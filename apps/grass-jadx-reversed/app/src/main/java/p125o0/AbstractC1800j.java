package p125o0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import p004A2.InterfaceC0025b;
import p005B.AbstractC0032g;
import p009C.AbstractC0139b;
import p015D2.C0197u;
import p015D2.C0198v;
import p029J.AbstractC0306A;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p069X0.InterfaceC0720k;
import p071Y0.AbstractC0752p;
import p110k.C1532G0;
import p117m0.AbstractC1717l;
import p118m1.AbstractC1745j;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;
import p129p0.AbstractC1822d;
import p131p2.C1829c;
import p131p2.C1831e;
import p131p2.C1832f;
import p131p2.C1835i;
import p142s2.AbstractC1892g;
import p146t2.AbstractC1923b;
import p146t2.C1922a;
import p146t2.EnumC1924c;

/* JADX INFO: renamed from: o0.j */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1800j {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static final long m3983a(String str) {
        EnumC1924c enumC1924c;
        int i3;
        long jM3990h;
        int i4 = 1;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        int i5 = C1922a.f6730h;
        boolean z3 = false;
        char cCharAt = str.charAt(0);
        int i6 = (cCharAt == '+' || cCharAt == '-') ? 1 : 0;
        byte b3 = i6 > 0 && str.length() > 0 && AbstractC1717l.m3802e(str.charAt(0), '-', false);
        if (length <= i6) {
            throw new IllegalArgumentException("No components");
        }
        if (str.charAt(i6) != 'P') {
            throw new IllegalArgumentException();
        }
        int i7 = i6 + 1;
        if (i7 == length) {
            throw new IllegalArgumentException();
        }
        EnumC1924c enumC1924c2 = null;
        long jM4316e = 0;
        int i8 = 0;
        while (i7 < length) {
            if (str.charAt(i7) != 'T') {
                int i9 = i7;
                while (i9 < str.length()) {
                    char cCharAt2 = str.charAt(i9);
                    if (!new C1829c('0', '9').m4073a(cCharAt2) && AbstractC1892g.m4221n("+-.", cCharAt2, z3 ? 1 : 0, z3, 2) < 0) {
                        break;
                    }
                    i9 += i4;
                }
                String strSubstring = str.substring(i7, i9);
                AbstractC1766e.m3919d("substring(...)", strSubstring);
                if (strSubstring.length() == 0) {
                    throw new IllegalArgumentException();
                }
                int length2 = strSubstring.length() + i7;
                if (length2 < 0 || length2 > AbstractC1892g.m4219l(str)) {
                    throw new IllegalArgumentException("Missing unit for value ".concat(strSubstring));
                }
                char cCharAt3 = str.charAt(length2);
                int i10 = length2 + i4;
                if (i8 == 0) {
                    if (cCharAt3 != 'D') {
                        throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + cCharAt3);
                    }
                    enumC1924c = EnumC1924c.DAYS;
                } else if (cCharAt3 == 'H') {
                    enumC1924c = EnumC1924c.HOURS;
                } else if (cCharAt3 == 'M') {
                    enumC1924c = EnumC1924c.MINUTES;
                } else {
                    if (cCharAt3 != 'S') {
                        throw new IllegalArgumentException("Invalid duration ISO time unit: " + cCharAt3);
                    }
                    enumC1924c = EnumC1924c.SECONDS;
                }
                if (enumC1924c2 != null && enumC1924c2.compareTo(enumC1924c) <= 0) {
                    throw new IllegalArgumentException("Unexpected order of duration components");
                }
                int iM4221n = AbstractC1892g.m4221n(strSubstring, '.', z3 ? 1 : 0, z3, 6);
                if (enumC1924c != EnumC1924c.SECONDS || iM4221n <= 0) {
                    i3 = length;
                    jM4316e = C1922a.m4316e(jM4316e, m3995m(m3992j(strSubstring), enumC1924c));
                } else {
                    String strSubstring2 = strSubstring.substring(z3 ? 1 : 0, iM4221n);
                    AbstractC1766e.m3919d("substring(...)", strSubstring2);
                    long jM4316e2 = C1922a.m4316e(jM4316e, m3995m(m3992j(strSubstring2), enumC1924c));
                    String strSubstring3 = strSubstring.substring(iM4221n);
                    AbstractC1766e.m3919d("substring(...)", strSubstring3);
                    double d = Double.parseDouble(strSubstring3);
                    double dM4047a = AbstractC1822d.m4047a(d, enumC1924c, EnumC1924c.NANOSECONDS);
                    if (((Double.isNaN(dM4047a) ? 1 : 0) ^ i4) == 0) {
                        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
                    }
                    if (Double.isNaN(dM4047a)) {
                        throw new IllegalArgumentException("Cannot round NaN value.");
                    }
                    long jRound = Math.round(dM4047a);
                    EnumC1924c enumC1924c3 = enumC1924c;
                    i3 = length;
                    if (new C1835i(-4611686018426999999L, 4611686018426999999L).m4075a(jRound)) {
                        jM3990h = jRound << 1;
                        int i11 = C1922a.f6730h;
                        int i12 = AbstractC1923b.f6732a;
                        enumC1924c = enumC1924c3;
                    } else {
                        enumC1924c = enumC1924c3;
                        double dM4047a2 = AbstractC1822d.m4047a(d, enumC1924c, EnumC1924c.MILLISECONDS);
                        if (Double.isNaN(dM4047a2)) {
                            throw new IllegalArgumentException("Cannot round NaN value.");
                        }
                        jM3990h = m3990h(Math.round(dM4047a2));
                    }
                    jM4316e = C1922a.m4316e(jM4316e2, jM3990h);
                }
                enumC1924c2 = enumC1924c;
                i7 = i10;
                length = i3;
                i4 = 1;
                z3 = false;
            } else {
                if (i8 != 0 || (i7 = i7 + i4) == length) {
                    throw new IllegalArgumentException();
                }
                i8 = i4;
            }
        }
        if (b3 != true) {
            return jM4316e;
        }
        long j2 = ((-(jM4316e >> 1)) << 1) + ((long) (((int) jM4316e) & 1));
        int i13 = AbstractC1923b.f6732a;
        return j2;
    }

    /* JADX INFO: renamed from: b */
    public static final void m3984b(C0198v c0198v) {
        AbstractC1766e.m3920e("<this>", c0198v);
        if ((c0198v instanceof C0198v ? c0198v : null) != null) {
            return;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + AbstractC1770i.m3927a(c0198v.getClass()));
    }

    /* JADX INFO: renamed from: c */
    public static void m3985c(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                AbstractC0139b.m280h(drawable, colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                AbstractC0139b.m280h(drawable, ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                AbstractC0139b.m281i(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: renamed from: d */
    public static final C0197u m3986d(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("<this>", interfaceC0025b);
        C0197u c0197u = interfaceC0025b instanceof C0197u ? (C0197u) interfaceC0025b : null;
        if (c0197u != null) {
            return c0197u;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + AbstractC1770i.m3927a(interfaceC0025b.getClass()));
    }

    /* JADX INFO: renamed from: e */
    public static ImageView.ScaleType m3987e(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 5 ? i3 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    /* JADX INFO: renamed from: f */
    public static void m3988f(Object obj, boolean z3) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalArgumentException(AbstractC0032g.m154l("AnnotationIntrospector returned EnumNamingStrategy definition of type ", AbstractC1745j.m3883f(obj), "; expected type `Class<EnumNamingStrategy>` instead"));
        }
        Class cls = (Class) obj;
        if (cls == InterfaceC0720k.class) {
            return;
        }
        if (!InterfaceC0720k.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(AbstractC0032g.m154l("Problem with AnnotationIntrospector returned Class ", AbstractC1745j.m3883f(cls), "; expected `Class<EnumNamingStrategy>`"));
        }
        AbstractC0032g.m162t(AbstractC1745j.m3885h(cls, z3));
    }

    /* JADX INFO: renamed from: g */
    public static final long m3989g(long j2) {
        long j3 = (j2 << 1) + 1;
        int i3 = C1922a.f6730h;
        int i4 = AbstractC1923b.f6732a;
        return j3;
    }

    /* JADX INFO: renamed from: h */
    public static final long m3990h(long j2) {
        if (!new C1835i(-4611686018426L, 4611686018426L).m4075a(j2)) {
            return m3989g(AbstractC0752p.m1932a(j2));
        }
        long j3 = (j2 * ((long) 1000000)) << 1;
        int i3 = C1922a.f6730h;
        int i4 = AbstractC1923b.f6732a;
        return j3;
    }

    /* JADX INFO: renamed from: i */
    public static Drawable m3991i(Context context, int i3) {
        return C1532G0.m3578c().m3583e(context, i3);
    }

    /* JADX INFO: renamed from: j */
    public static final long m3992j(String str) {
        int length = str.length();
        int i3 = (length <= 0 || AbstractC1892g.m4221n("+-", str.charAt(0), 0, false, 2) < 0) ? 0 : 1;
        if (length - i3 > 16) {
            Iterable c1832f = new C1832f(i3, AbstractC1892g.m4219l(str), 1);
            if (!(c1832f instanceof Collection) || !((Collection) c1832f).isEmpty()) {
                Iterator it = c1832f.iterator();
                while (((C1831e) it).f6343g) {
                    if (!new C1829c('0', '9').m4073a(str.charAt(((C1831e) it).m4074a()))) {
                    }
                }
            }
            return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        if (str.startsWith("+")) {
            str = AbstractC1892g.m4218k(1, str);
        }
        return Long.parseLong(str);
    }

    /* JADX INFO: renamed from: k */
    public static void m3993k(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = drawable.mutate();
        AbstractC0139b.m280h(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    /* JADX INFO: renamed from: l */
    public static void m3994l(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        boolean zM584a = AbstractC0306A.m584a(checkableImageButton);
        boolean z3 = onLongClickListener != null;
        boolean z4 = zM584a || z3;
        checkableImageButton.setFocusable(z4);
        checkableImageButton.setClickable(zM584a);
        checkableImageButton.setPressable(zM584a);
        checkableImageButton.setLongClickable(z3);
        AbstractC0307B.m603s(checkableImageButton, z4 ? 1 : 2);
    }

    /* JADX INFO: renamed from: m */
    public static final long m3995m(long j2, EnumC1924c enumC1924c) {
        AbstractC1766e.m3920e("unit", enumC1924c);
        EnumC1924c enumC1924c2 = EnumC1924c.NANOSECONDS;
        AbstractC1766e.m3920e("sourceUnit", enumC1924c2);
        TimeUnit timeUnit = enumC1924c.f6740e;
        TimeUnit timeUnit2 = enumC1924c2.f6740e;
        long jConvert = timeUnit.convert(4611686018426999999L, timeUnit2);
        if (!new C1835i(-jConvert, jConvert).m4075a(j2)) {
            EnumC1924c enumC1924c3 = EnumC1924c.MILLISECONDS;
            AbstractC1766e.m3920e("targetUnit", enumC1924c3);
            return m3989g(AbstractC0752p.m1932a(enumC1924c3.f6740e.convert(j2, timeUnit)));
        }
        long jConvert2 = timeUnit2.convert(j2, timeUnit) << 1;
        int i3 = C1922a.f6730h;
        int i4 = AbstractC1923b.f6732a;
        return jConvert2;
    }
}
