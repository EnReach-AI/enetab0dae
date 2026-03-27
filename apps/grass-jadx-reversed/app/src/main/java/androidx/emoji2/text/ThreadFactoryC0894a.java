package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: androidx.emoji2.text.a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ThreadFactoryC0894a implements ThreadFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f2963a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f2963a);
        thread.setPriority(10);
        return thread;
    }
}
