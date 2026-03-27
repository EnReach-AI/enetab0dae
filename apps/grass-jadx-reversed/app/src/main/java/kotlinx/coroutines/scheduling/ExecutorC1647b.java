package kotlinx.coroutines.scheduling;

import com.facebook.C1110g;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import p066W0.C0684k;
import p119m2.AbstractC1766e;
import p136r.AbstractC1849h;
import p158w2.C2003g;

/* JADX INFO: renamed from: kotlinx.coroutines.scheduling.b */
/* JADX INFO: loaded from: classes.dex */
public final class ExecutorC1647b implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;
    volatile /* synthetic */ long controlState;

    /* JADX INFO: renamed from: e */
    public final int f5851e;

    /* JADX INFO: renamed from: f */
    public final int f5852f;

    /* JADX INFO: renamed from: g */
    public final long f5853g;

    /* JADX INFO: renamed from: h */
    public final String f5854h = "DefaultDispatcher";

    /* JADX INFO: renamed from: i */
    public final C1650e f5855i;

    /* JADX INFO: renamed from: j */
    public final C1650e f5856j;

    /* JADX INFO: renamed from: k */
    public final C2003g f5857k;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* JADX INFO: renamed from: o */
    public static final C1110g f5850o = new C1110g(1, "NOT_IN_STACK");

    /* JADX INFO: renamed from: l */
    public static final /* synthetic */ AtomicLongFieldUpdater f5847l = AtomicLongFieldUpdater.newUpdater(ExecutorC1647b.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: m */
    public static final /* synthetic */ AtomicLongFieldUpdater f5848m = AtomicLongFieldUpdater.newUpdater(ExecutorC1647b.class, "controlState");

    /* JADX INFO: renamed from: n */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5849n = AtomicIntegerFieldUpdater.newUpdater(ExecutorC1647b.class, "_isTerminated");

    public ExecutorC1647b(int i3, int i4, long j2) {
        this.f5851e = i3;
        this.f5852f = i4;
        this.f5853g = j2;
        if (i3 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i3 + " should be at least 1").toString());
        }
        if (i4 < i3) {
            throw new IllegalArgumentException(("Max pool size " + i4 + " should be greater than or equals to core pool size " + i3).toString());
        }
        if (i4 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i4 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.f5855i = new C1650e();
        this.f5856j = new C1650e();
        this.parkedWorkersStack = 0L;
        this.f5857k = new C2003g(i3 + 1);
        this.controlState = ((long) i3) << 42;
        this._isTerminated = 0;
    }

    /* JADX INFO: renamed from: a */
    public final int m3735a() {
        synchronized (this.f5857k) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j2 = this.controlState;
            int i3 = (int) (j2 & 2097151);
            int i4 = i3 - ((int) ((j2 & 4398044413952L) >> 21));
            if (i4 < 0) {
                i4 = 0;
            }
            if (i4 >= this.f5851e) {
                return 0;
            }
            if (i3 >= this.f5852f) {
                return 0;
            }
            int i5 = ((int) (this.controlState & 2097151)) + 1;
            if (i5 <= 0 || this.f5857k.m4459b(i5) != null) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            C1646a c1646a = new C1646a(this, i5);
            this.f5857k.m4460c(i5, c1646a);
            if (i5 != ((int) (2097151 & f5848m.incrementAndGet(this)))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c1646a.start();
            return i4 + 1;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3736b(Runnable runnable, C0684k c0684k, boolean z3) {
        RunnableC1653h runnableC1653h;
        int i3;
        AbstractC1654i.f5870e.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof RunnableC1653h) {
            runnableC1653h = (RunnableC1653h) runnable;
            runnableC1653h.f5863e = jNanoTime;
            runnableC1653h.f5864f = c0684k;
        } else {
            runnableC1653h = new RunnableC1653h(runnable, jNanoTime, c0684k);
        }
        Thread threadCurrentThread = Thread.currentThread();
        RunnableC1653h runnableC1653hM3743a = null;
        C1646a c1646a = threadCurrentThread instanceof C1646a ? (C1646a) threadCurrentThread : null;
        if (c1646a == null || !AbstractC1766e.m3916a(c1646a.f5846k, this)) {
            c1646a = null;
        }
        if (c1646a == null || (i3 = c1646a.f5841f) == 5 || (runnableC1653h.f5864f.f1859a == 0 && i3 == 2)) {
            runnableC1653hM3743a = runnableC1653h;
        } else {
            c1646a.f5845j = true;
            C1656k c1656k = c1646a.f5840e;
            if (z3) {
                runnableC1653hM3743a = c1656k.m3743a(runnableC1653h);
            } else {
                c1656k.getClass();
                RunnableC1653h runnableC1653h2 = (RunnableC1653h) C1656k.f5874b.getAndSet(c1656k, runnableC1653h);
                if (runnableC1653h2 != null) {
                    runnableC1653hM3743a = c1656k.m3743a(runnableC1653h2);
                }
            }
        }
        if (runnableC1653hM3743a != null) {
            if (!(runnableC1653hM3743a.f5864f.f1859a == 1 ? this.f5856j.m4448a(runnableC1653hM3743a) : this.f5855i.m4448a(runnableC1653hM3743a))) {
                throw new RejectedExecutionException(AbstractC1766e.m3923h(this.f5854h, " was terminated"));
            }
        }
        boolean z4 = z3 && c1646a != null;
        if (runnableC1653h.f5864f.f1859a == 0) {
            if (z4 || m3741g() || m3740f(this.controlState)) {
                return;
            }
            m3741g();
            return;
        }
        long jAddAndGet = f5848m.addAndGet(this, 2097152L);
        if (z4 || m3741g() || m3740f(jAddAndGet)) {
            return;
        }
        m3741g();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* JADX INFO: renamed from: c */
    public final boolean m3737c() {
        return this._isTerminated;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i3;
        if (f5849n.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            C1646a c1646a = threadCurrentThread instanceof C1646a ? (C1646a) threadCurrentThread : null;
            if (c1646a == null || !AbstractC1766e.m3916a(c1646a.f5846k, this)) {
                c1646a = null;
            }
            synchronized (this.f5857k) {
                i3 = (int) (this.controlState & 2097151);
            }
            if (1 <= i3) {
                int i4 = 1;
                while (true) {
                    int i5 = i4 + 1;
                    Object objM4459b = this.f5857k.m4459b(i4);
                    AbstractC1766e.m3917b(objM4459b);
                    C1646a c1646a2 = (C1646a) objM4459b;
                    if (c1646a2 != c1646a) {
                        while (c1646a2.isAlive()) {
                            LockSupport.unpark(c1646a2);
                            c1646a2.join(10000L);
                        }
                        C1656k c1656k = c1646a2.f5840e;
                        C1650e c1650e = this.f5856j;
                        c1656k.getClass();
                        RunnableC1653h runnableC1653h = (RunnableC1653h) C1656k.f5874b.getAndSet(c1656k, null);
                        if (runnableC1653h != null) {
                            c1650e.m4448a(runnableC1653h);
                        }
                        while (true) {
                            RunnableC1653h runnableC1653hM3745c = c1656k.m3745c();
                            if (runnableC1653hM3745c == null) {
                                break;
                            } else {
                                c1650e.m4448a(runnableC1653hM3745c);
                            }
                        }
                    }
                    if (i4 == i3) {
                        break;
                    } else {
                        i4 = i5;
                    }
                }
            }
            this.f5856j.m4449b();
            this.f5855i.m4449b();
            while (true) {
                RunnableC1653h runnableC1653hM3726a = c1646a == null ? null : c1646a.m3726a(true);
                if (runnableC1653hM3726a == null && (runnableC1653hM3726a = (RunnableC1653h) this.f5855i.m4451d()) == null && (runnableC1653hM3726a = (RunnableC1653h) this.f5856j.m4451d()) == null) {
                    break;
                }
                try {
                    runnableC1653hM3726a.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (c1646a != null) {
                c1646a.m3733h(5);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m3738d(C1646a c1646a) {
        long j2;
        int iM3727b;
        if (c1646a.m3728c() != f5850o) {
            return;
        }
        do {
            j2 = this.parkedWorkersStack;
            iM3727b = c1646a.m3727b();
            c1646a.m3732g(this.f5857k.m4459b((int) (2097151 & j2)));
        } while (!f5847l.compareAndSet(this, j2, ((long) iM3727b) | ((2097152 + j2) & (-2097152))));
    }

    /* JADX INFO: renamed from: e */
    public final void m3739e(C1646a c1646a, int i3, int i4) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i5 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i5 == i3) {
                if (i4 == 0) {
                    Object objM3728c = c1646a.m3728c();
                    while (true) {
                        if (objM3728c == f5850o) {
                            i5 = -1;
                            break;
                        }
                        if (objM3728c == null) {
                            i5 = 0;
                            break;
                        }
                        C1646a c1646a2 = (C1646a) objM3728c;
                        int iM3727b = c1646a2.m3727b();
                        if (iM3727b != 0) {
                            i5 = iM3727b;
                            break;
                        }
                        objM3728c = c1646a2.m3728c();
                    }
                } else {
                    i5 = i4;
                }
            }
            if (i5 >= 0 && f5847l.compareAndSet(this, j2, j3 | ((long) i5))) {
                return;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        m3736b(runnable, AbstractC1654i.f5871f, false);
    }

    /* JADX INFO: renamed from: f */
    public final boolean m3740f(long j2) {
        int i3 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = this.f5851e;
        if (i3 < i4) {
            int iM3735a = m3735a();
            if (iM3735a == 1 && i4 > 1) {
                m3735a();
            }
            if (iM3735a > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m3741g() {
        C1110g c1110g;
        int iM3727b;
        while (true) {
            long j2 = this.parkedWorkersStack;
            C1646a c1646a = (C1646a) this.f5857k.m4459b((int) (2097151 & j2));
            if (c1646a == null) {
                c1646a = null;
            } else {
                long j3 = (2097152 + j2) & (-2097152);
                Object objM3728c = c1646a.m3728c();
                while (true) {
                    c1110g = f5850o;
                    if (objM3728c == c1110g) {
                        iM3727b = -1;
                        break;
                    }
                    if (objM3728c == null) {
                        iM3727b = 0;
                        break;
                    }
                    C1646a c1646a2 = (C1646a) objM3728c;
                    iM3727b = c1646a2.m3727b();
                    if (iM3727b != 0) {
                        break;
                    }
                    objM3728c = c1646a2.m3728c();
                }
                if (iM3727b >= 0 && f5847l.compareAndSet(this, j2, ((long) iM3727b) | j3)) {
                    c1646a.m3732g(c1110g);
                }
            }
            if (c1646a == null) {
                return false;
            }
            if (C1646a.f5839l.compareAndSet(c1646a, -1, 0)) {
                LockSupport.unpark(c1646a);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        int iM4458a = this.f5857k.m4458a();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        while (i8 < iM4458a) {
            int i9 = i8 + 1;
            C1646a c1646a = (C1646a) this.f5857k.m4459b(i8);
            if (c1646a != null) {
                int iM3744b = c1646a.f5840e.m3744b();
                int iM4118b = AbstractC1849h.m4118b(c1646a.f5841f);
                if (iM4118b == 0) {
                    i3++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iM3744b);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iM4118b == 1) {
                    i4++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iM3744b);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iM4118b == 2) {
                    i5++;
                } else if (iM4118b == 3) {
                    i6++;
                    if (iM3744b > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iM3744b);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iM4118b == 4) {
                    i7++;
                }
            }
            i8 = i9;
        }
        long j2 = this.controlState;
        return this.f5854h + '@' + Integer.toHexString(System.identityHashCode(this)) + "[Pool Size {core = " + this.f5851e + ", max = " + this.f5852f + "}, Worker States {CPU = " + i3 + ", blocking = " + i4 + ", parked = " + i5 + ", dormant = " + i6 + ", terminated = " + i7 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f5855i.m4450c() + ", global blocking queue size = " + this.f5856j.m4450c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.f5851e - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }
}
