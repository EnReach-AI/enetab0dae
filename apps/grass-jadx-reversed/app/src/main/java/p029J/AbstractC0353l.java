package p029J;

import android.view.ViewGroup;

/* JADX INFO: renamed from: J.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0353l {
    /* JADX INFO: renamed from: a */
    public static int m769a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getLayoutDirection();
    }

    /* JADX INFO: renamed from: b */
    public static int m770b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    /* JADX INFO: renamed from: c */
    public static int m771c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    /* JADX INFO: renamed from: d */
    public static boolean m772d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.isMarginRelative();
    }

    /* JADX INFO: renamed from: e */
    public static void m773e(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.resolveLayoutDirection(i3);
    }

    /* JADX INFO: renamed from: f */
    public static void m774f(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setLayoutDirection(i3);
    }

    /* JADX INFO: renamed from: g */
    public static void m775g(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setMarginEnd(i3);
    }

    /* JADX INFO: renamed from: h */
    public static void m776h(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setMarginStart(i3);
    }
}
