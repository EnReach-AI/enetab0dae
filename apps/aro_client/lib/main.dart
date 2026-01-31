import 'dart:async';
import 'dart:math';
import 'package:flutter/material.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';
import 'package:aro_client/components/path_provider.dart';
import 'package:aro_client/ffi/study_lib.dart';
import 'package:aro_client/ffi/study_service.dart';
import 'package:aro_client/services/AppServiceStarter.dart';
import 'package:aro_client/services/logger_service.dart';
import 'package:aro_client/services/lib_update_service.dart';
import 'package:aro_client/utils/native_dialog.dart';
import 'package:window_manager/window_manager.dart';
import 'dart:io';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:tray_manager/tray_manager.dart';
import 'package:path/path.dart' as p;
import 'dart:convert';
import 'package:aro_client/utils/config.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart' as inapp;
import 'package:desktop_webview_window/desktop_webview_window.dart';

void main(List<String> args) async {
  runZonedGuarded(() async {
    WidgetsFlutterBinding.ensureInitialized();
    if (runWebViewTitleBarWidget(args)) {
      return;
    }

    await LoggerService().initialize();
    LoggerService().info('App starting...');

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
        if (Platform.isWindows) {
          try {
            final exeDir = p.dirname(Platform.resolvedExecutable);
            final iconPath = p.join(exeDir, 'resources', 'app_icon.ico');
            await trayManager.setIcon(iconPath);
            await trayManager.setToolTip('ARO');
          } catch (e) {
            LoggerService().error('Failed to setup Windows tray icon', e);
          }
        } else if (Platform.isLinux) {
          try {
            final exeDir = p.dirname(Platform.resolvedExecutable);
            final iconPath = p.join(exeDir, 'resources', 'app_icon.png');
            await trayManager.setIcon(iconPath);
          } catch (e) {
            LoggerService().error('Failed to setup Linux tray icon', e);
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
      title: 'ARO',
      theme: ThemeData(
        useMaterial3: true,
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepOrange),
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  WebViewController? _controller;
  // win.WebviewController? _winController;
  inapp.InAppWebViewController? _desktopController;
  // bool _isWindowsInit = false;
  // String? _errorMessage;

  final service = StudyService.instance;
  HttpServer? _linuxBridgeServer;
  final Set<WebSocket> _linuxBridgeClients = {};
  int? _linuxBridgePort;
  String? _linuxBridgeToken;
  bool _linuxWebviewLaunched = false;
  bool _linuxWebviewStarting = false;
  String? _linuxWebviewError;
  bool get _useDesktopWebviewWindow =>
      Platform.isLinux ||
      (kDebugMode &&
          Platform.environment['ARO_FORCE_DESKTOP_WEBVIEW_WINDOW'] == '1');

  // void sendToWeb(Map<String, dynamic> data) {
  //   final json = jsonEncode(data);
  //   _controller.runJavaScript(
  //     'window.onFlutterMessage($json);',
  //   );
  // }

  @override
  void dispose() {
    for (final c in _linuxBridgeClients) {
      try {
        c.close();
      } catch (_) {}
    }
    _linuxBridgeClients.clear();
    try {
      _linuxBridgeServer?.close();
    } catch (_) {}
    super.dispose();
  }

  void _broadcastToLinuxWeb(String message) {
    for (final c in _linuxBridgeClients.toList()) {
      if (c.closeCode != null) {
        _linuxBridgeClients.remove(c);
        continue;
      }
      try {
        c.add(message);
      } catch (_) {
        _linuxBridgeClients.remove(c);
      }
    }
  }

  void sendMessageToWeb(Map<String, dynamic> data) {
    final json = jsonEncode(data);
    if (_useDesktopWebviewWindow) {
      _broadcastToLinuxWeb(json);
      return;
    }
    final script = '''
    window.onFlutterMessage && window.onFlutterMessage($json);
  ''';
    if (Platform.isWindows) {
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
        await Process.start(exePath, []);
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
                onPressed: () {
                  Navigator.of(context).pop();
                },
                child: const Text('OK'),
              ),
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
      final stat = service.getNodeStat();
      final statMap = jsonDecode(stat);
      print('statMap nodeInfo $statMap');

      if (statMap['code'] == 200 && statMap['data']['bind'] == true) {
        print('Send stat result:  ------- $stat $statMap ');
        sendToWeb({
          'type': 'nodeInfo',
          'payload': statMap,
        });
        connectWS();
      }
    } else if (message == 'nodeSignUp') {
      final status = service.nodeSignUp();
      print('node status: $status');
      sendMessageToWeb({
        'type': 'nodeSignUp',
        'payload': status,
      });
      print('Send nodeSignUp:  ------- ');

      final stat = service.getNodeStat();
      final statMap = jsonDecode(stat);

      print('statMapStat $statMap');

      if (statMap['code'] == 200) {
        print('Send: signup sta  ------- $stat $statMap ');
        sendMessageToWeb({
          'type': 'nodeInfo',
          'payload': statMap,
        });
        connectWS();
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

  Future<bool> _openExternalUrl(String url) async {
    try {
      final uriStr = (url.startsWith('http://') || url.startsWith('https://'))
          ? url
          : 'https://$url';
      if (Platform.isMacOS) {
        final res = await Process.run('open', [uriStr]);
        return res.exitCode == 0;
      } else if (Platform.isLinux) {
        final res = await Process.run('xdg-open', [uriStr]);
        return res.exitCode == 0;
      } else if (Platform.isWindows) {
        final res = await Process.run('cmd', ['/c', 'start', '', uriStr]);
        return res.exitCode == 0;
      } else {
        print('Unsupported platform for opening URL: $uriStr');
        return false;
      }
    } catch (e) {
      print('Failed to open external URL: $e');
      return false;
    }
  }

  Future<void> initNode() async {
    try {
      final appDir = await getAppSupportDir();
      print('Generate file directory 123: $appDir');
      // final service = StudyService.instance; // Remove local variable to avoid confusion
      final initResult = service.nodeInit(appDir, {
        "config": {"BaseAPIURL": AllConfig.apiBase, "BaseWSURL": AllConfig.ws}
      });

      LoggerService().info('Init result: $initResult ------- ');
    } catch (e) {
      print('Error initializing node: $e');
      LoggerService().error('Error initializing node', e);
    }
  }

  void sendToWeb(Map<String, dynamic> data) {
    final json = jsonEncode(data);
    if (_useDesktopWebviewWindow) {
      _broadcastToLinuxWeb(json);
      return;
    }
    final script = 'window.onFlutterMessage($json);';
    if (Platform.isWindows) {
      _desktopController?.evaluateJavascript(source: script);
    } else {
      _controller?.runJavaScript(script);
    }
  }

  @override
  void initState() {
    super.initState();
    // Initialize node in background, don't block UI
    initNode().catchError((e) {
      print('initNode error caught: $e');
    });

    if (_useDesktopWebviewWindow) {
      WidgetsBinding.instance.addPostFrameCallback((_) {
        _initLinuxWebview().catchError((e, s) {
          LoggerService().error('Linux webview init failed', e, s);
        });
      });
    } else if (!Platform.isWindows) {
      _initMobileWebView();
    }
  }

  Future<void> _initLinuxWebview() async {
    if (_linuxWebviewLaunched) return;
    _linuxWebviewLaunched = true;
    if (mounted) {
      setState(() {
        _linuxWebviewStarting = true;
        _linuxWebviewError = null;
      });
    }

    try {
      _linuxBridgeServer ??=
          await HttpServer.bind(InternetAddress.loopbackIPv4, 0);
      _linuxBridgePort = _linuxBridgeServer!.port;
      final tokenBytes =
          List<int>.generate(32, (_) => Random.secure().nextInt(256));
      _linuxBridgeToken = base64UrlEncode(tokenBytes);
      _linuxBridgeServer!.listen((HttpRequest request) async {
        if (_linuxBridgeToken == null ||
            request.uri.path != '/ws/$_linuxBridgeToken') {
          request.response.statusCode = HttpStatus.notFound;
          await request.response.close();
          return;
        }
        if (!WebSocketTransformer.isUpgradeRequest(request)) {
          request.response.statusCode = HttpStatus.badRequest;
          await request.response.close();
          return;
        }
        final socket = await WebSocketTransformer.upgrade(request);
        _linuxBridgeClients.add(socket);
        socket.listen(
          (data) {
            if (data is String) {
              handleWebMessage(data);
            } else {
              handleWebMessage(data.toString());
            }
          },
          onDone: () {
            _linuxBridgeClients.remove(socket);
          },
          onError: (_) {
            _linuxBridgeClients.remove(socket);
          },
          cancelOnError: true,
        );
      });

      final webview = await WebviewWindow.create(
        configuration: CreateConfiguration(
          windowWidth: 360,
          windowHeight: 640,
          title: 'ARO',
        ),
      );

      final wsPort = _linuxBridgePort!;
      final wsToken = _linuxBridgeToken!;
      webview.addScriptToExecuteOnDocumentCreated('''
        (function() {
          var wsUrl = "ws://127.0.0.1:$wsPort/ws/$wsToken";
          var socket = null;
          function connect() {
            try {
              socket = new WebSocket(wsUrl);
              socket.onmessage = function(event) {
                try {
                  if (!window.onFlutterMessage) return;
                  var data = event.data;
                  if (typeof data === "string") {
                    try {
                      window.onFlutterMessage(JSON.parse(data));
                      return;
                    } catch (e) {}
                  }
                  window.onFlutterMessage(data);
                } catch (e) {}
              };
              socket.onclose = function() {
                setTimeout(connect, 1000);
              };
            } catch (e) {
              setTimeout(connect, 1000);
            }
          }
          connect();

          window.Flutter = window.Flutter || {};
          window.Flutter.postMessage = function(msg) {
            try {
              if (!socket || socket.readyState !== 1) return;
              if (typeof msg === "string") {
                socket.send(msg);
              } else {
                socket.send(JSON.stringify(msg));
              }
            } catch (e) {}
          };
        })();
      ''');

      webview.launch(AllConfig.deskTopURL);
      if (Platform.isLinux) {
        await windowManager.hide();
      }

      if (mounted) {
        setState(() {
          _linuxWebviewStarting = false;
        });
      }
    } catch (e, s) {
      LoggerService().error('Linux webview startup failed', e, s);
      if (mounted) {
        setState(() {
          _linuxWebviewStarting = false;
          _linuxWebviewError = e.toString();
        });
      }
    }
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
    if (_useDesktopWebviewWindow) {
      if (_linuxWebviewError != null) {
        return Scaffold(
          body: Center(
            child: Padding(
              padding: const EdgeInsets.symmetric(horizontal: 24),
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  const Text('Linux WebView 启动失败'),
                  const SizedBox(height: 12),
                  SelectableText(
                    _linuxWebviewError!,
                    textAlign: TextAlign.center,
                  ),
                  const SizedBox(height: 12),
                  OutlinedButton(
                    onPressed: () {
                      _openExternalUrl(AllConfig.deskTopURL);
                    },
                    child: const Text('用系统浏览器打开'),
                  ),
                  const SizedBox(height: 12),
                  OutlinedButton(
                    onPressed: () async {
                      await Clipboard.setData(
                        const ClipboardData(text: AllConfig.deskTopURL),
                      );
                    },
                    child: const Text('复制链接'),
                  ),
                ],
              ),
            ),
          ),
        );
      }
      if (_linuxWebviewStarting) {
        return const Scaffold(
          body: Center(child: CircularProgressIndicator()),
        );
      }
      return const Scaffold(body: SizedBox.shrink());
    }
    if (Platform.isWindows) {
      return Scaffold(
        body: HeroMode(
          enabled: false,
          child: _buildDesktopWebView(),
        ),
      );
    }
    // Use webview_flutter for Linux, macOS, Android, iOS
    if (_controller == null) {
      return const Scaffold(
        body: Center(child: CircularProgressIndicator()),
      );
    }
    return Scaffold(
      body: WebViewWidget(controller: _controller!),
    );
  }

  Widget _buildDesktopWebView() {
    try {
      return inapp.InAppWebView(
        key: const ValueKey('desktop_webview'),
        initialUrlRequest: inapp.URLRequest(
          url: inapp.WebUri(AllConfig.deskTopURL),
        ),
        initialSettings: inapp.InAppWebViewSettings(
          javaScriptEnabled: true,
        ),
        onWebViewCreated: (controller) {
          _desktopController = controller;
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
        onLoadStop: (controller, url) async {
          try {
            await controller.evaluateJavascript(source: '''
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
        onLoadError: (controller, url, code, message) {
          LoggerService()
              .error('WebView load error: $message (code: $code)', null);
        },
      );
    } catch (e) {
      LoggerService().error('Failed to create desktop webview', e);
      return Scaffold(
        body: Center(
          child: Text('Failed to load webview: ${e.toString()}'),
        ),
      );
    }
  }
}
