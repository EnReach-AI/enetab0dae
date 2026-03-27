package p128p;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: p.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1813g implements Iterator {

    /* JADX INFO: renamed from: e */
    public final int f6279e;

    /* JADX INFO: renamed from: f */
    public int f6280f;

    /* JADX INFO: renamed from: g */
    public int f6281g;

    /* JADX INFO: renamed from: h */
    public boolean f6282h = false;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ C1807a f6283i;

    public C1813g(C1807a c1807a, int i3) {
        this.f6283i = c1807a;
        this.f6279e = i3;
        this.f6280f = c1807a.m4009d();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6281g < this.f6280f;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objM4007b = this.f6283i.m4007b(this.f6281g, this.f6279e);
        this.f6281g++;
        this.f6282h = true;
        return objM4007b;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f6282h) {
            throw new IllegalStateException();
        }
        int i3 = this.f6281g - 1;
        this.f6281g = i3;
        this.f6280f--;
        this.f6282h = false;
        this.f6283i.m4013h(i3);
    }
}
