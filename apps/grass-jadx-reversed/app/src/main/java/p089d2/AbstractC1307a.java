package p089d2;

import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: d2.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1307a implements InterfaceC1315i {
    private final InterfaceC1316j key;

    public AbstractC1307a(InterfaceC1316j interfaceC1316j) {
        this.key = interfaceC1316j;
    }

    @Override // p089d2.InterfaceC1317k
    public <R> R fold(R r3, InterfaceC1693p interfaceC1693p) {
        AbstractC1766e.m3920e("operation", interfaceC1693p);
        return (R) interfaceC1693p.mo317c(r3, this);
    }

    @Override // p089d2.InterfaceC1317k
    public <E extends InterfaceC1315i> E get(InterfaceC1316j interfaceC1316j) {
        AbstractC1766e.m3920e("key", interfaceC1316j);
        if (AbstractC1766e.m3916a(getKey(), interfaceC1316j)) {
            return this;
        }
        return null;
    }

    @Override // p089d2.InterfaceC1315i
    public InterfaceC1316j getKey() {
        return this.key;
    }

    @Override // p089d2.InterfaceC1317k
    public InterfaceC1317k minusKey(InterfaceC1316j interfaceC1316j) {
        AbstractC1766e.m3920e("key", interfaceC1316j);
        return AbstractC1766e.m3916a(getKey(), interfaceC1316j) ? C1318l.f4678e : this;
    }

    @Override // p089d2.InterfaceC1317k
    public InterfaceC1317k plus(InterfaceC1317k interfaceC1317k) {
        AbstractC1766e.m3920e("context", interfaceC1317k);
        return interfaceC1317k == C1318l.f4678e ? this : (InterfaceC1317k) interfaceC1317k.fold(this, C1309c.f4670h);
    }
}
