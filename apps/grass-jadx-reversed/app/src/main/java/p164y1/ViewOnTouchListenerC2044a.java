package p164y1;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: renamed from: y1.a */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnTouchListenerC2044a implements View.OnTouchListener {

    /* JADX INFO: renamed from: e */
    public final Dialog f7250e;

    /* JADX INFO: renamed from: f */
    public final int f7251f;

    /* JADX INFO: renamed from: g */
    public final int f7252g;

    public ViewOnTouchListenerC2044a(Dialog dialog, Rect rect) {
        this.f7250e = dialog;
        this.f7251f = rect.left;
        this.f7252g = rect.top;
        ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = viewFindViewById.getLeft() + this.f7251f;
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, viewFindViewById.getTop() + this.f7252g, width, viewFindViewById.getHeight() + r4).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        view.performClick();
        return this.f7250e.onTouchEvent(motionEventObtain);
    }
}
