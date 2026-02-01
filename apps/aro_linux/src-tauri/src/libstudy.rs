use std::{
  env,
  ffi::{CStr, CString},
  os::raw::c_char,
  path::{Path, PathBuf},
  sync::{Mutex, OnceLock},
};

use libloading::Library;

type CStrReturnFn = unsafe extern "C" fn() -> *mut c_char;
type CStrArgReturnFn = unsafe extern "C" fn(*const c_char) -> *mut c_char;

pub struct Libstudy {
  _lib: Library,
  init_libstudy: CStrArgReturnFn,
  get_last_version: CStrReturnFn,
  cleanup: CStrReturnFn,
}

impl Libstudy {
  pub fn load(path: &Path) -> anyhow::Result<Self> {
    let lib = unsafe { Library::new(path) };
    let lib = lib.map_err(|e| anyhow::anyhow!("failed to load {:?}: {}", path, e))?;

    unsafe {
      let init_libstudy = *lib
        .get::<CStrArgReturnFn>(b"InitLibstudy\0")
        .map_err(|e| anyhow::anyhow!("missing symbol InitLibstudy: {}", e))?;
      let get_last_version = *lib
        .get::<CStrReturnFn>(b"GetLastVersion\0")
        .map_err(|e| anyhow::anyhow!("missing symbol GetLastVersion: {}", e))?;
      let cleanup = *lib
        .get::<CStrReturnFn>(b"Cleanup\0")
        .map_err(|e| anyhow::anyhow!("missing symbol Cleanup: {}", e))?;

      Ok(Self {
        _lib: lib,
        init_libstudy,
        get_last_version,
        cleanup,
      })
    }
  }

  fn platform_lib_filename() -> &'static str {
    #[cfg(target_os = "windows")]
    {
      return "libstudy.dll";
    }
    #[cfg(target_os = "macos")]
    {
      return "libstudy.dylib";
    }
    #[cfg(not(any(target_os = "windows", target_os = "macos")))]
    {
      return "libstudy.so";
    }
  }

  fn push_if_set(paths: &mut Vec<PathBuf>, v: Option<PathBuf>) {
    if let Some(p) = v {
      paths.push(p);
    }
  }

  fn exe_dir() -> Option<PathBuf> {
    env::current_exe().ok().and_then(|p| p.parent().map(|d| d.to_path_buf()))
  }

  pub fn candidate_paths(override_path: Option<PathBuf>) -> Vec<PathBuf> {
    let mut paths = Vec::new();

    // 1) runtime override (like Flutter StudyLibrary.setOverridePath)
    Self::push_if_set(&mut paths, override_path);

    // 2) environment override
    if let Ok(p) = env::var("LIBSTUDY_PATH") {
      if !p.trim().is_empty() {
        paths.push(PathBuf::from(p));
      }
    }

    let lib_name = Self::platform_lib_filename();

    // 3) near executable (mirrors Flutter candidates)
    if let Some(exe_dir) = Self::exe_dir() {
      #[cfg(target_os = "linux")]
      {
        paths.push(exe_dir.join("lib").join(lib_name));
        paths.push(exe_dir.join(lib_name));
        paths.push(exe_dir.join("resources").join(lib_name));
        // some bundles place resources one level up
        paths.push(exe_dir.join("..",).join("resources").join(lib_name));
      }

      #[cfg(target_os = "windows")]
      {
        paths.push(exe_dir.join(lib_name));
        // common tauri bundle layout
        paths.push(exe_dir.join("resources").join(lib_name));
      }

      #[cfg(target_os = "macos")]
      {
        // Typical macOS bundle layout (similar to Flutter):
        // MyApp.app/Contents/MacOS/<bin> -> Frameworks/
        paths.push(exe_dir.join(".." ).join(".." ).join("Frameworks").join(lib_name));
        paths.push(exe_dir.join(".." ).join("Frameworks").join(lib_name));
        paths.push(exe_dir.join(lib_name));
      }
    }

    // 4) current dir and system lookup
    paths.push(PathBuf::from(format!("./{lib_name}")));
    paths.push(PathBuf::from(lib_name));

    // 5) dev repo layout (best-effort)
    #[cfg(target_os = "linux")]
    {
      paths.push(PathBuf::from("../plugins/linux/libstudy.so"));
      paths.push(PathBuf::from("../../plugins/linux/libstudy.so"));
      paths.push(PathBuf::from("../../../plugins/linux/libstudy.so"));
      paths.push(PathBuf::from("../../../plugins/linux-arm64/libstudy.so"));
    }
    #[cfg(target_os = "macos")]
    {
      paths.push(PathBuf::from("../../../plugins/macos/libstudy.dylib"));
    }
    #[cfg(target_os = "windows")]
    {
      paths.push(PathBuf::from("../../../plugins/windows/libstudy.dll"));
    }

    // 6) resource directory inside this crate (when build.rs copies into src-tauri/resources)
    paths.push(PathBuf::from(format!("resources/{lib_name}")));

    paths
  }

  pub fn try_load_with_paths(paths: Vec<PathBuf>) -> anyhow::Result<(Self, PathBuf)> {
    let mut tried: Vec<String> = Vec::new();
    for p in paths {
      tried.push(p.display().to_string());
      if p.exists() {
        let lib = Self::load(&p)?;
        return Ok((lib, p));
      }
    }

    Err(anyhow::anyhow!(
      "libstudy not found. Tried:\n{}\nTip: set LIBSTUDY_PATH to an absolute path.",
      tried.join("\n")
    ))
  }

  pub fn try_load_default() -> anyhow::Result<(Self, PathBuf)> {
    Self::try_load_with_paths(Self::candidate_paths(None))
  }

  pub fn init(&self, init_params_json: &str) -> anyhow::Result<String> {
    let c = CString::new(init_params_json)?;
    unsafe { call_c_string_with_arg(self.init_libstudy, c.as_ptr()) }
  }

  pub fn get_last_version(&self) -> anyhow::Result<String> {
    unsafe { call_c_string(self.get_last_version) }
  }

  pub fn cleanup(&self) -> anyhow::Result<String> {
    unsafe { call_c_string(self.cleanup) }
  }
}

#[derive(Default)]
struct LibstudyState {
  loaded: Option<(Libstudy, PathBuf)>,
  override_path: Option<PathBuf>,
}

static STATE: OnceLock<Mutex<LibstudyState>> = OnceLock::new();

fn state() -> &'static Mutex<LibstudyState> {
  STATE.get_or_init(|| Mutex::new(LibstudyState::default()))
}

pub fn set_override_path(path: Option<PathBuf>) {
  let mut s = state().lock().expect("libstudy state lock poisoned");
  s.override_path = path;
  // allow re-load from the new location next call
  s.loaded = None;
}

pub fn with_lib<T>(f: impl FnOnce(&Libstudy, &Path) -> anyhow::Result<T>) -> anyhow::Result<T> {
  let mut s = state().lock().expect("libstudy state lock poisoned");
  if s.loaded.is_none() {
    let paths = Libstudy::candidate_paths(s.override_path.clone());
    s.loaded = Some(Libstudy::try_load_with_paths(paths)?);
  }
  let (lib, path) = s.loaded.as_ref().expect("just loaded");
  f(lib, path)
}

pub fn info() -> anyhow::Result<(bool, Option<PathBuf>)> {
  let s = state().lock().expect("libstudy state lock poisoned");
  Ok((s.loaded.is_some(), s.loaded.as_ref().map(|(_, p)| p.clone())))
}

unsafe fn call_c_string(func: CStrReturnFn) -> anyhow::Result<String> {
  let ptr = func();
  if ptr.is_null() {
    return Err(anyhow::anyhow!("native call returned NULL"));
  }

  let s = CStr::from_ptr(ptr).to_string_lossy().to_string();
  libc::free(ptr as *mut libc::c_void);
  Ok(s)
}

unsafe fn call_c_string_with_arg(func: CStrArgReturnFn, arg: *const c_char) -> anyhow::Result<String> {
  let ptr = func(arg);
  if ptr.is_null() {
    return Err(anyhow::anyhow!("native call returned NULL"));
  }

  let s = CStr::from_ptr(ptr).to_string_lossy().to_string();
  libc::free(ptr as *mut libc::c_void);
  Ok(s)
}
