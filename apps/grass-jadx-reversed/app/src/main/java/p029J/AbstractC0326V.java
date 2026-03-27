package p029J;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: renamed from: J.V */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0326V {
    /* JADX INFO: renamed from: a */
    public static boolean m707a(ViewParent viewParent, View view, float f3, float f4, boolean z3) {
        return viewParent.onNestedFling(view, f3, f4, z3);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m708b(ViewParent viewParent, View view, float f3, float f4) {
        return viewParent.onNestedPreFling(view, f3, f4);
    }

    /* JADX INFO: renamed from: c */
    public static void m709c(ViewParent viewParent, View view, int i3, int i4, int[] iArr) {
        viewParent.onNestedPreScroll(view, i3, i4, iArr);
    }

    /* JADX INFO: renamed from: d */
    public static void m710d(ViewParent viewParent, View view, int i3, int i4, int i5, int i6) {
        viewParent.onNestedScroll(view, i3, i4, i5, i6);
    }

    /* JADX INFO: renamed from: e */
    public static void m711e(ViewParent viewParent, View view, View view2, int i3) {
        viewParent.onNestedScrollAccepted(view, view2, i3);
    }

    /* JADX INFO: renamed from: f */
    public static boolean m712f(ViewParent viewParent, View view, View view2, int i3) {
        return viewParent.onStartNestedScroll(view, view2, i3);
    }

    /* JADX INFO: renamed from: g */
    public static void m713g(ViewParent viewParent, View view) {
        viewParent.onStopNestedScroll(view);
    }
}
