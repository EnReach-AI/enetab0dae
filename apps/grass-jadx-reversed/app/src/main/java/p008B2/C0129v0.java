package p008B2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p083b2.C1070o;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.v0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0129v0 implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0129v0 f332a = new C0129v0();

    /* JADX INFO: renamed from: b */
    public static final C0067G f333b = AbstractC0089b0.m254a("kotlin.UInt", C0071K.f231a);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        int i3 = ((C1070o) obj).f3754e;
        AbstractC1766e.m3920e("encoder", c0198v);
        c0198v.m357i(f333b).m359k(i3);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        return new C1070o(interfaceC0025b.mo99s(f333b).mo93h());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f333b;
    }
}
