package p097f2;

import p005B.AbstractC0032g;
import p089d2.C1313g;
import p089d2.InterfaceC1312f;
import p089d2.InterfaceC1315i;
import p089d2.InterfaceC1317k;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: f2.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1350c extends AbstractC1348a {

    /* JADX INFO: renamed from: f */
    public final InterfaceC1317k f4816f;

    /* JADX INFO: renamed from: g */
    public transient C1349b f4817g;

    public AbstractC1350c(InterfaceC1312f interfaceC1312f, InterfaceC1317k interfaceC1317k) {
        super(interfaceC1312f);
        this.f4816f = interfaceC1317k;
    }

    @Override // p089d2.InterfaceC1312f
    /* JADX INFO: renamed from: d */
    public final InterfaceC1317k mo3283d() {
        InterfaceC1317k interfaceC1317k = this.f4816f;
        AbstractC1766e.m3917b(interfaceC1317k);
        return interfaceC1317k;
    }

    @Override // p097f2.AbstractC1348a
    /* JADX INFO: renamed from: h */
    public final void mo3303h() {
        C1349b c1349b = this.f4817g;
        if (c1349b == null || c1349b == this) {
            this.f4817g = C1349b.f4815e;
            return;
        }
        InterfaceC1317k interfaceC1317k = this.f4816f;
        AbstractC1766e.m3917b(interfaceC1317k);
        InterfaceC1315i interfaceC1315i = interfaceC1317k.get(C1313g.f4676a);
        AbstractC1766e.m3917b(interfaceC1315i);
        AbstractC0032g.m162t(c1349b);
        throw null;
    }
}
