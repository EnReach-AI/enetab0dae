package p150u2;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: u2.g */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1958g extends AbstractC1963l implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: g */
    public static final RunnableC1958g f6977g = new RunnableC1958g();

    /* JADX INFO: renamed from: h */
    public static final long f6978h;

    static {
        Long l3;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l3 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l3 = 1000L;
        }
        f6978h = timeUnit.toNanos(l3.longValue());
    }

    @Override // p150u2.AbstractC1964m
    /* JADX INFO: renamed from: c */
    public final Thread mo4360c() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    @Override // p150u2.AbstractC1963l
    /* JADX INFO: renamed from: d */
    public final void mo4361d(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.mo4361d(runnable);
    }

    /* JADX INFO: renamed from: h */
    public final synchronized void m4362h() {
        int i3 = debugStatus;
        if (i3 == 2 || i3 == 3) {
            debugStatus = 3;
            m4365g();
            notifyAll();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0072, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r14 = this;
            java.lang.ThreadLocal r0 = p150u2.AbstractC1968q.f6984a
            r0.set(r14)
            r0 = 0
            monitor-enter(r14)     // Catch: java.lang.Throwable -> L37
            int r1 = p150u2.RunnableC1958g.debugStatus     // Catch: java.lang.Throwable -> L73
            r2 = 2
            if (r1 == r2) goto L75
            r3 = 3
            if (r1 != r3) goto L11
            goto L75
        L11:
            r1 = 1
            p150u2.RunnableC1958g.debugStatus = r1     // Catch: java.lang.Throwable -> L73
            r14.notifyAll()     // Catch: java.lang.Throwable -> L73
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L37
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = r4
        L1e:
            java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L37
            long r8 = r14.m4364f()     // Catch: java.lang.Throwable -> L37
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            r10 = 0
            if (r1 != 0) goto L54
            long r12 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L37
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 != 0) goto L39
            long r6 = p150u2.RunnableC1958g.f6978h     // Catch: java.lang.Throwable -> L37
            long r6 = r6 + r12
            goto L39
        L37:
            r1 = move-exception
            goto L87
        L39:
            long r12 = r6 - r12
            int r1 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r1 > 0) goto L4e
            p150u2.RunnableC1958g._thread = r0
            r14.m4362h()
            boolean r0 = r14.m4363e()
            if (r0 != 0) goto L4d
            r14.mo4360c()
        L4d:
            return
        L4e:
            int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r1 <= 0) goto L55
            r8 = r12
            goto L55
        L54:
            r6 = r4
        L55:
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 <= 0) goto L1e
            int r1 = p150u2.RunnableC1958g.debugStatus     // Catch: java.lang.Throwable -> L37
            if (r1 == r2) goto L64
            if (r1 != r3) goto L60
            goto L64
        L60:
            java.util.concurrent.locks.LockSupport.parkNanos(r14, r8)     // Catch: java.lang.Throwable -> L37
            goto L1e
        L64:
            p150u2.RunnableC1958g._thread = r0
            r14.m4362h()
            boolean r0 = r14.m4363e()
            if (r0 != 0) goto L72
            r14.mo4360c()
        L72:
            return
        L73:
            r1 = move-exception
            goto L85
        L75:
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L37
            p150u2.RunnableC1958g._thread = r0
            r14.m4362h()
            boolean r0 = r14.m4363e()
            if (r0 != 0) goto L84
            r14.mo4360c()
        L84:
            return
        L85:
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L37
            throw r1     // Catch: java.lang.Throwable -> L37
        L87:
            p150u2.RunnableC1958g._thread = r0
            r14.m4362h()
            boolean r0 = r14.m4363e()
            if (r0 != 0) goto L95
            r14.mo4360c()
        L95:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p150u2.RunnableC1958g.run():void");
    }
}
