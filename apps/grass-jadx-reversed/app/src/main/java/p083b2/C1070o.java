package p083b2;

import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1070o implements Comparable {

    /* JADX INFO: renamed from: e */
    public final int f3754e;

    public /* synthetic */ C1070o(int i3) {
        this.f3754e = i3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return AbstractC1766e.m3921f(this.f3754e ^ Integer.MIN_VALUE, ((C1070o) obj).f3754e ^ Integer.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1070o) {
            return this.f3754e == ((C1070o) obj).f3754e;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f3754e);
    }

    public final String toString() {
        return String.valueOf(((long) this.f3754e) & 4294967295L);
    }
}
