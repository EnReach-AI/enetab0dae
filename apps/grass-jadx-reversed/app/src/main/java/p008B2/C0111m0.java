package p008B2;

import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.m0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0111m0 extends AbstractC0099g0 {

    /* JADX INFO: renamed from: c */
    public static final C0111m0 f304c = new C0111m0(C0113n0.f306a);

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        short[] sArr = (short[]) obj;
        AbstractC1766e.m3920e("<this>", sArr);
        return sArr.length;
    }

    @Override // p008B2.AbstractC0120r, p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        C0109l0 c0109l0 = (C0109l0) obj;
        AbstractC1766e.m3920e("builder", c0109l0);
        short sMo83m = interfaceC0024a.mo83m(this.f286b, i3);
        c0109l0.mo228b(c0109l0.mo229d() + 1);
        short[] sArr = c0109l0.f300a;
        int i4 = c0109l0.f301b;
        c0109l0.f301b = i4 + 1;
        sArr[i4] = sMo83m;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        short[] sArr = (short[]) obj;
        AbstractC1766e.m3920e("<this>", sArr);
        C0109l0 c0109l0 = new C0109l0();
        c0109l0.f300a = sArr;
        c0109l0.f301b = sArr.length;
        c0109l0.mo228b(10);
        return c0109l0;
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: m */
    public final Object mo225m() {
        return new short[0];
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: n */
    public final void mo226n(C0198v c0198v, Object obj, int i3) {
        short[] sArr = (short[]) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("content", sArr);
        for (int i4 = 0; i4 < i3; i4++) {
            short s3 = sArr[i4];
            C0097f0 c0097f0 = this.f286b;
            AbstractC1766e.m3920e("descriptor", c0097f0);
            c0198v.m354f(c0097f0, i4);
            c0198v.m364p(s3);
        }
    }
}
