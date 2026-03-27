package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import p089d2.C1318l;
import p089d2.InterfaceC1317k;
import p119m2.AbstractC1766e;
import p137r0.AbstractC1852a;
import p150u2.AbstractC1966o;
import p158w2.AbstractC2004h;
import p158w2.RunnableC1997a;

/* JADX INFO: renamed from: kotlinx.coroutines.scheduling.c */
/* JADX INFO: loaded from: classes.dex */
public final class ExecutorC1648c extends AbstractC1966o implements Executor {

    /* JADX INFO: renamed from: f */
    public static final ExecutorC1648c f5858f = new ExecutorC1648c();

    /* JADX INFO: renamed from: g */
    public static final RunnableC1997a f5859g;

    static {
        C1655j c1655j = C1655j.f5873f;
        int i3 = AbstractC2004h.f7147a;
        if (64 >= i3) {
            i3 = 64;
        }
        int iM4132g = AbstractC1852a.m4132g("kotlinx.coroutines.io.parallelism", i3, 0, 0, 12);
        c1655j.getClass();
        if (iM4132g < 1) {
            throw new IllegalArgumentException(AbstractC1766e.m3923h("Expected positive parallelism level, but got ", Integer.valueOf(iM4132g)).toString());
        }
        f5859g = new RunnableC1997a(c1655j, iM4132g);
    }

    @Override // p150u2.AbstractC1954c
    /* JADX INFO: renamed from: a */
    public final void mo3742a(InterfaceC1317k interfaceC1317k, Runnable runnable) {
        f5859g.mo3742a(interfaceC1317k, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        mo3742a(C1318l.f4678e, runnable);
    }

    @Override // p150u2.AbstractC1954c
    public final String toString() {
        return "Dispatchers.IO";
    }
}
