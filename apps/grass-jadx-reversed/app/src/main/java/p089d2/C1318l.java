package p089d2;

import java.io.Serializable;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: d2.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1318l implements InterfaceC1317k, Serializable {

    /* JADX INFO: renamed from: e */
    public static final C1318l f4678e = new C1318l();
    private static final long serialVersionUID = 0;

    private final Object readResolve() {
        return f4678e;
    }

    @Override // p089d2.InterfaceC1317k
    public final Object fold(Object obj, InterfaceC1693p interfaceC1693p) {
        return obj;
    }

    @Override // p089d2.InterfaceC1317k
    public final InterfaceC1315i get(InterfaceC1316j interfaceC1316j) {
        AbstractC1766e.m3920e("key", interfaceC1316j);
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // p089d2.InterfaceC1317k
    public final InterfaceC1317k minusKey(InterfaceC1316j interfaceC1316j) {
        AbstractC1766e.m3920e("key", interfaceC1316j);
        return this;
    }

    @Override // p089d2.InterfaceC1317k
    public final InterfaceC1317k plus(InterfaceC1317k interfaceC1317k) {
        AbstractC1766e.m3920e("context", interfaceC1317k);
        return interfaceC1317k;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }
}
