package p150u2;

import p005B.AbstractC0032g;
import p089d2.InterfaceC1317k;

/* JADX INFO: renamed from: u2.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1969r extends AbstractC1954c {

    /* JADX INFO: renamed from: f */
    public static final /* synthetic */ int f6985f = 0;

    static {
        new C1969r();
    }

    @Override // p150u2.AbstractC1954c
    /* JADX INFO: renamed from: a */
    public final void mo3742a(InterfaceC1317k interfaceC1317k, Runnable runnable) {
        AbstractC0032g.m159q(interfaceC1317k.get(AbstractC1970s.f6986e));
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // p150u2.AbstractC1954c
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
