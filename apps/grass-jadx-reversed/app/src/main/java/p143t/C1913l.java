package p143t;

import p136r.AbstractC1849h;
import p140s.AbstractC1869i;
import p140s.C1863c;
import p140s.C1864d;

/* JADX INFO: renamed from: t.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1913l extends AbstractC1914m {

    /* JADX INFO: renamed from: k */
    public C1907f f6684k;

    /* JADX INFO: renamed from: l */
    public C1902a f6685l;

    @Override // p143t.InterfaceC1905d
    /* JADX INFO: renamed from: a */
    public final void mo4233a(InterfaceC1905d interfaceC1905d) {
        float f3;
        float f4;
        float f5;
        int i3;
        if (AbstractC1849h.m4118b(this.f6695j) == 3) {
            C1864d c1864d = this.f6687b;
            m4263l(c1864d.f6515y, c1864d.f6462A, 1);
            return;
        }
        C1908g c1908g = this.f6690e;
        if (c1908g.f6670c && !c1908g.f6677j && this.f6689d == 3) {
            C1864d c1864d2 = this.f6687b;
            int i4 = c1864d2.f6501k;
            if (i4 == 2) {
                C1864d c1864d3 = c1864d2.f6470I;
                if (c1864d3 != null) {
                    if (c1864d3.f6495e.f6690e.f6677j) {
                        c1908g.mo4250d((int) ((r5.f6674g * c1864d2.f6508r) + 0.5f));
                    }
                }
            } else if (i4 == 3) {
                C1908g c1908g2 = c1864d2.f6494d.f6690e;
                if (c1908g2.f6677j) {
                    int i5 = c1864d2.f6474M;
                    if (i5 == -1) {
                        f3 = c1908g2.f6674g;
                        f4 = c1864d2.f6473L;
                    } else if (i5 == 0) {
                        f5 = c1908g2.f6674g * c1864d2.f6473L;
                        i3 = (int) (f5 + 0.5f);
                        c1908g.mo4250d(i3);
                    } else if (i5 != 1) {
                        i3 = 0;
                        c1908g.mo4250d(i3);
                    } else {
                        f3 = c1908g2.f6674g;
                        f4 = c1864d2.f6473L;
                    }
                    f5 = f3 / f4;
                    i3 = (int) (f5 + 0.5f);
                    c1908g.mo4250d(i3);
                }
            }
        }
        C1907f c1907f = this.f6693h;
        if (c1907f.f6670c) {
            C1907f c1907f2 = this.f6694i;
            if (c1907f2.f6670c) {
                if (c1907f.f6677j && c1907f2.f6677j && c1908g.f6677j) {
                    return;
                }
                if (!c1908g.f6677j && this.f6689d == 3) {
                    C1864d c1864d4 = this.f6687b;
                    if (c1864d4.f6500j == 0 && !c1864d4.m4162r()) {
                        C1907f c1907f3 = (C1907f) c1907f.f6679l.get(0);
                        C1907f c1907f4 = (C1907f) c1907f2.f6679l.get(0);
                        int i6 = c1907f3.f6674g + c1907f.f6673f;
                        int i7 = c1907f4.f6674g + c1907f2.f6673f;
                        c1907f.mo4250d(i6);
                        c1907f2.mo4250d(i7);
                        c1908g.mo4250d(i7 - i6);
                        return;
                    }
                }
                if (!c1908g.f6677j && this.f6689d == 3 && this.f6686a == 1 && c1907f.f6679l.size() > 0 && c1907f2.f6679l.size() > 0) {
                    C1907f c1907f5 = (C1907f) c1907f.f6679l.get(0);
                    int i8 = (((C1907f) c1907f2.f6679l.get(0)).f6674g + c1907f2.f6673f) - (c1907f5.f6674g + c1907f.f6673f);
                    int i9 = c1908g.f6680m;
                    if (i8 < i9) {
                        c1908g.mo4250d(i8);
                    } else {
                        c1908g.mo4250d(i9);
                    }
                }
                if (c1908g.f6677j && c1907f.f6679l.size() > 0 && c1907f2.f6679l.size() > 0) {
                    C1907f c1907f6 = (C1907f) c1907f.f6679l.get(0);
                    C1907f c1907f7 = (C1907f) c1907f2.f6679l.get(0);
                    int i10 = c1907f6.f6674g;
                    int i11 = c1907f.f6673f + i10;
                    int i12 = c1907f7.f6674g;
                    int i13 = c1907f2.f6673f + i12;
                    float f6 = this.f6687b.f6481T;
                    if (c1907f6 == c1907f7) {
                        f6 = 0.5f;
                    } else {
                        i10 = i11;
                        i12 = i13;
                    }
                    c1907f.mo4250d((int) ((((i12 - i10) - c1908g.f6674g) * f6) + i10 + 0.5f));
                    c1907f2.mo4250d(c1907f.f6674g + c1908g.f6674g);
                }
            }
        }
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
            c1908g.mo4250d(c1864d5.m4153i());
        }
        boolean z4 = c1908g.f6677j;
        C1907f c1907f = this.f6694i;
        C1907f c1907f2 = this.f6693h;
        if (!z4) {
            C1864d c1864d6 = this.f6687b;
            this.f6689d = c1864d6.f6493c0[1];
            if (c1864d6.f6513w) {
                this.f6685l = new C1902a(this);
            }
            int i3 = this.f6689d;
            if (i3 != 3) {
                if (i3 == 4 && (c1864d4 = this.f6687b.f6470I) != null && c1864d4.f6493c0[1] == 1) {
                    int iM4153i = (c1864d4.m4153i() - this.f6687b.f6515y.m4139c()) - this.f6687b.f6462A.m4139c();
                    C1913l c1913l = c1864d4.f6495e;
                    AbstractC1914m.m4258b(c1907f2, c1913l.f6693h, this.f6687b.f6515y.m4139c());
                    AbstractC1914m.m4258b(c1907f, c1913l.f6694i, -this.f6687b.f6462A.m4139c());
                    c1908g.mo4250d(iM4153i);
                    return;
                }
                if (i3 == 1) {
                    c1908g.mo4250d(this.f6687b.m4153i());
                }
            }
        } else if (this.f6689d == 4 && (c1864d2 = (c1864d = this.f6687b).f6470I) != null && c1864d2.f6493c0[1] == 1) {
            C1913l c1913l2 = c1864d2.f6495e;
            AbstractC1914m.m4258b(c1907f2, c1913l2.f6693h, c1864d.f6515y.m4139c());
            AbstractC1914m.m4258b(c1907f, c1913l2.f6694i, -this.f6687b.f6462A.m4139c());
            return;
        }
        boolean z5 = c1908g.f6677j;
        C1907f c1907f3 = this.f6684k;
        if (z5) {
            C1864d c1864d7 = this.f6687b;
            if (c1864d7.f6488a) {
                C1863c[] c1863cArr = c1864d7.f6467F;
                C1863c c1863c = c1863cArr[2];
                C1863c c1863c2 = c1863c.f6458d;
                if (c1863c2 != null && c1863cArr[3].f6458d != null) {
                    if (c1864d7.m4162r()) {
                        c1907f2.f6673f = this.f6687b.f6467F[2].m4139c();
                        c1907f.f6673f = -this.f6687b.f6467F[3].m4139c();
                    } else {
                        C1907f c1907fM4259h = AbstractC1914m.m4259h(this.f6687b.f6467F[2]);
                        if (c1907fM4259h != null) {
                            AbstractC1914m.m4258b(c1907f2, c1907fM4259h, this.f6687b.f6467F[2].m4139c());
                        }
                        C1907f c1907fM4259h2 = AbstractC1914m.m4259h(this.f6687b.f6467F[3]);
                        if (c1907fM4259h2 != null) {
                            AbstractC1914m.m4258b(c1907f, c1907fM4259h2, -this.f6687b.f6467F[3].m4139c());
                        }
                        c1907f2.f6669b = true;
                        c1907f.f6669b = true;
                    }
                    C1864d c1864d8 = this.f6687b;
                    if (c1864d8.f6513w) {
                        AbstractC1914m.m4258b(c1907f3, c1907f2, c1864d8.f6477P);
                        return;
                    }
                    return;
                }
                if (c1863c2 != null) {
                    C1907f c1907fM4259h3 = AbstractC1914m.m4259h(c1863c);
                    if (c1907fM4259h3 != null) {
                        AbstractC1914m.m4258b(c1907f2, c1907fM4259h3, this.f6687b.f6467F[2].m4139c());
                        AbstractC1914m.m4258b(c1907f, c1907f2, c1908g.f6674g);
                        C1864d c1864d9 = this.f6687b;
                        if (c1864d9.f6513w) {
                            AbstractC1914m.m4258b(c1907f3, c1907f2, c1864d9.f6477P);
                            return;
                        }
                        return;
                    }
                    return;
                }
                C1863c c1863c3 = c1863cArr[3];
                if (c1863c3.f6458d != null) {
                    C1907f c1907fM4259h4 = AbstractC1914m.m4259h(c1863c3);
                    if (c1907fM4259h4 != null) {
                        AbstractC1914m.m4258b(c1907f, c1907fM4259h4, -this.f6687b.f6467F[3].m4139c());
                        AbstractC1914m.m4258b(c1907f2, c1907f, -c1908g.f6674g);
                    }
                    C1864d c1864d10 = this.f6687b;
                    if (c1864d10.f6513w) {
                        AbstractC1914m.m4258b(c1907f3, c1907f2, c1864d10.f6477P);
                        return;
                    }
                    return;
                }
                C1863c c1863c4 = c1863cArr[4];
                if (c1863c4.f6458d != null) {
                    C1907f c1907fM4259h5 = AbstractC1914m.m4259h(c1863c4);
                    if (c1907fM4259h5 != null) {
                        AbstractC1914m.m4258b(c1907f3, c1907fM4259h5, 0);
                        AbstractC1914m.m4258b(c1907f2, c1907f3, -this.f6687b.f6477P);
                        AbstractC1914m.m4258b(c1907f, c1907f2, c1908g.f6674g);
                        return;
                    }
                    return;
                }
                if ((c1864d7 instanceof AbstractC1869i) || c1864d7.f6470I == null || c1864d7.mo4151g(7).f6458d != null) {
                    return;
                }
                C1864d c1864d11 = this.f6687b;
                AbstractC1914m.m4258b(c1907f2, c1864d11.f6470I.f6495e.f6693h, c1864d11.m4158n());
                AbstractC1914m.m4258b(c1907f, c1907f2, c1908g.f6674g);
                C1864d c1864d12 = this.f6687b;
                if (c1864d12.f6513w) {
                    AbstractC1914m.m4258b(c1907f3, c1907f2, c1864d12.f6477P);
                    return;
                }
                return;
            }
        }
        if (z5 || this.f6689d != 3) {
            c1908g.m4248b(this);
        } else {
            C1864d c1864d13 = this.f6687b;
            int i4 = c1864d13.f6501k;
            if (i4 == 2) {
                C1864d c1864d14 = c1864d13.f6470I;
                if (c1864d14 != null) {
                    C1908g c1908g2 = c1864d14.f6495e.f6690e;
                    c1908g.f6679l.add(c1908g2);
                    c1908g2.f6678k.add(c1908g);
                    c1908g.f6669b = true;
                    c1908g.f6678k.add(c1907f2);
                    c1908g.f6678k.add(c1907f);
                }
            } else if (i4 == 3 && !c1864d13.m4162r()) {
                C1864d c1864d15 = this.f6687b;
                if (c1864d15.f6500j != 3) {
                    C1908g c1908g3 = c1864d15.f6494d.f6690e;
                    c1908g.f6679l.add(c1908g3);
                    c1908g3.f6678k.add(c1908g);
                    c1908g.f6669b = true;
                    c1908g.f6678k.add(c1907f2);
                    c1908g.f6678k.add(c1907f);
                }
            }
        }
        C1864d c1864d16 = this.f6687b;
        C1863c[] c1863cArr2 = c1864d16.f6467F;
        C1863c c1863c5 = c1863cArr2[2];
        C1863c c1863c6 = c1863c5.f6458d;
        if (c1863c6 != null && c1863cArr2[3].f6458d != null) {
            if (c1864d16.m4162r()) {
                c1907f2.f6673f = this.f6687b.f6467F[2].m4139c();
                c1907f.f6673f = -this.f6687b.f6467F[3].m4139c();
            } else {
                C1907f c1907fM4259h6 = AbstractC1914m.m4259h(this.f6687b.f6467F[2]);
                C1907f c1907fM4259h7 = AbstractC1914m.m4259h(this.f6687b.f6467F[3]);
                c1907fM4259h6.m4248b(this);
                c1907fM4259h7.m4248b(this);
                this.f6695j = 4;
            }
            if (this.f6687b.f6513w) {
                m4261c(c1907f3, c1907f2, 1, this.f6685l);
            }
        } else if (c1863c6 != null) {
            C1907f c1907fM4259h8 = AbstractC1914m.m4259h(c1863c5);
            if (c1907fM4259h8 != null) {
                AbstractC1914m.m4258b(c1907f2, c1907fM4259h8, this.f6687b.f6467F[2].m4139c());
                m4261c(c1907f, c1907f2, 1, c1908g);
                if (this.f6687b.f6513w) {
                    m4261c(c1907f3, c1907f2, 1, this.f6685l);
                }
                if (this.f6689d == 3) {
                    C1864d c1864d17 = this.f6687b;
                    if (c1864d17.f6473L > 0.0f) {
                        C1911j c1911j = c1864d17.f6494d;
                        if (c1911j.f6689d == 3) {
                            c1911j.f6690e.f6678k.add(c1908g);
                            c1908g.f6679l.add(this.f6687b.f6494d.f6690e);
                            c1908g.f6668a = this;
                        }
                    }
                }
            }
        } else {
            C1863c c1863c7 = c1863cArr2[3];
            if (c1863c7.f6458d != null) {
                C1907f c1907fM4259h9 = AbstractC1914m.m4259h(c1863c7);
                if (c1907fM4259h9 != null) {
                    AbstractC1914m.m4258b(c1907f, c1907fM4259h9, -this.f6687b.f6467F[3].m4139c());
                    m4261c(c1907f2, c1907f, -1, c1908g);
                    if (this.f6687b.f6513w) {
                        m4261c(c1907f3, c1907f2, 1, this.f6685l);
                    }
                }
            } else {
                C1863c c1863c8 = c1863cArr2[4];
                if (c1863c8.f6458d != null) {
                    C1907f c1907fM4259h10 = AbstractC1914m.m4259h(c1863c8);
                    if (c1907fM4259h10 != null) {
                        AbstractC1914m.m4258b(c1907f3, c1907fM4259h10, 0);
                        m4261c(c1907f2, c1907f3, -1, this.f6685l);
                        m4261c(c1907f, c1907f2, 1, c1908g);
                    }
                } else if (!(c1864d16 instanceof AbstractC1869i) && (c1864d3 = c1864d16.f6470I) != null) {
                    AbstractC1914m.m4258b(c1907f2, c1864d3.f6495e.f6693h, c1864d16.m4158n());
                    m4261c(c1907f, c1907f2, 1, c1908g);
                    if (this.f6687b.f6513w) {
                        m4261c(c1907f3, c1907f2, 1, this.f6685l);
                    }
                    if (this.f6689d == 3) {
                        C1864d c1864d18 = this.f6687b;
                        if (c1864d18.f6473L > 0.0f) {
                            C1911j c1911j2 = c1864d18.f6494d;
                            if (c1911j2.f6689d == 3) {
                                c1911j2.f6690e.f6678k.add(c1908g);
                                c1908g.f6679l.add(this.f6687b.f6494d.f6690e);
                                c1908g.f6668a = this;
                            }
                        }
                    }
                }
            }
        }
        if (c1908g.f6679l.size() == 0) {
            c1908g.f6670c = true;
        }
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: e */
    public final void mo4235e() {
        C1907f c1907f = this.f6693h;
        if (c1907f.f6677j) {
            this.f6687b.f6476O = c1907f.f6674g;
        }
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: f */
    public final void mo4236f() {
        this.f6688c = null;
        this.f6693h.m4249c();
        this.f6694i.m4249c();
        this.f6684k.m4249c();
        this.f6690e.m4249c();
        this.f6692g = false;
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: k */
    public final boolean mo4238k() {
        return this.f6689d != 3 || this.f6687b.f6501k == 0;
    }

    /* JADX INFO: renamed from: m */
    public final void m4257m() {
        this.f6692g = false;
        C1907f c1907f = this.f6693h;
        c1907f.m4249c();
        c1907f.f6677j = false;
        C1907f c1907f2 = this.f6694i;
        c1907f2.m4249c();
        c1907f2.f6677j = false;
        C1907f c1907f3 = this.f6684k;
        c1907f3.m4249c();
        c1907f3.f6677j = false;
        this.f6690e.f6677j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f6687b.f6484W;
    }
}
