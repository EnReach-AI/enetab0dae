package p131p2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: p2.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1831e implements Iterator {

    /* JADX INFO: renamed from: e */
    public final int f6341e;

    /* JADX INFO: renamed from: f */
    public final int f6342f;

    /* JADX INFO: renamed from: g */
    public boolean f6343g;

    /* JADX INFO: renamed from: h */
    public int f6344h;

    public C1831e(int i3, int i4, int i5) {
        this.f6341e = i5;
        this.f6342f = i4;
        boolean z3 = false;
        if (i5 <= 0 ? i3 >= i4 : i3 <= i4) {
            z3 = true;
        }
        this.f6343g = z3;
        this.f6344h = z3 ? i3 : i4;
    }

    /* JADX INFO: renamed from: a */
    public final int m4074a() {
        int i3 = this.f6344h;
        if (i3 != this.f6342f) {
            this.f6344h = this.f6341e + i3;
        } else {
            if (!this.f6343g) {
                throw new NoSuchElementException();
            }
            this.f6343g = false;
        }
        return i3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6343g;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(m4074a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
