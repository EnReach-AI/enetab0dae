package p109j1;

import java.math.BigDecimal;
import java.math.BigInteger;
import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p050Q0.AbstractC0595h;
import p069X0.AbstractC0709K;

/* JADX INFO: renamed from: j1.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1506n extends AbstractC1513u {

    /* JADX INFO: renamed from: e */
    public final long f5451e;

    public C1506n(long j2) {
        this.f5451e = j2;
    }

    @Override // p109j1.AbstractC1494b, p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: a */
    public final EnumC0544l mo1239a() {
        return EnumC0544l.f1299f;
    }

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return EnumC0548p.VALUE_NUMBER_INT;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1150w(this.f5451e);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: e */
    public final String mo1897e() {
        String str = AbstractC0595h.f1524a;
        long j2 = this.f5451e;
        if (j2 > 2147483647L || j2 < -2147483648L) {
            return Long.toString(j2);
        }
        int i3 = (int) j2;
        String[] strArr = AbstractC0595h.f1527d;
        if (i3 < strArr.length) {
            if (i3 >= 0) {
                return strArr[i3];
            }
            int i4 = (-i3) - 1;
            String[] strArr2 = AbstractC0595h.f1528e;
            if (i4 < strArr2.length) {
                return strArr2[i4];
            }
        }
        return Integer.toString(i3);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof C1506n) && ((C1506n) obj).f5451e == this.f5451e;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: f */
    public final BigInteger mo1898f() {
        return BigInteger.valueOf(this.f5451e);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: h */
    public final BigDecimal mo1900h() {
        return BigDecimal.valueOf(this.f5451e);
    }

    public final int hashCode() {
        long j2 = this.f5451e;
        return ((int) (j2 >> 32)) ^ ((int) j2);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: i */
    public final double mo1901i() {
        return this.f5451e;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: n */
    public final Number mo1906n() {
        return Long.valueOf(this.f5451e);
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: p */
    public final boolean mo3543p() {
        long j2 = this.f5451e;
        return j2 >= -2147483648L && j2 <= 2147483647L;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: q */
    public final boolean mo3544q() {
        return true;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: r */
    public final int mo3545r() {
        return (int) this.f5451e;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: t */
    public final long mo3546t() {
        return this.f5451e;
    }
}
