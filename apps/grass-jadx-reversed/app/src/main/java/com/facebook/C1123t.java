package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.C0880a;
import java.util.HashSet;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: com.facebook.t */
/* JADX INFO: loaded from: classes.dex */
public final class C1123t implements Parcelable {
    public static final Parcelable.Creator<C1123t> CREATOR = new C0880a(9);

    /* JADX INFO: renamed from: e */
    public final String f3894e;

    /* JADX INFO: renamed from: f */
    public final Parcelable f3895f;

    public C1123t(Parcelable parcelable) {
        this.f3894e = "image/png";
        this.f3895f = parcelable;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f3894e);
        parcel.writeParcelable(this.f3895f, i3);
    }

    public C1123t(Parcel parcel) {
        this.f3894e = parcel.readString();
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        this.f3895f = parcel.readParcelable(AbstractC1117n.f3882h.getClassLoader());
    }
}
