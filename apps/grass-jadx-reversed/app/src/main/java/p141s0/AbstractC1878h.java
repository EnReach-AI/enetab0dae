package p141s0;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p117m0.AbstractC1708c;
import p117m0.AbstractC1725t;
import p166z0.AbstractC2056E;
import p166z0.C2064b;
import p166z0.C2085w;

/* JADX INFO: renamed from: s0.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1878h {

    /* JADX INFO: renamed from: a */
    public static final C1876f f6613a;

    static {
        C1876f c1876f = new C1876f();
        c1876f.put(EnumC1877g.f6610e, "MOBILE_APP_INSTALL");
        c1876f.put(EnumC1877g.f6611f, "CUSTOM_APP_EVENTS");
        f6613a = c1876f;
    }

    /* JADX INFO: renamed from: a */
    public static JSONObject m4199a(EnumC1877g enumC1877g, C2064b c2064b, String str, boolean z3, Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", f6613a.get(enumC1877g));
        if (!AbstractC1708c.f5978c) {
            Log.w("c", "initStore should have been called before calling setUserID");
            AbstractC1708c.m3789a();
        }
        ReentrantReadWriteLock reentrantReadWriteLock = AbstractC1708c.f5976a;
        reentrantReadWriteLock.readLock().lock();
        try {
            String str2 = AbstractC1708c.f5977b;
            reentrantReadWriteLock.readLock().unlock();
            if (str2 != null) {
                jSONObject.put("app_user_id", str2);
            }
            jSONObject.put("anon_id", str);
            jSONObject.put("application_tracking_enabled", !z3);
            HashSet hashSet = AbstractC1117n.f3875a;
            jSONObject.put("advertiser_id_collection_enabled", AbstractC1103F.m2865b());
            if (c2064b != null) {
                String str3 = c2064b.f7296a;
                if (str3 != null) {
                    jSONObject.put("attribution", str3);
                }
                if (c2064b.m4570a() != null) {
                    jSONObject.put("advertiser_id", c2064b.m4570a());
                    jSONObject.put("advertiser_tracking_enabled", !c2064b.f7299d);
                }
                if (!c2064b.f7299d) {
                    SharedPreferences sharedPreferences = AbstractC1725t.f6017a;
                    String strM4553v = null;
                    if (!AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
                        try {
                            if (!AbstractC1725t.f6018b.get()) {
                                AbstractC1725t.m3832d();
                            }
                            HashMap map = new HashMap();
                            map.putAll(AbstractC1725t.f6019c);
                            map.putAll(AbstractC1725t.m3831c());
                            strM4553v = AbstractC2056E.m4553v(map);
                        } catch (Throwable th) {
                            AbstractC0147a.m295a(th, AbstractC1725t.class);
                        }
                    }
                    if (!strM4553v.isEmpty()) {
                        jSONObject.put("ud", strM4553v);
                    }
                }
                String str4 = c2064b.f7298c;
                if (str4 != null) {
                    jSONObject.put("installer_package", str4);
                }
            }
            try {
                AbstractC2056E.m4529A(jSONObject, context);
            } catch (Exception e3) {
                e3.toString();
                HashMap map2 = C2085w.f7377b;
                AbstractC1117n.m2896f();
            }
            JSONObject jSONObjectM4543l = AbstractC2056E.m4543l();
            if (jSONObjectM4543l != null) {
                Iterator<String> itKeys = jSONObjectM4543l.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, jSONObjectM4543l.get(next));
                }
            }
            jSONObject.put("application_package_name", context.getPackageName());
            return jSONObject;
        } catch (Throwable th2) {
            AbstractC1708c.f5976a.readLock().unlock();
            throw th2;
        }
    }
}
