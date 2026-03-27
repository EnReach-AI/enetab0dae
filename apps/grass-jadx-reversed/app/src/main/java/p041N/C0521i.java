package p041N;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p029J.C0335c;
import p032K.AbstractC0393k;
import p032K.C0390h;
import p032K.C0391i;

/* JADX INFO: renamed from: N.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0521i extends C0335c {

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f1217d;

    public /* synthetic */ C0521i(int i3) {
        this.f1217d = i3;
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: c */
    public void mo191c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f1217d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                super.mo191c(view, accessibilityEvent);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                accessibilityEvent.setClassName(ScrollView.class.getName());
                accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
                accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
                accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
                AbstractC0393k.m876c(accessibilityEvent, nestedScrollView.getScrollX());
                AbstractC0393k.m877d(accessibilityEvent, nestedScrollView.getScrollRange());
                break;
            default:
                super.mo191c(view, accessibilityEvent);
                break;
        }
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: d */
    public final void mo192d(View view, C0391i c0391i) {
        int scrollRange;
        switch (this.f1217d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                View.AccessibilityDelegate accessibilityDelegate = this.f830a;
                AccessibilityNodeInfo accessibilityNodeInfo = c0391i.f920a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                accessibilityNodeInfo.setClassName(ScrollView.class.getName());
                if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                    accessibilityNodeInfo.setScrollable(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        c0391i.m869b(C0390h.f910g);
                        c0391i.m869b(C0390h.f914k);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        c0391i.m869b(C0390h.f909f);
                        c0391i.m869b(C0390h.f915l);
                    }
                    break;
                }
                break;
            case 1:
                View.AccessibilityDelegate accessibilityDelegate2 = this.f830a;
                AccessibilityNodeInfo accessibilityNodeInfo2 = c0391i.f920a;
                accessibilityDelegate2.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                accessibilityNodeInfo2.setCollectionInfo(null);
                break;
            case 2:
                View.AccessibilityDelegate accessibilityDelegate3 = this.f830a;
                AccessibilityNodeInfo accessibilityNodeInfo3 = c0391i.f920a;
                accessibilityDelegate3.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                accessibilityNodeInfo3.setScrollable(false);
                break;
            default:
                View.AccessibilityDelegate accessibilityDelegate4 = this.f830a;
                AccessibilityNodeInfo accessibilityNodeInfo4 = c0391i.f920a;
                accessibilityDelegate4.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo4);
                accessibilityNodeInfo4.setCollectionInfo(null);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    @Override // p029J.C0335c
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo727g(android.view.View r5, int r6, android.os.Bundle r7) {
        /*
            r4 = this;
            int r0 = r4.f1217d
            switch(r0) {
                case 0: goto La;
                default: goto L5;
            }
        L5:
            boolean r5 = super.mo727g(r5, r6, r7)
            return r5
        La:
            boolean r7 = super.mo727g(r5, r6, r7)
            r0 = 1
            if (r7 == 0) goto L13
            goto La0
        L13:
            androidx.core.widget.NestedScrollView r5 = (androidx.core.widget.NestedScrollView) r5
            boolean r7 = r5.isEnabled()
            r1 = 0
            if (r7 != 0) goto L1f
        L1c:
            r0 = r1
            goto La0
        L1f:
            int r7 = r5.getHeight()
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.graphics.Matrix r3 = r5.getMatrix()
            boolean r3 = r3.isIdentity()
            if (r3 == 0) goto L3c
            boolean r3 = r5.getGlobalVisibleRect(r2)
            if (r3 == 0) goto L3c
            int r7 = r2.height()
        L3c:
            r2 = 4096(0x1000, float:5.74E-42)
            if (r6 == r2) goto L76
            r2 = 8192(0x2000, float:1.148E-41)
            if (r6 == r2) goto L4f
            r2 = 16908344(0x1020038, float:2.3877386E-38)
            if (r6 == r2) goto L4f
            r2 = 16908346(0x102003a, float:2.3877392E-38)
            if (r6 == r2) goto L76
            goto L1c
        L4f:
            int r6 = r5.getPaddingBottom()
            int r7 = r7 - r6
            int r6 = r5.getPaddingTop()
            int r7 = r7 - r6
            int r6 = r5.getScrollY()
            int r6 = r6 - r7
            int r6 = java.lang.Math.max(r6, r1)
            int r7 = r5.getScrollY()
            if (r6 == r7) goto L1c
            int r7 = r5.getScrollX()
            int r1 = r1 - r7
            int r7 = r5.getScrollY()
            int r6 = r6 - r7
            r5.m2332t(r1, r6, r0)
            goto La0
        L76:
            int r6 = r5.getPaddingBottom()
            int r7 = r7 - r6
            int r6 = r5.getPaddingTop()
            int r7 = r7 - r6
            int r6 = r5.getScrollY()
            int r6 = r6 + r7
            int r7 = r5.getScrollRange()
            int r6 = java.lang.Math.min(r6, r7)
            int r7 = r5.getScrollY()
            if (r6 == r7) goto L1c
            int r7 = r5.getScrollX()
            int r1 = r1 - r7
            int r7 = r5.getScrollY()
            int r6 = r6 - r7
            r5.m2332t(r1, r6, r0)
        La0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p041N.C0521i.mo727g(android.view.View, int, android.os.Bundle):boolean");
    }
}
