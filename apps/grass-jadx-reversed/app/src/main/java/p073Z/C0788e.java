package p073Z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: renamed from: Z.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0788e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC0777X f2252a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f2253b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f2254c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f2255d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ ViewPropertyAnimator f2256e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C0796i f2257f;

    public C0788e(C0796i c0796i, AbstractC0777X abstractC0777X, int i3, View view, int i4, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2257f = c0796i;
        this.f2252a = abstractC0777X;
        this.f2253b = i3;
        this.f2254c = view;
        this.f2255d = i4;
        this.f2256e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i3 = this.f2253b;
        View view = this.f2254c;
        if (i3 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f2255d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f2256e.setListener(null);
        C0796i c0796i = this.f2257f;
        AbstractC0777X abstractC0777X = this.f2252a;
        c0796i.m1952d(abstractC0777X);
        c0796i.f2305p.remove(abstractC0777X);
        c0796i.m2087j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f2257f.getClass();
    }
}
