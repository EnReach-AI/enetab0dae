package com.aro.aro_mobile

import android.content.Intent
import android.os.Build
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    companion object {
        const val EXTRA_STARTED_FROM_BOOT = "started_from_boot"
    }

    private val CHANNEL = "com.aro.aro_app/foreground"

    override fun configureFlutterEngine(flutterEngine: io.flutter.embedding.engine.FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            when (call.method) {
                "startService" -> {
                    val intent = Intent(this, ForegroundService::class.java)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        startForegroundService(intent)
                    } else {
                        startService(intent)
                    }
                    result.success("Service Started")
                }
                "stopService" -> {
                    val intent = Intent(this, ForegroundService::class.java)
                    stopService(intent)
                    result.success("Service Stopped")
                }
                "restartApp" -> {
                    restartApp()
                    result.success(true)
                }
                else -> result.notImplemented()
            }
        }
    }

    private fun restartApp() {
        val context = applicationContext
        val intent = context.packageManager.getLaunchIntentForPackage(context.packageName)
        intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
        Runtime.getRuntime().exit(0)
    }

    override fun onResume() {
        super.onResume()
        // If launched automatically from boot, put the task to background to avoid flashing UI.
        if (intent?.getBooleanExtra(EXTRA_STARTED_FROM_BOOT, false) == true) {
            moveTaskToBack(true)
        }
    }
}
