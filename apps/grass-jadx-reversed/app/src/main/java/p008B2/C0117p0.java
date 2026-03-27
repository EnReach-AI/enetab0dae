package p008B2;

import p004A2.InterfaceC0024a;
import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p039M0.AbstractC0473V;
import p083b2.C1066k;
import p119m2.AbstractC1766e;
import p161x2.C2017f;
import p161x2.InterfaceC2012a;
import p167z2.C2096h;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.p0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0117p0 implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2012a f312a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2012a f313b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2012a f314c;

    /* JADX INFO: renamed from: d */
    public final C2096h f315d = AbstractC0473V.m992D("kotlin.Triple", new InterfaceC2095g[0], new C0085Z(2, this));

    public C0117p0(InterfaceC2012a interfaceC2012a, InterfaceC2012a interfaceC2012a2, InterfaceC2012a interfaceC2012a3) {
        this.f312a = interfaceC2012a;
        this.f313b = interfaceC2012a2;
        this.f314c = interfaceC2012a3;
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        C1066k c1066k = (C1066k) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", c1066k);
        C2096h c2096h = this.f315d;
        C0198v c0198vM349a = c0198v.m349a(c2096h);
        c0198vM349a.m362n(c2096h, 0, this.f312a, c1066k.f3746e);
        c0198vM349a.m362n(c2096h, 1, this.f313b, c1066k.f3747f);
        c0198vM349a.m362n(c2096h, 2, this.f314c, c1066k.f3748g);
        c0198vM349a.m366r(c2096h);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        C2096h c2096h = this.f315d;
        InterfaceC0024a interfaceC0024aMo94i = interfaceC0025b.mo94i(c2096h);
        Object obj = AbstractC0089b0.f262c;
        Object objMo85p = obj;
        Object objMo85p2 = objMo85p;
        Object objMo85p3 = objMo85p2;
        while (true) {
            int iMo86q = interfaceC0024aMo94i.mo86q(c2096h);
            if (iMo86q == -1) {
                interfaceC0024aMo94i.mo88w(c2096h);
                if (objMo85p == obj) {
                    throw new C2017f("Element 'first' is missing");
                }
                if (objMo85p2 == obj) {
                    throw new C2017f("Element 'second' is missing");
                }
                if (objMo85p3 != obj) {
                    return new C1066k(objMo85p, objMo85p2, objMo85p3);
                }
                throw new C2017f("Element 'third' is missing");
            }
            if (iMo86q == 0) {
                objMo85p = interfaceC0024aMo94i.mo85p(c2096h, 0, this.f312a, null);
            } else if (iMo86q == 1) {
                objMo85p2 = interfaceC0024aMo94i.mo85p(c2096h, 1, this.f313b, null);
            } else {
                if (iMo86q != 2) {
                    throw new C2017f("Unexpected index " + iMo86q);
                }
                objMo85p3 = interfaceC0024aMo94i.mo85p(c2096h, 2, this.f314c, null);
            }
        }
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return this.f315d;
    }
}
