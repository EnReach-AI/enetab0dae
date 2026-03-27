package p110k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import java.lang.reflect.Method;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: k.o */
/* JADX INFO: loaded from: classes.dex */
public class C1607o extends Button {

    /* JADX INFO: renamed from: e */
    public final C1605n f5699e;

    /* JADX INFO: renamed from: f */
    public final C1560V f5700f;

    /* JADX INFO: renamed from: g */
    public C1619u f5701g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1607o(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        AbstractC1563W0.m3634a(context);
        AbstractC1561V0.m3628a(this, getContext());
        C1605n c1605n = new C1605n(this);
        this.f5699e = c1605n;
        c1605n.m3672f(attributeSet, i3);
        C1560V c1560v = new C1560V(this);
        this.f5700f = c1560v;
        c1560v.m3623f(attributeSet, i3);
        c1560v.m3620b();
        getEmojiTextViewHelper().m3690a(attributeSet, i3);
    }

    private C1619u getEmojiTextViewHelper() {
        if (this.f5701g == null) {
            this.f5701g = new C1619u(this);
        }
        return this.f5701g;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C1605n c1605n = this.f5699e;
        if (c1605n != null) {
            c1605n.m3669a();
        }
        C1560V c1560v = this.f5700f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        Method method = AbstractC1596i1.f5667a;
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        Method method = AbstractC1596i1.f5667a;
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        Method method = AbstractC1596i1.f5667a;
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        Method method = AbstractC1596i1.f5667a;
        return super.getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        Method method = AbstractC1596i1.f5667a;
        return super.getAutoSizeTextType() == 1 ? 1 : 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return super.getCustomSelectionActionModeCallback();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1605n c1605n = this.f5699e;
        if (c1605n != null) {
            return c1605n.m3670d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1605n c1605n = this.f5699e;
        if (c1605n != null) {
            return c1605n.m3671e();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5700f.m3621d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5700f.m3622e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        C1560V c1560v = this.f5700f;
        if (c1560v != null) {
            c1560v.getClass();
            Method method = AbstractC1596i1.f5667a;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        if (this.f5700f != null) {
            Method method = AbstractC1596i1.f5667a;
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().m3691b(z3);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i4, int i5, int i6) {
        Method method = AbstractC1596i1.f5667a;
        super.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i3) {
        Method method = AbstractC1596i1.f5667a;
        super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i3) {
        Method method = AbstractC1596i1.f5667a;
        super.setAutoSizeTextTypeWithDefaults(i3);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1605n c1605n = this.f5699e;
        if (c1605n != null) {
            c1605n.m3673g();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C1605n c1605n = this.f5699e;
        if (c1605n != null) {
            c1605n.m3674h(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().m3692c(z3);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((AbstractC1946e) getEmojiTextViewHelper().f5748b.f1085e).mo1442a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z3) {
        C1560V c1560v = this.f5700f;
        if (c1560v != null) {
            c1560v.f5565a.setAllCaps(z3);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1605n c1605n = this.f5699e;
        if (c1605n != null) {
            c1605n.m3676j(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1605n c1605n = this.f5699e;
        if (c1605n != null) {
            c1605n.m3677k(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C1560V c1560v = this.f5700f;
        c1560v.m3625i(colorStateList);
        c1560v.m3620b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C1560V c1560v = this.f5700f;
        c1560v.m3626j(mode);
        c1560v.m3620b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        C1560V c1560v = this.f5700f;
        if (c1560v != null) {
            c1560v.m3624g(context, i3);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i3, float f3) {
        Method method = AbstractC1596i1.f5667a;
        super.setTextSize(i3, f3);
    }
}
