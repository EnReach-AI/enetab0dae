package p039M0;

/* JADX INFO: renamed from: M0.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0500o {

    /* JADX INFO: renamed from: c */
    public static final C0500o f1154c = new C0500o(0, 0);

    /* JADX INFO: renamed from: a */
    public final int f1155a;

    /* JADX INFO: renamed from: b */
    public final int f1156b;

    public C0500o(int i3, int i4) {
        this.f1155a = i3;
        this.f1156b = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C0500o.class) {
            return false;
        }
        C0500o c0500o = (C0500o) obj;
        return c0500o.f1155a == this.f1155a && c0500o.f1156b == this.f1156b;
    }

    public final int hashCode() {
        return this.f1156b + this.f1155a;
    }

    public final String toString() {
        return this == f1154c ? "EMPTY" : String.format("(enabled=0x%x,disabled=0x%x)", Integer.valueOf(this.f1155a), Integer.valueOf(this.f1156b));
    }
}
