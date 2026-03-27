package p042N0;

import java.io.Serializable;

/* JADX INFO: renamed from: N0.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0558z implements Comparable, Serializable {

    /* JADX INFO: renamed from: g */
    public static final C0558z f1350g = new C0558z();
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final String f1351e = "";

    /* JADX INFO: renamed from: f */
    public final String f1352f = "";

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0558z c0558z = (C0558z) obj;
        if (c0558z == this) {
            return 0;
        }
        int iCompareTo = this.f1351e.compareTo(c0558z.f1351e);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompareTo2 = this.f1352f.compareTo(c0558z.f1352f);
        if (iCompareTo2 == 0) {
            return 0;
        }
        return iCompareTo2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C0558z.class) {
            return false;
        }
        C0558z c0558z = (C0558z) obj;
        return c0558z.f1352f.equals(this.f1352f) && c0558z.f1351e.equals(this.f1351e);
    }

    public final int hashCode() {
        return this.f1352f.hashCode() ^ this.f1351e.hashCode();
    }

    public final String toString() {
        return new StringBuilder("0.0.0").toString();
    }
}
