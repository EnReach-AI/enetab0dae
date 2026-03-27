package p041N;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* JADX INFO: renamed from: N.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0517e {
    /* JADX INFO: renamed from: a */
    public static EdgeEffect m1028a(Context context, AttributeSet attributeSet) {
        try {
            return new EdgeEffect(context, attributeSet);
        } catch (Throwable unused) {
            return new EdgeEffect(context);
        }
    }

    /* JADX INFO: renamed from: b */
    public static float m1029b(EdgeEffect edgeEffect) {
        try {
            return edgeEffect.getDistance();
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    /* JADX INFO: renamed from: c */
    public static float m1030c(EdgeEffect edgeEffect, float f3, float f4) {
        try {
            return edgeEffect.onPullDistance(f3, f4);
        } catch (Throwable unused) {
            edgeEffect.onPull(f3, f4);
            return 0.0f;
        }
    }
}
