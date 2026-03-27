package p008B2;

import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.O */
/* JADX INFO: loaded from: classes.dex */
public final class C0075O extends AbstractC0099g0 {

    /* JADX INFO: renamed from: c */
    public static final C0075O f238c = new C0075O(C0076P.f239a);

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        long[] jArr = (long[]) obj;
        AbstractC1766e.m3920e("<this>", jArr);
        return jArr.length;
    }

    @Override // p008B2.AbstractC0120r, p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        C0074N c0074n = (C0074N) obj;
        AbstractC1766e.m3920e("builder", c0074n);
        long jMo89z = interfaceC0024a.mo89z(this.f286b, i3);
        c0074n.mo228b(c0074n.mo229d() + 1);
        long[] jArr = c0074n.f236a;
        int i4 = c0074n.f237b;
        c0074n.f237b = i4 + 1;
        jArr[i4] = jMo89z;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        long[] jArr = (long[]) obj;
        AbstractC1766e.m3920e("<this>", jArr);
        C0074N c0074n = new C0074N();
        c0074n.f236a = jArr;
        c0074n.f237b = jArr.length;
        c0074n.mo228b(10);
        return c0074n;
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: m */
    public final Object mo225m() {
        return new long[0];
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: n */
    public final void mo226n(C0198v c0198v, Object obj, int i3) {
        long[] jArr = (long[]) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("content", jArr);
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = jArr[i4];
            C0097f0 c0097f0 = this.f286b;
            AbstractC1766e.m3920e("descriptor", c0097f0);
            c0198v.m354f(c0097f0, i4);
            c0198v.m360l(j2);
        }
    }
}
