package p110k;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.activity.result.C0880a;

/* JADX INFO: renamed from: k.M */
/* JADX INFO: loaded from: classes.dex */
public final class C1543M extends View.BaseSavedState {
    public static final Parcelable.Creator<C1543M> CREATOR = new C0880a(15);

    /* JADX INFO: renamed from: e */
    public boolean f5519e;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeByte(this.f5519e ? (byte) 1 : (byte) 0);
    }
}
