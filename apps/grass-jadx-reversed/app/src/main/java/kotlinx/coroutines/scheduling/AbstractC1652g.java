package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import p089d2.InterfaceC1317k;
import p150u2.AbstractC1966o;

/* JADX INFO: renamed from: kotlinx.coroutines.scheduling.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1652g extends AbstractC1966o {

    /* JADX INFO: renamed from: f */
    public final ExecutorC1647b f5862f;

    public AbstractC1652g(int i3, int i4, long j2) {
        this.f5862f = new ExecutorC1647b(i3, i4, j2);
    }

    @Override // p150u2.AbstractC1954c
    /* JADX INFO: renamed from: a */
    public final void mo3742a(InterfaceC1317k interfaceC1317k, Runnable runnable) {
        ExecutorC1647b executorC1647b = this.f5862f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ExecutorC1647b.f5847l;
        executorC1647b.m3736b(runnable, AbstractC1654i.f5871f, false);
    }
}
