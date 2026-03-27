package p008B2;

import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0094e extends AbstractC0099g0 {

    /* JADX INFO: renamed from: c */
    public static final C0094e f280c = new C0094e(C0096f.f281a);

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        AbstractC1766e.m3920e("<this>", zArr);
        return zArr.length;
    }

    @Override // p008B2.AbstractC0120r, p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        C0092d c0092d = (C0092d) obj;
        AbstractC1766e.m3920e("builder", c0092d);
        boolean zMo77a = interfaceC0024a.mo77a(this.f286b, i3);
        c0092d.mo228b(c0092d.mo229d() + 1);
        boolean[] zArr = c0092d.f267a;
        int i4 = c0092d.f268b;
        c0092d.f268b = i4 + 1;
        zArr[i4] = zMo77a;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        AbstractC1766e.m3920e("<this>", zArr);
        C0092d c0092d = new C0092d();
        c0092d.f267a = zArr;
        c0092d.f268b = zArr.length;
        c0092d.mo228b(10);
        return c0092d;
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: m */
    public final Object mo225m() {
        return new boolean[0];
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: n */
    public final void mo226n(C0198v c0198v, Object obj, int i3) {
        boolean[] zArr = (boolean[]) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("content", zArr);
        for (int i4 = 0; i4 < i3; i4++) {
            boolean z3 = zArr[i4];
            C0097f0 c0097f0 = this.f286b;
            AbstractC1766e.m3920e("descriptor", c0097f0);
            c0198v.m354f(c0097f0, i4);
            c0198v.m350b(z3);
        }
    }
}
