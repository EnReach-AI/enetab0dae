package p008B2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.C2093e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.o0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0115o0 implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0115o0 f310a = new C0115o0();

    /* JADX INFO: renamed from: b */
    public static final C0101h0 f311b = new C0101h0("kotlin.String", C2093e.f7405k);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        String str = (String) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", str);
        c0198v.m365q(str);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        return interfaceC0025b.mo101v();
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f311b;
    }
}
