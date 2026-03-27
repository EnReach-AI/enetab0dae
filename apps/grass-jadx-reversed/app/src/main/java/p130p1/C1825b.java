package p130p1;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import p128p.C1817k;

/* JADX INFO: renamed from: p1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1825b {

    /* JADX INFO: renamed from: a */
    public final C1817k f6324a = new C1817k();

    /* JADX INFO: renamed from: b */
    public final C1817k f6325b = new C1817k();

    /* JADX INFO: renamed from: a */
    public static C1825b m4070a(Context context, int i3) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i3);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return m4071b(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return m4071b(arrayList);
        } catch (Exception e3) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i3), e3);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static C1825b m4071b(ArrayList arrayList) {
        C1825b c1825b = new C1825b();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Animator animator = (Animator) arrayList.get(i3);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            c1825b.f6325b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = AbstractC1824a.f6321b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = AbstractC1824a.f6322c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = AbstractC1824a.f6323d;
            }
            C1826c c1826c = new C1826c();
            c1826c.f6329d = 0;
            c1826c.f6330e = 1;
            c1826c.f6326a = startDelay;
            c1826c.f6327b = duration;
            c1826c.f6328c = interpolator;
            c1826c.f6329d = objectAnimator.getRepeatCount();
            c1826c.f6330e = objectAnimator.getRepeatMode();
            c1825b.f6324a.put(propertyName, c1826c);
        }
        return c1825b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1825b) {
            return this.f6324a.equals(((C1825b) obj).f6324a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6324a.hashCode();
    }

    public final String toString() {
        return "\n" + C1825b.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f6324a + "}\n";
    }
}
