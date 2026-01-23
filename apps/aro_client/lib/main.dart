import 'dart:async';
import 'package:flutter/material.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';
import 'package:aro_client/components/path_provider.dart';
import 'package:aro_client/ffi/study_service.dart';
import 'package:aro_client/services/AppServiceStarter.dart';
import 'package:aro_client/services/logger_service.dart';
import 'package:window_manager/window_manager.dart';
import 'dart:io';
import 'package:s_webview/s_webview.dart';
import 'package:webview_flutter/webview_flutter.dart';
import 'dart:convert';

void main() async {
  runZonedGuarded(() async {
    WidgetsFlutterBinding.ensureInitialized();

    await LoggerService().initialize();
    LoggerService().info('App starting...');

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
  late final WebViewController _controller;
  final service = StudyService.instance;

  // void sendToWeb(Map<String, dynamic> data) {
  //   final json = jsonEncode(data);
  //   _controller.runJavaScript(
  //     'window.onFlutterMessage($json);',
  //   );
  // }

  void sendMessageToWeb(Map<String, dynamic> data) {
    final json = jsonEncode(data);
    _controller.runJavaScript('''
    window.onFlutterMessage && window.onFlutterMessage($json);
  ''');
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
      final service = StudyService.instance;
      final initResult = service.nodeInit(appDir, {
        "config": {
          "BaseAPIURL": "https://staging-dashboard.aro.network",
          "BaseWSURL": "wss://staging-ws.aro.network"
        }
      });

      LoggerService().info('Init result: $initResult ------- ');
    } catch (e) {
      print('Error initializing node: $e');
    }
    service.nodeSignUp();
  }

  void sendToWeb(Map<String, dynamic> data) {
    final json = jsonEncode(data);
    _controller.runJavaScript(
      'window.onFlutterMessage($json);',
    );
  }

  @override
  void initState() {
    super.initState();
    // Initialize node in background, don't block UI
    initNode().catchError((e) {
      print('initNode error caught: $e');
    });
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

            // sendToWeb({
            //   'type': 'nodeInfo',
            //   'payload': jsonDecode(service.getNodeStat()),
            // });
            // sendToWeb({
            //   'type': 'nodeRewards',
            //   'payload': jsonDecode(res),
            // });
          },
        ),
      )
      ..loadRequest(
          Uri.parse('https://0ee63895-262b.ipproxy.aro.network/desktop'));
    // Uri.parse('http://192.168.50.179:3000'));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: WebViewWidget(controller: _controller),
    );
  }
}
