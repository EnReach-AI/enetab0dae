package p026I;

/* JADX INFO: renamed from: I.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0295c {

    /* JADX INFO: renamed from: a */
    public final Object f793a;

    /* JADX INFO: renamed from: b */
    public final Object f794b;

    public C0295c(Object obj, Object obj2) {
        this.f793a = obj;
        this.f794b = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0295c)) {
            return false;
        }
        C0295c c0295c = (C0295c) obj;
        return AbstractC0294b.m569a(c0295c.f793a, this.f793a) && AbstractC0294b.m569a(c0295c.f794b, this.f794b);
    }

    public final int hashCode() {
        Object obj = this.f793a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f794b;
        return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "Pair{" + this.f793a + " " + this.f794b + "}";
    }
}
