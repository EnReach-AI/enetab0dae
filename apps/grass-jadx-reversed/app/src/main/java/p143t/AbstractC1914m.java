package p143t;

import p136r.AbstractC1849h;
import p140s.C1863c;
import p140s.C1864d;

/* JADX INFO: renamed from: t.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1914m implements InterfaceC1905d {

    /* JADX INFO: renamed from: a */
    public int f6686a;

    /* JADX INFO: renamed from: b */
    public C1864d f6687b;

    /* JADX INFO: renamed from: c */
    public C1912k f6688c;

    /* JADX INFO: renamed from: d */
    public int f6689d;

    /* JADX INFO: renamed from: e */
    public final C1908g f6690e = new C1908g(this);

    /* JADX INFO: renamed from: f */
    public int f6691f = 0;

    /* JADX INFO: renamed from: g */
    public boolean f6692g = false;

    /* JADX INFO: renamed from: h */
    public final C1907f f6693h = new C1907f(this);

    /* JADX INFO: renamed from: i */
    public final C1907f f6694i = new C1907f(this);

    /* JADX INFO: renamed from: j */
    public int f6695j = 1;

    public AbstractC1914m(C1864d c1864d) {
        this.f6687b = c1864d;
    }

    /* JADX INFO: renamed from: b */
    public static void m4258b(C1907f c1907f, C1907f c1907f2, int i3) {
        c1907f.f6679l.add(c1907f2);
        c1907f.f6673f = i3;
        c1907f2.f6678k.add(c1907f);
    }

    /* JADX INFO: renamed from: h */
    public static C1907f m4259h(C1863c c1863c) {
        C1863c c1863c2 = c1863c.f6458d;
        if (c1863c2 == null) {
            return null;
        }
        int iM4118b = AbstractC1849h.m4118b(c1863c2.f6457c);
        C1864d c1864d = c1863c2.f6456b;
        if (iM4118b == 1) {
            return c1864d.f6494d.f6693h;
        }
        if (iM4118b == 2) {
            return c1864d.f6495e.f6693h;
        }
        if (iM4118b == 3) {
            return c1864d.f6494d.f6694i;
        }
        if (iM4118b == 4) {
            return c1864d.f6495e.f6694i;
        }
        if (iM4118b != 5) {
            return null;
        }
        return c1864d.f6495e.f6684k;
    }

    /* JADX INFO: renamed from: i */
    public static C1907f m4260i(C1863c c1863c, int i3) {
        C1863c c1863c2 = c1863c.f6458d;
        if (c1863c2 == null) {
            return null;
        }
        C1864d c1864d = c1863c2.f6456b;
        AbstractC1914m abstractC1914m = i3 == 0 ? c1864d.f6494d : c1864d.f6495e;
        int iM4118b = AbstractC1849h.m4118b(c1863c2.f6457c);
        if (iM4118b == 1 || iM4118b == 2) {
            return abstractC1914m.f6693h;
        }
        if (iM4118b == 3 || iM4118b == 4) {
            return abstractC1914m.f6694i;
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final void m4261c(C1907f c1907f, C1907f c1907f2, int i3, C1908g c1908g) {
        c1907f.f6679l.add(c1907f2);
        c1907f.f6679l.add(this.f6690e);
        c1907f.f6675h = i3;
        c1907f.f6676i = c1908g;
        c1907f2.f6678k.add(c1907f);
        c1908g.f6678k.add(c1907f);
    }

    /* JADX INFO: renamed from: d */
    public abstract void mo4234d();

    /* JADX INFO: renamed from: e */
    public abstract void mo4235e();

    /* JADX INFO: renamed from: f */
    public abstract void mo4236f();

    /* JADX INFO: renamed from: g */
    public final int m4262g(int i3, int i4) {
        int iMax;
        if (i4 == 0) {
            C1864d c1864d = this.f6687b;
            int i5 = c1864d.f6504n;
            iMax = Math.max(c1864d.f6503m, i3);
            if (i5 > 0) {
                iMax = Math.min(i5, i3);
            }
            if (iMax == i3) {
                return i3;
            }
        } else {
            C1864d c1864d2 = this.f6687b;
            int i6 = c1864d2.f6507q;
            iMax = Math.max(c1864d2.f6506p, i3);
            if (i6 > 0) {
                iMax = Math.min(i6, i3);
            }
            if (iMax == i3) {
                return i3;
            }
        }
        return iMax;
    }

    /* JADX INFO: renamed from: j */
    public long mo4237j() {
        if (this.f6690e.f6677j) {
            return r0.f6674g;
        }
        return 0L;
    }

    /* JADX INFO: renamed from: k */
    public abstract boolean mo4238k();

    /* JADX INFO: renamed from: l */
    public final void m4263l(C1863c c1863c, C1863c c1863c2, int i3) {
        C1907f c1907fM4259h = m4259h(c1863c);
        C1907f c1907fM4259h2 = m4259h(c1863c2);
        if (c1907fM4259h.f6677j && c1907fM4259h2.f6677j) {
            int iM4139c = c1863c.m4139c() + c1907fM4259h.f6674g;
            int iM4139c2 = c1907fM4259h2.f6674g - c1863c2.m4139c();
            int i4 = iM4139c2 - iM4139c;
            C1908g c1908g = this.f6690e;
            if (!c1908g.f6677j && this.f6689d == 3) {
                int i5 = this.f6686a;
                if (i5 == 0) {
                    c1908g.mo4250d(m4262g(i4, i3));
                } else if (i5 == 1) {
                    c1908g.mo4250d(Math.min(m4262g(c1908g.f6680m, i3), i4));
                } else if (i5 == 2) {
                    C1864d c1864d = this.f6687b;
                    C1864d c1864d2 = c1864d.f6470I;
                    if (c1864d2 != null) {
                        if ((i3 == 0 ? c1864d2.f6494d : c1864d2.f6495e).f6690e.f6677j) {
                            c1908g.mo4250d(m4262g((int) ((r6.f6674g * (i3 == 0 ? c1864d.f6505o : c1864d.f6508r)) + 0.5f), i3));
                        }
                    }
                } else if (i5 == 3) {
                    C1864d c1864d3 = this.f6687b;
                    AbstractC1914m abstractC1914m = c1864d3.f6494d;
                    int i6 = abstractC1914m.f6689d;
                    C1913l c1913l = c1864d3.f6495e;
                    if (i6 != 3 || abstractC1914m.f6686a != 3 || c1913l.f6689d != 3 || c1913l.f6686a != 3) {
                        if (i3 == 0) {
                            abstractC1914m = c1913l;
                        }
                        if (abstractC1914m.f6690e.f6677j) {
                            float f3 = c1864d3.f6473L;
                            c1908g.mo4250d(i3 == 1 ? (int) ((r6.f6674g / f3) + 0.5f) : (int) ((f3 * r6.f6674g) + 0.5f));
                        }
                    }
                }
            }
            if (c1908g.f6677j) {
                int i7 = c1908g.f6674g;
                C1907f c1907f = this.f6694i;
                C1907f c1907f2 = this.f6693h;
                if (i7 == i4) {
                    c1907f2.mo4250d(iM4139c);
                    c1907f.mo4250d(iM4139c2);
                    return;
                }
                C1864d c1864d4 = this.f6687b;
                float f4 = i3 == 0 ? c1864d4.f6480S : c1864d4.f6481T;
                if (c1907fM4259h == c1907fM4259h2) {
                    iM4139c = c1907fM4259h.f6674g;
                    iM4139c2 = c1907fM4259h2.f6674g;
                    f4 = 0.5f;
                }
                c1907f2.mo4250d((int) ((((iM4139c2 - iM4139c) - i7) * f4) + iM4139c + 0.5f));
                c1907f.mo4250d(c1907f2.f6674g + c1908g.f6674g);
            }
        }
    }
}
