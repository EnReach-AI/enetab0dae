package p032K;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import java.util.WeakHashMap;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p034K1.C0423j;
import p034K1.C0425l;
import p125o0.AbstractC1794d;

/* JADX INFO: renamed from: K.e */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityManagerTouchExplorationStateChangeListenerC0387e implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a */
    public final InterfaceC0386d f907a;

    public AccessibilityManagerTouchExplorationStateChangeListenerC0387e(InterfaceC0386d interfaceC0386d) {
        this.f907a = interfaceC0386d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessibilityManagerTouchExplorationStateChangeListenerC0387e) {
            return this.f907a.equals(((AccessibilityManagerTouchExplorationStateChangeListenerC0387e) obj).f907a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f907a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z3) {
        C0425l c0425l = (C0425l) ((C0423j) this.f907a).f964a;
        AutoCompleteTextView autoCompleteTextView = c0425l.f970h;
        if (autoCompleteTextView == null || AbstractC1794d.m3951g(autoCompleteTextView)) {
            return;
        }
        int i3 = z3 ? 2 : 1;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m603s(c0425l.f1014d, i3);
    }
}
