package p011C2;

import p004A2.InterfaceC0025b;
import p015D2.C0186j;
import p015D2.C0198v;
import p039M0.AbstractC0473V;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1800j;
import p161x2.InterfaceC2012a;
import p167z2.C2098j;
import p167z2.C2099k;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: C2.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0166s implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0166s f399a = new C0166s();

    /* JADX INFO: renamed from: b */
    public static final InterfaceC2095g f400b = AbstractC0473V.m993E("kotlinx.serialization.json.JsonNull", C2099k.f7423d, new InterfaceC2095g[0], C2098j.f7421f);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", (C0165r) obj);
        AbstractC1800j.m3984b(c0198v);
        c0198v.m361m();
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        AbstractC1800j.m3986d(interfaceC0025b);
        if (interfaceC0025b.mo95j()) {
            throw new C0186j("Expected 'null' literal");
        }
        return C0165r.INSTANCE;
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f400b;
    }
}
