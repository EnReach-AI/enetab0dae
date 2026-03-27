package p110k;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: k.o0 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1608o0 implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f5702e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ AbstractViewOnTouchListenerC1610p0 f5703f;

    public /* synthetic */ RunnableC1608o0(AbstractViewOnTouchListenerC1610p0 abstractViewOnTouchListenerC1610p0, int i3) {
        this.f5702e = i3;
        this.f5703f = abstractViewOnTouchListenerC1610p0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5702e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ViewParent parent = this.f5703f.f5711h.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                AbstractViewOnTouchListenerC1610p0 abstractViewOnTouchListenerC1610p0 = this.f5703f;
                abstractViewOnTouchListenerC1610p0.m3679a();
                View view = abstractViewOnTouchListenerC1610p0.f5711h;
                if (view.isEnabled() && !view.isLongClickable() && abstractViewOnTouchListenerC1610p0.mo3501c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    abstractViewOnTouchListenerC1610p0.f5714k = true;
                    break;
                }
                break;
        }
    }
}
