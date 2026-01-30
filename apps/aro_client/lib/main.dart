import 'dart:async';
import 'package:flutter/material.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';
import 'package:aro_client/components/path_provider.dart';
import 'package:aro_client/ffi/study_lib.dart';
import 'package:aro_client/ffi/study_service.dart';
import 'package:aro_client/services/AppServiceStarter.dart';
import 'package:aro_client/services/logger_service.dart';
import 'package:aro_client/utils/native_dialog.dart';
import 'package:window_manager/window_manager.dart';
import 'dart:io';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:tray_manager/tray_manager.dart';
import 'package:path/path.dart' as p;
import 'dart:convert';
import 'package:aro_client/utils/config.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart' as inapp;

void main(List<String> args) async {
  runZonedGuarded(() async {
    WidgetsFlutterBinding.ensureInitialized();

    await LoggerService().initialize();
    LoggerService().info('App starting...');

    try {
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
      // NativeDialog.show('Async Error:\n$error');
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
        final versionMap2 = version2;

        print('versionMap getVersion $versionMap 12311 $versionMap2');
        if (versionMap['code'] == 200) {
          sendMessageToWeb({
            'type': 'getVersion',
            'payload': versionMap,
          });
        }
      } catch (e) {
        print('getVersion error $e');
      }
    } else if (message == 'getWSClientStatus') {
      final status = service.getWSClientStatus();
      final statusMap = jsonDecode(status);
      print('statusMap getWSClientStatus $statusMap');
      LoggerService().info('getWSClientStatus--- $statusMap');
      if (statusMap['code'] == 200) {
        sendMessageToWeb({
          'type': 'getWSClientStatus',
          'payload': statusMap,
        });
      }
    }
  }

  Future<void> _openExternalUrl(String url) async {
    try {
      final uriStr = (url.startsWith('http://') || url.startsWith('https://'))
          ? url
          : 'https://$url';
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
    // Initialize node in background, don't block UI
    initNode().catchError((e) {
      print('initNode error caught: $e');
    });

    if (Platform.isWindows || Platform.isLinux) {
      // On Windows and Linux, we use embedded InAppWebView which is initialized in build()
    } else {
      _initMobileWebView();
    }
  }

  void _initMobileWebView() {
    _controller = WebViewController()
      ..setJavaScriptMode(JavaScriptMode.unrestricted)
      ..addJavaScriptChannel(
        'Flutter',
        onMessageReceived: (JavaScriptMessage message) {
          print('Received Web message: $message');
          handleWebMessage(message.message);
        },
      )
      ..setNavigationDelegate(
        NavigationDelegate(
          onPageFinished: (_) {
            print('[FLUTTER] page finished');
          },
        ),
      )
      ..loadRequest(Uri.parse(Platform.isAndroid || Platform.isIOS
          ? AllConfig.mobileURL
          : AllConfig.deskTopURL));
  }

  @override
  Widget build(BuildContext context) {
    if (Platform.isWindows || Platform.isLinux) {
      return Scaffold(
        body: inapp.InAppWebView(
          initialUrlRequest: inapp.URLRequest(
            url: inapp.WebUri.uri(Uri.parse(AllConfig.deskTopURL)),
          ),
          initialSettings: inapp.InAppWebViewSettings(
            isInspectable: kDebugMode,
          ),
          onWebViewCreated: (controller) {
            _desktopController = controller;
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
          },
          onLoadStop: (controller, url) async {
            await controller.evaluateJavascript(source: '''
                if (!window.Flutter) {
                  window.Flutter = {
                    postMessage: function(msg) {
                      window.flutter_inappwebview.callHandler('Flutter', msg);
                    }
                  };
                }
             ''');
          },
        ),
      );
    }
    return Scaffold(
      body: _controller != null
          ? WebViewWidget(controller: _controller!)
          : const Center(child: CircularProgressIndicator()),
    );
  }
}
