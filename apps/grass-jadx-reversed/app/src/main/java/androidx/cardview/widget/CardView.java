package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import p001A.C0009j;
import p019F0.C0217a;
import p120n.AbstractC1775a;
import p124o.C1789a;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: j */
    public static final int[] f2861j = {R.attr.colorBackground};

    /* JADX INFO: renamed from: k */
    public static final C0217a f2862k = new C0217a(12);

    /* JADX INFO: renamed from: e */
    public boolean f2863e;

    /* JADX INFO: renamed from: f */
    public boolean f2864f;

    /* JADX INFO: renamed from: g */
    public final Rect f2865g;

    /* JADX INFO: renamed from: h */
    public final Rect f2866h;

    /* JADX INFO: renamed from: i */
    public final C0009j f2867i;

    public CardView(Context context, AttributeSet attributeSet) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, io.getgrass.www.R.attr.cardViewStyle);
        Rect rect = new Rect();
        this.f2865g = rect;
        this.f2866h = new Rect();
        C0009j c0009j = new C0009j(this);
        this.f2867i = c0009j;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1775a.f6151a, io.getgrass.www.R.attr.cardViewStyle, io.getgrass.www.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f2861j);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(io.getgrass.www.R.color.cardview_light_background) : getResources().getColor(io.getgrass.www.R.color.cardview_dark_background));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.f2863e = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.f2864f = typedArrayObtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        C0217a c0217a = f2862k;
        C1789a c1789a = new C1789a(colorStateListValueOf, dimension);
        c0009j.f30f = c1789a;
        setBackgroundDrawable(c1789a);
        setClipToOutline(true);
        setElevation(dimension2);
        c0217a.m433g(c0009j, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((C1789a) ((Drawable) this.f2867i.f30f)).f6175h;
    }

    public float getCardElevation() {
        return ((CardView) this.f2867i.f31g).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f2865g.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f2865g.left;
    }

    public int getContentPaddingRight() {
        return this.f2865g.right;
    }

    public int getContentPaddingTop() {
        return this.f2865g.top;
    }

    public float getMaxCardElevation() {
        return ((C1789a) ((Drawable) this.f2867i.f30f)).f6172e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f2864f;
    }

    public float getRadius() {
        return ((C1789a) ((Drawable) this.f2867i.f30f)).f6168a;
    }

    public boolean getUseCompatPadding() {
        return this.f2863e;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
    }

    public void setCardBackgroundColor(int i3) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i3);
        C1789a c1789a = (C1789a) ((Drawable) this.f2867i.f30f);
        if (colorStateListValueOf == null) {
            c1789a.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        c1789a.f6175h = colorStateListValueOf;
        c1789a.f6169b.setColor(colorStateListValueOf.getColorForState(c1789a.getState(), c1789a.f6175h.getDefaultColor()));
        c1789a.invalidateSelf();
    }

    public void setCardElevation(float f3) {
        ((CardView) this.f2867i.f31g).setElevation(f3);
    }

    public void setMaxCardElevation(float f3) {
        f2862k.m433g(this.f2867i, f3);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i3) {
        super.setMinimumHeight(i3);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i3) {
        super.setMinimumWidth(i3);
    }

    @Override // android.view.View
    public final void setPadding(int i3, int i4, int i5, int i6) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i3, int i4, int i5, int i6) {
    }

    public void setPreventCornerOverlap(boolean z3) {
        if (z3 != this.f2864f) {
            this.f2864f = z3;
            C0217a c0217a = f2862k;
            C0009j c0009j = this.f2867i;
            c0217a.m433g(c0009j, ((C1789a) ((Drawable) c0009j.f30f)).f6172e);
        }
    }

    public void setRadius(float f3) {
        C1789a c1789a = (C1789a) ((Drawable) this.f2867i.f30f);
        if (f3 == c1789a.f6168a) {
            return;
        }
        c1789a.f6168a = f3;
        c1789a.m3946b(null);
        c1789a.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z3) {
        if (this.f2863e != z3) {
            this.f2863e = z3;
            C0217a c0217a = f2862k;
            C0009j c0009j = this.f2867i;
            c0217a.m433g(c0009j, ((C1789a) ((Drawable) c0009j.f30f)).f6172e);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        C1789a c1789a = (C1789a) ((Drawable) this.f2867i.f30f);
        if (colorStateList == null) {
            c1789a.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        c1789a.f6175h = colorStateList;
        c1789a.f6169b.setColor(colorStateList.getColorForState(c1789a.getState(), c1789a.f6175h.getDefaultColor()));
        c1789a.invalidateSelf();
    }
}
