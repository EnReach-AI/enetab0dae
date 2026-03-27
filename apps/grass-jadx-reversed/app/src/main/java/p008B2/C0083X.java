package p008B2;

import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p119m2.AbstractC1766e;
import p161x2.C2017f;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.X */
/* JADX INFO: loaded from: classes.dex */
public final class C0083X implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0083X f252a = new C0083X();

    /* JADX INFO: renamed from: b */
    public static final C0082W f253b = C0082W.f251a;

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", (Void) obj);
        throw new C2017f("'kotlin.Nothing' cannot be serialized");
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        throw new C2017f("'kotlin.Nothing' does not have instances");
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f253b;
    }
}
