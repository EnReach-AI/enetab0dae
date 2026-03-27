package p110k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import p041N.InterfaceC0532t;
import p077a0.C0846e;
import p125o0.AbstractC1800j;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: k.p */
/* JADX INFO: loaded from: classes.dex */
public class C1609p extends CheckBox implements InterfaceC0532t {

    /* JADX INFO: renamed from: e */
    public final C0846e f5704e;

    /* JADX INFO: renamed from: f */
    public final C1605n f5705f;

    /* JADX INFO: renamed from: g */
    public final C1560V f5706g;

    /* JADX INFO: renamed from: h */
    public C1619u f5707h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1609p(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        AbstractC1563W0.m3634a(context);
        AbstractC1561V0.m3628a(this, getContext());
        C0846e c0846e = new C0846e(this, 3);
        this.f5704e = c0846e;
        c0846e.m2175e(attributeSet, i3);
        C1605n c1605n = new C1605n(this);
        this.f5705f = c1605n;
        c1605n.m3672f(attributeSet, i3);
        C1560V c1560v = new C1560V(this);
        this.f5706g = c1560v;
        c1560v.m3623f(attributeSet, i3);
        getEmojiTextViewHelper().m3690a(attributeSet, i3);
    }

    private C1619u getEmojiTextViewHelper() {
        if (this.f5707h == null) {
            this.f5707h = new C1619u(this);
        }
        return this.f5707h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1605n c1605n = this.f5705f;
        if (c1605n != null) {
            c1605n.m3669a();
        }
        C1560V c1560v = this.f5706g;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0846e c0846e = this.f5704e;
        if (c0846e != null) {
            c0846e.getClass();
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1605n c1605n = this.f5705f;
        if (c1605n != null) {
            return c1605n.m3670d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1605n c1605n = this.f5705f;
        if (c1605n != null) {
            return c1605n.m3671e();
        }
        return null;
    }

    @Override // p041N.InterfaceC0532t
    public ColorStateList getSupportButtonTintList() {
        C0846e c0846e = this.f5704e;
        if (c0846e != null) {
            return (ColorStateList) c0846e.f2516f;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0846e c0846e = this.f5704e;
        if (c0846e != null) {
            return (PorterDuff.Mode) c0846e.f2517g;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5706g.m3621d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5706g.m3622e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().m3691b(z3);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1605n c1605n = this.f5705f;
        if (c1605n != null) {
            c1605n.m3673g();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C1605n c1605n = this.f5705f;
        if (c1605n != null) {
            c1605n.m3674h(i3);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0846e c0846e = this.f5704e;
        if (c0846e != null) {
            if (c0846e.f2514d) {
                c0846e.f2514d = false;
            } else {
                c0846e.f2514d = true;
                c0846e.m2172b();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5706g;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5706g;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().m3692c(z3);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((AbstractC1946e) getEmojiTextViewHelper().f5748b.f1085e).mo1442a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1605n c1605n = this.f5705f;
        if (c1605n != null) {
            c1605n.m3676j(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1605n c1605n = this.f5705f;
        if (c1605n != null) {
            c1605n.m3677k(mode);
        }
    }

    @Override // p041N.InterfaceC0532t
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0846e c0846e = this.f5704e;
        if (c0846e != null) {
            c0846e.f2516f = colorStateList;
            c0846e.f2512b = true;
            c0846e.m2172b();
        }
    }

    @Override // p041N.InterfaceC0532t
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0846e c0846e = this.f5704e;
        if (c0846e != null) {
            c0846e.f2517g = mode;
            c0846e.f2513c = true;
            c0846e.m2172b();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C1560V c1560v = this.f5706g;
        c1560v.m3625i(colorStateList);
        c1560v.m3620b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C1560V c1560v = this.f5706g;
        c1560v.m3626j(mode);
        c1560v.m3620b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i3) {
        setButtonDrawable(AbstractC1800j.m3991i(getContext(), i3));
    }
}
