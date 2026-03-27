package p110k;

import androidx.appcompat.widget.SearchView;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p044O.AbstractC0566c;

/* JADX INFO: renamed from: k.K0 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1540K0 implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f5511e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ SearchView f5512f;

    public /* synthetic */ RunnableC1540K0(SearchView searchView, int i3) {
        this.f5511e = i3;
        this.f5512f = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5511e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f5512f.m2259u();
                break;
            default:
                AbstractC0566c abstractC0566c = this.f5512f.f2784S;
                if (abstractC0566c instanceof ViewOnClickListenerC1559U0) {
                    abstractC0566c.mo1242b(null);
                }
                break;
        }
    }
}
