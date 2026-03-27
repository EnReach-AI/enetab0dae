package p086c2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p083b2.C1068m;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: c2.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1082a implements Collection {

    /* JADX INFO: renamed from: e */
    public final Object[] f3775e;

    /* JADX INFO: renamed from: f */
    public final boolean f3776f;

    public C1082a(Object[] objArr, boolean z3) {
        this.f3775e = objArr;
        this.f3776f = z3;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
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
        return AbstractC1084c.m2832z(this.f3775e, obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        AbstractC1766e.m3920e("elements", collection);
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (AbstractC1084c.m2832z(this.f3775e, it.next()) < 0) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f3775e.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        Object[] objArr = this.f3775e;
        AbstractC1766e.m3920e("array", objArr);
        return new C1068m(objArr);
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
        return this.f3775e.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] objArr = this.f3775e;
        AbstractC1766e.m3920e("<this>", objArr);
        if (this.f3776f && objArr.getClass().equals(Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        AbstractC1766e.m3919d("copyOf(...)", objArrCopyOf);
        return objArrCopyOf;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        AbstractC1766e.m3920e("array", objArr);
        return AbstractC1766e.m3926k(this, objArr);
    }
}
