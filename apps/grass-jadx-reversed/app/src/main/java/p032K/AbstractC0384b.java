package p032K;

import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: renamed from: K.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0384b {
    /* JADX INFO: renamed from: a */
    public static int m849a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    /* JADX INFO: renamed from: b */
    public static void m850b(AccessibilityEvent accessibilityEvent, int i3) {
        accessibilityEvent.setContentChangeTypes(i3);
    }
}
