package p141s0;

import android.content.Context;
import com.facebook.AbstractC1117n;
import java.util.HashSet;
import p010C0.AbstractC0147a;
import p110k.C1605n;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;

/* JADX INFO: renamed from: s0.b */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1872b implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ long f6595e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ String f6596f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Context f6597g;

    public RunnableC1872b(long j2, String str, Context context) {
        this.f6595e = j2;
        this.f6596f = str;
        this.f6597g = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            if (AbstractC1874d.f6604e == null) {
                AbstractC1874d.f6604e = new C1605n(Long.valueOf(this.f6595e), null);
                AbstractC1885o.m4213c(this.f6597g, this.f6596f, AbstractC1874d.f6606g);
            } else if (((Long) AbstractC1874d.f6604e.f5695c) != null) {
                long jLongValue = this.f6595e - ((Long) AbstractC1874d.f6604e.f5695c).longValue();
                HashSet hashSet = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                if (jLongValue > (AbstractC2082t.m4621b(AbstractC1117n.f3877c) == null ? 60 : r0.f7351b) * 1000) {
                    AbstractC1885o.m4215e(this.f6596f, AbstractC1874d.f6604e, AbstractC1874d.f6606g);
                    AbstractC1885o.m4213c(this.f6597g, this.f6596f, AbstractC1874d.f6606g);
                    AbstractC1874d.f6604e = new C1605n(Long.valueOf(this.f6595e), null);
                } else if (jLongValue > 1000) {
                    AbstractC1874d.f6604e.f5693a++;
                }
            }
            AbstractC1874d.f6604e.f5695c = Long.valueOf(this.f6595e);
            AbstractC1874d.f6604e.m3678l();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }
}
