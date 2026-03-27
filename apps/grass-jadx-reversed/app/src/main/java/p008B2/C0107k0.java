package p008B2;

import java.util.List;
import java.util.Set;
import p039M0.AbstractC0493h0;
import p119m2.AbstractC1766e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.k0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0107k0 implements InterfaceC2095g, InterfaceC0106k {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2095g f296a;

    /* JADX INFO: renamed from: b */
    public final String f297b;

    /* JADX INFO: renamed from: c */
    public final Set f298c;

    public C0107k0(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("original", interfaceC2095g);
        this.f296a = interfaceC2095g;
        this.f297b = interfaceC2095g.mo233d() + '?';
        this.f298c = AbstractC0089b0.m255b(interfaceC2095g);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: a */
    public final String mo230a(int i3) {
        return this.f296a.mo230a(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: b */
    public final boolean mo231b() {
        return this.f296a.mo231b();
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: c */
    public final int mo232c(String str) {
        AbstractC1766e.m3920e("name", str);
        return this.f296a.mo232c(str);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: d */
    public final String mo233d() {
        return this.f297b;
    }

    @Override // p008B2.InterfaceC0106k
    /* JADX INFO: renamed from: e */
    public final Set mo264e() {
        return this.f298c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0107k0) {
            return AbstractC1766e.m3916a(this.f296a, ((C0107k0) obj).f296a);
        }
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: f */
    public final boolean mo234f() {
        return true;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: g */
    public final List mo235g(int i3) {
        return this.f296a.mo235g(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: h */
    public final InterfaceC2095g mo236h(int i3) {
        return this.f296a.mo236h(i3);
    }

    public final int hashCode() {
        return this.f296a.hashCode() * 31;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: i */
    public final AbstractC0493h0 mo237i() {
        return this.f296a.mo237i();
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: j */
    public final boolean mo238j(int i3) {
        return this.f296a.mo238j(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: k */
    public final List mo239k() {
        return this.f296a.mo239k();
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: l */
    public final int mo240l() {
        return this.f296a.mo240l();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f296a);
        sb.append('?');
        return sb.toString();
    }
}
