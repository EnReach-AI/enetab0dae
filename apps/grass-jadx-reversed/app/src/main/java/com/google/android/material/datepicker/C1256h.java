package com.google.android.material.datepicker;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import p073Z.AbstractC0761G;

/* JADX INFO: renamed from: com.google.android.material.datepicker.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1256h extends AbstractC0761G {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1258j f4361a;

    public C1256h(C1258j c1258j) {
        this.f4361a = c1258j;
        AbstractC1269u.m3191c(null);
        AbstractC1269u.m3191c(null);
    }

    @Override // p073Z.AbstractC0761G
    /* JADX INFO: renamed from: a */
    public final void mo1956a(RecyclerView recyclerView) {
        if ((recyclerView.getAdapter() instanceof C1271w) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            this.f4361a.getClass();
            throw null;
        }
    }
}
