package p118m1;

import java.io.Serializable;

/* JADX INFO: renamed from: m1.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1746k implements Serializable {

    /* JADX INFO: renamed from: h */
    public static final C1746k f6113h = new C1746k(1, 0, new Object[4]);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final int f6114e;

    /* JADX INFO: renamed from: f */
    public final int f6115f;

    /* JADX INFO: renamed from: g */
    public final Object[] f6116g;

    public C1746k(int i3, int i4, Object[] objArr) {
        this.f6114e = i3;
        this.f6115f = i4;
        this.f6116g = objArr;
    }

    /* JADX INFO: renamed from: a */
    public final Object m3904a(String str) {
        int iHashCode = str.hashCode();
        int i3 = this.f6114e;
        int i4 = iHashCode & i3;
        int i5 = i4 << 1;
        Object[] objArr = this.f6116g;
        Object obj = objArr[i5];
        if (obj == str || str.equals(obj)) {
            return objArr[i5 + 1];
        }
        if (obj == null) {
            return null;
        }
        int i6 = i3 + 1;
        int i7 = ((i4 >> 1) + i6) << 1;
        Object obj2 = objArr[i7];
        if (str.equals(obj2)) {
            return objArr[i7 + 1];
        }
        if (obj2 == null) {
            return null;
        }
        int i8 = (i6 + (i6 >> 1)) << 1;
        int i9 = this.f6115f + i8;
        while (i8 < i9) {
            Object obj3 = objArr[i8];
            if (obj3 == str || str.equals(obj3)) {
                return objArr[i8 + 1];
            }
            i8 += 2;
        }
        return null;
    }
}
