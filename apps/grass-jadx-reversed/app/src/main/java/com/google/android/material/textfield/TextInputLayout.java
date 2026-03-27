package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import p005B.AbstractC0026a;
import p007B1.AbstractC0045e;
import p007B1.AbstractC0054n;
import p007B1.C0044d;
import p009C.AbstractC0139b;
import p015D2.C0181e;
import p016E1.C0203a;
import p016E1.C0206d;
import p023H.AbstractC0245h;
import p023H.AbstractC0246i;
import p023H.C0239b;
import p025H1.C0272a;
import p025H1.C0276e;
import p025H1.C0277f;
import p025H1.C0278g;
import p025H1.C0280i;
import p025H1.C0281j;
import p025H1.InterfaceC0274c;
import p029J.AbstractC0307B;
import p029J.AbstractC0308C;
import p029J.AbstractC0310E;
import p029J.AbstractC0315J;
import p029J.AbstractC0323S;
import p029J.AbstractC0353l;
import p033K0.AbstractC0406d;
import p034K1.C0407A;
import p034K1.C0408B;
import p034K1.C0410D;
import p034K1.C0411E;
import p034K1.C0413G;
import p034K1.C0420g;
import p034K1.C0425l;
import p034K1.C0427n;
import p034K1.C0430q;
import p034K1.C0433t;
import p034K1.C0434u;
import p034K1.C0437x;
import p034K1.C0439z;
import p034K1.InterfaceC0412F;
import p034K1.RunnableC0409C;
import p036L0.C0444d;
import p039M0.AbstractC0473V;
import p040M1.AbstractC0512a;
import p087d0.AbstractC1297p;
import p087d0.C1290i;
import p110k.AbstractC1589g0;
import p110k.C1532G0;
import p110k.C1564X;
import p110k.C1613r;
import p125o0.AbstractC1794d;
import p125o0.AbstractC1800j;
import p126o1.AbstractC1805a;
import p130p1.AbstractC1824a;
import p144t0.AbstractC1919e;
import p144t0.AbstractC1920f;
import p144t0.C1916b;
import p165z.AbstractC2048d;
import p165z.AbstractC2049e;
import p166z0.C2071i;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* JADX INFO: renamed from: C0 */
    public static final int[][] f4465C0 = {new int[]{R.attr.state_pressed}, new int[0]};

    /* JADX INFO: renamed from: A */
    public C1290i f4466A;

    /* JADX INFO: renamed from: A0 */
    public boolean f4467A0;

    /* JADX INFO: renamed from: B */
    public C1290i f4468B;

    /* JADX INFO: renamed from: B0 */
    public boolean f4469B0;

    /* JADX INFO: renamed from: C */
    public ColorStateList f4470C;

    /* JADX INFO: renamed from: D */
    public ColorStateList f4471D;

    /* JADX INFO: renamed from: E */
    public boolean f4472E;

    /* JADX INFO: renamed from: F */
    public CharSequence f4473F;

    /* JADX INFO: renamed from: G */
    public boolean f4474G;

    /* JADX INFO: renamed from: H */
    public C0278g f4475H;

    /* JADX INFO: renamed from: I */
    public C0278g f4476I;

    /* JADX INFO: renamed from: J */
    public StateListDrawable f4477J;

    /* JADX INFO: renamed from: K */
    public boolean f4478K;

    /* JADX INFO: renamed from: L */
    public C0278g f4479L;

    /* JADX INFO: renamed from: M */
    public C0278g f4480M;

    /* JADX INFO: renamed from: N */
    public C0281j f4481N;

    /* JADX INFO: renamed from: O */
    public boolean f4482O;

    /* JADX INFO: renamed from: P */
    public final int f4483P;

    /* JADX INFO: renamed from: Q */
    public int f4484Q;

    /* JADX INFO: renamed from: R */
    public int f4485R;

    /* JADX INFO: renamed from: S */
    public int f4486S;

    /* JADX INFO: renamed from: T */
    public int f4487T;

    /* JADX INFO: renamed from: U */
    public int f4488U;

    /* JADX INFO: renamed from: V */
    public int f4489V;

    /* JADX INFO: renamed from: W */
    public int f4490W;

    /* JADX INFO: renamed from: a0 */
    public final Rect f4491a0;

    /* JADX INFO: renamed from: b0 */
    public final Rect f4492b0;

    /* JADX INFO: renamed from: c0 */
    public final RectF f4493c0;

    /* JADX INFO: renamed from: d0 */
    public Typeface f4494d0;

    /* JADX INFO: renamed from: e */
    public final FrameLayout f4495e;

    /* JADX INFO: renamed from: e0 */
    public ColorDrawable f4496e0;

    /* JADX INFO: renamed from: f */
    public final C0439z f4497f;

    /* JADX INFO: renamed from: f0 */
    public int f4498f0;

    /* JADX INFO: renamed from: g */
    public final C0430q f4499g;

    /* JADX INFO: renamed from: g0 */
    public final LinkedHashSet f4500g0;

    /* JADX INFO: renamed from: h */
    public EditText f4501h;

    /* JADX INFO: renamed from: h0 */
    public ColorDrawable f4502h0;

    /* JADX INFO: renamed from: i */
    public CharSequence f4503i;

    /* JADX INFO: renamed from: i0 */
    public int f4504i0;

    /* JADX INFO: renamed from: j */
    public int f4505j;

    /* JADX INFO: renamed from: j0 */
    public Drawable f4506j0;

    /* JADX INFO: renamed from: k */
    public int f4507k;

    /* JADX INFO: renamed from: k0 */
    public ColorStateList f4508k0;

    /* JADX INFO: renamed from: l */
    public int f4509l;

    /* JADX INFO: renamed from: l0 */
    public ColorStateList f4510l0;

    /* JADX INFO: renamed from: m */
    public int f4511m;

    /* JADX INFO: renamed from: m0 */
    public int f4512m0;

    /* JADX INFO: renamed from: n */
    public final C0434u f4513n;

    /* JADX INFO: renamed from: n0 */
    public int f4514n0;

    /* JADX INFO: renamed from: o */
    public boolean f4515o;

    /* JADX INFO: renamed from: o0 */
    public int f4516o0;

    /* JADX INFO: renamed from: p */
    public int f4517p;

    /* JADX INFO: renamed from: p0 */
    public ColorStateList f4518p0;

    /* JADX INFO: renamed from: q */
    public boolean f4519q;

    /* JADX INFO: renamed from: q0 */
    public int f4520q0;

    /* JADX INFO: renamed from: r */
    public InterfaceC0412F f4521r;

    /* JADX INFO: renamed from: r0 */
    public int f4522r0;

    /* JADX INFO: renamed from: s */
    public C1564X f4523s;

    /* JADX INFO: renamed from: s0 */
    public int f4524s0;

    /* JADX INFO: renamed from: t */
    public int f4525t;

    /* JADX INFO: renamed from: t0 */
    public int f4526t0;

    /* JADX INFO: renamed from: u */
    public int f4527u;

    /* JADX INFO: renamed from: u0 */
    public int f4528u0;

    /* JADX INFO: renamed from: v */
    public CharSequence f4529v;

    /* JADX INFO: renamed from: v0 */
    public boolean f4530v0;

    /* JADX INFO: renamed from: w */
    public boolean f4531w;

    /* JADX INFO: renamed from: w0 */
    public final C0044d f4532w0;

    /* JADX INFO: renamed from: x */
    public C1564X f4533x;

    /* JADX INFO: renamed from: x0 */
    public boolean f4534x0;

    /* JADX INFO: renamed from: y */
    public ColorStateList f4535y;

    /* JADX INFO: renamed from: y0 */
    public boolean f4536y0;

    /* JADX INFO: renamed from: z */
    public int f4537z;

    /* JADX INFO: renamed from: z0 */
    public ValueAnimator f4538z0;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(AbstractC0512a.m1020a(context, attributeSet, io.getgrass.www.R.attr.textInputStyle, io.getgrass.www.R.style.Widget_Design_TextInputLayout), attributeSet, io.getgrass.www.R.attr.textInputStyle);
        this.f4505j = -1;
        this.f4507k = -1;
        this.f4509l = -1;
        this.f4511m = -1;
        this.f4513n = new C0434u(this);
        this.f4521r = new C0407A();
        this.f4491a0 = new Rect();
        this.f4492b0 = new Rect();
        this.f4493c0 = new RectF();
        this.f4500g0 = new LinkedHashSet();
        C0044d c0044d = new C0044d(this);
        this.f4532w0 = c0044d;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f4495e = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = AbstractC1824a.f6320a;
        c0044d.f127Q = linearInterpolator;
        c0044d.m200h(false);
        c0044d.f126P = linearInterpolator;
        c0044d.m200h(false);
        if (c0044d.f149g != 8388659) {
            c0044d.f149g = 8388659;
            c0044d.m200h(false);
        }
        int[] iArr = AbstractC1805a.f6250z;
        AbstractC0054n.m211a(context2, attributeSet, io.getgrass.www.R.attr.textInputStyle, io.getgrass.www.R.style.Widget_Design_TextInputLayout);
        AbstractC0054n.m212b(context2, attributeSet, iArr, io.getgrass.www.R.attr.textInputStyle, io.getgrass.www.R.style.Widget_Design_TextInputLayout, 22, 20, 38, 43, 47);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, io.getgrass.www.R.attr.textInputStyle, io.getgrass.www.R.style.Widget_Design_TextInputLayout);
        C2071i c2071i = new C2071i(context2, typedArrayObtainStyledAttributes);
        C0439z c0439z = new C0439z(this, c2071i);
        this.f4497f = c0439z;
        this.f4472E = typedArrayObtainStyledAttributes.getBoolean(46, true);
        setHint(typedArrayObtainStyledAttributes.getText(4));
        this.f4536y0 = typedArrayObtainStyledAttributes.getBoolean(45, true);
        this.f4534x0 = typedArrayObtainStyledAttributes.getBoolean(40, true);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            setMinEms(typedArrayObtainStyledAttributes.getInt(6, -1));
        } else if (typedArrayObtainStyledAttributes.hasValue(3)) {
            setMinWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(3, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            setMaxEms(typedArrayObtainStyledAttributes.getInt(5, -1));
        } else if (typedArrayObtainStyledAttributes.hasValue(2)) {
            setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.f4481N = C0281j.m552b(context2, attributeSet, io.getgrass.www.R.attr.textInputStyle, io.getgrass.www.R.style.Widget_Design_TextInputLayout).m4266a();
        this.f4483P = context2.getResources().getDimensionPixelOffset(io.getgrass.www.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.f4485R = typedArrayObtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.f4487T = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(io.getgrass.www.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.f4488U = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(io.getgrass.www.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.f4486S = this.f4487T;
        float dimension = typedArrayObtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = typedArrayObtainStyledAttributes.getDimension(11, -1.0f);
        C1916b c1916bM555e = this.f4481N.m555e();
        if (dimension >= 0.0f) {
            c1916bM555e.f6703e = new C0272a(dimension);
        }
        if (dimension2 >= 0.0f) {
            c1916bM555e.f6704f = new C0272a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            c1916bM555e.f6705g = new C0272a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            c1916bM555e.f6706h = new C0272a(dimension4);
        }
        this.f4481N = c1916bM555e.m4266a();
        ColorStateList colorStateListM4304e = AbstractC1920f.m4304e(context2, c2071i, 7);
        if (colorStateListM4304e != null) {
            int defaultColor = colorStateListM4304e.getDefaultColor();
            this.f4520q0 = defaultColor;
            this.f4490W = defaultColor;
            if (colorStateListM4304e.isStateful()) {
                this.f4522r0 = colorStateListM4304e.getColorForState(new int[]{-16842910}, -1);
                this.f4524s0 = colorStateListM4304e.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f4526t0 = colorStateListM4304e.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f4524s0 = this.f4520q0;
                ColorStateList colorStateListM4525c = AbstractC2049e.m4525c(context2, io.getgrass.www.R.color.mtrl_filled_background_color);
                this.f4522r0 = colorStateListM4525c.getColorForState(new int[]{-16842910}, -1);
                this.f4526t0 = colorStateListM4525c.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f4490W = 0;
            this.f4520q0 = 0;
            this.f4522r0 = 0;
            this.f4524s0 = 0;
            this.f4526t0 = 0;
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateListM4600j = c2071i.m4600j(1);
            this.f4510l0 = colorStateListM4600j;
            this.f4508k0 = colorStateListM4600j;
        }
        ColorStateList colorStateListM4304e2 = AbstractC1920f.m4304e(context2, c2071i, 14);
        this.f4516o0 = typedArrayObtainStyledAttributes.getColor(14, 0);
        this.f4512m0 = AbstractC2048d.m4520a(context2, io.getgrass.www.R.color.mtrl_textinput_default_box_stroke_color);
        this.f4528u0 = AbstractC2048d.m4520a(context2, io.getgrass.www.R.color.mtrl_textinput_disabled_color);
        this.f4514n0 = AbstractC2048d.m4520a(context2, io.getgrass.www.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListM4304e2 != null) {
            setBoxStrokeColorStateList(colorStateListM4304e2);
        }
        if (typedArrayObtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(AbstractC1920f.m4304e(context2, c2071i, 15));
        }
        if (typedArrayObtainStyledAttributes.getResourceId(47, -1) != -1) {
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(47, 0));
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(38, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(33);
        int i3 = typedArrayObtainStyledAttributes.getInt(32, 1);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(34, false);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(43, 0);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(42, false);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(41);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(55, 0);
        CharSequence text3 = typedArrayObtainStyledAttributes.getText(54);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(typedArrayObtainStyledAttributes.getInt(19, -1));
        this.f4527u = typedArrayObtainStyledAttributes.getResourceId(22, 0);
        this.f4525t = typedArrayObtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(typedArrayObtainStyledAttributes.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i3);
        setCounterOverflowTextAppearance(this.f4525t);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.f4527u);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (typedArrayObtainStyledAttributes.hasValue(39)) {
            setErrorTextColor(c2071i.m4600j(39));
        }
        if (typedArrayObtainStyledAttributes.hasValue(44)) {
            setHelperTextColor(c2071i.m4600j(44));
        }
        if (typedArrayObtainStyledAttributes.hasValue(48)) {
            setHintTextColor(c2071i.m4600j(48));
        }
        if (typedArrayObtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(c2071i.m4600j(23));
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(c2071i.m4600j(21));
        }
        if (typedArrayObtainStyledAttributes.hasValue(56)) {
            setPlaceholderTextColor(c2071i.m4600j(56));
        }
        C0430q c0430q = new C0430q(this, c2071i);
        this.f4499g = c0430q;
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(0, true);
        c2071i.m4608x();
        AbstractC0307B.m603s(this, 2);
        AbstractC0315J.m669l(this, 1);
        frameLayout.addView(c0439z);
        frameLayout.addView(c0430q);
        addView(frameLayout);
        setEnabled(z6);
        setHelperTextEnabled(z4);
        setErrorEnabled(z3);
        setCounterEnabled(z5);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f4501h;
        if (!(editText instanceof AutoCompleteTextView) || AbstractC1794d.m3951g(editText)) {
            return this.f4475H;
        }
        int iM4302c = AbstractC1920f.m4302c(this.f4501h, io.getgrass.www.R.attr.colorControlHighlight);
        int i3 = this.f4484Q;
        int[][] iArr = f4465C0;
        if (i3 != 2) {
            if (i3 != 1) {
                return null;
            }
            C0278g c0278g = this.f4475H;
            int i4 = this.f4490W;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{AbstractC1920f.m4309l(iM4302c, i4, 0.1f), i4}), c0278g, c0278g);
        }
        Context context = getContext();
        C0278g c0278g2 = this.f4475H;
        TypedValue typedValueM4298s = AbstractC1919e.m4298s(context, io.getgrass.www.R.attr.colorSurface, "TextInputLayout");
        int i5 = typedValueM4298s.resourceId;
        int iM4520a = i5 != 0 ? AbstractC2048d.m4520a(context, i5) : typedValueM4298s.data;
        C0278g c0278g3 = new C0278g(c0278g2.f719e.f697a);
        int iM4309l = AbstractC1920f.m4309l(iM4302c, iM4520a, 0.1f);
        c0278g3.m547k(new ColorStateList(iArr, new int[]{iM4309l, 0}));
        c0278g3.setTint(iM4520a);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iM4309l, iM4520a});
        C0278g c0278g4 = new C0278g(c0278g2.f719e.f697a);
        c0278g4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, c0278g3, c0278g4), c0278g2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f4477J == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f4477J = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f4477J.addState(new int[0], m3204f(false));
        }
        return this.f4477J;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f4476I == null) {
            this.f4476I = m3204f(true);
        }
        return this.f4476I;
    }

    /* JADX INFO: renamed from: k */
    public static void m3198k(ViewGroup viewGroup, boolean z3) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            childAt.setEnabled(z3);
            if (childAt instanceof ViewGroup) {
                m3198k((ViewGroup) childAt, z3);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f4501h != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f4501h = editText;
        int i3 = this.f4505j;
        if (i3 != -1) {
            setMinEms(i3);
        } else {
            setMinWidth(this.f4509l);
        }
        int i4 = this.f4507k;
        if (i4 != -1) {
            setMaxEms(i4);
        } else {
            setMaxWidth(this.f4511m);
        }
        this.f4478K = false;
        m3207i();
        setTextInputAccessibilityDelegate(new C0411E(this));
        Typeface typeface = this.f4501h.getTypeface();
        C0044d c0044d = this.f4532w0;
        c0044d.m205m(typeface);
        float textSize = this.f4501h.getTextSize();
        if (c0044d.f150h != textSize) {
            c0044d.f150h = textSize;
            c0044d.m200h(false);
        }
        float letterSpacing = this.f4501h.getLetterSpacing();
        if (c0044d.f133W != letterSpacing) {
            c0044d.f133W = letterSpacing;
            c0044d.m200h(false);
        }
        int gravity = this.f4501h.getGravity();
        int i5 = (gravity & (-113)) | 48;
        if (c0044d.f149g != i5) {
            c0044d.f149g = i5;
            c0044d.m200h(false);
        }
        if (c0044d.f147f != gravity) {
            c0044d.f147f = gravity;
            c0044d.m200h(false);
        }
        this.f4501h.addTextChangedListener(new C0408B(this, 0));
        if (this.f4508k0 == null) {
            this.f4508k0 = this.f4501h.getHintTextColors();
        }
        if (this.f4472E) {
            if (TextUtils.isEmpty(this.f4473F)) {
                CharSequence hint = this.f4501h.getHint();
                this.f4503i = hint;
                setHint(hint);
                this.f4501h.setHint((CharSequence) null);
            }
            this.f4474G = true;
        }
        if (this.f4523s != null) {
            m3211n(this.f4501h.getText());
        }
        m3214q();
        this.f4513n.m958b();
        this.f4497f.bringToFront();
        C0430q c0430q = this.f4499g;
        c0430q.bringToFront();
        Iterator it = this.f4500g0.iterator();
        while (it.hasNext()) {
            ((C0427n) it.next()).m935a(this);
        }
        c0430q.m952l();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        m3217t(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f4473F)) {
            return;
        }
        this.f4473F = charSequence;
        C0044d c0044d = this.f4532w0;
        if (charSequence == null || !TextUtils.equals(c0044d.f111A, charSequence)) {
            c0044d.f111A = charSequence;
            c0044d.f112B = null;
            Bitmap bitmap = c0044d.f115E;
            if (bitmap != null) {
                bitmap.recycle();
                c0044d.f115E = null;
            }
            c0044d.m200h(false);
        }
        if (this.f4530v0) {
            return;
        }
        m3208j();
    }

    private void setPlaceholderTextEnabled(boolean z3) {
        if (this.f4531w == z3) {
            return;
        }
        if (z3) {
            C1564X c1564x = this.f4533x;
            if (c1564x != null) {
                this.f4495e.addView(c1564x);
                this.f4533x.setVisibility(0);
            }
        } else {
            C1564X c1564x2 = this.f4533x;
            if (c1564x2 != null) {
                c1564x2.setVisibility(8);
            }
            this.f4533x = null;
        }
        this.f4531w = z3;
    }

    /* JADX INFO: renamed from: a */
    public final void m3199a(float f3) {
        int i3 = 0;
        C0044d c0044d = this.f4532w0;
        if (c0044d.f139b == f3) {
            return;
        }
        if (this.f4538z0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f4538z0 = valueAnimator;
            valueAnimator.setInterpolator(AbstractC1794d.m3955m(getContext(), io.getgrass.www.R.attr.motionEasingEmphasizedInterpolator, AbstractC1824a.f6321b));
            this.f4538z0.setDuration(AbstractC1794d.m3954l(getContext(), io.getgrass.www.R.attr.motionDurationMedium4, 167));
            this.f4538z0.addUpdateListener(new C0410D(i3, this));
        }
        this.f4538z0.setFloatValues(c0044d.f139b, f3);
        this.f4538z0.start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i3, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f4495e;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        m3216s();
        setEditText((EditText) view);
    }

    /* JADX INFO: renamed from: b */
    public final void m3200b() {
        int iM4520a;
        int i3;
        int i4;
        C0278g c0278g = this.f4475H;
        if (c0278g == null) {
            return;
        }
        C0281j c0281j = c0278g.f719e.f697a;
        C0281j c0281j2 = this.f4481N;
        if (c0281j != c0281j2) {
            c0278g.setShapeAppearanceModel(c0281j2);
        }
        if (this.f4484Q == 2 && (i3 = this.f4486S) > -1 && (i4 = this.f4489V) != 0) {
            C0278g c0278g2 = this.f4475H;
            c0278g2.f719e.f707k = i3;
            c0278g2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i4);
            C0277f c0277f = c0278g2.f719e;
            if (c0277f.f700d != colorStateListValueOf) {
                c0277f.f700d = colorStateListValueOf;
                c0278g2.onStateChange(c0278g2.getState());
            }
        }
        int iM105b = this.f4490W;
        if (this.f4484Q == 1) {
            Context context = getContext();
            TypedValue typedValueM4296q = AbstractC1919e.m4296q(context, io.getgrass.www.R.attr.colorSurface);
            if (typedValueM4296q != null) {
                int i5 = typedValueM4296q.resourceId;
                iM4520a = i5 != 0 ? AbstractC2048d.m4520a(context, i5) : typedValueM4296q.data;
            } else {
                iM4520a = 0;
            }
            iM105b = AbstractC0026a.m105b(this.f4490W, iM4520a);
        }
        this.f4490W = iM105b;
        this.f4475H.m547k(ColorStateList.valueOf(iM105b));
        C0278g c0278g3 = this.f4479L;
        if (c0278g3 != null && this.f4480M != null) {
            if (this.f4486S > -1 && this.f4489V != 0) {
                c0278g3.m547k(this.f4501h.isFocused() ? ColorStateList.valueOf(this.f4512m0) : ColorStateList.valueOf(this.f4489V));
                this.f4480M.m547k(ColorStateList.valueOf(this.f4489V));
            }
            invalidate();
        }
        m3215r();
    }

    /* JADX INFO: renamed from: c */
    public final int m3201c() {
        float fM197d;
        if (!this.f4472E) {
            return 0;
        }
        int i3 = this.f4484Q;
        C0044d c0044d = this.f4532w0;
        if (i3 == 0) {
            fM197d = c0044d.m197d();
        } else {
            if (i3 != 2) {
                return 0;
            }
            fM197d = c0044d.m197d() / 2.0f;
        }
        return (int) fM197d;
    }

    /* JADX INFO: renamed from: d */
    public final C1290i m3202d() {
        C1290i c1290i = new C1290i();
        c1290i.f4618g = AbstractC1794d.m3954l(getContext(), io.getgrass.www.R.attr.motionDurationShort2, 87);
        c1290i.f4619h = AbstractC1794d.m3955m(getContext(), io.getgrass.www.R.attr.motionEasingLinearInterpolator, AbstractC1824a.f6320a);
        return c1290i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i3) {
        EditText editText = this.f4501h;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i3);
            return;
        }
        if (this.f4503i != null) {
            boolean z3 = this.f4474G;
            this.f4474G = false;
            CharSequence hint = editText.getHint();
            this.f4501h.setHint(this.f4503i);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i3);
                return;
            } finally {
                this.f4501h.setHint(hint);
                this.f4474G = z3;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i3);
        onProvideAutofillVirtualStructure(viewStructure, i3);
        FrameLayout frameLayout = this.f4495e;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i4 = 0; i4 < frameLayout.getChildCount(); i4++) {
            View childAt = frameLayout.getChildAt(i4);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i4);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i3);
            if (childAt == this.f4501h) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.f4469B0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f4469B0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        C0278g c0278g;
        int i3;
        super.draw(canvas);
        boolean z3 = this.f4472E;
        C0044d c0044d = this.f4532w0;
        if (z3) {
            c0044d.getClass();
            int iSave = canvas.save();
            if (c0044d.f112B != null) {
                RectF rectF = c0044d.f145e;
                if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                    TextPaint textPaint = c0044d.f124N;
                    textPaint.setTextSize(c0044d.f117G);
                    float f3 = c0044d.f158p;
                    float f4 = c0044d.f159q;
                    float f5 = c0044d.f116F;
                    if (f5 != 1.0f) {
                        canvas.scale(f5, f5, f3, f4);
                    }
                    if (c0044d.f144d0 <= 1 || c0044d.f113C) {
                        canvas.translate(f3, f4);
                        c0044d.f135Y.draw(canvas);
                    } else {
                        float lineStart = c0044d.f158p - c0044d.f135Y.getLineStart(0);
                        int alpha = textPaint.getAlpha();
                        canvas.translate(lineStart, f4);
                        float f6 = alpha;
                        textPaint.setAlpha((int) (c0044d.f140b0 * f6));
                        int i4 = Build.VERSION.SDK_INT;
                        if (i4 >= 31) {
                            float f7 = c0044d.f118H;
                            float f8 = c0044d.f119I;
                            float f9 = c0044d.f120J;
                            int i5 = c0044d.f121K;
                            textPaint.setShadowLayer(f7, f8, f9, AbstractC0026a.m107d(i5, (textPaint.getAlpha() * Color.alpha(i5)) / 255));
                        }
                        c0044d.f135Y.draw(canvas);
                        textPaint.setAlpha((int) (c0044d.f138a0 * f6));
                        if (i4 >= 31) {
                            float f10 = c0044d.f118H;
                            float f11 = c0044d.f119I;
                            float f12 = c0044d.f120J;
                            int i6 = c0044d.f121K;
                            textPaint.setShadowLayer(f10, f11, f12, AbstractC0026a.m107d(i6, (Color.alpha(i6) * textPaint.getAlpha()) / 255));
                        }
                        int lineBaseline = c0044d.f135Y.getLineBaseline(0);
                        CharSequence charSequence = c0044d.f142c0;
                        float f13 = lineBaseline;
                        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f13, textPaint);
                        if (i4 >= 31) {
                            textPaint.setShadowLayer(c0044d.f118H, c0044d.f119I, c0044d.f120J, c0044d.f121K);
                        }
                        String strTrim = c0044d.f142c0.toString().trim();
                        if (strTrim.endsWith("…")) {
                            i3 = 0;
                            strTrim = strTrim.substring(0, strTrim.length() - 1);
                        } else {
                            i3 = 0;
                        }
                        String str = strTrim;
                        textPaint.setAlpha(alpha);
                        canvas.drawText(str, 0, Math.min(c0044d.f135Y.getLineEnd(i3), str.length()), 0.0f, f13, (Paint) textPaint);
                    }
                    canvas.restoreToCount(iSave);
                }
            }
        }
        if (this.f4480M == null || (c0278g = this.f4479L) == null) {
            return;
        }
        c0278g.draw(canvas);
        if (this.f4501h.isFocused()) {
            Rect bounds = this.f4480M.getBounds();
            Rect bounds2 = this.f4479L.getBounds();
            float f14 = c0044d.f139b;
            int iCenterX = bounds2.centerX();
            int i7 = bounds2.left;
            LinearInterpolator linearInterpolator = AbstractC1824a.f6320a;
            bounds.left = Math.round((i7 - iCenterX) * f14) + iCenterX;
            bounds.right = Math.round(f14 * (bounds2.right - iCenterX)) + iCenterX;
            this.f4480M.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.f4467A0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.f4467A0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            B1.d r3 = r4.f4532w0
            if (r3 == 0) goto L2f
            r3.f122L = r1
            android.content.res.ColorStateList r1 = r3.f153k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f152j
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.m200h(r2)
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            android.widget.EditText r3 = r4.f4501h
            if (r3 == 0) goto L47
            java.util.WeakHashMap r3 = p029J.AbstractC0323S.f816a
            boolean r3 = p029J.AbstractC0310E.m620c(r4)
            if (r3 == 0) goto L43
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L43
            goto L44
        L43:
            r0 = r2
        L44:
            r4.m3217t(r0, r2)
        L47:
            r4.m3214q()
            r4.m3220w()
            if (r1 == 0) goto L52
            r4.invalidate()
        L52:
            r4.f4467A0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    /* JADX INFO: renamed from: e */
    public final boolean m3203e() {
        return this.f4472E && !TextUtils.isEmpty(this.f4473F) && (this.f4475H instanceof C0420g);
    }

    /* JADX INFO: renamed from: f */
    public final C0278g m3204f(boolean z3) {
        float f3;
        TextInputLayout textInputLayout;
        int i3 = 0;
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(io.getgrass.www.R.dimen.mtrl_shape_corner_size_small_component);
        if (z3) {
            textInputLayout = this;
            f3 = dimensionPixelOffset;
        } else {
            f3 = 0.0f;
            textInputLayout = this;
        }
        EditText editText = textInputLayout.f4501h;
        float popupElevation = editText instanceof C0437x ? ((C0437x) editText).getPopupElevation() : getResources().getDimensionPixelOffset(io.getgrass.www.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(io.getgrass.www.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        C0280i c0280i = new C0280i();
        C0280i c0280i2 = new C0280i();
        C0280i c0280i3 = new C0280i();
        C0280i c0280i4 = new C0280i();
        C0276e c0276e = new C0276e(i3);
        C0276e c0276e2 = new C0276e(i3);
        C0276e c0276e3 = new C0276e(i3);
        C0276e c0276e4 = new C0276e(i3);
        C0272a c0272a = new C0272a(f3);
        C0272a c0272a2 = new C0272a(f3);
        C0272a c0272a3 = new C0272a(dimensionPixelOffset);
        C0272a c0272a4 = new C0272a(dimensionPixelOffset);
        C0281j c0281j = new C0281j();
        c0281j.f742a = c0280i;
        c0281j.f743b = c0280i2;
        c0281j.f744c = c0280i3;
        c0281j.f745d = c0280i4;
        c0281j.f746e = c0272a;
        c0281j.f747f = c0272a2;
        c0281j.f748g = c0272a4;
        c0281j.f749h = c0272a3;
        c0281j.f750i = c0276e;
        c0281j.f751j = c0276e2;
        c0281j.f752k = c0276e3;
        c0281j.f753l = c0276e4;
        Context context = getContext();
        Paint paint = C0278g.f718A;
        TypedValue typedValueM4298s = AbstractC1919e.m4298s(context, io.getgrass.www.R.attr.colorSurface, C0278g.class.getSimpleName());
        int i4 = typedValueM4298s.resourceId;
        int iM4520a = i4 != 0 ? AbstractC2048d.m4520a(context, i4) : typedValueM4298s.data;
        C0278g c0278g = new C0278g();
        c0278g.m545i(context);
        c0278g.m547k(ColorStateList.valueOf(iM4520a));
        c0278g.m546j(popupElevation);
        c0278g.setShapeAppearanceModel(c0281j);
        C0277f c0277f = c0278g.f719e;
        if (c0277f.f704h == null) {
            c0277f.f704h = new Rect();
        }
        c0278g.f719e.f704h.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        c0278g.invalidateSelf();
        return c0278g;
    }

    /* JADX INFO: renamed from: g */
    public final int m3205g(int i3, boolean z3) {
        int compoundPaddingLeft = this.f4501h.getCompoundPaddingLeft() + i3;
        return (getPrefixText() == null || z3) ? compoundPaddingLeft : (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f4501h;
        if (editText == null) {
            return super.getBaseline();
        }
        return m3201c() + getPaddingTop() + editText.getBaseline();
    }

    public C0278g getBoxBackground() {
        int i3 = this.f4484Q;
        if (i3 == 1 || i3 == 2) {
            return this.f4475H;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f4490W;
    }

    public int getBoxBackgroundMode() {
        return this.f4484Q;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f4485R;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean zM215e = AbstractC0054n.m215e(this);
        RectF rectF = this.f4493c0;
        return zM215e ? this.f4481N.f749h.mo529a(rectF) : this.f4481N.f748g.mo529a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean zM215e = AbstractC0054n.m215e(this);
        RectF rectF = this.f4493c0;
        return zM215e ? this.f4481N.f748g.mo529a(rectF) : this.f4481N.f749h.mo529a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean zM215e = AbstractC0054n.m215e(this);
        RectF rectF = this.f4493c0;
        return zM215e ? this.f4481N.f746e.mo529a(rectF) : this.f4481N.f747f.mo529a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean zM215e = AbstractC0054n.m215e(this);
        RectF rectF = this.f4493c0;
        return zM215e ? this.f4481N.f747f.mo529a(rectF) : this.f4481N.f746e.mo529a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f4516o0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f4518p0;
    }

    public int getBoxStrokeWidth() {
        return this.f4487T;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f4488U;
    }

    public int getCounterMaxLength() {
        return this.f4517p;
    }

    public CharSequence getCounterOverflowDescription() {
        C1564X c1564x;
        if (this.f4515o && this.f4519q && (c1564x = this.f4523s) != null) {
            return c1564x.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f4471D;
    }

    public ColorStateList getCounterTextColor() {
        return this.f4470C;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f4508k0;
    }

    public EditText getEditText() {
        return this.f4501h;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f4499g.f995k.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f4499g.f995k.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f4499g.f1001q;
    }

    public int getEndIconMode() {
        return this.f4499g.f997m;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f4499g.f1002r;
    }

    public CheckableImageButton getEndIconView() {
        return this.f4499g.f995k;
    }

    public CharSequence getError() {
        C0434u c0434u = this.f4513n;
        if (c0434u.f1039q) {
            return c0434u.f1038p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f4513n.f1042t;
    }

    public CharSequence getErrorContentDescription() {
        return this.f4513n.f1041s;
    }

    public int getErrorCurrentTextColors() {
        C1564X c1564x = this.f4513n.f1040r;
        if (c1564x != null) {
            return c1564x.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f4499g.f991g.getDrawable();
    }

    public CharSequence getHelperText() {
        C0434u c0434u = this.f4513n;
        if (c0434u.f1046x) {
            return c0434u.f1045w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        C1564X c1564x = this.f4513n.f1047y;
        if (c1564x != null) {
            return c1564x.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.f4472E) {
            return this.f4473F;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f4532w0.m197d();
    }

    public final int getHintCurrentCollapsedTextColor() {
        C0044d c0044d = this.f4532w0;
        return c0044d.m198e(c0044d.f153k);
    }

    public ColorStateList getHintTextColor() {
        return this.f4510l0;
    }

    public InterfaceC0412F getLengthCounter() {
        return this.f4521r;
    }

    public int getMaxEms() {
        return this.f4507k;
    }

    public int getMaxWidth() {
        return this.f4511m;
    }

    public int getMinEms() {
        return this.f4505j;
    }

    public int getMinWidth() {
        return this.f4509l;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f4499g.f995k.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f4499g.f995k.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f4531w) {
            return this.f4529v;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f4537z;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f4535y;
    }

    public CharSequence getPrefixText() {
        return this.f4497f.f1066g;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f4497f.f1065f.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f4497f.f1065f;
    }

    public C0281j getShapeAppearanceModel() {
        return this.f4481N;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f4497f.f1067h.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f4497f.f1067h.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f4497f.f1070k;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f4497f.f1071l;
    }

    public CharSequence getSuffixText() {
        return this.f4499g.f1004t;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f4499g.f1005u.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f4499g.f1005u;
    }

    public Typeface getTypeface() {
        return this.f4494d0;
    }

    /* JADX INFO: renamed from: h */
    public final int m3206h(int i3, boolean z3) {
        int compoundPaddingRight = i3 - this.f4501h.getCompoundPaddingRight();
        return (getPrefixText() == null || !z3) ? compoundPaddingRight : compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    }

    /* JADX INFO: renamed from: i */
    public final void m3207i() {
        int i3 = this.f4484Q;
        if (i3 == 0) {
            this.f4475H = null;
            this.f4479L = null;
            this.f4480M = null;
        } else if (i3 == 1) {
            this.f4475H = new C0278g(this.f4481N);
            this.f4479L = new C0278g();
            this.f4480M = new C0278g();
        } else {
            if (i3 != 2) {
                throw new IllegalArgumentException(this.f4484Q + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.f4472E || (this.f4475H instanceof C0420g)) {
                this.f4475H = new C0278g(this.f4481N);
            } else {
                C0281j c0281j = this.f4481N;
                int i4 = C0420g.f960C;
                this.f4475H = new C0420g(c0281j);
            }
            this.f4479L = null;
            this.f4480M = null;
        }
        m3215r();
        m3220w();
        if (this.f4484Q == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.f4485R = getResources().getDimensionPixelSize(io.getgrass.www.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (AbstractC1920f.m4308k(getContext())) {
                this.f4485R = getResources().getDimensionPixelSize(io.getgrass.www.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.f4501h != null && this.f4484Q == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText = this.f4501h;
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                AbstractC0308C.m614k(editText, AbstractC0308C.m609f(editText), getResources().getDimensionPixelSize(io.getgrass.www.R.dimen.material_filled_edittext_font_2_0_padding_top), AbstractC0308C.m608e(this.f4501h), getResources().getDimensionPixelSize(io.getgrass.www.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (AbstractC1920f.m4308k(getContext())) {
                EditText editText2 = this.f4501h;
                WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
                AbstractC0308C.m614k(editText2, AbstractC0308C.m609f(editText2), getResources().getDimensionPixelSize(io.getgrass.www.R.dimen.material_filled_edittext_font_1_3_padding_top), AbstractC0308C.m608e(this.f4501h), getResources().getDimensionPixelSize(io.getgrass.www.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.f4484Q != 0) {
            m3216s();
        }
        EditText editText3 = this.f4501h;
        if (editText3 instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText3;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i5 = this.f4484Q;
                if (i5 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i5 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008d  */
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3208j() {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.m3208j():void");
    }

    /* JADX INFO: renamed from: l */
    public final void m3209l(TextView textView, int i3) {
        try {
            textView.setTextAppearance(i3);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        textView.setTextAppearance(io.getgrass.www.R.style.TextAppearance_AppCompat_Caption);
        textView.setTextColor(AbstractC2048d.m4520a(getContext(), io.getgrass.www.R.color.design_error));
    }

    /* JADX INFO: renamed from: m */
    public final boolean m3210m() {
        C0434u c0434u = this.f4513n;
        return (c0434u.f1037o != 1 || c0434u.f1040r == null || TextUtils.isEmpty(c0434u.f1038p)) ? false : true;
    }

    /* JADX INFO: renamed from: n */
    public final void m3211n(Editable editable) {
        ((C0407A) this.f4521r).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z3 = this.f4519q;
        int i3 = this.f4517p;
        String string = null;
        if (i3 == -1) {
            this.f4523s.setText(String.valueOf(length));
            this.f4523s.setContentDescription(null);
            this.f4519q = false;
        } else {
            this.f4519q = length > i3;
            Context context = getContext();
            this.f4523s.setContentDescription(context.getString(this.f4519q ? io.getgrass.www.R.string.character_counter_overflowed_content_description : io.getgrass.www.R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.f4517p)));
            if (z3 != this.f4519q) {
                m3212o();
            }
            String str = C0239b.f587d;
            Locale locale = Locale.getDefault();
            int i4 = AbstractC0246i.f603a;
            C0239b c0239b = AbstractC0245h.m484a(locale) == 1 ? C0239b.f590g : C0239b.f589f;
            C1564X c1564x = this.f4523s;
            String string2 = getContext().getString(io.getgrass.www.R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.f4517p));
            if (string2 == null) {
                c0239b.getClass();
            } else {
                C0181e c0181e = c0239b.f593c;
                string = c0239b.m479c(string2).toString();
            }
            c1564x.setText(string);
        }
        if (this.f4501h == null || z3 == this.f4519q) {
            return;
        }
        m3217t(false, false);
        m3220w();
        m3214q();
    }

    /* JADX INFO: renamed from: o */
    public final void m3212o() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        C1564X c1564x = this.f4523s;
        if (c1564x != null) {
            m3209l(c1564x, this.f4519q ? this.f4525t : this.f4527u);
            if (!this.f4519q && (colorStateList2 = this.f4470C) != null) {
                this.f4523s.setTextColor(colorStateList2);
            }
            if (!this.f4519q || (colorStateList = this.f4471D) == null) {
                return;
            }
            this.f4523s.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f4532w0.m199g(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        EditText editText = this.f4501h;
        if (editText != null) {
            ThreadLocal threadLocal = AbstractC0045e.f169a;
            int width = editText.getWidth();
            int height = editText.getHeight();
            Rect rect = this.f4491a0;
            rect.set(0, 0, width, height);
            ThreadLocal threadLocal2 = AbstractC0045e.f169a;
            Matrix matrix = (Matrix) threadLocal2.get();
            if (matrix == null) {
                matrix = new Matrix();
                threadLocal2.set(matrix);
            } else {
                matrix.reset();
            }
            AbstractC0045e.m206a(this, editText, matrix);
            ThreadLocal threadLocal3 = AbstractC0045e.f170b;
            RectF rectF = (RectF) threadLocal3.get();
            if (rectF == null) {
                rectF = new RectF();
                threadLocal3.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
            C0278g c0278g = this.f4479L;
            if (c0278g != null) {
                int i7 = rect.bottom;
                c0278g.setBounds(rect.left, i7 - this.f4487T, rect.right, i7);
            }
            C0278g c0278g2 = this.f4480M;
            if (c0278g2 != null) {
                int i8 = rect.bottom;
                c0278g2.setBounds(rect.left, i8 - this.f4488U, rect.right, i8);
            }
            if (this.f4472E) {
                float textSize = this.f4501h.getTextSize();
                C0044d c0044d = this.f4532w0;
                if (c0044d.f150h != textSize) {
                    c0044d.f150h = textSize;
                    c0044d.m200h(false);
                }
                int gravity = this.f4501h.getGravity();
                int i9 = (gravity & (-113)) | 48;
                if (c0044d.f149g != i9) {
                    c0044d.f149g = i9;
                    c0044d.m200h(false);
                }
                if (c0044d.f147f != gravity) {
                    c0044d.f147f = gravity;
                    c0044d.m200h(false);
                }
                if (this.f4501h == null) {
                    throw new IllegalStateException();
                }
                boolean zM215e = AbstractC0054n.m215e(this);
                int i10 = rect.bottom;
                Rect rect2 = this.f4492b0;
                rect2.bottom = i10;
                int i11 = this.f4484Q;
                if (i11 == 1) {
                    rect2.left = m3205g(rect.left, zM215e);
                    rect2.top = rect.top + this.f4485R;
                    rect2.right = m3206h(rect.right, zM215e);
                } else if (i11 != 2) {
                    rect2.left = m3205g(rect.left, zM215e);
                    rect2.top = getPaddingTop();
                    rect2.right = m3206h(rect.right, zM215e);
                } else {
                    rect2.left = this.f4501h.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - m3201c();
                    rect2.right = rect.right - this.f4501h.getPaddingRight();
                }
                int i12 = rect2.left;
                int i13 = rect2.top;
                int i14 = rect2.right;
                int i15 = rect2.bottom;
                Rect rect3 = c0044d.f143d;
                if (rect3.left != i12 || rect3.top != i13 || rect3.right != i14 || rect3.bottom != i15) {
                    rect3.set(i12, i13, i14, i15);
                    c0044d.f123M = true;
                }
                if (this.f4501h == null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint = c0044d.f125O;
                textPaint.setTextSize(c0044d.f150h);
                textPaint.setTypeface(c0044d.f163u);
                textPaint.setLetterSpacing(c0044d.f133W);
                float f3 = -textPaint.ascent();
                rect2.left = this.f4501h.getCompoundPaddingLeft() + rect.left;
                rect2.top = (this.f4484Q != 1 || this.f4501h.getMinLines() > 1) ? rect.top + this.f4501h.getCompoundPaddingTop() : (int) (rect.centerY() - (f3 / 2.0f));
                rect2.right = rect.right - this.f4501h.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.f4484Q != 1 || this.f4501h.getMinLines() > 1) ? rect.bottom - this.f4501h.getCompoundPaddingBottom() : (int) (rect2.top + f3);
                rect2.bottom = compoundPaddingBottom;
                int i16 = rect2.left;
                int i17 = rect2.top;
                int i18 = rect2.right;
                Rect rect4 = c0044d.f141c;
                if (rect4.left != i16 || rect4.top != i17 || rect4.right != i18 || rect4.bottom != compoundPaddingBottom) {
                    rect4.set(i16, i17, i18, compoundPaddingBottom);
                    c0044d.f123M = true;
                }
                c0044d.m200h(false);
                if (!m3203e() || this.f4530v0) {
                    return;
                }
                m3208j();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        EditText editText;
        int iMax;
        super.onMeasure(i3, i4);
        EditText editText2 = this.f4501h;
        C0430q c0430q = this.f4499g;
        boolean z3 = false;
        if (editText2 != null && this.f4501h.getMeasuredHeight() < (iMax = Math.max(c0430q.getMeasuredHeight(), this.f4497f.getMeasuredHeight()))) {
            this.f4501h.setMinimumHeight(iMax);
            z3 = true;
        }
        boolean zM3213p = m3213p();
        if (z3 || zM3213p) {
            this.f4501h.post(new RunnableC0409C(this, 1));
        }
        if (this.f4533x != null && (editText = this.f4501h) != null) {
            this.f4533x.setGravity(editText.getGravity());
            this.f4533x.setPadding(this.f4501h.getCompoundPaddingLeft(), this.f4501h.getCompoundPaddingTop(), this.f4501h.getCompoundPaddingRight(), this.f4501h.getCompoundPaddingBottom());
        }
        c0430q.m952l();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0413G)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0413G c0413g = (C0413G) parcelable;
        super.onRestoreInstanceState(c0413g.f1425e);
        setError(c0413g.f940g);
        if (c0413g.f941h) {
            post(new RunnableC0409C(this, 0));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        boolean z3 = i3 == 1;
        if (z3 != this.f4482O) {
            InterfaceC0274c interfaceC0274c = this.f4481N.f746e;
            RectF rectF = this.f4493c0;
            float fMo529a = interfaceC0274c.mo529a(rectF);
            float fMo529a2 = this.f4481N.f747f.mo529a(rectF);
            float fMo529a3 = this.f4481N.f749h.mo529a(rectF);
            float fMo529a4 = this.f4481N.f748g.mo529a(rectF);
            C0281j c0281j = this.f4481N;
            AbstractC0406d abstractC0406d = c0281j.f742a;
            AbstractC0406d abstractC0406d2 = c0281j.f743b;
            AbstractC0406d abstractC0406d3 = c0281j.f745d;
            AbstractC0406d abstractC0406d4 = c0281j.f744c;
            C0276e c0276e = new C0276e(0);
            C0276e c0276e2 = new C0276e(0);
            C0276e c0276e3 = new C0276e(0);
            C0276e c0276e4 = new C0276e(0);
            C1916b.m4264b(abstractC0406d2);
            C1916b.m4264b(abstractC0406d);
            C1916b.m4264b(abstractC0406d4);
            C1916b.m4264b(abstractC0406d3);
            C0272a c0272a = new C0272a(fMo529a2);
            C0272a c0272a2 = new C0272a(fMo529a);
            C0272a c0272a3 = new C0272a(fMo529a4);
            C0272a c0272a4 = new C0272a(fMo529a3);
            C0281j c0281j2 = new C0281j();
            c0281j2.f742a = abstractC0406d2;
            c0281j2.f743b = abstractC0406d;
            c0281j2.f744c = abstractC0406d3;
            c0281j2.f745d = abstractC0406d4;
            c0281j2.f746e = c0272a;
            c0281j2.f747f = c0272a2;
            c0281j2.f748g = c0272a4;
            c0281j2.f749h = c0272a3;
            c0281j2.f750i = c0276e;
            c0281j2.f751j = c0276e2;
            c0281j2.f752k = c0276e3;
            c0281j2.f753l = c0276e4;
            this.f4482O = z3;
            setShapeAppearanceModel(c0281j2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C0413G c0413g = new C0413G(super.onSaveInstanceState());
        if (m3210m()) {
            c0413g.f940g = getError();
        }
        C0430q c0430q = this.f4499g;
        c0413g.f941h = c0430q.f997m != 0 && c0430q.f995k.f4424h;
        return c0413g;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX INFO: renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3213p() {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.m3213p():boolean");
    }

    /* JADX INFO: renamed from: q */
    public final void m3214q() {
        Drawable background;
        C1564X c1564x;
        PorterDuffColorFilter porterDuffColorFilterM3579g;
        PorterDuffColorFilter porterDuffColorFilterM3579g2;
        EditText editText = this.f4501h;
        if (editText == null || this.f4484Q != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = AbstractC1589g0.f5636a;
        Drawable drawableMutate = background.mutate();
        if (m3210m()) {
            int errorCurrentTextColors = getErrorCurrentTextColors();
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            PorterDuff.Mode mode2 = C1613r.f5721b;
            synchronized (C1613r.class) {
                porterDuffColorFilterM3579g2 = C1532G0.m3579g(errorCurrentTextColors, mode);
            }
            drawableMutate.setColorFilter(porterDuffColorFilterM3579g2);
            return;
        }
        if (!this.f4519q || (c1564x = this.f4523s) == null) {
            drawableMutate.clearColorFilter();
            this.f4501h.refreshDrawableState();
            return;
        }
        int currentTextColor = c1564x.getCurrentTextColor();
        PorterDuff.Mode mode3 = PorterDuff.Mode.SRC_IN;
        PorterDuff.Mode mode4 = C1613r.f5721b;
        synchronized (C1613r.class) {
            porterDuffColorFilterM3579g = C1532G0.m3579g(currentTextColor, mode3);
        }
        drawableMutate.setColorFilter(porterDuffColorFilterM3579g);
    }

    /* JADX INFO: renamed from: r */
    public final void m3215r() {
        EditText editText = this.f4501h;
        if (editText == null || this.f4475H == null) {
            return;
        }
        if ((this.f4478K || editText.getBackground() == null) && this.f4484Q != 0) {
            EditText editText2 = this.f4501h;
            Drawable editTextBoxBackground = getEditTextBoxBackground();
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0307B.m601q(editText2, editTextBoxBackground);
            this.f4478K = true;
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m3216s() {
        if (this.f4484Q != 1) {
            FrameLayout frameLayout = this.f4495e;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iM3201c = m3201c();
            if (iM3201c != layoutParams.topMargin) {
                layoutParams.topMargin = iM3201c;
                frameLayout.requestLayout();
            }
        }
    }

    public void setBoxBackgroundColor(int i3) {
        if (this.f4490W != i3) {
            this.f4490W = i3;
            this.f4520q0 = i3;
            this.f4524s0 = i3;
            this.f4526t0 = i3;
            m3200b();
        }
    }

    public void setBoxBackgroundColorResource(int i3) {
        setBoxBackgroundColor(AbstractC2048d.m4520a(getContext(), i3));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f4520q0 = defaultColor;
        this.f4490W = defaultColor;
        this.f4522r0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f4524s0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f4526t0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        m3200b();
    }

    public void setBoxBackgroundMode(int i3) {
        if (i3 == this.f4484Q) {
            return;
        }
        this.f4484Q = i3;
        if (this.f4501h != null) {
            m3207i();
        }
    }

    public void setBoxCollapsedPaddingTop(int i3) {
        this.f4485R = i3;
    }

    public void setBoxCornerFamily(int i3) {
        C1916b c1916bM555e = this.f4481N.m555e();
        InterfaceC0274c interfaceC0274c = this.f4481N.f746e;
        AbstractC0406d abstractC0406dM997I = AbstractC0473V.m997I(i3);
        c1916bM555e.f6699a = abstractC0406dM997I;
        C1916b.m4264b(abstractC0406dM997I);
        c1916bM555e.f6703e = interfaceC0274c;
        InterfaceC0274c interfaceC0274c2 = this.f4481N.f747f;
        AbstractC0406d abstractC0406dM997I2 = AbstractC0473V.m997I(i3);
        c1916bM555e.f6700b = abstractC0406dM997I2;
        C1916b.m4264b(abstractC0406dM997I2);
        c1916bM555e.f6704f = interfaceC0274c2;
        InterfaceC0274c interfaceC0274c3 = this.f4481N.f749h;
        AbstractC0406d abstractC0406dM997I3 = AbstractC0473V.m997I(i3);
        c1916bM555e.f6702d = abstractC0406dM997I3;
        C1916b.m4264b(abstractC0406dM997I3);
        c1916bM555e.f6706h = interfaceC0274c3;
        InterfaceC0274c interfaceC0274c4 = this.f4481N.f748g;
        AbstractC0406d abstractC0406dM997I4 = AbstractC0473V.m997I(i3);
        c1916bM555e.f6701c = abstractC0406dM997I4;
        C1916b.m4264b(abstractC0406dM997I4);
        c1916bM555e.f6705g = interfaceC0274c4;
        this.f4481N = c1916bM555e.m4266a();
        m3200b();
    }

    public void setBoxStrokeColor(int i3) {
        if (this.f4516o0 != i3) {
            this.f4516o0 = i3;
            m3220w();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f4512m0 = colorStateList.getDefaultColor();
            this.f4528u0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f4514n0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f4516o0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f4516o0 != colorStateList.getDefaultColor()) {
            this.f4516o0 = colorStateList.getDefaultColor();
        }
        m3220w();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f4518p0 != colorStateList) {
            this.f4518p0 = colorStateList;
            m3220w();
        }
    }

    public void setBoxStrokeWidth(int i3) {
        this.f4487T = i3;
        m3220w();
    }

    public void setBoxStrokeWidthFocused(int i3) {
        this.f4488U = i3;
        m3220w();
    }

    public void setBoxStrokeWidthFocusedResource(int i3) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i3));
    }

    public void setBoxStrokeWidthResource(int i3) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i3));
    }

    public void setCounterEnabled(boolean z3) {
        if (this.f4515o != z3) {
            C0434u c0434u = this.f4513n;
            if (z3) {
                C1564X c1564x = new C1564X(getContext(), null);
                this.f4523s = c1564x;
                c1564x.setId(io.getgrass.www.R.id.textinput_counter);
                Typeface typeface = this.f4494d0;
                if (typeface != null) {
                    this.f4523s.setTypeface(typeface);
                }
                this.f4523s.setMaxLines(1);
                c0434u.m957a(this.f4523s, 2);
                AbstractC0353l.m776h((ViewGroup.MarginLayoutParams) this.f4523s.getLayoutParams(), getResources().getDimensionPixelOffset(io.getgrass.www.R.dimen.mtrl_textinput_counter_margin_start));
                m3212o();
                if (this.f4523s != null) {
                    EditText editText = this.f4501h;
                    m3211n(editText != null ? editText.getText() : null);
                }
            } else {
                c0434u.m963g(this.f4523s, 2);
                this.f4523s = null;
            }
            this.f4515o = z3;
        }
    }

    public void setCounterMaxLength(int i3) {
        if (this.f4517p != i3) {
            if (i3 > 0) {
                this.f4517p = i3;
            } else {
                this.f4517p = -1;
            }
            if (!this.f4515o || this.f4523s == null) {
                return;
            }
            EditText editText = this.f4501h;
            m3211n(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i3) {
        if (this.f4525t != i3) {
            this.f4525t = i3;
            m3212o();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f4471D != colorStateList) {
            this.f4471D = colorStateList;
            m3212o();
        }
    }

    public void setCounterTextAppearance(int i3) {
        if (this.f4527u != i3) {
            this.f4527u = i3;
            m3212o();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f4470C != colorStateList) {
            this.f4470C = colorStateList;
            m3212o();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f4508k0 = colorStateList;
        this.f4510l0 = colorStateList;
        if (this.f4501h != null) {
            m3217t(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        m3198k(this, z3);
        super.setEnabled(z3);
    }

    public void setEndIconActivated(boolean z3) {
        this.f4499g.f995k.setActivated(z3);
    }

    public void setEndIconCheckable(boolean z3) {
        this.f4499g.f995k.setCheckable(z3);
    }

    public void setEndIconContentDescription(int i3) {
        C0430q c0430q = this.f4499g;
        CharSequence text = i3 != 0 ? c0430q.getResources().getText(i3) : null;
        CheckableImageButton checkableImageButton = c0430q.f995k;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i3) {
        C0430q c0430q = this.f4499g;
        Drawable drawableM3991i = i3 != 0 ? AbstractC1800j.m3991i(c0430q.getContext(), i3) : null;
        CheckableImageButton checkableImageButton = c0430q.f995k;
        checkableImageButton.setImageDrawable(drawableM3991i);
        if (drawableM3991i != null) {
            ColorStateList colorStateList = c0430q.f999o;
            PorterDuff.Mode mode = c0430q.f1000p;
            TextInputLayout textInputLayout = c0430q.f989e;
            AbstractC1800j.m3985c(textInputLayout, checkableImageButton, colorStateList, mode);
            AbstractC1800j.m3993k(textInputLayout, checkableImageButton, c0430q.f999o);
        }
    }

    public void setEndIconMinSize(int i3) {
        C0430q c0430q = this.f4499g;
        if (i3 < 0) {
            c0430q.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i3 != c0430q.f1001q) {
            c0430q.f1001q = i3;
            CheckableImageButton checkableImageButton = c0430q.f995k;
            checkableImageButton.setMinimumWidth(i3);
            checkableImageButton.setMinimumHeight(i3);
            CheckableImageButton checkableImageButton2 = c0430q.f991g;
            checkableImageButton2.setMinimumWidth(i3);
            checkableImageButton2.setMinimumHeight(i3);
        }
    }

    public void setEndIconMode(int i3) {
        this.f4499g.m946f(i3);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        C0430q c0430q = this.f4499g;
        View.OnLongClickListener onLongClickListener = c0430q.f1003s;
        CheckableImageButton checkableImageButton = c0430q.f995k;
        checkableImageButton.setOnClickListener(onClickListener);
        AbstractC1800j.m3994l(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        C0430q c0430q = this.f4499g;
        c0430q.f1003s = onLongClickListener;
        CheckableImageButton checkableImageButton = c0430q.f995k;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        AbstractC1800j.m3994l(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        C0430q c0430q = this.f4499g;
        c0430q.f1002r = scaleType;
        c0430q.f995k.setScaleType(scaleType);
        c0430q.f991g.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        C0430q c0430q = this.f4499g;
        if (c0430q.f999o != colorStateList) {
            c0430q.f999o = colorStateList;
            AbstractC1800j.m3985c(c0430q.f989e, c0430q.f995k, colorStateList, c0430q.f1000p);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        C0430q c0430q = this.f4499g;
        if (c0430q.f1000p != mode) {
            c0430q.f1000p = mode;
            AbstractC1800j.m3985c(c0430q.f989e, c0430q.f995k, c0430q.f999o, mode);
        }
    }

    public void setEndIconVisible(boolean z3) {
        this.f4499g.m947g(z3);
    }

    public void setError(CharSequence charSequence) {
        C0434u c0434u = this.f4513n;
        if (!c0434u.f1039q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            c0434u.m962f();
            return;
        }
        c0434u.m959c();
        c0434u.f1038p = charSequence;
        c0434u.f1040r.setText(charSequence);
        int i3 = c0434u.f1036n;
        if (i3 != 1) {
            c0434u.f1037o = 1;
        }
        c0434u.m965i(i3, c0434u.f1037o, c0434u.m964h(c0434u.f1040r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i3) {
        C0434u c0434u = this.f4513n;
        c0434u.f1042t = i3;
        C1564X c1564x = c0434u.f1040r;
        if (c1564x != null) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0310E.m623f(c1564x, i3);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        C0434u c0434u = this.f4513n;
        c0434u.f1041s = charSequence;
        C1564X c1564x = c0434u.f1040r;
        if (c1564x != null) {
            c1564x.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z3) {
        C0434u c0434u = this.f4513n;
        if (c0434u.f1039q == z3) {
            return;
        }
        c0434u.m959c();
        TextInputLayout textInputLayout = c0434u.f1030h;
        if (z3) {
            C1564X c1564x = new C1564X(c0434u.f1029g, null);
            c0434u.f1040r = c1564x;
            c1564x.setId(io.getgrass.www.R.id.textinput_error);
            c0434u.f1040r.setTextAlignment(5);
            Typeface typeface = c0434u.f1022B;
            if (typeface != null) {
                c0434u.f1040r.setTypeface(typeface);
            }
            int i3 = c0434u.f1043u;
            c0434u.f1043u = i3;
            C1564X c1564x2 = c0434u.f1040r;
            if (c1564x2 != null) {
                textInputLayout.m3209l(c1564x2, i3);
            }
            ColorStateList colorStateList = c0434u.f1044v;
            c0434u.f1044v = colorStateList;
            C1564X c1564x3 = c0434u.f1040r;
            if (c1564x3 != null && colorStateList != null) {
                c1564x3.setTextColor(colorStateList);
            }
            CharSequence charSequence = c0434u.f1041s;
            c0434u.f1041s = charSequence;
            C1564X c1564x4 = c0434u.f1040r;
            if (c1564x4 != null) {
                c1564x4.setContentDescription(charSequence);
            }
            int i4 = c0434u.f1042t;
            c0434u.f1042t = i4;
            C1564X c1564x5 = c0434u.f1040r;
            if (c1564x5 != null) {
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                AbstractC0310E.m623f(c1564x5, i4);
            }
            c0434u.f1040r.setVisibility(4);
            c0434u.m957a(c0434u.f1040r, 0);
        } else {
            c0434u.m962f();
            c0434u.m963g(c0434u.f1040r, 0);
            c0434u.f1040r = null;
            textInputLayout.m3214q();
            textInputLayout.m3220w();
        }
        c0434u.f1039q = z3;
    }

    public void setErrorIconDrawable(int i3) {
        C0430q c0430q = this.f4499g;
        c0430q.m948h(i3 != 0 ? AbstractC1800j.m3991i(c0430q.getContext(), i3) : null);
        AbstractC1800j.m3993k(c0430q.f989e, c0430q.f991g, c0430q.f992h);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        C0430q c0430q = this.f4499g;
        CheckableImageButton checkableImageButton = c0430q.f991g;
        View.OnLongClickListener onLongClickListener = c0430q.f994j;
        checkableImageButton.setOnClickListener(onClickListener);
        AbstractC1800j.m3994l(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        C0430q c0430q = this.f4499g;
        c0430q.f994j = onLongClickListener;
        CheckableImageButton checkableImageButton = c0430q.f991g;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        AbstractC1800j.m3994l(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        C0430q c0430q = this.f4499g;
        if (c0430q.f992h != colorStateList) {
            c0430q.f992h = colorStateList;
            AbstractC1800j.m3985c(c0430q.f989e, c0430q.f991g, colorStateList, c0430q.f993i);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        C0430q c0430q = this.f4499g;
        if (c0430q.f993i != mode) {
            c0430q.f993i = mode;
            AbstractC1800j.m3985c(c0430q.f989e, c0430q.f991g, c0430q.f992h, mode);
        }
    }

    public void setErrorTextAppearance(int i3) {
        C0434u c0434u = this.f4513n;
        c0434u.f1043u = i3;
        C1564X c1564x = c0434u.f1040r;
        if (c1564x != null) {
            c0434u.f1030h.m3209l(c1564x, i3);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        C0434u c0434u = this.f4513n;
        c0434u.f1044v = colorStateList;
        C1564X c1564x = c0434u.f1040r;
        if (c1564x == null || colorStateList == null) {
            return;
        }
        c1564x.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z3) {
        if (this.f4534x0 != z3) {
            this.f4534x0 = z3;
            m3217t(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        C0434u c0434u = this.f4513n;
        if (zIsEmpty) {
            if (c0434u.f1046x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!c0434u.f1046x) {
            setHelperTextEnabled(true);
        }
        c0434u.m959c();
        c0434u.f1045w = charSequence;
        c0434u.f1047y.setText(charSequence);
        int i3 = c0434u.f1036n;
        if (i3 != 2) {
            c0434u.f1037o = 2;
        }
        c0434u.m965i(i3, c0434u.f1037o, c0434u.m964h(c0434u.f1047y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        C0434u c0434u = this.f4513n;
        c0434u.f1021A = colorStateList;
        C1564X c1564x = c0434u.f1047y;
        if (c1564x == null || colorStateList == null) {
            return;
        }
        c1564x.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z3) {
        C0434u c0434u = this.f4513n;
        if (c0434u.f1046x == z3) {
            return;
        }
        c0434u.m959c();
        if (z3) {
            C1564X c1564x = new C1564X(c0434u.f1029g, null);
            c0434u.f1047y = c1564x;
            c1564x.setId(io.getgrass.www.R.id.textinput_helper_text);
            c0434u.f1047y.setTextAlignment(5);
            Typeface typeface = c0434u.f1022B;
            if (typeface != null) {
                c0434u.f1047y.setTypeface(typeface);
            }
            c0434u.f1047y.setVisibility(4);
            AbstractC0310E.m623f(c0434u.f1047y, 1);
            int i3 = c0434u.f1048z;
            c0434u.f1048z = i3;
            C1564X c1564x2 = c0434u.f1047y;
            if (c1564x2 != null) {
                c1564x2.setTextAppearance(i3);
            }
            ColorStateList colorStateList = c0434u.f1021A;
            c0434u.f1021A = colorStateList;
            C1564X c1564x3 = c0434u.f1047y;
            if (c1564x3 != null && colorStateList != null) {
                c1564x3.setTextColor(colorStateList);
            }
            c0434u.m957a(c0434u.f1047y, 1);
            c0434u.f1047y.setAccessibilityDelegate(new C0433t(c0434u));
        } else {
            c0434u.m959c();
            int i4 = c0434u.f1036n;
            if (i4 == 2) {
                c0434u.f1037o = 0;
            }
            c0434u.m965i(i4, c0434u.f1037o, c0434u.m964h(c0434u.f1047y, ""));
            c0434u.m963g(c0434u.f1047y, 1);
            c0434u.f1047y = null;
            TextInputLayout textInputLayout = c0434u.f1030h;
            textInputLayout.m3214q();
            textInputLayout.m3220w();
        }
        c0434u.f1046x = z3;
    }

    public void setHelperTextTextAppearance(int i3) {
        C0434u c0434u = this.f4513n;
        c0434u.f1048z = i3;
        C1564X c1564x = c0434u.f1047y;
        if (c1564x != null) {
            c1564x.setTextAppearance(i3);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.f4472E) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z3) {
        this.f4536y0 = z3;
    }

    public void setHintEnabled(boolean z3) {
        if (z3 != this.f4472E) {
            this.f4472E = z3;
            if (z3) {
                CharSequence hint = this.f4501h.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f4473F)) {
                        setHint(hint);
                    }
                    this.f4501h.setHint((CharSequence) null);
                }
                this.f4474G = true;
            } else {
                this.f4474G = false;
                if (!TextUtils.isEmpty(this.f4473F) && TextUtils.isEmpty(this.f4501h.getHint())) {
                    this.f4501h.setHint(this.f4473F);
                }
                setHintInternal(null);
            }
            if (this.f4501h != null) {
                m3216s();
            }
        }
    }

    public void setHintTextAppearance(int i3) {
        C0044d c0044d = this.f4532w0;
        View view = c0044d.f137a;
        C0206d c0206d = new C0206d(view.getContext(), i3);
        ColorStateList colorStateList = c0206d.f507j;
        if (colorStateList != null) {
            c0044d.f153k = colorStateList;
        }
        float f3 = c0206d.f508k;
        if (f3 != 0.0f) {
            c0044d.f151i = f3;
        }
        ColorStateList colorStateList2 = c0206d.f498a;
        if (colorStateList2 != null) {
            c0044d.f131U = colorStateList2;
        }
        c0044d.f129S = c0206d.f502e;
        c0044d.f130T = c0206d.f503f;
        c0044d.f128R = c0206d.f504g;
        c0044d.f132V = c0206d.f506i;
        C0203a c0203a = c0044d.f167y;
        if (c0203a != null) {
            c0203a.f491c = true;
        }
        C0444d c0444d = new C0444d(c0044d);
        c0206d.m396a();
        c0044d.f167y = new C0203a(c0444d, c0206d.f511n);
        c0206d.m398c(view.getContext(), c0044d.f167y);
        c0044d.m200h(false);
        this.f4510l0 = c0044d.f153k;
        if (this.f4501h != null) {
            m3217t(false, false);
            m3216s();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f4510l0 != colorStateList) {
            if (this.f4508k0 == null) {
                C0044d c0044d = this.f4532w0;
                if (c0044d.f153k != colorStateList) {
                    c0044d.f153k = colorStateList;
                    c0044d.m200h(false);
                }
            }
            this.f4510l0 = colorStateList;
            if (this.f4501h != null) {
                m3217t(false, false);
            }
        }
    }

    public void setLengthCounter(InterfaceC0412F interfaceC0412F) {
        this.f4521r = interfaceC0412F;
    }

    public void setMaxEms(int i3) {
        this.f4507k = i3;
        EditText editText = this.f4501h;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMaxEms(i3);
    }

    public void setMaxWidth(int i3) {
        this.f4511m = i3;
        EditText editText = this.f4501h;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMaxWidth(i3);
    }

    public void setMaxWidthResource(int i3) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    public void setMinEms(int i3) {
        this.f4505j = i3;
        EditText editText = this.f4501h;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMinEms(i3);
    }

    public void setMinWidth(int i3) {
        this.f4509l = i3;
        EditText editText = this.f4501h;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMinWidth(i3);
    }

    public void setMinWidthResource(int i3) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i3) {
        C0430q c0430q = this.f4499g;
        c0430q.f995k.setContentDescription(i3 != 0 ? c0430q.getResources().getText(i3) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i3) {
        C0430q c0430q = this.f4499g;
        c0430q.f995k.setImageDrawable(i3 != 0 ? AbstractC1800j.m3991i(c0430q.getContext(), i3) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z3) {
        C0430q c0430q = this.f4499g;
        if (z3 && c0430q.f997m != 1) {
            c0430q.m946f(1);
        } else if (z3) {
            c0430q.getClass();
        } else {
            c0430q.m946f(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        C0430q c0430q = this.f4499g;
        c0430q.f999o = colorStateList;
        AbstractC1800j.m3985c(c0430q.f989e, c0430q.f995k, colorStateList, c0430q.f1000p);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        C0430q c0430q = this.f4499g;
        c0430q.f1000p = mode;
        AbstractC1800j.m3985c(c0430q.f989e, c0430q.f995k, c0430q.f999o, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f4533x == null) {
            C1564X c1564x = new C1564X(getContext(), null);
            this.f4533x = c1564x;
            c1564x.setId(io.getgrass.www.R.id.textinput_placeholder);
            AbstractC0307B.m603s(this.f4533x, 2);
            C1290i c1290iM3202d = m3202d();
            this.f4466A = c1290iM3202d;
            c1290iM3202d.f4617f = 67L;
            this.f4468B = m3202d();
            setPlaceholderTextAppearance(this.f4537z);
            setPlaceholderTextColor(this.f4535y);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f4531w) {
                setPlaceholderTextEnabled(true);
            }
            this.f4529v = charSequence;
        }
        EditText editText = this.f4501h;
        m3218u(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i3) {
        this.f4537z = i3;
        C1564X c1564x = this.f4533x;
        if (c1564x != null) {
            c1564x.setTextAppearance(i3);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f4535y != colorStateList) {
            this.f4535y = colorStateList;
            C1564X c1564x = this.f4533x;
            if (c1564x == null || colorStateList == null) {
                return;
            }
            c1564x.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        C0439z c0439z = this.f4497f;
        c0439z.getClass();
        c0439z.f1066g = TextUtils.isEmpty(charSequence) ? null : charSequence;
        c0439z.f1065f.setText(charSequence);
        c0439z.m972d();
    }

    public void setPrefixTextAppearance(int i3) {
        this.f4497f.f1065f.setTextAppearance(i3);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f4497f.f1065f.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(C0281j c0281j) {
        C0278g c0278g = this.f4475H;
        if (c0278g == null || c0278g.f719e.f697a == c0281j) {
            return;
        }
        this.f4481N = c0281j;
        m3200b();
    }

    public void setStartIconCheckable(boolean z3) {
        this.f4497f.f1067h.setCheckable(z3);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f4497f.f1067h;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i3) {
        setStartIconDrawable(i3 != 0 ? AbstractC1800j.m3991i(getContext(), i3) : null);
    }

    public void setStartIconMinSize(int i3) {
        C0439z c0439z = this.f4497f;
        if (i3 < 0) {
            c0439z.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i3 != c0439z.f1070k) {
            c0439z.f1070k = i3;
            CheckableImageButton checkableImageButton = c0439z.f1067h;
            checkableImageButton.setMinimumWidth(i3);
            checkableImageButton.setMinimumHeight(i3);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        C0439z c0439z = this.f4497f;
        View.OnLongClickListener onLongClickListener = c0439z.f1072m;
        CheckableImageButton checkableImageButton = c0439z.f1067h;
        checkableImageButton.setOnClickListener(onClickListener);
        AbstractC1800j.m3994l(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        C0439z c0439z = this.f4497f;
        c0439z.f1072m = onLongClickListener;
        CheckableImageButton checkableImageButton = c0439z.f1067h;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        AbstractC1800j.m3994l(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        C0439z c0439z = this.f4497f;
        c0439z.f1071l = scaleType;
        c0439z.f1067h.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        C0439z c0439z = this.f4497f;
        if (c0439z.f1068i != colorStateList) {
            c0439z.f1068i = colorStateList;
            AbstractC1800j.m3985c(c0439z.f1064e, c0439z.f1067h, colorStateList, c0439z.f1069j);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        C0439z c0439z = this.f4497f;
        if (c0439z.f1069j != mode) {
            c0439z.f1069j = mode;
            AbstractC1800j.m3985c(c0439z.f1064e, c0439z.f1067h, c0439z.f1068i, mode);
        }
    }

    public void setStartIconVisible(boolean z3) {
        this.f4497f.m970b(z3);
    }

    public void setSuffixText(CharSequence charSequence) {
        C0430q c0430q = this.f4499g;
        c0430q.getClass();
        c0430q.f1004t = TextUtils.isEmpty(charSequence) ? null : charSequence;
        c0430q.f1005u.setText(charSequence);
        c0430q.m953m();
    }

    public void setSuffixTextAppearance(int i3) {
        this.f4499g.f1005u.setTextAppearance(i3);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f4499g.f1005u.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(C0411E c0411e) {
        EditText editText = this.f4501h;
        if (editText != null) {
            AbstractC0323S.m701k(editText, c0411e);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f4494d0) {
            this.f4494d0 = typeface;
            this.f4532w0.m205m(typeface);
            C0434u c0434u = this.f4513n;
            if (typeface != c0434u.f1022B) {
                c0434u.f1022B = typeface;
                C1564X c1564x = c0434u.f1040r;
                if (c1564x != null) {
                    c1564x.setTypeface(typeface);
                }
                C1564X c1564x2 = c0434u.f1047y;
                if (c1564x2 != null) {
                    c1564x2.setTypeface(typeface);
                }
            }
            C1564X c1564x3 = this.f4523s;
            if (c1564x3 != null) {
                c1564x3.setTypeface(typeface);
            }
        }
    }

    /* JADX INFO: renamed from: t */
    public final void m3217t(boolean z3, boolean z4) {
        ColorStateList colorStateList;
        C1564X c1564x;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f4501h;
        boolean z5 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f4501h;
        boolean z6 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f4508k0;
        C0044d c0044d = this.f4532w0;
        if (colorStateList2 != null) {
            c0044d.m201i(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f4508k0;
            c0044d.m201i(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f4528u0) : this.f4528u0));
        } else if (m3210m()) {
            C1564X c1564x2 = this.f4513n.f1040r;
            c0044d.m201i(c1564x2 != null ? c1564x2.getTextColors() : null);
        } else if (this.f4519q && (c1564x = this.f4523s) != null) {
            c0044d.m201i(c1564x.getTextColors());
        } else if (z6 && (colorStateList = this.f4510l0) != null && c0044d.f153k != colorStateList) {
            c0044d.f153k = colorStateList;
            c0044d.m200h(false);
        }
        C0430q c0430q = this.f4499g;
        C0439z c0439z = this.f4497f;
        if (z5 || !this.f4534x0 || (isEnabled() && z6)) {
            if (z4 || this.f4530v0) {
                ValueAnimator valueAnimator = this.f4538z0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f4538z0.cancel();
                }
                if (z3 && this.f4536y0) {
                    m3199a(1.0f);
                } else {
                    c0044d.m203k(1.0f);
                }
                this.f4530v0 = false;
                if (m3203e()) {
                    m3208j();
                }
                EditText editText3 = this.f4501h;
                m3218u(editText3 != null ? editText3.getText() : null);
                c0439z.f1073n = false;
                c0439z.m972d();
                c0430q.f1006v = false;
                c0430q.m953m();
                return;
            }
            return;
        }
        if (z4 || !this.f4530v0) {
            ValueAnimator valueAnimator2 = this.f4538z0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f4538z0.cancel();
            }
            if (z3 && this.f4536y0) {
                m3199a(0.0f);
            } else {
                c0044d.m203k(0.0f);
            }
            if (m3203e() && (!((C0420g) this.f4475H).f961B.isEmpty()) && m3203e()) {
                ((C0420g) this.f4475H).m926o(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.f4530v0 = true;
            C1564X c1564x3 = this.f4533x;
            if (c1564x3 != null && this.f4531w) {
                c1564x3.setText((CharSequence) null);
                AbstractC1297p.m3275a(this.f4495e, this.f4468B);
                this.f4533x.setVisibility(4);
            }
            c0439z.f1073n = true;
            c0439z.m972d();
            c0430q.f1006v = true;
            c0430q.m953m();
        }
    }

    /* JADX INFO: renamed from: u */
    public final void m3218u(Editable editable) {
        ((C0407A) this.f4521r).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.f4495e;
        if (length != 0 || this.f4530v0) {
            C1564X c1564x = this.f4533x;
            if (c1564x == null || !this.f4531w) {
                return;
            }
            c1564x.setText((CharSequence) null);
            AbstractC1297p.m3275a(frameLayout, this.f4468B);
            this.f4533x.setVisibility(4);
            return;
        }
        if (this.f4533x == null || !this.f4531w || TextUtils.isEmpty(this.f4529v)) {
            return;
        }
        this.f4533x.setText(this.f4529v);
        AbstractC1297p.m3275a(frameLayout, this.f4466A);
        this.f4533x.setVisibility(0);
        this.f4533x.bringToFront();
        announceForAccessibility(this.f4529v);
    }

    /* JADX INFO: renamed from: v */
    public final void m3219v(boolean z3, boolean z4) {
        int defaultColor = this.f4518p0.getDefaultColor();
        int colorForState = this.f4518p0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f4518p0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z3) {
            this.f4489V = colorForState2;
        } else if (z4) {
            this.f4489V = colorForState;
        } else {
            this.f4489V = defaultColor;
        }
    }

    /* JADX INFO: renamed from: w */
    public final void m3220w() {
        C1564X c1564x;
        EditText editText;
        EditText editText2;
        if (this.f4475H == null || this.f4484Q == 0) {
            return;
        }
        boolean z3 = false;
        boolean z4 = isFocused() || ((editText2 = this.f4501h) != null && editText2.hasFocus());
        boolean z5 = isHovered() || ((editText = this.f4501h) != null && editText.isHovered());
        if (m3210m() || (this.f4523s != null && this.f4519q)) {
            z3 = true;
        }
        if (!isEnabled()) {
            this.f4489V = this.f4528u0;
        } else if (m3210m()) {
            if (this.f4518p0 != null) {
                m3219v(z4, z5);
            } else {
                this.f4489V = getErrorCurrentTextColors();
            }
        } else if (!this.f4519q || (c1564x = this.f4523s) == null) {
            if (z4) {
                this.f4489V = this.f4516o0;
            } else if (z5) {
                this.f4489V = this.f4514n0;
            } else {
                this.f4489V = this.f4512m0;
            }
        } else if (this.f4518p0 != null) {
            m3219v(z4, z5);
        } else {
            this.f4489V = c1564x.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Context context = getContext();
            TypedValue typedValueM4296q = AbstractC1919e.m4296q(context, io.getgrass.www.R.attr.colorControlActivated);
            ColorStateList colorStateListValueOf = null;
            if (typedValueM4296q != null) {
                int i3 = typedValueM4296q.resourceId;
                if (i3 != 0) {
                    colorStateListValueOf = AbstractC2049e.m4525c(context, i3);
                } else {
                    int i4 = typedValueM4296q.data;
                    if (i4 != 0) {
                        colorStateListValueOf = ColorStateList.valueOf(i4);
                    }
                }
            }
            EditText editText3 = this.f4501h;
            if (editText3 != null && editText3.getTextCursorDrawable() != null && colorStateListValueOf != null) {
                Drawable textCursorDrawable = this.f4501h.getTextCursorDrawable();
                if (z3) {
                    ColorStateList colorStateListValueOf2 = this.f4518p0;
                    if (colorStateListValueOf2 == null) {
                        colorStateListValueOf2 = ColorStateList.valueOf(this.f4489V);
                    }
                    colorStateListValueOf = colorStateListValueOf2;
                }
                AbstractC0139b.m280h(textCursorDrawable, colorStateListValueOf);
            }
        }
        C0430q c0430q = this.f4499g;
        c0430q.m951k();
        CheckableImageButton checkableImageButton = c0430q.f991g;
        ColorStateList colorStateList = c0430q.f992h;
        TextInputLayout textInputLayout = c0430q.f989e;
        AbstractC1800j.m3993k(textInputLayout, checkableImageButton, colorStateList);
        ColorStateList colorStateList2 = c0430q.f999o;
        CheckableImageButton checkableImageButton2 = c0430q.f995k;
        AbstractC1800j.m3993k(textInputLayout, checkableImageButton2, colorStateList2);
        if (c0430q.m942b() instanceof C0425l) {
            if (!textInputLayout.m3210m() || checkableImageButton2.getDrawable() == null) {
                AbstractC1800j.m3985c(textInputLayout, checkableImageButton2, c0430q.f999o, c0430q.f1000p);
            } else {
                Drawable drawableMutate = checkableImageButton2.getDrawable().mutate();
                AbstractC0139b.m279g(drawableMutate, textInputLayout.getErrorCurrentTextColors());
                checkableImageButton2.setImageDrawable(drawableMutate);
            }
        }
        C0439z c0439z = this.f4497f;
        AbstractC1800j.m3993k(c0439z.f1064e, c0439z.f1067h, c0439z.f1068i);
        if (this.f4484Q == 2) {
            int i5 = this.f4486S;
            if (z4 && isEnabled()) {
                this.f4486S = this.f4488U;
            } else {
                this.f4486S = this.f4487T;
            }
            if (this.f4486S != i5 && m3203e() && !this.f4530v0) {
                if (m3203e()) {
                    ((C0420g) this.f4475H).m926o(0.0f, 0.0f, 0.0f, 0.0f);
                }
                m3208j();
            }
        }
        if (this.f4484Q == 1) {
            if (!isEnabled()) {
                this.f4490W = this.f4522r0;
            } else if (z5 && !z4) {
                this.f4490W = this.f4526t0;
            } else if (z4) {
                this.f4490W = this.f4524s0;
            } else {
                this.f4490W = this.f4520q0;
            }
        }
        m3200b();
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f4497f.m969a(drawable);
    }

    public void setHint(int i3) {
        setHint(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setStartIconContentDescription(int i3) {
        setStartIconContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f4499g.f995k.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f4499g.f995k.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f4499g.m948h(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f4499g.f995k;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        C0430q c0430q = this.f4499g;
        CheckableImageButton checkableImageButton = c0430q.f995k;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = c0430q.f999o;
            PorterDuff.Mode mode = c0430q.f1000p;
            TextInputLayout textInputLayout = c0430q.f989e;
            AbstractC1800j.m3985c(textInputLayout, checkableImageButton, colorStateList, mode);
            AbstractC1800j.m3993k(textInputLayout, checkableImageButton, c0430q.f999o);
        }
    }
}
