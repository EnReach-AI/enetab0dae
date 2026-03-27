package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p007B1.RunnableC0055o;
import p019F0.C0221e;
import p024H0.ViewOnClickListenerC0250d;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p029J.AbstractC0353l;
import p036L0.C0444d;
import p094f.AbstractC1343a;
import p105i.C1442j;
import p108j.C1481o;
import p108j.MenuC1479m;
import p110k.AbstractC1587f1;
import p110k.AbstractC1596i1;
import p110k.C1536I0;
import p110k.C1564X;
import p110k.C1569Z0;
import p110k.C1572a1;
import p110k.C1578c1;
import p110k.C1584e1;
import p110k.C1594i;
import p110k.C1621v;
import p110k.InterfaceC1575b1;
import p110k.InterfaceC1586f0;
import p110k.ViewOnClickListenerC1581d1;
import p125o0.AbstractC1800j;
import p166z0.C2071i;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* JADX INFO: renamed from: A */
    public final int f2810A;

    /* JADX INFO: renamed from: B */
    public CharSequence f2811B;

    /* JADX INFO: renamed from: C */
    public CharSequence f2812C;

    /* JADX INFO: renamed from: D */
    public ColorStateList f2813D;

    /* JADX INFO: renamed from: E */
    public ColorStateList f2814E;

    /* JADX INFO: renamed from: F */
    public boolean f2815F;

    /* JADX INFO: renamed from: G */
    public boolean f2816G;

    /* JADX INFO: renamed from: H */
    public final ArrayList f2817H;

    /* JADX INFO: renamed from: I */
    public final ArrayList f2818I;

    /* JADX INFO: renamed from: J */
    public final int[] f2819J;

    /* JADX INFO: renamed from: K */
    public final C0444d f2820K;

    /* JADX INFO: renamed from: L */
    public final C0444d f2821L;

    /* JADX INFO: renamed from: M */
    public C1584e1 f2822M;

    /* JADX INFO: renamed from: N */
    public C1594i f2823N;

    /* JADX INFO: renamed from: O */
    public C1569Z0 f2824O;

    /* JADX INFO: renamed from: P */
    public boolean f2825P;

    /* JADX INFO: renamed from: Q */
    public OnBackInvokedCallback f2826Q;

    /* JADX INFO: renamed from: R */
    public OnBackInvokedDispatcher f2827R;

    /* JADX INFO: renamed from: S */
    public boolean f2828S;

    /* JADX INFO: renamed from: T */
    public final RunnableC0055o f2829T;

    /* JADX INFO: renamed from: e */
    public ActionMenuView f2830e;

    /* JADX INFO: renamed from: f */
    public C1564X f2831f;

    /* JADX INFO: renamed from: g */
    public C1564X f2832g;

    /* JADX INFO: renamed from: h */
    public C1621v f2833h;

    /* JADX INFO: renamed from: i */
    public AppCompatImageView f2834i;

    /* JADX INFO: renamed from: j */
    public final Drawable f2835j;

    /* JADX INFO: renamed from: k */
    public final CharSequence f2836k;

    /* JADX INFO: renamed from: l */
    public C1621v f2837l;

    /* JADX INFO: renamed from: m */
    public View f2838m;

    /* JADX INFO: renamed from: n */
    public Context f2839n;

    /* JADX INFO: renamed from: o */
    public int f2840o;

    /* JADX INFO: renamed from: p */
    public int f2841p;

    /* JADX INFO: renamed from: q */
    public int f2842q;

    /* JADX INFO: renamed from: r */
    public final int f2843r;

    /* JADX INFO: renamed from: s */
    public final int f2844s;

    /* JADX INFO: renamed from: t */
    public int f2845t;

    /* JADX INFO: renamed from: u */
    public int f2846u;

    /* JADX INFO: renamed from: v */
    public int f2847v;

    /* JADX INFO: renamed from: w */
    public int f2848w;

    /* JADX INFO: renamed from: x */
    public C1536I0 f2849x;

    /* JADX INFO: renamed from: y */
    public int f2850y;

    /* JADX INFO: renamed from: z */
    public int f2851z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i3 = 0; i3 < menu.size(); i3++) {
            arrayList.add(menu.getItem(i3));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new C1442j(getContext());
    }

    /* JADX INFO: renamed from: h */
    public static C1572a1 m2265h() {
        C1572a1 c1572a1 = new C1572a1(-2, -2);
        c1572a1.f5597b = 0;
        c1572a1.f5596a = 8388627;
        return c1572a1;
    }

    /* JADX INFO: renamed from: i */
    public static C1572a1 m2266i(ViewGroup.LayoutParams layoutParams) {
        boolean z3 = layoutParams instanceof C1572a1;
        if (z3) {
            C1572a1 c1572a1 = (C1572a1) layoutParams;
            C1572a1 c1572a12 = new C1572a1(c1572a1);
            c1572a12.f5597b = 0;
            c1572a12.f5597b = c1572a1.f5597b;
            return c1572a12;
        }
        if (z3) {
            C1572a1 c1572a13 = new C1572a1((C1572a1) layoutParams);
            c1572a13.f5597b = 0;
            return c1572a13;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            C1572a1 c1572a14 = new C1572a1(layoutParams);
            c1572a14.f5597b = 0;
            return c1572a14;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        C1572a1 c1572a15 = new C1572a1(marginLayoutParams);
        c1572a15.f5597b = 0;
        ((ViewGroup.MarginLayoutParams) c1572a15).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) c1572a15).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) c1572a15).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) c1572a15).bottomMargin = marginLayoutParams.bottomMargin;
        return c1572a15;
    }

    /* JADX INFO: renamed from: l */
    public static int m2267l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return AbstractC0353l.m770b(marginLayoutParams) + AbstractC0353l.m771c(marginLayoutParams);
    }

    /* JADX INFO: renamed from: m */
    public static int m2268m(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* JADX INFO: renamed from: a */
    public final void m2269a(ArrayList arrayList, int i3) {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        boolean z3 = AbstractC0308C.m607d(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i3, AbstractC0308C.m607d(this));
        arrayList.clear();
        if (!z3) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                C1572a1 c1572a1 = (C1572a1) childAt.getLayoutParams();
                if (c1572a1.f5597b == 0 && m2283s(childAt) && m2276j(c1572a1.f5596a) == absoluteGravity) {
                    arrayList.add(childAt);
                }
            }
            return;
        }
        for (int i5 = childCount - 1; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            C1572a1 c1572a12 = (C1572a1) childAt2.getLayoutParams();
            if (c1572a12.f5597b == 0 && m2283s(childAt2) && m2276j(c1572a12.f5596a) == absoluteGravity) {
                arrayList.add(childAt2);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2270b(View view, boolean z3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        C1572a1 c1572a1M2265h = layoutParams == null ? m2265h() : !checkLayoutParams(layoutParams) ? m2266i(layoutParams) : (C1572a1) layoutParams;
        c1572a1M2265h.f5597b = 1;
        if (!z3 || this.f2838m == null) {
            addView(view, c1572a1M2265h);
        } else {
            view.setLayoutParams(c1572a1M2265h);
            this.f2818I.add(view);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m2271c() {
        if (this.f2837l == null) {
            C1621v c1621v = new C1621v(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f2837l = c1621v;
            c1621v.setImageDrawable(this.f2835j);
            this.f2837l.setContentDescription(this.f2836k);
            C1572a1 c1572a1M2265h = m2265h();
            c1572a1M2265h.f5596a = (this.f2843r & 112) | 8388611;
            c1572a1M2265h.f5597b = 2;
            this.f2837l.setLayoutParams(c1572a1M2265h);
            this.f2837l.setOnClickListener(new ViewOnClickListenerC0250d(6, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C1572a1);
    }

    /* JADX INFO: renamed from: d */
    public final void m2272d() {
        if (this.f2849x == null) {
            C1536I0 c1536i0 = new C1536I0();
            c1536i0.f5499a = 0;
            c1536i0.f5500b = 0;
            c1536i0.f5501c = Integer.MIN_VALUE;
            c1536i0.f5502d = Integer.MIN_VALUE;
            c1536i0.f5503e = 0;
            c1536i0.f5504f = 0;
            c1536i0.f5505g = false;
            c1536i0.f5506h = false;
            this.f2849x = c1536i0;
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m2273e() {
        m2274f();
        ActionMenuView actionMenuView = this.f2830e;
        if (actionMenuView.f2743t == null) {
            MenuC1479m menuC1479m = (MenuC1479m) actionMenuView.getMenu();
            if (this.f2824O == null) {
                this.f2824O = new C1569Z0(this);
            }
            this.f2830e.setExpandedActionViewsExclusive(true);
            menuC1479m.m3512b(this.f2824O, this.f2839n);
            m2284t();
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m2274f() {
        if (this.f2830e == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f2830e = actionMenuView;
            actionMenuView.setPopupTheme(this.f2840o);
            this.f2830e.setOnMenuItemClickListener(this.f2821L);
            ActionMenuView actionMenuView2 = this.f2830e;
            C0221e c0221e = new C0221e(19, this);
            actionMenuView2.f2748y = null;
            actionMenuView2.f2749z = c0221e;
            C1572a1 c1572a1M2265h = m2265h();
            c1572a1M2265h.f5596a = (this.f2843r & 112) | 8388613;
            this.f2830e.setLayoutParams(c1572a1M2265h);
            m2270b(this.f2830e, false);
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m2275g() {
        if (this.f2833h == null) {
            this.f2833h = new C1621v(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            C1572a1 c1572a1M2265h = m2265h();
            c1572a1M2265h.f5596a = (this.f2843r & 112) | 8388611;
            this.f2833h.setLayoutParams(c1572a1M2265h);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m2265h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m2266i(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        C1621v c1621v = this.f2837l;
        if (c1621v != null) {
            return c1621v.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        C1621v c1621v = this.f2837l;
        if (c1621v != null) {
            return c1621v.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        C1536I0 c1536i0 = this.f2849x;
        if (c1536i0 != null) {
            return c1536i0.f5505g ? c1536i0.f5499a : c1536i0.f5500b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i3 = this.f2851z;
        return i3 != Integer.MIN_VALUE ? i3 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        C1536I0 c1536i0 = this.f2849x;
        if (c1536i0 != null) {
            return c1536i0.f5499a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        C1536I0 c1536i0 = this.f2849x;
        if (c1536i0 != null) {
            return c1536i0.f5500b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        C1536I0 c1536i0 = this.f2849x;
        if (c1536i0 != null) {
            return c1536i0.f5505g ? c1536i0.f5500b : c1536i0.f5499a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i3 = this.f2850y;
        return i3 != Integer.MIN_VALUE ? i3 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuC1479m menuC1479m;
        ActionMenuView actionMenuView = this.f2830e;
        return (actionMenuView == null || (menuC1479m = actionMenuView.f2743t) == null || !menuC1479m.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f2851z, 0));
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        return AbstractC0308C.m607d(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        return AbstractC0308C.m607d(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f2850y, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        AppCompatImageView appCompatImageView = this.f2834i;
        if (appCompatImageView != null) {
            return appCompatImageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        AppCompatImageView appCompatImageView = this.f2834i;
        if (appCompatImageView != null) {
            return appCompatImageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        m2273e();
        return this.f2830e.getMenu();
    }

    public View getNavButtonView() {
        return this.f2833h;
    }

    public CharSequence getNavigationContentDescription() {
        C1621v c1621v = this.f2833h;
        if (c1621v != null) {
            return c1621v.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        C1621v c1621v = this.f2833h;
        if (c1621v != null) {
            return c1621v.getDrawable();
        }
        return null;
    }

    public C1594i getOuterActionMenuPresenter() {
        return this.f2823N;
    }

    public Drawable getOverflowIcon() {
        m2273e();
        return this.f2830e.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f2839n;
    }

    public int getPopupTheme() {
        return this.f2840o;
    }

    public CharSequence getSubtitle() {
        return this.f2812C;
    }

    public final TextView getSubtitleTextView() {
        return this.f2832g;
    }

    public CharSequence getTitle() {
        return this.f2811B;
    }

    public int getTitleMarginBottom() {
        return this.f2848w;
    }

    public int getTitleMarginEnd() {
        return this.f2846u;
    }

    public int getTitleMarginStart() {
        return this.f2845t;
    }

    public int getTitleMarginTop() {
        return this.f2847v;
    }

    public final TextView getTitleTextView() {
        return this.f2831f;
    }

    public InterfaceC1586f0 getWrapper() {
        Drawable drawable;
        if (this.f2822M == null) {
            C1584e1 c1584e1 = new C1584e1();
            c1584e1.f5631n = 0;
            c1584e1.f5618a = this;
            c1584e1.f5625h = getTitle();
            c1584e1.f5626i = getSubtitle();
            c1584e1.f5624g = c1584e1.f5625h != null;
            c1584e1.f5623f = getNavigationIcon();
            C2071i c2071iM4591v = C2071i.m4591v(getContext(), null, AbstractC1343a.f4777a, R.attr.actionBarStyle, 0);
            c1584e1.f5632o = c2071iM4591v.m4601l(15);
            TypedArray typedArray = (TypedArray) c2071iM4591v.f7315b;
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                c1584e1.f5624g = true;
                c1584e1.f5625h = text;
                if ((c1584e1.f5619b & 8) != 0) {
                    Toolbar toolbar = c1584e1.f5618a;
                    toolbar.setTitle(text);
                    if (c1584e1.f5624g) {
                        AbstractC0323S.m702l(toolbar.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                c1584e1.f5626i = text2;
                if ((c1584e1.f5619b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable drawableM4601l = c2071iM4591v.m4601l(20);
            if (drawableM4601l != null) {
                c1584e1.f5622e = drawableM4601l;
                c1584e1.m3649c();
            }
            Drawable drawableM4601l2 = c2071iM4591v.m4601l(17);
            if (drawableM4601l2 != null) {
                c1584e1.f5621d = drawableM4601l2;
                c1584e1.m3649c();
            }
            if (c1584e1.f5623f == null && (drawable = c1584e1.f5632o) != null) {
                c1584e1.f5623f = drawable;
                int i3 = c1584e1.f5619b & 4;
                Toolbar toolbar2 = c1584e1.f5618a;
                if (i3 != 0) {
                    toolbar2.setNavigationIcon(drawable);
                } else {
                    toolbar2.setNavigationIcon((Drawable) null);
                }
            }
            c1584e1.m3647a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = c1584e1.f5620c;
                if (view != null && (c1584e1.f5619b & 16) != 0) {
                    removeView(view);
                }
                c1584e1.f5620c = viewInflate;
                if (viewInflate != null && (c1584e1.f5619b & 16) != 0) {
                    addView(viewInflate);
                }
                c1584e1.m3647a(c1584e1.f5619b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = layoutDimension;
                setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int iMax = Math.max(dimensionPixelOffset, 0);
                int iMax2 = Math.max(dimensionPixelOffset2, 0);
                m2272d();
                this.f2849x.m3600a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = getContext();
                this.f2841p = resourceId2;
                C1564X c1564x = this.f2831f;
                if (c1564x != null) {
                    c1564x.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = getContext();
                this.f2842q = resourceId3;
                C1564X c1564x2 = this.f2832g;
                if (c1564x2 != null) {
                    c1564x2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            c2071iM4591v.m4608x();
            if (R.string.abc_action_bar_up_description != c1584e1.f5631n) {
                c1584e1.f5631n = R.string.abc_action_bar_up_description;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i4 = c1584e1.f5631n;
                    c1584e1.f5627j = i4 != 0 ? getContext().getString(i4) : null;
                    c1584e1.m3648b();
                }
            }
            c1584e1.f5627j = getNavigationContentDescription();
            setNavigationOnClickListener(new ViewOnClickListenerC1581d1(c1584e1));
            this.f2822M = c1584e1;
        }
        return this.f2822M;
    }

    /* JADX INFO: renamed from: j */
    public final int m2276j(int i3) {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        int iM607d = AbstractC0308C.m607d(this);
        int absoluteGravity = Gravity.getAbsoluteGravity(i3, iM607d) & 7;
        return (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) ? absoluteGravity : iM607d == 1 ? 5 : 3;
    }

    /* JADX INFO: renamed from: k */
    public final int m2277k(View view, int i3) {
        C1572a1 c1572a1 = (C1572a1) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i3 > 0 ? (measuredHeight - i3) / 2 : 0;
        int i5 = c1572a1.f5596a & 112;
        if (i5 != 16 && i5 != 48 && i5 != 80) {
            i5 = this.f2810A & 112;
        }
        if (i5 == 48) {
            return getPaddingTop() - i4;
        }
        if (i5 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) c1572a1).bottomMargin) - i4;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i6 = ((ViewGroup.MarginLayoutParams) c1572a1).topMargin;
        if (iMax < i6) {
            iMax = i6;
        } else {
            int i7 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i8 = ((ViewGroup.MarginLayoutParams) c1572a1).bottomMargin;
            if (i7 < i8) {
                iMax = Math.max(0, iMax - (i8 - i7));
            }
        }
        return paddingTop + iMax;
    }

    /* JADX INFO: renamed from: n */
    public final boolean m2278n(View view) {
        return view.getParent() == this || this.f2818I.contains(view);
    }

    /* JADX INFO: renamed from: o */
    public final int m2279o(View view, int i3, int i4, int[] iArr) {
        C1572a1 c1572a1 = (C1572a1) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) c1572a1).leftMargin - iArr[0];
        int iMax = Math.max(0, i5) + i3;
        iArr[0] = Math.max(0, -i5);
        int iM2277k = m2277k(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iM2277k, iMax + measuredWidth, view.getMeasuredHeight() + iM2277k);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) c1572a1).rightMargin + iMax;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m2284t();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2829T);
        m2284t();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2816G = false;
        }
        if (!this.f2816G) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f2816G = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2816G = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x029b A[LOOP:0: B:106:0x0299->B:107:0x029b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02b8 A[LOOP:1: B:109:0x02b6->B:110:0x02b8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d6 A[LOOP:2: B:112:0x02d4->B:113:0x02d6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0325 A[LOOP:3: B:121:0x0323->B:122:0x0325, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0222  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 822
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i4) {
        int iM2267l;
        int iMax;
        int iCombineMeasuredStates;
        int iM2267l2;
        int iM2268m;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean zM3658a = AbstractC1596i1.m3658a(this);
        int i5 = !zM3658a ? 1 : 0;
        int i6 = 0;
        if (m2283s(this.f2833h)) {
            m2282r(this.f2833h, i3, 0, i4, this.f2844s);
            iM2267l = m2267l(this.f2833h) + this.f2833h.getMeasuredWidth();
            iMax = Math.max(0, m2268m(this.f2833h) + this.f2833h.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f2833h.getMeasuredState());
        } else {
            iM2267l = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (m2283s(this.f2837l)) {
            m2282r(this.f2837l, i3, 0, i4, this.f2844s);
            iM2267l = m2267l(this.f2837l) + this.f2837l.getMeasuredWidth();
            iMax = Math.max(iMax, m2268m(this.f2837l) + this.f2837l.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2837l.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iM2267l);
        int iMax4 = Math.max(0, currentContentInsetStart - iM2267l);
        int[] iArr = this.f2819J;
        iArr[zM3658a ? 1 : 0] = iMax4;
        if (m2283s(this.f2830e)) {
            m2282r(this.f2830e, i3, iMax3, i4, this.f2844s);
            iM2267l2 = m2267l(this.f2830e) + this.f2830e.getMeasuredWidth();
            iMax = Math.max(iMax, m2268m(this.f2830e) + this.f2830e.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2830e.getMeasuredState());
        } else {
            iM2267l2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iM2267l2);
        iArr[i5] = Math.max(0, currentContentInsetEnd - iM2267l2);
        if (m2283s(this.f2838m)) {
            iMax5 += m2281q(this.f2838m, i3, iMax5, i4, 0, iArr);
            iMax = Math.max(iMax, m2268m(this.f2838m) + this.f2838m.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2838m.getMeasuredState());
        }
        if (m2283s(this.f2834i)) {
            iMax5 += m2281q(this.f2834i, i3, iMax5, i4, 0, iArr);
            iMax = Math.max(iMax, m2268m(this.f2834i) + this.f2834i.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2834i.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (((C1572a1) childAt.getLayoutParams()).f5597b == 0 && m2283s(childAt)) {
                iMax5 += m2281q(childAt, i3, iMax5, i4, 0, iArr);
                iMax = Math.max(iMax, m2268m(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i8 = this.f2847v + this.f2848w;
        int i9 = this.f2845t + this.f2846u;
        if (m2283s(this.f2831f)) {
            m2281q(this.f2831f, i3, iMax5 + i9, i4, i8, iArr);
            int iM2267l3 = m2267l(this.f2831f) + this.f2831f.getMeasuredWidth();
            iM2268m = m2268m(this.f2831f) + this.f2831f.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2831f.getMeasuredState());
            iMax2 = iM2267l3;
        } else {
            iM2268m = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (m2283s(this.f2832g)) {
            iMax2 = Math.max(iMax2, m2281q(this.f2832g, i3, iMax5 + i9, i4, iM2268m + i8, iArr));
            iM2268m += m2268m(this.f2832g) + this.f2832g.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f2832g.getMeasuredState());
        }
        int iMax6 = Math.max(iMax, iM2268m);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax6;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + iMax5 + iMax2, getSuggestedMinimumWidth()), i3, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i4, iCombineMeasuredStates2 << 16);
        if (!this.f2825P) {
            i6 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i10 = 0; i10 < childCount2; i10++) {
            View childAt2 = getChildAt(i10);
            if (m2283s(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i6 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i6);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof C1578c1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C1578c1 c1578c1 = (C1578c1) parcelable;
        super.onRestoreInstanceState(c1578c1.f1425e);
        ActionMenuView actionMenuView = this.f2830e;
        MenuC1479m menuC1479m = actionMenuView != null ? actionMenuView.f2743t : null;
        int i3 = c1578c1.f5612g;
        if (i3 != 0 && this.f2824O != null && menuC1479m != null && (menuItemFindItem = menuC1479m.findItem(i3)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (c1578c1.f5613h) {
            RunnableC0055o runnableC0055o = this.f2829T;
            removeCallbacks(runnableC0055o);
            post(runnableC0055o);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        m2272d();
        C1536I0 c1536i0 = this.f2849x;
        boolean z3 = i3 == 1;
        if (z3 == c1536i0.f5505g) {
            return;
        }
        c1536i0.f5505g = z3;
        if (!c1536i0.f5506h) {
            c1536i0.f5499a = c1536i0.f5503e;
            c1536i0.f5500b = c1536i0.f5504f;
            return;
        }
        if (z3) {
            int i4 = c1536i0.f5502d;
            if (i4 == Integer.MIN_VALUE) {
                i4 = c1536i0.f5503e;
            }
            c1536i0.f5499a = i4;
            int i5 = c1536i0.f5501c;
            if (i5 == Integer.MIN_VALUE) {
                i5 = c1536i0.f5504f;
            }
            c1536i0.f5500b = i5;
            return;
        }
        int i6 = c1536i0.f5501c;
        if (i6 == Integer.MIN_VALUE) {
            i6 = c1536i0.f5503e;
        }
        c1536i0.f5499a = i6;
        int i7 = c1536i0.f5502d;
        if (i7 == Integer.MIN_VALUE) {
            i7 = c1536i0.f5504f;
        }
        c1536i0.f5500b = i7;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C1594i c1594i;
        C1481o c1481o;
        C1578c1 c1578c1 = new C1578c1(super.onSaveInstanceState());
        C1569Z0 c1569z0 = this.f2824O;
        if (c1569z0 != null && (c1481o = c1569z0.f5593f) != null) {
            c1578c1.f5612g = c1481o.f5374a;
        }
        ActionMenuView actionMenuView = this.f2830e;
        c1578c1.f5613h = (actionMenuView == null || (c1594i = actionMenuView.f2747x) == null || !c1594i.m3656j()) ? false : true;
        return c1578c1;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2815F = false;
        }
        if (!this.f2815F) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f2815F = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2815F = false;
        }
        return true;
    }

    /* JADX INFO: renamed from: p */
    public final int m2280p(View view, int i3, int i4, int[] iArr) {
        C1572a1 c1572a1 = (C1572a1) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) c1572a1).rightMargin - iArr[1];
        int iMax = i3 - Math.max(0, i5);
        iArr[1] = Math.max(0, -i5);
        int iM2277k = m2277k(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iM2277k, iMax, view.getMeasuredHeight() + iM2277k);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) c1572a1).leftMargin);
    }

    /* JADX INFO: renamed from: q */
    public final int m2281q(View view, int i3, int i4, int i5, int i6, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i7 = marginLayoutParams.leftMargin - iArr[0];
        int i8 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i8) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i7);
        iArr[1] = Math.max(0, -i8);
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingRight() + getPaddingLeft() + iMax + i4, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i5, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    /* JADX INFO: renamed from: r */
    public final void m2282r(View view, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i5, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* JADX INFO: renamed from: s */
    public final boolean m2283s(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void setBackInvokedCallbackEnabled(boolean z3) {
        if (this.f2828S != z3) {
            this.f2828S = z3;
            m2284t();
        }
    }

    public void setCollapseContentDescription(int i3) {
        setCollapseContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setCollapseIcon(int i3) {
        setCollapseIcon(AbstractC1800j.m3991i(getContext(), i3));
    }

    public void setCollapsible(boolean z3) {
        this.f2825P = z3;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.f2851z) {
            this.f2851z = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.f2850y) {
            this.f2850y = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i3) {
        setLogo(AbstractC1800j.m3991i(getContext(), i3));
    }

    public void setLogoDescription(int i3) {
        setLogoDescription(getContext().getText(i3));
    }

    public void setNavigationContentDescription(int i3) {
        setNavigationContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setNavigationIcon(int i3) {
        setNavigationIcon(AbstractC1800j.m3991i(getContext(), i3));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m2275g();
        this.f2833h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(InterfaceC1575b1 interfaceC1575b1) {
    }

    public void setOverflowIcon(Drawable drawable) {
        m2273e();
        this.f2830e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i3) {
        if (this.f2840o != i3) {
            this.f2840o = i3;
            if (i3 == 0) {
                this.f2839n = getContext();
            } else {
                this.f2839n = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    public void setSubtitle(int i3) {
        setSubtitle(getContext().getText(i3));
    }

    public void setSubtitleTextColor(int i3) {
        setSubtitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setTitle(int i3) {
        setTitle(getContext().getText(i3));
    }

    public void setTitleMarginBottom(int i3) {
        this.f2848w = i3;
        requestLayout();
    }

    public void setTitleMarginEnd(int i3) {
        this.f2846u = i3;
        requestLayout();
    }

    public void setTitleMarginStart(int i3) {
        this.f2845t = i3;
        requestLayout();
    }

    public void setTitleMarginTop(int i3) {
        this.f2847v = i3;
        requestLayout();
    }

    public void setTitleTextColor(int i3) {
        setTitleTextColor(ColorStateList.valueOf(i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX INFO: renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2284t() {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            if (r0 < r1) goto L50
            android.window.OnBackInvokedDispatcher r0 = p110k.AbstractC1567Y0.m3638a(r3)
            k.Z0 r1 = r3.f2824O
            if (r1 == 0) goto L22
            j.o r1 = r1.f5593f
            if (r1 == 0) goto L22
            if (r0 == 0) goto L22
            java.util.WeakHashMap r1 = p029J.AbstractC0323S.f816a
            boolean r1 = p029J.AbstractC0310E.m619b(r3)
            if (r1 == 0) goto L22
            boolean r1 = r3.f2828S
            if (r1 == 0) goto L22
            r1 = 1
            goto L23
        L22:
            r1 = 0
        L23:
            if (r1 == 0) goto L42
            android.window.OnBackInvokedDispatcher r2 = r3.f2827R
            if (r2 != 0) goto L42
            android.window.OnBackInvokedCallback r1 = r3.f2826Q
            if (r1 != 0) goto L3a
            I1.d r1 = new I1.d
            r2 = 9
            r1.<init>(r2, r3)
            android.window.OnBackInvokedCallback r1 = p110k.AbstractC1567Y0.m3639b(r1)
            r3.f2826Q = r1
        L3a:
            android.window.OnBackInvokedCallback r1 = r3.f2826Q
            p110k.AbstractC1567Y0.m3640c(r0, r1)
            r3.f2827R = r0
            goto L50
        L42:
            if (r1 != 0) goto L50
            android.window.OnBackInvokedDispatcher r0 = r3.f2827R
            if (r0 == 0) goto L50
            android.window.OnBackInvokedCallback r1 = r3.f2826Q
            p110k.AbstractC1567Y0.m3641d(r0, r1)
            r0 = 0
            r3.f2827R = r0
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.m2284t():void");
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.f2810A = 8388627;
        this.f2817H = new ArrayList();
        this.f2818I = new ArrayList();
        this.f2819J = new int[2];
        this.f2820K = new C0444d(5);
        new ArrayList();
        this.f2821L = new C0444d(this);
        this.f2829T = new RunnableC0055o(16, this);
        Context context2 = getContext();
        int[] iArr = AbstractC1343a.f4800x;
        C2071i c2071iM4591v = C2071i.m4591v(context2, attributeSet, iArr, R.attr.toolbarStyle, 0);
        AbstractC0323S.m700j(this, context, iArr, attributeSet, (TypedArray) c2071iM4591v.f7315b, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) c2071iM4591v.f7315b;
        this.f2841p = typedArray.getResourceId(28, 0);
        this.f2842q = typedArray.getResourceId(19, 0);
        this.f2810A = typedArray.getInteger(0, 8388627);
        this.f2843r = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.f2848w = dimensionPixelOffset;
        this.f2847v = dimensionPixelOffset;
        this.f2846u = dimensionPixelOffset;
        this.f2845t = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f2845t = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f2846u = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f2847v = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f2848w = dimensionPixelOffset5;
        }
        this.f2844s = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        m2272d();
        C1536I0 c1536i0 = this.f2849x;
        c1536i0.f5506h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            c1536i0.f5503e = dimensionPixelSize;
            c1536i0.f5499a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            c1536i0.f5504f = dimensionPixelSize2;
            c1536i0.f5500b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            c1536i0.m3600a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f2850y = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f2851z = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f2835j = c2071iM4591v.m4601l(4);
        this.f2836k = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f2839n = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawableM4601l = c2071iM4591v.m4601l(16);
        if (drawableM4601l != null) {
            setNavigationIcon(drawableM4601l);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableM4601l2 = c2071iM4591v.m4601l(11);
        if (drawableM4601l2 != null) {
            setLogo(drawableM4601l2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(c2071iM4591v.m4600j(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(c2071iM4591v.m4600j(20));
        }
        if (typedArray.hasValue(14)) {
            getMenuInflater().inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        c2071iM4591v.m4608x();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        C1572a1 c1572a1 = new C1572a1(context, attributeSet);
        c1572a1.f5596a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1343a.f4778b);
        c1572a1.f5596a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        c1572a1.f5597b = 0;
        return c1572a1;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2271c();
        }
        C1621v c1621v = this.f2837l;
        if (c1621v != null) {
            c1621v.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            m2271c();
            this.f2837l.setImageDrawable(drawable);
        } else {
            C1621v c1621v = this.f2837l;
            if (c1621v != null) {
                c1621v.setImageDrawable(this.f2835j);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f2834i == null) {
                this.f2834i = new AppCompatImageView(getContext(), null);
            }
            if (!m2278n(this.f2834i)) {
                m2270b(this.f2834i, true);
            }
        } else {
            AppCompatImageView appCompatImageView = this.f2834i;
            if (appCompatImageView != null && m2278n(appCompatImageView)) {
                removeView(this.f2834i);
                this.f2818I.remove(this.f2834i);
            }
        }
        AppCompatImageView appCompatImageView2 = this.f2834i;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f2834i == null) {
            this.f2834i = new AppCompatImageView(getContext(), null);
        }
        AppCompatImageView appCompatImageView = this.f2834i;
        if (appCompatImageView != null) {
            appCompatImageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2275g();
        }
        C1621v c1621v = this.f2833h;
        if (c1621v != null) {
            c1621v.setContentDescription(charSequence);
            AbstractC1587f1.m3650a(this.f2833h, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m2275g();
            if (!m2278n(this.f2833h)) {
                m2270b(this.f2833h, true);
            }
        } else {
            C1621v c1621v = this.f2833h;
            if (c1621v != null && m2278n(c1621v)) {
                removeView(this.f2833h);
                this.f2818I.remove(this.f2833h);
            }
        }
        C1621v c1621v2 = this.f2833h;
        if (c1621v2 != null) {
            c1621v2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            C1564X c1564x = this.f2832g;
            if (c1564x != null && m2278n(c1564x)) {
                removeView(this.f2832g);
                this.f2818I.remove(this.f2832g);
            }
        } else {
            if (this.f2832g == null) {
                Context context = getContext();
                C1564X c1564x2 = new C1564X(context, null);
                this.f2832g = c1564x2;
                c1564x2.setSingleLine();
                this.f2832g.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.f2842q;
                if (i3 != 0) {
                    this.f2832g.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.f2814E;
                if (colorStateList != null) {
                    this.f2832g.setTextColor(colorStateList);
                }
            }
            if (!m2278n(this.f2832g)) {
                m2270b(this.f2832g, true);
            }
        }
        C1564X c1564x3 = this.f2832g;
        if (c1564x3 != null) {
            c1564x3.setText(charSequence);
        }
        this.f2812C = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f2814E = colorStateList;
        C1564X c1564x = this.f2832g;
        if (c1564x != null) {
            c1564x.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            C1564X c1564x = this.f2831f;
            if (c1564x != null && m2278n(c1564x)) {
                removeView(this.f2831f);
                this.f2818I.remove(this.f2831f);
            }
        } else {
            if (this.f2831f == null) {
                Context context = getContext();
                C1564X c1564x2 = new C1564X(context, null);
                this.f2831f = c1564x2;
                c1564x2.setSingleLine();
                this.f2831f.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.f2841p;
                if (i3 != 0) {
                    this.f2831f.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.f2813D;
                if (colorStateList != null) {
                    this.f2831f.setTextColor(colorStateList);
                }
            }
            if (!m2278n(this.f2831f)) {
                m2270b(this.f2831f, true);
            }
        }
        C1564X c1564x3 = this.f2831f;
        if (c1564x3 != null) {
            c1564x3.setText(charSequence);
        }
        this.f2811B = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f2813D = colorStateList;
        C1564X c1564x = this.f2831f;
        if (c1564x != null) {
            c1564x.setTextColor(colorStateList);
        }
    }
}
