package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import java.util.WeakHashMap;
import p029J.AbstractC0307B;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p029J.C0359o;
import p029J.C0365r;
import p029J.InterfaceC0357n;
import p029J.InterfaceC0363q;
import p041N.AbstractC0517e;
import p041N.AbstractC0522j;
import p041N.C0521i;
import p041N.C0524l;
import p041N.InterfaceC0523k;
import p071Y0.AbstractC0752p;
import p137r0.AbstractC1852a;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0363q, InterfaceC0357n {

    /* JADX INFO: renamed from: E */
    public static final float f2932E = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* JADX INFO: renamed from: F */
    public static final C0521i f2933F = new C0521i(0);

    /* JADX INFO: renamed from: G */
    public static final int[] f2934G = {R.attr.fillViewport};

    /* JADX INFO: renamed from: A */
    public C0524l f2935A;

    /* JADX INFO: renamed from: B */
    public final C0365r f2936B;

    /* JADX INFO: renamed from: C */
    public final C0359o f2937C;

    /* JADX INFO: renamed from: D */
    public float f2938D;

    /* JADX INFO: renamed from: e */
    public final float f2939e;

    /* JADX INFO: renamed from: f */
    public long f2940f;

    /* JADX INFO: renamed from: g */
    public final Rect f2941g;

    /* JADX INFO: renamed from: h */
    public final OverScroller f2942h;

    /* JADX INFO: renamed from: i */
    public final EdgeEffect f2943i;

    /* JADX INFO: renamed from: j */
    public final EdgeEffect f2944j;

    /* JADX INFO: renamed from: k */
    public int f2945k;

    /* JADX INFO: renamed from: l */
    public boolean f2946l;

    /* JADX INFO: renamed from: m */
    public boolean f2947m;

    /* JADX INFO: renamed from: n */
    public View f2948n;

    /* JADX INFO: renamed from: o */
    public boolean f2949o;

    /* JADX INFO: renamed from: p */
    public VelocityTracker f2950p;

    /* JADX INFO: renamed from: q */
    public boolean f2951q;

    /* JADX INFO: renamed from: r */
    public boolean f2952r;

    /* JADX INFO: renamed from: s */
    public final int f2953s;

    /* JADX INFO: renamed from: t */
    public final int f2954t;

    /* JADX INFO: renamed from: u */
    public final int f2955u;

    /* JADX INFO: renamed from: v */
    public int f2956v;

    /* JADX INFO: renamed from: w */
    public final int[] f2957w;

    /* JADX INFO: renamed from: x */
    public final int[] f2958x;

    /* JADX INFO: renamed from: y */
    public int f2959y;

    /* JADX INFO: renamed from: z */
    public int f2960z;

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, io.getgrass.www.R.attr.nestedScrollViewStyle);
        this.f2941g = new Rect();
        this.f2946l = true;
        this.f2947m = false;
        this.f2948n = null;
        this.f2949o = false;
        this.f2952r = true;
        this.f2956v = -1;
        this.f2957w = new int[2];
        this.f2958x = new int[2];
        int i3 = Build.VERSION.SDK_INT;
        this.f2943i = i3 >= 31 ? AbstractC0517e.m1028a(context, attributeSet) : new EdgeEffect(context);
        this.f2944j = i3 >= 31 ? AbstractC0517e.m1028a(context, attributeSet) : new EdgeEffect(context);
        this.f2939e = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f2942h = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2953s = viewConfiguration.getScaledTouchSlop();
        this.f2954t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2955u = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2934G, io.getgrass.www.R.attr.nestedScrollViewStyle, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f2936B = new C0365r();
        this.f2937C = new C0359o(this);
        setNestedScrollingEnabled(true);
        AbstractC0323S.m701k(this, f2933F);
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f2938D == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f2938D = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f2938D;
    }

    /* JADX INFO: renamed from: m */
    public static boolean m2319m(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && m2319m((View) parent, view2);
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: a */
    public final void mo821a(View view, View view2, int i3, int i4) {
        C0365r c0365r = this.f2936B;
        if (i4 == 1) {
            c0365r.f876b = i3;
        } else {
            c0365r.f875a = i3;
        }
        this.f2937C.m819h(2, i4);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: b */
    public final void mo822b(View view, int i3) {
        C0365r c0365r = this.f2936B;
        if (i3 == 1) {
            c0365r.f876b = 0;
        } else {
            c0365r.f875a = 0;
        }
        m2334v(i3);
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: c */
    public final void mo823c(View view, int i3, int i4, int[] iArr, int i5) {
        this.f2937C.m814c(i3, i4, iArr, null, i5);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void computeScroll() {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // p029J.InterfaceC0363q
    /* JADX INFO: renamed from: d */
    public final void mo827d(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        m2327o(i6, i7, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2323j(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f3, float f4, boolean z3) {
        return this.f2937C.m812a(f3, f4, z3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f3, float f4) {
        return this.f2937C.m813b(f3, f4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2) {
        return this.f2937C.m814c(i3, i4, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr) {
        return this.f2937C.m816e(i3, i4, i5, i6, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f2943i;
        int paddingLeft2 = 0;
        if (!edgeEffect.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (AbstractC0522j.m1042a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (AbstractC0522j.m1042a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                AbstractC0307B.m595k(this);
            }
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect2 = this.f2944j;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (AbstractC0522j.m1042a(this)) {
            width2 -= getPaddingRight() + getPaddingLeft();
            paddingLeft2 = getPaddingLeft();
        }
        if (AbstractC0522j.m1042a(this)) {
            height2 -= getPaddingBottom() + getPaddingTop();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
            AbstractC0307B.m595k(this);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: e */
    public final void mo824e(View view, int i3, int i4, int i5, int i6, int i7) {
        m2327o(i6, i7, null);
    }

    @Override // p029J.InterfaceC0361p
    /* JADX INFO: renamed from: f */
    public final boolean mo825f(View view, View view2, int i3, int i4) {
        return (i3 & 2) != 0;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m2320g(int i3) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i3);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !m2326n(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i3 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i3 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i3 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2322i(maxScrollAmount);
        } else {
            Rect rect = this.f2941g;
            viewFindNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(viewFindNextFocus, rect);
            m2322i(m2321h(rect));
            viewFindNextFocus.requestFocus(i3);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && (!m2326n(viewFindFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0365r c0365r = this.f2936B;
        return c0365r.f876b | c0365r.f875a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    /* JADX INFO: renamed from: h */
    public final int m2321h(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        int i5 = rect.bottom;
        if (i5 > i4 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i4, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        }
        if (rect.top >= scrollY || i5 >= i4) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i4 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f2937C.m818g(0);
    }

    /* JADX INFO: renamed from: i */
    public final void m2322i(int i3) {
        if (i3 != 0) {
            if (this.f2952r) {
                m2332t(0, i3, false);
            } else {
                scrollBy(0, i3);
            }
        }
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f2937C.f869d;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m2323j(KeyEvent keyEvent) {
        Rect rect = this.f2941g;
        rect.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 19) {
                    return !keyEvent.isAltPressed() ? m2320g(33) : m2325l(33);
                }
                if (keyCode == 20) {
                    return !keyEvent.isAltPressed() ? m2320g(130) : m2325l(130);
                }
                if (keyCode != 62) {
                    return false;
                }
                int i3 = keyEvent.isShiftPressed() ? 33 : 130;
                boolean z3 = i3 == 130;
                int height = getHeight();
                if (z3) {
                    rect.top = getScrollY() + height;
                    int childCount = getChildCount();
                    if (childCount > 0) {
                        View childAt2 = getChildAt(childCount - 1);
                        int paddingBottom = getPaddingBottom() + childAt2.getBottom() + ((FrameLayout.LayoutParams) childAt2.getLayoutParams()).bottomMargin;
                        if (rect.top + height > paddingBottom) {
                            rect.top = paddingBottom - height;
                        }
                    }
                } else {
                    int scrollY = getScrollY() - height;
                    rect.top = scrollY;
                    if (scrollY < 0) {
                        rect.top = 0;
                    }
                }
                int i4 = rect.top;
                int i5 = height + i4;
                rect.bottom = i5;
                m2330r(i3, i4, i5);
                return false;
            }
        }
        if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
        return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
    }

    /* JADX INFO: renamed from: k */
    public final void m2324k(int i3) {
        if (getChildCount() > 0) {
            this.f2942h.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.f2937C.m819h(2, 1);
            this.f2960z = getScrollY();
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0307B.m595k(this);
        }
    }

    /* JADX INFO: renamed from: l */
    public final boolean m2325l(int i3) {
        int childCount;
        boolean z3 = i3 == 130;
        int height = getHeight();
        Rect rect = this.f2941g;
        rect.top = 0;
        rect.bottom = height;
        if (z3 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return m2330r(i3, rect.top, rect.bottom);
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    /* JADX INFO: renamed from: n */
    public final boolean m2326n(View view, int i3, int i4) {
        Rect rect = this.f2941g;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i3 >= getScrollY() && rect.top - i3 <= getScrollY() + i4;
    }

    /* JADX INFO: renamed from: o */
    public final void m2327o(int i3, int i4, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i3);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f2937C.m815d(scrollY2, i3 - scrollY2, i4, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2947m = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean z3;
        int i3 = 0;
        if (motionEvent.getAction() == 8 && !this.f2949o) {
            float axisValue = AbstractC0752p.m1937g(motionEvent, 2) ? motionEvent.getAxisValue(9) : AbstractC0752p.m1937g(motionEvent, 4194304) ? motionEvent.getAxisValue(26) : 0.0f;
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i4 = scrollY - verticalScrollFactorCompat;
                if (i4 < 0) {
                    int overScrollMode = getOverScrollMode();
                    if ((overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !AbstractC0752p.m1937g(motionEvent, 8194)) {
                        float height = (-i4) / getHeight();
                        EdgeEffect edgeEffect = this.f2943i;
                        AbstractC1852a.m4129d(edgeEffect, height, 0.5f);
                        edgeEffect.onRelease();
                        invalidate();
                        z3 = 1;
                    } else {
                        z3 = 0;
                    }
                } else if (i4 > scrollRange) {
                    int overScrollMode2 = getOverScrollMode();
                    if ((overScrollMode2 == 0 || (overScrollMode2 == 1 && getScrollRange() > 0)) && !AbstractC0752p.m1937g(motionEvent, 8194)) {
                        float height2 = (i4 - scrollRange) / getHeight();
                        EdgeEffect edgeEffect2 = this.f2944j;
                        AbstractC1852a.m4129d(edgeEffect2, height2, 0.5f);
                        edgeEffect2.onRelease();
                        invalidate();
                        i3 = 1;
                    }
                    z3 = i3;
                    i3 = scrollRange;
                } else {
                    z3 = 0;
                    i3 = i4;
                }
                if (i3 == scrollY) {
                    return z3;
                }
                super.scrollTo(getScrollX(), i3);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0119  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int measuredHeight;
        super.onLayout(z3, i3, i4, i5, i6);
        int i7 = 0;
        this.f2946l = false;
        View view = this.f2948n;
        if (view != null && m2319m(view, this)) {
            View view2 = this.f2948n;
            Rect rect = this.f2941g;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iM2321h = m2321h(rect);
            if (iM2321h != 0) {
                scrollBy(0, iM2321h);
            }
        }
        this.f2948n = null;
        if (!this.f2947m) {
            if (this.f2935A != null) {
                scrollTo(getScrollX(), this.f2935A.f1218e);
                this.f2935A = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
            int paddingTop = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < measuredHeight && scrollY >= 0) {
                i7 = paddingTop + scrollY > measuredHeight ? measuredHeight - paddingTop : scrollY;
            }
            if (i7 != scrollY) {
                scrollTo(getScrollX(), i7);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2947m = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f2951q && View.MeasureSpec.getMode(i4) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f3, float f4, boolean z3) {
        if (z3) {
            return false;
        }
        dispatchNestedFling(0.0f, f4, true);
        m2324k((int) f4);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f3, float f4) {
        return this.f2937C.m813b(f3, f4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        this.f2937C.m814c(i3, i4, iArr, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        m2327o(i6, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i3) {
        mo821a(view, view2, i3, 0);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i3, int i4, boolean z3, boolean z4) {
        super.scrollTo(i3, i4);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (i3 == 2) {
            i3 = 130;
        } else if (i3 == 1) {
            i3 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i3) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i3);
        if (viewFindNextFocus == null || (true ^ m2326n(viewFindNextFocus, 0, getHeight()))) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i3, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0524l)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0524l c0524l = (C0524l) parcelable;
        super.onRestoreInstanceState(c0524l.getSuperState());
        this.f2935A = c0524l;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C0524l c0524l = new C0524l(super.onSaveInstanceState());
        c0524l.f1218e = getScrollY();
        return c0524l;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i3, int i4, int i5, int i6) {
        super.onScrollChanged(i3, i4, i5, i6);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !m2326n(viewFindFocus, 0, i6)) {
            return;
        }
        Rect rect = this.f2941g;
        viewFindFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(viewFindFocus, rect);
        m2322i(m2321h(rect));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i3) {
        return mo825f(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        mo822b(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0224  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r26) {
        /*
            Method dump skipped, instruction units count: 761
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: renamed from: p */
    public final void m2328p(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2956v) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.f2945k = (int) motionEvent.getY(i3);
            this.f2956v = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.f2950p;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX INFO: renamed from: q */
    public final boolean m2329q(int i3, int i4, int i5, int i6) {
        boolean z3;
        boolean z4;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i7 = i5 + i3;
        if (i4 <= 0 && i4 >= 0) {
            z3 = false;
        } else {
            i4 = 0;
            z3 = true;
        }
        if (i7 > i6) {
            z4 = true;
        } else if (i7 < 0) {
            i6 = 0;
            z4 = true;
        } else {
            i6 = i7;
            z4 = false;
        }
        if (z4 && !this.f2937C.m818g(1)) {
            this.f2942h.springBack(i4, i6, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i4, i6);
        return z3 || z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX INFO: renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m2330r(int r18, int r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            int r4 = r17.getHeight()
            int r5 = r17.getScrollY()
            int r4 = r4 + r5
            r6 = 33
            if (r1 != r6) goto L17
            r6 = 1
            goto L18
        L17:
            r6 = 0
        L18:
            r9 = 2
            java.util.ArrayList r9 = r0.getFocusables(r9)
            int r10 = r9.size()
            r11 = 0
            r12 = 0
            r13 = 0
        L24:
            if (r12 >= r10) goto L6c
            java.lang.Object r14 = r9.get(r12)
            android.view.View r14 = (android.view.View) r14
            int r15 = r14.getTop()
            int r7 = r14.getBottom()
            if (r2 >= r7) goto L69
            if (r15 >= r3) goto L69
            if (r2 >= r15) goto L3f
            if (r7 >= r3) goto L3f
            r16 = 1
            goto L41
        L3f:
            r16 = 0
        L41:
            if (r11 != 0) goto L47
            r11 = r14
            r13 = r16
            goto L69
        L47:
            if (r6 == 0) goto L4f
            int r8 = r11.getTop()
            if (r15 < r8) goto L57
        L4f:
            if (r6 != 0) goto L59
            int r8 = r11.getBottom()
            if (r7 <= r8) goto L59
        L57:
            r7 = 1
            goto L5a
        L59:
            r7 = 0
        L5a:
            if (r13 == 0) goto L61
            if (r16 == 0) goto L69
            if (r7 == 0) goto L69
            goto L68
        L61:
            if (r16 == 0) goto L66
            r11 = r14
            r13 = 1
            goto L69
        L66:
            if (r7 == 0) goto L69
        L68:
            r11 = r14
        L69:
            int r12 = r12 + 1
            goto L24
        L6c:
            if (r11 != 0) goto L6f
            r11 = r0
        L6f:
            if (r2 < r5) goto L75
            if (r3 > r4) goto L75
            r7 = 0
            goto L7f
        L75:
            if (r6 == 0) goto L79
            int r2 = r2 - r5
            goto L7b
        L79:
            int r2 = r3 - r4
        L7b:
            r0.m2322i(r2)
            r7 = 1
        L7f:
            android.view.View r2 = r17.findFocus()
            if (r11 == r2) goto L88
            r11.requestFocus(r1)
        L88:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.m2330r(int, int, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.f2946l) {
            this.f2948n = view2;
        } else {
            Rect rect = this.f2941g;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iM2321h = m2321h(rect);
            if (iM2321h != 0) {
                scrollBy(0, iM2321h);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iM2321h = m2321h(rect);
        boolean z4 = iM2321h != 0;
        if (z4) {
            if (z3) {
                scrollBy(0, iM2321h);
            } else {
                m2332t(0, iM2321h, false);
            }
        }
        return z4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z3) {
        VelocityTracker velocityTracker;
        if (z3 && (velocityTracker = this.f2950p) != null) {
            velocityTracker.recycle();
            this.f2950p = null;
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f2946l = true;
        super.requestLayout();
    }

    /* JADX INFO: renamed from: s */
    public final boolean m2331s(EdgeEffect edgeEffect, int i3) {
        if (i3 > 0) {
            return true;
        }
        float fM4127b = AbstractC1852a.m4127b(edgeEffect) * getHeight();
        float fAbs = Math.abs(-i3) * 0.35f;
        float f3 = this.f2939e * 0.015f;
        double dLog = Math.log(fAbs / f3);
        double d = f2932E;
        return ((float) (Math.exp((d / (d - 1.0d)) * dLog) * ((double) f3))) < fM4127b;
    }

    @Override // android.view.View
    public final void scrollTo(int i3, int i4) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i3 < 0) {
                i3 = 0;
            } else if (width + i3 > width2) {
                i3 = width2 - width;
            }
            if (height >= height2 || i4 < 0) {
                i4 = 0;
            } else if (height + i4 > height2) {
                i4 = height2 - height;
            }
            if (i3 == getScrollX() && i4 == getScrollY()) {
                return;
            }
            super.scrollTo(i3, i4);
        }
    }

    public void setFillViewport(boolean z3) {
        if (z3 != this.f2951q) {
            this.f2951q = z3;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z3) {
        C0359o c0359o = this.f2937C;
        if (c0359o.f869d) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0313H.m653z(c0359o.f868c);
        }
        c0359o.f869d = z3;
    }

    public void setOnScrollChangeListener(InterfaceC0523k interfaceC0523k) {
    }

    public void setSmoothScrollingEnabled(boolean z3) {
        this.f2952r = z3;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i3) {
        return this.f2937C.m819h(i3, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        m2334v(0);
    }

    /* JADX INFO: renamed from: t */
    public final void m2332t(int i3, int i4, boolean z3) {
        OverScroller overScroller = this.f2942h;
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f2940f > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f2942h.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i4 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
            if (z3) {
                this.f2937C.m819h(2, 1);
            } else {
                m2334v(1);
            }
            this.f2960z = getScrollY();
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0307B.m595k(this);
        } else {
            if (!overScroller.isFinished()) {
                overScroller.abortAnimation();
                m2334v(1);
            }
            scrollBy(i3, i4);
        }
        this.f2940f = AnimationUtils.currentAnimationTimeMillis();
    }

    /* JADX INFO: renamed from: u */
    public final boolean m2333u(MotionEvent motionEvent) {
        boolean z3;
        EdgeEffect edgeEffect = this.f2943i;
        if (AbstractC1852a.m4127b(edgeEffect) != 0.0f) {
            AbstractC1852a.m4129d(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z3 = true;
        } else {
            z3 = false;
        }
        EdgeEffect edgeEffect2 = this.f2944j;
        if (AbstractC1852a.m4127b(edgeEffect2) == 0.0f) {
            return z3;
        }
        AbstractC1852a.m4129d(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    /* JADX INFO: renamed from: v */
    public final void m2334v(int i3) {
        this.f2937C.m820i(i3);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3) {
        if (getChildCount() <= 0) {
            super.addView(view, i3);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
