package p109j1;

import com.fasterxml.jackson.core.exc.C1131b;
import java.math.BigDecimal;
import java.math.BigInteger;
import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p069X0.AbstractC0709K;

/* JADX INFO: renamed from: j1.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1499g extends AbstractC1513u {

    /* JADX INFO: renamed from: f */
    public static final BigDecimal f5436f;

    /* JADX INFO: renamed from: g */
    public static final BigDecimal f5437g;

    /* JADX INFO: renamed from: h */
    public static final BigDecimal f5438h;

    /* JADX INFO: renamed from: i */
    public static final BigDecimal f5439i;

    /* JADX INFO: renamed from: e */
    public final BigDecimal f5440e;

    static {
        new C1499g(BigDecimal.ZERO);
        f5436f = BigDecimal.valueOf(-2147483648L);
        f5437g = BigDecimal.valueOf(2147483647L);
        f5438h = BigDecimal.valueOf(Long.MIN_VALUE);
        f5439i = BigDecimal.valueOf(Long.MAX_VALUE);
    }

    public C1499g(BigDecimal bigDecimal) {
        this.f5440e = bigDecimal;
    }

    @Override // p109j1.AbstractC1494b, p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: a */
    public final EnumC0544l mo1239a() {
        return EnumC0544l.f1303j;
    }

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return EnumC0548p.VALUE_NUMBER_FLOAT;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1152y(this.f5440e);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: e */
    public final String mo1897e() {
        return this.f5440e.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof C1499g) && ((C1499g) obj).f5440e.compareTo(this.f5440e) == 0;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: f */
    public final BigInteger mo1898f() throws C1131b {
        BigDecimal bigDecimal = this.f5440e;
        int iScale = bigDecimal.scale();
        if (Math.abs(iScale) <= 100000) {
            return bigDecimal.toBigInteger();
        }
        throw new C1131b(String.format("BigDecimal scale (%d) magnitude exceeds maximum allowed (%d)", Integer.valueOf(iScale), 100000));
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: h */
    public final BigDecimal mo1900h() {
        return this.f5440e;
    }

    public final int hashCode() {
        return Double.valueOf(this.f5440e.doubleValue()).hashCode();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: i */
    public final double mo1901i() {
        return this.f5440e.doubleValue();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: n */
    public final Number mo1906n() {
        return this.f5440e;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: p */
    public final boolean mo3543p() {
        BigDecimal bigDecimal = f5436f;
        BigDecimal bigDecimal2 = this.f5440e;
        return bigDecimal2.compareTo(bigDecimal) >= 0 && bigDecimal2.compareTo(f5437g) <= 0;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: q */
    public final boolean mo3544q() {
        BigDecimal bigDecimal = f5438h;
        BigDecimal bigDecimal2 = this.f5440e;
        return bigDecimal2.compareTo(bigDecimal) >= 0 && bigDecimal2.compareTo(f5439i) <= 0;
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: r */
    public final int mo3545r() {
        return this.f5440e.intValue();
    }

    @Override // p109j1.AbstractC1513u
    /* JADX INFO: renamed from: t */
    public final long mo3546t() {
        return this.f5440e.longValue();
    }
}
