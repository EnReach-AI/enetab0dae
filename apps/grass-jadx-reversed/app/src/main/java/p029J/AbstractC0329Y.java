package p029J;

import android.animation.ValueAnimator;
import android.view.ViewPropertyAnimator;

/* JADX INFO: renamed from: J.Y */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0329Y {
    /* JADX INFO: renamed from: a */
    public static ViewPropertyAnimator m714a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
    }
}
