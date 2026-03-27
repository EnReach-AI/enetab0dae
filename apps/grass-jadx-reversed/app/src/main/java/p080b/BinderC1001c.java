package p080b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: renamed from: b.c */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1001c extends Binder implements InterfaceC1000b {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ int f3570b = 0;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1002d f3571a;

    public BinderC1001c(C1002d c1002d) {
        this.f3571a = c1002d;
        attachInterface(this, "android.support.v4.os.IResultReceiver");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 >= 1 && i3 <= 16777215) {
            parcel.enforceInterface("android.support.v4.os.IResultReceiver");
        }
        if (i3 == 1598968902) {
            parcel2.writeString("android.support.v4.os.IResultReceiver");
            return true;
        }
        if (i3 != 1) {
            return super.onTransact(i3, parcel, parcel2, i4);
        }
        int i5 = parcel.readInt();
        Object objCreateFromParcel = parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null;
        C1002d c1002d = this.f3571a;
        c1002d.getClass();
        c1002d.mo2190a(i5, (Bundle) objCreateFromParcel);
        return true;
    }
}
