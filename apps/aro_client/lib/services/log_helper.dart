import 'package:aro_client/services/logger_service.dart';

/// 日志使用示例和工具类
class LogHelper {
  /// 记录网络请求
  static void logNetworkRequest(String method, String url, {dynamic body}) {
    LoggerService().info('[$method] $url');
    if (body != null) {
      LoggerService().debug('Request body: $body');
    }
  }

  /// 记录网络响应
  static void logNetworkResponse(String url, int statusCode, {dynamic response}) {
    LoggerService().info('Response [$statusCode] $url');
    if (response != null) {
      LoggerService().debug('Response body: $response');
    }
  }

  /// 记录WebView消息
  static void logWebViewMessage(String message) {
    LoggerService().debug('WebView Message: $message');
  }

  /// 记录错误
  static void logError(String context, dynamic error, {StackTrace? stackTrace}) {
    LoggerService().error('[$context] Error: $error', error, stackTrace);
  }

  /// 记录应用生命周期事件
  static void logLifecycleEvent(String event) {
    LoggerService().info('Lifecycle Event: $event');
  }

  /// 获取日志文件路径（用于调试）
  static String getLogFilePath() {
    return LoggerService().logFilePath;
  }

  /// 清理旧日志
  static Future<void> cleanOldLogs() async {
    await LoggerService().cleanOldLogs();
  }
}
