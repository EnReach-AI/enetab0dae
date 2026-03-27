package p155w;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import p007B1.C0042b;
import p046P.AbstractC0573b;

/* JADX INFO: renamed from: w.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1984f extends AbstractC0573b {
    public static final Parcelable.Creator<C1984f> CREATOR = new C0042b(9);

    /* JADX INFO: renamed from: g */
    public SparseArray f7043g;

    public C1984f(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i3 = parcel.readInt();
        int[] iArr = new int[i3];
        parcel.readIntArray(iArr);
        Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        this.f7043g = new SparseArray(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            this.f7043g.append(iArr[i4], parcelableArray[i4]);
        }
    }

    @Override // p046P.AbstractC0573b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        SparseArray sparseArray = this.f7043g;
        int size = sparseArray != null ? sparseArray.size() : 0;
        parcel.writeInt(size);
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr[i4] = this.f7043g.keyAt(i4);
            parcelableArr[i4] = (Parcelable) this.f7043g.valueAt(i4);
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i3);
    }
}
