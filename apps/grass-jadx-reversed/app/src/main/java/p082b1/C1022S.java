package p082b1;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: b1.S */
/* JADX INFO: loaded from: classes.dex */
public final class C1022S implements InterfaceC1024U {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3637a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C1025V f3638b;

    public /* synthetic */ C1022S(C1025V c1025v, int i3) {
        this.f3637a = i3;
        this.f3638b = c1025v;
    }

    @Override // p082b1.InterfaceC1024U
    /* JADX INFO: renamed from: a */
    public final Object mo2748a(AbstractC1041l abstractC1041l) {
        switch (this.f3637a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return this.f3638b.f3643h.mo1743O(abstractC1041l);
            default:
                C1025V c1025v = this.f3638b;
                C1018N c1018nMo1798z = c1025v.f3643h.mo1798z(abstractC1041l);
                return c1018nMo1798z != null ? c1025v.f3643h.mo1729A(abstractC1041l, c1018nMo1798z) : c1018nMo1798z;
        }
    }
}
