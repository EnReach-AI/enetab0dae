package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import p019F0.C0217a;
import p031J1.AbstractC0379c;
import p031J1.C0382f;

/* JADX INFO: loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* JADX INFO: renamed from: i */
    public final C0217a f4459i;

    public BaseTransientBottomBar$Behavior() {
        C0217a c0217a = new C0217a(2);
        this.f4234f = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.f4235g = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.f4232d = 0;
        this.f4459i = c0217a;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, p155w.AbstractC1979a
    /* JADX INFO: renamed from: f */
    public final boolean mo3122f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.f4459i.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (C0382f.f902b == null) {
                    C0382f.f902b = new C0382f(0);
                }
                synchronized (C0382f.f902b.f903a) {
                }
            }
        } else if (coordinatorLayout.m2307o(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (C0382f.f902b == null) {
                C0382f.f902b = new C0382f(0);
            }
            synchronized (C0382f.f902b.f903a) {
            }
        }
        return super.mo3122f(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    /* JADX INFO: renamed from: r */
    public final boolean mo3138r(View view) {
        this.f4459i.getClass();
        return view instanceof AbstractC0379c;
    }
}
