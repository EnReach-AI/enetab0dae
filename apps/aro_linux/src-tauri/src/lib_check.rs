use anyhow::Result;
use serde::{Deserialize, Serialize};
use std::cmp::Ordering;
use std::path::PathBuf;
use std::{fs, io::Cursor};

use semver::Version;

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
    let current_version = extract_version(&current_version_map);
    let latest_version = extract_version(&latest_version_map);

    // If we can't determine versions, do not update (safe default).
    // This prevents accidental downgrades (e.g. treating current as 0.0.0).
    let (Some(current_version), Some(latest_version)) = (current_version, latest_version) else {
        log::warn!(
            "libstudy update: unable to extract versions; skipping update. current.data={:?} latest.data={:?}",
            current_version_map.get("data"),
            latest_version_map.get("data")
        );
        return Ok(UpdateResult {
            updated: false,
            message: "Unable to determine current/latest version; skipping update".to_string(),
        });
    };

    log::info!(
        "Checking libstudy update: current={}, latest={}",
        current_version,
        latest_version
    );

    // Compare versions using semver when possible. Never downgrade.
    match compare_versions(&current_version, &latest_version) {
        Some(Ordering::Less) => {
            // ok, proceed with update
        }
        Some(Ordering::Equal) => {
            log::info!("libstudy update: skip (already up to date): current==latest=={}", current_version);
            return Ok(UpdateResult {
                updated: false,
                message: format!("Already up to date ({})", current_version),
            });
        }
        Some(Ordering::Greater) => {
            log::warn!(
                "libstudy update: skip (downgrade prevented): current={} latest={}",
                current_version,
                latest_version
            );
            return Ok(UpdateResult {
                updated: false,
                message: format!(
                    "Downgrade prevented (current {} > latest {})",
                    current_version, latest_version
                ),
            });
        }
        None => {
            log::warn!(
                "libstudy update: unable to compare versions (non-semver); skipping update. current={} latest={}",
                current_version,
                latest_version
            );
            return Ok(UpdateResult {
                updated: false,
                message: "Unable to compare versions; skipping update".to_string(),
            });
        }
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

    // Ensure directory exists.
    fs::create_dir_all(&app_data_dir)?;

    // Write atomically via temp path.
    let tmp_path = app_data_dir.join(format!("{}.tmp", lib_filename));

    if download_url.ends_with(".zip") {
        let extracted = extract_lib_from_zip(&bytes, &lib_filename)?;
        fs::write(&tmp_path, extracted)?;
    } else {
        fs::write(&tmp_path, &bytes)?;
    }

    // Replace existing library.
    fs::rename(&tmp_path, &lib_path).or_else(|_| {
        // Cross-device rename fallback.
        fs::copy(&tmp_path, &lib_path)?;
        fs::remove_file(&tmp_path)?;
        Ok(())
    })?;

    log::info!("libstudy updated to {} at {:?}", latest_version, lib_path);

    Ok(UpdateResult {
        updated: true,
        message: format!("Updated from {} to {}", current_version, latest_version),
    })
}

fn extract_version(map: &serde_json::Value) -> Option<String> {
    // Common shapes we have seen:
    // 1) {"code":200, "data":"0.0.7"}
    // 2) {"code":200, "data":{"version":"0.0.3", ... }}
    // 3) {"code":200, "data":{"data":"0.0.7"}} (nested variants)
    let data = map.get("data")?;

    let raw = match data {
        serde_json::Value::String(s) => s.as_str(),
        serde_json::Value::Number(n) => return Some(n.to_string()),
        serde_json::Value::Object(obj) => {
            if let Some(serde_json::Value::String(s)) = obj.get("version") {
                s.as_str()
            } else if let Some(serde_json::Value::String(s)) = obj.get("data") {
                s.as_str()
            } else {
                return None;
            }
        }
        _ => return None,
    };

    let normalized = normalize_version(raw).to_string();
    (!normalized.is_empty()).then_some(normalized)
}

fn normalize_version(v: &str) -> &str {
    v.trim().strip_prefix('v').unwrap_or(v.trim())
}

fn compare_versions(current: &str, latest: &str) -> Option<Ordering> {
    let current_n = normalize_version(current);
    let latest_n = normalize_version(latest);

    match (Version::parse(current_n), Version::parse(latest_n)) {
        (Ok(c), Ok(l)) => Some(c.cmp(&l)),
        _ => None,
    }
}

fn extract_lib_from_zip(bytes: &bytes::Bytes, expected_filename: &str) -> Result<Vec<u8>> {
    let reader = Cursor::new(bytes);
    let mut zip = zip::ZipArchive::new(reader)?;

    // Prefer exact match (libstudy.so/dylib/dll), otherwise first file that ends with it.
    for i in 0..zip.len() {
        let mut file = zip.by_index(i)?;
        if file.is_dir() {
            continue;
        }
        let name = file.name().to_string();
        let base = name.split('/').last().unwrap_or(&name);
        if base == expected_filename {
            let mut out = Vec::new();
            std::io::copy(&mut file, &mut out)?;
            return Ok(out);
        }
    }

    for i in 0..zip.len() {
        let mut file = zip.by_index(i)?;
        if file.is_dir() {
            continue;
        }
        let name = file.name().to_string();
        if name.ends_with(expected_filename) {
            let mut out = Vec::new();
            std::io::copy(&mut file, &mut out)?;
            return Ok(out);
        }
    }

    Err(anyhow::anyhow!(
        "zip did not contain expected library file {}",
        expected_filename
    ))
}
