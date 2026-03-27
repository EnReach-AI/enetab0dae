package p073Z;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: Z.u */
/* JADX INFO: loaded from: classes.dex */
public class C0809u {

    /* JADX INFO: renamed from: a */
    public int f2392a = -1;

    /* JADX INFO: renamed from: b */
    public RecyclerView f2393b;

    /* JADX INFO: renamed from: c */
    public AbstractC0763I f2394c;

    /* JADX INFO: renamed from: d */
    public boolean f2395d;

    /* JADX INFO: renamed from: e */
    public boolean f2396e;

    /* JADX INFO: renamed from: f */
    public View f2397f;

    /* JADX INFO: renamed from: g */
    public final C0772S f2398g;

    /* JADX INFO: renamed from: h */
    public boolean f2399h;

    /* JADX INFO: renamed from: i */
    public final LinearInterpolator f2400i;

    /* JADX INFO: renamed from: j */
    public final DecelerateInterpolator f2401j;

    /* JADX INFO: renamed from: k */
    public PointF f2402k;

    /* JADX INFO: renamed from: l */
    public final DisplayMetrics f2403l;

    /* JADX INFO: renamed from: m */
    public boolean f2404m;

    /* JADX INFO: renamed from: n */
    public float f2405n;

    /* JADX INFO: renamed from: o */
    public int f2406o;

    /* JADX INFO: renamed from: p */
    public int f2407p;

    public C0809u(Context context) {
        C0772S c0772s = new C0772S();
        c0772s.f2176d = -1;
        c0772s.f2178f = false;
        c0772s.f2179g = 0;
        c0772s.f2173a = 0;
        c0772s.f2174b = 0;
        c0772s.f2175c = Integer.MIN_VALUE;
        c0772s.f2177e = null;
        this.f2398g = c0772s;
        this.f2400i = new LinearInterpolator();
        this.f2401j = new DecelerateInterpolator();
        this.f2404m = false;
        this.f2406o = 0;
        this.f2407p = 0;
        this.f2403l = context.getResources().getDisplayMetrics();
    }

    /* JADX INFO: renamed from: a */
    public static int m2106a(int i3, int i4, int i5, int i6, int i7) {
        if (i7 == -1) {
            return i5 - i3;
        }
        if (i7 != 0) {
            if (i7 == 1) {
                return i6 - i4;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i8 = i5 - i3;
        if (i8 > 0) {
            return i8;
        }
        int i9 = i6 - i4;
        if (i9 < 0) {
            return i9;
        }
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public float mo2107b(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    /* JADX INFO: renamed from: c */
    public int mo2108c(int i3) {
        float fAbs = Math.abs(i3);
        if (!this.f2404m) {
            this.f2405n = mo2107b(this.f2403l);
            this.f2404m = true;
        }
        return (int) Math.ceil(fAbs * this.f2405n);
    }

    /* JADX INFO: renamed from: d */
    public final PointF m2109d(int i3) {
        Object obj = this.f2394c;
        if (obj instanceof InterfaceC0773T) {
            return ((InterfaceC0773T) obj).mo2045a(i3);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + InterfaceC0773T.class.getCanonicalName());
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2110e(int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p073Z.C0809u.m2110e(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo2111f(android.view.View r11, p073Z.C0772S r12) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p073Z.C0809u.mo2111f(android.view.View, Z.S):void");
    }

    /* JADX INFO: renamed from: g */
    public final void m2112g() {
        if (this.f2396e) {
            this.f2396e = false;
            this.f2407p = 0;
            this.f2406o = 0;
            this.f2402k = null;
            this.f2393b.f3417g0.f2180a = -1;
            this.f2397f = null;
            this.f2392a = -1;
            this.f2395d = false;
            AbstractC0763I abstractC0763I = this.f2394c;
            if (abstractC0763I.f2143e == this) {
                abstractC0763I.f2143e = null;
            }
            this.f2394c = null;
            this.f2393b = null;
        }
    }
}
