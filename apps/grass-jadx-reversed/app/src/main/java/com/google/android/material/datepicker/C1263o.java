package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: renamed from: com.google.android.material.datepicker.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1263o implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ MaterialCalendarGridView f4411e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1265q f4412f;

    public C1263o(C1265q c1265q, MaterialCalendarGridView materialCalendarGridView) {
        this.f4412f = c1265q;
        this.f4411e = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
        MaterialCalendarGridView materialCalendarGridView = this.f4411e;
        C1262n c1262nM3176a = materialCalendarGridView.m3176a();
        if (i3 < c1262nM3176a.m3186a() || i3 > c1262nM3176a.m3188c()) {
            return;
        }
        if (materialCalendarGridView.m3176a().getItem(i3).longValue() >= ((C1258j) this.f4412f.f4416d.f1085e).f4366Y.f4345g.f4352e) {
            throw null;
        }
    }
}
