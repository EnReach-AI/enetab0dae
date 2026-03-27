package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import androidx.activity.result.C0880a;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: renamed from: com.google.android.material.datepicker.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1261m implements Comparable, Parcelable {
    public static final Parcelable.Creator<C1261m> CREATOR = new C0880a(13);

    /* JADX INFO: renamed from: e */
    public final Calendar f4399e;

    /* JADX INFO: renamed from: f */
    public final int f4400f;

    /* JADX INFO: renamed from: g */
    public final int f4401g;

    /* JADX INFO: renamed from: h */
    public final int f4402h;

    /* JADX INFO: renamed from: i */
    public final int f4403i;

    /* JADX INFO: renamed from: j */
    public final long f4404j;

    /* JADX INFO: renamed from: k */
    public String f4405k;

    public C1261m(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarM3189a = AbstractC1269u.m3189a(calendar);
        this.f4399e = calendarM3189a;
        this.f4400f = calendarM3189a.get(2);
        this.f4401g = calendarM3189a.get(1);
        this.f4402h = calendarM3189a.getMaximum(7);
        this.f4403i = calendarM3189a.getActualMaximum(5);
        this.f4404j = calendarM3189a.getTimeInMillis();
    }

    /* JADX INFO: renamed from: a */
    public static C1261m m3182a(int i3, int i4) {
        Calendar calendarM3191c = AbstractC1269u.m3191c(null);
        calendarM3191c.set(1, i3);
        calendarM3191c.set(2, i4);
        return new C1261m(calendarM3191c);
    }

    /* JADX INFO: renamed from: b */
    public static C1261m m3183b(long j2) {
        Calendar calendarM3191c = AbstractC1269u.m3191c(null);
        calendarM3191c.setTimeInMillis(j2);
        return new C1261m(calendarM3191c);
    }

    /* JADX INFO: renamed from: c */
    public final String m3184c() {
        if (this.f4405k == null) {
            this.f4405k = DateUtils.formatDateTime(null, this.f4399e.getTimeInMillis(), 8228);
        }
        return this.f4405k;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f4399e.compareTo(((C1261m) obj).f4399e);
    }

    /* JADX INFO: renamed from: d */
    public final int m3185d(C1261m c1261m) {
        if (!(this.f4399e instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (c1261m.f4400f - this.f4400f) + ((c1261m.f4401g - this.f4401g) * 12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1261m)) {
            return false;
        }
        C1261m c1261m = (C1261m) obj;
        return this.f4400f == c1261m.f4400f && this.f4401g == c1261m.f4401g;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4400f), Integer.valueOf(this.f4401g)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f4401g);
        parcel.writeInt(this.f4400f);
    }
}
