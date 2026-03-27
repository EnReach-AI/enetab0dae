package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import io.getgrass.www.R;
import java.util.Calendar;
import p036L0.C0444d;
import p073Z.AbstractC0756B;
import p073Z.AbstractC0777X;
import p073Z.C0764J;

/* JADX INFO: renamed from: com.google.android.material.datepicker.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1265q extends AbstractC0756B {

    /* JADX INFO: renamed from: c */
    public final C1250b f4415c;

    /* JADX INFO: renamed from: d */
    public final C0444d f4416d;

    /* JADX INFO: renamed from: e */
    public final int f4417e;

    public C1265q(ContextThemeWrapper contextThemeWrapper, C1250b c1250b, C0444d c0444d) {
        C1261m c1261m = c1250b.f4343e;
        C1261m c1261m2 = c1250b.f4346h;
        if (c1261m.f4399e.compareTo(c1261m2.f4399e) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (c1261m2.f4399e.compareTo(c1250b.f4344f.f4399e) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f4417e = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * C1262n.f4406h) + (C1259k.m3180U(contextThemeWrapper, android.R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.f4415c = c1250b;
        this.f4416d = c0444d;
        if (this.f2127a.m1948a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.f2128b = true;
    }

    @Override // p073Z.AbstractC0756B
    /* JADX INFO: renamed from: a */
    public final int mo1944a() {
        return this.f4415c.f4349k;
    }

    @Override // p073Z.AbstractC0756B
    /* JADX INFO: renamed from: b */
    public final long mo1945b(int i3) {
        Calendar calendarM3189a = AbstractC1269u.m3189a(this.f4415c.f4343e.f4399e);
        calendarM3189a.add(2, i3);
        return new C1261m(calendarM3189a).f4399e.getTimeInMillis();
    }

    @Override // p073Z.AbstractC0756B
    /* JADX INFO: renamed from: c */
    public final void mo1946c(AbstractC0777X abstractC0777X, int i3) {
        C1264p c1264p = (C1264p) abstractC0777X;
        C1250b c1250b = this.f4415c;
        Calendar calendarM3189a = AbstractC1269u.m3189a(c1250b.f4343e.f4399e);
        calendarM3189a.add(2, i3);
        C1261m c1261m = new C1261m(calendarM3189a);
        c1264p.f4413t.setText(c1261m.m3184c());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) c1264p.f4414u.findViewById(R.id.month_grid);
        if (materialCalendarGridView.m3176a() == null || !c1261m.equals(materialCalendarGridView.m3176a().f4408e)) {
            new C1262n(c1261m, c1250b);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.m3176a().getClass();
        throw null;
    }

    @Override // p073Z.AbstractC0756B
    /* JADX INFO: renamed from: d */
    public final AbstractC0777X mo1947d(ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!C1259k.m3180U(viewGroup.getContext(), android.R.attr.windowFullscreen)) {
            return new C1264p(linearLayout, false);
        }
        linearLayout.setLayoutParams(new C0764J(-1, this.f4417e));
        return new C1264p(linearLayout, true);
    }
}
