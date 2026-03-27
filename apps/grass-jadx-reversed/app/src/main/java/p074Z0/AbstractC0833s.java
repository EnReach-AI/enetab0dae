package p074Z0;

import java.util.Map;
import p039M0.C0500o;
import p039M0.C0502q;
import p039M0.C0508w;
import p039M0.EnumC0490g;
import p069X0.AbstractC0711b;
import p069X0.C0703E;
import p069X0.EnumC0731v;
import p082b1.C1026W;
import p082b1.C1029Z;
import p082b1.C1033d;
import p100g1.AbstractC1397f;
import p103h1.C1425m;
import p118m1.AbstractC1745j;
import p118m1.C1761z;

/* JADX INFO: renamed from: Z0.s */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0833s extends AbstractC0832r {

    /* JADX INFO: renamed from: o */
    public static final long f2482o;

    /* JADX INFO: renamed from: p */
    public static final long f2483p;

    /* JADX INFO: renamed from: g */
    public final C1026W f2484g;

    /* JADX INFO: renamed from: h */
    public final AbstractC1397f f2485h;

    /* JADX INFO: renamed from: i */
    public final C0703E f2486i;

    /* JADX INFO: renamed from: j */
    public final Class f2487j;

    /* JADX INFO: renamed from: k */
    public final AbstractC0825k f2488k;

    /* JADX INFO: renamed from: l */
    public final C1761z f2489l;

    /* JADX INFO: renamed from: m */
    public final C0822h f2490m;

    /* JADX INFO: renamed from: n */
    public final C0828n f2491n;

    static {
        long j2 = 0;
        for (EnumC0731v enumC0731v : EnumC0731v.values()) {
            if (enumC0731v.f2082e) {
                j2 |= enumC0731v.f2083f;
            }
        }
        f2482o = j2;
        f2483p = EnumC0731v.AUTO_DETECT_FIELDS.f2083f | EnumC0731v.AUTO_DETECT_GETTERS.f2083f | EnumC0731v.AUTO_DETECT_IS_GETTERS.f2083f | EnumC0731v.AUTO_DETECT_SETTERS.f2083f | EnumC0731v.AUTO_DETECT_CREATORS.f2083f;
    }

    public AbstractC0833s(C0815a c0815a, C1425m c1425m, C1026W c1026w, C1761z c1761z, C0822h c0822h, C0828n c0828n) {
        super(c0815a, f2482o);
        this.f2484g = c1026w;
        this.f2485h = c1425m;
        this.f2489l = c1761z;
        this.f2486i = null;
        this.f2487j = null;
        this.f2488k = C0824j.f2454g;
        this.f2490m = c0822h;
        this.f2491n = c0828n;
    }

    @Override // p082b1.InterfaceC1008D
    /* JADX INFO: renamed from: a */
    public final Class mo2158a(Class cls) {
        return this.f2484g.mo2158a(cls);
    }

    @Override // p074Z0.AbstractC0832r
    /* JADX INFO: renamed from: e */
    public final C0821g mo2150e(Class cls) {
        Map map = this.f2490m.f2447e;
        C0821g c0821g = map == null ? null : (C0821g) map.get(cls);
        return c0821g == null ? C0821g.f2446a : c0821g;
    }

    @Override // p074Z0.AbstractC0832r
    /* JADX INFO: renamed from: f */
    public final C0502q mo2151f(Class cls) {
        C0822h c0822h = this.f2490m;
        Map map = c0822h.f2447e;
        if (map != null) {
        }
        Boolean bool = c0822h.f2452j;
        return bool == null ? C0502q.f1168l : new C0502q("", null, null, null, null, C0500o.f1154c, bool);
    }

    @Override // p074Z0.AbstractC0832r
    /* JADX INFO: renamed from: g */
    public final C1029Z mo2152g(Class cls, C1033d c1033d) {
        C1029Z c1029z;
        boolean zM3898u = AbstractC1745j.m3898u(cls);
        C0822h c0822h = this.f2490m;
        if (zM3898u) {
            c1029z = C1029Z.f3656k;
        } else {
            c1029z = c0822h.f2450h;
            long j2 = this.f2480e;
            long j3 = f2483p;
            if ((j2 & j3) != j3) {
                boolean zM2157l = m2157l(EnumC0731v.AUTO_DETECT_FIELDS);
                EnumC0490g enumC0490g = EnumC0490g.f1134g;
                if (!zM2157l) {
                    c1029z.getClass();
                    if (c1029z.f3661i != enumC0490g) {
                        c1029z = new C1029Z(c1029z.f3657e, c1029z.f3658f, c1029z.f3659g, c1029z.f3660h, enumC0490g);
                    }
                }
                if (!m2157l(EnumC0731v.AUTO_DETECT_GETTERS)) {
                    c1029z.getClass();
                    if (c1029z.f3657e != enumC0490g) {
                        c1029z = new C1029Z(enumC0490g, c1029z.f3658f, c1029z.f3659g, c1029z.f3660h, c1029z.f3661i);
                    }
                }
                if (!m2157l(EnumC0731v.AUTO_DETECT_IS_GETTERS)) {
                    c1029z.getClass();
                    if (c1029z.f3658f != enumC0490g) {
                        c1029z = new C1029Z(c1029z.f3657e, enumC0490g, c1029z.f3659g, c1029z.f3660h, c1029z.f3661i);
                    }
                }
                if (!m2157l(EnumC0731v.AUTO_DETECT_SETTERS)) {
                    c1029z.getClass();
                    if (c1029z.f3659g != enumC0490g) {
                        c1029z = new C1029Z(c1029z.f3657e, c1029z.f3658f, enumC0490g, c1029z.f3660h, c1029z.f3661i);
                    }
                }
                if (!m2157l(EnumC0731v.AUTO_DETECT_CREATORS)) {
                    c1029z.getClass();
                    if (c1029z.f3660h != enumC0490g) {
                        c1029z = new C1029Z(c1029z.f3657e, c1029z.f3658f, c1029z.f3659g, enumC0490g, c1029z.f3661i);
                    }
                }
            }
        }
        AbstractC0711b abstractC0711bM2149d = m2149d();
        if (abstractC0711bM2149d != null) {
            c1029z = abstractC0711bM2149d.mo1757b(c1033d, c1029z);
        }
        Map map = c0822h.f2447e;
        if ((map == null ? null : (C0821g) map.get(cls)) != null) {
            c1029z.getClass();
        }
        return c1029z;
    }

    /* JADX INFO: renamed from: n */
    public final C0508w m2159n(Class cls, C1033d c1033d) {
        AbstractC0711b abstractC0711bM2149d = m2149d();
        C0508w c0508wMo1737I = abstractC0711bM2149d == null ? null : abstractC0711bM2149d.mo1737I(c1033d);
        Map map = this.f2490m.f2447e;
        if (map != null) {
        }
        C0508w c0508w = C0508w.f1176j;
        if (c0508wMo1737I == null) {
            return null;
        }
        return c0508wMo1737I;
    }

    public AbstractC0833s(AbstractC0833s abstractC0833s, long j2) {
        super(abstractC0833s, j2);
        this.f2484g = abstractC0833s.f2484g;
        this.f2485h = abstractC0833s.f2485h;
        this.f2489l = abstractC0833s.f2489l;
        this.f2486i = abstractC0833s.f2486i;
        this.f2487j = abstractC0833s.f2487j;
        this.f2488k = abstractC0833s.f2488k;
        this.f2490m = abstractC0833s.f2490m;
        this.f2491n = abstractC0833s.f2491n;
    }
}
