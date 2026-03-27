package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import p007B1.RunnableC0055o;

/* JADX INFO: renamed from: androidx.fragment.app.d */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationAnimationListenerC0933d implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ViewGroup f3154a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f3155b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C0934e f3156c;

    public AnimationAnimationListenerC0933d(ViewGroup viewGroup, View view, C0934e c0934e) {
        this.f3154a = viewGroup;
        this.f3155b = view;
        this.f3156c = c0934e;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.f3154a.post(new RunnableC0055o(10, this));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
