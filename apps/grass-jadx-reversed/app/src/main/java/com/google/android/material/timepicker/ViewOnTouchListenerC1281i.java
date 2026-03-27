package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

/* JADX INFO: renamed from: com.google.android.material.timepicker.i */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnTouchListenerC1281i implements View.OnTouchListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ GestureDetector f4580e;

    public ViewOnTouchListenerC1281i(GestureDetector gestureDetector) {
        this.f4580e = gestureDetector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f4580e.onTouchEvent(motionEvent);
        }
        return false;
    }
}
