package p021G;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: G.l */
/* JADX INFO: loaded from: classes.dex */
public final class ThreadFactoryC0235l implements ThreadFactory {

    /* JADX INFO: renamed from: a */
    public String f564a;

    /* JADX INFO: renamed from: b */
    public int f565b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new C0234k(runnable, this.f564a, this.f565b);
    }
}
