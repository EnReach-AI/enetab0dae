package p036L0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import p024H0.C0247a;

/* JADX INFO: renamed from: L0.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0446f extends AbstractC0441a {
    public static final Parcelable.Creator<C0446f> CREATOR = new C0247a(14);

    /* JADX INFO: renamed from: k */
    public final C0445e f1086k;

    /* JADX INFO: renamed from: l */
    public final String f1087l;

    public C0446f(Parcel parcel) {
        super(parcel);
        C0444d c0444d = new C0444d();
        Bundle bundle = new Bundle();
        c0444d.f1085e = bundle;
        C0445e c0445e = (C0445e) parcel.readParcelable(C0445e.class.getClassLoader());
        if (c0445e != null) {
            Bundle bundle2 = c0445e.f1088e;
            ((Bundle) c0444d.f1085e).putAll((Bundle) bundle2.clone());
            bundle.putString("og:type", bundle2.getString("og:type"));
        }
        this.f1086k = new C0445e(c0444d);
        this.f1087l = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // p036L0.AbstractC0441a, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeParcelable(this.f1086k, 0);
        parcel.writeString(this.f1087l);
    }
}
