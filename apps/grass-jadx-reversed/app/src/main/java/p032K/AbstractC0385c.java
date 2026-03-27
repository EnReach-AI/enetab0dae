package p032K;

import android.view.accessibility.AccessibilityManager;

/* JADX INFO: renamed from: K.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0385c {
    /* JADX INFO: renamed from: a */
    public static boolean m851a(AccessibilityManager accessibilityManager, InterfaceC0386d interfaceC0386d) {
        return accessibilityManager.addTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC0387e(interfaceC0386d));
    }

    /* JADX INFO: renamed from: b */
    public static boolean m852b(AccessibilityManager accessibilityManager, InterfaceC0386d interfaceC0386d) {
        return accessibilityManager.removeTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC0387e(interfaceC0386d));
    }
}
