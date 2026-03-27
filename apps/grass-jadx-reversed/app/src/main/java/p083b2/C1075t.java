package p083b2;

import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.t */
/* JADX INFO: loaded from: classes.dex */
public final class C1075t implements Comparable {

    /* JADX INFO: renamed from: e */
    public final short f3759e;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return AbstractC1766e.m3921f(this.f3759e & 65535, ((C1075t) obj).f3759e & 65535);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1075t) {
            return this.f3759e == ((C1075t) obj).f3759e;
        }
        return false;
    }

    public final int hashCode() {
        return Short.hashCode(this.f3759e);
    }

    public final String toString() {
        return String.valueOf(65535 & this.f3759e);
    }
}
