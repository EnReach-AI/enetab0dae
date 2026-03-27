package p029J;

import android.graphics.Rect;
import android.view.DisplayCutout;
import java.util.List;

/* JADX INFO: renamed from: J.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0345h {
    /* JADX INFO: renamed from: a */
    public static DisplayCutout m739a(Rect rect, List<Rect> list) {
        return new DisplayCutout(rect, list);
    }

    /* JADX INFO: renamed from: b */
    public static List<Rect> m740b(DisplayCutout displayCutout) {
        return displayCutout.getBoundingRects();
    }

    /* JADX INFO: renamed from: c */
    public static int m741c(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    /* JADX INFO: renamed from: d */
    public static int m742d(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    /* JADX INFO: renamed from: e */
    public static int m743e(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    /* JADX INFO: renamed from: f */
    public static int m744f(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }
}
