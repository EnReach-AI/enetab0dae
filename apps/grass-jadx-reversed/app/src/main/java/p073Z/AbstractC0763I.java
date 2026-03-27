package p073Z;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.C1100C;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p001A.C0009j;
import p019F0.C0221e;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p032K.C0391i;
import p036L0.C0444d;
import p067W1.C0693a;
import p070Y.AbstractC0736a;

/* JADX INFO: renamed from: Z.I */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0763I {

    /* JADX INFO: renamed from: a */
    public C1100C f2139a;

    /* JADX INFO: renamed from: b */
    public RecyclerView f2140b;

    /* JADX INFO: renamed from: c */
    public final C0009j f2141c;

    /* JADX INFO: renamed from: d */
    public final C0009j f2142d;

    /* JADX INFO: renamed from: e */
    public C0809u f2143e;

    /* JADX INFO: renamed from: f */
    public boolean f2144f;

    /* JADX INFO: renamed from: g */
    public boolean f2145g;

    /* JADX INFO: renamed from: h */
    public final boolean f2146h;

    /* JADX INFO: renamed from: i */
    public final boolean f2147i;

    /* JADX INFO: renamed from: j */
    public int f2148j;

    /* JADX INFO: renamed from: k */
    public boolean f2149k;

    /* JADX INFO: renamed from: l */
    public int f2150l;

    /* JADX INFO: renamed from: m */
    public int f2151m;

    /* JADX INFO: renamed from: n */
    public int f2152n;

    /* JADX INFO: renamed from: o */
    public int f2153o;

    public AbstractC0763I() {
        C0221e c0221e = new C0221e(9, this);
        C0444d c0444d = new C0444d(this);
        this.f2141c = new C0009j(c0221e);
        this.f2142d = new C0009j(c0444d);
        this.f2144f = false;
        this.f2145g = false;
        this.f2146h = true;
        this.f2147i = true;
    }

    /* JADX INFO: renamed from: D */
    public static int m1958D(View view) {
        return ((C0764J) view.getLayoutParams()).f2154a.m2051b();
    }

    /* JADX INFO: renamed from: E */
    public static C0762H m1959E(Context context, AttributeSet attributeSet, int i3, int i4) {
        C0762H c0762h = new C0762H();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0736a.f2103a, i3, i4);
        c0762h.f2135a = typedArrayObtainStyledAttributes.getInt(0, 1);
        c0762h.f2136b = typedArrayObtainStyledAttributes.getInt(10, 1);
        c0762h.f2137c = typedArrayObtainStyledAttributes.getBoolean(9, false);
        c0762h.f2138d = typedArrayObtainStyledAttributes.getBoolean(11, false);
        typedArrayObtainStyledAttributes.recycle();
        return c0762h;
    }

    /* JADX INFO: renamed from: I */
    public static boolean m1960I(int i3, int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (i5 > 0 && i3 != i5) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i3;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i3;
        }
        return true;
    }

    /* JADX INFO: renamed from: J */
    public static void m1961J(View view, int i3, int i4, int i5, int i6) {
        C0764J c0764j = (C0764J) view.getLayoutParams();
        Rect rect = c0764j.f2155b;
        view.layout(i3 + rect.left + ((ViewGroup.MarginLayoutParams) c0764j).leftMargin, i4 + rect.top + ((ViewGroup.MarginLayoutParams) c0764j).topMargin, (i5 - rect.right) - ((ViewGroup.MarginLayoutParams) c0764j).rightMargin, (i6 - rect.bottom) - ((ViewGroup.MarginLayoutParams) c0764j).bottomMargin);
    }

    /* JADX INFO: renamed from: g */
    public static int m1962g(int i3, int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i4, i5) : size : Math.min(size, Math.max(i4, i5));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX INFO: renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m1963w(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            int r5 = r5 - r7
            r7 = 0
            int r5 = java.lang.Math.max(r7, r5)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L1d
            if (r8 < 0) goto L12
        L10:
            r6 = r3
            goto L30
        L12:
            if (r8 != r1) goto L1a
            if (r6 == r2) goto L22
            if (r6 == 0) goto L1a
            if (r6 == r3) goto L22
        L1a:
            r6 = r7
            r8 = r6
            goto L30
        L1d:
            if (r8 < 0) goto L20
            goto L10
        L20:
            if (r8 != r1) goto L24
        L22:
            r8 = r5
            goto L30
        L24:
            if (r8 != r0) goto L1a
            if (r6 == r2) goto L2e
            if (r6 != r3) goto L2b
            goto L2e
        L2b:
            r8 = r5
            r6 = r7
            goto L30
        L2e:
            r8 = r5
            r6 = r2
        L30:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p073Z.AbstractC0763I.m1963w(boolean, int, int, int, int):int");
    }

    /* JADX INFO: renamed from: y */
    public static void m1964y(View view, Rect rect) {
        int[] iArr = RecyclerView.f3382w0;
        C0764J c0764j = (C0764J) view.getLayoutParams();
        Rect rect2 = c0764j.f2155b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) c0764j).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) c0764j).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) c0764j).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) c0764j).bottomMargin);
    }

    /* JADX INFO: renamed from: A */
    public final int m1965A() {
        RecyclerView recyclerView = this.f2140b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    /* JADX INFO: renamed from: B */
    public final int m1966B() {
        RecyclerView recyclerView = this.f2140b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    /* JADX INFO: renamed from: C */
    public final int m1967C() {
        RecyclerView recyclerView = this.f2140b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    /* JADX INFO: renamed from: F */
    public int mo1968F(C0769O c0769o, C0774U c0774u) {
        RecyclerView recyclerView = this.f2140b;
        if (recyclerView == null || recyclerView.f3432o == null || !mo1994e()) {
            return 1;
        }
        return this.f2140b.f3432o.mo1944a();
    }

    /* JADX INFO: renamed from: G */
    public final void m1969G(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((C0764J) view.getLayoutParams()).f2155b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.f2140b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.f2140b.f3430n;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    /* JADX INFO: renamed from: H */
    public abstract boolean mo1970H();

    /* JADX INFO: renamed from: K */
    public void mo1971K(int i3) {
        RecyclerView recyclerView = this.f2140b;
        if (recyclerView != null) {
            int iM2852h = recyclerView.f3420i.m2852h();
            for (int i4 = 0; i4 < iM2852h; i4++) {
                recyclerView.f3420i.m2851g(i4).offsetLeftAndRight(i3);
            }
        }
    }

    /* JADX INFO: renamed from: L */
    public void mo1972L(int i3) {
        RecyclerView recyclerView = this.f2140b;
        if (recyclerView != null) {
            int iM2852h = recyclerView.f3420i.m2852h();
            for (int i4 = 0; i4 < iM2852h; i4++) {
                recyclerView.f3420i.m2851g(i4).offsetTopAndBottom(i3);
            }
        }
    }

    /* JADX INFO: renamed from: M */
    public abstract void mo1973M(RecyclerView recyclerView);

    /* JADX INFO: renamed from: N */
    public abstract View mo1974N(View view, int i3, C0769O c0769o, C0774U c0774u);

    /* JADX INFO: renamed from: O */
    public void mo1975O(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f2140b;
        C0769O c0769o = recyclerView.f3414f;
        C0774U c0774u = recyclerView.f3417g0;
        if (recyclerView == null || accessibilityEvent == null) {
            return;
        }
        boolean z3 = true;
        if (!recyclerView.canScrollVertically(1) && !this.f2140b.canScrollVertically(-1) && !this.f2140b.canScrollHorizontally(-1) && !this.f2140b.canScrollHorizontally(1)) {
            z3 = false;
        }
        accessibilityEvent.setScrollable(z3);
        AbstractC0756B abstractC0756B = this.f2140b.f3432o;
        if (abstractC0756B != null) {
            accessibilityEvent.setItemCount(abstractC0756B.mo1944a());
        }
    }

    /* JADX INFO: renamed from: P */
    public void mo1976P(C0769O c0769o, C0774U c0774u, View view, C0391i c0391i) {
        c0391i.m873f(C0444d.m977w(false, mo1994e() ? m1958D(view) : 0, 1, mo1992d() ? m1958D(view) : 0, 1));
    }

    /* JADX INFO: renamed from: Q */
    public final void m1977Q(View view, C0391i c0391i) {
        AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(view);
        if (abstractC0777XM2571I == null || abstractC0777XM2571I.m2058i() || ((ArrayList) this.f2139a.f3801h).contains(abstractC0777XM2571I.f2202a)) {
            return;
        }
        RecyclerView recyclerView = this.f2140b;
        mo1976P(recyclerView.f3414f, recyclerView.f3417g0, view, c0391i);
    }

    /* JADX INFO: renamed from: R */
    public void mo1978R(int i3, int i4) {
    }

    /* JADX INFO: renamed from: S */
    public void mo1979S() {
    }

    /* JADX INFO: renamed from: T */
    public void mo1980T(int i3, int i4) {
    }

    /* JADX INFO: renamed from: U */
    public void mo1981U(int i3, int i4) {
    }

    /* JADX INFO: renamed from: V */
    public void mo1982V(int i3, int i4) {
    }

    /* JADX INFO: renamed from: W */
    public abstract void mo1983W(C0769O c0769o, C0774U c0774u);

    /* JADX INFO: renamed from: X */
    public abstract void mo1984X(C0774U c0774u);

    /* JADX INFO: renamed from: Y */
    public abstract void mo1985Y(Parcelable parcelable);

    /* JADX INFO: renamed from: Z */
    public abstract Parcelable mo1986Z();

    /* JADX INFO: renamed from: a0 */
    public void mo1987a0(int i3) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1988b(android.view.View r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p073Z.AbstractC0763I.m1988b(android.view.View, int, boolean):void");
    }

    /* JADX INFO: renamed from: b0 */
    public final void m1989b0(C0769O c0769o) {
        for (int iM2027v = m2027v() - 1; iM2027v >= 0; iM2027v--) {
            if (!RecyclerView.m2571I(m2025u(iM2027v)).m2065p()) {
                View viewM2025u = m2025u(iM2027v);
                m1995e0(iM2027v);
                c0769o.m2038f(viewM2025u);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo1990c(String str);

    /* JADX INFO: renamed from: c0 */
    public final void m1991c0(C0769O c0769o) {
        ArrayList arrayList;
        int size = c0769o.f2164a.size();
        int i3 = size - 1;
        while (true) {
            arrayList = c0769o.f2164a;
            if (i3 < 0) {
                break;
            }
            View view = ((AbstractC0777X) arrayList.get(i3)).f2202a;
            AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(view);
            if (!abstractC0777XM2571I.m2065p()) {
                abstractC0777XM2571I.m2064o(false);
                if (abstractC0777XM2571I.m2060k()) {
                    this.f2140b.removeDetachedView(view, false);
                }
                AbstractC0760F abstractC0760F = this.f2140b.f3396L;
                if (abstractC0760F != null) {
                    abstractC0760F.mo1953e(abstractC0777XM2571I);
                }
                abstractC0777XM2571I.m2064o(true);
                AbstractC0777X abstractC0777XM2571I2 = RecyclerView.m2571I(view);
                abstractC0777XM2571I2.f2215n = null;
                abstractC0777XM2571I2.f2216o = false;
                abstractC0777XM2571I2.f2211j &= -33;
                c0769o.m2039g(abstractC0777XM2571I2);
            }
            i3--;
        }
        arrayList.clear();
        ArrayList arrayList2 = c0769o.f2165b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f2140b.invalidate();
        }
    }

    /* JADX INFO: renamed from: d */
    public abstract boolean mo1992d();

    /* JADX INFO: renamed from: d0 */
    public final void m1993d0(View view, C0769O c0769o) {
        C1100C c1100c = this.f2139a;
        C0755A c0755a = (C0755A) c1100c.f3799f;
        int iIndexOfChild = c0755a.f2126a.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            if (((C0782b) c1100c.f3800g).m2072f(iIndexOfChild)) {
                c1100c.m2861s(view);
            }
            c0755a.m1943a(iIndexOfChild);
        }
        c0769o.m2038f(view);
    }

    /* JADX INFO: renamed from: e */
    public abstract boolean mo1994e();

    /* JADX INFO: renamed from: e0 */
    public final void m1995e0(int i3) {
        if (m2025u(i3) != null) {
            C1100C c1100c = this.f2139a;
            int iM2853j = c1100c.m2853j(i3);
            C0755A c0755a = (C0755A) c1100c.f3799f;
            View childAt = c0755a.f2126a.getChildAt(iM2853j);
            if (childAt == null) {
                return;
            }
            if (((C0782b) c1100c.f3800g).m2072f(iM2853j)) {
                c1100c.m2861s(childAt);
            }
            c0755a.m1943a(iM2853j);
        }
    }

    /* JADX INFO: renamed from: f */
    public boolean mo1996f(C0764J c0764j) {
        return c0764j != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b2  */
    /* JADX INFO: renamed from: f0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m1997f0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.m1965A()
            int r1 = r8.m1967C()
            int r2 = r8.f2152n
            int r3 = r8.m1966B()
            int r2 = r2 - r3
            int r3 = r8.f2153o
            int r4 = r8.m2029z()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            androidx.recyclerview.widget.RecyclerView r3 = r8.f2140b
            java.util.WeakHashMap r7 = p029J.AbstractC0323S.f816a
            int r3 = p029J.AbstractC0308C.m607d(r3)
            r7 = 1
            if (r3 != r7) goto L60
            if (r2 == 0) goto L5b
            goto L68
        L5b:
            int r2 = java.lang.Math.max(r6, r10)
            goto L68
        L60:
            if (r6 == 0) goto L63
            goto L67
        L63:
            int r6 = java.lang.Math.min(r4, r2)
        L67:
            r2 = r6
        L68:
            if (r1 == 0) goto L6b
            goto L6f
        L6b:
            int r1 = java.lang.Math.min(r5, r11)
        L6f:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lb2
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L80
            goto Lb7
        L80:
            int r1 = r8.m1965A()
            int r2 = r8.m1967C()
            int r3 = r8.f2152n
            int r4 = r8.m1966B()
            int r3 = r3 - r4
            int r4 = r8.f2153o
            int r5 = r8.m2029z()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.f2140b
            android.graphics.Rect r5 = r5.f3426l
            m1964y(r13, r5)
            int r13 = r5.left
            int r13 = r13 - r11
            if (r13 >= r3) goto Lb7
            int r13 = r5.right
            int r13 = r13 - r11
            if (r13 <= r1) goto Lb7
            int r13 = r5.top
            int r13 = r13 - r10
            if (r13 >= r4) goto Lb7
            int r13 = r5.bottom
            int r13 = r13 - r10
            if (r13 > r2) goto Lb2
            goto Lb7
        Lb2:
            if (r11 != 0) goto Lb8
            if (r10 == 0) goto Lb7
            goto Lb8
        Lb7:
            return r0
        Lb8:
            if (r12 == 0) goto Lbe
            r9.scrollBy(r11, r10)
            goto Lc1
        Lbe:
            r9.m2602b0(r11, r10, r0)
        Lc1:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p073Z.AbstractC0763I.m1997f0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    /* JADX INFO: renamed from: g0 */
    public final void m1998g0() {
        RecyclerView recyclerView = this.f2140b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    /* JADX INFO: renamed from: h */
    public abstract void mo1999h(int i3, int i4, C0774U c0774u, C0693a c0693a);

    /* JADX INFO: renamed from: h0 */
    public abstract int mo2000h0(int i3, C0769O c0769o, C0774U c0774u);

    /* JADX INFO: renamed from: i */
    public void mo2001i(int i3, C0693a c0693a) {
    }

    /* JADX INFO: renamed from: i0 */
    public abstract void mo2002i0(int i3);

    /* JADX INFO: renamed from: j */
    public abstract int mo2003j(C0774U c0774u);

    /* JADX INFO: renamed from: j0 */
    public abstract int mo2004j0(int i3, C0769O c0769o, C0774U c0774u);

    /* JADX INFO: renamed from: k */
    public abstract int mo2005k(C0774U c0774u);

    /* JADX INFO: renamed from: k0 */
    public final void m2006k0(RecyclerView recyclerView) {
        m2008l0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    /* JADX INFO: renamed from: l */
    public abstract int mo2007l(C0774U c0774u);

    /* JADX INFO: renamed from: l0 */
    public final void m2008l0(int i3, int i4) {
        this.f2152n = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        this.f2150l = mode;
        if (mode == 0) {
            int[] iArr = RecyclerView.f3382w0;
        }
        this.f2153o = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i4);
        this.f2151m = mode2;
        if (mode2 == 0) {
            int[] iArr2 = RecyclerView.f3382w0;
        }
    }

    /* JADX INFO: renamed from: m */
    public abstract int mo2009m(C0774U c0774u);

    /* JADX INFO: renamed from: m0 */
    public void mo2010m0(Rect rect, int i3, int i4) {
        int iM1966B = m1966B() + m1965A() + rect.width();
        int iM2029z = m2029z() + m1967C() + rect.height();
        RecyclerView recyclerView = this.f2140b;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        this.f2140b.setMeasuredDimension(m1962g(i3, iM1966B, AbstractC0307B.m589e(recyclerView)), m1962g(i4, iM2029z, AbstractC0307B.m588d(this.f2140b)));
    }

    /* JADX INFO: renamed from: n */
    public abstract int mo2011n(C0774U c0774u);

    /* JADX INFO: renamed from: n0 */
    public final void m2012n0(int i3, int i4) {
        int iM2027v = m2027v();
        if (iM2027v == 0) {
            this.f2140b.m2613n(i3, i4);
            return;
        }
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = Integer.MIN_VALUE;
        int i8 = Integer.MAX_VALUE;
        for (int i9 = 0; i9 < iM2027v; i9++) {
            View viewM2025u = m2025u(i9);
            Rect rect = this.f2140b.f3426l;
            m1964y(viewM2025u, rect);
            int i10 = rect.left;
            if (i10 < i8) {
                i8 = i10;
            }
            int i11 = rect.right;
            if (i11 > i5) {
                i5 = i11;
            }
            int i12 = rect.top;
            if (i12 < i6) {
                i6 = i12;
            }
            int i13 = rect.bottom;
            if (i13 > i7) {
                i7 = i13;
            }
        }
        this.f2140b.f3426l.set(i8, i6, i5, i7);
        mo2010m0(this.f2140b.f3426l, i3, i4);
    }

    /* JADX INFO: renamed from: o */
    public abstract int mo2013o(C0774U c0774u);

    /* JADX INFO: renamed from: o0 */
    public final void m2014o0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f2140b = null;
            this.f2139a = null;
            this.f2152n = 0;
            this.f2153o = 0;
        } else {
            this.f2140b = recyclerView;
            this.f2139a = recyclerView.f3420i;
            this.f2152n = recyclerView.getWidth();
            this.f2153o = recyclerView.getHeight();
        }
        this.f2150l = 1073741824;
        this.f2151m = 1073741824;
    }

    /* JADX INFO: renamed from: p */
    public final void m2015p(C0769O c0769o) {
        for (int iM2027v = m2027v() - 1; iM2027v >= 0; iM2027v--) {
            View viewM2025u = m2025u(iM2027v);
            AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(viewM2025u);
            if (!abstractC0777XM2571I.m2065p()) {
                if (!abstractC0777XM2571I.m2056g() || abstractC0777XM2571I.m2058i() || this.f2140b.f3432o.f2128b) {
                    m2025u(iM2027v);
                    this.f2139a.m2850f(iM2027v);
                    c0769o.m2040h(viewM2025u);
                    this.f2140b.f3422j.m36N(abstractC0777XM2571I);
                } else {
                    m1995e0(iM2027v);
                    c0769o.m2039g(abstractC0777XM2571I);
                }
            }
        }
    }

    /* JADX INFO: renamed from: p0 */
    public final boolean m2016p0(View view, int i3, int i4, C0764J c0764j) {
        return (!view.isLayoutRequested() && this.f2146h && m1960I(view.getWidth(), i3, ((ViewGroup.MarginLayoutParams) c0764j).width) && m1960I(view.getHeight(), i4, ((ViewGroup.MarginLayoutParams) c0764j).height)) ? false : true;
    }

    /* JADX INFO: renamed from: q */
    public View mo2017q(int i3) {
        int iM2027v = m2027v();
        for (int i4 = 0; i4 < iM2027v; i4++) {
            View viewM2025u = m2025u(i4);
            AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(viewM2025u);
            if (abstractC0777XM2571I != null && abstractC0777XM2571I.m2051b() == i3 && !abstractC0777XM2571I.m2065p() && (this.f2140b.f3417g0.f2186g || !abstractC0777XM2571I.m2058i())) {
                return viewM2025u;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: q0 */
    public boolean mo2018q0() {
        return false;
    }

    /* JADX INFO: renamed from: r */
    public abstract C0764J mo2019r();

    /* JADX INFO: renamed from: r0 */
    public final boolean m2020r0(View view, int i3, int i4, C0764J c0764j) {
        return (this.f2146h && m1960I(view.getMeasuredWidth(), i3, ((ViewGroup.MarginLayoutParams) c0764j).width) && m1960I(view.getMeasuredHeight(), i4, ((ViewGroup.MarginLayoutParams) c0764j).height)) ? false : true;
    }

    /* JADX INFO: renamed from: s */
    public C0764J mo2021s(Context context, AttributeSet attributeSet) {
        return new C0764J(context, attributeSet);
    }

    /* JADX INFO: renamed from: s0 */
    public abstract void mo2022s0(RecyclerView recyclerView, int i3);

    /* JADX INFO: renamed from: t */
    public C0764J mo2023t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0764J ? new C0764J((C0764J) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0764J((ViewGroup.MarginLayoutParams) layoutParams) : new C0764J(layoutParams);
    }

    /* JADX INFO: renamed from: t0 */
    public final void m2024t0(C0809u c0809u) {
        C0809u c0809u2 = this.f2143e;
        if (c0809u2 != null && c0809u != c0809u2 && c0809u2.f2396e) {
            c0809u2.m2112g();
        }
        this.f2143e = c0809u;
        RecyclerView recyclerView = this.f2140b;
        RunnableC0776W runnableC0776W = recyclerView.f3411d0;
        runnableC0776W.f2200k.removeCallbacks(runnableC0776W);
        runnableC0776W.f2196g.abortAnimation();
        if (c0809u.f2399h) {
            Log.w("RecyclerView", "An instance of " + c0809u.getClass().getSimpleName() + " was started more than once. Each instance of" + c0809u.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        c0809u.f2393b = recyclerView;
        c0809u.f2394c = this;
        int i3 = c0809u.f2392a;
        if (i3 == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.f3417g0.f2180a = i3;
        c0809u.f2396e = true;
        c0809u.f2395d = true;
        c0809u.f2397f = recyclerView.f3434p.mo2017q(i3);
        c0809u.f2393b.f3411d0.m2048a();
        c0809u.f2399h = true;
    }

    /* JADX INFO: renamed from: u */
    public final View m2025u(int i3) {
        C1100C c1100c = this.f2139a;
        if (c1100c != null) {
            return c1100c.m2851g(i3);
        }
        return null;
    }

    /* JADX INFO: renamed from: u0 */
    public abstract boolean mo2026u0();

    /* JADX INFO: renamed from: v */
    public final int m2027v() {
        C1100C c1100c = this.f2139a;
        if (c1100c != null) {
            return c1100c.m2852h();
        }
        return 0;
    }

    /* JADX INFO: renamed from: x */
    public int mo2028x(C0769O c0769o, C0774U c0774u) {
        RecyclerView recyclerView = this.f2140b;
        if (recyclerView == null || recyclerView.f3432o == null || !mo1992d()) {
            return 1;
        }
        return this.f2140b.f3432o.mo1944a();
    }

    /* JADX INFO: renamed from: z */
    public final int m2029z() {
        RecyclerView recyclerView = this.f2140b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }
}
