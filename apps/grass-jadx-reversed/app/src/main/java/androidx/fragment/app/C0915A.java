package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.C0880a;

/* JADX INFO: renamed from: androidx.fragment.app.A */
/* JADX INFO: loaded from: classes.dex */
public final class C0915A implements Parcelable {
    public static final Parcelable.Creator<C0915A> CREATOR = new C0880a(3);

    /* JADX INFO: renamed from: e */
    public String f3017e;

    /* JADX INFO: renamed from: f */
    public int f3018f;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f3017e);
        parcel.writeInt(this.f3018f);
    }
}
