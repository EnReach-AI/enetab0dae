package p034K1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p029J.AbstractC0308C;
import p029J.AbstractC0310E;
import p029J.AbstractC0323S;
import p110k.C1564X;
import p125o0.AbstractC1794d;
import p130p1.AbstractC1824a;
import p144t0.AbstractC1920f;

/* JADX INFO: renamed from: K1.u */
/* JADX INFO: loaded from: classes.dex */
public final class C0434u {

    /* JADX INFO: renamed from: A */
    public ColorStateList f1021A;

    /* JADX INFO: renamed from: B */
    public Typeface f1022B;

    /* JADX INFO: renamed from: a */
    public final int f1023a;

    /* JADX INFO: renamed from: b */
    public final int f1024b;

    /* JADX INFO: renamed from: c */
    public final int f1025c;

    /* JADX INFO: renamed from: d */
    public final TimeInterpolator f1026d;

    /* JADX INFO: renamed from: e */
    public final TimeInterpolator f1027e;

    /* JADX INFO: renamed from: f */
    public final TimeInterpolator f1028f;

    /* JADX INFO: renamed from: g */
    public final Context f1029g;

    /* JADX INFO: renamed from: h */
    public final TextInputLayout f1030h;

    /* JADX INFO: renamed from: i */
    public LinearLayout f1031i;

    /* JADX INFO: renamed from: j */
    public int f1032j;

    /* JADX INFO: renamed from: k */
    public FrameLayout f1033k;

    /* JADX INFO: renamed from: l */
    public Animator f1034l;

    /* JADX INFO: renamed from: m */
    public final float f1035m;

    /* JADX INFO: renamed from: n */
    public int f1036n;

    /* JADX INFO: renamed from: o */
    public int f1037o;

    /* JADX INFO: renamed from: p */
    public CharSequence f1038p;

    /* JADX INFO: renamed from: q */
    public boolean f1039q;

    /* JADX INFO: renamed from: r */
    public C1564X f1040r;

    /* JADX INFO: renamed from: s */
    public CharSequence f1041s;

    /* JADX INFO: renamed from: t */
    public int f1042t;

    /* JADX INFO: renamed from: u */
    public int f1043u;

    /* JADX INFO: renamed from: v */
    public ColorStateList f1044v;

    /* JADX INFO: renamed from: w */
    public CharSequence f1045w;

    /* JADX INFO: renamed from: x */
    public boolean f1046x;

    /* JADX INFO: renamed from: y */
    public C1564X f1047y;

    /* JADX INFO: renamed from: z */
    public int f1048z;

    public C0434u(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f1029g = context;
        this.f1030h = textInputLayout;
        this.f1035m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f1023a = AbstractC1794d.m3954l(context, R.attr.motionDurationShort4, 217);
        this.f1024b = AbstractC1794d.m3954l(context, R.attr.motionDurationMedium4, 167);
        this.f1025c = AbstractC1794d.m3954l(context, R.attr.motionDurationShort4, 167);
        this.f1026d = AbstractC1794d.m3955m(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, AbstractC1824a.f6323d);
        LinearInterpolator linearInterpolator = AbstractC1824a.f6320a;
        this.f1027e = AbstractC1794d.m3955m(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f1028f = AbstractC1794d.m3955m(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    /* JADX INFO: renamed from: a */
    public final void m957a(TextView textView, int i3) {
        if (this.f1031i == null && this.f1033k == null) {
            Context context = this.f1029g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f1031i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f1031i;
            TextInputLayout textInputLayout = this.f1030h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f1033k = new FrameLayout(context);
            this.f1031i.addView(this.f1033k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                m958b();
            }
        }
        if (i3 == 0 || i3 == 1) {
            this.f1033k.setVisibility(0);
            this.f1033k.addView(textView);
        } else {
            this.f1031i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f1031i.setVisibility(0);
        this.f1032j++;
    }

    /* JADX INFO: renamed from: b */
    public final void m958b() {
        if (this.f1031i != null) {
            TextInputLayout textInputLayout = this.f1030h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f1029g;
                boolean zM4308k = AbstractC1920f.m4308k(context);
                LinearLayout linearLayout = this.f1031i;
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                int iM609f = AbstractC0308C.m609f(editText);
                if (zM4308k) {
                    iM609f = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (zM4308k) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int iM608e = AbstractC0308C.m608e(editText);
                if (zM4308k) {
                    iM608e = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                AbstractC0308C.m614k(linearLayout, iM609f, dimensionPixelSize, iM608e, 0);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m959c() {
        Animator animator = this.f1034l;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m960d(ArrayList arrayList, boolean z3, TextView textView, int i3, int i4, int i5) {
        if (textView == null || !z3) {
            return;
        }
        if (i3 == i5 || i3 == i4) {
            boolean z4 = i5 == i3;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z4 ? 1.0f : 0.0f);
            int i6 = this.f1025c;
            objectAnimatorOfFloat.setDuration(z4 ? this.f1024b : i6);
            objectAnimatorOfFloat.setInterpolator(z4 ? this.f1027e : this.f1028f);
            if (i3 == i5 && i4 != 0) {
                objectAnimatorOfFloat.setStartDelay(i6);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i5 != i3 || i4 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f1035m, 0.0f);
            objectAnimatorOfFloat2.setDuration(this.f1023a);
            objectAnimatorOfFloat2.setInterpolator(this.f1026d);
            objectAnimatorOfFloat2.setStartDelay(i6);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    /* JADX INFO: renamed from: e */
    public final TextView m961e(int i3) {
        if (i3 == 1) {
            return this.f1040r;
        }
        if (i3 != 2) {
            return null;
        }
        return this.f1047y;
    }

    /* JADX INFO: renamed from: f */
    public final void m962f() {
        this.f1038p = null;
        m959c();
        if (this.f1036n == 1) {
            if (!this.f1046x || TextUtils.isEmpty(this.f1045w)) {
                this.f1037o = 0;
            } else {
                this.f1037o = 2;
            }
        }
        m965i(this.f1036n, this.f1037o, m964h(this.f1040r, ""));
    }

    /* JADX INFO: renamed from: g */
    public final void m963g(TextView textView, int i3) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f1031i;
        if (linearLayout == null) {
            return;
        }
        if ((i3 == 0 || i3 == 1) && (frameLayout = this.f1033k) != null) {
            frameLayout.removeView(textView);
        } else {
            linearLayout.removeView(textView);
        }
        int i4 = this.f1032j - 1;
        this.f1032j = i4;
        LinearLayout linearLayout2 = this.f1031i;
        if (i4 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: h */
    public final boolean m964h(TextView textView, CharSequence charSequence) {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        TextInputLayout textInputLayout = this.f1030h;
        return AbstractC0310E.m620c(textInputLayout) && textInputLayout.isEnabled() && !(this.f1037o == this.f1036n && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    /* JADX INFO: renamed from: i */
    public final void m965i(int i3, int i4, boolean z3) {
        TextView textViewM961e;
        TextView textViewM961e2;
        if (i3 == i4) {
            return;
        }
        if (z3) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f1034l = animatorSet;
            ArrayList arrayList = new ArrayList();
            m960d(arrayList, this.f1046x, this.f1047y, 2, i3, i4);
            m960d(arrayList, this.f1039q, this.f1040r, 1, i3, i4);
            int size = arrayList.size();
            long jMax = 0;
            for (int i5 = 0; i5 < size; i5++) {
                Animator animator = (Animator) arrayList.get(i5);
                jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
            valueAnimatorOfInt.setDuration(jMax);
            arrayList.add(0, valueAnimatorOfInt);
            animatorSet.playTogether(arrayList);
            animatorSet.addListener(new C0432s(this, i4, m961e(i3), i3, m961e(i4)));
            animatorSet.start();
        } else if (i3 != i4) {
            if (i4 != 0 && (textViewM961e2 = m961e(i4)) != null) {
                textViewM961e2.setVisibility(0);
                textViewM961e2.setAlpha(1.0f);
            }
            if (i3 != 0 && (textViewM961e = m961e(i3)) != null) {
                textViewM961e.setVisibility(4);
                if (i3 == 1) {
                    textViewM961e.setText((CharSequence) null);
                }
            }
            this.f1036n = i4;
        }
        TextInputLayout textInputLayout = this.f1030h;
        textInputLayout.m3214q();
        textInputLayout.m3217t(z3, false);
        textInputLayout.m3220w();
    }
}
