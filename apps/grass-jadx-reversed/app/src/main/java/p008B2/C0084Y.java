package p008B2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.Y */
/* JADX INFO: loaded from: classes.dex */
public final class C0084Y implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2012a f254a;

    /* JADX INFO: renamed from: b */
    public final C0107k0 f255b;

    public C0084Y(InterfaceC2012a interfaceC2012a) {
        this.f254a = interfaceC2012a;
        this.f255b = new C0107k0(interfaceC2012a.mo221c());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        AbstractC1766e.m3920e("encoder", c0198v);
        if (obj != null) {
            c0198v.m363o(this.f254a, obj);
        } else {
            c0198v.m361m();
        }
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        if (interfaceC0025b.mo95j()) {
            return interfaceC0025b.mo96k(this.f254a);
        }
        return null;
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return this.f255b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0084Y.class == obj.getClass() && AbstractC1766e.m3916a(this.f254a, ((C0084Y) obj).f254a);
    }

    public final int hashCode() {
        return this.f254a.hashCode();
    }
}
