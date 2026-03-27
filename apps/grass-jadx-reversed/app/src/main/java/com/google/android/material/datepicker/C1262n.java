package com.google.android.material.datepicker;

import android.widget.BaseAdapter;
import java.util.Calendar;

/* JADX INFO: renamed from: com.google.android.material.datepicker.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1262n extends BaseAdapter {

    /* JADX INFO: renamed from: h */
    public static final int f4406h = AbstractC1269u.m3191c(null).getMaximum(4);

    /* JADX INFO: renamed from: i */
    public static final int f4407i = (AbstractC1269u.m3191c(null).getMaximum(7) + AbstractC1269u.m3191c(null).getMaximum(5)) - 1;

    /* JADX INFO: renamed from: e */
    public final C1261m f4408e;

    /* JADX INFO: renamed from: f */
    public C1251c f4409f;

    /* JADX INFO: renamed from: g */
    public final C1250b f4410g;

    public C1262n(C1261m c1261m, C1250b c1250b) {
        this.f4408e = c1261m;
        this.f4410g = c1250b;
        throw null;
    }

    /* JADX INFO: renamed from: a */
    public final int m3186a() {
        int firstDayOfWeek = this.f4410g.f4347i;
        C1261m c1261m = this.f4408e;
        Calendar calendar = c1261m.f4399e;
        int i3 = calendar.get(7);
        if (firstDayOfWeek <= 0) {
            firstDayOfWeek = calendar.getFirstDayOfWeek();
        }
        int i4 = i3 - firstDayOfWeek;
        return i4 < 0 ? i4 + c1261m.f4402h : i4;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i3) {
        if (i3 < m3186a() || i3 > m3188c()) {
            return null;
        }
        int iM3186a = (i3 - m3186a()) + 1;
        Calendar calendarM3189a = AbstractC1269u.m3189a(this.f4408e.f4399e);
        calendarM3189a.set(5, iM3186a);
        return Long.valueOf(calendarM3189a.getTimeInMillis());
    }

    /* JADX INFO: renamed from: c */
    public final int m3188c() {
        return (m3186a() + this.f4408e.f4403i) - 1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f4407i;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        return i3 / this.f4408e.f4402h;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            r4 = this;
            android.content.Context r0 = r7.getContext()
            com.google.android.material.datepicker.c r1 = r4.f4409f
            if (r1 != 0) goto Lf
            com.google.android.material.datepicker.c r1 = new com.google.android.material.datepicker.c
            r1.<init>(r0)
            r4.f4409f = r1
        Lf:
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r6 != 0) goto L27
            android.content.Context r6 = r7.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            r0 = 2131427412(0x7f0b0054, float:1.847644E38)
            android.view.View r6 = r6.inflate(r0, r7, r1)
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
        L27:
            int r6 = r4.m3186a()
            int r6 = r5 - r6
            if (r6 < 0) goto L5d
            com.google.android.material.datepicker.m r7 = r4.f4408e
            int r2 = r7.f4403i
            if (r6 < r2) goto L36
            goto L5d
        L36:
            r2 = 1
            int r6 = r6 + r2
            r0.setTag(r7)
            android.content.res.Resources r7 = r0.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            java.util.Locale r7 = r7.locale
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r3 = "%d"
            java.lang.String r6 = java.lang.String.format(r7, r3, r6)
            r0.setText(r6)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L65
        L5d:
            r6 = 8
            r0.setVisibility(r6)
            r0.setEnabled(r1)
        L65:
            java.lang.Long r5 = r4.getItem(r5)
            if (r5 != 0) goto L6c
            goto L6e
        L6c:
            if (r0 != 0) goto L6f
        L6e:
            return r0
        L6f:
            r0.getContext()
            java.util.Calendar r5 = com.google.android.material.datepicker.AbstractC1269u.m3190b()
            r5.getTimeInMillis()
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.C1262n.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
