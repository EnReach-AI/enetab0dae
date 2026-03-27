package p008B2;

import java.util.List;
import p005B.AbstractC0032g;
import p039M0.AbstractC0493h0;
import p086c2.C1093l;
import p119m2.AbstractC1766e;
import p142s2.AbstractC1899n;
import p167z2.C2100l;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.E */
/* JADX INFO: loaded from: classes.dex */
public final class C0065E implements InterfaceC2095g {

    /* JADX INFO: renamed from: a */
    public final String f217a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2095g f218b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g f219c;

    /* JADX INFO: renamed from: d */
    public final int f220d = 2;

    public C0065E(String str, InterfaceC2095g interfaceC2095g, InterfaceC2095g interfaceC2095g2) {
        this.f217a = str;
        this.f218b = interfaceC2095g;
        this.f219c = interfaceC2095g2;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: a */
    public final String mo230a(int i3) {
        return String.valueOf(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: b */
    public final boolean mo231b() {
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: c */
    public final int mo232c(String str) {
        AbstractC1766e.m3920e("name", str);
        Integer numM4229f = AbstractC1899n.m4229f(str);
        if (numM4229f != null) {
            return numM4229f.intValue();
        }
        throw new IllegalArgumentException(str.concat(" is not a valid map index"));
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: d */
    public final String mo233d() {
        return this.f217a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0065E)) {
            return false;
        }
        C0065E c0065e = (C0065E) obj;
        return AbstractC1766e.m3916a(this.f217a, c0065e.f217a) && AbstractC1766e.m3916a(this.f218b, c0065e.f218b) && AbstractC1766e.m3916a(this.f219c, c0065e.f219c);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: f */
    public final boolean mo234f() {
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: g */
    public final List mo235g(int i3) {
        if (i3 >= 0) {
            return C1093l.f3782e;
        }
        StringBuilder sb = new StringBuilder("Illegal index ");
        sb.append(i3);
        sb.append(", ");
        throw new IllegalArgumentException(AbstractC0032g.m157o(sb, this.f217a, " expects only non-negative indices").toString());
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: h */
    public final InterfaceC2095g mo236h(int i3) {
        if (i3 < 0) {
            StringBuilder sb = new StringBuilder("Illegal index ");
            sb.append(i3);
            sb.append(", ");
            throw new IllegalArgumentException(AbstractC0032g.m157o(sb, this.f217a, " expects only non-negative indices").toString());
        }
        int i4 = i3 % 2;
        if (i4 == 0) {
            return this.f218b;
        }
        if (i4 == 1) {
            return this.f219c;
        }
        throw new IllegalStateException("Unreached".toString());
    }

    public final int hashCode() {
        return this.f219c.hashCode() + ((this.f218b.hashCode() + (this.f217a.hashCode() * 31)) * 31);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: i */
    public final AbstractC0493h0 mo237i() {
        return C2100l.f7426e;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: j */
    public final boolean mo238j(int i3) {
        if (i3 >= 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder("Illegal index ");
        sb.append(i3);
        sb.append(", ");
        throw new IllegalArgumentException(AbstractC0032g.m157o(sb, this.f217a, " expects only non-negative indices").toString());
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: k */
    public final List mo239k() {
        return C1093l.f3782e;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: l */
    public final int mo240l() {
        return this.f220d;
    }

    public final String toString() {
        return this.f217a + '(' + this.f218b + ", " + this.f219c + ')';
    }
}
