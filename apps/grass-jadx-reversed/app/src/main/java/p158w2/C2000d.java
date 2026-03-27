package p158w2;

import com.facebook.C1110g;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: w2.d */
/* JADX INFO: loaded from: classes.dex */
public final class C2000d {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* JADX INFO: renamed from: a */
    public final int f7142a;

    /* JADX INFO: renamed from: b */
    public final boolean f7143b;

    /* JADX INFO: renamed from: c */
    public final int f7144c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ AtomicReferenceArray f7145d;

    /* JADX INFO: renamed from: g */
    public static final C1110g f7141g = new C1110g(1, "REMOVE_FROZEN");

    /* JADX INFO: renamed from: e */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7139e = AtomicReferenceFieldUpdater.newUpdater(C2000d.class, Object.class, "_next");

    /* JADX INFO: renamed from: f */
    public static final /* synthetic */ AtomicLongFieldUpdater f7140f = AtomicLongFieldUpdater.newUpdater(C2000d.class, "_state");

    public C2000d(int i3, boolean z3) {
        this.f7142a = i3;
        this.f7143b = z3;
        int i4 = i3 - 1;
        this.f7144c = i4;
        this.f7145d = new AtomicReferenceArray(i3);
        if (i4 > 1073741823) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if ((i3 & i4) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        return 1;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m4452a(java.lang.Object r14) {
        /*
            r13 = this;
        L0:
            long r2 = r13._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L15
            r4 = 2305843009213693952(0x2000000000000000, double:1.4916681462400413E-154)
            long r2 = r2 & r4
            int r14 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r14 == 0) goto L14
            r1 = 2
        L14:
            return r1
        L15:
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            int r0 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r8 = 30
            long r4 = r4 >> r8
            int r9 = (int) r4
            int r10 = r13.f7144c
            int r4 = r9 + 2
            r4 = r4 & r10
            r5 = r0 & r10
            if (r4 != r5) goto L2e
            return r1
        L2e:
            boolean r4 = r13.f7143b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r13.f7145d
            r11 = r9 & r10
            java.lang.Object r4 = r4.get(r11)
            if (r4 == 0) goto L4d
            int r2 = r13.f7142a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L4c
            int r9 = r9 - r0
            r0 = r9 & r5
            int r2 = r2 >> 1
            if (r0 <= r2) goto L0
        L4c:
            return r1
        L4d:
            int r0 = r9 + 1
            r0 = r0 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = p158w2.C2000d.f7140f
            r4 = -1152921503533105153(0xf00000003fffffff, double:-3.1050369248997324E231)
            long r4 = r4 & r2
            long r11 = (long) r0
            long r11 = r11 << r8
            long r4 = r4 | r11
            r0 = r1
            r1 = r13
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f7145d
            r1 = r9 & r10
            r0.set(r1, r14)
            r0 = r13
        L6b:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 != 0) goto L75
            goto L93
        L75:
            w2.d r0 = r0.m4456e()
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r0.f7145d
            int r2 = r0.f7144c
            r2 = r2 & r9
            java.lang.Object r3 = r1.get(r2)
            boolean r4 = r3 instanceof p158w2.C1999c
            if (r4 == 0) goto L90
            w2.c r3 = (p158w2.C1999c) r3
            int r3 = r3.f7138a
            if (r3 != r9) goto L90
            r1.set(r2, r14)
            goto L91
        L90:
            r0 = 0
        L91:
            if (r0 != 0) goto L6b
        L93:
            r14 = 0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: p158w2.C2000d.m4452a(java.lang.Object):int");
    }

    /* JADX INFO: renamed from: b */
    public final boolean m4453b() {
        long j2;
        do {
            j2 = this._state;
            if ((j2 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j2) != 0) {
                return false;
            }
        } while (!f7140f.compareAndSet(this, j2, j2 | 2305843009213693952L));
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final int m4454c() {
        long j2 = this._state;
        return (((int) ((j2 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j2))) & 1073741823;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m4455d() {
        long j2 = this._state;
        return ((int) (1073741823 & j2)) == ((int) ((j2 & 1152921503533105152L) >> 30));
    }

    /* JADX INFO: renamed from: e */
    public final C2000d m4456e() {
        long j2;
        while (true) {
            j2 = this._state;
            if ((j2 & 1152921504606846976L) != 0) {
                break;
            }
            long j3 = j2 | 1152921504606846976L;
            if (f7140f.compareAndSet(this, j2, j3)) {
                j2 = j3;
                break;
            }
        }
        while (true) {
            C2000d c2000d = (C2000d) this._next;
            if (c2000d != null) {
                return c2000d;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7139e;
            C2000d c2000d2 = new C2000d(this.f7142a * 2, this.f7143b);
            int i3 = (int) (1073741823 & j2);
            int i4 = (int) ((1152921503533105152L & j2) >> 30);
            while (true) {
                int i5 = this.f7144c;
                int i6 = i3 & i5;
                if (i6 == (i5 & i4)) {
                    break;
                }
                Object c1999c = this.f7145d.get(i6);
                if (c1999c == null) {
                    c1999c = new C1999c(i3);
                }
                c2000d2.f7145d.set(c2000d2.f7144c & i3, c1999c);
                i3++;
            }
            c2000d2._state = (-1152921504606846977L) & j2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, c2000d2) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final Object m4457f() {
        while (true) {
            long j2 = this._state;
            if ((j2 & 1152921504606846976L) != 0) {
                return f7141g;
            }
            int i3 = (int) (j2 & 1073741823);
            int i4 = this.f7144c;
            int i5 = ((int) ((1152921503533105152L & j2) >> 30)) & i4;
            int i6 = i4 & i3;
            if (i5 == i6) {
                return null;
            }
            Object obj = this.f7145d.get(i6);
            if (obj == null) {
                if (this.f7143b) {
                    return null;
                }
            } else {
                if (obj instanceof C1999c) {
                    return null;
                }
                long j3 = (i3 + 1) & 1073741823;
                if (f7140f.compareAndSet(this, j2, (j2 & (-1073741824)) | j3)) {
                    this.f7145d.set(this.f7144c & i3, null);
                    return obj;
                }
                if (this.f7143b) {
                    C2000d c2000dM4456e = this;
                    while (true) {
                        long j4 = c2000dM4456e._state;
                        int i7 = (int) (j4 & 1073741823);
                        if ((j4 & 1152921504606846976L) != 0) {
                            c2000dM4456e = c2000dM4456e.m4456e();
                        } else {
                            if (f7140f.compareAndSet(c2000dM4456e, j4, (j4 & (-1073741824)) | j3)) {
                                c2000dM4456e.f7145d.set(c2000dM4456e.f7144c & i7, null);
                                c2000dM4456e = null;
                            } else {
                                continue;
                            }
                        }
                        if (c2000dM4456e == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
