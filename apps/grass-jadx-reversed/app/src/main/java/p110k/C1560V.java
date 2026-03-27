package p110k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import com.facebook.C1124u;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import p029J.AbstractC0323S;
import p038M.AbstractC0451a;
import p039M0.AbstractC0493h0;
import p041N.AbstractC0527o;
import p041N.AbstractC0529q;
import p041N.AbstractC0530r;
import p094f.AbstractC1343a;
import p129p0.AbstractC1822d;
import p165z.AbstractC2049e;
import p166z0.C2071i;

/* JADX INFO: renamed from: k.V */
/* JADX INFO: loaded from: classes.dex */
public final class C1560V {

    /* JADX INFO: renamed from: a */
    public final TextView f5565a;

    /* JADX INFO: renamed from: b */
    public C1124u f5566b;

    /* JADX INFO: renamed from: c */
    public C1124u f5567c;

    /* JADX INFO: renamed from: d */
    public C1124u f5568d;

    /* JADX INFO: renamed from: e */
    public C1124u f5569e;

    /* JADX INFO: renamed from: f */
    public C1124u f5570f;

    /* JADX INFO: renamed from: g */
    public C1124u f5571g;

    /* JADX INFO: renamed from: h */
    public C1124u f5572h;

    /* JADX INFO: renamed from: i */
    public final C1574b0 f5573i;

    /* JADX INFO: renamed from: j */
    public int f5574j = 0;

    /* JADX INFO: renamed from: k */
    public int f5575k = -1;

    /* JADX INFO: renamed from: l */
    public Typeface f5576l;

    /* JADX INFO: renamed from: m */
    public boolean f5577m;

    public C1560V(TextView textView) {
        this.f5565a = textView;
        this.f5573i = new C1574b0(textView);
    }

    /* JADX INFO: renamed from: c */
    public static C1124u m3617c(Context context, C1613r c1613r, int i3) {
        ColorStateList colorStateListM3585h;
        synchronized (c1613r) {
            colorStateListM3585h = c1613r.f5723a.m3585h(context, i3);
        }
        if (colorStateListM3585h == null) {
            return null;
        }
        C1124u c1124u = new C1124u();
        c1124u.f3897f = true;
        c1124u.f3898g = colorStateListM3585h;
        return c1124u;
    }

    /* JADX INFO: renamed from: h */
    public static void m3618h(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i3 >= 30) {
            AbstractC0451a.m988a(editorInfo, text);
            return;
        }
        text.getClass();
        if (i3 >= 30) {
            AbstractC0451a.m988a(editorInfo, text);
            return;
        }
        int i4 = editorInfo.initialSelStart;
        int i5 = editorInfo.initialSelEnd;
        int i6 = i4 > i5 ? i5 : i4;
        if (i4 <= i5) {
            i4 = i5;
        }
        int length = text.length();
        if (i6 < 0 || i4 > length) {
            AbstractC1822d.m4054h(editorInfo, null, 0, 0);
            return;
        }
        int i7 = editorInfo.inputType & 4095;
        if (i7 == 129 || i7 == 225 || i7 == 18) {
            AbstractC1822d.m4054h(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            AbstractC1822d.m4054h(editorInfo, text, i6, i4);
            return;
        }
        int i8 = i4 - i6;
        int i9 = i8 > 1024 ? 0 : i8;
        int i10 = 2048 - i9;
        int iMin = Math.min(text.length() - i4, i10 - Math.min(i6, (int) (((double) i10) * 0.8d)));
        int iMin2 = Math.min(i6, i10 - iMin);
        int i11 = i6 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i11))) {
            i11++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i4 + iMin) - 1))) {
            iMin--;
        }
        int i12 = iMin2 + i9;
        AbstractC1822d.m4054h(editorInfo, i9 != i8 ? TextUtils.concat(text.subSequence(i11, i11 + iMin2), text.subSequence(i4, iMin + i4)) : text.subSequence(i11, i12 + iMin + i11), iMin2, i12);
    }

    /* JADX INFO: renamed from: a */
    public final void m3619a(Drawable drawable, C1124u c1124u) {
        if (drawable == null || c1124u == null) {
            return;
        }
        C1613r.m3682d(drawable, c1124u, this.f5565a.getDrawableState());
    }

    /* JADX INFO: renamed from: b */
    public final void m3620b() {
        C1124u c1124u = this.f5566b;
        TextView textView = this.f5565a;
        if (c1124u != null || this.f5567c != null || this.f5568d != null || this.f5569e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            m3619a(compoundDrawables[0], this.f5566b);
            m3619a(compoundDrawables[1], this.f5567c);
            m3619a(compoundDrawables[2], this.f5568d);
            m3619a(compoundDrawables[3], this.f5569e);
        }
        if (this.f5570f == null && this.f5571g == null) {
            return;
        }
        Drawable[] drawableArrM3603a = AbstractC1551Q.m3603a(textView);
        m3619a(drawableArrM3603a[0], this.f5570f);
        m3619a(drawableArrM3603a[2], this.f5571g);
    }

    /* JADX INFO: renamed from: d */
    public final ColorStateList m3621d() {
        C1124u c1124u = this.f5572h;
        if (c1124u != null) {
            return (ColorStateList) c1124u.f3898g;
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public final PorterDuff.Mode m3622e() {
        C1124u c1124u = this.f5572h;
        if (c1124u != null) {
            return (PorterDuff.Mode) c1124u.f3899h;
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    public final void m3623f(AttributeSet attributeSet, int i3) {
        boolean z3;
        boolean z4;
        String string;
        String string2;
        boolean z5;
        int i4;
        int i5;
        ColorStateList colorStateList;
        int resourceId;
        int i6;
        int resourceId2;
        int i7;
        TextView textView = this.f5565a;
        Context context = textView.getContext();
        C1613r c1613rM3680a = C1613r.m3680a();
        int[] iArr = AbstractC1343a.f4784h;
        C2071i c2071iM4591v = C2071i.m4591v(context, attributeSet, iArr, i3, 0);
        AbstractC0323S.m700j(textView, textView.getContext(), iArr, attributeSet, (TypedArray) c2071iM4591v.f7315b, i3);
        TypedArray typedArray = (TypedArray) c2071iM4591v.f7315b;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.f5566b = m3617c(context, c1613rM3680a, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.f5567c = m3617c(context, c1613rM3680a, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.f5568d = m3617c(context, c1613rM3680a, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.f5569e = m3617c(context, c1613rM3680a, typedArray.getResourceId(2, 0));
        }
        if (typedArray.hasValue(5)) {
            this.f5570f = m3617c(context, c1613rM3680a, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.f5571g = m3617c(context, c1613rM3680a, typedArray.getResourceId(6, 0));
        }
        c2071iM4591v.m4608x();
        boolean z6 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = AbstractC1343a.f4799w;
        if (resourceId3 != -1) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            C2071i c2071i = new C2071i(context, typedArrayObtainStyledAttributes);
            if (z6 || !typedArrayObtainStyledAttributes.hasValue(14)) {
                z3 = false;
                z4 = false;
            } else {
                z4 = typedArrayObtainStyledAttributes.getBoolean(14, false);
                z3 = true;
            }
            m3627k(context, c2071i);
            if (typedArrayObtainStyledAttributes.hasValue(15)) {
                string2 = typedArrayObtainStyledAttributes.getString(15);
                i7 = 13;
            } else {
                i7 = 13;
                string2 = null;
            }
            string = typedArrayObtainStyledAttributes.hasValue(i7) ? typedArrayObtainStyledAttributes.getString(i7) : null;
            c2071i.m4608x();
        } else {
            z3 = false;
            z4 = false;
            string = null;
            string2 = null;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i3, 0);
        C2071i c2071i2 = new C2071i(context, typedArrayObtainStyledAttributes2);
        if (z6 || !typedArrayObtainStyledAttributes2.hasValue(14)) {
            z5 = z4;
        } else {
            z5 = typedArrayObtainStyledAttributes2.getBoolean(14, false);
            z3 = true;
        }
        if (typedArrayObtainStyledAttributes2.hasValue(15)) {
            string2 = typedArrayObtainStyledAttributes2.getString(15);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(13)) {
            string = typedArrayObtainStyledAttributes2.getString(13);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(0) && typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        m3627k(context, c2071i2);
        c2071i2.m4608x();
        if (!z6 && z3) {
            textView.setAllCaps(z5);
        }
        Typeface typeface = this.f5576l;
        if (typeface != null) {
            if (this.f5575k == -1) {
                textView.setTypeface(typeface, this.f5574j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (string != null) {
            AbstractC1556T.m3611d(textView, string);
        }
        if (string2 != null) {
            AbstractC1554S.m3607b(textView, AbstractC1554S.m3606a(string2));
        }
        int[] iArr3 = AbstractC1343a.f4785i;
        C1574b0 c1574b0 = this.f5573i;
        Context context2 = c1574b0.f5608i;
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i3, 0);
        TextView textView2 = c1574b0.f5607h;
        AbstractC0323S.m700j(textView2, textView2.getContext(), iArr3, attributeSet, typedArrayObtainStyledAttributes3, i3);
        if (typedArrayObtainStyledAttributes3.hasValue(5)) {
            c1574b0.f5600a = typedArrayObtainStyledAttributes3.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes3.hasValue(4) ? typedArrayObtainStyledAttributes3.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes3.hasValue(2) ? typedArrayObtainStyledAttributes3.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes3.hasValue(1) ? typedArrayObtainStyledAttributes3.getDimension(1, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes3.hasValue(3) && (resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = typedArrayObtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i8 = 0; i8 < length; i8++) {
                    iArr4[i8] = typedArrayObtainTypedArray.getDimensionPixelSize(i8, -1);
                }
                c1574b0.f5605f = C1574b0.m3642a(iArr4);
                c1574b0.m3644c();
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (!c1574b0.m3645d()) {
            c1574b0.f5600a = 0;
        } else if (c1574b0.f5600a == 1) {
            if (!c1574b0.f5606g) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i6 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i6 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i6, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                c1574b0.m3646e(dimension2, dimension3, dimension);
            }
            c1574b0.m3643b();
        }
        Method method = AbstractC1596i1.f5667a;
        if (c1574b0.f5600a != 0) {
            int[] iArr5 = c1574b0.f5605f;
            if (iArr5.length > 0) {
                if (AbstractC1556T.m3608a(textView) != -1.0f) {
                    AbstractC1556T.m3609b(textView, Math.round(c1574b0.f5603d), Math.round(c1574b0.f5604e), Math.round(c1574b0.f5602c), 0);
                } else {
                    AbstractC1556T.m3610c(textView, iArr5, 0);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = typedArrayObtainStyledAttributes4.getResourceId(8, -1);
        Drawable drawableM3683b = resourceId4 != -1 ? c1613rM3680a.m3683b(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(13, -1);
        Drawable drawableM3683b2 = resourceId5 != -1 ? c1613rM3680a.m3683b(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes4.getResourceId(9, -1);
        Drawable drawableM3683b3 = resourceId6 != -1 ? c1613rM3680a.m3683b(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes4.getResourceId(6, -1);
        Drawable drawableM3683b4 = resourceId7 != -1 ? c1613rM3680a.m3683b(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes4.getResourceId(10, -1);
        Drawable drawableM3683b5 = resourceId8 != -1 ? c1613rM3680a.m3683b(context, resourceId8) : null;
        int resourceId9 = typedArrayObtainStyledAttributes4.getResourceId(7, -1);
        Drawable drawableM3683b6 = resourceId9 != -1 ? c1613rM3680a.m3683b(context, resourceId9) : null;
        if (drawableM3683b5 != null || drawableM3683b6 != null) {
            Drawable[] drawableArrM3603a = AbstractC1551Q.m3603a(textView);
            if (drawableM3683b5 == null) {
                drawableM3683b5 = drawableArrM3603a[0];
            }
            if (drawableM3683b2 == null) {
                drawableM3683b2 = drawableArrM3603a[1];
            }
            if (drawableM3683b6 == null) {
                drawableM3683b6 = drawableArrM3603a[2];
            }
            if (drawableM3683b4 == null) {
                drawableM3683b4 = drawableArrM3603a[3];
            }
            AbstractC1551Q.m3604b(textView, drawableM3683b5, drawableM3683b2, drawableM3683b6, drawableM3683b4);
        } else if (drawableM3683b != null || drawableM3683b2 != null || drawableM3683b3 != null || drawableM3683b4 != null) {
            Drawable[] drawableArrM3603a2 = AbstractC1551Q.m3603a(textView);
            Drawable drawable = drawableArrM3603a2[0];
            if (drawable == null && drawableArrM3603a2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (drawableM3683b == null) {
                    drawableM3683b = compoundDrawables[0];
                }
                if (drawableM3683b2 == null) {
                    drawableM3683b2 = compoundDrawables[1];
                }
                if (drawableM3683b3 == null) {
                    drawableM3683b3 = compoundDrawables[2];
                }
                if (drawableM3683b4 == null) {
                    drawableM3683b4 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableM3683b, drawableM3683b2, drawableM3683b3, drawableM3683b4);
            } else {
                if (drawableM3683b2 == null) {
                    drawableM3683b2 = drawableArrM3603a2[1];
                }
                Drawable drawable2 = drawableArrM3603a2[2];
                if (drawableM3683b4 == null) {
                    drawableM3683b4 = drawableArrM3603a2[3];
                }
                AbstractC1551Q.m3604b(textView, drawable, drawableM3683b2, drawable2, drawableM3683b4);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(11)) {
            if (!typedArrayObtainStyledAttributes4.hasValue(11) || (resourceId = typedArrayObtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = AbstractC2049e.m4525c(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes4.getColorStateList(11);
            }
            AbstractC0529q.m1064f(textView, colorStateList);
        }
        if (typedArrayObtainStyledAttributes4.hasValue(12)) {
            i4 = -1;
            AbstractC0529q.m1065g(textView, AbstractC1589g0.m3652b(typedArrayObtainStyledAttributes4.getInt(12, -1), null));
        } else {
            i4 = -1;
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes4.getDimensionPixelSize(15, i4);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(18, i4);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(19, i4);
        typedArrayObtainStyledAttributes4.recycle();
        if (dimensionPixelSize != i4) {
            AbstractC0493h0.m1009b(dimensionPixelSize);
            AbstractC0530r.m1069c(textView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != i4) {
            AbstractC0493h0.m1009b(dimensionPixelSize2);
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            int i9 = AbstractC0527o.m1048a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
            if (dimensionPixelSize2 > Math.abs(i9)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), dimensionPixelSize2 - i9);
            }
            i5 = -1;
        } else {
            i5 = i4;
        }
        if (dimensionPixelSize3 != i5) {
            AbstractC0493h0.m1009b(dimensionPixelSize3);
            if (dimensionPixelSize3 != textView.getPaint().getFontMetricsInt(null)) {
                textView.setLineSpacing(dimensionPixelSize3 - r1, 1.0f);
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m3624g(Context context, int i3) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, AbstractC1343a.f4799w);
        C2071i c2071i = new C2071i(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.f5565a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        m3627k(context, c2071i);
        if (typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            AbstractC1556T.m3611d(textView, string);
        }
        c2071i.m4608x();
        Typeface typeface = this.f5576l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f5574j);
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m3625i(ColorStateList colorStateList) {
        if (this.f5572h == null) {
            this.f5572h = new C1124u();
        }
        C1124u c1124u = this.f5572h;
        c1124u.f3898g = colorStateList;
        c1124u.f3897f = colorStateList != null;
        this.f5566b = c1124u;
        this.f5567c = c1124u;
        this.f5568d = c1124u;
        this.f5569e = c1124u;
        this.f5570f = c1124u;
        this.f5571g = c1124u;
    }

    /* JADX INFO: renamed from: j */
    public final void m3626j(PorterDuff.Mode mode) {
        if (this.f5572h == null) {
            this.f5572h = new C1124u();
        }
        C1124u c1124u = this.f5572h;
        c1124u.f3899h = mode;
        c1124u.f3896e = mode != null;
        this.f5566b = c1124u;
        this.f5567c = c1124u;
        this.f5568d = c1124u;
        this.f5569e = c1124u;
        this.f5570f = c1124u;
        this.f5571g = c1124u;
    }

    /* JADX INFO: renamed from: k */
    public final void m3627k(Context context, C2071i c2071i) {
        String string;
        int i3 = this.f5574j;
        TypedArray typedArray = (TypedArray) c2071i.f7315b;
        this.f5574j = typedArray.getInt(2, i3);
        int i4 = typedArray.getInt(11, -1);
        this.f5575k = i4;
        if (i4 != -1) {
            this.f5574j &= 2;
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f5577m = false;
                int i5 = typedArray.getInt(1, 1);
                if (i5 == 1) {
                    this.f5576l = Typeface.SANS_SERIF;
                    return;
                } else if (i5 == 2) {
                    this.f5576l = Typeface.SERIF;
                    return;
                } else {
                    if (i5 != 3) {
                        return;
                    }
                    this.f5576l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f5576l = null;
        int i6 = typedArray.hasValue(12) ? 12 : 10;
        int i7 = this.f5575k;
        int i8 = this.f5574j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceM4603n = c2071i.m4603n(i6, this.f5574j, new C1549P(this, i7, i8, new WeakReference(this.f5565a)));
                if (typefaceM4603n != null) {
                    if (this.f5575k != -1) {
                        this.f5576l = AbstractC1558U.m3612a(Typeface.create(typefaceM4603n, 0), this.f5575k, (this.f5574j & 2) != 0);
                    } else {
                        this.f5576l = typefaceM4603n;
                    }
                }
                this.f5577m = this.f5576l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f5576l != null || (string = typedArray.getString(i6)) == null) {
            return;
        }
        if (this.f5575k != -1) {
            this.f5576l = AbstractC1558U.m3612a(Typeface.create(string, 0), this.f5575k, (this.f5574j & 2) != 0);
        } else {
            this.f5576l = Typeface.create(string, this.f5574j);
        }
    }
}
