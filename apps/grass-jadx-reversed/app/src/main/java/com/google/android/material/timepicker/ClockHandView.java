package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p125o0.AbstractC1794d;
import p126o1.AbstractC1805a;
import p130p1.AbstractC1824a;

/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: e */
    public final ValueAnimator f4556e;

    /* JADX INFO: renamed from: f */
    public boolean f4557f;

    /* JADX INFO: renamed from: g */
    public final ArrayList f4558g;

    /* JADX INFO: renamed from: h */
    public final int f4559h;

    /* JADX INFO: renamed from: i */
    public final float f4560i;

    /* JADX INFO: renamed from: j */
    public final Paint f4561j;

    /* JADX INFO: renamed from: k */
    public final RectF f4562k;

    /* JADX INFO: renamed from: l */
    public final int f4563l;

    /* JADX INFO: renamed from: m */
    public float f4564m;

    /* JADX INFO: renamed from: n */
    public boolean f4565n;

    /* JADX INFO: renamed from: o */
    public double f4566o;

    /* JADX INFO: renamed from: p */
    public int f4567p;

    /* JADX INFO: renamed from: q */
    public int f4568q;

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        this.f4556e = new ValueAnimator();
        this.f4558g = new ArrayList();
        Paint paint = new Paint();
        this.f4561j = paint;
        this.f4562k = new RectF();
        this.f4568q = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1805a.f6228d, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        AbstractC1794d.m3954l(context, R.attr.motionDurationLong2, 200);
        AbstractC1794d.m3955m(context, R.attr.motionEasingEmphasizedInterpolator, AbstractC1824a.f6321b);
        this.f4567p = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f4559h = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f4563l = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f4560i = r4.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        m3230b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m603s(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    public final int m3229a(int i3) {
        return i3 == 2 ? Math.round(this.f4567p * 0.66f) : this.f4567p;
    }

    /* JADX INFO: renamed from: b */
    public final void m3230b(float f3) {
        ValueAnimator valueAnimator = this.f4556e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        m3231c(f3);
    }

    /* JADX INFO: renamed from: c */
    public final void m3231c(float f3) {
        float f4 = f3 % 360.0f;
        this.f4564m = f4;
        this.f4566o = Math.toRadians(f4 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fM3229a = m3229a(this.f4568q);
        float fCos = (((float) Math.cos(this.f4566o)) * fM3229a) + width;
        float fSin = (fM3229a * ((float) Math.sin(this.f4566o))) + height;
        float f5 = this.f4559h;
        this.f4562k.set(fCos - f5, fSin - f5, fCos + f5, fSin + f5);
        Iterator it = this.f4558g.iterator();
        while (it.hasNext()) {
            ClockFaceView clockFaceView = (ClockFaceView) ((InterfaceC1276d) it.next());
            if (Math.abs(clockFaceView.f4550J - f4) > 0.001f) {
                clockFaceView.f4550J = f4;
                clockFaceView.m3228g();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f3 = width;
        float fM3229a = m3229a(this.f4568q);
        float fCos = (((float) Math.cos(this.f4566o)) * fM3229a) + f3;
        float f4 = height;
        float fSin = (fM3229a * ((float) Math.sin(this.f4566o))) + f4;
        Paint paint = this.f4561j;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f4559h, paint);
        double dSin = Math.sin(this.f4566o);
        paint.setStrokeWidth(this.f4563l);
        canvas.drawLine(f3, f4, width + ((int) (Math.cos(this.f4566o) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f3, f4, this.f4560i, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        if (this.f4556e.isRunning()) {
            return;
        }
        m3230b(this.f4564m);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        boolean z4;
        int actionMasked = motionEvent.getActionMasked();
        float x3 = motionEvent.getX();
        float y2 = motionEvent.getY();
        boolean z5 = false;
        if (actionMasked == 0) {
            this.f4565n = false;
            z3 = true;
            z4 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z4 = this.f4565n;
            if (this.f4557f) {
                this.f4568q = ((float) Math.hypot((double) (x3 - ((float) (getWidth() / 2))), (double) (y2 - ((float) (getHeight() / 2))))) <= ((float) m3229a(2)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 2 : 1;
            }
            z3 = false;
        } else {
            z4 = false;
            z3 = false;
        }
        boolean z6 = this.f4565n;
        int degrees = (int) Math.toDegrees(Math.atan2(y2 - (getHeight() / 2), x3 - (getWidth() / 2)));
        int i3 = degrees + 90;
        if (i3 < 0) {
            i3 = degrees + 450;
        }
        float f3 = i3;
        boolean z7 = this.f4564m != f3;
        if (z3 && z7) {
            z5 = true;
        } else if (z7 || z4) {
            m3230b(f3);
            z5 = true;
        }
        this.f4565n = z6 | z5;
        return true;
    }
}
