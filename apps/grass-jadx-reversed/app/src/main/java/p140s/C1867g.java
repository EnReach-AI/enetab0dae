package p140s;

import java.util.ArrayList;
import p136r.C1846e;
import p143t.C1903b;
import p147u.C1929e;

/* JADX INFO: renamed from: s.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1867g extends AbstractC1869i {

    /* JADX INFO: renamed from: A0 */
    public float f6550A0;

    /* JADX INFO: renamed from: B0 */
    public float f6551B0;

    /* JADX INFO: renamed from: C0 */
    public int f6552C0;

    /* JADX INFO: renamed from: D0 */
    public int f6553D0;

    /* JADX INFO: renamed from: E0 */
    public int f6554E0;

    /* JADX INFO: renamed from: F0 */
    public int f6555F0;

    /* JADX INFO: renamed from: G0 */
    public int f6556G0;

    /* JADX INFO: renamed from: H0 */
    public int f6557H0;

    /* JADX INFO: renamed from: I0 */
    public int f6558I0;

    /* JADX INFO: renamed from: J0 */
    public ArrayList f6559J0;

    /* JADX INFO: renamed from: K0 */
    public C1864d[] f6560K0;

    /* JADX INFO: renamed from: L0 */
    public C1864d[] f6561L0;

    /* JADX INFO: renamed from: M0 */
    public int[] f6562M0;

    /* JADX INFO: renamed from: N0 */
    public C1864d[] f6563N0;

    /* JADX INFO: renamed from: O0 */
    public int f6564O0;

    /* JADX INFO: renamed from: f0 */
    public int f6565f0;

    /* JADX INFO: renamed from: g0 */
    public int f6566g0;

    /* JADX INFO: renamed from: h0 */
    public int f6567h0;

    /* JADX INFO: renamed from: i0 */
    public int f6568i0;

    /* JADX INFO: renamed from: j0 */
    public int f6569j0;

    /* JADX INFO: renamed from: k0 */
    public int f6570k0;

    /* JADX INFO: renamed from: l0 */
    public boolean f6571l0;

    /* JADX INFO: renamed from: m0 */
    public int f6572m0;

    /* JADX INFO: renamed from: n0 */
    public int f6573n0;

    /* JADX INFO: renamed from: o0 */
    public C1903b f6574o0;

    /* JADX INFO: renamed from: p0 */
    public C1929e f6575p0;

    /* JADX INFO: renamed from: q0 */
    public int f6576q0;

    /* JADX INFO: renamed from: r0 */
    public int f6577r0;

    /* JADX INFO: renamed from: s0 */
    public int f6578s0;

    /* JADX INFO: renamed from: t0 */
    public int f6579t0;

    /* JADX INFO: renamed from: u0 */
    public int f6580u0;

    /* JADX INFO: renamed from: v0 */
    public int f6581v0;

    /* JADX INFO: renamed from: w0 */
    public float f6582w0;

    /* JADX INFO: renamed from: x0 */
    public float f6583x0;

    /* JADX INFO: renamed from: y0 */
    public float f6584y0;

    /* JADX INFO: renamed from: z0 */
    public float f6585z0;

    @Override // p140s.AbstractC1869i
    /* JADX INFO: renamed from: B */
    public final void mo4181B() {
        for (int i3 = 0; i3 < this.f6592e0; i3++) {
            C1864d c1864d = this.f6591d0[i3];
        }
    }

    /* JADX INFO: renamed from: C */
    public final int m4182C(C1864d c1864d, int i3) {
        if (c1864d == null) {
            return 0;
        }
        int[] iArr = c1864d.f6493c0;
        if (iArr[1] == 3) {
            int i4 = c1864d.f6501k;
            if (i4 == 0) {
                return 0;
            }
            if (i4 == 2) {
                int i5 = (int) (c1864d.f6508r * i3);
                if (i5 != c1864d.m4153i()) {
                    m4184E(iArr[0], c1864d.m4156l(), 1, i5, c1864d);
                }
                return i5;
            }
            if (i4 == 1) {
                return c1864d.m4153i();
            }
            if (i4 == 3) {
                return (int) ((c1864d.m4156l() * c1864d.f6473L) + 0.5f);
            }
        }
        return c1864d.m4153i();
    }

    /* JADX INFO: renamed from: D */
    public final int m4183D(C1864d c1864d, int i3) {
        if (c1864d == null) {
            return 0;
        }
        int[] iArr = c1864d.f6493c0;
        if (iArr[0] == 3) {
            int i4 = c1864d.f6500j;
            if (i4 == 0) {
                return 0;
            }
            if (i4 == 2) {
                int i5 = (int) (c1864d.f6505o * i3);
                if (i5 != c1864d.m4156l()) {
                    m4184E(1, i5, iArr[1], c1864d.m4153i(), c1864d);
                }
                return i5;
            }
            if (i4 == 1) {
                return c1864d.m4156l();
            }
            if (i4 == 3) {
                return (int) ((c1864d.m4153i() * c1864d.f6473L) + 0.5f);
            }
        }
        return c1864d.m4156l();
    }

    /* JADX INFO: renamed from: E */
    public final void m4184E(int i3, int i4, int i5, int i6, C1864d c1864d) {
        C1929e c1929e;
        C1864d c1864d2;
        while (true) {
            c1929e = this.f6575p0;
            if (c1929e != null || (c1864d2 = this.f6470I) == null) {
                break;
            } else {
                this.f6575p0 = ((C1865e) c1864d2).f6520g0;
            }
        }
        C1903b c1903b = this.f6574o0;
        c1903b.f6648a = i3;
        c1903b.f6649b = i5;
        c1903b.f6650c = i4;
        c1903b.f6651d = i6;
        c1929e.m4326a(c1864d, c1903b);
        c1864d.m4169y(c1903b.f6652e);
        c1864d.m4166v(c1903b.f6653f);
        c1864d.f6513w = c1903b.f6655h;
        int i7 = c1903b.f6654g;
        c1864d.f6477P = i7;
        c1864d.f6513w = i7 > 0;
    }

    @Override // p140s.C1864d
    /* JADX INFO: renamed from: a */
    public final void mo4135a(C1846e c1846e) {
        C1864d c1864d;
        super.mo4135a(c1846e);
        C1864d c1864d2 = this.f6470I;
        boolean z3 = c1864d2 != null ? ((C1865e) c1864d2).f6521h0 : false;
        int i3 = this.f6556G0;
        ArrayList arrayList = this.f6559J0;
        if (i3 != 0) {
            if (i3 == 1) {
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    ((C1866f) arrayList.get(i4)).m4176b(i4, z3, i4 == size + (-1));
                    i4++;
                }
            } else if (i3 == 2 && this.f6562M0 != null && this.f6561L0 != null && this.f6560K0 != null) {
                for (int i5 = 0; i5 < this.f6564O0; i5++) {
                    this.f6563N0[i5].m4164t();
                }
                int[] iArr = this.f6562M0;
                int i6 = iArr[0];
                int i7 = iArr[1];
                C1864d c1864d3 = null;
                for (int i8 = 0; i8 < i6; i8++) {
                    C1864d c1864d4 = this.f6561L0[z3 ? (i6 - i8) - 1 : i8];
                    if (c1864d4 != null && c1864d4.f6483V != 8) {
                        C1863c c1863c = c1864d4.f6514x;
                        if (i8 == 0) {
                            c1864d4.m4149e(c1863c, this.f6514x, this.f6569j0);
                            c1864d4.f6485X = this.f6576q0;
                            c1864d4.f6480S = this.f6582w0;
                        }
                        if (i8 == i6 - 1) {
                            c1864d4.m4149e(c1864d4.f6516z, this.f6516z, this.f6570k0);
                        }
                        if (i8 > 0) {
                            c1864d4.m4149e(c1863c, c1864d3.f6516z, this.f6552C0);
                            c1864d3.m4149e(c1864d3.f6516z, c1863c, 0);
                        }
                        c1864d3 = c1864d4;
                    }
                }
                for (int i9 = 0; i9 < i7; i9++) {
                    C1864d c1864d5 = this.f6560K0[i9];
                    if (c1864d5 != null && c1864d5.f6483V != 8) {
                        C1863c c1863c2 = c1864d5.f6515y;
                        if (i9 == 0) {
                            c1864d5.m4149e(c1863c2, this.f6515y, this.f6565f0);
                            c1864d5.f6486Y = this.f6577r0;
                            c1864d5.f6481T = this.f6583x0;
                        }
                        if (i9 == i7 - 1) {
                            c1864d5.m4149e(c1864d5.f6462A, this.f6462A, this.f6566g0);
                        }
                        if (i9 > 0) {
                            c1864d5.m4149e(c1863c2, c1864d3.f6462A, this.f6553D0);
                            c1864d3.m4149e(c1864d3.f6462A, c1863c2, 0);
                        }
                        c1864d3 = c1864d5;
                    }
                }
                for (int i10 = 0; i10 < i6; i10++) {
                    for (int i11 = 0; i11 < i7; i11++) {
                        int i12 = (i11 * i6) + i10;
                        if (this.f6558I0 == 1) {
                            i12 = (i10 * i7) + i11;
                        }
                        C1864d[] c1864dArr = this.f6563N0;
                        if (i12 < c1864dArr.length && (c1864d = c1864dArr[i12]) != null && c1864d.f6483V != 8) {
                            C1864d c1864d6 = this.f6561L0[i10];
                            C1864d c1864d7 = this.f6560K0[i11];
                            if (c1864d != c1864d6) {
                                c1864d.m4149e(c1864d.f6514x, c1864d6.f6514x, 0);
                                c1864d.m4149e(c1864d.f6516z, c1864d6.f6516z, 0);
                            }
                            if (c1864d != c1864d7) {
                                c1864d.m4149e(c1864d.f6515y, c1864d7.f6515y, 0);
                                c1864d.m4149e(c1864d.f6462A, c1864d7.f6462A, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((C1866f) arrayList.get(0)).m4176b(0, z3, true);
        }
        this.f6571l0 = false;
    }
}
