package p131p2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: p2.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1828b implements Iterator {

    /* JADX INFO: renamed from: e */
    public final int f6334e;

    /* JADX INFO: renamed from: f */
    public final int f6335f;

    /* JADX INFO: renamed from: g */
    public boolean f6336g;

    /* JADX INFO: renamed from: h */
    public int f6337h;

    public C1828b(char c3, char c4, int i3) {
        this.f6334e = i3;
        this.f6335f = c4;
        boolean z3 = false;
        if (i3 <= 0 ? AbstractC1766e.m3921f(c3, c4) >= 0 : AbstractC1766e.m3921f(c3, c4) <= 0) {
            z3 = true;
        }
        this.f6336g = z3;
        this.f6337h = z3 ? c3 : c4;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6336g;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i3 = this.f6337h;
        if (i3 != this.f6335f) {
            this.f6337h = this.f6334e + i3;
        } else {
            if (!this.f6336g) {
                throw new NoSuchElementException();
            }
            this.f6336g = false;
        }
        return Character.valueOf((char) i3);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
