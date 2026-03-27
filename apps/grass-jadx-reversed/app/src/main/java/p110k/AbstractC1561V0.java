package p110k;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import p005B.AbstractC0026a;
import p094f.AbstractC1343a;
import p165z.AbstractC2049e;

/* JADX INFO: renamed from: k.V0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1561V0 {

    /* JADX INFO: renamed from: a */
    public static final ThreadLocal f5578a = new ThreadLocal();

    /* JADX INFO: renamed from: b */
    public static final int[] f5579b = {-16842910};

    /* JADX INFO: renamed from: c */
    public static final int[] f5580c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d */
    public static final int[] f5581d = {R.attr.state_pressed};

    /* JADX INFO: renamed from: e */
    public static final int[] f5582e = {R.attr.state_checked};

    /* JADX INFO: renamed from: f */
    public static final int[] f5583f = new int[0];

    /* JADX INFO: renamed from: g */
    public static final int[] f5584g = new int[1];

    /* JADX INFO: renamed from: a */
    public static void m3628a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC1343a.f4786j);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(117)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m3629b(Context context, int i3) {
        ColorStateList colorStateListM3631d = m3631d(context, i3);
        if (colorStateListM3631d != null && colorStateListM3631d.isStateful()) {
            return colorStateListM3631d.getColorForState(f5579b, colorStateListM3631d.getDefaultColor());
        }
        ThreadLocal threadLocal = f5578a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f3 = typedValue.getFloat();
        return AbstractC0026a.m107d(m3630c(context, i3), Math.round(Color.alpha(r4) * f3));
    }

    /* JADX INFO: renamed from: c */
    public static int m3630c(Context context, int i3) {
        int[] iArr = f5584g;
        iArr[0] = i3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: d */
    public static ColorStateList m3631d(Context context, int i3) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = f5584g;
        iArr[0] = i3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = AbstractC2049e.m4525c(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
