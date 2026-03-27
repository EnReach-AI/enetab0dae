package com.google.android.material.appbar;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import p005B.AbstractC0032g;
import p134q1.AbstractC1839a;

/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout$BaseBehavior<T> extends AbstractC1839a {

    /* JADX INFO: renamed from: c */
    public boolean f4209c;

    /* JADX INFO: renamed from: d */
    public int f4210d;

    /* JADX INFO: renamed from: e */
    public int f4211e;

    /* JADX INFO: renamed from: f */
    public int f4212f;

    /* JADX INFO: renamed from: g */
    public VelocityTracker f4213g;

    public AppBarLayout$BaseBehavior() {
        this.f4210d = -1;
        this.f4212f = -1;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: f */
    public final boolean mo3122f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f4212f < 0) {
            this.f4212f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f4209c) {
            int i3 = this.f4210d;
            if (i3 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i3)) == -1) {
                return false;
            }
            int y2 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y2 - this.f4211e) > this.f4212f) {
                this.f4211e = y2;
                return true;
            }
        }
        if (motionEvent.getActionMasked() != 0) {
            VelocityTracker velocityTracker = this.f4213g;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return false;
        }
        this.f4210d = -1;
        motionEvent.getX();
        motionEvent.getY();
        AbstractC0032g.m160r(view);
        throw null;
    }

    @Override // p134q1.AbstractC1839a, p155w.AbstractC1979a
    /* JADX INFO: renamed from: g */
    public final boolean mo3123g(CoordinatorLayout coordinatorLayout, View view, int i3) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: h */
    public final boolean mo3124h(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: j */
    public final void mo3125j(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int[] iArr, int i5) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: k */
    public final void mo3126k(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int[] iArr) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: m */
    public final void mo3127m(View view, Parcelable parcelable) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: n */
    public final Parcelable mo3128n(View view) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: o */
    public final boolean mo3129o(View view, int i3, int i4) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: p */
    public final void mo3130p(View view, View view2, int i3) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo3131q(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            int r0 = r8.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            r4 = 0
            if (r0 == r2) goto L41
            r5 = 2
            if (r0 == r5) goto L2d
            r7 = 3
            if (r0 == r7) goto L45
            r7 = 6
            if (r0 == r7) goto L14
            goto L52
        L14:
            int r7 = r8.getActionIndex()
            if (r7 != 0) goto L1b
            goto L1c
        L1b:
            r2 = r4
        L1c:
            int r7 = r8.getPointerId(r2)
            r6.f4210d = r7
            float r7 = r8.getY(r2)
            r0 = 1056964608(0x3f000000, float:0.5)
            float r7 = r7 + r0
            int r7 = (int) r7
            r6.f4211e = r7
            goto L52
        L2d:
            int r0 = r6.f4210d
            int r0 = r8.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r4
        L36:
            float r8 = r8.getY(r0)
            int r8 = (int) r8
            r6.f4211e = r8
            p005B.AbstractC0032g.m162t(r7)
            throw r3
        L41:
            android.view.VelocityTracker r0 = r6.f4213g
            if (r0 != 0) goto L5c
        L45:
            r6.f4209c = r4
            r6.f4210d = r1
            android.view.VelocityTracker r7 = r6.f4213g
            if (r7 == 0) goto L52
            r7.recycle()
            r6.f4213g = r3
        L52:
            android.view.VelocityTracker r7 = r6.f4213g
            if (r7 == 0) goto L59
            r7.addMovement(r8)
        L59:
            boolean r7 = r6.f4209c
            return r7
        L5c:
            r0.addMovement(r8)
            android.view.VelocityTracker r8 = r6.f4213g
            r0 = 1000(0x3e8, float:1.401E-42)
            r8.computeCurrentVelocity(r0)
            android.view.VelocityTracker r8 = r6.f4213g
            int r0 = r6.f4210d
            r8.getYVelocity(r0)
            p005B.AbstractC0032g.m162t(r7)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout$BaseBehavior.mo3131q(android.view.View, android.view.MotionEvent):boolean");
    }

    public AppBarLayout$BaseBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        this.f4210d = -1;
        this.f4212f = -1;
    }
}
