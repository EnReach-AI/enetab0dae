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
  let Some(dir) = CRASH_LOG_DIR.get() else {
    // Best-effort: at least stderr.
    eprintln!("[crash-log] {message}");
    return;
  };

  let path = dir.join("crash.log");
  let _ = rotate_file_keep_all_if_oversize(&path, DEFAULT_MAX_CRASH_FILE_SIZE_BYTES);

  if let Ok(mut f) = fs::OpenOptions::new().create(true).append(true).open(&path) {
    let _ = writeln!(f, "{message}");
  }
}

#[cfg(target_os = "linux")]
use tauri_plugin_dialog::DialogExt;

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

#[cfg(target_os = "linux")]
const LINUX_TRAY_ICON: tauri::image::Image<'static> = tauri::include_image!("./icons/32x32.png");

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
    .logo { width:142px; height:30px; object-fit:contain; display:block; margin:0 auto 24px auto; pointer-events:none; }
    .desc { font-size:14px; font-weight:700; opacity:0.95; white-space:pre-line; }
    .connecting { position:absolute; left:0; right:0; bottom:118px; text-align:center; font-size:15px; opacity:0.9; }
    .bottom { position:absolute; left:0; right:0; bottom:0; height:98px; background:#02B421; border-top-left-radius:30px; border-top-right-radius:30px; display:flex; align-items:center; justify-content:center; padding:0 20px; box-shadow:0 2px 8px rgba(0,0,0,0.2); text-align:center; font-size:14px; font-weight:600; }
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
    <div class="connecting">Connecting...</div>
    <div class="bottom" id="msg">There seems to be a network issue, please check your internet connectivity.</div>
  </div>

  <script>
    (function() {
      const setMsg = (state) => {
        const el = document.getElementById('msg');
        if (!el) return;
        if (state === 'offline') {
          el.textContent = 'Network disconnected. Please check your connectivity.';
        } else if (state === 'no_internet') {
          el.textContent = 'There seems to be a network issue, please check your internet connectivity.';
        } else {
          el.textContent = 'Connecting...';
        }
      };

      const listen = () => {
        try {
          const t = window.__TAURI__;
          const fn = t && t.event && t.event.listen;
          if (typeof fn !== 'function') return false;
          fn('aro-net-status', (event) => {
            const p = event && event.payload ? event.payload : null;
            const s = p && p.state ? String(p.state) : '';
            setMsg(s);
          });
          return true;
        } catch (_) { return false; }
      };
      listen() || setTimeout(listen, 250);
    })();
  </script>
</body>
</html>"#.to_string();

    html = html.replace("__HEADER_B64__", &header_b64);
    html = html.replace("__LOGO_B64__", &logo_b64);
    html
  })
}

fn ensure_offline_overlay_window(app: &tauri::AppHandle) -> Result<(), String> {
  if app.get_webview_window("offline").is_some() {
    return Ok(());
  }

  let about_blank = Url::parse("about:blank").map_err(|e| format!("invalid about:blank url: {e}"))?;
  tauri::WebviewWindowBuilder::new(app, "offline", tauri::WebviewUrl::External(about_blank))
    .title("ARO Desktop")
    .inner_size(360.0, 640.0)
    .resizable(false)
    .decorations(false)
    .always_on_top(true)
    .skip_taskbar(true)
    .visible(false)
    .build()
    .map_err(|e| format!("failed to create offline overlay window: {e}"))?;

  Ok(())
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, Serialize)]
#[serde(rename_all = "snake_case")]
enum NetState {
  Online,
  Offline,
  NoInternet,
}

#[derive(Debug, Clone, Serialize)]
struct NetStatusPayload {
  state: NetState,
  checked_at_ms: i128,
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
      // DNS failure or resolver not available.
      log::debug!("net: resolve failed host={host} port={port} err={e}");
      return NetState::NoInternet;
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
  let poll_interval = Duration::from_millis(300);
  let timeout = Duration::from_millis(250);

  std::thread::spawn(move || {
    let mut last_emitted: Option<NetState> = None;
    let mut bad_streak: u8 = 0;
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

    let Some(main) = main_window else {
      log::warn!("net: main window not found; network monitor running without UI");
      // Still run and log state changes.
      loop {
        let _ = check_remote_reachability(&remote_ui_url, timeout);
        std::thread::sleep(poll_interval);
      }
    };

    loop {
      let raw_state = check_remote_reachability(&remote_ui_url, timeout);
      let state = if raw_state == NetState::Online {
        bad_streak = 0;
        NetState::Online
      } else {
        bad_streak = bad_streak.saturating_add(1);
        // Require two consecutive bad reads before we consider it truly bad.
        if bad_streak >= 2 { raw_state } else { last_emitted.unwrap_or(raw_state) }
      };

      let now = OffsetDateTime::now_utc().unix_timestamp_nanos() / 1_000_000;
      let payload = NetStatusPayload {
        state,
        checked_at_ms: now,
      };

      // Emit only when state changes, or if we haven't been able to emit yet.
      let should_emit = last_emitted.map(|s| s != state).unwrap_or(true);
      if should_emit {
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

          if let Some(off) = app.get_webview_window("offline") {
            let _ = off.hide();
          }

          // Restore main always-on-top behavior (configured in tauri.conf.json).
          let _ = main.set_always_on_top(true);

          // Always ensure the main window is visible again after recovering from Offline.
          let _ = main.show();
          let _ = main.set_focus();
        } else {
          // Offline/NoInternet: show the native overlay window.
          // Hide the main window to avoid showing two windows (main + offline overlay).
          let _ = main.hide();

          if app.get_webview_window("offline").is_none() {
            let _ = ensure_offline_overlay_window(&app);
          }

          if let Some(off) = app.get_webview_window("offline") {
            // Ensure the overlay is actually above the main window.
            let _ = main.set_always_on_top(false);
            let _ = off.set_always_on_top(true);

            // Best-effort: match main window bounds.
            if let Ok(pos) = main.outer_position() {
              let _ = off.set_position(pos);
            }
            if let Ok(size) = main.outer_size() {
              let _ = off.set_size(size);
            } else {
              // Fallback to configured fixed size.
              let _ = off.set_size(tauri::LogicalSize::new(360.0, 640.0));
            }
            let _ = off.show();
            let _ = off.set_focus();
          }
        }

        last_emitted = Some(state);
        log::info!("net: state -> {:?}", state);
      }

      std::thread::sleep(poll_interval);
    }
  });
}

#[cfg_attr(mobile, tauri::mobile_entry_point)]
pub fn run() {
  if !acquire_single_instance_lock() {
    return;
  }

  let builder = tauri::Builder::default()
    .plugin(tauri_plugin_shell::init())
    .on_page_load(|window, _payload| {
      // Inject scripts on every page load for reliability (remote UI navigation / reloads).
      if window.label() == "offline" {
        // Fill the about:blank window with our offline overlay HTML.
        // Use JSON string encoding to avoid JS escaping issues.
        match serde_json::to_string(offline_overlay_html()) {
          Ok(html_js) => {
            let js = format!(
              "document.open();document.write({});document.close();",
              html_js
            );
            if let Err(e) = window.eval(&js) {
              log::warn!("failed to write offline overlay html (page load): {e}");
            }
          }
          Err(e) => {
            log::warn!("failed to encode offline overlay html: {e}");
          }
        }
        return;
      }

      if window.label() != "main" {
        return;
      }

      if let Err(e) = window.eval(FLUTTER_COMPAT_BRIDGE_JS) {
        log::warn!("failed to inject compat bridge (page load): {e}");
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

      install_panic_hook();

      // Ensure libstudy is always loaded from the same per-user location.
      // This makes install + update paths consistent: ~/.local/share/<identifier>/libstudy.so
      set_default_libstudy_override(&app.handle());

      // Tauri-layer network monitor: emits 'aro-net-status' for UI prompts.
      start_network_monitor(app.handle().clone());

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
              if let Some(w) = app.get_webview_window("main") {
                let _ = w.show();
                let _ = w.set_focus();
              }
            }
            "tray_hidden" => {
              if let Some(w) = app.get_webview_window("main") {
                let _ = w.hide();
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

        // Do not show the window here; network monitor will show it after routing.
      }

      #[cfg(target_os = "linux")]
      {
        let tray_show = tauri::menu::MenuItem::with_id(app, "tray_show", "Show", true, None::<&str>)?;
        let tray_hidden = tauri::menu::MenuItem::with_id(app, "tray_hidden", "Hide", true, None::<&str>)?;
        let tray_quit = tauri::menu::MenuItem::with_id(app, "tray_quit", "Quit", true, None::<&str>)?;
        let tray_menu = tauri::menu::Menu::with_items(app, &[&tray_show, &tray_hidden, &tray_quit])?;

        let _tray = tauri::tray::TrayIconBuilder::with_id("main")
          .icon(LINUX_TRAY_ICON)
          .menu(&tray_menu)
          .on_menu_event(|app, event| match event.id().as_ref() {
            "tray_show" => {
              if let Some(w) = app.get_webview_window("main") {
                let _ = w.show();
                let _ = w.set_focus();
              }
            }
            "tray_hidden" => {
              if let Some(w) = app.get_webview_window("main") {
                let _ = w.hide();
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

        // Do not show the window here; network monitor will show it after routing.
      }

      // Do not eager-load: Flutter sets override path before loading.
      // In Tauri we allow the frontend to call `set_libstudy_override_path` first.
      let (loaded, path) = libstudy::info().unwrap_or((false, None));
      log::info!("libstudy initial state loaded={loaded} path={path:?}");

      // Provide a Flutter-compatible JS bridge so the remote React page can keep
      // using window.Flutter.postMessage + window.onFlutterMessage.
      if let Some(main) = app.get_webview_window("main") {
        if let Err(e) = main.eval(FLUTTER_COMPAT_BRIDGE_JS) {
          log::warn!("failed to inject Flutter compat bridge: {e}");
        } else {
          log::info!("Flutter compat bridge injected");
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
fn init_libstudy(api_base_url: Option<String>, ws_base_url: Option<String>) -> Result<String, String> {
  let init_params = serde_json::json!({
    "config": {
      // Match Go struct field names (no json tags in libstudy): BaseAPIURL/BaseWSURL
      "BaseAPIURL": api_base_url.unwrap_or_default(),
      "BaseWSURL": ws_base_url.unwrap_or_default()
    }
  });
  libstudy::with_lib(|lib, _path| lib.init(&init_params.to_string()))
    .map_err(|e| e.to_string())
}

#[tauri::command]
async fn init_libstudy_auto(app: tauri::AppHandle) -> Result<String, String> {
  // Ensure the per-user copy exists and prefer it for loading.
  set_default_libstudy_override(&app);

  #[cfg(target_os = "linux")]
  let app_for_update_prompt = app.clone();

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

    log::info!("init_libstudy_auto: attempting to load libstudy...");
    let result = libstudy::with_lib(|lib, path| {
      log::info!("init_libstudy_auto: libstudy loaded from {:?}, calling init...", path);
      lib.init(&init_params.to_string())
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
          log::info!("init_libstudy_auto: checking for libstudy updates (Linux)...");
          let current_version_result = libstudy::with_lib(|lib, _| lib.get_current_version());
          let latest_version_result = libstudy::with_lib(|lib, _| lib.get_last_version());
          
          if let (Ok(current_ver), Ok(latest_ver)) = (current_version_result, latest_version_result) {
            match (serde_json::from_str::<serde_json::Value>(&current_ver), 
                   serde_json::from_str::<serde_json::Value>(&latest_ver)) {
              (Ok(current_map), Ok(latest_map)) => {
                if current_map.get("code").and_then(|c| c.as_i64()) == Some(200) {
                  log::info!("init_libstudy_auto: current version: {}, latest version: {}", 
                            current_ver, latest_ver);
                  
                  // Spawn update check in background
                  let app_data = app_data_dir2.clone();
                  let app_for_update_prompt2 = app_for_update_prompt.clone();
                  tauri::async_runtime::spawn(async move {
                    match lib_check::check_and_update(current_map, latest_map, app_data).await {
                      Ok(update_result) => {
                        log::info!("libstudy update result: {:?}", update_result);
                        if update_result.updated {
                          log::warn!("libstudy was updated! Restart required to take effect.");

                          // Native prompt (Tauri dialog) so the user sees it even without DevTools.
                          let msg = format!(
                            "Update completed. Please restart the app to take effect.\n{}",
                            update_result.message
                          );
                          // Non-blocking. Ignore errors if dialog backend is unavailable.
                          let _ = app_for_update_prompt2
                            .dialog()
                            .message(msg)
                            .show(move |_| {
                              // Close the app after user confirms the update
                              // Use std::process::exit for stronger termination on Linux
                              #[cfg(target_os = "linux")]
                              {
                                log::info!("Closing app after libstudy update on Linux");
                                std::thread::sleep(std::time::Duration::from_millis(100));
                                std::process::exit(0);
                              }
                              
                              #[cfg(not(target_os = "linux"))]
                              {
                                let _ = app_for_update_prompt2.clone().exit(0);
                              }
                            });
                        }
                      }
                      Err(e) => {
                        log::warn!("libstudy update check failed: {}", e);
                      }
                    }
                  });
                }
              }
              _ => {
                log::warn!("Failed to parse version JSON responses");
              }
            }
          }
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
fn init_libstudy_with_params(
  init_params_json: String,
  working_dir: Option<String>,
) -> Result<String, String> {
  if let Some(dir) = working_dir.as_ref().filter(|d| !d.trim().is_empty()) {
    std::env::set_current_dir(dir).map_err(|e| format!("failed to set current dir to {dir:?}: {e}"))?;
  }

  libstudy::with_lib(|lib, _path| lib.init(&init_params_json)).map_err(|e| e.to_string())
}

#[tauri::command]
async fn node_sign_up() -> Result<String, String> {
  let resp = tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.node_sign_up()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("node_sign_up task join error: {e}"))??;

  println!("[node_sign_up] response={resp}");
  log::info!("node_sign_up response={resp}");
  Ok(resp)
}



#[tauri::command]
async fn get_node_stat() -> Result<String, String> {
  let resp = tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.get_node_stat()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("get_node_stat task join error: {e}"))??;
  println!("[get_node_stat] response={resp}");
  log::info!("get_node_stat response={resp}");
  Ok(resp)
}

#[tauri::command]
async fn get_rewards() -> Result<String, String> {
  let resp = tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.get_rewards()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("get_rewards task join error: {e}"))??;

  println!("[get_rewards] response={resp}");
  log::info!("get_rewards response={resp}");
  Ok(resp)
}

#[tauri::command]
async fn get_current_version() -> Result<String, String> {
  let resp = tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.get_current_version()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("get_current_version task join error: {e}"))??;
    println!("[get_current_version] response={resp}");
  log::info!("get_current_version response={resp}");
  Ok(resp)
}

#[tauri::command]
async fn get_last_version() -> Result<String, String> {
  let resp = tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.get_last_version()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("get_last_version task join error: {e}"))??;

  println!("[get_last_version] response={resp}");
  log::info!("get_last_version response={resp}");
  Ok(resp)
}
