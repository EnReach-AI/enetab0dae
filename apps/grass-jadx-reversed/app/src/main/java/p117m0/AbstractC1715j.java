package p117m0;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AbstractC1117n;
import com.facebook.C1125v;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import p010C0.AbstractC0147a;
import p015D2.C0192p;
import p019F0.RunnableC0218b;
import p036L0.C0444d;
import p068X.C0698c;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;
import p166z0.C2079q;
import p166z0.C2085w;

/* JADX INFO: renamed from: m0.j */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1715j {

    /* JADX INFO: renamed from: c */
    public static ScheduledFuture f5998c;

    /* JADX INFO: renamed from: a */
    public static volatile C0444d f5996a = new C0444d(21);

    /* JADX INFO: renamed from: b */
    public static final ScheduledExecutorService f5997b = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: d */
    public static final RunnableC0218b f5999d = new RunnableC0218b(3);

    /* JADX INFO: renamed from: a */
    public static C0444d m3792a() {
        if (AbstractC0147a.f354a.contains(AbstractC1715j.class)) {
            return null;
        }
        try {
            return f5996a;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1715j.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static C1125v m3793b(C1707b c1707b, C1724s c1724s, boolean z3, C0192p c0192p) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1715j.class)) {
            return null;
        }
        try {
            String str = c1707b.f5975f;
            C2079q c2079qM4625f = AbstractC2082t.m4625f(str, false);
            C1125v c1125vM2913l = C1125v.m2913l(null, str + "/activities", null, null);
            Bundle bundle = c1125vM2913l.f3907e;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("access_token", c1707b.f5974e);
            if (!set.contains(C1718m.class)) {
                try {
                    synchronized (C1718m.f6001d) {
                    }
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, C1718m.class);
                }
            }
            String strM3811b = C1718m.m3811b();
            if (strM3811b != null) {
                bundle.putString("install_referrer", strM3811b);
            }
            c1125vM2913l.f3907e = bundle;
            boolean z4 = c2079qM4625f != null ? c2079qM4625f.f7350a : false;
            AbstractC2069g.m4584h();
            int iM3827d = c1724s.m3827d(c1125vM2913l, AbstractC1117n.f3882h, z4, z3);
            if (iM3827d == 0) {
                return null;
            }
            c0192p.f443f += iM3827d;
            c1125vM2913l.m2927s(new C1714i(c1707b, c1125vM2913l, c1724s, c0192p));
            return c1125vM2913l;
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1715j.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static ArrayList m3794c(C0444d c0444d, C0192p c0192p) {
        Set<C1707b> setKeySet;
        C1724s c1724s;
        if (AbstractC0147a.f354a.contains(AbstractC1715j.class)) {
            return null;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            Context context = AbstractC1117n.f3882h;
            AbstractC2069g.m4584h();
            boolean z3 = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
            ArrayList arrayList = new ArrayList();
            synchronized (c0444d) {
                setKeySet = ((HashMap) c0444d.f1085e).keySet();
            }
            for (C1707b c1707b : setKeySet) {
                synchronized (c0444d) {
                    c1724s = (C1724s) ((HashMap) c0444d.f1085e).get(c1707b);
                }
                C1125v c1125vM3793b = m3793b(c1707b, c1724s, z3, c0192p);
                if (c1125vM3793b != null) {
                    arrayList.add(c1125vM3793b);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1715j.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m3795d(int i3) {
        if (AbstractC0147a.f354a.contains(AbstractC1715j.class)) {
            return;
        }
        try {
            f5997b.execute(new RunnableC1712g(i3));
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1715j.class);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m3796e(int i3) {
        if (AbstractC0147a.f354a.contains(AbstractC1715j.class)) {
            return;
        }
        try {
            f5996a.m982o(AbstractC1717l.m3808k());
            try {
                C0192p c0192pM3797f = m3797f(i3, f5996a);
                if (c0192pM3797f != null) {
                    Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                    intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", c0192pM3797f.f443f);
                    intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", (EnumC1721p) c0192pM3797f.f444g);
                    HashSet hashSet = AbstractC1117n.f3875a;
                    AbstractC2069g.m4584h();
                    C0698c.m1678a(AbstractC1117n.f3882h).m1680c(intent);
                }
            } catch (Exception e3) {
                Log.w("m0.j", "Caught unexpected exception while flushing app events: ", e3);
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1715j.class);
        }
    }

    /* JADX INFO: renamed from: f */
    public static C0192p m3797f(int i3, C0444d c0444d) {
        if (AbstractC0147a.f354a.contains(AbstractC1715j.class)) {
            return null;
        }
        try {
            C0192p c0192p = new C0192p(4);
            c0192p.f443f = 0;
            c0192p.f444g = EnumC1721p.f6006e;
            ArrayList arrayListM3794c = m3794c(c0444d, c0192p);
            if (arrayListM3794c.size() <= 0) {
                return null;
            }
            switch (i3) {
                case 1:
                case 2:
                case FromStringDeserializer.Std.STD_URI /* 3 */:
                case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    HashMap map = C2085w.f7377b;
                    AbstractC1117n.m2896f();
                    Iterator it = arrayListM3794c.iterator();
                    while (it.hasNext()) {
                        ((C1125v) it.next()).m2923d();
                    }
                    return c0192p;
                default:
                    throw null;
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1715j.class);
            return null;
        }
    }
}
