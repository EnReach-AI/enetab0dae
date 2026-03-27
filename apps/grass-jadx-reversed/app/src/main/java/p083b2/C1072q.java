package p083b2;

import p117m0.AbstractC1717l;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1072q implements Comparable {

    /* JADX INFO: renamed from: e */
    public final long f3756e;

    public /* synthetic */ C1072q(long j2) {
        this.f3756e = j2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j2 = ((C1072q) obj).f3756e;
        long j3 = this.f3756e ^ Long.MIN_VALUE;
        long j4 = j2 ^ Long.MIN_VALUE;
        if (j3 < j4) {
            return -1;
        }
        return j3 == j4 ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1072q) {
            return this.f3756e == ((C1072q) obj).f3756e;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f3756e);
    }

    public final String toString() {
        long j2 = this.f3756e;
        if (j2 >= 0) {
            AbstractC1717l.m3798a();
            String string = Long.toString(j2, 10);
            AbstractC1766e.m3919d("toString(...)", string);
            return string;
        }
        long j3 = 10;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        AbstractC1717l.m3798a();
        String string2 = Long.toString(j4, 10);
        AbstractC1766e.m3919d("toString(...)", string2);
        AbstractC1717l.m3798a();
        String string3 = Long.toString(j5, 10);
        AbstractC1766e.m3919d("toString(...)", string3);
        return string2.concat(string3);
    }
}
