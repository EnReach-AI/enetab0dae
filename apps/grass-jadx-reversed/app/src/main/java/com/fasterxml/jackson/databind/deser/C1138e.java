package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.deser.impl.C1146D;
import com.fasterxml.jackson.databind.deser.impl.C1148F;
import com.fasterxml.jackson.databind.deser.impl.C1154f;
import com.fasterxml.jackson.databind.deser.impl.C1163o;
import com.fasterxml.jackson.databind.deser.impl.C1167s;
import com.fasterxml.jackson.databind.deser.impl.C1172x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import p005B.AbstractC0032g;
import p039M0.AbstractC0485d0;
import p039M0.AbstractC0489f0;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0703E;
import p069X0.C0710a;
import p069X0.C0717h;
import p069X0.EnumC0731v;
import p074Z0.C0829o;
import p078a1.C0850b;
import p082b1.AbstractC1007C;
import p082b1.AbstractC1041l;
import p082b1.C1005A;
import p082b1.C1018N;
import p082b1.C1019O;
import p082b1.C1033d;
import p082b1.C1039j;
import p082b1.C1043n;
import p100g1.AbstractC1398g;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1138e extends AbstractC1135b {

    /* JADX INFO: renamed from: f */
    public static final Class[] f3944f = {Throwable.class};

    /* JADX INFO: renamed from: g */
    public static final C1138e f3945g = new C1138e(new C0829o(null, null, null, null, null));
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: t */
    public static void m2954t(C1005A c1005a, C1137d c1137d) {
        Map mapEmptyMap;
        C1019O c1019o = c1005a.f3579b;
        if (c1019o != null) {
            if (!c1019o.f3624j) {
                c1019o.m2746h();
            }
            mapEmptyMap = c1019o.f3634t;
        } else {
            mapEmptyMap = Collections.emptyMap();
        }
        if (mapEmptyMap != null) {
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                AbstractC1041l abstractC1041l = (AbstractC1041l) entry.getValue();
                C0703E c0703eM1686a = C0703E.m1686a(abstractC1041l.mo2767d());
                AbstractC0721l abstractC0721lMo2769f = abstractC1041l.mo2769f();
                InterfaceC1737b interfaceC1737b = c1005a.f3582e.f3674n;
                Object key = entry.getKey();
                if (c1137d.f3935e == null) {
                    c1137d.f3935e = new ArrayList();
                }
                C0717h c0717h = c1137d.f3931a;
                c0717h.getClass();
                if (c0717h.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                    try {
                        abstractC1041l.m2799h(c0717h.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    } catch (IllegalArgumentException e3) {
                        c1137d.m2950c(e3);
                        throw null;
                    }
                }
                c1137d.f3935e.add(new C1148F(c0703eM1686a, abstractC0721lMo2769f, abstractC1041l, key));
            }
        }
    }

    /* JADX INFO: renamed from: u */
    public static void m2955u(AbstractC0718i abstractC0718i, C1005A c1005a, C1137d c1137d) {
        AbstractC0721l abstractC0721l;
        AbstractC0485d0 abstractC0485d0M1813h;
        AbstractC1204t abstractC1204t;
        C1018N c1018n = c1005a.f3586i;
        if (c1018n == null) {
            return;
        }
        abstractC0718i.m1814i(c1018n);
        Class cls = c1018n.f3611b;
        if (cls == AbstractC0489f0.class) {
            LinkedHashMap linkedHashMap = c1137d.f3934d;
            C0703E c0703e = c1018n.f3610a;
            abstractC1204t = (AbstractC1204t) linkedHashMap.get(c0703e.f1928e);
            if (abstractC1204t == null) {
                throw new IllegalArgumentException(AbstractC0032g.m155m("Invalid Object Id definition for ", AbstractC1745j.m3895r(c1005a.f1980a), ": cannot find property with name ", AbstractC1745j.m3880c(c0703e.f1928e)));
            }
            abstractC0485d0M1813h = new C1172x(c1018n.f3613d);
            abstractC0721l = abstractC1204t.f4103h;
        } else {
            AbstractC0721l abstractC0721lM1848m = abstractC0718i.m1848m(cls);
            abstractC0718i.mo1711f().getClass();
            abstractC0721l = C1675q.m3771l(abstractC0721lM1848m, AbstractC0485d0.class)[0];
            abstractC0485d0M1813h = abstractC0718i.m1813h(c1018n);
            abstractC1204t = null;
        }
        AbstractC0485d0 abstractC0485d0 = abstractC0485d0M1813h;
        AbstractC1204t abstractC1204t2 = abstractC1204t;
        AbstractC0721l abstractC0721l2 = abstractC0721l;
        c1137d.f3940j = new C1167s(abstractC0721l2, c1018n.f3610a, abstractC0485d0, abstractC0718i.m1856u(abstractC0721l2), abstractC1204t2);
    }

    /* JADX INFO: renamed from: r */
    public final void m2956r(AbstractC0718i abstractC0718i, C1005A c1005a, C1137d c1137d) throws C0850b {
        ArrayList<AbstractC1007C> arrayList = null;
        HashSet hashSet = null;
        for (AbstractC1007C abstractC1007C : c1005a.m2698f()) {
            C0710a c0710aMo2712k = abstractC1007C.mo2712k();
            if (c0710aMo2712k != null && c0710aMo2712k.f1978a == 2) {
                String str = c0710aMo2712k.f1979b;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashSet = new HashSet();
                    hashSet.add(str);
                } else if (!hashSet.add(str)) {
                    throw new IllegalArgumentException("Multiple back-reference properties with name " + AbstractC1745j.m3902y(str));
                }
                arrayList.add(abstractC1007C);
            }
        }
        if (arrayList != null) {
            for (AbstractC1007C abstractC1007C2 : arrayList) {
                C0710a c0710aMo2712k2 = abstractC1007C2.mo2712k();
                String str2 = c0710aMo2712k2 == null ? null : c0710aMo2712k2.f1979b;
                AbstractC1204t abstractC1204tM2958v = m2958v(abstractC0718i, c1005a, abstractC1007C2, abstractC1007C2.mo2719r());
                if (c1137d.f3936f == null) {
                    c1137d.f3936f = new HashMap(4);
                }
                C0717h c0717h = c1137d.f3931a;
                c0717h.getClass();
                if (c0717h.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                    try {
                        abstractC1204tM2958v.mo2969n(c0717h);
                    } catch (IllegalArgumentException e3) {
                        c1137d.m2950c(e3);
                        throw null;
                    }
                }
                c1137d.f3936f.put(str2, abstractC1204tM2958v);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0147  */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r19v2, types: [b1.l] */
    /* JADX WARN: Type inference failed for: r19v3, types: [b1.l] */
    /* JADX WARN: Type inference failed for: r21v0, types: [b1.l] */
    /* JADX WARN: Type inference failed for: r21v1, types: [b1.l] */
    /* JADX WARN: Type inference failed for: r21v5, types: [b1.l] */
    /* JADX WARN: Type inference failed for: r32v0, types: [com.fasterxml.jackson.databind.deser.b, com.fasterxml.jackson.databind.deser.e] */
    /* JADX WARN: Type inference failed for: r33v0, types: [X0.i] */
    /* JADX WARN: Type inference failed for: r35v0, types: [com.fasterxml.jackson.databind.deser.d] */
    /* JADX WARN: Type inference failed for: r5v42, types: [X0.b] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [b1.b, b1.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX INFO: renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2957s(p069X0.AbstractC0718i r33, p082b1.C1005A r34, com.fasterxml.jackson.databind.deser.C1137d r35) throws p078a1.C0850b {
        /*
            Method dump skipped, instruction units count: 1182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.C1138e.m2957s(X0.i, b1.A, com.fasterxml.jackson.databind.deser.d):void");
    }

    /* JADX INFO: renamed from: v */
    public final AbstractC1204t m2958v(AbstractC0718i abstractC0718i, C1005A c1005a, AbstractC1007C abstractC1007C, AbstractC0721l abstractC0721l) throws C0850b {
        AbstractC1041l abstractC1041lMo2721t = abstractC1007C.mo2721t();
        if (abstractC1041lMo2721t == null) {
            abstractC1041lMo2721t = abstractC1007C.mo2717p();
        }
        if (abstractC1041lMo2721t == null) {
            abstractC0718i.m1838P(c1005a, abstractC1007C, "No non-constructor mutator available", new Object[0]);
            throw null;
        }
        AbstractC0721l abstractC0721lM2947q = m2947q(abstractC0718i, abstractC1041lMo2721t, abstractC0721l);
        AbstractC1398g abstractC1398g = (AbstractC1398g) abstractC0721lM2947q.f2039h;
        boolean z3 = abstractC1041lMo2721t instanceof C1043n;
        C1033d c1033d = c1005a.f3582e;
        AbstractC1204t c1163o = z3 ? new C1163o(abstractC1007C, abstractC0721lM2947q, abstractC1398g, c1033d.f3674n, (C1043n) abstractC1041lMo2721t) : new C1154f(abstractC1007C, abstractC0721lM2947q, abstractC1398g, c1033d.f3674n, (C1039j) abstractC1041lMo2721t);
        AbstractC0722m abstractC0722mM2935n = AbstractC1135b.m2935n(abstractC0718i, abstractC1041lMo2721t);
        if (abstractC0722mM2935n == null) {
            abstractC0722mM2935n = (AbstractC0722m) abstractC0721lM2947q.f2038g;
        }
        if (abstractC0722mM2935n != null) {
            c1163o = c1163o.mo2965H(abstractC0718i.m1861z(abstractC0722mM2935n, c1163o, abstractC0721lM2947q));
        }
        C0710a c0710aMo2712k = abstractC1007C.mo2712k();
        if (c0710aMo2712k != null && c0710aMo2712k.f1978a == 1) {
            c1163o.f4107l = c0710aMo2712k.f1979b;
        }
        C1018N c1018nMo2711j = abstractC1007C.mo2711j();
        if (c1018nMo2711j != null) {
            c1163o.f4108m = c1018nMo2711j;
        }
        return c1163o;
    }

    /* JADX INFO: renamed from: w */
    public final C1146D m2959w(AbstractC0718i abstractC0718i, C1005A c1005a, AbstractC1007C abstractC1007C) {
        C1043n c1043nMo2718q = abstractC1007C.mo2718q();
        AbstractC0721l abstractC0721lM2947q = m2947q(abstractC0718i, c1043nMo2718q, c1043nMo2718q.mo2769f());
        AbstractC1204t c1146d = new C1146D(abstractC1007C, abstractC0721lM2947q, (AbstractC1398g) abstractC0721lM2947q.f2039h, c1005a.f3582e.f3674n, c1043nMo2718q);
        AbstractC0722m abstractC0722mM2935n = AbstractC1135b.m2935n(abstractC0718i, c1043nMo2718q);
        if (abstractC0722mM2935n == null) {
            abstractC0722mM2935n = (AbstractC0722m) abstractC0721lM2947q.f2038g;
        }
        if (abstractC0722mM2935n != null) {
            c1146d = c1146d.mo2965H(abstractC0718i.m1861z(abstractC0722mM2935n, c1146d, abstractC0721lM2947q));
        }
        return (C1146D) c1146d;
    }
}
