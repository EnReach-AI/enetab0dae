package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.google.android.material.datepicker.u */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1269u {

    /* JADX INFO: renamed from: a */
    public static final AtomicReference f4419a = new AtomicReference();

    /* JADX INFO: renamed from: a */
    public static Calendar m3189a(Calendar calendar) {
        Calendar calendarM3191c = m3191c(calendar);
        Calendar calendarM3191c2 = m3191c(null);
        calendarM3191c2.set(calendarM3191c.get(1), calendarM3191c.get(2), calendarM3191c.get(5));
        return calendarM3191c2;
    }

    /* JADX INFO: renamed from: b */
    public static Calendar m3190b() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        return calendar;
    }

    /* JADX INFO: renamed from: c */
    public static Calendar m3191c(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }
}
