package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p005B.AbstractC0032g;
import p007B1.AbstractC0054n;
import p009C.AbstractC0139b;
import p019F0.C0221e;
import p025H1.C0272a;
import p025H1.C0281j;
import p025H1.InterfaceC0292u;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p039M0.AbstractC0473V;
import p040M1.AbstractC0512a;
import p041N.AbstractC0528p;
import p110k.C1607o;
import p125o0.AbstractC1800j;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1920f;
import p144t0.C1916b;
import p149u1.C1948b;
import p149u1.C1949c;
import p149u1.InterfaceC1947a;
import p165z.AbstractC2049e;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends C1607o implements Checkable, InterfaceC0292u {

    /* JADX INFO: renamed from: u */
    public static final int[] f4293u = {R.attr.state_checkable};

    /* JADX INFO: renamed from: v */
    public static final int[] f4294v = {R.attr.state_checked};

    /* JADX INFO: renamed from: h */
    public final C1949c f4295h;

    /* JADX INFO: renamed from: i */
    public final LinkedHashSet f4296i;

    /* JADX INFO: renamed from: j */
    public InterfaceC1947a f4297j;

    /* JADX INFO: renamed from: k */
    public PorterDuff.Mode f4298k;

    /* JADX INFO: renamed from: l */
    public ColorStateList f4299l;

    /* JADX INFO: renamed from: m */
    public Drawable f4300m;

    /* JADX INFO: renamed from: n */
    public int f4301n;

    /* JADX INFO: renamed from: o */
    public int f4302o;

    /* JADX INFO: renamed from: p */
    public int f4303p;

    /* JADX INFO: renamed from: q */
    public int f4304q;

    /* JADX INFO: renamed from: r */
    public boolean f4305r;

    /* JADX INFO: renamed from: s */
    public boolean f4306s;

    /* JADX INFO: renamed from: t */
    public int f4307t;

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(AbstractC0512a.m1020a(context, attributeSet, io.getgrass.www.R.attr.materialButtonStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Button), attributeSet, io.getgrass.www.R.attr.materialButtonStyle);
        this.f4296i = new LinkedHashSet();
        this.f4305r = false;
        this.f4306s = false;
        Context context2 = getContext();
        TypedArray typedArrayM216f = AbstractC0054n.m216f(context2, attributeSet, AbstractC1805a.f6233i, io.getgrass.www.R.attr.materialButtonStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.f4304q = typedArrayM216f.getDimensionPixelSize(12, 0);
        int i3 = typedArrayM216f.getInt(15, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f4298k = AbstractC0054n.m217g(i3, mode);
        this.f4299l = AbstractC1920f.m4303d(getContext(), typedArrayM216f, 14);
        this.f4300m = AbstractC1920f.m4305f(getContext(), typedArrayM216f, 10);
        this.f4307t = typedArrayM216f.getInteger(11, 1);
        this.f4301n = typedArrayM216f.getDimensionPixelSize(13, 0);
        C1949c c1949c = new C1949c(this, C0281j.m552b(context2, attributeSet, io.getgrass.www.R.attr.materialButtonStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Button).m4266a());
        this.f4295h = c1949c;
        c1949c.f6946c = typedArrayM216f.getDimensionPixelOffset(1, 0);
        c1949c.f6947d = typedArrayM216f.getDimensionPixelOffset(2, 0);
        c1949c.f6948e = typedArrayM216f.getDimensionPixelOffset(3, 0);
        c1949c.f6949f = typedArrayM216f.getDimensionPixelOffset(4, 0);
        if (typedArrayM216f.hasValue(8)) {
            int dimensionPixelSize = typedArrayM216f.getDimensionPixelSize(8, -1);
            c1949c.f6950g = dimensionPixelSize;
            float f3 = dimensionPixelSize;
            C1916b c1916bM555e = c1949c.f6945b.m555e();
            c1916bM555e.f6703e = new C0272a(f3);
            c1916bM555e.f6704f = new C0272a(f3);
            c1916bM555e.f6705g = new C0272a(f3);
            c1916bM555e.f6706h = new C0272a(f3);
            c1949c.m4354c(c1916bM555e.m4266a());
            c1949c.f6959p = true;
        }
        c1949c.f6951h = typedArrayM216f.getDimensionPixelSize(20, 0);
        c1949c.f6952i = AbstractC0054n.m217g(typedArrayM216f.getInt(7, -1), mode);
        c1949c.f6953j = AbstractC1920f.m4303d(getContext(), typedArrayM216f, 6);
        c1949c.f6954k = AbstractC1920f.m4303d(getContext(), typedArrayM216f, 19);
        c1949c.f6955l = AbstractC1920f.m4303d(getContext(), typedArrayM216f, 16);
        c1949c.f6960q = typedArrayM216f.getBoolean(5, false);
        c1949c.f6963t = typedArrayM216f.getDimensionPixelSize(9, 0);
        c1949c.f6961r = typedArrayM216f.getBoolean(21, true);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        int iM609f = AbstractC0308C.m609f(this);
        int paddingTop = getPaddingTop();
        int iM608e = AbstractC0308C.m608e(this);
        int paddingBottom = getPaddingBottom();
        if (typedArrayM216f.hasValue(0)) {
            c1949c.f6958o = true;
            setSupportBackgroundTintList(c1949c.f6953j);
            setSupportBackgroundTintMode(c1949c.f6952i);
        } else {
            c1949c.m4356e();
        }
        AbstractC0308C.m614k(this, iM609f + c1949c.f6946c, paddingTop + c1949c.f6948e, iM608e + c1949c.f6947d, paddingBottom + c1949c.f6949f);
        typedArrayM216f.recycle();
        setCompoundDrawablePadding(this.f4304q);
        m3161d(this.f4300m != null);
    }

    private String getA11yClassName() {
        return (m3158a() ? CompoundButton.class : Button.class).getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i3 = 0; i3 < lineCount; i3++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i3));
        }
        return (int) Math.ceil(fMax);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3158a() {
        C1949c c1949c = this.f4295h;
        return c1949c != null && c1949c.f6960q;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3159b() {
        C1949c c1949c = this.f4295h;
        return (c1949c == null || c1949c.f6958o) ? false : true;
    }

    /* JADX INFO: renamed from: c */
    public final void m3160c() {
        int i3 = this.f4307t;
        boolean z3 = true;
        if (i3 != 1 && i3 != 2) {
            z3 = false;
        }
        if (z3) {
            AbstractC0528p.m1055e(this, this.f4300m, null, null, null);
            return;
        }
        if (i3 == 3 || i3 == 4) {
            AbstractC0528p.m1055e(this, null, null, this.f4300m, null);
        } else if (i3 == 16 || i3 == 32) {
            AbstractC0528p.m1055e(this, null, this.f4300m, null, null);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m3161d(boolean z3) {
        Drawable drawable = this.f4300m;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.f4300m = drawableMutate;
            AbstractC0139b.m280h(drawableMutate, this.f4299l);
            PorterDuff.Mode mode = this.f4298k;
            if (mode != null) {
                AbstractC0139b.m281i(this.f4300m, mode);
            }
            int intrinsicWidth = this.f4301n;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f4300m.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f4301n;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f4300m.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f4300m;
            int i3 = this.f4302o;
            int i4 = this.f4303p;
            drawable2.setBounds(i3, i4, intrinsicWidth + i3, intrinsicHeight + i4);
            this.f4300m.setVisible(true, z3);
        }
        if (z3) {
            m3160c();
            return;
        }
        Drawable[] drawableArrM1051a = AbstractC0528p.m1051a(this);
        Drawable drawable3 = drawableArrM1051a[0];
        Drawable drawable4 = drawableArrM1051a[1];
        Drawable drawable5 = drawableArrM1051a[2];
        int i5 = this.f4307t;
        if (((i5 == 1 || i5 == 2) && drawable3 != this.f4300m) || (((i5 == 3 || i5 == 4) && drawable5 != this.f4300m) || ((i5 == 16 || i5 == 32) && drawable4 != this.f4300m))) {
            m3160c();
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m3162e(int i3, int i4) {
        if (this.f4300m == null || getLayout() == null) {
            return;
        }
        int i5 = this.f4307t;
        if (!(i5 == 1 || i5 == 2) && i5 != 3 && i5 != 4) {
            if (i5 == 16 || i5 == 32) {
                this.f4302o = 0;
                if (i5 == 16) {
                    this.f4303p = 0;
                    m3161d(false);
                    return;
                }
                int intrinsicHeight = this.f4301n;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f4300m.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i4 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f4304q) - getPaddingBottom()) / 2);
                if (this.f4303p != iMax) {
                    this.f4303p = iMax;
                    m3161d(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f4303p = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i6 = this.f4307t;
        if (i6 == 1 || i6 == 3 || ((i6 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i6 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f4302o = 0;
            m3161d(false);
            return;
        }
        int intrinsicWidth = this.f4301n;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f4300m.getIntrinsicWidth();
        }
        int textLayoutWidth = i3 - getTextLayoutWidth();
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        int iM608e = (((textLayoutWidth - AbstractC0308C.m608e(this)) - intrinsicWidth) - this.f4304q) - AbstractC0308C.m609f(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            iM608e /= 2;
        }
        if ((AbstractC0308C.m607d(this) == 1) != (this.f4307t == 4)) {
            iM608e = -iM608e;
        }
        if (this.f4302o != iM608e) {
            this.f4302o = iM608e;
            m3161d(false);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (m3159b()) {
            return this.f4295h.f6950g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f4300m;
    }

    public int getIconGravity() {
        return this.f4307t;
    }

    public int getIconPadding() {
        return this.f4304q;
    }

    public int getIconSize() {
        return this.f4301n;
    }

    public ColorStateList getIconTint() {
        return this.f4299l;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f4298k;
    }

    public int getInsetBottom() {
        return this.f4295h.f6949f;
    }

    public int getInsetTop() {
        return this.f4295h.f6948e;
    }

    public ColorStateList getRippleColor() {
        if (m3159b()) {
            return this.f4295h.f6955l;
        }
        return null;
    }

    public C0281j getShapeAppearanceModel() {
        if (m3159b()) {
            return this.f4295h.f6945b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (m3159b()) {
            return this.f4295h.f6954k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (m3159b()) {
            return this.f4295h.f6951h;
        }
        return 0;
    }

    @Override // p110k.C1607o
    public ColorStateList getSupportBackgroundTintList() {
        return m3159b() ? this.f4295h.f6953j : super.getSupportBackgroundTintList();
    }

    @Override // p110k.C1607o
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return m3159b() ? this.f4295h.f6952i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f4305r;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (m3159b()) {
            AbstractC0473V.m998K(this, this.f4295h.m4353b(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (m3158a()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f4293u);
        }
        if (this.f4305r) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f4294v);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // p110k.C1607o, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.f4305r);
    }

    @Override // p110k.C1607o, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(m3158a());
        accessibilityNodeInfo.setChecked(this.f4305r);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // p110k.C1607o, android.widget.TextView, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        m3162e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C1948b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C1948b c1948b = (C1948b) parcelable;
        super.onRestoreInstanceState(c1948b.f1425e);
        setChecked(c1948b.f6943g);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        C1948b c1948b = new C1948b(super.onSaveInstanceState());
        c1948b.f6943g = this.f4305r;
        return c1948b;
    }

    @Override // p110k.C1607o, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        m3162e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f4295h.f6961r) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f4300m != null) {
            if (this.f4300m.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        if (!m3159b()) {
            super.setBackgroundColor(i3);
            return;
        }
        C1949c c1949c = this.f4295h;
        if (c1949c.m4353b(false) != null) {
            c1949c.m4353b(false).setTint(i3);
        }
    }

    @Override // p110k.C1607o, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!m3159b()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        C1949c c1949c = this.f4295h;
        c1949c.f6958o = true;
        ColorStateList colorStateList = c1949c.f6953j;
        MaterialButton materialButton = c1949c.f6944a;
        materialButton.setSupportBackgroundTintList(colorStateList);
        materialButton.setSupportBackgroundTintMode(c1949c.f6952i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // p110k.C1607o, android.view.View
    public void setBackgroundResource(int i3) {
        setBackgroundDrawable(i3 != 0 ? AbstractC1800j.m3991i(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z3) {
        if (m3159b()) {
            this.f4295h.f6960q = z3;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        if (m3158a() && isEnabled() && this.f4305r != z3) {
            this.f4305r = z3;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
                boolean z4 = this.f4305r;
                if (!materialButtonToggleGroup.f4314j) {
                    materialButtonToggleGroup.m3164b(getId(), z4);
                }
            }
            if (this.f4306s) {
                return;
            }
            this.f4306s = true;
            Iterator it = this.f4296i.iterator();
            if (it.hasNext()) {
                AbstractC0032g.m162t(it.next());
                throw null;
            }
            this.f4306s = false;
        }
    }

    public void setCornerRadius(int i3) {
        if (m3159b()) {
            C1949c c1949c = this.f4295h;
            if (c1949c.f6959p && c1949c.f6950g == i3) {
                return;
            }
            c1949c.f6950g = i3;
            c1949c.f6959p = true;
            float f3 = i3;
            C1916b c1916bM555e = c1949c.f6945b.m555e();
            c1916bM555e.f6703e = new C0272a(f3);
            c1916bM555e.f6704f = new C0272a(f3);
            c1916bM555e.f6705g = new C0272a(f3);
            c1916bM555e.f6706h = new C0272a(f3);
            c1949c.m4354c(c1916bM555e.m4266a());
        }
    }

    public void setCornerRadiusResource(int i3) {
        if (m3159b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        if (m3159b()) {
            this.f4295h.m4353b(false).m546j(f3);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f4300m != drawable) {
            this.f4300m = drawable;
            m3161d(true);
            m3162e(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i3) {
        if (this.f4307t != i3) {
            this.f4307t = i3;
            m3162e(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i3) {
        if (this.f4304q != i3) {
            this.f4304q = i3;
            setCompoundDrawablePadding(i3);
        }
    }

    public void setIconResource(int i3) {
        setIcon(i3 != 0 ? AbstractC1800j.m3991i(getContext(), i3) : null);
    }

    public void setIconSize(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f4301n != i3) {
            this.f4301n = i3;
            m3161d(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f4299l != colorStateList) {
            this.f4299l = colorStateList;
            m3161d(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f4298k != mode) {
            this.f4298k = mode;
            m3161d(false);
        }
    }

    public void setIconTintResource(int i3) {
        setIconTint(AbstractC2049e.m4525c(getContext(), i3));
    }

    public void setInsetBottom(int i3) {
        C1949c c1949c = this.f4295h;
        c1949c.m4355d(c1949c.f6948e, i3);
    }

    public void setInsetTop(int i3) {
        C1949c c1949c = this.f4295h;
        c1949c.m4355d(i3, c1949c.f6949f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(InterfaceC1947a interfaceC1947a) {
        this.f4297j = interfaceC1947a;
    }

    @Override // android.view.View
    public void setPressed(boolean z3) {
        InterfaceC1947a interfaceC1947a = this.f4297j;
        if (interfaceC1947a != null) {
            ((MaterialButtonToggleGroup) ((C0221e) interfaceC1947a).f534f).invalidate();
        }
        super.setPressed(z3);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (m3159b()) {
            C1949c c1949c = this.f4295h;
            if (c1949c.f6955l != colorStateList) {
                c1949c.f6955l = colorStateList;
                MaterialButton materialButton = c1949c.f6944a;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    RippleDrawable rippleDrawable = (RippleDrawable) materialButton.getBackground();
                    if (colorStateList == null) {
                        colorStateList = ColorStateList.valueOf(0);
                    }
                    rippleDrawable.setColor(colorStateList);
                }
            }
        }
    }

    public void setRippleColorResource(int i3) {
        if (m3159b()) {
            setRippleColor(AbstractC2049e.m4525c(getContext(), i3));
        }
    }

    @Override // p025H1.InterfaceC0292u
    public void setShapeAppearanceModel(C0281j c0281j) {
        if (!m3159b()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f4295h.m4354c(c0281j);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z3) {
        if (m3159b()) {
            C1949c c1949c = this.f4295h;
            c1949c.f6957n = z3;
            c1949c.m4357f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (m3159b()) {
            C1949c c1949c = this.f4295h;
            if (c1949c.f6954k != colorStateList) {
                c1949c.f6954k = colorStateList;
                c1949c.m4357f();
            }
        }
    }

    public void setStrokeColorResource(int i3) {
        if (m3159b()) {
            setStrokeColor(AbstractC2049e.m4525c(getContext(), i3));
        }
    }

    public void setStrokeWidth(int i3) {
        if (m3159b()) {
            C1949c c1949c = this.f4295h;
            if (c1949c.f6951h != i3) {
                c1949c.f6951h = i3;
                c1949c.m4357f();
            }
        }
    }

    public void setStrokeWidthResource(int i3) {
        if (m3159b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // p110k.C1607o
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!m3159b()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        C1949c c1949c = this.f4295h;
        if (c1949c.f6953j != colorStateList) {
            c1949c.f6953j = colorStateList;
            if (c1949c.m4353b(false) != null) {
                AbstractC0139b.m280h(c1949c.m4353b(false), c1949c.f6953j);
            }
        }
    }

    @Override // p110k.C1607o
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!m3159b()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        C1949c c1949c = this.f4295h;
        if (c1949c.f6952i != mode) {
            c1949c.f6952i = mode;
            if (c1949c.m4353b(false) == null || c1949c.f6952i == null) {
                return;
            }
            AbstractC0139b.m281i(c1949c.m4353b(false), c1949c.f6952i);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i3) {
        super.setTextAlignment(i3);
        m3162e(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z3) {
        this.f4295h.f6961r = z3;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f4305r);
    }
}
