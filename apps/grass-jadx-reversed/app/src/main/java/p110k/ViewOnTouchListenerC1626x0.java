package p110k;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: k.x0 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnTouchListenerC1626x0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C1628y0 f5759e;

    public ViewOnTouchListenerC1626x0(C1628y0 c1628y0) {
        this.f5759e = c1628y0;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C1625x c1625x;
        int action = motionEvent.getAction();
        int x3 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        C1628y0 c1628y0 = this.f5759e;
        if (action == 0 && (c1625x = c1628y0.f5769D) != null && c1625x.isShowing() && x3 >= 0 && x3 < c1628y0.f5769D.getWidth() && y2 >= 0 && y2 < c1628y0.f5769D.getHeight()) {
            c1628y0.f5791z.postDelayed(c1628y0.f5787v, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        c1628y0.f5791z.removeCallbacks(c1628y0.f5787v);
        return false;
    }
}
