package p008B2;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p004A2.InterfaceC0024a;
import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p083b2.AbstractC1056a;
import p083b2.C1077v;
import p083b2.InterfaceC1059d;
import p119m2.AbstractC1766e;
import p161x2.C2017f;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.H */
/* JADX INFO: loaded from: classes.dex */
public final class C0068H implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f226a;

    /* JADX INFO: renamed from: b */
    public final Object f227b;

    public C0068H() {
        this.f226a = 1;
        this.f227b = AbstractC1056a.m2815b(new C0136z(this));
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        switch (this.f226a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC1766e.m3920e("encoder", c0198v);
                throw new IllegalStateException("unsupported".toString());
            default:
                AbstractC1766e.m3920e("encoder", c0198v);
                AbstractC1766e.m3920e("value", obj);
                c0198v.m349a(mo221c()).m366r(mo221c());
                return;
        }
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        switch (this.f226a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC1766e.m3920e("decoder", interfaceC0025b);
                throw new IllegalStateException("unsupported".toString());
            default:
                AbstractC1766e.m3920e("decoder", interfaceC0025b);
                InterfaceC2095g interfaceC2095gMo221c = mo221c();
                InterfaceC0024a interfaceC0024aMo94i = interfaceC0025b.mo94i(interfaceC2095gMo221c);
                int iMo86q = interfaceC0024aMo94i.mo86q(mo221c());
                if (iMo86q == -1) {
                    interfaceC0024aMo94i.mo88w(interfaceC2095gMo221c);
                    return C1077v.f3761a;
                }
                throw new C2017f("Unexpected index " + iMo86q);
        }
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        switch (this.f226a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                throw new IllegalStateException("unsupported".toString());
            default:
                return (InterfaceC2095g) ((InterfaceC1059d) this.f227b).getValue();
        }
    }

    public C0068H(InterfaceC2012a interfaceC2012a) {
        this.f226a = 0;
        this.f227b = interfaceC2012a;
    }
}
