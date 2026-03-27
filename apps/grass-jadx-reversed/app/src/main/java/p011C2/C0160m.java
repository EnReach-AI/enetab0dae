package p011C2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p039M0.AbstractC0473V;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1800j;
import p161x2.InterfaceC2012a;
import p167z2.C2091c;
import p167z2.C2096h;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: C2.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0160m implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0160m f390a = new C0160m();

    /* JADX INFO: renamed from: b */
    public static final C2096h f391b = AbstractC0473V.m993E("kotlinx.serialization.json.JsonElement", C2091c.f7396d, new InterfaceC2095g[0], C0159l.f387g);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        AbstractC0156i abstractC0156i = (AbstractC0156i) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", abstractC0156i);
        AbstractC1800j.m3984b(c0198v);
        if (abstractC0156i instanceof AbstractC0172y) {
            c0198v.m363o(C0173z.f407a, abstractC0156i);
        } else if (abstractC0156i instanceof C0168u) {
            c0198v.m363o(C0170w.f405a, abstractC0156i);
        } else if (abstractC0156i instanceof C0150c) {
            c0198v.m363o(C0152e.f364a, abstractC0156i);
        }
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        return AbstractC1800j.m3986d(interfaceC0025b).m347M();
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f391b;
    }
}
