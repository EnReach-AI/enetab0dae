package p029J;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

/* JADX INFO: renamed from: J.M */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0318M {
    /* JADX INFO: renamed from: a */
    public static View.AccessibilityDelegate m682a(View view) {
        return view.getAccessibilityDelegate();
    }

    /* JADX INFO: renamed from: b */
    public static List<Rect> m683b(View view) {
        return view.getSystemGestureExclusionRects();
    }

    /* JADX INFO: renamed from: c */
    public static void m684c(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i3, int i4) {
        view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i3, i4);
    }

    /* JADX INFO: renamed from: d */
    public static void m685d(View view, List<Rect> list) {
        view.setSystemGestureExclusionRects(list);
    }
}
