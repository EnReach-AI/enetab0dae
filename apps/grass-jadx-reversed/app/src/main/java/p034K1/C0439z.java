package p034K1;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p007B1.AbstractC0054n;
import p029J.AbstractC0308C;
import p029J.AbstractC0310E;
import p029J.AbstractC0323S;
import p029J.AbstractC0353l;
import p110k.C1564X;
import p125o0.AbstractC1800j;
import p144t0.AbstractC1920f;
import p166z0.C2071i;

/* JADX INFO: renamed from: K1.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0439z extends LinearLayout {

    /* JADX INFO: renamed from: e */
    public final TextInputLayout f1064e;

    /* JADX INFO: renamed from: f */
    public final C1564X f1065f;

    /* JADX INFO: renamed from: g */
    public CharSequence f1066g;

    /* JADX INFO: renamed from: h */
    public final CheckableImageButton f1067h;

    /* JADX INFO: renamed from: i */
    public ColorStateList f1068i;

    /* JADX INFO: renamed from: j */
    public PorterDuff.Mode f1069j;

    /* JADX INFO: renamed from: k */
    public int f1070k;

    /* JADX INFO: renamed from: l */
    public ImageView.ScaleType f1071l;

    /* JADX INFO: renamed from: m */
    public View.OnLongClickListener f1072m;

    /* JADX INFO: renamed from: n */
    public boolean f1073n;

    public C0439z(TextInputLayout textInputLayout, C2071i c2071i) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f1064e = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f1067h = checkableImageButton;
        C1564X c1564x = new C1564X(getContext(), null);
        this.f1065f = c1564x;
        if (AbstractC1920f.m4308k(getContext())) {
            AbstractC0353l.m775g((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        View.OnLongClickListener onLongClickListener = this.f1072m;
        checkableImageButton.setOnClickListener(null);
        AbstractC1800j.m3994l(checkableImageButton, onLongClickListener);
        this.f1072m = null;
        checkableImageButton.setOnLongClickListener(null);
        AbstractC1800j.m3994l(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) c2071i.f7315b;
        if (typedArray.hasValue(67)) {
            this.f1068i = AbstractC1920f.m4304e(getContext(), c2071i, 67);
        }
        if (typedArray.hasValue(68)) {
            this.f1069j = AbstractC0054n.m217g(typedArray.getInt(68, -1), null);
        }
        if (typedArray.hasValue(64)) {
            m969a(c2071i.m4601l(64));
            if (typedArray.hasValue(63) && checkableImageButton.getContentDescription() != (text = typedArray.getText(63))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(62, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(65, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f1070k) {
            this.f1070k = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(66)) {
            ImageView.ScaleType scaleTypeM3987e = AbstractC1800j.m3987e(typedArray.getInt(66, -1));
            this.f1071l = scaleTypeM3987e;
            checkableImageButton.setScaleType(scaleTypeM3987e);
        }
        c1564x.setVisibility(8);
        c1564x.setId(R.id.textinput_prefix_text);
        c1564x.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0310E.m623f(c1564x, 1);
        c1564x.setTextAppearance(typedArray.getResourceId(58, 0));
        if (typedArray.hasValue(59)) {
            c1564x.setTextColor(c2071i.m4600j(59));
        }
        CharSequence text2 = typedArray.getText(57);
        this.f1066g = TextUtils.isEmpty(text2) ? null : text2;
        c1564x.setText(text2);
        m972d();
        addView(checkableImageButton);
        addView(c1564x);
    }

    /* JADX INFO: renamed from: a */
    public final void m969a(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f1067h;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f1068i;
            PorterDuff.Mode mode = this.f1069j;
            TextInputLayout textInputLayout = this.f1064e;
            AbstractC1800j.m3985c(textInputLayout, checkableImageButton, colorStateList, mode);
            m970b(true);
            AbstractC1800j.m3993k(textInputLayout, checkableImageButton, this.f1068i);
            return;
        }
        m970b(false);
        View.OnLongClickListener onLongClickListener = this.f1072m;
        checkableImageButton.setOnClickListener(null);
        AbstractC1800j.m3994l(checkableImageButton, onLongClickListener);
        this.f1072m = null;
        checkableImageButton.setOnLongClickListener(null);
        AbstractC1800j.m3994l(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m970b(boolean z3) {
        CheckableImageButton checkableImageButton = this.f1067h;
        if ((checkableImageButton.getVisibility() == 0) != z3) {
            checkableImageButton.setVisibility(z3 ? 0 : 8);
            m971c();
            m972d();
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m971c() {
        int iM609f;
        EditText editText = this.f1064e.f4501h;
        if (editText == null) {
            return;
        }
        if (this.f1067h.getVisibility() == 0) {
            iM609f = 0;
        } else {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            iM609f = AbstractC0308C.m609f(editText);
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
        AbstractC0308C.m614k(this.f1065f, iM609f, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    /* JADX INFO: renamed from: d */
    public final void m972d() {
        int i3 = (this.f1066g == null || this.f1073n) ? 8 : 0;
        setVisibility((this.f1067h.getVisibility() == 0 || i3 == 0) ? 0 : 8);
        this.f1065f.setVisibility(i3);
        this.f1064e.m3213p();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        m971c();
    }
}
