package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p029J.AbstractC0323S;
import p126o1.AbstractC1805a;
import p134q1.AbstractC1839a;
import p137r0.AbstractC1852a;
import p155w.AbstractC1979a;
import p155w.C1982d;

/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout$ScrollingViewBehavior extends AbstractC1839a {

    /* JADX INFO: renamed from: c */
    public final int f4214c;

    public AppBarLayout$ScrollingViewBehavior() {
        new Rect();
        new Rect();
    }

    /* JADX INFO: renamed from: s */
    public static void m3132s(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
        }
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: b */
    public final void mo3133b(View view) {
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: d */
    public boolean mo3134d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        AbstractC1979a abstractC1979a = ((C1982d) view2.getLayoutParams()).f7026a;
        if (abstractC1979a instanceof AppBarLayout$BaseBehavior) {
            int bottom = view2.getBottom() - view.getTop();
            ((AppBarLayout$BaseBehavior) abstractC1979a).getClass();
            int i3 = this.f4214c;
            int iM4126a = bottom - (i3 == 0 ? 0 : AbstractC1852a.m4126a((int) (0.0f * i3), 0, i3));
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            view.offsetTopAndBottom(iM4126a);
        }
        return false;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: h */
    public final boolean mo3124h(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5) {
        int i6 = view.getLayoutParams().height;
        if (i6 != -1 && i6 != -2) {
            return false;
        }
        m3132s(coordinatorLayout.m2304j(view));
        return false;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: l */
    public final void mo3135l(CoordinatorLayout coordinatorLayout, View view) {
        m3132s(coordinatorLayout.m2304j(view));
    }

    @Override // p134q1.AbstractC1839a
    /* JADX INFO: renamed from: r */
    public final void mo3136r(CoordinatorLayout coordinatorLayout, View view, int i3) {
        m3132s(coordinatorLayout.m2304j(view));
        coordinatorLayout.m2309q(view, i3);
    }

    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        new Rect();
        new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1805a.f6244t);
        this.f4214c = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
