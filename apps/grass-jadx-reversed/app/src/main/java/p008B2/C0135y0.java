package p008B2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p083b2.C1072q;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.y0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0135y0 implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0135y0 f347a = new C0135y0();

    /* JADX INFO: renamed from: b */
    public static final C0067G f348b = AbstractC0089b0.m254a("kotlin.ULong", C0076P.f239a);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        long j2 = ((C1072q) obj).f3756e;
        AbstractC1766e.m3920e("encoder", c0198v);
        c0198v.m357i(f348b).m360l(j2);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        return new C1072q(interfaceC0025b.mo99s(f348b).mo91c());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f348b;
    }
}
