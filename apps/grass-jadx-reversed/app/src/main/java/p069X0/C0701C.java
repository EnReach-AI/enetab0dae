package p069X0;

import java.io.Closeable;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import p042N0.AbstractC0540h;
import p042N0.C0537e;
import p042N0.EnumC0539g;
import p042N0.InterfaceC0550r;
import p050Q0.C0596i;
import p066W0.C0680g;
import p066W0.C0687n;
import p066W0.InterfaceC0681h;
import p109j1.C1503k;
import p112k1.AbstractC1640h;
import p112k1.AbstractC1644l;
import p112k1.C1639g;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: X0.C */
/* JADX INFO: loaded from: classes.dex */
public final class C0701C implements Serializable {

    /* JADX INFO: renamed from: k */
    public static final C0687n f1909k;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final C0707I f1910e;

    /* JADX INFO: renamed from: f */
    public final AbstractC1640h f1911f;

    /* JADX INFO: renamed from: g */
    public final AbstractC1644l f1912g;

    /* JADX INFO: renamed from: h */
    public final C0537e f1913h;

    /* JADX INFO: renamed from: i */
    public final C0699A f1914i = C0699A.f1905g;

    /* JADX INFO: renamed from: j */
    public final C0700B f1915j = C0700B.f1908e;

    static {
        String str = InterfaceC0550r.f1334b.f1531e;
        C0687n c0687n = new C0687n();
        c0687n.f1865e = str;
        c0687n.f1866f = InterfaceC0550r.f1333a;
        f1909k = c0687n;
    }

    public C0701C(C0734y c0734y, C0707I c0707i) {
        this.f1910e = c0707i;
        this.f1911f = c0734y.f2088h;
        this.f1912g = c0734y.f2089i;
        this.f1913h = c0734y.f2085e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public final void m1682a(AbstractC0540h abstractC0540h, C1503k c1503k) {
        EnumC0708J enumC0708J = EnumC0708J.CLOSE_CLOSEABLE;
        C0707I c0707i = this.f1910e;
        boolean zM1698r = c0707i.m1698r(enumC0708J);
        AbstractC1644l abstractC1644l = this.f1912g;
        AbstractC1640h abstractC1640h = this.f1911f;
        C0700B c0700b = this.f1915j;
        if (zM1698r && (c1503k instanceof Closeable)) {
            Closeable closeable = (Closeable) c1503k;
            try {
                C1639g c1639g = (C1639g) abstractC1640h;
                c1639g.getClass();
                C1639g c1639g2 = new C1639g(c1639g, c0707i, abstractC1644l);
                c0700b.getClass();
                c1639g2.m3724L(abstractC0540h, c1503k);
            } catch (Exception e3) {
                e = e3;
            }
            try {
                closeable.close();
                abstractC0540h.close();
                return;
            } catch (Exception e4) {
                e = e4;
                closeable = null;
                AbstractC1745j.m3884g(abstractC0540h, closeable, e);
                throw null;
            }
        }
        try {
            C1639g c1639g3 = (C1639g) abstractC1640h;
            c1639g3.getClass();
            C1639g c1639g4 = new C1639g(c1639g3, c0707i, abstractC1644l);
            c0700b.getClass();
            c1639g4.m3724L(abstractC0540h, c1503k);
            abstractC0540h.close();
        } catch (Exception e5) {
            Annotation[] annotationArr = AbstractC1745j.f6110a;
            abstractC0540h.mo1132e(EnumC0539g.AUTO_CLOSE_JSON_CONTENT);
            try {
                abstractC0540h.close();
            } catch (Exception e6) {
                e5.addSuppressed(e6);
            }
            AbstractC1745j.m3874D(e5);
            AbstractC1745j.m3875E(e5);
            throw new RuntimeException(e5);
        }
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC0540h m1683b(C0596i c0596i) {
        AbstractC0540h abstractC0540hM1099p = this.f1913h.m1099p(c0596i);
        this.f1910e.m1696p(abstractC0540hM1099p);
        C0699A c0699a = this.f1914i;
        InterfaceC0550r c0680g = c0699a.f1906e;
        if (c0680g != null) {
            if (c0680g == f1909k) {
                abstractC0540hM1099p.f1268e = null;
            } else {
                if (c0680g instanceof InterfaceC0681h) {
                    c0680g = new C0680g((C0680g) ((InterfaceC0681h) c0680g));
                }
                abstractC0540hM1099p.f1268e = c0680g;
            }
        }
        if (c0699a.f1907f != null) {
            abstractC0540hM1099p.mo1137j();
        }
        return abstractC0540hM1099p;
    }
}
