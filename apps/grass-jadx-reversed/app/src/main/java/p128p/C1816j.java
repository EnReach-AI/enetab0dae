package p128p;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: p.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1816j implements Collection {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C1807a f6290e;

    public C1816j(C1807a c1807a) {
        this.f6290e = c1807a;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f6290e.m4006a();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f6290e.m4011f(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f6290e.m4009d() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C1813g(this.f6290e, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        C1807a c1807a = this.f6290e;
        int iM4011f = c1807a.m4011f(obj);
        if (iM4011f < 0) {
            return false;
        }
        c1807a.m4013h(iM4011f);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        C1807a c1807a = this.f6290e;
        int iM4009d = c1807a.m4009d();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < iM4009d) {
            if (collection.contains(c1807a.m4007b(i3, 1))) {
                c1807a.m4013h(i3);
                i3--;
                iM4009d--;
                z3 = true;
            }
            i3++;
        }
        return z3;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        C1807a c1807a = this.f6290e;
        int iM4009d = c1807a.m4009d();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < iM4009d) {
            if (!collection.contains(c1807a.m4007b(i3, 1))) {
                c1807a.m4013h(i3);
                i3--;
                iM4009d--;
                z3 = true;
            }
            i3++;
        }
        return z3;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f6290e.m4009d();
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f6290e.m4015k(objArr, 1);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        C1807a c1807a = this.f6290e;
        int iM4009d = c1807a.m4009d();
        Object[] objArr = new Object[iM4009d];
        for (int i3 = 0; i3 < iM4009d; i3++) {
            objArr[i3] = c1807a.m4007b(i3, 1);
        }
        return objArr;
    }
}
