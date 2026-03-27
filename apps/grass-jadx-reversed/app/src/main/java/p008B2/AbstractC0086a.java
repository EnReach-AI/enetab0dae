package p008B2;

import java.util.Iterator;
import p004A2.InterfaceC0024a;
import p004A2.InterfaceC0025b;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;

/* JADX INFO: renamed from: B2.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0086a implements InterfaceC2012a {
    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        return m253h(interfaceC0025b);
    }

    /* JADX INFO: renamed from: d */
    public abstract Object mo241d();

    /* JADX INFO: renamed from: e */
    public abstract int mo242e(Object obj);

    /* JADX INFO: renamed from: f */
    public abstract Iterator mo243f(Object obj);

    /* JADX INFO: renamed from: g */
    public abstract int mo222g(Object obj);

    /* JADX INFO: renamed from: h */
    public final Object m253h(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        Object objMo241d = mo241d();
        int iMo242e = mo242e(objMo241d);
        InterfaceC0024a interfaceC0024aMo94i = interfaceC0025b.mo94i(mo221c());
        while (true) {
            int iMo86q = interfaceC0024aMo94i.mo86q(mo221c());
            if (iMo86q == -1) {
                interfaceC0024aMo94i.mo88w(mo221c());
                return mo244k(objMo241d);
            }
            mo223i(interfaceC0024aMo94i, iMo86q + iMo242e, objMo241d, true);
        }
    }

    /* JADX INFO: renamed from: i */
    public abstract void mo223i(InterfaceC0024a interfaceC0024a, int i3, Object obj, boolean z3);

    /* JADX INFO: renamed from: j */
    public abstract Object mo224j(Object obj);

    /* JADX INFO: renamed from: k */
    public abstract Object mo244k(Object obj);
}
