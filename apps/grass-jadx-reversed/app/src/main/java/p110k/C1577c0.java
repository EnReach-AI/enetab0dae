package p110k;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: k.c0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1577c0 extends ToggleButton {

    /* JADX INFO: renamed from: e */
    public final C1605n f5609e;

    /* JADX INFO: renamed from: f */
    public final C1560V f5610f;

    /* JADX INFO: renamed from: g */
    public C1619u f5611g;

    public C1577c0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        AbstractC1561V0.m3628a(this, getContext());
        C1605n c1605n = new C1605n(this);
        this.f5609e = c1605n;
        c1605n.m3672f(attributeSet, R.attr.buttonStyleToggle);
        C1560V c1560v = new C1560V(this);
        this.f5610f = c1560v;
        c1560v.m3623f(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().m3690a(attributeSet, R.attr.buttonStyleToggle);
    }

    private C1619u getEmojiTextViewHelper() {
        if (this.f5611g == null) {
            this.f5611g = new C1619u(this);
        }
        return this.f5611g;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C1605n c1605n = this.f5609e;
        if (c1605n != null) {
            c1605n.m3669a();
        }
        C1560V c1560v = this.f5610f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1605n c1605n = this.f5609e;
        if (c1605n != null) {
            return c1605n.m3670d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1605n c1605n = this.f5609e;
        if (c1605n != null) {
            return c1605n.m3671e();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5610f.m3621d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5610f.m3622e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().m3691b(z3);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1605n c1605n = this.f5609e;
        if (c1605n != null) {
            c1605n.m3673g();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C1605n c1605n = this.f5609e;
        if (c1605n != null) {
            c1605n.m3674h(i3);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5610f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5610f;
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
        C1605n c1605n = this.f5609e;
        if (c1605n != null) {
            c1605n.m3676j(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1605n c1605n = this.f5609e;
        if (c1605n != null) {
            c1605n.m3677k(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C1560V c1560v = this.f5610f;
        c1560v.m3625i(colorStateList);
        c1560v.m3620b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C1560V c1560v = this.f5610f;
        c1560v.m3626j(mode);
        c1560v.m3620b();
    }
}
