package p029J;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: renamed from: J.I */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0314I {
    /* JADX INFO: renamed from: a */
    public static C0364q0 m654a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        C0364q0 c0364q0M829g = C0364q0.m829g(rootWindowInsets, null);
        C0360o0 c0360o0 = c0364q0M829g.f874a;
        c0360o0.mo756p(c0364q0M829g);
        c0360o0.mo750d(view.getRootView());
        return c0364q0M829g;
    }

    /* JADX INFO: renamed from: b */
    public static int m655b(View view) {
        return view.getScrollIndicators();
    }

    /* JADX INFO: renamed from: c */
    public static void m656c(View view, int i3) {
        view.setScrollIndicators(i3);
    }

    /* JADX INFO: renamed from: d */
    public static void m657d(View view, int i3, int i4) {
        view.setScrollIndicators(i3, i4);
    }
}
