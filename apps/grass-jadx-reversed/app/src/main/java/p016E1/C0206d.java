package p016E1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import p001A.AbstractC0017r;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1920f;
import p148u0.AbstractC1944c;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: E1.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0206d {

    /* JADX INFO: renamed from: a */
    public final ColorStateList f498a;

    /* JADX INFO: renamed from: b */
    public final String f499b;

    /* JADX INFO: renamed from: c */
    public final int f500c;

    /* JADX INFO: renamed from: d */
    public final int f501d;

    /* JADX INFO: renamed from: e */
    public final float f502e;

    /* JADX INFO: renamed from: f */
    public final float f503f;

    /* JADX INFO: renamed from: g */
    public final float f504g;

    /* JADX INFO: renamed from: h */
    public final boolean f505h;

    /* JADX INFO: renamed from: i */
    public final float f506i;

    /* JADX INFO: renamed from: j */
    public final ColorStateList f507j;

    /* JADX INFO: renamed from: k */
    public float f508k;

    /* JADX INFO: renamed from: l */
    public final int f509l;

    /* JADX INFO: renamed from: m */
    public boolean f510m = false;

    /* JADX INFO: renamed from: n */
    public Typeface f511n;

    public C0206d(Context context, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, AbstractC1805a.f6248x);
        this.f508k = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.f507j = AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 3);
        AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 4);
        AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 5);
        this.f500c = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.f501d = typedArrayObtainStyledAttributes.getInt(1, 1);
        int i4 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f509l = typedArrayObtainStyledAttributes.getResourceId(i4, 0);
        this.f499b = typedArrayObtainStyledAttributes.getString(i4);
        typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.f498a = AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 6);
        this.f502e = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.f503f = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.f504g = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i3, AbstractC1805a.f6240p);
        this.f505h = typedArrayObtainStyledAttributes2.hasValue(0);
        this.f506i = typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    /* JADX INFO: renamed from: a */
    public final void m396a() {
        String str;
        Typeface typeface = this.f511n;
        int i3 = this.f500c;
        if (typeface == null && (str = this.f499b) != null) {
            this.f511n = Typeface.create(str, i3);
        }
        if (this.f511n == null) {
            int i4 = this.f501d;
            if (i4 == 1) {
                this.f511n = Typeface.SANS_SERIF;
            } else if (i4 == 2) {
                this.f511n = Typeface.SERIF;
            } else if (i4 != 3) {
                this.f511n = Typeface.DEFAULT;
            } else {
                this.f511n = Typeface.MONOSPACE;
            }
            this.f511n = Typeface.create(this.f511n, i3);
        }
    }

    /* JADX INFO: renamed from: b */
    public final Typeface m397b(Context context) {
        if (this.f510m) {
            return this.f511n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceM72a = AbstractC0017r.m72a(context, this.f509l);
                this.f511n = typefaceM72a;
                if (typefaceM72a != null) {
                    this.f511n = Typeface.create(typefaceM72a, this.f500c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e3) {
                Log.d("TextAppearance", "Error loading font " + this.f499b, e3);
            }
        }
        m396a();
        this.f510m = true;
        return this.f511n;
    }

    /* JADX INFO: renamed from: c */
    public final void m398c(Context context, AbstractC1944c abstractC1944c) {
        if (m399d(context)) {
            m397b(context);
        } else {
            m396a();
        }
        int i3 = this.f509l;
        if (i3 == 0) {
            this.f510m = true;
        }
        if (this.f510m) {
            abstractC1944c.mo210e(this.f511n, true);
            return;
        }
        try {
            C0204b c0204b = new C0204b(this, abstractC1944c);
            ThreadLocal threadLocal = AbstractC0017r.f43a;
            if (context.isRestricted()) {
                c0204b.m12a(-4);
            } else {
                AbstractC0017r.m73b(context, i3, new TypedValue(), 0, c0204b, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f510m = true;
            abstractC1944c.mo209d(1);
        } catch (Exception e3) {
            Log.d("TextAppearance", "Error loading font " + this.f499b, e3);
            this.f510m = true;
            abstractC1944c.mo209d(-3);
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m399d(Context context) {
        Typeface typefaceM73b = null;
        int i3 = this.f509l;
        if (i3 != 0) {
            ThreadLocal threadLocal = AbstractC0017r.f43a;
            if (!context.isRestricted()) {
                typefaceM73b = AbstractC0017r.m73b(context, i3, new TypedValue(), 0, null, false, true);
            }
        }
        return typefaceM73b != null;
    }

    /* JADX INFO: renamed from: e */
    public final void m400e(Context context, TextPaint textPaint, AbstractC1944c abstractC1944c) {
        m401f(context, textPaint, abstractC1944c);
        ColorStateList colorStateList = this.f507j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f498a;
        textPaint.setShadowLayer(this.f504g, this.f502e, this.f503f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    /* JADX INFO: renamed from: f */
    public final void m401f(Context context, TextPaint textPaint, AbstractC1944c abstractC1944c) {
        if (m399d(context)) {
            m402g(context, textPaint, m397b(context));
            return;
        }
        m396a();
        m402g(context, textPaint, this.f511n);
        m398c(context, new C0205c(this, context, textPaint, abstractC1944c));
    }

    /* JADX INFO: renamed from: g */
    public final void m402g(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceM4347e = AbstractC1946e.m4347e(context.getResources().getConfiguration(), typeface);
        if (typefaceM4347e != null) {
            typeface = typefaceM4347e;
        }
        textPaint.setTypeface(typeface);
        int i3 = (~typeface.getStyle()) & this.f500c;
        textPaint.setFakeBoldText((i3 & 1) != 0);
        textPaint.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f508k);
        if (this.f505h) {
            textPaint.setLetterSpacing(this.f506i);
        }
    }
}
