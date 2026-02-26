import 'dart:async';
import 'package:flutter/material.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';
import 'package:aro_client/components/path_provider.dart';
import 'package:aro_client/ffi/study_lib.dart';
import 'package:aro_client/ffi/study_service.dart';
import 'package:aro_client/services/AppServiceStarter.dart';
import 'package:aro_client/services/logger_service.dart';
import 'package:aro_client/services/lib_update_service.dart';
import 'package:aro_client/services/connectivity_service.dart';
import 'package:aro_client/utils/native_dialog.dart';
import 'package:window_manager/window_manager.dart';
import 'dart:io';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:tray_manager/tray_manager.dart';
import 'package:path/path.dart' as p;
import 'dart:convert';
import 'package:aro_client/utils/config.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart' as inapp;
import 'package:url_launcher/url_launcher.dart';

void main(List<String> args) async {
  runZonedGuarded(() async {
    WidgetsFlutterBinding.ensureInitialized();

    await LoggerService().initialize();
    LoggerService().info('App starting...');

    // Initialize connectivity service
    await ConnectivityService().initialize();

    try {
      if (Platform.isMacOS ||
          Platform.isAndroid ||
          Platform.isWindows ||
          Platform.isLinux) {
        final appSupportDir = await getAppSupportDir();
        String overrideFile;
        if (Platform.isMacOS) {
          overrideFile = 'libstudy.dylib';
        } else if (Platform.isWindows) {
          overrideFile = 'libstudy.dll';
        } else {
          overrideFile = 'libstudy.so';
        }
        final overridePath = p.join(appSupportDir, overrideFile);
        StudyLibrary.setOverridePath(overridePath);
      }
      StudyLibrary.ensureInitialized();
    } catch (e) {
      LoggerService().error('Native library initialization failed', e);
    }

    FlutterError.onError = (FlutterErrorDetails details) {
      FlutterError.presentError(details);
      LoggerService().error(
        'Flutter Error: ${details.exception}',
        details.exception,
        details.stack,
      );
    };

    PlatformDispatcher.instance.onError = (error, stack) {
      LoggerService().error('Async Error: $error', error, stack);
      return true;
    };

    if (Platform.isMacOS || Platform.isWindows || Platform.isLinux) {
      await windowManager.ensureInitialized();

      WindowOptions windowOptions = const WindowOptions(
        size: Size(360, 640),
        minimumSize: Size(360, 640),
        maximumSize: Size(360, 640),
      );

      windowManager.waitUntilReadyToShow(windowOptions, () async {
        await windowManager.show();
        try {
          await windowManager.setTitle('ARO Desktop');
        } catch (_) {}
        if (Platform.isWindows) {
          await windowManager.setMinimizable(false);
          await windowManager.setMaximizable(false);
          try {
            final exeDir = p.dirname(Platform.resolvedExecutable);
            final iconPath = p.join(exeDir, 'resources', 'app_icon.ico');
            await trayManager.setIcon(iconPath);
            await trayManager.setToolTip('ARO Desktop');
          } catch (e) {
            LoggerService().error('Failed to setup Windows tray icon', e);
          }
        } else if (Platform.isMacOS) {
          try {
            // For macOS, use Resources directory within the app bundle
            final exePath = Platform.resolvedExecutable;
            final exeDir = p.dirname(exePath);
            final resourcesPath = p.join(exeDir, '..', 'Resources');
            final iconPath = p.join(resourcesPath, 'app_icon.png');
            await trayManager.setIcon(iconPath);
          } catch (e) {
            LoggerService().error('Failed to setup macOS tray icon', e);
          }
        }
      });
    }
    if (Platform.isAndroid) {
      AppServiceStarter.startForegroundService();
    }

    runApp(
      const MyApp(),
    );
  }, (error, stack) {
    LoggerService().error('Uncaught Error: $error', error, stack);

    NativeDialog.show(
        'Uncaught Error (Crash):\n$error\n\n'
        'Log file path: ${LoggerService().logFilePath}',
        title: 'Application Crash');
  });
}

class MyApp extends StatelessWidget {
  static const platform = MethodChannel('com.aro.aro_app/foreground');

  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'ARO Desktop',
      theme: ThemeData(
        useMaterial3: true,
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepOrange),
      ),
      builder: (context, child) {
        final builtChild = child ?? const SizedBox.shrink();
        // Work around a Linux crash where HeroController can throw a null-check
        // error during platform view initialization (InAppWebView).
        if (Platform.isLinux) {
          return HeroControllerScope.none(child: builtChild);
        }
        return builtChild;
      },
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage>
    with TrayListener, WindowListener {
  WebViewController? _controller;
  // win.WebviewController? _winController;
  inapp.InAppWebViewController? _desktopController;
  // bool _isWindowsInit = false;
  // String? _errorMessage;
  bool _isDesktopWebViewReady = false;
  String? _desktopWebViewError;
  bool _isConnected = true;

  bool _trayMenuOpening = false;

  final service = StudyService.instance;

  // void sendToWeb(Map<String, dynamic> data) {
  //   final json = jsonEncode(data);
  //   _controller.runJavaScript(
  //     'window.onFlutterMessage($json);',
  //   );
  // }

  void sendMessageToWeb(Map<String, dynamic> data) {
    final json = jsonEncode(data);
    final script = '''
    window.onFlutterMessage && window.onFlutterMessage($json);
  ''';
    if (Platform.isWindows || Platform.isLinux) {
      _desktopController?.evaluateJavascript(source: script);
    } else {
      _controller?.runJavaScript(script);
    }
  }

  void connectWS() {
    // final status = service.connectWS();
    // print('connect status: $status');
  }

  Future<void> _restartApp() async {
    try {
      if (Platform.isAndroid) {
        await MyApp.platform.invokeMethod('restartApp');
        return;
      }

      if (Platform.isMacOS) {
        final exePath = Platform.resolvedExecutable;
        final exeDir = Directory(exePath).parent;
        final appBundlePath = p.normalize(p.join(exeDir.path, '..', '..'));
        await Process.run('open', [appBundlePath]);
        exit(0);
      }

      if (Platform.isWindows) {
        final exePath = Platform.resolvedExecutable;
        await Process.start(exePath, ['--wait-for-single-instance']);
        exit(0);
      }

      if (Platform.isLinux) {
        final exePath = Platform.resolvedExecutable;
        await Process.start(exePath, []);
        exit(0);
      }
    } catch (e) {
      LoggerService().error('Restart failed', e);
    }
  }

  Future<void> _showRestartDialog() async {
    if (!mounted) return;
    try {
      await showDialog<void>(
        context: context,
        barrierDismissible: false,
        builder: (context) {
          return AlertDialog(
            title: const Text('Update completed'),
            content: const Text(
                'Update completed. Please restart the app to take effect.'),
            actions: [
              TextButton(
                onPressed: () async {
                  Navigator.of(context).pop();
                  await _restartApp();
                },
                child: const Text('Restart now'),
              ),
            ],
          );
        },
      );
    } catch (e) {
      LoggerService().error('Show restart dialog failed', e);
    }
  }

  void handleWebMessage(String message) async {
    print('messagehandleWebMessage $message');
    // Try to decode JSON messages from the web first
    Map<String, dynamic>? msgMap;
    try {
      final decoded = jsonDecode(message);
      if (decoded is Map<String, dynamic>) msgMap = decoded;
    } catch (_) {}

    if (msgMap != null &&
        msgMap['type'] == 'openExternal' &&
        msgMap['url'] != null) {
      final url = msgMap['url'].toString();
      print('Opening external URL from web: $url');
      await _openExternalUrl(url);
      return;
    }

    if (message == 'nodeInfo') {
      try {
        final stat = service.getNodeStat();
        final statMap = jsonDecode(stat);
        print('statMap nodeInfo $statMap');

        if (statMap['code'] == 200 && statMap['data']['bind'] == true) {
          print('Send stat result:  ------- $stat $statMap ');
          sendToWeb({
            'type': 'nodeInfo',
            'payload': statMap,
          });
        }
      } catch (e) {
        print('nodeInfo error $e');
        LoggerService().info('nodeInfo--- error $e ');
      }
    } else if (message == 'nodeSignUp') {
      try {
        final status = service.nodeSignUp();
        print('node status: $status');
        sendMessageToWeb({
          'type': 'nodeSignUp',
          'payload': status,
        });

        final stat = service.getNodeStat();
        final statMap = jsonDecode(stat);

        print('statMapStat $statMap');

        if (statMap['code'] == 200) {
          print('Send: signup sta  ------- $stat $statMap ');
          sendMessageToWeb({
            'type': 'nodeInfo',
            'payload': statMap,
          });
        }
      } catch (e) {
        print('nodeSignUp error $e');
        LoggerService().info('nodeSignUp--- error $e ');
      }
    } else if (message == 'nodeRewards') {
      final rewards = service.getRewards();
      final rewardsMap = jsonDecode(rewards);

      print('node rewardsMap: $rewardsMap');
      if (rewardsMap['code'] == 200) {
        sendMessageToWeb({
          'type': 'nodeRewards',
          'payload': rewardsMap,
        });
      }
    } else if (message == 'getVersion') {
      try {
        final version = service.getCurrentVersion();
        final version2 = service.getLastVersion();

        final versionMap = jsonDecode(version);
        final versionMap2 = jsonDecode(version2);

        LoggerService()
            .info('getVersion1232--- $versionMap 12311 $versionMap2 $version2');

        print(
            'versionMap getVersion $versionMap 12311 $versionMap2 $versionMap2');
        if (versionMap['code'] == 200) {
          sendMessageToWeb({
            'type': 'getVersion',
            'payload': versionMap,
          });
        }

        if (versionMap2 is Map<String, dynamic>) {
          Map<String, dynamic>? updateResult;

          if (Platform.isMacOS) {
            updateResult = await LibUpdateService.instance.checkAndUpdateMacOS(
              currentVersionMap: versionMap,
              latestVersionMap: versionMap2,
            );
          } else if (Platform.isAndroid) {
            updateResult =
                await LibUpdateService.instance.checkAndUpdateAndroid(
              currentVersionMap: versionMap,
              latestVersionMap: versionMap2,
            );
          } else if (Platform.isWindows) {
            updateResult =
                await LibUpdateService.instance.checkAndUpdateWindows(
              currentVersionMap: versionMap,
              latestVersionMap: versionMap2,
            );
          } else if (Platform.isLinux) {
            updateResult = await LibUpdateService.instance.checkAndUpdateLinux(
              currentVersionMap: versionMap,
              latestVersionMap: versionMap2,
            );
          }

          if (updateResult != null) {
            print('updateResult getVersion $updateResult');
            LoggerService().info('Library update result: $updateResult');
            if (updateResult['updated'] == true) {
              await _showRestartDialog();
            }
          }
        }
      } catch (e) {
        print('getVersion error $e');
      }
    }
    // else if (message == 'getWSClientStatus') {
    //   final status = service.getWSClientStatus();
    //   final statusMap = jsonDecode(status);
    //   print('statusMap getWSClientStatus $statusMap');
    //   LoggerService().info('getWSClientStatus--- $statusMap');
    //   if (statusMap['code'] == 200) {
    //     sendMessageToWeb({
    //       'type': 'getWSClientStatus',
    //       'payload': statusMap,
    //     });
    //   }
    // }
  }

  Future<void> _openExternalUrl(String url) async {
    try {
      final uriStr = (url.startsWith('http://') || url.startsWith('https://'))
          ? url
          : 'https://$url';
      final uri = Uri.parse(uriStr);

      // Prefer url_launcher (Android/iOS/desktop). It also avoids relying on Process on mobile.
      try {
        final launched = await launchUrl(
          uri,
          mode: LaunchMode.externalApplication,
        );
        if (launched) return;
      } catch (e) {
        // Fall back to platform command below for desktop.
        print('launchUrl failed, falling back to platform command: $e');
      }

      if (Platform.isMacOS) {
        await Process.run('open', [uriStr]);
      } else if (Platform.isLinux) {
        await Process.run('xdg-open', [uriStr]);
      } else if (Platform.isWindows) {
        await Process.run('cmd', ['/c', 'start', '', uriStr]);
      } else {
        print('Unsupported platform for opening URL: $uriStr');
      }
    } catch (e) {
      print('Failed to open external URL: $e');
    }
  }

  Future<void> initNode() async {
    try {
      final appDir = await getAppSupportDir();
      print('Generate file directory 123: $appDir');
      // final service = StudyService.instance; // Remove local variable to avoid confusion
      final initResult = service.nodeInit({
        "appDir": appDir,
        "config": {"BaseAPIURL": AllConfig.apiBase},
      });

      print('initializing node: $initResult');
      LoggerService().info('Init result: $initResult ------- ');
    } catch (e) {
      print('Error initializing node: $e');
      LoggerService().error('Error initializing node', e);
    }
  }

  void sendToWeb(Map<String, dynamic> data) {
    final json = jsonEncode(data);
    final script = 'window.onFlutterMessage($json);';
    if (Platform.isWindows || Platform.isLinux) {
      _desktopController?.evaluateJavascript(source: script);
    } else {
      _controller?.runJavaScript(script);
    }
  }

  @override
  void initState() {
    super.initState();

    // Setup connectivity listener
    _setupConnectivityListener();

    if (Platform.isWindows) {
      trayManager.addListener(this);
      unawaited(_setupWindowsTrayMenu());

      windowManager.addListener(this);
      unawaited(windowManager.setPreventClose(true));
    }

    initNode().catchError((e) {
      print('initNode error caught: $e');
    });

    if (Platform.isWindows || Platform.isLinux) {
      // On Windows/Linux, delay webview creation to ensure Hero system is fully disabled
      // Use addPostFrameCallback to ensure the widget tree is built before creating webview
      WidgetsBinding.instance.addPostFrameCallback((_) {
        if (mounted) {
          setState(() {
            _isDesktopWebViewReady = true;
          });
        }
      });

      // If the platform webview fails to initialize (e.g. missing WebView2 on
      // Windows), the screen can stay blank. Add a small timeout to surface a
      // helpful message.
      Timer(const Duration(seconds: 60), () {
        if (!mounted) return;
        if (_desktopController != null) return;
        if (_desktopWebViewError != null) return;

        if (Platform.isWindows) {
          setState(() {
            _desktopWebViewError =
                'Server Error. Click the Retry button to try again.';
          });
        }
      });
    } else {
      // Initialize webview_flutter for Android/iOS/macOS
      _initMobileWebView();
    }
  }

  Future<void> _setupWindowsTrayMenu() async {
    try {
      final menu = Menu(
        items: [
          MenuItem(key: 'Show', label: 'Show'),
          MenuItem(key: 'Hide', label: 'Hide'),
          MenuItem.separator(),
          MenuItem(key: 'Quit', label: 'Quit'),
        ],
      );
      await trayManager.setContextMenu(menu);
    } catch (e, s) {
      LoggerService().error('Failed to setup tray menu', e, s);
    }
  }

  Future<void> _trayShow() async {
    try {
      await windowManager.show();
      await windowManager.focus();
    } catch (e, s) {
      LoggerService().error('Tray show failed', e, s);
    }
  }

  Future<void> _trayHide() async {
    try {
      await windowManager.hide();
    } catch (e, s) {
      LoggerService().error('Tray hide failed', e, s);
    }
  }

  Future<void> _trayExit() async {
    try {
      await trayManager.destroy();
    } catch (_) {}
    exit(0);
  }

  Future<void> _popTrayContextMenu() async {
    if (_trayMenuOpening) return;
    _trayMenuOpening = true;
    try {
      await trayManager.popUpContextMenu();
    } catch (e, s) {
      LoggerService().error('Pop tray context menu failed', e, s);
    } finally {
      // popUpContextMenu can return quickly; give a short cooldown to avoid
      // double-triggering on down+up.
      Timer(const Duration(milliseconds: 300), () {
        _trayMenuOpening = false;
      });
    }
  }

  @override
  void onTrayIconMouseDown() {
    unawaited(_trayShow());
  }

  @override
  void onTrayIconRightMouseDown() {
    if (Platform.isWindows) {
      // On Windows, opening the menu exactly on mouse down can sometimes cause
      // dismissal issues. A tiny delay tends to make it behave normally.
      unawaited(Future.delayed(const Duration(milliseconds: 10), () async {
        await _popTrayContextMenu();
      }));
      return;
    }
    unawaited(_popTrayContextMenu());
  }

  @override
  void onTrayIconRightMouseUp() {
    // Fallback: some environments may not reliably fire right-mouse-down.
    if (Platform.isWindows) {
      unawaited(_popTrayContextMenu());
    }
  }

  @override
  void onTrayMenuItemClick(MenuItem menuItem) {
    switch (menuItem.key) {
      case 'Show':
        unawaited(_trayShow());
        break;
      case 'Hide':
        unawaited(_trayHide());
        break;
      case 'Quit':
        unawaited(_trayExit());
        break;
    }
  }

  @override
  Future<void> onWindowClose() async {
    if (!Platform.isWindows) return;
    await _trayHide();
  }

  void _setupConnectivityListener() {
    final connectivityService = ConnectivityService();
    _isConnected = connectivityService.isConnected;

    connectivityService.addListener((isConnected) {
      if (mounted) {
        setState(() {
          _isConnected = isConnected;
        });
      }
    });
  }

  @override
  void dispose() {
    if (Platform.isWindows) {
      trayManager.removeListener(this);
      windowManager.removeListener(this);
    }
    ConnectivityService().dispose();
    super.dispose();
  }

  void _initMobileWebView() {
    try {
      _controller = WebViewController();

      _controller!.setJavaScriptMode(JavaScriptMode.unrestricted);

      _controller!.addJavaScriptChannel(
        'Flutter',
        onMessageReceived: (JavaScriptMessage message) {
          print('Received Web message: $message');
          handleWebMessage(message.message);
        },
      );

      _controller!.setNavigationDelegate(
        NavigationDelegate(
          onPageFinished: (_) {
            print('[FLUTTER] page finished');
            // Disable context menu and right-click on mobile
            _controller?.runJavaScript('''
              document.addEventListener('contextmenu', function(e) {
                e.preventDefault();
                return false;
              }, false);
              
              // Disable drag and drop
              document.addEventListener('dragover', function(e) {
                e.preventDefault();
                return false;
              }, false);
              document.addEventListener('drop', function(e) {
                e.preventDefault();
                return false;
              }, false);
            ''');
          },
        ),
      );

      final url = Platform.isAndroid || Platform.isIOS
          ? AllConfig.mobileURL
          : AllConfig.deskTopURL;
      _controller!.loadRequest(Uri.parse(url));
    } catch (e) {
      print('Error initializing webview: $e');
      LoggerService().error('Error initializing webview', e);
    }
  }

  @override
  Widget build(BuildContext context) {
    if (Platform.isWindows || Platform.isLinux) {
      // Use Builder to ensure Hero system is fully disabled before creating InAppWebView
      if (!_isDesktopWebViewReady) {
        return const Scaffold(
          body: Center(child: CircularProgressIndicator()),
        );
      }

      if (_desktopWebViewError != null) {
        return Scaffold(
          body: Center(
            child: Padding(
              padding: const EdgeInsets.all(16.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  const Icon(Icons.error_outline, size: 48, color: Colors.red),
                  const SizedBox(height: 16),
                  Text(
                    _desktopWebViewError!,
                    textAlign: TextAlign.center,
                    style: const TextStyle(fontSize: 12),
                  ),
                  const SizedBox(height: 16),
                  TextButton(
                    onPressed: () {
                      setState(() {
                        _desktopWebViewError = null;
                      });
                    },
                    child: const Text('Retry'),
                  ),
                ],
              ),
            ),
          ),
        );
      }

      return Scaffold(
        body: Stack(
          children: [
            HeroControllerScope.none(
              child: HeroMode(
                enabled: false,
                child: Builder(
                  builder: (context) => _buildDesktopWebView(),
                ),
              ),
            ),
            if (!_isConnected) _buildNetworkOfflineOverlay(),
          ],
        ),
      );
    }
    // Use webview_flutter for macOS, Android, iOS
    if (_controller == null) {
      return const Scaffold(
        body: Center(child: CircularProgressIndicator()),
      );
    }
    return Scaffold(
      body: Stack(
        children: [
          WebViewWidget(controller: _controller!),
          if (!_isConnected) _buildNetworkOfflineOverlay(),
        ],
      ),
    );
  }

  Widget _buildNetworkOfflineOverlay() {
    return Container(
      color: Colors.black.withOpacity(0.7),
      child: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Icon(
              Icons.wifi_off,
              size: 64,
              color: Colors.white,
            ),
            const SizedBox(height: 24),
            const Text(
              'Network Unavailable',
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
                color: Colors.white,
              ),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 12),
            const Text(
              'Please check your internet connection',
              style: TextStyle(
                fontSize: 14,
                color: Colors.white70,
              ),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 24),
            ElevatedButton.icon(
              onPressed: () {
                // User can tap to dismiss the message
                // Connection will be restored automatically once network is available
              },
              icon: const Icon(Icons.check),
              label: const Text('OK'),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildDesktopWebView() {
    try {
      // For Linux, ensure we create the webview with proper platform view settings
      final settings = inapp.InAppWebViewSettings(
        javaScriptEnabled: true,
        javaScriptCanOpenWindowsAutomatically: false,
        supportMultipleWindows: false,
        useShouldOverrideUrlLoading: true,
        // Disable zoom controls
        builtInZoomControls: false,
        displayZoomControls: false,
      );

      return inapp.InAppWebView(
        key: const ValueKey('desktop_webview'),
        initialUrlRequest: inapp.URLRequest(
          url: inapp.WebUri(AllConfig.deskTopURL),
        ),
        initialSettings: settings,
        onWebViewCreated: (controller) {
          _desktopController = controller;
          if (mounted && _desktopWebViewError != null) {
            setState(() {
              _desktopWebViewError = null;
            });
          }
          try {
            controller.addJavaScriptHandler(
              handlerName: 'Flutter',
              callback: (args) {
                if (args.isNotEmpty) {
                  dynamic message = args[0];
                  if (message is String) {
                    handleWebMessage(message);
                  } else if (message is Map) {
                    handleWebMessage(jsonEncode(message));
                  }
                }
              },
            );
          } catch (e) {
            LoggerService().error('Failed to add JavaScript handler', e);
          }
        },
        shouldOverrideUrlLoading: (controller, action) async {
          return inapp.NavigationActionPolicy.ALLOW;
        },
        onLoadStop: (controller, url) async {
          try {
            // Disable context menu and right-click
            await controller.evaluateJavascript(source: '''
              document.addEventListener('contextmenu', function(e) {
                e.preventDefault();
                return false;
              }, false);
              
              // Disable drag and drop
              document.addEventListener('dragover', function(e) {
                e.preventDefault();
                return false;
              }, false);
              document.addEventListener('drop', function(e) {
                e.preventDefault();
                return false;
              }, false);
              
              if (!window.Flutter) {
                window.Flutter = {
                  postMessage: function(msg) {
                    window.flutter_inappwebview.callHandler('Flutter', msg);
                  }
                };
              }
            ''');
          } catch (e) {
            LoggerService().error('Failed to evaluate JavaScript', e);
          }
        },
        onReceivedError: (controller, request, error) {
          LoggerService().error(
            'WebView error: ${error.description} (${error.type}) url=${request.url}',
            error,
          );
          if (!mounted) return;
          setState(() {
            _desktopWebViewError = 'Failed to load page.';
          });
        },
        onCreateWindow: (controller, action) async {
          final uri = action.request.url;
          if (uri != null) {
            await controller.loadUrl(
              urlRequest: inapp.URLRequest(url: uri),
            );
          }
          return false;
        },
      );
    } catch (e, s) {
      LoggerService().error('Failed to create desktop webview', e, s);

      // Provide helpful error message for Linux
      String errorMessage = 'Failed to load page';

      return Scaffold(
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                const Icon(Icons.error_outline, size: 48, color: Colors.red),
                const SizedBox(height: 16),
                Text(
                  errorMessage,
                  textAlign: TextAlign.center,
                  style: const TextStyle(fontSize: 12),
                ),
              ],
            ),
          ),
        ),
      );
    }
  }
}
