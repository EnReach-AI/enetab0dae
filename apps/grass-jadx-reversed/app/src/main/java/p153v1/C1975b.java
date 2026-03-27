package p153v1;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.activity.result.C0880a;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: v1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1975b extends View.BaseSavedState {
    public static final Parcelable.Creator<C1975b> CREATOR = new C0880a(16);

    /* JADX INFO: renamed from: e */
    public int f6996e;

    public final String toString() {
        StringBuilder sb = new StringBuilder("MaterialCheckBox.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" CheckedState=");
        int i3 = this.f6996e;
        return AbstractC0032g.m157o(sb, i3 != 1 ? i3 != 2 ? "unchecked" : "indeterminate" : "checked", "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeValue(Integer.valueOf(this.f6996e));
    }
}
