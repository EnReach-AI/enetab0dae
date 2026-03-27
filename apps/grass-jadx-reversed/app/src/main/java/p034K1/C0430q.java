package p034K1;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import io.getgrass.www.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p005B.AbstractC0032g;
import p007B1.AbstractC0054n;
import p029J.AbstractC0307B;
import p029J.AbstractC0308C;
import p029J.AbstractC0310E;
import p029J.AbstractC0323S;
import p029J.AbstractC0353l;
import p032K.AbstractC0385c;
import p032K.InterfaceC0386d;
import p110k.C1564X;
import p125o0.AbstractC1800j;
import p144t0.AbstractC1920f;
import p166z0.C2071i;

/* JADX INFO: renamed from: K1.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0430q extends LinearLayout {

    /* JADX INFO: renamed from: e */
    public final TextInputLayout f989e;

    /* JADX INFO: renamed from: f */
    public final FrameLayout f990f;

    /* JADX INFO: renamed from: g */
    public final CheckableImageButton f991g;

    /* JADX INFO: renamed from: h */
    public ColorStateList f992h;

    /* JADX INFO: renamed from: i */
    public PorterDuff.Mode f993i;

    /* JADX INFO: renamed from: j */
    public View.OnLongClickListener f994j;

    /* JADX INFO: renamed from: k */
    public final CheckableImageButton f995k;

    /* JADX INFO: renamed from: l */
    public final C0429p f996l;

    /* JADX INFO: renamed from: m */
    public int f997m;

    /* JADX INFO: renamed from: n */
    public final LinkedHashSet f998n;

    /* JADX INFO: renamed from: o */
    public ColorStateList f999o;

    /* JADX INFO: renamed from: p */
    public PorterDuff.Mode f1000p;

    /* JADX INFO: renamed from: q */
    public int f1001q;

    /* JADX INFO: renamed from: r */
    public ImageView.ScaleType f1002r;

    /* JADX INFO: renamed from: s */
    public View.OnLongClickListener f1003s;

    /* JADX INFO: renamed from: t */
    public CharSequence f1004t;

    /* JADX INFO: renamed from: u */
    public final C1564X f1005u;

    /* JADX INFO: renamed from: v */
    public boolean f1006v;

    /* JADX INFO: renamed from: w */
    public EditText f1007w;

    /* JADX INFO: renamed from: x */
    public final AccessibilityManager f1008x;

    /* JADX INFO: renamed from: y */
    public InterfaceC0386d f1009y;

    /* JADX INFO: renamed from: z */
    public final C0426m f1010z;

    public C0430q(TextInputLayout textInputLayout, C2071i c2071i) {
        CharSequence text;
        super(textInputLayout.getContext());
        int i3 = 0;
        this.f997m = 0;
        this.f998n = new LinkedHashSet();
        this.f1010z = new C0426m(this);
        C0427n c0427n = new C0427n(this);
        this.f1008x = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f989e = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f990f = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonM941a = m941a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.f991g = checkableImageButtonM941a;
        CheckableImageButton checkableImageButtonM941a2 = m941a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.f995k = checkableImageButtonM941a2;
        this.f996l = new C0429p(this, c2071i);
        C1564X c1564x = new C1564X(getContext(), null);
        this.f1005u = c1564x;
        TypedArray typedArray = (TypedArray) c2071i.f7315b;
        if (typedArray.hasValue(36)) {
            this.f992h = AbstractC1920f.m4304e(getContext(), c2071i, 36);
        }
        if (typedArray.hasValue(37)) {
            this.f993i = AbstractC0054n.m217g(typedArray.getInt(37, -1), null);
        }
        if (typedArray.hasValue(35)) {
            m948h(c2071i.m4601l(35));
        }
        checkableImageButtonM941a.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m603s(checkableImageButtonM941a, 2);
        checkableImageButtonM941a.setClickable(false);
        checkableImageButtonM941a.setPressable(false);
        checkableImageButtonM941a.setFocusable(false);
        if (!typedArray.hasValue(51)) {
            if (typedArray.hasValue(30)) {
                this.f999o = AbstractC1920f.m4304e(getContext(), c2071i, 30);
            }
            if (typedArray.hasValue(31)) {
                this.f1000p = AbstractC0054n.m217g(typedArray.getInt(31, -1), null);
            }
        }
        if (typedArray.hasValue(28)) {
            m946f(typedArray.getInt(28, 0));
            if (typedArray.hasValue(25) && checkableImageButtonM941a2.getContentDescription() != (text = typedArray.getText(25))) {
                checkableImageButtonM941a2.setContentDescription(text);
            }
            checkableImageButtonM941a2.setCheckable(typedArray.getBoolean(24, true));
        } else if (typedArray.hasValue(51)) {
            if (typedArray.hasValue(52)) {
                this.f999o = AbstractC1920f.m4304e(getContext(), c2071i, 52);
            }
            if (typedArray.hasValue(53)) {
                this.f1000p = AbstractC0054n.m217g(typedArray.getInt(53, -1), null);
            }
            m946f(typedArray.getBoolean(51, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(49);
            if (checkableImageButtonM941a2.getContentDescription() != text2) {
                checkableImageButtonM941a2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(27, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f1001q) {
            this.f1001q = dimensionPixelSize;
            checkableImageButtonM941a2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonM941a2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonM941a.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonM941a.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(29)) {
            ImageView.ScaleType scaleTypeM3987e = AbstractC1800j.m3987e(typedArray.getInt(29, -1));
            this.f1002r = scaleTypeM3987e;
            checkableImageButtonM941a2.setScaleType(scaleTypeM3987e);
            checkableImageButtonM941a.setScaleType(scaleTypeM3987e);
        }
        c1564x.setVisibility(8);
        c1564x.setId(R.id.textinput_suffix_text);
        c1564x.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        AbstractC0310E.m623f(c1564x, 1);
        c1564x.setTextAppearance(typedArray.getResourceId(70, 0));
        if (typedArray.hasValue(71)) {
            c1564x.setTextColor(c2071i.m4600j(71));
        }
        CharSequence text3 = typedArray.getText(69);
        this.f1004t = TextUtils.isEmpty(text3) ? null : text3;
        c1564x.setText(text3);
        m953m();
        frameLayout.addView(checkableImageButtonM941a2);
        addView(c1564x);
        addView(frameLayout);
        addView(checkableImageButtonM941a);
        textInputLayout.f4500g0.add(c0427n);
        if (textInputLayout.f4501h != null) {
            c0427n.m935a(textInputLayout);
        }
        addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0428o(i3, this));
    }

    /* JADX INFO: renamed from: a */
    public final CheckableImageButton m941a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i3) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i3);
        if (AbstractC1920f.m4308k(getContext())) {
            AbstractC0353l.m776h((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC0431r m942b() {
        AbstractC0431r c0419f;
        int i3 = this.f997m;
        C0429p c0429p = this.f996l;
        SparseArray sparseArray = (SparseArray) c0429p.f987c;
        AbstractC0431r c0438y = (AbstractC0431r) sparseArray.get(i3);
        if (c0438y == null) {
            C0430q c0430q = (C0430q) c0429p.f988d;
            if (i3 == -1) {
                c0419f = new C0419f(c0430q, 0);
            } else if (i3 == 0) {
                c0419f = new C0419f(c0430q, 1);
            } else if (i3 == 1) {
                c0438y = new C0438y(c0430q, c0429p.f986b);
                sparseArray.append(i3, c0438y);
            } else if (i3 == 2) {
                c0419f = new C0418e(c0430q);
            } else {
                if (i3 != 3) {
                    throw new IllegalArgumentException("Invalid end icon mode: " + i3);
                }
                c0419f = new C0425l(c0430q);
            }
            c0438y = c0419f;
            sparseArray.append(i3, c0438y);
        }
        return c0438y;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m943c() {
        return this.f990f.getVisibility() == 0 && this.f995k.getVisibility() == 0;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m944d() {
        return this.f991g.getVisibility() == 0;
    }

    /* JADX INFO: renamed from: e */
    public final void m945e(boolean z3) {
        boolean z4;
        boolean zIsActivated;
        boolean z5;
        AbstractC0431r abstractC0431rM942b = m942b();
        boolean zMo955k = abstractC0431rM942b.mo955k();
        CheckableImageButton checkableImageButton = this.f995k;
        boolean z6 = true;
        if (!zMo955k || (z5 = checkableImageButton.f4424h) == abstractC0431rM942b.mo930l()) {
            z4 = false;
        } else {
            checkableImageButton.setChecked(!z5);
            z4 = true;
        }
        if (!(abstractC0431rM942b instanceof C0425l) || (zIsActivated = checkableImageButton.isActivated()) == abstractC0431rM942b.mo929j()) {
            z6 = z4;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z3 || z6) {
            AbstractC1800j.m3993k(this.f989e, checkableImageButton, this.f999o);
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m946f(int i3) {
        if (this.f997m == i3) {
            return;
        }
        AbstractC0431r abstractC0431rM942b = m942b();
        InterfaceC0386d interfaceC0386d = this.f1009y;
        AccessibilityManager accessibilityManager = this.f1008x;
        if (interfaceC0386d != null && accessibilityManager != null) {
            AbstractC0385c.m852b(accessibilityManager, interfaceC0386d);
        }
        this.f1009y = null;
        abstractC0431rM942b.mo923s();
        this.f997m = i3;
        Iterator it = this.f998n.iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            throw null;
        }
        m947g(i3 != 0);
        AbstractC0431r abstractC0431rM942b2 = m942b();
        int iMo916d = this.f996l.f985a;
        if (iMo916d == 0) {
            iMo916d = abstractC0431rM942b2.mo916d();
        }
        Drawable drawableM3991i = iMo916d != 0 ? AbstractC1800j.m3991i(getContext(), iMo916d) : null;
        CheckableImageButton checkableImageButton = this.f995k;
        checkableImageButton.setImageDrawable(drawableM3991i);
        TextInputLayout textInputLayout = this.f989e;
        if (drawableM3991i != null) {
            AbstractC1800j.m3985c(textInputLayout, checkableImageButton, this.f999o, this.f1000p);
            AbstractC1800j.m3993k(textInputLayout, checkableImageButton, this.f999o);
        }
        int iMo915c = abstractC0431rM942b2.mo915c();
        CharSequence text = iMo915c != 0 ? getResources().getText(iMo915c) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(abstractC0431rM942b2.mo955k());
        if (!abstractC0431rM942b2.mo928i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i3);
        }
        abstractC0431rM942b2.mo922r();
        InterfaceC0386d interfaceC0386dMo927h = abstractC0431rM942b2.mo927h();
        this.f1009y = interfaceC0386dMo927h;
        if (interfaceC0386dMo927h != null && accessibilityManager != null) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            if (AbstractC0310E.m619b(this)) {
                AbstractC0385c.m851a(accessibilityManager, this.f1009y);
            }
        }
        View.OnClickListener onClickListenerMo918f = abstractC0431rM942b2.mo918f();
        View.OnLongClickListener onLongClickListener = this.f1003s;
        checkableImageButton.setOnClickListener(onClickListenerMo918f);
        AbstractC1800j.m3994l(checkableImageButton, onLongClickListener);
        EditText editText = this.f1007w;
        if (editText != null) {
            abstractC0431rM942b2.mo920m(editText);
            m949i(abstractC0431rM942b2);
        }
        AbstractC1800j.m3985c(textInputLayout, checkableImageButton, this.f999o, this.f1000p);
        m945e(true);
    }

    /* JADX INFO: renamed from: g */
    public final void m947g(boolean z3) {
        if (m943c() != z3) {
            this.f995k.setVisibility(z3 ? 0 : 8);
            m950j();
            m952l();
            this.f989e.m3213p();
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m948h(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f991g;
        checkableImageButton.setImageDrawable(drawable);
        m951k();
        AbstractC1800j.m3985c(this.f989e, checkableImageButton, this.f992h, this.f993i);
    }

    /* JADX INFO: renamed from: i */
    public final void m949i(AbstractC0431r abstractC0431r) {
        if (this.f1007w == null) {
            return;
        }
        if (abstractC0431r.mo917e() != null) {
            this.f1007w.setOnFocusChangeListener(abstractC0431r.mo917e());
        }
        if (abstractC0431r.mo919g() != null) {
            this.f995k.setOnFocusChangeListener(abstractC0431r.mo919g());
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m950j() {
        this.f990f.setVisibility((this.f995k.getVisibility() != 0 || m944d()) ? 8 : 0);
        setVisibility((m943c() || m944d() || ((this.f1004t == null || this.f1006v) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    /* JADX INFO: renamed from: k */
    public final void m951k() {
        CheckableImageButton checkableImageButton = this.f991g;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f989e;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.f4513n.f1039q && textInputLayout.m3210m()) ? 0 : 8);
        m950j();
        m952l();
        if (this.f997m != 0) {
            return;
        }
        textInputLayout.m3213p();
    }

    /* JADX INFO: renamed from: l */
    public final void m952l() {
        int iM608e;
        TextInputLayout textInputLayout = this.f989e;
        if (textInputLayout.f4501h == null) {
            return;
        }
        if (m943c() || m944d()) {
            iM608e = 0;
        } else {
            EditText editText = textInputLayout.f4501h;
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            iM608e = AbstractC0308C.m608e(editText);
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = textInputLayout.f4501h.getPaddingTop();
        int paddingBottom = textInputLayout.f4501h.getPaddingBottom();
        WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
        AbstractC0308C.m614k(this.f1005u, dimensionPixelSize, paddingTop, iM608e, paddingBottom);
    }

    /* JADX INFO: renamed from: m */
    public final void m953m() {
        C1564X c1564x = this.f1005u;
        int visibility = c1564x.getVisibility();
        int i3 = (this.f1004t == null || this.f1006v) ? 8 : 0;
        if (visibility != i3) {
            m942b().mo921p(i3 == 0);
        }
        m950j();
        c1564x.setVisibility(i3);
        this.f989e.m3213p();
    }
}
