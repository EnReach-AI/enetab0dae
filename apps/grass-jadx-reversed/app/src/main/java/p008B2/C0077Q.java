package p008B2;

import java.util.Map;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.Q */
/* JADX INFO: loaded from: classes.dex */
public final class C0077Q implements Map.Entry {

    /* JADX INFO: renamed from: e */
    public final Object f241e;

    /* JADX INFO: renamed from: f */
    public final Object f242f;

    public C0077Q(Object obj, Object obj2) {
        this.f241e = obj;
        this.f242f = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0077Q)) {
            return false;
        }
        C0077Q c0077q = (C0077Q) obj;
        return AbstractC1766e.m3916a(this.f241e, c0077q.f241e) && AbstractC1766e.m3916a(this.f242f, c0077q.f242f);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f241e;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f242f;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f241e;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f242f;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final String toString() {
        return "MapEntry(key=" + this.f241e + ", value=" + this.f242f + ')';
    }
}
