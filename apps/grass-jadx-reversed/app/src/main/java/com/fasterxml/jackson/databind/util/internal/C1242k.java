package com.fasterxml.jackson.databind.util.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.util.internal.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1242k extends AbstractSet {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f4180e;

    /* JADX INFO: renamed from: f */
    public final ConcurrentMapC1248q f4181f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ ConcurrentMapC1248q f4182g;

    public /* synthetic */ C1242k(ConcurrentMapC1248q concurrentMapC1248q, int i3) {
        this.f4180e = i3;
        this.f4182g = concurrentMapC1248q;
        this.f4181f = concurrentMapC1248q;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        switch (this.f4180e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                throw new UnsupportedOperationException("ConcurrentLinkedHashMap does not allow add to be called on entrySet()");
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f4180e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f4181f.clear();
                break;
            default:
                this.f4181f.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f4180e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                C1243l c1243l = (C1243l) this.f4181f.f4194e.get(entry.getKey());
                return c1243l != null && c1243l.m3113a().equals(entry.getValue());
            default:
                return this.f4182g.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f4180e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new C1241j(this.f4182g, 0);
            default:
                return new C1241j(this.f4182g, 2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f4180e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return this.f4181f.remove(entry.getKey(), entry.getValue());
            default:
                return this.f4181f.remove(obj) != null;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f4180e) {
        }
        return this.f4181f.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        switch (this.f4180e) {
            case 1:
                return this.f4181f.f4194e.keySet().toArray();
            default:
                return super.toArray();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        switch (this.f4180e) {
            case 1:
                return this.f4181f.f4194e.keySet().toArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }
}
