package p144t0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import p005B.AbstractC0032g;
import p010C0.AbstractC0147a;

/* JADX INFO: renamed from: t0.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1919e {
    /* JADX INFO: renamed from: a */
    public static void m4280a(C1915a c1915a, C1915a c1915a2) {
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return;
        }
        try {
            int[] iArr = c1915a.f6697b;
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = iArr[2];
            float[] fArr = c1915a.f6696a;
            float[] fArr2 = c1915a2.f6696a;
            for (int i6 = 0; i6 < i3; i6++) {
                for (int i7 = 0; i7 < i4; i7++) {
                    for (int i8 = 0; i8 < i5; i8++) {
                        int i9 = (i7 * i5) + (i6 * i4 * i5) + i8;
                        fArr[i9] = fArr[i9] + fArr2[i8];
                    }
                }
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m4281b(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = m4282c(r9, r10, r11)
            boolean r1 = m4282c(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L78
            if (r0 != 0) goto Lf
            goto L78
        Lf:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L3d
            if (r9 == r3) goto L36
            if (r9 == r4) goto L2f
            if (r9 != r1) goto L29
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L77
            goto L43
        L29:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L2f:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L77
            goto L43
        L36:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L77
            goto L43
        L3d:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L77
        L43:
            if (r9 == r5) goto L77
            if (r9 != r4) goto L48
            goto L77
        L48:
            int r11 = m4290k(r9, r10, r11)
            if (r9 == r5) goto L6a
            if (r9 == r3) goto L65
            if (r9 == r4) goto L60
            if (r9 != r1) goto L5a
            int r9 = r12.bottom
            int r10 = r10.bottom
        L58:
            int r9 = r9 - r10
            goto L6f
        L5a:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L60:
            int r9 = r12.right
            int r10 = r10.right
            goto L58
        L65:
            int r9 = r10.top
            int r10 = r12.top
            goto L58
        L6a:
            int r9 = r10.left
            int r10 = r12.left
            goto L58
        L6f:
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L76
            r2 = r6
        L76:
            return r2
        L77:
            return r6
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p144t0.AbstractC1919e.m4281b(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4282c(int i3, Rect rect, Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    /* JADX INFO: renamed from: d */
    public static C1915a m4283d(C1915a[] c1915aArr) {
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return null;
        }
        try {
            int i3 = c1915aArr[0].f6697b[0];
            int i4 = 0;
            for (C1915a c1915a : c1915aArr) {
                i4 += c1915a.f6697b[1];
            }
            C1915a c1915a2 = new C1915a(new int[]{i3, i4});
            float[] fArr = c1915a2.f6696a;
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = i5 * i4;
                for (C1915a c1915a3 : c1915aArr) {
                    float[] fArr2 = c1915a3.f6696a;
                    int i7 = c1915a3.f6697b[1];
                    System.arraycopy(fArr2, i5 * i7, fArr, i6, i7);
                    i6 += i7;
                }
            }
            return c1915a2;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static C1915a m4284e(C1915a c1915a, C1915a c1915a2) {
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return null;
        }
        try {
            int[] iArr = c1915a.f6697b;
            int i3 = 0;
            int i4 = iArr[0];
            int i5 = iArr[1];
            int i6 = iArr[2];
            int[] iArr2 = c1915a2.f6697b;
            int i7 = iArr2[0];
            int i8 = (i5 - i7) + 1;
            int i9 = iArr2[2];
            C1915a c1915a3 = new C1915a(new int[]{i4, i8, i9});
            float[] fArr = c1915a.f6696a;
            float[] fArr2 = c1915a3.f6696a;
            float[] fArr3 = c1915a2.f6696a;
            int i10 = 0;
            while (i10 < i4) {
                int i11 = i3;
                while (i11 < i9) {
                    int i12 = i3;
                    while (i12 < i8) {
                        float f3 = 0.0f;
                        while (i3 < i7) {
                            for (int i13 = 0; i13 < i6; i13++) {
                                f3 = (fArr[((i3 + i12) * i6) + (i5 * i6 * i10) + i13] * fArr3[(((i3 * i6) + i13) * i9) + i11]) + f3;
                            }
                            i3++;
                        }
                        fArr2[(i12 * i9) + (i8 * i9 * i10) + i11] = f3;
                        i12++;
                        i3 = 0;
                    }
                    i11++;
                    i3 = 0;
                }
                i10++;
                i3 = 0;
            }
            return c1915a3;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: f */
    public static C1915a m4285f(C1915a c1915a, C1915a c1915a2, C1915a c1915a3) {
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return null;
        }
        try {
            int i3 = c1915a.f6697b[0];
            int i4 = c1915a3.f6697b[0];
            C1915a c1915aM4293n = m4293n(c1915a, c1915a2);
            float[] fArr = c1915a3.f6696a;
            float[] fArr2 = c1915aM4293n.f6696a;
            for (int i5 = 0; i5 < i3; i5++) {
                for (int i6 = 0; i6 < i4; i6++) {
                    int i7 = (i5 * i4) + i6;
                    fArr2[i7] = fArr2[i7] + fArr[i6];
                }
            }
            return c1915aM4293n;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    public static C1915a m4286g(String[] strArr, C1915a c1915a) {
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return null;
        }
        try {
            int length = strArr.length;
            int i3 = c1915a.f6697b[1];
            C1915a c1915a2 = new C1915a(new int[]{length, 128, i3});
            float[] fArr = c1915a2.f6696a;
            float[] fArr2 = c1915a.f6696a;
            for (int i4 = 0; i4 < length; i4++) {
                int[] iArrM4311s = AbstractC1920f.m4311s(strArr[i4]);
                for (int i5 = 0; i5 < 128; i5++) {
                    System.arraycopy(fArr2, iArrM4311s[i5] * i3, fArr, (i3 * i5) + (i3 * 128 * i4), i3);
                }
            }
            return c1915a2;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: h */
    public static void m4287h(C1915a c1915a) {
        int[] iArr;
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return;
        }
        try {
            int i3 = 1;
            if (1 >= c1915a.f6697b.length) {
                return;
            }
            int i4 = 1;
            int i5 = 1;
            while (true) {
                iArr = c1915a.f6697b;
                if (i4 >= iArr.length) {
                    break;
                }
                i5 *= iArr[i4];
                i4++;
            }
            int[] iArr2 = {iArr[0], i5};
            c1915a.f6697b = iArr2;
            for (int i6 = 0; i6 < 2; i6++) {
                i3 *= iArr2[i6];
            }
            float[] fArr = new float[i3];
            System.arraycopy(c1915a.f6696a, 0, fArr, 0, Math.min(c1915a.f6698c, i3));
            c1915a.f6696a = fArr;
            c1915a.f6698c = i3;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
        }
    }

    /* JADX INFO: renamed from: i */
    public static String m4288i(Resources resources, int i3) {
        String resourcePackageName;
        String str;
        if (resources == null) {
            return "#" + Integer.toHexString(i3);
        }
        if (((i3 >>> 24) & 255) != 127) {
            resourcePackageName = resources.getResourcePackageName(i3);
            str = ":";
        } else {
            resourcePackageName = "";
            str = "";
        }
        String resourceTypeName = resources.getResourceTypeName(i3);
        String resourceEntryName = resources.getResourceEntryName(i3);
        StringBuilder sb = new StringBuilder(resourceEntryName.length() + resourceTypeName.length() + str.length() + resourcePackageName.length() + 1 + 1);
        sb.append("@");
        sb.append(resourcePackageName);
        sb.append(str);
        sb.append(resourceTypeName);
        return AbstractC0032g.m157o(sb, "/", resourceEntryName);
    }

    /* JADX INFO: renamed from: j */
    public static boolean m4289j(int i3, Rect rect, Rect rect2) {
        if (i3 == 17) {
            int i4 = rect.right;
            int i5 = rect2.right;
            return (i4 > i5 || rect.left >= i5) && rect.left > rect2.left;
        }
        if (i3 == 33) {
            int i6 = rect.bottom;
            int i7 = rect2.bottom;
            return (i6 > i7 || rect.top >= i7) && rect.top > rect2.top;
        }
        if (i3 == 66) {
            int i8 = rect.left;
            int i9 = rect2.left;
            return (i8 < i9 || rect.right <= i9) && rect.right < rect2.right;
        }
        if (i3 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i10 = rect.top;
        int i11 = rect2.top;
        return (i10 < i11 || rect.bottom <= i11) && rect.bottom < rect2.bottom;
    }

    /* JADX INFO: renamed from: k */
    public static int m4290k(int i3, Rect rect, Rect rect2) {
        int i4;
        int i5;
        if (i3 == 17) {
            i4 = rect.left;
            i5 = rect2.right;
        } else if (i3 == 33) {
            i4 = rect.top;
            i5 = rect2.bottom;
        } else if (i3 == 66) {
            i4 = rect2.left;
            i5 = rect.right;
        } else {
            if (i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i4 = rect2.top;
            i5 = rect.bottom;
        }
        return Math.max(0, i4 - i5);
    }

    /* JADX INFO: renamed from: l */
    public static C1915a m4291l(C1915a c1915a, int i3) {
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return null;
        }
        try {
            int[] iArr = c1915a.f6697b;
            int i4 = 0;
            int i5 = iArr[0];
            int i6 = iArr[1];
            int i7 = iArr[2];
            int i8 = (i6 - i3) + 1;
            C1915a c1915a2 = new C1915a(new int[]{i5, i8, i7});
            float[] fArr = c1915a.f6696a;
            float[] fArr2 = c1915a2.f6696a;
            int i9 = 0;
            while (i9 < i5) {
                int i10 = i4;
                while (i10 < i7) {
                    int i11 = i4;
                    while (i11 < i8) {
                        int i12 = i11 * i7;
                        int i13 = (i9 * i8 * i7) + i12 + i10;
                        int i14 = (i9 * i6 * i7) + i12 + i10;
                        fArr2[i13] = Float.MIN_VALUE;
                        for (int i15 = i4; i15 < i3; i15++) {
                            fArr2[i13] = Math.max(fArr2[i13], fArr[(i15 * i7) + i14]);
                        }
                        i11++;
                        i4 = 0;
                    }
                    i10++;
                    i4 = 0;
                }
                i9++;
                i4 = 0;
            }
            return c1915a2;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: m */
    public static int m4292m(int i3, Rect rect, Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    /* JADX INFO: renamed from: n */
    public static C1915a m4293n(C1915a c1915a, C1915a c1915a2) {
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return null;
        }
        try {
            int i3 = c1915a.f6697b[0];
            int[] iArr = c1915a2.f6697b;
            int i4 = iArr[0];
            int i5 = iArr[1];
            C1915a c1915a3 = new C1915a(new int[]{i3, i5});
            float[] fArr = c1915a.f6696a;
            float[] fArr2 = c1915a2.f6696a;
            float[] fArr3 = c1915a3.f6696a;
            for (int i6 = 0; i6 < i3; i6++) {
                for (int i7 = 0; i7 < i5; i7++) {
                    int i8 = (i6 * i5) + i7;
                    fArr3[i8] = 0.0f;
                    for (int i9 = 0; i9 < i4; i9++) {
                        fArr3[i8] = (fArr[(i6 * i4) + i9] * fArr2[(i9 * i5) + i7]) + fArr3[i8];
                    }
                }
            }
            return c1915a3;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: o */
    public static void m4294o(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    /* JADX INFO: renamed from: p */
    public static void m4295p(C1915a c1915a) {
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return;
        }
        try {
            float[] fArr = c1915a.f6696a;
            for (int i3 = 0; i3 < fArr.length; i3++) {
                if (fArr[i3] < 0.0f) {
                    fArr[i3] = 0.0f;
                }
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
        }
    }

    /* JADX INFO: renamed from: q */
    public static TypedValue m4296q(Context context, int i3) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i3, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    /* JADX INFO: renamed from: r */
    public static boolean m4297r(Context context, int i3, boolean z3) {
        TypedValue typedValueM4296q = m4296q(context, i3);
        return (typedValueM4296q == null || typedValueM4296q.type != 18) ? z3 : typedValueM4296q.data != 0;
    }

    /* JADX INFO: renamed from: s */
    public static TypedValue m4298s(Context context, int i3, String str) {
        TypedValue typedValueM4296q = m4296q(context, i3);
        if (typedValueM4296q != null) {
            return typedValueM4296q;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i3)));
    }

    /* JADX INFO: renamed from: t */
    public static void m4299t(C1915a c1915a) {
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return;
        }
        try {
            int[] iArr = c1915a.f6697b;
            int i3 = iArr[0];
            int i4 = iArr[1];
            float[] fArr = c1915a.f6696a;
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = i5 * i4;
                int i7 = i6 + i4;
                float f3 = Float.MIN_VALUE;
                for (int i8 = i6; i8 < i7; i8++) {
                    float f4 = fArr[i8];
                    if (f4 > f3) {
                        f3 = f4;
                    }
                }
                for (int i9 = i6; i9 < i7; i9++) {
                    fArr[i9] = (float) Math.exp(fArr[i9] - f3);
                }
                float f5 = 0.0f;
                for (int i10 = i6; i10 < i7; i10++) {
                    f5 += fArr[i10];
                }
                while (i6 < i7) {
                    fArr[i6] = fArr[i6] / f5;
                    i6++;
                }
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
        }
    }

    /* JADX INFO: renamed from: u */
    public static C1915a m4300u(C1915a c1915a) {
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return null;
        }
        try {
            int[] iArr = c1915a.f6697b;
            int i3 = iArr[0];
            int i4 = iArr[1];
            C1915a c1915a2 = new C1915a(new int[]{i4, i3});
            float[] fArr = c1915a.f6696a;
            float[] fArr2 = c1915a2.f6696a;
            for (int i5 = 0; i5 < i3; i5++) {
                for (int i6 = 0; i6 < i4; i6++) {
                    fArr2[(i6 * i3) + i5] = fArr[(i5 * i4) + i6];
                }
            }
            return c1915a2;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: v */
    public static C1915a m4301v(C1915a c1915a) {
        if (AbstractC0147a.f354a.contains(AbstractC1919e.class)) {
            return null;
        }
        try {
            int[] iArr = c1915a.f6697b;
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = iArr[2];
            C1915a c1915a2 = new C1915a(new int[]{i5, i4, i3});
            float[] fArr = c1915a.f6696a;
            float[] fArr2 = c1915a2.f6696a;
            for (int i6 = 0; i6 < i3; i6++) {
                for (int i7 = 0; i7 < i4; i7++) {
                    for (int i8 = 0; i8 < i5; i8++) {
                        fArr2[(i7 * i3) + (i8 * i3 * i4) + i6] = fArr[(i7 * i5) + (i6 * i4 * i5) + i8];
                    }
                }
            }
            return c1915a2;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1919e.class);
            return null;
        }
    }
}
