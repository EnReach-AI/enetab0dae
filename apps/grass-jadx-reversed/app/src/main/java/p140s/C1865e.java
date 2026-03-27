package p140s;

import com.facebook.C1100C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p125o0.C1803m;
import p136r.C1844c;
import p136r.C1846e;
import p136r.C1848g;
import p136r.C1850i;
import p143t.AbstractC1914m;
import p143t.C1903b;
import p143t.C1904c;
import p143t.C1906e;
import p143t.C1911j;
import p143t.C1913l;
import p147u.C1929e;

/* JADX INFO: renamed from: s.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1865e extends C1864d {

    /* JADX INFO: renamed from: d0 */
    public ArrayList f6517d0 = new ArrayList();

    /* JADX INFO: renamed from: e0 */
    public final C1100C f6518e0 = new C1100C(this);

    /* JADX INFO: renamed from: f0 */
    public final C1906e f6519f0;

    /* JADX INFO: renamed from: g0 */
    public C1929e f6520g0;

    /* JADX INFO: renamed from: h0 */
    public boolean f6521h0;

    /* JADX INFO: renamed from: i0 */
    public final C1846e f6522i0;

    /* JADX INFO: renamed from: j0 */
    public int f6523j0;

    /* JADX INFO: renamed from: k0 */
    public int f6524k0;

    /* JADX INFO: renamed from: l0 */
    public int f6525l0;

    /* JADX INFO: renamed from: m0 */
    public int f6526m0;

    /* JADX INFO: renamed from: n0 */
    public C1862b[] f6527n0;

    /* JADX INFO: renamed from: o0 */
    public C1862b[] f6528o0;

    /* JADX INFO: renamed from: p0 */
    public int f6529p0;

    /* JADX INFO: renamed from: q0 */
    public boolean f6530q0;

    /* JADX INFO: renamed from: r0 */
    public boolean f6531r0;

    public C1865e() {
        C1906e c1906e = new C1906e();
        c1906e.f6661b = true;
        c1906e.f6662c = true;
        c1906e.f6664e = new ArrayList();
        new ArrayList();
        c1906e.f6665f = null;
        c1906e.f6666g = new C1903b();
        c1906e.f6667h = new ArrayList();
        c1906e.f6660a = this;
        c1906e.f6663d = this;
        this.f6519f0 = c1906e;
        this.f6520g0 = null;
        this.f6521h0 = false;
        this.f6522i0 = new C1846e();
        this.f6525l0 = 0;
        this.f6526m0 = 0;
        this.f6527n0 = new C1862b[4];
        this.f6528o0 = new C1862b[4];
        this.f6529p0 = 263;
        this.f6530q0 = false;
        this.f6531r0 = false;
    }

    /* JADX INFO: renamed from: B */
    public final void m4171B(C1864d c1864d, int i3) {
        if (i3 == 0) {
            int i4 = this.f6525l0 + 1;
            C1862b[] c1862bArr = this.f6528o0;
            if (i4 >= c1862bArr.length) {
                this.f6528o0 = (C1862b[]) Arrays.copyOf(c1862bArr, c1862bArr.length * 2);
            }
            C1862b[] c1862bArr2 = this.f6528o0;
            int i5 = this.f6525l0;
            c1862bArr2[i5] = new C1862b(c1864d, 0, this.f6521h0);
            this.f6525l0 = i5 + 1;
            return;
        }
        if (i3 == 1) {
            int i6 = this.f6526m0 + 1;
            C1862b[] c1862bArr3 = this.f6527n0;
            if (i6 >= c1862bArr3.length) {
                this.f6527n0 = (C1862b[]) Arrays.copyOf(c1862bArr3, c1862bArr3.length * 2);
            }
            C1862b[] c1862bArr4 = this.f6527n0;
            int i7 = this.f6526m0;
            c1862bArr4[i7] = new C1862b(c1864d, 1, this.f6521h0);
            this.f6526m0 = i7 + 1;
        }
    }

    /* JADX INFO: renamed from: C */
    public final void m4172C(C1846e c1846e) {
        mo4135a(c1846e);
        int size = this.f6517d0.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            C1864d c1864d = (C1864d) this.f6517d0.get(i3);
            boolean[] zArr = c1864d.f6469H;
            zArr[0] = false;
            zArr[1] = false;
            if (c1864d instanceof C1861a) {
                z3 = true;
            }
        }
        if (z3) {
            for (int i4 = 0; i4 < size; i4++) {
                C1864d c1864d2 = (C1864d) this.f6517d0.get(i4);
                if (c1864d2 instanceof C1861a) {
                    C1861a c1861a = (C1861a) c1864d2;
                    for (int i5 = 0; i5 < c1861a.f6592e0; i5++) {
                        C1864d c1864d3 = c1861a.f6591d0[i5];
                        int i6 = c1861a.f6435f0;
                        if (i6 == 0 || i6 == 1) {
                            c1864d3.f6469H[0] = true;
                        } else if (i6 == 2 || i6 == 3) {
                            c1864d3.f6469H[1] = true;
                        }
                    }
                }
            }
        }
        for (int i7 = 0; i7 < size; i7++) {
            C1864d c1864d4 = (C1864d) this.f6517d0.get(i7);
            c1864d4.getClass();
            if ((c1864d4 instanceof C1867g) || (c1864d4 instanceof C1868h)) {
                c1864d4.mo4135a(c1846e);
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            C1864d c1864d5 = (C1864d) this.f6517d0.get(i8);
            if (c1864d5 instanceof C1865e) {
                int[] iArr = c1864d5.f6493c0;
                int i9 = iArr[0];
                int i10 = iArr[1];
                if (i9 == 2) {
                    c1864d5.m4167w(1);
                }
                if (i10 == 2) {
                    c1864d5.m4168x(1);
                }
                c1864d5.mo4135a(c1846e);
                if (i9 == 2) {
                    c1864d5.m4167w(i9);
                }
                if (i10 == 2) {
                    c1864d5.m4168x(i10);
                }
            } else {
                c1864d5.f6498h = -1;
                c1864d5.f6499i = -1;
                int[] iArr2 = this.f6493c0;
                int i11 = iArr2[0];
                int[] iArr3 = c1864d5.f6493c0;
                if (i11 != 2 && iArr3[0] == 4) {
                    C1863c c1863c = c1864d5.f6514x;
                    int i12 = c1863c.f6459e;
                    int iM4156l = m4156l();
                    C1863c c1863c2 = c1864d5.f6516z;
                    int i13 = iM4156l - c1863c2.f6459e;
                    c1863c.f6461g = c1846e.m4107j(c1863c);
                    c1863c2.f6461g = c1846e.m4107j(c1863c2);
                    c1846e.m4101d(c1863c.f6461g, i12);
                    c1846e.m4101d(c1863c2.f6461g, i13);
                    c1864d5.f6498h = 2;
                    c1864d5.f6475N = i12;
                    int i14 = i13 - i12;
                    c1864d5.f6471J = i14;
                    int i15 = c1864d5.f6478Q;
                    if (i14 < i15) {
                        c1864d5.f6471J = i15;
                    }
                }
                if (iArr2[1] != 2 && iArr3[1] == 4) {
                    C1863c c1863c3 = c1864d5.f6515y;
                    int i16 = c1863c3.f6459e;
                    int iM4153i = m4153i();
                    C1863c c1863c4 = c1864d5.f6462A;
                    int i17 = iM4153i - c1863c4.f6459e;
                    c1863c3.f6461g = c1846e.m4107j(c1863c3);
                    c1863c4.f6461g = c1846e.m4107j(c1863c4);
                    c1846e.m4101d(c1863c3.f6461g, i16);
                    c1846e.m4101d(c1863c4.f6461g, i17);
                    if (c1864d5.f6477P > 0 || c1864d5.f6483V == 8) {
                        C1863c c1863c5 = c1864d5.f6463B;
                        C1850i c1850iM4107j = c1846e.m4107j(c1863c5);
                        c1863c5.f6461g = c1850iM4107j;
                        c1846e.m4101d(c1850iM4107j, c1864d5.f6477P + i16);
                    }
                    c1864d5.f6499i = 2;
                    c1864d5.f6476O = i16;
                    int i18 = i17 - i16;
                    c1864d5.f6472K = i18;
                    int i19 = c1864d5.f6479R;
                    if (i18 < i19) {
                        c1864d5.f6472K = i19;
                    }
                }
                if (!(c1864d5 instanceof C1867g) && !(c1864d5 instanceof C1868h)) {
                    c1864d5.mo4135a(c1846e);
                }
            }
        }
        if (this.f6525l0 > 0) {
            AbstractC1870j.m4186a(this, c1846e, 0);
        }
        if (this.f6526m0 > 0) {
            AbstractC1870j.m4186a(this, c1846e, 1);
        }
    }

    /* JADX INFO: renamed from: D */
    public final boolean m4173D(int i3, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        C1906e c1906e = this.f6519f0;
        C1865e c1865e = c1906e.f6660a;
        int iM4152h = c1865e.m4152h(0);
        int iM4152h2 = c1865e.m4152h(1);
        int iM4157m = c1865e.m4157m();
        int iM4158n = c1865e.m4158n();
        ArrayList<AbstractC1914m> arrayList = c1906e.f6664e;
        C1913l c1913l = c1865e.f6495e;
        C1911j c1911j = c1865e.f6494d;
        if (z3 && (iM4152h == 2 || iM4152h2 == 2)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z7 = z3;
                    break;
                }
                AbstractC1914m abstractC1914m = (AbstractC1914m) it.next();
                if (abstractC1914m.f6691f == i3 && !abstractC1914m.mo4238k()) {
                    z7 = false;
                    break;
                }
            }
            if (i3 == 0) {
                if (z7 && iM4152h == 2) {
                    c1865e.m4167w(1);
                    c1865e.m4169y(c1906e.m4244d(c1865e, 0));
                    c1911j.f6690e.mo4250d(c1865e.m4156l());
                }
            } else if (z7 && iM4152h2 == 2) {
                c1865e.m4168x(1);
                c1865e.m4166v(c1906e.m4244d(c1865e, 1));
                c1913l.f6690e.mo4250d(c1865e.m4153i());
            }
        }
        int[] iArr = c1865e.f6493c0;
        if (i3 == 0) {
            z4 = false;
            int i4 = iArr[0];
            if (i4 == 1 || i4 == 4) {
                int iM4156l = c1865e.m4156l() + iM4157m;
                c1911j.f6694i.mo4250d(iM4156l);
                c1911j.f6690e.mo4250d(iM4156l - iM4157m);
                z5 = true;
            }
            z5 = z4;
        } else {
            z4 = false;
            int i5 = iArr[1];
            if (i5 == 1 || i5 == 4) {
                int iM4153i = c1865e.m4153i() + iM4158n;
                c1913l.f6694i.mo4250d(iM4153i);
                c1913l.f6690e.mo4250d(iM4153i - iM4158n);
                z5 = true;
            }
            z5 = z4;
        }
        c1906e.m4247g();
        for (AbstractC1914m abstractC1914m2 : arrayList) {
            if (abstractC1914m2.f6691f == i3 && (abstractC1914m2.f6687b != c1865e || abstractC1914m2.f6692g)) {
                abstractC1914m2.mo4235e();
            }
        }
        for (AbstractC1914m abstractC1914m3 : arrayList) {
            if (abstractC1914m3.f6691f == i3 && (z5 || abstractC1914m3.f6687b != c1865e)) {
                if (!abstractC1914m3.f6693h.f6677j || !abstractC1914m3.f6694i.f6677j || (!(abstractC1914m3 instanceof C1904c) && !abstractC1914m3.f6690e.f6677j)) {
                    z6 = z4;
                    break;
                }
            }
        }
        z6 = true;
        c1865e.m4167w(iM4152h);
        c1865e.m4168x(iM4152h2);
        return z6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r7v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX INFO: renamed from: E */
    public final void m4174E() {
        boolean z3;
        int i3;
        boolean z4;
        ?? r22;
        ?? r16;
        boolean z5;
        ?? r02;
        char c3;
        ?? r03;
        ?? r15;
        int i4 = 0;
        this.f6475N = 0;
        this.f6476O = 0;
        int iMax = Math.max(0, m4156l());
        int iMax2 = Math.max(0, m4153i());
        this.f6530q0 = false;
        this.f6531r0 = false;
        int i5 = this.f6529p0;
        boolean z6 = ((i5 & 64) == 64) || (i5 & 128) == 128;
        C1846e c1846e = this.f6522i0;
        c1846e.getClass();
        c1846e.f6383f = false;
        if (this.f6529p0 != 0 && z6) {
            c1846e.f6383f = true;
        }
        ?? r7 = this.f6493c0;
        ?? r8 = r7[1];
        ?? r9 = r7[0];
        ArrayList arrayList = this.f6517d0;
        boolean z7 = r9 == 2 || r8 == 2;
        this.f6525l0 = 0;
        this.f6526m0 = 0;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C1864d c1864d = (C1864d) this.f6517d0.get(i6);
            if (c1864d instanceof C1865e) {
                ((C1865e) c1864d).m4174E();
            }
        }
        int i7 = 0;
        ?? r152 = 0;
        boolean z8 = true;
        while (z8) {
            int i8 = i7 + 1;
            try {
                c1846e.m4114r();
                this.f6525l0 = i4;
                this.f6526m0 = i4;
                m4150f(c1846e);
                for (int i9 = i4; i9 < size; i9++) {
                    ((C1864d) this.f6517d0.get(i9)).m4150f(c1846e);
                }
                m4172C(c1846e);
            } catch (Exception e3) {
                e = e3;
            }
            try {
                C1848g c1848g = c1846e.f6379b;
                if (c1846e.f6383f) {
                    int i10 = i4;
                    while (true) {
                        if (i10 >= c1846e.f6386i) {
                            for (int i11 = i4; i11 < c1846e.f6386i; i11++) {
                                C1844c c1844c = c1846e.f6382e[i11];
                                c1844c.f6371a.f6403e = c1844c.f6372b;
                            }
                        } else {
                            if (!c1846e.f6382e[i10].f6375e) {
                                c1846e.m4111o(c1848g);
                                break;
                            }
                            i10++;
                        }
                    }
                } else {
                    c1846e.m4111o(c1848g);
                }
                z3 = true;
            } catch (Exception e4) {
                e = e4;
                z8 = true;
                e.printStackTrace();
                z3 = z8;
                System.out.println("EXCEPTION : " + e);
            }
            boolean[] zArr = AbstractC1870j.f6593a;
            if (z3) {
                zArr[2] = false;
                mo4146A(c1846e);
                int size2 = this.f6517d0.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    ((C1864d) this.f6517d0.get(i12)).mo4146A(c1846e);
                }
            } else {
                mo4146A(c1846e);
                for (int i13 = 0; i13 < size; i13++) {
                    ((C1864d) this.f6517d0.get(i13)).mo4146A(c1846e);
                }
            }
            if (z7 && i8 < 8 && zArr[2]) {
                int i14 = 0;
                int iMax3 = 0;
                int iMax4 = 0;
                while (i14 < size) {
                    C1864d c1864d2 = (C1864d) this.f6517d0.get(i14);
                    iMax3 = Math.max(iMax3, c1864d2.m4156l() + c1864d2.f6475N);
                    iMax4 = Math.max(iMax4, c1864d2.m4153i() + c1864d2.f6476O);
                    i14++;
                    i8 = i8;
                }
                i3 = i8;
                int iMax5 = Math.max(this.f6478Q, iMax3);
                int iMax6 = Math.max(this.f6479R, iMax4);
                if (r9 != 2 || m4156l() >= iMax5) {
                    z4 = false;
                    r152 = r152;
                } else {
                    m4169y(iMax5);
                    r7[0] = 2;
                    z4 = true;
                    r152 = 1;
                }
                if (r8 == 2 && m4153i() < iMax6) {
                    m4166v(iMax6);
                    r7[1] = 2;
                    z4 = true;
                    r152 = 1;
                }
            } else {
                i3 = i8;
                z4 = false;
            }
            int iMax7 = Math.max(this.f6478Q, m4156l());
            if (iMax7 > m4156l()) {
                m4169y(iMax7);
                r22 = 1;
                r7[0] = 1;
                z4 = true;
                r16 = 1;
            } else {
                r22 = 1;
                r16 = r152;
            }
            int iMax8 = Math.max(this.f6479R, m4153i());
            if (iMax8 > m4153i()) {
                m4166v(iMax8);
                r7[r22] = r22;
                ?? r04 = r22;
                z5 = r04 == true ? 1 : 0;
                r02 = r04;
            } else {
                z5 = z4;
                r02 = r16;
            }
            if (r02 == 0) {
                ?? r05 = r02;
                r05 = r02;
                if (r7[0] == 2 && iMax > 0) {
                    r05 = r02;
                    if (m4156l() > iMax) {
                        this.f6530q0 = r22;
                        r7[0] = r22;
                        m4169y(iMax);
                        ?? r06 = r22;
                        z5 = r06 == true ? 1 : 0;
                        r05 = r06;
                    }
                }
                c3 = 2;
                r03 = r05;
                r03 = r05;
                if (r7[r22] == 2 && iMax2 > 0) {
                    r03 = r05;
                    if (m4153i() > iMax2) {
                        this.f6531r0 = r22;
                        r7[r22] = r22;
                        m4166v(iMax2);
                        z5 = true;
                        r15 = 1;
                    }
                }
                i7 = i3;
                i4 = 0;
                z8 = z5;
                r152 = r15;
            } else {
                c3 = 2;
                r03 = r02;
            }
            r15 = r03;
            i7 = i3;
            i4 = 0;
            z8 = z5;
            r152 = r15;
        }
        this.f6517d0 = arrayList;
        if (r152 != 0) {
            r7[0] = r9;
            r7[1] = r8;
        }
        mo4165u(c1846e.f6388k);
    }

    @Override // p140s.C1864d
    /* JADX INFO: renamed from: s */
    public final void mo4163s() {
        this.f6522i0.m4114r();
        this.f6523j0 = 0;
        this.f6524k0 = 0;
        this.f6517d0.clear();
        super.mo4163s();
    }

    @Override // p140s.C1864d
    /* JADX INFO: renamed from: u */
    public final void mo4165u(C1803m c1803m) {
        super.mo4165u(c1803m);
        int size = this.f6517d0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((C1864d) this.f6517d0.get(i3)).mo4165u(c1803m);
        }
    }

    @Override // p140s.C1864d
    /* JADX INFO: renamed from: z */
    public final void mo4170z(boolean z3, boolean z4) {
        super.mo4170z(z3, z4);
        int size = this.f6517d0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((C1864d) this.f6517d0.get(i3)).mo4170z(z3, z4);
        }
    }
}
