package p083b2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1071p implements Collection {

    /* JADX INFO: renamed from: e */
    public final int[] f3755e;

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
        if (!(obj instanceof C1070o)) {
            return false;
        }
        int i3 = ((C1070o) obj).f3754e;
        int[] iArr = this.f3755e;
        int length = iArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                i4 = -1;
                break;
            }
            if (i3 == iArr[i4]) {
                break;
            }
            i4++;
        }
        return i4 >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        AbstractC1766e.m3920e("elements", collection);
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (obj instanceof C1070o) {
                int i3 = ((C1070o) obj).f3754e;
                int[] iArr = this.f3755e;
                int length = iArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        i4 = -1;
                        break;
                    }
                    if (i3 == iArr[i4]) {
                        break;
                    }
                    i4++;
                }
                if (i4 >= 0) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof C1071p) {
            return AbstractC1766e.m3916a(this.f3755e, ((C1071p) obj).f3755e);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f3755e);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f3755e.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C1068m(1, this.f3755e);
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
        return this.f3755e.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return AbstractC1766e.m3925j(this);
    }

    public final String toString() {
        return "UIntArray(storage=" + Arrays.toString(this.f3755e) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        AbstractC1766e.m3920e("array", objArr);
        return AbstractC1766e.m3926k(this, objArr);
    }
}
