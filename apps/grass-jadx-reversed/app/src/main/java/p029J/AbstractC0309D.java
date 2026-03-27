package p029J;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: renamed from: J.D */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0309D {
    /* JADX INFO: renamed from: a */
    public static Rect m615a(View view) {
        return view.getClipBounds();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m616b(View view) {
        return view.isInLayout();
    }

    /* JADX INFO: renamed from: c */
    public static void m617c(View view, Rect rect) {
        view.setClipBounds(rect);
    }
}
