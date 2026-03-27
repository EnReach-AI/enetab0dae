package p144t0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.facebook.AbstractC1117n;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p005B.AbstractC0026a;
import p010C0.AbstractC0147a;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1800j;
import p165z.AbstractC2048d;
import p165z.AbstractC2049e;
import p166z0.AbstractC2069g;
import p166z0.C2071i;

/* JADX INFO: renamed from: t0.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1920f {
    /* JADX INFO: renamed from: c */
    public static int m4302c(View view, int i3) {
        Context context = view.getContext();
        TypedValue typedValueM4298s = AbstractC1919e.m4298s(view.getContext(), i3, view.getClass().getCanonicalName());
        int i4 = typedValueM4298s.resourceId;
        return i4 != 0 ? AbstractC2048d.m4520a(context, i4) : typedValueM4298s.data;
    }

    /* JADX INFO: renamed from: d */
    public static ColorStateList m4303d(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        ColorStateList colorStateListM4525c;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (colorStateListM4525c = AbstractC2049e.m4525c(context, resourceId)) == null) ? typedArray.getColorStateList(i3) : colorStateListM4525c;
    }

    /* JADX INFO: renamed from: e */
    public static ColorStateList m4304e(Context context, C2071i c2071i, int i3) {
        int resourceId;
        ColorStateList colorStateListM4525c;
        TypedArray typedArray = (TypedArray) c2071i.f7315b;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (colorStateListM4525c = AbstractC2049e.m4525c(context, resourceId)) == null) ? c2071i.m4600j(i3) : colorStateListM4525c;
    }

    /* JADX INFO: renamed from: f */
    public static Drawable m4305f(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        Drawable drawableM3991i;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (drawableM3991i = AbstractC1800j.m3991i(context, resourceId)) == null) ? typedArray.getDrawable(i3) : drawableM3991i;
    }

    /* JADX INFO: renamed from: g */
    public static File m4306g() {
        if (AbstractC0147a.f354a.contains(AbstractC1920f.class)) {
            return null;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            File file = new File(AbstractC1117n.f3882h.getFilesDir(), "facebook_ml/");
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    return null;
                }
            }
            return file;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1920f.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: j */
    public static boolean m4307j(int i3) {
        boolean z3;
        if (i3 != 0) {
            ThreadLocal threadLocal = AbstractC0026a.f79a;
            double[] dArr = (double[]) threadLocal.get();
            if (dArr == null) {
                dArr = new double[3];
                threadLocal.set(dArr);
            }
            int iRed = Color.red(i3);
            int iGreen = Color.green(i3);
            int iBlue = Color.blue(i3);
            if (dArr.length != 3) {
                throw new IllegalArgumentException("outXyz must have a length of 3.");
            }
            double d = ((double) iRed) / 255.0d;
            double dPow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
            double d3 = ((double) iGreen) / 255.0d;
            double dPow2 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
            double d4 = ((double) iBlue) / 255.0d;
            double dPow3 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
            z3 = false;
            dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
            double d5 = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
            dArr[1] = d5;
            dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
            if (d5 / 100.0d > 0.5d) {
                return true;
            }
        } else {
            z3 = false;
        }
        return z3;
    }

    /* JADX INFO: renamed from: k */
    public static boolean m4308k(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    /* JADX INFO: renamed from: l */
    public static int m4309l(int i3, int i4, float f3) {
        return AbstractC0026a.m105b(AbstractC0026a.m107d(i4, Math.round(Color.alpha(i4) * f3)), i3);
    }

    /* JADX INFO: renamed from: m */
    public static List m4310m(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        AbstractC1766e.m3919d("singletonList(...)", listSingletonList);
        return listSingletonList;
    }

    /* JADX INFO: renamed from: s */
    public static int[] m4311s(String str) {
        String strJoin;
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1920f.class)) {
            return null;
        }
        try {
            int[] iArr = new int[128];
            if (set.contains(AbstractC1920f.class)) {
                strJoin = null;
            } else {
                try {
                    strJoin = TextUtils.join(" ", str.trim().split("\\s+"));
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, AbstractC1920f.class);
                    strJoin = null;
                }
            }
            byte[] bytes = strJoin.getBytes(Charset.forName("UTF-8"));
            for (int i3 = 0; i3 < 128; i3++) {
                if (i3 < bytes.length) {
                    iArr[i3] = bytes[i3] & 255;
                } else {
                    iArr[i3] = 0;
                }
            }
            return iArr;
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1920f.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract int mo575a(View view, int i3);

    /* JADX INFO: renamed from: b */
    public abstract int mo576b(View view, int i3);

    /* JADX INFO: renamed from: h */
    public int mo577h(View view) {
        return 0;
    }

    /* JADX INFO: renamed from: i */
    public int mo578i() {
        return 0;
    }

    /* JADX INFO: renamed from: n */
    public void mo4133n(View view, int i3) {
    }

    /* JADX INFO: renamed from: o */
    public abstract void mo579o(int i3);

    /* JADX INFO: renamed from: p */
    public abstract void mo580p(View view, int i3, int i4);

    /* JADX INFO: renamed from: q */
    public abstract void mo581q(View view, float f3, float f4);

    /* JADX INFO: renamed from: r */
    public abstract boolean mo582r(View view, int i3);
}
