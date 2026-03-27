package com.fasterxml.jackson.databind.util.internal;

import java.util.AbstractCollection;
import java.util.Iterator;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.util.internal.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1245n extends AbstractCollection {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ ConcurrentMapC1248q f4188e;

    public C1245n(ConcurrentMapC1248q concurrentMapC1248q) {
        this.f4188e = concurrentMapC1248q;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f4188e.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f4188e.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C1241j(this.f4188e, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f4188e.size();
    }
}
