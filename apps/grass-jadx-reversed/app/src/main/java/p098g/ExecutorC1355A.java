package p098g;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import p001A.RunnableC0014o;

/* JADX INFO: renamed from: g.A */
/* JADX INFO: loaded from: classes.dex */
public final class ExecutorC1355A implements Executor {

    /* JADX INFO: renamed from: e */
    public final Object f4823e = new Object();

    /* JADX INFO: renamed from: f */
    public final ArrayDeque f4824f = new ArrayDeque();

    /* JADX INFO: renamed from: g */
    public final Executor f4825g;

    /* JADX INFO: renamed from: h */
    public Runnable f4826h;

    public ExecutorC1355A(ExecutorC1356B executorC1356B) {
        this.f4825g = executorC1356B;
    }

    /* JADX INFO: renamed from: a */
    public final void m3310a() {
        synchronized (this.f4823e) {
            try {
                Runnable runnable = (Runnable) this.f4824f.poll();
                this.f4826h = runnable;
                if (runnable != null) {
                    this.f4825g.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f4823e) {
            try {
                this.f4824f.add(new RunnableC0014o(this, 2, runnable));
                if (this.f4826h == null) {
                    m3310a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
