package p008B2;

import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p083b2.C1069n;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.r0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0121r0 extends AbstractC0099g0 {

    /* JADX INFO: renamed from: c */
    public static final C0121r0 f319c = new C0121r0(C0123s0.f322a);

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        byte[] bArr = ((C1069n) obj).f3753e;
        AbstractC1766e.m3920e("$this$collectionSize", bArr);
        return bArr.length;
    }

    @Override // p008B2.AbstractC0120r, p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        C0119q0 c0119q0 = (C0119q0) obj;
        AbstractC1766e.m3920e("builder", c0119q0);
        byte bMo98r = interfaceC0024a.mo87t(this.f286b, i3).mo98r();
        c0119q0.mo228b(c0119q0.mo229d() + 1);
        byte[] bArr = c0119q0.f316a;
        int i4 = c0119q0.f317b;
        c0119q0.f317b = i4 + 1;
        bArr[i4] = bMo98r;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        byte[] bArr = ((C1069n) obj).f3753e;
        AbstractC1766e.m3920e("$this$toBuilder", bArr);
        C0119q0 c0119q0 = new C0119q0();
        c0119q0.f316a = bArr;
        c0119q0.f317b = bArr.length;
        c0119q0.mo228b(10);
        return c0119q0;
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: m */
    public final Object mo225m() {
        return new C1069n(new byte[0]);
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: n */
    public final void mo226n(C0198v c0198v, Object obj, int i3) {
        byte[] bArr = ((C1069n) obj).f3753e;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("content", bArr);
        for (int i4 = 0; i4 < i3; i4++) {
            c0198v.m358j(this.f286b, i4).m351c(bArr[i4]);
        }
    }
}
