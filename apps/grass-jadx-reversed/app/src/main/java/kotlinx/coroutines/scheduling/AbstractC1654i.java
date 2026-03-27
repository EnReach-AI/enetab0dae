package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import p066W0.C0684k;
import p137r0.AbstractC1852a;
import p158w2.AbstractC2004h;

/* JADX INFO: renamed from: kotlinx.coroutines.scheduling.i */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1654i {

    /* JADX INFO: renamed from: a */
    public static final long f5866a = AbstractC1852a.m4131f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 1, Long.MAX_VALUE);

    /* JADX INFO: renamed from: b */
    public static final int f5867b;

    /* JADX INFO: renamed from: c */
    public static final int f5868c;

    /* JADX INFO: renamed from: d */
    public static final long f5869d;

    /* JADX INFO: renamed from: e */
    public static final C1651f f5870e;

    /* JADX INFO: renamed from: f */
    public static final C0684k f5871f;

    /* JADX INFO: renamed from: g */
    public static final C0684k f5872g;

    static {
        int i3 = AbstractC2004h.f7147a;
        if (i3 < 2) {
            i3 = 2;
        }
        f5867b = AbstractC1852a.m4132g("kotlinx.coroutines.scheduler.core.pool.size", i3, 1, 0, 8);
        f5868c = AbstractC1852a.m4132g("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        f5869d = TimeUnit.SECONDS.toNanos(AbstractC1852a.m4131f("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f5870e = C1651f.f5861a;
        f5871f = new C0684k(0);
        f5872g = new C0684k(1);
    }
}
