package p095f0;

import android.os.Parcel;
import android.util.SparseIntArray;
import p005B.AbstractC0032g;
import p128p.C1808b;

/* JADX INFO: renamed from: f0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1345b extends AbstractC1344a {

    /* JADX INFO: renamed from: d */
    public final SparseIntArray f4806d;

    /* JADX INFO: renamed from: e */
    public final Parcel f4807e;

    /* JADX INFO: renamed from: f */
    public final int f4808f;

    /* JADX INFO: renamed from: g */
    public final int f4809g;

    /* JADX INFO: renamed from: h */
    public final String f4810h;

    /* JADX INFO: renamed from: i */
    public int f4811i;

    /* JADX INFO: renamed from: j */
    public int f4812j;

    /* JADX INFO: renamed from: k */
    public int f4813k;

    public C1345b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C1808b(), new C1808b(), new C1808b());
    }

    @Override // p095f0.AbstractC1344a
    /* JADX INFO: renamed from: a */
    public final C1345b mo3291a() {
        Parcel parcel = this.f4807e;
        int iDataPosition = parcel.dataPosition();
        int i3 = this.f4812j;
        if (i3 == this.f4808f) {
            i3 = this.f4809g;
        }
        return new C1345b(parcel, iDataPosition, i3, AbstractC0032g.m157o(new StringBuilder(), this.f4810h, "  "), this.f4803a, this.f4804b, this.f4805c);
    }

    @Override // p095f0.AbstractC1344a
    /* JADX INFO: renamed from: e */
    public final boolean mo3295e(int i3) {
        while (this.f4812j < this.f4809g) {
            int i4 = this.f4813k;
            if (i4 == i3) {
                return true;
            }
            if (String.valueOf(i4).compareTo(String.valueOf(i3)) > 0) {
                return false;
            }
            int i5 = this.f4812j;
            Parcel parcel = this.f4807e;
            parcel.setDataPosition(i5);
            int i6 = parcel.readInt();
            this.f4813k = parcel.readInt();
            this.f4812j += i6;
        }
        return this.f4813k == i3;
    }

    @Override // p095f0.AbstractC1344a
    /* JADX INFO: renamed from: i */
    public final void mo3299i(int i3) {
        int i4 = this.f4811i;
        SparseIntArray sparseIntArray = this.f4806d;
        Parcel parcel = this.f4807e;
        if (i4 >= 0) {
            int i5 = sparseIntArray.get(i4);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i5);
            parcel.writeInt(iDataPosition - i5);
            parcel.setDataPosition(iDataPosition);
        }
        this.f4811i = i3;
        sparseIntArray.put(i3, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i3);
    }

    public C1345b(Parcel parcel, int i3, int i4, String str, C1808b c1808b, C1808b c1808b2, C1808b c1808b3) {
        super(c1808b, c1808b2, c1808b3);
        this.f4806d = new SparseIntArray();
        this.f4811i = -1;
        this.f4813k = -1;
        this.f4807e = parcel;
        this.f4808f = i3;
        this.f4809g = i4;
        this.f4812j = i3;
        this.f4810h = str;
    }
}
