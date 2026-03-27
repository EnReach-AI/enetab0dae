package p082b1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p074Z0.AbstractC0832r;
import p074Z0.AbstractC0833s;
import p114l1.C1659a;
import p114l1.C1670l;
import p114l1.C1674p;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: b1.B */
/* JADX INFO: loaded from: classes.dex */
public final class C1006B extends AbstractC1009E implements Serializable {

    /* JADX INFO: renamed from: e */
    public static final C1005A f3587e = C1005A.m2696g(C1670l.m3758M(String.class), null, new C1033d(String.class));

    /* JADX INFO: renamed from: f */
    public static final C1005A f3588f;

    /* JADX INFO: renamed from: g */
    public static final C1005A f3589g;

    /* JADX INFO: renamed from: h */
    public static final C1005A f3590h;

    /* JADX INFO: renamed from: i */
    public static final C1005A f3591i;
    private static final long serialVersionUID = 2;

    static {
        Class cls = Boolean.TYPE;
        f3588f = C1005A.m2696g(C1670l.m3758M(cls), null, new C1033d(cls));
        Class cls2 = Integer.TYPE;
        f3589g = C1005A.m2696g(C1670l.m3758M(cls2), null, new C1033d(cls2));
        Class cls3 = Long.TYPE;
        f3590h = C1005A.m2696g(C1670l.m3758M(cls3), null, new C1033d(cls3));
        f3591i = C1005A.m2696g(C1670l.m3758M(Object.class), null, new C1033d(Object.class));
    }

    /* JADX INFO: renamed from: a */
    public static C1005A m2700a(AbstractC0832r abstractC0832r, AbstractC0721l abstractC0721l) {
        if (!abstractC0721l.mo1887v() || (abstractC0721l instanceof C1659a)) {
            return null;
        }
        Class cls = abstractC0721l.f2036e;
        if (!AbstractC1745j.m3898u(cls)) {
            return null;
        }
        if (Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls)) {
            return C1005A.m2696g(abstractC0721l, abstractC0832r, m2702c(abstractC0832r, abstractC0721l, abstractC0832r));
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public static C1005A m2701b(AbstractC0832r abstractC0832r, AbstractC0721l abstractC0721l) {
        Class cls = abstractC0721l.f2036e;
        boolean zIsPrimitive = cls.isPrimitive();
        C1005A c1005a = f3588f;
        C1005A c1005a2 = f3590h;
        C1005A c1005a3 = f3589g;
        if (zIsPrimitive) {
            if (cls == Integer.TYPE) {
                return c1005a3;
            }
            if (cls == Long.TYPE) {
                return c1005a2;
            }
            if (cls == Boolean.TYPE) {
                return c1005a;
            }
            return null;
        }
        if (!AbstractC1745j.m3898u(cls)) {
            if (AbstractC0725p.class.isAssignableFrom(cls)) {
                return C1005A.m2696g(abstractC0721l, abstractC0832r, new C1033d(cls));
            }
            return null;
        }
        if (cls == Object.class) {
            return f3591i;
        }
        if (cls == String.class) {
            return f3587e;
        }
        if (cls == Integer.class) {
            return c1005a3;
        }
        if (cls == Long.class) {
            return c1005a2;
        }
        if (cls == Boolean.class) {
            return c1005a;
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public static C1033d m2702c(AbstractC0832r abstractC0832r, AbstractC0721l abstractC0721l, InterfaceC1008D interfaceC1008D) {
        abstractC0721l.getClass();
        boolean z3 = abstractC0721l instanceof C1659a;
        Class cls = abstractC0721l.f2036e;
        if (z3 && (abstractC0832r == null || ((AbstractC0833s) abstractC0832r).f2484g.mo2158a(cls) == null)) {
            return new C1033d(cls);
        }
        C1034e c1034e = new C1034e(abstractC0832r, abstractC0721l, interfaceC1008D);
        ArrayList arrayList = new ArrayList(8);
        if (!abstractC0721l.m1883r(Object.class)) {
            if (cls.isInterface()) {
                C1034e.m2779d(abstractC0721l, arrayList, false);
            } else {
                C1034e.m2780e(abstractC0721l, arrayList, false);
            }
        }
        InterfaceC1737b interfaceC1737bM2786g = c1034e.m2786g(arrayList);
        C1675q c1675q = abstractC0832r.f2481f.f2419e;
        return new C1033d(abstractC0721l, (Class) c1034e.f3683e, arrayList, (Class) c1034e.f3684f, interfaceC1737bM2786g, (C1674p) c1034e.f3682d, c1034e.f3679a, interfaceC1008D, c1675q, c1034e.f3680b);
    }

    /* JADX INFO: renamed from: d */
    public static C1019O m2703d(AbstractC0832r abstractC0832r, AbstractC0721l abstractC0721l, InterfaceC1008D interfaceC1008D, boolean z3) {
        C1013I c1013i;
        C1033d c1033dM2702c = m2702c(abstractC0832r, abstractC0721l, interfaceC1008D);
        if (AbstractC1745j.m3901x(abstractC0721l.f2036e)) {
            ((C1011G) abstractC0832r.f2481f.f2423i).getClass();
            c1013i = new C1012H(abstractC0832r, c1033dM2702c);
        } else {
            ((C1011G) abstractC0832r.f2481f.f2423i).getClass();
            c1013i = new C1013I(abstractC0832r, "set");
        }
        return new C1019O(abstractC0832r, z3, abstractC0721l, c1033dM2702c, c1013i);
    }
}
