package p118m1;

import java.util.Collections;
import java.util.Iterator;
import p039M0.C0453A;
import p039M0.EnumC0511z;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p069X0.C0702D;
import p069X0.C0703E;
import p074Z0.AbstractC0832r;
import p082b1.AbstractC1007C;
import p082b1.AbstractC1041l;
import p082b1.C1028Y;
import p082b1.C1039j;
import p082b1.C1043n;
import p082b1.C1047r;
import p114l1.C1675q;

/* JADX INFO: renamed from: m1.A */
/* JADX INFO: loaded from: classes.dex */
public final class C1726A extends AbstractC1007C {

    /* JADX INFO: renamed from: f */
    public final AbstractC0711b f6021f;

    /* JADX INFO: renamed from: g */
    public final AbstractC1041l f6022g;

    /* JADX INFO: renamed from: h */
    public final C0702D f6023h;

    /* JADX INFO: renamed from: i */
    public final C0703E f6024i;

    /* JADX INFO: renamed from: j */
    public final C0453A f6025j;

    public C1726A(AbstractC0711b abstractC0711b, AbstractC1041l abstractC1041l, C0703E c0703e, C0702D c0702d, C0453A c0453a) {
        this.f6021f = abstractC0711b;
        this.f6022g = abstractC1041l;
        this.f6024i = c0703e;
        this.f6023h = c0702d == null ? C0702D.f1917m : c0702d;
        this.f6025j = c0453a;
    }

    /* JADX INFO: renamed from: C */
    public static C1726A m3836C(AbstractC0832r abstractC0832r, C1028Y c1028y, C0703E c0703e, C0702D c0702d, EnumC0511z enumC0511z) {
        C0453A c0453a;
        EnumC0511z enumC0511z2;
        if (enumC0511z == null || enumC0511z == (enumC0511z2 = EnumC0511z.f1186i)) {
            c0453a = AbstractC1007C.f3592e;
        } else {
            C0453A c0453a2 = C0453A.f1095i;
            c0453a = enumC0511z != enumC0511z2 ? new C0453A(enumC0511z, null, null, null) : C0453A.f1095i;
        }
        return new C1726A(abstractC0832r.m2149d(), c1028y, c0703e, c0702d, c0453a);
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: A */
    public final boolean mo2704A() {
        return false;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: a */
    public final C0703E mo2706a() {
        return this.f6024i;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: b */
    public final C0702D mo2707b() {
        return this.f6023h;
    }

    @Override // p118m1.InterfaceC1758w
    /* JADX INFO: renamed from: f */
    public final String mo1808f() {
        return this.f6024i.f1928e;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: i */
    public final C0453A mo2710i() {
        return this.f6025j;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: n */
    public final C1047r mo2715n() {
        AbstractC1041l abstractC1041l = this.f6022g;
        if (abstractC1041l instanceof C1047r) {
            return (C1047r) abstractC1041l;
        }
        return null;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: o */
    public final Iterator mo2716o() {
        C1047r c1047rMo2715n = mo2715n();
        return c1047rMo2715n == null ? AbstractC1745j.f6112c : Collections.singleton(c1047rMo2715n).iterator();
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: p */
    public final C1039j mo2717p() {
        AbstractC1041l abstractC1041l = this.f6022g;
        if (abstractC1041l instanceof C1039j) {
            return (C1039j) abstractC1041l;
        }
        return null;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: q */
    public final C1043n mo2718q() {
        AbstractC1041l abstractC1041l = this.f6022g;
        if ((abstractC1041l instanceof C1043n) && ((C1043n) abstractC1041l).f3704h.getParameterCount() == 0) {
            return (C1043n) abstractC1041l;
        }
        return null;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: r */
    public final AbstractC0721l mo2719r() {
        AbstractC1041l abstractC1041l = this.f6022g;
        return abstractC1041l == null ? C1675q.m3773n() : abstractC1041l.mo2769f();
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: s */
    public final Class mo2720s() {
        AbstractC1041l abstractC1041l = this.f6022g;
        return abstractC1041l == null ? Object.class : abstractC1041l.mo2768e();
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: t */
    public final C1043n mo2721t() {
        AbstractC1041l abstractC1041l = this.f6022g;
        if ((abstractC1041l instanceof C1043n) && ((C1043n) abstractC1041l).f3704h.getParameterCount() == 1) {
            return (C1043n) abstractC1041l;
        }
        return null;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: u */
    public final C0703E mo2722u() {
        AbstractC0711b abstractC0711b = this.f6021f;
        if (abstractC0711b != null && this.f6022g != null) {
            abstractC0711b.getClass();
        }
        return null;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: v */
    public final boolean mo2723v() {
        return this.f6022g instanceof C1047r;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: w */
    public final boolean mo2724w() {
        return this.f6022g instanceof C1039j;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: x */
    public final boolean mo2725x(C0703E c0703e) {
        return this.f6024i.equals(c0703e);
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: y */
    public final boolean mo2726y() {
        return mo2721t() != null;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: z */
    public final boolean mo2727z() {
        return false;
    }
}
