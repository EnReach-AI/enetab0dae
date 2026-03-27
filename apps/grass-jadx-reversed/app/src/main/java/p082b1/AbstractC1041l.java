package p082b1;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import p019F0.C0221e;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: b1.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1041l extends AbstractC1031b implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final transient InterfaceC1027X f3699e;

    /* JADX INFO: renamed from: f */
    public final transient C0221e f3700f;

    public AbstractC1041l(InterfaceC1027X interfaceC1027X, C0221e c0221e) {
        this.f3699e = interfaceC1027X;
        this.f3700f = c0221e;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: c */
    public final Annotation mo2774c(Class cls) {
        C0221e c0221e = this.f3700f;
        if (c0221e == null) {
            return null;
        }
        return c0221e.mo442a(cls);
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: g */
    public final boolean mo2775g(Class[] clsArr) {
        C0221e c0221e = this.f3700f;
        if (c0221e == null) {
            return false;
        }
        return c0221e.mo454o(clsArr);
    }

    /* JADX INFO: renamed from: h */
    public final void m2799h(boolean z3) {
        Member memberMo2771k = mo2771k();
        if (memberMo2771k != null) {
            AbstractC1745j.m3882e(memberMo2771k, z3);
        }
    }

    /* JADX INFO: renamed from: i */
    public abstract Class mo2770i();

    /* JADX INFO: renamed from: j */
    public String mo2800j() {
        return mo2770i().getName() + "#" + mo2767d();
    }

    /* JADX INFO: renamed from: k */
    public abstract Member mo2771k();

    /* JADX INFO: renamed from: l */
    public abstract Object mo2772l(Object obj);

    /* JADX INFO: renamed from: m */
    public final boolean m2801m(Class cls) {
        C0221e c0221e = this.f3700f;
        if (c0221e == null) {
            return false;
        }
        return c0221e.m459w(cls);
    }

    /* JADX INFO: renamed from: n */
    public abstract AbstractC1031b mo2773n(C0221e c0221e);
}
