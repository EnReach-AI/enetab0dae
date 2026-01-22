import 'package:flutter/services.dart';

class AppServiceStarter {
  static const _channel = MethodChannel('com.aro.aro_app/foreground');

  static Future<void> startForegroundService() async {
    try {
      await _channel.invokeMethod('startService');
    } on PlatformException catch (e) {
      print('Failed to start service: ${e.message}');
    }
  }

  static Future<void> stopForegroundService() async {
    try {
      await _channel.invokeMethod('stopService');
    } on PlatformException catch (e) {
      print('Failed to stop service: ${e.message}');
    }
  }
}
