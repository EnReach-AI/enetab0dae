package p167z2;

import java.util.List;
import p039M0.AbstractC0493h0;
import p119m2.AbstractC1766e;
import p119m2.C1763b;
import p135q2.InterfaceC1840a;

/* JADX INFO: renamed from: z2.b */
/* JADX INFO: loaded from: classes.dex */
public final class C2090b implements InterfaceC2095g {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2095g f7392a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1840a f7393b;

    /* JADX INFO: renamed from: c */
    public final String f7394c;

    public C2090b(C2096h c2096h, InterfaceC1840a interfaceC1840a) {
        AbstractC1766e.m3920e("kClass", interfaceC1840a);
        this.f7392a = c2096h;
        this.f7393b = interfaceC1840a;
        this.f7394c = c2096h.f7406a + '<' + ((C1763b) interfaceC1840a).m3915b() + '>';
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: a */
    public final String mo230a(int i3) {
        return this.f7392a.mo230a(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: b */
    public final boolean mo231b() {
        return this.f7392a.mo231b();
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: c */
    public final int mo232c(String str) {
        AbstractC1766e.m3920e("name", str);
        return this.f7392a.mo232c(str);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: d */
    public final String mo233d() {
        return this.f7394c;
    }

    public final boolean equals(Object obj) {
        C2090b c2090b = obj instanceof C2090b ? (C2090b) obj : null;
        return c2090b != null && AbstractC1766e.m3916a(this.f7392a, c2090b.f7392a) && AbstractC1766e.m3916a(c2090b.f7393b, this.f7393b);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: f */
    public final boolean mo234f() {
        return this.f7392a.mo234f();
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: g */
    public final List mo235g(int i3) {
        return this.f7392a.mo235g(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: h */
    public final InterfaceC2095g mo236h(int i3) {
        return this.f7392a.mo236h(i3);
    }

    public final int hashCode() {
        return this.f7394c.hashCode() + (this.f7393b.hashCode() * 31);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: i */
    public final AbstractC0493h0 mo237i() {
        return this.f7392a.mo237i();
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: j */
    public final boolean mo238j(int i3) {
        return this.f7392a.mo238j(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: k */
    public final List mo239k() {
        return this.f7392a.mo239k();
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: l */
    public final int mo240l() {
        return this.f7392a.mo240l();
    }

    public final String toString() {
        return "ContextDescriptor(kClass: " + this.f7393b + ", original: " + this.f7392a + ')';
    }
}
