package com.facebook;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p019F0.C0217a;
import p019F0.C0221e;
import p019F0.C0222f;
import p021G.RunnableC0224a;
import p025H1.C0276e;
import p141s0.AbstractC1874d;
import p141s0.AbstractC1878h;
import p141s0.EnumC1877g;
import p148u0.AbstractC1943b;
import p148u0.RunnableC1942a;
import p160x0.C2011f;
import p166z0.AbstractC2052A;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2077o;
import p166z0.AbstractC2082t;
import p166z0.AbstractC2087y;
import p166z0.C2064b;
import p166z0.C2065c;
import p166z0.C2068f;
import p166z0.CallableC2084v;
import p166z0.EnumC2076n;

/* JADX INFO: renamed from: com.facebook.n */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1117n {

    /* JADX INFO: renamed from: b */
    public static Executor f3876b;

    /* JADX INFO: renamed from: c */
    public static volatile String f3877c;

    /* JADX INFO: renamed from: d */
    public static volatile String f3878d;

    /* JADX INFO: renamed from: e */
    public static volatile String f3879e;

    /* JADX INFO: renamed from: f */
    public static volatile Boolean f3880f;

    /* JADX INFO: renamed from: h */
    public static Context f3882h;

    /* JADX INFO: renamed from: i */
    public static int f3883i;

    /* JADX INFO: renamed from: j */
    public static final Object f3884j;

    /* JADX INFO: renamed from: k */
    public static final String f3885k;

    /* JADX INFO: renamed from: l */
    public static boolean f3886l;

    /* JADX INFO: renamed from: m */
    public static boolean f3887m;

    /* JADX INFO: renamed from: n */
    public static Boolean f3888n;

    /* JADX INFO: renamed from: o */
    public static Boolean f3889o;

    /* JADX INFO: renamed from: p */
    public static final C0222f f3890p;

    /* JADX INFO: renamed from: a */
    public static final HashSet f3875a = new HashSet(Arrays.asList(EnumC1098A.f3789f));

    /* JADX INFO: renamed from: g */
    public static volatile String f3881g = "facebook.com";

    static {
        new AtomicLong(65536L);
        f3883i = 64206;
        f3884j = new Object();
        Collection collection = AbstractC2052A.f7256a;
        f3885k = "v8.0";
        f3886l = false;
        f3887m = false;
        Boolean bool = Boolean.FALSE;
        f3888n = bool;
        f3889o = bool;
        f3890p = new C0222f(8);
    }

    /* JADX INFO: renamed from: a */
    public static Executor m2891a() {
        synchronized (f3884j) {
            try {
                if (f3876b == null) {
                    f3876b = AsyncTask.THREAD_POOL_EXECUTOR;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f3876b;
    }

    /* JADX INFO: renamed from: b */
    public static String m2892b() {
        StringBuilder sb = new StringBuilder("getGraphApiVersion: ");
        String str = f3885k;
        sb.append(str);
        return str;
    }

    /* JADX INFO: renamed from: c */
    public static String m2893c() {
        Date date = C1104a.f3820p;
        C1104a c1104a = (C1104a) C1107d.m2887a().f3849d;
        String str = c1104a != null ? c1104a.f3833o : null;
        if (str != null && str.equals("gaming")) {
            return f3881g.replace("facebook.com", "fb.gg");
        }
        return f3881g;
    }

    /* JADX INFO: renamed from: d */
    public static synchronized boolean m2894d() {
        return f3889o.booleanValue();
    }

    /* JADX INFO: renamed from: e */
    public static synchronized boolean m2895e() {
        return f3888n.booleanValue();
    }

    /* JADX INFO: renamed from: f */
    public static void m2896f() {
        synchronized (f3875a) {
        }
    }

    /* JADX INFO: renamed from: g */
    public static void m2897g(Context context) {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return;
            }
            if (f3877c == null) {
                Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                        f3877c = str.substring(2);
                    } else {
                        f3877c = str;
                    }
                } else if (obj instanceof Number) {
                    throw new C1111h("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                }
            }
            if (f3878d == null) {
                f3878d = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
            }
            if (f3879e == null) {
                f3879e = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
            }
            if (f3883i == 64206) {
                f3883i = applicationInfo.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
            }
            if (f3880f == null) {
                f3880f = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* JADX INFO: renamed from: h */
    public static void m2898h(Context context, String str) {
        if (AbstractC0147a.f354a.contains(AbstractC1117n.class)) {
            return;
        }
        try {
            if (context == null || str == null) {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            C2064b c2064bM4569b = C2064b.m4569b(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
            String strConcat = str.concat("ping");
            long j2 = sharedPreferences.getLong(strConcat, 0L);
            try {
                EnumC1877g enumC1877g = EnumC1877g.f6610e;
                String strM438u = C0221e.m438u(context);
                AbstractC2069g.m4584h();
                JSONObject jSONObjectM4199a = AbstractC1878h.m4199a(enumC1877g, c2064bM4569b, strM438u, context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false), context);
                String strConcat2 = str.concat("/activities");
                f3890p.getClass();
                C1125v c1125vM2913l = C1125v.m2913l(null, strConcat2, jSONObjectM4199a, null);
                if (j2 == 0 && c1125vM2913l.m2923d().f3921c == null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putLong(strConcat, System.currentTimeMillis());
                    editorEdit.apply();
                }
            } catch (JSONException e3) {
                throw new C1111h("An error occurred while publishing install.", e3);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1117n.class);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m2899i(Context context, String str) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1117n.class)) {
            return;
        }
        try {
            m2891a().execute(new RunnableC0224a(context.getApplicationContext(), 2, str));
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1117n.class);
        }
        if (AbstractC2077o.m4613b(EnumC2076n.OnDeviceEventProcessing) && AbstractC1943b.m4338a() && !set.contains(AbstractC1943b.class)) {
            try {
                AbstractC2069g.m4584h();
                Context context2 = f3882h;
                if (context2 == null || str == null) {
                    return;
                }
                m2891a().execute(new RunnableC1942a(context2, str));
                return;
            } catch (Throwable th2) {
                AbstractC0147a.m295a(th2, AbstractC1943b.class);
                return;
            }
            AbstractC0147a.m295a(th, AbstractC1117n.class);
        }
    }

    /* JADX INFO: renamed from: j */
    public static synchronized void m2900j(Context context) {
        ActivityInfo activityInfo;
        int i3 = 8;
        int i4 = 9;
        synchronized (AbstractC1117n.class) {
            try {
                if (f3888n.booleanValue()) {
                    return;
                }
                AbstractC2069g.m4582f("applicationContext", context);
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    try {
                        activityInfo = packageManager.getActivityInfo(new ComponentName(context, "com.facebook.FacebookActivity"), 1);
                    } catch (PackageManager.NameNotFoundException unused) {
                        activityInfo = null;
                    }
                } else {
                    activityInfo = null;
                }
                if (activityInfo == null) {
                    Log.w("z0.g", "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
                }
                if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
                    Log.w("z0.g", "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
                }
                f3882h = context.getApplicationContext();
                C0221e.m438u(context);
                m2897g(f3882h);
                if (AbstractC2056E.m4550s(f3877c)) {
                    throw new C1111h("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
                }
                f3888n = Boolean.TRUE;
                AtomicBoolean atomicBoolean = AbstractC1103F.f3811a;
                boolean zM2863a = false;
                if (!AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
                    try {
                        AbstractC1103F.m2868e();
                        zM2863a = AbstractC1103F.f3813c.m2863a();
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, AbstractC1103F.class);
                    }
                }
                if (zM2863a) {
                    f3889o = Boolean.TRUE;
                }
                if ((f3882h instanceof Application) && AbstractC1103F.m2866c()) {
                    AbstractC1874d.m4194c((Application) f3882h, f3877c);
                }
                AbstractC2082t.m4622c();
                AbstractC2087y.m4642k();
                C2065c.m4571a(f3882h);
                CallableC1115l callableC1115l = new CallableC1115l();
                C2011f c2011f = new C2011f();
                c2011f.f7169b = new CountDownLatch(1);
                m2891a().execute(new FutureTask(new CallableC2084v(c2011f, callableC1115l)));
                AbstractC2077o.m4612a(new C0276e(i3), EnumC2076n.Instrument);
                AbstractC2077o.m4612a(new C2068f(i3), EnumC2076n.AppEvents);
                AbstractC2077o.m4612a(new C0217a(i4), EnumC2076n.ChromeCustomTabsPrefetching);
                AbstractC2077o.m4612a(new C0222f(i4), EnumC2076n.IgnoreAppSwitchToLoggedOut);
                AbstractC2077o.m4612a(new C0276e(i4), EnumC2076n.Monitoring);
                m2891a().execute(new FutureTask(new CallableC1116m(context)));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
