package p029J;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX INFO: renamed from: J.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0333b {
    /* JADX INFO: renamed from: a */
    public static AccessibilityNodeProvider m720a(View.AccessibilityDelegate accessibilityDelegate, View view) {
        return accessibilityDelegate.getAccessibilityNodeProvider(view);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m721b(View.AccessibilityDelegate accessibilityDelegate, View view, int i3, Bundle bundle) {
        return accessibilityDelegate.performAccessibilityAction(view, i3, bundle);
    }
}
