package p011C2;

import p004A2.InterfaceC0025b;
import p015D2.AbstractC0190n;
import p015D2.C0198v;
import p039M0.AbstractC0473V;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;
import p125o0.AbstractC1800j;
import p161x2.InterfaceC2012a;
import p167z2.C2093e;
import p167z2.C2098j;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: C2.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0173z implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0173z f407a = new C0173z();

    /* JADX INFO: renamed from: b */
    public static final InterfaceC2095g f408b = AbstractC0473V.m993E("kotlinx.serialization.json.JsonPrimitive", C2093e.f7405k, new InterfaceC2095g[0], C2098j.f7421f);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        AbstractC0172y abstractC0172y = (AbstractC0172y) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", abstractC0172y);
        AbstractC1800j.m3984b(c0198v);
        if (abstractC0172y instanceof C0165r) {
            c0198v.m363o(C0166s.f399a, C0165r.INSTANCE);
        } else {
            c0198v.m363o(C0163p.f396a, (C0162o) abstractC0172y);
        }
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        AbstractC0156i abstractC0156iM347M = AbstractC1800j.m3986d(interfaceC0025b).m347M();
        if (abstractC0156iM347M instanceof AbstractC0172y) {
            return (AbstractC0172y) abstractC0156iM347M;
        }
        throw AbstractC0190n.m321c(-1, "Unexpected JSON element, expected JsonPrimitive, had " + AbstractC1770i.m3927a(abstractC0156iM347M.getClass()), abstractC0156iM347M.toString());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f408b;
    }
}
