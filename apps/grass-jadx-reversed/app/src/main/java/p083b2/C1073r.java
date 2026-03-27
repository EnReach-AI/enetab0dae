package p083b2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p086c2.AbstractC1084c;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1073r implements Collection {

    /* JADX INFO: renamed from: e */
    public final long[] f3757e;

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof C1072q)) {
            return false;
        }
        return AbstractC1084c.m2830x(this.f3757e, ((C1072q) obj).f3756e);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        AbstractC1766e.m3920e("elements", collection);
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (obj instanceof C1072q) {
                if (AbstractC1084c.m2830x(this.f3757e, ((C1072q) obj).f3756e)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof C1073r) {
            return AbstractC1766e.m3916a(this.f3757e, ((C1073r) obj).f3757e);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f3757e);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f3757e.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C1068m(2, this.f3757e);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f3757e.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return AbstractC1766e.m3925j(this);
    }

    public final String toString() {
        return "ULongArray(storage=" + Arrays.toString(this.f3757e) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        AbstractC1766e.m3920e("array", objArr);
        return AbstractC1766e.m3926k(this, objArr);
    }
}
