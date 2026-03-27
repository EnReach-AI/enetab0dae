package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.C0880a;
import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.material.datepicker.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1252d implements Parcelable {
    public static final Parcelable.Creator<C1252d> CREATOR = new C0880a(12);

    /* JADX INFO: renamed from: e */
    public final long f4352e;

    public C1252d(long j2) {
        this.f4352e = j2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1252d) && this.f4352e == ((C1252d) obj).f4352e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f4352e)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f4352e);
    }
}
