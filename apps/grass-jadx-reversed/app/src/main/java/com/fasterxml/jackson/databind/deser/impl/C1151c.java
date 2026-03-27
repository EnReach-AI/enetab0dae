package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.HashMap;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0712c;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.EnumC0731v;
import p074Z0.AbstractC0832r;
import p082b1.AbstractC1048s;
import p082b1.C1047r;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1151c {

    /* JADX INFO: renamed from: j */
    public static final String[] f3981j = {"default", "from-String", "from-int", "from-long", "from-big-integer", "from-double", "from-big-decimal", "from-boolean", "delegate", "property-based", "array-delegate"};

    /* JADX INFO: renamed from: a */
    public final AbstractC0712c f3982a;

    /* JADX INFO: renamed from: b */
    public final boolean f3983b;

    /* JADX INFO: renamed from: c */
    public final boolean f3984c;

    /* JADX INFO: renamed from: d */
    public final AbstractC1048s[] f3985d = new AbstractC1048s[11];

    /* JADX INFO: renamed from: e */
    public int f3986e = 0;

    /* JADX INFO: renamed from: f */
    public boolean f3987f = false;

    /* JADX INFO: renamed from: g */
    public AbstractC1204t[] f3988g;

    /* JADX INFO: renamed from: h */
    public AbstractC1204t[] f3989h;

    /* JADX INFO: renamed from: i */
    public AbstractC1204t[] f3990i;

    public C1151c(AbstractC0712c abstractC0712c, AbstractC0832r abstractC0832r) {
        this.f3982a = abstractC0712c;
        abstractC0832r.getClass();
        this.f3983b = abstractC0832r.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS);
        this.f3984c = abstractC0832r.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0721l m2994a(AbstractC0718i abstractC0718i, AbstractC1048s abstractC1048s, AbstractC1204t[] abstractC1204tArr) {
        if (!this.f3987f || abstractC1048s == null) {
            return null;
        }
        int i3 = 0;
        if (abstractC1204tArr != null) {
            int length = abstractC1204tArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (abstractC1204tArr[i4] == null) {
                    i3 = i4;
                    break;
                }
                i4++;
            }
        }
        AbstractC0832r abstractC0832r = abstractC0718i.f1998g;
        AbstractC0721l abstractC0721lMo2791t = abstractC1048s.mo2791t(i3);
        AbstractC0711b abstractC0711bM2149d = abstractC0832r.m2149d();
        if (abstractC0711bM2149d == null) {
            return abstractC0721lMo2791t;
        }
        C1047r c1047rM2805r = abstractC1048s.m2805r(i3);
        Object objMo1773j = abstractC0711bM2149d.mo1773j(c1047rM2805r);
        return objMo1773j != null ? abstractC0721lMo2791t.mo1870I(abstractC0718i.mo1849n(objMo1773j)) : abstractC0711bM2149d.mo1786p0(abstractC0832r, c1047rM2805r, abstractC0721lMo2791t);
    }

    /* JADX INFO: renamed from: b */
    public final void m2995b(AbstractC1048s abstractC1048s, boolean z3, AbstractC1204t[] abstractC1204tArr, int i3) {
        if (abstractC1048s.mo2791t(i3).mo1885t()) {
            if (m2997d(abstractC1048s, 10, z3)) {
                this.f3989h = abstractC1204tArr;
            }
        } else if (m2997d(abstractC1048s, 8, z3)) {
            this.f3988g = abstractC1204tArr;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m2996c(AbstractC1048s abstractC1048s, boolean z3, AbstractC1204t[] abstractC1204tArr) {
        Integer num;
        if (m2997d(abstractC1048s, 9, z3)) {
            if (abstractC1204tArr.length > 1) {
                HashMap map = new HashMap();
                int length = abstractC1204tArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    String str = abstractC1204tArr[i3].f4102g.f1928e;
                    if ((!str.isEmpty() || abstractC1204tArr[i3].mo2971p() == null) && (num = (Integer) map.put(str, Integer.valueOf(i3))) != null) {
                        throw new IllegalArgumentException(String.format("Duplicate creator property \"%s\" (index %s vs %d) for type %s ", str, num, Integer.valueOf(i3), AbstractC1745j.m3903z(this.f3982a.f1980a.f2036e)));
                    }
                }
            }
            this.f3990i = abstractC1204tArr;
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m2997d(AbstractC1048s abstractC1048s, int i3, boolean z3) {
        boolean z4;
        int i4 = 1 << i3;
        this.f3987f = true;
        AbstractC1048s[] abstractC1048sArr = this.f3985d;
        AbstractC1048s abstractC1048s2 = abstractC1048sArr[i3];
        if (abstractC1048s2 != null) {
            boolean z5 = false;
            if ((this.f3986e & i4) == 0) {
                z4 = !z3;
            } else {
                if (!z3) {
                    return false;
                }
                z4 = true;
            }
            if (z4 && abstractC1048s2.getClass() == abstractC1048s.getClass()) {
                Class clsMo2792u = abstractC1048s2.mo2792u(0);
                Class<?> clsMo2792u2 = abstractC1048s.mo2792u(0);
                String[] strArr = f3981j;
                if (clsMo2792u == clsMo2792u2) {
                    Class clsMo2770i = abstractC1048s.mo2770i();
                    Annotation[] annotationArr = AbstractC1745j.f6110a;
                    if (Enum.class.isAssignableFrom(clsMo2770i) && "valueOf".equals(abstractC1048s.mo2767d())) {
                        return false;
                    }
                    if (Enum.class.isAssignableFrom(abstractC1048s2.mo2770i()) && "valueOf".equals(abstractC1048s2.mo2767d())) {
                        z5 = true;
                    }
                    if (!z5) {
                        throw new IllegalArgumentException(String.format("Conflicting %s creators: already had %s creator %s, encountered another: %s", strArr[i3], z3 ? "explicitly marked" : "implicitly discovered", abstractC1048s2, abstractC1048s));
                    }
                } else {
                    if (clsMo2792u2.isAssignableFrom(clsMo2792u)) {
                        return false;
                    }
                    if (!clsMo2792u.isAssignableFrom(clsMo2792u2)) {
                        if (clsMo2792u.isPrimitive() == clsMo2792u2.isPrimitive()) {
                            throw new IllegalArgumentException(String.format("Conflicting %s creators: already had %s creator %s, encountered another: %s", strArr[i3], z3 ? "explicitly marked" : "implicitly discovered", abstractC1048s2, abstractC1048s));
                        }
                        if (clsMo2792u.isPrimitive()) {
                            return false;
                        }
                    }
                }
            }
        }
        if (z3) {
            this.f3986e |= i4;
        }
        if (abstractC1048s != null && this.f3983b) {
            AbstractC1745j.m3882e((Member) abstractC1048s.mo2766a(), this.f3984c);
        }
        abstractC1048sArr[i3] = abstractC1048s;
        return true;
    }
}
