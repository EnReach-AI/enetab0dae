package p034K1;

import android.view.View;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: K1.b */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ViewOnFocusChangeListenerC0415b implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f944a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractC0431r f945b;

    public /* synthetic */ ViewOnFocusChangeListenerC0415b(AbstractC0431r abstractC0431r, int i3) {
        this.f944a = i3;
        this.f945b = abstractC0431r;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z3) {
        switch (this.f944a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0418e c0418e = (C0418e) this.f945b;
                c0418e.m924t(c0418e.m925u());
                break;
            default:
                C0425l c0425l = (C0425l) this.f945b;
                c0425l.f974l = z3;
                c0425l.m956q();
                if (!z3) {
                    c0425l.m933t(false);
                    c0425l.f975m = false;
                }
                break;
        }
    }
}
