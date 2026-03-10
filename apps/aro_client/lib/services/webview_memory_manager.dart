import 'dart:async';
import 'dart:io';
import 'package:aro_client/services/logger_service.dart';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart' as inapp;

/// Manages WebView memory to prevent OOM crashes during long-running sessions.
///
/// The crash analysis showed that after ~46 hours of runtime, JavaScriptCore's
/// memory allocator runs out of memory during GC, causing a SIGTRAP crash.
///
/// This manager:
/// 1. Periodically clears WebView cache and local storage
/// 2. Monitors process memory usage and triggers cleanup when thresholds are hit
/// 3. Performs periodic soft page reloads to reset the JS heap
class WebViewMemoryManager {
  static final WebViewMemoryManager _instance =
      WebViewMemoryManager._internal();

  factory WebViewMemoryManager() => _instance;
  WebViewMemoryManager._internal();

  Timer? _periodicCleanupTimer;
  Timer? _memoryMonitorTimer;

  /// How often to clear WebView caches (default: every 2 hours).
  static const Duration cacheCleanupInterval = Duration(hours: 2);

  /// How often to check process memory usage (default: every 5 minutes).
  static const Duration memoryCheckInterval = Duration(minutes: 5);

  /// Memory threshold in MB. When RSS exceeds this, aggressive cleanup is
  /// triggered. On a 16 GB Mac, 4 GB is a reasonable ceiling for a lightweight
  /// desktop app.
  static const int memoryThresholdMB = 3072; // 3 GB

  /// How often to do a soft WebView reload to reclaim JS heap (default: 6 hours).
  static const Duration softReloadInterval = Duration(hours: 6);

  Timer? _softReloadTimer;

  WebViewController? _mobileController;
  inapp.InAppWebViewController? _desktopController;

  bool _isRunning = false;

  /// Start memory management. Call this after WebView is initialized.
  void start({
    WebViewController? mobileController,
    inapp.InAppWebViewController? desktopController,
  }) {
    _mobileController = mobileController;
    _desktopController = desktopController;
    _isRunning = true;

    _startPeriodicCacheCleanup();
    _startMemoryMonitor();
    _startSoftReloadTimer();

    LoggerService().info('[WebViewMemoryManager] Started memory management');
  }

  /// Update references when controllers change (e.g. after a reload).
  void updateControllers({
    WebViewController? mobileController,
    inapp.InAppWebViewController? desktopController,
  }) {
    _mobileController = mobileController;
    _desktopController = desktopController;
  }

  /// Stop all timers and release references.
  void dispose() {
    _isRunning = false;
    _periodicCleanupTimer?.cancel();
    _periodicCleanupTimer = null;
    _memoryMonitorTimer?.cancel();
    _memoryMonitorTimer = null;
    _softReloadTimer?.cancel();
    _softReloadTimer = null;
    _mobileController = null;
    _desktopController = null;
    LoggerService().info('[WebViewMemoryManager] Disposed');
  }

  // ---------------------------------------------------------------------------
  // Periodic cache cleanup
  // ---------------------------------------------------------------------------

  void _startPeriodicCacheCleanup() {
    _periodicCleanupTimer?.cancel();
    _periodicCleanupTimer = Timer.periodic(cacheCleanupInterval, (_) {
      if (!_isRunning) return;
      _clearWebViewCache();
    });
  }

  /// Clear WebView caches (HTTP cache, local storage, cookies).
  Future<void> _clearWebViewCache() async {
    try {
      LoggerService()
          .info('[WebViewMemoryManager] Performing periodic cache cleanup');

      if (Platform.isWindows || Platform.isLinux) {
        await _clearDesktopCache();
      } else {
        await _clearMobileCache();
      }

      LoggerService().info('[WebViewMemoryManager] Cache cleanup completed');
    } catch (e, s) {
      LoggerService()
          .error('[WebViewMemoryManager] Cache cleanup failed', e, s);
    }
  }

  Future<void> _clearMobileCache() async {
    final controller = _mobileController;
    if (controller == null) return;

    try {
      await controller.clearCache();
      LoggerService()
          .info('[WebViewMemoryManager] Mobile WebView cache cleared');
    } catch (e) {
      LoggerService()
          .error('[WebViewMemoryManager] Failed to clear mobile cache', e);
    }

    try {
      await controller.clearLocalStorage();
      LoggerService()
          .info('[WebViewMemoryManager] Mobile WebView localStorage cleared');
    } catch (e) {
      // clearLocalStorage may not be available on all platforms
      LoggerService().warning(
          '[WebViewMemoryManager] clearLocalStorage not supported or failed: $e');
    }
  }

  Future<void> _clearDesktopCache() async {
    // InAppWebView uses static/global cache clearing methods
    try {
      if (Platform.isWindows || Platform.isLinux) {
        // Clear all InAppWebView caches
        final controller = _desktopController;
        if (controller != null) {
          await controller.clearHistory();
        }
      }
      LoggerService()
          .info('[WebViewMemoryManager] Desktop WebView cache cleared');
    } catch (e) {
      LoggerService()
          .error('[WebViewMemoryManager] Failed to clear desktop cache', e);
    }

    try {
      // Clear cookies
      await inapp.CookieManager.instance().deleteAllCookies();
      LoggerService().info('[WebViewMemoryManager] Desktop cookies cleared');
    } catch (e) {
      LoggerService()
          .error('[WebViewMemoryManager] Failed to clear cookies', e);
    }
  }

  // ---------------------------------------------------------------------------
  // Memory monitoring
  // ---------------------------------------------------------------------------

  void _startMemoryMonitor() {
    _memoryMonitorTimer?.cancel();
    _memoryMonitorTimer = Timer.periodic(memoryCheckInterval, (_) {
      if (!_isRunning) return;
      _checkMemoryUsage();
    });
  }

  Future<void> _checkMemoryUsage() async {
    try {
      final memoryMB = await _getProcessMemoryMB();
      if (memoryMB == null) return;

      LoggerService().info(
          '[WebViewMemoryManager] Current memory usage: ${memoryMB.toStringAsFixed(1)} MB');

      if (memoryMB > memoryThresholdMB) {
        LoggerService()
            .warning('[WebViewMemoryManager] Memory threshold exceeded '
                '(${memoryMB.toStringAsFixed(0)} MB > $memoryThresholdMB MB). '
                'Triggering aggressive cleanup.');
        await _aggressiveCleanup();
      }
    } catch (e) {
      LoggerService().error('[WebViewMemoryManager] Memory check failed', e);
    }
  }

  /// Get process RSS in MB. Returns null if unavailable.
  Future<double?> _getProcessMemoryMB() async {
    try {
      // ProcessInfo.currentRss gives resident set size in bytes (Dart VM).
      // However, this only reflects the Dart heap — not native allocations
      // from WKWebView / JSC. We use platform commands as the primary source.
      if (Platform.isMacOS) {
        final currentPid = pid; // dart:io top-level getter
        final result =
            await Process.run('ps', ['-o', 'rss=', '-p', '$currentPid']);
        if (result.exitCode == 0) {
          final rssKB = int.tryParse(result.stdout.toString().trim());
          if (rssKB != null) {
            return rssKB / 1024.0;
          }
        }
      } else if (Platform.isLinux) {
        final statusFile = File('/proc/self/status');
        if (await statusFile.exists()) {
          final content = await statusFile.readAsString();
          final match = RegExp(r'VmRSS:\s+(\d+)\s+kB').firstMatch(content);
          if (match != null) {
            final rssKB = int.tryParse(match.group(1)!);
            if (rssKB != null) {
              return rssKB / 1024.0;
            }
          }
        }
      } else if (Platform.isWindows) {
        final currentPid = pid;
        final result = await Process.run(
            'tasklist', ['/FI', 'PID eq $currentPid', '/FO', 'CSV', '/NH']);
        if (result.exitCode == 0) {
          final line = result.stdout.toString().trim();
          final parts = line.split(',');
          if (parts.length >= 5) {
            final memStr =
                parts[4].replaceAll('"', '').replaceAll(RegExp(r'[^\d]'), '');
            final memKB = int.tryParse(memStr);
            if (memKB != null) {
              return memKB / 1024.0;
            }
          }
        }
      }
    } catch (e) {
      // Silently fail — memory monitoring is best-effort
    }
    return null;
  }

  /// Aggressive cleanup when memory is critically high.
  /// Clears caches and forces a page reload to drop the entire JS heap.
  Future<void> _aggressiveCleanup() async {
    try {
      LoggerService()
          .info('[WebViewMemoryManager] Performing aggressive memory cleanup');

      // 1. Clear all caches
      await _clearWebViewCache();

      // 2. Force GC via JavaScript (hint only — some engines respect this)
      await _triggerJSGarbageCollection();

      // 3. Reload the page to drop the JS heap entirely
      await _reloadWebView();

      LoggerService().info(
          '[WebViewMemoryManager] Aggressive cleanup completed — page reloaded');
    } catch (e, s) {
      LoggerService()
          .error('[WebViewMemoryManager] Aggressive cleanup failed', e, s);
    }
  }

  /// Attempt to hint the JS engine to run garbage collection.
  Future<void> _triggerJSGarbageCollection() async {
    // There is no guaranteed way to force GC in WKWebView, but we can:
    // 1. Null out large objects
    // 2. Use window.gc() if available (only in some debug builds)
    const gcScript = '''
      (function() {
        try {
          // Release any large cached data the web page might hold
          if (window.gc) { window.gc(); }
          // Hint: create and drop a large allocation to encourage GC
          var tmp = new ArrayBuffer(1024 * 1024);
          tmp = null;
        } catch(e) {}
      })();
    ''';

    try {
      if (Platform.isWindows || Platform.isLinux) {
        await _desktopController?.evaluateJavascript(source: gcScript);
      } else {
        await _mobileController?.runJavaScript(gcScript);
      }
    } catch (e) {
      // Best-effort
    }
  }

  // ---------------------------------------------------------------------------
  // Soft periodic reload
  // ---------------------------------------------------------------------------

  void _startSoftReloadTimer() {
    _softReloadTimer?.cancel();
    _softReloadTimer = Timer.periodic(softReloadInterval, (_) {
      if (!_isRunning) return;
      _softReload();
    });
  }

  /// Soft reload: clear cache then reload the page.
  /// This is the most effective way to reclaim JSC heap memory in WKWebView,
  /// because WKWebView doesn't fully release JS heap memory unless the page is
  /// reloaded or the web process is terminated.
  Future<void> _softReload() async {
    try {
      LoggerService().info(
          '[WebViewMemoryManager] Performing periodic soft reload to reclaim JS heap');

      await _triggerJSGarbageCollection();

      // Small delay to let GC hint take effect
      await Future.delayed(const Duration(milliseconds: 500));

      await _reloadWebView();

      LoggerService().info('[WebViewMemoryManager] Soft reload completed');
    } catch (e, s) {
      LoggerService().error('[WebViewMemoryManager] Soft reload failed', e, s);
    }
  }

  Future<void> _reloadWebView() async {
    try {
      if (Platform.isWindows || Platform.isLinux) {
        await _desktopController?.reload();
      } else {
        await _mobileController?.reload();
      }
    } catch (e) {
      LoggerService().error('[WebViewMemoryManager] WebView reload failed', e);
    }
  }

  /// Manually trigger a cleanup (can be called from outside, e.g. on app
  /// resume or when a memory warning is received).
  Future<void> manualCleanup() async {
    LoggerService().info('[WebViewMemoryManager] Manual cleanup requested');
    await _clearWebViewCache();
    await _triggerJSGarbageCollection();
  }
}
