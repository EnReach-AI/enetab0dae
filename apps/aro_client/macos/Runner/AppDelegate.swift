import Cocoa
import FlutterMacOS

@main
class AppDelegate: FlutterAppDelegate, NSMenuDelegate {

  var statusItem: NSStatusItem?
  private var contextMenu: NSMenu!
  private var eventMonitor: Any?

  override func applicationDidFinishLaunching(_ notification: Notification) {
    // Start as accessory app (no Dock icon) — menu-bar-only style
    NSApp.setActivationPolicy(.accessory)

    registerTray()
    registerFlutterChannel()

    // Show the window below the tray icon on first launch
    DispatchQueue.main.async {
      self.showBelowTrayIcon()
    }

    super.applicationDidFinishLaunching(notification)
  }

  func registerTray() {
    statusItem = NSStatusBar.system.statusItem(withLength: NSStatusItem.variableLength)

    if let button = statusItem?.button {
      button.action = #selector(statusItemClicked(_:))
      button.target = self
      button.sendAction(on: [.leftMouseUp, .rightMouseUp])
      applyConnectivityState(offline: false)
    }

    // Build context menu (shown on right-click)
    contextMenu = NSMenu()
    contextMenu.delegate = self
    contextMenu.addItem(NSMenuItem(title: "Show", action: #selector(showApp), keyEquivalent: ""))
    contextMenu.addItem(NSMenuItem(title: "Hide", action: #selector(hideToTray), keyEquivalent: ""))
    contextMenu.addItem(NSMenuItem.separator())
    contextMenu.addItem(NSMenuItem(title: "Quit", action: #selector(NSApplication.terminate(_:)), keyEquivalent: "q"))
    // Do NOT assign statusItem?.menu — we handle clicks manually
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

  // MARK: - Status item click handling

  @objc func statusItemClicked(_ sender: NSStatusBarButton) {
    guard let event = NSApp.currentEvent else { return }

    if event.type == .rightMouseUp {
      // Right-click → show context menu
      statusItem?.menu = contextMenu
      statusItem?.button?.performClick(nil)
      // Clear the menu after it closes so left-click still triggers action
      return
    }

    // Left-click → toggle the window below the tray icon
    toggleWindow()
  }

  // Called when the right-click context menu closes
  func menuDidClose(_ menu: NSMenu) {
    // Remove the menu so subsequent left-clicks fire the button action
    statusItem?.menu = nil
  }

  // MARK: - Window positioning & toggling

  @objc func toggleWindow() {
    guard let window = mainFlutterWindow else { return }

    if window.isVisible {
      hideToTray()
    } else {
      showBelowTrayIcon()
    }
  }

  func showBelowTrayIcon() {
    guard let window = mainFlutterWindow else { return }

    positionWindowBelowStatusItem(window)

    window.level = .statusBar
    window.makeKeyAndOrderFront(nil)
    NSApp.activate(ignoringOtherApps: true)

    // Observe focus loss — hide window when the user clicks elsewhere
    removeEventMonitor()
    eventMonitor = NSEvent.addGlobalMonitorForEvents(
      matching: [.leftMouseDown, .rightMouseDown]
    ) { [weak self] _ in
      self?.hideToTray()
    }
  }

  @objc func hideToTray() {
    mainFlutterWindow?.orderOut(nil)
    removeEventMonitor()
  }

  @objc func showApp() {
    showBelowTrayIcon()
  }

  private func removeEventMonitor() {
    if let monitor = eventMonitor {
      NSEvent.removeMonitor(monitor)
      eventMonitor = nil
    }
  }

  /// Positions `window` centred horizontally beneath the status-bar button,
  /// with a small gap. Falls back to screen center if the button rect cannot
  /// be determined.
  private func positionWindowBelowStatusItem(_ window: NSWindow) {
    guard let button = statusItem?.button,
          let buttonWindow = button.window else {
      window.center()
      return
    }

    // Button frame in screen coordinates
    let buttonRect = button.convert(button.bounds, to: nil)
    let screenRect = buttonWindow.convertToScreen(buttonRect)

    let windowSize = window.frame.size
    let gap: CGFloat = 4 // pixels between menu bar and window

    let x = screenRect.midX - windowSize.width / 2
    let y = screenRect.minY - windowSize.height - gap

    // Keep within screen bounds
    if let screen = buttonWindow.screen ?? NSScreen.main {
      let visibleFrame = screen.visibleFrame
      let clampedX = max(visibleFrame.minX, min(x, visibleFrame.maxX - windowSize.width))
      let clampedY = max(visibleFrame.minY, min(y, visibleFrame.maxY - windowSize.height))
      window.setFrameOrigin(NSPoint(x: clampedX, y: clampedY))
    } else {
      window.setFrameOrigin(NSPoint(x: x, y: y))
    }
  }

  override func applicationWillTerminate(_ notification: Notification) {
    removeEventMonitor()
  }
}
