package p008B2;

import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p083b2.C1076u;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.A0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0059A0 extends AbstractC0099g0 {

    /* JADX INFO: renamed from: c */
    public static final C0059A0 f207c = new C0059A0(C0061B0.f210a);

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        short[] sArr = ((C1076u) obj).f3760e;
        AbstractC1766e.m3920e("$this$collectionSize", sArr);
        return sArr.length;
    }

    @Override // p008B2.AbstractC0120r, p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        C0137z0 c0137z0 = (C0137z0) obj;
        AbstractC1766e.m3920e("builder", c0137z0);
        short sMo100u = interfaceC0024a.mo87t(this.f286b, i3).mo100u();
        c0137z0.mo228b(c0137z0.mo229d() + 1);
        short[] sArr = c0137z0.f352a;
        int i4 = c0137z0.f353b;
        c0137z0.f353b = i4 + 1;
        sArr[i4] = sMo100u;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        short[] sArr = ((C1076u) obj).f3760e;
        AbstractC1766e.m3920e("$this$toBuilder", sArr);
        C0137z0 c0137z0 = new C0137z0();
        c0137z0.f352a = sArr;
        c0137z0.f353b = sArr.length;
        c0137z0.mo228b(10);
        return c0137z0;
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: m */
    public final Object mo225m() {
        return new C1076u(new short[0]);
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: n */
    public final void mo226n(C0198v c0198v, Object obj, int i3) {
        short[] sArr = ((C1076u) obj).f3760e;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("content", sArr);
        for (int i4 = 0; i4 < i3; i4++) {
            c0198v.m358j(this.f286b, i4).m364p(sArr[i4]);
        }
    }
}
