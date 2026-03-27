package p041N;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import p024H0.C0247a;

/* JADX INFO: renamed from: N.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0524l extends View.BaseSavedState {
    public static final Parcelable.Creator<C0524l> CREATOR = new C0247a(17);

    /* JADX INFO: renamed from: e */
    public int f1218e;

    public final String toString() {
        return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1218e + "}";
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f1218e);
    }
}
