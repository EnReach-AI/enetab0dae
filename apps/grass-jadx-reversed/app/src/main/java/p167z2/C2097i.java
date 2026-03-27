package p167z2;

import java.util.Iterator;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: z2.i */
/* JADX INFO: loaded from: classes.dex */
public final class C2097i implements Iterator {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f7418e;

    /* JADX INFO: renamed from: f */
    public int f7419f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ InterfaceC2095g f7420g;

    public C2097i(InterfaceC2095g interfaceC2095g, int i3) {
        this.f7418e = i3;
        switch (i3) {
            case 1:
                this.f7420g = interfaceC2095g;
                this.f7419f = interfaceC2095g.mo240l();
                break;
            default:
                this.f7420g = interfaceC2095g;
                this.f7419f = interfaceC2095g.mo240l();
                break;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f7418e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (this.f7419f > 0) {
                }
                break;
            default:
                if (this.f7419f > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f7418e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                InterfaceC2095g interfaceC2095g = this.f7420g;
                int iMo240l = interfaceC2095g.mo240l();
                int i3 = this.f7419f;
                this.f7419f = i3 - 1;
                return interfaceC2095g.mo236h(iMo240l - i3);
            default:
                InterfaceC2095g interfaceC2095g2 = this.f7420g;
                int iMo240l2 = interfaceC2095g2.mo240l();
                int i4 = this.f7419f;
                this.f7419f = i4 - 1;
                return interfaceC2095g2.mo230a(iMo240l2 - i4);
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f7418e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
