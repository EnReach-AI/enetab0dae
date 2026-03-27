package p109j1;

import com.fasterxml.jackson.core.exc.C1130a;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.math.BigDecimal;
import java.math.BigInteger;
import p042N0.AbstractC0545m;
import p042N0.AbstractC0547o;
import p042N0.AbstractC0549q;
import p042N0.C0533a;
import p042N0.C0541i;
import p042N0.C0542j;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p045O0.AbstractC0571c;
import p066W0.AbstractC0692s;
import p066W0.C0684k;
import p069X0.AbstractC0725p;
import p118m1.C1742g;

/* JADX INFO: renamed from: j1.y */
/* JADX INFO: loaded from: classes.dex */
public final class C1517y extends AbstractC0571c {

    /* JADX INFO: renamed from: q */
    public final AbstractC0549q f5468q;

    /* JADX INFO: renamed from: r */
    public AbstractC1510r f5469r;

    /* JADX INFO: renamed from: s */
    public boolean f5470s;

    public C1517y(AbstractC0725p abstractC0725p, AbstractC0549q abstractC0549q) {
        super(0);
        this.f5468q = abstractC0549q;
        C1509q c1509q = new C1509q(0, null);
        c1509q.f5458h = false;
        c1509q.f5457g = abstractC0725p;
        this.f5469r = c1509q;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: B */
    public final String mo1157B() {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == null) {
            return null;
        }
        switch (enumC0548p.ordinal()) {
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return this.f5469r.f5460e;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                AbstractC0725p abstractC0725pM3561u0 = m3561u0();
                if (abstractC0725pM3561u0 != null && abstractC0725pM3561u0.mo1905m() == 2) {
                    return abstractC0725pM3561u0.mo1897e();
                }
                break;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return m3561u0().mo1907o();
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                return String.valueOf(m3561u0().mo1906n());
        }
        return this.f1423g.f1325e;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: C */
    public final char[] mo1158C() {
        return mo1157B().toCharArray();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: D */
    public final int mo1159D() {
        return mo1157B().length();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: E */
    public final int mo1160E() {
        return 0;
    }

    @Override // p045O0.AbstractC0571c, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: F */
    public final C0541i mo1161F() {
        return C0541i.f1269k;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: L */
    public final boolean mo1167L() {
        return false;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: S */
    public final boolean mo1174S() {
        if (this.f5470s) {
            return false;
        }
        AbstractC0725p abstractC0725pM3561u0 = m3561u0();
        if (abstractC0725pM3561u0 instanceof AbstractC1513u) {
            return ((AbstractC1513u) abstractC0725pM3561u0).mo3547s();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: V */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p042N0.EnumC0548p mo1177V() {
        /*
            r2 = this;
            j1.r r0 = r2.f5469r
            N0.p r0 = r0.mo3553j()
            r2.f1423g = r0
            r1 = 1
            if (r0 != 0) goto Lf
            r2.f5470s = r1
            r0 = 0
            return r0
        Lf:
            int r0 = r0.ordinal()
            if (r0 == r1) goto L2f
            r1 = 2
            if (r0 == r1) goto L28
            r1 = 3
            if (r0 == r1) goto L1f
            r1 = 4
            if (r0 == r1) goto L28
            goto L37
        L1f:
            j1.r r0 = r2.f5469r
            j1.o r0 = r0.mo3554k()
            r2.f5469r = r0
            goto L37
        L28:
            j1.r r0 = r2.f5469r
            j1.r r0 = r0.f5459d
            r2.f5469r = r0
            goto L37
        L2f:
            j1.r r0 = r2.f5469r
            j1.p r0 = r0.mo3555l()
            r2.f5469r = r0
        L37:
            N0.p r0 = r2.f1423g
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p109j1.C1517y.mo1177V():N0.p");
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: Y */
    public final int mo1180Y(C0533a c0533a, C1742g c1742g) {
        byte[] bArrMo1193h = mo1193h(c0533a);
        if (bArrMo1193h == null) {
            return 0;
        }
        c1742g.write(bArrMo1193h, 0, bArrMo1193h.length);
        return bArrMo1193h.length;
    }

    @Override // p045O0.AbstractC0571c, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: c0 */
    public final AbstractC0545m mo1187c0() {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == EnumC0548p.START_OBJECT) {
            this.f5469r = this.f5469r.f5459d;
            this.f1423g = EnumC0548p.END_OBJECT;
        } else if (enumC0548p == EnumC0548p.START_ARRAY) {
            this.f5469r = this.f5469r.f5459d;
            this.f1423g = EnumC0548p.END_ARRAY;
        }
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f5470s) {
            return;
        }
        this.f5470s = true;
        this.f5469r = null;
        this.f1423g = null;
    }

    @Override // p045O0.AbstractC0571c
    /* JADX INFO: renamed from: f0 */
    public final void mo1269f0() {
        AbstractC0692s.m1666a();
        throw null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: g */
    public final BigInteger mo1192g() {
        return m3562v0().mo1898f();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: h */
    public final byte[] mo1193h(C0533a c0533a) {
        AbstractC0725p abstractC0725pM3561u0 = m3561u0();
        if (abstractC0725pM3561u0 != null) {
            return abstractC0725pM3561u0 instanceof C1516x ? ((C1516x) abstractC0725pM3561u0).m3560p(c0533a) : abstractC0725pM3561u0.mo1899g();
        }
        return null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: k */
    public final AbstractC0549q mo1196k() {
        return this.f5468q;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: l */
    public final C0541i mo1197l() {
        return C0541i.f1269k;
    }

    @Override // p045O0.AbstractC0571c, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: m */
    public final String mo1198m() {
        AbstractC1510r abstractC1510r = this.f5469r;
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == EnumC0548p.START_OBJECT || enumC0548p == EnumC0548p.START_ARRAY) {
            abstractC1510r = abstractC1510r.f5459d;
        }
        if (abstractC1510r == null) {
            return null;
        }
        return abstractC1510r.f5460e;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: o */
    public final BigDecimal mo1200o() {
        return m3562v0().mo1900h();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: p */
    public final double mo1201p() {
        return m3562v0().mo1901i();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: q */
    public final Object mo1202q() {
        AbstractC0725p abstractC0725pM3561u0;
        if (this.f5470s || (abstractC0725pM3561u0 = m3561u0()) == null) {
            return null;
        }
        if (abstractC0725pM3561u0.mo1905m() == 8) {
            return ((C1515w) abstractC0725pM3561u0).f5465e;
        }
        if (abstractC0725pM3561u0.mo1905m() == 2) {
            return ((C1496d) abstractC0725pM3561u0).f5431e;
        }
        return null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: r */
    public final float mo1203r() {
        return (float) m3562v0().mo1901i();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: s */
    public final int mo1204s() throws C1130a {
        AbstractC1513u abstractC1513u = (AbstractC1513u) m3562v0();
        if (abstractC1513u.mo3543p()) {
            return abstractC1513u.mo3545r();
        }
        m1288r0();
        throw null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: t */
    public final long mo1205t() throws C1130a {
        AbstractC1513u abstractC1513u = (AbstractC1513u) m3562v0();
        if (abstractC1513u.mo3544q()) {
            return abstractC1513u.mo3546t();
        }
        m1289s0();
        throw null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: u */
    public final EnumC0544l mo1206u() {
        return m3562v0().mo1239a();
    }

    /* JADX INFO: renamed from: u0 */
    public final AbstractC0725p m3561u0() {
        AbstractC1510r abstractC1510r;
        if (this.f5470s || (abstractC1510r = this.f5469r) == null) {
            return null;
        }
        return abstractC1510r.mo3552i();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: v */
    public final Number mo1207v() {
        return m3562v0().mo1906n();
    }

    /* JADX INFO: renamed from: v0 */
    public final AbstractC0725p m3562v0() throws C0542j {
        AbstractC0725p abstractC0725pM3561u0 = m3561u0();
        if (abstractC0725pM3561u0 != null && abstractC0725pM3561u0.mo1905m() == 6) {
            return abstractC0725pM3561u0;
        }
        throw new C0542j(this, "Current token (" + (abstractC0725pM3561u0 == null ? null : abstractC0725pM3561u0.mo1240b()) + ") not numeric, cannot use numeric value accessors");
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: y */
    public final AbstractC0547o mo1210y() {
        return this.f5469r;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: z */
    public final C0684k mo1211z() {
        return AbstractC0545m.f1305f;
    }
}
