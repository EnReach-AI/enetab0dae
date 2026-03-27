package p073Z;

import android.os.Parcel;
import android.os.Parcelable;
import p024H0.C0247a;

/* JADX INFO: renamed from: Z.t */
/* JADX INFO: loaded from: classes.dex */
public final class C0808t implements Parcelable {
    public static final Parcelable.Creator<C0808t> CREATOR = new C0247a(18);

    /* JADX INFO: renamed from: e */
    public int f2389e;

    /* JADX INFO: renamed from: f */
    public int f2390f;

    /* JADX INFO: renamed from: g */
    public boolean f2391g;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f2389e);
        parcel.writeInt(this.f2390f);
        parcel.writeInt(this.f2391g ? 1 : 0);
    }
}
