package p069X0;

import p042N0.AbstractC0540h;
import p042N0.EnumC0539g;
import p042N0.InterfaceC0550r;
import p066W0.C0680g;
import p066W0.InterfaceC0681h;
import p074Z0.AbstractC0832r;
import p074Z0.AbstractC0833s;
import p074Z0.C0815a;
import p074Z0.C0822h;
import p074Z0.C0828n;
import p074Z0.InterfaceC0826l;
import p082b1.C1005A;
import p082b1.C1006B;
import p082b1.C1026W;
import p103h1.C1425m;
import p118m1.C1761z;

/* JADX INFO: renamed from: X0.I */
/* JADX INFO: loaded from: classes.dex */
public final class C0707I extends AbstractC0833s {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: w */
    public static final C0680g f1932w = new C0680g();

    /* JADX INFO: renamed from: x */
    public static final int f1933x = AbstractC0832r.m2147b(EnumC0708J.class);

    /* JADX INFO: renamed from: q */
    public final InterfaceC0550r f1934q;

    /* JADX INFO: renamed from: r */
    public final int f1935r;

    /* JADX INFO: renamed from: s */
    public final int f1936s;

    /* JADX INFO: renamed from: t */
    public final int f1937t;

    /* JADX INFO: renamed from: u */
    public final int f1938u;

    /* JADX INFO: renamed from: v */
    public final int f1939v;

    public C0707I(C0815a c0815a, C1425m c1425m, C1026W c1026w, C1761z c1761z, C0822h c0822h, C0828n c0828n) {
        super(c0815a, c1425m, c1026w, c1761z, c0822h, c0828n);
        this.f1935r = f1933x;
        this.f1934q = f1932w;
        this.f1936s = 0;
        this.f1937t = 0;
        this.f1938u = 0;
        this.f1939v = 0;
    }

    @Override // p074Z0.AbstractC0832r
    /* JADX INFO: renamed from: m */
    public final boolean mo1694m(InterfaceC0826l interfaceC0826l) {
        return this.f2491n.m2143a(interfaceC0826l);
    }

    /* JADX INFO: renamed from: o */
    public final AbstractC0833s m1695o(long j2) {
        return new C0707I(this, j2, this.f1935r, this.f1936s, this.f1937t, this.f1938u, this.f1939v);
    }

    /* JADX INFO: renamed from: p */
    public final void m1696p(AbstractC0540h abstractC0540h) {
        int i3 = EnumC0708J.INDENT_OUTPUT.f1963f;
        int i4 = this.f1935r;
        if ((i3 & i4) != 0 && abstractC0540h.f1268e == null) {
            InterfaceC0550r c0680g = this.f1934q;
            if (c0680g instanceof InterfaceC0681h) {
                C0680g c0680g2 = (C0680g) ((InterfaceC0681h) c0680g);
                c0680g2.getClass();
                c0680g = new C0680g(c0680g2);
            }
            if (c0680g != null) {
                abstractC0540h.f1268e = c0680g;
            }
        }
        boolean z3 = (EnumC0708J.WRITE_BIGDECIMAL_AS_PLAIN.f1963f & i4) != 0;
        int i5 = this.f1937t;
        if (i5 != 0 || z3) {
            int i6 = this.f1936s;
            if (z3) {
                int i7 = EnumC0539g.WRITE_BIGDECIMAL_AS_PLAIN.f1267f;
                i6 |= i7;
                i5 |= i7;
            }
            abstractC0540h.mo1135h(i6, i5);
        }
        if (this.f1939v != 0) {
            abstractC0540h.getClass();
        }
    }

    /* JADX INFO: renamed from: q */
    public final C1005A m1697q(AbstractC0721l abstractC0721l) {
        ((C1006B) this.f2481f.f2420f).getClass();
        C1005A c1005aM2701b = C1006B.m2701b(this, abstractC0721l);
        if (c1005aM2701b != null) {
            return c1005aM2701b;
        }
        C1005A c1005aM2700a = C1006B.m2700a(this, abstractC0721l);
        return c1005aM2700a == null ? new C1005A(C1006B.m2703d(this, abstractC0721l, this, true)) : c1005aM2700a;
    }

    /* JADX INFO: renamed from: r */
    public final boolean m1698r(EnumC0708J enumC0708J) {
        return (enumC0708J.f1963f & this.f1935r) != 0;
    }

    public C0707I(C0707I c0707i, long j2, int i3, int i4, int i5, int i6, int i7) {
        super(c0707i, j2);
        this.f1935r = i3;
        this.f1934q = c0707i.f1934q;
        this.f1936s = i4;
        this.f1937t = i5;
        this.f1938u = i6;
        this.f1939v = i7;
    }
}
