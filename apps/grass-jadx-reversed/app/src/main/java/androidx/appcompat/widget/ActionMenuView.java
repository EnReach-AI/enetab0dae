package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import p019F0.C0221e;
import p025H1.C0276e;
import p108j.C1481o;
import p108j.InterfaceC1462B;
import p108j.InterfaceC1477k;
import p108j.InterfaceC1478l;
import p108j.InterfaceC1491y;
import p108j.MenuC1479m;
import p110k.AbstractC1596i1;
import p110k.AbstractC1614r0;
import p110k.C1582e;
import p110k.C1591h;
import p110k.C1594i;
import p110k.C1599k;
import p110k.C1612q0;
import p110k.InterfaceC1597j;
import p110k.InterfaceC1601l;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends AbstractC1614r0 implements InterfaceC1478l, InterfaceC1462B {

    /* JADX INFO: renamed from: A */
    public boolean f2738A;

    /* JADX INFO: renamed from: B */
    public int f2739B;

    /* JADX INFO: renamed from: C */
    public final int f2740C;

    /* JADX INFO: renamed from: D */
    public final int f2741D;

    /* JADX INFO: renamed from: E */
    public InterfaceC1601l f2742E;

    /* JADX INFO: renamed from: t */
    public MenuC1479m f2743t;

    /* JADX INFO: renamed from: u */
    public Context f2744u;

    /* JADX INFO: renamed from: v */
    public int f2745v;

    /* JADX INFO: renamed from: w */
    public boolean f2746w;

    /* JADX INFO: renamed from: x */
    public C1594i f2747x;

    /* JADX INFO: renamed from: y */
    public InterfaceC1491y f2748y;

    /* JADX INFO: renamed from: z */
    public InterfaceC1477k f2749z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f3 = context.getResources().getDisplayMetrics().density;
        this.f2740C = (int) (56.0f * f3);
        this.f2741D = (int) (f3 * 4.0f);
        this.f2744u = context;
        this.f2745v = 0;
    }

    /* JADX INFO: renamed from: l */
    public static C1599k m2241l() {
        C1599k c1599k = new C1599k(-2, -2);
        c1599k.f5668a = false;
        ((LinearLayout.LayoutParams) c1599k).gravity = 16;
        return c1599k;
    }

    /* JADX INFO: renamed from: m */
    public static C1599k m2242m(ViewGroup.LayoutParams layoutParams) {
        C1599k c1599k;
        if (layoutParams == null) {
            return m2241l();
        }
        if (layoutParams instanceof C1599k) {
            C1599k c1599k2 = (C1599k) layoutParams;
            c1599k = new C1599k(c1599k2);
            c1599k.f5668a = c1599k2.f5668a;
        } else {
            c1599k = new C1599k(layoutParams);
        }
        if (((LinearLayout.LayoutParams) c1599k).gravity <= 0) {
            ((LinearLayout.LayoutParams) c1599k).gravity = 16;
        }
        return c1599k;
    }

    @Override // p108j.InterfaceC1462B
    /* JADX INFO: renamed from: a */
    public final void mo2224a(MenuC1479m menuC1479m) {
        this.f2743t = menuC1479m;
    }

    @Override // p108j.InterfaceC1478l
    /* JADX INFO: renamed from: b */
    public final boolean mo2225b(C1481o c1481o) {
        return this.f2743t.m3519q(c1481o, null, 0);
    }

    @Override // p110k.AbstractC1614r0, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C1599k;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // p110k.AbstractC1614r0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m2241l();
    }

    @Override // p110k.AbstractC1614r0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m2242m(layoutParams);
    }

    public Menu getMenu() {
        if (this.f2743t == null) {
            Context context = getContext();
            MenuC1479m menuC1479m = new MenuC1479m(context);
            this.f2743t = menuC1479m;
            menuC1479m.f5348e = new C0221e(18, this);
            C1594i c1594i = new C1594i(context);
            this.f2747x = c1594i;
            c1594i.f5652p = true;
            c1594i.f5653q = true;
            InterfaceC1491y c0276e = this.f2748y;
            if (c0276e == null) {
                c0276e = new C0276e(10);
            }
            c1594i.f5645i = c0276e;
            this.f2743t.m3512b(c1594i, this.f2744u);
            C1594i c1594i2 = this.f2747x;
            c1594i2.f5648l = this;
            this.f2743t = c1594i2.f5643g;
        }
        return this.f2743t;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        C1594i c1594i = this.f2747x;
        C1591h c1591h = c1594i.f5649m;
        if (c1591h != null) {
            return c1591h.getDrawable();
        }
        if (c1594i.f5651o) {
            return c1594i.f5650n;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f2745v;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // p110k.AbstractC1614r0
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ C1612q0 generateDefaultLayoutParams() {
        return m2241l();
    }

    @Override // p110k.AbstractC1614r0
    /* JADX INFO: renamed from: i */
    public final C1612q0 generateLayoutParams(AttributeSet attributeSet) {
        return new C1599k(getContext(), attributeSet);
    }

    @Override // p110k.AbstractC1614r0
    /* JADX INFO: renamed from: j */
    public final /* bridge */ /* synthetic */ C1612q0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m2242m(layoutParams);
    }

    /* JADX INFO: renamed from: n */
    public final boolean m2246n(int i3) {
        boolean zMo2219a = false;
        if (i3 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i3 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i3);
        if (i3 < getChildCount() && (childAt instanceof InterfaceC1597j)) {
            zMo2219a = ((InterfaceC1597j) childAt).mo2219a();
        }
        return (i3 <= 0 || !(childAt2 instanceof InterfaceC1597j)) ? zMo2219a : zMo2219a | ((InterfaceC1597j) childAt2).mo2220b();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C1594i c1594i = this.f2747x;
        if (c1594i != null) {
            c1594i.mo3480g();
            if (this.f2747x.m3656j()) {
                this.f2747x.m3655f();
                this.f2747x.m3657l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C1594i c1594i = this.f2747x;
        if (c1594i != null) {
            c1594i.m3655f();
            C1582e c1582e = c1594i.f5660x;
            if (c1582e == null || !c1582e.m3539b()) {
                return;
            }
            c1582e.f5421j.dismiss();
        }
    }

    @Override // p110k.AbstractC1614r0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int width;
        int paddingLeft;
        if (!this.f2738A) {
            super.onLayout(z3, i3, i4, i5, i6);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i6 - i4) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i5 - i3;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zM3658a = AbstractC1596i1.m3658a(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                C1599k c1599k = (C1599k) childAt.getLayoutParams();
                if (c1599k.f5668a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (m2246n(i11)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zM3658a) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) c1599k).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) c1599k).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) c1599k).leftMargin) + ((LinearLayout.LayoutParams) c1599k).rightMargin;
                    m2246n(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        int iMax = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (zM3658a) {
            int width2 = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                C1599k c1599k2 = (C1599k) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !c1599k2.f5668a) {
                    int i17 = width2 - ((LinearLayout.LayoutParams) c1599k2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width2 = i17 - ((measuredWidth3 + ((LinearLayout.LayoutParams) c1599k2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            C1599k c1599k3 = (C1599k) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !c1599k3.f5668a) {
                int i20 = paddingLeft2 + ((LinearLayout.LayoutParams) c1599k3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) c1599k3).rightMargin + iMax + i20;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v26 */
    @Override // p110k.AbstractC1614r0, android.view.View
    public final void onMeasure(int i3, int i4) {
        int i5;
        int i6;
        int i7;
        boolean z3;
        int i8;
        int i9;
        int i10;
        int i11;
        ?? r12;
        int i12;
        int i13;
        int i14;
        MenuC1479m menuC1479m;
        boolean z4 = this.f2738A;
        boolean z5 = View.MeasureSpec.getMode(i3) == 1073741824;
        this.f2738A = z5;
        if (z4 != z5) {
            this.f2739B = 0;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (this.f2738A && (menuC1479m = this.f2743t) != null && size != this.f2739B) {
            this.f2739B = size;
            menuC1479m.m3518p(true);
        }
        int childCount = getChildCount();
        if (!this.f2738A || childCount <= 0) {
            for (int i15 = 0; i15 < childCount; i15++) {
                C1599k c1599k = (C1599k) getChildAt(i15).getLayoutParams();
                ((LinearLayout.LayoutParams) c1599k).rightMargin = 0;
                ((LinearLayout.LayoutParams) c1599k).leftMargin = 0;
            }
            super.onMeasure(i3, i4);
            return;
        }
        int mode = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i3);
        int size3 = View.MeasureSpec.getSize(i4);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, paddingBottom, -2);
        int i16 = size2 - paddingRight;
        int i17 = this.f2740C;
        int i18 = i16 / i17;
        int i19 = i16 % i17;
        if (i18 == 0) {
            setMeasuredDimension(i16, 0);
            return;
        }
        int i20 = (i19 / i18) + i17;
        int childCount2 = getChildCount();
        int i21 = 0;
        int iMax = 0;
        int i22 = 0;
        boolean z6 = false;
        int i23 = 0;
        int iMax2 = 0;
        long j2 = 0;
        while (true) {
            i5 = this.f2741D;
            if (i22 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i22);
            int i24 = size3;
            if (childAt.getVisibility() == 8) {
                i12 = i16;
                i13 = paddingBottom;
            } else {
                boolean z7 = childAt instanceof ActionMenuItemView;
                int i25 = i21 + 1;
                if (z7) {
                    childAt.setPadding(i5, 0, i5, 0);
                }
                C1599k c1599k2 = (C1599k) childAt.getLayoutParams();
                c1599k2.f5673f = false;
                c1599k2.f5670c = 0;
                c1599k2.f5669b = 0;
                c1599k2.f5671d = false;
                ((LinearLayout.LayoutParams) c1599k2).leftMargin = 0;
                ((LinearLayout.LayoutParams) c1599k2).rightMargin = 0;
                c1599k2.f5672e = z7 && (TextUtils.isEmpty(((ActionMenuItemView) childAt).getText()) ^ true);
                int i26 = c1599k2.f5668a ? 1 : i18;
                C1599k c1599k3 = (C1599k) childAt.getLayoutParams();
                i12 = i16;
                i13 = paddingBottom;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z7 ? (ActionMenuItemView) childAt : null;
                boolean z8 = actionMenuItemView != null && (TextUtils.isEmpty(actionMenuItemView.getText()) ^ true);
                if (i26 <= 0 || (z8 && i26 < 2)) {
                    i14 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i26 * i20, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i14 = measuredWidth / i20;
                    if (measuredWidth % i20 != 0) {
                        i14++;
                    }
                    if (z8 && i14 < 2) {
                        i14 = 2;
                    }
                }
                c1599k3.f5671d = !c1599k3.f5668a && z8;
                c1599k3.f5669b = i14;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i14 * i20, 1073741824), iMakeMeasureSpec);
                iMax = Math.max(iMax, i14);
                if (c1599k2.f5671d) {
                    i23++;
                }
                if (c1599k2.f5668a) {
                    z6 = true;
                }
                i18 -= i14;
                iMax2 = Math.max(iMax2, childAt.getMeasuredHeight());
                if (i14 == 1) {
                    j2 |= (long) (1 << i22);
                }
                i21 = i25;
            }
            i22++;
            size3 = i24;
            paddingBottom = i13;
            i16 = i12;
        }
        int i27 = i16;
        int i28 = size3;
        int i29 = iMax2;
        boolean z9 = z6 && i21 == 2;
        boolean z10 = false;
        while (i23 > 0 && i18 > 0) {
            int i30 = Integer.MAX_VALUE;
            int i31 = 0;
            int i32 = 0;
            long j3 = 0;
            while (i32 < childCount2) {
                int i33 = i29;
                C1599k c1599k4 = (C1599k) getChildAt(i32).getLayoutParams();
                boolean z11 = z10;
                if (c1599k4.f5671d) {
                    int i34 = c1599k4.f5669b;
                    if (i34 < i30) {
                        j3 = 1 << i32;
                        i30 = i34;
                        i31 = 1;
                    } else if (i34 == i30) {
                        i31++;
                        j3 |= 1 << i32;
                    }
                }
                i32++;
                z10 = z11;
                i29 = i33;
            }
            i7 = i29;
            z3 = z10;
            j2 |= j3;
            if (i31 > i18) {
                i6 = mode;
                break;
            }
            int i35 = i30 + 1;
            int i36 = 0;
            while (i36 < childCount2) {
                View childAt2 = getChildAt(i36);
                C1599k c1599k5 = (C1599k) childAt2.getLayoutParams();
                int i37 = mode;
                int i38 = childMeasureSpec;
                int i39 = childCount2;
                long j4 = 1 << i36;
                if ((j3 & j4) != 0) {
                    if (z9 && c1599k5.f5672e) {
                        r12 = 1;
                        r12 = 1;
                        if (i18 == 1) {
                            childAt2.setPadding(i5 + i20, 0, i5, 0);
                        }
                    } else {
                        r12 = 1;
                    }
                    c1599k5.f5669b += r12;
                    c1599k5.f5673f = r12;
                    i18--;
                } else if (c1599k5.f5669b == i35) {
                    j2 |= j4;
                }
                i36++;
                childMeasureSpec = i38;
                mode = i37;
                childCount2 = i39;
            }
            i29 = i7;
            z10 = true;
        }
        i6 = mode;
        i7 = i29;
        z3 = z10;
        int i40 = childMeasureSpec;
        int i41 = childCount2;
        boolean z12 = !z6 && i21 == 1;
        if (i18 <= 0 || j2 == 0 || (i18 >= i21 - 1 && !z12 && iMax <= 1)) {
            i8 = i41;
        } else {
            float fBitCount = Long.bitCount(j2);
            if (!z12) {
                if ((j2 & 1) != 0 && !((C1599k) getChildAt(0).getLayoutParams()).f5672e) {
                    fBitCount -= 0.5f;
                }
                int i42 = i41 - 1;
                if ((j2 & ((long) (1 << i42))) != 0 && !((C1599k) getChildAt(i42).getLayoutParams()).f5672e) {
                    fBitCount -= 0.5f;
                }
            }
            int i43 = fBitCount > 0.0f ? (int) ((i18 * i20) / fBitCount) : 0;
            i8 = i41;
            for (int i44 = 0; i44 < i8; i44++) {
                if ((j2 & ((long) (1 << i44))) != 0) {
                    View childAt3 = getChildAt(i44);
                    C1599k c1599k6 = (C1599k) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c1599k6.f5670c = i43;
                        c1599k6.f5673f = true;
                        if (i44 == 0 && !c1599k6.f5672e) {
                            ((LinearLayout.LayoutParams) c1599k6).leftMargin = (-i43) / 2;
                        }
                        z3 = true;
                    } else if (c1599k6.f5668a) {
                        c1599k6.f5670c = i43;
                        c1599k6.f5673f = true;
                        ((LinearLayout.LayoutParams) c1599k6).rightMargin = (-i43) / 2;
                        z3 = true;
                    } else {
                        if (i44 != 0) {
                            ((LinearLayout.LayoutParams) c1599k6).leftMargin = i43 / 2;
                        }
                        if (i44 != i8 - 1) {
                            ((LinearLayout.LayoutParams) c1599k6).rightMargin = i43 / 2;
                        }
                    }
                }
            }
        }
        if (z3) {
            int i45 = 0;
            while (i45 < i8) {
                View childAt4 = getChildAt(i45);
                C1599k c1599k7 = (C1599k) childAt4.getLayoutParams();
                if (c1599k7.f5673f) {
                    i11 = i40;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((c1599k7.f5669b * i20) + c1599k7.f5670c, 1073741824), i11);
                } else {
                    i11 = i40;
                }
                i45++;
                i40 = i11;
            }
        }
        if (i6 != 1073741824) {
            i10 = i27;
            i9 = i7;
        } else {
            i9 = i28;
            i10 = i27;
        }
        setMeasuredDimension(i10, i9);
    }

    public void setExpandedActionViewsExclusive(boolean z3) {
        this.f2747x.f5657u = z3;
    }

    public void setOnMenuItemClickListener(InterfaceC1601l interfaceC1601l) {
        this.f2742E = interfaceC1601l;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        C1594i c1594i = this.f2747x;
        C1591h c1591h = c1594i.f5649m;
        if (c1591h != null) {
            c1591h.setImageDrawable(drawable);
        } else {
            c1594i.f5651o = true;
            c1594i.f5650n = drawable;
        }
    }

    public void setOverflowReserved(boolean z3) {
        this.f2746w = z3;
    }

    public void setPopupTheme(int i3) {
        if (this.f2745v != i3) {
            this.f2745v = i3;
            if (i3 == 0) {
                this.f2744u = getContext();
            } else {
                this.f2744u = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    public void setPresenter(C1594i c1594i) {
        this.f2747x = c1594i;
        c1594i.f5648l = this;
        this.f2743t = c1594i.f5643g;
    }

    @Override // p110k.AbstractC1614r0, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C1599k(getContext(), attributeSet);
    }
}
