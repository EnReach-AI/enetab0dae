package p007B1;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import java.util.WeakHashMap;
import p016E1.C0203a;
import p023H.AbstractC0244g;
import p029J.AbstractC0307B;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p060U.C0652a;
import p130p1.AbstractC1824a;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: B1.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0044d {

    /* JADX INFO: renamed from: A */
    public CharSequence f111A;

    /* JADX INFO: renamed from: B */
    public CharSequence f112B;

    /* JADX INFO: renamed from: C */
    public boolean f113C;

    /* JADX INFO: renamed from: E */
    public Bitmap f115E;

    /* JADX INFO: renamed from: F */
    public float f116F;

    /* JADX INFO: renamed from: G */
    public float f117G;

    /* JADX INFO: renamed from: H */
    public float f118H;

    /* JADX INFO: renamed from: I */
    public float f119I;

    /* JADX INFO: renamed from: J */
    public float f120J;

    /* JADX INFO: renamed from: K */
    public int f121K;

    /* JADX INFO: renamed from: L */
    public int[] f122L;

    /* JADX INFO: renamed from: M */
    public boolean f123M;

    /* JADX INFO: renamed from: N */
    public final TextPaint f124N;

    /* JADX INFO: renamed from: O */
    public final TextPaint f125O;

    /* JADX INFO: renamed from: P */
    public TimeInterpolator f126P;

    /* JADX INFO: renamed from: Q */
    public TimeInterpolator f127Q;

    /* JADX INFO: renamed from: R */
    public float f128R;

    /* JADX INFO: renamed from: S */
    public float f129S;

    /* JADX INFO: renamed from: T */
    public float f130T;

    /* JADX INFO: renamed from: U */
    public ColorStateList f131U;

    /* JADX INFO: renamed from: V */
    public float f132V;

    /* JADX INFO: renamed from: W */
    public float f133W;

    /* JADX INFO: renamed from: X */
    public float f134X;

    /* JADX INFO: renamed from: Y */
    public StaticLayout f135Y;

    /* JADX INFO: renamed from: Z */
    public float f136Z;

    /* JADX INFO: renamed from: a */
    public final View f137a;

    /* JADX INFO: renamed from: a0 */
    public float f138a0;

    /* JADX INFO: renamed from: b */
    public float f139b;

    /* JADX INFO: renamed from: b0 */
    public float f140b0;

    /* JADX INFO: renamed from: c */
    public final Rect f141c;

    /* JADX INFO: renamed from: c0 */
    public CharSequence f142c0;

    /* JADX INFO: renamed from: d */
    public final Rect f143d;

    /* JADX INFO: renamed from: e */
    public final RectF f145e;

    /* JADX INFO: renamed from: j */
    public ColorStateList f152j;

    /* JADX INFO: renamed from: k */
    public ColorStateList f153k;

    /* JADX INFO: renamed from: l */
    public float f154l;

    /* JADX INFO: renamed from: m */
    public float f155m;

    /* JADX INFO: renamed from: n */
    public float f156n;

    /* JADX INFO: renamed from: o */
    public float f157o;

    /* JADX INFO: renamed from: p */
    public float f158p;

    /* JADX INFO: renamed from: q */
    public float f159q;

    /* JADX INFO: renamed from: r */
    public Typeface f160r;

    /* JADX INFO: renamed from: s */
    public Typeface f161s;

    /* JADX INFO: renamed from: t */
    public Typeface f162t;

    /* JADX INFO: renamed from: u */
    public Typeface f163u;

    /* JADX INFO: renamed from: v */
    public Typeface f164v;

    /* JADX INFO: renamed from: w */
    public Typeface f165w;

    /* JADX INFO: renamed from: x */
    public Typeface f166x;

    /* JADX INFO: renamed from: y */
    public C0203a f167y;

    /* JADX INFO: renamed from: f */
    public int f147f = 16;

    /* JADX INFO: renamed from: g */
    public int f149g = 16;

    /* JADX INFO: renamed from: h */
    public float f150h = 15.0f;

    /* JADX INFO: renamed from: i */
    public float f151i = 15.0f;

    /* JADX INFO: renamed from: z */
    public final TextUtils.TruncateAt f168z = TextUtils.TruncateAt.END;

    /* JADX INFO: renamed from: D */
    public final boolean f114D = true;

    /* JADX INFO: renamed from: d0 */
    public final int f144d0 = 1;

    /* JADX INFO: renamed from: e0 */
    public final float f146e0 = 1.0f;

    /* JADX INFO: renamed from: f0 */
    public final int f148f0 = 1;

    public C0044d(View view) {
        this.f137a = view;
        TextPaint textPaint = new TextPaint(129);
        this.f124N = textPaint;
        this.f125O = new TextPaint(textPaint);
        this.f143d = new Rect();
        this.f141c = new Rect();
        this.f145e = new RectF();
        m199g(view.getContext().getResources().getConfiguration());
    }

    /* JADX INFO: renamed from: a */
    public static int m193a(int i3, int i4, float f3) {
        float f4 = 1.0f - f3;
        return Color.argb(Math.round((Color.alpha(i4) * f3) + (Color.alpha(i3) * f4)), Math.round((Color.red(i4) * f3) + (Color.red(i3) * f4)), Math.round((Color.green(i4) * f3) + (Color.green(i3) * f4)), Math.round((Color.blue(i4) * f3) + (Color.blue(i3) * f4)));
    }

    /* JADX INFO: renamed from: f */
    public static float m194f(float f3, float f4, float f5, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f5 = timeInterpolator.getInterpolation(f5);
        }
        return AbstractC1824a.m4069a(f3, f4, f5);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m195b(CharSequence charSequence) {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        boolean z3 = AbstractC0308C.m607d(this.f137a) == 1;
        if (this.f114D) {
            return (z3 ? AbstractC0244g.f602d : AbstractC0244g.f601c).m305c(charSequence, charSequence.length());
        }
        return z3;
    }

    /* JADX INFO: renamed from: c */
    public final void m196c(float f3, boolean z3) {
        float f4;
        float f5;
        Typeface typeface;
        boolean z4;
        Layout.Alignment alignment;
        if (this.f111A == null) {
            return;
        }
        float fWidth = this.f143d.width();
        float fWidth2 = this.f141c.width();
        if (Math.abs(f3 - 1.0f) < 1.0E-5f) {
            f4 = this.f151i;
            f5 = this.f132V;
            this.f116F = 1.0f;
            typeface = this.f160r;
        } else {
            float f6 = this.f150h;
            float f7 = this.f133W;
            Typeface typeface2 = this.f163u;
            if (Math.abs(f3 - 0.0f) < 1.0E-5f) {
                this.f116F = 1.0f;
            } else {
                this.f116F = m194f(this.f150h, this.f151i, f3, this.f127Q) / this.f150h;
            }
            float f8 = this.f151i / this.f150h;
            fWidth = (!z3 && fWidth2 * f8 > fWidth) ? Math.min(fWidth / f8, fWidth2) : fWidth2;
            f4 = f6;
            f5 = f7;
            typeface = typeface2;
        }
        TextPaint textPaint = this.f124N;
        if (fWidth > 0.0f) {
            boolean z5 = this.f117G != f4;
            boolean z6 = this.f134X != f5;
            boolean z7 = this.f166x != typeface;
            StaticLayout staticLayout = this.f135Y;
            boolean z8 = z5 || z6 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z7 || this.f123M;
            this.f117G = f4;
            this.f134X = f5;
            this.f166x = typeface;
            this.f123M = false;
            textPaint.setLinearText(this.f116F != 1.0f);
            z4 = z8;
        } else {
            z4 = false;
        }
        if (this.f112B == null || z4) {
            textPaint.setTextSize(this.f117G);
            textPaint.setTypeface(this.f166x);
            textPaint.setLetterSpacing(this.f134X);
            boolean zM195b = m195b(this.f111A);
            this.f113C = zM195b;
            int i3 = this.f144d0;
            if (i3 <= 1 || zM195b) {
                i3 = 1;
            }
            if (i3 == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                int absoluteGravity = Gravity.getAbsoluteGravity(this.f147f, zM195b ? 1 : 0) & 7;
                alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.f113C ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.f113C ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
            }
            C0049i c0049i = new C0049i(this.f111A, textPaint, (int) fWidth);
            c0049i.f188l = this.f168z;
            c0049i.f187k = zM195b;
            c0049i.f181e = alignment;
            c0049i.f186j = false;
            c0049i.f182f = i3;
            float f9 = this.f146e0;
            c0049i.f183g = 0.0f;
            c0049i.f184h = f9;
            c0049i.f185i = this.f148f0;
            StaticLayout staticLayoutM207a = c0049i.m207a();
            staticLayoutM207a.getClass();
            this.f135Y = staticLayoutM207a;
            this.f112B = staticLayoutM207a.getText();
        }
    }

    /* JADX INFO: renamed from: d */
    public final float m197d() {
        TextPaint textPaint = this.f125O;
        textPaint.setTextSize(this.f151i);
        textPaint.setTypeface(this.f160r);
        textPaint.setLetterSpacing(this.f132V);
        return -textPaint.ascent();
    }

    /* JADX INFO: renamed from: e */
    public final int m198e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f122L;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    /* JADX INFO: renamed from: g */
    public final void m199g(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f162t;
            if (typeface != null) {
                this.f161s = AbstractC1946e.m4347e(configuration, typeface);
            }
            Typeface typeface2 = this.f165w;
            if (typeface2 != null) {
                this.f164v = AbstractC1946e.m4347e(configuration, typeface2);
            }
            Typeface typeface3 = this.f161s;
            if (typeface3 == null) {
                typeface3 = this.f162t;
            }
            this.f160r = typeface3;
            Typeface typeface4 = this.f164v;
            if (typeface4 == null) {
                typeface4 = this.f165w;
            }
            this.f163u = typeface4;
            m200h(true);
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m200h(boolean z3) {
        float fMeasureText;
        StaticLayout staticLayout;
        View view = this.f137a;
        if ((view.getHeight() <= 0 || view.getWidth() <= 0) && !z3) {
            return;
        }
        m196c(1.0f, z3);
        CharSequence charSequence = this.f112B;
        TextPaint textPaint = this.f124N;
        if (charSequence != null && (staticLayout = this.f135Y) != null) {
            this.f142c0 = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), this.f168z);
        }
        CharSequence charSequence2 = this.f142c0;
        if (charSequence2 != null) {
            this.f136Z = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f136Z = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f149g, this.f113C ? 1 : 0);
        int i3 = absoluteGravity & 112;
        Rect rect = this.f143d;
        if (i3 == 48) {
            this.f155m = rect.top;
        } else if (i3 != 80) {
            this.f155m = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f155m = textPaint.ascent() + rect.bottom;
        }
        int i4 = absoluteGravity & 8388615;
        if (i4 == 1) {
            this.f157o = rect.centerX() - (this.f136Z / 2.0f);
        } else if (i4 != 5) {
            this.f157o = rect.left;
        } else {
            this.f157o = rect.right - this.f136Z;
        }
        m196c(0.0f, z3);
        float height = this.f135Y != null ? r1.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.f135Y;
        if (staticLayout2 == null || this.f144d0 <= 1) {
            CharSequence charSequence3 = this.f112B;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.f135Y;
        if (staticLayout3 != null) {
            staticLayout3.getLineCount();
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f147f, this.f113C ? 1 : 0);
        int i5 = absoluteGravity2 & 112;
        Rect rect2 = this.f141c;
        if (i5 == 48) {
            this.f154l = rect2.top;
        } else if (i5 != 80) {
            this.f154l = rect2.centerY() - (height / 2.0f);
        } else {
            this.f154l = textPaint.descent() + (rect2.bottom - height);
        }
        int i6 = absoluteGravity2 & 8388615;
        if (i6 == 1) {
            this.f156n = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i6 != 5) {
            this.f156n = rect2.left;
        } else {
            this.f156n = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.f115E;
        if (bitmap != null) {
            bitmap.recycle();
            this.f115E = null;
        }
        m204l(this.f139b);
        float f3 = this.f139b;
        float fM194f = m194f(rect2.left, rect.left, f3, this.f126P);
        RectF rectF = this.f145e;
        rectF.left = fM194f;
        rectF.top = m194f(this.f154l, this.f155m, f3, this.f126P);
        rectF.right = m194f(rect2.right, rect.right, f3, this.f126P);
        rectF.bottom = m194f(rect2.bottom, rect.bottom, f3, this.f126P);
        this.f158p = m194f(this.f156n, this.f157o, f3, this.f126P);
        this.f159q = m194f(this.f154l, this.f155m, f3, this.f126P);
        m204l(f3);
        C0652a c0652a = AbstractC1824a.f6321b;
        this.f138a0 = 1.0f - m194f(0.0f, 1.0f, 1.0f - f3, c0652a);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m595k(view);
        this.f140b0 = m194f(1.0f, 0.0f, f3, c0652a);
        AbstractC0307B.m595k(view);
        ColorStateList colorStateList = this.f153k;
        ColorStateList colorStateList2 = this.f152j;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(m193a(m198e(colorStateList2), m198e(this.f153k), f3));
        } else {
            textPaint.setColor(m198e(colorStateList));
        }
        float f4 = this.f132V;
        float f5 = this.f133W;
        if (f4 != f5) {
            textPaint.setLetterSpacing(m194f(f5, f4, f3, c0652a));
        } else {
            textPaint.setLetterSpacing(f4);
        }
        this.f118H = AbstractC1824a.m4069a(0.0f, this.f128R, f3);
        this.f119I = AbstractC1824a.m4069a(0.0f, this.f129S, f3);
        this.f120J = AbstractC1824a.m4069a(0.0f, this.f130T, f3);
        int iM193a = m193a(0, m198e(this.f131U), f3);
        this.f121K = iM193a;
        textPaint.setShadowLayer(this.f118H, this.f119I, this.f120J, iM193a);
        AbstractC0307B.m595k(view);
    }

    /* JADX INFO: renamed from: i */
    public final void m201i(ColorStateList colorStateList) {
        if (this.f153k == colorStateList && this.f152j == colorStateList) {
            return;
        }
        this.f153k = colorStateList;
        this.f152j = colorStateList;
        m200h(false);
    }

    /* JADX INFO: renamed from: j */
    public final boolean m202j(Typeface typeface) {
        C0203a c0203a = this.f167y;
        if (c0203a != null) {
            c0203a.f491c = true;
        }
        if (this.f162t == typeface) {
            return false;
        }
        this.f162t = typeface;
        Typeface typefaceM4347e = AbstractC1946e.m4347e(this.f137a.getContext().getResources().getConfiguration(), typeface);
        this.f161s = typefaceM4347e;
        if (typefaceM4347e == null) {
            typefaceM4347e = this.f162t;
        }
        this.f160r = typefaceM4347e;
        return true;
    }

    /* JADX INFO: renamed from: k */
    public final void m203k(float f3) {
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        if (f3 != this.f139b) {
            this.f139b = f3;
            float f4 = this.f141c.left;
            Rect rect = this.f143d;
            float fM194f = m194f(f4, rect.left, f3, this.f126P);
            RectF rectF = this.f145e;
            rectF.left = fM194f;
            rectF.top = m194f(this.f154l, this.f155m, f3, this.f126P);
            rectF.right = m194f(r1.right, rect.right, f3, this.f126P);
            rectF.bottom = m194f(r1.bottom, rect.bottom, f3, this.f126P);
            this.f158p = m194f(this.f156n, this.f157o, f3, this.f126P);
            this.f159q = m194f(this.f154l, this.f155m, f3, this.f126P);
            m204l(f3);
            C0652a c0652a = AbstractC1824a.f6321b;
            this.f138a0 = 1.0f - m194f(0.0f, 1.0f, 1.0f - f3, c0652a);
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            View view = this.f137a;
            AbstractC0307B.m595k(view);
            this.f140b0 = m194f(1.0f, 0.0f, f3, c0652a);
            AbstractC0307B.m595k(view);
            ColorStateList colorStateList = this.f153k;
            ColorStateList colorStateList2 = this.f152j;
            TextPaint textPaint = this.f124N;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(m193a(m198e(colorStateList2), m198e(this.f153k), f3));
            } else {
                textPaint.setColor(m198e(colorStateList));
            }
            float f5 = this.f132V;
            float f6 = this.f133W;
            if (f5 != f6) {
                textPaint.setLetterSpacing(m194f(f6, f5, f3, c0652a));
            } else {
                textPaint.setLetterSpacing(f5);
            }
            this.f118H = AbstractC1824a.m4069a(0.0f, this.f128R, f3);
            this.f119I = AbstractC1824a.m4069a(0.0f, this.f129S, f3);
            this.f120J = AbstractC1824a.m4069a(0.0f, this.f130T, f3);
            int iM193a = m193a(0, m198e(this.f131U), f3);
            this.f121K = iM193a;
            textPaint.setShadowLayer(this.f118H, this.f119I, this.f120J, iM193a);
            AbstractC0307B.m595k(view);
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m204l(float f3) {
        m196c(f3, false);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m595k(this.f137a);
    }

    /* JADX INFO: renamed from: m */
    public final void m205m(Typeface typeface) {
        boolean z3;
        boolean zM202j = m202j(typeface);
        if (this.f165w != typeface) {
            this.f165w = typeface;
            Typeface typefaceM4347e = AbstractC1946e.m4347e(this.f137a.getContext().getResources().getConfiguration(), typeface);
            this.f164v = typefaceM4347e;
            if (typefaceM4347e == null) {
                typefaceM4347e = this.f165w;
            }
            this.f163u = typefaceM4347e;
            z3 = true;
        } else {
            z3 = false;
        }
        if (zM202j || z3) {
            m200h(false);
        }
    }
}
