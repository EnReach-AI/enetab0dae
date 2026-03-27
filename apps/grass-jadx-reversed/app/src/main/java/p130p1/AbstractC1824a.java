package p130p1;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import p060U.C0652a;

/* JADX INFO: renamed from: p1.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1824a {

    /* JADX INFO: renamed from: a */
    public static final LinearInterpolator f6320a = new LinearInterpolator();

    /* JADX INFO: renamed from: b */
    public static final C0652a f6321b = new C0652a(1);

    /* JADX INFO: renamed from: c */
    public static final C0652a f6322c = new C0652a(0);

    /* JADX INFO: renamed from: d */
    public static final C0652a f6323d = new C0652a(2);

    static {
        new DecelerateInterpolator();
    }

    /* JADX INFO: renamed from: a */
    public static float m4069a(float f3, float f4, float f5) {
        return ((f4 - f3) * f5) + f3;
    }
}
