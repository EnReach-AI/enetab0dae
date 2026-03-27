package p036L0;

import android.os.Parcel;
import android.os.Parcelable;
import p024H0.C0247a;

/* JADX INFO: renamed from: L0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0442b implements Parcelable {
    public static final Parcelable.Creator<C0442b> CREATOR = new C0247a(11);

    /* JADX INFO: renamed from: e */
    public final String f1080e;

    public C0442b(C0444d c0444d) {
        this.f1080e = (String) c0444d.f1085e;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f1080e);
    }

    public C0442b(Parcel parcel) {
        this.f1080e = parcel.readString();
    }
}
