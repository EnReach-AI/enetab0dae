package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p029J.AbstractC0323S;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1920f;
import p147u.C1931g;
import p147u.C1932h;
import p147u.C1936l;
import p165z.AbstractC2049e;

/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends AbstractC1277e implements InterfaceC1276d {

    /* JADX INFO: renamed from: A */
    public final SparseArray f4541A;

    /* JADX INFO: renamed from: B */
    public final C1275c f4542B;

    /* JADX INFO: renamed from: C */
    public final int[] f4543C;

    /* JADX INFO: renamed from: D */
    public final float[] f4544D;

    /* JADX INFO: renamed from: E */
    public final int f4545E;

    /* JADX INFO: renamed from: F */
    public final int f4546F;

    /* JADX INFO: renamed from: G */
    public final int f4547G;

    /* JADX INFO: renamed from: H */
    public final int f4548H;

    /* JADX INFO: renamed from: I */
    public final String[] f4549I;

    /* JADX INFO: renamed from: J */
    public float f4550J;

    /* JADX INFO: renamed from: K */
    public final ColorStateList f4551K;

    /* JADX INFO: renamed from: w */
    public final ClockHandView f4552w;

    /* JADX INFO: renamed from: x */
    public final Rect f4553x;

    /* JADX INFO: renamed from: y */
    public final RectF f4554y;

    /* JADX INFO: renamed from: z */
    public final Rect f4555z;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4553x = new Rect();
        this.f4554y = new RectF();
        this.f4555z = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.f4541A = sparseArray;
        this.f4544D = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1805a.f6227c, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListM4303d = AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 1);
        this.f4551K = colorStateListM4303d;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f4552w = clockHandView;
        this.f4545E = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListM4303d.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListM4303d.getDefaultColor());
        this.f4543C = new int[]{colorForState, colorForState, colorStateListM4303d.getDefaultColor()};
        clockHandView.f4558g.add(this);
        int defaultColor = AbstractC2049e.m4525c(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListM4303d2 = AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 0);
        setBackgroundColor(colorStateListM4303d2 != null ? colorStateListM4303d2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC1274b(this));
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f4542B = new C1275c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.f4549I = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < Math.max(this.f4549I.length, size); i3++) {
            TextView textView = (TextView) sparseArray.get(i3);
            if (i3 >= this.f4549I.length) {
                removeView(textView);
                sparseArray.remove(i3);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i3, textView);
                    addView(textView);
                }
                textView.setText(this.f4549I[i3]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i3));
                int i4 = (i3 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i4));
                z3 = i4 > 1 ? true : z3;
                AbstractC0323S.m701k(textView, this.f4542B);
                textView.setTextColor(this.f4551K);
            }
        }
        ClockHandView clockHandView2 = this.f4552w;
        if (clockHandView2.f4557f && !z3) {
            clockHandView2.f4568q = 1;
        }
        clockHandView2.f4557f = z3;
        clockHandView2.invalidate();
        this.f4546F = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.f4547G = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.f4548H = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.AbstractC1277e
    /* JADX INFO: renamed from: f */
    public final void mo3227f() {
        C1936l c1936l = new C1936l();
        c1936l.m4336b(this);
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i4 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i4 == null) {
                    i4 = 1;
                }
                if (!map.containsKey(i4)) {
                    map.put(i4, new ArrayList());
                }
                ((List) map.get(i4)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            int iRound = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.f4575u * 0.66f) : this.f4575u;
            Iterator it = list.iterator();
            float size = 0.0f;
            while (it.hasNext()) {
                int id = ((View) it.next()).getId();
                HashMap map2 = c1936l.f6923c;
                if (!map2.containsKey(Integer.valueOf(id))) {
                    map2.put(Integer.valueOf(id), new C1931g());
                }
                C1932h c1932h = ((C1931g) map2.get(Integer.valueOf(id))).f6832d;
                c1932h.f6893w = R.id.circle_center;
                c1932h.f6894x = iRound;
                c1932h.f6895y = size;
                size += 360.0f / list.size();
            }
        }
        c1936l.m4335a(this);
        setConstraintSet(null);
        requestLayout();
        int i5 = 0;
        while (true) {
            SparseArray sparseArray = this.f4541A;
            if (i5 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i5)).setVisibility(0);
            i5++;
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m3228g() {
        SparseArray sparseArray;
        RectF rectF;
        Rect rect;
        RectF rectF2 = this.f4552w.f4562k;
        float f3 = Float.MAX_VALUE;
        TextView textView = null;
        int i3 = 0;
        while (true) {
            sparseArray = this.f4541A;
            int size = sparseArray.size();
            rectF = this.f4554y;
            rect = this.f4553x;
            if (i3 >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i3);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float fHeight = rectF.height() * rectF.width();
                if (fHeight < f3) {
                    textView = textView2;
                    f3 = fHeight;
                }
            }
            i3++;
        }
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            TextView textView3 = (TextView) sparseArray.get(i4);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.f4555z);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.f4543C, this.f4544D, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.f4549I.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        m3228g();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.f4548H / Math.max(Math.max(this.f4546F / displayMetrics.heightPixels, this.f4547G / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
