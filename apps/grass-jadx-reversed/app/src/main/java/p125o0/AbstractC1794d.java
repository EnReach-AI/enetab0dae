package p125o0;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Path;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.EditText;
import com.facebook.AbstractC1117n;
import java.util.Set;
import p005B.AbstractC0032g;
import p005B.C0033h;
import p010C0.AbstractC0147a;
import p035L.AbstractC0440a;
import p071Y0.AbstractC0752p;
import p083b2.C1070o;
import p083b2.C1072q;
import p117m0.AbstractC1717l;
import p119m2.AbstractC1766e;
import p129p0.C1819a;
import p141s0.AbstractC1875e;
import p144t0.AbstractC1919e;

/* JADX INFO: renamed from: o0.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1794d {
    /* JADX INFO: renamed from: e */
    public static float m3949e(String[] strArr, int i3) {
        float f3 = Float.parseFloat(strArr[i3]);
        if (f3 >= 0.0f && f3 <= 1.0f) {
            return f3;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f3);
    }

    /* JADX INFO: renamed from: f */
    public static final int m3950f(int i3, int i4, int i5) {
        if (i5 > 0) {
            if (i3 >= i4) {
                return i4;
            }
            int i6 = i4 % i5;
            if (i6 < 0) {
                i6 += i5;
            }
            int i7 = i3 % i5;
            if (i7 < 0) {
                i7 += i5;
            }
            int i8 = (i6 - i7) % i5;
            if (i8 < 0) {
                i8 += i5;
            }
            return i4 - i8;
        }
        if (i5 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        if (i3 <= i4) {
            return i4;
        }
        int i9 = -i5;
        int i10 = i3 % i9;
        if (i10 < 0) {
            i10 += i9;
        }
        int i11 = i4 % i9;
        if (i11 < 0) {
            i11 += i9;
        }
        int i12 = (i10 - i11) % i9;
        if (i12 < 0) {
            i12 += i9;
        }
        return i4 + i12;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m3951g(EditText editText) {
        return editText.getInputType() != 0;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m3952h(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    /* JADX INFO: renamed from: i */
    public static void m3953i(C1819a c1819a, View view, View view2) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1794d.class)) {
            return;
        }
        try {
            String str = c1819a.f6302a;
            Bundle bundleM3967i = C1798h.m3967i(c1819a, view, view2);
            if (!set.contains(AbstractC1794d.class)) {
                try {
                    String string = bundleM3967i.getString("_valueToSum");
                    if (string != null) {
                        bundleM3967i.putDouble("_valueToSum", AbstractC1875e.m4198d(string));
                    }
                    bundleM3967i.putString("_is_fb_codeless", "1");
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, AbstractC1794d.class);
                }
            }
            AbstractC1117n.m2891a().execute(new RunnableC1791a(str, bundleM3967i, 0));
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1794d.class);
        }
    }

    /* JADX INFO: renamed from: l */
    public static int m3954l(Context context, int i3, int i4) {
        TypedValue typedValueM4296q = AbstractC1919e.m4296q(context, i3);
        return (typedValueM4296q == null || typedValueM4296q.type != 16) ? i4 : typedValueM4296q.data;
    }

    /* JADX INFO: renamed from: m */
    public static TimeInterpolator m3955m(Context context, int i3, Interpolator interpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i3, typedValue, true)) {
            return interpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!m3952h(strValueOf, "cubic-bezier") && !m3952h(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (m3952h(strValueOf, "cubic-bezier")) {
            String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
            if (strArrSplit.length == 4) {
                return AbstractC0440a.m974b(m3949e(strArrSplit, 0), m3949e(strArrSplit, 1), m3949e(strArrSplit, 2), m3949e(strArrSplit, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
        }
        if (!m3952h(strValueOf, "path")) {
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String strSubstring = strValueOf.substring(5, strValueOf.length() - 1);
        Path path = new Path();
        C0033h[] c0033hArrM1935d = AbstractC0752p.m1935d(strSubstring);
        if (c0033hArrM1935d != null) {
            try {
                C0033h.m169b(c0033hArrM1935d, path);
            } catch (RuntimeException e3) {
                throw new RuntimeException(AbstractC0032g.m152j("Error in parsing ", strSubstring), e3);
            }
        } else {
            path = null;
        }
        return AbstractC0440a.m975c(path);
    }

    /* JADX INFO: renamed from: n */
    public static final C1070o m3956n(String str) {
        int i3;
        AbstractC1717l.m3798a();
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        if (AbstractC1766e.m3921f(cCharAt, 48) < 0) {
            i3 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i3 = 0;
        }
        int iDivideUnsigned = 119304647;
        while (i3 < length) {
            int iDigit = Character.digit((int) str.charAt(i3), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i4, iDivideUnsigned) > 0) {
                if (iDivideUnsigned == 119304647) {
                    iDivideUnsigned = Integer.divideUnsigned(-1, 10);
                    if (Integer.compareUnsigned(i4, iDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            int i5 = i4 * 10;
            int i6 = iDigit + i5;
            if (Integer.compareUnsigned(i6, i5) < 0) {
                return null;
            }
            i3++;
            i4 = i6;
        }
        return new C1070o(i4);
    }

    /* JADX INFO: renamed from: o */
    public static final C1072q m3957o(String str) {
        AbstractC1766e.m3920e("<this>", str);
        AbstractC1717l.m3798a();
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        if (AbstractC1766e.m3921f(cCharAt, 48) < 0) {
            i3 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long j2 = 10;
        long j3 = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i3 < length) {
            int iDigit = Character.digit((int) str.charAt(i3), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Long.compareUnsigned(j3, jDivideUnsigned) > 0) {
                if (jDivideUnsigned != 512409557603043100L) {
                    return null;
                }
                jDivideUnsigned = Long.divideUnsigned(-1L, j2);
                if (Long.compareUnsigned(j3, jDivideUnsigned) > 0) {
                    return null;
                }
            }
            long j4 = j3 * j2;
            long j5 = (((long) iDigit) & 4294967295L) + j4;
            if (Long.compareUnsigned(j5, j4) < 0) {
                return null;
            }
            i3++;
            j3 = j5;
        }
        return new C1072q(j3);
    }

    /* JADX INFO: renamed from: j */
    public abstract View mo2464j(int i3);

    /* JADX INFO: renamed from: k */
    public abstract boolean mo2465k();
}
