package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: com.google.android.material.datepicker.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1260l<S> extends AbstractC1266r {

    /* JADX INFO: renamed from: X */
    public int f4397X;

    /* JADX INFO: renamed from: Y */
    public C1250b f4398Y;

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: q */
    public final void mo518q(Bundle bundle) {
        super.mo518q(bundle);
        if (bundle == null) {
            bundle = this.f3227j;
        }
        this.f4397X = bundle.getInt("THEME_RES_ID_KEY");
        AbstractC0032g.m158p(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f4398Y = (C1250b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: r */
    public final View mo500r(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(m2492j(), this.f4397X));
        throw null;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: y */
    public final void mo502y(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f4397X);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f4398Y);
    }
}
