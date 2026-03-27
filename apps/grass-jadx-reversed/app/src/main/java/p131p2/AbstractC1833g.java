package p131p2;

import java.util.Iterator;

/* JADX INFO: renamed from: p2.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1833g implements Iterable {

    /* JADX INFO: renamed from: e */
    public final long f6346e;

    /* JADX INFO: renamed from: f */
    public final long f6347f;

    /* JADX INFO: renamed from: g */
    public final long f6348g;

    public AbstractC1833g(long j2, long j3) {
        this.f6346e = j2;
        if (j2 < j3) {
            long j4 = j3 % 1;
            long j5 = j2 % 1;
            long j6 = ((j4 < 0 ? j4 + 1 : j4) - (j5 < 0 ? j5 + 1 : j5)) % 1;
            j3 -= j6 < 0 ? j6 + 1 : j6;
        }
        this.f6347f = j3;
        this.f6348g = 1L;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C1834h(this.f6346e, this.f6347f, this.f6348g);
    }
}
