package com.aro.aro_mobile

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * WorkManager-based periodic keepalive.
 * WorkManager tasks are the most resilient scheduling mechanism on Android
 * because Google requires OEMs to honour them (backed by JobScheduler / GCM).
 * This worker runs every ~15 minutes and restarts ForegroundService if it's
 * not running.
 */
class KeepAliveWorker(
    context: Context,
    params: WorkerParameters,
) : Worker(context, params) {

    companion object {
        const val WORK_NAME = "aro_keep_alive"
    }

    override fun doWork(): Result {
        if (isServiceRunning()) {
            Log.d("KeepAliveWorker", "ForegroundService already running")
            return Result.success()
        }

        Log.i("KeepAliveWorker", "ForegroundService not running, restarting")
        val serviceIntent = Intent(applicationContext, ForegroundService::class.java)
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                applicationContext.startForegroundService(serviceIntent)
            } else {
                applicationContext.startService(serviceIntent)
            }
        } catch (t: Throwable) {
            Log.e("KeepAliveWorker", "Failed to restart service", t)
        }
        return Result.success()
    }

    private fun isServiceRunning(): Boolean {
        val manager = applicationContext.getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager
            ?: return false
        @Suppress("DEPRECATION")
        for (service in manager.getRunningServices(100)) {
            if (ForegroundService::class.java.name == service.service.className) {
                return true
            }
        }
        return false
    }
}
