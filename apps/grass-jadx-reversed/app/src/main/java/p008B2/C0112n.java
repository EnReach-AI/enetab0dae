package p008B2;

import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0112n extends AbstractC0099g0 {

    /* JADX INFO: renamed from: c */
    public static final C0112n f305c = new C0112n(C0114o.f308a);

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        char[] cArr = (char[]) obj;
        AbstractC1766e.m3920e("<this>", cArr);
        return cArr.length;
    }

    @Override // p008B2.AbstractC0120r, p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        C0110m c0110m = (C0110m) obj;
        AbstractC1766e.m3920e("builder", c0110m);
        char cMo76B = interfaceC0024a.mo76B(this.f286b, i3);
        c0110m.mo228b(c0110m.mo229d() + 1);
        char[] cArr = c0110m.f302a;
        int i4 = c0110m.f303b;
        c0110m.f303b = i4 + 1;
        cArr[i4] = cMo76B;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        char[] cArr = (char[]) obj;
        AbstractC1766e.m3920e("<this>", cArr);
        C0110m c0110m = new C0110m();
        c0110m.f302a = cArr;
        c0110m.f303b = cArr.length;
        c0110m.mo228b(10);
        return c0110m;
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: m */
    public final Object mo225m() {
        return new char[0];
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: n */
    public final void mo226n(C0198v c0198v, Object obj, int i3) {
        char[] cArr = (char[]) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("content", cArr);
        for (int i4 = 0; i4 < i3; i4++) {
            char c3 = cArr[i4];
            C0097f0 c0097f0 = this.f286b;
            AbstractC1766e.m3920e("descriptor", c0097f0);
            c0198v.m354f(c0097f0, i4);
            c0198v.m352d(c3);
        }
    }
}
