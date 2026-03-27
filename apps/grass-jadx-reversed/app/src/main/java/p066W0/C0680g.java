package p066W0;

import java.io.Serializable;
import p042N0.AbstractC0540h;
import p042N0.InterfaceC0550r;
import p042N0.InterfaceC0551s;
import p050Q0.C0597j;
import p058T0.AbstractC0637b;

/* JADX INFO: renamed from: W0.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0680g implements InterfaceC0550r, InterfaceC0681h, Serializable {

    /* JADX INFO: renamed from: l */
    public static final C0597j f1849l = new C0597j(" ");
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final AbstractC0679f f1850e;

    /* JADX INFO: renamed from: f */
    public final AbstractC0679f f1851f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC0551s f1852g;

    /* JADX INFO: renamed from: h */
    public final boolean f1853h;

    /* JADX INFO: renamed from: i */
    public transient int f1854i;

    /* JADX INFO: renamed from: j */
    public final C0689p f1855j;

    /* JADX INFO: renamed from: k */
    public final String f1856k;

    public C0680g() {
        this.f1850e = C0678e.f1848e;
        this.f1851f = C0677d.f1844h;
        this.f1853h = true;
        this.f1852g = f1849l;
        this.f1855j = InterfaceC0550r.f1333a;
        this.f1856k = " : ";
    }

    @Override // p042N0.InterfaceC0550r
    /* JADX INFO: renamed from: a */
    public final void mo1224a(AbstractC0637b abstractC0637b) {
        this.f1850e.mo1640b(abstractC0637b, this.f1854i);
    }

    @Override // p042N0.InterfaceC0550r
    /* JADX INFO: renamed from: b */
    public final void mo1225b(AbstractC0540h abstractC0540h, int i3) {
        AbstractC0679f abstractC0679f = this.f1850e;
        if (!abstractC0679f.mo1641a()) {
            this.f1854i--;
        }
        if (i3 > 0) {
            abstractC0679f.mo1640b(abstractC0540h, this.f1854i);
        } else {
            abstractC0540h.mo1111D(' ');
        }
        abstractC0540h.mo1111D(']');
    }

    @Override // p042N0.InterfaceC0550r
    /* JADX INFO: renamed from: c */
    public final void mo1226c(AbstractC0637b abstractC0637b) {
        if (this.f1853h) {
            abstractC0637b.mo1113F(this.f1856k);
        } else {
            this.f1855j.getClass();
            abstractC0637b.mo1111D(':');
        }
    }

    @Override // p042N0.InterfaceC0550r
    /* JADX INFO: renamed from: d */
    public final void mo1227d(AbstractC0540h abstractC0540h) {
        if (!this.f1850e.mo1641a()) {
            this.f1854i++;
        }
        abstractC0540h.mo1111D('[');
    }

    @Override // p042N0.InterfaceC0550r
    /* JADX INFO: renamed from: e */
    public final void mo1228e(AbstractC0540h abstractC0540h) {
        this.f1855j.getClass();
        abstractC0540h.mo1111D(',');
        this.f1851f.mo1640b(abstractC0540h, this.f1854i);
    }

    @Override // p042N0.InterfaceC0550r
    /* JADX INFO: renamed from: f */
    public final void mo1229f(AbstractC0540h abstractC0540h) {
        abstractC0540h.mo1111D('{');
        if (this.f1851f.mo1641a()) {
            return;
        }
        this.f1854i++;
    }

    @Override // p042N0.InterfaceC0550r
    /* JADX INFO: renamed from: g */
    public final void mo1230g(AbstractC0540h abstractC0540h, int i3) {
        AbstractC0679f abstractC0679f = this.f1851f;
        if (!abstractC0679f.mo1641a()) {
            this.f1854i--;
        }
        if (i3 > 0) {
            abstractC0679f.mo1640b(abstractC0540h, this.f1854i);
        } else {
            abstractC0540h.mo1111D(' ');
        }
        abstractC0540h.mo1111D('}');
    }

    @Override // p042N0.InterfaceC0550r
    /* JADX INFO: renamed from: h */
    public final void mo1231h(AbstractC0637b abstractC0637b) {
        InterfaceC0551s interfaceC0551s = this.f1852g;
        if (interfaceC0551s != null) {
            abstractC0637b.mo1112E(interfaceC0551s);
        }
    }

    @Override // p042N0.InterfaceC0550r
    /* JADX INFO: renamed from: i */
    public final void mo1232i(AbstractC0637b abstractC0637b) {
        this.f1855j.getClass();
        abstractC0637b.mo1111D(',');
        this.f1850e.mo1640b(abstractC0637b, this.f1854i);
    }

    @Override // p042N0.InterfaceC0550r
    /* JADX INFO: renamed from: j */
    public final void mo1233j(AbstractC0540h abstractC0540h) {
        this.f1851f.mo1640b(abstractC0540h, this.f1854i);
    }

    public C0680g(C0680g c0680g) {
        InterfaceC0551s interfaceC0551s = c0680g.f1852g;
        this.f1850e = C0678e.f1848e;
        this.f1851f = C0677d.f1844h;
        this.f1853h = true;
        this.f1850e = c0680g.f1850e;
        this.f1851f = c0680g.f1851f;
        this.f1853h = c0680g.f1853h;
        this.f1854i = c0680g.f1854i;
        this.f1855j = c0680g.f1855j;
        this.f1856k = c0680g.f1856k;
        this.f1852g = interfaceC0551s;
    }
}
