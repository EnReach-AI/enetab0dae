package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.C0880a;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.E */
/* JADX INFO: loaded from: classes.dex */
public final class C0919E implements Parcelable {
    public static final Parcelable.Creator<C0919E> CREATOR = new C0880a(4);

    /* JADX INFO: renamed from: e */
    public ArrayList f3055e;

    /* JADX INFO: renamed from: f */
    public ArrayList f3056f;

    /* JADX INFO: renamed from: g */
    public C0931b[] f3057g;

    /* JADX INFO: renamed from: h */
    public int f3058h;

    /* JADX INFO: renamed from: i */
    public String f3059i;

    /* JADX INFO: renamed from: j */
    public ArrayList f3060j;

    /* JADX INFO: renamed from: k */
    public ArrayList f3061k;

    /* JADX INFO: renamed from: l */
    public ArrayList f3062l;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.f3055e);
        parcel.writeStringList(this.f3056f);
        parcel.writeTypedArray(this.f3057g, i3);
        parcel.writeInt(this.f3058h);
        parcel.writeString(this.f3059i);
        parcel.writeStringList(this.f3060j);
        parcel.writeTypedList(this.f3061k);
        parcel.writeTypedList(this.f3062l);
    }
}
