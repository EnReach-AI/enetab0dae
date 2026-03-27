package p143t;

import p140s.C1864d;
import p140s.C1868h;

/* JADX INFO: renamed from: t.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1909h extends AbstractC1914m {
    @Override // p143t.InterfaceC1905d
    /* JADX INFO: renamed from: a */
    public final void mo4233a(InterfaceC1905d interfaceC1905d) {
        C1907f c1907f = this.f6693h;
        if (c1907f.f6670c && !c1907f.f6677j) {
            c1907f.mo4250d((int) ((((C1907f) c1907f.f6679l.get(0)).f6674g * ((C1868h) this.f6687b).f6586d0) + 0.5f));
        }
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: d */
    public final void mo4234d() {
        C1864d c1864d = this.f6687b;
        C1868h c1868h = (C1868h) c1864d;
        int i3 = c1868h.f6587e0;
        int i4 = c1868h.f6588f0;
        int i5 = c1868h.f6590h0;
        C1907f c1907f = this.f6693h;
        if (i5 == 1) {
            if (i3 != -1) {
                c1907f.f6679l.add(c1864d.f6470I.f6494d.f6693h);
                this.f6687b.f6470I.f6494d.f6693h.f6678k.add(c1907f);
                c1907f.f6673f = i3;
            } else if (i4 != -1) {
                c1907f.f6679l.add(c1864d.f6470I.f6494d.f6694i);
                this.f6687b.f6470I.f6494d.f6694i.f6678k.add(c1907f);
                c1907f.f6673f = -i4;
            } else {
                c1907f.f6669b = true;
                c1907f.f6679l.add(c1864d.f6470I.f6494d.f6694i);
                this.f6687b.f6470I.f6494d.f6694i.f6678k.add(c1907f);
            }
            m4251m(this.f6687b.f6494d.f6693h);
            m4251m(this.f6687b.f6494d.f6694i);
            return;
        }
        if (i3 != -1) {
            c1907f.f6679l.add(c1864d.f6470I.f6495e.f6693h);
            this.f6687b.f6470I.f6495e.f6693h.f6678k.add(c1907f);
            c1907f.f6673f = i3;
        } else if (i4 != -1) {
            c1907f.f6679l.add(c1864d.f6470I.f6495e.f6694i);
            this.f6687b.f6470I.f6495e.f6694i.f6678k.add(c1907f);
            c1907f.f6673f = -i4;
        } else {
            c1907f.f6669b = true;
            c1907f.f6679l.add(c1864d.f6470I.f6495e.f6694i);
            this.f6687b.f6470I.f6495e.f6694i.f6678k.add(c1907f);
        }
        m4251m(this.f6687b.f6495e.f6693h);
        m4251m(this.f6687b.f6495e.f6694i);
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: e */
    public final void mo4235e() {
        C1864d c1864d = this.f6687b;
        int i3 = ((C1868h) c1864d).f6590h0;
        C1907f c1907f = this.f6693h;
        if (i3 == 1) {
            c1864d.f6475N = c1907f.f6674g;
        } else {
            c1864d.f6476O = c1907f.f6674g;
        }
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: f */
    public final void mo4236f() {
        this.f6693h.m4249c();
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: k */
    public final boolean mo4238k() {
        return false;
    }

    /* JADX INFO: renamed from: m */
    public final void m4251m(C1907f c1907f) {
        C1907f c1907f2 = this.f6693h;
        c1907f2.f6678k.add(c1907f);
        c1907f.f6679l.add(c1907f2);
    }
}
