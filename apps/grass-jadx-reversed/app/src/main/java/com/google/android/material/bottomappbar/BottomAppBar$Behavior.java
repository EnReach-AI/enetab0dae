package com.google.android.material.bottomappbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import p005B.AbstractC0032g;
import p110k.ViewOnLayoutChangeListenerC1544M0;

/* JADX INFO: loaded from: classes.dex */
public class BottomAppBar$Behavior extends HideBottomViewOnScrollBehavior<Object> {
    public BottomAppBar$Behavior() {
        new ViewOnLayoutChangeListenerC1544M0(1, this);
        new Rect();
    }

    @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, p155w.AbstractC1979a
    /* JADX INFO: renamed from: g */
    public final boolean mo3123g(CoordinatorLayout coordinatorLayout, View view, int i3) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, p155w.AbstractC1979a
    /* JADX INFO: renamed from: o */
    public final boolean mo3129o(View view, int i3, int i4) {
        AbstractC0032g.m160r(view);
        throw null;
    }

    public BottomAppBar$Behavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new ViewOnLayoutChangeListenerC1544M0(1, this);
        new Rect();
    }
}
