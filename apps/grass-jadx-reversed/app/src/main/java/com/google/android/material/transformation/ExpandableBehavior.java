package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p005B.AbstractC0032g;
import p029J.AbstractC0310E;
import p029J.AbstractC0323S;
import p155w.AbstractC1979a;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends AbstractC1979a {
    public ExpandableBehavior() {
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: b */
    public abstract void mo3133b(View view);

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: d */
    public final boolean mo3134d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        AbstractC0032g.m162t(view2);
        throw null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: g */
    public final boolean mo3123g(CoordinatorLayout coordinatorLayout, View view, int i3) {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (!AbstractC0310E.m620c(view)) {
            ArrayList arrayListM2304j = coordinatorLayout.m2304j(view);
            int size = arrayListM2304j.size();
            for (int i4 = 0; i4 < size; i4++) {
                mo3133b(view);
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
