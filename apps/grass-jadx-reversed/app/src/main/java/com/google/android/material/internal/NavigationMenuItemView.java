package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.WeakHashMap;
import p001A.AbstractC0010k;
import p001A.AbstractC0017r;
import p007B1.AbstractC0046f;
import p007B1.C0041a;
import p009C.AbstractC0139b;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p041N.AbstractC0528p;
import p108j.C1481o;
import p108j.InterfaceC1461A;
import p110k.AbstractC1587f1;
import p110k.C1612q0;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends AbstractC0046f implements InterfaceC1461A {

    /* JADX INFO: renamed from: J */
    public static final int[] f4427J = {R.attr.state_checked};

    /* JADX INFO: renamed from: A */
    public boolean f4428A;

    /* JADX INFO: renamed from: B */
    public boolean f4429B;

    /* JADX INFO: renamed from: C */
    public final CheckedTextView f4430C;

    /* JADX INFO: renamed from: D */
    public FrameLayout f4431D;

    /* JADX INFO: renamed from: E */
    public C1481o f4432E;

    /* JADX INFO: renamed from: F */
    public ColorStateList f4433F;

    /* JADX INFO: renamed from: G */
    public boolean f4434G;

    /* JADX INFO: renamed from: H */
    public Drawable f4435H;

    /* JADX INFO: renamed from: I */
    public final C0041a f4436I;

    /* JADX INFO: renamed from: z */
    public int f4437z;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0041a c0041a = new C0041a(1, this);
        this.f4436I = c0041a;
        setOrientation(0);
        LayoutInflater.from(context).inflate(io.getgrass.www.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(io.getgrass.www.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(io.getgrass.www.R.id.design_menu_item_text);
        this.f4430C = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        AbstractC0323S.m701k(checkedTextView, c0041a);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f4431D == null) {
                this.f4431D = (FrameLayout) ((ViewStub) findViewById(io.getgrass.www.R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f4431D.removeAllViews();
            this.f4431D.addView(view);
        }
    }

    @Override // p108j.InterfaceC1461A
    /* JADX INFO: renamed from: d */
    public final void mo2221d(C1481o c1481o) {
        StateListDrawable stateListDrawable;
        this.f4432E = c1481o;
        int i3 = c1481o.f5374a;
        if (i3 > 0) {
            setId(i3);
        }
        setVisibility(c1481o.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(io.getgrass.www.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f4427J, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0307B.m601q(this, stateListDrawable);
        }
        setCheckable(c1481o.isCheckable());
        setChecked(c1481o.isChecked());
        setEnabled(c1481o.isEnabled());
        setTitle(c1481o.f5378e);
        setIcon(c1481o.getIcon());
        setActionView(c1481o.getActionView());
        setContentDescription(c1481o.f5390q);
        AbstractC1587f1.m3650a(this, c1481o.f5391r);
        C1481o c1481o2 = this.f4432E;
        CharSequence charSequence = c1481o2.f5378e;
        CheckedTextView checkedTextView = this.f4430C;
        if (charSequence == null && c1481o2.getIcon() == null && this.f4432E.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.f4431D;
            if (frameLayout != null) {
                C1612q0 c1612q0 = (C1612q0) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) c1612q0).width = -1;
                this.f4431D.setLayoutParams(c1612q0);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.f4431D;
        if (frameLayout2 != null) {
            C1612q0 c1612q02 = (C1612q0) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) c1612q02).width = -2;
            this.f4431D.setLayoutParams(c1612q02);
        }
    }

    @Override // p108j.InterfaceC1461A
    public C1481o getItemData() {
        return this.f4432E;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        C1481o c1481o = this.f4432E;
        if (c1481o != null && c1481o.isCheckable() && this.f4432E.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f4427J);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z3) {
        refreshDrawableState();
        if (this.f4429B != z3) {
            this.f4429B = z3;
            this.f4436I.mo728h(this.f4430C, 2048);
        }
    }

    public void setChecked(boolean z3) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.f4430C;
        checkedTextView.setChecked(z3);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), z3 ? 1 : 0);
    }

    public void setHorizontalPadding(int i3) {
        setPadding(i3, getPaddingTop(), i3, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f4434G) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                AbstractC0139b.m280h(drawable, this.f4433F);
            }
            int i3 = this.f4437z;
            drawable.setBounds(0, 0, i3, i3);
        } else if (this.f4428A) {
            if (this.f4435H == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = AbstractC0017r.f43a;
                Drawable drawableM67a = AbstractC0010k.m67a(resources, io.getgrass.www.R.drawable.navigation_empty_icon, theme);
                this.f4435H = drawableM67a;
                if (drawableM67a != null) {
                    int i4 = this.f4437z;
                    drawableM67a.setBounds(0, 0, i4, i4);
                }
            }
            drawable = this.f4435H;
        }
        AbstractC0528p.m1055e(this.f4430C, drawable, null, null, null);
    }

    public void setIconPadding(int i3) {
        this.f4430C.setCompoundDrawablePadding(i3);
    }

    public void setIconSize(int i3) {
        this.f4437z = i3;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f4433F = colorStateList;
        this.f4434G = colorStateList != null;
        C1481o c1481o = this.f4432E;
        if (c1481o != null) {
            setIcon(c1481o.getIcon());
        }
    }

    public void setMaxLines(int i3) {
        this.f4430C.setMaxLines(i3);
    }

    public void setNeedsEmptyIcon(boolean z3) {
        this.f4428A = z3;
    }

    public void setTextAppearance(int i3) {
        this.f4430C.setTextAppearance(i3);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f4430C.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f4430C.setText(charSequence);
    }
}
