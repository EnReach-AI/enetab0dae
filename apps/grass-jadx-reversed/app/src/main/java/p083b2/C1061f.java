package p083b2;

import java.io.Serializable;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1061f implements Serializable {

    /* JADX INFO: renamed from: e */
    public final Object f3736e;

    /* JADX INFO: renamed from: f */
    public final Object f3737f;

    public C1061f(Object obj, Object obj2) {
        this.f3736e = obj;
        this.f3737f = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1061f)) {
            return false;
        }
        C1061f c1061f = (C1061f) obj;
        return AbstractC1766e.m3916a(this.f3736e, c1061f.f3736e) && AbstractC1766e.m3916a(this.f3737f, c1061f.f3737f);
    }

    public final int hashCode() {
        Object obj = this.f3736e;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f3737f;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f3736e + ", " + this.f3737f + ')';
    }
}
