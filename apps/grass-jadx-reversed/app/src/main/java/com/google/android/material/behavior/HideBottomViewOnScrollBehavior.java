package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import io.getgrass.www.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p005B.AbstractC0032g;
import p034K1.C0424k;
import p125o0.AbstractC1794d;
import p130p1.AbstractC1824a;
import p155w.AbstractC1979a;

/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends AbstractC1979a {

    /* JADX INFO: renamed from: b */
    public int f4222b;

    /* JADX INFO: renamed from: c */
    public int f4223c;

    /* JADX INFO: renamed from: d */
    public TimeInterpolator f4224d;

    /* JADX INFO: renamed from: e */
    public TimeInterpolator f4225e;

    /* JADX INFO: renamed from: h */
    public ViewPropertyAnimator f4228h;

    /* JADX INFO: renamed from: a */
    public final LinkedHashSet f4221a = new LinkedHashSet();

    /* JADX INFO: renamed from: f */
    public int f4226f = 0;

    /* JADX INFO: renamed from: g */
    public int f4227g = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: g */
    public boolean mo3123g(CoordinatorLayout coordinatorLayout, View view, int i3) {
        this.f4226f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f4222b = AbstractC1794d.m3954l(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f4223c = AbstractC1794d.m3954l(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.f4224d = AbstractC1794d.m3955m(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC1824a.f6323d);
        this.f4225e = AbstractC1794d.m3955m(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC1824a.f6322c);
        return false;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: k */
    public final void mo3126k(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int[] iArr) {
        LinkedHashSet linkedHashSet = this.f4221a;
        if (i3 > 0) {
            if (this.f4227g == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.f4228h;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f4227g = 1;
            Iterator it = linkedHashSet.iterator();
            if (it.hasNext()) {
                AbstractC0032g.m162t(it.next());
                throw null;
            }
            this.f4228h = view.animate().translationY(this.f4226f).setInterpolator(this.f4225e).setDuration(this.f4223c).setListener(new C0424k(4, this));
            return;
        }
        if (i3 >= 0 || this.f4227g == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.f4228h;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            view.clearAnimation();
        }
        this.f4227g = 2;
        Iterator it2 = linkedHashSet.iterator();
        if (it2.hasNext()) {
            AbstractC0032g.m162t(it2.next());
            throw null;
        }
        this.f4228h = view.animate().translationY(0).setInterpolator(this.f4224d).setDuration(this.f4222b).setListener(new C0424k(4, this));
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: o */
    public boolean mo3129o(View view, int i3, int i4) {
        return i3 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
