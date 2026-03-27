package p074Z0;

import java.io.Serializable;
import p066W0.AbstractC0692s;

/* JADX INFO: renamed from: Z0.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0828n implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final int f2459e;

    /* JADX INFO: renamed from: f */
    public final int f2460f;

    public C0828n(int i3, int i4) {
        this.f2459e = i3;
        this.f2460f = i4;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m2143a(InterfaceC0826l interfaceC0826l) {
        int iMo2142d = interfaceC0826l.mo2142d();
        if (iMo2142d == 0) {
            return interfaceC0826l.mo1643c(this.f2459e);
        }
        if (iMo2142d == 1) {
            return interfaceC0826l.mo1643c(this.f2460f);
        }
        AbstractC0692s.m1666a();
        throw null;
    }
}
