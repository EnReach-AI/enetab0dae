package p110k;

import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p029J.AbstractC0310E;
import p029J.AbstractC0323S;

/* JADX INFO: renamed from: k.v0 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1622v0 implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f5752e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1628y0 f5753f;

    public /* synthetic */ RunnableC1622v0(C1628y0 c1628y0, int i3) {
        this.f5752e = i3;
        this.f5753f = c1628y0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1628y0 c1628y0 = this.f5753f;
        switch (this.f5752e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C1604m0 c1604m0 = c1628y0.f5772g;
                if (c1604m0 != null) {
                    c1604m0.setListSelectionHidden(true);
                    c1604m0.requestLayout();
                }
                break;
            default:
                C1604m0 c1604m02 = c1628y0.f5772g;
                if (c1604m02 != null) {
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    if (AbstractC0310E.m619b(c1604m02) && c1628y0.f5772g.getCount() > c1628y0.f5772g.getChildCount() && c1628y0.f5772g.getChildCount() <= c1628y0.f5782q) {
                        c1628y0.f5769D.setInputMethodMode(2);
                        c1628y0.mo3476f();
                        break;
                    }
                }
                break;
        }
    }
}
