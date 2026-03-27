package p029J;

import android.graphics.Rect;
import android.view.Gravity;

/* JADX INFO: renamed from: J.j */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0349j {
    /* JADX INFO: renamed from: a */
    public static void m759a(int i3, int i4, int i5, Rect rect, int i6, int i7, Rect rect2, int i8) {
        Gravity.apply(i3, i4, i5, rect, i6, i7, rect2, i8);
    }

    /* JADX INFO: renamed from: b */
    public static void m760b(int i3, int i4, int i5, Rect rect, Rect rect2, int i6) {
        Gravity.apply(i3, i4, i5, rect, rect2, i6);
    }

    /* JADX INFO: renamed from: c */
    public static void m761c(int i3, Rect rect, Rect rect2, int i4) {
        Gravity.applyDisplay(i3, rect, rect2, i4);
    }
}
