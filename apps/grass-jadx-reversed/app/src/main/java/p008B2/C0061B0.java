package p008B2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p083b2.C1075t;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.B0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0061B0 implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0061B0 f210a = new C0061B0();

    /* JADX INFO: renamed from: b */
    public static final C0067G f211b = AbstractC0089b0.m254a("kotlin.UShort", C0113n0.f306a);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        short s3 = ((C1075t) obj).f3759e;
        AbstractC1766e.m3920e("encoder", c0198v);
        c0198v.m357i(f211b).m364p(s3);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        return new C1075t(interfaceC0025b.mo99s(f211b).mo100u());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f211b;
    }
}
