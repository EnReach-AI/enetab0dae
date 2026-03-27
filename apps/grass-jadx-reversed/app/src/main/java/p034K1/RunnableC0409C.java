package p034K1;

import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: K1.C */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0409C implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f935e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ TextInputLayout f936f;

    public /* synthetic */ RunnableC0409C(TextInputLayout textInputLayout, int i3) {
        this.f935e = i3;
        this.f936f = textInputLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f935e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                CheckableImageButton checkableImageButton = this.f936f.f4499g.f995k;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                break;
            default:
                this.f936f.f4501h.requestLayout();
                break;
        }
    }
}
