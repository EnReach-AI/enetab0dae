package p110k;

import android.transition.Transition;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: k.A0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1520A0 {
    /* JADX INFO: renamed from: a */
    public static void m3563a(PopupWindow popupWindow, Transition transition) {
        popupWindow.setEnterTransition(transition);
    }

    /* JADX INFO: renamed from: b */
    public static void m3564b(PopupWindow popupWindow, Transition transition) {
        popupWindow.setExitTransition(transition);
    }
}
