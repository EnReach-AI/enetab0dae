package p124o;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: o.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1789a extends Drawable {

    /* JADX INFO: renamed from: a */
    public float f6168a;

    /* JADX INFO: renamed from: b */
    public final Paint f6169b;

    /* JADX INFO: renamed from: c */
    public final RectF f6170c;

    /* JADX INFO: renamed from: d */
    public final Rect f6171d;

    /* JADX INFO: renamed from: e */
    public float f6172e;

    /* JADX INFO: renamed from: h */
    public ColorStateList f6175h;

    /* JADX INFO: renamed from: i */
    public PorterDuffColorFilter f6176i;

    /* JADX INFO: renamed from: j */
    public ColorStateList f6177j;

    /* JADX INFO: renamed from: f */
    public boolean f6173f = false;

    /* JADX INFO: renamed from: g */
    public boolean f6174g = true;

    /* JADX INFO: renamed from: k */
    public PorterDuff.Mode f6178k = PorterDuff.Mode.SRC_IN;

    public C1789a(ColorStateList colorStateList, float f3) {
        this.f6168a = f3;
        Paint paint = new Paint(5);
        this.f6169b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.f6175h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.f6175h.getDefaultColor()));
        this.f6170c = new RectF();
        this.f6171d = new Rect();
    }

    /* JADX INFO: renamed from: a */
    public final PorterDuffColorFilter m3945a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX INFO: renamed from: b */
    public final void m3946b(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        RectF rectF = this.f6170c;
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
        Rect rect2 = this.f6171d;
        rect2.set(rect);
        if (this.f6173f) {
            rect2.inset((int) Math.ceil(AbstractC1790b.m3947a(this.f6172e, this.f6168a, this.f6174g)), (int) Math.ceil(AbstractC1790b.m3948b(this.f6172e, this.f6168a, this.f6174g)));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z3;
        Paint paint = this.f6169b;
        if (this.f6176i == null || paint.getColorFilter() != null) {
            z3 = false;
        } else {
            paint.setColorFilter(this.f6176i);
            z3 = true;
        }
        RectF rectF = this.f6170c;
        float f3 = this.f6168a;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        if (z3) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f6171d, this.f6168a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f6177j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f6175h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m3946b(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f6175h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f6169b;
        boolean z3 = colorForState != paint.getColor();
        if (z3) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f6177j;
        if (colorStateList2 == null || (mode = this.f6178k) == null) {
            return z3;
        }
        this.f6176i = m3945a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        this.f6169b.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f6169b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f6177j = colorStateList;
        this.f6176i = m3945a(colorStateList, this.f6178k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f6178k = mode;
        this.f6176i = m3945a(this.f6177j, mode);
        invalidateSelf();
    }
}
