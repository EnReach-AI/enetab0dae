package p008B2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.C2093e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.K */
/* JADX INFO: loaded from: classes.dex */
public final class C0071K implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0071K f231a = new C0071K();

    /* JADX INFO: renamed from: b */
    public static final C0101h0 f232b = new C0101h0("kotlin.Int", C2093e.f7402h);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        int iIntValue = ((Number) obj).intValue();
        AbstractC1766e.m3920e("encoder", c0198v);
        c0198v.m359k(iIntValue);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        return Integer.valueOf(interfaceC0025b.mo93h());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f232b;
    }
}
