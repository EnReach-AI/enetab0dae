package p007B1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import p110k.AbstractC1614r0;
import p126o1.AbstractC1805a;

/* JADX INFO: renamed from: B1.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0046f extends AbstractC1614r0 {

    /* JADX INFO: renamed from: t */
    public Drawable f171t;

    /* JADX INFO: renamed from: u */
    public final Rect f172u;

    /* JADX INFO: renamed from: v */
    public final Rect f173v;

    /* JADX INFO: renamed from: w */
    public int f174w;

    /* JADX INFO: renamed from: x */
    public final boolean f175x;

    /* JADX INFO: renamed from: y */
    public boolean f176y;

    public AbstractC0046f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f172u = new Rect();
        this.f173v = new Rect();
        this.f174w = 119;
        this.f175x = true;
        this.f176y = false;
        int[] iArr = AbstractC1805a.f6231g;
        AbstractC0054n.m211a(context, attributeSet, 0, 0);
        AbstractC0054n.m212b(context, attributeSet, iArr, 0, 0, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        this.f174w = typedArrayObtainStyledAttributes.getInt(1, this.f174w);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f175x = typedArrayObtainStyledAttributes.getBoolean(2, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f171t;
        if (drawable != null) {
            if (this.f176y) {
                this.f176y = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z3 = this.f175x;
                Rect rect = this.f172u;
                if (z3) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i3 = this.f174w;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.f173v;
                Gravity.apply(i3, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void drawableHotspotChanged(float f3, float f4) {
        super.drawableHotspotChanged(f3, f4);
        Drawable drawable = this.f171t;
        if (drawable != null) {
            drawable.setHotspot(f3, f4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f171t;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f171t.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f171t;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f174w;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f171t;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // p110k.AbstractC1614r0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        this.f176y = z3 | this.f176y;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        this.f176y = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f171t;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f171t);
            }
            this.f171t = drawable;
            this.f176y = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f174w == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i3) {
        if (this.f174w != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.f174w = i3;
            if (i3 == 119 && this.f171t != null) {
                this.f171t.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f171t;
    }
}
