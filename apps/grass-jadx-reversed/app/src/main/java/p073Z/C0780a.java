package p073Z;

/* JADX INFO: renamed from: Z.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0780a {

    /* JADX INFO: renamed from: a */
    public int f2224a;

    /* JADX INFO: renamed from: b */
    public int f2225b;

    /* JADX INFO: renamed from: c */
    public Object f2226c;

    /* JADX INFO: renamed from: d */
    public int f2227d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0780a.class != obj.getClass()) {
            return false;
        }
        C0780a c0780a = (C0780a) obj;
        int i3 = this.f2224a;
        if (i3 != c0780a.f2224a) {
            return false;
        }
        if (i3 == 8 && Math.abs(this.f2227d - this.f2225b) == 1 && this.f2227d == c0780a.f2225b && this.f2225b == c0780a.f2227d) {
            return true;
        }
        if (this.f2227d != c0780a.f2227d || this.f2225b != c0780a.f2225b) {
            return false;
        }
        Object obj2 = this.f2226c;
        if (obj2 != null) {
            if (!obj2.equals(c0780a.f2226c)) {
                return false;
            }
        } else if (c0780a.f2226c != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f2224a * 31) + this.f2225b) * 31) + this.f2227d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i3 = this.f2224a;
        sb.append(i3 != 1 ? i3 != 2 ? i3 != 4 ? i3 != 8 ? "??" : "mv" : "up" : "rm" : "add");
        sb.append(",s:");
        sb.append(this.f2225b);
        sb.append("c:");
        sb.append(this.f2227d);
        sb.append(",p:");
        sb.append(this.f2226c);
        sb.append("]");
        return sb.toString();
    }
}
