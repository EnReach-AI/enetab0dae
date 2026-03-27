package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p117m0.C1718m;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: com.facebook.F */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1103F {

    /* JADX INFO: renamed from: a */
    public static final AtomicBoolean f3811a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b */
    public static final AtomicBoolean f3812b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c */
    public static final C1102E f3813c = new C1102E("com.facebook.sdk.AutoInitEnabled", true);

    /* JADX INFO: renamed from: d */
    public static final C1102E f3814d = new C1102E("com.facebook.sdk.AutoLogAppEventsEnabled", true);

    /* JADX INFO: renamed from: e */
    public static final C1102E f3815e = new C1102E("com.facebook.sdk.AdvertiserIDCollectionEnabled", true);

    /* JADX INFO: renamed from: f */
    public static final C1102E f3816f = new C1102E("auto_event_setup_enabled", false);

    /* JADX INFO: renamed from: g */
    public static final C1102E f3817g = new C1102E("com.facebook.sdk.MonitorEnabled", true);

    /* JADX INFO: renamed from: h */
    public static SharedPreferences f3818h;

    /* JADX INFO: renamed from: a */
    public static C1102E m2864a() {
        if (AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            return null;
        }
        try {
            return f3816f;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1103F.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m2865b() {
        if (AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            return false;
        }
        try {
            m2868e();
            return f3815e.m2863a();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1103F.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m2866c() {
        if (AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            return false;
        }
        try {
            m2868e();
            return f3814d.m2863a();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1103F.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m2867d() {
        if (AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            return;
        }
        try {
            C1102E c1102e = f3816f;
            m2872i(c1102e);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (c1102e.f3808b == null || jCurrentTimeMillis - c1102e.f3810d >= 604800000) {
                c1102e.f3808b = null;
                c1102e.f3810d = 0L;
                if (f3812b.compareAndSet(false, true)) {
                    AbstractC1117n.m2891a().execute(new RunnableC1101D(jCurrentTimeMillis));
                }
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1103F.class);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m2868e() {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1103F.class)) {
            return;
        }
        try {
            if (AbstractC1117n.m2895e()) {
                if (f3811a.compareAndSet(false, true)) {
                    AbstractC2069g.m4584h();
                    f3818h = AbstractC1117n.f3882h.getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
                    C1102E[] c1102eArr = {f3814d, f3815e, f3813c};
                    if (!set.contains(AbstractC1103F.class)) {
                        for (int i3 = 0; i3 < 3; i3++) {
                            try {
                                C1102E c1102e = c1102eArr[i3];
                                if (c1102e == f3816f) {
                                    m2867d();
                                } else if (c1102e.f3808b == null) {
                                    m2872i(c1102e);
                                    if (c1102e.f3808b == null) {
                                        m2869f(c1102e);
                                    }
                                } else {
                                    m2874k(c1102e);
                                }
                            } catch (Throwable th) {
                                AbstractC0147a.m295a(th, AbstractC1103F.class);
                                m2867d();
                                m2871h();
                                m2870g();
                            }
                        }
                    }
                    m2867d();
                    m2871h();
                    m2870g();
                }
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1103F.class);
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m2869f(C1102E c1102e) {
        Bundle bundle;
        if (AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            return;
        }
        try {
            m2873j();
            try {
                HashSet hashSet = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                Context context = AbstractC1117n.f3882h;
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(c1102e.f3807a)) {
                    return;
                }
                c1102e.f3808b = Boolean.valueOf(applicationInfo.metaData.getBoolean(c1102e.f3807a, c1102e.f3809c));
            } catch (PackageManager.NameNotFoundException unused) {
                HashSet hashSet2 = AbstractC1117n.f3875a;
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1103F.class);
        }
    }

    /* JADX INFO: renamed from: g */
    public static void m2870g() {
        int i3;
        ApplicationInfo applicationInfo;
        if (AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            return;
        }
        try {
            if (f3811a.get() && AbstractC1117n.m2895e()) {
                AbstractC2069g.m4584h();
                Context context = AbstractC1117n.f3882h;
                int i4 = (f3813c.m2863a() ? 1 : 0) | ((f3814d.m2863a() ? 1 : 0) << 1) | ((f3815e.m2863a() ? 1 : 0) << 2) | ((f3817g.m2863a() ? 1 : 0) << 3);
                int i5 = 0;
                int i6 = f3818h.getInt("com.facebook.sdk.USER_SETTINGS_BITMASK", 0);
                if (i6 != i4) {
                    f3818h.edit().putInt("com.facebook.sdk.USER_SETTINGS_BITMASK", i4).commit();
                    try {
                        applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    if (applicationInfo == null || applicationInfo.metaData == null) {
                        i3 = 0;
                    } else {
                        String[] strArr = {"com.facebook.sdk.AutoInitEnabled", "com.facebook.sdk.AutoLogAppEventsEnabled", "com.facebook.sdk.AdvertiserIDCollectionEnabled", "com.facebook.sdk.MonitorEnabled"};
                        boolean[] zArr = {true, true, true, true};
                        i3 = 0;
                        int i7 = 0;
                        while (i5 < 4) {
                            try {
                                i7 |= (applicationInfo.metaData.containsKey(strArr[i5]) ? 1 : 0) << i5;
                                i3 |= (applicationInfo.metaData.getBoolean(strArr[i5], zArr[i5]) ? 1 : 0) << i5;
                                i5++;
                            } catch (PackageManager.NameNotFoundException unused2) {
                            }
                        }
                        i5 = i7;
                    }
                    C1718m c1718m = new C1718m(context, (String) null);
                    Bundle bundle = new Bundle();
                    bundle.putInt("usage", i5);
                    bundle.putInt("initial", i3);
                    bundle.putInt("previous", i6);
                    bundle.putInt("current", i4);
                    if ((bundle.getInt("previous") & 2) == 0) {
                        HashSet hashSet = AbstractC1117n.f3875a;
                        if (!m2866c()) {
                            return;
                        }
                    }
                    c1718m.m3817g(bundle, "fb_sdk_settings_changed");
                }
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1103F.class);
        }
    }

    /* JADX INFO: renamed from: h */
    public static void m2871h() {
        Bundle bundle;
        if (AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            return;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            Context context = AbstractC1117n.f3882h;
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return;
            }
            if (!bundle.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled")) {
                Log.w("com.facebook.F", "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
            }
            if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled")) {
                Log.w("com.facebook.F", "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
            }
            if (m2865b()) {
                return;
            }
            Log.w("com.facebook.F", "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.");
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1103F.class);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m2872i(C1102E c1102e) {
        if (AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            return;
        }
        try {
            m2873j();
            try {
                String string = f3818h.getString(c1102e.f3807a, "");
                if (string.isEmpty()) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(string);
                c1102e.f3808b = Boolean.valueOf(jSONObject.getBoolean("value"));
                c1102e.f3810d = jSONObject.getLong("last_timestamp");
            } catch (JSONException unused) {
                HashSet hashSet = AbstractC1117n.f3875a;
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1103F.class);
        }
    }

    /* JADX INFO: renamed from: j */
    public static void m2873j() {
        if (AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            return;
        }
        try {
            if (f3811a.get()) {
            } else {
                throw new C1118o("The UserSettingManager has not been initialized successfully");
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1103F.class);
        }
    }

    /* JADX INFO: renamed from: k */
    public static void m2874k(C1102E c1102e) {
        if (AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            return;
        }
        try {
            m2873j();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("value", c1102e.f3808b);
                jSONObject.put("last_timestamp", c1102e.f3810d);
                f3818h.edit().putString(c1102e.f3807a, jSONObject.toString()).commit();
                m2870g();
            } catch (Exception unused) {
                HashSet hashSet = AbstractC1117n.f3875a;
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1103F.class);
        }
    }
}
