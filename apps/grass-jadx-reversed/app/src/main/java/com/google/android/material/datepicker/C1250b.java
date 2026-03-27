package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.C0880a;
import java.util.Arrays;
import java.util.Objects;
import p026I.AbstractC0294b;

/* JADX INFO: renamed from: com.google.android.material.datepicker.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1250b implements Parcelable {
    public static final Parcelable.Creator<C1250b> CREATOR = new C0880a(11);

    /* JADX INFO: renamed from: e */
    public final C1261m f4343e;

    /* JADX INFO: renamed from: f */
    public final C1261m f4344f;

    /* JADX INFO: renamed from: g */
    public final C1252d f4345g;

    /* JADX INFO: renamed from: h */
    public final C1261m f4346h;

    /* JADX INFO: renamed from: i */
    public final int f4347i;

    /* JADX INFO: renamed from: j */
    public final int f4348j;

    /* JADX INFO: renamed from: k */
    public final int f4349k;

    public C1250b(C1261m c1261m, C1261m c1261m2, C1252d c1252d, C1261m c1261m3, int i3) {
        Objects.requireNonNull(c1261m, "start cannot be null");
        Objects.requireNonNull(c1261m2, "end cannot be null");
        Objects.requireNonNull(c1252d, "validator cannot be null");
        this.f4343e = c1261m;
        this.f4344f = c1261m2;
        this.f4346h = c1261m3;
        this.f4347i = i3;
        this.f4345g = c1252d;
        if (c1261m3 != null && c1261m.f4399e.compareTo(c1261m3.f4399e) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (c1261m3 != null && c1261m3.f4399e.compareTo(c1261m2.f4399e) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i3 < 0 || i3 > AbstractC1269u.m3191c(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f4349k = c1261m.m3185d(c1261m2) + 1;
        this.f4348j = (c1261m2.f4401g - c1261m.f4401g) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1250b)) {
            return false;
        }
        C1250b c1250b = (C1250b) obj;
        return this.f4343e.equals(c1250b.f4343e) && this.f4344f.equals(c1250b.f4344f) && AbstractC0294b.m569a(this.f4346h, c1250b.f4346h) && this.f4347i == c1250b.f4347i && this.f4345g.equals(c1250b.f4345g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4343e, this.f4344f, this.f4346h, Integer.valueOf(this.f4347i), this.f4345g});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f4343e, 0);
        parcel.writeParcelable(this.f4344f, 0);
        parcel.writeParcelable(this.f4346h, 0);
        parcel.writeParcelable(this.f4345g, 0);
        parcel.writeInt(this.f4347i);
    }
}
