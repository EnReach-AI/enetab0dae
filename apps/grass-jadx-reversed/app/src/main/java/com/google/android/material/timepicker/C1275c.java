package com.google.android.material.timepicker;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import io.getgrass.www.R;
import p029J.C0335c;
import p032K.C0390h;
import p032K.C0391i;
import p036L0.C0444d;

/* JADX INFO: renamed from: com.google.android.material.timepicker.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1275c extends C0335c {

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ ClockFaceView f4573d;

    public C1275c(ClockFaceView clockFaceView) {
        this.f4573d = clockFaceView;
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: d */
    public final void mo192d(View view, C0391i c0391i) {
        View.AccessibilityDelegate accessibilityDelegate = this.f830a;
        AccessibilityNodeInfo accessibilityNodeInfo = c0391i.f920a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int iIntValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (iIntValue > 0) {
            accessibilityNodeInfo.setTraversalAfter((View) this.f4573d.f4541A.get(iIntValue - 1));
        }
        c0391i.m873f(C0444d.m977w(view.isSelected(), 0, 1, iIntValue, 1));
        accessibilityNodeInfo.setClickable(true);
        c0391i.m869b(C0390h.f908e);
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: g */
    public final boolean mo727g(View view, int i3, Bundle bundle) {
        if (i3 != 16) {
            return super.mo727g(view, i3, bundle);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        ClockFaceView clockFaceView = this.f4573d;
        view.getHitRect(clockFaceView.f4553x);
        float fCenterX = clockFaceView.f4553x.centerX();
        float fCenterY = clockFaceView.f4553x.centerY();
        clockFaceView.f4552w.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
        clockFaceView.f4552w.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
        return true;
    }
}
