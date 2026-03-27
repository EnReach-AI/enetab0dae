package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import p073Z.C0774U;

/* JADX INFO: renamed from: com.google.android.material.datepicker.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1255g extends LinearLayoutManager {

    /* JADX INFO: renamed from: E */
    public final /* synthetic */ int f4359E;

    /* JADX INFO: renamed from: F */
    public final /* synthetic */ C1258j f4360F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1255g(C1258j c1258j, int i3, int i4) {
        super(i3);
        this.f4360F = c1258j;
        this.f4359E = i4;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p073Z.AbstractC0763I
    /* JADX INFO: renamed from: s0 */
    public final void mo2022s0(RecyclerView recyclerView, int i3) {
        C1267s c1267s = new C1267s(recyclerView.getContext());
        c1267s.f2392a = i3;
        m2024t0(c1267s);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /* JADX INFO: renamed from: v0 */
    public final void mo2566v0(C0774U c0774u, int[] iArr) {
        int i3 = this.f4359E;
        C1258j c1258j = this.f4360F;
        if (i3 == 0) {
            iArr[0] = c1258j.f4371d0.getWidth();
            iArr[1] = c1258j.f4371d0.getWidth();
        } else {
            iArr[0] = c1258j.f4371d0.getHeight();
            iArr[1] = c1258j.f4371d0.getHeight();
        }
    }
}
