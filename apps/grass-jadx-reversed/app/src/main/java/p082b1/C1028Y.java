package p082b1;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import p005B.AbstractC0032g;
import p019F0.C0221e;
import p069X0.AbstractC0721l;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: b1.Y */
/* JADX INFO: loaded from: classes.dex */
public final class C1028Y extends AbstractC1041l {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: g */
    public final Class f3652g;

    /* JADX INFO: renamed from: h */
    public final AbstractC0721l f3653h;

    /* JADX INFO: renamed from: i */
    public final String f3654i;

    public C1028Y(InterfaceC1027X interfaceC1027X, Class cls, String str, AbstractC0721l abstractC0721l) {
        super(interfaceC1027X, null);
        this.f3652g = cls;
        this.f3653h = abstractC0721l;
        this.f3654i = str;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ AnnotatedElement mo2766a() {
        return null;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: d */
    public final String mo2767d() {
        return this.f3654i;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: e */
    public final Class mo2768e() {
        return this.f3653h.f2036e;
    }

    @Override // p082b1.AbstractC1031b
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!AbstractC1745j.m3896s(obj, C1028Y.class)) {
            return false;
        }
        C1028Y c1028y = (C1028Y) obj;
        return c1028y.f3652g == this.f3652g && c1028y.f3654i.equals(this.f3654i);
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: f */
    public final AbstractC0721l mo2769f() {
        return this.f3653h;
    }

    @Override // p082b1.AbstractC1031b
    public final int hashCode() {
        return this.f3654i.hashCode();
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: i */
    public final Class mo2770i() {
        return this.f3652g;
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: k */
    public final Member mo2771k() {
        return null;
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: l */
    public final Object mo2772l(Object obj) {
        throw new IllegalArgumentException(AbstractC0032g.m157o(new StringBuilder("Cannot get virtual property '"), this.f3654i, "'"));
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: n */
    public final AbstractC1031b mo2773n(C0221e c0221e) {
        return this;
    }

    @Override // p082b1.AbstractC1031b
    public final String toString() {
        return "[virtual " + mo2800j() + "]";
    }
}
