package com.aro.aro_mobile

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log

/**
 * Dedicated receiver for service restart alarms.
 * Using a BroadcastReceiver as the AlarmManager target is more reliable
 * than PendingIntent.getService() on some OEM ROMs that block direct
 * service starts from alarms.
 */
class ServiceRestartReceiver : BroadcastReceiver() {

    companion object {
        const val ACTION_RESTART_SERVICE = "com.aro.aro_mobile.ACTION_RESTART_SERVICE"
    }

    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action != ACTION_RESTART_SERVICE) return

        Log.i("ServiceRestartReceiver", "Restart alarm fired, starting ForegroundService")

        val serviceIntent = Intent(context, ForegroundService::class.java)
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(serviceIntent)
            } else {
                context.startService(serviceIntent)
            }
        } catch (t: Throwable) {
            Log.e("ServiceRestartReceiver", "Failed to restart ForegroundService", t)
            // Try expedited WorkManager as fallback, then schedule another alarm.
            ForegroundService.scheduleExpeditedRestart(context.applicationContext)
            ForegroundService.scheduleRestartAlarm(context.applicationContext, 10_000L)
        }
    }
}
