package p073Z;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import p024H0.C0247a;

/* JADX INFO: renamed from: Z.d0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0787d0 implements Parcelable {
    public static final Parcelable.Creator<C0787d0> CREATOR = new C0247a(19);

    /* JADX INFO: renamed from: e */
    public int f2248e;

    /* JADX INFO: renamed from: f */
    public int f2249f;

    /* JADX INFO: renamed from: g */
    public int[] f2250g;

    /* JADX INFO: renamed from: h */
    public boolean f2251h;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f2248e + ", mGapDir=" + this.f2249f + ", mHasUnwantedGapAfter=" + this.f2251h + ", mGapPerSpan=" + Arrays.toString(this.f2250g) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f2248e);
        parcel.writeInt(this.f2249f);
        parcel.writeInt(this.f2251h ? 1 : 0);
        int[] iArr = this.f2250g;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f2250g);
        }
    }
}
