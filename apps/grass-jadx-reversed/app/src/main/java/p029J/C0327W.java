package p029J;

import android.animation.ValueAnimator;
import android.view.View;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p034K1.C0425l;
import p036L0.C0444d;
import p098g.C1361G;

/* JADX INFO: renamed from: J.W */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0327W implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f822a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f823b;

    public /* synthetic */ C0327W(C0425l c0425l) {
        this.f823b = c0425l;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f822a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((View) ((C1361G) ((C0444d) this.f823b).f1085e).f4845d.getParent()).invalidate();
                break;
            default:
                C0425l c0425l = (C0425l) this.f823b;
                c0425l.getClass();
                c0425l.f1014d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }

    public /* synthetic */ C0327W(C0444d c0444d, View view) {
        this.f823b = c0444d;
    }
}
