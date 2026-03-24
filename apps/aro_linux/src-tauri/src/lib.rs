mod libstudy;

#[cfg(target_os = "linux")]
mod lib_check;

use std::backtrace::Backtrace;
use std::fs;
use std::io::Write;
use std::net::{TcpStream, ToSocketAddrs};
use std::path::{Path, PathBuf};
use std::sync::OnceLock;
use std::time::Duration;

use base64::Engine;
use serde::Serialize;
use time::{
  format_description,
  OffsetDateTime,
};

use tauri::Emitter;
use tauri::Manager;
use tauri_plugin_shell::ShellExt;

#[cfg(target_family = "unix")]
use std::os::unix::io::AsRawFd;

static INSTANCE_LOCK_FILE: OnceLock<std::fs::File> = OnceLock::new();

static LAST_PAGE_LOAD_ERROR_AT_MS: std::sync::atomic::AtomicI64 =
  std::sync::atomic::AtomicI64::new(0);

static INITIAL_NODE_INFO_RESOLVED: std::sync::atomic::AtomicBool =
  std::sync::atomic::AtomicBool::new(false);

static LAST_STATUS_OVERLAY_STATE: std::sync::atomic::AtomicU8 =
  std::sync::atomic::AtomicU8::new(1);

/// Whether the offline overlay is the currently active (visible) window.
static STATUS_OVERLAY_VISIBLE: std::sync::atomic::AtomicBool =
  std::sync::atomic::AtomicBool::new(false);

#[cfg(target_os = "macos")]
static LAST_MACOS_CONNECTIVITY_STATE: std::sync::atomic::AtomicU8 =
  std::sync::atomic::AtomicU8::new(0);

#[cfg(target_os = "linux")]
static LAST_LINUX_CONNECTIVITY_STATE: std::sync::atomic::AtomicU8 =
  std::sync::atomic::AtomicU8::new(0);

#[cfg(target_os = "linux")]
const LIBSTUDY_UPDATE_CHECK_INTERVAL: Duration = Duration::from_secs(10 * 60);

#[cfg(target_os = "linux")]
static LIBSTUDY_UPDATE_MONITOR_STARTED: OnceLock<()> = OnceLock::new();

fn now_ms_i64() -> i64 {
  (OffsetDateTime::now_utc().unix_timestamp_nanos() / 1_000_000) as i64
}

// -------------------------
// libstudy (Go) call routing
// -------------------------
//
// We embed a Go shared library (libstudy). On macOS and some GUI runtimes, it's
// common to run application code on threads with a very small native stack
// (~512KB). Calling into the Go runtime from such a thread can crash the whole
// process with:
//   fatal error: morestack on g0
//
// To avoid this, route all Go calls through a dedicated worker thread that we
// create with an explicitly large stack.

#[derive(Debug)]
enum LibstudyOp {
  Init { init_params_json: String },
  NodeSignUp,
  GetNodeStat,
  GetRewards,
  GetCurrentVersion,
  GetLastVersion,
}

struct LibstudyRequest {
  op: LibstudyOp,
  resp: std::sync::mpsc::Sender<Result<String, String>>,
}

struct LibstudyWorker {
  tx: std::sync::mpsc::Sender<LibstudyRequest>,
}

static LIBSTUDY_WORKER: OnceLock<LibstudyWorker> = OnceLock::new();

fn init_libstudy_worker() {
  if LIBSTUDY_WORKER.get().is_some() {
    return;
  }

  let (tx, rx) = std::sync::mpsc::channel::<LibstudyRequest>();

  // Go runtime is happiest when entered on a thread with a sufficiently large
  // native stack. 8MiB is a conservative choice.
  let builder = std::thread::Builder::new()
    .name("libstudy-go-worker".to_string())
    .stack_size(8 * 1024 * 1024);

  let _ = builder.spawn(move || {
    while let Ok(req) = rx.recv() {
      let result: Result<String, String> = match req.op {
        LibstudyOp::Init { init_params_json } => libstudy::with_lib(|lib, _path| lib.init(&init_params_json))
          .map_err(|e| e.to_string()),
        LibstudyOp::NodeSignUp => libstudy::with_lib(|lib, _path| lib.node_sign_up())
          .map_err(|e| e.to_string()),
        LibstudyOp::GetNodeStat => libstudy::with_lib(|lib, _path| lib.get_node_stat())
          .map_err(|e| e.to_string()),
        LibstudyOp::GetRewards => libstudy::with_lib(|lib, _path| lib.get_rewards())
          .map_err(|e| e.to_string()),
        LibstudyOp::GetCurrentVersion => libstudy::with_lib(|lib, _path| lib.get_current_version())
          .map_err(|e| e.to_string()),
        LibstudyOp::GetLastVersion => libstudy::with_lib(|lib, _path| lib.get_last_version())
          .map_err(|e| e.to_string()),
      };

      let _ = req.resp.send(result);
    }
  });

  let _ = LIBSTUDY_WORKER.set(LibstudyWorker { tx });
}

async fn call_libstudy(op: LibstudyOp) -> Result<String, String> {
  init_libstudy_worker();

  let worker = LIBSTUDY_WORKER
    .get()
    .ok_or_else(|| "libstudy worker not initialized".to_string())?;

  let (resp_tx, resp_rx) = std::sync::mpsc::channel::<Result<String, String>>();
  worker
    .tx
    .send(LibstudyRequest { op, resp: resp_tx })
    .map_err(|e| format!("failed to enqueue libstudy request: {e}"))?;

  // Waiting for a response is blocking; do it off the async runtime.
  tauri::async_runtime::spawn_blocking(move || {
    resp_rx
      .recv()
      .map_err(|e| format!("libstudy worker dropped response: {e}"))?
  })
  .await
  .map_err(|e| format!("libstudy wait task join error: {e}"))?
}

fn call_libstudy_sync(op: LibstudyOp) -> Result<String, String> {
  init_libstudy_worker();

  let worker = LIBSTUDY_WORKER
    .get()
    .ok_or_else(|| "libstudy worker not initialized".to_string())?;

  let (resp_tx, resp_rx) = std::sync::mpsc::channel::<Result<String, String>>();
  worker
    .tx
    .send(LibstudyRequest { op, resp: resp_tx })
    .map_err(|e| format!("failed to enqueue libstudy request: {e}"))?;

  resp_rx
    .recv()
    .map_err(|e| format!("libstudy worker dropped response: {e}"))?
}

#[cfg(target_os = "linux")]
fn libstudy_version_response_ok(value: &serde_json::Value) -> bool {
  value.get("code").and_then(|c| c.as_i64()) == Some(200)
}

#[cfg(target_os = "linux")]
async fn run_libstudy_update_check(
  app: tauri::AppHandle,
  app_data_dir: PathBuf,
  source: &'static str,
) {
  log::info!("libstudy update: checking for updates ({source})...");
  println!("libstudy update: checking for updates ({source})...");

  let (current_ver, latest_ver) = match (
    call_libstudy_sync(LibstudyOp::GetCurrentVersion),
    call_libstudy_sync(LibstudyOp::GetLastVersion),
  ) {
    (Ok(current_ver), Ok(latest_ver)) => (current_ver, latest_ver),
    (Err(e), _) => {
      log::warn!("libstudy update: failed to get current version ({source}): {e}");
      println!("libstudy update: failed to get current version ({source}): {e}");
      return;
    }
    (_, Err(e)) => {
      log::warn!("libstudy update: failed to get latest version ({source}): {e}");
      println!("libstudy update: failed to get latest version ({source}): {e}");
      return;
    }
  };

  let (current_map, latest_map) = match (
    serde_json::from_str::<serde_json::Value>(&current_ver),
    serde_json::from_str::<serde_json::Value>(&latest_ver),
  ) {
    (Ok(current_map), Ok(latest_map)) => (current_map, latest_map),
    _ => {
      log::warn!(
        "libstudy update: failed to parse version JSON ({source}). current={} latest={}",
        current_ver,
        latest_ver
      );
      println!(
        "libstudy update: failed to parse version JSON ({source}). current={} latest={}",
        current_ver,
        latest_ver
      );
      return;
    }
  };

  if !libstudy_version_response_ok(&current_map) || !libstudy_version_response_ok(&latest_map) {
    log::warn!(
      "libstudy update: version API returned non-success code ({source}). current={} latest={}",
      current_ver,
      latest_ver
    );
    println!(
      "libstudy update: version API returned non-success code ({source}). current={} latest={}",
      current_ver,
      latest_ver
    );
    return;
  }

  log::info!(
    "libstudy update: current version: {}, latest version: {} ({source})",
    current_ver,
    latest_ver
  );
  println!(
    "libstudy update: current version: {}, latest version: {} ({source})",
    current_ver,
    latest_ver
  );

  match lib_check::check_and_update(current_map, latest_map, app_data_dir).await {
    Ok(update_result) => {
      log::info!("libstudy update result ({source}): {:?}", update_result);
      println!("libstudy update result ({source}): {:?}", update_result);
      if update_result.updated {
        log::warn!(
          "libstudy was updated. Restarting app automatically to apply changes. {}",
          update_result.message
        );
        println!(
          "libstudy was updated. Restarting app automatically to apply changes. {}",
          update_result.message
        );
        app.restart();
      }
    }
    Err(e) => {
      log::warn!("libstudy update check failed ({source}): {e}");
      println!("libstudy update check failed ({source}): {e}");
    }
  }
}

#[cfg(target_os = "linux")]
fn start_libstudy_update_monitor(app: tauri::AppHandle, app_data_dir: PathBuf) {
  if LIBSTUDY_UPDATE_MONITOR_STARTED.set(()).is_err() {
    log::info!("libstudy update monitor already started; skipping duplicate start");
    println!("libstudy update monitor already started; skipping duplicate start");
    return;
  }

  if let Err(e) = std::thread::Builder::new()
    .name("libstudy-update-monitor".to_string())
    .spawn(move || loop {
      std::thread::sleep(LIBSTUDY_UPDATE_CHECK_INTERVAL);

      let app_for_check = app.clone();
      let app_data_for_check = app_data_dir.clone();
      tauri::async_runtime::spawn(async move {
        run_libstudy_update_check(app_for_check, app_data_for_check, "scheduled").await;
      });
    })
  {
    log::error!("failed to start libstudy update monitor: {e}");
    println!("failed to start libstudy update monitor: {e}");
  } else {
    log::info!(
      "libstudy update monitor started; interval={}s",
      LIBSTUDY_UPDATE_CHECK_INTERVAL.as_secs()
    );
    println!(
      "libstudy update monitor started; interval={}s",
      LIBSTUDY_UPDATE_CHECK_INTERVAL.as_secs()
    );
  }
}

fn infer_network_issue_state() -> NetState {
  match cached_connectivity_state() {
    Some(NetState::Offline) => NetState::Offline,
    Some(NetState::NoInternet) => NetState::NoInternet,
    _ => match classify_local_network_state(Duration::from_millis(350)) {
      NetState::Offline => NetState::Offline,
      _ => NetState::NoInternet,
    },
  }
}

fn emit_network_issue_and_show_overlay(
  app: &tauri::AppHandle,
  main_window: Option<tauri::WebviewWindow>,
  reason: &str,
) {
  let state = infer_network_issue_state();
  let overlay_state = if state == NetState::Offline {
    StatusOverlayState::Offline
  } else {
    StatusOverlayState::NoInternet
  };

  LAST_PAGE_LOAD_ERROR_AT_MS.store(now_ms_i64(), std::sync::atomic::Ordering::Relaxed);
  log::warn!("net: forcing overlay ({state:?}): {reason}");

  // Keep tray icon in sync with the overlay state.
  #[cfg(target_os = "macos")]
  {
    cache_macos_connectivity_state(state);
    sync_macos_connectivity_icon(app, state);
  }
  #[cfg(target_os = "linux")]
  {
    cache_linux_connectivity_state(state);
    sync_linux_connectivity_icon(app, state);
  }

  let payload = NetStatusPayload {
    state,
    checked_at_ms: now_ms_i64() as i128,
  };
  let _ = app.emit("aro-net-status", payload);

  show_status_overlay(app, main_window, overlay_state, true);
}

fn acquire_single_instance_lock() -> bool {
  #[cfg(target_family = "unix")]
  {
    let runtime_dir = std::env::var_os("XDG_RUNTIME_DIR")
      .map(std::path::PathBuf::from)
      .unwrap_or_else(|| std::path::PathBuf::from("/tmp"));

    let lock_path = runtime_dir.join("com.aro.ARONetwork.lock");

    let file = match std::fs::OpenOptions::new()
      .create(true)
      .read(true)
      .write(true)
      .open(&lock_path)
    {
      Ok(f) => f,
      Err(e) => {
        log::warn!("single-instance: failed to open lock file {:?}: {e}", lock_path);
        return true;
      }
    };

    let fd = file.as_raw_fd();
    let rc = unsafe { libc::flock(fd, libc::LOCK_EX | libc::LOCK_NB) };
    if rc != 0 {
      let err = std::io::Error::last_os_error();
      if let Some(code) = err.raw_os_error() {
        if code == libc::EWOULDBLOCK || code == libc::EAGAIN {
          log::info!("single-instance: another instance is running; exiting");
          return false;
        }
      }

      // If we can't determine lock state reliably, don't block startup.
      log::warn!("single-instance: flock failed: {err}");
      return true;
    }

    let _ = INSTANCE_LOCK_FILE.set(file);
    true
  }

  #[cfg(not(target_family = "unix"))]
  {
    true
  }
}

use url::Url;

const OFFLINE_HEADER_PNG: &[u8] = include_bytes!("../icons/header.png");
const OFFLINE_LOGO_PNG: &[u8] = include_bytes!("../icons/gr-logo-desktop.png");

static OFFLINE_OVERLAY_HTML: OnceLock<String> = OnceLock::new();
static CRASH_LOG_DIR: OnceLock<PathBuf> = OnceLock::new();

const PAGE_LOAD_ERROR_DETECTOR_JS: &str = r#"(function(){
  try {
    const w = window;
    const invoke = (cmd, args) => {
      const fn = (w.__TAURI__ && w.__TAURI__.core && w.__TAURI__.core.invoke)
        || (w.__TAURI_INTERNALS__ && w.__TAURI_INTERNALS__.invoke);
      if (typeof fn !== 'function') return Promise.reject(new Error('invoke not available'));
      return fn(cmd, args || {});
    };

    const text = String((document && document.body && document.body.innerText) || '');
    const title = String((document && document.title) || '');
    const href = String((location && location.href) || '');

    // WebKit / Linux error pages typically include these.
    const isDnsError = text.includes('Error resolving')
      || text.includes('Name or service not known')
      || text.includes('ERR_NAME_NOT_RESOLVED')
      || text.includes('DNS_PROBE_FINISHED_NXDOMAIN');

    if (!isDnsError) return;
    const snippet = (title + ' | ' + href + ' | ' + text).slice(0, 800);
    invoke('report_page_load_error', { error: snippet });
  } catch (_) {}
})();"#;

const DEFAULT_MAX_LOG_FILE_SIZE_BYTES: u128 = 10 * 1024 * 1024; // 10 MiB
const DEFAULT_MAX_CRASH_FILE_SIZE_BYTES: u64 = 2 * 1024 * 1024; // 2 MiB

fn parse_u128_env(name: &str) -> Option<u128> {
  std::env::var(name)
    .ok()
    .map(|s| s.trim().to_string())
    .filter(|s| !s.is_empty())
    .and_then(|s| s.parse::<u128>().ok())
}

fn resolve_max_log_file_size_bytes() -> u128 {
  // Prefer bytes; fall back to MB.
  if let Some(bytes) = parse_u128_env("ARO_LOG_MAX_FILE_SIZE_BYTES") {
    return bytes.max(1024 * 1024);
  }
  if let Some(mb) = parse_u128_env("ARO_LOG_MAX_FILE_SIZE_MB") {
    return (mb * 1024 * 1024).max(1024 * 1024);
  }
  DEFAULT_MAX_LOG_FILE_SIZE_BYTES
}

fn rotate_file_keep_all_if_oversize(path: &Path, max_size: u64) -> Result<(), String> {
  if !path.exists() {
    return Ok(());
  }
  let size = fs::metadata(path)
    .map_err(|e| format!("failed to stat {path:?}: {e}"))?
    .len();
  if size <= max_size {
    return Ok(());
  }

  let now = OffsetDateTime::now_local().unwrap_or_else(|_| OffsetDateTime::now_utc());
  let stamp = now
    .format(&format_description::parse("[year]-[month]-[day]_[hour]-[minute]-[second]")
      .map_err(|e| format!("failed to build time format: {e}"))?)
    .map_err(|e| format!("failed to format time: {e}"))?;

  let file_stem = path
    .file_stem()
    .and_then(|s| s.to_str())
    .unwrap_or("log");
  let rotated_name = format!("{file_stem}_{stamp}.log");

  let dir = path.parent().unwrap_or_else(|| Path::new("."));
  let rotated = dir.join(rotated_name);

  fs::rename(path, &rotated)
    .map_err(|e| format!("failed to rotate {path:?} -> {rotated:?}: {e}"))?;
  Ok(())
}

fn init_crash_log_dir(app: &tauri::AppHandle) {
  if CRASH_LOG_DIR.get().is_some() {
    return;
  }
  let dir = app
    .path()
    .app_log_dir()
    .unwrap_or_else(|_| std::env::temp_dir().join("aro_desktop_logs"));
  let _ = fs::create_dir_all(&dir);
  let _ = CRASH_LOG_DIR.set(dir);
}

fn append_crash_log(message: &str) {
  let dir = if let Some(dir) = CRASH_LOG_DIR.get() {
    dir.clone()
  } else {
    let fallback_dir = std::env::temp_dir().join("aro_desktop_logs");
    let _ = fs::create_dir_all(&fallback_dir);
    let _ = CRASH_LOG_DIR.set(fallback_dir.clone());
    fallback_dir
  };

  let path = dir.join("crash.log");
  let _ = rotate_file_keep_all_if_oversize(&path, DEFAULT_MAX_CRASH_FILE_SIZE_BYTES);

  if let Ok(mut f) = fs::OpenOptions::new().create(true).append(true).open(&path) {
    let _ = writeln!(f, "{message}");
  } else {
    eprintln!("[crash-log] {message}");
  }
}

fn find_bundled_libstudy(app: &tauri::AppHandle) -> Result<std::path::PathBuf, String> {
  let lib_name = libstudy::Libstudy::platform_lib_filename();

  let resource_dir = app
    .path()
    .resource_dir()
    .map_err(|e| format!("failed to resolve resource_dir: {e}"))?;

  let mut candidates: Vec<std::path::PathBuf> = vec![
    resource_dir.join(lib_name),
    resource_dir.join("resources").join(lib_name),
  ];

  if let Ok(exe) = std::env::current_exe() {
    if let Some(exe_dir) = exe.parent() {
      candidates.push(exe_dir.join(lib_name));
      candidates.push(exe_dir.join("resources").join(lib_name));
      candidates.push(exe_dir.join("..").join("resources").join(lib_name));
    }
  }

  // Fallback: relative to current working directory.
  candidates.push(std::path::PathBuf::from("resources").join(lib_name));

  for c in candidates {
    if c.exists() {
      return Ok(c);
    }
  }

  Err(format!(
    "libstudy was not found in bundled resources. resource_dir={resource_dir:?} expected={lib_name}"
  ))
}

fn ensure_libstudy_in_app_data(app: &tauri::AppHandle) -> Result<std::path::PathBuf, String> {
  let app_data_dir = app
    .path()
    .app_data_dir()
    .map_err(|e| format!("failed to resolve app_data_dir: {e}"))?;

  std::fs::create_dir_all(&app_data_dir)
    .map_err(|e| format!("failed to create app_data_dir {app_data_dir:?}: {e}"))?;

  let lib_name = libstudy::Libstudy::platform_lib_filename();
  let dst = app_data_dir.join(lib_name);
  if dst.exists() {
    log::info!("libstudy: app_data library already exists at {dst:?}");
    return Ok(dst);
  }

  let src = find_bundled_libstudy(app)?;
  {
    // Helpful diagnostics when we have a library but can't stage it.
    log::info!(
      "libstudy: preparing staged copy src={src:?} dst={dst:?}"
    );
  }

  {
    if src.exists() {
      log::info!("libstudy: copying bundled library from {src:?} to {dst:?}");

      std::fs::copy(&src, &dst).map_err(|e| {
        format!("libstudy: failed to copy from {src:?} to {dst:?}: {e}")
      })?;

      #[cfg(target_os = "linux")]
      {
        use std::os::unix::fs::PermissionsExt;
        if let Ok(meta) = std::fs::metadata(&src) {
          let _ = std::fs::set_permissions(
            &dst,
            std::fs::Permissions::from_mode(meta.permissions().mode()),
          );
        }
      }

      return Ok(dst);
    }
  }

  Err(format!("libstudy source not found at {src:?}"))
}

fn set_default_libstudy_override(app: &tauri::AppHandle) {
  match ensure_libstudy_in_app_data(app) {
    Ok(p) => {
      libstudy::set_override_path(Some(p.clone()));
      log::info!("libstudy: default override path set to {p:?} (updates will replace this file)");
    }
    Err(e) => {
      // Do not hard-fail app startup; fall back to loading from bundled resources directly.
      log::warn!("libstudy: unable to prepare app_data library: {e}");

      match find_bundled_libstudy(app) {
        Ok(p) => {
          libstudy::set_override_path(Some(p.clone()));
          log::info!("libstudy: falling back to bundled library path {p:?}");
        }
        Err(e2) => {
          log::warn!("libstudy: bundled library was not found either: {e2}");
        }
      }
    }
  }
}

#[cfg(target_os = "macos")]
const MACOS_TRAY_ICON: tauri::image::Image<'static> = tauri::include_image!("./icons/32x32.png");

#[cfg(target_os = "macos")]
const MACOS_TRAY_ICON_OFFLINE: tauri::image::Image<'static> =
  tauri::include_image!("./icons/app_icon_offline.png");

#[cfg(target_os = "linux")]
const LINUX_TRAY_ICON: tauri::image::Image<'static> = tauri::include_image!("./icons/32x32.png");

#[cfg(target_os = "linux")]
const LINUX_TRAY_ICON_OFFLINE: tauri::image::Image<'static> =
  tauri::include_image!("./icons/app_icon_offline.png");

const FLUTTER_COMPAT_BRIDGE_JS: &str = r#"
(function () {
  try {
    // If we're really inside Flutter (JS channel), don't override.
    if (window.Flutter && typeof window.Flutter.postMessage === 'function') return;

    const invoke = (cmd, args) => {
      const w = window;
      const fn = (w.__TAURI__ && w.__TAURI__.core && w.__TAURI__.core.invoke)
        || (w.__TAURI_INTERNALS__ && w.__TAURI_INTERNALS__.invoke);
      if (typeof fn === 'function') {
        return fn(cmd, args);
      }
      throw new Error('Tauri invoke is not available (no __TAURI__.core.invoke or __TAURI_INTERNALS__.invoke)');
    };

    const safeJsonParse = (s) => {
      if (typeof s !== 'string') return s;
      try { return JSON.parse(s); } catch { return s; }
    };

    const sendToWeb = (msg) => {
      try {
        // Always log to Rust so we can debug without DevTools.
        invoke('bridge_log', { message: '[bridge] sendToWeb ' + JSON.stringify(msg) });
      } catch {}

      if (typeof window.onFlutterMessage === 'function') {
        window.onFlutterMessage(msg);
      } else {
        try { invoke('bridge_log', { message: '[bridge] window.onFlutterMessage is NOT set' }); } catch {}
      }
    };

    const sendError = (e) => {
      const message = (e && e.message) ? e.message : String(e);
      try { invoke('bridge_log', { message: '[bridge] error: ' + message }); } catch {}
      sendToWeb({ type: 'error', message });
    };

    // Tauri WebView: window.open() for external links is often blocked or opens inside the webview.
    // Intercept common patterns (window.open(url, '_blank', ...)) and route to the system browser.
    if (!window.__ARO_EXTERNAL_OPEN_PATCHED__ && typeof window.open === 'function') {
      window.__ARO_EXTERNAL_OPEN_PATCHED__ = true;
      const _open = window.open.bind(window);
      window.open = function (url, target, features) {
        try {
          const u = String(url || '');
          if (target === '_blank' && (u.startsWith('http://') || u.startsWith('https://'))) {
            try { invoke('bridge_log', { message: '[bridge] window.open intercepted -> open_external ' + u }); } catch {}
            invoke('open_external', { url: u });
            return null;
          }
        } catch (e) {}
        return _open(url, target, features);
      };
    }

    window.Flutter = window.Flutter || {};

    // Keep Flutter protocol: Flutter.postMessage(stringOrJsonString)
    window.Flutter.postMessage = async (message) => {
      try {
        // Flutter side supports JSON messages too (e.g. openExternal)
        let msgObj = null;
        if (typeof message === 'string') {
          try {
            const decoded = JSON.parse(message);
            if (decoded && typeof decoded === 'object') msgObj = decoded;
          } catch {}
        } else if (message && typeof message === 'object') {
          msgObj = message;
        }

        // Prefer structured messages when provided.
        const messageType = (msgObj && typeof msgObj.type === 'string') ? msgObj.type : message;

        if (msgObj && msgObj.type === 'openExternal' && msgObj.url) {
          await invoke('open_external', { url: String(msgObj.url) });
          return;
        }

        // Align with Flutter app behavior: initNode runs on app startup.
        // Here we auto-init on webReady to keep existing web code unchanged.
        if (messageType === 'webReady') {
          try { await invoke('bridge_log', { message: '[bridge] webReady received; invoking init_libstudy_auto' }); } catch {}
          try {
            const info = await invoke('libstudy_info');
            if (info && info.loaded === true) {
              try { await invoke('bridge_log', { message: '[bridge] libstudy already loaded; skipping init_libstudy_auto' }); } catch {}
              return;
            }
          } catch {}

          await invoke('init_libstudy_auto', {});
          return;
        }

        if (messageType === 'nodeInfo') {
          const resp = await invoke('get_node_stat');
          const map = safeJsonParse(resp);
          // Always send the payload; the web app can decide what to do with bind status.
          sendToWeb({ type: 'nodeInfo', payload: map });
          return;
        }

        if (messageType === 'nodeSignUp') {
          try { await invoke('bridge_log', { message: '[bridge] nodeSignUp received; invoking node_sign_up' }); } catch {}
          const resp = await invoke('node_sign_up');
          sendToWeb({ type: 'nodeSignUp', payload: safeJsonParse(resp) });
          const stat = await invoke('get_node_stat');
          const statMap = safeJsonParse(stat);
          sendToWeb({ type: 'nodeInfo', payload: statMap });
          return;
        }

        if (messageType === 'nodeRewards') {
          const resp = await invoke('get_rewards');
          const map = safeJsonParse(resp);
          if (map && map.code === 200) {
            sendToWeb({ type: 'nodeRewards', payload: map });
          }
          return;
        }

        if (messageType === 'getVersion') {
          const resp = await invoke('get_current_version');
          const map = safeJsonParse(resp);
          if (map && map.code === 200) {
            sendToWeb({ type: 'getVersion', payload: map });
          }
          return;
        }

       
      } catch (e) {
        sendError(e);
      }
    };

    // If the page called Flutter.postMessage very early (before this bridge was injected),
    // replay those queued messages now.
    try {
      const queued = window.__ARO_FLUTTER_QUEUE;
      if (Array.isArray(queued) && queued.length) {
        window.__ARO_FLUTTER_QUEUE = [];
        for (const m of queued) {
          try { window.Flutter.postMessage(m); } catch {}
        }
      }
    } catch {}
  } catch (e) {
    // As a last resort, do nothing.
    console.warn('Failed to install Flutter compatibility bridge', e);
  }
})();
"#;

const GLOBAL_APP_CRASH_BRIDGE_JS: &str = r#"
(function () {
  try {
    if (window.__ARO_CRASH_LOGGER_INSTALLED__) return;
    window.__ARO_CRASH_LOGGER_INSTALLED__ = true;

    const invoke = (cmd, args) => {
      const w = window;
      const fn = (w.__TAURI__ && w.__TAURI__.core && w.__TAURI__.core.invoke)
        || (w.__TAURI_INTERNALS__ && w.__TAURI_INTERNALS__.invoke);
      if (typeof fn === 'function') {
        return fn(cmd, args);
      }
      return Promise.reject(new Error('Tauri invoke is not available'));
    };

    const sendCrash = (payload) => {
      try {
        invoke('bridge_crash_log', payload);
      } catch {}
    };

    window.addEventListener('error', (event) => {
      const maybeError = event && event.error;
      const message =
        (maybeError && maybeError.message)
        || event.message
        || 'unknown window error';
      const stack = (maybeError && maybeError.stack)
        ? String(maybeError.stack)
        : null;
      sendCrash({
        kind: 'window.error',
        message: String(message),
        stack,
        url: event.filename ? String(event.filename) : null,
        line: Number.isFinite(event.lineno) ? Number(event.lineno) : null,
        column: Number.isFinite(event.colno) ? Number(event.colno) : null,
      });
    });

    window.addEventListener('unhandledrejection', (event) => {
      const reason = event && event.reason;
      let message = 'unhandled rejection';
      let stack = null;

      if (reason && typeof reason === 'object') {
        if (typeof reason.message === 'string' && reason.message.length > 0) {
          message = reason.message;
        } else {
          try { message = JSON.stringify(reason); } catch { message = String(reason); }
        }
        if (typeof reason.stack === 'string' && reason.stack.length > 0) {
          stack = reason.stack;
        }
      } else if (typeof reason === 'string') {
        message = reason;
      } else if (typeof reason !== 'undefined') {
        message = String(reason);
      }

      sendCrash({
        kind: 'unhandledrejection',
        message: String(message),
        stack,
        url: null,
        line: null,
        column: null,
      });
    });
  } catch {}
})();
"#;

fn offline_overlay_html() -> &'static str {
  OFFLINE_OVERLAY_HTML.get_or_init(|| {
    let header_b64 = base64::engine::general_purpose::STANDARD.encode(OFFLINE_HEADER_PNG);
    let logo_b64 = base64::engine::general_purpose::STANDARD.encode(OFFLINE_LOGO_PNG);

    let mut html = r#"<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>ARO Desktop</title>
  <style>
    html, body { margin:0; padding:0; width:100%; height:100%; background:#000; color:#fff; font-family: system-ui, -apple-system, Segoe UI, Roboto, sans-serif; }
    #root { position:fixed; inset:0; }
    .top { position:absolute; top:0; left:0; right:0; height:120px; overflow:hidden; }
    .header { width:100%; height:120px; object-fit:cover; display:block; }
    .logo-tl { position:absolute; top:18px; left:18px; width:142px; height:30px; object-fit:contain; pointer-events:none; }
    .center { position:absolute; inset:0; display:flex; align-items:center; justify-content:center; padding:24px; text-align:center; }
    .spinner { width:30px; height:30px; margin:0 auto 20px auto; border-radius:999px; border:3px solid rgba(255,255,255,0.2); border-top-color:#fff; animation:spin 0.9s linear infinite; }
    .logo { width:142px; height:30px; object-fit:contain; display:block; margin:0 auto 24px auto; pointer-events:none; }
    .desc { font-family:'Poppins', system-ui, -apple-system, Segoe UI, Roboto, sans-serif; font-size:14px; font-weight:400; opacity:0.95; white-space:pre-line;}
    .connecting { position:absolute; left:0; right:0; bottom:118px; text-align:center; font-size:15px; opacity:0.9; }
    .bottom { position:absolute; left:0; right:0; bottom:0; height:78px; background:#02B421; border-top-left-radius:30px; border-top-right-radius:30px; display:none; align-items:center; justify-content:center; gap:8px; padding:0 20px; box-shadow:0 2px 8px rgba(0,0,0,0.2); text-align:center; font-size:14px; font-weight:400 }
    .bottom-icon { width:14px; height:14px; flex:0 0 14px; }
    .bottom-text { line-height:1.35;font-family:'Poppins', system-ui, -apple-system, Segoe UI, Roboto, sans-serif; }
    .msgTitle { display:flex; justify-content:flex-start}
    @keyframes spin { to { transform: rotate(360deg); } }
  </style>
</head>
<body>
  <div id="root">
    <div class="top">
      <img class="header" alt="" src="data:image/png;base64,__HEADER_B64__" />
    </div>
    <div class="center">
      <div>
      
        <img class="logo" alt="ARO" src="data:image/png;base64,__LOGO_B64__" />
        <div class="desc">A lightweight desktop app.
One-click start and forget it.</div>
      </div>
    </div>
    <div class="connecting" id="connecting-text">Connecting...</div>
    <div class="bottom" id="msg" data-state="loading">
    <div class="msgTitle">
      <svg class="bottom-icon" id="msg-icon" width="14" height="14" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
        <path fill-rule="evenodd" clip-rule="evenodd" d="M6.99968 1.75004C4.10018 1.75004 1.74967 4.10055 1.74967 7.00004C1.74967 9.89954 4.10018 12.25 6.99968 12.25C9.89917 12.25 12.2497 9.89954 12.2497 7.00004C12.2497 4.10055 9.89917 1.75004 6.99968 1.75004ZM0.583008 7.00004C0.583008 3.45621 3.45585 0.583374 6.99968 0.583374C10.5435 0.583374 13.4163 3.45621 13.4163 7.00004C13.4163 10.5439 10.5435 13.4167 6.99968 13.4167C3.45585 13.4167 0.583008 10.5439 0.583008 7.00004Z" fill="white"/>
        <path fill-rule="evenodd" clip-rule="evenodd" d="M7.00033 4.08337C7.32249 4.08337 7.58366 4.34454 7.58366 4.66671V7.00004C7.58366 7.32221 7.32249 7.58337 7.00033 7.58337C6.67816 7.58337 6.41699 7.32221 6.41699 7.00004V4.66671C6.41699 4.34454 6.67816 4.08337 7.00033 4.08337Z" fill="white"/>
        <path fill-rule="evenodd" clip-rule="evenodd" d="M6.41699 9.33333C6.41699 9.01117 6.67816 8.75 7.00033 8.75H7.00616C7.32833 8.75 7.58949 9.01117 7.58949 9.33333C7.58949 9.6555 7.32833 9.91667 7.00616 9.91667H7.00033C6.67816 9.91667 6.41699 9.6555 6.41699 9.33333Z" fill="white"/>
      </svg>
      <span class="bottom-text" id="msg-text">There seems to be a network issue, please check your internet connectivity.</span>
    </div>
    </div>

  </div>

  <script>
    (function() {
      const invoke = (cmd, args) => {
        try {
          const t = window.__TAURI__;
          const fn = (t && t.core && t.core.invoke)
            || (window.__TAURI_INTERNALS__ && window.__TAURI_INTERNALS__.invoke);
          if (typeof fn !== 'function') return Promise.reject(new Error('invoke not available'));
          return fn(cmd, args || {});
        } catch (error) {
          return Promise.reject(error);
        }
      };

      const setMsg = (state) => {
        const normalized = state || 'loading';
        const msg = document.getElementById('msg');
        const title = document.getElementById('connecting-text');
        const isDisconnected = normalized === 'offline' || normalized === 'no_internet';
        if (msg) {
          msg.dataset.state = normalized;
          msg.style.display = isDisconnected ? 'flex' : 'none';
        }
        if (title) {
          title.textContent = 'Connecting...';
        }
      };

      // Expose globally so Rust can push state via eval directly.
      window.__setOverlayState = setMsg;

      const pendingState = typeof window.__pendingOverlayState === 'string'
        ? window.__pendingOverlayState
        : '';

      setMsg(pendingState || 'loading');

      // If Rust pushed state before this JS was ready, pick it up now.
      const syncCurrentState = async () => {
        try {
          const payload = await invoke('get_status_overlay_state');
          const state = payload && payload.state ? String(payload.state) : 'loading';
          setMsg(state);
        } catch (_) {}
      };

      const listen = (eventName) => {
        try {
          const t = window.__TAURI__;
          const fn = t && t.event && t.event.listen;
          if (typeof fn !== 'function') return false;
          fn(eventName, (event) => {
            const p = event && event.payload ? event.payload : null;
            const s = p && p.state ? String(p.state) : '';
            setMsg(s);
          });
          return true;
        } catch (_) { return false; }
      };
      syncCurrentState();
      const attach = () => {
        const overlayOk = listen('aro-status-overlay');
        const netOk = listen('aro-net-status');
        return overlayOk || netOk;
      };
      attach() || setTimeout(() => {
        attach();
        syncCurrentState();
      }, 250);
    })();
  </script>
</body>
</html>"#.to_string();

    html = html.replace("__HEADER_B64__", &header_b64);
    html = html.replace("__LOGO_B64__", &logo_b64);
    html
  })
}

fn write_offline_overlay_html(window: &tauri::WebviewWindow, source: &str) -> Result<(), String> {
  let html_js = serde_json::to_string(offline_overlay_html())
    .map_err(|e| format!("failed to encode offline overlay html ({source}): {e}"))?;

  let js = format!(
    "document.open();document.write({});document.close();",
    html_js
  );

  window
    .eval(&js)
    .map_err(|e| format!("failed to write offline overlay html ({source}): {e}"))
}

fn ensure_offline_overlay_window(app: &tauri::AppHandle) -> Result<(), String> {
  if app.get_webview_window("offline").is_some() {
    return Ok(());
  }

  let about_blank = Url::parse("about:blank").map_err(|e| format!("invalid about:blank url: {e}"))?;
  let window = tauri::WebviewWindowBuilder::new(app, "offline", tauri::WebviewUrl::External(about_blank))
    .title("ARO Desktop")
    .inner_size(360.0, 640.0)
    .resizable(false)
    .decorations(false)
    .always_on_top(true)
    .skip_taskbar(true)
    .visible(false)
    .build()
    .map_err(|e| format!("failed to create offline overlay window: {e}"))?;

  let _ = write_offline_overlay_html(&window, "window creation");

  Ok(())
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, Serialize)]
#[serde(rename_all = "snake_case")]
enum NetState {
  Online,
  Offline,
  NoInternet,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, Serialize)]
#[serde(rename_all = "snake_case")]
enum StatusOverlayState {
  Loading,
  Offline,
  NoInternet,
}

#[derive(Debug, Clone, Serialize)]
struct StatusOverlayPayload {
  state: StatusOverlayState,
}

fn cache_status_overlay_state(state: StatusOverlayState) {
  let value = match state {
    StatusOverlayState::Loading => 1,
    StatusOverlayState::Offline => 2,
    StatusOverlayState::NoInternet => 3,
  };

  LAST_STATUS_OVERLAY_STATE.store(value, std::sync::atomic::Ordering::Relaxed);
}

fn current_status_overlay_state() -> StatusOverlayState {
  match LAST_STATUS_OVERLAY_STATE.load(std::sync::atomic::Ordering::Relaxed) {
    2 => StatusOverlayState::Offline,
    3 => StatusOverlayState::NoInternet,
    _ => StatusOverlayState::Loading,
  }
}

fn initial_node_info_pending() -> bool {
  !INITIAL_NODE_INFO_RESOLVED.load(std::sync::atomic::Ordering::Relaxed)
}

fn mark_initial_node_info_resolved() -> bool {
  INITIAL_NODE_INFO_RESOLVED
    .compare_exchange(
      false,
      true,
      std::sync::atomic::Ordering::Relaxed,
      std::sync::atomic::Ordering::Relaxed,
    )
    .is_ok()
}

fn normalize_status_overlay_state(requested: StatusOverlayState) -> StatusOverlayState {
  if requested != StatusOverlayState::Loading {
    return requested;
  }

  match cached_connectivity_state() {
    Some(NetState::Offline) => StatusOverlayState::Offline,
    Some(NetState::NoInternet) => StatusOverlayState::NoInternet,
    _ => StatusOverlayState::Loading,
  }
}

fn show_status_overlay(
  app: &tauri::AppHandle,
  main_window: Option<tauri::WebviewWindow>,
  state: StatusOverlayState,
  hide_main: bool,
) {
  let state = normalize_status_overlay_state(state);
  let main = main_window.or_else(|| app.get_webview_window("main"));

  if app.get_webview_window("offline").is_none() {
    let _ = ensure_offline_overlay_window(app);
  }

  let Some(off) = app.get_webview_window("offline") else {
    return;
  };

  cache_status_overlay_state(state);
  let _ = app.emit("aro-status-overlay", StatusOverlayPayload { state });

  // Directly push state into the overlay window via eval so it works even if
  // the event listener hasn't attached yet (race with document.write injection).
  let state_str = match state {
    StatusOverlayState::Loading => "loading",
    StatusOverlayState::Offline => "offline",
    StatusOverlayState::NoInternet => "no_internet",
  };
  let js_push = format!(
    "try {{ window.__pendingOverlayState = '{}'; if (typeof window.__setOverlayState === 'function') window.__setOverlayState('{}'); }} catch(_) {{}}",
    state_str, state_str
  );
  let _ = off.eval(&js_push);

  if let Some(m) = main.clone() {
    if hide_main {
      let _ = m.hide();
    } else {
      let _ = m.show();
    }
  }

  if let Some(m) = main {
    let _ = m.set_always_on_top(false);
    let _ = off.set_always_on_top(true);
    if let Ok(pos) = m.outer_position() {
      let _ = off.set_position(pos);
    }
    if let Ok(size) = m.outer_size() {
      let _ = off.set_size(size);
    }
  } else {
    let _ = off.set_always_on_top(true);
  }

  let _ = off.show();
  let _ = off.set_focus();
  STATUS_OVERLAY_VISIBLE.store(true, std::sync::atomic::Ordering::Relaxed);
}

fn should_hide_main_for_loading_overlay() -> bool {
  cfg!(target_os = "linux")
}

fn hide_status_overlay(app: &tauri::AppHandle) {
  STATUS_OVERLAY_VISIBLE.store(false, std::sync::atomic::Ordering::Relaxed);
  if let Some(off) = app.get_webview_window("offline") {
    let _ = off.hide();
  }
}

#[cfg(target_os = "macos")]
fn cached_connectivity_state() -> Option<NetState> {
  cached_macos_connectivity_state()
}

#[cfg(target_os = "linux")]
fn cached_connectivity_state() -> Option<NetState> {
  cached_linux_connectivity_state()
}

#[cfg(not(any(target_os = "macos", target_os = "linux")))]
fn cached_connectivity_state() -> Option<NetState> {
  None
}

fn parse_node_stat_response(resp: &str) -> Option<serde_json::Value> {
  serde_json::from_str::<serde_json::Value>(resp).ok()
}

fn node_stat_response_looks_like_network_failure(value: &serde_json::Value) -> bool {
  let code_500 = value.get("code").and_then(|c| c.as_i64()) == Some(500);
  if !code_500 {
    return false;
  }

  let msg = value
    .get("message")
    .and_then(|m| m.as_str())
    .unwrap_or("");
  let msg_lc = msg.to_ascii_lowercase();

  msg_lc.contains("request failed")
    || msg_lc.contains("unexpected eof")
    || msg_lc.contains("connection")
    || msg_lc.contains("timed out")
    || msg_lc.contains("timeout")
    || msg_lc.contains("dns")
    || msg_lc.contains("resolve")
    || msg_lc.contains("name or service not known")
}

fn node_stat_response_is_auth_required(value: &serde_json::Value) -> bool {
  let message = value
    .get("message")
    .and_then(|m| m.as_str())
    .unwrap_or("")
    .to_ascii_lowercase();

  message.contains("code=401") || message.contains("401") && message.contains("need auth")
}

fn initial_node_info_response_is_ready(value: &serde_json::Value) -> bool {
  matches!(
    value.get("data").and_then(|data| data.get("bind")),
    Some(serde_json::Value::Bool(_))
  ) || node_stat_response_is_auth_required(value)
}

fn maybe_complete_initial_node_info(app: &tauri::AppHandle, resp: &str) {
  if !initial_node_info_pending() {
    return;
  }

  let Some(value) = parse_node_stat_response(resp) else {
    return;
  };

  if !initial_node_info_response_is_ready(&value) {
    return;
  }

  if !mark_initial_node_info_resolved() {
    return;
  }

  let resolved_for_auth = node_stat_response_is_auth_required(&value);
  if resolved_for_auth {
    log::info!("initial node info resolved by auth-required response; hiding startup loading overlay");
  } else {
    log::info!("initial node info resolved; hiding startup loading overlay");
  }

  match cached_connectivity_state() {
    Some(NetState::Offline) => {
      show_status_overlay(
        app,
        app.get_webview_window("main"),
        StatusOverlayState::Offline,
        true,
      );
    }
    Some(NetState::NoInternet) => {
      show_status_overlay(
        app,
        app.get_webview_window("main"),
        StatusOverlayState::NoInternet,
        true,
      );
    }
    _ => {
      hide_status_overlay(app);
      if let Some(main) = app.get_webview_window("main") {
        let _ = main.set_always_on_top(true);
        let _ = main.show();
        let _ = main.set_focus();
      }
    }
  }
}

#[cfg(target_os = "macos")]
fn cache_macos_connectivity_state(state: NetState) {
  let value = match state {
    NetState::Online => 1,
    NetState::Offline => 2,
    NetState::NoInternet => 3,
  };

  LAST_MACOS_CONNECTIVITY_STATE.store(value, std::sync::atomic::Ordering::Relaxed);
}

#[cfg(target_os = "macos")]
fn cached_macos_connectivity_state() -> Option<NetState> {
  match LAST_MACOS_CONNECTIVITY_STATE.load(std::sync::atomic::Ordering::Relaxed) {
    1 => Some(NetState::Online),
    2 => Some(NetState::Offline),
    3 => Some(NetState::NoInternet),
    _ => None,
  }
}

#[cfg(target_os = "macos")]
fn sync_macos_connectivity_icon(app: &tauri::AppHandle, state: NetState) {
  let icon = if state == NetState::Online {
    Some(MACOS_TRAY_ICON)
  } else {
    Some(MACOS_TRAY_ICON_OFFLINE)
  };

  let Some(tray) = app.tray_by_id("main") else {
    return;
  };

  if let Err(e) = tray.set_icon(icon) {
    log::warn!("macos tray icon sync failed state={state:?} err={e}");
  }
}

#[cfg(target_os = "linux")]
fn cache_linux_connectivity_state(state: NetState) {
  let value = match state {
    NetState::Online => 1,
    NetState::Offline => 2,
    NetState::NoInternet => 3,
  };

  LAST_LINUX_CONNECTIVITY_STATE.store(value, std::sync::atomic::Ordering::Relaxed);
}

#[cfg(target_os = "linux")]
fn cached_linux_connectivity_state() -> Option<NetState> {
  match LAST_LINUX_CONNECTIVITY_STATE.load(std::sync::atomic::Ordering::Relaxed) {
    1 => Some(NetState::Online),
    2 => Some(NetState::Offline),
    3 => Some(NetState::NoInternet),
    _ => None,
  }
}

#[cfg(target_os = "linux")]
fn sync_linux_connectivity_icon(app: &tauri::AppHandle, state: NetState) {
  let icon = if state == NetState::Online {
    Some(LINUX_TRAY_ICON)
  } else {
    Some(LINUX_TRAY_ICON_OFFLINE)
  };

  let Some(tray) = app.tray_by_id("main") else {
    return;
  };

  if let Err(e) = tray.set_icon(icon) {
    log::warn!("linux tray icon sync failed state={state:?} err={e}");
  }
}

#[derive(Debug, Clone, Serialize)]
struct NetStatusPayload {
  state: NetState,
  checked_at_ms: i128,
}

#[cfg(target_os = "linux")]
fn linux_default_route_interface() -> Option<String> {
  let routes = fs::read_to_string("/proc/net/route").ok()?;

  routes.lines().skip(1).find_map(|line| {
    let fields: Vec<&str> = line.split_whitespace().collect();
    if fields.len() > 1 && fields[1] == "00000000" {
      Some(fields[0].to_string())
    } else {
      None
    }
  })
}

#[cfg(target_os = "linux")]
fn linux_interface_has_carrier(interface: &str) -> Option<bool> {
  let carrier_path = format!("/sys/class/net/{interface}/carrier");
  if let Ok(value) = fs::read_to_string(&carrier_path) {
    return Some(value.trim() == "1");
  }

  let operstate_path = format!("/sys/class/net/{interface}/operstate");
  let state = fs::read_to_string(&operstate_path).ok()?;

  match state.trim() {
    "up" | "unknown" => Some(true),
    "down" | "dormant" | "lowerlayerdown" | "notpresent" => Some(false),
    _ => None,
  }
}

fn classify_local_network_state(timeout: Duration) -> NetState {
  #[cfg(target_os = "linux")]
  {
    match linux_default_route_interface() {
      Some(interface) => {
        if matches!(linux_interface_has_carrier(&interface), Some(false)) {
          log::debug!("net: linux interface has no carrier iface={interface}");
          return NetState::Offline;
        }
      }
      None => {
        log::debug!("net: linux default route missing");
        return NetState::Offline;
      }
    }
  }

  let probe_addrs = [
    std::net::SocketAddr::from(([1, 1, 1, 1], 443)),
    std::net::SocketAddr::from(([8, 8, 8, 8], 443)),
  ];

  let mut saw_unreachable = false;

  for addr in probe_addrs {
    match TcpStream::connect_timeout(&addr, timeout) {
      Ok(_) => return NetState::NoInternet,
      Err(e) => {
        use std::io::ErrorKind;
        match e.kind() {
          ErrorKind::NetworkUnreachable | ErrorKind::NotConnected | ErrorKind::AddrNotAvailable => {
            saw_unreachable = true;
          }
          _ => {}
        }
        log::debug!("net: fallback probe failed addr={addr} err={e}");
      }
    }
  }

  if saw_unreachable {
    NetState::Offline
  } else {
    NetState::NoInternet
  }
}

fn check_remote_reachability(remote_ui_url: &str, timeout: Duration) -> NetState {
  let parsed = match Url::parse(remote_ui_url) {
    Ok(u) => u,
    Err(_) => return NetState::NoInternet,
  };

  let host = match parsed.host_str() {
    Some(h) => h.to_string(),
    None => return NetState::NoInternet,
  };

  let port = parsed.port_or_known_default().unwrap_or(443);
  let addrs: Vec<std::net::SocketAddr> = match (host.as_str(), port).to_socket_addrs() {
    Ok(it) => it.take(3).collect(),
    Err(e) => {
      // DNS failure or resolver not available. Probe a stable public IP to
      // distinguish a real local disconnect from a remote hostname issue.
      log::debug!("net: resolve failed host={host} port={port} err={e}");
      return classify_local_network_state(timeout);
    }
  };

  // Try a few resolved addresses; treat fast 'unreachable' as offline.
  let mut saw_unreachable = false;
  let mut saw_timeout = false;

  for addr in addrs {
    match TcpStream::connect_timeout(&addr, timeout) {
      Ok(_) => return NetState::Online,
      Err(e) => {
        use std::io::ErrorKind;
        match e.kind() {
          ErrorKind::NetworkUnreachable | ErrorKind::NotConnected | ErrorKind::AddrNotAvailable => {
            saw_unreachable = true;
          }
          ErrorKind::TimedOut => {
            saw_timeout = true;
          }
          _ => {}
        }
        log::debug!("net: connect failed addr={addr} err={e}");
      }
    }
  }

  if saw_unreachable {
    return NetState::Offline;
  }
  if saw_timeout {
    return NetState::NoInternet;
  }
  NetState::NoInternet
}

fn start_network_monitor(app: tauri::AppHandle) {
  // Default to the current remote UI.
  let remote_ui_url = std::env::var("ARO_REMOTE_UI_URL")
    .ok()
    .filter(|s| !s.trim().is_empty())
    .unwrap_or_else(|| "https://0ee63895-262b.ipproxy.aro.network/desktop/".to_string());

  // Faster reaction for “断网/网络差” UI switching.
  let poll_interval = Duration::from_millis(1000); // 1s check
  let timeout = Duration::from_millis(1500); // 1.5s timeout

  std::thread::spawn(move || {
    let mut last_emitted: Option<NetState> = None;
    let mut fail_count: u8 = 0;
    let mut success_count: u8 = 0;
    let mut remote_loaded = false;

    // Wait for the window handle to exist.
    let mut main_window = None;
    for _ in 0..200 {
      if let Some(w) = app.get_webview_window("main") {
        main_window = Some(w);
        break;
      }
      std::thread::sleep(Duration::from_millis(10));
    }
        log::info!("net: Here ");


    let Some(main) = main_window else {
      log::warn!("net: main window not found; network monitor running without UI");
      // Still run and log state changes.
      loop {
        let _ = check_remote_reachability(&remote_ui_url, timeout);
        std::thread::sleep(poll_interval);
      }
    };

    loop {
      // If the webview has recently reported a page load error, treat it as
      // temporarily offline/no-internet to avoid flicker/blank pages.
      let now_ms = now_ms_i64();
      let last_err_ms = LAST_PAGE_LOAD_ERROR_AT_MS.load(std::sync::atomic::Ordering::Relaxed);
      let page_error_recent = last_err_ms > 0 && now_ms.saturating_sub(last_err_ms) <= 5_000;

      let mut raw_state = check_remote_reachability(&remote_ui_url, timeout);
      if page_error_recent && raw_state == NetState::Online {
        raw_state = NetState::NoInternet;
      }
      
      if raw_state == NetState::Online {
        fail_count = 0;
        success_count = success_count.saturating_add(1);
      } else {
        success_count = 0;
        fail_count = fail_count.saturating_add(1);
      }

      // Determine the effective state with hysteresis.
      let state = match last_emitted {
        Some(NetState::Online) => {
          // If currently Online, require 2 failures to switch to Offline/NoInternet.
          if fail_count >= 2 { raw_state } else { NetState::Online }
        }
        Some(s) => {
          // If currently Offline/NoInternet
          if raw_state == NetState::Online {
             // Require 2 successes to switch back to Online.
             if success_count >= 2 { NetState::Online } else { s }
          } else {
             // Switch between Offline <-> NoInternet immediately if valid
             raw_state
          }
        }
        None => {
          // Initial state: accept raw_state immediately to show UI quickly.
          raw_state
        }
      };

      let now = OffsetDateTime::now_utc().unix_timestamp_nanos() / 1_000_000;
      let payload = NetStatusPayload {
        state,
        checked_at_ms: now,
      };

      // Emit only when state changes, or if we haven't been able to emit yet.
      // Note: If raw_state flipped but we suppressed it due to hysteresis, state == last_emitted, so we won't emit.
      let should_emit = last_emitted.map(|s| s != state).unwrap_or(true);
      if should_emit {
        #[cfg(target_os = "macos")]
        {
          cache_macos_connectivity_state(state);
          sync_macos_connectivity_icon(&app, state);
        }

        #[cfg(target_os = "linux")]
        {
          cache_linux_connectivity_state(state);
          sync_linux_connectivity_icon(&app, state);
        }

        // Emit to all windows (main + offline overlay).
        let _ = app.emit("aro-net-status", payload.clone());

        // Online: load the remote UI if needed, show the main window, hide overlay.
        if state == NetState::Online {
          if !remote_loaded {
            let target = remote_ui_url.as_str();
            match Url::parse(target) {
              Ok(u) => {
                let mut ww = main.clone();
                if let Err(e) = ww.navigate(u) {
                  log::warn!("net: navigate failed target={target} err={e}");
                } else {
                  remote_loaded = true;
                }
              }
              Err(e) => log::warn!("net: invalid target url={target} err={e}"),
            }
          }

          if initial_node_info_pending() {
            show_status_overlay(
              &app,
              Some(main.clone()),
              StatusOverlayState::Loading,
              should_hide_main_for_loading_overlay(),
            );
          } else {
            hide_status_overlay(&app);

            // Restore main always-on-top behavior (configured in tauri.conf.json).
            let _ = main.set_always_on_top(true);

            // Always ensure the main window is visible again after recovering from Offline.
            let _ = main.show();
            let _ = main.set_focus();
          }
        } else {
          let overlay_state = if state == NetState::Offline {
            StatusOverlayState::Offline
          } else {
            StatusOverlayState::NoInternet
          };
          show_status_overlay(&app, Some(main.clone()), overlay_state, true);
        }

        last_emitted = Some(state);
        log::info!("net: state -> {:?}", state);
      }

      // If there was a recent page-load error, ensure we will attempt to
      // navigate again after recovery.
      if page_error_recent {
        remote_loaded = false;
      }

      std::thread::sleep(poll_interval);
    }
  });
}

// Called by injected JS when the webview loads a native error page (e.g. DNS failure).
#[tauri::command]
fn report_page_load_error(app: tauri::AppHandle, window: tauri::WebviewWindow, error: String) {
  log::warn!("report_page_load_error: {error} (window={})", window.label());
  if window.label() != "main" {
    return;
  }
  emit_network_issue_and_show_overlay(&app, Some(window), &error);
}

#[tauri::command]
fn get_status_overlay_state() -> StatusOverlayPayload {
  StatusOverlayPayload {
    state: current_status_overlay_state(),
  }
}

#[cfg_attr(mobile, tauri::mobile_entry_point)]
pub fn run() {
  if !acquire_single_instance_lock() {
    return;
  }

  install_panic_hook();

  let builder = tauri::Builder::default()
    .plugin(tauri_plugin_shell::init())
    .on_page_load(|window, _payload| {
      // Inject scripts on every page load for reliability (remote UI navigation / reloads).
      if window.label() == "offline" {
        // Fill the about:blank window with our offline overlay HTML.
        match serde_json::to_string(offline_overlay_html()) {
          Ok(html_js) => {
            let js = format!("document.open();document.write({});document.close();", html_js);
            if let Err(e) = window.eval(&js) {
              log::warn!("failed to write offline overlay html (page load): {e}");
            }
          }
          Err(e) => log::warn!("failed to encode offline overlay html (page load): {e}"),
        }
        return;
      }

      if window.label() != "main" {
        return;
      }

      if let Err(e) = window.eval(GLOBAL_APP_CRASH_BRIDGE_JS) {
        log::warn!("failed to inject global crash bridge (page load): {e}");
      }

      if let Err(e) = window.eval(FLUTTER_COMPAT_BRIDGE_JS) {
        log::warn!("failed to inject compat bridge (page load): {e}");
      }

      // Detect native error pages (DNS/resolve failures) and switch to offline overlay.
      if let Err(e) = window.eval(PAGE_LOAD_ERROR_DETECTOR_JS) {
        log::warn!("failed to inject page-load error detector: {e}");
      }
    });

  #[cfg(target_os = "linux")]
  let builder = builder.plugin(tauri_plugin_dialog::init());

  builder.setup(|app| {
      // Always enable file logging so crashes and native errors are persisted.
      let log_level = if cfg!(debug_assertions) {
        log::LevelFilter::Debug
      } else {
        log::LevelFilter::Info
      };

      init_crash_log_dir(&app.handle());
      let max_file_size = resolve_max_log_file_size_bytes();

      app.handle().plugin(
        tauri_plugin_log::Builder::default()
          .level(log_level)
          // Rotate previous log file when it grows too large (rotation happens on startup).
          .rotation_strategy(tauri_plugin_log::RotationStrategy::KeepAll)
          .max_file_size(max_file_size)
          .format(|out, message, record| {
            let now = OffsetDateTime::now_local().unwrap_or_else(|_| OffsetDateTime::now_utc());
            let fmt = format_description::parse("[year]-[month]-[day] [hour]:[minute]:[second].[subsecond digits:3]")
              .unwrap_or_else(|_| format_description::parse("[year]-[month]-[day]T[hour]:[minute]:[second].[subsecond digits:3]").expect("valid fallback time format"));
            let ts = now
              .format(&fmt)
              .unwrap_or_else(|_| "<time-format-error>".to_string());
            out.finish(format_args!(
              "[{ts}] [{level}] {target} - {message}",
              ts = ts,
              level = record.level(),
              target = record.target(),
              message = message
            ))
          })
          .build(),
      )?;

      // Log the actual log file location on startup
      if let Ok(log_dir) = app.path().app_log_dir() {
        log::info!(" (Log file location): {}", log_dir.display());
        println!("(Log file location): {}", log_dir.display());
      }
      log::info!("====================Net init ====================");

      // Log system environment information 
      log::info!("==================== System Environment ====================");
      log::info!("OS: {}", std::env::consts::OS);
      log::info!("Architecture: {}", std::env::consts::ARCH);
      log::info!("Family: {}", std::env::consts::FAMILY);
      #[cfg(target_os = "linux")]
      log::info!("Platform: Linux (auto-update enabled)");
      #[cfg(target_os = "macos")]
      log::info!("Platform: macOS (auto-update not supported)");
      #[cfg(target_os = "windows")]
      log::info!("Platform: Windows (auto-update not supported)");
      log::info!("==========================================================");

      // Ensure libstudy is always loaded from the same per-user location.
      // This makes install + update paths consistent: ~/.local/share/<identifier>/libstudy.so
      set_default_libstudy_override(&app.handle());

      // Initialize the Go-call worker early to avoid first-call surprises.
      init_libstudy_worker();

      // Tauri-layer network monitor: emits 'aro-net-status' for UI prompts.
      start_network_monitor(app.handle().clone());

      show_status_overlay(
        &app.handle(),
        app.get_webview_window("main"),
        StatusOverlayState::Loading,
        should_hide_main_for_loading_overlay(),
      );

      #[cfg(target_os = "macos")]
      {
        // Ensure the app appears in the Dock (not an "agent" app) during dev runs.
        let handle = app.handle();

        match handle.set_activation_policy(tauri::ActivationPolicy::Regular) {
          Ok(_) => log::info!("macos activation policy set to Regular"),
          Err(e) => log::warn!("macos set_activation_policy failed: {e}"),
        }

        // NOTE: Tauri v2 does not expose `set_dock_visibility` on `AppHandle`.
        // Setting activation policy to `Regular` is sufficient to show in Dock.
        log::info!("macos dock visibility: using ActivationPolicy::Regular");

        // Create a macOS tray (status bar) icon. Enabling the `tray-icon` feature is not
        // enough; the tray icon must be instantiated at runtime.
        let tray_show = tauri::menu::MenuItem::with_id(app, "tray_show", "Show", true, None::<&str>)?;
        let tray_hidden = tauri::menu::MenuItem::with_id(app, "tray_hidden", "Hide", true, None::<&str>)?;
        let tray_quit = tauri::menu::MenuItem::with_id(app, "tray_quit", "Quit", true, None::<&str>)?;
        let tray_menu = tauri::menu::Menu::with_items(app, &[&tray_show, &tray_hidden, &tray_quit])?;

        let _tray = tauri::tray::TrayIconBuilder::with_id("main")
          .icon(MACOS_TRAY_ICON)
          .menu(&tray_menu)
          .on_menu_event(|app, event| match event.id().as_ref() {
            "tray_show" => {
              let overlay_active = STATUS_OVERLAY_VISIBLE.load(std::sync::atomic::Ordering::Relaxed);
              if overlay_active {
                if let Some(off) = app.get_webview_window("offline") {
                  let _ = off.show();
                  let _ = off.set_focus();
                }
              } else {
                if let Some(w) = app.get_webview_window("main") {
                  let _ = w.show();
                  let _ = w.set_focus();
                }
              }
            }
            "tray_hidden" => {
              if let Some(w) = app.get_webview_window("main") {
                let _ = w.hide();
              }
              if let Some(off) = app.get_webview_window("offline") {
                let _ = off.hide();
              }
            }
            "tray_quit" => {
              app.exit(0);
            }
            _ => {}
          })
          .build(app)?;

        let labels: Vec<String> = handle.webview_windows().keys().cloned().collect();
        log::info!("webview window labels: {labels:?}");

        if let Some(state) = cached_macos_connectivity_state() {
          sync_macos_connectivity_icon(&handle, state);
        }

        // Do not show the window here; network monitor will show it after routing.
      }

      #[cfg(target_os = "linux")]
      {
        let tray_show = tauri::menu::MenuItem::with_id(app, "tray_show", "Show", true, None::<&str>)?;
        let tray_hidden = tauri::menu::MenuItem::with_id(app, "tray_hidden", "Hide", true, None::<&str>)?;
        let tray_quit = tauri::menu::MenuItem::with_id(app, "tray_quit", "Quit", true, None::<&str>)?;
        let tray_menu = tauri::menu::Menu::with_items(app, &[&tray_show, &tray_hidden, &tray_quit])?;

        // Choose the initial tray icon based on cached connectivity state.
        // At startup, if the network state is unknown or offline, use the offline icon
        // so the tray matches the loading/offline overlay that is always shown initially.
        let initial_tray_icon = match cached_linux_connectivity_state() {
          Some(NetState::Online) => LINUX_TRAY_ICON,
          _ => LINUX_TRAY_ICON_OFFLINE,
        };

        let _tray = tauri::tray::TrayIconBuilder::with_id("main")
          .icon(initial_tray_icon)
          .menu(&tray_menu)
          .on_menu_event(|app, event| match event.id().as_ref() {
            "tray_show" => {
              let overlay_active = STATUS_OVERLAY_VISIBLE.load(std::sync::atomic::Ordering::Relaxed);
              if overlay_active {
                if let Some(off) = app.get_webview_window("offline") {
                  let _ = off.show();
                  let _ = off.set_focus();
                }
              } else {
                if let Some(w) = app.get_webview_window("main") {
                  let _ = w.show();
                  let _ = w.set_focus();
                }
              }
            }
            "tray_hidden" => {
              if let Some(w) = app.get_webview_window("main") {
                let _ = w.hide();
              }
              if let Some(off) = app.get_webview_window("offline") {
                let _ = off.hide();
              }
            }
            "tray_quit" => {
              app.exit(0);
            }
            _ => {}
          })
          .build(app)?;

        let handle = app.handle();
        let labels: Vec<String> = handle.webview_windows().keys().cloned().collect();
        log::info!("webview window labels: {labels:?}");

        if let Some(state) = cached_linux_connectivity_state() {
          sync_linux_connectivity_icon(&handle, state);
        }

        // Do not show the window here; network monitor will show it after routing.
      }

      // Do not eager-load: Flutter sets override path before loading.
      // In Tauri we allow the frontend to call `set_libstudy_override_path` first.
      let (loaded, path) = libstudy::info().unwrap_or((false, None));
      log::info!("libstudy initial state loaded={loaded} path={path:?}");

      // Provide a Flutter-compatible JS bridge so the remote React page can keep
      // using window.Flutter.postMessage + window.onFlutterMessage.
      if let Some(main) = app.get_webview_window("main") {
        if let Err(e) = main.eval(GLOBAL_APP_CRASH_BRIDGE_JS) {
          log::warn!("failed to inject global crash bridge: {e}");
        }
        if let Err(e) = main.eval(FLUTTER_COMPAT_BRIDGE_JS) {
          log::warn!("failed to inject  compat bridge: {e}");
        } else {
          log::info!("Compat bridge injected");
        }
      }

      // Do not show the window here; the network monitor will show it after
      // it routes to the appropriate page (remote UI vs offline page).

      // Optional eager init (useful in dev to verify logging / libstudy init even if the web page
        // doesn't call it).
        let eager_init = std::env::var("ARO_EAGER_INIT").ok().as_deref() == Some("1");
      if eager_init {
        let handle = app.handle().clone();
        tauri::async_runtime::spawn(async move {
          match init_libstudy_auto(handle).await {
            Ok(resp) => {
              println!("[eager_init] init_libstudy_auto OK: {resp}");
              log::info!("eager_init init_libstudy_auto OK: {resp}");
            }
            Err(e) => {
              println!("[eager_init] init_libstudy_auto ERR: {e}");
              log::warn!("eager_init init_libstudy_auto ERR: {e}");
            }
          }
        });
      }
      Ok(())
    })
    .invoke_handler(tauri::generate_handler![
      bridge_log,
      bridge_crash_log,
      report_page_load_error,
      get_status_overlay_state,
      set_libstudy_override_path,
      init_libstudy,
      init_libstudy_with_params,
      init_libstudy_auto,
      open_external,
      node_sign_up,
      get_node_stat,
      get_rewards,
      // get_ws_client_status,
      get_current_version,
      get_last_version,
      libstudy_info,
    ])
    .run(tauri::generate_context!())
    .expect("error while running tauri application");
}

fn install_panic_hook() {
  // Ensure we only set once even if setup is re-run.
  static ONCE: std::sync::Once = std::sync::Once::new();
  ONCE.call_once(|| {
    std::panic::set_hook(Box::new(|panic_info| {
      let thread = std::thread::current();
      let thread_name = thread.name().unwrap_or("<unnamed>");

      let payload = if let Some(s) = panic_info.payload().downcast_ref::<&str>() {
        (*s).to_string()
      } else if let Some(s) = panic_info.payload().downcast_ref::<String>() {
        s.clone()
      } else {
        "<non-string panic payload>".to_string()
      };

      let location = panic_info
        .location()
        .map(|l| format!("{}:{}:{}", l.file(), l.line(), l.column()))
        .unwrap_or_else(|| "<unknown>".to_string());

      let backtrace = Backtrace::capture();

      let now = OffsetDateTime::now_local().unwrap_or_else(|_| OffsetDateTime::now_utc());
      let fmt = format_description::parse("[year]-[month]-[day] [hour]:[minute]:[second].[subsecond digits:3]")
        .unwrap_or_else(|_| format_description::parse("[year]-[month]-[day]T[hour]:[minute]:[second].[subsecond digits:3]").expect("valid fallback time format"));
      let ts = now
        .format(&fmt)
        .unwrap_or_else(|_| "<time-format-error>".to_string());

      // Log to both stderr and the configured logger (tauri-plugin-log) so we
      // get it in dev console and in log files.
      let msg = format!(
        "[{ts}] [panic] thread={thread_name} location={location} payload={payload}\n{backtrace}"
      );
      eprintln!("{msg}");
      log::error!("{msg}");
      // Also write to a dedicated crash log file (best-effort).
      append_crash_log(&msg);
    }));
  });
}

#[tauri::command]
fn bridge_log(message: String) {
  println!("{message}");
  log::info!("{message}");
}

#[tauri::command]
fn bridge_crash_log(
  kind: String,
  message: String,
  stack: Option<String>,
  url: Option<String>,
  line: Option<u32>,
  column: Option<u32>,
) {
  let now = OffsetDateTime::now_local().unwrap_or_else(|_| OffsetDateTime::now_utc());
  let fmt = format_description::parse("[year]-[month]-[day] [hour]:[minute]:[second].[subsecond digits:3]")
    .unwrap_or_else(|_| format_description::parse("[year]-[month]-[day]T[hour]:[minute]:[second].[subsecond digits:3]").expect("valid fallback time format"));
  let ts = now
    .format(&fmt)
    .unwrap_or_else(|_| "<time-format-error>".to_string());

  let entry = format!(
    "[{ts}] [web-crash] kind={kind} url={} line={} column={} message={}\nstack={} ",
    url.unwrap_or_else(|| "<unknown>".to_string()),
    line
      .map(|value| value.to_string())
      .unwrap_or_else(|| "<unknown>".to_string()),
    column
      .map(|value| value.to_string())
      .unwrap_or_else(|| "<unknown>".to_string()),
    message,
    stack.unwrap_or_else(|| "<none>".to_string()),
  );

  log::error!("{entry}");
  append_crash_log(&entry);
}

#[tauri::command]
fn libstudy_info() -> Result<serde_json::Value, String> {
  let (loaded, path) = libstudy::info().map_err(|e| e.to_string())?;
  Ok(serde_json::json!({
    "loaded": loaded,
    "path": path
  }))
}

#[tauri::command]
fn set_libstudy_override_path(path: Option<String>) -> Result<(), String> {
  let p = path
    .map(std::path::PathBuf::from)
    .filter(|p| !p.as_os_str().is_empty());
  libstudy::set_override_path(p);
  Ok(())
}

#[tauri::command]
async fn init_libstudy(api_base_url: Option<String>, ws_base_url: Option<String>) -> Result<String, String> {
  let init_params = serde_json::json!({
    "config": {
      // Match Go struct field names (no json tags in libstudy): BaseAPIURL/BaseWSURL
      "BaseAPIURL": api_base_url.unwrap_or_default(),
      "BaseWSURL": ws_base_url.unwrap_or_default()
    }
  });
  call_libstudy(LibstudyOp::Init {
    init_params_json: init_params.to_string(),
  })
  .await
}

#[tauri::command]
async fn init_libstudy_auto(app: tauri::AppHandle) -> Result<String, String> {
  // Ensure the per-user copy exists and prefer it for loading.
  set_default_libstudy_override(&app);

  log::info!("init_libstudy_ing");
  

  #[cfg(target_os = "linux")]
  let app_for_update_restart = app.clone();

  // Mirror Flutter behavior: set working dir to app support dir before init,
  // so libstudy can store keypair files in a writable location.
  let app_data_dir = app
    .path()
    .app_data_dir()
    .map_err(|e| format!("failed to resolve app_data_dir: {e}"))?;
  let app_data_dir2 = app_data_dir.clone();

  tauri::async_runtime::spawn_blocking(move || {    log::info!("========== init_libstudy_auto START ==========");
    log::info!("Current OS: {}, ARCH: {}", std::env::consts::OS, std::env::consts::ARCH);
        std::fs::create_dir_all(&app_data_dir2)
      .map_err(|e| format!("failed to create app_data_dir {app_data_dir2:?}: {e}"))?;
    std::env::set_current_dir(&app_data_dir2)
      .map_err(|e| format!("failed to set current dir to {app_data_dir2:?}: {e}"))?;

    println!("[init_libstudy_auto] working dir set to {:?}", app_data_dir2);
    log::info!("init_libstudy_auto: working dir set to {app_data_dir2:?}");

  // Use libstudy defaults (constant endpoints) unless caller explicitly sets URLs via init_libstudy.
  let init_params = serde_json::json!({
    "appDir": app_data_dir2.to_string_lossy().to_string(),
    "config": {
      "BaseAPIURL": "https://staging-api.aro.network",
      "BaseWSURL": "staging-ws.aro.network"
    }
  });


  println!("[init_libstudy_auto] init_params={}", init_params);
  log::info!("init_libstudy_auto: {init_params}");

    log::info!("init_libstudy_auto: attempting to load libstudy (via go-worker)...");
    let result = call_libstudy_sync(LibstudyOp::Init {
      init_params_json: init_params.to_string(),
    });

    match result {
      Ok(resp) => {
        log::info!("init_libstudy_auto: init SUCCESS response={}", resp);

        // Self-healing: If we loaded from a fallback path (e.g. bundled resources) instead of the 
        // expected app_data path (which set_default_libstudy_override prioritizes), it implies 
        // the app_data copy is broken/incompatible. We should overwrite it with the working one.
        if let Ok((true, Some(loaded_path))) = libstudy::info() {
          let lib_name = libstudy::Libstudy::platform_lib_filename();
          let data_lib_path = app_data_dir2.join(lib_name);

          // Check if we are using a different file than the one in data dir, AND the data dir file exists (is broken)
          if loaded_path != data_lib_path && data_lib_path.exists() {
             log::warn!("init_libstudy_auto: Self-healing triggered. Loaded from {:?} but expected {:?}. Overwriting broken library...", loaded_path, data_lib_path);
             println!("[init_libstudy_auto] Self-healing: loaded from {:?} but expected {:?}. Attempting to overwrite broken library...", loaded_path, data_lib_path);
             
             match std::fs::copy(&loaded_path, &data_lib_path) {
               Ok(_) => {
                 log::info!("init_libstudy_auto: Self-healing successful. Broken library replaced.");
                 #[cfg(target_os = "linux")]
                 {
                   use std::os::unix::fs::PermissionsExt;
                   if let Ok(meta) = std::fs::metadata(&loaded_path) {
                     let _ = std::fs::set_permissions(&data_lib_path, std::fs::Permissions::from_mode(meta.permissions().mode()));
                   }
                 }
               },
               Err(e) => log::error!("init_libstudy_auto: Self-healing failed to copy library: {}", e),
             }
          }
        }
      
        
        // Check for libstudy updates (only on Linux)
        #[cfg(target_os = "linux")]
        {
          start_libstudy_update_monitor(app_for_update_restart.clone(), app_data_dir2.clone());

          let app_data = app_data_dir2.clone();
          let app_for_update_restart2 = app_for_update_restart.clone();
          tauri::async_runtime::spawn(async move {
            run_libstudy_update_check(app_for_update_restart2, app_data, "startup").await;
          });
        }
        
        #[cfg(not(target_os = "linux"))]
        {
          log::info!("init_libstudy_auto: auto-update not supported on this platform ({})", std::env::consts::OS);
        }
        
        Ok(resp)
      }
      Err(e) => {
        let err_msg = format!("{:#}", e);
        log::error!("init_libstudy_auto: FAILED - {}", err_msg);
        println!("[init_libstudy_auto] ERROR: {}", err_msg);
        Err(err_msg)
      }
    }
  })
  .await
  .map_err(|e| {
    let err = format!("init_libstudy_auto task join error: {e}");
    log::error!("{}", err);
    err
  })?
}

#[tauri::command]
fn open_external(app: tauri::AppHandle, url: String) -> Result<(), String> {
  app.shell().open(url, None).map_err(|e| e.to_string())
}

#[tauri::command]
async fn init_libstudy_with_params(
  init_params_json: String,
  working_dir: Option<String>,
) -> Result<String, String> {
  if let Some(dir) = working_dir.as_ref().filter(|d| !d.trim().is_empty()) {
    std::env::set_current_dir(dir).map_err(|e| format!("failed to set current dir to {dir:?}: {e}"))?;
  }

  call_libstudy(LibstudyOp::Init { init_params_json }).await
}

#[tauri::command]
async fn node_sign_up() -> Result<String, String> {
  let resp = call_libstudy(LibstudyOp::NodeSignUp).await?;

  println!("[node_sign_up] response={resp}");
  log::info!("node_sign_up response={resp}");
  Ok(resp)
}



#[tauri::command]
async fn get_node_stat(app: tauri::AppHandle) -> Result<String, String> {
  let resp = call_libstudy(LibstudyOp::GetNodeStat).await?;
  println!("[get_node_stat] response={resp}");
  log::info!("get_node_stat response={resp}");

  maybe_complete_initial_node_info(&app, &resp);

  // If the API call failed in a network-y way, switch to the offline overlay.
  // libstudy tends to wrap transport errors into { code: 500, message: "request failed: ..." }.
  log::info!("get_rewardsRes response={resp}");

  if let Some(v) = parse_node_stat_response(&resp) {
    if node_stat_response_looks_like_network_failure(&v) {
      let msg = v
        .get("message")
        .and_then(|m| m.as_str())
        .unwrap_or("");

      emit_network_issue_and_show_overlay(
        &app,
        app.get_webview_window("main"),
        &format!("libstudy get_node_stat code=500: {msg}"),
      );
    }
  }
  Ok(resp)
}

#[tauri::command]
async fn get_rewards() -> Result<String, String> {
  let resp = call_libstudy(LibstudyOp::GetRewards).await?;

  println!("[get_rewards] response={resp}");
  log::info!("get_rewards response={resp}");
  Ok(resp)
}

#[tauri::command]
async fn get_current_version() -> Result<String, String> {
  let resp = call_libstudy(LibstudyOp::GetCurrentVersion).await?;
    println!("[get_current_version] response={resp}");
  log::info!("get_current_version response={resp}");
  Ok(resp)
}

#[tauri::command]
async fn get_last_version() -> Result<String, String> {
  let resp = call_libstudy(LibstudyOp::GetLastVersion).await?;

  println!("[get_last_version] response={resp}");
  log::info!("get_last_version response={resp}");
  Ok(resp)
}
