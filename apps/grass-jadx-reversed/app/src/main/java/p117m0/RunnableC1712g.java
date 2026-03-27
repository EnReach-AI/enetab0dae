package p117m0;

import p010C0.AbstractC0147a;

/* JADX INFO: renamed from: m0.g */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1712g implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f5989e;

    public RunnableC1712g(int i3) {
        this.f5989e = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            AbstractC1715j.m3796e(this.f5989e);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }
}
