package p098g;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: g.B */
/* JADX INFO: loaded from: classes.dex */
public final class ExecutorC1356B implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
}
