package p036L0;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import p024H0.C0247a;

/* JADX INFO: renamed from: L0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0443c extends AbstractC0441a {
    public static final Parcelable.Creator<C0443c> CREATOR = new C0247a(12);

    /* JADX INFO: renamed from: k */
    public final String f1081k;

    /* JADX INFO: renamed from: l */
    public final String f1082l;

    /* JADX INFO: renamed from: m */
    public final Uri f1083m;

    /* JADX INFO: renamed from: n */
    public final String f1084n;

    public C0443c(Parcel parcel) {
        super(parcel);
        this.f1081k = parcel.readString();
        this.f1082l = parcel.readString();
        this.f1083m = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f1084n = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // p036L0.AbstractC0441a, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f1081k);
        parcel.writeString(this.f1082l);
        parcel.writeParcelable(this.f1083m, 0);
        parcel.writeString(this.f1084n);
    }
}
