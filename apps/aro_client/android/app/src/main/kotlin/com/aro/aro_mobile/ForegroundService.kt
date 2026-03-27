package com.aro.aro_mobile

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.PowerManager
import android.os.SystemClock
import android.os.UserManager
import android.util.Log
import androidx.core.app.NotificationCompat
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugins.GeneratedPluginRegistrant
import io.flutter.plugin.common.MethodChannel

class ForegroundService : Service() {

    companion object {
        const val CHANNEL_NAME = "com.aro.aro_app/foreground"
        const val ACTION_RESTART_APP = "com.aro.aro_mobile.ACTION_RESTART_APP"
        const val ACTION_STOP_FOR_UPDATE = "com.aro.aro_mobile.ACTION_STOP_FOR_UPDATE"
        private const val ACTION_KEEP_ALIVE_ALARM = "com.aro.aro_mobile.ACTION_KEEP_ALIVE_ALARM"
        private const val KEEP_ALIVE_INTERVAL_MS = 15 * 60 * 1000L
        private const val KEEP_ALIVE_REQUEST_CODE = 1001
        private const val WAKE_LOCK_TAG = "aro:foreground_wakelock"

        @Volatile
        private var flutterEngine: FlutterEngine? = null

        @Volatile
        private var isRunning = false
    }

    private val CHANNEL_ID = "foreground_service_channel"

    @Volatile
    private var workerRunning = false

    private var serviceMethodChannel: MethodChannel? = null
    private val heartbeatHandler = Handler(Looper.getMainLooper())
    private var heartbeatRunnable: Runnable? = null
    private var unlockReceiver: android.content.BroadcastReceiver? = null
    private var wakeLock: PowerManager.WakeLock? = null
    private var connectivityManager: ConnectivityManager? = null
    private var networkCallback: ConnectivityManager.NetworkCallback? = null

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()

        if (isRunning) {
            Log.w("ForegroundService", "Service already running, stopping duplicate")
            stopSelf()
            return
        }
        isRunning = true

        createNotificationChannel()
        acquireWakeLock()
        registerNetworkCallback()
        Log.i("ForegroundService", "Service created with WakeLock and network monitor")
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "ARO is running in the background"
                setShowBadge(false)
            }
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == ACTION_KEEP_ALIVE_ALARM) {
            Log.i("ForegroundService", "Keep-alive alarm received")
        }

        if (intent?.action == ACTION_STOP_FOR_UPDATE) {
            Log.i("ForegroundService", "Received STOP_FOR_UPDATE action, destroying engine and stopping service")
            destroyBackgroundEngine()
            stopForegroundCompat()
            stopSelf()
            return START_NOT_STICKY
        }

        val openAppIntent = packageManager.getLaunchIntentForPackage(packageName)
            ?.apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            }
            ?: Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }

        val openAppPendingIntent = PendingIntent.getActivity(
            this,
            0,
            openAppIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("ARO is earning for you in the background")
            .setContentText("Click return App")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(openAppPendingIntent)
            .setOngoing(true)
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setSilent(true)
            .build()

        startForeground(1, notification)

        acquireWakeLock()
        scheduleKeepAliveAlarm()

        // Handle restart request: just keep the Service running in background.
        // User will reopen the app manually and get the updated library.
        if (intent?.action == ACTION_RESTART_APP) {
            Log.i("ForegroundService", "Received RESTART_APP action, staying in background")
        }

        // Start heavy initialization after foreground elevation to avoid
        // Android 8+ foreground service start timeout on slower devices.
        ensureBackgroundEngineIfNeeded()

        if (!workerRunning) {
            workerRunning = true
            startHeartbeatLoop()
        }

        return START_STICKY
    }

    private fun acquireWakeLock() {
        if (wakeLock?.isHeld == true) return
        try {
            val pm = getSystemService(POWER_SERVICE) as PowerManager
            wakeLock = pm.newWakeLock(
                PowerManager.PARTIAL_WAKE_LOCK,
                WAKE_LOCK_TAG
            ).apply {
                setReferenceCounted(false)
                acquire()
            }
            Log.i("ForegroundService", "WakeLock acquired")
        } catch (t: Throwable) {
            Log.e("ForegroundService", "Failed to acquire WakeLock", t)
        }
    }

    private fun releaseWakeLock() {
        try {
            wakeLock?.let {
                if (it.isHeld) {
                    it.release()
                    Log.i("ForegroundService", "WakeLock released")
                }
            }
        } catch (t: Throwable) {
            Log.e("ForegroundService", "Failed to release WakeLock", t)
        } finally {
            wakeLock = null
        }
    }

    private fun registerNetworkCallback() {
        try {
            connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            networkCallback = object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    Log.d("ForegroundService", "Network available: $network")
                }

                override fun onLost(network: Network) {
                    Log.d("ForegroundService", "Network lost: $network")
                }
            }
            connectivityManager?.registerDefaultNetworkCallback(networkCallback!!)
            Log.i("ForegroundService", "Network callback registered")
        } catch (t: Throwable) {
            Log.e("ForegroundService", "Failed to register network callback", t)
        }
    }

    private fun unregisterNetworkCallback() {
        networkCallback?.let {
            try {
                connectivityManager?.unregisterNetworkCallback(it)
            } catch (t: Throwable) {
                Log.e("ForegroundService", "Failed to unregister network callback", t)
            }
        }
        networkCallback = null
        connectivityManager = null
    }

    private fun scheduleKeepAliveAlarm() {
        try {
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            val pendingIntent = PendingIntent.getService(
                this,
                KEEP_ALIVE_REQUEST_CODE,
                Intent(this, ForegroundService::class.java).apply {
                    action = ACTION_KEEP_ALIVE_ALARM
                },
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            )

            val triggerAt = SystemClock.elapsedRealtime() + KEEP_ALIVE_INTERVAL_MS
            alarmManager.setAndAllowWhileIdle(
                AlarmManager.ELAPSED_REALTIME_WAKEUP,
                triggerAt,
                pendingIntent,
            )
        } catch (t: Throwable) {
            Log.e("ForegroundService", "Failed to schedule keep-alive alarm", t)
        }
    }

    private fun cancelKeepAliveAlarm() {
        try {
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            val pendingIntent = PendingIntent.getService(
                this,
                KEEP_ALIVE_REQUEST_CODE,
                Intent(this, ForegroundService::class.java).apply {
                    action = ACTION_KEEP_ALIVE_ALARM
                },
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            )
            alarmManager.cancel(pendingIntent)
        } catch (t: Throwable) {
            Log.e("ForegroundService", "Failed to cancel keep-alive alarm", t)
        }
    }

    private fun startHeartbeatLoop() {
        if (heartbeatRunnable != null) return

        val runnable = object : Runnable {
            override fun run() {
                if (!workerRunning) return
                Log.d("ForegroundService", "Background service is executing....")
                heartbeatHandler.postDelayed(this, 30000)
            }
        }

        heartbeatRunnable = runnable
        heartbeatHandler.post(runnable)
    }

    private fun stopHeartbeatLoop() {
        workerRunning = false
        heartbeatRunnable?.let {
            heartbeatHandler.removeCallbacks(it)
        }
        heartbeatRunnable = null
    }

    private fun ensureBackgroundEngineIfNeeded() {
        if (isUserUnlocked()) {
            ensureBackgroundEngine()
        } else {
            registerUnlockReceiver()
        }
    }

    private fun ensureBackgroundEngine() {
        flutterEngine?.let {
            registerServiceMethodChannel(it)
            return
        }

        if (!isUserUnlocked()) {
            Log.w("ForegroundService", "User locked; postponing  engine start")
            return
        }

        try {
            Log.i("ForegroundService", "Starting headless engine (backgroundMain)")
            val loader = FlutterInjector.instance().flutterLoader()
            loader.startInitialization(applicationContext)
            loader.ensureInitializationComplete(applicationContext, null)

            val engine = FlutterEngine(applicationContext)
            GeneratedPluginRegistrant.registerWith(engine)
            registerServiceMethodChannel(engine)

            val entrypoint = DartExecutor.DartEntrypoint(loader.findAppBundlePath(), "backgroundMain")
            engine.dartExecutor.executeDartEntrypoint(entrypoint)

            flutterEngine = engine
        } catch (t: Throwable) {
            Log.e("ForegroundService", "Failed to start headless engine", t)
        }
    }

    private fun registerServiceMethodChannel(engine: FlutterEngine) {
        serviceMethodChannel?.setMethodCallHandler(null)
        serviceMethodChannel = MethodChannel(engine.dartExecutor.binaryMessenger, CHANNEL_NAME).apply {
            setMethodCallHandler { call, result ->
                when (call.method) {
                    "restartServiceForUpdate" -> {
                        result.success(true)
                        Handler(Looper.getMainLooper()).post {
                            restartServiceForUpdate()
                        }
                    }
                    else -> result.notImplemented()
                }
            }
        }
    }

    private fun restartServiceForUpdate() {
        Log.i("ForegroundService", "Restarting background engine for update")
        destroyBackgroundEngine()
        Handler(Looper.getMainLooper()).postDelayed(
            {
                ensureBackgroundEngineIfNeeded()
            },
            500,
        )
    }

    private fun destroyBackgroundEngine() {
        try {
            serviceMethodChannel?.setMethodCallHandler(null)
            serviceMethodChannel = null
            flutterEngine?.destroy()
            Log.i("ForegroundService", "Background engine destroyed for update")
        } catch (t: Throwable) {
            Log.e("ForegroundService", "Failed to destroy background engine", t)
        } finally {
            flutterEngine = null
        }
    }

    private fun stopForegroundCompat() {
        try {
            @Suppress("DEPRECATION")
            stopForeground(true)
        } catch (t: Throwable) {
            Log.w("ForegroundService", "Failed to stop foreground cleanly", t)
        }
    }

    private fun registerUnlockReceiver() {
        if (unlockReceiver != null) return
        val receiver = object : android.content.BroadcastReceiver() {
            override fun onReceive(ctx: Context?, intent: Intent?) {
                if (Intent.ACTION_USER_UNLOCKED == intent?.action && isUserUnlocked()) {
                    try {
                        applicationContext.unregisterReceiver(this)
                    } catch (_: Throwable) {
                        // ignore
                    }
                    unlockReceiver = null
                    ensureBackgroundEngine()
                }
            }
        }
        unlockReceiver = receiver
        applicationContext.registerReceiver(receiver, IntentFilter(Intent.ACTION_USER_UNLOCKED))
    }

    private fun isUserUnlocked(): Boolean {
        return try {
            val um = getSystemService(UserManager::class.java)
            um?.isUserUnlocked ?: true
        } catch (_: Throwable) {
            true
        }
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        val restartServiceIntent = Intent(applicationContext, ForegroundService::class.java)
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                applicationContext.startForegroundService(restartServiceIntent)
            } else {
                applicationContext.startService(restartServiceIntent)
            }
        } catch (t: Throwable) {
            Log.e("ForegroundService", "Failed to restart service after task removed", t)
        }
        super.onTaskRemoved(rootIntent)
    }

    /**
     * Launch the main Activity from the Service context.
     * Used after library update to restart the UI.
     */
    private fun launchMainActivity() {
        try {
            val launchIntent = packageManager
                .getLaunchIntentForPackage(packageName)
                ?.apply {
                    addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                    )
                }
            if (launchIntent != null) {
                startActivity(launchIntent)
                Log.i("ForegroundService", "Activity launched successfully")
            } else {
                Log.w("ForegroundService", "No launch intent found")
            }
        } catch (t: Throwable) {
            Log.e("ForegroundService", "Failed to launch Activity", t)
        }
    }

    override fun onDestroy() {
        stopHeartbeatLoop()
        cancelKeepAliveAlarm()
        unregisterNetworkCallback()
        releaseWakeLock()
        isRunning = false
        unlockReceiver?.let {
            try {
                applicationContext.unregisterReceiver(it)
            } catch (_: Throwable) {
                // ignore
            }
            unlockReceiver = null
        }
        // Keep engine alive across service restarts; do not destroy here.
        super.onDestroy()
    }
}
