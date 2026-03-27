package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.facebook.C1100C;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p001A.C0009j;
import p007B1.RunnableC0055o;
import p018F.AbstractC0215g;
import p018F.AbstractC0216h;
import p019F0.C0222f;
import p029J.AbstractC0307B;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p029J.C0359o;
import p029J.C0365r;
import p029J.InterfaceC0357n;
import p032K.AbstractC0384b;
import p049Q.InterpolatorC0586d;
import p067W1.C0693a;
import p073Z.AbstractC0756B;
import p073Z.AbstractC0760F;
import p073Z.AbstractC0761G;
import p073Z.AbstractC0763I;
import p073Z.AbstractC0765K;
import p073Z.AbstractC0766L;
import p073Z.AbstractC0775V;
import p073Z.AbstractC0777X;
import p073Z.C0755A;
import p073Z.C0759E;
import p073Z.C0764J;
import p073Z.C0767M;
import p073Z.C0768N;
import p073Z.C0769O;
import p073Z.C0771Q;
import p073Z.C0774U;
import p073Z.C0779Z;
import p073Z.C0780a;
import p073Z.C0782b;
import p073Z.C0797i0;
import p073Z.C0800l;
import p073Z.C0809u;
import p073Z.C0814z;
import p073Z.InterfaceC0758D;
import p073Z.InterfaceC0770P;
import p073Z.RunnableC0776W;
import p073Z.RunnableC0802n;
import p125o0.C1798h;
import p128p.C1811e;
import p128p.C1817k;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements InterfaceC0357n {

    /* JADX INFO: renamed from: w0 */
    public static final int[] f3382w0 = {R.attr.nestedScrollingEnabled};

    /* JADX INFO: renamed from: x0 */
    public static final Class[] f3383x0;

    /* JADX INFO: renamed from: y0 */
    public static final InterpolatorC0586d f3384y0;

    /* JADX INFO: renamed from: A */
    public int f3385A;

    /* JADX INFO: renamed from: B */
    public final AccessibilityManager f3386B;

    /* JADX INFO: renamed from: C */
    public boolean f3387C;

    /* JADX INFO: renamed from: D */
    public boolean f3388D;

    /* JADX INFO: renamed from: E */
    public int f3389E;

    /* JADX INFO: renamed from: F */
    public int f3390F;

    /* JADX INFO: renamed from: G */
    public C0759E f3391G;

    /* JADX INFO: renamed from: H */
    public EdgeEffect f3392H;

    /* JADX INFO: renamed from: I */
    public EdgeEffect f3393I;

    /* JADX INFO: renamed from: J */
    public EdgeEffect f3394J;

    /* JADX INFO: renamed from: K */
    public EdgeEffect f3395K;

    /* JADX INFO: renamed from: L */
    public AbstractC0760F f3396L;

    /* JADX INFO: renamed from: M */
    public int f3397M;

    /* JADX INFO: renamed from: N */
    public int f3398N;

    /* JADX INFO: renamed from: O */
    public VelocityTracker f3399O;

    /* JADX INFO: renamed from: P */
    public int f3400P;

    /* JADX INFO: renamed from: Q */
    public int f3401Q;

    /* JADX INFO: renamed from: R */
    public int f3402R;

    /* JADX INFO: renamed from: S */
    public int f3403S;

    /* JADX INFO: renamed from: T */
    public int f3404T;

    /* JADX INFO: renamed from: U */
    public AbstractC0765K f3405U;

    /* JADX INFO: renamed from: V */
    public final int f3406V;

    /* JADX INFO: renamed from: W */
    public final int f3407W;

    /* JADX INFO: renamed from: a0 */
    public final float f3408a0;

    /* JADX INFO: renamed from: b0 */
    public final float f3409b0;

    /* JADX INFO: renamed from: c0 */
    public boolean f3410c0;

    /* JADX INFO: renamed from: d0 */
    public final RunnableC0776W f3411d0;

    /* JADX INFO: renamed from: e */
    public final C0222f f3412e;

    /* JADX INFO: renamed from: e0 */
    public RunnableC0802n f3413e0;

    /* JADX INFO: renamed from: f */
    public final C0769O f3414f;

    /* JADX INFO: renamed from: f0 */
    public final C0693a f3415f0;

    /* JADX INFO: renamed from: g */
    public C0771Q f3416g;

    /* JADX INFO: renamed from: g0 */
    public final C0774U f3417g0;

    /* JADX INFO: renamed from: h */
    public final C1798h f3418h;

    /* JADX INFO: renamed from: h0 */
    public AbstractC0766L f3419h0;

    /* JADX INFO: renamed from: i */
    public final C1100C f3420i;

    /* JADX INFO: renamed from: i0 */
    public ArrayList f3421i0;

    /* JADX INFO: renamed from: j */
    public final C0009j f3422j;

    /* JADX INFO: renamed from: j0 */
    public boolean f3423j0;

    /* JADX INFO: renamed from: k */
    public boolean f3424k;

    /* JADX INFO: renamed from: k0 */
    public boolean f3425k0;

    /* JADX INFO: renamed from: l */
    public final Rect f3426l;

    /* JADX INFO: renamed from: l0 */
    public final C0755A f3427l0;

    /* JADX INFO: renamed from: m */
    public final Rect f3428m;

    /* JADX INFO: renamed from: m0 */
    public boolean f3429m0;

    /* JADX INFO: renamed from: n */
    public final RectF f3430n;

    /* JADX INFO: renamed from: n0 */
    public C0779Z f3431n0;

    /* JADX INFO: renamed from: o */
    public AbstractC0756B f3432o;

    /* JADX INFO: renamed from: o0 */
    public final int[] f3433o0;

    /* JADX INFO: renamed from: p */
    public AbstractC0763I f3434p;

    /* JADX INFO: renamed from: p0 */
    public C0359o f3435p0;

    /* JADX INFO: renamed from: q */
    public final ArrayList f3436q;

    /* JADX INFO: renamed from: q0 */
    public final int[] f3437q0;

    /* JADX INFO: renamed from: r */
    public final ArrayList f3438r;

    /* JADX INFO: renamed from: r0 */
    public final int[] f3439r0;

    /* JADX INFO: renamed from: s */
    public C0800l f3440s;

    /* JADX INFO: renamed from: s0 */
    public final int[] f3441s0;

    /* JADX INFO: renamed from: t */
    public boolean f3442t;

    /* JADX INFO: renamed from: t0 */
    public final ArrayList f3443t0;

    /* JADX INFO: renamed from: u */
    public boolean f3444u;

    /* JADX INFO: renamed from: u0 */
    public final RunnableC0055o f3445u0;

    /* JADX INFO: renamed from: v */
    public boolean f3446v;

    /* JADX INFO: renamed from: v0 */
    public final C0814z f3447v0;

    /* JADX INFO: renamed from: w */
    public int f3448w;

    /* JADX INFO: renamed from: x */
    public boolean f3449x;

    /* JADX INFO: renamed from: y */
    public boolean f3450y;

    /* JADX INFO: renamed from: z */
    public boolean f3451z;

    static {
        Class cls = Integer.TYPE;
        f3383x0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f3384y0 = new InterpolatorC0586d(1);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, io.getgrass.www.R.attr.recyclerViewStyle);
    }

    /* JADX INFO: renamed from: D */
    public static RecyclerView m2570D(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView recyclerViewM2570D = m2570D(viewGroup.getChildAt(i3));
            if (recyclerViewM2570D != null) {
                return recyclerViewM2570D;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: I */
    public static AbstractC0777X m2571I(View view) {
        if (view == null) {
            return null;
        }
        return ((C0764J) view.getLayoutParams()).f2154a;
    }

    private C0359o getScrollingChildHelper() {
        if (this.f3435p0 == null) {
            this.f3435p0 = new C0359o(this);
        }
        return this.f3435p0;
    }

    /* JADX INFO: renamed from: j */
    public static void m2576j(AbstractC0777X abstractC0777X) {
        WeakReference weakReference = abstractC0777X.f2203b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == abstractC0777X.f2202a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            abstractC0777X.f2203b = null;
        }
    }

    /* JADX INFO: renamed from: A */
    public final View m2577A(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* JADX INFO: renamed from: B */
    public final boolean m2578B(MotionEvent motionEvent) {
        boolean z3;
        int action = motionEvent.getAction();
        ArrayList arrayList = this.f3438r;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0800l c0800l = (C0800l) arrayList.get(i3);
            int i4 = c0800l.f2341v;
            if (i4 == 1) {
                boolean zM2094d = c0800l.m2094d(motionEvent.getX(), motionEvent.getY());
                boolean zM2093c = c0800l.m2093c(motionEvent.getX(), motionEvent.getY());
                if (motionEvent.getAction() == 0 && (zM2094d || zM2093c)) {
                    if (zM2093c) {
                        c0800l.f2342w = 1;
                        c0800l.f2335p = (int) motionEvent.getX();
                    } else if (zM2094d) {
                        c0800l.f2342w = 2;
                        c0800l.f2332m = (int) motionEvent.getY();
                    }
                    c0800l.m2095f(2);
                }
            } else {
                z3 = i4 == 2;
            }
            if (z3 && action != 3) {
                this.f3440s = c0800l;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: C */
    public final void m2579C(int[] iArr) {
        int iM2852h = this.f3420i.m2852h();
        if (iM2852h == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < iM2852h; i5++) {
            AbstractC0777X abstractC0777XM2571I = m2571I(this.f3420i.m2851g(i5));
            if (!abstractC0777XM2571I.m2065p()) {
                int iM2051b = abstractC0777XM2571I.m2051b();
                if (iM2051b < i3) {
                    i3 = iM2051b;
                }
                if (iM2051b > i4) {
                    i4 = iM2051b;
                }
            }
        }
        iArr[0] = i3;
        iArr[1] = i4;
    }

    /* JADX INFO: renamed from: E */
    public final AbstractC0777X m2580E(int i3) {
        AbstractC0777X abstractC0777X = null;
        if (this.f3387C) {
            return null;
        }
        int iM2855l = this.f3420i.m2855l();
        for (int i4 = 0; i4 < iM2855l; i4++) {
            AbstractC0777X abstractC0777XM2571I = m2571I(this.f3420i.m2854k(i4));
            if (abstractC0777XM2571I != null && !abstractC0777XM2571I.m2058i() && m2581F(abstractC0777XM2571I) == i3) {
                if (!this.f3420i.m2857n(abstractC0777XM2571I.f2202a)) {
                    return abstractC0777XM2571I;
                }
                abstractC0777X = abstractC0777XM2571I;
            }
        }
        return abstractC0777X;
    }

    /* JADX INFO: renamed from: F */
    public final int m2581F(AbstractC0777X abstractC0777X) {
        if (abstractC0777X.m2053d(524) || !abstractC0777X.m2055f()) {
            return -1;
        }
        C1798h c1798h = this.f3418h;
        int i3 = abstractC0777X.f2204c;
        ArrayList arrayList = (ArrayList) c1798h.f6209b;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            C0780a c0780a = (C0780a) arrayList.get(i4);
            int i5 = c0780a.f2224a;
            if (i5 != 1) {
                if (i5 == 2) {
                    int i6 = c0780a.f2225b;
                    if (i6 <= i3) {
                        int i7 = c0780a.f2227d;
                        if (i6 + i7 > i3) {
                            return -1;
                        }
                        i3 -= i7;
                    } else {
                        continue;
                    }
                } else if (i5 == 8) {
                    int i8 = c0780a.f2225b;
                    if (i8 == i3) {
                        i3 = c0780a.f2227d;
                    } else {
                        if (i8 < i3) {
                            i3--;
                        }
                        if (c0780a.f2227d <= i3) {
                            i3++;
                        }
                    }
                }
            } else if (c0780a.f2225b <= i3) {
                i3 += c0780a.f2227d;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: G */
    public final long m2582G(AbstractC0777X abstractC0777X) {
        return this.f3432o.f2128b ? abstractC0777X.f2206e : abstractC0777X.f2204c;
    }

    /* JADX INFO: renamed from: H */
    public final AbstractC0777X m2583H(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return m2571I(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    /* JADX INFO: renamed from: J */
    public final Rect m2584J(View view) {
        C0764J c0764j = (C0764J) view.getLayoutParams();
        boolean z3 = c0764j.f2156c;
        Rect rect = c0764j.f2155b;
        if (!z3) {
            return rect;
        }
        if (this.f3417g0.f2186g && (c0764j.f2154a.m2061l() || c0764j.f2154a.m2056g())) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.f3436q;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Rect rect2 = this.f3426l;
            rect2.set(0, 0, 0, 0);
            ((AbstractC0761G) arrayList.get(i3)).getClass();
            ((C0764J) view.getLayoutParams()).f2154a.m2051b();
            rect2.set(0, 0, 0, 0);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        c0764j.f2156c = false;
        return rect;
    }

    /* JADX INFO: renamed from: K */
    public final boolean m2585K() {
        return !this.f3446v || this.f3387C || this.f3418h.m3975j();
    }

    /* JADX INFO: renamed from: L */
    public final boolean m2586L() {
        return this.f3389E > 0;
    }

    /* JADX INFO: renamed from: M */
    public final void m2587M(int i3) {
        if (this.f3434p == null) {
            return;
        }
        setScrollState(2);
        this.f3434p.mo2002i0(i3);
        awakenScrollBars();
    }

    /* JADX INFO: renamed from: N */
    public final void m2588N() {
        int iM2855l = this.f3420i.m2855l();
        for (int i3 = 0; i3 < iM2855l; i3++) {
            ((C0764J) this.f3420i.m2854k(i3).getLayoutParams()).f2156c = true;
        }
        ArrayList arrayList = this.f3414f.f2166c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            C0764J c0764j = (C0764J) ((AbstractC0777X) arrayList.get(i4)).f2202a.getLayoutParams();
            if (c0764j != null) {
                c0764j.f2156c = true;
            }
        }
    }

    /* JADX INFO: renamed from: O */
    public final void m2589O(int i3, int i4, boolean z3) {
        int i5 = i3 + i4;
        int iM2855l = this.f3420i.m2855l();
        for (int i6 = 0; i6 < iM2855l; i6++) {
            AbstractC0777X abstractC0777XM2571I = m2571I(this.f3420i.m2854k(i6));
            if (abstractC0777XM2571I != null && !abstractC0777XM2571I.m2065p()) {
                int i7 = abstractC0777XM2571I.f2204c;
                C0774U c0774u = this.f3417g0;
                if (i7 >= i5) {
                    abstractC0777XM2571I.m2062m(-i4, z3);
                    c0774u.f2185f = true;
                } else if (i7 >= i3) {
                    abstractC0777XM2571I.m2050a(8);
                    abstractC0777XM2571I.m2062m(-i4, z3);
                    abstractC0777XM2571I.f2204c = i3 - 1;
                    c0774u.f2185f = true;
                }
            }
        }
        C0769O c0769o = this.f3414f;
        ArrayList arrayList = c0769o.f2166c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AbstractC0777X abstractC0777X = (AbstractC0777X) arrayList.get(size);
            if (abstractC0777X != null) {
                int i8 = abstractC0777X.f2204c;
                if (i8 >= i5) {
                    abstractC0777X.m2062m(-i4, z3);
                } else if (i8 >= i3) {
                    abstractC0777X.m2050a(8);
                    c0769o.m2037e(size);
                }
            }
        }
        requestLayout();
    }

    /* JADX INFO: renamed from: P */
    public final void m2590P() {
        this.f3389E++;
    }

    /* JADX INFO: renamed from: Q */
    public final void m2591Q(boolean z3) {
        int i3;
        AccessibilityManager accessibilityManager;
        int i4 = this.f3389E - 1;
        this.f3389E = i4;
        if (i4 < 1) {
            this.f3389E = 0;
            if (z3) {
                int i5 = this.f3385A;
                this.f3385A = 0;
                if (i5 != 0 && (accessibilityManager = this.f3386B) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    AbstractC0384b.m850b(accessibilityEventObtain, i5);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.f3443t0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    AbstractC0777X abstractC0777X = (AbstractC0777X) arrayList.get(size);
                    if (abstractC0777X.f2202a.getParent() == this && !abstractC0777X.m2065p() && (i3 = abstractC0777X.f2218q) != -1) {
                        WeakHashMap weakHashMap = AbstractC0323S.f816a;
                        AbstractC0307B.m603s(abstractC0777X.f2202a, i3);
                        abstractC0777X.f2218q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    /* JADX INFO: renamed from: R */
    public final void m2592R(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3398N) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.f3398N = motionEvent.getPointerId(i3);
            int x3 = (int) (motionEvent.getX(i3) + 0.5f);
            this.f3402R = x3;
            this.f3400P = x3;
            int y2 = (int) (motionEvent.getY(i3) + 0.5f);
            this.f3403S = y2;
            this.f3401Q = y2;
        }
    }

    /* JADX INFO: renamed from: S */
    public final void m2593S() {
        if (this.f3429m0 || !this.f3442t) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m597m(this, this.f3445u0);
        this.f3429m0 = true;
    }

    /* JADX INFO: renamed from: T */
    public final void m2594T() {
        boolean z3;
        if (this.f3387C) {
            C1798h c1798h = this.f3418h;
            c1798h.m3980o((ArrayList) c1798h.f6209b);
            c1798h.m3980o((ArrayList) c1798h.f6210c);
            if (this.f3388D) {
                this.f3434p.mo1979S();
            }
        }
        if (this.f3396L == null || !this.f3434p.mo2026u0()) {
            this.f3418h.m3971d();
        } else {
            this.f3418h.m3979n();
        }
        boolean z4 = this.f3423j0 || this.f3425k0;
        boolean z5 = this.f3446v && this.f3396L != null && ((z3 = this.f3387C) || z4 || this.f3434p.f2144f) && (!z3 || this.f3432o.f2128b);
        C0774U c0774u = this.f3417g0;
        c0774u.f2189j = z5;
        c0774u.f2190k = z5 && z4 && !this.f3387C && this.f3396L != null && this.f3434p.mo2026u0();
    }

    /* JADX INFO: renamed from: U */
    public final void m2595U(boolean z3) {
        this.f3388D = z3 | this.f3388D;
        this.f3387C = true;
        int iM2855l = this.f3420i.m2855l();
        for (int i3 = 0; i3 < iM2855l; i3++) {
            AbstractC0777X abstractC0777XM2571I = m2571I(this.f3420i.m2854k(i3));
            if (abstractC0777XM2571I != null && !abstractC0777XM2571I.m2065p()) {
                abstractC0777XM2571I.m2050a(6);
            }
        }
        m2588N();
        C0769O c0769o = this.f3414f;
        ArrayList arrayList = c0769o.f2166c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            AbstractC0777X abstractC0777X = (AbstractC0777X) arrayList.get(i4);
            if (abstractC0777X != null) {
                abstractC0777X.m2050a(6);
                abstractC0777X.m2050a(1024);
            }
        }
        AbstractC0756B abstractC0756B = c0769o.f2171h.f3432o;
        if (abstractC0756B == null || !abstractC0756B.f2128b) {
            c0769o.m2036d();
        }
    }

    /* JADX INFO: renamed from: V */
    public final void m2596V(AbstractC0777X abstractC0777X, C0365r c0365r) {
        abstractC0777X.f2211j &= -8193;
        boolean z3 = this.f3417g0.f2187h;
        C0009j c0009j = this.f3422j;
        if (z3 && abstractC0777X.m2061l() && !abstractC0777X.m2058i() && !abstractC0777X.m2065p()) {
            ((C1811e) c0009j.f31g).m4027e(m2582G(abstractC0777X), abstractC0777X);
        }
        C1817k c1817k = (C1817k) c0009j.f30f;
        C0797i0 c0797i0M2091a = (C0797i0) c1817k.getOrDefault(abstractC0777X, null);
        if (c0797i0M2091a == null) {
            c0797i0M2091a = C0797i0.m2091a();
            c1817k.put(abstractC0777X, c0797i0M2091a);
        }
        c0797i0M2091a.f2310b = c0365r;
        c0797i0M2091a.f2309a |= 4;
    }

    /* JADX INFO: renamed from: W */
    public final void m2597W(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f3426l;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C0764J) {
            C0764J c0764j = (C0764J) layoutParams;
            if (!c0764j.f2156c) {
                int i3 = rect.left;
                Rect rect2 = c0764j.f2155b;
                rect.left = i3 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.f3434p.m1997f0(this, view, this.f3426l, !this.f3446v, view2 == null);
    }

    /* JADX INFO: renamed from: X */
    public final void m2598X() {
        VelocityTracker velocityTracker = this.f3399O;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        m2605e0(0);
        EdgeEffect edgeEffect = this.f3392H;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f3392H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f3393I;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f3393I.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3394J;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f3394J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3395K;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f3395K.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0307B.m595k(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0119  */
    /* JADX INFO: renamed from: Y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m2599Y(int r22, int r23, android.view.MotionEvent r24) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.m2599Y(int, int, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: renamed from: Z */
    public final void m2600Z(int i3, int i4, int[] iArr) {
        AbstractC0777X abstractC0777X;
        C1100C c1100c = this.f3420i;
        m2603c0();
        m2590P();
        int i5 = AbstractC0216h.f520a;
        AbstractC0215g.m424a("RV Scroll");
        C0774U c0774u = this.f3417g0;
        m2625z(c0774u);
        C0769O c0769o = this.f3414f;
        int iMo2000h0 = i3 != 0 ? this.f3434p.mo2000h0(i3, c0769o, c0774u) : 0;
        int iMo2004j0 = i4 != 0 ? this.f3434p.mo2004j0(i4, c0769o, c0774u) : 0;
        AbstractC0215g.m425b();
        int iM2852h = c1100c.m2852h();
        for (int i6 = 0; i6 < iM2852h; i6++) {
            View viewM2851g = c1100c.m2851g(i6);
            AbstractC0777X abstractC0777XM2583H = m2583H(viewM2851g);
            if (abstractC0777XM2583H != null && (abstractC0777X = abstractC0777XM2583H.f2210i) != null) {
                int left = viewM2851g.getLeft();
                int top = viewM2851g.getTop();
                View view = abstractC0777X.f2202a;
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        m2591Q(true);
        m2604d0(false);
        if (iArr != null) {
            iArr[0] = iMo2000h0;
            iArr[1] = iMo2004j0;
        }
    }

    /* JADX INFO: renamed from: a0 */
    public final void m2601a0(int i3) {
        C0809u c0809u;
        if (this.f3450y) {
            return;
        }
        setScrollState(0);
        RunnableC0776W runnableC0776W = this.f3411d0;
        runnableC0776W.f2200k.removeCallbacks(runnableC0776W);
        runnableC0776W.f2196g.abortAnimation();
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null && (c0809u = abstractC0763I.f2143e) != null) {
            c0809u.m2112g();
        }
        AbstractC0763I abstractC0763I2 = this.f3434p;
        if (abstractC0763I2 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            abstractC0763I2.mo2002i0(i3);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i3, int i4) {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null) {
            abstractC0763I.getClass();
        }
        super.addFocusables(arrayList, i3, i4);
    }

    /* JADX INFO: renamed from: b0 */
    public final void m2602b0(int i3, int i4, boolean z3) {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f3450y) {
            return;
        }
        if (!abstractC0763I.mo1992d()) {
            i3 = 0;
        }
        if (!this.f3434p.mo1994e()) {
            i4 = 0;
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        if (z3) {
            int i5 = i3 != 0 ? 1 : 0;
            if (i4 != 0) {
                i5 |= 2;
            }
            getScrollingChildHelper().m819h(i5, 1);
        }
        this.f3411d0.m2049b(i3, i4, Integer.MIN_VALUE, null);
    }

    /* JADX INFO: renamed from: c0 */
    public final void m2603c0() {
        int i3 = this.f3448w + 1;
        this.f3448w = i3;
        if (i3 != 1 || this.f3450y) {
            return;
        }
        this.f3449x = false;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0764J) && this.f3434p.mo1996f((C0764J) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null && abstractC0763I.mo1992d()) {
            return this.f3434p.mo2003j(this.f3417g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null && abstractC0763I.mo1992d()) {
            return this.f3434p.mo2005k(this.f3417g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null && abstractC0763I.mo1992d()) {
            return this.f3434p.mo2007l(this.f3417g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null && abstractC0763I.mo1994e()) {
            return this.f3434p.mo2009m(this.f3417g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null && abstractC0763I.mo1994e()) {
            return this.f3434p.mo2011n(this.f3417g0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null && abstractC0763I.mo1994e()) {
            return this.f3434p.mo2013o(this.f3417g0);
        }
        return 0;
    }

    /* JADX INFO: renamed from: d0 */
    public final void m2604d0(boolean z3) {
        if (this.f3448w < 1) {
            this.f3448w = 1;
        }
        if (!z3 && !this.f3450y) {
            this.f3449x = false;
        }
        if (this.f3448w == 1) {
            if (z3 && this.f3449x && !this.f3450y && this.f3434p != null && this.f3432o != null) {
                m2614o();
            }
            if (!this.f3450y) {
                this.f3449x = false;
            }
        }
        this.f3448w--;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f3, float f4, boolean z3) {
        return getScrollingChildHelper().m812a(f3, f4, z3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f3, float f4) {
        return getScrollingChildHelper().m813b(f3, f4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m814c(i3, i4, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr) {
        return getScrollingChildHelper().m816e(i3, i4, i5, i6, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z3;
        super.draw(canvas);
        ArrayList arrayList = this.f3436q;
        int size = arrayList.size();
        boolean z4 = false;
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC0761G) arrayList.get(i3)).mo1957b(canvas);
        }
        EdgeEffect edgeEffect = this.f3392H;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z3 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f3424k ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f3392H;
            z3 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f3393I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f3424k) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f3393I;
            z3 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f3394J;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f3424k ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f3394J;
            z3 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f3395K;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f3424k) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f3395K;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z3 |= z4;
            canvas.restoreToCount(iSave4);
        }
        if ((z3 || this.f3396L == null || arrayList.size() <= 0 || !this.f3396L.mo1955g()) ? z3 : true) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0307B.m595k(this);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    /* JADX INFO: renamed from: e0 */
    public final void m2605e0(int i3) {
        getScrollingChildHelper().m820i(i3);
    }

    /* JADX INFO: renamed from: f */
    public final void m2606f(AbstractC0777X abstractC0777X) {
        View view = abstractC0777X.f2202a;
        boolean z3 = view.getParent() == this;
        this.f3414f.m2042j(m2583H(view));
        if (abstractC0777X.m2060k()) {
            this.f3420i.m2849e(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z3) {
            this.f3420i.m2848d(view, -1, true);
            return;
        }
        C1100C c1100c = this.f3420i;
        int iIndexOfChild = ((C0755A) c1100c.f3799f).f2126a.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            ((C0782b) c1100c.f3800g).m2074h(iIndexOfChild);
            c1100c.m2856m(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    /* JADX INFO: renamed from: g */
    public final void m2607g(AbstractC0761G abstractC0761G) {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null) {
            abstractC0763I.mo1990c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.f3436q;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(abstractC0761G);
        m2588N();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null) {
            return abstractC0763I.mo2019r();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + m2624y());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null) {
            return abstractC0763I.mo2021s(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + m2624y());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public AbstractC0756B getAdapter() {
        return this.f3432o;
    }

    @Override // android.view.View
    public int getBaseline() {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I == null) {
            return super.getBaseline();
        }
        abstractC0763I.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i3, int i4) {
        return super.getChildDrawingOrder(i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f3424k;
    }

    public C0779Z getCompatAccessibilityDelegate() {
        return this.f3431n0;
    }

    public C0759E getEdgeEffectFactory() {
        return this.f3391G;
    }

    public AbstractC0760F getItemAnimator() {
        return this.f3396L;
    }

    public int getItemDecorationCount() {
        return this.f3436q.size();
    }

    public AbstractC0763I getLayoutManager() {
        return this.f3434p;
    }

    public int getMaxFlingVelocity() {
        return this.f3407W;
    }

    public int getMinFlingVelocity() {
        return this.f3406V;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public AbstractC0765K getOnFlingListener() {
        return this.f3405U;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f3410c0;
    }

    public C0768N getRecycledViewPool() {
        return this.f3414f.m2035c();
    }

    public int getScrollState() {
        return this.f3397M;
    }

    /* JADX INFO: renamed from: h */
    public final void m2608h(AbstractC0766L abstractC0766L) {
        if (this.f3421i0 == null) {
            this.f3421i0 = new ArrayList();
        }
        this.f3421i0.add(abstractC0766L);
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m818g(0);
    }

    /* JADX INFO: renamed from: i */
    public final void m2609i(String str) {
        if (m2586L()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + m2624y());
        }
        if (this.f3390F > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + m2624y()));
        }
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f3442t;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f3450y;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f869d;
    }

    /* JADX INFO: renamed from: k */
    public final void m2610k() {
        int iM2855l = this.f3420i.m2855l();
        for (int i3 = 0; i3 < iM2855l; i3++) {
            AbstractC0777X abstractC0777XM2571I = m2571I(this.f3420i.m2854k(i3));
            if (!abstractC0777XM2571I.m2065p()) {
                abstractC0777XM2571I.f2205d = -1;
                abstractC0777XM2571I.f2208g = -1;
            }
        }
        C0769O c0769o = this.f3414f;
        ArrayList arrayList = c0769o.f2166c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            AbstractC0777X abstractC0777X = (AbstractC0777X) arrayList.get(i4);
            abstractC0777X.f2205d = -1;
            abstractC0777X.f2208g = -1;
        }
        ArrayList arrayList2 = c0769o.f2164a;
        int size2 = arrayList2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            AbstractC0777X abstractC0777X2 = (AbstractC0777X) arrayList2.get(i5);
            abstractC0777X2.f2205d = -1;
            abstractC0777X2.f2208g = -1;
        }
        ArrayList arrayList3 = c0769o.f2165b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i6 = 0; i6 < size3; i6++) {
                AbstractC0777X abstractC0777X3 = (AbstractC0777X) c0769o.f2165b.get(i6);
                abstractC0777X3.f2205d = -1;
                abstractC0777X3.f2208g = -1;
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m2611l(int i3, int i4) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f3392H;
        if (edgeEffect == null || edgeEffect.isFinished() || i3 <= 0) {
            zIsFinished = false;
        } else {
            this.f3392H.onRelease();
            zIsFinished = this.f3392H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f3394J;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i3 < 0) {
            this.f3394J.onRelease();
            zIsFinished |= this.f3394J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3393I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i4 > 0) {
            this.f3393I.onRelease();
            zIsFinished |= this.f3393I.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3395K;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i4 < 0) {
            this.f3395K.onRelease();
            zIsFinished |= this.f3395K.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0307B.m595k(this);
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m2612m() {
        C1798h c1798h = this.f3418h;
        if (!this.f3446v || this.f3387C) {
            int i3 = AbstractC0216h.f520a;
            AbstractC0215g.m424a("RV FullInvalidate");
            m2614o();
            AbstractC0215g.m425b();
            return;
        }
        if (c1798h.m3975j()) {
            c1798h.getClass();
            if (c1798h.m3975j()) {
                int i4 = AbstractC0216h.f520a;
                AbstractC0215g.m424a("RV FullInvalidate");
                m2614o();
                AbstractC0215g.m425b();
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public final void m2613n(int i3, int i4) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        setMeasuredDimension(AbstractC0763I.m1962g(i3, paddingRight, AbstractC0307B.m589e(this)), AbstractC0763I.m1962g(i4, getPaddingBottom() + getPaddingTop(), AbstractC0307B.m588d(this)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03cd  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [Z.X] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX INFO: renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2614o() {
        /*
            Method dump skipped, instruction units count: 1003
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.m2614o():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.f3389E = r0
            r1 = 1
            r5.f3442t = r1
            boolean r2 = r5.f3446v
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = r1
            goto L16
        L15:
            r2 = r0
        L16:
            r5.f3446v = r2
            Z.I r2 = r5.f3434p
            if (r2 == 0) goto L1e
            r2.f2145g = r1
        L1e:
            r5.f3429m0 = r0
            java.lang.ThreadLocal r0 = p073Z.RunnableC0802n.f2351i
            java.lang.Object r1 = r0.get()
            Z.n r1 = (p073Z.RunnableC0802n) r1
            r5.f3413e0 = r1
            if (r1 != 0) goto L68
            Z.n r1 = new Z.n
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2353e = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2356h = r2
            r5.f3413e0 = r1
            java.util.WeakHashMap r1 = p029J.AbstractC0323S.f816a
            android.view.Display r1 = p029J.AbstractC0308C.m605b(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L5a
            if (r1 == 0) goto L5a
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L5a
            goto L5c
        L5a:
            r1 = 1114636288(0x42700000, float:60.0)
        L5c:
            Z.n r2 = r5.f3413e0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f2355g = r3
            r0.set(r2)
        L68:
            Z.n r0 = r5.f3413e0
            java.util.ArrayList r0 = r0.f2353e
            r0.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        C0809u c0809u;
        super.onDetachedFromWindow();
        AbstractC0760F abstractC0760F = this.f3396L;
        if (abstractC0760F != null) {
            abstractC0760F.mo1954f();
        }
        setScrollState(0);
        RunnableC0776W runnableC0776W = this.f3411d0;
        runnableC0776W.f2200k.removeCallbacks(runnableC0776W);
        runnableC0776W.f2196g.abortAnimation();
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null && (c0809u = abstractC0763I.f2143e) != null) {
            c0809u.m2112g();
        }
        this.f3442t = false;
        AbstractC0763I abstractC0763I2 = this.f3434p;
        if (abstractC0763I2 != null) {
            abstractC0763I2.f2145g = false;
            abstractC0763I2.mo1973M(this);
        }
        this.f3443t0.clear();
        removeCallbacks(this.f3445u0);
        this.f3422j.getClass();
        while (C0797i0.f2308d.mo571a() != null) {
        }
        RunnableC0802n runnableC0802n = this.f3413e0;
        if (runnableC0802n != null) {
            runnableC0802n.f2353e.remove(this);
            this.f3413e0 = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f3436q;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC0761G) arrayList.get(i3)).mo1956a(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            Z.I r0 = r5.f3434p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f3450y
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            Z.I r0 = r5.f3434p
            boolean r0 = r0.mo1994e()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            Z.I r3 = r5.f3434p
            boolean r3 = r3.mo1992d()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            Z.I r3 = r5.f3434p
            boolean r3 = r3.mo1994e()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            Z.I r3 = r5.f3434p
            boolean r3 = r3.mo1992d()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6c:
            float r2 = r5.f3408a0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f3409b0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.m2599Y(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        if (this.f3450y) {
            return false;
        }
        this.f3440s = null;
        if (m2578B(motionEvent)) {
            m2598X();
            setScrollState(0);
            return true;
        }
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I == null) {
            return false;
        }
        boolean zMo1992d = abstractC0763I.mo1992d();
        boolean zMo1994e = this.f3434p.mo1994e();
        if (this.f3399O == null) {
            this.f3399O = VelocityTracker.obtain();
        }
        this.f3399O.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f3451z) {
                this.f3451z = false;
            }
            this.f3398N = motionEvent.getPointerId(0);
            int x3 = (int) (motionEvent.getX() + 0.5f);
            this.f3402R = x3;
            this.f3400P = x3;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.f3403S = y2;
            this.f3401Q = y2;
            if (this.f3397M == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                m2605e0(1);
            }
            int[] iArr = this.f3439r0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i3 = zMo1992d;
            if (zMo1994e) {
                i3 = (zMo1992d ? 1 : 0) | 2;
            }
            getScrollingChildHelper().m819h(i3, 0);
        } else if (actionMasked == 1) {
            this.f3399O.clear();
            m2605e0(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f3398N);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f3398N + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x4 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f3397M != 1) {
                int i4 = x4 - this.f3400P;
                int i5 = y3 - this.f3401Q;
                if (!zMo1992d || Math.abs(i4) <= this.f3404T) {
                    z3 = false;
                } else {
                    this.f3402R = x4;
                    z3 = true;
                }
                if (zMo1994e && Math.abs(i5) > this.f3404T) {
                    this.f3403S = y3;
                    z3 = true;
                }
                if (z3) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            m2598X();
            setScrollState(0);
        } else if (actionMasked == 5) {
            this.f3398N = motionEvent.getPointerId(actionIndex);
            int x5 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f3402R = x5;
            this.f3400P = x5;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f3403S = y4;
            this.f3401Q = y4;
        } else if (actionMasked == 6) {
            m2592R(motionEvent);
        }
        return this.f3397M == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int i7 = AbstractC0216h.f520a;
        AbstractC0215g.m424a("RV OnLayout");
        m2614o();
        AbstractC0215g.m425b();
        this.f3446v = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i4) {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I == null) {
            m2613n(i3, i4);
            return;
        }
        boolean zMo1970H = abstractC0763I.mo1970H();
        C0774U c0774u = this.f3417g0;
        if (!zMo1970H) {
            if (this.f3444u) {
                this.f3434p.f2140b.m2613n(i3, i4);
                return;
            }
            if (c0774u.f2190k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            AbstractC0756B abstractC0756B = this.f3432o;
            if (abstractC0756B != null) {
                c0774u.f2184e = abstractC0756B.mo1944a();
            } else {
                c0774u.f2184e = 0;
            }
            m2603c0();
            this.f3434p.f2140b.m2613n(i3, i4);
            m2604d0(false);
            c0774u.f2186g = false;
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        this.f3434p.f2140b.m2613n(i3, i4);
        if ((mode == 1073741824 && mode2 == 1073741824) || this.f3432o == null) {
            return;
        }
        if (c0774u.f2183d == 1) {
            m2615p();
        }
        this.f3434p.m2008l0(i3, i4);
        c0774u.f2188i = true;
        m2616q();
        this.f3434p.m2012n0(i3, i4);
        if (this.f3434p.mo2018q0()) {
            this.f3434p.m2008l0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            c0774u.f2188i = true;
            m2616q();
            this.f3434p.m2012n0(i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (m2586L()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i3, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof C0771Q)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0771Q c0771q = (C0771Q) parcelable;
        this.f3416g = c0771q;
        super.onRestoreInstanceState(c0771q.f1425e);
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I == null || (parcelable2 = this.f3416g.f2172g) == null) {
            return;
        }
        abstractC0763I.mo1985Y(parcelable2);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C0771Q c0771q = new C0771Q(super.onSaveInstanceState());
        C0771Q c0771q2 = this.f3416g;
        if (c0771q2 != null) {
            c0771q.f2172g = c0771q2.f2172g;
        } else {
            AbstractC0763I abstractC0763I = this.f3434p;
            if (abstractC0763I != null) {
                c0771q.f2172g = abstractC0763I.mo1986Z();
            } else {
                c0771q.f2172g = null;
            }
        }
        return c0771q;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        if (i3 == i5 && i4 == i6) {
            return;
        }
        this.f3395K = null;
        this.f3393I = null;
        this.f3394J = null;
        this.f3392H = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01fa A[PHI: r0
      0x01fa: PHI (r0v51 int) = (r0v38 int), (r0v55 int) binds: [B:90:0x01e3, B:94:0x01f6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fd  */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v7 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r26) {
        /*
            Method dump skipped, instruction units count: 1238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX INFO: renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2615p() {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.m2615p():void");
    }

    /* JADX INFO: renamed from: q */
    public final void m2616q() {
        m2603c0();
        m2590P();
        C0774U c0774u = this.f3417g0;
        c0774u.m2046a(6);
        this.f3418h.m3971d();
        c0774u.f2184e = this.f3432o.mo1944a();
        c0774u.f2182c = 0;
        c0774u.f2186g = false;
        this.f3434p.mo1983W(this.f3414f, c0774u);
        c0774u.f2185f = false;
        this.f3416g = null;
        c0774u.f2189j = c0774u.f2189j && this.f3396L != null;
        c0774u.f2183d = 4;
        m2591Q(true);
        m2604d0(false);
    }

    /* JADX INFO: renamed from: r */
    public final boolean m2617r(int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        return getScrollingChildHelper().m814c(i3, i4, iArr, iArr2, i5);
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z3) {
        AbstractC0777X abstractC0777XM2571I = m2571I(view);
        if (abstractC0777XM2571I != null) {
            if (abstractC0777XM2571I.m2060k()) {
                abstractC0777XM2571I.f2211j &= -257;
            } else if (!abstractC0777XM2571I.m2065p()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + abstractC0777XM2571I + m2624y());
            }
        }
        view.clearAnimation();
        m2571I(view);
        super.removeDetachedView(view, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        C0809u c0809u = this.f3434p.f2143e;
        if ((c0809u == null || !c0809u.f2396e) && !m2586L() && view2 != null) {
            m2597W(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        return this.f3434p.m1997f0(this, view, rect, z3, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z3) {
        ArrayList arrayList = this.f3438r;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((C0800l) arrayList.get(i3)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f3448w != 0 || this.f3450y) {
            this.f3449x = true;
        } else {
            super.requestLayout();
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m2618s(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        getScrollingChildHelper().m816e(i3, i4, i5, i6, iArr, i7, iArr2);
    }

    @Override // android.view.View
    public final void scrollBy(int i3, int i4) {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f3450y) {
            return;
        }
        boolean zMo1992d = abstractC0763I.mo1992d();
        boolean zMo1994e = this.f3434p.mo1994e();
        if (zMo1992d || zMo1994e) {
            if (!zMo1992d) {
                i3 = 0;
            }
            if (!zMo1994e) {
                i4 = 0;
            }
            m2599Y(i3, i4, null);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i3, int i4) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!m2586L()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int iM849a = accessibilityEvent != null ? AbstractC0384b.m849a(accessibilityEvent) : 0;
            this.f3385A |= iM849a != 0 ? iM849a : 0;
        }
    }

    public void setAccessibilityDelegateCompat(C0779Z c0779z) {
        this.f3431n0 = c0779z;
        AbstractC0323S.m701k(this, c0779z);
    }

    public void setAdapter(AbstractC0756B abstractC0756B) {
        setLayoutFrozen(false);
        AbstractC0756B abstractC0756B2 = this.f3432o;
        C0222f c0222f = this.f3412e;
        if (abstractC0756B2 != null) {
            abstractC0756B2.f2127a.unregisterObserver(c0222f);
            this.f3432o.getClass();
        }
        AbstractC0760F abstractC0760F = this.f3396L;
        if (abstractC0760F != null) {
            abstractC0760F.mo1954f();
        }
        AbstractC0763I abstractC0763I = this.f3434p;
        C0769O c0769o = this.f3414f;
        if (abstractC0763I != null) {
            abstractC0763I.m1989b0(c0769o);
            this.f3434p.m1991c0(c0769o);
        }
        c0769o.f2164a.clear();
        c0769o.m2036d();
        C1798h c1798h = this.f3418h;
        c1798h.m3980o((ArrayList) c1798h.f6209b);
        c1798h.m3980o((ArrayList) c1798h.f6210c);
        AbstractC0756B abstractC0756B3 = this.f3432o;
        this.f3432o = abstractC0756B;
        if (abstractC0756B != null) {
            abstractC0756B.f2127a.registerObserver(c0222f);
        }
        AbstractC0756B abstractC0756B4 = this.f3432o;
        c0769o.f2164a.clear();
        c0769o.m2036d();
        C0768N c0768nM2035c = c0769o.m2035c();
        if (abstractC0756B3 != null) {
            c0768nM2035c.f2163b--;
        }
        if (c0768nM2035c.f2163b == 0) {
            int i3 = 0;
            while (true) {
                SparseArray sparseArray = c0768nM2035c.f2162a;
                if (i3 >= sparseArray.size()) {
                    break;
                }
                ((C0767M) sparseArray.valueAt(i3)).f2158a.clear();
                i3++;
            }
        }
        if (abstractC0756B4 != null) {
            c0768nM2035c.f2163b++;
        }
        this.f3417g0.f2185f = true;
        m2595U(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(InterfaceC0758D interfaceC0758D) {
        if (interfaceC0758D == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z3) {
        if (z3 != this.f3424k) {
            this.f3395K = null;
            this.f3393I = null;
            this.f3394J = null;
            this.f3392H = null;
        }
        this.f3424k = z3;
        super.setClipToPadding(z3);
        if (this.f3446v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(C0759E c0759e) {
        c0759e.getClass();
        this.f3391G = c0759e;
        this.f3395K = null;
        this.f3393I = null;
        this.f3394J = null;
        this.f3392H = null;
    }

    public void setHasFixedSize(boolean z3) {
        this.f3444u = z3;
    }

    public void setItemAnimator(AbstractC0760F abstractC0760F) {
        AbstractC0760F abstractC0760F2 = this.f3396L;
        if (abstractC0760F2 != null) {
            abstractC0760F2.mo1954f();
            this.f3396L.f2129a = null;
        }
        this.f3396L = abstractC0760F;
        if (abstractC0760F != null) {
            abstractC0760F.f2129a = this.f3427l0;
        }
    }

    public void setItemViewCacheSize(int i3) {
        C0769O c0769o = this.f3414f;
        c0769o.f2168e = i3;
        c0769o.m2043k();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z3) {
        suppressLayout(z3);
    }

    public void setLayoutManager(AbstractC0763I abstractC0763I) {
        C0755A c0755a;
        C0809u c0809u;
        if (abstractC0763I == this.f3434p) {
            return;
        }
        setScrollState(0);
        RunnableC0776W runnableC0776W = this.f3411d0;
        runnableC0776W.f2200k.removeCallbacks(runnableC0776W);
        runnableC0776W.f2196g.abortAnimation();
        AbstractC0763I abstractC0763I2 = this.f3434p;
        if (abstractC0763I2 != null && (c0809u = abstractC0763I2.f2143e) != null) {
            c0809u.m2112g();
        }
        AbstractC0763I abstractC0763I3 = this.f3434p;
        C0769O c0769o = this.f3414f;
        if (abstractC0763I3 != null) {
            AbstractC0760F abstractC0760F = this.f3396L;
            if (abstractC0760F != null) {
                abstractC0760F.mo1954f();
            }
            this.f3434p.m1989b0(c0769o);
            this.f3434p.m1991c0(c0769o);
            c0769o.f2164a.clear();
            c0769o.m2036d();
            if (this.f3442t) {
                AbstractC0763I abstractC0763I4 = this.f3434p;
                abstractC0763I4.f2145g = false;
                abstractC0763I4.mo1973M(this);
            }
            this.f3434p.m2014o0(null);
            this.f3434p = null;
        } else {
            c0769o.f2164a.clear();
            c0769o.m2036d();
        }
        C1100C c1100c = this.f3420i;
        ((C0782b) c1100c.f3800g).m2073g();
        ArrayList arrayList = (ArrayList) c1100c.f3801h;
        int size = arrayList.size() - 1;
        while (true) {
            c0755a = (C0755A) c1100c.f3799f;
            if (size < 0) {
                break;
            }
            View view = (View) arrayList.get(size);
            c0755a.getClass();
            AbstractC0777X abstractC0777XM2571I = m2571I(view);
            if (abstractC0777XM2571I != null) {
                int i3 = abstractC0777XM2571I.f2217p;
                RecyclerView recyclerView = c0755a.f2126a;
                if (recyclerView.m2586L()) {
                    abstractC0777XM2571I.f2218q = i3;
                    recyclerView.f3443t0.add(abstractC0777XM2571I);
                } else {
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    AbstractC0307B.m603s(abstractC0777XM2571I.f2202a, i3);
                }
                abstractC0777XM2571I.f2217p = 0;
            }
            arrayList.remove(size);
            size--;
        }
        RecyclerView recyclerView2 = c0755a.f2126a;
        int childCount = recyclerView2.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView2.getChildAt(i4);
            m2571I(childAt);
            childAt.clearAnimation();
        }
        recyclerView2.removeAllViews();
        this.f3434p = abstractC0763I;
        if (abstractC0763I != null) {
            if (abstractC0763I.f2140b != null) {
                throw new IllegalArgumentException("LayoutManager " + abstractC0763I + " is already attached to a RecyclerView:" + abstractC0763I.f2140b.m2624y());
            }
            abstractC0763I.m2014o0(this);
            if (this.f3442t) {
                this.f3434p.f2145g = true;
            }
        }
        c0769o.m2043k();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z3) {
        C0359o scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f869d) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0313H.m653z(scrollingChildHelper.f868c);
        }
        scrollingChildHelper.f869d = z3;
    }

    public void setOnFlingListener(AbstractC0765K abstractC0765K) {
        this.f3405U = abstractC0765K;
    }

    @Deprecated
    public void setOnScrollListener(AbstractC0766L abstractC0766L) {
        this.f3419h0 = abstractC0766L;
    }

    public void setPreserveFocusAfterLayout(boolean z3) {
        this.f3410c0 = z3;
    }

    public void setRecycledViewPool(C0768N c0768n) {
        C0769O c0769o = this.f3414f;
        if (c0769o.f2170g != null) {
            r1.f2163b--;
        }
        c0769o.f2170g = c0768n;
        if (c0768n == null || c0769o.f2171h.getAdapter() == null) {
            return;
        }
        c0769o.f2170g.f2163b++;
    }

    public void setRecyclerListener(InterfaceC0770P interfaceC0770P) {
    }

    public void setScrollState(int i3) {
        C0809u c0809u;
        if (i3 == this.f3397M) {
            return;
        }
        this.f3397M = i3;
        if (i3 != 2) {
            RunnableC0776W runnableC0776W = this.f3411d0;
            runnableC0776W.f2200k.removeCallbacks(runnableC0776W);
            runnableC0776W.f2196g.abortAnimation();
            AbstractC0763I abstractC0763I = this.f3434p;
            if (abstractC0763I != null && (c0809u = abstractC0763I.f2143e) != null) {
                c0809u.m2112g();
            }
        }
        AbstractC0763I abstractC0763I2 = this.f3434p;
        if (abstractC0763I2 != null) {
            abstractC0763I2.mo1987a0(i3);
        }
        AbstractC0766L abstractC0766L = this.f3419h0;
        if (abstractC0766L != null) {
            abstractC0766L.mo2030a(this, i3);
        }
        ArrayList arrayList = this.f3421i0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((AbstractC0766L) this.f3421i0.get(size)).mo2030a(this, i3);
            }
        }
    }

    public void setScrollingTouchSlop(int i3) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 != 0) {
            if (i3 == 1) {
                this.f3404T = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i3 + "; using default value");
        }
        this.f3404T = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(AbstractC0775V abstractC0775V) {
        this.f3414f.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i3) {
        return getScrollingChildHelper().m819h(i3, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().m820i(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z3) {
        C0809u c0809u;
        if (z3 != this.f3450y) {
            m2609i("Do not suppressLayout in layout or scroll");
            if (!z3) {
                this.f3450y = false;
                if (this.f3449x && this.f3434p != null && this.f3432o != null) {
                    requestLayout();
                }
                this.f3449x = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f3450y = true;
            this.f3451z = true;
            setScrollState(0);
            RunnableC0776W runnableC0776W = this.f3411d0;
            runnableC0776W.f2200k.removeCallbacks(runnableC0776W);
            runnableC0776W.f2196g.abortAnimation();
            AbstractC0763I abstractC0763I = this.f3434p;
            if (abstractC0763I == null || (c0809u = abstractC0763I.f2143e) == null) {
                return;
            }
            c0809u.m2112g();
        }
    }

    /* JADX INFO: renamed from: t */
    public final void m2619t(int i3, int i4) {
        this.f3390F++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i3, scrollY - i4);
        AbstractC0766L abstractC0766L = this.f3419h0;
        if (abstractC0766L != null) {
            abstractC0766L.mo2031b(this, i3, i4);
        }
        ArrayList arrayList = this.f3421i0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((AbstractC0766L) this.f3421i0.get(size)).mo2031b(this, i3, i4);
            }
        }
        this.f3390F--;
    }

    /* JADX INFO: renamed from: u */
    public final void m2620u() {
        if (this.f3395K != null) {
            return;
        }
        this.f3391G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f3395K = edgeEffect;
        if (this.f3424k) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX INFO: renamed from: v */
    public final void m2621v() {
        if (this.f3392H != null) {
            return;
        }
        this.f3391G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f3392H = edgeEffect;
        if (this.f3424k) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* JADX INFO: renamed from: w */
    public final void m2622w() {
        if (this.f3394J != null) {
            return;
        }
        this.f3391G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f3394J = edgeEffect;
        if (this.f3424k) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* JADX INFO: renamed from: x */
    public final void m2623x() {
        if (this.f3393I != null) {
            return;
        }
        this.f3391G.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f3393I = edgeEffect;
        if (this.f3424k) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX INFO: renamed from: y */
    public final String m2624y() {
        return " " + super.toString() + ", adapter:" + this.f3432o + ", layout:" + this.f3434p + ", context:" + getContext();
    }

    /* JADX INFO: renamed from: z */
    public final void m2625z(C0774U c0774u) {
        if (getScrollState() != 2) {
            c0774u.getClass();
            return;
        }
        OverScroller overScroller = this.f3411d0.f2196g;
        overScroller.getFinalX();
        overScroller.getCurrX();
        c0774u.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x03c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RecyclerView(android.content.Context r22, android.util.AttributeSet r23, int r24) throws java.lang.NoSuchMethodException {
        /*
            Method dump skipped, instruction units count: 998
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AbstractC0763I abstractC0763I = this.f3434p;
        if (abstractC0763I != null) {
            return abstractC0763I.mo2023t(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + m2624y());
    }
}
