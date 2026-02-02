mod libstudy;

use std::backtrace::Backtrace;
use time::{
  format_description,
  OffsetDateTime,
};

use tauri::Manager;
use tauri_plugin_shell::ShellExt;

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

        if (messageType === 'getWSClientStatus') {
          const resp = await invoke('get_ws_client_status');
          const map = safeJsonParse(resp);
          if (map && map.code === 200) {
            sendToWeb({ type: 'getWSClientStatus', payload: map });
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

#[cfg_attr(mobile, tauri::mobile_entry_point)]
pub fn run() {
  tauri::Builder::default()
    .plugin(tauri_plugin_shell::init())
    .setup(|app| {
      // Always enable file logging so crashes and native errors are persisted.
      let log_level = if cfg!(debug_assertions) {
        log::LevelFilter::Debug
      } else {
        log::LevelFilter::Info
      };
      app.handle().plugin(
        tauri_plugin_log::Builder::default()
          .level(log_level)
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

      install_panic_hook();

      #[cfg(target_os = "macos")]
      {
        // Ensure the app appears in the Dock (not an "agent" app) during dev runs.
        let handle = app.handle();

        match handle.set_activation_policy(tauri::ActivationPolicy::Regular) {
          Ok(_) => log::info!("macos activation policy set to Regular"),
          Err(e) => log::warn!("macos set_activation_policy failed: {e}"),
        }

        match handle.set_dock_visibility(true) {
          Ok(_) => log::info!("macos dock visibility set to true"),
          Err(e) => log::warn!("macos set_dock_visibility(true) failed: {e}"),
        }

        let labels: Vec<String> = handle.webview_windows().keys().cloned().collect();
        log::info!("webview window labels: {labels:?}");

        if let Some(main) = handle.get_webview_window("main") {
          let _ = main.show();
          let _ = main.set_focus();
        } else if let Some((_, first)) = handle.webview_windows().into_iter().next() {
          let _ = first.show();
          let _ = first.set_focus();
        }
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
      node_report_base_info,
      get_node_stat,
      get_rewards,
      get_ws_client_status,
      start_ws_client,
      get_current_version,
      get_last_version,
      start_proxy_worker,
      stop_proxy_worker,
      get_proxy_worker_status,
      restart_proxy_worker,
      is_proxy_worker_running,
      cleanup_libstudy,
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
      eprintln!("[{ts}] [panic] thread={thread_name} location={location} payload={payload}\n{backtrace}");
      log::error!("panic thread={thread_name} location={location} payload={payload}\n{backtrace}");
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
  // Mirror Flutter behavior: set working dir to app support dir before init,
  // so libstudy can store keypair files in a writable location.
  let app_data_dir = app
    .path()
    .app_data_dir()
    .map_err(|e| format!("failed to resolve app_data_dir: {e}"))?;
  let app_data_dir2 = app_data_dir.clone();

  tauri::async_runtime::spawn_blocking(move || {
    std::fs::create_dir_all(&app_data_dir2)
      .map_err(|e| format!("failed to create app_data_dir {app_data_dir2:?}: {e}"))?;
    std::env::set_current_dir(&app_data_dir2)
      .map_err(|e| format!("failed to set current dir to {app_data_dir2:?}: {e}"))?;

    println!("[init_libstudy_auto] working dir set to {:?}", app_data_dir2);
    log::info!("init_libstudy_auto: working dir set to {app_data_dir2:?}");

  // Use libstudy defaults (constant endpoints) unless caller explicitly sets URLs via init_libstudy.
  let init_params = serde_json::json!({
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
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.node_sign_up()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("node_sign_up task join error: {e}"))?
}

#[tauri::command]
async fn node_report_base_info(sys_info_json: String) -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(move || {
    libstudy::with_lib(|lib, _path| lib.node_report_base_info(&sys_info_json)).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("node_report_base_info task join error: {e}"))?
}

#[tauri::command]
async fn get_node_stat() -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.get_node_stat()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("get_node_stat task join error: {e}"))?
}

#[tauri::command]
async fn get_rewards() -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.get_rewards()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("get_rewards task join error: {e}"))?
}

#[tauri::command]
async fn get_ws_client_status() -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.get_ws_client_status()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("get_ws_client_status task join error: {e}"))?
}

#[tauri::command]
async fn start_ws_client() -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.start_ws_client()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("start_ws_client task join error: {e}"))?
}

#[tauri::command]
async fn get_current_version() -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.get_current_version()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("get_current_version task join error: {e}"))?
}

#[tauri::command]
async fn get_last_version() -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.get_last_version()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("get_last_version task join error: {e}"))?
}

#[derive(serde::Deserialize)]
struct StartProxyWorkerArgs {
  // Frontends may send either `config_json` or `configJson`.
  #[serde(alias = "configJson")]
  config_json: String,
}

#[tauri::command]
async fn start_proxy_worker(
  app: tauri::AppHandle,
  args: StartProxyWorkerArgs,
) -> Result<String, String> {
  // Hardcoded config - ignoring frontend input for now
  const HARDCODED_CONFIG: &str = r#"{
    "sn": "OLKN4YY4XA9096W5",
    "token": "1",
    "tunnel_id": "4dd56d7f-df87-4f7b-9dd3-5f74465d8f74",
    "proxy_server_ip": "150.109.69.196",
    "proxy_server_port": 443,
    "local_port": 22779,
    "nat_type": 0,
    "fixed_port": 22779
  }"#;

  log::info!(
    "start_proxy_worker using hardcoded config (ignoring frontend input): sn=OLKN4YY4XA9096W5 tunnel_id=4dd56d7f-df87-4f7b-9dd3-5f74465d8f74 proxy_server=150.109.69.196:443 local_port=22779 nat_type=0 fixed_port=22779 token=1"
  );

  // Align with init_libstudy_auto behavior: ensure we run from a writable directory.
  let app_data_dir = app
    .path()
    .app_data_dir()
    .map_err(|e| format!("start_proxy_worker failed to resolve app_data_dir: {e}"))?;

  let final_config_json = HARDCODED_CONFIG.to_string();

  let resp = tauri::async_runtime::spawn_blocking(move || {
    std::fs::create_dir_all(&app_data_dir)
      .map_err(|e| format!("start_proxy_worker failed to create app_data_dir {app_data_dir:?}: {e}"))?;
    std::env::set_current_dir(&app_data_dir)
      .map_err(|e| format!("start_proxy_worker failed to set current dir to {app_data_dir:?}: {e}"))?;

    libstudy::with_lib(|lib, _path| lib.start_proxy_worker(&final_config_json))
      .map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("start_proxy_worker task join error: {e}"))??;

  // Log the response and best-effort parse for status.
  match serde_json::from_str::<serde_json::Value>(&resp) {
    Ok(v) => {
      let code = v.get("code").and_then(|c| c.as_i64());
      let msg = v
        .get("message")
        .or_else(|| v.get("msg"))
        .and_then(|m| m.as_str())
        .unwrap_or("");
      log::info!("start_proxy_worker response parsed code={code:?} message={msg}");
    }
    Err(_) => {
      log::info!("start_proxy_worker response (non-JSON): {resp}");
    }
  }

  Ok(resp)
}

#[tauri::command]
async fn stop_proxy_worker() -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.stop_proxy_worker()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("stop_proxy_worker task join error: {e}"))?
}

#[tauri::command]
async fn get_proxy_worker_status() -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.get_proxy_worker_status()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("get_proxy_worker_status task join error: {e}"))?
}

#[tauri::command]
async fn restart_proxy_worker() -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.restart_proxy_worker()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("restart_proxy_worker task join error: {e}"))?
}

#[tauri::command]
async fn is_proxy_worker_running() -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.is_proxy_worker_running()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("is_proxy_worker_running task join error: {e}"))?
}

#[tauri::command]
async fn cleanup_libstudy() -> Result<String, String> {
  tauri::async_runtime::spawn_blocking(|| {
    libstudy::with_lib(|lib, _path| lib.cleanup()).map_err(|e| e.to_string())
  })
  .await
  .map_err(|e| format!("cleanup_libstudy task join error: {e}"))?
}
