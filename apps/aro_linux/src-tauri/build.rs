use std::{
  env,
  fs,
  path::{Path, PathBuf},
};

fn main() {
  // Best-effort: copy libstudy from repo plugins/ into src-tauri/resources/ so bundling can include it.
  // This mirrors the Flutter build that installs libstudy next to the executable.
  if let Err(e) = copy_libstudy_into_resources() {
    println!("cargo:warning=libstudy copy skipped: {e}");
  }

  tauri_build::build()
}

fn copy_libstudy_into_resources() -> anyhow::Result<()> {
  let manifest_dir = PathBuf::from(env::var("CARGO_MANIFEST_DIR")?);
  let resources_dir = manifest_dir.join("resources");
  fs::create_dir_all(&resources_dir)?;

  let target_os = env::var("CARGO_CFG_TARGET_OS").unwrap_or_default();
  let target_arch = env::var("CARGO_CFG_TARGET_ARCH").unwrap_or_default();

  let (plugin_subdir, filename) = match target_os.as_str() {
    "linux" => {
      let dir = if target_arch == "aarch64" {
        "linux-arm64"
      } else {
        "linux"
      };
      (dir, "libstudy.so")
    }
    "macos" => ("macos", "libstudy.dylib"),
    "windows" => ("windows", "libstudy.dll"),
    other => return Err(anyhow::anyhow!("unsupported target OS for libstudy copy: {other}")),
  };

  let repo_root = manifest_dir
    .parent()
    .and_then(|p| p.parent())
    .and_then(|p| p.parent())
    .ok_or_else(|| anyhow::anyhow!("failed to resolve repo root from {manifest_dir:?}"))?;

  let src = repo_root.join("plugins").join(plugin_subdir).join(filename);
  let dst = resources_dir.join(filename);

  if !src.exists() {
    return Err(anyhow::anyhow!("{src:?} does not exist"));
  }

  // Avoid touching the file if unchanged.
  if same_file_contents(&src, &dst).unwrap_or(false) {
    return Ok(());
  }

  fs::copy(&src, &dst)?;
  Ok(())
}

fn same_file_contents(a: &Path, b: &Path) -> std::io::Result<bool> {
  if !b.exists() {
    return Ok(false);
  }
  let am = fs::metadata(a)?;
  let bm = fs::metadata(b)?;
  if am.len() != bm.len() {
    return Ok(false);
  }
  // Fast-path: same size; do a byte compare.
  Ok(fs::read(a)? == fs::read(b)?)
}
