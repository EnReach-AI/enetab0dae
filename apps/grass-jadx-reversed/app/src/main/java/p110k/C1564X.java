package p110k;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.media.session.AbstractC0864a;
import android.text.InputFilter;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p005B.AbstractC0032g;
import p005B.AbstractC0034i;
import p023H.AbstractC0242e;
import p023H.C0241d;
import p039M0.AbstractC0493h0;
import p041N.AbstractC0528p;
import p041N.AbstractC0529q;
import p041N.AbstractC0530r;
import p125o0.AbstractC1800j;
import p144t0.AbstractC1919e;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: k.X */
/* JADX INFO: loaded from: classes.dex */
public class C1564X extends TextView {

    /* JADX INFO: renamed from: e */
    public final C1605n f5586e;

    /* JADX INFO: renamed from: f */
    public final C1560V f5587f;

    /* JADX INFO: renamed from: g */
    public C1619u f5588g;

    /* JADX INFO: renamed from: h */
    public boolean f5589h;

    /* JADX INFO: renamed from: i */
    public C1627y f5590i;

    /* JADX INFO: renamed from: j */
    public Future f5591j;

    public C1564X(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private C1619u getEmojiTextViewHelper() {
        if (this.f5588g == null) {
            this.f5588g = new C1619u(this);
        }
        return this.f5588g;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C1605n c1605n = this.f5586e;
        if (c1605n != null) {
            c1605n.m3669a();
        }
        C1560V c1560v = this.f5587f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m3637f() {
        Future future = this.f5591j;
        if (future == null) {
            return;
        }
        try {
            this.f5591j = null;
            AbstractC0032g.m162t(future.get());
            if (Build.VERSION.SDK_INT >= 29) {
                throw null;
            }
            PrecomputedText.Params paramsM1068b = AbstractC0530r.m1068b(this);
            paramsM1068b.getTextPaint();
            paramsM1068b.getTextDirection();
            paramsM1068b.getBreakStrategy();
            paramsM1068b.getHyphenationFrequency();
            throw null;
        } catch (InterruptedException | ExecutionException unused) {
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

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public InterfaceC1562W getSuperCaller() {
        if (this.f5590i == null) {
            this.f5590i = new C1627y(this);
        }
        return this.f5590i;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1605n c1605n = this.f5586e;
        if (c1605n != null) {
            return c1605n.m3670d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1605n c1605n = this.f5586e;
        if (c1605n != null) {
            return c1605n.m3671e();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5587f.m3621d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5587f.m3622e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        m3637f();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return super.getTextClassifier();
    }

    public C0241d getTextMetricsParamsCompat() {
        return new C0241d(AbstractC0530r.m1068b(this));
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f5587f.getClass();
        C1560V.m3618h(this, inputConnectionOnCreateInputConnection, editorInfo);
        AbstractC1919e.m4294o(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        C1560V c1560v = this.f5587f;
        if (c1560v != null) {
            c1560v.getClass();
            Method method = AbstractC1596i1.f5667a;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i4) {
        m3637f();
        super.onMeasure(i3, i4);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        if (this.f5587f != null) {
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
        C1605n c1605n = this.f5586e;
        if (c1605n != null) {
            c1605n.m3673g();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C1605n c1605n = this.f5586e;
        if (c1605n != null) {
            c1605n.m3674h(i3);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5587f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5587f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5587f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5587f;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((AbstractC1946e) getEmojiTextViewHelper().f5748b.f1085e).mo1442a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i3) {
        getSuperCaller().mo3633b(i3);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i3) {
        getSuperCaller().mo3632a(i3);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i3) {
        AbstractC0493h0.m1009b(i3);
        if (i3 != getPaint().getFontMetricsInt(null)) {
            setLineSpacing(i3 - r0, 1.0f);
        }
    }

    public void setPrecomputedText(AbstractC0242e abstractC0242e) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        PrecomputedText.Params paramsM1068b = AbstractC0530r.m1068b(this);
        paramsM1068b.getTextPaint();
        paramsM1068b.getTextDirection();
        paramsM1068b.getBreakStrategy();
        paramsM1068b.getHyphenationFrequency();
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1605n c1605n = this.f5586e;
        if (c1605n != null) {
            c1605n.m3676j(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1605n c1605n = this.f5586e;
        if (c1605n != null) {
            c1605n.m3677k(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C1560V c1560v = this.f5587f;
        c1560v.m3625i(colorStateList);
        c1560v.m3620b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C1560V c1560v = this.f5587f;
        c1560v.m3626j(mode);
        c1560v.m3620b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        C1560V c1560v = this.f5587f;
        if (c1560v != null) {
            c1560v.m3624g(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future<AbstractC0242e> future) {
        this.f5591j = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(C0241d c0241d) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = c0241d.f595b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i3 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i3 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i3 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i3 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i3 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i3 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i3 = 7;
            }
        }
        AbstractC0528p.m1058h(this, i3);
        getPaint().set(c0241d.f594a);
        AbstractC0529q.m1063e(this, c0241d.f596c);
        AbstractC0529q.m1066h(this, c0241d.f597d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i3, float f3) {
        Method method = AbstractC1596i1.f5667a;
        super.setTextSize(i3, f3);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i3) {
        Typeface typefaceCreate;
        if (this.f5589h) {
            return;
        }
        if (typeface == null || i3 <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            AbstractC0864a abstractC0864a = AbstractC0034i.f88a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i3);
        }
        this.f5589h = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i3);
        } finally {
            this.f5589h = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1564X(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        AbstractC1563W0.m3634a(context);
        this.f5589h = false;
        this.f5590i = null;
        AbstractC1561V0.m3628a(this, getContext());
        C1605n c1605n = new C1605n(this);
        this.f5586e = c1605n;
        c1605n.m3672f(attributeSet, i3);
        C1560V c1560v = new C1560V(this);
        this.f5587f = c1560v;
        c1560v.m3623f(attributeSet, i3);
        c1560v.m3620b();
        getEmojiTextViewHelper().m3690a(attributeSet, i3);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i3 != 0 ? AbstractC1800j.m3991i(context, i3) : null, i4 != 0 ? AbstractC1800j.m3991i(context, i4) : null, i5 != 0 ? AbstractC1800j.m3991i(context, i5) : null, i6 != 0 ? AbstractC1800j.m3991i(context, i6) : null);
        C1560V c1560v = this.f5587f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i3 != 0 ? AbstractC1800j.m3991i(context, i3) : null, i4 != 0 ? AbstractC1800j.m3991i(context, i4) : null, i5 != 0 ? AbstractC1800j.m3991i(context, i5) : null, i6 != 0 ? AbstractC1800j.m3991i(context, i6) : null);
        C1560V c1560v = this.f5587f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }
}
