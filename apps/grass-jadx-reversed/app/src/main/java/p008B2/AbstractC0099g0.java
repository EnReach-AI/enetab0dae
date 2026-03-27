package p008B2;

import java.util.Iterator;
import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.g0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0099g0 extends AbstractC0120r {

    /* JADX INFO: renamed from: b */
    public final C0097f0 f286b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0099g0(InterfaceC2012a interfaceC2012a) {
        super(interfaceC2012a);
        AbstractC1766e.m3920e("primitiveSerializer", interfaceC2012a);
        this.f286b = new C0097f0(interfaceC2012a.mo221c());
    }

    @Override // p008B2.AbstractC0120r, p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        AbstractC1766e.m3920e("encoder", c0198v);
        int iMo222g = mo222g(obj);
        C0097f0 c0097f0 = this.f286b;
        AbstractC1766e.m3920e("descriptor", c0097f0);
        C0198v c0198vM349a = c0198v.m349a(c0097f0);
        mo226n(c0198vM349a, obj, iMo222g);
        c0198vM349a.m366r(c0097f0);
    }

    @Override // p008B2.AbstractC0086a, p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        return m253h(interfaceC0025b);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return this.f286b;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: d */
    public final Object mo241d() {
        return (AbstractC0095e0) mo224j(mo225m());
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: e */
    public final int mo242e(Object obj) {
        AbstractC0095e0 abstractC0095e0 = (AbstractC0095e0) obj;
        AbstractC1766e.m3920e("<this>", abstractC0095e0);
        return abstractC0095e0.mo229d();
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: f */
    public final Iterator mo243f(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: k */
    public final Object mo244k(Object obj) {
        AbstractC0095e0 abstractC0095e0 = (AbstractC0095e0) obj;
        AbstractC1766e.m3920e("<this>", abstractC0095e0);
        return abstractC0095e0.mo227a();
    }

    @Override // p008B2.AbstractC0120r
    /* JADX INFO: renamed from: l */
    public final void mo262l(Object obj, int i3, Object obj2) {
        AbstractC1766e.m3920e("<this>", (AbstractC0095e0) obj);
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    /* JADX INFO: renamed from: m */
    public abstract Object mo225m();

    /* JADX INFO: renamed from: n */
    public abstract void mo226n(C0198v c0198v, Object obj, int i3);
}
