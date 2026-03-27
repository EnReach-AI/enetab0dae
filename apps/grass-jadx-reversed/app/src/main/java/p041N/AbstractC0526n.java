package p041N;

import android.widget.PopupWindow;

/* JADX INFO: renamed from: N.n */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0526n {
    /* JADX INFO: renamed from: a */
    public static boolean m1044a(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    /* JADX INFO: renamed from: b */
    public static int m1045b(PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }

    /* JADX INFO: renamed from: c */
    public static void m1046c(PopupWindow popupWindow, boolean z3) {
        popupWindow.setOverlapAnchor(z3);
    }

    /* JADX INFO: renamed from: d */
    public static void m1047d(PopupWindow popupWindow, int i3) {
        popupWindow.setWindowLayoutType(i3);
    }
}
