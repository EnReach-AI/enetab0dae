package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.WeakHashMap;
import p001A.C0009j;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p032K.C0391i;
import p036L0.C0444d;
import p067W1.C0693a;
import p073Z.AbstractC0763I;
import p073Z.C0764J;
import p073Z.C0769O;
import p073Z.C0774U;
import p073Z.C0803o;
import p073Z.C0805q;
import p073Z.C0806r;
import p073Z.C0807s;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: E */
    public boolean f3359E;

    /* JADX INFO: renamed from: F */
    public int f3360F;

    /* JADX INFO: renamed from: G */
    public int[] f3361G;

    /* JADX INFO: renamed from: H */
    public View[] f3362H;

    /* JADX INFO: renamed from: I */
    public final SparseIntArray f3363I;

    /* JADX INFO: renamed from: J */
    public final SparseIntArray f3364J;

    /* JADX INFO: renamed from: K */
    public final C0009j f3365K;

    /* JADX INFO: renamed from: L */
    public final Rect f3366L;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f3359E = false;
        this.f3360F = -1;
        this.f3363I = new SparseIntArray();
        this.f3364J = new SparseIntArray();
        this.f3365K = new C0009j(14);
        this.f3366L = new Rect();
        m2542g1(AbstractC0763I.m1959E(context, attributeSet, i3, i4).f2136b);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: F */
    public final int mo1968F(C0769O c0769o, C0774U c0774u) {
        if (this.f3371p == 0) {
            return this.f3360F;
        }
        if (c0774u.m2047b() < 1) {
            return 0;
        }
        return m2538c1(c0774u.m2047b() - 1, c0769o, c0774u) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /* JADX INFO: renamed from: I0 */
    public final View mo2531I0(C0769O c0769o, C0774U c0774u, int i3, int i4, int i5) {
        m2546B0();
        int iMo2122k = this.f3373r.mo2122k();
        int iMo2118g = this.f3373r.mo2118g();
        int i6 = i4 > i3 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i3 != i4) {
            View viewM2025u = m2025u(i3);
            int iM1958D = AbstractC0763I.m1958D(viewM2025u);
            if (iM1958D >= 0 && iM1958D < i5 && m2539d1(iM1958D, c0769o, c0774u) == 0) {
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

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00df, code lost:
    
        if (r13 == (r2 > r15)) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0126  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: N */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View mo1974N(android.view.View r23, int r24, p073Z.C0769O r25, p073Z.C0774U r26) {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.mo1974N(android.view.View, int, Z.O, Z.U):android.view.View");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v38 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /* JADX INFO: renamed from: O0 */
    public final void mo2532O0(C0769O c0769o, C0774U c0774u, C0807s c0807s, C0806r c0806r) {
        int i3;
        int i4;
        int i5;
        int iMo2115d;
        int iM1965A;
        int iMo2115d2;
        int i6;
        int iM1963w;
        int iM1963w2;
        ?? r8;
        int i7;
        View viewM2105b;
        int iMo2121j = this.f3373r.mo2121j();
        boolean z3 = iMo2121j != 1073741824;
        int i8 = m2027v() > 0 ? this.f3361G[this.f3360F] : 0;
        if (z3) {
            m2543h1();
        }
        boolean z4 = c0807s.f2381e == 1;
        int iM2539d1 = this.f3360F;
        if (!z4) {
            iM2539d1 = m2539d1(c0807s.f2380d, c0769o, c0774u) + m2540e1(c0807s.f2380d, c0769o, c0774u);
        }
        int i9 = 0;
        while (i9 < this.f3360F && (i7 = c0807s.f2380d) >= 0 && i7 < c0774u.m2047b() && iM2539d1 > 0) {
            int i10 = c0807s.f2380d;
            int iM2540e1 = m2540e1(i10, c0769o, c0774u);
            if (iM2540e1 > this.f3360F) {
                throw new IllegalArgumentException("Item at position " + i10 + " requires " + iM2540e1 + " spans but GridLayoutManager has only " + this.f3360F + " spans.");
            }
            iM2539d1 -= iM2540e1;
            if (iM2539d1 < 0 || (viewM2105b = c0807s.m2105b(c0769o)) == null) {
                break;
            }
            this.f3362H[i9] = viewM2105b;
            i9++;
        }
        if (i9 == 0) {
            c0806r.f2374b = true;
            return;
        }
        if (z4) {
            i5 = 1;
            i4 = i9;
            i3 = 0;
        } else {
            i3 = i9 - 1;
            i4 = -1;
            i5 = -1;
        }
        int i11 = 0;
        while (i3 != i4) {
            View view = this.f3362H[i3];
            C0803o c0803o = (C0803o) view.getLayoutParams();
            int iM2540e12 = m2540e1(AbstractC0763I.m1958D(view), c0769o, c0774u);
            c0803o.f2358f = iM2540e12;
            c0803o.f2357e = i11;
            i11 += iM2540e12;
            i3 += i5;
        }
        float f3 = 0.0f;
        int i12 = 0;
        for (int i13 = 0; i13 < i9; i13++) {
            View view2 = this.f3362H[i13];
            if (c0807s.f2387k != null) {
                r8 = 0;
                r8 = 0;
                if (z4) {
                    m1988b(view2, -1, true);
                } else {
                    m1988b(view2, 0, true);
                }
            } else if (z4) {
                r8 = 0;
                m1988b(view2, -1, false);
            } else {
                r8 = 0;
                m1988b(view2, 0, false);
            }
            RecyclerView recyclerView = this.f2140b;
            Rect rect = this.f3366L;
            if (recyclerView == null) {
                rect.set(r8, r8, r8, r8);
            } else {
                rect.set(recyclerView.m2584J(view2));
            }
            m2541f1(view2, iMo2121j, r8);
            int iMo2114c = this.f3373r.mo2114c(view2);
            if (iMo2114c > i12) {
                i12 = iMo2114c;
            }
            float fMo2115d = (this.f3373r.mo2115d(view2) * 1.0f) / ((C0803o) view2.getLayoutParams()).f2358f;
            if (fMo2115d > f3) {
                f3 = fMo2115d;
            }
        }
        if (z3) {
            m2535Z0(Math.max(Math.round(f3 * this.f3360F), i8));
            i12 = 0;
            for (int i14 = 0; i14 < i9; i14++) {
                View view3 = this.f3362H[i14];
                m2541f1(view3, 1073741824, true);
                int iMo2114c2 = this.f3373r.mo2114c(view3);
                if (iMo2114c2 > i12) {
                    i12 = iMo2114c2;
                }
            }
        }
        for (int i15 = 0; i15 < i9; i15++) {
            View view4 = this.f3362H[i15];
            if (this.f3373r.mo2114c(view4) != i12) {
                C0803o c0803o2 = (C0803o) view4.getLayoutParams();
                Rect rect2 = c0803o2.f2155b;
                int i16 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) c0803o2).topMargin + ((ViewGroup.MarginLayoutParams) c0803o2).bottomMargin;
                int i17 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) c0803o2).leftMargin + ((ViewGroup.MarginLayoutParams) c0803o2).rightMargin;
                int iM2537b1 = m2537b1(c0803o2.f2357e, c0803o2.f2358f);
                if (this.f3371p == 1) {
                    iM1963w2 = AbstractC0763I.m1963w(false, iM2537b1, 1073741824, i17, ((ViewGroup.MarginLayoutParams) c0803o2).width);
                    iM1963w = View.MeasureSpec.makeMeasureSpec(i12 - i16, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12 - i17, 1073741824);
                    iM1963w = AbstractC0763I.m1963w(false, iM2537b1, 1073741824, i16, ((ViewGroup.MarginLayoutParams) c0803o2).height);
                    iM1963w2 = iMakeMeasureSpec;
                }
                if (m2020r0(view4, iM1963w2, iM1963w, (C0764J) view4.getLayoutParams())) {
                    view4.measure(iM1963w2, iM1963w);
                }
            }
        }
        c0806r.f2373a = i12;
        if (this.f3371p != 1) {
            if (c0807s.f2382f == -1) {
                int i18 = c0807s.f2378b;
                iM1965A = i18 - i12;
                iMo2115d = i18;
            } else {
                int i19 = c0807s.f2378b;
                iMo2115d = i19 + i12;
                iM1965A = i19;
            }
            iMo2115d2 = 0;
            i6 = 0;
        } else if (c0807s.f2382f == -1) {
            int i20 = c0807s.f2378b;
            iM1965A = 0;
            iMo2115d = 0;
            i6 = i20 - i12;
            iMo2115d2 = i20;
        } else {
            i6 = c0807s.f2378b;
            iMo2115d2 = i6 + i12;
            iM1965A = 0;
            iMo2115d = 0;
        }
        for (int i21 = 0; i21 < i9; i21++) {
            View view5 = this.f3362H[i21];
            C0803o c0803o3 = (C0803o) view5.getLayoutParams();
            if (this.f3371p != 1) {
                int iM1967C = m1967C() + this.f3361G[c0803o3.f2357e];
                i6 = iM1967C;
                iMo2115d2 = this.f3373r.mo2115d(view5) + iM1967C;
            } else if (m2557N0()) {
                int iM1965A2 = m1965A() + this.f3361G[this.f3360F - c0803o3.f2357e];
                iMo2115d = iM1965A2;
                iM1965A = iM1965A2 - this.f3373r.mo2115d(view5);
            } else {
                iM1965A = m1965A() + this.f3361G[c0803o3.f2357e];
                iMo2115d = this.f3373r.mo2115d(view5) + iM1965A;
            }
            AbstractC0763I.m1961J(view5, iM1965A, i6, iMo2115d, iMo2115d2);
            if (c0803o3.f2154a.m2058i() || c0803o3.f2154a.m2061l()) {
                c0806r.f2375c = true;
            }
            c0806r.f2376d = view5.hasFocusable() | c0806r.f2376d;
        }
        Arrays.fill(this.f3362H, (Object) null);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: P */
    public final void mo1976P(C0769O c0769o, C0774U c0774u, View view, C0391i c0391i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C0803o)) {
            m1977Q(view, c0391i);
            return;
        }
        C0803o c0803o = (C0803o) layoutParams;
        int iM2538c1 = m2538c1(c0803o.f2154a.m2051b(), c0769o, c0774u);
        if (this.f3371p == 0) {
            c0391i.m873f(C0444d.m977w(false, c0803o.f2357e, c0803o.f2358f, iM2538c1, 1));
        } else {
            c0391i.m873f(C0444d.m977w(false, iM2538c1, 1, c0803o.f2357e, c0803o.f2358f));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /* JADX INFO: renamed from: P0 */
    public final void mo2533P0(C0769O c0769o, C0774U c0774u, C0805q c0805q, int i3) {
        m2543h1();
        if (c0774u.m2047b() > 0 && !c0774u.f2186g) {
            boolean z3 = i3 == 1;
            int iM2539d1 = m2539d1(c0805q.f2369b, c0769o, c0774u);
            if (z3) {
                while (iM2539d1 > 0) {
                    int i4 = c0805q.f2369b;
                    if (i4 <= 0) {
                        break;
                    }
                    int i5 = i4 - 1;
                    c0805q.f2369b = i5;
                    iM2539d1 = m2539d1(i5, c0769o, c0774u);
                }
            } else {
                int iM2047b = c0774u.m2047b() - 1;
                int i6 = c0805q.f2369b;
                while (i6 < iM2047b) {
                    int i7 = i6 + 1;
                    int iM2539d12 = m2539d1(i7, c0769o, c0774u);
                    if (iM2539d12 <= iM2539d1) {
                        break;
                    }
                    i6 = i7;
                    iM2539d1 = iM2539d12;
                }
                c0805q.f2369b = i6;
            }
        }
        m2536a1();
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: R */
    public final void mo1978R(int i3, int i4) {
        C0009j c0009j = this.f3365K;
        c0009j.m28F();
        ((SparseIntArray) c0009j.f31g).clear();
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: S */
    public final void mo1979S() {
        C0009j c0009j = this.f3365K;
        c0009j.m28F();
        ((SparseIntArray) c0009j.f31g).clear();
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: T */
    public final void mo1980T(int i3, int i4) {
        C0009j c0009j = this.f3365K;
        c0009j.m28F();
        ((SparseIntArray) c0009j.f31g).clear();
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: U */
    public final void mo1981U(int i3, int i4) {
        C0009j c0009j = this.f3365K;
        c0009j.m28F();
        ((SparseIntArray) c0009j.f31g).clear();
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: V */
    public final void mo1982V(int i3, int i4) {
        C0009j c0009j = this.f3365K;
        c0009j.m28F();
        ((SparseIntArray) c0009j.f31g).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /* JADX INFO: renamed from: V0 */
    public final void mo2534V0(boolean z3) {
        if (z3) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.mo2534V0(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: W */
    public final void mo1983W(C0769O c0769o, C0774U c0774u) {
        boolean z3 = c0774u.f2186g;
        SparseIntArray sparseIntArray = this.f3364J;
        SparseIntArray sparseIntArray2 = this.f3363I;
        if (z3) {
            int iM2027v = m2027v();
            for (int i3 = 0; i3 < iM2027v; i3++) {
                C0803o c0803o = (C0803o) m2025u(i3).getLayoutParams();
                int iM2051b = c0803o.f2154a.m2051b();
                sparseIntArray2.put(iM2051b, c0803o.f2358f);
                sparseIntArray.put(iM2051b, c0803o.f2357e);
            }
        }
        super.mo1983W(c0769o, c0774u);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: X */
    public final void mo1984X(C0774U c0774u) {
        super.mo1984X(c0774u);
        this.f3359E = false;
    }

    /* JADX INFO: renamed from: Z0 */
    public final void m2535Z0(int i3) {
        int i4;
        int[] iArr = this.f3361G;
        int i5 = this.f3360F;
        if (iArr == null || iArr.length != i5 + 1 || iArr[iArr.length - 1] != i3) {
            iArr = new int[i5 + 1];
        }
        int i6 = 0;
        iArr[0] = 0;
        int i7 = i3 / i5;
        int i8 = i3 % i5;
        int i9 = 0;
        for (int i10 = 1; i10 <= i5; i10++) {
            i6 += i8;
            if (i6 <= 0 || i5 - i6 >= i8) {
                i4 = i7;
            } else {
                i4 = i7 + 1;
                i6 -= i5;
            }
            i9 += i4;
            iArr[i10] = i9;
        }
        this.f3361G = iArr;
    }

    /* JADX INFO: renamed from: a1 */
    public final void m2536a1() {
        View[] viewArr = this.f3362H;
        if (viewArr == null || viewArr.length != this.f3360F) {
            this.f3362H = new View[this.f3360F];
        }
    }

    /* JADX INFO: renamed from: b1 */
    public final int m2537b1(int i3, int i4) {
        if (this.f3371p != 1 || !m2557N0()) {
            int[] iArr = this.f3361G;
            return iArr[i4 + i3] - iArr[i3];
        }
        int[] iArr2 = this.f3361G;
        int i5 = this.f3360F;
        return iArr2[i5 - i3] - iArr2[(i5 - i3) - i4];
    }

    /* JADX INFO: renamed from: c1 */
    public final int m2538c1(int i3, C0769O c0769o, C0774U c0774u) {
        boolean z3 = c0774u.f2186g;
        C0009j c0009j = this.f3365K;
        if (!z3) {
            int i4 = this.f3360F;
            c0009j.getClass();
            return C0009j.m23D(i3, i4);
        }
        int iM2034b = c0769o.m2034b(i3);
        if (iM2034b != -1) {
            int i5 = this.f3360F;
            c0009j.getClass();
            return C0009j.m23D(iM2034b, i5);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i3);
        return 0;
    }

    /* JADX INFO: renamed from: d1 */
    public final int m2539d1(int i3, C0769O c0769o, C0774U c0774u) {
        boolean z3 = c0774u.f2186g;
        C0009j c0009j = this.f3365K;
        if (!z3) {
            int i4 = this.f3360F;
            c0009j.getClass();
            return i3 % i4;
        }
        int i5 = this.f3364J.get(i3, -1);
        if (i5 != -1) {
            return i5;
        }
        int iM2034b = c0769o.m2034b(i3);
        if (iM2034b != -1) {
            int i6 = this.f3360F;
            c0009j.getClass();
            return iM2034b % i6;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 0;
    }

    /* JADX INFO: renamed from: e1 */
    public final int m2540e1(int i3, C0769O c0769o, C0774U c0774u) {
        boolean z3 = c0774u.f2186g;
        C0009j c0009j = this.f3365K;
        if (!z3) {
            c0009j.getClass();
            return 1;
        }
        int i4 = this.f3363I.get(i3, -1);
        if (i4 != -1) {
            return i4;
        }
        if (c0769o.m2034b(i3) != -1) {
            c0009j.getClass();
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 1;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: f */
    public final boolean mo1996f(C0764J c0764j) {
        return c0764j instanceof C0803o;
    }

    /* JADX INFO: renamed from: f1 */
    public final void m2541f1(View view, int i3, boolean z3) {
        int iM1963w;
        int iM1963w2;
        C0803o c0803o = (C0803o) view.getLayoutParams();
        Rect rect = c0803o.f2155b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) c0803o).topMargin + ((ViewGroup.MarginLayoutParams) c0803o).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) c0803o).leftMargin + ((ViewGroup.MarginLayoutParams) c0803o).rightMargin;
        int iM2537b1 = m2537b1(c0803o.f2357e, c0803o.f2358f);
        if (this.f3371p == 1) {
            iM1963w2 = AbstractC0763I.m1963w(false, iM2537b1, i3, i5, ((ViewGroup.MarginLayoutParams) c0803o).width);
            iM1963w = AbstractC0763I.m1963w(true, this.f3373r.mo2123l(), this.f2151m, i4, ((ViewGroup.MarginLayoutParams) c0803o).height);
        } else {
            int iM1963w3 = AbstractC0763I.m1963w(false, iM2537b1, i3, i4, ((ViewGroup.MarginLayoutParams) c0803o).height);
            int iM1963w4 = AbstractC0763I.m1963w(true, this.f3373r.mo2123l(), this.f2150l, i5, ((ViewGroup.MarginLayoutParams) c0803o).width);
            iM1963w = iM1963w3;
            iM1963w2 = iM1963w4;
        }
        C0764J c0764j = (C0764J) view.getLayoutParams();
        if (z3 ? m2020r0(view, iM1963w2, iM1963w, c0764j) : m2016p0(view, iM1963w2, iM1963w, c0764j)) {
            view.measure(iM1963w2, iM1963w);
        }
    }

    /* JADX INFO: renamed from: g1 */
    public final void m2542g1(int i3) {
        if (i3 == this.f3360F) {
            return;
        }
        this.f3359E = true;
        if (i3 < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i3);
        }
        this.f3360F = i3;
        this.f3365K.m28F();
        m1998g0();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: h0 */
    public final int mo2000h0(int i3, C0769O c0769o, C0774U c0774u) {
        m2543h1();
        m2536a1();
        return super.mo2000h0(i3, c0769o, c0774u);
    }

    /* JADX INFO: renamed from: h1 */
    public final void m2543h1() {
        int iM2029z;
        int iM1967C;
        if (this.f3371p == 1) {
            iM2029z = this.f2152n - m1966B();
            iM1967C = m1965A();
        } else {
            iM2029z = this.f2153o - m2029z();
            iM1967C = m1967C();
        }
        m2535Z0(iM2029z - iM1967C);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: j0 */
    public final int mo2004j0(int i3, C0769O c0769o, C0774U c0774u) {
        m2543h1();
        m2536a1();
        return super.mo2004j0(i3, c0769o, c0774u);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: k */
    public final int mo2005k(C0774U c0774u) {
        return m2568y0(c0774u);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: l */
    public final int mo2007l(C0774U c0774u) {
        return m2569z0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: m0 */
    public final void mo2010m0(Rect rect, int i3, int i4) {
        int iM1962g;
        int iM1962g2;
        if (this.f3361G == null) {
            super.mo2010m0(rect, i3, i4);
        }
        int iM1966B = m1966B() + m1965A();
        int iM2029z = m2029z() + m1967C();
        if (this.f3371p == 1) {
            int iHeight = rect.height() + iM2029z;
            RecyclerView recyclerView = this.f2140b;
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            iM1962g2 = AbstractC0763I.m1962g(i4, iHeight, AbstractC0307B.m588d(recyclerView));
            int[] iArr = this.f3361G;
            iM1962g = AbstractC0763I.m1962g(i3, iArr[iArr.length - 1] + iM1966B, AbstractC0307B.m589e(this.f2140b));
        } else {
            int iWidth = rect.width() + iM1966B;
            RecyclerView recyclerView2 = this.f2140b;
            WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
            iM1962g = AbstractC0763I.m1962g(i3, iWidth, AbstractC0307B.m589e(recyclerView2));
            int[] iArr2 = this.f3361G;
            iM1962g2 = AbstractC0763I.m1962g(i4, iArr2[iArr2.length - 1] + iM2029z, AbstractC0307B.m588d(this.f2140b));
        }
        this.f2140b.setMeasuredDimension(iM1962g, iM1962g2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: n */
    public final int mo2011n(C0774U c0774u) {
        return m2568y0(c0774u);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: o */
    public final int mo2013o(C0774U c0774u) {
        return m2569z0(c0774u);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: r */
    public final C0764J mo2019r() {
        return this.f3371p == 0 ? new C0803o(-2, -1) : new C0803o(-1, -2);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: s */
    public final C0764J mo2021s(Context context, AttributeSet attributeSet) {
        C0803o c0803o = new C0803o(context, attributeSet);
        c0803o.f2357e = -1;
        c0803o.f2358f = 0;
        return c0803o;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: t */
    public final C0764J mo2023t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            C0803o c0803o = new C0803o((ViewGroup.MarginLayoutParams) layoutParams);
            c0803o.f2357e = -1;
            c0803o.f2358f = 0;
            return c0803o;
        }
        C0803o c0803o2 = new C0803o(layoutParams);
        c0803o2.f2357e = -1;
        c0803o2.f2358f = 0;
        return c0803o2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: u0 */
    public final boolean mo2026u0() {
        return this.f3381z == null && !this.f3359E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /* JADX INFO: renamed from: w0 */
    public final void mo2544w0(C0774U c0774u, C0807s c0807s, C0693a c0693a) {
        int i3;
        int i4 = this.f3360F;
        for (int i5 = 0; i5 < this.f3360F && (i3 = c0807s.f2380d) >= 0 && i3 < c0774u.m2047b() && i4 > 0; i5++) {
            c0693a.m1667a(c0807s.f2380d, Math.max(0, c0807s.f2383g));
            this.f3365K.getClass();
            i4--;
            c0807s.f2380d += c0807s.f2381e;
        }
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: x */
    public final int mo2028x(C0769O c0769o, C0774U c0774u) {
        if (this.f3371p == 1) {
            return this.f3360F;
        }
        if (c0774u.m2047b() < 1) {
            return 0;
        }
        return m2538c1(c0774u.m2047b() - 1, c0769o, c0774u) + 1;
    }

    public GridLayoutManager(int i3) {
        super(1);
        this.f3359E = false;
        this.f3360F = -1;
        this.f3363I = new SparseIntArray();
        this.f3364J = new SparseIntArray();
        this.f3365K = new C0009j(14);
        this.f3366L = new Rect();
        m2542g1(i3);
    }
}
