package p036L0;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import p024H0.C0247a;

/* JADX INFO: renamed from: L0.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0449i implements Parcelable {
    public static final Parcelable.Creator<C0449i> CREATOR = new C0247a(16);

    /* JADX INFO: renamed from: e */
    public final Bundle f1089e;

    /* JADX INFO: renamed from: f */
    public final Bitmap f1090f;

    /* JADX INFO: renamed from: g */
    public final Uri f1091g;

    /* JADX INFO: renamed from: h */
    public final boolean f1092h;

    /* JADX INFO: renamed from: i */
    public final String f1093i;

    public C0449i(Parcel parcel) {
        this.f1089e = parcel.readBundle();
        this.f1090f = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.f1091g = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f1092h = parcel.readByte() != 0;
        this.f1093i = parcel.readString();
    }

    /* JADX INFO: renamed from: a */
    public final void m986a(Parcel parcel, int i3) {
        parcel.writeBundle(this.f1089e);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        m986a(parcel, i3);
        parcel.writeParcelable(this.f1090f, 0);
        parcel.writeParcelable(this.f1091g, 0);
        parcel.writeByte(this.f1092h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f1093i);
    }
}
