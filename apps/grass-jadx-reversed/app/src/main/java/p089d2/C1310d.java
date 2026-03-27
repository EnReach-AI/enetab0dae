package p089d2;

import p083b2.C1077v;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;
import p119m2.C1769h;

/* JADX INFO: renamed from: d2.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1310d extends AbstractC1767f implements InterfaceC1693p {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ InterfaceC1317k[] f4672f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ C1769h f4673g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1310d(InterfaceC1317k[] interfaceC1317kArr, C1769h c1769h) {
        super(2);
        this.f4672f = interfaceC1317kArr;
        this.f4673g = c1769h;
    }

    @Override // p115l2.InterfaceC1693p
    /* JADX INFO: renamed from: c */
    public final Object mo317c(Object obj, Object obj2) {
        InterfaceC1315i interfaceC1315i = (InterfaceC1315i) obj2;
        AbstractC1766e.m3920e("<anonymous parameter 0>", (C1077v) obj);
        AbstractC1766e.m3920e("element", interfaceC1315i);
        C1769h c1769h = this.f4673g;
        int i3 = c1769h.f6146e;
        c1769h.f6146e = i3 + 1;
        this.f4672f[i3] = interfaceC1315i;
        return C1077v.f3761a;
    }
}
