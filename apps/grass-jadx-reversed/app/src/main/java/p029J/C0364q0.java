package p029J;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;
import p005B.C0029d;
import p026I.AbstractC0294b;

/* JADX INFO: renamed from: J.q0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0364q0 {

    /* JADX INFO: renamed from: b */
    public static final C0364q0 f873b;

    /* JADX INFO: renamed from: a */
    public final C0360o0 f874a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f873b = C0358n0.f865q;
        } else {
            f873b = C0360o0.f871b;
        }
    }

    public C0364q0(WindowInsets windowInsets) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            this.f874a = new C0358n0(this, windowInsets);
        } else if (i3 >= 29) {
            this.f874a = new C0354l0(this, windowInsets);
        } else {
            this.f874a = new C0352k0(this, windowInsets);
        }
    }

    /* JADX INFO: renamed from: e */
    public static C0029d m828e(C0029d c0029d, int i3, int i4, int i5, int i6) {
        int iMax = Math.max(0, c0029d.f81a - i3);
        int iMax2 = Math.max(0, c0029d.f82b - i4);
        int iMax3 = Math.max(0, c0029d.f83c - i5);
        int iMax4 = Math.max(0, c0029d.f84d - i6);
        return (iMax == i3 && iMax2 == i4 && iMax3 == i5 && iMax4 == i6) ? c0029d : C0029d.m139a(iMax, iMax2, iMax3, iMax4);
    }

    /* JADX INFO: renamed from: g */
    public static C0364q0 m829g(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        C0364q0 c0364q0 = new C0364q0(windowInsets);
        if (view != null) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            if (AbstractC0310E.m619b(view)) {
                C0364q0 c0364q0M654a = AbstractC0314I.m654a(view);
                C0360o0 c0360o0 = c0364q0.f874a;
                c0360o0.mo756p(c0364q0M654a);
                c0360o0.mo750d(view.getRootView());
            }
        }
        return c0364q0;
    }

    /* JADX INFO: renamed from: a */
    public final int m830a() {
        return this.f874a.mo752j().f84d;
    }

    /* JADX INFO: renamed from: b */
    public final int m831b() {
        return this.f874a.mo752j().f81a;
    }

    /* JADX INFO: renamed from: c */
    public final int m832c() {
        return this.f874a.mo752j().f83c;
    }

    /* JADX INFO: renamed from: d */
    public final int m833d() {
        return this.f874a.mo752j().f82b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0364q0)) {
            return false;
        }
        return AbstractC0294b.m569a(this.f874a, ((C0364q0) obj).f874a);
    }

    /* JADX INFO: renamed from: f */
    public final WindowInsets m834f() {
        C0360o0 c0360o0 = this.f874a;
        if (c0360o0 instanceof AbstractC0348i0) {
            return ((AbstractC0348i0) c0360o0).f856c;
        }
        return null;
    }

    public final int hashCode() {
        C0360o0 c0360o0 = this.f874a;
        if (c0360o0 == null) {
            return 0;
        }
        return c0360o0.hashCode();
    }

    public C0364q0() {
        this.f874a = new C0360o0(this);
    }
}
