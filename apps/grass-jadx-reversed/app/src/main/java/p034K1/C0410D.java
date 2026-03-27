package p034K1;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p025H1.C0277f;
import p025H1.C0278g;
import p073Z.C0800l;

/* JADX INFO: renamed from: K1.D */
/* JADX INFO: loaded from: classes.dex */
public final class C0410D implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f937a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f938b;

    public /* synthetic */ C0410D(int i3, Object obj) {
        this.f937a = i3;
        this.f938b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f937a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((TextInputLayout) this.f938b).f4532w0.m203k(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 1:
                int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                C0800l c0800l = (C0800l) this.f938b;
                c0800l.f2322c.setAlpha(iFloatValue);
                c0800l.f2323d.setAlpha(iFloatValue);
                c0800l.f2338s.invalidate();
                break;
            default:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C0278g c0278g = ((BottomSheetBehavior) this.f938b).f4275i;
                if (c0278g != null) {
                    C0277f c0277f = c0278g.f719e;
                    if (c0277f.f706j != fFloatValue) {
                        c0277f.f706j = fFloatValue;
                        c0278g.f723i = true;
                        c0278g.invalidateSelf();
                    }
                }
                break;
        }
    }
}
