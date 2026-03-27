package p166z0;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p010C0.AbstractC0147a;
import p117m0.C1719n;

/* JADX INFO: renamed from: z0.r */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC2080r implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f7363e = 0;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1719n f7364f;

    public RunnableC2080r(C1719n c1719n) {
        this.f7364f = c1719n;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7363e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (!AbstractC0147a.f354a.contains(this)) {
                    try {
                        this.f7364f.getClass();
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, this);
                        return;
                    }
                    break;
                }
                break;
            default:
                if (!AbstractC0147a.f354a.contains(this)) {
                    try {
                        this.f7364f.getClass();
                        C1719n.m3819a();
                    } catch (Throwable th2) {
                        AbstractC0147a.m295a(th2, this);
                    }
                    break;
                }
                break;
        }
    }

    public RunnableC2080r(C1719n c1719n, C2079q c2079q) {
        this.f7364f = c1719n;
    }
}
