package io.getgrass.plugin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.DownloadManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.webkit.WebView;
import app.tauri.annotation.Command;
import app.tauri.annotation.Permission;
import app.tauri.annotation.TauriPlugin;
import app.tauri.plugin.Invoke;
import app.tauri.plugin.JSObject;
import app.tauri.plugin.Plugin;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import com.facebook.C1102E;
import io.getgrass.plugin.ForegroundService;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.C0838a;
import p000.EnumC0998b;
import p005B.AbstractC0032g;
import p007B1.RunnableC0055o;
import p010C0.AbstractC0147a;
import p019F0.C0221e;
import p019F0.RunnableC0218b;
import p025H1.C0276e;
import p036L0.C0444d;
import p079a2.C0857b;
import p079a2.C0858c;
import p079a2.C0861f;
import p079a2.C0862g;
import p079a2.RunnableC0856a;
import p086c2.C1093l;
import p117m0.AbstractC1725t;
import p117m0.C1718m;
import p119m2.AbstractC1766e;
import p141s0.AbstractC1874d;

/* JADX INFO: loaded from: classes.dex */
@TauriPlugin(permissions = {@Permission(alias = "accessNetworkState", strings = {"android.permission.ACCESS_NETWORK_STATE"}), @Permission(alias = "requestIgnoreBatteryOptimizations", strings = {"android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"}), @Permission(alias = "foregroundService", strings = {"android.permission.FOREGROUND_SERVICE"}), @Permission(alias = "foregroundServiceRemoteMessaging", strings = {"android.permission.FOREGROUND_SERVICE_REMOTE_MESSAGING"}), @Permission(alias = "systemAlertWindow", strings = {"android.permission.SYSTEM_ALERT_WINDOW"}), @Permission(alias = "wakeLock", strings = {"android.permission.WAKE_LOCK"}), @Permission(alias = "requestInstallPackages", strings = {"android.permission.REQUEST_INSTALL_PACKAGES"}), @Permission(alias = "postNotifications", strings = {"android.permission.POST_NOTIFICATIONS"})})
public final class ExamplePlugin extends Plugin {

    /* JADX INFO: renamed from: d */
    public final Activity f5150d;

    /* JADX INFO: renamed from: e */
    public final C0276e f5151e;

    /* JADX INFO: renamed from: f */
    public WebView f5152f;

    /* JADX INFO: renamed from: g */
    public final Context f5153g;

    /* JADX INFO: renamed from: h */
    public C0861f f5154h;

    /* JADX INFO: renamed from: i */
    public final C0221e f5155i;

    /* JADX INFO: renamed from: j */
    public ConnectivityManager f5156j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExamplePlugin(Activity activity) {
        super(activity);
        AbstractC1766e.m3920e("activity", activity);
        this.f5150d = activity;
        this.f5151e = new C0276e(6);
        Context applicationContext = activity.getApplicationContext();
        AbstractC1766e.m3919d("getApplicationContext(...)", applicationContext);
        this.f5153g = applicationContext;
        this.f5155i = C0221e.m440y(activity);
    }

    @Command
    public final void areNotificationsEnabled(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        JSObject jSObject = new JSObject();
        Object systemService = this.f5153g.getSystemService("notification");
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.app.NotificationManager", systemService);
        jSObject.put("value", ((NotificationManager) systemService).areNotificationsEnabled());
        invoke.m2683d(jSObject);
    }

    @Override // app.tauri.plugin.Plugin
    /* JADX INFO: renamed from: b */
    public final void mo2660b(WebView webView) {
        AbstractC1766e.m3920e("webView", webView);
        Log.d(this.f5150d.getPackageName(), "[ExamplePlugin][load]");
        this.f5152f = webView;
        Context context = this.f5153g;
        C0862g c0862g = C0862g.f2541f;
        this.f5154h = new C0861f(context);
        Object systemService = this.f5153g.getSystemService("connectivity");
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.net.ConnectivityManager", systemService);
        this.f5156j = (ConnectivityManager) systemService;
        C0838a c0838a = new C0838a(new C0858c(this), this.f5153g);
        ConnectivityManager connectivityManager = this.f5156j;
        if (connectivityManager == null) {
            AbstractC1766e.m3924i("connectivityManager");
            throw null;
        }
        connectivityManager.registerDefaultNetworkCallback(c0838a);
        HashSet hashSet = AbstractC1117n.f3875a;
        AtomicBoolean atomicBoolean = AbstractC1103F.f3811a;
        if (!AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            try {
                C1102E c1102e = AbstractC1103F.f3814d;
                c1102e.f3808b = Boolean.TRUE;
                c1102e.f3810d = System.currentTimeMillis();
                if (AbstractC1103F.f3811a.get()) {
                    AbstractC1103F.m2874k(c1102e);
                } else {
                    AbstractC1103F.m2868e();
                }
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC1103F.class);
            }
        }
        AbstractC1874d.m4194c((Application) AbstractC1117n.f3882h, AbstractC1117n.f3877c);
    }

    @Command
    @SuppressLint({"BatteryLife"})
    public final void disableBatteryOptimizations(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        Intent intent = new Intent();
        Activity activity = this.f5150d;
        String packageName = activity.getPackageName();
        Object systemService = activity.getSystemService("power");
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.os.PowerManager", systemService);
        if (((PowerManager) systemService).isIgnoringBatteryOptimizations(packageName)) {
            return;
        }
        intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(Uri.parse("package:" + packageName));
        activity.startActivity(intent);
        invoke.m2682c();
    }

    @Command
    public final void disableWebViewOptimizations(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        new Thread(new RunnableC0856a(this, 1)).start();
        invoke.m2682c();
    }

    @Command
    @SuppressLint({"Range"})
    public final void downloadAndInstall(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        DownloadAndInstallArgs downloadAndInstallArgs = (DownloadAndInstallArgs) invoke.m2680a(DownloadAndInstallArgs.class);
        JSObject jSObject = new JSObject();
        jSObject.put("isDownloading", true);
        m2687e("onDownloadAndInstall", jSObject);
        DownloadManager.Request description = new DownloadManager.Request(Uri.parse(downloadAndInstallArgs.getUrl())).setTitle("Downloading Update").setDescription("Please make sure you have a stable connection");
        String str = Environment.DIRECTORY_DOWNLOADS;
        Context context = this.f5153g;
        DownloadManager.Request notificationVisibility = description.setDestinationInExternalFilesDir(context, str, "www-getgrass-io-update.apk").setNotificationVisibility(1);
        Object systemService = context.getSystemService("download");
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.app.DownloadManager", systemService);
        DownloadManager downloadManager = (DownloadManager) systemService;
        context.registerReceiver(new C0857b(downloadManager, downloadManager.enqueue(notificationVisibility), this), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    }

    @Command
    public final void facebookClearUserData(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        SharedPreferences sharedPreferences = AbstractC1725t.f6017a;
        if (!AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
            try {
                C0444d.m976r().execute(new RunnableC0218b(6));
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC1725t.class);
            }
        }
        invoke.m2682c();
    }

    @Command
    public final void facebookLogEvent(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        FacebookLogEventArgs facebookLogEventArgs = (FacebookLogEventArgs) invoke.f3536f.m1918k(FacebookLogEventArgs.class, invoke.f3535e);
        String eventName = facebookLogEventArgs.getEventName();
        List<Object> parameters = facebookLogEventArgs.getParameters();
        if (parameters == null) {
            parameters = C1093l.f3782e;
        }
        Activity activity = this.f5150d;
        Log.d(activity.getPackageName(), "facebookLogEvent eventName:" + eventName);
        Bundle bundle = new Bundle();
        if (!parameters.isEmpty()) {
            for (Object obj : parameters) {
                AbstractC1766e.m3918c("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj);
                Map map = (Map) obj;
                Object obj2 = map.get("key");
                AbstractC1766e.m3918c("null cannot be cast to non-null type kotlin.String", obj2);
                String str = (String) obj2;
                Object obj3 = map.get("value");
                AbstractC1766e.m3918c("null cannot be cast to non-null type kotlin.String", obj3);
                String str2 = (String) obj3;
                Log.d(activity.getPackageName(), AbstractC0032g.m156n("Adding key:", str, " with value:", str2, " as parameter"));
                bundle.putString(str, str2);
            }
        }
        ((C1718m) this.f5155i.f534f).m3815d(bundle, eventName);
        invoke.m2682c();
    }

    @Command
    public final void facebookSetUserData(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        String email = ((FacebookSetUserDataArgs) invoke.f3536f.m1918k(FacebookSetUserDataArgs.class, invoke.f3535e)).getEmail();
        if (email == null) {
            invoke.m2681b("Must provide key");
            return;
        }
        SharedPreferences sharedPreferences = AbstractC1725t.f6017a;
        Set set = AbstractC0147a.f354a;
        if (!set.contains(AbstractC1725t.class)) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("em", email);
                if (!set.contains(AbstractC1725t.class)) {
                    try {
                        C0444d.m976r().execute(new RunnableC0055o(17, bundle));
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, AbstractC1725t.class);
                    }
                }
            } catch (Throwable th2) {
                AbstractC0147a.m295a(th2, AbstractC1725t.class);
            }
        }
        invoke.m2682c();
    }

    @Command
    public final void getBuildInfo(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        JSObject jSObject = new JSObject();
        jSObject.put("brand", Build.BRAND);
        jSObject.put("manufacturer", Build.MANUFACTURER);
        jSObject.put("model", Build.MODEL);
        invoke.m2683d(jSObject);
    }

    @Command
    public final void getId(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        String string = Settings.Secure.getString(this.f5153g.getContentResolver(), "android_id");
        JSObject jSObject = new JSObject();
        jSObject.put("value", string);
        invoke.m2683d(jSObject);
    }

    @Command
    public final void getNetworkStatus(Invoke invoke) {
        EnumC0998b enumC0998b = EnumC0998b.f3564e;
        AbstractC1766e.m3920e("invoke", invoke);
        ConnectivityManager connectivityManager = this.f5156j;
        if (connectivityManager == null) {
            AbstractC1766e.m3924i("connectivityManager");
            throw null;
        }
        if (connectivityManager == null) {
            AbstractC1766e.m3924i("connectivityManager");
            throw null;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        ConnectivityManager connectivityManager2 = this.f5156j;
        if (connectivityManager2 == null) {
            AbstractC1766e.m3924i("connectivityManager");
            throw null;
        }
        NetworkCapabilities networkCapabilities = connectivityManager2.getNetworkCapabilities(activeNetwork);
        boolean z3 = false;
        if (activeNetwork == null || networkCapabilities == null) {
            enumC0998b = EnumC0998b.f3566g;
        } else {
            if (!networkCapabilities.hasTransport(1)) {
                enumC0998b = networkCapabilities.hasTransport(0) ? EnumC0998b.f3565f : EnumC0998b.f3567h;
            }
            z3 = true;
        }
        JSObject jSObject = new JSObject();
        JSObject jSObject2 = new JSObject();
        jSObject2.put("connected", z3);
        String lowerCase = enumC0998b.toString().toLowerCase(Locale.ROOT);
        AbstractC1766e.m3919d("toLowerCase(...)", lowerCase);
        jSObject2.put("connectionType", lowerCase);
        jSObject.put("value", (Object) jSObject2);
        invoke.m2683d(jSObject);
    }

    @Command
    public final void getPreferences(Invoke invoke) {
        String strM2188a;
        AbstractC1766e.m3920e("invoke", invoke);
        String key = ((GetPreferencesArgs) invoke.m2680a(GetPreferencesArgs.class)).getKey();
        if (key == null) {
            invoke.m2681b("Must provide key");
            return;
        }
        try {
            C0861f c0861f = this.f5154h;
            AbstractC1766e.m3917b(c0861f);
            strM2188a = c0861f.m2188a(key);
        } catch (Exception e3) {
            Log.e(this.f5150d.getPackageName(), "Error getting " + key + ' ' + e3.getMessage());
            strM2188a = null;
        }
        JSObject jSObject = new JSObject();
        jSObject.put("value", strM2188a);
        invoke.m2683d(jSObject);
    }

    @Command
    public final void isForegroundServiceEnabled(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        JSObject jSObject = new JSObject();
        ForegroundService.Companion companion = ForegroundService.f5157k;
        jSObject.put("value", ForegroundService.f5158l);
        invoke.m2683d(jSObject);
    }

    @Command
    public final void isIgnoringBatteryOptimizations(Invoke invoke) {
        Activity activity = this.f5150d;
        AbstractC1766e.m3920e("invoke", invoke);
        JSObject jSObject = new JSObject();
        try {
            String packageName = activity.getPackageName();
            Object systemService = activity.getSystemService("power");
            AbstractC1766e.m3918c("null cannot be cast to non-null type android.os.PowerManager", systemService);
            jSObject.put("value", ((PowerManager) systemService).isIgnoringBatteryOptimizations(packageName));
        } catch (Exception unused) {
            jSObject.put("value", false);
        }
        invoke.m2683d(jSObject);
    }

    @Command
    public final void openBatterySettings(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        this.f5150d.startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
        invoke.m2682c();
    }

    @Command
    public final void openInBrowser(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(((OpenInBrowserArgs) invoke.m2680a(OpenInBrowserArgs.class)).getUrl()));
        intent.addFlags(268435456);
        this.f5153g.startActivity(intent);
        invoke.m2682c();
    }

    @Command
    public final void openNotificationSettings(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        Activity activity = this.f5150d;
        intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        activity.startActivity(intent);
        invoke.m2682c();
    }

    @Command
    public final void ping(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        PingArgs pingArgs = (PingArgs) invoke.m2680a(PingArgs.class);
        JSObject jSObject = new JSObject();
        String value = pingArgs.getValue();
        if (value == null) {
            value = "default value :(";
        }
        this.f5151e.getClass();
        Log.i("Pong", value);
        jSObject.put("value", value);
        invoke.m2683d(jSObject);
    }

    @Command
    public final void setPreferences(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        SetPreferencesArgs setPreferencesArgs = (SetPreferencesArgs) invoke.m2680a(SetPreferencesArgs.class);
        String key = setPreferencesArgs.getKey();
        if (key == null) {
            invoke.m2681b("Must provide key");
            return;
        }
        String value = setPreferencesArgs.getValue();
        try {
            C0861f c0861f = this.f5154h;
            AbstractC1766e.m3917b(c0861f);
            c0861f.m2189b(key, value == null ? "" : value);
        } catch (Exception e3) {
            Log.e(this.f5150d.getPackageName(), "Error setting " + key + ' ' + e3.getMessage());
        }
        JSObject jSObject = new JSObject();
        jSObject.put("key", key);
        jSObject.put("value", value);
        m2687e("onPreferencesChanged", jSObject);
        invoke.m2682c();
    }

    @Command
    public final void startForegroundService(Invoke invoke) {
        Context context = this.f5153g;
        AbstractC1766e.m3920e("invoke", invoke);
        try {
            ForegroundService.Companion companion = ForegroundService.f5157k;
            if (ForegroundService.f5158l) {
                Log.i(context.getPackageName(), "ForegroundService is already running");
            } else {
                context.startForegroundService(new Intent(context, (Class<?>) ForegroundService.class));
                this.f5150d.runOnUiThread(new RunnableC0856a(this, 0));
            }
        } catch (Exception e3) {
            Log.e(context.getPackageName(), "startForegroundService: '" + e3.getMessage() + '\'');
        }
        invoke.m2682c();
    }

    @Command
    public final void stopForegroundService(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        ForegroundService.Companion companion = ForegroundService.f5157k;
        if (ForegroundService.f5158l) {
            Context context = this.f5153g;
            context.stopService(new Intent(context, (Class<?>) ForegroundService.class));
        }
        m2687e("onForegroundServiceStop", new JSObject());
        invoke.m2682c();
    }
}
