package p019F0;

import android.os.Bundle;
import com.facebook.AbstractC1117n;
import com.facebook.C1125v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: F0.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0219c {

    /* JADX INFO: renamed from: a */
    public static boolean f524a;

    /* JADX INFO: renamed from: b */
    public static final C0220d f525b;

    /* JADX INFO: renamed from: c */
    public static final HashMap f526c;

    static {
        C0221e c0221e;
        C0222f c0222f;
        C0220d c0220d;
        new Random();
        synchronized (C0221e.class) {
            try {
                if (C0221e.f532g == null) {
                    C0221e c0221e2 = new C0221e(0, false);
                    c0221e2.f534f = new LinkedList();
                    C0221e.f532g = c0221e2;
                }
                c0221e = C0221e.f532g;
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (C0222f.class) {
            try {
                if (C0222f.f535f == null) {
                    C0222f.f535f = new C0222f(0);
                }
                c0222f = C0222f.f535f;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        C0220d c0220d2 = C0220d.f527c;
        synchronized (C0220d.class) {
            try {
                if (C0220d.f527c == null) {
                    C0220d c0220d3 = new C0220d();
                    Executors.newSingleThreadScheduledExecutor();
                    if (c0220d3.f530a == null) {
                        c0220d3.f530a = c0221e;
                    }
                    if (c0220d3.f531b == null) {
                        c0220d3.f531b = c0222f;
                    }
                    C0220d.f527c = c0220d3;
                }
                c0220d = C0220d.f527c;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        f525b = c0220d;
        synchronized (C0217a.class) {
            if (!AbstractC0147a.f354a.contains(C0217a.class)) {
                try {
                    if (C0217a.f521f == null) {
                        C0217a c0217a = new C0217a(0);
                        new HashMap();
                        C0217a.f521f = c0217a;
                    }
                } catch (Throwable th4) {
                    AbstractC0147a.m295a(th4, C0217a.class);
                }
            }
        }
        f526c = new HashMap();
        new AtomicLong(0L);
    }

    /* JADX INFO: renamed from: a */
    public static JSONObject m435a() {
        if (AbstractC0147a.f354a.contains(AbstractC0219c.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("fields", "monitoring_config");
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C1125v c1125v = new C1125v(null, AbstractC1117n.f3877c, null, null, null);
            c1125v.f3911i = true;
            c1125v.f3907e = bundle;
            return c1125v.m2923d().f3920b;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC0219c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m436b(JSONObject jSONObject) {
        if (AbstractC0147a.f354a.contains(AbstractC0219c.class)) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("monitoring_config").getJSONArray("sample_rates");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                String string = jSONObject2.getString("key");
                int i4 = jSONObject2.getInt("value");
                if (!"default".equals(string)) {
                    f526c.put(string, Integer.valueOf(i4));
                }
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC0219c.class);
        }
    }
}
