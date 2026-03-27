package p033K0;

import android.os.Parcel;
import android.os.Parcelable;
import p024H0.C0247a;

/* JADX INFO: renamed from: K0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0403a implements Parcelable {
    public static final Parcelable.Creator<C0403a> CREATOR = new C0247a(10);

    /* JADX INFO: renamed from: e */
    public String f924e;

    /* JADX INFO: renamed from: f */
    public long f925f;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f924e);
        parcel.writeLong(this.f925f);
    }
}
