package p082b1;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: b1.Q */
/* JADX INFO: loaded from: classes.dex */
public final class C1021Q implements InterfaceC1024U {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3635a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C1025V f3636b;

    public /* synthetic */ C1021Q(C1025V c1025v, int i3) {
        this.f3635a = i3;
        this.f3636b = c1025v;
    }

    @Override // p082b1.InterfaceC1024U
    /* JADX INFO: renamed from: a */
    public final Object mo2748a(AbstractC1041l abstractC1041l) {
        switch (this.f3635a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return this.f3636b.f3643h.mo1760c0(abstractC1041l);
            default:
                return this.f3636b.f3643h.mo1784o0(abstractC1041l);
        }
    }
}
