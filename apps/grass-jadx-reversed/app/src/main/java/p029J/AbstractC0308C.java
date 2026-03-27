package p029J;

import android.graphics.Paint;
import android.view.Display;
import android.view.View;

/* JADX INFO: renamed from: J.C */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0308C {
    /* JADX INFO: renamed from: a */
    public static int m604a() {
        return View.generateViewId();
    }

    /* JADX INFO: renamed from: b */
    public static Display m605b(View view) {
        return view.getDisplay();
    }

    /* JADX INFO: renamed from: c */
    public static int m606c(View view) {
        return view.getLabelFor();
    }

    /* JADX INFO: renamed from: d */
    public static int m607d(View view) {
        return view.getLayoutDirection();
    }

    /* JADX INFO: renamed from: e */
    public static int m608e(View view) {
        return view.getPaddingEnd();
    }

    /* JADX INFO: renamed from: f */
    public static int m609f(View view) {
        return view.getPaddingStart();
    }

    /* JADX INFO: renamed from: g */
    public static boolean m610g(View view) {
        return view.isPaddingRelative();
    }

    /* JADX INFO: renamed from: h */
    public static void m611h(View view, int i3) {
        view.setLabelFor(i3);
    }

    /* JADX INFO: renamed from: i */
    public static void m612i(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    /* JADX INFO: renamed from: j */
    public static void m613j(View view, int i3) {
        view.setLayoutDirection(i3);
    }

    /* JADX INFO: renamed from: k */
    public static void m614k(View view, int i3, int i4, int i5, int i6) {
        view.setPaddingRelative(i3, i4, i5, i6);
    }
}
