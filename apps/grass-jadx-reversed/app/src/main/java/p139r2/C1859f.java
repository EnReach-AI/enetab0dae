package p139r2;

import java.util.Iterator;

/* JADX INFO: renamed from: r2.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1859f implements Iterator {

    /* JADX INFO: renamed from: e */
    public final Iterator f6431e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1860g f6432f;

    public C1859f(C1860g c1860g) {
        this.f6432f = c1860g;
        this.f6431e = c1860g.f6433a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6431e.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f6432f.f6434b.mo249f(this.f6431e.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
