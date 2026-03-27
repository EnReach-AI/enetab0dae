package p128p;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: p.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1815i implements Iterator, Map.Entry {

    /* JADX INFO: renamed from: e */
    public int f6286e;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ C1807a f6289h;

    /* JADX INFO: renamed from: g */
    public boolean f6288g = false;

    /* JADX INFO: renamed from: f */
    public int f6287f = -1;

    public C1815i(C1807a c1807a) {
        this.f6289h = c1807a;
        this.f6286e = c1807a.m4009d() - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f6288g) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i3 = this.f6287f;
        C1807a c1807a = this.f6289h;
        Object objM4007b = c1807a.m4007b(i3, 0);
        if (key != objM4007b && (key == null || !key.equals(objM4007b))) {
            return false;
        }
        Object value = entry.getValue();
        Object objM4007b2 = c1807a.m4007b(this.f6287f, 1);
        return value == objM4007b2 || (value != null && value.equals(objM4007b2));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (!this.f6288g) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f6289h.m4007b(this.f6287f, 0);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (!this.f6288g) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f6289h.m4007b(this.f6287f, 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6287f < this.f6286e;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f6288g) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i3 = this.f6287f;
        C1807a c1807a = this.f6289h;
        Object objM4007b = c1807a.m4007b(i3, 0);
        Object objM4007b2 = c1807a.m4007b(this.f6287f, 1);
        return (objM4007b == null ? 0 : objM4007b.hashCode()) ^ (objM4007b2 != null ? objM4007b2.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f6287f++;
        this.f6288g = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f6288g) {
            throw new IllegalStateException();
        }
        this.f6289h.m4013h(this.f6287f);
        this.f6287f--;
        this.f6286e--;
        this.f6288g = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f6288g) {
            return this.f6289h.m4014i(this.f6287f, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
