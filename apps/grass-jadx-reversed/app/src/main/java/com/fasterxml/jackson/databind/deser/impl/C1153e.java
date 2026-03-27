package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import java.io.Closeable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p042N0.AbstractC0545m;
import p042N0.C0538f;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.EnumC0719j;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p103h1.AbstractC1428p;
import p118m1.AbstractC1745j;
import p118m1.C1728C;
import p118m1.C1730E;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1153e {

    /* JADX INFO: renamed from: a */
    public final AbstractC0721l f3995a;

    /* JADX INFO: renamed from: b */
    public final C1152d[] f3996b;

    /* JADX INFO: renamed from: c */
    public final Map f3997c;

    /* JADX INFO: renamed from: d */
    public final String[] f3998d;

    /* JADX INFO: renamed from: e */
    public final C1730E[] f3999e;

    public C1153e(AbstractC0721l abstractC0721l, C1152d[] c1152dArr, HashMap map) {
        this.f3995a = abstractC0721l;
        this.f3996b = c1152dArr;
        this.f3997c = map;
        this.f3998d = null;
        this.f3999e = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m2998a(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, int i3, String str) throws C0850b, C0538f {
        if (str == null) {
            abstractC0718i.m1842T("Internal error in external Type Id handling: `null` type id passed", new Object[0]);
            throw null;
        }
        C1728C c1728cM3860e0 = this.f3999e[i3].m3860e0(abstractC0545m);
        EnumC0548p enumC0548pMo1177V = c1728cM3860e0.mo1177V();
        EnumC0548p enumC0548p = EnumC0548p.VALUE_NULL;
        C1152d[] c1152dArr = this.f3996b;
        if (enumC0548pMo1177V == enumC0548p) {
            c1152dArr[i3].f3991a.mo2961B(obj, null);
            return;
        }
        C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
        c1730eM1847l.mo1117J();
        c1730eM1847l.mo1125R(str);
        c1730eM1847l.m3862g0(c1728cM3860e0);
        c1730eM1847l.mo1142o();
        C1728C c1728cM3860e02 = c1730eM1847l.m3860e0(abstractC0545m);
        c1728cM3860e02.mo1177V();
        c1152dArr[i3].f3991a.mo2967k(c1728cM3860e02, abstractC0718i, obj);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m2999b(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, String str, Object obj, String str2, int i3) throws C0850b, C0538f {
        if (!str.equals(this.f3996b[i3].f3993c)) {
            return false;
        }
        if (obj != null) {
            C1730E[] c1730eArr = this.f3999e;
            if (c1730eArr[i3] != null) {
                m2998a(abstractC0545m, abstractC0718i, obj, i3, str2);
                c1730eArr[i3] = null;
                return true;
            }
        }
        this.f3998d[i3] = str2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0103 A[SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m3000c(p042N0.AbstractC0545m r12, p069X0.AbstractC0718i r13, com.fasterxml.jackson.databind.deser.impl.C1143A r14, com.fasterxml.jackson.databind.deser.impl.C1171w r15) throws p078a1.C0850b, p042N0.C0538f {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.impl.C1153e.m3000c(N0.m, X0.i, com.fasterxml.jackson.databind.deser.impl.A, com.fasterxml.jackson.databind.deser.impl.w):java.lang.Object");
    }

    /* JADX INFO: renamed from: d */
    public final void m3001d(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0850b, C0538f {
        String str;
        C1152d[] c1152dArr = this.f3996b;
        int length = c1152dArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            String str2 = this.f3998d[i3];
            C1152d c1152d = c1152dArr[i3];
            C1730E[] c1730eArr = this.f3999e;
            if (str2 == null) {
                C1730E c1730e = c1730eArr[i3];
                if (c1730e != null) {
                    if (c1730e.f6063m.m3850d(0).f1332l) {
                        C1728C c1728cM3860e0 = c1730e.m3860e0(abstractC0545m);
                        c1728cM3860e0.mo1177V();
                        AbstractC1204t abstractC1204t = c1152d.f3991a;
                        Object objM3399a = AbstractC1398g.m3399a(c1728cM3860e0, abstractC1204t.f4103h);
                        if (objM3399a != null) {
                            abstractC1204t.mo2961B(obj, objM3399a);
                        }
                    }
                    AbstractC1398g abstractC1398g = c1152d.f3992b;
                    boolean z3 = ((AbstractC1428p) abstractC1398g).f5063h != null;
                    AbstractC0721l abstractC0721l = this.f3995a;
                    String str3 = c1152d.f3993c;
                    AbstractC1204t abstractC1204t2 = c1152d.f3991a;
                    if (!z3) {
                        String str4 = abstractC1204t2.f4102g.f1928e;
                        abstractC0718i.getClass();
                        Class cls = abstractC0721l.f2036e;
                        C0850b c0850b = new C0850b((Closeable) abstractC0718i.f2002k, String.format("Missing external type id property '%s' (and no 'defaultImpl' specified)", str3));
                        if (str4 == null) {
                            throw c0850b;
                        }
                        c0850b.mo1816d(str4, cls);
                        throw c0850b;
                    }
                    AbstractC1428p abstractC1428p = (AbstractC1428p) abstractC1398g;
                    abstractC1428p.getClass();
                    Annotation[] annotationArr = AbstractC1745j.f6110a;
                    AbstractC0721l abstractC0721l2 = abstractC1428p.f5063h;
                    Class cls2 = abstractC0721l2 == null ? null : abstractC0721l2.f2036e;
                    String strMo3429c = cls2 != null ? abstractC1428p.f5060e.mo3429c(null, cls2) : null;
                    if (strMo3429c == null) {
                        String str5 = abstractC1204t2.f4102g.f1928e;
                        abstractC0718i.getClass();
                        Class cls3 = abstractC0721l.f2036e;
                        C0850b c0850b2 = new C0850b((Closeable) abstractC0718i.f2002k, String.format("Invalid default type id for property '%s': `null` returned by TypeIdResolver", str3));
                        if (str5 == null) {
                            throw c0850b2;
                        }
                        c0850b2.mo1816d(str5, cls3);
                        throw c0850b2;
                    }
                    str = strMo3429c;
                } else {
                    continue;
                }
            } else {
                if (c1730eArr[i3] == null) {
                    AbstractC1204t abstractC1204t3 = c1152d.f3991a;
                    if (abstractC1204t3.m2728g() || abstractC0718i.m1833K(EnumC0719j.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)) {
                        Class<?> cls4 = obj.getClass();
                        String str6 = abstractC1204t3.f4102g.f1928e;
                        Object[] objArr = {str6, c1152d.f3993c};
                        abstractC0718i.getClass();
                        C0850b c0850b3 = new C0850b((Closeable) abstractC0718i.f2002k, String.format("Missing property '%s' for external type id '%s'", objArr));
                        if (str6 == null) {
                            throw c0850b3;
                        }
                        c0850b3.mo1816d(str6, cls4);
                        throw c0850b3;
                    }
                    return;
                }
                str = str2;
            }
            m2998a(abstractC0545m, abstractC0718i, obj, i3, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3002e(p042N0.AbstractC0545m r13, p069X0.AbstractC0718i r14, java.lang.Object r15, java.lang.String r16) throws p078a1.C0850b, p042N0.C0538f {
        /*
            r12 = this;
            r6 = r12
            r1 = r13
            r2 = r14
            r0 = r16
            java.util.Map r3 = r6.f3997c
            java.lang.Object r3 = r3.get(r0)
            if (r3 != 0) goto Lf
            r0 = 0
            return r0
        Lf:
            boolean r4 = r3 instanceof java.util.List
            r7 = 1
            com.fasterxml.jackson.databind.deser.impl.d[] r5 = r6.f3996b
            m1.E[] r8 = r6.f3999e
            java.lang.String[] r9 = r6.f3998d
            if (r4 == 0) goto L75
            java.util.List r3 = (java.util.List) r3
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r10 = r4.intValue()
            r5 = r5[r10]
            java.lang.String r5 = r5.f3993c
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L54
            java.lang.String r0 = r13.mo1157B()
            r13.mo1187c0()
            int r1 = r4.intValue()
            r9[r1] = r0
        L41:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L74
            java.lang.Object r1 = r3.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r9[r1] = r0
            goto L41
        L54:
            m1.E r0 = r14.m1847l(r13)
            r0.m3862g0(r13)
            int r1 = r4.intValue()
            r8[r1] = r0
        L61:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L74
            java.lang.Object r1 = r3.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r8[r1] = r0
            goto L61
        L74:
            return r7
        L75:
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r10 = r3.intValue()
            r3 = r5[r10]
            java.lang.String r3 = r3.f3993c
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L95
            java.lang.String r0 = r13.mo1165J()
            r9[r10] = r0
            r13.mo1187c0()
            if (r15 == 0) goto Lb3
            r0 = r8[r10]
            if (r0 == 0) goto Lb3
            goto La4
        L95:
            m1.E r0 = r14.m1847l(r13)
            r0.m3862g0(r13)
            r8[r10] = r0
            if (r15 == 0) goto Lb3
            r0 = r9[r10]
            if (r0 == 0) goto Lb3
        La4:
            r5 = r9[r10]
            r11 = 0
            r9[r10] = r11
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r10
            r0.m2998a(r1, r2, r3, r4, r5)
            r8[r10] = r11
        Lb3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.impl.C1153e.m3002e(N0.m, X0.i, java.lang.Object, java.lang.String):boolean");
    }

    /* JADX INFO: renamed from: f */
    public final void m3003f(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, String str) throws C0850b, C0538f {
        Object obj2 = this.f3997c.get(str);
        if (obj2 == null) {
            return;
        }
        String strMo1157B = abstractC0545m.mo1157B();
        if (!(obj2 instanceof List)) {
            m2999b(abstractC0545m, abstractC0718i, str, obj, strMo1157B, ((Integer) obj2).intValue());
            return;
        }
        Iterator it = ((List) obj2).iterator();
        while (it.hasNext()) {
            m2999b(abstractC0545m, abstractC0718i, str, obj, strMo1157B, ((Integer) it.next()).intValue());
        }
    }

    public C1153e(C1153e c1153e) {
        this.f3995a = c1153e.f3995a;
        C1152d[] c1152dArr = c1153e.f3996b;
        this.f3996b = c1152dArr;
        this.f3997c = c1153e.f3997c;
        int length = c1152dArr.length;
        this.f3998d = new String[length];
        this.f3999e = new C1730E[length];
    }
}
