use anyhow::Result;
use serde::{Deserialize, Serialize};
use std::path::PathBuf;

#[derive(Debug, Serialize, Deserialize)]
pub struct UpdateResult {
    pub updated: bool,
    pub message: String,
}

// Platform-specific library file extensions
#[cfg(target_os = "linux")]
const LIB_EXTENSION: &str = "so";
#[cfg(target_os = "macos")]
const LIB_EXTENSION: &str = "dylib";
#[cfg(target_os = "windows")]
const LIB_EXTENSION: &str = "dll";

// Platform-specific URL field names in version JSON
#[cfg(target_os = "linux")]
const URL_FIELD: &str = "linux_url";
#[cfg(target_os = "macos")]
const URL_FIELD: &str = "mac_url";
#[cfg(target_os = "windows")]
const URL_FIELD: &str = "windows_url";

/// Check and update libstudy for the current platform
/// Currently only supported on Linux, but prepared for macOS/Windows
pub async fn check_and_update(
    current_version_map: serde_json::Value,
    latest_version_map: serde_json::Value,
    app_data_dir: PathBuf,
) -> Result<UpdateResult> {
    let current_version = current_version_map
        .get("data")
        .and_then(|d| d.get("version"))
        .and_then(|v| v.as_str())
        .unwrap_or("0.0.0");

    let latest_version = latest_version_map
        .get("data")
        .and_then(|d| d.get("version"))
        .and_then(|v| v.as_str())
        .unwrap_or("0.0.0");

    log::info!(
        "Checking libstudy update: current={}, latest={}",
        current_version,
        latest_version
    );

    if current_version >= latest_version {
        return Ok(UpdateResult {
            updated: false,
            message: format!("Already up to date ({})", current_version),
        });
    }

    let download_url = latest_version_map
        .get("data")
        .and_then(|d| d.get(URL_FIELD))
        .or_else(|| latest_version_map.get("data").and_then(|d| d.get("url")))
        .and_then(|u| u.as_str());

    if download_url.is_none() {
        return Ok(UpdateResult {
            updated: false,
            message: format!("No download URL found ({}) in latest version", URL_FIELD),
        });
    }

    let download_url = download_url.unwrap();
    log::info!("Downloading libstudy from: {}", download_url);

    let response = reqwest::get(download_url).await?;
    let bytes = response.bytes().await?;

    let lib_filename = format!("libstudy.{}", LIB_EXTENSION);
    let lib_path = app_data_dir.join(&lib_filename);
    std::fs::write(&lib_path, bytes)?;

    log::info!("libstudy updated to {} at {:?}", latest_version, lib_path);

    Ok(UpdateResult {
        updated: true,
        message: format!(
            "Updated from {} to {}",
            current_version, latest_version
        ),
    })
}
