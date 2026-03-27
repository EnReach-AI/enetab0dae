package p087d0;

import java.util.ArrayList;
import p128p.C1808b;

/* JADX INFO: renamed from: d0.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1295n extends AbstractC1294m {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1808b f4635a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ViewTreeObserverOnPreDrawListenerC1296o f4636b;

    public C1295n(ViewTreeObserverOnPreDrawListenerC1296o viewTreeObserverOnPreDrawListenerC1296o, C1808b c1808b) {
        this.f4636b = viewTreeObserverOnPreDrawListenerC1296o;
        this.f4635a = c1808b;
    }

    @Override // p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: d */
    public final void mo3252d(AbstractC1293l abstractC1293l) {
        ((ArrayList) this.f4635a.getOrDefault(this.f4636b.f4638f, null)).remove(abstractC1293l);
        abstractC1293l.m3274u(this);
    }
}
