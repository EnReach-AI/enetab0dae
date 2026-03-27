package p086c2;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: c2.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1094m implements Map, Serializable {

    /* JADX INFO: renamed from: e */
    public static final C1094m f3783e = new C1094m();
    private static final long serialVersionUID = 8246714829545688274L;

    private final Object readResolve() {
        return f3783e;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        AbstractC1766e.m3920e("value", (Void) obj);
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return C1095n.f3784e;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return null;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return C1095n.f3784e;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return 0;
    }

    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return C1093l.f3782e;
    }
}
