package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.C0880a;
import p095f0.C1345b;
import p095f0.InterfaceC1346c;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new C0880a(14);

    /* JADX INFO: renamed from: e */
    public final InterfaceC1346c f3475e;

    public ParcelImpl(Parcel parcel) {
        this.f3475e = new C1345b(parcel).m3298h();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        new C1345b(parcel).m3301k(this.f3475e);
    }
}
