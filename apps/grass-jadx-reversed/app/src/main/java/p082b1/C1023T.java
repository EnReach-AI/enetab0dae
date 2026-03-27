package p082b1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p077a0.C0846e;

/* JADX INFO: renamed from: b1.T */
/* JADX INFO: loaded from: classes.dex */
public final class C1023T implements Iterator {

    /* JADX INFO: renamed from: e */
    public C0846e f3639e;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3639e != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        C0846e c0846e = this.f3639e;
        if (c0846e == null) {
            throw new NoSuchElementException();
        }
        AbstractC1041l abstractC1041l = (AbstractC1041l) c0846e.f2515e;
        this.f3639e = (C0846e) c0846e.f2516f;
        return abstractC1041l;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
