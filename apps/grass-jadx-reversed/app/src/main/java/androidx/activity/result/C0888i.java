package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: androidx.activity.result.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0888i implements Parcelable {
    public static final Parcelable.Creator<C0888i> CREATOR = new C0880a(1);

    /* JADX INFO: renamed from: e */
    public final IntentSender f2645e;

    /* JADX INFO: renamed from: f */
    public final Intent f2646f;

    /* JADX INFO: renamed from: g */
    public final int f2647g;

    /* JADX INFO: renamed from: h */
    public final int f2648h;

    public C0888i(IntentSender intentSender, int i3, int i4) {
        this.f2645e = intentSender;
        this.f2646f = null;
        this.f2647g = i3;
        this.f2648h = i4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f2645e, i3);
        parcel.writeParcelable(this.f2646f, i3);
        parcel.writeInt(this.f2647g);
        parcel.writeInt(this.f2648h);
    }

    public C0888i(Parcel parcel) {
        this.f2645e = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f2646f = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f2647g = parcel.readInt();
        this.f2648h = parcel.readInt();
    }
}
