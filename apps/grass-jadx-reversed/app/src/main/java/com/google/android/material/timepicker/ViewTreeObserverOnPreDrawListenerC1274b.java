package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: com.google.android.material.timepicker.b */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC1274b implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ ClockFaceView f4572e;

    public ViewTreeObserverOnPreDrawListenerC1274b(ClockFaceView clockFaceView) {
        this.f4572e = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f4572e;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.f4552w.f4559h) - clockFaceView.f4545E;
        if (height != clockFaceView.f4575u) {
            clockFaceView.f4575u = height;
            clockFaceView.mo3227f();
            int i3 = clockFaceView.f4575u;
            ClockHandView clockHandView = clockFaceView.f4552w;
            clockHandView.f4567p = i3;
            clockHandView.invalidate();
        }
        return true;
    }
}
