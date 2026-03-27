package p029J;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import io.getgrass.www.R;
import p005B.C0029d;

/* JADX INFO: renamed from: J.H */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0313H {
    /* JADX INFO: renamed from: a */
    public static void m628a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    /* JADX INFO: renamed from: b */
    public static C0364q0 m629b(View view, C0364q0 c0364q0, Rect rect) {
        WindowInsets windowInsetsM834f = c0364q0.m834f();
        if (windowInsetsM834f != null) {
            return C0364q0.m829g(view.computeSystemWindowInsets(windowInsetsM834f, rect), view);
        }
        rect.setEmpty();
        return c0364q0;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m630c(View view, float f3, float f4, boolean z3) {
        return view.dispatchNestedFling(f3, f4, z3);
    }

    /* JADX INFO: renamed from: d */
    public static boolean m631d(View view, float f3, float f4) {
        return view.dispatchNestedPreFling(f3, f4);
    }

    /* JADX INFO: renamed from: e */
    public static boolean m632e(View view, int i3, int i4, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i3, i4, iArr, iArr2);
    }

    /* JADX INFO: renamed from: f */
    public static boolean m633f(View view, int i3, int i4, int i5, int i6, int[] iArr) {
        return view.dispatchNestedScroll(i3, i4, i5, i6, iArr);
    }

    /* JADX INFO: renamed from: g */
    public static ColorStateList m634g(View view) {
        return view.getBackgroundTintList();
    }

    /* JADX INFO: renamed from: h */
    public static PorterDuff.Mode m635h(View view) {
        return view.getBackgroundTintMode();
    }

    /* JADX INFO: renamed from: i */
    public static float m636i(View view) {
        return view.getElevation();
    }

    /* JADX INFO: renamed from: j */
    public static C0364q0 m637j(View view) {
        if (!AbstractC0338d0.f835d || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = AbstractC0338d0.f832a.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) AbstractC0338d0.f833b.get(obj);
            Rect rect2 = (Rect) AbstractC0338d0.f834c.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            AbstractC0346h0 c0344g0 = i3 >= 30 ? new C0344g0() : i3 >= 29 ? new C0342f0() : new C0340e0();
            c0344g0.mo737c(C0029d.m139a(rect.left, rect.top, rect.right, rect.bottom));
            c0344g0.mo738d(C0029d.m139a(rect2.left, rect2.top, rect2.right, rect2.bottom));
            C0364q0 c0364q0Mo736b = c0344g0.mo736b();
            c0364q0Mo736b.f874a.mo756p(c0364q0Mo736b);
            c0364q0Mo736b.f874a.mo750d(view.getRootView());
            return c0364q0Mo736b;
        } catch (IllegalAccessException e3) {
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e3.getMessage(), e3);
            return null;
        }
    }

    /* JADX INFO: renamed from: k */
    public static String m638k(View view) {
        return view.getTransitionName();
    }

    /* JADX INFO: renamed from: l */
    public static float m639l(View view) {
        return view.getTranslationZ();
    }

    /* JADX INFO: renamed from: m */
    public static float m640m(View view) {
        return view.getZ();
    }

    /* JADX INFO: renamed from: n */
    public static boolean m641n(View view) {
        return view.hasNestedScrollingParent();
    }

    /* JADX INFO: renamed from: o */
    public static boolean m642o(View view) {
        return view.isImportantForAccessibility();
    }

    /* JADX INFO: renamed from: p */
    public static boolean m643p(View view) {
        return view.isNestedScrollingEnabled();
    }

    /* JADX INFO: renamed from: q */
    public static void m644q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    /* JADX INFO: renamed from: r */
    public static void m645r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    /* JADX INFO: renamed from: s */
    public static void m646s(View view, float f3) {
        view.setElevation(f3);
    }

    /* JADX INFO: renamed from: t */
    public static void m647t(View view, boolean z3) {
        view.setNestedScrollingEnabled(z3);
    }

    /* JADX INFO: renamed from: u */
    public static void m648u(View view, InterfaceC0367s interfaceC0367s) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, interfaceC0367s);
        }
        if (interfaceC0367s == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC0312G(view, interfaceC0367s));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m649v(View view, String str) {
        view.setTransitionName(str);
    }

    /* JADX INFO: renamed from: w */
    public static void m650w(View view, float f3) {
        view.setTranslationZ(f3);
    }

    /* JADX INFO: renamed from: x */
    public static void m651x(View view, float f3) {
        view.setZ(f3);
    }

    /* JADX INFO: renamed from: y */
    public static boolean m652y(View view, int i3) {
        return view.startNestedScroll(i3);
    }

    /* JADX INFO: renamed from: z */
    public static void m653z(View view) {
        view.stopNestedScroll();
    }
}
