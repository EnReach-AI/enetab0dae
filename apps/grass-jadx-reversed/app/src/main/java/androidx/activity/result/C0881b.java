package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: androidx.activity.result.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0881b implements Parcelable {
    public static final Parcelable.Creator<C0881b> CREATOR = new C0880a(0);

    /* JADX INFO: renamed from: e */
    public final int f2627e;

    /* JADX INFO: renamed from: f */
    public final Intent f2628f;

    public C0881b(int i3, Intent intent) {
        this.f2627e = i3;
        this.f2628f = intent;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ActivityResult{resultCode=");
        int i3 = this.f2627e;
        sb.append(i3 != -1 ? i3 != 0 ? String.valueOf(i3) : "RESULT_CANCELED" : "RESULT_OK");
        sb.append(", data=");
        sb.append(this.f2628f);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f2627e);
        Intent intent = this.f2628f;
        parcel.writeInt(intent == null ? 0 : 1);
        if (intent != null) {
            intent.writeToParcel(parcel, i3);
        }
    }

    public C0881b(Parcel parcel) {
        this.f2627e = parcel.readInt();
        this.f2628f = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
