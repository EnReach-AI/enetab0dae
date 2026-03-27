package p032K;

import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: renamed from: K.k */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0393k {
    /* JADX INFO: renamed from: a */
    public static int m874a(AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollX();
    }

    /* JADX INFO: renamed from: b */
    public static int m875b(AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollY();
    }

    /* JADX INFO: renamed from: c */
    public static void m876c(AccessibilityRecord accessibilityRecord, int i3) {
        accessibilityRecord.setMaxScrollX(i3);
    }

    /* JADX INFO: renamed from: d */
    public static void m877d(AccessibilityRecord accessibilityRecord, int i3) {
        accessibilityRecord.setMaxScrollY(i3);
    }
}
