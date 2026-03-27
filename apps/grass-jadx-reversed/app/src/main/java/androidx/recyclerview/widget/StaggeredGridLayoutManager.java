package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.WeakHashMap;
import p001A.C0009j;
import p007B1.RunnableC0055o;
import p029J.AbstractC0307B;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p032K.C0391i;
import p036L0.C0444d;
import p039M0.AbstractC0473V;
import p067W1.C0693a;
import p073Z.AbstractC0763I;
import p073Z.AbstractC0811w;
import p073Z.C0762H;
import p073Z.C0764J;
import p073Z.C0769O;
import p073Z.C0774U;
import p073Z.C0783b0;
import p073Z.C0785c0;
import p073Z.C0789e0;
import p073Z.C0791f0;
import p073Z.C0804p;
import p073Z.C0809u;
import p073Z.InterfaceC0773T;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends AbstractC0763I implements InterfaceC0773T {

    /* JADX INFO: renamed from: B */
    public final C0009j f3453B;

    /* JADX INFO: renamed from: C */
    public final int f3454C;

    /* JADX INFO: renamed from: D */
    public boolean f3455D;

    /* JADX INFO: renamed from: E */
    public boolean f3456E;

    /* JADX INFO: renamed from: F */
    public C0789e0 f3457F;

    /* JADX INFO: renamed from: G */
    public final Rect f3458G;

    /* JADX INFO: renamed from: H */
    public final C0783b0 f3459H;

    /* JADX INFO: renamed from: I */
    public final boolean f3460I;

    /* JADX INFO: renamed from: J */
    public int[] f3461J;

    /* JADX INFO: renamed from: K */
    public final RunnableC0055o f3462K;

    /* JADX INFO: renamed from: p */
    public final int f3463p;

    /* JADX INFO: renamed from: q */
    public final C0791f0[] f3464q;

    /* JADX INFO: renamed from: r */
    public final AbstractC0811w f3465r;

    /* JADX INFO: renamed from: s */
    public final AbstractC0811w f3466s;

    /* JADX INFO: renamed from: t */
    public final int f3467t;

    /* JADX INFO: renamed from: u */
    public int f3468u;

    /* JADX INFO: renamed from: v */
    public final C0804p f3469v;

    /* JADX INFO: renamed from: w */
    public boolean f3470w;

    /* JADX INFO: renamed from: y */
    public final BitSet f3472y;

    /* JADX INFO: renamed from: x */
    public boolean f3471x = false;

    /* JADX INFO: renamed from: z */
    public int f3473z = -1;

    /* JADX INFO: renamed from: A */
    public int f3452A = Integer.MIN_VALUE;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f3463p = -1;
        this.f3470w = false;
        C0009j c0009j = new C0009j(15, false);
        this.f3453B = c0009j;
        this.f3454C = 2;
        this.f3458G = new Rect();
        this.f3459H = new C0783b0(this);
        this.f3460I = true;
        this.f3462K = new RunnableC0055o(7, this);
        C0762H c0762hM1959E = AbstractC0763I.m1959E(context, attributeSet, i3, i4);
        int i5 = c0762hM1959E.f2135a;
        if (i5 != 0 && i5 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        mo1990c(null);
        if (i5 != this.f3467t) {
            this.f3467t = i5;
            AbstractC0811w abstractC0811w = this.f3465r;
            this.f3465r = this.f3466s;
            this.f3466s = abstractC0811w;
            m1998g0();
        }
        int i6 = c0762hM1959E.f2136b;
        mo1990c(null);
        if (i6 != this.f3463p) {
            int[] iArr = (int[]) c0009j.f30f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            c0009j.f31g = null;
            m1998g0();
            this.f3463p = i6;
            this.f3472y = new BitSet(this.f3463p);
            this.f3464q = new C0791f0[this.f3463p];
            for (int i7 = 0; i7 < this.f3463p; i7++) {
                this.f3464q[i7] = new C0791f0(this, i7);
            }
            m1998g0();
        }
        boolean z3 = c0762hM1959E.f2137c;
        mo1990c(null);
        C0789e0 c0789e0 = this.f3457F;
        if (c0789e0 != null && c0789e0.f2265l != z3) {
            c0789e0.f2265l = z3;
        }
        this.f3470w = z3;
        m1998g0();
        C0804p c0804p = new C0804p();
        c0804p.f2359a = true;
        c0804p.f2364f = 0;
        c0804p.f2365g = 0;
        this.f3469v = c0804p;
        this.f3465r = AbstractC0811w.m2127a(this, this.f3467t);
        this.f3466s = AbstractC0811w.m2127a(this, 1 - this.f3467t);
    }

    /* JADX INFO: renamed from: Y0 */
    public static int m2626Y0(int i3, int i4, int i5) {
        if (i4 == 0 && i5 == 0) {
            return i3;
        }
        int mode = View.MeasureSpec.getMode(i3);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i3) - i4) - i5), mode) : i3;
    }

    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean, int] */
    /* JADX INFO: renamed from: A0 */
    public final int m2627A0(C0769O c0769o, C0804p c0804p, C0774U c0774u) {
        C0791f0 c0791f0;
        ?? r6;
        int i3;
        int iM2083h;
        int iMo2114c;
        int iMo2122k;
        int iMo2114c2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        int i9 = 1;
        this.f3472y.set(0, this.f3463p, true);
        C0804p c0804p2 = this.f3469v;
        int i10 = c0804p2.f2367i ? c0804p.f2363e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : c0804p.f2363e == 1 ? c0804p.f2365g + c0804p.f2360b : c0804p.f2364f - c0804p.f2360b;
        int i11 = c0804p.f2363e;
        for (int i12 = 0; i12 < this.f3463p; i12++) {
            if (!this.f3464q[i12].f2273a.isEmpty()) {
                m2650X0(this.f3464q[i12], i11, i10);
            }
        }
        int iMo2118g = this.f3471x ? this.f3465r.mo2118g() : this.f3465r.mo2122k();
        boolean z3 = false;
        while (true) {
            int i13 = c0804p.f2361c;
            if (((i13 < 0 || i13 >= c0774u.m2047b()) ? i8 : i9) == 0 || (!c0804p2.f2367i && this.f3472y.isEmpty())) {
                break;
            }
            View view = c0769o.m2041i(c0804p.f2361c, Long.MAX_VALUE).f2202a;
            c0804p.f2361c += c0804p.f2362d;
            C0785c0 c0785c0 = (C0785c0) view.getLayoutParams();
            int iM2051b = c0785c0.f2154a.m2051b();
            C0009j c0009j = this.f3453B;
            int[] iArr = (int[]) c0009j.f30f;
            int i14 = (iArr == null || iM2051b >= iArr.length) ? -1 : iArr[iM2051b];
            if (i14 == -1) {
                if (m2641O0(c0804p.f2363e)) {
                    i7 = this.f3463p - i9;
                    i6 = -1;
                    i5 = -1;
                } else {
                    i5 = i9;
                    i6 = this.f3463p;
                    i7 = i8;
                }
                C0791f0 c0791f02 = null;
                if (c0804p.f2363e == i9) {
                    int iMo2122k2 = this.f3465r.mo2122k();
                    int i15 = Integer.MAX_VALUE;
                    while (i7 != i6) {
                        C0791f0 c0791f03 = this.f3464q[i7];
                        int iM2081f = c0791f03.m2081f(iMo2122k2);
                        if (iM2081f < i15) {
                            i15 = iM2081f;
                            c0791f02 = c0791f03;
                        }
                        i7 += i5;
                    }
                } else {
                    int iMo2118g2 = this.f3465r.mo2118g();
                    int i16 = Integer.MIN_VALUE;
                    while (i7 != i6) {
                        C0791f0 c0791f04 = this.f3464q[i7];
                        int iM2083h2 = c0791f04.m2083h(iMo2118g2);
                        if (iM2083h2 > i16) {
                            c0791f02 = c0791f04;
                            i16 = iM2083h2;
                        }
                        i7 += i5;
                    }
                }
                c0791f0 = c0791f02;
                c0009j.m66z(iM2051b);
                ((int[]) c0009j.f30f)[iM2051b] = c0791f0.f2277e;
            } else {
                c0791f0 = this.f3464q[i14];
            }
            c0785c0.f2242e = c0791f0;
            if (c0804p.f2363e == 1) {
                r6 = 0;
                m1988b(view, -1, false);
            } else {
                r6 = 0;
                m1988b(view, 0, false);
            }
            if (this.f3467t == 1) {
                i3 = 1;
                m2639M0(view, AbstractC0763I.m1963w(r6, this.f3468u, this.f2150l, r6, ((ViewGroup.MarginLayoutParams) c0785c0).width), AbstractC0763I.m1963w(true, this.f2153o, this.f2151m, m2029z() + m1967C(), ((ViewGroup.MarginLayoutParams) c0785c0).height));
            } else {
                i3 = 1;
                m2639M0(view, AbstractC0763I.m1963w(true, this.f2152n, this.f2150l, m1966B() + m1965A(), ((ViewGroup.MarginLayoutParams) c0785c0).width), AbstractC0763I.m1963w(false, this.f3468u, this.f2151m, 0, ((ViewGroup.MarginLayoutParams) c0785c0).height));
            }
            if (c0804p.f2363e == i3) {
                iMo2114c = c0791f0.m2081f(iMo2118g);
                iM2083h = this.f3465r.mo2114c(view) + iMo2114c;
            } else {
                iM2083h = c0791f0.m2083h(iMo2118g);
                iMo2114c = iM2083h - this.f3465r.mo2114c(view);
            }
            if (c0804p.f2363e == 1) {
                C0791f0 c0791f05 = c0785c0.f2242e;
                c0791f05.getClass();
                C0785c0 c0785c02 = (C0785c0) view.getLayoutParams();
                c0785c02.f2242e = c0791f05;
                ArrayList arrayList = c0791f05.f2273a;
                arrayList.add(view);
                c0791f05.f2275c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    c0791f05.f2274b = Integer.MIN_VALUE;
                }
                if (c0785c02.f2154a.m2058i() || c0785c02.f2154a.m2061l()) {
                    c0791f05.f2276d = c0791f05.f2278f.f3465r.mo2114c(view) + c0791f05.f2276d;
                }
            } else {
                C0791f0 c0791f06 = c0785c0.f2242e;
                c0791f06.getClass();
                C0785c0 c0785c03 = (C0785c0) view.getLayoutParams();
                c0785c03.f2242e = c0791f06;
                ArrayList arrayList2 = c0791f06.f2273a;
                arrayList2.add(0, view);
                c0791f06.f2274b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    c0791f06.f2275c = Integer.MIN_VALUE;
                }
                if (c0785c03.f2154a.m2058i() || c0785c03.f2154a.m2061l()) {
                    c0791f06.f2276d = c0791f06.f2278f.f3465r.mo2114c(view) + c0791f06.f2276d;
                }
            }
            if (m2638L0() && this.f3467t == 1) {
                iMo2114c2 = this.f3466s.mo2118g() - (((this.f3463p - 1) - c0791f0.f2277e) * this.f3468u);
                iMo2122k = iMo2114c2 - this.f3466s.mo2114c(view);
            } else {
                iMo2122k = this.f3466s.mo2122k() + (c0791f0.f2277e * this.f3468u);
                iMo2114c2 = this.f3466s.mo2114c(view) + iMo2122k;
            }
            if (this.f3467t == 1) {
                AbstractC0763I.m1961J(view, iMo2122k, iMo2114c, iMo2114c2, iM2083h);
            } else {
                AbstractC0763I.m1961J(view, iMo2114c, iMo2122k, iM2083h, iMo2114c2);
            }
            m2650X0(c0791f0, c0804p2.f2363e, i10);
            m2643Q0(c0769o, c0804p2);
            if (c0804p2.f2366h && view.hasFocusable()) {
                i4 = 0;
                this.f3472y.set(c0791f0.f2277e, false);
            } else {
                i4 = 0;
            }
            i8 = i4;
            i9 = 1;
            z3 = true;
        }
        int i17 = i8;
        if (!z3) {
            m2643Q0(c0769o, c0804p2);
        }
        int iMo2122k3 = c0804p2.f2363e == -1 ? this.f3465r.mo2122k() - m2635I0(this.f3465r.mo2122k()) : m2634H0(this.f3465r.mo2118g()) - this.f3465r.mo2118g();
        return iMo2122k3 > 0 ? Math.min(c0804p.f2360b, iMo2122k3) : i17;
    }

    /* JADX INFO: renamed from: B0 */
    public final View m2628B0(boolean z3) {
        int iMo2122k = this.f3465r.mo2122k();
        int iMo2118g = this.f3465r.mo2118g();
        View view = null;
        for (int iM2027v = m2027v() - 1; iM2027v >= 0; iM2027v--) {
            View viewM2025u = m2025u(iM2027v);
            int iMo2116e = this.f3465r.mo2116e(viewM2025u);
            int iMo2113b = this.f3465r.mo2113b(viewM2025u);
            if (iMo2113b > iMo2122k && iMo2116e < iMo2118g) {
                if (iMo2113b <= iMo2118g || !z3) {
                    return viewM2025u;
                }
                if (view == null) {
                    view = viewM2025u;
                }
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: C0 */
    public final View m2629C0(boolean z3) {
        int iMo2122k = this.f3465r.mo2122k();
        int iMo2118g = this.f3465r.mo2118g();
        int iM2027v = m2027v();
        View view = null;
        for (int i3 = 0; i3 < iM2027v; i3++) {
            View viewM2025u = m2025u(i3);
            int iMo2116e = this.f3465r.mo2116e(viewM2025u);
            if (this.f3465r.mo2113b(viewM2025u) > iMo2122k && iMo2116e < iMo2118g) {
                if (iMo2116e >= iMo2122k || !z3) {
                    return viewM2025u;
                }
                if (view == null) {
                    view = viewM2025u;
                }
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: D0 */
    public final void m2630D0(C0769O c0769o, C0774U c0774u, boolean z3) {
        int iMo2118g;
        int iM2634H0 = m2634H0(Integer.MIN_VALUE);
        if (iM2634H0 != Integer.MIN_VALUE && (iMo2118g = this.f3465r.mo2118g() - iM2634H0) > 0) {
            int i3 = iMo2118g - (-m2647U0(-iMo2118g, c0769o, c0774u));
            if (!z3 || i3 <= 0) {
                return;
            }
            this.f3465r.mo2126p(i3);
        }
    }

    /* JADX INFO: renamed from: E0 */
    public final void m2631E0(C0769O c0769o, C0774U c0774u, boolean z3) {
        int iMo2122k;
        int iM2635I0 = m2635I0(Integer.MAX_VALUE);
        if (iM2635I0 != Integer.MAX_VALUE && (iMo2122k = iM2635I0 - this.f3465r.mo2122k()) > 0) {
            int iM2647U0 = iMo2122k - m2647U0(iMo2122k, c0769o, c0774u);
            if (!z3 || iM2647U0 <= 0) {
                return;
            }
            this.f3465r.mo2126p(-iM2647U0);
        }
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: F */
    public final int mo1968F(C0769O c0769o, C0774U c0774u) {
        return this.f3467t == 0 ? this.f3463p : super.mo1968F(c0769o, c0774u);
    }

    /* JADX INFO: renamed from: F0 */
    public final int m2632F0() {
        if (m2027v() == 0) {
            return 0;
        }
        return AbstractC0763I.m1958D(m2025u(0));
    }

    /* JADX INFO: renamed from: G0 */
    public final int m2633G0() {
        int iM2027v = m2027v();
        if (iM2027v == 0) {
            return 0;
        }
        return AbstractC0763I.m1958D(m2025u(iM2027v - 1));
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: H */
    public final boolean mo1970H() {
        return this.f3454C != 0;
    }

    /* JADX INFO: renamed from: H0 */
    public final int m2634H0(int i3) {
        int iM2081f = this.f3464q[0].m2081f(i3);
        for (int i4 = 1; i4 < this.f3463p; i4++) {
            int iM2081f2 = this.f3464q[i4].m2081f(i3);
            if (iM2081f2 > iM2081f) {
                iM2081f = iM2081f2;
            }
        }
        return iM2081f;
    }

    /* JADX INFO: renamed from: I0 */
    public final int m2635I0(int i3) {
        int iM2083h = this.f3464q[0].m2083h(i3);
        for (int i4 = 1; i4 < this.f3463p; i4++) {
            int iM2083h2 = this.f3464q[i4].m2083h(i3);
            if (iM2083h2 < iM2083h) {
                iM2083h = iM2083h2;
            }
        }
        return iM2083h;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX INFO: renamed from: J0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2636J0(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.f3471x
            if (r0 == 0) goto L9
            int r0 = r7.m2633G0()
            goto Ld
        L9:
            int r0 = r7.m2632F0()
        Ld:
            r1 = 8
            if (r10 != r1) goto L1b
            if (r8 >= r9) goto L17
            int r2 = r9 + 1
        L15:
            r3 = r8
            goto L1e
        L17:
            int r2 = r8 + 1
            r3 = r9
            goto L1e
        L1b:
            int r2 = r8 + r9
            goto L15
        L1e:
            A.j r4 = r7.f3453B
            r4.m27E(r3)
            r5 = 1
            if (r10 == r5) goto L37
            r6 = 2
            if (r10 == r6) goto L33
            if (r10 == r1) goto L2c
            goto L3a
        L2c:
            r4.m31I(r8, r5)
            r4.m30H(r9, r5)
            goto L3a
        L33:
            r4.m31I(r8, r9)
            goto L3a
        L37:
            r4.m30H(r8, r9)
        L3a:
            if (r2 > r0) goto L3d
            return
        L3d:
            boolean r8 = r7.f3471x
            if (r8 == 0) goto L46
            int r8 = r7.m2632F0()
            goto L4a
        L46:
            int r8 = r7.m2633G0()
        L4a:
            if (r3 > r8) goto L4f
            r7.m1998g0()
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m2636J0(int, int, int):void");
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: K */
    public final void mo1971K(int i3) {
        super.mo1971K(i3);
        for (int i4 = 0; i4 < this.f3463p; i4++) {
            C0791f0 c0791f0 = this.f3464q[i4];
            int i5 = c0791f0.f2274b;
            if (i5 != Integer.MIN_VALUE) {
                c0791f0.f2274b = i5 + i3;
            }
            int i6 = c0791f0.f2275c;
            if (i6 != Integer.MIN_VALUE) {
                c0791f0.f2275c = i6 + i3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x002c A[SYNTHETIC] */
    /* JADX INFO: renamed from: K0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View m2637K0() {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m2637K0():android.view.View");
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: L */
    public final void mo1972L(int i3) {
        super.mo1972L(i3);
        for (int i4 = 0; i4 < this.f3463p; i4++) {
            C0791f0 c0791f0 = this.f3464q[i4];
            int i5 = c0791f0.f2274b;
            if (i5 != Integer.MIN_VALUE) {
                c0791f0.f2274b = i5 + i3;
            }
            int i6 = c0791f0.f2275c;
            if (i6 != Integer.MIN_VALUE) {
                c0791f0.f2275c = i6 + i3;
            }
        }
    }

    /* JADX INFO: renamed from: L0 */
    public final boolean m2638L0() {
        RecyclerView recyclerView = this.f2140b;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        return AbstractC0308C.m607d(recyclerView) == 1;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: M */
    public final void mo1973M(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2140b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.f3462K);
        }
        for (int i3 = 0; i3 < this.f3463p; i3++) {
            this.f3464q[i3].m2077b();
        }
        recyclerView.requestLayout();
    }

    /* JADX INFO: renamed from: M0 */
    public final void m2639M0(View view, int i3, int i4) {
        RecyclerView recyclerView = this.f2140b;
        Rect rect = this.f3458G;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.m2584J(view));
        }
        C0785c0 c0785c0 = (C0785c0) view.getLayoutParams();
        int iM2626Y0 = m2626Y0(i3, ((ViewGroup.MarginLayoutParams) c0785c0).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) c0785c0).rightMargin + rect.right);
        int iM2626Y02 = m2626Y0(i4, ((ViewGroup.MarginLayoutParams) c0785c0).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) c0785c0).bottomMargin + rect.bottom);
        if (m2016p0(view, iM2626Y0, iM2626Y02, c0785c0)) {
            view.measure(iM2626Y0, iM2626Y02);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005f  */
    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: N */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View mo1974N(android.view.View r9, int r10, p073Z.C0769O r11, p073Z.C0774U r12) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.mo1974N(android.view.View, int, Z.O, Z.U):android.view.View");
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x040d  */
    /* JADX INFO: renamed from: N0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2640N0(p073Z.C0769O r17, p073Z.C0774U r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 1064
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m2640N0(Z.O, Z.U, boolean):void");
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: O */
    public final void mo1975O(AccessibilityEvent accessibilityEvent) {
        super.mo1975O(accessibilityEvent);
        if (m2027v() > 0) {
            View viewM2629C0 = m2629C0(false);
            View viewM2628B0 = m2628B0(false);
            if (viewM2629C0 == null || viewM2628B0 == null) {
                return;
            }
            int iM1958D = AbstractC0763I.m1958D(viewM2629C0);
            int iM1958D2 = AbstractC0763I.m1958D(viewM2628B0);
            if (iM1958D < iM1958D2) {
                accessibilityEvent.setFromIndex(iM1958D);
                accessibilityEvent.setToIndex(iM1958D2);
            } else {
                accessibilityEvent.setFromIndex(iM1958D2);
                accessibilityEvent.setToIndex(iM1958D);
            }
        }
    }

    /* JADX INFO: renamed from: O0 */
    public final boolean m2641O0(int i3) {
        if (this.f3467t == 0) {
            return (i3 == -1) != this.f3471x;
        }
        return ((i3 == -1) == this.f3471x) == m2638L0();
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: P */
    public final void mo1976P(C0769O c0769o, C0774U c0774u, View view, C0391i c0391i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C0785c0)) {
            m1977Q(view, c0391i);
            return;
        }
        C0785c0 c0785c0 = (C0785c0) layoutParams;
        if (this.f3467t == 0) {
            C0791f0 c0791f0 = c0785c0.f2242e;
            c0391i.m873f(C0444d.m977w(false, c0791f0 == null ? -1 : c0791f0.f2277e, 1, -1, -1));
        } else {
            C0791f0 c0791f02 = c0785c0.f2242e;
            c0391i.m873f(C0444d.m977w(false, -1, -1, c0791f02 == null ? -1 : c0791f02.f2277e, 1));
        }
    }

    /* JADX INFO: renamed from: P0 */
    public final void m2642P0(int i3, C0774U c0774u) {
        int iM2632F0;
        int i4;
        if (i3 > 0) {
            iM2632F0 = m2633G0();
            i4 = 1;
        } else {
            iM2632F0 = m2632F0();
            i4 = -1;
        }
        C0804p c0804p = this.f3469v;
        c0804p.f2359a = true;
        m2649W0(iM2632F0, c0774u);
        m2648V0(i4);
        c0804p.f2361c = iM2632F0 + c0804p.f2362d;
        c0804p.f2360b = Math.abs(i3);
    }

    /* JADX INFO: renamed from: Q0 */
    public final void m2643Q0(C0769O c0769o, C0804p c0804p) {
        if (!c0804p.f2359a || c0804p.f2367i) {
            return;
        }
        if (c0804p.f2360b == 0) {
            if (c0804p.f2363e == -1) {
                m2644R0(c0769o, c0804p.f2365g);
                return;
            } else {
                m2645S0(c0769o, c0804p.f2364f);
                return;
            }
        }
        int i3 = 1;
        if (c0804p.f2363e == -1) {
            int i4 = c0804p.f2364f;
            int iM2083h = this.f3464q[0].m2083h(i4);
            while (i3 < this.f3463p) {
                int iM2083h2 = this.f3464q[i3].m2083h(i4);
                if (iM2083h2 > iM2083h) {
                    iM2083h = iM2083h2;
                }
                i3++;
            }
            int i5 = i4 - iM2083h;
            m2644R0(c0769o, i5 < 0 ? c0804p.f2365g : c0804p.f2365g - Math.min(i5, c0804p.f2360b));
            return;
        }
        int i6 = c0804p.f2365g;
        int iM2081f = this.f3464q[0].m2081f(i6);
        while (i3 < this.f3463p) {
            int iM2081f2 = this.f3464q[i3].m2081f(i6);
            if (iM2081f2 < iM2081f) {
                iM2081f = iM2081f2;
            }
            i3++;
        }
        int i7 = iM2081f - c0804p.f2365g;
        m2645S0(c0769o, i7 < 0 ? c0804p.f2364f : Math.min(i7, c0804p.f2360b) + c0804p.f2364f);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: R */
    public final void mo1978R(int i3, int i4) {
        m2636J0(i3, i4, 1);
    }

    /* JADX INFO: renamed from: R0 */
    public final void m2644R0(C0769O c0769o, int i3) {
        for (int iM2027v = m2027v() - 1; iM2027v >= 0; iM2027v--) {
            View viewM2025u = m2025u(iM2027v);
            if (this.f3465r.mo2116e(viewM2025u) < i3 || this.f3465r.mo2125o(viewM2025u) < i3) {
                return;
            }
            C0785c0 c0785c0 = (C0785c0) viewM2025u.getLayoutParams();
            c0785c0.getClass();
            if (c0785c0.f2242e.f2273a.size() == 1) {
                return;
            }
            C0791f0 c0791f0 = c0785c0.f2242e;
            ArrayList arrayList = c0791f0.f2273a;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            C0785c0 c0785c02 = (C0785c0) view.getLayoutParams();
            c0785c02.f2242e = null;
            if (c0785c02.f2154a.m2058i() || c0785c02.f2154a.m2061l()) {
                c0791f0.f2276d -= c0791f0.f2278f.f3465r.mo2114c(view);
            }
            if (size == 1) {
                c0791f0.f2274b = Integer.MIN_VALUE;
            }
            c0791f0.f2275c = Integer.MIN_VALUE;
            m1993d0(viewM2025u, c0769o);
        }
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: S */
    public final void mo1979S() {
        C0009j c0009j = this.f3453B;
        int[] iArr = (int[]) c0009j.f30f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        c0009j.f31g = null;
        m1998g0();
    }

    /* JADX INFO: renamed from: S0 */
    public final void m2645S0(C0769O c0769o, int i3) {
        while (m2027v() > 0) {
            View viewM2025u = m2025u(0);
            if (this.f3465r.mo2113b(viewM2025u) > i3 || this.f3465r.mo2124n(viewM2025u) > i3) {
                return;
            }
            C0785c0 c0785c0 = (C0785c0) viewM2025u.getLayoutParams();
            c0785c0.getClass();
            if (c0785c0.f2242e.f2273a.size() == 1) {
                return;
            }
            C0791f0 c0791f0 = c0785c0.f2242e;
            ArrayList arrayList = c0791f0.f2273a;
            View view = (View) arrayList.remove(0);
            C0785c0 c0785c02 = (C0785c0) view.getLayoutParams();
            c0785c02.f2242e = null;
            if (arrayList.size() == 0) {
                c0791f0.f2275c = Integer.MIN_VALUE;
            }
            if (c0785c02.f2154a.m2058i() || c0785c02.f2154a.m2061l()) {
                c0791f0.f2276d -= c0791f0.f2278f.f3465r.mo2114c(view);
            }
            c0791f0.f2274b = Integer.MIN_VALUE;
            m1993d0(viewM2025u, c0769o);
        }
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: T */
    public final void mo1980T(int i3, int i4) {
        m2636J0(i3, i4, 8);
    }

    /* JADX INFO: renamed from: T0 */
    public final void m2646T0() {
        if (this.f3467t == 1 || !m2638L0()) {
            this.f3471x = this.f3470w;
        } else {
            this.f3471x = !this.f3470w;
        }
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: U */
    public final void mo1981U(int i3, int i4) {
        m2636J0(i3, i4, 2);
    }

    /* JADX INFO: renamed from: U0 */
    public final int m2647U0(int i3, C0769O c0769o, C0774U c0774u) {
        if (m2027v() == 0 || i3 == 0) {
            return 0;
        }
        m2642P0(i3, c0774u);
        C0804p c0804p = this.f3469v;
        int iM2627A0 = m2627A0(c0769o, c0804p, c0774u);
        if (c0804p.f2360b >= iM2627A0) {
            i3 = i3 < 0 ? -iM2627A0 : iM2627A0;
        }
        this.f3465r.mo2126p(-i3);
        this.f3455D = this.f3471x;
        c0804p.f2360b = 0;
        m2643Q0(c0769o, c0804p);
        return i3;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: V */
    public final void mo1982V(int i3, int i4) {
        m2636J0(i3, i4, 4);
    }

    /* JADX INFO: renamed from: V0 */
    public final void m2648V0(int i3) {
        C0804p c0804p = this.f3469v;
        c0804p.f2363e = i3;
        c0804p.f2362d = this.f3471x != (i3 == -1) ? -1 : 1;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: W */
    public final void mo1983W(C0769O c0769o, C0774U c0774u) {
        m2640N0(c0769o, c0774u, true);
    }

    /* JADX INFO: renamed from: W0 */
    public final void m2649W0(int i3, C0774U c0774u) {
        int iMo2123l;
        int iMo2123l2;
        int i4;
        C0804p c0804p = this.f3469v;
        boolean z3 = false;
        c0804p.f2360b = 0;
        c0804p.f2361c = i3;
        C0809u c0809u = this.f2143e;
        if (!(c0809u != null && c0809u.f2396e) || (i4 = c0774u.f2180a) == -1) {
            iMo2123l = 0;
            iMo2123l2 = 0;
        } else {
            if (this.f3471x == (i4 < i3)) {
                iMo2123l = this.f3465r.mo2123l();
                iMo2123l2 = 0;
            } else {
                iMo2123l2 = this.f3465r.mo2123l();
                iMo2123l = 0;
            }
        }
        RecyclerView recyclerView = this.f2140b;
        if (recyclerView == null || !recyclerView.f3424k) {
            c0804p.f2365g = this.f3465r.mo2117f() + iMo2123l;
            c0804p.f2364f = -iMo2123l2;
        } else {
            c0804p.f2364f = this.f3465r.mo2122k() - iMo2123l2;
            c0804p.f2365g = this.f3465r.mo2118g() + iMo2123l;
        }
        c0804p.f2366h = false;
        c0804p.f2359a = true;
        if (this.f3465r.mo2120i() == 0 && this.f3465r.mo2117f() == 0) {
            z3 = true;
        }
        c0804p.f2367i = z3;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: X */
    public final void mo1984X(C0774U c0774u) {
        this.f3473z = -1;
        this.f3452A = Integer.MIN_VALUE;
        this.f3457F = null;
        this.f3459H.m2075a();
    }

    /* JADX INFO: renamed from: X0 */
    public final void m2650X0(C0791f0 c0791f0, int i3, int i4) {
        int i5 = c0791f0.f2276d;
        int i6 = c0791f0.f2277e;
        if (i3 != -1) {
            int i7 = c0791f0.f2275c;
            if (i7 == Integer.MIN_VALUE) {
                c0791f0.m2076a();
                i7 = c0791f0.f2275c;
            }
            if (i7 - i5 >= i4) {
                this.f3472y.set(i6, false);
                return;
            }
            return;
        }
        int i8 = c0791f0.f2274b;
        if (i8 == Integer.MIN_VALUE) {
            View view = (View) c0791f0.f2273a.get(0);
            C0785c0 c0785c0 = (C0785c0) view.getLayoutParams();
            c0791f0.f2274b = c0791f0.f2278f.f3465r.mo2116e(view);
            c0785c0.getClass();
            i8 = c0791f0.f2274b;
        }
        if (i8 + i5 <= i4) {
            this.f3472y.set(i6, false);
        }
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: Y */
    public final void mo1985Y(Parcelable parcelable) {
        if (parcelable instanceof C0789e0) {
            this.f3457F = (C0789e0) parcelable;
            m1998g0();
        }
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: Z */
    public final Parcelable mo1986Z() {
        int iM2083h;
        int iMo2122k;
        int[] iArr;
        C0789e0 c0789e0 = this.f3457F;
        if (c0789e0 != null) {
            C0789e0 c0789e02 = new C0789e0();
            c0789e02.f2260g = c0789e0.f2260g;
            c0789e02.f2258e = c0789e0.f2258e;
            c0789e02.f2259f = c0789e0.f2259f;
            c0789e02.f2261h = c0789e0.f2261h;
            c0789e02.f2262i = c0789e0.f2262i;
            c0789e02.f2263j = c0789e0.f2263j;
            c0789e02.f2265l = c0789e0.f2265l;
            c0789e02.f2266m = c0789e0.f2266m;
            c0789e02.f2267n = c0789e0.f2267n;
            c0789e02.f2264k = c0789e0.f2264k;
            return c0789e02;
        }
        C0789e0 c0789e03 = new C0789e0();
        c0789e03.f2265l = this.f3470w;
        c0789e03.f2266m = this.f3455D;
        c0789e03.f2267n = this.f3456E;
        C0009j c0009j = this.f3453B;
        if (c0009j == null || (iArr = (int[]) c0009j.f30f) == null) {
            c0789e03.f2262i = 0;
        } else {
            c0789e03.f2263j = iArr;
            c0789e03.f2262i = iArr.length;
            c0789e03.f2264k = (List) c0009j.f31g;
        }
        if (m2027v() > 0) {
            c0789e03.f2258e = this.f3455D ? m2633G0() : m2632F0();
            View viewM2628B0 = this.f3471x ? m2628B0(true) : m2629C0(true);
            c0789e03.f2259f = viewM2628B0 != null ? AbstractC0763I.m1958D(viewM2628B0) : -1;
            int i3 = this.f3463p;
            c0789e03.f2260g = i3;
            c0789e03.f2261h = new int[i3];
            for (int i4 = 0; i4 < this.f3463p; i4++) {
                if (this.f3455D) {
                    iM2083h = this.f3464q[i4].m2081f(Integer.MIN_VALUE);
                    if (iM2083h != Integer.MIN_VALUE) {
                        iMo2122k = this.f3465r.mo2118g();
                        iM2083h -= iMo2122k;
                    }
                } else {
                    iM2083h = this.f3464q[i4].m2083h(Integer.MIN_VALUE);
                    if (iM2083h != Integer.MIN_VALUE) {
                        iMo2122k = this.f3465r.mo2122k();
                        iM2083h -= iMo2122k;
                    }
                }
                c0789e03.f2261h[i4] = iM2083h;
            }
        } else {
            c0789e03.f2258e = -1;
            c0789e03.f2259f = -1;
            c0789e03.f2260g = 0;
        }
        return c0789e03;
    }

    @Override // p073Z.InterfaceC0773T
    /* JADX INFO: renamed from: a */
    public final PointF mo2045a(int i3) {
        int iM2651v0 = m2651v0(i3);
        PointF pointF = new PointF();
        if (iM2651v0 == 0) {
            return null;
        }
        if (this.f3467t == 0) {
            pointF.x = iM2651v0;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iM2651v0;
        }
        return pointF;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: a0 */
    public final void mo1987a0(int i3) {
        if (i3 == 0) {
            m2652w0();
        }
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: c */
    public final void mo1990c(String str) {
        RecyclerView recyclerView;
        if (this.f3457F != null || (recyclerView = this.f2140b) == null) {
            return;
        }
        recyclerView.m2609i(str);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: d */
    public final boolean mo1992d() {
        return this.f3467t == 0;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: e */
    public final boolean mo1994e() {
        return this.f3467t == 1;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: f */
    public final boolean mo1996f(C0764J c0764j) {
        return c0764j instanceof C0785c0;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: h */
    public final void mo1999h(int i3, int i4, C0774U c0774u, C0693a c0693a) {
        C0804p c0804p;
        int iM2081f;
        int iM2083h;
        if (this.f3467t != 0) {
            i3 = i4;
        }
        if (m2027v() == 0 || i3 == 0) {
            return;
        }
        m2642P0(i3, c0774u);
        int[] iArr = this.f3461J;
        if (iArr == null || iArr.length < this.f3463p) {
            this.f3461J = new int[this.f3463p];
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = this.f3463p;
            c0804p = this.f3469v;
            if (i5 >= i7) {
                break;
            }
            if (c0804p.f2362d == -1) {
                iM2081f = c0804p.f2364f;
                iM2083h = this.f3464q[i5].m2083h(iM2081f);
            } else {
                iM2081f = this.f3464q[i5].m2081f(c0804p.f2365g);
                iM2083h = c0804p.f2365g;
            }
            int i8 = iM2081f - iM2083h;
            if (i8 >= 0) {
                this.f3461J[i6] = i8;
                i6++;
            }
            i5++;
        }
        Arrays.sort(this.f3461J, 0, i6);
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = c0804p.f2361c;
            if (i10 < 0 || i10 >= c0774u.m2047b()) {
                return;
            }
            c0693a.m1667a(c0804p.f2361c, this.f3461J[i9]);
            c0804p.f2361c += c0804p.f2362d;
        }
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: h0 */
    public final int mo2000h0(int i3, C0769O c0769o, C0774U c0774u) {
        return m2647U0(i3, c0769o, c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: i0 */
    public final void mo2002i0(int i3) {
        C0789e0 c0789e0 = this.f3457F;
        if (c0789e0 != null && c0789e0.f2258e != i3) {
            c0789e0.f2261h = null;
            c0789e0.f2260g = 0;
            c0789e0.f2258e = -1;
            c0789e0.f2259f = -1;
        }
        this.f3473z = i3;
        this.f3452A = Integer.MIN_VALUE;
        m1998g0();
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: j */
    public final int mo2003j(C0774U c0774u) {
        return m2653x0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: j0 */
    public final int mo2004j0(int i3, C0769O c0769o, C0774U c0774u) {
        return m2647U0(i3, c0769o, c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: k */
    public final int mo2005k(C0774U c0774u) {
        return m2654y0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: l */
    public final int mo2007l(C0774U c0774u) {
        return m2655z0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: m */
    public final int mo2009m(C0774U c0774u) {
        return m2653x0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: m0 */
    public final void mo2010m0(Rect rect, int i3, int i4) {
        int iM1962g;
        int iM1962g2;
        int i5 = this.f3463p;
        int iM1966B = m1966B() + m1965A();
        int iM2029z = m2029z() + m1967C();
        if (this.f3467t == 1) {
            int iHeight = rect.height() + iM2029z;
            RecyclerView recyclerView = this.f2140b;
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            iM1962g2 = AbstractC0763I.m1962g(i4, iHeight, AbstractC0307B.m588d(recyclerView));
            iM1962g = AbstractC0763I.m1962g(i3, (this.f3468u * i5) + iM1966B, AbstractC0307B.m589e(this.f2140b));
        } else {
            int iWidth = rect.width() + iM1966B;
            RecyclerView recyclerView2 = this.f2140b;
            WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
            iM1962g = AbstractC0763I.m1962g(i3, iWidth, AbstractC0307B.m589e(recyclerView2));
            iM1962g2 = AbstractC0763I.m1962g(i4, (this.f3468u * i5) + iM2029z, AbstractC0307B.m588d(this.f2140b));
        }
        this.f2140b.setMeasuredDimension(iM1962g, iM1962g2);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: n */
    public final int mo2011n(C0774U c0774u) {
        return m2654y0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: o */
    public final int mo2013o(C0774U c0774u) {
        return m2655z0(c0774u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: r */
    public final C0764J mo2019r() {
        return this.f3467t == 0 ? new C0785c0(-2, -1) : new C0785c0(-1, -2);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: s */
    public final C0764J mo2021s(Context context, AttributeSet attributeSet) {
        return new C0785c0(context, attributeSet);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: s0 */
    public final void mo2022s0(RecyclerView recyclerView, int i3) {
        C0809u c0809u = new C0809u(recyclerView.getContext());
        c0809u.f2392a = i3;
        m2024t0(c0809u);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: t */
    public final C0764J mo2023t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0785c0((ViewGroup.MarginLayoutParams) layoutParams) : new C0785c0(layoutParams);
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: u0 */
    public final boolean mo2026u0() {
        return this.f3457F == null;
    }

    /* JADX INFO: renamed from: v0 */
    public final int m2651v0(int i3) {
        if (m2027v() == 0) {
            return this.f3471x ? 1 : -1;
        }
        return (i3 < m2632F0()) != this.f3471x ? -1 : 1;
    }

    /* JADX INFO: renamed from: w0 */
    public final boolean m2652w0() {
        int iM2632F0;
        if (m2027v() != 0 && this.f3454C != 0 && this.f2145g) {
            if (this.f3471x) {
                iM2632F0 = m2633G0();
                m2632F0();
            } else {
                iM2632F0 = m2632F0();
                m2633G0();
            }
            C0009j c0009j = this.f3453B;
            if (iM2632F0 == 0 && m2637K0() != null) {
                int[] iArr = (int[]) c0009j.f30f;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                c0009j.f31g = null;
                this.f2144f = true;
                m1998g0();
                return true;
            }
        }
        return false;
    }

    @Override // p073Z.AbstractC0763I
    /* JADX INFO: renamed from: x */
    public final int mo2028x(C0769O c0769o, C0774U c0774u) {
        return this.f3467t == 1 ? this.f3463p : super.mo2028x(c0769o, c0774u);
    }

    /* JADX INFO: renamed from: x0 */
    public final int m2653x0(C0774U c0774u) {
        if (m2027v() == 0) {
            return 0;
        }
        AbstractC0811w abstractC0811w = this.f3465r;
        boolean z3 = this.f3460I;
        return AbstractC0473V.m994F(c0774u, abstractC0811w, m2629C0(!z3), m2628B0(!z3), this, this.f3460I);
    }

    /* JADX INFO: renamed from: y0 */
    public final int m2654y0(C0774U c0774u) {
        if (m2027v() == 0) {
            return 0;
        }
        AbstractC0811w abstractC0811w = this.f3465r;
        boolean z3 = this.f3460I;
        return AbstractC0473V.m995G(c0774u, abstractC0811w, m2629C0(!z3), m2628B0(!z3), this, this.f3460I, this.f3471x);
    }

    /* JADX INFO: renamed from: z0 */
    public final int m2655z0(C0774U c0774u) {
        if (m2027v() == 0) {
            return 0;
        }
        AbstractC0811w abstractC0811w = this.f3465r;
        boolean z3 = this.f3460I;
        return AbstractC0473V.m996H(c0774u, abstractC0811w, m2629C0(!z3), m2628B0(!z3), this, this.f3460I);
    }
}
