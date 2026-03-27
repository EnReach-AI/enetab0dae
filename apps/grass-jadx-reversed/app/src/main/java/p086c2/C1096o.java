package p086c2;

import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: c2.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1096o {

    /* JADX INFO: renamed from: a */
    public final int f3785a;

    /* JADX INFO: renamed from: b */
    public final Object f3786b;

    public C1096o(int i3, Object obj) {
        this.f3785a = i3;
        this.f3786b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1096o)) {
            return false;
        }
        C1096o c1096o = (C1096o) obj;
        return this.f3785a == c1096o.f3785a && AbstractC1766e.m3916a(this.f3786b, c1096o.f3786b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f3785a) * 31;
        Object obj = this.f3786b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f3785a + ", value=" + this.f3786b + ')';
    }
}
