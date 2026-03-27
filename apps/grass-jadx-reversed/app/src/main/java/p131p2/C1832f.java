package p131p2;

/* JADX INFO: renamed from: p2.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1832f extends C1830d {

    /* JADX INFO: renamed from: h */
    public static final C1832f f6345h = new C1832f(1, 0, 1);

    @Override // p131p2.C1830d
    public final boolean equals(Object obj) {
        if (obj instanceof C1832f) {
            if (!isEmpty() || !((C1832f) obj).isEmpty()) {
                C1832f c1832f = (C1832f) obj;
                if (this.f6338e == c1832f.f6338e) {
                    if (this.f6339f == c1832f.f6339f) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // p131p2.C1830d
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f6338e * 31) + this.f6339f;
    }

    @Override // p131p2.C1830d
    public final boolean isEmpty() {
        return this.f6338e > this.f6339f;
    }

    @Override // p131p2.C1830d
    public final String toString() {
        return this.f6338e + ".." + this.f6339f;
    }
}
