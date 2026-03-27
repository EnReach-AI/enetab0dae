package p069X0;

import p001A.C0009j;
import p074Z0.AbstractC0832r;
import p074Z0.AbstractC0833s;
import p074Z0.C0815a;
import p074Z0.C0818d;
import p074Z0.C0822h;
import p074Z0.C0823i;
import p074Z0.C0828n;
import p074Z0.InterfaceC0826l;
import p082b1.C1005A;
import p082b1.C1006B;
import p082b1.C1026W;
import p103h1.C1425m;
import p109j1.C1505m;
import p118m1.C1761z;

/* JADX INFO: renamed from: X0.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0717h extends AbstractC0833s {
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: z */
    public static final int f1986z = AbstractC0832r.m2147b(EnumC0719j.class);

    /* JADX INFO: renamed from: q */
    public final C0009j f1987q;

    /* JADX INFO: renamed from: r */
    public final C1505m f1988r;

    /* JADX INFO: renamed from: s */
    public final C0818d f1989s;

    /* JADX INFO: renamed from: t */
    public final C0823i f1990t;

    /* JADX INFO: renamed from: u */
    public final int f1991u;

    /* JADX INFO: renamed from: v */
    public final int f1992v;

    /* JADX INFO: renamed from: w */
    public final int f1993w;

    /* JADX INFO: renamed from: x */
    public final int f1994x;

    /* JADX INFO: renamed from: y */
    public final int f1995y;

    public C0717h(C0815a c0815a, C1425m c1425m, C1026W c1026w, C1761z c1761z, C0822h c0822h, C0818d c0818d, C0828n c0828n) {
        super(c0815a, c1425m, c1026w, c1761z, c0822h, c0828n);
        this.f1991u = f1986z;
        this.f1987q = null;
        this.f1988r = C1505m.f5450e;
        this.f1990t = null;
        this.f1989s = c0818d;
        this.f1992v = 0;
        this.f1993w = 0;
        this.f1994x = 0;
        this.f1995y = 0;
    }

    @Override // p074Z0.AbstractC0832r
    /* JADX INFO: renamed from: m */
    public final boolean mo1694m(InterfaceC0826l interfaceC0826l) {
        return this.f2491n.m2143a(interfaceC0826l);
    }

    /* JADX INFO: renamed from: o */
    public final AbstractC0833s m1817o(long j2) {
        return new C0717h(this, j2, this.f1991u, this.f1992v, this.f1993w, this.f1994x, this.f1995y);
    }

    /* JADX INFO: renamed from: p */
    public final C1005A m1818p(AbstractC0721l abstractC0721l) {
        ((C1006B) this.f2481f.f2420f).getClass();
        C1005A c1005aM2701b = C1006B.m2701b(this, abstractC0721l);
        if (c1005aM2701b != null) {
            return c1005aM2701b;
        }
        C1005A c1005aM2700a = C1006B.m2700a(this, abstractC0721l);
        return c1005aM2700a == null ? new C1005A(C1006B.m2703d(this, abstractC0721l, this, false)) : c1005aM2700a;
    }

    /* JADX INFO: renamed from: q */
    public final C1005A m1819q(AbstractC0721l abstractC0721l) {
        ((C1006B) this.f2481f.f2420f).getClass();
        C1005A c1005aM2701b = C1006B.m2701b(this, abstractC0721l);
        if (c1005aM2701b != null) {
            return c1005aM2701b;
        }
        C1005A c1005aM2700a = C1006B.m2700a(this, abstractC0721l);
        return c1005aM2700a == null ? new C1005A(C1006B.m2703d(this, abstractC0721l, this, false)) : c1005aM2700a;
    }

    /* JADX INFO: renamed from: r */
    public final boolean m1820r(EnumC0719j enumC0719j) {
        return (enumC0719j.f2035f & this.f1991u) != 0;
    }

    public C0717h(C0717h c0717h, long j2, int i3, int i4, int i5, int i6, int i7) {
        super(c0717h, j2);
        this.f1991u = i3;
        this.f1987q = c0717h.f1987q;
        this.f1988r = c0717h.f1988r;
        this.f1989s = c0717h.f1989s;
        this.f1990t = c0717h.f1990t;
        this.f1992v = i4;
        this.f1993w = i5;
        this.f1994x = i6;
        this.f1995y = i7;
    }
}
