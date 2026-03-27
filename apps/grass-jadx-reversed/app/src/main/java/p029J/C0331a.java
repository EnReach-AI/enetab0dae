package p029J;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import io.getgrass.www.R;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import p031J1.C0382f;
import p032K.C0390h;
import p032K.C0391i;

/* JADX INFO: renamed from: J.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0331a extends View.AccessibilityDelegate {

    /* JADX INFO: renamed from: a */
    public final C0335c f828a;

    public C0331a(C0335c c0335c) {
        this.f828a = c0335c;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f828a.mo723a(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        C0382f c0382fMo724b = this.f828a.mo724b(view);
        if (c0382fMo724b != null) {
            return (AccessibilityNodeProvider) c0382fMo724b.f903a;
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f828a.mo191c(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Object tag;
        C0391i c0391i = new C0391i(accessibilityNodeInfo);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        accessibilityNodeInfo.setScreenReaderFocusable(Boolean.valueOf(AbstractC0317L.m676d(view)).booleanValue());
        accessibilityNodeInfo.setHeading(Boolean.valueOf(AbstractC0317L.m675c(view)).booleanValue());
        accessibilityNodeInfo.setPaneTitle(AbstractC0317L.m674b(view));
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            tag = AbstractC0319N.m686a(view);
        } else {
            tag = view.getTag(R.id.tag_state_description);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        CharSequence charSequence = (CharSequence) tag;
        if (i3 >= 30) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
        this.f828a.mo192d(view, c0391i);
        accessibilityNodeInfo.getText();
        List listEmptyList = (List) view.getTag(R.id.tag_accessibility_actions);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        for (int i4 = 0; i4 < listEmptyList.size(); i4++) {
            c0391i.m869b((C0390h) listEmptyList.get(i4));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f828a.mo725e(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f828a.mo726f(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
        return this.f828a.mo727g(view, i3, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View view, int i3) {
        this.f828a.mo728h(view, i3);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f828a.mo729i(view, accessibilityEvent);
    }
}
