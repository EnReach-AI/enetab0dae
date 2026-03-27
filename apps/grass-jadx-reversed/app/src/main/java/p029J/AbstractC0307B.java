package p029J;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX INFO: renamed from: J.B */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0307B {
    /* JADX INFO: renamed from: a */
    public static AccessibilityNodeProvider m585a(View view) {
        return view.getAccessibilityNodeProvider();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m586b(View view) {
        return view.getFitsSystemWindows();
    }

    /* JADX INFO: renamed from: c */
    public static int m587c(View view) {
        return view.getImportantForAccessibility();
    }

    /* JADX INFO: renamed from: d */
    public static int m588d(View view) {
        return view.getMinimumHeight();
    }

    /* JADX INFO: renamed from: e */
    public static int m589e(View view) {
        return view.getMinimumWidth();
    }

    /* JADX INFO: renamed from: f */
    public static ViewParent m590f(View view) {
        return view.getParentForAccessibility();
    }

    /* JADX INFO: renamed from: g */
    public static int m591g(View view) {
        return view.getWindowSystemUiVisibility();
    }

    /* JADX INFO: renamed from: h */
    public static boolean m592h(View view) {
        return view.hasOverlappingRendering();
    }

    /* JADX INFO: renamed from: i */
    public static boolean m593i(View view) {
        return view.hasTransientState();
    }

    /* JADX INFO: renamed from: j */
    public static boolean m594j(View view, int i3, Bundle bundle) {
        return view.performAccessibilityAction(i3, bundle);
    }

    /* JADX INFO: renamed from: k */
    public static void m595k(View view) {
        view.postInvalidateOnAnimation();
    }

    /* JADX INFO: renamed from: l */
    public static void m596l(View view, int i3, int i4, int i5, int i6) {
        view.postInvalidateOnAnimation(i3, i4, i5, i6);
    }

    /* JADX INFO: renamed from: m */
    public static void m597m(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    /* JADX INFO: renamed from: n */
    public static void m598n(View view, Runnable runnable, long j2) {
        view.postOnAnimationDelayed(runnable, j2);
    }

    /* JADX INFO: renamed from: o */
    public static void m599o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    /* JADX INFO: renamed from: p */
    public static void m600p(View view) {
        view.requestFitSystemWindows();
    }

    /* JADX INFO: renamed from: q */
    public static void m601q(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    /* JADX INFO: renamed from: r */
    public static void m602r(View view, boolean z3) {
        view.setHasTransientState(z3);
    }

    /* JADX INFO: renamed from: s */
    public static void m603s(View view, int i3) {
        view.setImportantForAccessibility(i3);
    }
}
