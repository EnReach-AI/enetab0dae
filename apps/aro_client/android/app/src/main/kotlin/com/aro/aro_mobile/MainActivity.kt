package com.aro.aro_mobile

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.PowerManager
import android.provider.Settings
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
                "stopServiceForUpdate" -> {
                    try {
                        val intent = Intent(this, ForegroundService::class.java).apply {
                            action = ForegroundService.ACTION_STOP_FOR_UPDATE
                        }
                        startService(intent)
                        result.success("Service Stopping For Update")
                    } catch (e: Exception) {
                        result.error("SERVICE_UPDATE_STOP_ERROR", e.message, null)
                    }
                }
                "restartApp" -> {
                    result.success(true)
                    Handler(Looper.getMainLooper()).post {
                        restartApp()
                    }
                }
                "openAppSettings" -> {
                    try {
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = Uri.fromParts("package", packageName, null)
                        }
                        startActivity(intent)
                        result.success(true)
                    } catch (e: Exception) {
                        result.error("SETTINGS_ERROR", e.message, null)
                    }
                }
                "isIgnoringBatteryOptimizations" -> {
                    try {
                        val pm = getSystemService(POWER_SERVICE) as PowerManager
                        val isIgnoring = pm.isIgnoringBatteryOptimizations(packageName)
                        result.success(isIgnoring)
                    } catch (e: Exception) {
                        result.error("BATTERY_CHECK_ERROR", e.message, null)
                    }
                }
                "requestIgnoreBatteryOptimizations" -> {
                    try {
                        val pm = getSystemService(POWER_SERVICE) as PowerManager
                        if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                            val intent = Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS).apply {
                                data = Uri.parse("package:$packageName")
                            }
                            startActivity(intent)
                        }
                        result.success(true)
                    } catch (e: Exception) {
                        result.error("BATTERY_REQUEST_ERROR", e.message, null)
                    }
                }
                else -> result.notImplemented()
            }
        }
    }

    private fun restartApp() {
        val context = applicationContext
        val packageManager = context.packageManager
        val intent = packageManager.getLaunchIntentForPackage(context.packageName)
        if (intent != null) {
            val componentName = intent.component
            val restartIntent = Intent.makeRestartActivityTask(componentName)
            context.startActivity(restartIntent)
        }
        // Kill immediately. The intent is already queued in ActivityManagerService
        // (system_server process), so the system will create a NEW process to
        // host the restarted activity. Do NOT delay — a delayed kill would
        // destroy the new activity that started in the same process.
        System.exit(0)
    }

    override fun onResume() {
        super.onResume()
        // If launched automatically from boot, put the task to background to avoid flashing UI.
        if (intent?.getBooleanExtra(EXTRA_STARTED_FROM_BOOT, false) == true) {
            moveTaskToBack(true)
        }
    }
}
