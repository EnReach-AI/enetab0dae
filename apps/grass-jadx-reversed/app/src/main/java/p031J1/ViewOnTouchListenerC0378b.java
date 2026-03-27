package p031J1;

import android.view.MotionEvent;
import android.view.View;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: J1.b */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnTouchListenerC0378b implements View.OnTouchListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f890e;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f890e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return true;
            default:
                if (view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
        }
    }
}
