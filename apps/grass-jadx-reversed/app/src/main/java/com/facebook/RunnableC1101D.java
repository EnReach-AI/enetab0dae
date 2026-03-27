package com.facebook;

import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;
import p166z0.C2064b;
import p166z0.C2079q;

/* JADX INFO: renamed from: com.facebook.D */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1101D implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ long f3806e;

    public RunnableC1101D(long j2) {
        this.f3806e = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1102E c1102e;
        Set set = AbstractC0147a.f354a;
        if (set.contains(this)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = null;
            if (set.contains(AbstractC1103F.class)) {
                c1102e = null;
            } else {
                try {
                    c1102e = AbstractC1103F.f3815e;
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, AbstractC1103F.class);
                    c1102e = null;
                }
            }
            if (c1102e.m2863a()) {
                HashSet hashSet = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                C2079q c2079qM4625f = AbstractC2082t.m4625f(AbstractC1117n.f3877c, false);
                if (c2079qM4625f != null && c2079qM4625f.f7356g) {
                    AbstractC2069g.m4584h();
                    C2064b c2064bM4569b = C2064b.m4569b(AbstractC1117n.f3882h);
                    if (((c2064bM4569b == null || c2064bM4569b.m4570a() == null) ? null : c2064bM4569b.m4570a()) != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("advertiser_id", c2064bM4569b.m4570a());
                        bundle.putString("fields", "auto_event_setup_enabled");
                        AbstractC2069g.m4584h();
                        C1125v c1125v = new C1125v(null, AbstractC1117n.f3877c, null, null, null);
                        c1125v.f3911i = true;
                        c1125v.f3907e = bundle;
                        JSONObject jSONObject = c1125v.m2923d().f3920b;
                        if (jSONObject != null) {
                            AbstractC1103F.m2864a().f3808b = Boolean.valueOf(jSONObject.optBoolean("auto_event_setup_enabled", false));
                            AbstractC1103F.m2864a().f3810d = this.f3806e;
                            C1102E c1102eM2864a = AbstractC1103F.m2864a();
                            if (!AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
                                try {
                                    AbstractC1103F.m2874k(c1102eM2864a);
                                } catch (Throwable th2) {
                                    AbstractC0147a.m295a(th2, AbstractC1103F.class);
                                }
                            }
                        }
                    }
                }
            }
            if (!AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
                try {
                    atomicBoolean = AbstractC1103F.f3812b;
                } catch (Throwable th3) {
                    AbstractC0147a.m295a(th3, AbstractC1103F.class);
                }
            }
            atomicBoolean.set(false);
        } catch (Throwable th4) {
            AbstractC0147a.m295a(th4, this);
        }
    }
}
