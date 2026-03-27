package p036L0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: L0.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0448h implements Parcelable {

    /* JADX INFO: renamed from: e */
    public final Bundle f1088e;

    public AbstractC0448h(C0444d c0444d) {
        this.f1088e = (Bundle) ((Bundle) c0444d.f1085e).clone();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeBundle(this.f1088e);
    }

    public AbstractC0448h(Parcel parcel) {
        this.f1088e = parcel.readBundle(C0444d.class.getClassLoader());
    }
}
