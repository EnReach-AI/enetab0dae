package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: kotlinx.coroutines.scheduling.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1656k {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5874b = AtomicReferenceFieldUpdater.newUpdater(C1656k.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: c */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5875c = AtomicIntegerFieldUpdater.newUpdater(C1656k.class, "producerIndex");

    /* JADX INFO: renamed from: d */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5876d = AtomicIntegerFieldUpdater.newUpdater(C1656k.class, "consumerIndex");

    /* JADX INFO: renamed from: e */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5877e = AtomicIntegerFieldUpdater.newUpdater(C1656k.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a */
    public final AtomicReferenceArray f5878a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    /* JADX INFO: renamed from: a */
    public final RunnableC1653h m3743a(RunnableC1653h runnableC1653h) {
        if (runnableC1653h.f5864f.f1859a == 1) {
            f5877e.incrementAndGet(this);
        }
        if (this.producerIndex - this.consumerIndex == 127) {
            return runnableC1653h;
        }
        int i3 = this.producerIndex & 127;
        while (this.f5878a.get(i3) != null) {
            Thread.yield();
        }
        this.f5878a.lazySet(i3, runnableC1653h);
        f5875c.incrementAndGet(this);
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final int m3744b() {
        return this.lastScheduledTask != null ? (this.producerIndex - this.consumerIndex) + 1 : this.producerIndex - this.consumerIndex;
    }

    /* JADX INFO: renamed from: c */
    public final RunnableC1653h m3745c() {
        RunnableC1653h runnableC1653h;
        while (true) {
            int i3 = this.consumerIndex;
            if (i3 - this.producerIndex == 0) {
                return null;
            }
            int i4 = i3 & 127;
            if (f5876d.compareAndSet(this, i3, i3 + 1) && (runnableC1653h = (RunnableC1653h) this.f5878a.getAndSet(i4, null)) != null) {
                if (runnableC1653h.f5864f.f1859a == 1) {
                    f5877e.decrementAndGet(this);
                }
                return runnableC1653h;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final long m3746d(C1656k c1656k) {
        int i3 = c1656k.producerIndex;
        AtomicReferenceArray atomicReferenceArray = c1656k.f5878a;
        for (int i4 = c1656k.consumerIndex; i4 != i3; i4++) {
            int i5 = i4 & 127;
            if (c1656k.blockingTasksInBuffer == 0) {
                break;
            }
            RunnableC1653h runnableC1653h = (RunnableC1653h) atomicReferenceArray.get(i5);
            if (runnableC1653h != null && runnableC1653h.f5864f.f1859a == 1) {
                while (!atomicReferenceArray.compareAndSet(i5, runnableC1653h, null)) {
                    if (atomicReferenceArray.get(i5) != runnableC1653h) {
                        break;
                    }
                }
                f5877e.decrementAndGet(c1656k);
                RunnableC1653h runnableC1653h2 = (RunnableC1653h) f5874b.getAndSet(this, runnableC1653h);
                if (runnableC1653h2 == null) {
                    return -1L;
                }
                m3743a(runnableC1653h2);
                return -1L;
            }
        }
        return m3747e(c1656k, true);
    }

    /* JADX INFO: renamed from: e */
    public final long m3747e(C1656k c1656k, boolean z3) {
        while (true) {
            RunnableC1653h runnableC1653h = (RunnableC1653h) c1656k.lastScheduledTask;
            if (runnableC1653h == null) {
                return -2L;
            }
            if (z3 && runnableC1653h.f5864f.f1859a != 1) {
                return -2L;
            }
            AbstractC1654i.f5870e.getClass();
            long jNanoTime = System.nanoTime() - runnableC1653h.f5863e;
            long j2 = AbstractC1654i.f5866a;
            if (jNanoTime < j2) {
                return j2 - jNanoTime;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5874b;
            while (!atomicReferenceFieldUpdater.compareAndSet(c1656k, runnableC1653h, null)) {
                if (atomicReferenceFieldUpdater.get(c1656k) != runnableC1653h) {
                    break;
                }
            }
            RunnableC1653h runnableC1653h2 = (RunnableC1653h) f5874b.getAndSet(this, runnableC1653h);
            if (runnableC1653h2 == null) {
                return -1L;
            }
            m3743a(runnableC1653h2);
            return -1L;
        }
    }
}
