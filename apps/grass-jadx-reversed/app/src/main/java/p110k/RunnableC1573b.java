package p110k;

import androidx.appcompat.widget.ActionBarOverlayLayout;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: k.b */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1573b implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f5598e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ ActionBarOverlayLayout f5599f;

    public /* synthetic */ RunnableC1573b(ActionBarOverlayLayout actionBarOverlayLayout, int i3) {
        this.f5598e = i3;
        this.f5599f = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5598e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f5599f;
                actionBarOverlayLayout.m2236h();
                actionBarOverlayLayout.f2711A = actionBarOverlayLayout.f2719h.animate().translationY(0.0f).setListener(actionBarOverlayLayout.f2712B);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f5599f;
                actionBarOverlayLayout2.m2236h();
                actionBarOverlayLayout2.f2711A = actionBarOverlayLayout2.f2719h.animate().translationY(-actionBarOverlayLayout2.f2719h.getHeight()).setListener(actionBarOverlayLayout2.f2712B);
                break;
        }
    }
}
