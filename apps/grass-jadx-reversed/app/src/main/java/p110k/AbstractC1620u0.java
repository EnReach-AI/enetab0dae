package p110k;

import android.graphics.Rect;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: k.u0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1620u0 {
    /* JADX INFO: renamed from: a */
    public static void m3693a(PopupWindow popupWindow, Rect rect) {
        popupWindow.setEpicenterBounds(rect);
    }

    /* JADX INFO: renamed from: b */
    public static void m3694b(PopupWindow popupWindow, boolean z3) {
        popupWindow.setIsClippedToScreen(z3);
    }
}
