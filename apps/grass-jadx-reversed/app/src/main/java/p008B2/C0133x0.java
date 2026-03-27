package p008B2;

import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p083b2.C1073r;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.x0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0133x0 extends AbstractC0099g0 {

    /* JADX INFO: renamed from: c */
    public static final C0133x0 f344c = new C0133x0(C0135y0.f347a);

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        long[] jArr = ((C1073r) obj).f3757e;
        AbstractC1766e.m3920e("$this$collectionSize", jArr);
        return jArr.length;
    }

    @Override // p008B2.AbstractC0120r, p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        C0131w0 c0131w0 = (C0131w0) obj;
        AbstractC1766e.m3920e("builder", c0131w0);
        long jMo91c = interfaceC0024a.mo87t(this.f286b, i3).mo91c();
        c0131w0.mo228b(c0131w0.mo229d() + 1);
        long[] jArr = c0131w0.f339a;
        int i4 = c0131w0.f340b;
        c0131w0.f340b = i4 + 1;
        jArr[i4] = jMo91c;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        long[] jArr = ((C1073r) obj).f3757e;
        AbstractC1766e.m3920e("$this$toBuilder", jArr);
        C0131w0 c0131w0 = new C0131w0();
        c0131w0.f339a = jArr;
        c0131w0.f340b = jArr.length;
        c0131w0.mo228b(10);
        return c0131w0;
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: m */
    public final Object mo225m() {
        return new C1073r(new long[0]);
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: n */
    public final void mo226n(C0198v c0198v, Object obj, int i3) {
        long[] jArr = ((C1073r) obj).f3757e;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("content", jArr);
        for (int i4 = 0; i4 < i3; i4++) {
            c0198v.m358j(this.f286b, i4).m360l(jArr[i4]);
        }
    }
}
