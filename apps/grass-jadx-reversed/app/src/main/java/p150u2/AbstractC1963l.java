package p150u2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p005B.AbstractC0032g;
import p089d2.InterfaceC1317k;
import p158w2.C2000d;

/* JADX INFO: renamed from: u2.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1963l extends AbstractC1964m implements InterfaceC1960i {

    /* JADX INFO: renamed from: f */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6982f = AtomicReferenceFieldUpdater.newUpdater(AbstractC1963l.class, Object.class, "_queue");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    static {
        AtomicReferenceFieldUpdater.newUpdater(AbstractC1963l.class, Object.class, "_delayed");
    }

    @Override // p150u2.AbstractC1954c
    /* JADX INFO: renamed from: a */
    public final void mo3742a(InterfaceC1317k interfaceC1317k, Runnable runnable) {
        mo4361d(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        p150u2.RunnableC1958g.f6977g.mo4361d(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo4361d(java.lang.Runnable r5) {
        /*
            r4 = this;
        L0:
            java.lang.Object r0 = r4._queue
            int r1 = r4._isCompleted
            if (r1 == 0) goto L7
            goto L46
        L7:
            if (r0 != 0) goto L1a
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = p150u2.AbstractC1963l.f6982f
        Lb:
            r0 = 0
            boolean r0 = r1.compareAndSet(r4, r0, r5)
            if (r0 == 0) goto L13
            goto L64
        L13:
            java.lang.Object r0 = r1.get(r4)
            if (r0 == 0) goto Lb
            goto L0
        L1a:
            boolean r1 = r0 instanceof p158w2.C2000d
            r2 = 1
            if (r1 == 0) goto L42
            r1 = r0
            w2.d r1 = (p158w2.C2000d) r1
            int r3 = r1.m4452a(r5)
            if (r3 == 0) goto L64
            if (r3 == r2) goto L2e
            r0 = 2
            if (r3 == r0) goto L46
            goto L0
        L2e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = p150u2.AbstractC1963l.f6982f
            w2.d r1 = r1.m4456e()
        L34:
            boolean r3 = r2.compareAndSet(r4, r0, r1)
            if (r3 == 0) goto L3b
            goto L0
        L3b:
            java.lang.Object r3 = r2.get(r4)
            if (r3 == r0) goto L34
            goto L0
        L42:
            com.facebook.g r1 = p150u2.AbstractC1965n.f6983a
            if (r0 != r1) goto L4c
        L46:
            u2.g r0 = p150u2.RunnableC1958g.f6977g
            r0.mo4361d(r5)
            goto L71
        L4c:
            w2.d r1 = new w2.d
            r3 = 8
            r1.<init>(r3, r2)
            r2 = r0
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r1.m4452a(r2)
            r1.m4452a(r5)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = p150u2.AbstractC1963l.f6982f
        L5e:
            boolean r3 = r2.compareAndSet(r4, r0, r1)
            if (r3 == 0) goto L72
        L64:
            java.lang.Thread r5 = r4.mo4360c()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            if (r0 == r5) goto L71
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L71:
            return
        L72:
            java.lang.Object r3 = r2.get(r4)
            if (r3 == r0) goto L5e
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: p150u2.AbstractC1963l.mo4361d(java.lang.Runnable):void");
    }

    /* JADX INFO: renamed from: e */
    public final boolean m4363e() {
        AbstractC0032g.m162t(this._delayed);
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        return obj instanceof C2000d ? ((C2000d) obj).m4455d() : obj == AbstractC1965n.f6983a;
    }

    /* JADX INFO: renamed from: f */
    public final long m4364f() {
        Runnable runnable;
        AbstractC0032g.m162t(this._delayed);
        loop0: while (true) {
            Object obj = this._queue;
            runnable = null;
            if (obj == null) {
                break;
            }
            if (!(obj instanceof C2000d)) {
                if (obj != AbstractC1965n.f6983a) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6982f;
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    runnable = (Runnable) obj;
                    break loop0;
                }
                break;
            }
            C2000d c2000d = (C2000d) obj;
            Object objM4457f = c2000d.m4457f();
            if (objM4457f != C2000d.f7141g) {
                runnable = (Runnable) objM4457f;
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6982f;
            C2000d c2000dM4456e = c2000d.m4456e();
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, c2000dM4456e) && atomicReferenceFieldUpdater2.get(this) == obj) {
            }
        }
        if (runnable != null) {
            runnable.run();
            return 0L;
        }
        Object obj2 = this._queue;
        if (obj2 == null) {
            AbstractC0032g.m162t(this._delayed);
        } else if (obj2 instanceof C2000d) {
            if (!((C2000d) obj2).m4455d()) {
                return 0L;
            }
            AbstractC0032g.m162t(this._delayed);
        } else if (obj2 != AbstractC1965n.f6983a) {
            return 0L;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: renamed from: g */
    public final void m4365g() {
        this._queue = null;
        this._delayed = null;
    }
}
