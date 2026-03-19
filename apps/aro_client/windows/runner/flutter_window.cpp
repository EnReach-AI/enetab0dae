#include "flutter_window.h"

#include <filesystem>
#include <optional>
#include <shellapi.h>
#include <string>

#include <flutter/standard_method_codec.h>

#include "flutter/generated_plugin_registrant.h"

namespace {

const flutter::EncodableValue* ValueOrNull(const flutter::EncodableMap& map,
                                           const char* key) {
  auto it = map.find(flutter::EncodableValue(key));
  if (it == map.end()) {
    return nullptr;
  }
  return &it->second;
}

std::wstring Utf8ToWide(const std::string& value) {
  if (value.empty()) {
    return std::wstring();
  }

  const int size_needed = MultiByteToWideChar(
      CP_UTF8, 0, value.c_str(), static_cast<int>(value.size()), nullptr, 0);
  if (size_needed <= 0) {
    return std::wstring(value.begin(), value.end());
  }

  std::wstring wide(size_needed, L'\0');
  MultiByteToWideChar(CP_UTF8, 0, value.c_str(), static_cast<int>(value.size()),
                      &wide[0], size_needed);
  return wide;
}

std::filesystem::path GetExecutableDirectory() {
  wchar_t module_path[MAX_PATH];
  const DWORD length =
      ::GetModuleFileNameW(nullptr, module_path, MAX_PATH);
  if (length == 0 || length >= MAX_PATH) {
    return std::filesystem::current_path();
  }

  return std::filesystem::path(std::wstring(module_path, length)).parent_path();
}

}  // namespace

FlutterWindow::FlutterWindow(const flutter::DartProject& project)
    : project_(project) {}

FlutterWindow::~FlutterWindow() {}

void FlutterWindow::RegisterWindowChannel() {
  windows_channel_ =
      std::make_unique<flutter::MethodChannel<flutter::EncodableValue>>(
          flutter_controller_->engine()->messenger(),
          "com.aro.aro_app/windows",
          &flutter::StandardMethodCodec::GetInstance());

  windows_channel_->SetMethodCallHandler(
      [this](const flutter::MethodCall<flutter::EncodableValue>& call,
             std::unique_ptr<flutter::MethodResult<flutter::EncodableValue>>
                 result) {
        if (call.method_name() == "setConnectivityState") {
          bool offline = false;

          if (const auto* args =
                  std::get_if<flutter::EncodableMap>(call.arguments())) {
            if (const auto* offline_value =
                    std::get_if<bool>(ValueOrNull(*args, "offline"))) {
              offline = *offline_value;
            }
          }

          SetConnectivityState(offline);
          result->Success(flutter::EncodableValue(true));
          return;
        }

        if (call.method_name() != "showBackgroundNotification") {
          result->NotImplemented();
          return;
        }

        std::string title = "ARO Desktop";
        std::string body = "ARO Desktop is still running in the background.";

        if (const auto* args =
                std::get_if<flutter::EncodableMap>(call.arguments())) {
          if (const auto* title_value =
                  std::get_if<std::string>(ValueOrNull(*args, "title"))) {
            title = *title_value;
          }
          if (const auto* body_value =
                  std::get_if<std::string>(ValueOrNull(*args, "body"))) {
            body = *body_value;
          }
        }

        ShowTrayNotification(title, body);
        result->Success(flutter::EncodableValue(true));
      });
}

std::wstring FlutterWindow::ResolveConnectivityIconPath(bool offline) const {
  const auto icon_path = GetExecutableDirectory() / L"resources" /
                         (offline ? L"app_icon_offline.ico" : L"app_icon.ico");
  return icon_path.wstring();
}

void FlutterWindow::DisposeWindowIcons() {
  if (large_window_icon_ != nullptr) {
    ::DestroyIcon(large_window_icon_);
    large_window_icon_ = nullptr;
  }

  if (small_window_icon_ != nullptr) {
    ::DestroyIcon(small_window_icon_);
    small_window_icon_ = nullptr;
  }
}

void FlutterWindow::SetConnectivityState(bool offline) {
  if (GetHandle() == nullptr) {
    return;
  }

  const std::wstring icon_path = ResolveConnectivityIconPath(offline);
  HICON large_icon = static_cast<HICON>(::LoadImageW(
      nullptr, icon_path.c_str(), IMAGE_ICON, ::GetSystemMetrics(SM_CXICON),
      ::GetSystemMetrics(SM_CYICON), LR_DEFAULTCOLOR | LR_LOADFROMFILE));
  HICON small_icon = static_cast<HICON>(::LoadImageW(
      nullptr, icon_path.c_str(), IMAGE_ICON,
      ::GetSystemMetrics(SM_CXSMICON), ::GetSystemMetrics(SM_CYSMICON),
      LR_DEFAULTCOLOR | LR_LOADFROMFILE));

  if (large_icon == nullptr && small_icon == nullptr) {
    return;
  }

  if (large_icon != nullptr) {
    ::SendMessage(GetHandle(), WM_SETICON, ICON_BIG,
                  reinterpret_cast<LPARAM>(large_icon));
  }
  if (small_icon != nullptr) {
    ::SendMessage(GetHandle(), WM_SETICON, ICON_SMALL,
                  reinterpret_cast<LPARAM>(small_icon));
  }

  DisposeWindowIcons();
  large_window_icon_ = large_icon;
  small_window_icon_ = small_icon;
}

void FlutterWindow::ShowTrayNotification(const std::string& title,
                                         const std::string& body) {
  NOTIFYICONDATAW nid = {};
  nid.cbSize = sizeof(NOTIFYICONDATAW);
  nid.hWnd = GetHandle();
  nid.uID = 1;
  nid.uFlags = NIF_INFO;
  nid.dwInfoFlags = NIIF_INFO | NIIF_NOSOUND;

  const std::wstring wide_title = Utf8ToWide(title);
  const std::wstring wide_body = Utf8ToWide(body);

  wcsncpy_s(nid.szInfoTitle, _countof(nid.szInfoTitle), wide_title.c_str(),
            _TRUNCATE);
  wcsncpy_s(nid.szInfo, _countof(nid.szInfo), wide_body.c_str(), _TRUNCATE);

  Shell_NotifyIconW(NIM_MODIFY, &nid);
}

bool FlutterWindow::OnCreate() {
  if (!Win32Window::OnCreate()) {
    return false;
  }

  RECT frame = GetClientArea();

  // The size here must match the window dimensions to avoid unnecessary surface
  // creation / destruction in the startup path.
  flutter_controller_ = std::make_unique<flutter::FlutterViewController>(
      frame.right - frame.left, frame.bottom - frame.top, project_);
  // Ensure that basic setup of the controller was successful.
  if (!flutter_controller_->engine() || !flutter_controller_->view()) {
    return false;
  }
  RegisterPlugins(flutter_controller_->engine());
  RegisterWindowChannel();
  SetChildContent(flutter_controller_->view()->GetNativeWindow());

  this->Show();
  SetConnectivityState(false);

  // Flutter can complete the first frame before the "show window" callback is
  // registered. The following call ensures a frame is pending to ensure the
  // window is shown. It is a no-op if the first frame hasn't completed yet.
  flutter_controller_->ForceRedraw();

  return true;
}

void FlutterWindow::OnDestroy() {
  DisposeWindowIcons();

  if (flutter_controller_) {
    flutter_controller_ = nullptr;
  }

  Win32Window::OnDestroy();
}

LRESULT
FlutterWindow::MessageHandler(HWND hwnd, UINT const message,
                              WPARAM const wparam,
                              LPARAM const lparam) noexcept {
  // Give Flutter, including plugins, an opportunity to handle window messages.
  if (flutter_controller_) {
    std::optional<LRESULT> result =
        flutter_controller_->HandleTopLevelWindowProc(hwnd, message, wparam,
                                                      lparam);
    if (result) {
      return *result;
    }
  }

  switch (message) {
    case WM_FONTCHANGE:
      flutter_controller_->engine()->ReloadSystemFonts();
      break;
  }

  return Win32Window::MessageHandler(hwnd, message, wparam, lparam);
}
