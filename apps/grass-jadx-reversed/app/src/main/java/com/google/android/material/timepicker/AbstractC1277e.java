package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p025H1.C0278g;
import p025H1.C0279h;
import p028I1.RunnableC0304d;
import p029J.AbstractC0307B;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p126o1.AbstractC1805a;
import p144t0.C1916b;

/* JADX INFO: renamed from: com.google.android.material.timepicker.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1277e extends ConstraintLayout {

    /* JADX INFO: renamed from: t */
    public final RunnableC0304d f4574t;

    /* JADX INFO: renamed from: u */
    public int f4575u;

    /* JADX INFO: renamed from: v */
    public final C0278g f4576v;

    public AbstractC1277e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        C0278g c0278g = new C0278g();
        this.f4576v = c0278g;
        C0279h c0279h = new C0279h(0.5f);
        C1916b c1916bM555e = c0278g.f719e.f697a.m555e();
        c1916bM555e.f6703e = c0279h;
        c1916bM555e.f6704f = c0279h;
        c1916bM555e.f6705g = c0279h;
        c1916bM555e.f6706h = c0279h;
        c0278g.setShapeAppearanceModel(c1916bM555e.m4266a());
        this.f4576v.m547k(ColorStateList.valueOf(-1));
        C0278g c0278g2 = this.f4576v;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m601q(this, c0278g2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1805a.f6243s, R.attr.materialClockStyle, 0);
        this.f4575u = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f4574t = new RunnableC0304d(7, this);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            view.setId(AbstractC0308C.m604a());
        }
        Handler handler = getHandler();
        if (handler != null) {
            RunnableC0304d runnableC0304d = this.f4574t;
            handler.removeCallbacks(runnableC0304d);
            handler.post(runnableC0304d);
        }
    }

    /* JADX INFO: renamed from: f */
    public abstract void mo3227f();

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        mo3227f();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            RunnableC0304d runnableC0304d = this.f4574t;
            handler.removeCallbacks(runnableC0304d);
            handler.post(runnableC0304d);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i3) {
        this.f4576v.m547k(ColorStateList.valueOf(i3));
    }
}
