package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import p029J.AbstractC0323S;
import p041N.C0521i;

/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: e */
    public final boolean f4340e;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        AbstractC1269u.m3191c(null);
        if (C1259k.m3180U(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(io.getgrass.www.R.id.cancel_button);
            setNextFocusRightId(io.getgrass.www.R.id.confirm_button);
        }
        this.f4340e = C1259k.m3180U(getContext(), io.getgrass.www.R.attr.nestedScrollable);
        AbstractC0323S.m701k(this, new C0521i(3));
    }

    /* JADX INFO: renamed from: a */
    public final C1262n m3176a() {
        return (C1262n) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final Adapter getAdapter() {
        return (C1262n) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((C1262n) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        C1262n c1262n = (C1262n) super.getAdapter();
        c1262n.getClass();
        int iMax = Math.max(c1262n.m3186a(), getFirstVisiblePosition());
        int iMin = Math.min(c1262n.m3188c(), getLastVisiblePosition());
        c1262n.getItem(iMax);
        c1262n.getItem(iMin);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z3, int i3, Rect rect) {
        if (!z3) {
            super.onFocusChanged(false, i3, rect);
            return;
        }
        if (i3 == 33) {
            setSelection(((C1262n) super.getAdapter()).m3188c());
        } else if (i3 == 130) {
            setSelection(((C1262n) super.getAdapter()).m3186a());
        } else {
            super.onFocusChanged(true, i3, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (!super.onKeyDown(i3, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((C1262n) super.getAdapter()).m3186a()) {
            return true;
        }
        if (19 != i3) {
            return false;
        }
        setSelection(((C1262n) super.getAdapter()).m3186a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i3, int i4) {
        if (!this.f4340e) {
            super.onMeasure(i3, i4);
            return;
        }
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i3) {
        if (i3 < ((C1262n) super.getAdapter()).m3186a()) {
            super.setSelection(((C1262n) super.getAdapter()).m3186a());
        } else {
            super.setSelection(i3);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (C1262n) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof C1262n)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), C1262n.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
