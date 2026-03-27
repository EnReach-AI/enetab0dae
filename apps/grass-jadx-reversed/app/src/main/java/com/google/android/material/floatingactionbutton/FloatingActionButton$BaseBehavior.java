package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import p005B.AbstractC0032g;
import p126o1.AbstractC1805a;
import p155w.AbstractC1979a;
import p155w.C1982d;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton$BaseBehavior<T> extends AbstractC1979a {
    public FloatingActionButton$BaseBehavior() {
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: a */
    public final boolean mo3192a(View view) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: c */
    public final void mo3148c(C1982d c1982d) {
        if (c1982d.f7033h == 0) {
            c1982d.f7033h = 80;
        }
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: d */
    public final boolean mo3134d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: g */
    public final boolean mo3123g(CoordinatorLayout coordinatorLayout, View view, int i3) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    public FloatingActionButton$BaseBehavior(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1805a.f6230f);
        typedArrayObtainStyledAttributes.getBoolean(0, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
