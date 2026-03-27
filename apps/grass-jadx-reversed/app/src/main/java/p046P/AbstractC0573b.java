package p046P;

import android.os.Parcel;
import android.os.Parcelable;
import p007B1.C0042b;

/* JADX INFO: renamed from: P.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0573b implements Parcelable {

    /* JADX INFO: renamed from: e */
    public final Parcelable f1425e;

    /* JADX INFO: renamed from: f */
    public static final C0572a f1424f = new C0572a();
    public static final Parcelable.Creator<AbstractC0573b> CREATOR = new C0042b(3);

    public AbstractC0573b() {
        this.f1425e = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f1425e, i3);
    }

    public AbstractC0573b(Parcelable parcelable) {
        if (parcelable != null) {
            this.f1425e = parcelable == f1424f ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbstractC0573b(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f1425e = parcelable == null ? f1424f : parcelable;
    }
}
