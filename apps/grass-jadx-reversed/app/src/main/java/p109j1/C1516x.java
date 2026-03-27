package p109j1;

import p005B.AbstractC0032g;
import p042N0.AbstractC0534b;
import p042N0.AbstractC0540h;
import p042N0.C0533a;
import p042N0.EnumC0548p;
import p066W0.C0674a;
import p066W0.C0676c;
import p069X0.AbstractC0709K;
import p078a1.C0851c;

/* JADX INFO: renamed from: j1.x */
/* JADX INFO: loaded from: classes.dex */
public final class C1516x extends AbstractC1518z {

    /* JADX INFO: renamed from: f */
    public static final C1516x f5466f = new C1516x("");
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public final String f5467e;

    public C1516x(String str) {
        this.f5467e = str;
    }

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return EnumC0548p.VALUE_STRING;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        String str = this.f5467e;
        if (str == null) {
            abstractC0540h.mo1146s();
        } else {
            abstractC0540h.mo1125R(str);
        }
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: e */
    public final String mo1897e() {
        return this.f5467e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof C1516x)) {
            return ((C1516x) obj).f5467e.equals(this.f5467e);
        }
        return false;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: g */
    public final byte[] mo1899g() {
        return m3560p(AbstractC0534b.f1228b);
    }

    public final int hashCode() {
        return this.f5467e.hashCode();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: m */
    public final int mo1905m() {
        return 9;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: o */
    public final String mo1907o() {
        return this.f5467e;
    }

    /* JADX INFO: renamed from: p */
    public final byte[] m3560p(C0533a c0533a) throws C0851c {
        String strTrim = this.f5467e.trim();
        C0676c c0676c = new C0676c((C0674a) null, Math.max(16, Math.min(65536, ((strTrim.length() >> 2) * 3) + 4)));
        try {
            c0533a.m1072b(strTrim, c0676c);
            return c0676c.m1639f();
        } catch (IllegalArgumentException e3) {
            throw new C0851c(null, AbstractC0032g.m152j("Cannot access contents of TextNode as binary due to broken Base64 encoding: ", e3.getMessage()), strTrim);
        }
    }
}
