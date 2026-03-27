package p008B2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.C2093e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.n0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0113n0 implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0113n0 f306a = new C0113n0();

    /* JADX INFO: renamed from: b */
    public static final C0101h0 f307b = new C0101h0("kotlin.Short", C2093e.f7404j);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        short sShortValue = ((Number) obj).shortValue();
        AbstractC1766e.m3920e("encoder", c0198v);
        c0198v.m364p(sShortValue);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        return Short.valueOf(interfaceC0025b.mo100u());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f307b;
    }
}
