package p011C2;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import p086c2.AbstractC1085d;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2016e;

/* JADX INFO: renamed from: C2.u */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC2016e(with = C0170w.class)
public final class C0168u extends AbstractC0156i implements Map<String, AbstractC0156i> {
    public static final C0167t Companion = new C0167t();

    /* JADX INFO: renamed from: e */
    public final Map f401e;

    public C0168u(Map map) {
        AbstractC1766e.m3920e("content", map);
        this.f401e = map;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ AbstractC0156i compute(String str, BiFunction<? super String, ? super AbstractC0156i, ? extends AbstractC0156i> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ AbstractC0156i computeIfAbsent(String str, Function<? super String, ? extends AbstractC0156i> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ AbstractC0156i computeIfPresent(String str, BiFunction<? super String, ? super AbstractC0156i, ? extends AbstractC0156i> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String str = (String) obj;
        AbstractC1766e.m3920e("key", str);
        return this.f401e.containsKey(str);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (!(obj instanceof AbstractC0156i)) {
            return false;
        }
        AbstractC0156i abstractC0156i = (AbstractC0156i) obj;
        AbstractC1766e.m3920e("value", abstractC0156i);
        return this.f401e.containsValue(abstractC0156i);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, AbstractC0156i>> entrySet() {
        return this.f401e.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return AbstractC1766e.m3916a(this.f401e, obj);
    }

    @Override // java.util.Map
    public final AbstractC0156i get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        AbstractC1766e.m3920e("key", str);
        return (AbstractC0156i) this.f401e.get(str);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f401e.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f401e.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f401e.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ AbstractC0156i merge(String str, AbstractC0156i abstractC0156i, BiFunction<? super AbstractC0156i, ? super AbstractC0156i, ? extends AbstractC0156i> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ AbstractC0156i put(String str, AbstractC0156i abstractC0156i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends AbstractC0156i> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ AbstractC0156i putIfAbsent(String str, AbstractC0156i abstractC0156i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final AbstractC0156i remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ AbstractC0156i replace(String str, AbstractC0156i abstractC0156i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super AbstractC0156i, ? extends AbstractC0156i> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f401e.size();
    }

    public final String toString() {
        return AbstractC1085d.m2834x(this.f401e.entrySet(), ",", "{", "}", C0159l.f388h, 24);
    }

    @Override // java.util.Map
    public final Collection<AbstractC0156i> values() {
        return this.f401e.values();
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String str, AbstractC0156i abstractC0156i, AbstractC0156i abstractC0156i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
