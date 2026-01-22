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
      button.image = NSImage(named: "AppIcon")
      button.action = #selector(toggleWindow)
    }

    let menu = NSMenu()
    menu.addItem(NSMenuItem(title: "Show", action: #selector(showApp), keyEquivalent: ""))
    menu.addItem(NSMenuItem(title: "Hidden", action: #selector(hideToTray), keyEquivalent: ""))
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
      default:
        result(FlutterMethodNotImplemented)
      }
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
