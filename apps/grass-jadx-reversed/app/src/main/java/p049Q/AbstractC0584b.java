package p049Q;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p019F0.C0217a;
import p019F0.C0222f;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p029J.C0335c;
import p031J1.C0382f;
import p032K.AbstractC0394l;
import p032K.C0391i;
import p157w1.C1994c;

/* JADX INFO: renamed from: Q.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0584b extends C0335c {

    /* JADX INFO: renamed from: n */
    public static final Rect f1458n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: o */
    public static final C0217a f1459o = new C0217a(3);

    /* JADX INFO: renamed from: p */
    public static final C0222f f1460p = new C0222f(3);

    /* JADX INFO: renamed from: h */
    public final AccessibilityManager f1465h;

    /* JADX INFO: renamed from: i */
    public final View f1466i;

    /* JADX INFO: renamed from: j */
    public C0583a f1467j;

    /* JADX INFO: renamed from: d */
    public final Rect f1461d = new Rect();

    /* JADX INFO: renamed from: e */
    public final Rect f1462e = new Rect();

    /* JADX INFO: renamed from: f */
    public final Rect f1463f = new Rect();

    /* JADX INFO: renamed from: g */
    public final int[] f1464g = new int[2];

    /* JADX INFO: renamed from: k */
    public int f1468k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: l */
    public int f1469l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m */
    public int f1470m = Integer.MIN_VALUE;

    public AbstractC0584b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f1466i = view;
        this.f1465h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (AbstractC0307B.m587c(view) == 0) {
            AbstractC0307B.m603s(view, 1);
        }
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: b */
    public final C0382f mo724b(View view) {
        if (this.f1467j == null) {
            this.f1467j = new C0583a(this);
        }
        return this.f1467j;
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: d */
    public final void mo192d(View view, C0391i c0391i) {
        View.AccessibilityDelegate accessibilityDelegate = this.f830a;
        AccessibilityNodeInfo accessibilityNodeInfo = c0391i.f920a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = ((C1994c) this).f7069q;
        accessibilityNodeInfo.setCheckable(chip.m3171d());
        accessibilityNodeInfo.setClickable(chip.isClickable());
        accessibilityNodeInfo.setClassName(chip.getAccessibilityClassName());
        accessibilityNodeInfo.setText(chip.getText());
    }

    /* JADX INFO: renamed from: j */
    public final boolean m1309j(int i3) {
        if (this.f1469l != i3) {
            return false;
        }
        this.f1469l = Integer.MIN_VALUE;
        C1994c c1994c = (C1994c) this;
        if (i3 == 1) {
            Chip chip = c1994c.f7069q;
            chip.f4330q = false;
            chip.refreshDrawableState();
        }
        m1316q(i3, 8);
        return true;
    }

    /* JADX INFO: renamed from: k */
    public final C0391i m1310k(int i3) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        C0391i c0391i = new C0391i(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        accessibilityNodeInfoObtain.setClassName("android.view.View");
        Rect rect = f1458n;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        c0391i.f921b = -1;
        View view = this.f1466i;
        accessibilityNodeInfoObtain.setParent(view);
        mo1314o(i3, c0391i);
        if (c0391i.m872e() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f1462e;
        c0391i.m871d(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(view.getContext().getPackageName());
        c0391i.f922c = i3;
        accessibilityNodeInfoObtain.setSource(view, i3);
        if (this.f1468k == i3) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            c0391i.m868a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            c0391i.m868a(64);
        }
        boolean z3 = this.f1469l == i3;
        if (z3) {
            c0391i.m868a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            c0391i.m868a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z3);
        int[] iArr = this.f1464g;
        view.getLocationOnScreen(iArr);
        Rect rect3 = this.f1461d;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            c0391i.m871d(rect3);
            if (c0391i.f921b != -1) {
                C0391i c0391i2 = new C0391i(AccessibilityNodeInfo.obtain());
                int i4 = c0391i.f921b;
                while (true) {
                    accessibilityNodeInfo = c0391i2.f920a;
                    if (i4 == -1) {
                        break;
                    }
                    c0391i2.f921b = -1;
                    accessibilityNodeInfo.setParent(view, -1);
                    accessibilityNodeInfo.setBoundsInParent(rect);
                    mo1314o(i4, c0391i2);
                    c0391i2.m871d(rect2);
                    rect3.offset(rect2.left, rect2.top);
                    i4 = c0391i2.f921b;
                }
                accessibilityNodeInfo.recycle();
            }
            rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
        }
        Rect rect4 = this.f1463f;
        if (view.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect4)) {
                c0391i.f920a.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    Object parent = view.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view2 = (View) parent;
                            if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                break;
                            }
                            parent = view2.getParent();
                        } else if (parent != null) {
                            accessibilityNodeInfoObtain.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return c0391i;
    }

    /* JADX INFO: renamed from: l */
    public abstract void mo1311l(ArrayList arrayList);

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a7  */
    /* JADX INFO: renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m1312m(int r20, android.graphics.Rect r21) {
        /*
            Method dump skipped, instruction units count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p049Q.AbstractC0584b.m1312m(int, android.graphics.Rect):boolean");
    }

    /* JADX INFO: renamed from: n */
    public final C0391i m1313n(int i3) {
        if (i3 != -1) {
            return m1310k(i3);
        }
        View view = this.f1466i;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
        C0391i c0391i = new C0391i(accessibilityNodeInfoObtain);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        mo1311l(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            c0391i.f920a.addChild(view, ((Integer) arrayList.get(i4)).intValue());
        }
        return c0391i;
    }

    /* JADX INFO: renamed from: o */
    public abstract void mo1314o(int i3, C0391i c0391i);

    /* JADX INFO: renamed from: p */
    public final boolean m1315p(int i3) {
        int i4;
        View view = this.f1466i;
        if ((!view.isFocused() && !view.requestFocus()) || (i4 = this.f1469l) == i3) {
            return false;
        }
        if (i4 != Integer.MIN_VALUE) {
            m1309j(i4);
        }
        if (i3 == Integer.MIN_VALUE) {
            return false;
        }
        this.f1469l = i3;
        C1994c c1994c = (C1994c) this;
        if (i3 == 1) {
            Chip chip = c1994c.f7069q;
            chip.f4330q = true;
            chip.refreshDrawableState();
        }
        m1316q(i3, 8);
        return true;
    }

    /* JADX INFO: renamed from: q */
    public final void m1316q(int i3, int i4) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i3 == Integer.MIN_VALUE || !this.f1465h.isEnabled() || (parent = (view = this.f1466i).getParent()) == null) {
            return;
        }
        if (i3 != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i4);
            C0391i c0391iM1313n = m1313n(i3);
            accessibilityEventObtain.getText().add(c0391iM1313n.m872e());
            AccessibilityNodeInfo accessibilityNodeInfo = c0391iM1313n.f920a;
            accessibilityEventObtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            accessibilityEventObtain.setScrollable(accessibilityNodeInfo.isScrollable());
            accessibilityEventObtain.setPassword(accessibilityNodeInfo.isPassword());
            accessibilityEventObtain.setEnabled(accessibilityNodeInfo.isEnabled());
            accessibilityEventObtain.setChecked(accessibilityNodeInfo.isChecked());
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(accessibilityNodeInfo.getClassName());
            AbstractC0394l.m878a(accessibilityEventObtain, view, i3);
            accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i4);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }
}
