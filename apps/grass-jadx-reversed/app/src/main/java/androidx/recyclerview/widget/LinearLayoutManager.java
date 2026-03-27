package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.WeakHashMap;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p039M0.AbstractC0473V;
import p067W1.C0693a;
import p073Z.AbstractC0763I;
import p073Z.AbstractC0811w;
import p073Z.C0762H;
import p073Z.C0764J;
import p073Z.C0769O;
import p073Z.C0774U;
import p073Z.C0805q;
import p073Z.C0806r;
import p073Z.C0807s;
import p073Z.C0808t;
import p073Z.C0809u;
import p073Z.InterfaceC0773T;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends AbstractC0763I implements InterfaceC0773T {

    /* JADX INFO: renamed from: A */
    public final C0805q f3367A;

    /* JADX INFO: renamed from: B */
    public final C0806r f3368B;

    /* JADX INFO: renamed from: C */
    public final int f3369C;

    /* JADX INFO: renamed from: D */
    public final int[] f3370D;

    /* JADX INFO: renamed from: p */
    public int f3371p;

    /* JADX INFO: renamed from: q */
    public C0807s f3372q;

    /* JADX INFO: renamed from: r */
    public AbstractC0811w f3373r;

    /* JADX INFO: renamed from: s */
    public boolean f3374s;

    /* JADX INFO: renamed from: t */
    public final boolean f3375t;

    /* JADX INFO: renamed from: u */
    public boolean f3376u;

    /* JADX INFO: renamed from: v */
    public boolean f3377v;

    /* JADX INFO: renamed from: w */
    public final boolean f3378w;

    /* JADX INFO: renamed from: x */
    public int f3379x;

    /* JADX INFO: renamed from: y */
    public int f3380y;

    /* JADX INFO: renamed from: z */
    public C0808t f3381z;

    public LinearLayoutManager(int i3) {
        this.f3371p = 1;
        this.f3375t = false;
        this.f3376u = false;
        this.f3377v = false;
        this.f3378w = true;
        this.f3379x = -1;
        this.f3380y = Integer.MIN_VALUE;
        this.f3381z = null;
        this.f3367A = new C0805q();
        this.f3368B = new C0806r();
        this.f3369C = 2;
        this.f3370D = new int[2];
        m2562U0(i3);
        mo1990c(null);
        if (this.f3375t) {
            this.f3375t = false;
            m1998g0();
        }
    }

    /* JADX INFO: renamed from: A0 */
    public final int m2545A0(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 17 ? i3 != 33 ? i3 != 66 ? (i3 == 130 && this.f3371p == 1) ? 1 : Integer.MIN_VALUE : this.f3371p == 0 ? 1 : Integer.MIN_VALUE : this.f3371p == 1 ? -1 : Integer.MIN_VALUE : this.f3371p == 0 ? -1 : Integer.MIN_VALUE : (this.f3371p != 1 && m2557N0()) ? -1 : 1 : (this.f3371p != 1 && m2557N0()) ? 1 : -1;
    }

    /* JADX INFO: renamed from: B0 */
    public final void m2546B0() {
        if (this.f3372q == null) {
            C0807s c0807s = new C0807s();
            c0807s.f2377a = true;
            c0807s.f2384h = 0;
            c0807s.f2385i = 0;
            c0807s.f2387k = null;
            this.f3372q = c0807s;
        }
    }

    /* JADX INFO: renamed from: C0 */
    public final int m2547C0(C0769O c0769o, C0807s c0807s, C0774U c0774u, boolean z3) {
        int i3;
        int i4 = c0807s.f2379c;
        int i5 = c0807s.f2383g;
        if (i5 != Integer.MIN_VALUE) {
            if (i4 < 0) {
                c0807s.f2383g = i5 + i4;
            }
            m2558Q0(c0769o, c0807s);
        }
        int i6 = c0807s.f2379c + c0807s.f2384h;
        while (true) {
            if ((!c0807s.f2388l && i6 <= 0) || (i3 = c0807s.f2380d) < 0 || i3 >= c0774u.m2047b()) {
                break;
            }
            C0806r c0806r = this.f3368B;
            c0806r.f2373a = 0;
            c0806r.f2374b = false;
            c0806r.f2375c = false;
            c0806r.f2376d = false;
            mo2532O0(c0769o, c0774u, c0807s, c0806r);
            if (!c0806r.f2374b) {
                int i7 = c0807s.f2378b;
                int i8 = c0806r.f2373a;
                c0807s.f2378b = (c0807s.f2382f * i8) + i7;
                if (!c0806r.f2375c || c0807s.f2387k != null || !c0774u.f2186g) {
                    c0807s.f2379c -= i8;
                    i6 -= i8;
                }
                int i9 = c0807s.f2383g;
                if (i9 != Integer.MIN_VALUE) {
                    int i10 = i9 + i8;
                    c0807s.f2383g = i10;
                    int i11 = c0807s.f2379c;
                    if (i11 < 0) {
                        c0807s.f2383g = i10 + i11;
                    }
                    m2558Q0(c0769o, c0807s);
                }
                if (z3 && c0806r.f2376d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i4 - c0807s.f2379c;
    }

    /* JADX INFO: renamed from: D0 */
    public final View m2548D0(boolean z3) {
        return this.f3376u ? m2552H0(0, m2027v(), z3) : m2552H0(m2027v() - 1, -1, z3);
    }

    /* JADX INFO: renamed from: E0 */
    public final View m2549E0(boolean z3) {
        return this.f3376u ? m2552H0(m2027v() - 1, -1, z3) : m2552H0(0, m2027v(), z3);
    }

    /* JADX INFO: renamed from: F0 */
    public final int m2550F0() {
        View viewM2552H0 = m2552H0(m2027v() - 1, -1, false);
        if (viewM2552H0 == null) {
            return -1;
        }
        return AbstractC0763I.m1958D(viewM2552H0);
    }

    /* JADX INFO: renamed from: G0 */
    public final View m2551G0(int i3, int i4) {
        int i5;
        int i6;
        m2546B0();
        if (i4 <= i3 && i4 >= i3) {
            return m2025u(i3);
        }
        if (this.f3373r.mo2116e(m2025u(i3)) < this.f3373r.mo2122k()) {
            i5 = 16644;
            i6 = 16388;
        } else {
            i5 = 4161;
            i6 = 4097;
        }
        return this.f3371p == 0 ? this.f2141c.m24A(i3, i4, i5, i6) : this.f2142d.m24A(i3, i4, i5, i6);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: H */
    public final boolean mo1970H() {
        return true;
    }

    /* JADX INFO: renamed from: H0 */
    public final View m2552H0(int i3, int i4, boolean z3) {
        m2546B0();
        int i5 = z3 ? 24579 : 320;
        return this.f3371p == 0 ? this.f2141c.m24A(i3, i4, i5, 320) : this.f2142d.m24A(i3, i4, i5, 320);
    }

    /* JADX INFO: renamed from: I0 */
    public View mo2531I0(C0769O c0769o, C0774U c0774u, int i3, int i4, int i5) {
        m2546B0();
        int iMo2122k = this.f3373r.mo2122k();
        int iMo2118g = this.f3373r.mo2118g();
        int i6 = i4 > i3 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i3 != i4) {
            View viewM2025u = m2025u(i3);
            int iM1958D = AbstractC0763I.m1958D(viewM2025u);
            if (iM1958D >= 0 && iM1958D < i5) {
                if (((C0764J) viewM2025u.getLayoutParams()).f2154a.m2058i()) {
                    if (view2 == null) {
                        view2 = viewM2025u;
                    }
                } else {
                    if (this.f3373r.mo2116e(viewM2025u) < iMo2118g && this.f3373r.mo2113b(viewM2025u) >= iMo2122k) {
                        return viewM2025u;
                    }
                    if (view == null) {
                        view = viewM2025u;
                    }
                }
            }
            i3 += i6;
        }
        return view != null ? view : view2;
    }

    /* JADX INFO: renamed from: J0 */
    public final int m2553J0(int i3, C0769O c0769o, C0774U c0774u, boolean z3) {
        int iMo2118g;
        int iMo2118g2 = this.f3373r.mo2118g() - i3;
        if (iMo2118g2 <= 0) {
            return 0;
        }
        int i4 = -m2561T0(-iMo2118g2, c0769o, c0774u);
        int i5 = i3 + i4;
        if (!z3 || (iMo2118g = this.f3373r.mo2118g() - i5) <= 0) {
            return i4;
        }
        this.f3373r.mo2126p(iMo2118g);
        return iMo2118g + i4;
    }

    /* JADX INFO: renamed from: K0 */
    public final int m2554K0(int i3, C0769O c0769o, C0774U c0774u, boolean z3) {
        int iMo2122k;
        int iMo2122k2 = i3 - this.f3373r.mo2122k();
        if (iMo2122k2 <= 0) {
            return 0;
        }
        int i4 = -m2561T0(iMo2122k2, c0769o, c0774u);
        int i5 = i3 + i4;
        if (!z3 || (iMo2122k = i5 - this.f3373r.mo2122k()) <= 0) {
            return i4;
        }
        this.f3373r.mo2126p(-iMo2122k);
        return i4 - iMo2122k;
    }

    /* JADX INFO: renamed from: L0 */
    public final View m2555L0() {
        return m2025u(this.f3376u ? 0 : m2027v() - 1);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: M */
    public final void mo1973M(RecyclerView recyclerView) {
    }

    /* JADX INFO: renamed from: M0 */
    public final View m2556M0() {
        return m2025u(this.f3376u ? m2027v() - 1 : 0);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: N */
    public View mo1974N(View view, int i3, C0769O c0769o, C0774U c0774u) {
        int iM2545A0;
        m2560S0();
        if (m2027v() == 0 || (iM2545A0 = m2545A0(i3)) == Integer.MIN_VALUE) {
            return null;
        }
        m2546B0();
        m2563W0(iM2545A0, (int) (this.f3373r.mo2123l() * 0.33333334f), false, c0774u);
        C0807s c0807s = this.f3372q;
        c0807s.f2383g = Integer.MIN_VALUE;
        c0807s.f2377a = false;
        m2547C0(c0769o, c0807s, c0774u, true);
        View viewM2551G0 = iM2545A0 == -1 ? this.f3376u ? m2551G0(m2027v() - 1, -1) : m2551G0(0, m2027v()) : this.f3376u ? m2551G0(0, m2027v()) : m2551G0(m2027v() - 1, -1);
        View viewM2556M0 = iM2545A0 == -1 ? m2556M0() : m2555L0();
        if (!viewM2556M0.hasFocusable()) {
            return viewM2551G0;
        }
        if (viewM2551G0 == null) {
            return null;
        }
        return viewM2556M0;
    }

    /* JADX INFO: renamed from: N0 */
    public final boolean m2557N0() {
        RecyclerView recyclerView = this.f2140b;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        return AbstractC0308C.m607d(recyclerView) == 1;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: O */
    public final void mo1975O(AccessibilityEvent accessibilityEvent) {
        super.mo1975O(accessibilityEvent);
        if (m2027v() > 0) {
            View viewM2552H0 = m2552H0(0, m2027v(), false);
            accessibilityEvent.setFromIndex(viewM2552H0 == null ? -1 : AbstractC0763I.m1958D(viewM2552H0));
            accessibilityEvent.setToIndex(m2550F0());
        }
    }

    /* JADX INFO: renamed from: O0 */
    public void mo2532O0(C0769O c0769o, C0774U c0774u, C0807s c0807s, C0806r c0806r) {
        int iM1965A;
        int i3;
        int i4;
        int iMo2115d;
        View viewM2105b = c0807s.m2105b(c0769o);
        if (viewM2105b == null) {
            c0806r.f2374b = true;
            return;
        }
        C0764J c0764j = (C0764J) viewM2105b.getLayoutParams();
        if (c0807s.f2387k == null) {
            if (this.f3376u == (c0807s.f2382f == -1)) {
                m1988b(viewM2105b, -1, false);
            } else {
                m1988b(viewM2105b, 0, false);
            }
        } else {
            if (this.f3376u == (c0807s.f2382f == -1)) {
                m1988b(viewM2105b, -1, true);
            } else {
                m1988b(viewM2105b, 0, true);
            }
        }
        C0764J c0764j2 = (C0764J) viewM2105b.getLayoutParams();
        Rect rectM2584J = this.f2140b.m2584J(viewM2105b);
        int i5 = rectM2584J.left + rectM2584J.right;
        int i6 = rectM2584J.top + rectM2584J.bottom;
        int iM1963w = AbstractC0763I.m1963w(mo1992d(), this.f2152n, this.f2150l, m1966B() + m1965A() + ((ViewGroup.MarginLayoutParams) c0764j2).leftMargin + ((ViewGroup.MarginLayoutParams) c0764j2).rightMargin + i5, ((ViewGroup.MarginLayoutParams) c0764j2).width);
        int iM1963w2 = AbstractC0763I.m1963w(mo1994e(), this.f2153o, this.f2151m, m2029z() + m1967C() + ((ViewGroup.MarginLayoutParams) c0764j2).topMargin + ((ViewGroup.MarginLayoutParams) c0764j2).bottomMargin + i6, ((ViewGroup.MarginLayoutParams) c0764j2).height);
        if (m2016p0(viewM2105b, iM1963w, iM1963w2, c0764j2)) {
            viewM2105b.measure(iM1963w, iM1963w2);
        }
        c0806r.f2373a = this.f3373r.mo2114c(viewM2105b);
        if (this.f3371p == 1) {
            if (m2557N0()) {
                iMo2115d = this.f2152n - m1966B();
                iM1965A = iMo2115d - this.f3373r.mo2115d(viewM2105b);
            } else {
                iM1965A = m1965A();
                iMo2115d = this.f3373r.mo2115d(viewM2105b) + iM1965A;
            }
            if (c0807s.f2382f == -1) {
                i3 = c0807s.f2378b;
                i4 = i3 - c0806r.f2373a;
            } else {
                i4 = c0807s.f2378b;
                i3 = c0806r.f2373a + i4;
            }
        } else {
            int iM1967C = m1967C();
            int iMo2115d2 = this.f3373r.mo2115d(viewM2105b) + iM1967C;
            if (c0807s.f2382f == -1) {
                int i7 = c0807s.f2378b;
                int i8 = i7 - c0806r.f2373a;
                iMo2115d = i7;
                i3 = iMo2115d2;
                iM1965A = i8;
                i4 = iM1967C;
            } else {
                int i9 = c0807s.f2378b;
                int i10 = c0806r.f2373a + i9;
                iM1965A = i9;
                i3 = iMo2115d2;
                i4 = iM1967C;
                iMo2115d = i10;
            }
        }
        AbstractC0763I.m1961J(viewM2105b, iM1965A, i4, iMo2115d, i3);
        if (c0764j.f2154a.m2058i() || c0764j.f2154a.m2061l()) {
            c0806r.f2375c = true;
        }
        c0806r.f2376d = viewM2105b.hasFocusable();
    }

    /* JADX INFO: renamed from: P0 */
    public void mo2533P0(C0769O c0769o, C0774U c0774u, C0805q c0805q, int i3) {
    }

    /* JADX INFO: renamed from: Q0 */
    public final void m2558Q0(C0769O c0769o, C0807s c0807s) {
        if (!c0807s.f2377a || c0807s.f2388l) {
            return;
        }
        int i3 = c0807s.f2383g;
        int i4 = c0807s.f2385i;
        if (c0807s.f2382f == -1) {
            int iM2027v = m2027v();
            if (i3 < 0) {
                return;
            }
            int iMo2117f = (this.f3373r.mo2117f() - i3) + i4;
            if (this.f3376u) {
                for (int i5 = 0; i5 < iM2027v; i5++) {
                    View viewM2025u = m2025u(i5);
                    if (this.f3373r.mo2116e(viewM2025u) < iMo2117f || this.f3373r.mo2125o(viewM2025u) < iMo2117f) {
                        m2559R0(c0769o, 0, i5);
                        return;
                    }
                }
                return;
            }
            int i6 = iM2027v - 1;
            for (int i7 = i6; i7 >= 0; i7--) {
                View viewM2025u2 = m2025u(i7);
                if (this.f3373r.mo2116e(viewM2025u2) < iMo2117f || this.f3373r.mo2125o(viewM2025u2) < iMo2117f) {
                    m2559R0(c0769o, i6, i7);
                    return;
                }
            }
            return;
        }
        if (i3 < 0) {
            return;
        }
        int i8 = i3 - i4;
        int iM2027v2 = m2027v();
        if (!this.f3376u) {
            for (int i9 = 0; i9 < iM2027v2; i9++) {
                View viewM2025u3 = m2025u(i9);
                if (this.f3373r.mo2113b(viewM2025u3) > i8 || this.f3373r.mo2124n(viewM2025u3) > i8) {
                    m2559R0(c0769o, 0, i9);
                    return;
                }
            }
            return;
        }
        int i10 = iM2027v2 - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            View viewM2025u4 = m2025u(i11);
            if (this.f3373r.mo2113b(viewM2025u4) > i8 || this.f3373r.mo2124n(viewM2025u4) > i8) {
                m2559R0(c0769o, i10, i11);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: R0 */
    public final void m2559R0(C0769O c0769o, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        if (i4 <= i3) {
            while (i3 > i4) {
                View viewM2025u = m2025u(i3);
                m1995e0(i3);
                c0769o.m2038f(viewM2025u);
                i3--;
            }
            return;
        }
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            View viewM2025u2 = m2025u(i5);
            m1995e0(i5);
            c0769o.m2038f(viewM2025u2);
        }
    }

    /* JADX INFO: renamed from: S0 */
    public final void m2560S0() {
        if (this.f3371p == 1 || !m2557N0()) {
            this.f3376u = this.f3375t;
        } else {
            this.f3376u = !this.f3375t;
        }
    }

    /* JADX INFO: renamed from: T0 */
    public final int m2561T0(int i3, C0769O c0769o, C0774U c0774u) {
        if (m2027v() == 0 || i3 == 0) {
            return 0;
        }
        m2546B0();
        this.f3372q.f2377a = true;
        int i4 = i3 > 0 ? 1 : -1;
        int iAbs = Math.abs(i3);
        m2563W0(i4, iAbs, true, c0774u);
        C0807s c0807s = this.f3372q;
        int iM2547C0 = m2547C0(c0769o, c0807s, c0774u, false) + c0807s.f2383g;
        if (iM2547C0 < 0) {
            return 0;
        }
        if (iAbs > iM2547C0) {
            i3 = i4 * iM2547C0;
        }
        this.f3373r.mo2126p(-i3);
        this.f3372q.f2386j = i3;
        return i3;
    }

    /* JADX INFO: renamed from: U0 */
    public final void m2562U0(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i3);
        }
        mo1990c(null);
        if (i3 != this.f3371p || this.f3373r == null) {
            AbstractC0811w abstractC0811wM2127a = AbstractC0811w.m2127a(this, i3);
            this.f3373r = abstractC0811wM2127a;
            this.f3367A.f2368a = abstractC0811wM2127a;
            this.f3371p = i3;
            m1998g0();
        }
    }

    /* JADX INFO: renamed from: V0 */
    public void mo2534V0(boolean z3) {
        mo1990c(null);
        if (this.f3377v == z3) {
            return;
        }
        this.f3377v = z3;
        m1998g0();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0188  */
    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: W */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo1983W(p073Z.C0769O r18, p073Z.C0774U r19) {
        /*
            Method dump skipped, instruction units count: 1157
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.mo1983W(Z.O, Z.U):void");
    }

    /* JADX INFO: renamed from: W0 */
    public final void m2563W0(int i3, int i4, boolean z3, C0774U c0774u) {
        int iMo2122k;
        this.f3372q.f2388l = this.f3373r.mo2120i() == 0 && this.f3373r.mo2117f() == 0;
        this.f3372q.f2382f = i3;
        int[] iArr = this.f3370D;
        iArr[0] = 0;
        iArr[1] = 0;
        mo2566v0(c0774u, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z4 = i3 == 1;
        C0807s c0807s = this.f3372q;
        int i5 = z4 ? iMax2 : iMax;
        c0807s.f2384h = i5;
        if (!z4) {
            iMax = iMax2;
        }
        c0807s.f2385i = iMax;
        if (z4) {
            c0807s.f2384h = this.f3373r.mo2119h() + i5;
            View viewM2555L0 = m2555L0();
            C0807s c0807s2 = this.f3372q;
            c0807s2.f2381e = this.f3376u ? -1 : 1;
            int iM1958D = AbstractC0763I.m1958D(viewM2555L0);
            C0807s c0807s3 = this.f3372q;
            c0807s2.f2380d = iM1958D + c0807s3.f2381e;
            c0807s3.f2378b = this.f3373r.mo2113b(viewM2555L0);
            iMo2122k = this.f3373r.mo2113b(viewM2555L0) - this.f3373r.mo2118g();
        } else {
            View viewM2556M0 = m2556M0();
            C0807s c0807s4 = this.f3372q;
            c0807s4.f2384h = this.f3373r.mo2122k() + c0807s4.f2384h;
            C0807s c0807s5 = this.f3372q;
            c0807s5.f2381e = this.f3376u ? 1 : -1;
            int iM1958D2 = AbstractC0763I.m1958D(viewM2556M0);
            C0807s c0807s6 = this.f3372q;
            c0807s5.f2380d = iM1958D2 + c0807s6.f2381e;
            c0807s6.f2378b = this.f3373r.mo2116e(viewM2556M0);
            iMo2122k = (-this.f3373r.mo2116e(viewM2556M0)) + this.f3373r.mo2122k();
        }
        C0807s c0807s7 = this.f3372q;
        c0807s7.f2379c = i4;
        if (z3) {
            c0807s7.f2379c = i4 - iMo2122k;
        }
        c0807s7.f2383g = iMo2122k;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: X */
    public void mo1984X(C0774U c0774u) {
        this.f3381z = null;
        this.f3379x = -1;
        this.f3380y = Integer.MIN_VALUE;
        this.f3367A.m2103d();
    }

    /* JADX INFO: renamed from: X0 */
    public final void m2564X0(int i3, int i4) {
        this.f3372q.f2379c = this.f3373r.mo2118g() - i4;
        C0807s c0807s = this.f3372q;
        c0807s.f2381e = this.f3376u ? -1 : 1;
        c0807s.f2380d = i3;
        c0807s.f2382f = 1;
        c0807s.f2378b = i4;
        c0807s.f2383g = Integer.MIN_VALUE;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: Y */
    public final void mo1985Y(Parcelable parcelable) {
        if (parcelable instanceof C0808t) {
            this.f3381z = (C0808t) parcelable;
            m1998g0();
        }
    }

    /* JADX INFO: renamed from: Y0 */
    public final void m2565Y0(int i3, int i4) {
        this.f3372q.f2379c = i4 - this.f3373r.mo2122k();
        C0807s c0807s = this.f3372q;
        c0807s.f2380d = i3;
        c0807s.f2381e = this.f3376u ? 1 : -1;
        c0807s.f2382f = -1;
        c0807s.f2378b = i4;
        c0807s.f2383g = Integer.MIN_VALUE;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: Z */
    public final Parcelable mo1986Z() {
        C0808t c0808t = this.f3381z;
        if (c0808t != null) {
            C0808t c0808t2 = new C0808t();
            c0808t2.f2389e = c0808t.f2389e;
            c0808t2.f2390f = c0808t.f2390f;
            c0808t2.f2391g = c0808t.f2391g;
            return c0808t2;
        }
        C0808t c0808t3 = new C0808t();
        if (m2027v() > 0) {
            m2546B0();
            boolean z3 = this.f3374s ^ this.f3376u;
            c0808t3.f2391g = z3;
            if (z3) {
                View viewM2555L0 = m2555L0();
                c0808t3.f2390f = this.f3373r.mo2118g() - this.f3373r.mo2113b(viewM2555L0);
                c0808t3.f2389e = AbstractC0763I.m1958D(viewM2555L0);
            } else {
                View viewM2556M0 = m2556M0();
                c0808t3.f2389e = AbstractC0763I.m1958D(viewM2556M0);
                c0808t3.f2390f = this.f3373r.mo2116e(viewM2556M0) - this.f3373r.mo2122k();
            }
        } else {
            c0808t3.f2389e = -1;
        }
        return c0808t3;
    }

    @Override // p073Z.InterfaceC0773T
    /* JADX INFO: renamed from: a */
    public final PointF mo2045a(int i3) {
        if (m2027v() == 0) {
            return null;
        }
        int i4 = (i3 < AbstractC0763I.m1958D(m2025u(0))) != this.f3376u ? -1 : 1;
        return this.f3371p == 0 ? new PointF(i4, 0.0f) : new PointF(0.0f, i4);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: c */
    public final void mo1990c(String str) {
        RecyclerView recyclerView;
        if (this.f3381z != null || (recyclerView = this.f2140b) == null) {
            return;
        }
        recyclerView.m2609i(str);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: d */
    public final boolean mo1992d() {
        return this.f3371p == 0;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: e */
    public final boolean mo1994e() {
        return this.f3371p == 1;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: h */
    public final void mo1999h(int i3, int i4, C0774U c0774u, C0693a c0693a) {
        if (this.f3371p != 0) {
            i3 = i4;
        }
        if (m2027v() == 0 || i3 == 0) {
            return;
        }
        m2546B0();
        m2563W0(i3 > 0 ? 1 : -1, Math.abs(i3), true, c0774u);
        mo2544w0(c0774u, this.f3372q, c0693a);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: h0 */
    public int mo2000h0(int i3, C0769O c0769o, C0774U c0774u) {
        if (this.f3371p == 1) {
            return 0;
        }
        return m2561T0(i3, c0769o, c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: i */
    public final void mo2001i(int i3, C0693a c0693a) {
        boolean z3;
        int i4;
        C0808t c0808t = this.f3381z;
        if (c0808t == null || (i4 = c0808t.f2389e) < 0) {
            m2560S0();
            z3 = this.f3376u;
            i4 = this.f3379x;
            if (i4 == -1) {
                i4 = z3 ? i3 - 1 : 0;
            }
        } else {
            z3 = c0808t.f2391g;
        }
        int i5 = z3 ? -1 : 1;
        for (int i6 = 0; i6 < this.f3369C && i4 >= 0 && i4 < i3; i6++) {
            c0693a.m1667a(i4, 0);
            i4 += i5;
        }
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: i0 */
    public final void mo2002i0(int i3) {
        this.f3379x = i3;
        this.f3380y = Integer.MIN_VALUE;
        C0808t c0808t = this.f3381z;
        if (c0808t != null) {
            c0808t.f2389e = -1;
        }
        m1998g0();
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: j */
    public final int mo2003j(C0774U c0774u) {
        return m2567x0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: j0 */
    public int mo2004j0(int i3, C0769O c0769o, C0774U c0774u) {
        if (this.f3371p == 0) {
            return 0;
        }
        return m2561T0(i3, c0769o, c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: k */
    public int mo2005k(C0774U c0774u) {
        return m2568y0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: l */
    public int mo2007l(C0774U c0774u) {
        return m2569z0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: m */
    public final int mo2009m(C0774U c0774u) {
        return m2567x0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: n */
    public int mo2011n(C0774U c0774u) {
        return m2568y0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: o */
    public int mo2013o(C0774U c0774u) {
        return m2569z0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: q */
    public final View mo2017q(int i3) {
        int iM2027v = m2027v();
        if (iM2027v == 0) {
            return null;
        }
        int iM1958D = i3 - AbstractC0763I.m1958D(m2025u(0));
        if (iM1958D >= 0 && iM1958D < iM2027v) {
            View viewM2025u = m2025u(iM1958D);
            if (AbstractC0763I.m1958D(viewM2025u) == i3) {
                return viewM2025u;
            }
        }
        return super.mo2017q(i3);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: q0 */
    public final boolean mo2018q0() {
        if (this.f2151m == 1073741824 || this.f2150l == 1073741824) {
            return false;
        }
        int iM2027v = m2027v();
        for (int i3 = 0; i3 < iM2027v; i3++) {
            ViewGroup.LayoutParams layoutParams = m2025u(i3).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: r */
    public C0764J mo2019r() {
        return new C0764J(-2, -2);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: s0 */
    public void mo2022s0(RecyclerView recyclerView, int i3) {
        C0809u c0809u = new C0809u(recyclerView.getContext());
        c0809u.f2392a = i3;
        m2024t0(c0809u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: u0 */
    public boolean mo2026u0() {
        return this.f3381z == null && this.f3374s == this.f3377v;
    }

    /* JADX INFO: renamed from: v0 */
    public void mo2566v0(C0774U c0774u, int[] iArr) {
        int i3;
        int iMo2123l = c0774u.f2180a != -1 ? this.f3373r.mo2123l() : 0;
        if (this.f3372q.f2382f == -1) {
            i3 = 0;
        } else {
            i3 = iMo2123l;
            iMo2123l = 0;
        }
        iArr[0] = iMo2123l;
        iArr[1] = i3;
    }

    /* JADX INFO: renamed from: w0 */
    public void mo2544w0(C0774U c0774u, C0807s c0807s, C0693a c0693a) {
        int i3 = c0807s.f2380d;
        if (i3 < 0 || i3 >= c0774u.m2047b()) {
            return;
        }
        c0693a.m1667a(i3, Math.max(0, c0807s.f2383g));
    }

    /* JADX INFO: renamed from: x0 */
    public final int m2567x0(C0774U c0774u) {
        if (m2027v() == 0) {
            return 0;
        }
        m2546B0();
        AbstractC0811w abstractC0811w = this.f3373r;
        boolean z3 = !this.f3378w;
        return AbstractC0473V.m994F(c0774u, abstractC0811w, m2549E0(z3), m2548D0(z3), this, this.f3378w);
    }

    /* JADX INFO: renamed from: y0 */
    public final int m2568y0(C0774U c0774u) {
        if (m2027v() == 0) {
            return 0;
        }
        m2546B0();
        AbstractC0811w abstractC0811w = this.f3373r;
        boolean z3 = !this.f3378w;
        return AbstractC0473V.m995G(c0774u, abstractC0811w, m2549E0(z3), m2548D0(z3), this, this.f3378w, this.f3376u);
    }

    /* JADX INFO: renamed from: z0 */
    public final int m2569z0(C0774U c0774u) {
        if (m2027v() == 0) {
            return 0;
        }
        m2546B0();
        AbstractC0811w abstractC0811w = this.f3373r;
        boolean z3 = !this.f3378w;
        return AbstractC0473V.m996H(c0774u, abstractC0811w, m2549E0(z3), m2548D0(z3), this, this.f3378w);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f3371p = 1;
        this.f3375t = false;
        this.f3376u = false;
        this.f3377v = false;
        this.f3378w = true;
        this.f3379x = -1;
        this.f3380y = Integer.MIN_VALUE;
        this.f3381z = null;
        this.f3367A = new C0805q();
        this.f3368B = new C0806r();
        this.f3369C = 2;
        this.f3370D = new int[2];
        C0762H c0762hM1959E = AbstractC0763I.m1959E(context, attributeSet, i3, i4);
        m2562U0(c0762hM1959E.f2135a);
        boolean z3 = c0762hM1959E.f2137c;
        mo1990c(null);
        if (z3 != this.f3375t) {
            this.f3375t = z3;
            m1998g0();
        }
        mo2534V0(c0762hM1959E.f2138d);
    }
}
