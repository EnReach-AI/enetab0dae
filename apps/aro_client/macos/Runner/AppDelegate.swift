import Cocoa
import FlutterMacOS

@main
class AppDelegate: FlutterAppDelegate {

  var statusItem: NSStatusItem?

  override func applicationDidFinishLaunching(_ notification: Notification) {
    NSApp.setActivationPolicy(.regular)
    NSApp.activate(ignoringOtherApps: true)

    registerTray()
    registerFlutterChannel()

    super.applicationDidFinishLaunching(notification)
  }

  func registerTray() {
    statusItem = NSStatusBar.system.statusItem(withLength: NSStatusItem.variableLength)

    if let button = statusItem?.button {
      button.action = #selector(toggleWindow)
      button.target = self
      applyConnectivityState(offline: false)
    }

    let menu = NSMenu()
    menu.addItem(NSMenuItem(title: "Show", action: #selector(showApp), keyEquivalent: ""))
    menu.addItem(NSMenuItem(title: "Hide", action: #selector(hideToTray), keyEquivalent: ""))
    menu.addItem(NSMenuItem.separator())
    menu.addItem(NSMenuItem(title: "Quit", action: #selector(NSApplication.terminate(_:)), keyEquivalent: "q"))

    statusItem?.menu = menu
  }

  func registerFlutterChannel() {
    let controller = mainFlutterWindow?.contentViewController as! FlutterViewController
    let channel = FlutterMethodChannel(
      name: "app_mode",
      binaryMessenger: controller.engine.binaryMessenger
    )

    channel.setMethodCallHandler { call, result in
      switch call.method {
      case "hideToTray":
        self.hideToTray()
        result(nil)
      case "showApp":
        self.showApp()
        result(nil)
      case "setConnectivityState":
        let args = call.arguments as? [String: Any]
        let offline = args?["offline"] as? Bool ?? false
        DispatchQueue.main.async {
          self.applyConnectivityState(offline: offline)
          result(nil)
        }
      default:
        result(FlutterMethodNotImplemented)
      }
    }
  }

  func imageFromBundleAsset(named name: String) -> NSImage? {
    if let image = NSImage(named: NSImage.Name(name)) {
      return image.copy() as? NSImage ?? image
    }

    guard let url = Bundle.main.url(forResource: name, withExtension: "png") else {
      return nil
    }
    return NSImage(contentsOf: url)
  }

  func statusBarIconImage(offline: Bool) -> NSImage? {
    let image = imageFromBundleAsset(named: offline ? "OfflineAppIcon" : "AppIcon")
      ?? (offline ? imageFromBundleAsset(named: "TrayOffline") : nil)
      ?? imageFromBundleAsset(named: offline ? "app_icon_offline" : "app_icon")

    image?.size = NSSize(width: 18, height: 18)
    image?.isTemplate = false
    return image
  }

  func applicationIconImage(offline: Bool) -> NSImage? {
    imageFromBundleAsset(named: offline ? "OfflineAppIcon" : "AppIcon")
      ?? imageFromBundleAsset(named: offline ? "app_icon_offline" : "app_icon")
      ?? (offline ? imageFromBundleAsset(named: "TrayOffline") : nil)
      ?? NSWorkspace.shared.icon(forFile: Bundle.main.bundlePath)
  }

  func applyConnectivityState(offline: Bool) {
    if let button = statusItem?.button,
       let image = statusBarIconImage(offline: offline) {
      button.image = image
      button.imagePosition = .imageOnly
    }

    if let appIcon = applicationIconImage(offline: offline) {
      NSApp.applicationIconImage = appIcon
    }
  }

  @objc func hideToTray() {
    NSApp.setActivationPolicy(.accessory) 
    NSApp.hide(nil)
  }

  @objc func showApp() {
    NSApp.setActivationPolicy(.regular)  
    NSApp.activate(ignoringOtherApps: true)
    mainFlutterWindow?.makeKeyAndOrderFront(nil)
  }

  @objc func toggleWindow() {
    showApp()
  }
}
