package p083b2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1069n implements Collection {

    /* JADX INFO: renamed from: e */
    public final byte[] f3753e;

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
        if (!(obj instanceof C1067l)) {
            return false;
        }
        byte b3 = ((C1067l) obj).f3749e;
        byte[] bArr = this.f3753e;
        int length = bArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (b3 == bArr[i3]) {
                break;
            }
            i3++;
        }
        return i3 >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        AbstractC1766e.m3920e("elements", collection);
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (obj instanceof C1067l) {
                byte b3 = ((C1067l) obj).f3749e;
                byte[] bArr = this.f3753e;
                int length = bArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        i3 = -1;
                        break;
                    }
                    if (b3 == bArr[i3]) {
                        break;
                    }
                    i3++;
                }
                if (i3 >= 0) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof C1069n) {
            return AbstractC1766e.m3916a(this.f3753e, ((C1069n) obj).f3753e);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f3753e);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f3753e.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C1068m(0, this.f3753e);
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
        return this.f3753e.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return AbstractC1766e.m3925j(this);
    }

    public final String toString() {
        return "UByteArray(storage=" + Arrays.toString(this.f3753e) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        AbstractC1766e.m3920e("array", objArr);
        return AbstractC1766e.m3926k(this, objArr);
    }
}
