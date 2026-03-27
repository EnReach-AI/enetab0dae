package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.WeakHashMap;
import p019F0.C0221e;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p032K.C0390h;
import p049Q.C0587e;
import p138r1.C1853a;
import p155w.AbstractC1979a;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends AbstractC1979a {

    /* JADX INFO: renamed from: a */
    public C0587e f4229a;

    /* JADX INFO: renamed from: b */
    public boolean f4230b;

    /* JADX INFO: renamed from: c */
    public boolean f4231c;

    /* JADX INFO: renamed from: d */
    public int f4232d = 2;

    /* JADX INFO: renamed from: e */
    public final float f4233e = 0.5f;

    /* JADX INFO: renamed from: f */
    public float f4234f = 0.0f;

    /* JADX INFO: renamed from: g */
    public float f4235g = 0.5f;

    /* JADX INFO: renamed from: h */
    public final C1853a f4236h = new C1853a(this);

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: f */
    public boolean mo3122f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zM2307o = this.f4230b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zM2307o = coordinatorLayout.m2307o(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f4230b = zM2307o;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f4230b = false;
        }
        if (!zM2307o) {
            return false;
        }
        if (this.f4229a == null) {
            this.f4229a = new C0587e(coordinatorLayout.getContext(), coordinatorLayout, this.f4236h);
        }
        return !this.f4231c && this.f4229a.m1332p(motionEvent);
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: g */
    public final boolean mo3123g(CoordinatorLayout coordinatorLayout, View view, int i3) {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (AbstractC0307B.m587c(view) == 0) {
            AbstractC0307B.m603s(view, 1);
            AbstractC0323S.m698h(view, 1048576);
            AbstractC0323S.m696f(view, 0);
            if (mo3138r(view)) {
                AbstractC0323S.m699i(view, C0390h.f913j, new C0221e(21, this));
            }
        }
        return false;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: q */
    public final boolean mo3131q(View view, MotionEvent motionEvent) {
        if (this.f4229a == null) {
            return false;
        }
        if (this.f4231c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f4229a.m1326j(motionEvent);
        return true;
    }

    /* JADX INFO: renamed from: r */
    public boolean mo3138r(View view) {
        return true;
    }
}
