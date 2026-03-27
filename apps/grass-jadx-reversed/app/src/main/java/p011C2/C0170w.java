package p011C2;

import java.util.Map;
import p004A2.InterfaceC0025b;
import p008B2.C0066F;
import p008B2.C0115o0;
import p015D2.C0198v;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1800j;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: C2.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0170w implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0170w f405a = new C0170w();

    /* JADX INFO: renamed from: b */
    public static final C0169v f406b = C0169v.f402b;

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        C0168u c0168u = (C0168u) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", c0168u);
        AbstractC1800j.m3984b(c0198v);
        C0115o0 c0115o0 = C0115o0.f310a;
        C0160m c0160m = C0160m.f390a;
        new C0066F(C0115o0.f310a, C0160m.f390a, 1).mo219a(c0198v, c0168u);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        AbstractC1800j.m3986d(interfaceC0025b);
        C0115o0 c0115o0 = C0115o0.f310a;
        C0160m c0160m = C0160m.f390a;
        return new C0168u((Map) new C0066F(C0115o0.f310a, C0160m.f390a, 1).mo220b(interfaceC0025b));
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f406b;
    }
}
