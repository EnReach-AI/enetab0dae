package p008B2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p083b2.C1077v;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.C0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0063C0 implements InterfaceC2012a {

    /* JADX INFO: renamed from: b */
    public static final C0063C0 f213b = new C0063C0();

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0068H f214a = new C0068H();

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        C1077v c1077v = (C1077v) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", c1077v);
        this.f214a.mo219a(c0198v, c1077v);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        this.f214a.mo220b(interfaceC0025b);
        return C1077v.f3761a;
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return this.f214a.mo221c();
    }
}
