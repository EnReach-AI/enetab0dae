package com.fasterxml.jackson.databind.util.internal;

import java.util.concurrent.atomic.AtomicLong;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.util.internal.d */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1235d implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f4166e;

    /* JADX INFO: renamed from: f */
    public final C1243l f4167f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ ConcurrentMapC1248q f4168g;

    public /* synthetic */ RunnableC1235d(ConcurrentMapC1248q concurrentMapC1248q, C1243l c1243l, int i3) {
        this.f4166e = i3;
        this.f4168g = concurrentMapC1248q;
        this.f4167f = c1243l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4166e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ConcurrentMapC1248q concurrentMapC1248q = this.f4168g;
                AtomicLong atomicLong = concurrentMapC1248q.f4198i;
                atomicLong.lazySet(atomicLong.get() + ((long) 1));
                C1243l c1243l = this.f4167f;
                if (((C1246o) c1243l.get()).m3114a()) {
                    concurrentMapC1248q.f4197h.offerLast(c1243l);
                    concurrentMapC1248q.m3118d();
                }
                break;
            default:
                ConcurrentMapC1248q concurrentMapC1248q2 = this.f4168g;
                C1234c c1234c = concurrentMapC1248q2.f4197h;
                C1243l c1243l2 = this.f4167f;
                if (c1234c.m3108b(c1243l2)) {
                    C1243l c1243l3 = c1243l2.f4184f;
                    C1243l c1243l4 = c1243l2.f4185g;
                    if (c1243l3 == null) {
                        c1234c.f4164e = c1243l4;
                    } else {
                        c1243l3.f4185g = c1243l4;
                        c1243l2.f4184f = null;
                    }
                    if (c1243l4 == null) {
                        c1234c.f4165f = c1243l3;
                    } else {
                        c1243l4.f4184f = c1243l3;
                        c1243l2.f4185g = null;
                    }
                }
                concurrentMapC1248q2.m3119e(c1243l2);
                break;
        }
    }
}
