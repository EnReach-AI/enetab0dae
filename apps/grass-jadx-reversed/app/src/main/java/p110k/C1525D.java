package p110k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import io.getgrass.www.R;
import p009C.AbstractC0139b;
import p009C.AbstractC0140c;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p094f.AbstractC1343a;
import p166z0.C2071i;

/* JADX INFO: renamed from: k.D */
/* JADX INFO: loaded from: classes.dex */
public final class C1525D extends C1627y {

    /* JADX INFO: renamed from: e */
    public final SeekBar f5473e;

    /* JADX INFO: renamed from: f */
    public Drawable f5474f;

    /* JADX INFO: renamed from: g */
    public ColorStateList f5475g;

    /* JADX INFO: renamed from: h */
    public PorterDuff.Mode f5476h;

    /* JADX INFO: renamed from: i */
    public boolean f5477i;

    /* JADX INFO: renamed from: j */
    public boolean f5478j;

    public C1525D(SeekBar seekBar) {
        super(seekBar);
        this.f5475g = null;
        this.f5476h = null;
        this.f5477i = false;
        this.f5478j = false;
        this.f5473e = seekBar;
    }

    @Override // p110k.C1627y
    /* JADX INFO: renamed from: d */
    public final void mo3569d(AttributeSet attributeSet, int i3) {
        super.mo3569d(attributeSet, R.attr.seekBarStyle);
        SeekBar seekBar = this.f5473e;
        Context context = seekBar.getContext();
        int[] iArr = AbstractC1343a.f4783g;
        C2071i c2071iM4591v = C2071i.m4591v(context, attributeSet, iArr, R.attr.seekBarStyle, 0);
        AbstractC0323S.m700j(seekBar, seekBar.getContext(), iArr, attributeSet, (TypedArray) c2071iM4591v.f7315b, R.attr.seekBarStyle);
        Drawable drawableM4602m = c2071iM4591v.m4602m(0);
        if (drawableM4602m != null) {
            seekBar.setThumb(drawableM4602m);
        }
        Drawable drawableM4601l = c2071iM4591v.m4601l(1);
        Drawable drawable = this.f5474f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f5474f = drawableM4601l;
        if (drawableM4601l != null) {
            drawableM4601l.setCallback(seekBar);
            AbstractC0140c.m283b(drawableM4601l, AbstractC0308C.m607d(seekBar));
            if (drawableM4601l.isStateful()) {
                drawableM4601l.setState(seekBar.getDrawableState());
            }
            m3570h();
        }
        seekBar.invalidate();
        TypedArray typedArray = (TypedArray) c2071iM4591v.f7315b;
        if (typedArray.hasValue(3)) {
            this.f5476h = AbstractC1589g0.m3652b(typedArray.getInt(3, -1), this.f5476h);
            this.f5478j = true;
        }
        if (typedArray.hasValue(2)) {
            this.f5475g = c2071iM4591v.m4600j(2);
            this.f5477i = true;
        }
        c2071iM4591v.m4608x();
        m3570h();
    }

    /* JADX INFO: renamed from: h */
    public final void m3570h() {
        Drawable drawable = this.f5474f;
        if (drawable != null) {
            if (this.f5477i || this.f5478j) {
                Drawable drawableMutate = drawable.mutate();
                this.f5474f = drawableMutate;
                if (this.f5477i) {
                    AbstractC0139b.m280h(drawableMutate, this.f5475g);
                }
                if (this.f5478j) {
                    AbstractC0139b.m281i(this.f5474f, this.f5476h);
                }
                if (this.f5474f.isStateful()) {
                    this.f5474f.setState(this.f5473e.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m3571i(Canvas canvas) {
        if (this.f5474f != null) {
            int max = this.f5473e.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f5474f.getIntrinsicWidth();
                int intrinsicHeight = this.f5474f.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i4 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f5474f.setBounds(-i3, -i4, i3, i4);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i5 = 0; i5 <= max; i5++) {
                    this.f5474f.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
