package p008B2;

import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p083b2.C1071p;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.u0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0127u0 extends AbstractC0099g0 {

    /* JADX INFO: renamed from: c */
    public static final C0127u0 f329c = new C0127u0(C0129v0.f332a);

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        int[] iArr = ((C1071p) obj).f3755e;
        AbstractC1766e.m3920e("$this$collectionSize", iArr);
        return iArr.length;
    }

    @Override // p008B2.AbstractC0120r, p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        C0125t0 c0125t0 = (C0125t0) obj;
        AbstractC1766e.m3920e("builder", c0125t0);
        int iMo93h = interfaceC0024a.mo87t(this.f286b, i3).mo93h();
        c0125t0.mo228b(c0125t0.mo229d() + 1);
        int[] iArr = c0125t0.f325a;
        int i4 = c0125t0.f326b;
        c0125t0.f326b = i4 + 1;
        iArr[i4] = iMo93h;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        int[] iArr = ((C1071p) obj).f3755e;
        AbstractC1766e.m3920e("$this$toBuilder", iArr);
        C0125t0 c0125t0 = new C0125t0();
        c0125t0.f325a = iArr;
        c0125t0.f326b = iArr.length;
        c0125t0.mo228b(10);
        return c0125t0;
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: m */
    public final Object mo225m() {
        return new C1071p(new int[0]);
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: n */
    public final void mo226n(C0198v c0198v, Object obj, int i3) {
        int[] iArr = ((C1071p) obj).f3755e;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("content", iArr);
        for (int i4 = 0; i4 < i3; i4++) {
            c0198v.m358j(this.f286b, i4).m359k(iArr[i4]);
        }
    }
}
