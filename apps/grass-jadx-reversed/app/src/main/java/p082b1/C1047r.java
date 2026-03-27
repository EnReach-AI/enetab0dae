package p082b1;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import p019F0.C0221e;
import p069X0.AbstractC0721l;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: b1.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1047r extends AbstractC1041l {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: g */
    public final AbstractC1048s f3714g;

    /* JADX INFO: renamed from: h */
    public final AbstractC0721l f3715h;

    /* JADX INFO: renamed from: i */
    public final int f3716i;

    public C1047r(AbstractC1048s abstractC1048s, AbstractC0721l abstractC0721l, InterfaceC1027X interfaceC1027X, C0221e c0221e, int i3) {
        super(interfaceC1027X, c0221e);
        this.f3714g = abstractC1048s;
        this.f3715h = abstractC0721l;
        this.f3716i = i3;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: a */
    public final AnnotatedElement mo2766a() {
        return null;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: d */
    public final String mo2767d() {
        return "";
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: e */
    public final Class mo2768e() {
        return this.f3715h.f2036e;
    }

    @Override // p082b1.AbstractC1031b
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!AbstractC1745j.m3896s(obj, C1047r.class)) {
            return false;
        }
        C1047r c1047r = (C1047r) obj;
        return c1047r.f3714g.equals(this.f3714g) && c1047r.f3716i == this.f3716i;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: f */
    public final AbstractC0721l mo2769f() {
        return this.f3715h;
    }

    @Override // p082b1.AbstractC1031b
    public final int hashCode() {
        return this.f3714g.hashCode() + this.f3716i;
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: i */
    public final Class mo2770i() {
        return this.f3714g.mo2770i();
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: k */
    public final Member mo2771k() {
        return this.f3714g.mo2771k();
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: l */
    public final Object mo2772l(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of ".concat(this.f3714g.mo2770i().getName()));
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: n */
    public final AbstractC1031b mo2773n(C0221e c0221e) {
        if (c0221e == this.f3700f) {
            return this;
        }
        AbstractC1048s abstractC1048s = this.f3714g;
        C0221e[] c0221eArr = abstractC1048s.f3717g;
        int i3 = this.f3716i;
        c0221eArr[i3] = c0221e;
        return abstractC1048s.m2805r(i3);
    }

    @Override // p082b1.AbstractC1031b
    public final String toString() {
        return "[parameter #" + this.f3716i + ", annotations: " + this.f3700f + "]";
    }
}
