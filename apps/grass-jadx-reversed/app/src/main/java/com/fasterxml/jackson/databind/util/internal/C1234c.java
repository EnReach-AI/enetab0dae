package com.fasterxml.jackson.databind.util.internal;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.util.internal.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1234c extends AbstractCollection implements Deque {

    /* JADX INFO: renamed from: e */
    public InterfaceC1232a f4164e;

    /* JADX INFO: renamed from: f */
    public InterfaceC1232a f4165f;

    /* JADX INFO: renamed from: a */
    public final void m3107a() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
    public final boolean add(Object obj) {
        return offerLast((InterfaceC1232a) obj);
    }

    @Override // java.util.Deque
    public final void addFirst(Object obj) {
        if (!offerFirst((InterfaceC1232a) obj)) {
            throw new IllegalArgumentException();
        }
    }

    @Override // java.util.Deque
    public final void addLast(Object obj) {
        if (!offerLast((InterfaceC1232a) obj)) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3108b(InterfaceC1232a interfaceC1232a) {
        return (((C1243l) interfaceC1232a).f4184f == null && ((C1243l) interfaceC1232a).f4185g == null && interfaceC1232a != this.f4164e) ? false : true;
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final boolean offerFirst(InterfaceC1232a interfaceC1232a) {
        if (m3108b(interfaceC1232a)) {
            return false;
        }
        InterfaceC1232a interfaceC1232a2 = this.f4164e;
        this.f4164e = interfaceC1232a;
        if (interfaceC1232a2 == null) {
            this.f4165f = interfaceC1232a;
            return true;
        }
        ((C1243l) interfaceC1232a2).f4184f = (C1243l) interfaceC1232a;
        ((C1243l) interfaceC1232a).f4185g = (C1243l) interfaceC1232a2;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        InterfaceC1232a interfaceC1232a = this.f4164e;
        while (interfaceC1232a != null) {
            C1243l c1243l = (C1243l) interfaceC1232a;
            C1243l c1243l2 = c1243l.f4185g;
            c1243l.f4184f = null;
            c1243l.f4185g = null;
            interfaceC1232a = c1243l2;
        }
        this.f4165f = null;
        this.f4164e = null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final boolean contains(Object obj) {
        return (obj instanceof InterfaceC1232a) && m3108b((InterfaceC1232a) obj);
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final boolean offerLast(InterfaceC1232a interfaceC1232a) {
        if (m3108b(interfaceC1232a)) {
            return false;
        }
        InterfaceC1232a interfaceC1232a2 = this.f4165f;
        this.f4165f = interfaceC1232a;
        if (interfaceC1232a2 == null) {
            this.f4164e = interfaceC1232a;
            return true;
        }
        ((C1243l) interfaceC1232a2).f4185g = (C1243l) interfaceC1232a;
        ((C1243l) interfaceC1232a).f4184f = (C1243l) interfaceC1232a2;
        return true;
    }

    @Override // java.util.Deque
    public final Iterator descendingIterator() {
        return new C1233b(this.f4165f, 1);
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final InterfaceC1232a pollFirst() {
        if (isEmpty()) {
            return null;
        }
        InterfaceC1232a interfaceC1232a = this.f4164e;
        C1243l c1243l = (C1243l) interfaceC1232a;
        C1243l c1243l2 = c1243l.f4185g;
        c1243l.f4185g = null;
        this.f4164e = c1243l2;
        if (c1243l2 == null) {
            this.f4165f = null;
        } else {
            c1243l2.f4184f = null;
        }
        return interfaceC1232a;
    }

    @Override // java.util.Deque, java.util.Queue
    public final Object element() {
        m3107a();
        return this.f4164e;
    }

    @Override // java.util.Deque
    public final Object getFirst() {
        m3107a();
        return this.f4164e;
    }

    @Override // java.util.Deque
    public final Object getLast() {
        m3107a();
        return this.f4165f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f4164e == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Deque
    public final Iterator iterator() {
        return new C1233b(this.f4164e, 0);
    }

    @Override // java.util.Deque, java.util.Queue
    public final boolean offer(Object obj) {
        return offerLast((InterfaceC1232a) obj);
    }

    @Override // java.util.Deque, java.util.Queue
    public final Object peek() {
        return this.f4164e;
    }

    @Override // java.util.Deque
    public final Object peekFirst() {
        return this.f4164e;
    }

    @Override // java.util.Deque
    public final Object peekLast() {
        return this.f4165f;
    }

    @Override // java.util.Deque, java.util.Queue
    public final Object poll() {
        return pollFirst();
    }

    @Override // java.util.Deque
    public final Object pollLast() {
        if (isEmpty()) {
            return null;
        }
        InterfaceC1232a interfaceC1232a = this.f4165f;
        C1243l c1243l = (C1243l) interfaceC1232a;
        C1243l c1243l2 = c1243l.f4184f;
        c1243l.f4184f = null;
        this.f4165f = c1243l2;
        if (c1243l2 == null) {
            this.f4164e = null;
        } else {
            c1243l2.f4185g = null;
        }
        return interfaceC1232a;
    }

    @Override // java.util.Deque
    public final Object pop() {
        m3107a();
        return pollFirst();
    }

    @Override // java.util.Deque
    public final void push(Object obj) {
        if (!offerFirst((InterfaceC1232a) obj)) {
            throw new IllegalArgumentException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final boolean remove(Object obj) {
        if (obj instanceof InterfaceC1232a) {
            InterfaceC1232a interfaceC1232a = (InterfaceC1232a) obj;
            if (m3108b(interfaceC1232a)) {
                C1243l c1243l = (C1243l) interfaceC1232a;
                C1243l c1243l2 = c1243l.f4184f;
                C1243l c1243l3 = c1243l.f4185g;
                if (c1243l2 == null) {
                    this.f4164e = c1243l3;
                } else {
                    c1243l2.f4185g = c1243l3;
                    c1243l.f4184f = null;
                }
                if (c1243l3 == null) {
                    this.f4165f = c1243l2;
                } else {
                    c1243l3.f4184f = c1243l2;
                    c1243l.f4185g = null;
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Deque
    public final Object removeFirst() {
        m3107a();
        return pollFirst();
    }

    @Override // java.util.Deque
    public final boolean removeFirstOccurrence(Object obj) {
        return remove(obj);
    }

    @Override // java.util.Deque
    public final Object removeLast() {
        m3107a();
        if (isEmpty()) {
            return null;
        }
        InterfaceC1232a interfaceC1232a = this.f4165f;
        C1243l c1243l = (C1243l) interfaceC1232a;
        C1243l c1243l2 = c1243l.f4184f;
        c1243l.f4184f = null;
        this.f4165f = c1243l2;
        if (c1243l2 == null) {
            this.f4164e = null;
        } else {
            c1243l2.f4185g = null;
        }
        return interfaceC1232a;
    }

    @Override // java.util.Deque
    public final boolean removeLastOccurrence(Object obj) {
        return remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final int size() {
        int i3 = 0;
        for (Object obj = this.f4164e; obj != null; obj = ((C1243l) obj).f4185g) {
            i3++;
        }
        return i3;
    }

    @Override // java.util.Deque, java.util.Queue
    public final Object remove() {
        m3107a();
        return pollFirst();
    }
}
