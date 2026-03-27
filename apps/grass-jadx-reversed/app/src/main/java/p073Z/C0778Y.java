package p073Z;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;
import p029J.C0335c;
import p031J1.C0382f;
import p032K.C0391i;

/* JADX INFO: renamed from: Z.Y */
/* JADX INFO: loaded from: classes.dex */
public final class C0778Y extends C0335c {

    /* JADX INFO: renamed from: d */
    public final C0779Z f2220d;

    /* JADX INFO: renamed from: e */
    public final WeakHashMap f2221e = new WeakHashMap();

    public C0778Y(C0779Z c0779z) {
        this.f2220d = c0779z;
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: a */
    public final boolean mo723a(View view, AccessibilityEvent accessibilityEvent) {
        C0335c c0335c = (C0335c) this.f2221e.get(view);
        return c0335c != null ? c0335c.mo723a(view, accessibilityEvent) : this.f830a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: b */
    public final C0382f mo724b(View view) {
        C0335c c0335c = (C0335c) this.f2221e.get(view);
        return c0335c != null ? c0335c.mo724b(view) : super.mo724b(view);
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: c */
    public final void mo191c(View view, AccessibilityEvent accessibilityEvent) {
        C0335c c0335c = (C0335c) this.f2221e.get(view);
        if (c0335c != null) {
            c0335c.mo191c(view, accessibilityEvent);
        } else {
            super.mo191c(view, accessibilityEvent);
        }
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: d */
    public final void mo192d(View view, C0391i c0391i) {
        C0779Z c0779z = this.f2220d;
        boolean zM2585K = c0779z.f2222d.m2585K();
        View.AccessibilityDelegate accessibilityDelegate = this.f830a;
        AccessibilityNodeInfo accessibilityNodeInfo = c0391i.f920a;
        if (!zM2585K) {
            RecyclerView recyclerView = c0779z.f2222d;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().m1977Q(view, c0391i);
                C0335c c0335c = (C0335c) this.f2221e.get(view);
                if (c0335c != null) {
                    c0335c.mo192d(view, c0391i);
                    return;
                } else {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    return;
                }
            }
        }
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: e */
    public final void mo725e(View view, AccessibilityEvent accessibilityEvent) {
        C0335c c0335c = (C0335c) this.f2221e.get(view);
        if (c0335c != null) {
            c0335c.mo725e(view, accessibilityEvent);
        } else {
            super.mo725e(view, accessibilityEvent);
        }
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: f */
    public final boolean mo726f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        C0335c c0335c = (C0335c) this.f2221e.get(viewGroup);
        return c0335c != null ? c0335c.mo726f(viewGroup, view, accessibilityEvent) : this.f830a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: g */
    public final boolean mo727g(View view, int i3, Bundle bundle) {
        C0779Z c0779z = this.f2220d;
        if (!c0779z.f2222d.m2585K()) {
            RecyclerView recyclerView = c0779z.f2222d;
            if (recyclerView.getLayoutManager() != null) {
                C0335c c0335c = (C0335c) this.f2221e.get(view);
                if (c0335c != null) {
                    if (c0335c.mo727g(view, i3, bundle)) {
                        return true;
                    }
                } else if (super.mo727g(view, i3, bundle)) {
                    return true;
                }
                C0769O c0769o = recyclerView.getLayoutManager().f2140b.f3414f;
                return false;
            }
        }
        return super.mo727g(view, i3, bundle);
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: h */
    public final void mo728h(View view, int i3) {
        C0335c c0335c = (C0335c) this.f2221e.get(view);
        if (c0335c != null) {
            c0335c.mo728h(view, i3);
        } else {
            super.mo728h(view, i3);
        }
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: i */
    public final void mo729i(View view, AccessibilityEvent accessibilityEvent) {
        C0335c c0335c = (C0335c) this.f2221e.get(view);
        if (c0335c != null) {
            c0335c.mo729i(view, accessibilityEvent);
        } else {
            super.mo729i(view, accessibilityEvent);
        }
    }
}
