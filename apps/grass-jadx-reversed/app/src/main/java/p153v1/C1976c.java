package p153v1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p001A.AbstractC0010k;
import p001A.AbstractC0017r;
import p005B.AbstractC0032g;
import p007B1.AbstractC0054n;
import p009C.AbstractC0139b;
import p034K1.C0424k;
import p040M1.AbstractC0512a;
import p041N.AbstractC0514b;
import p041N.AbstractC0515c;
import p091e0.C1321b;
import p091e0.C1323d;
import p091e0.C1324e;
import p091e0.C1325f;
import p110k.C1609p;
import p125o0.AbstractC1800j;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1919e;
import p144t0.AbstractC1920f;
import p166z0.C2071i;

/* JADX INFO: renamed from: v1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1976c extends C1609p {

    /* JADX INFO: renamed from: C */
    public static final int[] f6997C = {R.attr.state_indeterminate};

    /* JADX INFO: renamed from: D */
    public static final int[] f6998D = {R.attr.state_error};

    /* JADX INFO: renamed from: E */
    public static final int[][] f6999E = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: F */
    public static final int f7000F = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");

    /* JADX INFO: renamed from: A */
    public final C1325f f7001A;

    /* JADX INFO: renamed from: B */
    public final C1974a f7002B;

    /* JADX INFO: renamed from: i */
    public final LinkedHashSet f7003i;

    /* JADX INFO: renamed from: j */
    public final LinkedHashSet f7004j;

    /* JADX INFO: renamed from: k */
    public ColorStateList f7005k;

    /* JADX INFO: renamed from: l */
    public boolean f7006l;

    /* JADX INFO: renamed from: m */
    public boolean f7007m;

    /* JADX INFO: renamed from: n */
    public boolean f7008n;

    /* JADX INFO: renamed from: o */
    public CharSequence f7009o;

    /* JADX INFO: renamed from: p */
    public Drawable f7010p;

    /* JADX INFO: renamed from: q */
    public Drawable f7011q;

    /* JADX INFO: renamed from: r */
    public boolean f7012r;

    /* JADX INFO: renamed from: s */
    public ColorStateList f7013s;

    /* JADX INFO: renamed from: t */
    public ColorStateList f7014t;

    /* JADX INFO: renamed from: u */
    public PorterDuff.Mode f7015u;

    /* JADX INFO: renamed from: v */
    public int f7016v;

    /* JADX INFO: renamed from: w */
    public int[] f7017w;

    /* JADX INFO: renamed from: x */
    public boolean f7018x;

    /* JADX INFO: renamed from: y */
    public CharSequence f7019y;

    /* JADX INFO: renamed from: z */
    public CompoundButton.OnCheckedChangeListener f7020z;

    public C1976c(Context context, AttributeSet attributeSet) {
        super(AbstractC0512a.m1020a(context, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox), attributeSet, R.attr.checkboxStyle);
        this.f7003i = new LinkedHashSet();
        this.f7004j = new LinkedHashSet();
        Context context2 = getContext();
        C1325f c1325f = new C1325f(context2);
        Resources resources = context2.getResources();
        Resources.Theme theme = context2.getTheme();
        ThreadLocal threadLocal = AbstractC0017r.f43a;
        Drawable drawableM67a = AbstractC0010k.m67a(resources, R.drawable.mtrl_checkbox_button_checked_unchecked, theme);
        c1325f.f4697e = drawableM67a;
        drawableM67a.setCallback(c1325f.f4696j);
        new C1324e(c1325f.f4697e.getConstantState());
        this.f7001A = c1325f;
        this.f7002B = new C1974a(this);
        Context context3 = getContext();
        this.f7010p = AbstractC0515c.m1026a(this);
        this.f7013s = getSuperButtonTintList();
        setSupportButtonTintList(null);
        int[] iArr = AbstractC1805a.f6237m;
        AbstractC0054n.m211a(context3, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        AbstractC0054n.m212b(context3, attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context3.obtainStyledAttributes(attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        C2071i c2071i = new C2071i(context3, typedArrayObtainStyledAttributes);
        this.f7011q = c2071i.m4601l(2);
        if (this.f7010p != null && AbstractC1919e.m4297r(context3, R.attr.isMaterial3Theme, false)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
            if (resourceId == f7000F && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.f7010p = AbstractC1800j.m3991i(context3, R.drawable.mtrl_checkbox_button);
                this.f7012r = true;
                if (this.f7011q == null) {
                    this.f7011q = AbstractC1800j.m3991i(context3, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.f7014t = AbstractC1920f.m4304e(context3, c2071i, 3);
        this.f7015u = AbstractC0054n.m217g(typedArrayObtainStyledAttributes.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.f7006l = typedArrayObtainStyledAttributes.getBoolean(10, false);
        this.f7007m = typedArrayObtainStyledAttributes.getBoolean(6, true);
        this.f7008n = typedArrayObtainStyledAttributes.getBoolean(9, false);
        this.f7009o = typedArrayObtainStyledAttributes.getText(8);
        if (typedArrayObtainStyledAttributes.hasValue(7)) {
            setCheckedState(typedArrayObtainStyledAttributes.getInt(7, 0));
        }
        c2071i.m4608x();
        m4368a();
    }

    private String getButtonStateDescription() {
        int i3 = this.f7016v;
        return i3 == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i3 == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f7005k == null) {
            int iM4302c = AbstractC1920f.m4302c(this, R.attr.colorControlActivated);
            int iM4302c2 = AbstractC1920f.m4302c(this, R.attr.colorError);
            int iM4302c3 = AbstractC1920f.m4302c(this, R.attr.colorSurface);
            int iM4302c4 = AbstractC1920f.m4302c(this, R.attr.colorOnSurface);
            this.f7005k = new ColorStateList(f6999E, new int[]{AbstractC1920f.m4309l(iM4302c3, iM4302c2, 1.0f), AbstractC1920f.m4309l(iM4302c3, iM4302c, 1.0f), AbstractC1920f.m4309l(iM4302c3, iM4302c4, 0.54f), AbstractC1920f.m4309l(iM4302c3, iM4302c4, 0.38f), AbstractC1920f.m4309l(iM4302c3, iM4302c4, 0.38f)});
        }
        return this.f7005k;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f7013s;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    /* JADX INFO: renamed from: a */
    public final void m4368a() {
        int intrinsicHeight;
        int intrinsicWidth;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        C0424k c0424k;
        Drawable drawableMutate = this.f7010p;
        ColorStateList colorStateList3 = this.f7013s;
        PorterDuff.Mode modeM1023b = AbstractC0514b.m1023b(this);
        if (drawableMutate == null) {
            drawableMutate = null;
        } else if (colorStateList3 != null) {
            drawableMutate = drawableMutate.mutate();
            if (modeM1023b != null) {
                AbstractC0139b.m281i(drawableMutate, modeM1023b);
            }
        }
        this.f7010p = drawableMutate;
        Drawable drawableMutate2 = this.f7011q;
        ColorStateList colorStateList4 = this.f7014t;
        PorterDuff.Mode mode = this.f7015u;
        if (drawableMutate2 == null) {
            drawableMutate2 = null;
        } else if (colorStateList4 != null) {
            drawableMutate2 = drawableMutate2.mutate();
            if (mode != null) {
                AbstractC0139b.m281i(drawableMutate2, mode);
            }
        }
        this.f7011q = drawableMutate2;
        if (this.f7012r) {
            C1325f c1325f = this.f7001A;
            if (c1325f != null) {
                Drawable drawable = c1325f.f4697e;
                C1974a c1974a = this.f7002B;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (c1974a.f6994a == null) {
                        c1974a.f6994a = new C1321b(c1974a);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(c1974a.f6994a);
                }
                ArrayList arrayList = c1325f.f4695i;
                C1323d c1323d = c1325f.f4692f;
                if (arrayList != null && c1974a != null) {
                    arrayList.remove(c1974a);
                    if (c1325f.f4695i.size() == 0 && (c0424k = c1325f.f4694h) != null) {
                        c1323d.f4688b.removeListener(c0424k);
                        c1325f.f4694h = null;
                    }
                }
                Drawable drawable2 = c1325f.f4697e;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (c1974a.f6994a == null) {
                        c1974a.f6994a = new C1321b(c1974a);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(c1974a.f6994a);
                } else if (c1974a != null) {
                    if (c1325f.f4695i == null) {
                        c1325f.f4695i = new ArrayList();
                    }
                    if (!c1325f.f4695i.contains(c1974a)) {
                        c1325f.f4695i.add(c1974a);
                        if (c1325f.f4694h == null) {
                            c1325f.f4694h = new C0424k(2, c1325f);
                        }
                        c1323d.f4688b.addListener(c1325f.f4694h);
                    }
                }
            }
            Drawable drawable3 = this.f7010p;
            if ((drawable3 instanceof AnimatedStateListDrawable) && c1325f != null) {
                ((AnimatedStateListDrawable) drawable3).addTransition(R.id.checked, R.id.unchecked, c1325f, false);
                ((AnimatedStateListDrawable) this.f7010p).addTransition(R.id.indeterminate, R.id.unchecked, c1325f, false);
            }
        }
        Drawable drawable4 = this.f7010p;
        if (drawable4 != null && (colorStateList2 = this.f7013s) != null) {
            AbstractC0139b.m280h(drawable4, colorStateList2);
        }
        Drawable drawable5 = this.f7011q;
        if (drawable5 != null && (colorStateList = this.f7014t) != null) {
            AbstractC0139b.m280h(drawable5, colorStateList);
        }
        Drawable drawable6 = this.f7010p;
        Drawable drawable7 = this.f7011q;
        if (drawable6 == null) {
            drawable6 = drawable7;
        } else if (drawable7 != null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable6, drawable7});
            if (drawable7.getIntrinsicWidth() == -1 || drawable7.getIntrinsicHeight() == -1) {
                int intrinsicWidth2 = drawable6.getIntrinsicWidth();
                intrinsicHeight = drawable6.getIntrinsicHeight();
                intrinsicWidth = intrinsicWidth2;
            } else if (drawable7.getIntrinsicWidth() > drawable6.getIntrinsicWidth() || drawable7.getIntrinsicHeight() > drawable6.getIntrinsicHeight()) {
                float intrinsicWidth3 = drawable7.getIntrinsicWidth() / drawable7.getIntrinsicHeight();
                if (intrinsicWidth3 >= drawable6.getIntrinsicWidth() / drawable6.getIntrinsicHeight()) {
                    intrinsicWidth = drawable6.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth / intrinsicWidth3);
                } else {
                    intrinsicHeight = drawable6.getIntrinsicHeight();
                    intrinsicWidth = (int) (intrinsicWidth3 * intrinsicHeight);
                }
            } else {
                intrinsicWidth = drawable7.getIntrinsicWidth();
                intrinsicHeight = drawable7.getIntrinsicHeight();
            }
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable6 = layerDrawable;
        }
        super.setButtonDrawable(drawable6);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f7010p;
    }

    public Drawable getButtonIconDrawable() {
        return this.f7011q;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f7014t;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f7015u;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f7013s;
    }

    public int getCheckedState() {
        return this.f7016v;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f7009o;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f7016v == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f7006l && this.f7013s == null && this.f7014t == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        int[] iArrCopyOf;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6997C);
        }
        if (this.f7008n) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6998D);
        }
        int i4 = 0;
        while (true) {
            if (i4 >= iArrOnCreateDrawableState.length) {
                iArrCopyOf = Arrays.copyOf(iArrOnCreateDrawableState, iArrOnCreateDrawableState.length + 1);
                iArrCopyOf[iArrOnCreateDrawableState.length] = 16842912;
                break;
            }
            int i5 = iArrOnCreateDrawableState[i4];
            if (i5 == 16842912) {
                iArrCopyOf = iArrOnCreateDrawableState;
                break;
            }
            if (i5 == 0) {
                iArrCopyOf = (int[]) iArrOnCreateDrawableState.clone();
                iArrCopyOf[i4] = 16842912;
                break;
            }
            i4++;
        }
        this.f7017w = iArrCopyOf;
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable drawableM1026a;
        if (!this.f7007m || !TextUtils.isEmpty(getText()) || (drawableM1026a = AbstractC0515c.m1026a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableM1026a.getIntrinsicWidth()) / 2) * (AbstractC0054n.m215e(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableM1026a.getBounds();
            AbstractC0139b.m278f(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f7008n) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f7009o));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C1975b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C1975b c1975b = (C1975b) parcelable;
        super.onRestoreInstanceState(c1975b.getSuperState());
        setCheckedState(c1975b.f6996e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        C1975b c1975b = new C1975b(super.onSaveInstanceState());
        c1975b.f6996e = getCheckedState();
        return c1975b;
    }

    @Override // p110k.C1609p, android.widget.CompoundButton
    public void setButtonDrawable(int i3) {
        setButtonDrawable(AbstractC1800j.m3991i(getContext(), i3));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f7011q = drawable;
        m4368a();
    }

    public void setButtonIconDrawableResource(int i3) {
        setButtonIconDrawable(AbstractC1800j.m3991i(getContext(), i3));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f7014t == colorStateList) {
            return;
        }
        this.f7014t = colorStateList;
        m4368a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f7015u == mode) {
            return;
        }
        this.f7015u = mode;
        m4368a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f7013s == colorStateList) {
            return;
        }
        this.f7013s = colorStateList;
        m4368a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        m4368a();
    }

    public void setCenterIfNoTextEnabled(boolean z3) {
        this.f7007m = z3;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        setCheckedState(z3 ? 1 : 0);
    }

    public void setCheckedState(int i3) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f7016v != i3) {
            this.f7016v = i3;
            super.setChecked(i3 == 1);
            refreshDrawableState();
            if (Build.VERSION.SDK_INT >= 30 && this.f7019y == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.f7018x) {
                return;
            }
            this.f7018x = true;
            LinkedHashSet linkedHashSet = this.f7004j;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    AbstractC0032g.m162t(it.next());
                    throw null;
                }
            }
            if (this.f7016v != 2 && (onCheckedChangeListener = this.f7020z) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f7018x = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f7009o = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i3) {
        setErrorAccessibilityLabel(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setErrorShown(boolean z3) {
        if (this.f7008n == z3) {
            return;
        }
        this.f7008n = z3;
        refreshDrawableState();
        Iterator it = this.f7003i.iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            throw null;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f7020z = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f7019y = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z3) {
        this.f7006l = z3;
        if (z3) {
            AbstractC0514b.m1024c(this, getMaterialThemeColorsTintList());
        } else {
            AbstractC0514b.m1024c(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // p110k.C1609p, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f7010p = drawable;
        this.f7012r = false;
        m4368a();
    }
}
