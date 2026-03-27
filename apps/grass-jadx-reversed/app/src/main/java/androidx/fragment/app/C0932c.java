package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: androidx.fragment.app.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0932c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ViewGroup f3149a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f3150b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ boolean f3151c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C0928N f3152d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C0934e f3153e;

    public C0932c(ViewGroup viewGroup, View view, boolean z3, C0928N c0928n, C0934e c0934e) {
        this.f3149a = viewGroup;
        this.f3150b = view;
        this.f3151c = z3;
        this.f3152d = c0928n;
        this.f3153e = c0934e;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f3149a;
        View view = this.f3150b;
        viewGroup.endViewTransition(view);
        if (this.f3151c) {
            AbstractC0032g.m143a(view, this.f3152d.f3109a);
        }
        this.f3153e.m2450e();
    }
}
