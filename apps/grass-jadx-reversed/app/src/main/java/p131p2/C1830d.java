package p131p2;

import java.util.Iterator;
import p125o0.AbstractC1794d;

/* JADX INFO: renamed from: p2.d */
/* JADX INFO: loaded from: classes.dex */
public class C1830d implements Iterable {

    /* JADX INFO: renamed from: e */
    public final int f6338e;

    /* JADX INFO: renamed from: f */
    public final int f6339f;

    /* JADX INFO: renamed from: g */
    public final int f6340g;

    public C1830d(int i3, int i4, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i5 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f6338e = i3;
        this.f6339f = AbstractC1794d.m3950f(i3, i4, i5);
        this.f6340g = i5;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1830d) {
            if (!isEmpty() || !((C1830d) obj).isEmpty()) {
                C1830d c1830d = (C1830d) obj;
                if (this.f6338e != c1830d.f6338e || this.f6339f != c1830d.f6339f || this.f6340g != c1830d.f6340g) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f6338e * 31) + this.f6339f) * 31) + this.f6340g;
    }

    public boolean isEmpty() {
        int i3 = this.f6340g;
        int i4 = this.f6339f;
        int i5 = this.f6338e;
        if (i3 > 0) {
            if (i5 <= i4) {
                return false;
            }
        } else if (i5 >= i4) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C1831e(this.f6338e, this.f6339f, this.f6340g);
    }

    public String toString() {
        StringBuilder sb;
        int i3 = this.f6339f;
        int i4 = this.f6338e;
        int i5 = this.f6340g;
        if (i5 > 0) {
            sb = new StringBuilder();
            sb.append(i4);
            sb.append("..");
            sb.append(i3);
            sb.append(" step ");
            sb.append(i5);
        } else {
            sb = new StringBuilder();
            sb.append(i4);
            sb.append(" downTo ");
            sb.append(i3);
            sb.append(" step ");
            sb.append(-i5);
        }
        return sb.toString();
    }
}
