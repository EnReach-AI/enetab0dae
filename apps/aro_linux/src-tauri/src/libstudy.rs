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
  node_sign_up: CStrReturnFn,
  node_report_base_info: CStrArgReturnFn,
  get_node_stat: CStrReturnFn,
  get_rewards: CStrReturnFn,
  init_libstudy: CStrArgReturnFn,
  get_ws_client_status: Option<CStrReturnFn>,
  start_ws_client: Option<CStrReturnFn>,
  get_current_version: CStrReturnFn,
  get_last_version: CStrReturnFn,
  start_proxy_worker: CStrArgReturnFn,
  stop_proxy_worker: CStrReturnFn,
  get_proxy_worker_status: CStrReturnFn,
  restart_proxy_worker: CStrReturnFn,
  is_proxy_worker_running: CStrReturnFn,
  cleanup: CStrReturnFn,
}

impl Libstudy {
  pub fn load(path: &Path) -> anyhow::Result<Self> {
    let lib = unsafe { Library::new(path) };
    let lib = lib.map_err(|e| {
      log::error!(
        "libstudy: failed to load dynamic library path={:?} err={} diagnostics={} ",
        path,
        e,
        load_diagnostics(path)
      );
      anyhow::anyhow!("failed to load {:?}: {}", path, e)
    })?;

    unsafe {
      let node_sign_up = *lib
        .get::<CStrReturnFn>(b"NodeSignUp\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol NodeSignUp path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol NodeSignUp: {}", e)
        })?;
      let node_report_base_info = *lib
        .get::<CStrArgReturnFn>(b"NodeReportBaseInfo\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol NodeReportBaseInfo path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol NodeReportBaseInfo: {}", e)
        })?;
      let get_node_stat = *lib
        .get::<CStrReturnFn>(b"GetNodeStat\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol GetNodeStat path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol GetNodeStat: {}", e)
        })?;
      let get_rewards = *lib
        .get::<CStrReturnFn>(b"GetRewards\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol GetRewards path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol GetRewards: {}", e)
        })?;

      let init_libstudy = *lib
        .get::<CStrArgReturnFn>(b"InitLibstudy\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol InitLibstudy path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol InitLibstudy: {}", e)
        })?;

      let get_ws_client_status = lib
        .get::<CStrReturnFn>(b"GetWSClientStatus\0")
        .ok()
        .map(|s| *s);
      let start_ws_client = lib
        .get::<CStrReturnFn>(b"StartWSClient\0")
        .ok()
        .map(|s| *s);

      let get_current_version = *lib
        .get::<CStrReturnFn>(b"GetCurrentVersion\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol GetCurrentVersion path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol GetCurrentVersion: {}", e)
        })?;
      let get_last_version = *lib
        .get::<CStrReturnFn>(b"GetLastVersion\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol GetLastVersion path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol GetLastVersion: {}", e)
        })?;

      let start_proxy_worker = *lib
        .get::<CStrArgReturnFn>(b"StartProxyWorker\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol StartProxyWorker path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol StartProxyWorker: {}", e)
        })?;
      let stop_proxy_worker = *lib
        .get::<CStrReturnFn>(b"StopProxyWorker\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol StopProxyWorker path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol StopProxyWorker: {}", e)
        })?;
      let get_proxy_worker_status = *lib
        .get::<CStrReturnFn>(b"GetProxyWorkerStatus\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol GetProxyWorkerStatus path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol GetProxyWorkerStatus: {}", e)
        })?;
      let restart_proxy_worker = *lib
        .get::<CStrReturnFn>(b"RestartProxyWorker\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol RestartProxyWorker path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol RestartProxyWorker: {}", e)
        })?;
      let is_proxy_worker_running = *lib
        .get::<CStrReturnFn>(b"IsProxyWorkerRunning\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol IsProxyWorkerRunning path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol IsProxyWorkerRunning: {}", e)
        })?;

      let cleanup = *lib
        .get::<CStrReturnFn>(b"Cleanup\0")
        .map_err(|e| {
          log::error!("libstudy: missing symbol Cleanup path={:?} err={}", path, e);
          anyhow::anyhow!("missing symbol Cleanup: {}", e)
        })?;

      Ok(Self {
        _lib: lib,
        node_sign_up,
        node_report_base_info,
        get_node_stat,
        get_rewards,
        init_libstudy,
        get_ws_client_status,
        start_ws_client,
        get_current_version,
        get_last_version,
        start_proxy_worker,
        stop_proxy_worker,
        get_proxy_worker_status,
        restart_proxy_worker,
        is_proxy_worker_running,
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

    // Absolute repo-root candidates (dev builds). These remain valid even if the app changes the
    // current working directory (e.g. init_libstudy_auto chdir's into app_data_dir).
    // In release builds this path won't exist and is harmless.
    let manifest_dir = PathBuf::from(env!("CARGO_MANIFEST_DIR"));
    let repo_root_from_manifest = manifest_dir.join("..").join("..").join("..");

    // 3) near executable (mirrors Flutter candidates)
    if let Some(exe_dir) = Self::exe_dir() {
      #[cfg(target_os = "linux")]
      {
        // Tauri Linux bundle layout: exe at /usr/bin/app, resources at /usr/lib/ARO Desktop/resources/
        paths.push(PathBuf::from("/usr/lib/ARO Desktop/resources").join(lib_name));
        
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
        // Some bundles place resources at Contents/Resources
        paths.push(exe_dir.join(".." ).join("Resources").join(lib_name));
        paths.push(exe_dir.join(lib_name));
      }
    }

    // 4) current dir and system lookup
    paths.push(PathBuf::from(format!("./{lib_name}")));
    paths.push(PathBuf::from(lib_name));

    // 5) dev repo layout (best-effort)
    #[cfg(target_os = "linux")]
    {
      paths.push(repo_root_from_manifest.join("plugins").join("linux").join(lib_name));
      paths.push(repo_root_from_manifest.join("plugins").join("linux-arm64").join(lib_name));
      paths.push(PathBuf::from("../plugins/linux/libstudy.so"));
      paths.push(PathBuf::from("../../plugins/linux/libstudy.so"));
      paths.push(PathBuf::from("../../../plugins/linux/libstudy.so"));
      paths.push(PathBuf::from("../../../plugins/linux-arm64/libstudy.so"));
    }
    #[cfg(target_os = "macos")]
    {
      paths.push(repo_root_from_manifest.join("plugins").join("macos").join(lib_name));
      paths.push(PathBuf::from("../../../plugins/macos/libstudy.dylib"));
    }
    #[cfg(target_os = "windows")]
    {
      paths.push(repo_root_from_manifest.join("plugins").join("windows").join(lib_name));
      paths.push(PathBuf::from("../../../plugins/windows/libstudy.dll"));
    }

    // 6) resource directory inside this crate (when build.rs copies into src-tauri/resources)
    paths.push(PathBuf::from(format!("resources/{lib_name}")));

    paths
  }

  pub fn try_load_with_paths(paths: Vec<PathBuf>) -> anyhow::Result<(Self, PathBuf)> {
    let mut tried: Vec<String> = Vec::new();
    let mut errors: Vec<String> = Vec::new();

    for p in paths {
      let display = p.display().to_string();
      tried.push(display.clone());

      if !p.exists() {
        log::debug!("libstudy: candidate does not exist: {display}");
        continue;
      }

      log::info!("libstudy: trying to load candidate: {display}");
      match Self::load(&p) {
        Ok(lib) => {
          log::info!("libstudy: loaded OK from {display}");
          return Ok((lib, p));
        }
        Err(e) => {
          // Keep going: the file exists but may be incompatible (arch), missing dependencies,
          // or missing symbols.
          let err_line = format!("{display}: {e}");
          log::error!("libstudy: failed to load from {display}: {e:?}");
          errors.push(err_line);
          continue;
        }
      }
    }

    Err(anyhow::anyhow!(
      "libstudy not found / failed to load. Tried:\n{}\n\nErrors:\n{}\n\nTip: set LIBSTUDY_PATH to an absolute path.",
      tried.join("\n"),
      if errors.is_empty() { "<none>".to_string() } else { errors.join("\n") }
    ))
  }

  pub fn init(&self, init_params_json: &str) -> anyhow::Result<String> {
    let c = CString::new(init_params_json)?;
    unsafe { call_c_string_with_arg(self.init_libstudy, c.as_ptr()) }
  }

  pub fn node_sign_up(&self) -> anyhow::Result<String> {
    unsafe { call_c_string(self.node_sign_up) }
  }

  pub fn node_report_base_info(&self, sys_info_json: &str) -> anyhow::Result<String> {
    let c = CString::new(sys_info_json)?;
    unsafe { call_c_string_with_arg(self.node_report_base_info, c.as_ptr()) }
  }

  pub fn get_node_stat(&self) -> anyhow::Result<String> {
    unsafe { call_c_string(self.get_node_stat) }
  }

  pub fn get_rewards(&self) -> anyhow::Result<String> {
    unsafe { call_c_string(self.get_rewards) }
  }

  pub fn get_ws_client_status(&self) -> anyhow::Result<String> {
    let func = self
      .get_ws_client_status
      .ok_or_else(|| anyhow::anyhow!("missing symbol GetWSClientStatus (libstudy build may have it disabled)"))?;
    unsafe { call_c_string(func) }
  }

  pub fn start_ws_client(&self) -> anyhow::Result<String> {
    let func = self
      .start_ws_client
      .ok_or_else(|| anyhow::anyhow!("missing symbol StartWSClient (libstudy build may have it disabled)"))?;
    unsafe { call_c_string(func) }
  }

  pub fn get_current_version(&self) -> anyhow::Result<String> {
    unsafe { call_c_string(self.get_current_version) }
  }

  pub fn get_last_version(&self) -> anyhow::Result<String> {
    unsafe { call_c_string(self.get_last_version) }
  }

  pub fn start_proxy_worker(&self, config_json: &str) -> anyhow::Result<String> {
    let c = CString::new(config_json)?;
    unsafe { call_c_string_with_arg(self.start_proxy_worker, c.as_ptr()) }
  }

  pub fn stop_proxy_worker(&self) -> anyhow::Result<String> {
    unsafe { call_c_string(self.stop_proxy_worker) }
  }

  pub fn get_proxy_worker_status(&self) -> anyhow::Result<String> {
    unsafe { call_c_string(self.get_proxy_worker_status) }
  }

  pub fn restart_proxy_worker(&self) -> anyhow::Result<String> {
    unsafe { call_c_string(self.restart_proxy_worker) }
  }

  pub fn is_proxy_worker_running(&self) -> anyhow::Result<String> {
    unsafe { call_c_string(self.is_proxy_worker_running) }
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

fn load_diagnostics(path: &Path) -> String {
  let cwd = env::current_dir().ok();
  let exe = env::current_exe().ok();

  let mut env_bits: Vec<String> = Vec::new();
  #[cfg(target_os = "macos")]
  {
    for k in ["DYLD_LIBRARY_PATH", "DYLD_FALLBACK_LIBRARY_PATH"] {
      if let Ok(v) = env::var(k) {
        if !v.trim().is_empty() {
          env_bits.push(format!("{k}={v}"));
        }
      }
    }
  }
  #[cfg(target_os = "linux")]
  {
    for k in ["LD_LIBRARY_PATH"] {
      if let Ok(v) = env::var(k) {
        if !v.trim().is_empty() {
          env_bits.push(format!("{k}={v}"));
        }
      }
    }
  }
  #[cfg(target_os = "windows")]
  {
    for k in ["PATH"] {
      if let Ok(v) = env::var(k) {
        if !v.trim().is_empty() {
          env_bits.push(format!("{k}={v}"));
        }
      }
    }
  }

  format!(
    "cwd={:?} exe={:?} requested={:?} env=[{}]",
    cwd,
    exe,
    path,
    env_bits.join("; ")
  )
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
