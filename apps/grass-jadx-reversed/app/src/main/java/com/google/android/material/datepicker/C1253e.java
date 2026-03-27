package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import io.getgrass.www.R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.material.datepicker.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1253e extends BaseAdapter {

    /* JADX INFO: renamed from: e */
    public final Calendar f4353e;

    /* JADX INFO: renamed from: f */
    public final int f4354f;

    /* JADX INFO: renamed from: g */
    public final int f4355g;

    public C1253e() {
        Calendar calendarM3191c = AbstractC1269u.m3191c(null);
        this.f4353e = calendarM3191c;
        this.f4354f = calendarM3191c.getMaximum(7);
        this.f4355g = calendarM3191c.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f4354f;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i3) {
        int i4 = this.f4354f;
        if (i3 >= i4) {
            return null;
        }
        int i5 = i3 + this.f4355g;
        if (i5 > i4) {
            i5 -= i4;
        }
        return Integer.valueOf(i5);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i4 = i3 + this.f4355g;
        int i5 = this.f4354f;
        if (i4 > i5) {
            i4 -= i5;
        }
        Calendar calendar = this.f4353e;
        calendar.set(7, i4);
        textView.setText(calendar.getDisplayName(7, 4, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public C1253e(int i3) {
        Calendar calendarM3191c = AbstractC1269u.m3191c(null);
        this.f4353e = calendarM3191c;
        this.f4354f = calendarM3191c.getMaximum(7);
        this.f4355g = i3;
    }
}
