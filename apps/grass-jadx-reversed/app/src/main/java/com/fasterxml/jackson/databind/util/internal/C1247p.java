package com.fasterxml.jackson.databind.util.internal;

import java.util.AbstractMap;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.util.internal.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1247p extends AbstractMap.SimpleEntry {
    static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ ConcurrentMapC1248q f4191e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1247p(ConcurrentMapC1248q concurrentMapC1248q, C1243l c1243l) {
        super(c1243l.f4183e, c1243l.m3113a());
        this.f4191e = concurrentMapC1248q;
    }

    @Override // java.util.AbstractMap.SimpleEntry, java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f4191e.m3120f(getKey(), obj, false);
        return super.setValue(obj);
    }

    public Object writeReplace() {
        return new AbstractMap.SimpleEntry(this);
    }
}
