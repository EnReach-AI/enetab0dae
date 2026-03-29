package com.aro.aro_mobile

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.UserManager
import android.util.Log

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action ?: return

        val shouldStart = action == Intent.ACTION_BOOT_COMPLETED ||
            action == Intent.ACTION_LOCKED_BOOT_COMPLETED ||
            action == Intent.ACTION_MY_PACKAGE_REPLACED ||
            action == "android.intent.action.QUICKBOOT_POWERON" ||
            action == "com.htc.intent.action.QUICKBOOT_POWERON"

        if (!shouldStart) return

        val userManager = context.getSystemService(UserManager::class.java)
        val isUnlocked = userManager?.isUserUnlocked ?: true

        // If credential-protected storage is locked (cold boot before unlock), defer heavy start until unlock.
        if (!isUnlocked) {
            Log.w("BootReceiver", "User locked; deferring service start until unlock")
            val appContext = context.applicationContext
            val unlockReceiver = object : BroadcastReceiver() {
                override fun onReceive(ctx: Context, intent: Intent) {
                    if (Intent.ACTION_USER_UNLOCKED == intent.action) {
                        appContext.unregisterReceiver(this)
                        startForegroundServiceSafely(appContext)
                    }
                }
            }
            appContext.registerReceiver(unlockReceiver, IntentFilter(Intent.ACTION_USER_UNLOCKED))
            return
        }

        startForegroundServiceSafely(context)
    }

    private fun startForegroundServiceSafely(context: Context) {
        val serviceIntent = Intent(context, ForegroundService::class.java)

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(serviceIntent)
            } else {
                context.startService(serviceIntent)
            }
        } catch (t: Throwable) {
            Log.e("BootReceiver", "Failed to start ForegroundService.", t)
        }
    }

}
