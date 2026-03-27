package p113l;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: l.b */
/* JADX INFO: loaded from: classes.dex */
public final class ThreadFactoryC1658b implements ThreadFactory {

    /* JADX INFO: renamed from: a */
    public final AtomicInteger f5881a = new AtomicInteger(0);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f5881a.getAndIncrement())));
        return thread;
    }
}
