package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import p119m2.AbstractC1766e;
import p123n2.AbstractC1788f;

/* JADX INFO: renamed from: kotlinx.coroutines.scheduling.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1646a extends Thread {

    /* JADX INFO: renamed from: l */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5839l = AtomicIntegerFieldUpdater.newUpdater(C1646a.class, "workerCtl");

    /* JADX INFO: renamed from: e */
    public final C1656k f5840e;

    /* JADX INFO: renamed from: f */
    public int f5841f;

    /* JADX INFO: renamed from: g */
    public long f5842g;

    /* JADX INFO: renamed from: h */
    public long f5843h;

    /* JADX INFO: renamed from: i */
    public int f5844i;
    private volatile int indexInArray;

    /* JADX INFO: renamed from: j */
    public boolean f5845j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ExecutorC1647b f5846k;
    private volatile Object nextParkedWorker;
    volatile /* synthetic */ int workerCtl;

    public C1646a(ExecutorC1647b executorC1647b, int i3) {
        this.f5846k = executorC1647b;
        setDaemon(true);
        this.f5840e = new C1656k();
        this.f5841f = 4;
        this.workerCtl = 0;
        this.nextParkedWorker = ExecutorC1647b.f5850o;
        AbstractC1788f.f6166e.getClass();
        this.f5844i = AbstractC1788f.f6167f.mo3944a().nextInt();
        m3731f(i3);
    }

    /* JADX INFO: renamed from: a */
    public final RunnableC1653h m3726a(boolean z3) {
        RunnableC1653h runnableC1653hM3730e;
        RunnableC1653h runnableC1653hM3730e2;
        long j2;
        RunnableC1653h runnableC1653hM3745c;
        if (this.f5841f != 1) {
            ExecutorC1647b executorC1647b = this.f5846k;
            do {
                j2 = executorC1647b.controlState;
                if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                    if (z3) {
                        C1656k c1656k = this.f5840e;
                        c1656k.getClass();
                        runnableC1653hM3745c = (RunnableC1653h) C1656k.f5874b.getAndSet(c1656k, null);
                        if (runnableC1653hM3745c == null) {
                            runnableC1653hM3745c = c1656k.m3745c();
                        }
                        if (runnableC1653hM3745c == null) {
                            runnableC1653hM3745c = (RunnableC1653h) this.f5846k.f5856j.m4451d();
                        }
                    } else {
                        runnableC1653hM3745c = (RunnableC1653h) this.f5846k.f5856j.m4451d();
                    }
                    return runnableC1653hM3745c == null ? m3734i(true) : runnableC1653hM3745c;
                }
            } while (!ExecutorC1647b.f5848m.compareAndSet(executorC1647b, j2, j2 - 4398046511104L));
            this.f5841f = 1;
        }
        if (z3) {
            boolean z4 = m3729d(this.f5846k.f5851e * 2) == 0;
            if (z4 && (runnableC1653hM3730e2 = m3730e()) != null) {
                return runnableC1653hM3730e2;
            }
            C1656k c1656k2 = this.f5840e;
            c1656k2.getClass();
            RunnableC1653h runnableC1653h = (RunnableC1653h) C1656k.f5874b.getAndSet(c1656k2, null);
            RunnableC1653h runnableC1653hM3745c2 = runnableC1653h == null ? c1656k2.m3745c() : runnableC1653h;
            if (runnableC1653hM3745c2 != null) {
                return runnableC1653hM3745c2;
            }
            if (!z4 && (runnableC1653hM3730e = m3730e()) != null) {
                return runnableC1653hM3730e;
            }
        } else {
            RunnableC1653h runnableC1653hM3730e3 = m3730e();
            if (runnableC1653hM3730e3 != null) {
                return runnableC1653hM3730e3;
            }
        }
        return m3734i(false);
    }

    /* JADX INFO: renamed from: b */
    public final int m3727b() {
        return this.indexInArray;
    }

    /* JADX INFO: renamed from: c */
    public final Object m3728c() {
        return this.nextParkedWorker;
    }

    /* JADX INFO: renamed from: d */
    public final int m3729d(int i3) {
        int i4 = this.f5844i;
        int i5 = i4 ^ (i4 << 13);
        int i6 = i5 ^ (i5 >> 17);
        int i7 = i6 ^ (i6 << 5);
        this.f5844i = i7;
        int i8 = i3 - 1;
        return (i8 & i3) == 0 ? i7 & i8 : (i7 & Integer.MAX_VALUE) % i3;
    }

    /* JADX INFO: renamed from: e */
    public final RunnableC1653h m3730e() {
        int iM3729d = m3729d(2);
        ExecutorC1647b executorC1647b = this.f5846k;
        if (iM3729d == 0) {
            RunnableC1653h runnableC1653h = (RunnableC1653h) executorC1647b.f5855i.m4451d();
            return runnableC1653h == null ? (RunnableC1653h) executorC1647b.f5856j.m4451d() : runnableC1653h;
        }
        RunnableC1653h runnableC1653h2 = (RunnableC1653h) executorC1647b.f5856j.m4451d();
        return runnableC1653h2 == null ? (RunnableC1653h) executorC1647b.f5855i.m4451d() : runnableC1653h2;
    }

    /* JADX INFO: renamed from: f */
    public final void m3731f(int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5846k.f5854h);
        sb.append("-worker-");
        sb.append(i3 == 0 ? "TERMINATED" : String.valueOf(i3));
        setName(sb.toString());
        this.indexInArray = i3;
    }

    /* JADX INFO: renamed from: g */
    public final void m3732g(Object obj) {
        this.nextParkedWorker = obj;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m3733h(int i3) {
        int i4 = this.f5841f;
        boolean z3 = i4 == 1;
        if (z3) {
            ExecutorC1647b.f5848m.addAndGet(this.f5846k, 4398046511104L);
        }
        if (i4 != i3) {
            this.f5841f = i3;
        }
        return z3;
    }

    /* JADX INFO: renamed from: i */
    public final RunnableC1653h m3734i(boolean z3) {
        long jM3747e;
        int i3 = (int) (this.f5846k.controlState & 2097151);
        if (i3 < 2) {
            return null;
        }
        int iM3729d = m3729d(i3);
        ExecutorC1647b executorC1647b = this.f5846k;
        int i4 = 0;
        long jMin = Long.MAX_VALUE;
        while (i4 < i3) {
            i4++;
            iM3729d++;
            if (iM3729d > i3) {
                iM3729d = 1;
            }
            C1646a c1646a = (C1646a) executorC1647b.f5857k.m4459b(iM3729d);
            if (c1646a != null && c1646a != this) {
                if (z3) {
                    jM3747e = this.f5840e.m3746d(c1646a.f5840e);
                } else {
                    C1656k c1656k = this.f5840e;
                    C1656k c1656k2 = c1646a.f5840e;
                    c1656k.getClass();
                    RunnableC1653h runnableC1653hM3745c = c1656k2.m3745c();
                    if (runnableC1653hM3745c != null) {
                        RunnableC1653h runnableC1653h = (RunnableC1653h) C1656k.f5874b.getAndSet(c1656k, runnableC1653hM3745c);
                        if (runnableC1653h != null) {
                            c1656k.m3743a(runnableC1653h);
                        }
                        jM3747e = -1;
                    } else {
                        jM3747e = c1656k.m3747e(c1656k2, false);
                    }
                }
                if (jM3747e == -1) {
                    C1656k c1656k3 = this.f5840e;
                    c1656k3.getClass();
                    RunnableC1653h runnableC1653h2 = (RunnableC1653h) C1656k.f5874b.getAndSet(c1656k3, null);
                    return runnableC1653h2 == null ? c1656k3.m3745c() : runnableC1653h2;
                }
                if (jM3747e > 0) {
                    jMin = Math.min(jMin, jM3747e);
                }
            }
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        this.f5843h = jMin;
        return null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        loop0: while (true) {
            boolean z3 = false;
            while (!this.f5846k.m3737c() && this.f5841f != 5) {
                RunnableC1653h runnableC1653hM3726a = m3726a(this.f5845j);
                if (runnableC1653hM3726a != null) {
                    this.f5843h = 0L;
                    int i3 = runnableC1653hM3726a.f5864f.f1859a;
                    this.f5842g = 0L;
                    if (this.f5841f == 3) {
                        this.f5841f = 2;
                    }
                    ExecutorC1647b executorC1647b = this.f5846k;
                    if (i3 != 0 && m3733h(2) && !executorC1647b.m3741g() && !executorC1647b.m3740f(executorC1647b.controlState)) {
                        executorC1647b.m3741g();
                    }
                    executorC1647b.getClass();
                    try {
                        runnableC1653hM3726a.run();
                    } catch (Throwable th) {
                        Thread threadCurrentThread = Thread.currentThread();
                        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                    }
                    if (i3 != 0) {
                        ExecutorC1647b.f5848m.addAndGet(executorC1647b, -2097152L);
                        if (this.f5841f != 5) {
                            this.f5841f = 4;
                        }
                    }
                } else {
                    this.f5845j = false;
                    if (this.f5843h != 0) {
                        if (z3) {
                            m3733h(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f5843h);
                            this.f5843h = 0L;
                        } else {
                            z3 = true;
                        }
                    } else if (this.nextParkedWorker != ExecutorC1647b.f5850o) {
                        this.workerCtl = -1;
                        while (this.nextParkedWorker != ExecutorC1647b.f5850o && this.workerCtl == -1 && !this.f5846k.m3737c() && this.f5841f != 5) {
                            m3733h(3);
                            Thread.interrupted();
                            if (this.f5842g == 0) {
                                this.f5842g = System.nanoTime() + this.f5846k.f5853g;
                            }
                            LockSupport.parkNanos(this.f5846k.f5853g);
                            if (System.nanoTime() - this.f5842g >= 0) {
                                this.f5842g = 0L;
                                ExecutorC1647b executorC1647b2 = this.f5846k;
                                synchronized (executorC1647b2.f5857k) {
                                    try {
                                        if (!executorC1647b2.m3737c()) {
                                            if (((int) (executorC1647b2.controlState & 2097151)) > executorC1647b2.f5851e) {
                                                if (f5839l.compareAndSet(this, -1, 1)) {
                                                    int i4 = this.indexInArray;
                                                    m3731f(0);
                                                    executorC1647b2.m3739e(this, i4, 0);
                                                    int andDecrement = (int) (ExecutorC1647b.f5848m.getAndDecrement(executorC1647b2) & 2097151);
                                                    if (andDecrement != i4) {
                                                        Object objM4459b = executorC1647b2.f5857k.m4459b(andDecrement);
                                                        AbstractC1766e.m3917b(objM4459b);
                                                        C1646a c1646a = (C1646a) objM4459b;
                                                        executorC1647b2.f5857k.m4460c(i4, c1646a);
                                                        c1646a.m3731f(i4);
                                                        executorC1647b2.m3739e(c1646a, andDecrement, i4);
                                                    }
                                                    executorC1647b2.f5857k.m4460c(andDecrement, null);
                                                    this.f5841f = 5;
                                                }
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                        }
                    } else {
                        this.f5846k.m3738d(this);
                    }
                }
            }
            break loop0;
        }
        m3733h(5);
    }
}
