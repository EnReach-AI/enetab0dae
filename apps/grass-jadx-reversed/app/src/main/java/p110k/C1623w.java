package p110k;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import p125o0.AbstractC1800j;
import p144t0.AbstractC1919e;
import p166z0.C2071i;

/* JADX INFO: renamed from: k.w */
/* JADX INFO: loaded from: classes.dex */
public final class C1623w extends MultiAutoCompleteTextView {

    /* JADX INFO: renamed from: h */
    public static final int[] f5754h = {R.attr.popupBackground};

    /* JADX INFO: renamed from: e */
    public final C1605n f5755e;

    /* JADX INFO: renamed from: f */
    public final C1560V f5756f;

    /* JADX INFO: renamed from: g */
    public final C1627y f5757g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1623w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, io.getgrass.www.R.attr.autoCompleteTextViewStyle);
        AbstractC1563W0.m3634a(context);
        AbstractC1561V0.m3628a(this, getContext());
        C2071i c2071iM4591v = C2071i.m4591v(getContext(), attributeSet, f5754h, io.getgrass.www.R.attr.autoCompleteTextViewStyle, 0);
        if (((TypedArray) c2071iM4591v.f7315b).hasValue(0)) {
            setDropDownBackgroundDrawable(c2071iM4591v.m4601l(0));
        }
        c2071iM4591v.m4608x();
        C1605n c1605n = new C1605n(this);
        this.f5755e = c1605n;
        c1605n.m3672f(attributeSet, io.getgrass.www.R.attr.autoCompleteTextViewStyle);
        C1560V c1560v = new C1560V(this);
        this.f5756f = c1560v;
        c1560v.m3623f(attributeSet, io.getgrass.www.R.attr.autoCompleteTextViewStyle);
        c1560v.m3620b();
        C1627y c1627y = new C1627y(this);
        this.f5757g = c1627y;
        c1627y.mo3569d(attributeSet, io.getgrass.www.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean zIsFocusable = isFocusable();
            boolean zIsClickable = isClickable();
            boolean zIsLongClickable = isLongClickable();
            int inputType = getInputType();
            KeyListener keyListenerM3695c = c1627y.m3695c(keyListener);
            if (keyListenerM3695c == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerM3695c);
            setRawInputType(inputType);
            setFocusable(zIsFocusable);
            setClickable(zIsClickable);
            setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C1605n c1605n = this.f5755e;
        if (c1605n != null) {
            c1605n.m3669a();
        }
        C1560V c1560v = this.f5756f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1605n c1605n = this.f5755e;
        if (c1605n != null) {
            return c1605n.m3670d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1605n c1605n = this.f5755e;
        if (c1605n != null) {
            return c1605n.m3671e();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5756f.m3621d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5756f.m3622e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AbstractC1919e.m4294o(inputConnectionOnCreateInputConnection, editorInfo, this);
        return this.f5757g.m3696e(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1605n c1605n = this.f5755e;
        if (c1605n != null) {
            c1605n.m3673g();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C1605n c1605n = this.f5755e;
        if (c1605n != null) {
            c1605n.m3674h(i3);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5756f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5756f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i3) {
        setDropDownBackgroundDrawable(AbstractC1800j.m3991i(getContext(), i3));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        this.f5757g.m3697f(z3);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f5757g.m3695c(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1605n c1605n = this.f5755e;
        if (c1605n != null) {
            c1605n.m3676j(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1605n c1605n = this.f5755e;
        if (c1605n != null) {
            c1605n.m3677k(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C1560V c1560v = this.f5756f;
        c1560v.m3625i(colorStateList);
        c1560v.m3620b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C1560V c1560v = this.f5756f;
        c1560v.m3626j(mode);
        c1560v.m3620b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        C1560V c1560v = this.f5756f;
        if (c1560v != null) {
            c1560v.m3624g(context, i3);
        }
    }
}
