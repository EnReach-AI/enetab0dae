package p021G;

import android.os.Process;

/* JADX INFO: renamed from: G.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0234k extends Thread {

    /* JADX INFO: renamed from: e */
    public final int f563e;

    public C0234k(Runnable runnable, String str, int i3) {
        super(runnable, str);
        this.f563e = i3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f563e);
        super.run();
    }
}
