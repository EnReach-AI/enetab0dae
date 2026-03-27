package p145t1;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import p007B1.C0042b;
import p046P.AbstractC0573b;

/* JADX INFO: renamed from: t1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1921a extends AbstractC0573b {
    public static final Parcelable.Creator<C1921a> CREATOR = new C0042b(7);

    /* JADX INFO: renamed from: g */
    public final int f6723g;

    /* JADX INFO: renamed from: h */
    public final int f6724h;

    /* JADX INFO: renamed from: i */
    public final boolean f6725i;

    /* JADX INFO: renamed from: j */
    public final boolean f6726j;

    /* JADX INFO: renamed from: k */
    public final boolean f6727k;

    public C1921a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f6723g = parcel.readInt();
        this.f6724h = parcel.readInt();
        this.f6725i = parcel.readInt() == 1;
        this.f6726j = parcel.readInt() == 1;
        this.f6727k = parcel.readInt() == 1;
    }

    @Override // p046P.AbstractC0573b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f6723g);
        parcel.writeInt(this.f6724h);
        parcel.writeInt(this.f6725i ? 1 : 0);
        parcel.writeInt(this.f6726j ? 1 : 0);
        parcel.writeInt(this.f6727k ? 1 : 0);
    }

    public C1921a(AbsSavedState absSavedState, BottomSheetBehavior bottomSheetBehavior) {
        super(absSavedState);
        this.f6723g = bottomSheetBehavior.f4248L;
        this.f6724h = bottomSheetBehavior.f4271e;
        this.f6725i = bottomSheetBehavior.f4265b;
        this.f6726j = bottomSheetBehavior.f4245I;
        this.f6727k = bottomSheetBehavior.f4246J;
    }
}
