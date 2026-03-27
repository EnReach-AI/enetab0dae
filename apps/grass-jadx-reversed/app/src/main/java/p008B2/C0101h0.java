package p008B2;

import java.util.List;
import p039M0.AbstractC0493h0;
import p086c2.C1093l;
import p119m2.AbstractC1766e;
import p167z2.AbstractC2094f;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.h0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0101h0 implements InterfaceC2095g {

    /* JADX INFO: renamed from: a */
    public final String f288a;

    /* JADX INFO: renamed from: b */
    public final AbstractC2094f f289b;

    public C0101h0(String str, AbstractC2094f abstractC2094f) {
        AbstractC1766e.m3920e("kind", abstractC2094f);
        this.f288a = str;
        this.f289b = abstractC2094f;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: a */
    public final String mo230a(int i3) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
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
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: d */
    public final String mo233d() {
        return this.f288a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0101h0)) {
            return false;
        }
        C0101h0 c0101h0 = (C0101h0) obj;
        if (AbstractC1766e.m3916a(this.f288a, c0101h0.f288a)) {
            if (AbstractC1766e.m3916a(this.f289b, c0101h0.f289b)) {
                return true;
            }
        }
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: f */
    public final boolean mo234f() {
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: g */
    public final List mo235g(int i3) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: h */
    public final InterfaceC2095g mo236h(int i3) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final int hashCode() {
        return (this.f289b.hashCode() * 31) + this.f288a.hashCode();
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: i */
    public final AbstractC0493h0 mo237i() {
        return this.f289b;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: j */
    public final boolean mo238j(int i3) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: k */
    public final List mo239k() {
        return C1093l.f3782e;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: l */
    public final int mo240l() {
        return 0;
    }

    public final String toString() {
        return "PrimitiveDescriptor(" + this.f288a + ')';
    }
}
