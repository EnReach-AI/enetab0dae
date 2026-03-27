package p073Z;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import p029J.C0335c;
import p032K.C0391i;

/* JADX INFO: renamed from: Z.Z */
/* JADX INFO: loaded from: classes.dex */
public final class C0779Z extends C0335c {

    /* JADX INFO: renamed from: d */
    public final RecyclerView f2222d;

    /* JADX INFO: renamed from: e */
    public final C0778Y f2223e;

    public C0779Z(RecyclerView recyclerView) {
        this.f2222d = recyclerView;
        C0778Y c0778y = this.f2223e;
        if (c0778y != null) {
            this.f2223e = c0778y;
        } else {
            this.f2223e = new C0778Y(this);
        }
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: c */
    public final void mo191c(View view, AccessibilityEvent accessibilityEvent) {
        super.mo191c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.f2222d.m2585K()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().mo1975O(accessibilityEvent);
        }
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: d */
    public final void mo192d(View view, C0391i c0391i) {
        View.AccessibilityDelegate accessibilityDelegate = this.f830a;
        AccessibilityNodeInfo accessibilityNodeInfo = c0391i.f920a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        RecyclerView recyclerView = this.f2222d;
        if (recyclerView.m2585K() || recyclerView.getLayoutManager() == null) {
            return;
        }
        AbstractC0763I layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f2140b;
        C0769O c0769o = recyclerView2.f3414f;
        if (recyclerView2.canScrollVertically(-1) || layoutManager.f2140b.canScrollHorizontally(-1)) {
            c0391i.m868a(8192);
            accessibilityNodeInfo.setScrollable(true);
        }
        if (layoutManager.f2140b.canScrollVertically(1) || layoutManager.f2140b.canScrollHorizontally(1)) {
            c0391i.m868a(4096);
            accessibilityNodeInfo.setScrollable(true);
        }
        C0774U c0774u = recyclerView2.f3417g0;
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(layoutManager.mo1968F(c0769o, c0774u), layoutManager.mo2028x(c0769o, c0774u), false, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056 A[PHI: r0
      0x0056: PHI (r0v8 int) = (r0v4 int), (r0v12 int) binds: [B:27:0x0073, B:19:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p029J.C0335c
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo727g(android.view.View r4, int r5, android.os.Bundle r6) {
        /*
            r3 = this;
            boolean r4 = super.mo727g(r4, r5, r6)
            r6 = 1
            if (r4 == 0) goto L8
            return r6
        L8:
            androidx.recyclerview.widget.RecyclerView r4 = r3.f2222d
            boolean r0 = r4.m2585K()
            r1 = 0
            if (r0 != 0) goto L8d
            Z.I r0 = r4.getLayoutManager()
            if (r0 == 0) goto L8d
            Z.I r4 = r4.getLayoutManager()
            androidx.recyclerview.widget.RecyclerView r0 = r4.f2140b
            Z.O r2 = r0.f3414f
            r2 = 4096(0x1000, float:5.74E-42)
            if (r5 == r2) goto L58
            r2 = 8192(0x2000, float:1.148E-41)
            if (r5 == r2) goto L2a
            r5 = r1
            r0 = r5
            goto L81
        L2a:
            r5 = -1
            boolean r0 = r0.canScrollVertically(r5)
            if (r0 == 0) goto L3f
            int r0 = r4.f2153o
            int r2 = r4.m1967C()
            int r0 = r0 - r2
            int r2 = r4.m2029z()
            int r0 = r0 - r2
            int r0 = -r0
            goto L40
        L3f:
            r0 = r1
        L40:
            androidx.recyclerview.widget.RecyclerView r2 = r4.f2140b
            boolean r5 = r2.canScrollHorizontally(r5)
            if (r5 == 0) goto L56
            int r5 = r4.f2152n
            int r2 = r4.m1965A()
            int r5 = r5 - r2
            int r2 = r4.m1966B()
            int r5 = r5 - r2
            int r5 = -r5
            goto L81
        L56:
            r5 = r1
            goto L81
        L58:
            boolean r5 = r0.canScrollVertically(r6)
            if (r5 == 0) goto L6c
            int r5 = r4.f2153o
            int r0 = r4.m1967C()
            int r5 = r5 - r0
            int r0 = r4.m2029z()
            int r5 = r5 - r0
            r0 = r5
            goto L6d
        L6c:
            r0 = r1
        L6d:
            androidx.recyclerview.widget.RecyclerView r5 = r4.f2140b
            boolean r5 = r5.canScrollHorizontally(r6)
            if (r5 == 0) goto L56
            int r5 = r4.f2152n
            int r2 = r4.m1965A()
            int r5 = r5 - r2
            int r2 = r4.m1966B()
            int r5 = r5 - r2
        L81:
            if (r0 != 0) goto L87
            if (r5 != 0) goto L87
            r6 = r1
            goto L8c
        L87:
            androidx.recyclerview.widget.RecyclerView r4 = r4.f2140b
            r4.m2602b0(r5, r0, r6)
        L8c:
            return r6
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p073Z.C0779Z.mo727g(android.view.View, int, android.os.Bundle):boolean");
    }
}
