package p008B2;

import java.util.Iterator;
import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0120r extends AbstractC0086a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2012a f318a;

    public AbstractC0120r(InterfaceC2012a interfaceC2012a) {
        this.f318a = interfaceC2012a;
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public void mo219a(C0198v c0198v, Object obj) {
        AbstractC1766e.m3920e("encoder", c0198v);
        int iMo222g = mo222g(obj);
        InterfaceC2095g interfaceC2095gMo221c = mo221c();
        AbstractC1766e.m3920e("descriptor", interfaceC2095gMo221c);
        C0198v c0198vM349a = c0198v.m349a(interfaceC2095gMo221c);
        Iterator itMo243f = mo243f(obj);
        for (int i3 = 0; i3 < iMo222g; i3++) {
            c0198vM349a.m362n(mo221c(), i3, this.f318a, itMo243f.next());
        }
        c0198vM349a.m366r(interfaceC2095gMo221c);
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: i */
    public void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3) {
        mo262l(obj, i3, interfaceC0024a.mo85p(mo221c(), i3, this.f318a, null));
    }

    /* JADX INFO: renamed from: l */
    public abstract void mo262l(Object obj, int i3, Object obj2);
}
