package p083b2;

import java.io.Serializable;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1066k implements Serializable {

    /* JADX INFO: renamed from: e */
    public final Object f3746e;

    /* JADX INFO: renamed from: f */
    public final Object f3747f;

    /* JADX INFO: renamed from: g */
    public final Object f3748g;

    public C1066k(Object obj, Object obj2, Object obj3) {
        this.f3746e = obj;
        this.f3747f = obj2;
        this.f3748g = obj3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1066k)) {
            return false;
        }
        C1066k c1066k = (C1066k) obj;
        return AbstractC1766e.m3916a(this.f3746e, c1066k.f3746e) && AbstractC1766e.m3916a(this.f3747f, c1066k.f3747f) && AbstractC1766e.m3916a(this.f3748g, c1066k.f3748g);
    }

    public final int hashCode() {
        Object obj = this.f3746e;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f3747f;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f3748g;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f3746e + ", " + this.f3747f + ", " + this.f3748g + ')';
    }
}
