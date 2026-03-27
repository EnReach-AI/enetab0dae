package kotlinx.coroutines.scheduling;

import p066W0.C0684k;

/* JADX INFO: renamed from: kotlinx.coroutines.scheduling.h */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1653h implements Runnable {

    /* JADX INFO: renamed from: e */
    public long f5863e;

    /* JADX INFO: renamed from: f */
    public C0684k f5864f;

    /* JADX INFO: renamed from: g */
    public final Runnable f5865g;

    public RunnableC1653h(Runnable runnable, long j2, C0684k c0684k) {
        this.f5863e = j2;
        this.f5864f = c0684k;
        this.f5865g = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f5865g.run();
        } finally {
            this.f5864f.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f5865g;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(runnable)));
        sb.append(", ");
        sb.append(this.f5863e);
        sb.append(", ");
        sb.append(this.f5864f);
        sb.append(']');
        return sb.toString();
    }
}
