package p140s;

import p005B.AbstractC0032g;
import p136r.AbstractC1849h;
import p136r.C1844c;
import p136r.C1846e;
import p136r.C1850i;

/* JADX INFO: renamed from: s.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1861a extends AbstractC1869i {

    /* JADX INFO: renamed from: f0 */
    public int f6435f0;

    /* JADX INFO: renamed from: g0 */
    public boolean f6436g0;

    /* JADX INFO: renamed from: h0 */
    public int f6437h0;

    @Override // p140s.C1864d
    /* JADX INFO: renamed from: a */
    public final void mo4135a(C1846e c1846e) {
        boolean z3;
        int i3;
        int i4;
        C1863c[] c1863cArr = this.f6467F;
        C1863c c1863c = this.f6514x;
        c1863cArr[0] = c1863c;
        C1863c c1863c2 = this.f6515y;
        int i5 = 2;
        c1863cArr[2] = c1863c2;
        C1863c c1863c3 = this.f6516z;
        c1863cArr[1] = c1863c3;
        C1863c c1863c4 = this.f6462A;
        c1863cArr[3] = c1863c4;
        for (C1863c c1863c5 : c1863cArr) {
            c1863c5.f6461g = c1846e.m4107j(c1863c5);
        }
        int i6 = this.f6435f0;
        if (i6 < 0 || i6 >= 4) {
            return;
        }
        C1863c c1863c6 = c1863cArr[i6];
        for (int i7 = 0; i7 < this.f6592e0; i7++) {
            C1864d c1864d = this.f6591d0[i7];
            if ((this.f6436g0 || c1864d.mo4136b()) && ((((i4 = this.f6435f0) == 0 || i4 == 1) && c1864d.f6493c0[0] == 3 && c1864d.f6514x.f6458d != null && c1864d.f6516z.f6458d != null) || ((i4 == 2 || i4 == 3) && c1864d.f6493c0[1] == 3 && c1864d.f6515y.f6458d != null && c1864d.f6462A.f6458d != null))) {
                z3 = true;
                break;
            }
        }
        z3 = false;
        boolean z4 = c1863c.m4141e() || c1863c3.m4141e();
        boolean z5 = c1863c2.m4141e() || c1863c4.m4141e();
        int i8 = (z3 || !(((i3 = this.f6435f0) == 0 && z4) || ((i3 == 2 && z5) || ((i3 == 1 && z4) || (i3 == 3 && z5))))) ? 4 : 5;
        int i9 = 0;
        while (i9 < this.f6592e0) {
            C1864d c1864d2 = this.f6591d0[i9];
            if (this.f6436g0 || c1864d2.mo4136b()) {
                C1850i c1850iM4107j = c1846e.m4107j(c1864d2.f6467F[this.f6435f0]);
                int i10 = this.f6435f0;
                C1863c c1863c7 = c1864d2.f6467F[i10];
                c1863c7.f6461g = c1850iM4107j;
                C1863c c1863c8 = c1863c7.f6458d;
                int i11 = (c1863c8 == null || c1863c8.f6456b != this) ? 0 : c1863c7.f6459e;
                if (i10 == 0 || i10 == i5) {
                    C1850i c1850i = c1863c6.f6461g;
                    int i12 = this.f6437h0 - i11;
                    C1844c c1844cM4108k = c1846e.m4108k();
                    C1850i c1850iM4109l = c1846e.m4109l();
                    c1850iM4109l.f6402d = 0;
                    c1844cM4108k.m4091c(c1850i, c1850iM4107j, c1850iM4109l, i12);
                    c1846e.m4100c(c1844cM4108k);
                } else {
                    C1850i c1850i2 = c1863c6.f6461g;
                    int i13 = this.f6437h0 + i11;
                    C1844c c1844cM4108k2 = c1846e.m4108k();
                    C1850i c1850iM4109l2 = c1846e.m4109l();
                    c1850iM4109l2.f6402d = 0;
                    c1844cM4108k2.m4090b(c1850i2, c1850iM4107j, c1850iM4109l2, i13);
                    c1846e.m4100c(c1844cM4108k2);
                }
                c1846e.m4102e(c1863c6.f6461g, c1850iM4107j, this.f6437h0 + i11, i8);
            }
            i9++;
            i5 = 2;
        }
        int i14 = this.f6435f0;
        if (i14 == 0) {
            c1846e.m4102e(c1863c3.f6461g, c1863c.f6461g, 0, 8);
            c1846e.m4102e(c1863c.f6461g, this.f6470I.f6516z.f6461g, 0, 4);
            c1846e.m4102e(c1863c.f6461g, this.f6470I.f6514x.f6461g, 0, 0);
            return;
        }
        if (i14 == 1) {
            c1846e.m4102e(c1863c.f6461g, c1863c3.f6461g, 0, 8);
            c1846e.m4102e(c1863c.f6461g, this.f6470I.f6514x.f6461g, 0, 4);
            c1846e.m4102e(c1863c.f6461g, this.f6470I.f6516z.f6461g, 0, 0);
        } else if (i14 == 2) {
            c1846e.m4102e(c1863c4.f6461g, c1863c2.f6461g, 0, 8);
            c1846e.m4102e(c1863c2.f6461g, this.f6470I.f6462A.f6461g, 0, 4);
            c1846e.m4102e(c1863c2.f6461g, this.f6470I.f6515y.f6461g, 0, 0);
        } else if (i14 == 3) {
            c1846e.m4102e(c1863c2.f6461g, c1863c4.f6461g, 0, 8);
            c1846e.m4102e(c1863c2.f6461g, this.f6470I.f6515y.f6461g, 0, 4);
            c1846e.m4102e(c1863c2.f6461g, this.f6470I.f6462A.f6461g, 0, 0);
        }
    }

    @Override // p140s.C1864d
    /* JADX INFO: renamed from: b */
    public final boolean mo4136b() {
        return true;
    }

    @Override // p140s.C1864d
    public final String toString() {
        String strM157o = AbstractC0032g.m157o(new StringBuilder("[Barrier] "), this.f6484W, " {");
        for (int i3 = 0; i3 < this.f6592e0; i3++) {
            C1864d c1864d = this.f6591d0[i3];
            if (i3 > 0) {
                strM157o = AbstractC1849h.m4117a(strM157o, ", ");
            }
            strM157o = strM157o + c1864d.f6484W;
        }
        return AbstractC1849h.m4117a(strM157o, "}");
    }
}
