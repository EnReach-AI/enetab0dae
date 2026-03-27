package p109j1;

import java.math.BigDecimal;
import java.math.BigInteger;
import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p050Q0.AbstractC0595h;
import p069X0.AbstractC0709K;

/* JADX INFO: renamed from: j1.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1500h extends AbstractC1513u {

    /* JADX INFO: renamed from: e */
    public final double f5441e;

    public C1500h(double d) {
        this.f5441e = d;
    }

    @Override // p109j1.AbstractC1494b, p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: a */
    public final EnumC0544l mo1239a() {
        return EnumC0544l.f1302i;
    }

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return EnumC0548p.VALUE_NUMBER_FLOAT;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1147t(this.f5441e);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: e */
    public final String mo1897e() {
        String str = AbstractC0595h.f1524a;
        return Double.toString(this.f5441e);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof C1500h)) {
            return Double.compare(this.f5441e, ((C1500h) obj).f5441e) == 0;
        }
        return false;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: f */
    public final BigInteger mo1898f() {
        return BigDecimal.valueOf(this.f5441e).toBigInteger();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: h */
    public final BigDecimal mo1900h() {
        return BigDecimal.valueOf(this.f5441e);
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f5441e);
        return ((int) (jDoubleToLongBits >> 32)) ^ ((int) jDoubleToLongBits);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: i */
    public final double mo1901i() {
        return this.f5441e;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: n */
    public final Number mo1906n() {
        return Double.valueOf(this.f5441e);
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: p */
    public final boolean mo3543p() {
        double d = this.f5441e;
        return d >= -2.147483648E9d && d <= 2.147483647E9d;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: q */
    public final boolean mo3544q() {
        double d = this.f5441e;
        return d >= -9.223372036854776E18d && d <= 9.223372036854776E18d;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: r */
    public final int mo3545r() {
        return (int) this.f5441e;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: s */
    public final boolean mo3547s() {
        double d = this.f5441e;
        return Double.isNaN(d) || Double.isInfinite(d);
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: t */
    public final long mo3546t() {
        return (long) this.f5441e;
    }
}
