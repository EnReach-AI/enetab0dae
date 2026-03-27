package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.material.timepicker.C1278f;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import p007B1.AbstractC0054n;
import p007B1.C0041a;
import p019F0.C0221e;
import p025H1.C0272a;
import p025H1.C0281j;
import p029J.AbstractC0307B;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p029J.AbstractC0353l;
import p040M1.AbstractC0512a;
import p126o1.AbstractC1805a;
import p144t0.C1916b;
import p149u1.C1950d;
import p149u1.C1951e;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: o */
    public static final /* synthetic */ int f4308o = 0;

    /* JADX INFO: renamed from: e */
    public final ArrayList f4309e;

    /* JADX INFO: renamed from: f */
    public final C0221e f4310f;

    /* JADX INFO: renamed from: g */
    public final LinkedHashSet f4311g;

    /* JADX INFO: renamed from: h */
    public final C1950d f4312h;

    /* JADX INFO: renamed from: i */
    public Integer[] f4313i;

    /* JADX INFO: renamed from: j */
    public boolean f4314j;

    /* JADX INFO: renamed from: k */
    public boolean f4315k;

    /* JADX INFO: renamed from: l */
    public boolean f4316l;

    /* JADX INFO: renamed from: m */
    public final int f4317m;

    /* JADX INFO: renamed from: n */
    public HashSet f4318n;

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(AbstractC0512a.m1020a(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.f4309e = new ArrayList();
        this.f4310f = new C0221e(22, this);
        this.f4311g = new LinkedHashSet();
        this.f4312h = new C1950d(this);
        this.f4314j = false;
        this.f4318n = new HashSet();
        TypedArray typedArrayM216f = AbstractC0054n.m216f(getContext(), attributeSet, AbstractC1805a.f6234j, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        setSingleSelection(typedArrayM216f.getBoolean(3, false));
        this.f4317m = typedArrayM216f.getResourceId(1, -1);
        this.f4316l = typedArrayM216f.getBoolean(2, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayM216f.getBoolean(0, true));
        typedArrayM216f.recycle();
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m603s(this, 1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (m3165c(i3)) {
                return i3;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (m3165c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if ((getChildAt(i4) instanceof MaterialButton) && m3165c(i4)) {
                i3++;
            }
        }
        return i3;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            materialButton.setId(AbstractC0308C.m604a());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f4310f);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    /* JADX INFO: renamed from: a */
    public final void m3163a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i3 = firstVisibleChildIndex + 1; i3 < getChildCount(); i3++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i3);
            int iMin = Math.min(materialButton.getStrokeWidth(), ((MaterialButton) getChildAt(i3 - 1)).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                AbstractC0353l.m775g(layoutParams2, 0);
                AbstractC0353l.m776h(layoutParams2, -iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -iMin;
                AbstractC0353l.m776h(layoutParams2, 0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            AbstractC0353l.m775g(layoutParams3, 0);
            AbstractC0353l.m776h(layoutParams3, 0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i3, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        m3164b(materialButton.getId(), materialButton.f4305r);
        C0281j shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f4309e.add(new C1951e(shapeAppearanceModel.f746e, shapeAppearanceModel.f749h, shapeAppearanceModel.f747f, shapeAppearanceModel.f748g));
        materialButton.setEnabled(isEnabled());
        AbstractC0323S.m701k(materialButton, new C0041a(3, this));
    }

    /* JADX INFO: renamed from: b */
    public final void m3164b(int i3, boolean z3) {
        if (i3 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i3);
            return;
        }
        HashSet hashSet = new HashSet(this.f4318n);
        if (z3 && !hashSet.contains(Integer.valueOf(i3))) {
            if (this.f4315k && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i3));
        } else {
            if (z3 || !hashSet.contains(Integer.valueOf(i3))) {
                return;
            }
            if (!this.f4316l || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i3));
            }
        }
        m3166d(hashSet);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m3165c(int i3) {
        return getChildAt(i3).getVisibility() != 8;
    }

    /* JADX INFO: renamed from: d */
    public final void m3166d(Set set) {
        HashSet hashSet = this.f4318n;
        this.f4318n = new HashSet(set);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            int id = ((MaterialButton) getChildAt(i3)).getId();
            boolean zContains = set.contains(Integer.valueOf(id));
            View viewFindViewById = findViewById(id);
            if (viewFindViewById instanceof MaterialButton) {
                this.f4314j = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.f4314j = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.f4311g.iterator();
                while (it.hasNext()) {
                    ((C1278f) it.next()).m3232a();
                }
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f4312h);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            treeMap.put((MaterialButton) getChildAt(i3), Integer.valueOf(i3));
        }
        this.f4313i = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: renamed from: e */
    public final void m3167e() {
        C1951e c1951e;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i3 = 0; i3 < childCount; i3++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i3);
            if (materialButton.getVisibility() != 8) {
                C1916b c1916bM555e = materialButton.getShapeAppearanceModel().m555e();
                C1951e c1951e2 = (C1951e) this.f4309e.get(i3);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z3 = getOrientation() == 0;
                    C0272a c0272a = C1951e.f6965e;
                    if (i3 == firstVisibleChildIndex) {
                        c1951e = z3 ? AbstractC0054n.m215e(this) ? new C1951e(c0272a, c0272a, c1951e2.f6967b, c1951e2.f6968c) : new C1951e(c1951e2.f6966a, c1951e2.f6969d, c0272a, c0272a) : new C1951e(c1951e2.f6966a, c0272a, c1951e2.f6967b, c0272a);
                    } else if (i3 == lastVisibleChildIndex) {
                        c1951e = z3 ? AbstractC0054n.m215e(this) ? new C1951e(c1951e2.f6966a, c1951e2.f6969d, c0272a, c0272a) : new C1951e(c0272a, c0272a, c1951e2.f6967b, c1951e2.f6968c) : new C1951e(c0272a, c1951e2.f6969d, c0272a, c1951e2.f6968c);
                    } else {
                        c1951e2 = null;
                    }
                    c1951e2 = c1951e;
                }
                if (c1951e2 == null) {
                    c1916bM555e.f6703e = new C0272a(0.0f);
                    c1916bM555e.f6704f = new C0272a(0.0f);
                    c1916bM555e.f6705g = new C0272a(0.0f);
                    c1916bM555e.f6706h = new C0272a(0.0f);
                } else {
                    c1916bM555e.f6703e = c1951e2.f6966a;
                    c1916bM555e.f6706h = c1951e2.f6969d;
                    c1916bM555e.f6704f = c1951e2.f6967b;
                    c1916bM555e.f6705g = c1951e2.f6968c;
                }
                materialButton.setShapeAppearanceModel(c1916bM555e.m4266a());
            }
        }
    }

    public int getCheckedButtonId() {
        if (!this.f4315k || this.f4318n.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f4318n.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            int id = ((MaterialButton) getChildAt(i3)).getId();
            if (this.f4318n.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i3, int i4) {
        Integer[] numArr = this.f4313i;
        if (numArr != null && i4 < numArr.length) {
            return numArr[i4].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i4;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.f4317m;
        if (i3 != -1) {
            m3166d(Collections.singleton(Integer.valueOf(i3)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getVisibleButtonCount(), false, this.f4315k ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        m3167e();
        m3163a();
        super.onMeasure(i3, i4);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f4309e.remove(iIndexOfChild);
        }
        m3167e();
        m3163a();
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            ((MaterialButton) getChildAt(i3)).setEnabled(z3);
        }
    }

    public void setSelectionRequired(boolean z3) {
        this.f4316l = z3;
    }

    public void setSingleSelection(boolean z3) {
        if (this.f4315k != z3) {
            this.f4315k = z3;
            m3166d(new HashSet());
        }
    }

    public void setSingleSelection(int i3) {
        setSingleSelection(getResources().getBoolean(i3));
    }
}
