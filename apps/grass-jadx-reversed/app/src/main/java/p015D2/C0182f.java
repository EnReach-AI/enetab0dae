package p015D2;

import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: D2.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0182f extends C0181e {

    /* JADX INFO: renamed from: d */
    public final boolean f424d;

    public C0182f(C0192p c0192p, boolean z3) {
        super(c0192p);
        this.f424d = z3;
    }

    @Override // p015D2.C0181e
    /* JADX INFO: renamed from: k */
    public final void mo313k(String str) {
        AbstractC1766e.m3920e("value", str);
        if (this.f424d) {
            super.mo313k(str);
        } else {
            m311i(str);
        }
    }
}
