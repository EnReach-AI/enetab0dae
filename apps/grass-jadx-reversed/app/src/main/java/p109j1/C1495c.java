package p109j1;

import java.math.BigDecimal;
import java.math.BigInteger;
import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p069X0.AbstractC0709K;

/* JADX INFO: renamed from: j1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1495c extends AbstractC1513u {

    /* JADX INFO: renamed from: f */
    public static final BigInteger f5425f = BigInteger.valueOf(-2147483648L);

    /* JADX INFO: renamed from: g */
    public static final BigInteger f5426g = BigInteger.valueOf(2147483647L);

    /* JADX INFO: renamed from: h */
    public static final BigInteger f5427h = BigInteger.valueOf(Long.MIN_VALUE);

    /* JADX INFO: renamed from: i */
    public static final BigInteger f5428i = BigInteger.valueOf(Long.MAX_VALUE);

    /* JADX INFO: renamed from: e */
    public final BigInteger f5429e;

    public C1495c(BigInteger bigInteger) {
        this.f5429e = bigInteger;
    }

    @Override // p109j1.AbstractC1494b, p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: a */
    public final EnumC0544l mo1239a() {
        return EnumC0544l.f1300g;
    }

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return EnumC0548p.VALUE_NUMBER_INT;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1153z(this.f5429e);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: e */
    public final String mo1897e() {
        return this.f5429e.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof C1495c)) {
            return ((C1495c) obj).f5429e.equals(this.f5429e);
        }
        return false;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: f */
    public final BigInteger mo1898f() {
        return this.f5429e;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: h */
    public final BigDecimal mo1900h() {
        return new BigDecimal(this.f5429e);
    }

    public final int hashCode() {
        return this.f5429e.hashCode();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: i */
    public final double mo1901i() {
        return this.f5429e.doubleValue();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: n */
    public final Number mo1906n() {
        return this.f5429e;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: p */
    public final boolean mo3543p() {
        BigInteger bigInteger = f5425f;
        BigInteger bigInteger2 = this.f5429e;
        return bigInteger2.compareTo(bigInteger) >= 0 && bigInteger2.compareTo(f5426g) <= 0;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: q */
    public final boolean mo3544q() {
        BigInteger bigInteger = f5427h;
        BigInteger bigInteger2 = this.f5429e;
        return bigInteger2.compareTo(bigInteger) >= 0 && bigInteger2.compareTo(f5428i) <= 0;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: r */
    public final int mo3545r() {
        return this.f5429e.intValue();
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: t */
    public final long mo3546t() {
        return this.f5429e.longValue();
    }
}
