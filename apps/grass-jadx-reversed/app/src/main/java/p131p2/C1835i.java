package p131p2;

/* JADX INFO: renamed from: p2.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1835i extends AbstractC1833g {
    static {
        new C1835i(1L, 0L);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m4075a(long j2) {
        return this.f6346e <= j2 && j2 <= this.f6347f;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1835i) {
            long j2 = this.f6346e;
            long j3 = this.f6347f;
            if (j2 > j3) {
                C1835i c1835i = (C1835i) obj;
                if (c1835i.f6346e <= c1835i.f6347f) {
                }
                return true;
            }
            C1835i c1835i2 = (C1835i) obj;
            if (j2 == c1835i2.f6346e && j3 == c1835i2.f6347f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f6346e;
        long j3 = this.f6347f;
        if (j2 > j3) {
            return -1;
        }
        return (int) ((((long) 31) * (j2 ^ (j2 >>> 32))) + ((j3 >>> 32) ^ j3));
    }

    public final String toString() {
        return this.f6346e + ".." + this.f6347f;
    }
}
