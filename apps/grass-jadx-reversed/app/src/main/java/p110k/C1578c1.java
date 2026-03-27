package p110k;

import android.os.Parcel;
import android.os.Parcelable;
import p007B1.C0042b;
import p046P.AbstractC0573b;

/* JADX INFO: renamed from: k.c1 */
/* JADX INFO: loaded from: classes.dex */
public final class C1578c1 extends AbstractC0573b {
    public static final Parcelable.Creator<C1578c1> CREATOR = new C0042b(6);

    /* JADX INFO: renamed from: g */
    public int f5612g;

    /* JADX INFO: renamed from: h */
    public boolean f5613h;

    public C1578c1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f5612g = parcel.readInt();
        this.f5613h = parcel.readInt() != 0;
    }

    @Override // p046P.AbstractC0573b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f5612g);
        parcel.writeInt(this.f5613h ? 1 : 0);
    }
}
