package p117m0;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.facebook.AbstractC1117n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import p010C0.AbstractC0147a;
import p121n0.C1778c;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: m0.t */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1725t {

    /* JADX INFO: renamed from: a */
    public static SharedPreferences f6017a;

    /* JADX INFO: renamed from: b */
    public static final AtomicBoolean f6018b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c */
    public static final ConcurrentHashMap f6019c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d */
    public static final ConcurrentHashMap f6020d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a */
    public static AtomicBoolean m3829a() {
        if (AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
            return null;
        }
        try {
            return f6018b;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1725t.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m3830b() {
        if (AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
            return;
        }
        try {
            m3832d();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1725t.class);
        }
    }

    /* JADX INFO: renamed from: c */
    public static HashMap m3831c() {
        if (AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            HashSet hashSetM3936b = C1778c.m3936b();
            ConcurrentHashMap concurrentHashMap = f6020d;
            for (String str : concurrentHashMap.keySet()) {
                if (hashSetM3936b.contains(str)) {
                    map.put(str, concurrentHashMap.get(str));
                }
            }
            return map;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1725t.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public static synchronized void m3832d() {
        if (AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = f6018b;
            if (atomicBoolean.get()) {
                return;
            }
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AbstractC1117n.f3882h);
            f6017a = defaultSharedPreferences;
            String string = defaultSharedPreferences.getString("com.facebook.appevents.UserDataStore.userData", "");
            String string2 = f6017a.getString("com.facebook.appevents.UserDataStore.internalUserData", "");
            f6019c.putAll(AbstractC2056E.m4532a(string));
            f6020d.putAll(AbstractC2056E.m4532a(string2));
            atomicBoolean.set(true);
            return;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1725t.class);
            return;
        }
    }

    /* JADX INFO: renamed from: e */
    public static String m3833e(String str, String str2) {
        if (AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
            return null;
        }
        try {
            String lowerCase = str2.trim().toLowerCase();
            if ("em".equals(str)) {
                if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                    return lowerCase;
                }
                Log.e("t", "Setting email failure: this is not a valid email address");
                return "";
            }
            if ("ph".equals(str)) {
                return lowerCase.replaceAll("[^0-9]", "");
            }
            if (!"ge".equals(str)) {
                return lowerCase;
            }
            String strSubstring = lowerCase.length() > 0 ? lowerCase.substring(0, 1) : "";
            if (!"f".equals(strSubstring) && !"m".equals(strSubstring)) {
                Log.e("t", "Setting gender failure: the supported value for gender is f or m");
                return "";
            }
            return strSubstring;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1725t.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m3834f(Bundle bundle) {
        if (AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
            return;
        }
        try {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null) {
                    String string = obj.toString();
                    boolean zMatches = false;
                    if (!AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
                        try {
                            zMatches = string.matches("[A-Fa-f0-9]{64}");
                        } catch (Throwable th) {
                            AbstractC0147a.m295a(th, AbstractC1725t.class);
                        }
                    }
                    ConcurrentHashMap concurrentHashMap = f6019c;
                    if (zMatches) {
                        concurrentHashMap.put(str, string.toLowerCase());
                    } else {
                        String strM4530B = AbstractC2056E.m4530B(m3833e(str, string));
                        if (strM4530B != null) {
                            concurrentHashMap.put(str, strM4530B);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1725t.class);
        }
    }

    /* JADX INFO: renamed from: g */
    public static void m3835g(String str, String str2) {
        if (AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
            return;
        }
        try {
            AbstractC1117n.m2891a().execute(new RunnableC1713h(str, 3, str2));
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1725t.class);
        }
    }
}
