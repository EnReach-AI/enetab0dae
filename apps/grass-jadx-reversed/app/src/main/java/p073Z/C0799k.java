package p073Z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p087d0.AbstractC1299r;
import p087d0.C1300s;

/* JADX INFO: renamed from: Z.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0799k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2313a = 0;

    /* JADX INFO: renamed from: b */
    public boolean f2314b = false;

    /* JADX INFO: renamed from: c */
    public final Object f2315c;

    public C0799k(View view) {
        this.f2315c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f2313a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f2314b = true;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f2313a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (!this.f2314b) {
                    C0800l c0800l = (C0800l) this.f2315c;
                    if (((Float) c0800l.f2345z.getAnimatedValue()).floatValue() != 0.0f) {
                        c0800l.f2318A = 2;
                        c0800l.f2338s.invalidate();
                    } else {
                        c0800l.f2318A = 0;
                        c0800l.m2095f(0);
                    }
                } else {
                    this.f2314b = false;
                }
                break;
            default:
                C1300s c1300s = AbstractC1299r.f4645a;
                View view = (View) this.f2315c;
                c1300s.mo1940h(view, 1.0f);
                if (this.f2314b) {
                    view.setLayerType(0, null);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f2313a) {
            case 1:
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                View view = (View) this.f2315c;
                if (AbstractC0307B.m592h(view) && view.getLayerType() == 0) {
                    this.f2314b = true;
                    view.setLayerType(2, null);
                    break;
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public C0799k(C0800l c0800l) {
        this.f2315c = c0800l;
    }
}
