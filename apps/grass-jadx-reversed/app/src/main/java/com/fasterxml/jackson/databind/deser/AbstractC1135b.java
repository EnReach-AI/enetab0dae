package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.deser.impl.C1150b;
import com.fasterxml.jackson.databind.deser.impl.C1151c;
import java.io.Closeable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import p005B.AbstractC0032g;
import p033K0.AbstractC0406d;
import p039M0.C0466N;
import p039M0.C0480b;
import p039M0.EnumC0481b0;
import p039M0.EnumC0495j;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0712c;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0730u;
import p069X0.C0702D;
import p069X0.C0703E;
import p069X0.C0717h;
import p069X0.EnumC0731v;
import p074Z0.C0829o;
import p078a1.C0850b;
import p082b1.AbstractC1007C;
import p082b1.AbstractC1031b;
import p082b1.AbstractC1041l;
import p082b1.AbstractC1048s;
import p082b1.C1005A;
import p082b1.C1025V;
import p082b1.C1033d;
import p082b1.C1047r;
import p100g1.AbstractC1398g;
import p103h1.AbstractC1428p;
import p103h1.C1426n;
import p106i1.C1448a;
import p114l1.AbstractC1665g;
import p114l1.C1660b;
import p114l1.C1666h;
import p118m1.AbstractC1745j;
import p118m1.C1740e;
import p118m1.C1749n;
import p166z0.C2071i;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1135b extends AbstractC1176k implements Serializable {

    /* JADX INFO: renamed from: e */
    public final C0829o f3929e;

    static {
        new C0703E("@JsonUnwrapped", null);
    }

    public AbstractC1135b(C0829o c0829o) {
        this.f3929e = c0829o;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m2931g(AbstractC0712c abstractC0712c, AbstractC0711b abstractC0711b, AbstractC1048s abstractC1048s, AbstractC1007C abstractC1007C) {
        if (abstractC1007C != null && abstractC1007C.mo2704A()) {
            return true;
        }
        if (abstractC0712c.mo1801c() != null) {
            return false;
        }
        if (abstractC0711b.mo1787q(abstractC1048s.m2805r(0)) != null) {
            return true;
        }
        if (abstractC1007C != null) {
            String strMo1808f = abstractC1007C.mo1808f();
            if (strMo1808f != null && !strMo1808f.isEmpty() && abstractC1007C.mo2709h()) {
                return true;
            }
            if (!abstractC1007C.mo2704A() && AbstractC1745j.m3901x(abstractC0712c.f1980a.f2036e)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: j */
    public static void m2932j(C1151c c1151c, AbstractC1048s abstractC1048s, boolean z3, boolean z4) {
        Class clsMo2792u = abstractC1048s.mo2792u(0);
        if (clsMo2792u == String.class || clsMo2792u == CharSequence.class) {
            if (z3 || z4) {
                c1151c.m2997d(abstractC1048s, 1, z3);
                return;
            }
            return;
        }
        if (clsMo2792u == Integer.TYPE || clsMo2792u == Integer.class) {
            if (z3 || z4) {
                c1151c.m2997d(abstractC1048s, 2, z3);
                return;
            }
            return;
        }
        if (clsMo2792u == Long.TYPE || clsMo2792u == Long.class) {
            if (z3 || z4) {
                c1151c.m2997d(abstractC1048s, 3, z3);
                return;
            }
            return;
        }
        if (clsMo2792u == Double.TYPE || clsMo2792u == Double.class) {
            if (z3 || z4) {
                c1151c.m2997d(abstractC1048s, 5, z3);
                return;
            }
            return;
        }
        if (clsMo2792u == Boolean.TYPE || clsMo2792u == Boolean.class) {
            if (z3 || z4) {
                c1151c.m2997d(abstractC1048s, 7, z3);
                return;
            }
            return;
        }
        if (clsMo2792u == BigInteger.class && (z3 || z4)) {
            c1151c.m2997d(abstractC1048s, 4, z3);
        }
        if (clsMo2792u == BigDecimal.class && (z3 || z4)) {
            c1151c.m2997d(abstractC1048s, 6, z3);
        }
        if (z3) {
            c1151c.m2995b(abstractC1048s, z3, null, 0);
        }
    }

    /* JADX INFO: renamed from: k */
    public static boolean m2933k(AbstractC0718i abstractC0718i, AbstractC1031b abstractC1031b) {
        EnumC0495j enumC0495jMo1763e;
        AbstractC0711b abstractC0711bM2149d = abstractC0718i.f1998g.m2149d();
        return (abstractC0711bM2149d == null || (enumC0495jMo1763e = abstractC0711bM2149d.mo1763e(abstractC0718i.f1998g, abstractC1031b)) == null || enumC0495jMo1763e == EnumC0495j.f1145h) ? false : true;
    }

    /* JADX INFO: renamed from: m */
    public static C1749n m2934m(Class cls, C0717h c0717h, C1005A c1005a) {
        AbstractC1041l abstractC1041lMo1801c = c1005a.mo1801c();
        if (abstractC1041lMo1801c == null) {
            AbstractC0711b abstractC0711bM2149d = c0717h.m2149d();
            boolean zM2157l = c0717h.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_ENUMS);
            Enum[] enumArrM3905a = C1749n.m3905a(cls);
            String[] strArrMo1779m = abstractC0711bM2149d.mo1779m(cls, enumArrM3905a, new String[enumArrM3905a.length]);
            String[][] strArr = new String[strArrMo1779m.length][];
            abstractC0711bM2149d.mo1775k(cls, enumArrM3905a, strArr);
            HashMap map = new HashMap();
            int length = enumArrM3905a.length;
            for (int i3 = 0; i3 < length; i3++) {
                Enum r6 = enumArrM3905a[i3];
                String strName = strArrMo1779m[i3];
                if (strName == null) {
                    strName = r6.name();
                }
                map.put(strName, r6);
                String[] strArr2 = strArr[i3];
                if (strArr2 != null) {
                    for (String str : strArr2) {
                        map.putIfAbsent(str, r6);
                    }
                }
            }
            return new C1749n(cls, enumArrM3905a, map, abstractC0711bM2149d.mo1767g(cls), zM2157l, false);
        }
        c0717h.getClass();
        if (c0717h.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            AbstractC1745j.m3882e(abstractC1041lMo1801c.mo2771k(), c0717h.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        AbstractC0711b abstractC0711bM2149d2 = c0717h.m2149d();
        boolean zM2157l2 = c0717h.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Enum[] enumArrM3905a2 = C1749n.m3905a(cls);
        HashMap map2 = new HashMap();
        int length2 = enumArrM3905a2.length;
        while (true) {
            length2--;
            if (length2 < 0) {
                break;
            }
            Enum r22 = enumArrM3905a2[length2];
            try {
                Object objMo2772l = abstractC1041lMo1801c.mo2772l(r22);
                if (objMo2772l != null) {
                    map2.put(objMo2772l.toString(), r22);
                }
            } catch (Exception e3) {
                throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + r22 + ": " + e3.getMessage());
            }
        }
        Enum enumMo1767g = abstractC0711bM2149d2 != null ? abstractC0711bM2149d2.mo1767g(cls) : null;
        Class clsMo2768e = abstractC1041lMo1801c.mo2768e();
        if (clsMo2768e.isPrimitive()) {
            clsMo2768e = AbstractC1745j.m3877G(clsMo2768e);
        }
        return new C1749n(cls, enumArrM3905a2, map2, enumMo1767g, zM2157l2, clsMo2768e == Long.class || clsMo2768e == Integer.class || clsMo2768e == Short.class || clsMo2768e == Byte.class);
    }

    /* JADX INFO: renamed from: n */
    public static AbstractC0722m m2935n(AbstractC0718i abstractC0718i, AbstractC1031b abstractC1031b) {
        Object objMo1773j;
        AbstractC0711b abstractC0711bM2149d = abstractC0718i.f1998g.m2149d();
        if (abstractC0711bM2149d == null || (objMo1773j = abstractC0711bM2149d.mo1773j(abstractC1031b)) == null) {
            return null;
        }
        return abstractC0718i.mo1849n(objMo1773j);
    }

    /* JADX INFO: renamed from: o */
    public static AbstractC0730u m2936o(AbstractC0718i abstractC0718i, AbstractC1031b abstractC1031b) {
        Object objMo1791s;
        AbstractC0711b abstractC0711bM2149d = abstractC0718i.f1998g.m2149d();
        if (abstractC0711bM2149d == null || (objMo1791s = abstractC0711bM2149d.mo1791s(abstractC1031b)) == null) {
            return null;
        }
        return abstractC0718i.mo1834L(objMo1791s);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0193  */
    @Override // com.fasterxml.jackson.databind.deser.AbstractC1176k
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p069X0.AbstractC0722m mo2937a(p069X0.AbstractC0718i r17, p114l1.C1662d r18, p082b1.C1005A r19) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.AbstractC1135b.mo2937a(X0.i, l1.d, b1.A):X0.m");
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1176k
    /* JADX INFO: renamed from: b */
    public final AbstractC1428p mo2938b(C0717h c0717h, AbstractC0721l abstractC0721l) {
        C1005A c1005aM2156k = c0717h.m2156k(abstractC0721l.f2036e);
        AbstractC0711b abstractC0711bM2149d = c0717h.m2149d();
        C1033d c1033d = c1005aM2156k.f3582e;
        C1426n c1426nMo1754Z = abstractC0711bM2149d.mo1754Z(abstractC0721l, c0717h, c1033d);
        if (c1426nMo1754Z == null && (c1426nMo1754Z = c0717h.f2481f.f2424j) == null) {
            return null;
        }
        ArrayList arrayListMo3397b = c0717h.f2485h.mo3397b(c0717h, c1033d);
        if (c1426nMo1754Z.f5056e == null && abstractC0721l.mo1884s()) {
            mo2939c(abstractC0721l);
            Class cls = abstractC0721l.f2036e;
            if (!abstractC0721l.m1883r(cls) && c1426nMo1754Z.f5056e != cls) {
                AbstractC1745j.m3876F(C1426n.class, c1426nMo1754Z, "withDefaultImpl");
                C1426n c1426n = new C1426n();
                c1426n.f5055d = false;
                c1426n.f5052a = c1426nMo1754Z.f5052a;
                c1426n.f5053b = c1426nMo1754Z.f5053b;
                c1426n.f5054c = c1426nMo1754Z.f5054c;
                c1426n.f5055d = c1426nMo1754Z.f5055d;
                c1426n.f5057f = c1426nMo1754Z.f5057f;
                c1426n.f5056e = cls;
                c1426nMo1754Z = c1426n;
            }
        }
        try {
            return c1426nMo1754Z.m3436a(c0717h, abstractC0721l, arrayListMo3397b);
        } catch (IllegalArgumentException | IllegalStateException e3) {
            C0850b c0850b = new C0850b((Closeable) null, AbstractC1745j.m3886i(e3));
            c0850b.initCause(e3);
            throw c0850b;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1176k
    /* JADX INFO: renamed from: c */
    public final AbstractC0721l mo2939c(AbstractC0721l abstractC0721l) {
        Class cls = abstractC0721l.f2036e;
        AbstractC0406d[] abstractC0406dArr = this.f3929e.f2469h;
        if (abstractC0406dArr.length > 0) {
            if (abstractC0406dArr.length > 0) {
                if (abstractC0406dArr.length <= 0) {
                    throw new NoSuchElementException();
                }
                AbstractC0032g.m162t(abstractC0406dArr[0]);
                throw null;
            }
        }
        return abstractC0721l;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006a A[PHI: r5
      0x006a: PHI (r5v9 X0.E) = (r5v5 X0.E), (r5v8 X0.E) binds: [B:33:0x0068, B:40:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2940d(p069X0.AbstractC0718i r15, p069X0.AbstractC0712c r16, com.fasterxml.jackson.databind.deser.impl.C1151c r17, com.fasterxml.jackson.databind.deser.impl.C1150b r18, p074Z0.C0823i r19) throws p078a1.C0850b {
        /*
            r14 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            r3 = 1
            int r4 = r1.f3979c
            z0.i[] r5 = r1.f3980d
            if (r3 == r4) goto L32
            r19.getClass()
            r6 = -1
            r7 = r6
        L11:
            if (r2 >= r4) goto L21
            r8 = r5[r2]
            java.lang.Object r8 = r8.f7316c
            M0.b r8 = (p039M0.C0480b) r8
            if (r8 != 0) goto L1f
            if (r7 < 0) goto L1e
            goto L22
        L1e:
            r7 = r2
        L1f:
            int r2 = r2 + r3
            goto L11
        L21:
            r6 = r7
        L22:
            if (r6 < 0) goto L2e
            X0.E r2 = r1.m2992c(r6)
            if (r2 != 0) goto L2e
            r14.m2941e(r15, r16, r17, r18)
            return
        L2e:
            r14.m2942f(r15, r16, r17, r18)
            return
        L32:
            r4 = r5[r2]
            java.lang.Object r6 = r4.f7314a
            r12 = r6
            b1.r r12 = (p082b1.C1047r) r12
            java.lang.Object r4 = r4.f7316c
            r13 = r4
            M0.b r13 = (p039M0.C0480b) r13
            r19.getClass()
            b1.C r4 = r1.m2993d(r2)
            r5 = r5[r2]
            java.lang.Object r5 = r5.f7315b
            b1.C r5 = (p082b1.AbstractC1007C) r5
            r6 = 0
            if (r5 == 0) goto L59
            boolean r7 = r5.mo2704A()
            if (r7 == 0) goto L59
            X0.E r5 = r5.mo2706a()
            goto L5a
        L59:
            r5 = r6
        L5a:
            if (r5 == 0) goto L5e
            r7 = r3
            goto L5f
        L5e:
            r7 = r2
        L5f:
            if (r7 != 0) goto L6b
            b1.l r8 = r16.mo1801c()
            if (r8 == 0) goto L68
            goto L6b
        L68:
            if (r13 == 0) goto L6d
        L6a:
            r7 = r3
        L6b:
            r10 = r5
            goto L7e
        L6d:
            if (r4 == 0) goto L6b
            X0.E r5 = r1.m2992c(r2)
            if (r5 == 0) goto L7c
            boolean r4 = r4.mo2709h()
            if (r4 == 0) goto L7c
            goto L6a
        L7c:
            r7 = r2
            goto L6b
        L7e:
            b1.s r4 = r1.f3978b
            if (r7 == 0) goto L93
            r11 = 0
            r7 = r14
            r8 = r15
            r9 = r16
            com.fasterxml.jackson.databind.deser.g r1 = r7.m2945l(r8, r9, r10, r11, r12, r13)
            com.fasterxml.jackson.databind.deser.t[] r5 = new com.fasterxml.jackson.databind.deser.AbstractC1204t[r3]
            r5[r2] = r1
            r0.m2996c(r4, r3, r5)
            return
        L93:
            m2932j(r0, r4, r3, r3)
            b1.C r0 = r1.m2993d(r2)
            if (r0 == 0) goto La0
            b1.V r0 = (p082b1.C1025V) r0
            r0.f3647l = r6
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.AbstractC1135b.m2940d(X0.i, X0.c, com.fasterxml.jackson.databind.deser.impl.c, com.fasterxml.jackson.databind.deser.impl.b, Z0.i):void");
    }

    /* JADX INFO: renamed from: e */
    public final void m2941e(AbstractC0718i abstractC0718i, AbstractC0712c abstractC0712c, C1151c c1151c, C1150b c1150b) throws C0850b {
        int i3 = c1150b.f3979c;
        AbstractC1204t[] abstractC1204tArr = new AbstractC1204t[i3];
        int i4 = -1;
        for (int i5 = 0; i5 < i3; i5++) {
            C2071i c2071i = c1150b.f3980d[i5];
            C1047r c1047r = (C1047r) c2071i.f7314a;
            C0480b c0480b = (C0480b) c2071i.f7316c;
            if (c0480b != null) {
                abstractC1204tArr[i5] = m2945l(abstractC0718i, abstractC0712c, null, i5, c1047r, c0480b);
            } else {
                if (i4 >= 0) {
                    abstractC0718i.m1839Q(abstractC0712c, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", Integer.valueOf(i4), Integer.valueOf(i5), c1150b);
                    throw null;
                }
                i4 = i5;
            }
        }
        if (i4 < 0) {
            abstractC0718i.m1839Q(abstractC0712c, "No argument left as delegating for Creator %s: exactly one required", c1150b);
            throw null;
        }
        AbstractC1048s abstractC1048s = c1150b.f3978b;
        if (i3 != 1) {
            c1151c.m2995b(abstractC1048s, true, abstractC1204tArr, i4);
            return;
        }
        m2932j(c1151c, abstractC1048s, true, true);
        AbstractC1007C abstractC1007CM2993d = c1150b.m2993d(0);
        if (abstractC1007CM2993d != null) {
            ((C1025V) abstractC1007CM2993d).f3647l = null;
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m2942f(AbstractC0718i abstractC0718i, AbstractC0712c abstractC0712c, C1151c c1151c, C1150b c1150b) throws C0850b {
        C0703E c0703e;
        int i3 = c1150b.f3979c;
        AbstractC1204t[] abstractC1204tArr = new AbstractC1204t[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            C2071i c2071i = c1150b.f3980d[i4];
            C0480b c0480b = (C0480b) c2071i.f7316c;
            C1047r c1047r = (C1047r) c2071i.f7314a;
            C0703E c0703eM2992c = c1150b.m2992c(i4);
            if (c0703eM2992c != null) {
                c0703e = c0703eM2992c;
            } else {
                if (abstractC0718i.f1998g.m2149d().mo1756a0(c1047r) != null) {
                    abstractC0718i.m1839Q(abstractC0712c, "Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", Integer.valueOf(c1047r.f3716i));
                    throw null;
                }
                c1150b.m2991b(i4);
                if (c0480b == null) {
                    abstractC0718i.m1839Q(abstractC0712c, "Argument #%d of constructor %s has no property name (and is not Injectable): can not use as property-based Creator", Integer.valueOf(i4), c1150b);
                    throw null;
                }
                c0703e = null;
            }
            abstractC1204tArr[i4] = m2945l(abstractC0718i, abstractC0712c, c0703e, i4, c1047r, c0480b);
        }
        c1151c.m2996c(c1150b.f3978b, true, abstractC1204tArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:206:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0465 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016b  */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fasterxml.jackson.databind.deser.std.C1202r m2943h(p069X0.AbstractC0718i r38, p069X0.AbstractC0712c r39) {
        /*
            Method dump skipped, instruction units count: 1709
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.AbstractC1135b.m2943h(X0.i, X0.c):com.fasterxml.jackson.databind.deser.std.r");
    }

    /* JADX INFO: renamed from: i */
    public final AbstractC0722m m2944i(Class cls) {
        AbstractC0722m abstractC0722m;
        C1740e c1740eM2145b = this.f3929e.m2145b();
        do {
            abstractC0722m = null;
            if (!c1740eM2145b.hasNext()) {
                break;
            }
            C1448a c1448a = (C1448a) ((AbstractC1177l) c1740eM2145b.next());
            HashMap map = c1448a.f5143e;
            if (map != null && (abstractC0722m = (AbstractC0722m) map.get(new C1660b(cls))) == null && c1448a.f5144f && cls.isEnum()) {
                abstractC0722m = (AbstractC0722m) c1448a.f5143e.get(new C1660b(Enum.class));
            }
        } while (abstractC0722m == null);
        return abstractC0722m;
    }

    /* JADX INFO: renamed from: l */
    public final C1140g m2945l(AbstractC0718i abstractC0718i, AbstractC0712c abstractC0712c, C0703E c0703e, int i3, C1047r c1047r, C0480b c0480b) {
        EnumC0481b0 enumC0481b0;
        EnumC0481b0 enumC0481b02;
        EnumC0481b0 enumC0481b03;
        C0717h c0717h = abstractC0718i.f1998g;
        AbstractC0711b abstractC0711bM2149d = c0717h.m2149d();
        C0702D c0702dM1684a = abstractC0711bM2149d == null ? C0702D.f1918n : C0702D.m1684a(abstractC0711bM2149d.mo1778l0(c1047r), abstractC0711bM2149d.mo1736H(c1047r), abstractC0711bM2149d.mo1741M(c1047r), abstractC0711bM2149d.mo1735G(c1047r));
        AbstractC0721l abstractC0721lM2947q = m2947q(abstractC0718i, c1047r, c1047r.f3715h);
        AbstractC1398g abstractC1398g = (AbstractC1398g) abstractC0721lM2947q.f2039h;
        AbstractC1398g abstractC1398gMo2938b = abstractC1398g == null ? mo2938b(c0717h, abstractC0721lM2947q) : abstractC1398g;
        C0717h c0717h2 = abstractC0718i.f1998g;
        AbstractC0711b abstractC0711bM2149d2 = c0717h2.m2149d();
        EnumC0481b0 enumC0481b04 = EnumC0481b0.f1125h;
        if (abstractC0711bM2149d2 != null) {
            C0466N c0466nMo1751W = abstractC0711bM2149d2.mo1751W(c1047r);
            enumC0481b02 = c0466nMo1751W.f1105e;
            if (enumC0481b02 == enumC0481b04) {
                enumC0481b02 = null;
            }
            enumC0481b0 = c0466nMo1751W.f1106f;
            if (enumC0481b0 == enumC0481b04) {
                enumC0481b0 = null;
            }
        } else {
            enumC0481b0 = null;
            enumC0481b02 = null;
        }
        c0717h2.mo2150e(abstractC0721lM2947q.f2036e);
        C0466N c0466n = c0717h2.f2490m.f2449g;
        if (enumC0481b02 == null && (enumC0481b02 = c0466n.f1105e) == enumC0481b04) {
            enumC0481b02 = null;
        }
        EnumC0481b0 enumC0481b05 = enumC0481b02;
        if (enumC0481b0 == null) {
            EnumC0481b0 enumC0481b06 = c0466n.f1106f;
            enumC0481b03 = enumC0481b06 != enumC0481b04 ? enumC0481b06 : null;
        } else {
            enumC0481b03 = enumC0481b0;
        }
        AbstractC1204t c1140g = new C1140g(c0703e, abstractC0721lM2947q, abstractC1398gMo2938b, ((C1005A) abstractC0712c).f3582e.f3674n, c1047r, i3, c0480b, (enumC0481b05 == null && enumC0481b03 == null) ? c0702dM1684a : new C0702D(c0702dM1684a.f1919e, c0702dM1684a.f1920f, c0702dM1684a.f1921g, c0702dM1684a.f1922h, c0702dM1684a.f1923i, enumC0481b05, enumC0481b03));
        AbstractC0722m abstractC0722mM2935n = m2935n(abstractC0718i, c1047r);
        if (abstractC0722mM2935n == null) {
            abstractC0722mM2935n = (AbstractC0722m) abstractC0721lM2947q.f2038g;
        }
        if (abstractC0722mM2935n != null) {
            c1140g = c1140g.mo2965H(abstractC0718i.m1861z(abstractC0722mM2935n, c1140g, abstractC0721lM2947q));
        }
        return (C1140g) c1140g;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX INFO: renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fasterxml.jackson.databind.deser.AbstractC1208x m2946p(p069X0.AbstractC0718i r5, p069X0.AbstractC0712c r6) {
        /*
            r4 = this;
            X0.h r0 = r5.f1998g
            r1 = r6
            b1.A r1 = (p082b1.C1005A) r1
            b1.d r1 = r1.f3582e
            X0.b r2 = r0.m2149d()
            java.lang.Object r1 = r2.mo1758b0(r1)
            r2 = 0
            if (r1 == 0) goto L58
            boolean r3 = r1 instanceof com.fasterxml.jackson.databind.deser.AbstractC1208x
            if (r3 == 0) goto L19
            com.fasterxml.jackson.databind.deser.x r1 = (com.fasterxml.jackson.databind.deser.AbstractC1208x) r1
            goto L59
        L19:
            java.lang.Class r1 = (java.lang.Class) r1
            boolean r3 = p118m1.AbstractC1745j.m3897t(r1)
            if (r3 == 0) goto L22
            goto L58
        L22:
            java.lang.Class<com.fasterxml.jackson.databind.deser.x> r3 = com.fasterxml.jackson.databind.deser.AbstractC1208x.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L3b
            r0.m2153h()
            X0.v r3 = p069X0.EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r0 = r0.m2157l(r3)
            java.lang.Object r0 = p118m1.AbstractC1745j.m3885h(r1, r0)
            r1 = r0
            com.fasterxml.jackson.databind.deser.x r1 = (com.fasterxml.jackson.databind.deser.AbstractC1208x) r1
            goto L59
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "AnnotationIntrospector returned Class "
            r6.<init>(r0)
            java.lang.String r0 = r1.getName()
            r6.append(r0)
            java.lang.String r0 = "; expected Class<ValueInstantiator>"
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L58:
            r1 = r2
        L59:
            if (r1 != 0) goto L69
            X0.l r0 = r6.f1980a
            java.lang.Class r0 = r0.f2036e
            com.fasterxml.jackson.databind.deser.w r1 = p020F2.AbstractC0223a.m466c(r0)
            if (r1 != 0) goto L69
            com.fasterxml.jackson.databind.deser.std.r r1 = r4.m2943h(r5, r6)
        L69:
            Z0.o r5 = r4.f3929e
            w0.a[] r5 = r5.f2470i
            int r6 = r5.length
            if (r6 <= 0) goto L80
            int r6 = r5.length
            if (r6 <= 0) goto L80
            int r6 = r5.length
            if (r6 <= 0) goto L7a
            r6 = 0
            r5 = r5[r6]
            throw r2
        L7a:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            r5.<init>()
            throw r5
        L80:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.AbstractC1135b.m2946p(X0.i, X0.c):com.fasterxml.jackson.databind.deser.x");
    }

    /* JADX INFO: renamed from: q */
    public final AbstractC0721l m2947q(AbstractC0718i abstractC0718i, AbstractC1041l abstractC1041l, AbstractC0721l abstractC0721l) {
        AbstractC0721l abstractC0721lMo1869H;
        AbstractC1428p abstractC1428pM3436a;
        AbstractC0730u abstractC0730uMo1834L;
        AbstractC0711b abstractC0711bM2149d = abstractC0718i.f1998g.m2149d();
        if (abstractC0711bM2149d == null) {
            return abstractC0721l;
        }
        if (!abstractC0721l.mo1890y() || abstractC0721l.mo1877l() == null || (abstractC0730uMo1834L = abstractC0718i.mo1834L(abstractC0711bM2149d.mo1791s(abstractC1041l))) == null) {
            abstractC0721lMo1869H = abstractC0721l;
        } else {
            C1666h c1666h = (C1666h) ((AbstractC1665g) abstractC0721l);
            abstractC0721lMo1869H = new C1666h(c1666h.f2036e, c1666h.f5913l, c1666h.f5911j, c1666h.f5912k, c1666h.f5903n.mo1870I(abstractC0730uMo1834L), c1666h.f5904o, c1666h.f2038g, c1666h.f2039h, c1666h.f2040i);
        }
        boolean zMo1880o = abstractC0721lMo1869H.mo1880o();
        C0717h c0717h = abstractC0718i.f1998g;
        if (zMo1880o) {
            AbstractC0722m abstractC0722mMo1849n = abstractC0718i.mo1849n(abstractC0711bM2149d.mo1759c(abstractC1041l));
            if (abstractC0722mMo1849n != null) {
                abstractC0721lMo1869H = abstractC0721lMo1869H.mo1866E(abstractC0722mMo1849n);
            }
            C1426n c1426nMo1734F = c0717h.m2149d().mo1734F(c0717h, abstractC1041l, abstractC0721lMo1869H);
            AbstractC0721l abstractC0721lMo1874i = abstractC0721lMo1869H.mo1874i();
            AbstractC1428p abstractC1428pMo2938b = c1426nMo1734F == null ? mo2938b(c0717h, abstractC0721lMo1874i) : c1426nMo1734F.m3436a(c0717h, abstractC0721lMo1874i, c0717h.f2485h.mo3398c(c0717h, abstractC1041l, abstractC0721lMo1874i));
            if (abstractC1428pMo2938b != null) {
                abstractC0721lMo1869H = abstractC0721lMo1869H.mo1865D(abstractC1428pMo2938b);
            }
        }
        C1426n c1426nMo1742N = c0717h.m2149d().mo1742N(c0717h, abstractC1041l, abstractC0721lMo1869H);
        if (c1426nMo1742N == null) {
            abstractC1428pM3436a = mo2938b(c0717h, abstractC0721lMo1869H);
        } else {
            try {
                abstractC1428pM3436a = c1426nMo1742N.m3436a(c0717h, abstractC0721lMo1869H, c0717h.f2485h.mo3398c(c0717h, abstractC1041l, abstractC0721lMo1869H));
            } catch (IllegalArgumentException | IllegalStateException e3) {
                C0850b c0850b = new C0850b((Closeable) null, AbstractC1745j.m3886i(e3));
                c0850b.initCause(e3);
                throw c0850b;
            }
        }
        if (abstractC1428pM3436a != null) {
            abstractC0721lMo1869H = abstractC0721lMo1869H.mo1869H(abstractC1428pM3436a);
        }
        return abstractC0711bM2149d.mo1786p0(c0717h, abstractC1041l, abstractC0721lMo1869H);
    }
}
