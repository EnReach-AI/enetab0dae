package com.aro.aro_app

import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
	private val channelName = "com.aro.aro_app/foreground"

	override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
		super.configureFlutterEngine(flutterEngine)

		MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channelName)
			.setMethodCallHandler { call, result ->
				if (call.method == "restartApp") {
					restartApp()
					result.success(true)
				} else {
					result.notImplemented()
				}
			}
	}

	private fun restartApp() {
		// ForegroundService is in :bg process. Send restart action via IPC.
		try {
			val serviceIntent = Intent(this, com.aro.aro_mobile.ForegroundService::class.java).apply {
				action = com.aro.aro_mobile.ForegroundService.ACTION_RESTART_APP
			}
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
				startForegroundService(serviceIntent)
			} else {
				startService(serviceIntent)
			}
		} catch (t: Throwable) {
			android.util.Log.e("MainActivity", "Failed to send restart to service", t)
		}
		// Kill main process; Service in :bg is unaffected and will relaunch Activity.
		System.exit(0)
	}
}
