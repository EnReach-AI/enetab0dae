package p131p2;

import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: p2.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1829c extends AbstractC1827a {
    static {
        new C1829c((char) 1, (char) 0);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m4073a(char c3) {
        return AbstractC1766e.m3921f(this.f6331e, c3) <= 0 && AbstractC1766e.m3921f(c3, this.f6332f) <= 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1829c) {
            char c3 = this.f6331e;
            char c4 = this.f6332f;
            if (AbstractC1766e.m3921f(c3, c4) > 0) {
                C1829c c1829c = (C1829c) obj;
                if (AbstractC1766e.m3921f(c1829c.f6331e, c1829c.f6332f) <= 0) {
                }
                return true;
            }
            C1829c c1829c2 = (C1829c) obj;
            if (c3 == c1829c2.f6331e && c4 == c1829c2.f6332f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        char c3 = this.f6331e;
        char c4 = this.f6332f;
        if (AbstractC1766e.m3921f(c3, c4) > 0) {
            return -1;
        }
        return (c3 * 31) + c4;
    }

    public final String toString() {
        return this.f6331e + ".." + this.f6332f;
    }
}
