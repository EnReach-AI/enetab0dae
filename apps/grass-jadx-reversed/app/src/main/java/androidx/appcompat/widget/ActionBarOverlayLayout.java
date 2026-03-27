package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p005B.C0029d;
import p029J.AbstractC0307B;
import p029J.AbstractC0311F;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p029J.AbstractC0346h0;
import p029J.C0340e0;
import p029J.C0342f0;
import p029J.C0344g0;
import p029J.C0360o0;
import p029J.C0364q0;
import p029J.C0365r;
import p029J.InterfaceC0361p;
import p029J.InterfaceC0363q;
import p034K1.C0424k;
import p098g.C1361G;
import p105i.C1444l;
import p108j.InterfaceC1491y;
import p108j.MenuC1479m;
import p110k.C1569Z0;
import p110k.C1579d;
import p110k.C1584e1;
import p110k.C1594i;
import p110k.InterfaceC1576c;
import p110k.InterfaceC1583e0;
import p110k.InterfaceC1586f0;
import p110k.RunnableC1573b;
import p125o0.AbstractC1800j;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC1583e0, InterfaceC0361p, InterfaceC0363q {

    /* JADX INFO: renamed from: F */
    public static final int[] f2710F = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* JADX INFO: renamed from: A */
    public ViewPropertyAnimator f2711A;

    /* JADX INFO: renamed from: B */
    public final C0424k f2712B;

    /* JADX INFO: renamed from: C */
    public final RunnableC1573b f2713C;

    /* JADX INFO: renamed from: D */
    public final RunnableC1573b f2714D;

    /* JADX INFO: renamed from: E */
    public final C0365r f2715E;

    /* JADX INFO: renamed from: e */
    public int f2716e;

    /* JADX INFO: renamed from: f */
    public int f2717f;

    /* JADX INFO: renamed from: g */
    public ContentFrameLayout f2718g;

    /* JADX INFO: renamed from: h */
    public ActionBarContainer f2719h;

    /* JADX INFO: renamed from: i */
    public InterfaceC1586f0 f2720i;

    /* JADX INFO: renamed from: j */
    public Drawable f2721j;

    /* JADX INFO: renamed from: k */
    public boolean f2722k;

    /* JADX INFO: renamed from: l */
    public boolean f2723l;

    /* JADX INFO: renamed from: m */
    public boolean f2724m;

    /* JADX INFO: renamed from: n */
    public boolean f2725n;

    /* JADX INFO: renamed from: o */
    public boolean f2726o;

    /* JADX INFO: renamed from: p */
    public int f2727p;

    /* JADX INFO: renamed from: q */
    public int f2728q;

    /* JADX INFO: renamed from: r */
    public final Rect f2729r;

    /* JADX INFO: renamed from: s */
    public final Rect f2730s;

    /* JADX INFO: renamed from: t */
    public final Rect f2731t;

    /* JADX INFO: renamed from: u */
    public C0364q0 f2732u;

    /* JADX INFO: renamed from: v */
    public C0364q0 f2733v;

    /* JADX INFO: renamed from: w */
    public C0364q0 f2734w;

    /* JADX INFO: renamed from: x */
    public C0364q0 f2735x;

    /* JADX INFO: renamed from: y */
    public InterfaceC1576c f2736y;

    /* JADX INFO: renamed from: z */
    public OverScroller f2737z;

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2717f = 0;
        this.f2729r = new Rect();
        this.f2730s = new Rect();
        this.f2731t = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        C0364q0 c0364q0 = C0364q0.f873b;
        this.f2732u = c0364q0;
        this.f2733v = c0364q0;
        this.f2734w = c0364q0;
        this.f2735x = c0364q0;
        this.f2712B = new C0424k(3, this);
        this.f2713C = new RunnableC1573b(this, 0);
        this.f2714D = new RunnableC1573b(this, 1);
        m2237i(context);
        this.f2715E = new C0365r();
    }

    /* JADX INFO: renamed from: g */
    public static boolean m2235g(View view, Rect rect, boolean z3) {
        boolean z4;
        C1579d c1579d = (C1579d) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) c1579d).leftMargin;
        int i4 = rect.left;
        if (i3 != i4) {
            ((ViewGroup.MarginLayoutParams) c1579d).leftMargin = i4;
            z4 = true;
        } else {
            z4 = false;
        }
        int i5 = ((ViewGroup.MarginLayoutParams) c1579d).topMargin;
        int i6 = rect.top;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) c1579d).topMargin = i6;
            z4 = true;
        }
        int i7 = ((ViewGroup.MarginLayoutParams) c1579d).rightMargin;
        int i8 = rect.right;
        if (i7 != i8) {
            ((ViewGroup.MarginLayoutParams) c1579d).rightMargin = i8;
            z4 = true;
        }
        if (z3) {
            int i9 = ((ViewGroup.MarginLayoutParams) c1579d).bottomMargin;
            int i10 = rect.bottom;
            if (i9 != i10) {
                ((ViewGroup.MarginLayoutParams) c1579d).bottomMargin = i10;
                return true;
            }
        }
        return z4;
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: a */
    public final void mo821a(View view, View view2, int i3, int i4) {
        if (i4 == 0) {
            onNestedScrollAccepted(view, view2, i3);
        }
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: b */
    public final void mo822b(View view, int i3) {
        if (i3 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: c */
    public final void mo823c(View view, int i3, int i4, int[] iArr, int i5) {
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C1579d;
    }

    @Override // p029J.InterfaceC0363q
    /* JADX INFO: renamed from: d */
    public final void mo827d(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        mo824e(view, i3, i4, i5, i6, i7);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f2721j == null || this.f2722k) {
            return;
        }
        if (this.f2719h.getVisibility() == 0) {
            translationY = (int) (this.f2719h.getTranslationY() + this.f2719h.getBottom() + 0.5f);
        } else {
            translationY = 0;
        }
        this.f2721j.setBounds(0, translationY, getWidth(), this.f2721j.getIntrinsicHeight() + translationY);
        this.f2721j.draw(canvas);
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: e */
    public final void mo824e(View view, int i3, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            onNestedScroll(view, i3, i4, i5, i6);
        }
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: f */
    public final boolean mo825f(View view, View view2, int i3, int i4) {
        return i4 == 0 && onStartNestedScroll(view, view2, i3);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C1579d(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C1579d(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f2719h;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0365r c0365r = this.f2715E;
        return c0365r.f876b | c0365r.f875a;
    }

    public CharSequence getTitle() {
        m2239k();
        return ((C1584e1) this.f2720i).f5618a.getTitle();
    }

    /* JADX INFO: renamed from: h */
    public final void m2236h() {
        removeCallbacks(this.f2713C);
        removeCallbacks(this.f2714D);
        ViewPropertyAnimator viewPropertyAnimator = this.f2711A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m2237i(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f2710F);
        this.f2716e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f2721j = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f2722k = context.getApplicationInfo().targetSdkVersion < 19;
        this.f2737z = new OverScroller(context);
    }

    /* JADX INFO: renamed from: j */
    public final void m2238j(int i3) {
        m2239k();
        if (i3 == 2) {
            ((C1584e1) this.f2720i).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i3 == 5) {
            ((C1584e1) this.f2720i).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i3 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    /* JADX INFO: renamed from: k */
    public final void m2239k() {
        InterfaceC1586f0 wrapper;
        if (this.f2718g == null) {
            this.f2718g = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f2719h = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof InterfaceC1586f0) {
                wrapper = (InterfaceC1586f0) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f2720i = wrapper;
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m2240l(Menu menu, InterfaceC1491y interfaceC1491y) {
        m2239k();
        C1584e1 c1584e1 = (C1584e1) this.f2720i;
        C1594i c1594i = c1584e1.f5630m;
        Toolbar toolbar = c1584e1.f5618a;
        if (c1594i == null) {
            c1584e1.f5630m = new C1594i(toolbar.getContext());
        }
        C1594i c1594i2 = c1584e1.f5630m;
        c1594i2.f5645i = interfaceC1491y;
        MenuC1479m menuC1479m = (MenuC1479m) menu;
        if (menuC1479m == null && toolbar.f2830e == null) {
            return;
        }
        toolbar.m2274f();
        MenuC1479m menuC1479m2 = toolbar.f2830e.f2743t;
        if (menuC1479m2 == menuC1479m) {
            return;
        }
        if (menuC1479m2 != null) {
            menuC1479m2.m3520r(toolbar.f2823N);
            menuC1479m2.m3520r(toolbar.f2824O);
        }
        if (toolbar.f2824O == null) {
            toolbar.f2824O = new C1569Z0(toolbar);
        }
        c1594i2.f5657u = true;
        if (menuC1479m != null) {
            menuC1479m.m3512b(c1594i2, toolbar.f2839n);
            menuC1479m.m3512b(toolbar.f2824O, toolbar.f2839n);
        } else {
            c1594i2.mo3506c(toolbar.f2839n, null);
            toolbar.f2824O.mo3506c(toolbar.f2839n, null);
            c1594i2.mo3480g();
            toolbar.f2824O.mo3480g();
        }
        toolbar.f2830e.setPopupTheme(toolbar.f2840o);
        toolbar.f2830e.setPresenter(c1594i2);
        toolbar.f2823N = c1594i2;
        toolbar.m2284t();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        m2239k();
        C0364q0 c0364q0M829g = C0364q0.m829g(windowInsets, this);
        boolean zM2235g = m2235g(this.f2719h, new Rect(c0364q0M829g.m831b(), c0364q0M829g.m833d(), c0364q0M829g.m832c(), c0364q0M829g.m830a()), false);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        Rect rect = this.f2729r;
        AbstractC0313H.m629b(this, c0364q0M829g, rect);
        int i3 = rect.left;
        int i4 = rect.top;
        int i5 = rect.right;
        int i6 = rect.bottom;
        C0360o0 c0360o0 = c0364q0M829g.f874a;
        C0364q0 c0364q0Mo753l = c0360o0.mo753l(i3, i4, i5, i6);
        this.f2732u = c0364q0Mo753l;
        boolean z3 = true;
        if (!this.f2733v.equals(c0364q0Mo753l)) {
            this.f2733v = this.f2732u;
            zM2235g = true;
        }
        Rect rect2 = this.f2730s;
        if (rect2.equals(rect)) {
            z3 = zM2235g;
        } else {
            rect2.set(rect);
        }
        if (z3) {
            requestLayout();
        }
        return c0360o0.mo767a().f874a.mo763c().f874a.mo762b().m834f();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m2237i(getContext());
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0311F.m627c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2236h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                C1579d c1579d = (C1579d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = ((ViewGroup.MarginLayoutParams) c1579d).leftMargin + paddingLeft;
                int i9 = ((ViewGroup.MarginLayoutParams) c1579d).topMargin + paddingTop;
                childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i4) {
        int measuredHeight;
        m2239k();
        measureChildWithMargins(this.f2719h, i3, 0, i4, 0);
        C1579d c1579d = (C1579d) this.f2719h.getLayoutParams();
        int iMax = Math.max(0, this.f2719h.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c1579d).leftMargin + ((ViewGroup.MarginLayoutParams) c1579d).rightMargin);
        int iMax2 = Math.max(0, this.f2719h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c1579d).topMargin + ((ViewGroup.MarginLayoutParams) c1579d).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f2719h.getMeasuredState());
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        boolean z3 = (AbstractC0307B.m591g(this) & 256) != 0;
        if (z3) {
            measuredHeight = this.f2716e;
            if (this.f2724m && this.f2719h.getTabContainer() != null) {
                measuredHeight += this.f2716e;
            }
        } else {
            measuredHeight = this.f2719h.getVisibility() != 8 ? this.f2719h.getMeasuredHeight() : 0;
        }
        Rect rect = this.f2729r;
        Rect rect2 = this.f2731t;
        rect2.set(rect);
        C0364q0 c0364q0 = this.f2732u;
        this.f2734w = c0364q0;
        if (this.f2723l || z3) {
            C0029d c0029dM139a = C0029d.m139a(c0364q0.m831b(), this.f2734w.m833d() + measuredHeight, this.f2734w.m832c(), this.f2734w.m830a());
            C0364q0 c0364q02 = this.f2734w;
            int i5 = Build.VERSION.SDK_INT;
            AbstractC0346h0 c0344g0 = i5 >= 30 ? new C0344g0(c0364q02) : i5 >= 29 ? new C0342f0(c0364q02) : new C0340e0(c0364q02);
            c0344g0.mo738d(c0029dM139a);
            this.f2734w = c0344g0.mo736b();
        } else {
            rect2.top += measuredHeight;
            rect2.bottom = rect2.bottom;
            this.f2734w = c0364q0.f874a.mo753l(0, measuredHeight, 0, 0);
        }
        m2235g(this.f2718g, rect2, true);
        if (!this.f2735x.equals(this.f2734w)) {
            C0364q0 c0364q03 = this.f2734w;
            this.f2735x = c0364q03;
            ContentFrameLayout contentFrameLayout = this.f2718g;
            WindowInsets windowInsetsM834f = c0364q03.m834f();
            if (windowInsetsM834f != null) {
                WindowInsets windowInsetsM625a = AbstractC0311F.m625a(contentFrameLayout, windowInsetsM834f);
                if (!windowInsetsM625a.equals(windowInsetsM834f)) {
                    C0364q0.m829g(windowInsetsM625a, contentFrameLayout);
                }
            }
        }
        measureChildWithMargins(this.f2718g, i3, 0, i4, 0);
        C1579d c1579d2 = (C1579d) this.f2718g.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f2718g.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c1579d2).leftMargin + ((ViewGroup.MarginLayoutParams) c1579d2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f2718g.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c1579d2).topMargin + ((ViewGroup.MarginLayoutParams) c1579d2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2718g.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i3, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i4, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f3, float f4, boolean z3) {
        if (!this.f2725n || !z3) {
            return false;
        }
        this.f2737z.fling(0, 0, 0, (int) f4, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f2737z.getFinalY() > this.f2719h.getHeight()) {
            m2236h();
            this.f2714D.run();
        } else {
            m2236h();
            this.f2713C.run();
        }
        this.f2726o = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f3, float f4) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        int i7 = this.f2727p + i4;
        this.f2727p = i7;
        setActionBarHideOffset(i7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i3) {
        C1361G c1361g;
        C1444l c1444l;
        this.f2715E.f875a = i3;
        this.f2727p = getActionBarHideOffset();
        m2236h();
        InterfaceC1576c interfaceC1576c = this.f2736y;
        if (interfaceC1576c == null || (c1444l = (c1361g = (C1361G) interfaceC1576c).f4860s) == null) {
            return;
        }
        c1444l.m3450a();
        c1361g.f4860s = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i3) {
        if ((i3 & 2) == 0 || this.f2719h.getVisibility() != 0) {
            return false;
        }
        return this.f2725n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f2725n || this.f2726o) {
            return;
        }
        if (this.f2727p <= this.f2719h.getHeight()) {
            m2236h();
            postDelayed(this.f2713C, 600L);
        } else {
            m2236h();
            postDelayed(this.f2714D, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i3) {
        super.onWindowSystemUiVisibilityChanged(i3);
        m2239k();
        int i4 = this.f2728q ^ i3;
        this.f2728q = i3;
        boolean z3 = (i3 & 4) == 0;
        boolean z4 = (i3 & 256) != 0;
        InterfaceC1576c interfaceC1576c = this.f2736y;
        if (interfaceC1576c != null) {
            ((C1361G) interfaceC1576c).f4856o = !z4;
            if (z3 || !z4) {
                C1361G c1361g = (C1361G) interfaceC1576c;
                if (c1361g.f4857p) {
                    c1361g.f4857p = false;
                    c1361g.m3331o(true);
                }
            } else {
                C1361G c1361g2 = (C1361G) interfaceC1576c;
                if (!c1361g2.f4857p) {
                    c1361g2.f4857p = true;
                    c1361g2.m3331o(true);
                }
            }
        }
        if ((i4 & 256) == 0 || this.f2736y == null) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0311F.m627c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        this.f2717f = i3;
        InterfaceC1576c interfaceC1576c = this.f2736y;
        if (interfaceC1576c != null) {
            ((C1361G) interfaceC1576c).f4855n = i3;
        }
    }

    public void setActionBarHideOffset(int i3) {
        m2236h();
        this.f2719h.setTranslationY(-Math.max(0, Math.min(i3, this.f2719h.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC1576c interfaceC1576c) {
        this.f2736y = interfaceC1576c;
        if (getWindowToken() != null) {
            ((C1361G) this.f2736y).f4855n = this.f2717f;
            int i3 = this.f2728q;
            if (i3 != 0) {
                onWindowSystemUiVisibilityChanged(i3);
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                AbstractC0311F.m627c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z3) {
        this.f2724m = z3;
    }

    public void setHideOnContentScrollEnabled(boolean z3) {
        if (z3 != this.f2725n) {
            this.f2725n = z3;
            if (z3) {
                return;
            }
            m2236h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i3) {
        m2239k();
        C1584e1 c1584e1 = (C1584e1) this.f2720i;
        c1584e1.f5621d = i3 != 0 ? AbstractC1800j.m3991i(c1584e1.f5618a.getContext(), i3) : null;
        c1584e1.m3649c();
    }

    public void setLogo(int i3) {
        m2239k();
        C1584e1 c1584e1 = (C1584e1) this.f2720i;
        c1584e1.f5622e = i3 != 0 ? AbstractC1800j.m3991i(c1584e1.f5618a.getContext(), i3) : null;
        c1584e1.m3649c();
    }

    public void setOverlayMode(boolean z3) {
        this.f2723l = z3;
        this.f2722k = z3 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z3) {
    }

    public void setUiOptions(int i3) {
    }

    @Override // p110k.InterfaceC1583e0
    public void setWindowCallback(Window.Callback callback) {
        m2239k();
        ((C1584e1) this.f2720i).f5628k = callback;
    }

    @Override // p110k.InterfaceC1583e0
    public void setWindowTitle(CharSequence charSequence) {
        m2239k();
        C1584e1 c1584e1 = (C1584e1) this.f2720i;
        if (c1584e1.f5624g) {
            return;
        }
        c1584e1.f5625h = charSequence;
        if ((c1584e1.f5619b & 8) != 0) {
            Toolbar toolbar = c1584e1.f5618a;
            toolbar.setTitle(charSequence);
            if (c1584e1.f5624g) {
                AbstractC0323S.m702l(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C1579d(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        m2239k();
        C1584e1 c1584e1 = (C1584e1) this.f2720i;
        c1584e1.f5621d = drawable;
        c1584e1.m3649c();
    }
}
