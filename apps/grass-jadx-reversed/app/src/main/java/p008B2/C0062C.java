package p008B2;

import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.C */
/* JADX INFO: loaded from: classes.dex */
public final class C0062C extends AbstractC0099g0 {

    /* JADX INFO: renamed from: c */
    public static final C0062C f212c = new C0062C(C0064D.f215a);

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        float[] fArr = (float[]) obj;
        AbstractC1766e.m3920e("<this>", fArr);
        return fArr.length;
    }

    @Override // p008B2.AbstractC0120r, p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        C0060B c0060b = (C0060B) obj;
        AbstractC1766e.m3920e("builder", c0060b);
        float fMo80e = interfaceC0024a.mo80e(this.f286b, i3);
        c0060b.mo228b(c0060b.mo229d() + 1);
        float[] fArr = c0060b.f208a;
        int i4 = c0060b.f209b;
        c0060b.f209b = i4 + 1;
        fArr[i4] = fMo80e;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        float[] fArr = (float[]) obj;
        AbstractC1766e.m3920e("<this>", fArr);
        C0060B c0060b = new C0060B();
        c0060b.f208a = fArr;
        c0060b.f209b = fArr.length;
        c0060b.mo228b(10);
        return c0060b;
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: m */
    public final Object mo225m() {
        return new float[0];
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: n */
    public final void mo226n(C0198v c0198v, Object obj, int i3) {
        float[] fArr = (float[]) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("content", fArr);
        for (int i4 = 0; i4 < i3; i4++) {
            float f3 = fArr[i4];
            C0097f0 c0097f0 = this.f286b;
            AbstractC1766e.m3920e("descriptor", c0097f0);
            c0198v.m354f(c0097f0, i4);
            c0198v.m356h(f3);
        }
    }
}
