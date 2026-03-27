package p124o;

import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: o.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1790b extends Drawable {

    /* JADX INFO: renamed from: a */
    public static final double f6179a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: a */
    public static float m3947a(float f3, float f4, boolean z3) {
        if (!z3) {
            return f3;
        }
        return (float) (((1.0d - f6179a) * ((double) f4)) + ((double) f3));
    }

    /* JADX INFO: renamed from: b */
    public static float m3948b(float f3, float f4, boolean z3) {
        if (!z3) {
            return f3 * 1.5f;
        }
        return (float) (((1.0d - f6179a) * ((double) f4)) + ((double) (f3 * 1.5f)));
    }
}
