package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: com.facebook.x */
/* JADX INFO: loaded from: classes.dex */
public final class C1127x extends AbstractList {

    /* JADX INFO: renamed from: h */
    public static final AtomicInteger f3914h = new AtomicInteger();

    /* JADX INFO: renamed from: e */
    public Handler f3915e;

    /* JADX INFO: renamed from: f */
    public final List f3916f;

    /* JADX INFO: renamed from: g */
    public final ArrayList f3917g;

    public C1127x(List list) {
        this.f3916f = new ArrayList();
        f3914h.incrementAndGet();
        this.f3917g = new ArrayList();
        this.f3916f = new ArrayList(list);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        this.f3916f.add(i3, (C1125v) obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f3916f.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        return (C1125v) this.f3916f.get(i3);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i3) {
        return (C1125v) this.f3916f.remove(i3);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        return (C1125v) this.f3916f.set(i3, (C1125v) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3916f.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        return this.f3916f.add((C1125v) obj);
    }

    public C1127x(C1125v... c1125vArr) {
        this.f3916f = new ArrayList();
        f3914h.incrementAndGet();
        this.f3917g = new ArrayList();
        this.f3916f = Arrays.asList(c1125vArr);
    }
}
