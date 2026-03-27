package p008B2;

import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p115l2.InterfaceC1678a;
import p119m2.AbstractC1767f;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.c0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0091c0 extends AbstractC1767f implements InterfaceC1678a {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f265f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ AbstractC0093d0 f266g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0091c0(AbstractC0093d0 abstractC0093d0, int i3) {
        super(0);
        this.f265f = i3;
        this.f266g = abstractC0093d0;
    }

    @Override // p115l2.InterfaceC1678a
    /* JADX INFO: renamed from: a */
    public final Object mo263a() {
        AbstractC0093d0 abstractC0093d0 = this.f266g;
        switch (this.f265f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return Integer.valueOf(AbstractC0089b0.m258e(abstractC0093d0, (InterfaceC2095g[]) abstractC0093d0.f278j.getValue()));
            case 1:
                C0068H c0068h = abstractC0093d0.f270b;
                return c0068h != null ? new InterfaceC2012a[]{(InterfaceC2012a) c0068h.f227b} : AbstractC0089b0.f261b;
            default:
                return AbstractC0089b0.m256c(abstractC0093d0.f270b != null ? new ArrayList(0) : null);
        }
    }
}
