package p069X0;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import p042N0.InterfaceC0557y;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: X0.p */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0725p extends AbstractC0726q implements InterfaceC0557y, Iterable {
    /* JADX INFO: renamed from: e */
    public abstract String mo1897e();

    /* JADX INFO: renamed from: f */
    public BigInteger mo1898f() {
        return BigInteger.ZERO;
    }

    /* JADX INFO: renamed from: g */
    public byte[] mo1899g() {
        return null;
    }

    /* JADX INFO: renamed from: h */
    public BigDecimal mo1900h() {
        return BigDecimal.ZERO;
    }

    /* JADX INFO: renamed from: i */
    public double mo1901i() {
        return 0.0d;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return mo1902j();
    }

    /* JADX INFO: renamed from: j */
    public Iterator mo1902j() {
        return AbstractC1745j.f6112c;
    }

    /* JADX INFO: renamed from: k */
    public Iterator mo1903k() {
        return AbstractC1745j.f6112c;
    }

    /* JADX INFO: renamed from: l */
    public abstract AbstractC0725p mo1904l(String str);

    /* JADX INFO: renamed from: m */
    public abstract int mo1905m();

    /* JADX INFO: renamed from: n */
    public Number mo1906n() {
        return null;
    }

    /* JADX INFO: renamed from: o */
    public String mo1907o() {
        return null;
    }
}
