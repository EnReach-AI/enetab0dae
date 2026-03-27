package p024H0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: H0.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0254h implements Parcelable {
    public static final Parcelable.Creator<C0254h> CREATOR = new C0247a(1);

    /* JADX INFO: renamed from: e */
    public String f625e;

    /* JADX INFO: renamed from: f */
    public String f626f;

    /* JADX INFO: renamed from: g */
    public String f627g;

    /* JADX INFO: renamed from: h */
    public long f628h;

    /* JADX INFO: renamed from: i */
    public long f629i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f625e);
        parcel.writeString(this.f626f);
        parcel.writeString(this.f627g);
        parcel.writeLong(this.f628h);
        parcel.writeLong(this.f629i);
    }
}
