mod libstudy;

#[cfg(target_os = "linux")]
mod lib_check;

use std::backtrace::Backtrace;
use time::{
  format_description,
  OffsetDateTime,
};

use tauri::Manager;
use tauri_plugin_shell::ShellExt;

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
  let builder = tauri::Builder::default().plugin(tauri_plugin_shell::init());

  #[cfg(target_os = "linux")]
  let builder = builder.plugin(tauri_plugin_dialog::init());

  builder.setup(|app| {
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
        let tray_menu = tauri::menu::Menu::with_items(app, &[&tray_show, &tray_hidden,   &tray_quit])?;

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

      // The window is configured as `visible: false` in `tauri.conf.json`.
      // On macOS we explicitly show/focus it above; do the same on Linux/Windows
      // so the app does not run "headless" with no way to open it.
      #[cfg(any(target_os = "linux", target_os = "windows"))]
      {
        if let Some(main) = app.get_webview_window("main") {
          log::info!("showing main window on startup");
          let _ = main.show();
          let _ = main.set_focus();
        } else {
          log::warn!("main window not found; cannot show on startup");
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
                            .title("ARO Desktop")
                            .show(|_| {});
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
