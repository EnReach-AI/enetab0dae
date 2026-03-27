package p073Z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: Z.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0790f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2268a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C0792g f2269b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ ViewPropertyAnimator f2270c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ View f2271d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C0796i f2272e;

    public /* synthetic */ C0790f(C0796i c0796i, C0792g c0792g, ViewPropertyAnimator viewPropertyAnimator, View view, int i3) {
        this.f2268a = i3;
        this.f2272e = c0796i;
        this.f2269b = c0792g;
        this.f2270c = viewPropertyAnimator;
        this.f2271d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f2268a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f2270c.setListener(null);
                View view = this.f2271d;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                C0792g c0792g = this.f2269b;
                AbstractC0777X abstractC0777X = c0792g.f2279a;
                C0796i c0796i = this.f2272e;
                c0796i.m1952d(abstractC0777X);
                c0796i.f2307r.remove(c0792g.f2279a);
                c0796i.m2087j();
                break;
            default:
                this.f2270c.setListener(null);
                View view2 = this.f2271d;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                C0792g c0792g2 = this.f2269b;
                AbstractC0777X abstractC0777X2 = c0792g2.f2280b;
                C0796i c0796i2 = this.f2272e;
                c0796i2.m1952d(abstractC0777X2);
                c0796i2.f2307r.remove(c0792g2.f2280b);
                c0796i2.m2087j();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f2268a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0777X abstractC0777X = this.f2269b.f2279a;
                this.f2272e.getClass();
                break;
            default:
                AbstractC0777X abstractC0777X2 = this.f2269b.f2280b;
                this.f2272e.getClass();
                break;
        }
    }
}
