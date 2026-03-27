package p128p;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: p.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1808b extends C1817k implements Map {

    /* JADX INFO: renamed from: l */
    public C1807a f6256l;

    public C1808b(C1817k c1817k) {
        int i3 = c1817k.f6297g;
        m4034b(i3);
        if (this.f6297g != 0) {
            for (int i4 = 0; i4 < i3; i4++) {
                put(c1817k.m4039h(i4), c1817k.m4041j(i4));
            }
        } else if (i3 > 0) {
            System.arraycopy(c1817k.f6295e, 0, this.f6295e, 0, i3);
            System.arraycopy(c1817k.f6296f, 0, this.f6296f, 0, i3 << 1);
            this.f6297g = i3;
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.f6256l == null) {
            this.f6256l = new C1807a(0, this);
        }
        C1807a c1807a = this.f6256l;
        if (c1807a.f6251a == null) {
            c1807a.f6251a = new C1814h(c1807a, 0);
        }
        return c1807a.f6251a;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f6256l == null) {
            this.f6256l = new C1807a(0, this);
        }
        C1807a c1807a = this.f6256l;
        if (c1807a.f6252b == null) {
            c1807a.f6252b = new C1814h(c1807a, 1);
        }
        return c1807a.f6252b;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        m4034b(map.size() + this.f6297g);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.f6256l == null) {
            this.f6256l = new C1807a(0, this);
        }
        C1807a c1807a = this.f6256l;
        if (c1807a.f6253c == null) {
            c1807a.f6253c = new C1816j(c1807a);
        }
        return c1807a.f6253c;
    }
}
