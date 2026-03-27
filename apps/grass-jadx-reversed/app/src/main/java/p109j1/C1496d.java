package p109j1;

import java.util.Arrays;
import p042N0.AbstractC0534b;
import p042N0.AbstractC0540h;
import p042N0.C0533a;
import p042N0.EnumC0548p;
import p069X0.AbstractC0709K;

/* JADX INFO: renamed from: j1.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1496d extends AbstractC1518z {

    /* JADX INFO: renamed from: f */
    public static final C1496d f5430f = new C1496d(new byte[0]);
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public final byte[] f5431e;

    public C1496d(byte[] bArr) {
        this.f5431e = bArr;
    }

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return EnumC0548p.VALUE_EMBEDDED_OBJECT;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        C0533a c0533a = abstractC0709K.f1966e.f2481f.f2429o;
        byte[] bArr = this.f5431e;
        abstractC0540h.mo1139l(c0533a, bArr, 0, bArr.length);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: e */
    public final String mo1897e() {
        return AbstractC0534b.f1228b.m1075e(this.f5431e);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof C1496d)) {
            return Arrays.equals(((C1496d) obj).f5431e, this.f5431e);
        }
        return false;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: g */
    public final byte[] mo1899g() {
        return this.f5431e;
    }

    public final int hashCode() {
        byte[] bArr = this.f5431e;
        if (bArr == null) {
            return -1;
        }
        return bArr.length;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: m */
    public final int mo1905m() {
        return 2;
    }
}
