import Cocoa
import FlutterMacOS

class MainFlutterWindow: NSWindow {
  override func awakeFromNib() {
    let flutterViewController = FlutterViewController()
    let windowFrame = self.frame
    self.contentViewController = flutterViewController
    self.setFrame(windowFrame, display: true)

    self.titleVisibility = .hidden
    self.titlebarAppearsTransparent = true
    self.isMovableByWindowBackground = true

    if let closeButton = standardWindowButton(.closeButton) {
        closeButton.isHidden = true
    }
    if let miniButton = standardWindowButton(.miniaturizeButton) {
        miniButton.isHidden = true
    }
    if let zoomButton = standardWindowButton(.zoomButton) {
        zoomButton.isHidden = true
    }

    self.styleMask.insert(.fullSizeContentView)

    RegisterGeneratedPlugins(registry: flutterViewController)
    super.awakeFromNib()
  }
}
