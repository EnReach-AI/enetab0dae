
// Ensure we handle page load errors gracefully (e.g. DNS failure even if IP ping works).
#[tauri::command]
fn report_page_load_error(app: tauri::AppHandle, window: tauri::WebviewWindow, error: String) {
  log::warn!("report_page_load_error: {} (in window {})", error, window.label());

  // If the main window failed to load, treat it as effectively offline.
  if window.label() == "main" {
    // Hide the main window to avoid showing the error page.
    let _ = window.hide();
    
    // Show the offline overlay if not already visible.
    if app.get_webview_window("offline").is_none() {
      let _ = ensure_offline_overlay_window(&app);
    }
    
    if let Some(off) = app.get_webview_window("offline") {
      // Ensure the overlay is visible.
      let _ = off.show();
      let _ = off.set_focus();
    }
  }
}
