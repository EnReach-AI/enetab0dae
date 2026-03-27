package p008B2;

import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.J */
/* JADX INFO: loaded from: classes.dex */
public final class C0070J extends AbstractC0099g0 {

    /* JADX INFO: renamed from: c */
    public static final C0070J f230c = new C0070J(C0071K.f231a);

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        int[] iArr = (int[]) obj;
        AbstractC1766e.m3920e("<this>", iArr);
        return iArr.length;
    }

    @Override // p008B2.AbstractC0120r, p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        C0069I c0069i = (C0069I) obj;
        AbstractC1766e.m3920e("builder", c0069i);
        int iMo81f = interfaceC0024a.mo81f(this.f286b, i3);
        c0069i.mo228b(c0069i.mo229d() + 1);
        int[] iArr = c0069i.f228a;
        int i4 = c0069i.f229b;
        c0069i.f229b = i4 + 1;
        iArr[i4] = iMo81f;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        int[] iArr = (int[]) obj;
        AbstractC1766e.m3920e("<this>", iArr);
        C0069I c0069i = new C0069I();
        c0069i.f228a = iArr;
        c0069i.f229b = iArr.length;
        c0069i.mo228b(10);
        return c0069i;
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: m */
    public final Object mo225m() {
        return new int[0];
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: n */
    public final void mo226n(C0198v c0198v, Object obj, int i3) {
        int[] iArr = (int[]) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("content", iArr);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            C0097f0 c0097f0 = this.f286b;
            AbstractC1766e.m3920e("descriptor", c0097f0);
            c0198v.m354f(c0097f0, i4);
            c0198v.m359k(i5);
        }
    }
}
