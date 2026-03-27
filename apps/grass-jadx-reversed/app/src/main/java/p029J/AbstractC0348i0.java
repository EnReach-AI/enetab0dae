package p029J;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p005B.C0029d;

/* JADX INFO: renamed from: J.i0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0348i0 extends C0360o0 {

    /* JADX INFO: renamed from: h */
    public static boolean f851h = false;

    /* JADX INFO: renamed from: i */
    public static Method f852i;

    /* JADX INFO: renamed from: j */
    public static Class f853j;

    /* JADX INFO: renamed from: k */
    public static Field f854k;

    /* JADX INFO: renamed from: l */
    public static Field f855l;

    /* JADX INFO: renamed from: c */
    public final WindowInsets f856c;

    /* JADX INFO: renamed from: d */
    public C0029d[] f857d;

    /* JADX INFO: renamed from: e */
    public C0029d f858e;

    /* JADX INFO: renamed from: f */
    public C0364q0 f859f;

    /* JADX INFO: renamed from: g */
    public C0029d f860g;

    public AbstractC0348i0(C0364q0 c0364q0, WindowInsets windowInsets) {
        super(c0364q0);
        this.f858e = null;
        this.f856c = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    /* JADX INFO: renamed from: r */
    private C0029d m746r(int i3, boolean z3) {
        C0029d c0029dM139a = C0029d.f80e;
        for (int i4 = 1; i4 <= 256; i4 <<= 1) {
            if ((i3 & i4) != 0) {
                C0029d c0029dM757s = m757s(i4, z3);
                c0029dM139a = C0029d.m139a(Math.max(c0029dM139a.f81a, c0029dM757s.f81a), Math.max(c0029dM139a.f82b, c0029dM757s.f82b), Math.max(c0029dM139a.f83c, c0029dM757s.f83c), Math.max(c0029dM139a.f84d, c0029dM757s.f84d));
            }
        }
        return c0029dM139a;
    }

    /* JADX INFO: renamed from: t */
    private C0029d m747t() {
        C0364q0 c0364q0 = this.f859f;
        return c0364q0 != null ? c0364q0.f874a.mo764h() : C0029d.f80e;
    }

    /* JADX INFO: renamed from: u */
    private C0029d m748u(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!f851h) {
            m749v();
        }
        Method method = f852i;
        if (method != null && f853j != null && f854k != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f854k.get(f855l.get(objInvoke));
                if (rect != null) {
                    return C0029d.m139a(rect.left, rect.top, rect.right, rect.bottom);
                }
                return null;
            } catch (ReflectiveOperationException e3) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e3.getMessage(), e3);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    /* JADX INFO: renamed from: v */
    private static void m749v() {
        try {
            f852i = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f853j = cls;
            f854k = cls.getDeclaredField("mVisibleInsets");
            f855l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f854k.setAccessible(true);
            f855l.setAccessible(true);
        } catch (ReflectiveOperationException e3) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e3.getMessage(), e3);
        }
        f851h = true;
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: d */
    public void mo750d(View view) {
        C0029d c0029dM748u = m748u(view);
        if (c0029dM748u == null) {
            c0029dM748u = C0029d.f80e;
        }
        m758w(c0029dM748u);
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: f */
    public C0029d mo751f(int i3) {
        return m746r(i3, false);
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: j */
    public final C0029d mo752j() {
        if (this.f858e == null) {
            WindowInsets windowInsets = this.f856c;
            this.f858e = C0029d.m139a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f858e;
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: l */
    public C0364q0 mo753l(int i3, int i4, int i5, int i6) {
        C0364q0 c0364q0M829g = C0364q0.m829g(this.f856c, null);
        int i7 = Build.VERSION.SDK_INT;
        AbstractC0346h0 c0344g0 = i7 >= 30 ? new C0344g0(c0364q0M829g) : i7 >= 29 ? new C0342f0(c0364q0M829g) : new C0340e0(c0364q0M829g);
        c0344g0.mo738d(C0364q0.m828e(mo752j(), i3, i4, i5, i6));
        c0344g0.mo737c(C0364q0.m828e(mo764h(), i3, i4, i5, i6));
        return c0344g0.mo736b();
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: n */
    public boolean mo754n() {
        return this.f856c.isRound();
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: o */
    public void mo755o(C0029d[] c0029dArr) {
        this.f857d = c0029dArr;
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: p */
    public void mo756p(C0364q0 c0364q0) {
        this.f859f = c0364q0;
    }

    /* JADX INFO: renamed from: s */
    public C0029d m757s(int i3, boolean z3) {
        C0029d c0029dMo764h;
        int i4;
        if (i3 == 1) {
            return z3 ? C0029d.m139a(0, Math.max(m747t().f82b, mo752j().f82b), 0, 0) : C0029d.m139a(0, mo752j().f82b, 0, 0);
        }
        if (i3 == 2) {
            if (z3) {
                C0029d c0029dM747t = m747t();
                C0029d c0029dMo764h2 = mo764h();
                return C0029d.m139a(Math.max(c0029dM747t.f81a, c0029dMo764h2.f81a), 0, Math.max(c0029dM747t.f83c, c0029dMo764h2.f83c), Math.max(c0029dM747t.f84d, c0029dMo764h2.f84d));
            }
            C0029d c0029dMo752j = mo752j();
            C0364q0 c0364q0 = this.f859f;
            c0029dMo764h = c0364q0 != null ? c0364q0.f874a.mo764h() : null;
            int iMin = c0029dMo752j.f84d;
            if (c0029dMo764h != null) {
                iMin = Math.min(iMin, c0029dMo764h.f84d);
            }
            return C0029d.m139a(c0029dMo752j.f81a, 0, c0029dMo752j.f83c, iMin);
        }
        C0029d c0029d = C0029d.f80e;
        if (i3 == 8) {
            C0029d[] c0029dArr = this.f857d;
            c0029dMo764h = c0029dArr != null ? c0029dArr[3] : null;
            if (c0029dMo764h != null) {
                return c0029dMo764h;
            }
            C0029d c0029dMo752j2 = mo752j();
            C0029d c0029dM747t2 = m747t();
            int i5 = c0029dMo752j2.f84d;
            if (i5 > c0029dM747t2.f84d) {
                return C0029d.m139a(0, 0, 0, i5);
            }
            C0029d c0029d2 = this.f860g;
            return (c0029d2 == null || c0029d2.equals(c0029d) || (i4 = this.f860g.f84d) <= c0029dM747t2.f84d) ? c0029d : C0029d.m139a(0, 0, 0, i4);
        }
        if (i3 == 16) {
            return mo778i();
        }
        if (i3 == 32) {
            return mo777g();
        }
        if (i3 == 64) {
            return mo779k();
        }
        if (i3 != 128) {
            return c0029d;
        }
        C0364q0 c0364q02 = this.f859f;
        C0347i c0347iMo768e = c0364q02 != null ? c0364q02.f874a.mo768e() : mo768e();
        if (c0347iMo768e == null) {
            return c0029d;
        }
        DisplayCutout displayCutout = c0347iMo768e.f850a;
        return C0029d.m139a(AbstractC0345h.m742d(displayCutout), AbstractC0345h.m744f(displayCutout), AbstractC0345h.m743e(displayCutout), AbstractC0345h.m741c(displayCutout));
    }

    /* JADX INFO: renamed from: w */
    public void m758w(C0029d c0029d) {
        this.f860g = c0029d;
    }
}
