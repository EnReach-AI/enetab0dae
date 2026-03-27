package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import p029J.ViewTreeObserverOnPreDrawListenerC0371v;

/* JADX INFO: renamed from: androidx.fragment.app.s */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0948s extends AnimationSet implements Runnable {

    /* JADX INFO: renamed from: e */
    public final ViewGroup f3256e;

    /* JADX INFO: renamed from: f */
    public final View f3257f;

    /* JADX INFO: renamed from: g */
    public boolean f3258g;

    /* JADX INFO: renamed from: h */
    public boolean f3259h;

    /* JADX INFO: renamed from: i */
    public boolean f3260i;

    public RunnableC0948s(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f3260i = true;
        this.f3256e = viewGroup;
        this.f3257f = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j2, Transformation transformation) {
        this.f3260i = true;
        if (this.f3258g) {
            return !this.f3259h;
        }
        if (!super.getTransformation(j2, transformation)) {
            this.f3258g = true;
            ViewTreeObserverOnPreDrawListenerC0371v.m839a(this.f3256e, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z3 = this.f3258g;
        ViewGroup viewGroup = this.f3256e;
        if (z3 || !this.f3260i) {
            viewGroup.endViewTransition(this.f3257f);
            this.f3259h = true;
        } else {
            this.f3260i = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j2, Transformation transformation, float f3) {
        this.f3260i = true;
        if (this.f3258g) {
            return !this.f3259h;
        }
        if (!super.getTransformation(j2, transformation, f3)) {
            this.f3258g = true;
            ViewTreeObserverOnPreDrawListenerC0371v.m839a(this.f3256e, this);
        }
        return true;
    }
}
