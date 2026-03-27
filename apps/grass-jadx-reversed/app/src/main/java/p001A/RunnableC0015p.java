package p001A;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: A.p */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0015p implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f40e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f41f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f42g;

    public /* synthetic */ RunnableC0015p(Object obj, int i3, int i4) {
        this.f40e = i4;
        this.f42g = obj;
        this.f41f = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f40e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((AbstractC0001b) this.f42g).mo13g(this.f41f);
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f42g;
                View view = (View) sideSheetBehavior.f4452n.get();
                if (view != null) {
                    sideSheetBehavior.m3195t(view, this.f41f, false);
                }
                break;
        }
    }
}
