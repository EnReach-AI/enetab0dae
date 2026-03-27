package p060U;

import android.view.animation.Interpolator;

/* JADX INFO: renamed from: U.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractInterpolatorC0653b implements Interpolator {

    /* JADX INFO: renamed from: a */
    public final float[] f1754a;

    /* JADX INFO: renamed from: b */
    public final float f1755b;

    public AbstractInterpolatorC0653b(float[] fArr) {
        this.f1754a = fArr;
        this.f1755b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f3) {
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f1754a;
        int iMin = Math.min((int) ((fArr.length - 1) * f3), fArr.length - 2);
        float f4 = this.f1755b;
        float f5 = (f3 - (iMin * f4)) / f4;
        float f6 = fArr[iMin];
        return ((fArr[iMin + 1] - f6) * f5) + f6;
    }
}
