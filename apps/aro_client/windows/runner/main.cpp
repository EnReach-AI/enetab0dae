#include <flutter/dart_project.h>
#include <flutter/flutter_view_controller.h>
#include <windows.h>

#include <algorithm>

#include "flutter_window.h"
#include "utils.h"

namespace {
// Used by the Windows installer/uninstaller to detect whether the app is
// currently running.
constexpr const wchar_t kAroAppMutexName[] = L"AROClientMutex";
HANDLE g_aro_app_mutex = nullptr;

constexpr const wchar_t kFlutterWindowClassName[] = L"FLUTTER_RUNNER_WIN32_WINDOW";
constexpr const wchar_t kMainWindowTitle[] = L"ARO Desktop";

bool HasArg(const std::vector<std::string>& args, const char* flag) {
  return std::find(args.begin(), args.end(), std::string(flag)) != args.end();
}

void ActivateExistingInstance() {
  HWND hwnd = ::FindWindowW(kFlutterWindowClassName, kMainWindowTitle);
  if (!hwnd) {
    // Fallback: find by title only.
    hwnd = ::FindWindowW(nullptr, kMainWindowTitle);
  }
  if (!hwnd) {
    return;
  }

  ::ShowWindow(hwnd, SW_RESTORE);
  ::SetForegroundWindow(hwnd);
}
}  // namespace

int APIENTRY wWinMain(_In_ HINSTANCE instance, _In_opt_ HINSTANCE prev,
                      _In_ wchar_t *command_line, _In_ int show_command) {
  // Read args early (used for single-instance/restart flow).
  std::vector<std::string> command_line_arguments = GetCommandLineArguments();

  // Create a named mutex for single-instance + uninstall detection.
  // We create it with initial ownership so a restart can wait for release.
  g_aro_app_mutex = ::CreateMutexW(nullptr, TRUE, kAroAppMutexName);
  const DWORD mutex_error = ::GetLastError();

  if (mutex_error == ERROR_ALREADY_EXISTS) {
    if (HasArg(command_line_arguments, "--wait-for-single-instance")) {
      // Restart path: wait until the previous instance releases the mutex.
      DWORD wait_result = ::WaitForSingleObject(g_aro_app_mutex, 30000);
      if (wait_result != WAIT_OBJECT_0 && wait_result != WAIT_ABANDONED) {
        ActivateExistingInstance();
        return EXIT_SUCCESS;
      }
    } else {
      // Normal second launch: activate existing window and exit.
      ActivateExistingInstance();
      return EXIT_SUCCESS;
    }
  }

  // Attach to console when present (e.g., 'flutter run') or create a
  // new console when running with a debugger.
  if (!::AttachConsole(ATTACH_PARENT_PROCESS) && ::IsDebuggerPresent()) {
    CreateAndAttachConsole();
  }

  // Initialize COM, so that it is available for use in the library and/or
  // plugins.
  ::CoInitializeEx(nullptr, COINIT_APARTMENTTHREADED);

  flutter::DartProject project(L"data");

  project.set_dart_entrypoint_arguments(std::move(command_line_arguments));

  FlutterWindow window(project);
  Win32Window::Point origin(10, 10);
  Win32Window::Size size(1280, 720);
  if (!window.Create(kMainWindowTitle, origin, size)) {
    return EXIT_FAILURE;
  }
  window.SetQuitOnClose(true);

  ::MSG msg;
  while (::GetMessage(&msg, nullptr, 0, 0)) {
    ::TranslateMessage(&msg);
    ::DispatchMessage(&msg);
  }

  if (g_aro_app_mutex) {
    ::ReleaseMutex(g_aro_app_mutex);
    ::CloseHandle(g_aro_app_mutex);
    g_aro_app_mutex = nullptr;
  }

  ::CoUninitialize();
  return EXIT_SUCCESS;
}
