package p143t;

import p140s.AbstractC1869i;
import p140s.C1863c;
import p140s.C1864d;

/* JADX INFO: renamed from: t.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1911j extends AbstractC1914m {

    /* JADX INFO: renamed from: k */
    public static final int[] f6681k = new int[2];

    /* JADX INFO: renamed from: m */
    public static void m4253m(int[] iArr, int i3, int i4, int i5, int i6, float f3, int i7) {
        int i8 = i4 - i3;
        int i9 = i6 - i5;
        if (i7 != -1) {
            if (i7 == 0) {
                iArr[0] = (int) ((i9 * f3) + 0.5f);
                iArr[1] = i9;
                return;
            } else {
                if (i7 != 1) {
                    return;
                }
                iArr[0] = i8;
                iArr[1] = (int) ((i8 * f3) + 0.5f);
                return;
            }
        }
        int i10 = (int) ((i9 * f3) + 0.5f);
        int i11 = (int) ((i8 / f3) + 0.5f);
        if (i10 <= i8) {
            iArr[0] = i10;
            iArr[1] = i9;
        } else if (i11 <= i9) {
            iArr[0] = i8;
            iArr[1] = i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0267  */
    @Override // p143t.InterfaceC1905d
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo4233a(p143t.InterfaceC1905d r24) {
        /*
            Method dump skipped, instruction units count: 907
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p143t.C1911j.mo4233a(t.d):void");
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: d */
    public final void mo4234d() {
        C1864d c1864d;
        C1864d c1864d2;
        C1864d c1864d3;
        C1864d c1864d4;
        C1864d c1864d5 = this.f6687b;
        boolean z3 = c1864d5.f6488a;
        C1908g c1908g = this.f6690e;
        if (z3) {
            c1908g.mo4250d(c1864d5.m4156l());
        }
        boolean z4 = c1908g.f6677j;
        C1907f c1907f = this.f6694i;
        C1907f c1907f2 = this.f6693h;
        if (!z4) {
            C1864d c1864d6 = this.f6687b;
            int i3 = c1864d6.f6493c0[0];
            this.f6689d = i3;
            if (i3 != 3) {
                if (i3 == 4 && (((c1864d4 = c1864d6.f6470I) != null && c1864d4.f6493c0[0] == 1) || c1864d4.f6493c0[0] == 4)) {
                    int iM4156l = (c1864d4.m4156l() - this.f6687b.f6514x.m4139c()) - this.f6687b.f6516z.m4139c();
                    C1911j c1911j = c1864d4.f6494d;
                    AbstractC1914m.m4258b(c1907f2, c1911j.f6693h, this.f6687b.f6514x.m4139c());
                    AbstractC1914m.m4258b(c1907f, c1911j.f6694i, -this.f6687b.f6516z.m4139c());
                    c1908g.mo4250d(iM4156l);
                    return;
                }
                if (i3 == 1) {
                    c1908g.mo4250d(c1864d6.m4156l());
                }
            }
        } else if (this.f6689d == 4 && (((c1864d2 = (c1864d = this.f6687b).f6470I) != null && c1864d2.f6493c0[0] == 1) || c1864d2.f6493c0[0] == 4)) {
            AbstractC1914m.m4258b(c1907f2, c1864d2.f6494d.f6693h, c1864d.f6514x.m4139c());
            AbstractC1914m.m4258b(c1907f, c1864d2.f6494d.f6694i, -this.f6687b.f6516z.m4139c());
            return;
        }
        if (c1908g.f6677j) {
            C1864d c1864d7 = this.f6687b;
            if (c1864d7.f6488a) {
                C1863c[] c1863cArr = c1864d7.f6467F;
                C1863c c1863c = c1863cArr[0];
                C1863c c1863c2 = c1863c.f6458d;
                if (c1863c2 != null && c1863cArr[1].f6458d != null) {
                    if (c1864d7.m4161q()) {
                        c1907f2.f6673f = this.f6687b.f6467F[0].m4139c();
                        c1907f.f6673f = -this.f6687b.f6467F[1].m4139c();
                        return;
                    }
                    C1907f c1907fM4259h = AbstractC1914m.m4259h(this.f6687b.f6467F[0]);
                    if (c1907fM4259h != null) {
                        AbstractC1914m.m4258b(c1907f2, c1907fM4259h, this.f6687b.f6467F[0].m4139c());
                    }
                    C1907f c1907fM4259h2 = AbstractC1914m.m4259h(this.f6687b.f6467F[1]);
                    if (c1907fM4259h2 != null) {
                        AbstractC1914m.m4258b(c1907f, c1907fM4259h2, -this.f6687b.f6467F[1].m4139c());
                    }
                    c1907f2.f6669b = true;
                    c1907f.f6669b = true;
                    return;
                }
                if (c1863c2 != null) {
                    C1907f c1907fM4259h3 = AbstractC1914m.m4259h(c1863c);
                    if (c1907fM4259h3 != null) {
                        AbstractC1914m.m4258b(c1907f2, c1907fM4259h3, this.f6687b.f6467F[0].m4139c());
                        AbstractC1914m.m4258b(c1907f, c1907f2, c1908g.f6674g);
                        return;
                    }
                    return;
                }
                C1863c c1863c3 = c1863cArr[1];
                if (c1863c3.f6458d != null) {
                    C1907f c1907fM4259h4 = AbstractC1914m.m4259h(c1863c3);
                    if (c1907fM4259h4 != null) {
                        AbstractC1914m.m4258b(c1907f, c1907fM4259h4, -this.f6687b.f6467F[1].m4139c());
                        AbstractC1914m.m4258b(c1907f2, c1907f, -c1908g.f6674g);
                        return;
                    }
                    return;
                }
                if ((c1864d7 instanceof AbstractC1869i) || c1864d7.f6470I == null || c1864d7.mo4151g(7).f6458d != null) {
                    return;
                }
                C1864d c1864d8 = this.f6687b;
                AbstractC1914m.m4258b(c1907f2, c1864d8.f6470I.f6494d.f6693h, c1864d8.m4157m());
                AbstractC1914m.m4258b(c1907f, c1907f2, c1908g.f6674g);
                return;
            }
        }
        if (this.f6689d == 3) {
            C1864d c1864d9 = this.f6687b;
            int i4 = c1864d9.f6500j;
            if (i4 == 2) {
                C1864d c1864d10 = c1864d9.f6470I;
                if (c1864d10 != null) {
                    C1908g c1908g2 = c1864d10.f6495e.f6690e;
                    c1908g.f6679l.add(c1908g2);
                    c1908g2.f6678k.add(c1908g);
                    c1908g.f6669b = true;
                    c1908g.f6678k.add(c1907f2);
                    c1908g.f6678k.add(c1907f);
                }
            } else if (i4 == 3) {
                if (c1864d9.f6501k == 3) {
                    c1907f2.f6668a = this;
                    c1907f.f6668a = this;
                    C1913l c1913l = c1864d9.f6495e;
                    c1913l.f6693h.f6668a = this;
                    c1913l.f6694i.f6668a = this;
                    c1908g.f6668a = this;
                    if (c1864d9.m4162r()) {
                        c1908g.f6679l.add(this.f6687b.f6495e.f6690e);
                        this.f6687b.f6495e.f6690e.f6678k.add(c1908g);
                        C1913l c1913l2 = this.f6687b.f6495e;
                        c1913l2.f6690e.f6668a = this;
                        c1908g.f6679l.add(c1913l2.f6693h);
                        c1908g.f6679l.add(this.f6687b.f6495e.f6694i);
                        this.f6687b.f6495e.f6693h.f6678k.add(c1908g);
                        this.f6687b.f6495e.f6694i.f6678k.add(c1908g);
                    } else if (this.f6687b.m4161q()) {
                        this.f6687b.f6495e.f6690e.f6679l.add(c1908g);
                        c1908g.f6678k.add(this.f6687b.f6495e.f6690e);
                    } else {
                        this.f6687b.f6495e.f6690e.f6679l.add(c1908g);
                    }
                } else {
                    C1908g c1908g3 = c1864d9.f6495e.f6690e;
                    c1908g.f6679l.add(c1908g3);
                    c1908g3.f6678k.add(c1908g);
                    this.f6687b.f6495e.f6693h.f6678k.add(c1908g);
                    this.f6687b.f6495e.f6694i.f6678k.add(c1908g);
                    c1908g.f6669b = true;
                    c1908g.f6678k.add(c1907f2);
                    c1908g.f6678k.add(c1907f);
                    c1907f2.f6679l.add(c1908g);
                    c1907f.f6679l.add(c1908g);
                }
            }
        }
        C1864d c1864d11 = this.f6687b;
        C1863c[] c1863cArr2 = c1864d11.f6467F;
        C1863c c1863c4 = c1863cArr2[0];
        C1863c c1863c5 = c1863c4.f6458d;
        if (c1863c5 != null && c1863cArr2[1].f6458d != null) {
            if (c1864d11.m4161q()) {
                c1907f2.f6673f = this.f6687b.f6467F[0].m4139c();
                c1907f.f6673f = -this.f6687b.f6467F[1].m4139c();
                return;
            }
            C1907f c1907fM4259h5 = AbstractC1914m.m4259h(this.f6687b.f6467F[0]);
            C1907f c1907fM4259h6 = AbstractC1914m.m4259h(this.f6687b.f6467F[1]);
            c1907fM4259h5.m4248b(this);
            c1907fM4259h6.m4248b(this);
            this.f6695j = 4;
            return;
        }
        if (c1863c5 != null) {
            C1907f c1907fM4259h7 = AbstractC1914m.m4259h(c1863c4);
            if (c1907fM4259h7 != null) {
                AbstractC1914m.m4258b(c1907f2, c1907fM4259h7, this.f6687b.f6467F[0].m4139c());
                m4261c(c1907f, c1907f2, 1, c1908g);
                return;
            }
            return;
        }
        C1863c c1863c6 = c1863cArr2[1];
        if (c1863c6.f6458d != null) {
            C1907f c1907fM4259h8 = AbstractC1914m.m4259h(c1863c6);
            if (c1907fM4259h8 != null) {
                AbstractC1914m.m4258b(c1907f, c1907fM4259h8, -this.f6687b.f6467F[1].m4139c());
                m4261c(c1907f2, c1907f, -1, c1908g);
                return;
            }
            return;
        }
        if ((c1864d11 instanceof AbstractC1869i) || (c1864d3 = c1864d11.f6470I) == null) {
            return;
        }
        AbstractC1914m.m4258b(c1907f2, c1864d3.f6494d.f6693h, c1864d11.m4157m());
        m4261c(c1907f, c1907f2, 1, c1908g);
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: e */
    public final void mo4235e() {
        C1907f c1907f = this.f6693h;
        if (c1907f.f6677j) {
            this.f6687b.f6475N = c1907f.f6674g;
        }
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: f */
    public final void mo4236f() {
        this.f6688c = null;
        this.f6693h.m4249c();
        this.f6694i.m4249c();
        this.f6690e.m4249c();
        this.f6692g = false;
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: k */
    public final boolean mo4238k() {
        return this.f6689d != 3 || this.f6687b.f6500j == 0;
    }

    /* JADX INFO: renamed from: n */
    public final void m4254n() {
        this.f6692g = false;
        C1907f c1907f = this.f6693h;
        c1907f.m4249c();
        c1907f.f6677j = false;
        C1907f c1907f2 = this.f6694i;
        c1907f2.m4249c();
        c1907f2.f6677j = false;
        this.f6690e.f6677j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f6687b.f6484W;
    }
}
