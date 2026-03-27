package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p015D2.C0195s;
import p024H0.ViewOnClickListenerC0250d;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p029J.C0330Z;
import p094f.AbstractC1343a;
import p105i.AbstractC1434b;
import p108j.InterfaceC1462B;
import p108j.MenuC1479m;
import p110k.AbstractC1596i1;
import p110k.C1582e;
import p110k.C1594i;
import p125o0.AbstractC1800j;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* JADX INFO: renamed from: e */
    public final C0195s f2690e;

    /* JADX INFO: renamed from: f */
    public final Context f2691f;

    /* JADX INFO: renamed from: g */
    public ActionMenuView f2692g;

    /* JADX INFO: renamed from: h */
    public C1594i f2693h;

    /* JADX INFO: renamed from: i */
    public int f2694i;

    /* JADX INFO: renamed from: j */
    public C0330Z f2695j;

    /* JADX INFO: renamed from: k */
    public boolean f2696k;

    /* JADX INFO: renamed from: l */
    public boolean f2697l;

    /* JADX INFO: renamed from: m */
    public CharSequence f2698m;

    /* JADX INFO: renamed from: n */
    public CharSequence f2699n;

    /* JADX INFO: renamed from: o */
    public View f2700o;

    /* JADX INFO: renamed from: p */
    public View f2701p;

    /* JADX INFO: renamed from: q */
    public View f2702q;

    /* JADX INFO: renamed from: r */
    public LinearLayout f2703r;

    /* JADX INFO: renamed from: s */
    public TextView f2704s;

    /* JADX INFO: renamed from: t */
    public TextView f2705t;

    /* JADX INFO: renamed from: u */
    public final int f2706u;

    /* JADX INFO: renamed from: v */
    public final int f2707v;

    /* JADX INFO: renamed from: w */
    public boolean f2708w;

    /* JADX INFO: renamed from: x */
    public final int f2709x;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, R.attr.actionModeStyle);
        this.f2690e = new C0195s(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f2691f = context;
        } else {
            this.f2691f = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1343a.f4780d, R.attr.actionModeStyle, 0);
        Drawable drawable = (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : AbstractC1800j.m3991i(context, resourceId);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m601q(this, drawable);
        this.f2706u = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f2707v = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f2694i = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.f2709x = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: f */
    public static int m2228f(View view, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), i4);
        return Math.max(0, i3 - view.getMeasuredWidth());
    }

    /* JADX INFO: renamed from: g */
    public static int m2229g(View view, int i3, int i4, int i5, boolean z3) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = ((i5 - measuredHeight) / 2) + i4;
        if (z3) {
            view.layout(i3 - measuredWidth, i6, i3, measuredHeight + i6);
        } else {
            view.layout(i3, i6, i3 + measuredWidth, measuredHeight + i6);
        }
        return z3 ? -measuredWidth : measuredWidth;
    }

    /* JADX INFO: renamed from: c */
    public final void m2230c(AbstractC1434b abstractC1434b) {
        View view = this.f2700o;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f2709x, (ViewGroup) this, false);
            this.f2700o = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f2700o);
        }
        View viewFindViewById = this.f2700o.findViewById(R.id.action_mode_close_button);
        this.f2701p = viewFindViewById;
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC0250d(5, abstractC1434b));
        MenuC1479m menuC1479mMo3314e = abstractC1434b.mo3314e();
        C1594i c1594i = this.f2693h;
        if (c1594i != null) {
            c1594i.m3655f();
            C1582e c1582e = c1594i.f5660x;
            if (c1582e != null && c1582e.m3539b()) {
                c1582e.f5421j.dismiss();
            }
        }
        C1594i c1594i2 = new C1594i(getContext());
        this.f2693h = c1594i2;
        c1594i2.f5652p = true;
        c1594i2.f5653q = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuC1479mMo3314e.m3512b(this.f2693h, this.f2691f);
        C1594i c1594i3 = this.f2693h;
        InterfaceC1462B interfaceC1462B = c1594i3.f5648l;
        if (interfaceC1462B == null) {
            InterfaceC1462B interfaceC1462B2 = (InterfaceC1462B) c1594i3.f5644h.inflate(c1594i3.f5646j, (ViewGroup) this, false);
            c1594i3.f5648l = interfaceC1462B2;
            interfaceC1462B2.mo2224a(c1594i3.f5643g);
            c1594i3.mo3480g();
        }
        InterfaceC1462B interfaceC1462B3 = c1594i3.f5648l;
        if (interfaceC1462B != interfaceC1462B3) {
            ((ActionMenuView) interfaceC1462B3).setPresenter(c1594i3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) interfaceC1462B3;
        this.f2692g = actionMenuView;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m601q(actionMenuView, null);
        addView(this.f2692g, layoutParams);
    }

    /* JADX INFO: renamed from: d */
    public final void m2231d() {
        if (this.f2703r == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2703r = linearLayout;
            this.f2704s = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f2705t = (TextView) this.f2703r.findViewById(R.id.action_bar_subtitle);
            int i3 = this.f2706u;
            if (i3 != 0) {
                this.f2704s.setTextAppearance(getContext(), i3);
            }
            int i4 = this.f2707v;
            if (i4 != 0) {
                this.f2705t.setTextAppearance(getContext(), i4);
            }
        }
        this.f2704s.setText(this.f2698m);
        this.f2705t.setText(this.f2699n);
        boolean z3 = !TextUtils.isEmpty(this.f2698m);
        boolean z4 = !TextUtils.isEmpty(this.f2699n);
        this.f2705t.setVisibility(z4 ? 0 : 8);
        this.f2703r.setVisibility((z3 || z4) ? 0 : 8);
        if (this.f2703r.getParent() == null) {
            addView(this.f2703r);
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m2232e() {
        removeAllViews();
        this.f2702q = null;
        this.f2692g = null;
        this.f2693h = null;
        View view = this.f2701p;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.f2695j != null ? this.f2690e.f457b : getVisibility();
    }

    public int getContentHeight() {
        return this.f2694i;
    }

    public CharSequence getSubtitle() {
        return this.f2699n;
    }

    public CharSequence getTitle() {
        return this.f2698m;
    }

    @Override // android.view.View
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i3) {
        if (i3 != getVisibility()) {
            C0330Z c0330z = this.f2695j;
            if (c0330z != null) {
                c0330z.m716b();
            }
            super.setVisibility(i3);
        }
    }

    /* JADX INFO: renamed from: i */
    public final C0330Z m2234i(int i3, long j2) {
        C0330Z c0330z = this.f2695j;
        if (c0330z != null) {
            c0330z.m716b();
        }
        C0195s c0195s = this.f2690e;
        if (i3 != 0) {
            C0330Z c0330zM691a = AbstractC0323S.m691a(this);
            c0330zM691a.m715a(0.0f);
            c0330zM691a.m717c(j2);
            ((ActionBarContextView) c0195s.f458c).f2695j = c0330zM691a;
            c0195s.f457b = i3;
            c0330zM691a.m718d(c0195s);
            return c0330zM691a;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        C0330Z c0330zM691a2 = AbstractC0323S.m691a(this);
        c0330zM691a2.m715a(1.0f);
        c0330zM691a2.m717c(j2);
        ((ActionBarContextView) c0195s.f458c).f2695j = c0330zM691a2;
        c0195s.f457b = i3;
        c0330zM691a2.m718d(c0195s);
        return c0330zM691a2;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, AbstractC1343a.f4777a, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
        C1594i c1594i = this.f2693h;
        if (c1594i != null) {
            Configuration configuration2 = c1594i.f5642f.getResources().getConfiguration();
            int i3 = configuration2.screenWidthDp;
            int i4 = configuration2.screenHeightDp;
            c1594i.f5656t = (configuration2.smallestScreenWidthDp > 600 || i3 > 600 || (i3 > 960 && i4 > 720) || (i3 > 720 && i4 > 960)) ? 5 : (i3 >= 500 || (i3 > 640 && i4 > 480) || (i3 > 480 && i4 > 640)) ? 4 : i3 >= 360 ? 3 : 2;
            MenuC1479m menuC1479m = c1594i.f5643g;
            if (menuC1479m != null) {
                menuC1479m.m3518p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C1594i c1594i = this.f2693h;
        if (c1594i != null) {
            c1594i.m3655f();
            C1582e c1582e = this.f2693h.f5660x;
            if (c1582e == null || !c1582e.m3539b()) {
                return;
            }
            c1582e.f5421j.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2697l = false;
        }
        if (!this.f2697l) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f2697l = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2697l = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        boolean zM3658a = AbstractC1596i1.m3658a(this);
        int paddingRight = zM3658a ? (i5 - i3) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
        View view = this.f2700o;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2700o.getLayoutParams();
            int i7 = zM3658a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i8 = zM3658a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i9 = zM3658a ? paddingRight - i7 : paddingRight + i7;
            int iM2229g = m2229g(this.f2700o, i9, paddingTop, paddingTop2, zM3658a) + i9;
            paddingRight = zM3658a ? iM2229g - i8 : iM2229g + i8;
        }
        LinearLayout linearLayout = this.f2703r;
        if (linearLayout != null && this.f2702q == null && linearLayout.getVisibility() != 8) {
            paddingRight += m2229g(this.f2703r, paddingRight, paddingTop, paddingTop2, zM3658a);
        }
        View view2 = this.f2702q;
        if (view2 != null) {
            m2229g(view2, paddingRight, paddingTop, paddingTop2, zM3658a);
        }
        int paddingLeft = zM3658a ? getPaddingLeft() : (i5 - i3) - getPaddingRight();
        ActionMenuView actionMenuView = this.f2692g;
        if (actionMenuView != null) {
            m2229g(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zM3658a);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i4) {
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i4) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i3);
        int size2 = this.f2694i;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i4);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f2700o;
        if (view != null) {
            int iM2228f = m2228f(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2700o.getLayoutParams();
            paddingLeft = iM2228f - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f2692g;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = m2228f(this.f2692g, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.f2703r;
        if (linearLayout != null && this.f2702q == null) {
            if (this.f2708w) {
                this.f2703r.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f2703r.getMeasuredWidth();
                boolean z3 = measuredWidth <= paddingLeft;
                if (z3) {
                    paddingLeft -= measuredWidth;
                }
                this.f2703r.setVisibility(z3 ? 0 : 8);
            } else {
                paddingLeft = m2228f(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.f2702q;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i5 = layoutParams.width;
            int i6 = i5 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i5 >= 0) {
                paddingLeft = Math.min(i5, paddingLeft);
            }
            int i7 = layoutParams.height;
            int i8 = i7 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i7 >= 0) {
                iMin = Math.min(i7, iMin);
            }
            this.f2702q.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(iMin, i8));
        }
        if (this.f2694i > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i9) {
                i9 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i9);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2696k = false;
        }
        if (!this.f2696k) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f2696k = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2696k = false;
        }
        return true;
    }

    public void setContentHeight(int i3) {
        this.f2694i = i3;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f2702q;
        if (view2 != null) {
            removeView(view2);
        }
        this.f2702q = view;
        if (view != null && (linearLayout = this.f2703r) != null) {
            removeView(linearLayout);
            this.f2703r = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2699n = charSequence;
        m2231d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2698m = charSequence;
        m2231d();
        AbstractC0323S.m702l(this, charSequence);
    }

    public void setTitleOptional(boolean z3) {
        if (z3 != this.f2708w) {
            requestLayout();
        }
        this.f2708w = z3;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
