package p008B2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.C2093e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.D */
/* JADX INFO: loaded from: classes.dex */
public final class C0064D implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0064D f215a = new C0064D();

    /* JADX INFO: renamed from: b */
    public static final C0101h0 f216b = new C0101h0("kotlin.Float", C2093e.f7401g);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        float fFloatValue = ((Number) obj).floatValue();
        AbstractC1766e.m3920e("encoder", c0198v);
        c0198v.m356h(fFloatValue);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        return Float.valueOf(interfaceC0025b.mo102x());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f216b;
    }
}
