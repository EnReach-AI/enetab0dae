package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import p006B0.C0038a;
import p009C.AbstractC0140c;
import p026I.C0297e;
import p029J.AbstractC0307B;
import p029J.AbstractC0308C;
import p029J.AbstractC0311F;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p029J.AbstractC0349j;
import p029J.C0364q0;
import p029J.C0365r;
import p029J.InterfaceC0361p;
import p029J.InterfaceC0363q;
import p036L0.C0444d;
import p125o0.C1803m;
import p128p.C1817k;
import p151v.AbstractC1971a;
import p155w.AbstractC1979a;
import p155w.AbstractC1985g;
import p155w.C1982d;
import p155w.C1984f;
import p155w.InterfaceC1980b;
import p155w.ViewGroupOnHierarchyChangeListenerC1981c;
import p155w.ViewTreeObserverOnPreDrawListenerC1983e;
import p165z.AbstractC2047c;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements InterfaceC0361p, InterfaceC0363q {

    /* JADX INFO: renamed from: A */
    public static final C0038a f2887A;

    /* JADX INFO: renamed from: B */
    public static final C0297e f2888B;

    /* JADX INFO: renamed from: x */
    public static final String f2889x;

    /* JADX INFO: renamed from: y */
    public static final Class[] f2890y;

    /* JADX INFO: renamed from: z */
    public static final ThreadLocal f2891z;

    /* JADX INFO: renamed from: e */
    public final ArrayList f2892e;

    /* JADX INFO: renamed from: f */
    public final C1803m f2893f;

    /* JADX INFO: renamed from: g */
    public final ArrayList f2894g;

    /* JADX INFO: renamed from: h */
    public final ArrayList f2895h;

    /* JADX INFO: renamed from: i */
    public final int[] f2896i;

    /* JADX INFO: renamed from: j */
    public final int[] f2897j;

    /* JADX INFO: renamed from: k */
    public boolean f2898k;

    /* JADX INFO: renamed from: l */
    public boolean f2899l;

    /* JADX INFO: renamed from: m */
    public final int[] f2900m;

    /* JADX INFO: renamed from: n */
    public View f2901n;

    /* JADX INFO: renamed from: o */
    public View f2902o;

    /* JADX INFO: renamed from: p */
    public ViewTreeObserverOnPreDrawListenerC1983e f2903p;

    /* JADX INFO: renamed from: q */
    public boolean f2904q;

    /* JADX INFO: renamed from: r */
    public C0364q0 f2905r;

    /* JADX INFO: renamed from: s */
    public boolean f2906s;

    /* JADX INFO: renamed from: t */
    public Drawable f2907t;

    /* JADX INFO: renamed from: u */
    public ViewGroup.OnHierarchyChangeListener f2908u;

    /* JADX INFO: renamed from: v */
    public C0444d f2909v;

    /* JADX INFO: renamed from: w */
    public final C0365r f2910w;

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f2889x = r02 != null ? r02.getName() : null;
        f2887A = new C0038a(6);
        f2890y = new Class[]{Context.class, AttributeSet.class};
        f2891z = new ThreadLocal();
        f2888B = new C0297e();
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.f2892e = new ArrayList();
        this.f2893f = new C1803m(7);
        this.f2894g = new ArrayList();
        this.f2895h = new ArrayList();
        this.f2896i = new int[2];
        this.f2897j = new int[2];
        this.f2910w = new C0365r();
        int[] iArr = AbstractC1971a.f6987a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f2900m = intArray;
            float f3 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.f2900m[i3] = (int) (r2[i3] * f3);
            }
        }
        this.f2907t = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        m2313w();
        super.setOnHierarchyChangeListener(new ViewGroupOnHierarchyChangeListenerC1981c(this));
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (AbstractC0307B.m587c(this) == 0) {
            AbstractC0307B.m603s(this, 1);
        }
    }

    /* JADX INFO: renamed from: g */
    public static Rect m2297g() {
        Rect rect = (Rect) f2888B.mo571a();
        return rect == null ? new Rect() : rect;
    }

    /* JADX INFO: renamed from: l */
    public static void m2298l(int i3, Rect rect, Rect rect2, C1982d c1982d, int i4, int i5) {
        int i6 = c1982d.f7028c;
        if (i6 == 0) {
            i6 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i6, i3);
        int i7 = c1982d.f7029d;
        if ((i7 & 7) == 0) {
            i7 |= 8388611;
        }
        if ((i7 & 112) == 0) {
            i7 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i7, i3);
        int i8 = absoluteGravity & 7;
        int i9 = absoluteGravity & 112;
        int i10 = absoluteGravity2 & 7;
        int i11 = absoluteGravity2 & 112;
        int iWidth = i10 != 1 ? i10 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i11 != 16 ? i11 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i8 == 1) {
            iWidth -= i4 / 2;
        } else if (i8 != 5) {
            iWidth -= i4;
        }
        if (i9 == 16) {
            iHeight -= i5 / 2;
        } else if (i9 != 80) {
            iHeight -= i5;
        }
        rect2.set(iWidth, iHeight, i4 + iWidth, i5 + iHeight);
    }

    /* JADX INFO: renamed from: n */
    public static C1982d m2299n(View view) {
        C1982d c1982d = (C1982d) view.getLayoutParams();
        if (!c1982d.f7027b) {
            InterfaceC1980b interfaceC1980b = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                interfaceC1980b = (InterfaceC1980b) superclass.getAnnotation(InterfaceC1980b.class);
                if (interfaceC1980b != null) {
                    break;
                }
            }
            if (interfaceC1980b != null) {
                try {
                    AbstractC1979a abstractC1979a = (AbstractC1979a) interfaceC1980b.value().getDeclaredConstructor(null).newInstance(null);
                    AbstractC1979a abstractC1979a2 = c1982d.f7026a;
                    if (abstractC1979a2 != abstractC1979a) {
                        if (abstractC1979a2 != null) {
                            abstractC1979a2.mo3149e();
                        }
                        c1982d.f7026a = abstractC1979a;
                        c1982d.f7027b = true;
                        if (abstractC1979a != null) {
                            abstractC1979a.mo3148c(c1982d);
                        }
                    }
                } catch (Exception e3) {
                    Log.e("CoordinatorLayout", "Default behavior class " + interfaceC1980b.value().getName() + " could not be instantiated. Did you forget a default constructor?", e3);
                }
            }
            c1982d.f7027b = true;
        }
        return c1982d;
    }

    /* JADX INFO: renamed from: u */
    public static void m2300u(View view, int i3) {
        C1982d c1982d = (C1982d) view.getLayoutParams();
        int i4 = c1982d.f7034i;
        if (i4 != i3) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            view.offsetLeftAndRight(i3 - i4);
            c1982d.f7034i = i3;
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m2301v(View view, int i3) {
        C1982d c1982d = (C1982d) view.getLayoutParams();
        int i4 = c1982d.f7035j;
        if (i4 != i3) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            view.offsetTopAndBottom(i3 - i4);
            c1982d.f7035j = i3;
        }
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: a */
    public final void mo821a(View view, View view2, int i3, int i4) {
        C0365r c0365r = this.f2910w;
        if (i4 == 1) {
            c0365r.f876b = i3;
        } else {
            c0365r.f875a = i3;
        }
        this.f2902o = view2;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            ((C1982d) getChildAt(i5).getLayoutParams()).getClass();
        }
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: b */
    public final void mo822b(View view, int i3) {
        C0365r c0365r = this.f2910w;
        if (i3 == 1) {
            c0365r.f876b = 0;
        } else {
            c0365r.f875a = 0;
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            C1982d c1982d = (C1982d) childAt.getLayoutParams();
            if (c1982d.m4371a(i3)) {
                AbstractC1979a abstractC1979a = c1982d.f7026a;
                if (abstractC1979a != null) {
                    abstractC1979a.mo3130p(childAt, view, i3);
                }
                if (i3 == 0) {
                    c1982d.f7039n = false;
                } else if (i3 == 1) {
                    c1982d.f7040o = false;
                }
                c1982d.getClass();
            }
        }
        this.f2902o = null;
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: c */
    public final void mo823c(View view, int i3, int i4, int[] iArr, int i5) {
        AbstractC1979a abstractC1979a;
        int childCount = getChildCount();
        boolean z3 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C1982d c1982d = (C1982d) childAt.getLayoutParams();
                if (c1982d.m4371a(i5) && (abstractC1979a = c1982d.f7026a) != null) {
                    int[] iArr2 = this.f2896i;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    abstractC1979a.mo3125j(this, childAt, view, i3, i4, iArr2, i5);
                    iMax = i3 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i4 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z3 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z3) {
            m2308p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C1982d) && super.checkLayoutParams(layoutParams);
    }

    @Override // p029J.InterfaceC0363q
    /* JADX INFO: renamed from: d */
    public final void mo827d(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        AbstractC1979a abstractC1979a;
        int childCount = getChildCount();
        boolean z3 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                C1982d c1982d = (C1982d) childAt.getLayoutParams();
                if (c1982d.m4371a(i7) && (abstractC1979a = c1982d.f7026a) != null) {
                    int[] iArr2 = this.f2896i;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    abstractC1979a.mo3126k(this, childAt, i4, i5, i6, iArr2);
                    iMax = i5 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i6 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z3 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z3) {
            m2308p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        AbstractC1979a abstractC1979a = ((C1982d) view.getLayoutParams()).f7026a;
        if (abstractC1979a != null) {
            abstractC1979a.getClass();
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2907t;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: e */
    public final void mo824e(View view, int i3, int i4, int i5, int i6, int i7) {
        mo827d(view, i3, i4, i5, i6, 0, this.f2897j);
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: f */
    public final boolean mo825f(View view, View view2, int i3, int i4) {
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C1982d c1982d = (C1982d) childAt.getLayoutParams();
                AbstractC1979a abstractC1979a = c1982d.f7026a;
                if (abstractC1979a != null) {
                    boolean zMo3129o = abstractC1979a.mo3129o(childAt, i3, i4);
                    z3 |= zMo3129o;
                    if (i4 == 0) {
                        c1982d.f7039n = zMo3129o;
                    } else if (i4 == 1) {
                        c1982d.f7040o = zMo3129o;
                    }
                } else if (i4 == 0) {
                    c1982d.f7039n = false;
                } else if (i4 == 1) {
                    c1982d.f7040o = false;
                }
            }
        }
        return z3;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C1982d();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C1982d(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        m2311s();
        return Collections.unmodifiableList(this.f2892e);
    }

    public final C0364q0 getLastWindowInsets() {
        return this.f2905r;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0365r c0365r = this.f2910w;
        return c0365r.f876b | c0365r.f875a;
    }

    public Drawable getStatusBarBackground() {
        return this.f2907t;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    /* JADX INFO: renamed from: h */
    public final void m2302h(C1982d c1982d, Rect rect, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c1982d).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i3) - ((ViewGroup.MarginLayoutParams) c1982d).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c1982d).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i4) - ((ViewGroup.MarginLayoutParams) c1982d).bottomMargin));
        rect.set(iMax, iMax2, i3 + iMax, i4 + iMax2);
    }

    /* JADX INFO: renamed from: i */
    public final void m2303i(View view, Rect rect, boolean z3) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z3) {
            m2305k(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* JADX INFO: renamed from: j */
    public final ArrayList m2304j(View view) {
        C1817k c1817k = (C1817k) this.f2893f.f6221g;
        int i3 = c1817k.f6297g;
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < i3; i4++) {
            ArrayList arrayList2 = (ArrayList) c1817k.m4041j(i4);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c1817k.m4039h(i4));
            }
        }
        ArrayList arrayList3 = this.f2895h;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    /* JADX INFO: renamed from: k */
    public final void m2305k(View view, Rect rect) {
        ThreadLocal threadLocal = AbstractC1985g.f7044a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = AbstractC1985g.f7044a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        AbstractC1985g.m4372a(this, view, matrix);
        ThreadLocal threadLocal3 = AbstractC1985g.f7045b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* JADX INFO: renamed from: m */
    public final int m2306m(int i3) {
        int[] iArr = this.f2900m;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i3);
            return 0;
        }
        if (i3 >= 0 && i3 < iArr.length) {
            return iArr[i3];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i3 + " out of range for " + this);
        return 0;
    }

    /* JADX INFO: renamed from: o */
    public final boolean m2307o(View view, int i3, int i4) {
        C0297e c0297e = f2888B;
        Rect rectM2297g = m2297g();
        m2305k(view, rectM2297g);
        try {
            return rectM2297g.contains(i3, i4);
        } finally {
            rectM2297g.setEmpty();
            c0297e.mo573c(rectM2297g);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        m2312t(false);
        if (this.f2904q) {
            if (this.f2903p == null) {
                this.f2903p = new ViewTreeObserverOnPreDrawListenerC1983e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2903p);
        }
        if (this.f2905r == null) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            if (AbstractC0307B.m586b(this)) {
                AbstractC0311F.m627c(this);
            }
        }
        this.f2899l = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2312t(false);
        if (this.f2904q && this.f2903p != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2903p);
        }
        View view = this.f2902o;
        if (view != null) {
            mo822b(view, 0);
        }
        this.f2899l = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f2906s || this.f2907t == null) {
            return;
        }
        C0364q0 c0364q0 = this.f2905r;
        int iM833d = c0364q0 != null ? c0364q0.m833d() : 0;
        if (iM833d > 0) {
            this.f2907t.setBounds(0, 0, getWidth(), iM833d);
            this.f2907t.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m2312t(true);
        }
        boolean zM2310r = m2310r(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            m2312t(true);
        }
        return zM2310r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        AbstractC1979a abstractC1979a;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        int iM607d = AbstractC0308C.m607d(this);
        ArrayList arrayList = this.f2892e;
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) arrayList.get(i7);
            if (view.getVisibility() != 8 && ((abstractC1979a = ((C1982d) view.getLayoutParams()).f7026a) == null || !abstractC1979a.mo3123g(this, view, iM607d))) {
                m2309q(view, iM607d);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0189  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r33, int r34) {
        /*
            Method dump skipped, instruction units count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f3, float f4, boolean z3) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C1982d c1982d = (C1982d) childAt.getLayoutParams();
                if (c1982d.m4371a(0)) {
                    AbstractC1979a abstractC1979a = c1982d.f7026a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f3, float f4) {
        AbstractC1979a abstractC1979a;
        int childCount = getChildCount();
        boolean zMo3150i = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C1982d c1982d = (C1982d) childAt.getLayoutParams();
                if (c1982d.m4371a(0) && (abstractC1979a = c1982d.f7026a) != null) {
                    zMo3150i |= abstractC1979a.mo3150i(view);
                }
            }
        }
        return zMo3150i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        mo823c(view, i3, i4, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        mo824e(view, i3, i4, i5, i6, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i3) {
        mo821a(view, view2, i3, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof C1984f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C1984f c1984f = (C1984f) parcelable;
        super.onRestoreInstanceState(c1984f.f1425e);
        SparseArray sparseArray = c1984f.f7043g;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            AbstractC1979a abstractC1979a = m2299n(childAt).f7026a;
            if (id != -1 && abstractC1979a != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                abstractC1979a.mo3127m(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableMo3128n;
        C1984f c1984f = new C1984f(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            AbstractC1979a abstractC1979a = ((C1982d) childAt.getLayoutParams()).f7026a;
            if (id != -1 && abstractC1979a != null && (parcelableMo3128n = abstractC1979a.mo3128n(childAt)) != null) {
                sparseArray.append(id, parcelableMo3128n);
            }
        }
        c1984f.f7043g = sparseArray;
        return c1984f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i3) {
        return mo825f(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        mo822b(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f2901n
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.m2310r(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f2901n
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            w.d r6 = (p155w.C1982d) r6
            w.a r6 = r6.f7026a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f2901n
            boolean r6 = r6.mo3131q(r7, r1)
        L2a:
            android.view.View r7 = r0.f2901n
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L52
            r1 = 3
            if (r2 != r1) goto L55
        L52:
            r0.m2312t(r5)
        L55:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x004b A[EDGE_INSN: B:134:0x004b->B:10:0x004b BREAK  A[LOOP:2: B:122:0x02db->B:127:0x02f2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ec  */
    /* JADX INFO: renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2308p(int r26) {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.m2308p(int):void");
    }

    /* JADX INFO: renamed from: q */
    public final void m2309q(View view, int i3) {
        Rect rectM2297g;
        Rect rectM2297g2;
        C1982d c1982d = (C1982d) view.getLayoutParams();
        View view2 = c1982d.f7036k;
        if (view2 == null && c1982d.f7031f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        C0297e c0297e = f2888B;
        if (view2 != null) {
            rectM2297g = m2297g();
            rectM2297g2 = m2297g();
            try {
                m2305k(view2, rectM2297g);
                C1982d c1982d2 = (C1982d) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                m2298l(i3, rectM2297g, rectM2297g2, c1982d2, measuredWidth, measuredHeight);
                m2302h(c1982d2, rectM2297g2, measuredWidth, measuredHeight);
                view.layout(rectM2297g2.left, rectM2297g2.top, rectM2297g2.right, rectM2297g2.bottom);
                return;
            } finally {
                rectM2297g.setEmpty();
                c0297e.mo573c(rectM2297g);
                rectM2297g2.setEmpty();
                c0297e.mo573c(rectM2297g2);
            }
        }
        int i4 = c1982d.f7030e;
        if (i4 < 0) {
            C1982d c1982d3 = (C1982d) view.getLayoutParams();
            rectM2297g = m2297g();
            rectM2297g.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c1982d3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) c1982d3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c1982d3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) c1982d3).bottomMargin);
            if (this.f2905r != null) {
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                if (AbstractC0307B.m586b(this) && !AbstractC0307B.m586b(view)) {
                    rectM2297g.left = this.f2905r.m831b() + rectM2297g.left;
                    rectM2297g.top = this.f2905r.m833d() + rectM2297g.top;
                    rectM2297g.right -= this.f2905r.m832c();
                    rectM2297g.bottom -= this.f2905r.m830a();
                }
            }
            rectM2297g2 = m2297g();
            int i5 = c1982d3.f7028c;
            if ((i5 & 7) == 0) {
                i5 |= 8388611;
            }
            if ((i5 & 112) == 0) {
                i5 |= 48;
            }
            AbstractC0349j.m760b(i5, view.getMeasuredWidth(), view.getMeasuredHeight(), rectM2297g, rectM2297g2, i3);
            view.layout(rectM2297g2.left, rectM2297g2.top, rectM2297g2.right, rectM2297g2.bottom);
            return;
        }
        C1982d c1982d4 = (C1982d) view.getLayoutParams();
        int i6 = c1982d4.f7028c;
        if (i6 == 0) {
            i6 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i6, i3);
        int i7 = absoluteGravity & 7;
        int i8 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i3 == 1) {
            i4 = width - i4;
        }
        int iM2306m = m2306m(i4) - measuredWidth2;
        if (i7 == 1) {
            iM2306m += measuredWidth2 / 2;
        } else if (i7 == 5) {
            iM2306m += measuredWidth2;
        }
        int i9 = i8 != 16 ? i8 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c1982d4).leftMargin, Math.min(iM2306m, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) c1982d4).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c1982d4).topMargin, Math.min(i9, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) c1982d4).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    /* JADX INFO: renamed from: r */
    public final boolean m2310r(MotionEvent motionEvent, int i3) {
        boolean z3;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f2894g;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i4) : i4));
        }
        C0038a c0038a = f2887A;
        if (c0038a != null) {
            Collections.sort(arrayList, c0038a);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zMo3122f = false;
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) arrayList.get(i5);
            C1982d c1982d = (C1982d) view.getLayoutParams();
            AbstractC1979a abstractC1979a = c1982d.f7026a;
            if (!(zMo3122f || z4) || actionMasked == 0) {
                if (!zMo3122f && abstractC1979a != null) {
                    if (i3 == 0) {
                        zMo3122f = abstractC1979a.mo3122f(this, view, motionEvent);
                    } else if (i3 == 1) {
                        zMo3122f = abstractC1979a.mo3131q(view, motionEvent);
                    }
                    if (zMo3122f) {
                        this.f2901n = view;
                    }
                }
                if (c1982d.f7026a == null) {
                    c1982d.f7038m = false;
                }
                boolean z5 = c1982d.f7038m;
                if (z5) {
                    z3 = true;
                } else {
                    c1982d.f7038m = z5;
                    z3 = z5;
                }
                z4 = z3 && !z5;
                if (z3 && !z4) {
                    break;
                }
            } else if (abstractC1979a != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i3 == 0) {
                    abstractC1979a.mo3122f(this, view, motionEventObtain);
                } else if (i3 == 1) {
                    abstractC1979a.mo3131q(view, motionEventObtain);
                }
            }
        }
        arrayList.clear();
        return zMo3122f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        AbstractC1979a abstractC1979a = ((C1982d) view.getLayoutParams()).f7026a;
        if (abstractC1979a != null) {
            abstractC1979a.mo3135l(this, view);
        }
        return super.requestChildRectangleOnScreen(view, rect, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z3) {
        super.requestDisallowInterceptTouchEvent(z3);
        if (!z3 || this.f2898k) {
            return;
        }
        m2312t(false);
        this.f2898k = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0104  */
    /* JADX INFO: renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2311s() {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.m2311s():void");
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z3) {
        super.setFitsSystemWindows(z3);
        m2313w();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2908u = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f2907t;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f2907t = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f2907t.setState(getDrawableState());
                }
                Drawable drawable3 = this.f2907t;
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                AbstractC0140c.m283b(drawable3, AbstractC0308C.m607d(this));
                this.f2907t.setVisible(getVisibility() == 0, false);
                this.f2907t.setCallback(this);
            }
            WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
            AbstractC0307B.m595k(this);
        }
    }

    public void setStatusBarBackgroundColor(int i3) {
        setStatusBarBackground(new ColorDrawable(i3));
    }

    public void setStatusBarBackgroundResource(int i3) {
        setStatusBarBackground(i3 != 0 ? AbstractC2047c.m4518b(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z3 = i3 == 0;
        Drawable drawable = this.f2907t;
        if (drawable == null || drawable.isVisible() == z3) {
            return;
        }
        this.f2907t.setVisible(z3, false);
    }

    /* JADX INFO: renamed from: t */
    public final void m2312t(boolean z3) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            AbstractC1979a abstractC1979a = ((C1982d) childAt.getLayoutParams()).f7026a;
            if (abstractC1979a != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z3) {
                    abstractC1979a.mo3122f(this, childAt, motionEventObtain);
                } else {
                    abstractC1979a.mo3131q(childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            ((C1982d) getChildAt(i4).getLayoutParams()).f7038m = false;
        }
        this.f2901n = null;
        this.f2898k = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2907t;
    }

    /* JADX INFO: renamed from: w */
    public final void m2313w() {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (!AbstractC0307B.m586b(this)) {
            AbstractC0313H.m648u(this, null);
            return;
        }
        if (this.f2909v == null) {
            this.f2909v = new C0444d(this);
        }
        AbstractC0313H.m648u(this, this.f2909v);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C1982d ? new C1982d((C1982d) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C1982d((ViewGroup.MarginLayoutParams) layoutParams) : new C1982d(layoutParams);
    }
}
