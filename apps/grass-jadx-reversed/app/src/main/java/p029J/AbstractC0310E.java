package p029J;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: renamed from: J.E */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0310E {
    /* JADX INFO: renamed from: a */
    public static int m618a(View view) {
        return view.getAccessibilityLiveRegion();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m619b(View view) {
        return view.isAttachedToWindow();
    }

    /* JADX INFO: renamed from: c */
    public static boolean m620c(View view) {
        return view.isLaidOut();
    }

    /* JADX INFO: renamed from: d */
    public static boolean m621d(View view) {
        return view.isLayoutDirectionResolved();
    }

    /* JADX INFO: renamed from: e */
    public static void m622e(ViewParent viewParent, View view, View view2, int i3) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i3);
    }

    /* JADX INFO: renamed from: f */
    public static void m623f(View view, int i3) {
        view.setAccessibilityLiveRegion(i3);
    }

    /* JADX INFO: renamed from: g */
    public static void m624g(AccessibilityEvent accessibilityEvent, int i3) {
        accessibilityEvent.setContentChangeTypes(i3);
    }
}
