package com.aro.aro_mobile

import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "com.aro.aro_app/foreground"

    override fun configureFlutterEngine(flutterEngine: io.flutter.embedding.engine.FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            when (call.method) {
                "startService" -> {
                    val intent = Intent(this, ForegroundService::class.java)
                    startService(intent)
                    result.success("Service Started")
                }
                "stopService" -> {
                    val intent = Intent(this, ForegroundService::class.java)
                    stopService(intent)
                    result.success("Service Stopped")
                }
                else -> result.notImplemented()
            }
        }
    }
}
