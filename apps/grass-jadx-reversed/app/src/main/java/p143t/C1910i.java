package p143t;

import java.util.Iterator;
import p140s.C1861a;
import p140s.C1864d;

/* JADX INFO: renamed from: t.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1910i extends AbstractC1914m {
    @Override // p143t.InterfaceC1905d
    /* JADX INFO: renamed from: a */
    public final void mo4233a(InterfaceC1905d interfaceC1905d) {
        C1861a c1861a = (C1861a) this.f6687b;
        int i3 = c1861a.f6435f0;
        C1907f c1907f = this.f6693h;
        Iterator it = c1907f.f6679l.iterator();
        int i4 = 0;
        int i5 = -1;
        while (it.hasNext()) {
            int i6 = ((C1907f) it.next()).f6674g;
            if (i5 == -1 || i6 < i5) {
                i5 = i6;
            }
            if (i4 < i6) {
                i4 = i6;
            }
        }
        if (i3 == 0 || i3 == 2) {
            c1907f.mo4250d(i5 + c1861a.f6437h0);
        } else {
            c1907f.mo4250d(i4 + c1861a.f6437h0);
        }
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: d */
    public final void mo4234d() {
        C1864d c1864d = this.f6687b;
        if (c1864d instanceof C1861a) {
            C1907f c1907f = this.f6693h;
            c1907f.f6669b = true;
            C1861a c1861a = (C1861a) c1864d;
            int i3 = c1861a.f6435f0;
            boolean z3 = c1861a.f6436g0;
            int i4 = 0;
            if (i3 == 0) {
                c1907f.f6672e = 4;
                while (i4 < c1861a.f6592e0) {
                    C1864d c1864d2 = c1861a.f6591d0[i4];
                    if (z3 || c1864d2.f6483V != 8) {
                        C1907f c1907f2 = c1864d2.f6494d.f6693h;
                        c1907f2.f6678k.add(c1907f);
                        c1907f.f6679l.add(c1907f2);
                    }
                    i4++;
                }
                m4252m(this.f6687b.f6494d.f6693h);
                m4252m(this.f6687b.f6494d.f6694i);
                return;
            }
            if (i3 == 1) {
                c1907f.f6672e = 5;
                while (i4 < c1861a.f6592e0) {
                    C1864d c1864d3 = c1861a.f6591d0[i4];
                    if (z3 || c1864d3.f6483V != 8) {
                        C1907f c1907f3 = c1864d3.f6494d.f6694i;
                        c1907f3.f6678k.add(c1907f);
                        c1907f.f6679l.add(c1907f3);
                    }
                    i4++;
                }
                m4252m(this.f6687b.f6494d.f6693h);
                m4252m(this.f6687b.f6494d.f6694i);
                return;
            }
            if (i3 == 2) {
                c1907f.f6672e = 6;
                while (i4 < c1861a.f6592e0) {
                    C1864d c1864d4 = c1861a.f6591d0[i4];
                    if (z3 || c1864d4.f6483V != 8) {
                        C1907f c1907f4 = c1864d4.f6495e.f6693h;
                        c1907f4.f6678k.add(c1907f);
                        c1907f.f6679l.add(c1907f4);
                    }
                    i4++;
                }
                m4252m(this.f6687b.f6495e.f6693h);
                m4252m(this.f6687b.f6495e.f6694i);
                return;
            }
            if (i3 != 3) {
                return;
            }
            c1907f.f6672e = 7;
            while (i4 < c1861a.f6592e0) {
                C1864d c1864d5 = c1861a.f6591d0[i4];
                if (z3 || c1864d5.f6483V != 8) {
                    C1907f c1907f5 = c1864d5.f6495e.f6694i;
                    c1907f5.f6678k.add(c1907f);
                    c1907f.f6679l.add(c1907f5);
                }
                i4++;
            }
            m4252m(this.f6687b.f6495e.f6693h);
            m4252m(this.f6687b.f6495e.f6694i);
        }
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: e */
    public final void mo4235e() {
        C1864d c1864d = this.f6687b;
        if (c1864d instanceof C1861a) {
            int i3 = ((C1861a) c1864d).f6435f0;
            C1907f c1907f = this.f6693h;
            if (i3 == 0 || i3 == 1) {
                c1864d.f6475N = c1907f.f6674g;
            } else {
                c1864d.f6476O = c1907f.f6674g;
            }
        }
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: f */
    public final void mo4236f() {
        this.f6688c = null;
        this.f6693h.m4249c();
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: k */
    public final boolean mo4238k() {
        return false;
    }

    /* JADX INFO: renamed from: m */
    public final void m4252m(C1907f c1907f) {
        C1907f c1907f2 = this.f6693h;
        c1907f2.f6678k.add(c1907f);
        c1907f.f6679l.add(c1907f2);
    }
}
