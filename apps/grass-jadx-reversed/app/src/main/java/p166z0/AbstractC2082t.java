package p166z0;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.AbstractC1117n;
import com.facebook.C1125v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import p005B.AbstractC0032g;
import p117m0.C1719n;
import p148u0.RunnableC1942a;

/* JADX INFO: renamed from: z0.t */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2082t {

    /* JADX INFO: renamed from: a */
    public static final String[] f7370a = {"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url", "restrictive_data_filter_params", "aam_rules", "suggested_events_setting"};

    /* JADX INFO: renamed from: b */
    public static final ConcurrentHashMap f7371b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c */
    public static final AtomicReference f7372c = new AtomicReference(EnumC2081s.f7365e);

    /* JADX INFO: renamed from: d */
    public static final ConcurrentLinkedQueue f7373d = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: e */
    public static boolean f7374e = false;

    /* JADX INFO: renamed from: a */
    public static JSONObject m4620a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", new ArrayList(Arrays.asList(f7370a))));
        C1125v c1125v = new C1125v(null, str, null, null, null);
        c1125v.f3911i = true;
        c1125v.f3907e = bundle;
        return c1125v.m2923d().f3920b;
    }

    /* JADX INFO: renamed from: b */
    public static C2079q m4621b(String str) {
        if (str != null) {
            return (C2079q) f7371b.get(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public static void m4622c() {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        Context context = AbstractC1117n.f3882h;
        AbstractC2069g.m4584h();
        String str = AbstractC1117n.f3877c;
        boolean zM4550s = AbstractC2056E.m4550s(str);
        EnumC2081s enumC2081s = EnumC2081s.f7368h;
        if (zM4550s) {
            f7372c.set(enumC2081s);
            m4624e();
            return;
        }
        if (f7371b.containsKey(str)) {
            f7372c.set(EnumC2081s.f7367g);
            m4624e();
            return;
        }
        AtomicReference atomicReference = f7372c;
        EnumC2081s enumC2081s2 = EnumC2081s.f7365e;
        EnumC2081s enumC2081s3 = EnumC2081s.f7366f;
        while (true) {
            if (atomicReference.compareAndSet(enumC2081s2, enumC2081s3)) {
                break;
            }
            if (atomicReference.get() != enumC2081s2) {
                AtomicReference atomicReference2 = f7372c;
                while (!atomicReference2.compareAndSet(enumC2081s, enumC2081s3)) {
                    if (atomicReference2.get() != enumC2081s) {
                        m4624e();
                        return;
                    }
                }
            }
        }
        AbstractC1117n.m2891a().execute(new RunnableC1942a(context, AbstractC0032g.m152j("com.facebook.internal.APP_SETTINGS.", str), str));
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b3  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p166z0.C2079q m4623d(java.lang.String r27, org.json.JSONObject r28) {
        /*
            Method dump skipped, instruction units count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p166z0.AbstractC2082t.m4623d(java.lang.String, org.json.JSONObject):z0.q");
    }

    /* JADX INFO: renamed from: e */
    public static synchronized void m4624e() {
        EnumC2081s enumC2081s = (EnumC2081s) f7372c.get();
        if (!EnumC2081s.f7365e.equals(enumC2081s) && !EnumC2081s.f7366f.equals(enumC2081s)) {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C2079q c2079q = (C2079q) f7371b.get(AbstractC1117n.f3877c);
            Handler handler = new Handler(Looper.getMainLooper());
            if (EnumC2081s.f7368h.equals(enumC2081s)) {
                while (true) {
                    ConcurrentLinkedQueue concurrentLinkedQueue = f7373d;
                    if (concurrentLinkedQueue.isEmpty()) {
                        return;
                    } else {
                        handler.post(new RunnableC2080r((C1719n) concurrentLinkedQueue.poll()));
                    }
                }
            } else {
                while (true) {
                    ConcurrentLinkedQueue concurrentLinkedQueue2 = f7373d;
                    if (concurrentLinkedQueue2.isEmpty()) {
                        return;
                    } else {
                        handler.post(new RunnableC2080r((C1719n) concurrentLinkedQueue2.poll(), c2079q));
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public static C2079q m4625f(String str, boolean z3) {
        if (!z3) {
            ConcurrentHashMap concurrentHashMap = f7371b;
            if (concurrentHashMap.containsKey(str)) {
                return (C2079q) concurrentHashMap.get(str);
            }
        }
        JSONObject jSONObjectM4620a = m4620a(str);
        if (jSONObjectM4620a == null) {
            return null;
        }
        C2079q c2079qM4623d = m4623d(str, jSONObjectM4620a);
        AbstractC2069g.m4584h();
        if (str.equals(AbstractC1117n.f3877c)) {
            f7372c.set(EnumC2081s.f7367g);
            m4624e();
        }
        return c2079qM4623d;
    }
}
