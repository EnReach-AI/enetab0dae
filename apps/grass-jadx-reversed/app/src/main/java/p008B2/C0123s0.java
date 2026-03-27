package p008B2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p083b2.C1067l;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.s0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0123s0 implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0123s0 f322a = new C0123s0();

    /* JADX INFO: renamed from: b */
    public static final C0067G f323b = AbstractC0089b0.m254a("kotlin.UByte", C0102i.f290a);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        byte b3 = ((C1067l) obj).f3749e;
        AbstractC1766e.m3920e("encoder", c0198v);
        c0198v.m357i(f323b).m351c(b3);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        return new C1067l(interfaceC0025b.mo99s(f323b).mo98r());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f323b;
    }
}
