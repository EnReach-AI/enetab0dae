package p007B1;

import android.os.Parcel;
import android.os.Parcelable;
import p046P.AbstractC0573b;

/* JADX INFO: renamed from: B1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0043c extends AbstractC0573b {
    public static final Parcelable.Creator<C0043c> CREATOR = new C0042b(0);

    /* JADX INFO: renamed from: g */
    public boolean f110g;

    public C0043c(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f110g = parcel.readInt() == 1;
    }

    @Override // p046P.AbstractC0573b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f110g ? 1 : 0);
    }
}
