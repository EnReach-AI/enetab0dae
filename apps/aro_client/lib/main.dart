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
import 'package:s_webview/s_webview.dart';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:desktop_webview_window/desktop_webview_window.dart';
import 'dart:convert';

void main() async {
  runZonedGuarded(() async {
    WidgetsFlutterBinding.ensureInitialized();

    await LoggerService().initialize();
    LoggerService().info('App starting...');

    // 尽早检查原生库依赖，如果缺失会弹窗提示（仅限Windows）
    try {
      StudyLibrary.ensureInitialized();
    } catch (e) {
      LoggerService().error('Native library initialization failed', e);
      // 继续抛出，以便 runZonedGuarded 也能捕获（虽然这里已经记录了日志）
      // 或者我们可以选择吞掉异常让应用尝试运行（但很可能会再次崩溃）
      // 考虑到弹窗已经提示用户，这里记录日志后继续执行可能会导致后续更混乱的错误
      // 但为了让日志文件能完整写入，我们不强行退出。
    }

    FlutterError.onError = (FlutterErrorDetails details) {
      FlutterError.presentError(details);
      LoggerService().error(
        'Flutter Error: ${details.exception}',
        details.exception,
        details.stack,
      );
      // 在严重错误时尝试弹窗提示 (可选，避免太频繁)
      // NativeDialog.show('Flutter Error:\n${details.exception}');
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

    // 关键：对于未捕获的异常，尤其是启动时的崩溃，使用原生弹窗提示用户
    // 这样即使日志没写进去，用户也能看到报错
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
  // 移动平台使用 webview_flutter
  WebViewController? _mobileController;
  // 桌面平台使用 desktop_webview_window
  Webview? _desktopWebview;
  final service = StudyService.instance;
  
  bool get _isDesktop => Platform.isWindows || Platform.isLinux || Platform.isMacOS;

  // void sendToWeb(Map<String, dynamic> data) {
  //   final json = jsonEncode(data);
  //   _controller.runJavaScript(
  //     'window.onFlutterMessage($json);',
  //   );
  // }

  void sendMessageToWeb(Map<String, dynamic> data) {
    final json = jsonEncode(data);
    final script = 'window.onFlutterMessage && window.onFlutterMessage($json);';
    if (_isDesktop) {
      _desktopWebview?.evaluateJavaScript(script);
    } else {
      _mobileController?.runJavaScript(script);
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
      print('node rewards: $rewards');
      sendMessageToWeb({
        'type': 'nodeRewards',
        'payload': rewards,
      });
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
        "config": {
          "BaseAPIURL": "https://staging-dashboard.aro.network",
          "BaseWSURL": "wss://staging-ws.aro.network"
        }
      });

      LoggerService().info('Init result: $initResult ------- ');
      service.nodeSignUp(); // Move inside try block
    } catch (e) {
      print('Error initializing node: $e');
      LoggerService().error('Error initializing node', e);
    }
  }

  void sendToWeb(Map<String, dynamic> data) {
    final json = jsonEncode(data);
    final script = 'window.onFlutterMessage($json);';
    if (_isDesktop) {
      _desktopWebview?.evaluateJavaScript(script);
    } else {
      _mobileController?.runJavaScript(script);
    }
  }

  @override
  void initState() {
    super.initState();
    // Initialize node in background, don't block UI
    initNode().catchError((e) {
      print('initNode error caught: $e');
    });
    
    if (_isDesktop) {
      // 桌面平台使用 desktop_webview_window
      _initDesktopWebview();
    } else {
      // 移动平台使用 webview_flutter
      _mobileController = WebViewController()
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
        ..loadRequest(
            Uri.parse('https://0ee63895-262b.ipproxy.aro.network/desktop'));
    }
  }
  
  Future<void> _initDesktopWebview() async {
    try {
      _desktopWebview = await WebviewWindow.create(
        configuration: CreateConfiguration(
          windowWidth: 360,
          windowHeight: 640,
          title: 'Aro Client',
          titleBarTopPadding: Platform.isMacOS ? 20 : 0,
        ),
      );
      
      _desktopWebview?.addOnWebMessageReceivedCallback((message) {
        print('Received Web message: $message');
        handleWebMessage(message);
      });
      
      _desktopWebview?.launch('https://0ee63895-262b.ipproxy.aro.network/desktop');
    } catch (e) {
      print('Failed to create desktop webview: $e');
    }
  }

  @override
  void dispose() {
    _desktopWebview?.close();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    if (_isDesktop) {
      // 桌面平台：desktop_webview_window 在单独窗口运行
      // 这里显示一个占位 UI
      return Scaffold(
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const CircularProgressIndicator(),
              const SizedBox(height: 16),
              const Text('WebView 正在独立窗口中运行...'),
              const SizedBox(height: 16),
              ElevatedButton(
                onPressed: () {
                  _desktopWebview?.launch('https://0ee63895-262b.ipproxy.aro.network/desktop');
                },
                child: const Text('重新打开 WebView'),
              ),
            ],
          ),
        ),
      );
    }
    
    // 移动平台使用嵌入式 WebView
    return Scaffold(
      body: _mobileController != null 
          ? WebViewWidget(controller: _mobileController!)
          : const Center(child: CircularProgressIndicator()),
    );
  }
}
