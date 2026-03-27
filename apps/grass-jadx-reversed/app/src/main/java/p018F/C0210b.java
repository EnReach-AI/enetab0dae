package p018F;

/* JADX INFO: renamed from: F.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0210b {

    /* JADX INFO: renamed from: a */
    public boolean f513a;

    /* JADX INFO: renamed from: b */
    public InterfaceC0209a f514b;

    /* JADX INFO: renamed from: c */
    public boolean f515c;

    /* JADX INFO: renamed from: a */
    public final void m416a() {
        synchronized (this) {
            try {
                if (this.f513a) {
                    return;
                }
                this.f513a = true;
                this.f515c = true;
                InterfaceC0209a interfaceC0209a = this.f514b;
                if (interfaceC0209a != null) {
                    try {
                        interfaceC0209a.mo415r();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f515c = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                synchronized (this) {
                    this.f515c = false;
                    notifyAll();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m417b(InterfaceC0209a interfaceC0209a) {
        synchronized (this) {
            while (this.f515c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f514b == interfaceC0209a) {
                return;
            }
            this.f514b = interfaceC0209a;
            if (this.f513a) {
                interfaceC0209a.mo415r();
            }
        }
    }
}
