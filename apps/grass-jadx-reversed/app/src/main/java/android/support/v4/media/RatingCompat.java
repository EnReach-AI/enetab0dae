package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import p024H0.C0247a;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new C0247a(24);

    /* JADX INFO: renamed from: e */
    public final int f2555e;

    /* JADX INFO: renamed from: f */
    public final float f2556f;

    public RatingCompat(int i3, float f3) {
        this.f2555e = i3;
        this.f2556f = f3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f2555e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f2555e);
        sb.append(" rating=");
        float f3 = this.f2556f;
        sb.append(f3 < 0.0f ? "unrated" : String.valueOf(f3));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f2555e);
        parcel.writeFloat(this.f2556f);
    }
}
