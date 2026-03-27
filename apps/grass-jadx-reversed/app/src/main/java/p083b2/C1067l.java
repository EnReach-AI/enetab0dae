package p083b2;

import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1067l implements Comparable {

    /* JADX INFO: renamed from: e */
    public final byte f3749e;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return AbstractC1766e.m3921f(this.f3749e & 255, ((C1067l) obj).f3749e & 255);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1067l) {
            return this.f3749e == ((C1067l) obj).f3749e;
        }
        return false;
    }

    public final int hashCode() {
        return Byte.hashCode(this.f3749e);
    }

    public final String toString() {
        return String.valueOf(this.f3749e & 255);
    }
}
