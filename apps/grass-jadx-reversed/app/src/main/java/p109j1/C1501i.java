package p109j1;

import java.math.BigDecimal;
import java.math.BigInteger;
import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p050Q0.AbstractC0595h;
import p069X0.AbstractC0709K;

/* JADX INFO: renamed from: j1.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1501i extends AbstractC1513u {

    /* JADX INFO: renamed from: e */
    public final float f5442e;

    public C1501i(float f3) {
        this.f5442e = f3;
    }

    @Override // p109j1.AbstractC1494b, p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: a */
    public final EnumC0544l mo1239a() {
        return EnumC0544l.f1301h;
    }

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return EnumC0548p.VALUE_NUMBER_FLOAT;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1148u(this.f5442e);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: e */
    public final String mo1897e() {
        String str = AbstractC0595h.f1524a;
        return Float.toString(this.f5442e);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof C1501i)) {
            return Float.compare(this.f5442e, ((C1501i) obj).f5442e) == 0;
        }
        return false;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: f */
    public final BigInteger mo1898f() {
        return mo1900h().toBigInteger();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: h */
    public final BigDecimal mo1900h() {
        return BigDecimal.valueOf(this.f5442e);
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f5442e);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: i */
    public final double mo1901i() {
        return this.f5442e;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: n */
    public final Number mo1906n() {
        return Float.valueOf(this.f5442e);
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: p */
    public final boolean mo3543p() {
        float f3 = this.f5442e;
        return f3 >= -2.1474836E9f && f3 <= 2.1474836E9f;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: q */
    public final boolean mo3544q() {
        float f3 = this.f5442e;
        return f3 >= -9.223372E18f && f3 <= 9.223372E18f;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: r */
    public final int mo3545r() {
        return (int) this.f5442e;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: s */
    public final boolean mo3547s() {
        float f3 = this.f5442e;
        return Float.isNaN(f3) || Float.isInfinite(f3);
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: t */
    public final long mo3546t() {
        return (long) this.f5442e;
    }
}
