package p015D2;

import p011C2.C0148a;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: D2.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0184h extends C0181e {

    /* JADX INFO: renamed from: d */
    public final C0148a f426d;

    /* JADX INFO: renamed from: e */
    public int f427e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0184h(C0192p c0192p, C0148a c0148a) {
        super(c0192p);
        AbstractC1766e.m3920e("json", c0148a);
        this.f426d = c0148a;
    }

    @Override // p015D2.C0181e
    /* JADX INFO: renamed from: b */
    public final void mo304b() {
        this.f422b = true;
        this.f427e++;
    }

    @Override // p015D2.C0181e
    /* JADX INFO: renamed from: d */
    public final void mo306d() {
        this.f422b = false;
        m311i("\n");
        int i3 = this.f427e;
        for (int i4 = 0; i4 < i3; i4++) {
            m311i(this.f426d.f357a.f372g);
        }
    }

    @Override // p015D2.C0181e
    /* JADX INFO: renamed from: l */
    public final void mo314l() {
        m308f(' ');
    }

    @Override // p015D2.C0181e
    /* JADX INFO: renamed from: m */
    public final void mo315m() {
        this.f427e--;
    }
}
