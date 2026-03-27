package p131p2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: p2.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1834h implements Iterator {

    /* JADX INFO: renamed from: e */
    public final long f6349e;

    /* JADX INFO: renamed from: f */
    public final long f6350f;

    /* JADX INFO: renamed from: g */
    public boolean f6351g;

    /* JADX INFO: renamed from: h */
    public long f6352h;

    public C1834h(long j2, long j3, long j4) {
        this.f6349e = j4;
        this.f6350f = j3;
        boolean z3 = false;
        if (j4 <= 0 ? j2 >= j3 : j2 <= j3) {
            z3 = true;
        }
        this.f6351g = z3;
        this.f6352h = z3 ? j2 : j3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6351g;
    }

    @Override // java.util.Iterator
    public final Object next() {
        long j2 = this.f6352h;
        if (j2 != this.f6350f) {
            this.f6352h = this.f6349e + j2;
        } else {
            if (!this.f6351g) {
                throw new NoSuchElementException();
            }
            this.f6351g = false;
        }
        return Long.valueOf(j2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
