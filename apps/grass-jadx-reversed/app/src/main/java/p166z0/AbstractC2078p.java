package p166z0;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.AbstractC1117n;
import com.facebook.C1125v;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005B.AbstractC0032g;
import p007B1.RunnableC0055o;
import p148u0.RunnableC1942a;

/* JADX INFO: renamed from: z0.p */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2078p {

    /* JADX INFO: renamed from: a */
    public static final AtomicBoolean f7346a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b */
    public static final ConcurrentLinkedQueue f7347b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c */
    public static final ConcurrentHashMap f7348c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d */
    public static Long f7349d;

    /* JADX INFO: renamed from: a */
    public static JSONObject m4614a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "android");
        HashSet hashSet = AbstractC1117n.f3875a;
        bundle.putString("sdk_version", "8.2.0");
        bundle.putString("fields", "gatekeepers");
        C1125v c1125v = new C1125v(null, AbstractC0032g.m157o(new StringBuilder(), str, "/mobile_sdk_gk"), null, null, null);
        c1125v.f3911i = true;
        c1125v.f3907e = bundle;
        return c1125v.m2923d().f3920b;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m4615b(java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            r0 = 0
            m4616c(r0)
            if (r5 == 0) goto L3e
            java.util.concurrent.ConcurrentHashMap r0 = p166z0.AbstractC2078p.f7348c
            boolean r1 = r0.containsKey(r5)
            if (r1 != 0) goto Lf
            goto L3e
        Lf:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.Object r5 = r0.get(r5)
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            if (r5 != 0) goto L22
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            goto L43
        L22:
            java.util.Iterator r0 = r5.keys()
        L26:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L43
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = r5.optBoolean(r2)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r1.put(r2, r3)
            goto L26
        L3e:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
        L43:
            boolean r5 = r1.containsKey(r4)
            if (r5 != 0) goto L4a
            return r6
        L4a:
            java.lang.Object r4 = r1.get(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            if (r4 != 0) goto L53
            return r6
        L53:
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p166z0.AbstractC2078p.m4615b(java.lang.String, java.lang.String, boolean):boolean");
    }

    /* JADX INFO: renamed from: c */
    public static synchronized void m4616c(C2074l c2074l) {
        if (c2074l != null) {
            try {
                f7347b.add(c2074l);
            } catch (Throwable th) {
                throw th;
            }
        }
        Long l3 = f7349d;
        if (l3 != null && System.currentTimeMillis() - l3.longValue() < 3600000) {
            m4618e();
            return;
        }
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        Context context = AbstractC1117n.f3882h;
        AbstractC2069g.m4584h();
        String str = AbstractC1117n.f3877c;
        String str2 = "com.facebook.internal.APP_GATEKEEPERS." + str;
        if (context == null) {
            return;
        }
        JSONObject jSONObject = null;
        String string = context.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).getString(str2, null);
        if (!AbstractC2056E.m4550s(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException unused) {
                HashSet hashSet2 = AbstractC1117n.f3875a;
            }
            if (jSONObject != null) {
                m4617d(str, jSONObject);
            }
        }
        Executor executorM2891a = AbstractC1117n.m2891a();
        if (executorM2891a == null) {
            return;
        }
        if (f7346a.compareAndSet(false, true)) {
            executorM2891a.execute(new RunnableC1942a(str, context, str2));
        }
    }

    /* JADX INFO: renamed from: d */
    public static synchronized JSONObject m4617d(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            ConcurrentHashMap concurrentHashMap = f7348c;
            jSONObject2 = concurrentHashMap.containsKey(str) ? (JSONObject) concurrentHashMap.get(str) : new JSONObject();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.optJSONObject(0) : null;
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optJSONArray("gatekeepers") != null) {
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("gatekeepers");
                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                    try {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i3);
                        jSONObject2.put(jSONObject3.getString("key"), jSONObject3.getBoolean("value"));
                    } catch (JSONException unused) {
                        HashSet hashSet = AbstractC1117n.f3875a;
                    }
                }
            }
            f7348c.put(str, jSONObject2);
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject2;
    }

    /* JADX INFO: renamed from: e */
    public static void m4618e() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue concurrentLinkedQueue = f7347b;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            C2074l c2074l = (C2074l) concurrentLinkedQueue.poll();
            if (c2074l != null) {
                handler.post(new RunnableC0055o(24, c2074l));
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m4619f(String str) {
        JSONObject jSONObjectM4614a = m4614a(str);
        if (jSONObjectM4614a == null) {
            return;
        }
        AbstractC2069g.m4584h();
        Context context = AbstractC1117n.f3882h;
        context.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(AbstractC0032g.m152j("com.facebook.internal.APP_GATEKEEPERS.", str), jSONObjectM4614a.toString()).apply();
        m4617d(str, jSONObjectM4614a);
    }
}
