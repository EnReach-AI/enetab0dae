package p141s0;

import com.facebook.AbstractC1117n;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p007B1.RunnableC0055o;
import p010C0.AbstractC0147a;
import p110k.C1605n;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;

/* JADX INFO: renamed from: s0.c */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1873c implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ long f6598e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ String f6599f;

    public RunnableC1873c(long j2, String str) {
        this.f6598e = j2;
        this.f6599f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            if (AbstractC1874d.f6604e == null) {
                AbstractC1874d.f6604e = new C1605n(Long.valueOf(this.f6598e), null);
            }
            AbstractC1874d.f6604e.f5695c = Long.valueOf(this.f6598e);
            if (AbstractC1874d.f6603d.get() <= 0) {
                RunnableC0055o runnableC0055o = new RunnableC0055o(20, this);
                synchronized (AbstractC1874d.f6602c) {
                    ScheduledExecutorService scheduledExecutorService = AbstractC1874d.f6600a;
                    HashSet hashSet = AbstractC1117n.f3875a;
                    AbstractC2069g.m4584h();
                    AbstractC1874d.f6601b = scheduledExecutorService.schedule(runnableC0055o, AbstractC2082t.m4621b(AbstractC1117n.f3877c) == null ? 60 : r3.f7351b, TimeUnit.SECONDS);
                }
            }
            long j2 = AbstractC1874d.f6607h;
            AbstractC1879i.m4201b(j2 > 0 ? (this.f6598e - j2) / 1000 : 0L, this.f6599f);
            AbstractC1874d.f6604e.m3678l();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }
}
