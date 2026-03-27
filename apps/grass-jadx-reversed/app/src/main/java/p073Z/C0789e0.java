package p073Z;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import p024H0.C0247a;

/* JADX INFO: renamed from: Z.e0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0789e0 implements Parcelable {
    public static final Parcelable.Creator<C0789e0> CREATOR = new C0247a(20);

    /* JADX INFO: renamed from: e */
    public int f2258e;

    /* JADX INFO: renamed from: f */
    public int f2259f;

    /* JADX INFO: renamed from: g */
    public int f2260g;

    /* JADX INFO: renamed from: h */
    public int[] f2261h;

    /* JADX INFO: renamed from: i */
    public int f2262i;

    /* JADX INFO: renamed from: j */
    public int[] f2263j;

    /* JADX INFO: renamed from: k */
    public List f2264k;

    /* JADX INFO: renamed from: l */
    public boolean f2265l;

    /* JADX INFO: renamed from: m */
    public boolean f2266m;

    /* JADX INFO: renamed from: n */
    public boolean f2267n;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f2258e);
        parcel.writeInt(this.f2259f);
        parcel.writeInt(this.f2260g);
        if (this.f2260g > 0) {
            parcel.writeIntArray(this.f2261h);
        }
        parcel.writeInt(this.f2262i);
        if (this.f2262i > 0) {
            parcel.writeIntArray(this.f2263j);
        }
        parcel.writeInt(this.f2265l ? 1 : 0);
        parcel.writeInt(this.f2266m ? 1 : 0);
        parcel.writeInt(this.f2267n ? 1 : 0);
        parcel.writeList(this.f2264k);
    }
}
