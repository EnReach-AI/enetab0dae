package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: renamed from: com.google.android.material.timepicker.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1280h extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ TimePickerView f4579a;

    public C1280h(TimePickerView timePickerView) {
        this.f4579a = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        int i3 = TimePickerView.f4569u;
        this.f4579a.getClass();
        return false;
    }
}
