package p117m0;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AbstractC1117n;
import com.facebook.C1104a;
import com.facebook.C1107d;
import com.facebook.C1111h;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import p010C0.AbstractC0147a;
import p019F0.RunnableC0218b;
import p141s0.AbstractC1874d;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2078p;
import p166z0.C2085w;

/* JADX INFO: renamed from: m0.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1718m {

    /* JADX INFO: renamed from: c */
    public static ScheduledThreadPoolExecutor f6000c;

    /* JADX INFO: renamed from: d */
    public static final Object f6001d = new Object();

    /* JADX INFO: renamed from: e */
    public static String f6002e;

    /* JADX INFO: renamed from: f */
    public static boolean f6003f;

    /* JADX INFO: renamed from: a */
    public final String f6004a;

    /* JADX INFO: renamed from: b */
    public final C1707b f6005b;

    public C1718m(Context context, String str) {
        this(AbstractC2056E.m4540i(context), str);
    }

    /* JADX INFO: renamed from: a */
    public static int m3810a() {
        if (AbstractC0147a.f354a.contains(C1718m.class)) {
            return 0;
        }
        try {
            synchronized (f6001d) {
            }
            return 1;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C1718m.class);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:9:0x001f, B:17:0x0040, B:15:0x003a, B:12:0x0027), top: B:26:0x001f, outer: #2, inners: #1 }] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m3811b() {
        /*
            java.util.Set r0 = p010C0.AbstractC0147a.f354a
            java.lang.Class<m0.m> r1 = p117m0.C1718m.class
            boolean r2 = r0.contains(r1)
            r3 = 0
            if (r2 == 0) goto Lc
            return r3
        Lc:
            z0.f r2 = new z0.f     // Catch: java.lang.Throwable -> L5a
            r4 = 10
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L5a
            java.lang.Class<z0.u> r4 = p166z0.AbstractC2083u.class
            boolean r5 = r0.contains(r4)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r6 = "com.facebook.sdk.appEventPreferences"
            r7 = 0
            if (r5 == 0) goto L1f
            goto L48
        L1f:
            boolean r0 = r0.contains(r4)     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L27
        L25:
            r0 = r7
            goto L3e
        L27:
            java.util.HashSet r0 = com.facebook.AbstractC1117n.f3875a     // Catch: java.lang.Throwable -> L39
            p166z0.AbstractC2069g.m4584h()     // Catch: java.lang.Throwable -> L39
            android.content.Context r0 = com.facebook.AbstractC1117n.f3882h     // Catch: java.lang.Throwable -> L39
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r6, r7)     // Catch: java.lang.Throwable -> L39
            java.lang.String r5 = "is_referrer_updated"
            boolean r0 = r0.getBoolean(r5, r7)     // Catch: java.lang.Throwable -> L39
            goto L3e
        L39:
            r0 = move-exception
            p010C0.AbstractC0147a.m295a(r0, r4)     // Catch: java.lang.Throwable -> L44
            goto L25
        L3e:
            if (r0 != 0) goto L48
            p166z0.AbstractC2083u.m4627b(r2)     // Catch: java.lang.Throwable -> L44
            goto L48
        L44:
            r0 = move-exception
            p010C0.AbstractC0147a.m295a(r0, r4)     // Catch: java.lang.Throwable -> L5a
        L48:
            java.util.HashSet r0 = com.facebook.AbstractC1117n.f3875a     // Catch: java.lang.Throwable -> L5a
            p166z0.AbstractC2069g.m4584h()     // Catch: java.lang.Throwable -> L5a
            android.content.Context r0 = com.facebook.AbstractC1117n.f3882h     // Catch: java.lang.Throwable -> L5a
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r6, r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r2 = "install_referrer"
            java.lang.String r0 = r0.getString(r2, r3)     // Catch: java.lang.Throwable -> L5a
            return r0
        L5a:
            r0 = move-exception
            p010C0.AbstractC0147a.m295a(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p117m0.C1718m.m3811b():java.lang.String");
    }

    /* JADX INFO: renamed from: c */
    public static void m3812c() {
        if (AbstractC0147a.f354a.contains(C1718m.class)) {
            return;
        }
        try {
            synchronized (f6001d) {
                try {
                    if (f6000c != null) {
                        return;
                    }
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                    f6000c = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.scheduleAtFixedRate(new RunnableC0218b(5), 0L, 86400L, TimeUnit.SECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, C1718m.class);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0063 A[Catch: all -> 0x0072, TRY_LEAVE, TryCatch #0 {all -> 0x0072, blocks: (B:19:0x0042, B:29:0x005e, B:32:0x0063, B:28:0x005a, B:24:0x004d), top: B:49:0x0042, outer: #2, inners: #3 }] */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m3813f(p117m0.C1711f r7, p117m0.C1707b r8) {
        /*
            r0 = 1
            r1 = 0
            java.util.Set r2 = p010C0.AbstractC0147a.f354a
            java.lang.Class<m0.m> r3 = p117m0.C1718m.class
            boolean r4 = r2.contains(r3)
            if (r4 == 0) goto Ld
            return
        Ld:
            L0.d r4 = p117m0.AbstractC1715j.f5996a     // Catch: java.lang.Throwable -> L77
            java.lang.Class<m0.j> r4 = p117m0.AbstractC1715j.class
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L77
            if (r2 == 0) goto L18
            goto L27
        L18:
            java.util.concurrent.ScheduledExecutorService r2 = p117m0.AbstractC1715j.f5997b     // Catch: java.lang.Throwable -> L23
            m0.h r5 = new m0.h     // Catch: java.lang.Throwable -> L23
            r5.<init>(r8, r1, r7)     // Catch: java.lang.Throwable -> L23
            r2.execute(r5)     // Catch: java.lang.Throwable -> L23
            goto L27
        L23:
            r2 = move-exception
            p010C0.AbstractC0147a.m295a(r2, r4)     // Catch: java.lang.Throwable -> L77
        L27:
            z0.n r2 = p166z0.EnumC2076n.OnDevicePostInstallEventProcessing     // Catch: java.lang.Throwable -> L77
            boolean r2 = p166z0.AbstractC2077o.m4613b(r2)     // Catch: java.lang.Throwable -> L77
            if (r2 == 0) goto L79
            boolean r2 = p148u0.AbstractC1943b.m4338a()     // Catch: java.lang.Throwable -> L77
            if (r2 == 0) goto L79
            java.lang.String r8 = r8.f5975f     // Catch: java.lang.Throwable -> L77
            java.util.Set r2 = p010C0.AbstractC0147a.f354a     // Catch: java.lang.Throwable -> L77
            java.lang.Class<u0.b> r4 = p148u0.AbstractC1943b.class
            boolean r5 = r2.contains(r4)     // Catch: java.lang.Throwable -> L77
            if (r5 == 0) goto L42
            goto L79
        L42:
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L72
            if (r2 == 0) goto L49
            goto L79
        L49:
            boolean r2 = r7.f5985f     // Catch: java.lang.Throwable -> L77
            if (r2 == 0) goto L5e
            java.util.HashSet r5 = p148u0.AbstractC1943b.f6939a     // Catch: java.lang.Throwable -> L59
            java.lang.String r6 = r7.f5987h     // Catch: java.lang.Throwable -> L59
            boolean r5 = r5.contains(r6)     // Catch: java.lang.Throwable -> L59
            if (r5 == 0) goto L5e
            r1 = r0
            goto L5e
        L59:
            r8 = move-exception
            p010C0.AbstractC0147a.m295a(r8, r4)     // Catch: java.lang.Throwable -> L72
            goto L79
        L5e:
            r2 = r2 ^ r0
            if (r2 != 0) goto L63
            if (r1 == 0) goto L79
        L63:
            java.util.concurrent.Executor r1 = com.facebook.AbstractC1117n.m2891a()     // Catch: java.lang.Throwable -> L72
            G.a r2 = new G.a     // Catch: java.lang.Throwable -> L72
            r5 = 8
            r2.<init>(r8, r5, r7)     // Catch: java.lang.Throwable -> L72
            r1.execute(r2)     // Catch: java.lang.Throwable -> L72
            goto L79
        L72:
            r8 = move-exception
            p010C0.AbstractC0147a.m295a(r8, r4)     // Catch: java.lang.Throwable -> L77
            goto L79
        L77:
            r7 = move-exception
            goto L94
        L79:
            boolean r8 = r7.f5985f     // Catch: java.lang.Throwable -> L77
            if (r8 != 0) goto L93
            boolean r8 = p117m0.C1718m.f6003f     // Catch: java.lang.Throwable -> L77
            if (r8 != 0) goto L93
            java.lang.String r7 = r7.f5987h     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = "fb_mobile_activate_app"
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Throwable -> L77
            if (r7 == 0) goto L8e
            p117m0.C1718m.f6003f = r0     // Catch: java.lang.Throwable -> L77
            goto L93
        L8e:
            java.util.HashMap r7 = p166z0.C2085w.f7377b     // Catch: java.lang.Throwable -> L77
            com.facebook.AbstractC1117n.m2896f()     // Catch: java.lang.Throwable -> L77
        L93:
            return
        L94:
            p010C0.AbstractC0147a.m295a(r7, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p117m0.C1718m.m3813f(m0.f, m0.b):void");
    }

    /* JADX INFO: renamed from: i */
    public static void m3814i() {
        if (AbstractC0147a.f354a.contains(C1718m.class)) {
            return;
        }
        try {
            HashMap map = C2085w.f7377b;
            AbstractC1117n.m2896f();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C1718m.class);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m3815d(Bundle bundle, String str) {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            m3816e(str, null, bundle, false, AbstractC1874d.m4193b());
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m3816e(String str, Double d, Bundle bundle, boolean z3, UUID uuid) {
        if (AbstractC0147a.f354a.contains(this) || str == null) {
            return;
        }
        try {
            if (str.isEmpty()) {
                return;
            }
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            if (AbstractC2078p.m4615b("app_events_killswitch", AbstractC1117n.f3877c, false)) {
                HashMap map = C2085w.f7377b;
                AbstractC1117n.m2896f();
                return;
            }
            try {
                try {
                    m3813f(new C1711f(this.f6004a, str, d, bundle, z3, AbstractC1874d.f6608i == 0, uuid), this.f6005b);
                } catch (C1111h e3) {
                    e3.toString();
                    HashMap map2 = C2085w.f7377b;
                    AbstractC1117n.m2896f();
                }
            } catch (JSONException e4) {
                e4.toString();
                HashMap map3 = C2085w.f7377b;
                AbstractC1117n.m2896f();
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m3817g(Bundle bundle, String str) {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            m3816e(str, null, bundle, true, AbstractC1874d.m4193b());
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m3818h(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(this)) {
            return;
        }
        try {
            if (bigDecimal == null) {
                m3814i();
                return;
            }
            if (currency == null) {
                m3814i();
                return;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            bundle2.putString("fb_currency", currency.getCurrencyCode());
            m3816e("fb_mobile_purchase", Double.valueOf(bigDecimal.doubleValue()), bundle2, true, AbstractC1874d.m4193b());
            if (set.contains(C1718m.class)) {
                return;
            }
            try {
                if (m3810a() != 2) {
                    AbstractC1715j.m3795d(6);
                }
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, C1718m.class);
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, this);
        }
    }

    public C1718m(String str, String str2) {
        AbstractC2069g.m4584h();
        this.f6004a = str;
        Date date = C1104a.f3820p;
        C1104a c1104a = (C1104a) C1107d.m2887a().f3849d;
        if (c1104a == null || new Date().after(c1104a.f3823e) || !(str2 == null || str2.equals(c1104a.f3830l))) {
            if (str2 == null) {
                AbstractC2069g.m4584h();
                Context context = AbstractC1117n.f3882h;
                AbstractC2069g.m4582f("context", context);
                synchronized (AbstractC1117n.class) {
                    AbstractC1117n.m2900j(context);
                }
                AbstractC2069g.m4584h();
                str2 = AbstractC1117n.f3877c;
            }
            this.f6005b = new C1707b(null, str2);
        } else {
            String str3 = c1104a.f3827i;
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            this.f6005b = new C1707b(str3, AbstractC1117n.f3877c);
        }
        m3812c();
    }
}
