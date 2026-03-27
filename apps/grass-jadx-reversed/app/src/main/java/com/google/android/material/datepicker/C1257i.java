package com.google.android.material.datepicker;

import android.text.format.DateUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import p073Z.AbstractC0763I;
import p073Z.AbstractC0766L;

/* JADX INFO: renamed from: com.google.android.material.datepicker.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1257i extends AbstractC0766L {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1265q f4362a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MaterialButton f4363b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C1258j f4364c;

    public C1257i(C1258j c1258j, C1265q c1265q, MaterialButton materialButton) {
        this.f4364c = c1258j;
        this.f4362a = c1265q;
        this.f4363b = materialButton;
    }

    @Override // p073Z.AbstractC0766L
    /* JADX INFO: renamed from: a */
    public final void mo2030a(RecyclerView recyclerView, int i3) {
        if (i3 == 0) {
            recyclerView.announceForAccessibility(this.f4363b.getText());
        }
    }

    @Override // p073Z.AbstractC0766L
    /* JADX INFO: renamed from: b */
    public final void mo2031b(RecyclerView recyclerView, int i3, int i4) {
        int iM2550F0;
        C1258j c1258j = this.f4364c;
        if (i3 < 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) c1258j.f4371d0.getLayoutManager();
            View viewM2552H0 = linearLayoutManager.m2552H0(0, linearLayoutManager.m2027v(), false);
            iM2550F0 = viewM2552H0 == null ? -1 : AbstractC0763I.m1958D(viewM2552H0);
        } else {
            iM2550F0 = ((LinearLayoutManager) c1258j.f4371d0.getLayoutManager()).m2550F0();
        }
        C1265q c1265q = this.f4362a;
        Calendar calendarM3189a = AbstractC1269u.m3189a(c1265q.f4415c.f4343e.f4399e);
        calendarM3189a.add(2, iM2550F0);
        c1258j.f4367Z = new C1261m(calendarM3189a);
        Calendar calendarM3189a2 = AbstractC1269u.m3189a(c1265q.f4415c.f4343e.f4399e);
        calendarM3189a2.add(2, iM2550F0);
        calendarM3189a2.set(5, 1);
        Calendar calendarM3189a3 = AbstractC1269u.m3189a(calendarM3189a2);
        calendarM3189a3.get(2);
        calendarM3189a3.get(1);
        calendarM3189a3.getMaximum(7);
        calendarM3189a3.getActualMaximum(5);
        calendarM3189a3.getTimeInMillis();
        this.f4363b.setText(DateUtils.formatDateTime(null, calendarM3189a3.getTimeInMillis(), 8228));
    }
}
