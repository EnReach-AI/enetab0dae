package p028I1;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.sidesheet.SideSheetBehavior;
import p007B1.C0042b;
import p046P.AbstractC0573b;

/* JADX INFO: renamed from: I1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0303c extends AbstractC0573b {
    public static final Parcelable.Creator<C0303c> CREATOR = new C0042b(1);

    /* JADX INFO: renamed from: g */
    public final int f804g;

    public C0303c(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f804g = parcel.readInt();
    }

    @Override // p046P.AbstractC0573b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f804g);
    }

    public C0303c(AbsSavedState absSavedState, SideSheetBehavior sideSheetBehavior) {
        super(absSavedState);
        this.f804g = sideSheetBehavior.f4446h;
    }
}
