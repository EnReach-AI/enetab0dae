package p158w2;

import p089d2.InterfaceC1317k;
import p150u2.AbstractC1954c;
import p150u2.AbstractC1959h;
import p150u2.InterfaceC1960i;

/* JADX INFO: renamed from: w2.a */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1997a extends AbstractC1954c implements Runnable, InterfaceC1960i {

    /* JADX INFO: renamed from: f */
    public final AbstractC1954c f7133f;

    /* JADX INFO: renamed from: g */
    public final int f7134g;

    /* JADX INFO: renamed from: h */
    public final C1998b f7135h;

    /* JADX INFO: renamed from: i */
    public final Object f7136i;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public RunnableC1997a(AbstractC1954c abstractC1954c, int i3) {
        this.f7133f = abstractC1954c;
        this.f7134g = i3;
        if ((abstractC1954c instanceof InterfaceC1960i ? (InterfaceC1960i) abstractC1954c : null) == null) {
            int i4 = AbstractC1959h.f6979a;
        }
        this.f7135h = new C1998b();
        this.f7136i = new Object();
    }

    @Override // p150u2.AbstractC1954c
    /* JADX INFO: renamed from: a */
    public final void mo3742a(InterfaceC1317k interfaceC1317k, Runnable runnable) {
        this.f7135h.m4448a(runnable);
        if (this.runningWorkers >= this.f7134g) {
            return;
        }
        synchronized (this.f7136i) {
            if (this.runningWorkers >= this.f7134g) {
                return;
            }
            this.runningWorkers++;
            this.f7133f.mo3742a(this, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        r1 = r3.f7136i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        r3.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r3.f7135h.m4450c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        r3.runningWorkers++;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r3 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            w2.b r2 = r3.f7135h
            java.lang.Object r2 = r2.m4451d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L28
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L14
        L10:
            r2 = move-exception
            p150u2.AbstractC1957f.m4359a(r2)
        L14:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            u2.c r2 = r3.f7133f
            boolean r2 = r2.mo4358b()
            if (r2 == 0) goto L2
            u2.c r0 = r3.f7133f
            r0.mo3742a(r3, r3)
            return
        L28:
            java.lang.Object r1 = r3.f7136i
            monitor-enter(r1)
            int r2 = r3.runningWorkers     // Catch: java.lang.Throwable -> L43
            int r2 = r2 + (-1)
            r3.runningWorkers = r2     // Catch: java.lang.Throwable -> L43
            w2.b r2 = r3.f7135h     // Catch: java.lang.Throwable -> L43
            int r2 = r2.m4450c()     // Catch: java.lang.Throwable -> L43
            if (r2 != 0) goto L3b
            monitor-exit(r1)
            return
        L3b:
            int r2 = r3.runningWorkers     // Catch: java.lang.Throwable -> L43
            int r2 = r2 + 1
            r3.runningWorkers = r2     // Catch: java.lang.Throwable -> L43
            monitor-exit(r1)
            goto L1
        L43:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p158w2.RunnableC1997a.run():void");
    }
}
