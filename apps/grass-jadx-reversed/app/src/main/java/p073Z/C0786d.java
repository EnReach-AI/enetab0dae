package p073Z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: Z.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0786d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2243a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractC0777X f2244b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f2245c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ ViewPropertyAnimator f2246d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C0796i f2247e;

    public C0786d(C0796i c0796i, AbstractC0777X abstractC0777X, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2247e = c0796i;
        this.f2244b = abstractC0777X;
        this.f2246d = viewPropertyAnimator;
        this.f2245c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f2243a) {
            case 1:
                this.f2245c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f2243a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f2246d.setListener(null);
                this.f2245c.setAlpha(1.0f);
                C0796i c0796i = this.f2247e;
                AbstractC0777X abstractC0777X = this.f2244b;
                c0796i.m1952d(abstractC0777X);
                c0796i.f2306q.remove(abstractC0777X);
                c0796i.m2087j();
                break;
            default:
                this.f2246d.setListener(null);
                C0796i c0796i2 = this.f2247e;
                AbstractC0777X abstractC0777X2 = this.f2244b;
                c0796i2.m1952d(abstractC0777X2);
                c0796i2.f2304o.remove(abstractC0777X2);
                c0796i2.m2087j();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f2243a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f2247e.getClass();
                break;
            default:
                this.f2247e.getClass();
                break;
        }
    }

    public C0786d(C0796i c0796i, AbstractC0777X abstractC0777X, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2247e = c0796i;
        this.f2244b = abstractC0777X;
        this.f2245c = view;
        this.f2246d = viewPropertyAnimator;
    }
}
