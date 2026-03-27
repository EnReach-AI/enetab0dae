package p080b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.C0880a;

/* JADX INFO: renamed from: b.d */
/* JADX INFO: loaded from: classes.dex */
public class C1002d implements Parcelable {
    public static final Parcelable.Creator<C1002d> CREATOR = new C0880a(6);

    /* JADX INFO: renamed from: e */
    public InterfaceC1000b f3572e;

    /* JADX INFO: renamed from: a */
    public void mo2190a(int i3, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        synchronized (this) {
            try {
                if (this.f3572e == null) {
                    this.f3572e = new BinderC1001c(this);
                }
                parcel.writeStrongBinder(this.f3572e.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
