package p073Z;

import android.os.Parcel;
import android.os.Parcelable;
import p007B1.C0042b;
import p046P.AbstractC0573b;

/* JADX INFO: renamed from: Z.Q */
/* JADX INFO: loaded from: classes.dex */
public final class C0771Q extends AbstractC0573b {
    public static final Parcelable.Creator<C0771Q> CREATOR = new C0042b(4);

    /* JADX INFO: renamed from: g */
    public Parcelable f2172g;

    public C0771Q(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2172g = parcel.readParcelable(classLoader == null ? AbstractC0763I.class.getClassLoader() : classLoader);
    }

    @Override // p046P.AbstractC0573b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeParcelable(this.f2172g, 0);
    }
}
