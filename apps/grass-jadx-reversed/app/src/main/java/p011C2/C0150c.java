package p011C2;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import p086c2.AbstractC1085d;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2016e;

/* JADX INFO: renamed from: C2.c */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC2016e(with = C0152e.class)
public final class C0150c extends AbstractC0156i implements List<AbstractC0156i> {
    public static final C0149b Companion = new C0149b();

    /* JADX INFO: renamed from: e */
    public final List f360e;

    public C0150c(List list) {
        AbstractC1766e.m3920e("content", list);
        this.f360e = list;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i3, AbstractC0156i abstractC0156i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i3, Collection<? extends AbstractC0156i> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof AbstractC0156i)) {
            return false;
        }
        AbstractC0156i abstractC0156i = (AbstractC0156i) obj;
        AbstractC1766e.m3920e("element", abstractC0156i);
        return this.f360e.contains(abstractC0156i);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        AbstractC1766e.m3920e("elements", collection);
        return this.f360e.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        return AbstractC1766e.m3916a(this.f360e, obj);
    }

    @Override // java.util.List
    public final AbstractC0156i get(int i3) {
        return (AbstractC0156i) this.f360e.get(i3);
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.f360e.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof AbstractC0156i)) {
            return -1;
        }
        AbstractC0156i abstractC0156i = (AbstractC0156i) obj;
        AbstractC1766e.m3920e("element", abstractC0156i);
        return this.f360e.indexOf(abstractC0156i);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f360e.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.f360e.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof AbstractC0156i)) {
            return -1;
        }
        AbstractC0156i abstractC0156i = (AbstractC0156i) obj;
        AbstractC1766e.m3920e("element", abstractC0156i);
        return this.f360e.lastIndexOf(abstractC0156i);
    }

    @Override // java.util.List
    public final ListIterator<AbstractC0156i> listIterator() {
        return this.f360e.listIterator();
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ AbstractC0156i remove(int i3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<AbstractC0156i> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ AbstractC0156i set(int i3, AbstractC0156i abstractC0156i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f360e.size();
    }

    @Override // java.util.List
    public final void sort(Comparator<? super AbstractC0156i> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<AbstractC0156i> subList(int i3, int i4) {
        return this.f360e.subList(i3, i4);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return AbstractC1766e.m3925j(this);
    }

    public final String toString() {
        return AbstractC1085d.m2834x(this.f360e, ",", "[", "]", null, 56);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final ListIterator<AbstractC0156i> listIterator(int i3) {
        return this.f360e.listIterator(i3);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        AbstractC1766e.m3920e("array", objArr);
        return AbstractC1766e.m3926k(this, objArr);
    }
}
