package p110k;

import android.os.Parcel;
import android.os.Parcelable;
import p007B1.C0042b;
import p046P.AbstractC0573b;

/* JADX INFO: renamed from: k.R0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1553R0 extends AbstractC0573b {
    public static final Parcelable.Creator<C1553R0> CREATOR = new C0042b(5);

    /* JADX INFO: renamed from: g */
    public boolean f5536g;

    public C1553R0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f5536g = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public final String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f5536g + "}";
    }

    @Override // p046P.AbstractC0573b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeValue(Boolean.valueOf(this.f5536g));
    }
}
