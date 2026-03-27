package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.C0717h;
import p069X0.C0724o;
import p078a1.C0850b;
import p082b1.AbstractC1048s;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1202r extends AbstractC1208x implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final String f4077e;

    /* JADX INFO: renamed from: f */
    public final Class f4078f;

    /* JADX INFO: renamed from: g */
    public AbstractC1048s f4079g;

    /* JADX INFO: renamed from: h */
    public AbstractC1048s f4080h;

    /* JADX INFO: renamed from: i */
    public AbstractC1204t[] f4081i;

    /* JADX INFO: renamed from: j */
    public AbstractC0721l f4082j;

    /* JADX INFO: renamed from: k */
    public AbstractC1048s f4083k;

    /* JADX INFO: renamed from: l */
    public AbstractC1204t[] f4084l;

    /* JADX INFO: renamed from: m */
    public AbstractC0721l f4085m;

    /* JADX INFO: renamed from: n */
    public AbstractC1048s f4086n;

    /* JADX INFO: renamed from: o */
    public AbstractC1204t[] f4087o;

    /* JADX INFO: renamed from: p */
    public AbstractC1048s f4088p;

    /* JADX INFO: renamed from: q */
    public AbstractC1048s f4089q;

    /* JADX INFO: renamed from: r */
    public AbstractC1048s f4090r;

    /* JADX INFO: renamed from: s */
    public AbstractC1048s f4091s;

    /* JADX INFO: renamed from: t */
    public AbstractC1048s f4092t;

    /* JADX INFO: renamed from: u */
    public AbstractC1048s f4093u;

    /* JADX INFO: renamed from: v */
    public AbstractC1048s f4094v;

    public C1202r(AbstractC0721l abstractC0721l) {
        this.f4077e = abstractC0721l == null ? "UNKNOWN TYPE" : abstractC0721l.toString();
        this.f4078f = abstractC0721l == null ? Object.class : abstractC0721l.f2036e;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: A */
    public final AbstractC1048s mo3046A() {
        return this.f4079g;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: B */
    public final AbstractC1048s mo3047B() {
        return this.f4083k;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: C */
    public final AbstractC0721l mo3048C() {
        return this.f4082j;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: D */
    public final AbstractC1204t[] mo3039D(C0717h c0717h) {
        return this.f4081i;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: E */
    public final Class mo3049E() {
        return this.f4078f;
    }

    /* JADX INFO: renamed from: F */
    public final Object m3050F(AbstractC1048s abstractC1048s, AbstractC1204t[] abstractC1204tArr, AbstractC0718i abstractC0718i, Object obj) throws C0724o {
        if (abstractC1048s == null) {
            throw new IllegalStateException("No delegate constructor for " + this.f4077e);
        }
        try {
            if (abstractC1204tArr == null) {
                return abstractC1048s.mo2789q(obj);
            }
            int length = abstractC1204tArr.length;
            Object[] objArr = new Object[length];
            for (int i3 = 0; i3 < length; i3++) {
                AbstractC1204t abstractC1204t = abstractC1204tArr[i3];
                if (abstractC1204t != null) {
                    abstractC0718i.m1853r(abstractC1204t.mo2971p());
                    throw null;
                }
                objArr[i3] = obj;
            }
            return abstractC1048s.mo2788p(objArr);
        } catch (Exception e3) {
            throw m3051G(abstractC0718i, e3);
        }
    }

    /* JADX INFO: renamed from: G */
    public final C0724o m3051G(AbstractC0718i abstractC0718i, Exception exc) {
        Throwable cause;
        if ((exc instanceof InvocationTargetException) && (cause = exc.getCause()) != null) {
            exc = cause;
        }
        return exc instanceof C0724o ? (C0724o) exc : abstractC0718i.m1831I(this.f4078f, exc);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: a */
    public final boolean mo3052a() {
        return this.f4093u != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: b */
    public final boolean mo3053b() {
        return this.f4091s != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: c */
    public final boolean mo3054c() {
        return this.f4094v != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: d */
    public final boolean mo3055d() {
        return this.f4092t != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: e */
    public final boolean mo3056e() {
        return this.f4089q != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: f */
    public final boolean mo3057f() {
        return this.f4090r != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: g */
    public final boolean mo3058g() {
        return this.f4080h != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: h */
    public final boolean mo3059h() {
        return this.f4088p != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: i */
    public final boolean mo3060i() {
        return this.f4085m != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: j */
    public final boolean mo3005j() {
        return this.f4079g != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: k */
    public final boolean mo3061k() {
        return this.f4082j != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: l */
    public final boolean mo3006l() {
        return mo3005j() || mo3061k() || mo3060i() || mo3058g() || mo3059h() || mo3056e() || mo3057f() || mo3055d() || mo3054c();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: m */
    public final Object mo3062m(AbstractC0718i abstractC0718i, BigDecimal bigDecimal) throws C0850b {
        AbstractC1048s abstractC1048s = this.f4093u;
        if (abstractC1048s != null) {
            try {
                return abstractC1048s.mo2789q(bigDecimal);
            } catch (Exception e3) {
                abstractC0718i.m1859x(this.f4093u.mo2770i(), m3051G(abstractC0718i, e3));
                throw null;
            }
        }
        if (this.f4092t != null) {
            double dDoubleValue = bigDecimal.doubleValue();
            Double dValueOf = Double.isInfinite(dDoubleValue) ? null : Double.valueOf(dDoubleValue);
            if (dValueOf != null) {
                try {
                    return this.f4092t.mo2789q(dValueOf);
                } catch (Exception e4) {
                    abstractC0718i.m1859x(this.f4092t.mo2770i(), m3051G(abstractC0718i, e4));
                    throw null;
                }
            }
        }
        super.mo3062m(abstractC0718i, bigDecimal);
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: n */
    public final Object mo3063n(AbstractC0718i abstractC0718i, BigInteger bigInteger) throws C0850b {
        AbstractC1048s abstractC1048s = this.f4091s;
        if (abstractC1048s == null) {
            super.mo3063n(abstractC0718i, bigInteger);
            throw null;
        }
        try {
            return abstractC1048s.mo2789q(bigInteger);
        } catch (Exception e3) {
            abstractC0718i.m1859x(this.f4091s.mo2770i(), m3051G(abstractC0718i, e3));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: o */
    public final Object mo3064o(AbstractC0718i abstractC0718i, boolean z3) throws C0850b {
        if (this.f4094v == null) {
            super.mo3064o(abstractC0718i, z3);
            throw null;
        }
        try {
            return this.f4094v.mo2789q(Boolean.valueOf(z3));
        } catch (Exception e3) {
            abstractC0718i.m1859x(this.f4094v.mo2770i(), m3051G(abstractC0718i, e3));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: p */
    public final Object mo3065p(AbstractC0718i abstractC0718i, double d) throws C0850b {
        if (this.f4092t != null) {
            try {
                return this.f4092t.mo2789q(Double.valueOf(d));
            } catch (Exception e3) {
                abstractC0718i.m1859x(this.f4092t.mo2770i(), m3051G(abstractC0718i, e3));
                throw null;
            }
        }
        if (this.f4093u == null) {
            super.mo3065p(abstractC0718i, d);
            throw null;
        }
        try {
            return this.f4093u.mo2789q(BigDecimal.valueOf(d));
        } catch (Exception e4) {
            abstractC0718i.m1859x(this.f4093u.mo2770i(), m3051G(abstractC0718i, e4));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: q */
    public final Object mo3066q(AbstractC0718i abstractC0718i, int i3) throws C0850b {
        if (this.f4089q != null) {
            try {
                return this.f4089q.mo2789q(Integer.valueOf(i3));
            } catch (Exception e3) {
                abstractC0718i.m1859x(this.f4089q.mo2770i(), m3051G(abstractC0718i, e3));
                throw null;
            }
        }
        if (this.f4090r != null) {
            try {
                return this.f4090r.mo2789q(Long.valueOf(i3));
            } catch (Exception e4) {
                abstractC0718i.m1859x(this.f4090r.mo2770i(), m3051G(abstractC0718i, e4));
                throw null;
            }
        }
        if (this.f4091s == null) {
            super.mo3066q(abstractC0718i, i3);
            throw null;
        }
        try {
            return this.f4091s.mo2789q(BigInteger.valueOf(i3));
        } catch (Exception e5) {
            abstractC0718i.m1859x(this.f4091s.mo2770i(), m3051G(abstractC0718i, e5));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: r */
    public final Object mo3067r(AbstractC0718i abstractC0718i, long j2) throws C0850b {
        if (this.f4090r != null) {
            try {
                return this.f4090r.mo2789q(Long.valueOf(j2));
            } catch (Exception e3) {
                abstractC0718i.m1859x(this.f4090r.mo2770i(), m3051G(abstractC0718i, e3));
                throw null;
            }
        }
        if (this.f4091s == null) {
            super.mo3067r(abstractC0718i, j2);
            throw null;
        }
        try {
            return this.f4091s.mo2789q(BigInteger.valueOf(j2));
        } catch (Exception e4) {
            abstractC0718i.m1859x(this.f4091s.mo2770i(), m3051G(abstractC0718i, e4));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: s */
    public final Object mo3040s(AbstractC0718i abstractC0718i, Object[] objArr) throws C0850b {
        AbstractC1048s abstractC1048s = this.f4080h;
        if (abstractC1048s == null) {
            super.mo3040s(abstractC0718i, objArr);
            throw null;
        }
        try {
            return abstractC1048s.mo2788p(objArr);
        } catch (Exception e3) {
            abstractC0718i.m1859x(this.f4078f, m3051G(abstractC0718i, e3));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: t */
    public final Object mo3068t(AbstractC0718i abstractC0718i, String str) throws C0850b {
        AbstractC1048s abstractC1048s = this.f4088p;
        if (abstractC1048s == null) {
            super.mo3068t(abstractC0718i, str);
            throw null;
        }
        try {
            return abstractC1048s.mo2789q(str);
        } catch (Exception e3) {
            abstractC0718i.m1859x(this.f4088p.mo2770i(), m3051G(abstractC0718i, e3));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: u */
    public final Object mo3069u(AbstractC0718i abstractC0718i, Object obj) {
        AbstractC1048s abstractC1048s = this.f4086n;
        return (abstractC1048s != null || this.f4083k == null) ? m3050F(abstractC1048s, this.f4087o, abstractC0718i, obj) : mo3071x(abstractC0718i, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: v */
    public final Object mo3007v(AbstractC0718i abstractC0718i) throws C0850b {
        AbstractC1048s abstractC1048s = this.f4079g;
        if (abstractC1048s == null) {
            super.mo3007v(abstractC0718i);
            throw null;
        }
        try {
            return abstractC1048s.mo2787o();
        } catch (Exception e3) {
            abstractC0718i.m1859x(this.f4078f, m3051G(abstractC0718i, e3));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: w */
    public final Object mo3070w(AbstractC0718i abstractC0718i) throws C0850b {
        if (this.f4079g != null) {
            return mo3007v(abstractC0718i);
        }
        if (this.f4080h != null) {
            return mo3040s(abstractC0718i, new Object[this.f4081i.length]);
        }
        super.mo3070w(abstractC0718i);
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: x */
    public final Object mo3071x(AbstractC0718i abstractC0718i, Object obj) {
        AbstractC1048s abstractC1048s;
        AbstractC1048s abstractC1048s2 = this.f4083k;
        return (abstractC1048s2 != null || (abstractC1048s = this.f4086n) == null) ? m3050F(abstractC1048s2, this.f4084l, abstractC0718i, obj) : m3050F(abstractC1048s, this.f4087o, abstractC0718i, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: y */
    public final AbstractC1048s mo3072y() {
        return this.f4086n;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: z */
    public final AbstractC0721l mo3073z() {
        return this.f4085m;
    }
}
