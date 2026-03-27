package p149u1;

import android.os.Parcel;
import android.os.Parcelable;
import p007B1.C0042b;
import p046P.AbstractC0573b;

/* JADX INFO: renamed from: u1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1948b extends AbstractC0573b {
    public static final Parcelable.Creator<C1948b> CREATOR = new C0042b(8);

    /* JADX INFO: renamed from: g */
    public boolean f6943g;

    public C1948b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            C1948b.class.getClassLoader();
        }
        this.f6943g = parcel.readInt() == 1;
    }

    @Override // p046P.AbstractC0573b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f6943g ? 1 : 0);
    }
}
