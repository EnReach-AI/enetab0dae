mod libstudy;

#[cfg_attr(mobile, tauri::mobile_entry_point)]
pub fn run() {
  tauri::Builder::default()
    .setup(|app| {
      if cfg!(debug_assertions) {
        app.handle().plugin(
          tauri_plugin_log::Builder::default()
            .level(log::LevelFilter::Info)
            .build(),
        )?;
      }

      // Do not eager-load: Flutter sets override path before loading.
      // In Tauri we allow the frontend to call `set_libstudy_override_path` first.
      let (loaded, path) = libstudy::info().unwrap_or((false, None));
      log::info!("libstudy initial state loaded={loaded} path={path:?}");
      Ok(())
    })
    .invoke_handler(tauri::generate_handler![
      set_libstudy_override_path,
      init_libstudy,
      get_last_version,
      cleanup_libstudy,
      libstudy_info,
    ])
    .run(tauri::generate_context!())
    .expect("error while running tauri application");
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
      "base_api_url": api_base_url.unwrap_or_default(),
      "base_ws_url": ws_base_url.unwrap_or_default()
    }
  });
  libstudy::with_lib(|lib, _path| lib.init(&init_params.to_string()))
    .map_err(|e| e.to_string())
}

#[tauri::command]
fn get_last_version() -> Result<String, String> {
  libstudy::with_lib(|lib, _path| lib.get_last_version()).map_err(|e| e.to_string())
}

#[tauri::command]
fn cleanup_libstudy() -> Result<String, String> {
  libstudy::with_lib(|lib, _path| lib.cleanup()).map_err(|e| e.to_string())
}
