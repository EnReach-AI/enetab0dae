import 'dart:async';
import 'dart:ffi' show Abi;
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
import 'package:shared_preferences/shared_preferences.dart';
import 'package:permission_handler/permission_handler.dart';
import 'package:window_manager/window_manager.dart';
import 'dart:io';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:tray_manager/tray_manager.dart';
import 'package:path/path.dart' as p;
import 'dart:convert';
import 'package:aro_client/utils/config.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart' as inapp;
import 'package:url_launcher/url_launcher.dart';
import 'package:aro_client/services/webview_memory_manager.dart';

void main(List<String> args) async {
  // if (Platform.isMacOS && !bool.fromEnvironment('dart.vm.product')) {
  //   final abi = Abi.current();
  //   final debugFileName =
  //       abi == Abi.macosArm64 ? 'libstudy-arm.dylib' : 'libstudy-amd.dylib';
  //   StudyLibrary.setOverridePath(p.join('lib', 'ffi', 'macos', debugFileName));
  // }
  WidgetsFlutterBinding.ensureInitialized();
  await _prepareDesktopWindow();
  // await ConnectivityService().initialize();

  runApp(const MyApp());
}

Future<void> _prepareDesktopWindow() async {
  if (!(Platform.isMacOS || Platform.isWindows || Platform.isLinux)) {
    return;
  }

  await windowManager.ensureInitialized();

  const windowOptions = WindowOptions(
    size: Size(360, 640),
    center: true,
    minimumSize: Size(360, 640),
    maximumSize: Size(360, 640),
    title: 'ARO Desktop',
  );

  await windowManager.waitUntilReadyToShow(windowOptions);

  try {
    await windowManager.show();
  } catch (_) {}

  if (Platform.isWindows) {
    try {
      await windowManager.setMinimizable(false);
      await windowManager.setMaximizable(false);
    } catch (_) {}
  }
}

// Headless entrypoint for background init (invoked from ForegroundService).
@pragma('vm:entry-point')
void backgroundMain() async {
  print('[backgroundMain] starting');
  WidgetsFlutterBinding.ensureInitialized();
  await _runBackgroundInit();
}

Future<void> _runBackgroundInit() async {
  try {
    if (!Platform.isAndroid) {
      print('Background init skipped: not Android');
      return;
    }
    await LoggerService().initialize();
    await ConnectivityService().initialize();
    await _configureStudyLibraryOverridePath();
    StudyLibrary.ensureInitialized();

    final appDir = await getAppSupportDir();
    LoggerService().info('Background init appDir: $appDir');

    final initResult = StudyService.instance.nodeInit({
      "appDir": appDir,
      "config": {"BaseAPIURL": AllConfig.apiBase},
    });
    LoggerService().info('Background init result: $initResult');
  } catch (e, s) {
    // Use Logger if ready; otherwise print.
    try {
      LoggerService().error('Background init failed', e, s);
    } catch (_) {
      // ignore logger errors
    }
    print('Background init failed: $e');
    print(s);
  }
}

Future<void> _configureStudyLibraryOverridePath() async {
  if (!(Platform.isMacOS ||
      Platform.isAndroid ||
      Platform.isWindows ||
      Platform.isLinux)) {
    return;
  }

  final pinnedPath = await LibUpdateService.instance.readPinnedLibraryPath();
  if (pinnedPath != null) {
    StudyLibrary.setOverridePath(pinnedPath);
    LoggerService().info('StudyLibrary pinned override path: $pinnedPath');
    return;
  }

  final appSupportDir = await getAppSupportDir();
  if (Platform.isMacOS) {
    final abi = Abi.current();
    final preferredFile =
        abi == Abi.macosArm64 ? 'libstudy-arm.dylib' : 'libstudy-amd.dylib';
    final preferredPath = p.join(appSupportDir, preferredFile);
    final overridePath =
        File(preferredPath).existsSync() ? preferredPath : null;
    StudyLibrary.setOverridePath(overridePath);
    LoggerService().info(
      'StudyLibrary macOS override path: ${overridePath ?? '(none)'}',
    );
    return;
  }

  final overrideFile = Platform.isWindows ? 'libstudy.dll' : 'libstudy.so';
  final overridePath = p.join(appSupportDir, overrideFile);
  StudyLibrary.setOverridePath(overridePath);
  LoggerService().info('StudyLibrary override path: $overridePath');
}

class MyApp extends StatelessWidget {
  static const platform = MethodChannel('com.aro.aro_app/foreground');

  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: Platform.isAndroid ? 'ARO Mobile' : 'ARO Desktop',
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
    with TrayListener, WindowListener, WidgetsBindingObserver {
  WebViewController? _controller;
  String? _mobileWebViewCurrentUrl;
  int _mobileWebViewTimeoutRetryCount = 0;
  static const int _maxMobileWebViewTimeoutRetries = 2;
  Timer? _webViewRecoveryTimer;
  Timer? _updateCheckTimer;
  // win.WebviewController? _winController;
  inapp.InAppWebViewController? _desktopController;
  // bool _isWindowsInit = false;
  // String? _errorMessage;
  bool _isDesktopWebViewReady = false;
  bool _isWebViewLoading = true;
  bool _isInitializing = true;
  bool _isAppInitialized = false;
  String? _initError;
  String? _desktopWebViewError;
  bool _isConnected = true;
  bool _webViewNetworkIssue = false;

  bool _trayMenuOpening = false;
  bool _isShuttingDown = false;

  final _memoryManager = WebViewMemoryManager();

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
    print(
        'build: _isInitializing=$_isInitializing, _initError=$_initError, _controller=$_controller');
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
        LoggerService().info(
            '[Restart] Restarting ForegroundService to reload updated library...');
        try {
          // 1. Stop the Service with explicit update cleanup.
          await MyApp.platform.invokeMethod('stopServiceForUpdate');
          // Brief pause to let the system clean up the old process
          await Future.delayed(const Duration(milliseconds: 500));
          // 2. Start the Service again → new :bg process loads updated library
          await MyApp.platform.invokeMethod('startService');
          // 3. Relaunch the UI process automatically.
          await MyApp.platform.invokeMethod('restartApp');
          return;
        } catch (e) {
          LoggerService().error('[Restart] Platform channel failed', e);
        }
        // Fallback if platform restart fails.
        exit(0);
      }

      if (Platform.isMacOS) {
        final exePath = Platform.resolvedExecutable;
        final exeDir = Directory(exePath).parent;
        final appBundlePath = p.normalize(p.join(exeDir.path, '..', '..'));
        // Spawn a detached process that waits for this app to exit, then reopens it.
        // Using 'open' directly while the app is running just activates the
        // existing window instead of launching a new instance.
        final escaped = appBundlePath.replaceAll("'", "'\\''");
        await Process.start(
          'bash',
          ['-c', "sleep 1 && open '$escaped'"],
          mode: ProcessStartMode.detached,
        );
        exit(0);
      }

      if (Platform.isWindows) {
        final exePath = Platform.resolvedExecutable;
        LoggerService().info('[Restart] Windows relaunch requested', {
          'exePath': exePath,
        });

        var relaunched = false;
        try {
          await Process.start(
            exePath,
            const ['--wait-for-single-instance'],
            mode: ProcessStartMode.detached,
          );
          relaunched = true;
          LoggerService().info('[Restart] Windows relaunch started directly');
        } catch (e, s) {
          LoggerService().error(
            '[Restart] Direct Windows relaunch failed, trying cmd fallback',
            e,
            s,
          );
          try {
            await Process.start(
              'cmd',
              ['/c', 'start', '', exePath, '--wait-for-single-instance'],
              mode: ProcessStartMode.detached,
            );
            relaunched = true;
            LoggerService().info('[Restart] Windows relaunch started via cmd');
          } catch (e2, s2) {
            LoggerService()
                .error('[Restart] Windows cmd fallback failed', e2, s2);
          }
        }

        if (relaunched) {
          await _shutdownAndExit();
          return;
        }

        exit(0);
      }

      if (Platform.isLinux) {
        final exePath = Platform.resolvedExecutable;
        final escaped = exePath.replaceAll("'", "'\\''");
        await Process.start(
          'bash',
          ['-c', "sleep 1 && '$escaped'"],
          mode: ProcessStartMode.detached,
        );
        exit(0);
      }
    } catch (e) {
      LoggerService().error('Restart failed', e);
    }
  }

  /// Proactively check for library updates at startup without relying on
  /// WebView messages. If an update is found, download and auto-restart.
  Future<void> _autoCheckAndUpdate() async {
    // Wait a few seconds after init so the node has time to fetch
    // the latest version info from the server.
    await Future.delayed(const Duration(seconds: 5));
    try {
      final version = service.getCurrentVersion();
      final version2 = service.getLastVersion();

      final versionMap = jsonDecode(version);
      final versionMap2 = jsonDecode(version2);

      LoggerService().info(
          '[AutoUpdate] currentVersion=$versionMap latestVersion=$versionMap2');

      if (versionMap['code'] != 200 || versionMap2['code'] != 200) {
        LoggerService().info('[AutoUpdate] Version info unavailable, skipping');
        return;
      }

      if (versionMap2 is! Map<String, dynamic>) return;

      Map<String, dynamic>? updateResult;

      if (Platform.isMacOS) {
        updateResult = await LibUpdateService.instance.checkAndUpdateMacOS(
          currentVersionMap: versionMap,
          latestVersionMap: versionMap2,
        );
      } else if (Platform.isAndroid) {
        updateResult = await LibUpdateService.instance.checkAndUpdateAndroid(
          currentVersionMap: versionMap,
          latestVersionMap: versionMap2,
        );
      } else if (Platform.isWindows) {
        updateResult = await LibUpdateService.instance.checkAndUpdateWindows(
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
        LoggerService().info('[AutoUpdate] result: $updateResult');
        if (updateResult['updated'] == true ||
            updateResult['restartRequired'] == true) {
          LoggerService().info('[AutoUpdate] Auto-restarting after update...');
          await _restartApp();
        }
      }
    } catch (e) {
      LoggerService().error('[AutoUpdate] Auto update check failed', e);
    }
  }

  Future<void> _showAndroidAppSettingsDialog() async {
    if (!mounted) return;
    try {
      // Only show on first launch after install
      final prefs = await SharedPreferences.getInstance();
      final hasShownFirstLaunchDialog =
          prefs.getBool('has_shown_first_launch_dialog') ?? false;
      if (hasShownFirstLaunchDialog) return;

      // Mark as shown so it never shows again
      await prefs.setBool('has_shown_first_launch_dialog', true);

      if (!mounted) return;

      // 1) Request notification permission (first install won't have it enabled)
      try {
        final notificationStatus = await Permission.notification.status;
        if (notificationStatus.isDenied || notificationStatus.isRestricted) {
          await Permission.notification.request();
        }
      } catch (e) {
        LoggerService().error('Failed to request notification permission', e);
      }

      if (!mounted) return;

      // 2) Show app settings dialog
      await showDialog<void>(
        context: context,
        barrierDismissible: true,
        builder: (context) {
          return AlertDialog(
            title: const Text('Optimize App Performance'),
            content: const Text(
              'To ensure ARO Mobile runs reliably, please go to App Settings and enable the following:\n\n'
              '1. Notifications — Allow notifications so the background service can run properly.\n\n'
              '2. Background running — Allow the app to run in the background to keep your node online.\n\n'
              '3. Auto-start — Enable auto-start so the app can restart automatically after a reboot.',
            ),
            actions: [
              TextButton(
                onPressed: () {
                  Navigator.of(context).pop();
                },
                child: const Text('Later'),
              ),
              TextButton(
                onPressed: () async {
                  Navigator.of(context).pop();
                  try {
                    await MyApp.platform.invokeMethod('openAppSettings');
                  } catch (e) {
                    LoggerService().error('Failed to open app settings', e);
                  }
                },
                child: const Text('Go to Settings'),
              ),
            ],
          );
        },
      );
    } catch (e) {
      LoggerService().error('Show app settings dialog failed', e);
    }
  }

  void handleWebMessage(String message) async {
    print('messagehandleWebMessage $message');
    LoggerService().info('Received web message: $message');
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
        LoggerService().info('statMap nodeInfo : $statMap');

        if (statMap['code'] == 200) {
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
      LoggerService().info('node rewardsMap: $rewardsMap');
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
        if (versionMap2['code'] == 200) {
          if (versionMap2 is Map<String, dynamic>) {
            Map<String, dynamic>? updateResult;

            if (Platform.isMacOS) {
              updateResult =
                  await LibUpdateService.instance.checkAndUpdateMacOS(
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
              updateResult =
                  await LibUpdateService.instance.checkAndUpdateLinux(
                currentVersionMap: versionMap,
                latestVersionMap: versionMap2,
              );
            }

            if (updateResult != null) {
              print('updateResult getVersion $updateResult');
              LoggerService().info('Library update result: $updateResult');
              if (updateResult['updated'] == true ||
                  updateResult['restartRequired'] == true) {
                LoggerService().info('Auto-restarting after update...');
                await _restartApp();
              }
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
      print('Before nodeInit');
      final initResult = service.nodeInit({
        "appDir": appDir,
        "config": {"BaseAPIURL": AllConfig.apiBase},
      });
      print('After nodeInit');
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
    WidgetsBinding.instance.addObserver(this);
    _isWebViewLoading = true;

    _setupConnectivityListener();

    if (Platform.isWindows) {
      trayManager.addListener(this);
      windowManager.addListener(this);
      // NOTE: setPreventClose and tray menu setup are deferred to _asyncInit
      // AFTER windowManager.ensureInitialized() and trayManager.setIcon().
      // Calling them here (before initialization) caused explorer.exe to hang,
      // making desktop icons unclickable.
    }

    if (Platform.isWindows || Platform.isLinux) {
      WidgetsBinding.instance.addPostFrameCallback((_) {
        if (mounted) {
          setState(() {
            _isDesktopWebViewReady = true;
          });
        }
      });
      Timer(const Duration(seconds: 20), () {
        if (!mounted) return;
        if (_desktopController != null) return;
        if (_desktopWebViewError != null) return;
        setState(() {
          _desktopWebViewError = 'Failed to initialize.';
        });
      });
    }
    unawaited(_asyncInit());
  }

  Future<void> _asyncInit() async {
    setState(() {
      print('setState: initializing = true');
      _isInitializing = true;
      _initError = null;
    });
    try {
      await Future.delayed(const Duration(milliseconds: 5)); // 极短延迟，保证UI渲染

      await LoggerService().initialize();
      LoggerService().info('App starting...');

      // // 网络服务初始化
      await ConnectivityService().initialize();

      // 动态库路径设置
      await _configureStudyLibraryOverridePath();
      StudyLibrary.ensureInitialized();

      // 节点初始化
      await initNode();

      // 主动检查并自动更新（不依赖WebView消息）
      unawaited(_autoCheckAndUpdate());

      // 每10分钟定期检查更新
      _updateCheckTimer?.cancel();
      _updateCheckTimer = Timer.periodic(
        const Duration(minutes: 10),
        (_) => unawaited(_autoCheckAndUpdate()),
      );

      // 窗口启动阶段已在 main() 中完成，避免 Windows 固定停在左上角遮住桌面图标。
      if (Platform.isWindows) {
        try {
          final exeDir = p.dirname(Platform.resolvedExecutable);
          final iconPath = p.join(exeDir, 'resources', 'app_icon.ico');
          await trayManager.setIcon(iconPath);
          await trayManager.setToolTip('ARO Desktop');
          await _setupWindowsTrayMenu();
        } catch (e) {
          LoggerService().error('Failed to setup Windows tray icon', e);
        }
      }
      if (Platform.isAndroid) {
        AppServiceStarter.startForegroundService();
      }

      setState(() {
        print('setState: initializing = false, appInitialized = true');
        _isInitializing = false;
        _isAppInitialized = true;
      });

      // Show app-settings prompt on Android after initialization completes
      if (Platform.isAndroid) {
        WidgetsBinding.instance.addPostFrameCallback((_) {
          _showAndroidAppSettingsDialog();
        });
      }
    } catch (e) {
      LoggerService().error('Failed _asyncInit', e);

      setState(() {
        print('setState: initializing = false, error');
        _isInitializing = false;
        _initError = e.toString();
      });
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
    await _shutdownAndExit();
  }

  Future<void> _shutdownAndExit() async {
    if (_isShuttingDown) return;
    _isShuttingDown = true;

    if (Platform.isWindows) {
      try {
        trayManager.removeListener(this);
      } catch (_) {}
      try {
        windowManager.removeListener(this);
      } catch (_) {}
      try {
        await trayManager.destroy();
      } catch (_) {}
      try {
        await windowManager.destroy();
      } catch (_) {}
    }

    try {
      _updateCheckTimer?.cancel();
      _updateCheckTimer = null;
      _memoryManager.dispose();
      _desktopController?.dispose();
      _desktopController = null;
      _controller = null;
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
    if (_isShuttingDown) return;
    await _trayHide();
  }

  void _setupConnectivityListener() {
    final connectivityService = ConnectivityService();
    _isConnected = connectivityService.isConnected;

    var lastConnected = _isConnected;

    connectivityService.addListener((isConnected) {
      final connectionRestored = !lastConnected && isConnected;
      lastConnected = isConnected;

      if (!mounted) return;

      setState(() {
        _isConnected = isConnected;
      });

      // If we were showing the offline overlay due to a main-frame load error,
      // try a single reload when connectivity comes back (common after macOS
      // sleep/wake).
      if (connectionRestored && _webViewNetworkIssue) {
        _scheduleWebViewRecovery(
          reason: 'connectivity restored',
          delay: const Duration(milliseconds: 400),
        );
      }
    });
  }

  void _scheduleWebViewRecovery({
    required String reason,
    Duration delay = const Duration(milliseconds: 600),
  }) {
    if (_isShuttingDown) return;
    final existingTimer = _webViewRecoveryTimer;
    if (existingTimer != null && existingTimer.isActive) return;

    _webViewRecoveryTimer = Timer(delay, () {
      _webViewRecoveryTimer = null;
      if (!mounted) return;

      try {
        if (Platform.isWindows || Platform.isLinux) {
          _desktopController?.reload();
        } else {
          _controller?.reload();
        }
        LoggerService().info('WebView reload triggered ($reason)');
      } catch (e, s) {
        LoggerService().error('WebView reload failed ($reason)', e, s);
      }
    });
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    super.didChangeAppLifecycleState(state);
    // When the app is resumed after being paused (e.g. macOS sleep/wake),
    // proactively clean up WebView memory to reduce OOM risk.
    if (state == AppLifecycleState.resumed) {
      LoggerService()
          .info('[Lifecycle] App resumed — triggering memory cleanup');
      _memoryManager.manualCleanup();
    }
  }

  @override
  void dispose() {
    WidgetsBinding.instance.removeObserver(this);
    _memoryManager.dispose();

    if (Platform.isWindows) {
      try {
        trayManager.removeListener(this);
      } catch (_) {}
      try {
        windowManager.removeListener(this);
      } catch (_) {}
      try {
        trayManager.destroy();
      } catch (_) {}
    }

    try {
      _webViewRecoveryTimer?.cancel();
    } catch (_) {}
    _webViewRecoveryTimer = null;

    try {
      _updateCheckTimer?.cancel();
    } catch (_) {}
    _updateCheckTimer = null;

    // Properly dispose WebView controllers instead of just nulling them
    try {
      _desktopController?.dispose();
    } catch (_) {}
    _desktopController = null;
    _controller = null;
    ConnectivityService().dispose();
    super.dispose();
  }

  void _initMobileWebView() {
    try {
      print('[DEBUG] _initMobileWebView called');
      _controller = WebViewController();

      _controller!.setJavaScriptMode(JavaScriptMode.unrestricted);

      _controller!.addJavaScriptChannel(
        'Flutter',
        onMessageReceived: (JavaScriptMessage message) {
          print('[DEBUG] Received Web message: $message');
          handleWebMessage(message.message);
        },
      );

      _controller!.setNavigationDelegate(
        NavigationDelegate(
          onWebResourceError: (error) {
            final url = _mobileWebViewCurrentUrl ?? 'unknown';
            final isMainFrame = error.isForMainFrame != false;
            final message =
                'WebView error: ${error.description} (${error.errorCode}) '
                'type=${error.errorType} mainFrame=$isMainFrame url=$url';

            if (isMainFrame) {
              LoggerService().error(message);

              if (mounted) {
                setState(() {
                  _webViewNetworkIssue = true;
                });
              }

              // WKWebView network errors that commonly happen after macOS sleep/wake.
              const retryableMainFrameErrorCodes = <int>{
                -1001, // NSURLErrorTimedOut
                -1005, // NSURLErrorNetworkConnectionLost
                -1009, // NSURLErrorNotConnectedToInternet
              };
              if (retryableMainFrameErrorCodes.contains(error.errorCode) &&
                  _mobileWebViewTimeoutRetryCount <
                      _maxMobileWebViewTimeoutRetries) {
                _mobileWebViewTimeoutRetryCount += 1;
                final attempt = _mobileWebViewTimeoutRetryCount;

                LoggerService().warning(
                    'WebView main-frame request failed (${error.errorCode}). ');

                _scheduleWebViewRecovery(
                  reason:
                      'main-frame error ${error.errorCode} (retry $attempt)',
                  delay: Duration(milliseconds: 600 * attempt),
                );
              }
              return;
            }

            // Subresource errors are often non-fatal (image/js/etc).
            LoggerService().warning(message);
          },
          onProgress: (progress) {
            if (progress == 100) {
              if (_isWebViewLoading) {
                print('[DEBUG] progress=100 stop loading');
                setState(() {
                  _isWebViewLoading = false;
                });
              }
            }
            print('[DEBUG] progress=100 stop loading $progress');
          },
          onPageFinished: (_) {
            print('[DEBUG] onPageFinished called');
            setState(() {
              print('[DEBUG] setState: _isWebViewLoading = false');
              _isWebViewLoading = false;
              _webViewNetworkIssue = false;
            });

            _mobileWebViewTimeoutRetryCount = 0;

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

              // Memory leak prevention: clean up detached DOM nodes and
              // event listeners that may accumulate over long sessions.
              (function() {
                // Limit console history to prevent memory buildup from logging
                if (window.console && window.console.clear) {
                  setInterval(function() { console.clear(); }, 1800000); // every 30 min
                }
                // Periodically nullify stale references in global scope caches
                // that frameworks may create
                setInterval(function() {
                  try {
                    if (window.gc) { window.gc(); }
                    // Release image bitmap caches
                    if (window.createImageBitmap) {
                      var imgs = document.querySelectorAll('img[src^="blob:"]');
                      imgs.forEach(function(img) {
                        if (img.src && img.src.startsWith('blob:')) {
                          URL.revokeObjectURL(img.src);
                        }
                      });
                    }
                  } catch(e) {}
                }, 3600000); // every 60 min
              })();
            ''');
          },
          onPageStarted: (url) {
            print('[DEBUG] onPageStarted $url');

            final previousUrl = _mobileWebViewCurrentUrl;
            _mobileWebViewCurrentUrl = url;
            if (previousUrl != url) {
              _mobileWebViewTimeoutRetryCount = 0;
            }

            setState(() {
              _isWebViewLoading = true;
            });

            Future.delayed(const Duration(seconds: 8), () {
              if (mounted && _isWebViewLoading) {
                print('[DEBUG] fallback stop loading');
                setState(() {
                  _isWebViewLoading = false;
                });
              }
            });
          },
        ),
      );

      final url = Platform.isAndroid || Platform.isIOS
          ? AllConfig.mobileURL
          : AllConfig.deskTopURL;
      print('[DEBUG] WebView loading url: $url');
      _mobileWebViewCurrentUrl = url;
      _mobileWebViewTimeoutRetryCount = 0;
      _controller!.loadRequest(Uri.parse(url));

      // Start memory management for mobile/macOS WebView
      _memoryManager.start(mobileController: _controller);
    } catch (e) {
      print('[DEBUG] Error initializing webview: $e');
      LoggerService().error('Error initializing webview', e);
    }
  }

  @override
  Widget build(BuildContext context) {
    print(
        '[DEBUG] build() called, _isInitializing=$_isInitializing, _isAppInitialized=$_isAppInitialized, _controller=$_controller');
    if (Platform.isWindows || Platform.isLinux) {
      // Use Builder to ensure Hero system is fully disabled before creating InAppWebView
      if (!_isDesktopWebViewReady) {
        return const Scaffold(
          body: Center(child: CircularProgressIndicator()),
        );
      }
      LoggerService().error('Building desktop webview, error=$_controller');

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
            if (!_isConnected || _webViewNetworkIssue)
              _buildNetworkOfflineOverlay(),
          ],
        ),
      );
    }
    LoggerService().info(
        '[DEBUG] Using mobile webview, controller=$_controller -----  $mounted');
    // Use webview_flutter for macOS, Android, iOS
    if (_controller == null) {
      // Defer webview creation to next frame to avoid blocking UI thread
      WidgetsBinding.instance.addPostFrameCallback((_) {
        if (mounted && _controller == null) {
          _initMobileWebView();
        }
      });
      return Scaffold(
        body: Container(
          color: Colors.white,
          child: const Center(
            child: CircularProgressIndicator(),
          ),
        ),
      );
    }
    print(
        'build: _isInitializing=$_isInitializing, _initError=$_initError, _controller=$_controller');
    if (_isInitializing || !_isAppInitialized) {
      return Scaffold(
        body: Container(
          color: Colors.black,
          child: const Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                SizedBox(height: 24),
                Text('Initializing, please wait...',
                    style: TextStyle(fontSize: 18, color: Colors.white)),
              ],
            ),
          ),
        ),
      );
    }
    if (_initError != null) {
      return Scaffold(
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Icon(Icons.error, color: Colors.red, size: 48),
              const SizedBox(height: 16),
              Text('Initialization failed: $_initError',
                  style: const TextStyle(fontSize: 16)),
              const SizedBox(height: 16),
              ElevatedButton(
                onPressed: _asyncInit,
                child: const Text('Retry'),
              ),
            ],
          ),
        ),
      );
    }
    // String errorMessage = 'Failed to load page';

    print('[DEBUG] build() _isWebViewLoading=$_isWebViewLoading');
    return Scaffold(
      body: Stack(
        children: [
          WebViewWidget(controller: _controller!),
          if (_isWebViewLoading)
            Container(
              color: Colors.black,
              child: Center(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    const CircularProgressIndicator(
                      color: Colors.white,
                    ),
                    const SizedBox(height: 16),
                  ],
                ),
              ),
            ),
          if (!_isConnected || _webViewNetworkIssue)
            _buildNetworkOfflineOverlay(),
        ],
      ),
    );
  }

  Widget _buildNetworkOfflineOverlay() {
    return Container(
      decoration: const BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.centerLeft,
          end: Alignment.centerRight,
          transform: GradientRotation(0.3403392041388943),
          colors: [
            Color(0xFF000000),
            Color(0xFF3A3A3A),
            Color(0xFF3A3A3A),
            Color(0xFF000000),
          ],
          stops: [
            0.2909,
            0.7228,
            0.7665,
            0.95,
          ],
        ),
      ),
      child: Stack(
        children: [
          // Top header image
          Align(
            alignment: Alignment.topCenter,
            child: SafeArea(
              bottom: false,
              child: SizedBox(
                width: double.infinity,
                height: 120,
                child: Image.asset(
                  'lib/assets/header.png',
                  fit: BoxFit.cover,
                ),
              ),
            ),
          ),

          // Centered main content
          Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Platform.isAndroid
                    ? Image.asset(
                        'lib/assets/gr-logo-mobile.png',
                        width: 142,
                        height: 30,
                      )
                    : Image.asset(
                        'lib/assets/gr-logo-desktop.png',
                        width: 142,
                        height: 30,
                      ),
                const SizedBox(height: 24),
                Text(
                  Platform.isAndroid
                      ? 'Your mobile version ARO node.\nNow in your pocket. Take it anywhere.'
                      : '''
A lightweight desktop app.
One-click start and forget it.
''',
                  style: const TextStyle(
                    fontSize: 14,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                  ),
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 12),
              ],
            ),
          ),
          const Align(
            alignment: Alignment.bottomCenter,
            child: Padding(
              padding: EdgeInsets.only(bottom: 118.0),
              child: Text(
                'Connecting...',
                style: TextStyle(fontSize: 15, color: Colors.white),
                textAlign: TextAlign.center,
              ),
            ),
          ),
          // Bottom green bar
          Align(
            alignment: Alignment.bottomCenter,
            child: SafeArea(
              top: false,
              child: Container(
                height: 98,
                decoration: BoxDecoration(
                  color: const Color(0xFF02B421),
                  borderRadius: const BorderRadius.only(
                    topLeft: Radius.circular(30),
                    topRight: Radius.circular(30),
                  ),
                  boxShadow: [
                    BoxShadow(
                      color: Colors.black.withOpacity(0.2),
                      blurRadius: 8,
                      offset: const Offset(0, 2),
                    ),
                  ],
                ),
                child: const Center(
                  child: Padding(
                    padding: EdgeInsets.symmetric(horizontal: 10.0),
                    child: Text.rich(
                      TextSpan(
                        children: [
                          WidgetSpan(
                            alignment: PlaceholderAlignment.middle,
                            child: Icon(
                              Icons.info_outline,
                              size: 18,
                              color: Colors.white,
                            ),
                          ),
                          WidgetSpan(child: SizedBox(width: 8)),
                          TextSpan(
                            text:
                                'There seems to be a network issue, please check your internet connectivity.',
                          ),
                        ],
                      ),
                      style: TextStyle(
                        fontSize: 12,
                        color: Colors.white,
                        fontWeight: FontWeight.w400,
                      ),
                      textAlign: TextAlign.center,
                    ),
                  ),
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildDesktopWebView() {
    LoggerService()
        .info('Building desktop webview, controller=$_desktopController');
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
          if (mounted && _webViewNetworkIssue) {
            setState(() {
              _webViewNetworkIssue = false;
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

          // Start memory management for desktop WebView
          _memoryManager.start(desktopController: controller);
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

              // Memory leak prevention for long-running sessions
              (function() {
                if (window.console && window.console.clear) {
                  setInterval(function() { console.clear(); }, 1800000);
                }
                setInterval(function() {
                  try {
                    if (window.gc) { window.gc(); }
                    var imgs = document.querySelectorAll('img[src^="blob:"]');
                    imgs.forEach(function(img) {
                      if (img.src && img.src.startsWith('blob:')) {
                        URL.revokeObjectURL(img.src);
                      }
                    });
                  } catch(e) {}
                }, 3600000);
              })();
            ''');
          } catch (e) {
            LoggerService().error('Failed to evaluate JavaScript', e);
          }

          if (!mounted) return;
          if (!_webViewNetworkIssue) return;
          setState(() {
            _webViewNetworkIssue = false;
          });
        },
        onReceivedError: (controller, request, error) {
          final isMainFrame = request.isForMainFrame == true;
          final msg =
              'WebView error: ${error.description} (${error.type}) mainFrame=$isMainFrame url=${request.url}';

          if (isMainFrame) {
            LoggerService().error(msg, error);
            if (!mounted) return;
            setState(() {
              _webViewNetworkIssue = true;
              _desktopWebViewError = null;
            });
            return;
          }

          LoggerService().warning(msg, error);
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
      // String errorMessage = 'Failed to load page';

      return Scaffold(
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                const Icon(Icons.error_outline, size: 48, color: Colors.red),
                const SizedBox(height: 16),
              ],
            ),
          ),
        ),
      );
    }
  }
}
