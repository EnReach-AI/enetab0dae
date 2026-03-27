package p008B2;

import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0100h extends AbstractC0099g0 {

    /* JADX INFO: renamed from: c */
    public static final C0100h f287c = new C0100h(C0102i.f290a);

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        byte[] bArr = (byte[]) obj;
        AbstractC1766e.m3920e("<this>", bArr);
        return bArr.length;
    }

    @Override // p008B2.AbstractC0120r, p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        C0098g c0098g = (C0098g) obj;
        AbstractC1766e.m3920e("builder", c0098g);
        byte bMo78b = interfaceC0024a.mo78b(this.f286b, i3);
        c0098g.mo228b(c0098g.mo229d() + 1);
        byte[] bArr = c0098g.f284a;
        int i4 = c0098g.f285b;
        c0098g.f285b = i4 + 1;
        bArr[i4] = bMo78b;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        byte[] bArr = (byte[]) obj;
        AbstractC1766e.m3920e("<this>", bArr);
        C0098g c0098g = new C0098g();
        c0098g.f284a = bArr;
        c0098g.f285b = bArr.length;
        c0098g.mo228b(10);
        return c0098g;
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: m */
    public final Object mo225m() {
        return new byte[0];
    }

    @Override // p008B2.AbstractC0099g0
    /* JADX INFO: renamed from: n */
    public final void mo226n(C0198v c0198v, Object obj, int i3) {
        byte[] bArr = (byte[]) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("content", bArr);
        for (int i4 = 0; i4 < i3; i4++) {
            byte b3 = bArr[i4];
            C0097f0 c0097f0 = this.f286b;
            AbstractC1766e.m3920e("descriptor", c0097f0);
            c0198v.m354f(c0097f0, i4);
            c0198v.m351c(b3);
        }
    }
}
