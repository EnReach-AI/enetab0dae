import 'dart:async';
import 'dart:ffi' show Abi;
import 'dart:isolate';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
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
import 'package:webview_flutter_android/webview_flutter_android.dart';
import 'package:tray_manager/tray_manager.dart';
import 'package:path/path.dart' as p;
import 'dart:convert';
import 'package:aro_client/utils/config.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart' as inapp;
import 'package:url_launcher/url_launcher.dart';
import 'package:aro_client/services/webview_memory_manager.dart';

String? _studyLibraryOverridePathCache;

const Duration _autoUpdateInitialDelay = Duration(seconds: 5);
const Duration _autoUpdateCheckInterval = Duration(minutes: 10);
const Duration _autoUpdateThrottleWindow = Duration(minutes: 9);
const String _autoUpdateStampFileName = 'libstudy.auto_update.last_check';

Timer? _backgroundAutoUpdateTimer;
bool _backgroundAutoUpdateLoopStarted = false;
bool _autoUpdateCheckInProgress = false;

enum _InitialBindState {
  resolved,
  pending,
  invalidPayload,
}

String _loadNodeStatInBackground(String? overridePath) {
  StudyLibrary.setOverridePath(overridePath);
  StudyLibrary.ensureInitialized();
  return StudyService.instance.getNodeStat();
}

Future<void> _restartAppForUpdatedLibrary({
  bool launchUiOnAndroid = true,
}) async {
  try {
    if (Platform.isAndroid) {
      if (!launchUiOnAndroid) {
        LoggerService().info(
          '[Restart] Restarting Android background engine after update...',
        );
        try {
          await MyApp.platform.invokeMethod('restartServiceForUpdate');
        } catch (e, s) {
          LoggerService().error(
            '[Restart] Background Android service restart failed',
            e,
            s,
          );
        }
        return;
      }

      LoggerService().info(
        '[Restart] Restarting ForegroundService to reload updated library...',
      );
      try {
        await MyApp.platform.invokeMethod('stopServiceForUpdate');
        await Future.delayed(const Duration(milliseconds: 500));
        await MyApp.platform.invokeMethod('startService');
        await MyApp.platform.invokeMethod('restartApp');
        return;
      } catch (e, s) {
        LoggerService().error('[Restart] Platform channel failed', e, s);
      }

      exit(0);
    }

    if (Platform.isMacOS) {
      final exePath = Platform.resolvedExecutable;
      final exeDir = Directory(exePath).parent;
      final appBundlePath = p.normalize(p.join(exeDir.path, '..', '..'));
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
        exit(0);
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
  } catch (e, s) {
    LoggerService().error('Restart failed', e, s);
  }
}

Future<Map<String, dynamic>?> _checkAndUpdateCurrentPlatform({
  required Map<String, dynamic> currentVersionMap,
  required Map<String, dynamic> latestVersionMap,
}) async {
  if (Platform.isMacOS) {
    return LibUpdateService.instance.checkAndUpdateMacOS(
      currentVersionMap: currentVersionMap,
      latestVersionMap: latestVersionMap,
    );
  }

  if (Platform.isAndroid) {
    return LibUpdateService.instance.checkAndUpdateAndroid(
      currentVersionMap: currentVersionMap,
      latestVersionMap: latestVersionMap,
    );
  }

  if (Platform.isWindows) {
    return LibUpdateService.instance.checkAndUpdateWindows(
      currentVersionMap: currentVersionMap,
      latestVersionMap: latestVersionMap,
    );
  }

  if (Platform.isLinux) {
    return LibUpdateService.instance.checkAndUpdateLinux(
      currentVersionMap: currentVersionMap,
      latestVersionMap: latestVersionMap,
    );
  }

  return null;
}

Future<void> _performAutoUpdateCheck({
  required String trigger,
  bool launchUiOnAndroid = true,
}) async {
  final currentVersionRaw =
      jsonDecode(StudyService.instance.getCurrentVersion());
  final latestVersionRaw = jsonDecode(StudyService.instance.getLastVersion());

  if (currentVersionRaw is! Map || latestVersionRaw is! Map) {
    LoggerService().warning(
      '[AutoUpdate] [$trigger] Invalid version payload, skipping',
    );
    return;
  }

  final currentVersionMap = Map<String, dynamic>.from(currentVersionRaw);
  final latestVersionMap = Map<String, dynamic>.from(latestVersionRaw);

  LoggerService().info(
    '[AutoUpdate] [$trigger] currentVersion=$currentVersionMap '
    'latestVersion=$latestVersionMap',
  );

  if (currentVersionMap['code'] != 200 || latestVersionMap['code'] != 200) {
    LoggerService().info(
      '[AutoUpdate] [$trigger] Version info unavailable, skipping',
    );
    return;
  }

  final updateResult = await _checkAndUpdateCurrentPlatform(
    currentVersionMap: currentVersionMap,
    latestVersionMap: latestVersionMap,
  );

  if (updateResult == null) {
    LoggerService().info('[AutoUpdate] [$trigger] No updater for platform');
    return;
  }

  LoggerService().info('[AutoUpdate] [$trigger] result: $updateResult');

  if (updateResult['updated'] == true ||
      updateResult['restartRequired'] == true) {
    LoggerService().info(
      '[AutoUpdate] [$trigger] Auto-restarting after update...',
    );
    await _restartAppForUpdatedLibrary(
      launchUiOnAndroid: launchUiOnAndroid,
    );
  }
}

Future<void> _runCoordinatedAutoUpdateCheck({
  required String trigger,
  bool launchUiOnAndroid = true,
  Duration delay = Duration.zero,
  bool enforceThrottle = true,
}) async {
  if (delay > Duration.zero) {
    await Future.delayed(delay);
  }

  if (_autoUpdateCheckInProgress) {
    LoggerService().info(
      '[AutoUpdate] [$trigger] Check already in progress, skipping',
    );
    return;
  }

  _autoUpdateCheckInProgress = true;
  try {
    if (!enforceThrottle) {
      await _performAutoUpdateCheck(
        trigger: trigger,
        launchUiOnAndroid: launchUiOnAndroid,
      );
      return;
    }

    RandomAccessFile? lockHandle;
    final appDir = await getAppSupportDir();
    final stampFile = File(p.join(appDir, _autoUpdateStampFileName));
    final lockFile = File('${stampFile.path}.lock');
    var shouldStamp = false;

    try {
      await lockFile.create(recursive: true);
      lockHandle = await lockFile.open(mode: FileMode.append);
      await lockHandle.lock(FileLock.blockingExclusive);

      final now = DateTime.now();
      if (stampFile.existsSync()) {
        final raw = (await stampFile.readAsString()).trim();
        final millis = int.tryParse(raw);
        if (millis != null) {
          final lastCheck = DateTime.fromMillisecondsSinceEpoch(millis);
          final elapsed = now.difference(lastCheck);
          if (elapsed < _autoUpdateThrottleWindow) {
            LoggerService().info(
              '[AutoUpdate] [$trigger] Skipped; another process checked '
              '${elapsed.inSeconds}s ago',
            );
            return;
          }
        }
      }

      shouldStamp = true;
      await _performAutoUpdateCheck(
        trigger: trigger,
        launchUiOnAndroid: launchUiOnAndroid,
      );
    } finally {
      try {
        if (shouldStamp) {
          await stampFile.writeAsString(
            '${DateTime.now().millisecondsSinceEpoch}',
            flush: true,
          );
        }
      } catch (_) {}

      try {
        await lockHandle?.unlock();
      } catch (_) {}

      try {
        await lockHandle?.close();
      } catch (_) {}
    }
  } catch (e, s) {
    LoggerService()
        .error('[AutoUpdate] [$trigger] Auto update check failed', e, s);
  } finally {
    _autoUpdateCheckInProgress = false;
  }
}

void _startBackgroundAutoUpdateSchedule() {
  if (!Platform.isAndroid || _backgroundAutoUpdateLoopStarted) {
    return;
  }

  _backgroundAutoUpdateLoopStarted = true;
  LoggerService().info('[AutoUpdate] Starting Android background OTA schedule');

  unawaited(
    _runCoordinatedAutoUpdateCheck(
      trigger: 'android-background-startup',
      launchUiOnAndroid: false,
      delay: _autoUpdateInitialDelay,
    ),
  );

  _backgroundAutoUpdateTimer?.cancel();
  _backgroundAutoUpdateTimer = Timer.periodic(
    _autoUpdateCheckInterval,
    (_) => unawaited(
      _runCoordinatedAutoUpdateCheck(
        trigger: 'android-background-periodic',
        launchUiOnAndroid: false,
      ),
    ),
  );
}

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
    _startBackgroundAutoUpdateSchedule();
  } catch (e, s) {
    // Use Logger if ready; otherwise print.
    try {
      LoggerService().error('Background init failed', e, s);
    } catch (_) {
      // ignore logger errors
    }
    print('Background init failed: $e');
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
    _studyLibraryOverridePathCache = pinnedPath;
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
    _studyLibraryOverridePathCache = overridePath;
    StudyLibrary.setOverridePath(overridePath);
    LoggerService().info(
      'StudyLibrary macOS override path: ${overridePath ?? '(none)'}',
    );
    return;
  }

  final overrideFile = Platform.isWindows ? 'libstudy.dll' : 'libstudy.so';
  final overridePath = p.join(appSupportDir, overrideFile);
  _studyLibraryOverridePathCache = overridePath;
  StudyLibrary.setOverridePath(overridePath);
  LoggerService().info('StudyLibrary override path: $overridePath');
}

class MyApp extends StatelessWidget {
  static const platform = MethodChannel('com.aro.aro_app/foreground');
  static const windowsPlatform = MethodChannel('com.aro.aro_app/windows');
  static const appModePlatform = MethodChannel('app_mode');

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
  bool _isInitialNodeInfoLoading = true;
  bool _hasReceivedInitialNodeInfo = false;
  bool _hasInitialWebViewContentLoaded = false;

  bool _trayMenuOpening = false;
  bool _hasShownWindowsBackgroundNotice = false;
  bool _isShuttingDown = false;
  bool _isWindowsTrayReady = false;
  bool? _lastOfflineIconState;

  final _memoryManager = WebViewMemoryManager();

  final service = StudyService.instance;

  bool get _isEffectivelyOffline => !_isConnected || _webViewNetworkIssue;

  bool _forbidden = false;

  bool get _shouldShowStatusOverlay =>
      _isInitialNodeInfoLoading ||
      (_hasReceivedInitialNodeInfo && (!_isConnected || _webViewNetworkIssue));

  bool get _shouldShowStartupNodeInfoLoading =>
      _isInitialNodeInfoLoading && _isConnected && !_webViewNetworkIssue;

  String get _defaultWebViewUrl => Platform.isAndroid || Platform.isIOS
      ? AllConfig.mobileURL
      : AllConfig.deskTopURL;

  bool _isUsableWebViewUrl(String? url) {
    if (url == null) return false;

    final trimmed = url.trim();
    if (trimmed.isEmpty) return false;

    final uri = Uri.tryParse(trimmed);
    return uri != null && uri.hasScheme;
  }

  String _resolveMobileWebViewUrl([String? candidateUrl]) {
    if (_isUsableWebViewUrl(candidateUrl)) {
      return candidateUrl!.trim();
    }

    if (_isUsableWebViewUrl(_mobileWebViewCurrentUrl)) {
      return _mobileWebViewCurrentUrl!.trim();
    }

    return _defaultWebViewUrl;
  }

  void _logConnectivityIconSyncFailure(
    String message,
    Object error, [
    StackTrace? stackTrace,
  ]) {
    try {
      LoggerService().error(message, error, stackTrace);
    } catch (_) {
      debugPrint('$message: $error');
      if (stackTrace != null) {
        debugPrint(stackTrace.toString());
      }
    }
  }

  String _windowsTrayIconPath({required bool offline}) {
    final exeDir = p.dirname(Platform.resolvedExecutable);
    return p.join(
      exeDir,
      'resources',
      offline ? 'app_icon_offline.ico' : 'app_icon.ico',
    );
  }

  Future<void> _syncConnectivityIcon({bool force = false}) async {
    LoggerService().info('_webViewNetworkIssue', _webViewNetworkIssue);
    if (!(Platform.isMacOS || Platform.isWindows)) {
      return;
    }

    final isOffline = _isEffectivelyOffline;
    if (!force && _lastOfflineIconState == isOffline) {
      return;
    }
    _lastOfflineIconState = isOffline;

    if (Platform.isWindows) {
      if (_isWindowsTrayReady) {
        try {
          await trayManager.setIcon(_windowsTrayIconPath(offline: isOffline));
        } catch (e, s) {
          _logConnectivityIconSyncFailure(
            'Failed to update Windows tray icon',
            e,
            s,
          );
        }
      }

      try {
        await MyApp.windowsPlatform.invokeMethod('setConnectivityState', {
          'offline': isOffline,
        });
      } catch (e, s) {
        _logConnectivityIconSyncFailure(
          'Failed to update Windows app icon',
          e,
          s,
        );
      }
      return;
    }

    try {
      await MyApp.appModePlatform.invokeMethod('setConnectivityState', {
        'offline': isOffline,
      });
    } catch (e, s) {
      _logConnectivityIconSyncFailure('Failed to update macOS app icon', e, s);
    }
  }

  _InitialBindState _classifyInitialBindState(dynamic statPayload) {
    if (statPayload is! Map) return _InitialBindState.invalidPayload;
    if (statPayload['code'] != 200) return _InitialBindState.invalidPayload;

    final data = statPayload['data'];
    if (data is! Map) return _InitialBindState.invalidPayload;

    final bindValue = data['bind'];
    return bindValue is bool
        ? _InitialBindState.resolved
        : _InitialBindState.pending;
  }

  Future<String> _getNodeStatAsync() {
    final overridePath = _studyLibraryOverridePathCache;
    return Isolate.run(() => _loadNodeStatInBackground(overridePath));
  }

  void _completeInitialNodeInfoFlow({bool didReceiveNodeInfo = false}) {
    if (!didReceiveNodeInfo) return;
    if (!_isInitialNodeInfoLoading && _hasReceivedInitialNodeInfo) return;

    if (!mounted) {
      _hasReceivedInitialNodeInfo = true;
      _isInitialNodeInfoLoading = false;
      return;
    }

    setState(() {
      _hasReceivedInitialNodeInfo = true;
      _isInitialNodeInfoLoading = false;
    });
  }

  Widget _buildStatusOverlayScaffold() {
    return Scaffold(
      body: _buildNetworkOfflineOverlay(),
    );
  }

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
    }

    await _restartAppForUpdatedLibrary();
  }

  /// Proactively check for library updates at startup without relying on
  /// WebView messages. If an update is found, download and auto-restart.
  Future<void> _autoCheckAndUpdate() async {
    await _runCoordinatedAutoUpdateCheck(
      trigger: 'foreground-ui',
      delay: _autoUpdateInitialDelay,
    );
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
              'To ensure ARO Mobile runs smoothly on your phone, please head to your device settings and enable these options:\n\n'
              '1. Background running – Allow the app to continue working in the background (you enjoy higher rewards!).\n\n'
              '2. Auto-start – Let the app launch automatically after your phone restarts.\n\n'
              'No worries—you can tweak or disable them anytime in your settings if needed.',
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

  Future<void> _showBatteryOptimizationDialog() async {
    if (!Platform.isAndroid) return;
    if (!mounted) return;
    try {
      // Check if already ignoring battery optimizations
      final isIgnoring = await MyApp.platform
          .invokeMethod<bool>('isIgnoringBatteryOptimizations');
      if (isIgnoring == true) return;

      final prefs = await SharedPreferences.getInstance();
      final lastPromptMs = prefs.getInt('battery_opt_last_prompt_ms') ?? 0;

      // After the first prompt, re-check every 12 hours
      if (lastPromptMs > 0) {
        final now = DateTime.now().millisecondsSinceEpoch;
        if ((now - lastPromptMs) < 43200000) return;
      }

      await prefs.setInt(
        'battery_opt_last_prompt_ms',
        DateTime.now().millisecondsSinceEpoch,
      );

      // Directly invoke the system-level battery optimization prompt
      await MyApp.platform.invokeMethod('requestIgnoreBatteryOptimizations');
    } catch (e) {
      LoggerService().error('Battery optimization request failed', e);
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
      await _openExternalUrl(url);
      return;
    }

    if (message == 'nodeInfo') {
      var shouldCompleteInitialLoading = false;
      try {
        final stat = await _getNodeStatAsync();
        final statMap = jsonDecode(stat);
        final initialBindState = _classifyInitialBindState(statMap);

        print('initialBindState---- $initialBindState');
        // Only dismiss loading when bind is a concrete boolean (resolved).
        // 'pending' (bind == null) means the server hasn't returned full data
        // yet — keep loading visible until a subsequent nodeInfo resolves it.
        shouldCompleteInitialLoading =
            initialBindState == _InitialBindState.resolved;

        print('statMap nodeInfo $statMap');
        LoggerService().info(
          'statMap nodeInfo : $statMap, initialBindState=$initialBindState, '
          'isConnected=$_isConnected',
        );

        if (statMap['code'] == 200) {
          print('Send stat result:  ------- $stat $statMap ');
          sendToWeb({
            'type': 'nodeInfo',
            'payload': statMap,
          });

          final wasForbidden = _forbidden;
          final isForbidden = statMap['data']['connect'] == 'Restricted ip';
          if (_forbidden != isForbidden) {
            if (mounted) {
              setState(() {
                _forbidden = isForbidden;
              });
            } else {
              _forbidden = isForbidden;
            }
          }

          // When forbidden, reset initial-load state so the overlay stays
          // visible via _isInitialNodeInfoLoading. This also covers the case
          // where forbidden is detected after initial load already completed.
          if (isForbidden) {
            shouldCompleteInitialLoading = false;
            if (_hasReceivedInitialNodeInfo || !_isInitialNodeInfoLoading) {
              if (mounted) {
                setState(() {
                  _isInitialNodeInfoLoading = true;
                  _hasReceivedInitialNodeInfo = false;
                });
              } else {
                _isInitialNodeInfoLoading = true;
                _hasReceivedInitialNodeInfo = false;
              }
            }
          }

          // When forbidden just cleared, skip this cycle so that
          // _classifyInitialBindState gets a fresh evaluation on the
          // next nodeInfo call.
          if (wasForbidden && !isForbidden) {
            shouldCompleteInitialLoading = false;
          }

          print('_forbidden_forbidden $_forbidden');
        }
      } catch (e) {
        print('nodeInfo error $e');
        LoggerService().info('nodeInfo--- error $e ');
      } finally {
        _completeInitialNodeInfoFlow(
          didReceiveNodeInfo: shouldCompleteInitialLoading,
        );
      }
    } else if (message == 'nodeSignUp') {
      try {
        final status = service.nodeSignUp();
        print('node status: $status');
        sendMessageToWeb({
          'type': 'nodeSignUp',
          'payload': status,
        });

        final stat = await _getNodeStatAsync();
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
      print('Generate file directory: $appDir');
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
      _isInitializing = true;
      _initError = null;
    });
    try {
      await Future.delayed(const Duration(milliseconds: 5));

      await LoggerService().initialize();
      LoggerService().info('App starting...');

      await ConnectivityService().initialize();
      await _syncConnectivityIcon(force: true);

      await _configureStudyLibraryOverridePath();
      StudyLibrary.ensureInitialized();

      await initNode();

      unawaited(_autoCheckAndUpdate());

      _updateCheckTimer?.cancel();
      _updateCheckTimer = Timer.periodic(
        const Duration(minutes: 10),
        (_) => unawaited(_autoCheckAndUpdate()),
      );

      if (Platform.isWindows) {
        var trayReady = false;
        try {
          final iconPath = _windowsTrayIconPath(offline: false);
          await trayManager.setIcon(iconPath);
          await trayManager.setToolTip('ARO Desktop');
          await _setupWindowsTrayMenu();
          _isWindowsTrayReady = true;
          trayReady = true;
        } catch (e) {
          LoggerService().error('Failed to setup Windows tray icon', e);
        }

        if (trayReady) {
          await _syncConnectivityIcon(force: true);
          try {
            await windowManager.setPreventClose(true);
          } catch (e, s) {
            LoggerService()
                .error('Failed to enable Windows close intercept', e, s);
          }
        }
      }
      if (Platform.isAndroid) {
        AppServiceStarter.startForegroundService();
      }

      setState(() {
        _isInitializing = false;
        _isAppInitialized = true;
      });

      // Show app-settings prompt on Android after initialization completes
      if (Platform.isAndroid) {
        WidgetsBinding.instance.addPostFrameCallback((_) async {
          await _showAndroidAppSettingsDialog();
          await _showBatteryOptimizationDialog();
        });
      }
    } catch (e) {
      LoggerService().error('Failed _asyncInit', e);

      setState(() {
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

  Future<void> _showWindowsBackgroundRunningNotice() async {
    if (!Platform.isWindows) return;
    if (_hasShownWindowsBackgroundNotice) return;

    try {
      await MyApp.windowsPlatform.invokeMethod('showBackgroundNotification', {
        'title': 'ARO Desktop',
        'body':
            'ARO Desktop has been minimized to the system tray and is still running in the background.',
      });
      _hasShownWindowsBackgroundNotice = true;
    } catch (e, s) {
      LoggerService()
          .error('Failed to show Windows background notification', e, s);
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
        _isWindowsTrayReady = false;
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
    await _showWindowsBackgroundRunningNotice();
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
      unawaited(_syncConnectivityIcon());

      // If the app is still blocked on the startup nodeInfo flow or the
      // current page hit a main-frame network error, trigger one reload when
      // connectivity comes back.
      if (connectionRestored &&
          (_webViewNetworkIssue || !_hasReceivedInitialNodeInfo)) {
        _scheduleWebViewRecovery(
          reason: !_hasReceivedInitialNodeInfo
              ? 'connectivity restored during startup nodeInfo load'
              : 'connectivity restored',
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
        _recoverWebView(reason: reason);
      } catch (e, s) {
        LoggerService().error('WebView reload failed ($reason)', e, s);
      }
    });
  }

  void _recoverWebView({required String reason}) {
    if (Platform.isWindows || Platform.isLinux) {
      final targetUrl = inapp.WebUri(AllConfig.deskTopURL);

      if (_desktopController != null) {
        _desktopController!.loadUrl(
          urlRequest: inapp.URLRequest(url: targetUrl),
        );
        LoggerService().info('Desktop WebView load triggered ($reason)');
        return;
      }

      setState(() {
        _desktopWebViewError = null;
        _webViewNetworkIssue = false;
        _isDesktopWebViewReady = true;
      });
      unawaited(_syncConnectivityIcon());
      LoggerService().info(
        'Desktop WebView recovery deferred until controller is available ($reason)',
      );
      return;
    }

    final targetUrl = _resolveMobileWebViewUrl();

    if (_controller == null) {
      _mobileWebViewCurrentUrl = targetUrl;
      _mobileWebViewTimeoutRetryCount = 0;
      _initMobileWebView();
      LoggerService().info(
        'Mobile WebView controller recreated for recovery ($reason)',
      );
      return;
    }

    setState(() {
      _isWebViewLoading = true;
      _webViewNetworkIssue = false;
    });
    unawaited(_syncConnectivityIcon());
    _mobileWebViewCurrentUrl = targetUrl;
    _mobileWebViewTimeoutRetryCount = 0;
    _controller!.loadRequest(Uri.parse(targetUrl));
    LoggerService().info('Mobile WebView load triggered ($reason)', {
      'url': targetUrl,
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

      // Re-check battery optimization on resume (throttled to once/day)
      if (Platform.isAndroid && _isAppInitialized) {
        _showBatteryOptimizationDialog();
      }
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
        _isWindowsTrayReady = false;
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
      _controller = WebViewController();

      _controller!.setJavaScriptMode(JavaScriptMode.unrestricted);

      _controller!.addJavaScriptChannel(
        'Flutter',
        onMessageReceived: (JavaScriptMessage message) {
          handleWebMessage(message.message);
        },
      );

      _controller!.setNavigationDelegate(
        NavigationDelegate(
          onWebResourceError: (error) {
            final url = _resolveMobileWebViewUrl(_mobileWebViewCurrentUrl);
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
                unawaited(_syncConnectivityIcon());
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
            if (progress == 100 && _isWebViewLoading) {
              setState(() {
                _isWebViewLoading = false;
              });
            }
          },
          onPageFinished: (_) {
            setState(() {
              _hasInitialWebViewContentLoaded = true;
              _isWebViewLoading = false;
              _webViewNetworkIssue = false;
            });
            unawaited(_syncConnectivityIcon());

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
            final previousUrl = _mobileWebViewCurrentUrl;
            if (_isUsableWebViewUrl(url)) {
              _mobileWebViewCurrentUrl = url;
            }

            if (previousUrl != _mobileWebViewCurrentUrl) {
              _mobileWebViewTimeoutRetryCount = 0;
            } else if (!_isUsableWebViewUrl(url)) {
              LoggerService().warning(
                'Ignoring invalid WebView start URL during recovery',
                {'url': url},
              );
            }

            setState(() {
              _isWebViewLoading = true;
            });

            Future.delayed(const Duration(seconds: 8), () {
              if (mounted && _isWebViewLoading) {
                setState(() {
                  _isWebViewLoading = false;
                });
              }
            });
          },
        ),
      );

      final url = _resolveMobileWebViewUrl(_mobileWebViewCurrentUrl);
      _mobileWebViewCurrentUrl = url;
      _mobileWebViewTimeoutRetryCount = 0;
      _controller!.loadRequest(Uri.parse(url));

      // Start memory management for mobile/macOS WebView
      _memoryManager.start(mobileController: _controller);
    } catch (e) {
      LoggerService().error('Error initializing mobile webview', e);
    }
  }

  @override
  Widget build(BuildContext context) {
    if (Platform.isWindows || Platform.isLinux) {
      // Use Builder to ensure Hero system is fully disabled before creating InAppWebView
      if (!_isDesktopWebViewReady) {
        if (_shouldShowStatusOverlay) {
          return _buildStatusOverlayScaffold();
        }
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
            if (_shouldShowStatusOverlay) _buildNetworkOfflineOverlay(),
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
      if (_shouldShowStatusOverlay) {
        LoggerService()
            .info('_shouldShowStatusOverlay=$_shouldShowStatusOverlay');
        return _buildStatusOverlayScaffold();
      }
      return Scaffold(
        body: Container(
          color: Colors.white,
          child: const Center(
            child: CircularProgressIndicator(),
          ),
        ),
      );
    }

    if ((_isInitializing || !_isAppInitialized) &&
        _isInitialNodeInfoLoading &&
        !_hasInitialWebViewContentLoaded) {
      if (_shouldShowStatusOverlay) {
        return _buildStatusOverlayScaffold();
      }
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

    return Scaffold(
      body: Stack(
        children: [
          WebViewWidget.fromPlatformCreationParams(
            params: (Platform.isAndroid)
                ? AndroidWebViewWidgetCreationParams(
                    controller: _controller!.platform,
                    displayWithHybridComposition: true,
                  )
                : PlatformWebViewWidgetCreationParams(
                    controller: _controller!.platform,
                  ),
          ),
          if (_isWebViewLoading && !_shouldShowStartupNodeInfoLoading)
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
          if (_shouldShowStatusOverlay) _buildNetworkOfflineOverlay(),
        ],
      ),
    );
  }

  Widget _buildNetworkOfflineOverlay() {
    LoggerService()
        .info('Building network offline overlay =$_shouldShowStatusOverlay');
    final isStartupLoading = _shouldShowStartupNodeInfoLoading;

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
                if (_forbidden && _isConnected)
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: const [
                      Icon(
                        Icons.warning_amber_rounded,
                        size: 24,
                        color: Color(0xFFFFC107),
                      ),
                      SizedBox(width: 8),
                      Text(
                        'Service Unavailable',
                        style: TextStyle(
                          fontSize: 20,
                          fontWeight: FontWeight.bold,
                          color: Colors.white,
                        ),
                        textAlign: TextAlign.center,
                      ),
                    ],
                  ),
                if (_forbidden && _isConnected)
                  Padding(
                    padding:
                        const EdgeInsets.only(top: 20, left: 20, right: 20),
                    child: Text.rich(
                      TextSpan(
                        style: const TextStyle(
                          fontSize: 14,
                          fontWeight: FontWeight.bold,
                          color: Colors.white,
                        ),
                        children: [
                          const TextSpan(
                            text:
                                'Due to legal requirements, our platform cannot provide services in your region. This is based on your IP address detection. For more details on restricted regions, please refer to our ',
                          ),
                          TextSpan(
                            text: 'Terms of Service',
                            style: const TextStyle(
                              decoration: TextDecoration.underline,
                              decorationColor: Colors.white,
                            ),
                            recognizer: TapGestureRecognizer()
                              ..onTap = () =>
                                  _openExternalUrl('https://aro.network/terms'),
                          ),
                          const TextSpan(text: '.'),
                        ],
                      ),
                      textAlign: TextAlign.center,
                    ),
                  ),
                const SizedBox(height: 24),
                if (!_forbidden || _isEffectivelyOffline)
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
                if (isStartupLoading &&
                    (!_forbidden || _isEffectivelyOffline)) ...[
                  const SizedBox(height: 20),
                  const SizedBox(
                    width: 24,
                    height: 24,
                    child: CircularProgressIndicator(
                      color: Colors.white,
                      strokeWidth: 2.2,
                    ),
                  ),
                ],
                const SizedBox(height: 12),
              ],
            ),
          ),
          Align(
            alignment: Alignment.bottomCenter,
            child: !_forbidden
                ? Padding(
                    padding: const EdgeInsets.only(bottom: 118.0),
                    child: Text(
                      'Connecting...',
                      style: TextStyle(
                        fontSize: 15,
                        color: Colors.white,
                      ),
                      textAlign: TextAlign.center,
                    ),
                  )
                : null,
          ),
          // Bottom green bar
          Align(
            alignment: Alignment.bottomCenter,
            child: _isEffectivelyOffline
                ? SafeArea(
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
                      child: Center(
                          child: Padding(
                        padding: const EdgeInsets.symmetric(horizontal: 10.0),
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
                      )),
                    ),
                  )
                : null,
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
            unawaited(_syncConnectivityIcon());
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
          setState(() {
            _hasInitialWebViewContentLoaded = true;
            _webViewNetworkIssue = false;
          });
          unawaited(_syncConnectivityIcon());
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
            unawaited(_syncConnectivityIcon());
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
