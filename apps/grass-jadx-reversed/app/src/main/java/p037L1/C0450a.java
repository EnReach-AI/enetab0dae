package p037L1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import io.getgrass.www.R;
import p110k.C1564X;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1919e;

/* JADX INFO: renamed from: L1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0450a extends C1564X {
    /* JADX INFO: renamed from: g */
    public static int m987g(Context context, TypedArray typedArray, int... iArr) {
        int dimensionPixelSize = -1;
        for (int i3 = 0; i3 < iArr.length && dimensionPixelSize < 0; i3++) {
            int i4 = iArr[i3];
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i4, typedValue) && typedValue.type == 2) {
                TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
                typedArrayObtainStyledAttributes.recycle();
                dimensionPixelSize = dimensionPixelSize2;
            } else {
                dimensionPixelSize = typedArray.getDimensionPixelSize(i4, -1);
            }
        }
        return dimensionPixelSize;
    }

    @Override // p110k.C1564X, android.widget.TextView
    public final void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        if (AbstractC1919e.m4297r(context, R.attr.textAppearanceLineHeightEnabled, true)) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i3, AbstractC1805a.f6240p);
            int iM987g = m987g(getContext(), typedArrayObtainStyledAttributes, 1, 2);
            typedArrayObtainStyledAttributes.recycle();
            if (iM987g >= 0) {
                setLineHeight(iM987g);
            }
        }
    }
}
