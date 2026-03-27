package p032K;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
import p031J1.C0382f;

/* JADX INFO: renamed from: K.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0392j extends AccessibilityNodeProvider {

    /* JADX INFO: renamed from: a */
    public final C0382f f923a;

    public C0392j(C0382f c0382f) {
        this.f923a = c0382f;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final void addExtraDataToAccessibilityNodeInfo(int i3, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        this.f923a.getClass();
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i3) {
        C0391i c0391iMo846a = this.f923a.mo846a(i3);
        if (c0391iMo846a == null) {
            return null;
        }
        return c0391iMo846a.f920a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i3) {
        this.f923a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i3) {
        C0391i c0391iMo847b = this.f923a.mo847b(i3);
        if (c0391iMo847b == null) {
            return null;
        }
        return c0391iMo847b.f920a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i3, int i4, Bundle bundle) {
        return this.f923a.mo848c(i3, i4, bundle);
    }
}
