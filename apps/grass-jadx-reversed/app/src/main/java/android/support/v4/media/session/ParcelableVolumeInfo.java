package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import p024H0.C0247a;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new C0247a(28);

    /* JADX INFO: renamed from: e */
    public int f2561e;

    /* JADX INFO: renamed from: f */
    public int f2562f;

    /* JADX INFO: renamed from: g */
    public int f2563g;

    /* JADX INFO: renamed from: h */
    public int f2564h;

    /* JADX INFO: renamed from: i */
    public int f2565i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f2561e);
        parcel.writeInt(this.f2563g);
        parcel.writeInt(this.f2564h);
        parcel.writeInt(this.f2565i);
        parcel.writeInt(this.f2562f);
    }
}
