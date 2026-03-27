package p073Z;

/* JADX INFO: renamed from: Z.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0782b {

    /* JADX INFO: renamed from: a */
    public long f2230a = 0;

    /* JADX INFO: renamed from: b */
    public C0782b f2231b;

    /* JADX INFO: renamed from: a */
    public final void m2067a(int i3) {
        if (i3 < 64) {
            this.f2230a &= ~(1 << i3);
            return;
        }
        C0782b c0782b = this.f2231b;
        if (c0782b != null) {
            c0782b.m2067a(i3 - 64);
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m2068b(int i3) {
        C0782b c0782b = this.f2231b;
        if (c0782b == null) {
            return i3 >= 64 ? Long.bitCount(this.f2230a) : Long.bitCount(this.f2230a & ((1 << i3) - 1));
        }
        if (i3 < 64) {
            return Long.bitCount(this.f2230a & ((1 << i3) - 1));
        }
        return Long.bitCount(this.f2230a) + c0782b.m2068b(i3 - 64);
    }

    /* JADX INFO: renamed from: c */
    public final void m2069c() {
        if (this.f2231b == null) {
            this.f2231b = new C0782b();
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m2070d(int i3) {
        if (i3 < 64) {
            return (this.f2230a & (1 << i3)) != 0;
        }
        m2069c();
        return this.f2231b.m2070d(i3 - 64);
    }

    /* JADX INFO: renamed from: e */
    public final void m2071e(int i3, boolean z3) {
        if (i3 >= 64) {
            m2069c();
            this.f2231b.m2071e(i3 - 64, z3);
            return;
        }
        long j2 = this.f2230a;
        boolean z4 = (Long.MIN_VALUE & j2) != 0;
        long j3 = (1 << i3) - 1;
        this.f2230a = ((j2 & (~j3)) << 1) | (j2 & j3);
        if (z3) {
            m2074h(i3);
        } else {
            m2067a(i3);
        }
        if (z4 || this.f2231b != null) {
            m2069c();
            this.f2231b.m2071e(0, z4);
        }
    }

    /* JADX INFO: renamed from: f */
    public final boolean m2072f(int i3) {
        if (i3 >= 64) {
            m2069c();
            return this.f2231b.m2072f(i3 - 64);
        }
        long j2 = 1 << i3;
        long j3 = this.f2230a;
        boolean z3 = (j3 & j2) != 0;
        long j4 = j3 & (~j2);
        this.f2230a = j4;
        long j5 = j2 - 1;
        this.f2230a = (j4 & j5) | Long.rotateRight((~j5) & j4, 1);
        C0782b c0782b = this.f2231b;
        if (c0782b != null) {
            if (c0782b.m2070d(0)) {
                m2074h(63);
            }
            this.f2231b.m2072f(0);
        }
        return z3;
    }

    /* JADX INFO: renamed from: g */
    public final void m2073g() {
        this.f2230a = 0L;
        C0782b c0782b = this.f2231b;
        if (c0782b != null) {
            c0782b.m2073g();
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m2074h(int i3) {
        if (i3 < 64) {
            this.f2230a |= 1 << i3;
        } else {
            m2069c();
            this.f2231b.m2074h(i3 - 64);
        }
    }

    public final String toString() {
        if (this.f2231b == null) {
            return Long.toBinaryString(this.f2230a);
        }
        return this.f2231b.toString() + "xx" + Long.toBinaryString(this.f2230a);
    }
}
