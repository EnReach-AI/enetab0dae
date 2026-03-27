package p118m1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: m1.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1740e implements Iterator, Iterable {

    /* JADX INFO: renamed from: e */
    public final Object[] f6097e;

    /* JADX INFO: renamed from: f */
    public int f6098f = 0;

    public C1740e(Object[] objArr) {
        this.f6097e = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6098f < this.f6097e.length;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i3 = this.f6098f;
        Object[] objArr = this.f6097e;
        if (i3 >= objArr.length) {
            throw new NoSuchElementException();
        }
        this.f6098f = i3 + 1;
        return objArr[i3];
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
