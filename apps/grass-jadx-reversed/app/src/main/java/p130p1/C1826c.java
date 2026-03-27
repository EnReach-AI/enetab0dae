package p130p1;

import android.animation.TimeInterpolator;

/* JADX INFO: renamed from: p1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1826c {

    /* JADX INFO: renamed from: a */
    public long f6326a;

    /* JADX INFO: renamed from: b */
    public long f6327b;

    /* JADX INFO: renamed from: c */
    public TimeInterpolator f6328c;

    /* JADX INFO: renamed from: d */
    public int f6329d;

    /* JADX INFO: renamed from: e */
    public int f6330e;

    /* JADX INFO: renamed from: a */
    public final TimeInterpolator m4072a() {
        TimeInterpolator timeInterpolator = this.f6328c;
        return timeInterpolator != null ? timeInterpolator : AbstractC1824a.f6321b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1826c)) {
            return false;
        }
        C1826c c1826c = (C1826c) obj;
        if (this.f6326a == c1826c.f6326a && this.f6327b == c1826c.f6327b && this.f6329d == c1826c.f6329d && this.f6330e == c1826c.f6330e) {
            return m4072a().getClass().equals(c1826c.m4072a().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f6326a;
        long j3 = this.f6327b;
        return ((((m4072a().getClass().hashCode() + (((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31)) * 31) + this.f6329d) * 31) + this.f6330e;
    }

    public final String toString() {
        return "\n" + C1826c.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.f6326a + " duration: " + this.f6327b + " interpolator: " + m4072a().getClass() + " repeatCount: " + this.f6329d + " repeatMode: " + this.f6330e + "}\n";
    }
}
