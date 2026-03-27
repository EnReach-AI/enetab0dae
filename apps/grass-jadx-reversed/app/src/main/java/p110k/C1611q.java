package p110k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import io.getgrass.www.R;
import p029J.AbstractC0323S;
import p077a0.C0846e;
import p094f.AbstractC1343a;
import p125o0.AbstractC1800j;
import p144t0.AbstractC1919e;
import p166z0.C2071i;

/* JADX INFO: renamed from: k.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1611q extends CheckedTextView {

    /* JADX INFO: renamed from: e */
    public final C0846e f5717e;

    /* JADX INFO: renamed from: f */
    public final C1605n f5718f;

    /* JADX INFO: renamed from: g */
    public final C1560V f5719g;

    /* JADX INFO: renamed from: h */
    public C1619u f5720h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1611q(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        AbstractC1563W0.m3634a(context);
        AbstractC1561V0.m3628a(this, getContext());
        C1560V c1560v = new C1560V(this);
        this.f5719g = c1560v;
        c1560v.m3623f(attributeSet, R.attr.checkedTextViewStyle);
        c1560v.m3620b();
        C1605n c1605n = new C1605n(this);
        this.f5718f = c1605n;
        c1605n.m3672f(attributeSet, R.attr.checkedTextViewStyle);
        this.f5717e = new C0846e(this, 2);
        Context context2 = getContext();
        int[] iArr = AbstractC1343a.f4788l;
        C2071i c2071iM4591v = C2071i.m4591v(context2, attributeSet, iArr, R.attr.checkedTextViewStyle, 0);
        TypedArray typedArray = (TypedArray) c2071iM4591v.f7315b;
        AbstractC0323S.m700j(this, getContext(), iArr, attributeSet, (TypedArray) c2071iM4591v.f7315b, R.attr.checkedTextViewStyle);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(AbstractC1800j.m3991i(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        setCheckMarkDrawable(AbstractC1800j.m3991i(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(AbstractC1800j.m3991i(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(c2071iM4591v.m4600j(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(AbstractC1589g0.m3652b(typedArray.getInt(3, -1), null));
            }
            c2071iM4591v.m4608x();
            getEmojiTextViewHelper().m3690a(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            c2071iM4591v.m4608x();
            throw th;
        }
    }

    private C1619u getEmojiTextViewHelper() {
        if (this.f5720h == null) {
            this.f5720h = new C1619u(this);
        }
        return this.f5720h;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C1560V c1560v = this.f5719g;
        if (c1560v != null) {
            c1560v.m3620b();
        }
        C1605n c1605n = this.f5718f;
        if (c1605n != null) {
            c1605n.m3669a();
        }
        C0846e c0846e = this.f5717e;
        if (c0846e != null) {
            c0846e.m2173c();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return super.getCustomSelectionActionModeCallback();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1605n c1605n = this.f5718f;
        if (c1605n != null) {
            return c1605n.m3670d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1605n c1605n = this.f5718f;
        if (c1605n != null) {
            return c1605n.m3671e();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0846e c0846e = this.f5717e;
        if (c0846e != null) {
            return (ColorStateList) c0846e.f2516f;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0846e c0846e = this.f5717e;
        if (c0846e != null) {
            return (PorterDuff.Mode) c0846e.f2517g;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5719g.m3621d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5719g.m3622e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AbstractC1919e.m4294o(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().m3691b(z3);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1605n c1605n = this.f5718f;
        if (c1605n != null) {
            c1605n.m3673g();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C1605n c1605n = this.f5718f;
        if (c1605n != null) {
            c1605n.m3674h(i3);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0846e c0846e = this.f5717e;
        if (c0846e != null) {
            if (c0846e.f2514d) {
                c0846e.f2514d = false;
            } else {
                c0846e.f2514d = true;
                c0846e.m2173c();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5719g;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5719g;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().m3692c(z3);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1605n c1605n = this.f5718f;
        if (c1605n != null) {
            c1605n.m3676j(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1605n c1605n = this.f5718f;
        if (c1605n != null) {
            c1605n.m3677k(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0846e c0846e = this.f5717e;
        if (c0846e != null) {
            c0846e.f2516f = colorStateList;
            c0846e.f2512b = true;
            c0846e.m2173c();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0846e c0846e = this.f5717e;
        if (c0846e != null) {
            c0846e.f2517g = mode;
            c0846e.f2513c = true;
            c0846e.m2173c();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C1560V c1560v = this.f5719g;
        c1560v.m3625i(colorStateList);
        c1560v.m3620b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C1560V c1560v = this.f5719g;
        c1560v.m3626j(mode);
        c1560v.m3620b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        C1560V c1560v = this.f5719g;
        if (c1560v != null) {
            c1560v.m3624g(context, i3);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i3) {
        setCheckMarkDrawable(AbstractC1800j.m3991i(getContext(), i3));
    }
}
