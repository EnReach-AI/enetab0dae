package p141s0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.AbstractC1117n;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p001A.C0009j;
import p010C0.AbstractC0147a;
import p019F0.RunnableC0218b;
import p036L0.C0444d;
import p117m0.AbstractC1715j;
import p117m0.C1718m;
import p121n0.AbstractC1776a;
import p121n0.C1778c;
import p121n0.ViewTreeObserverOnGlobalFocusChangeListenerC1779d;
import p125o0.AbstractC1795e;
import p125o0.C1798h;
import p125o0.C1803m;
import p125o0.C1804n;
import p156w0.AbstractC1989d;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;
import p166z0.C2079q;
import p166z0.C2085w;

/* JADX INFO: renamed from: s0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1871a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6594a;

    public /* synthetic */ C1871a(int i3) {
        this.f6594a = i3;
    }

    /* JADX INFO: renamed from: a */
    private final void m4187a(Activity activity, Bundle bundle) {
    }

    /* JADX INFO: renamed from: b */
    private final void m4188b(Activity activity) {
    }

    /* JADX INFO: renamed from: c */
    private final void m4189c(Activity activity) {
    }

    /* JADX INFO: renamed from: d */
    private final void m4190d(Activity activity, Bundle bundle) {
    }

    /* JADX INFO: renamed from: e */
    private final void m4191e(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        switch (this.f6594a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ScheduledExecutorService scheduledExecutorService = AbstractC1874d.f6600a;
                HashMap map = C2085w.f7377b;
                AbstractC1117n.m2896f();
                AbstractC1874d.f6600a.execute(new RunnableC0218b(8));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        switch (this.f6594a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ScheduledExecutorService scheduledExecutorService = AbstractC1874d.f6600a;
                HashMap map = C2085w.f7377b;
                AbstractC1117n.m2896f();
                C1804n c1804n = AbstractC1795e.f6193a;
                Set set = AbstractC0147a.f354a;
                if (!set.contains(AbstractC1795e.class)) {
                    try {
                        C1798h c1798hM3966h = C1798h.m3966h();
                        c1798hM3966h.getClass();
                        if (!set.contains(c1798hM3966h)) {
                            try {
                                ((HashMap) c1798hM3966h.f6212e).remove(Integer.valueOf(activity.hashCode()));
                            } catch (Throwable th) {
                                AbstractC0147a.m295a(th, c1798hM3966h);
                                return;
                            }
                            break;
                        }
                    } catch (Throwable th2) {
                        AbstractC0147a.m295a(th2, AbstractC1795e.class);
                        return;
                    }
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Timer timer;
        switch (this.f6594a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ScheduledExecutorService scheduledExecutorService = AbstractC1874d.f6600a;
                HashMap map = C2085w.f7377b;
                AbstractC1117n.m2896f();
                AtomicInteger atomicInteger = AbstractC1874d.f6603d;
                if (atomicInteger.decrementAndGet() < 0) {
                    atomicInteger.set(0);
                    Log.w("s0.d", "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
                }
                AbstractC1874d.m4192a();
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strM4540i = AbstractC2056E.m4540i(activity);
                C1804n c1804n = AbstractC1795e.f6193a;
                Set set = AbstractC0147a.f354a;
                if (!set.contains(AbstractC1795e.class)) {
                    try {
                        if (AbstractC1795e.f6197e.get()) {
                            C1798h.m3966h().m3981p(activity);
                            C1803m c1803m = AbstractC1795e.f6195c;
                            if (c1803m != null && !set.contains(c1803m)) {
                                try {
                                    if (((Activity) ((WeakReference) c1803m.f6221g).get()) != null && (timer = (Timer) c1803m.f6222h) != null) {
                                        try {
                                            timer.cancel();
                                            c1803m.f6222h = null;
                                        } catch (Exception e3) {
                                            Log.e("o0.m", "Error unscheduling indexing job", e3);
                                        }
                                    }
                                } catch (Throwable th) {
                                    AbstractC0147a.m295a(th, c1803m);
                                }
                            }
                            SensorManager sensorManager = AbstractC1795e.f6194b;
                            if (sensorManager != null) {
                                sensorManager.unregisterListener(AbstractC1795e.f6193a);
                            }
                            break;
                        }
                    } catch (Throwable th2) {
                        AbstractC0147a.m295a(th2, AbstractC1795e.class);
                    }
                }
                AbstractC1874d.f6600a.execute(new RunnableC1873c(jCurrentTimeMillis, strM4540i));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        switch (this.f6594a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ScheduledExecutorService scheduledExecutorService = AbstractC1874d.f6600a;
                HashMap map = C2085w.f7377b;
                AbstractC1117n.m2896f();
                AbstractC1874d.f6609j = new WeakReference(activity);
                AbstractC1874d.f6603d.incrementAndGet();
                AbstractC1874d.m4192a();
                long jCurrentTimeMillis = System.currentTimeMillis();
                AbstractC1874d.f6607h = jCurrentTimeMillis;
                String strM4540i = AbstractC2056E.m4540i(activity);
                C1804n c1804n = AbstractC1795e.f6193a;
                Set set = AbstractC0147a.f354a;
                if (!set.contains(AbstractC1795e.class)) {
                    try {
                        if (AbstractC1795e.f6197e.get()) {
                            C1798h.m3966h().m3968a(activity);
                            Context applicationContext = activity.getApplicationContext();
                            AbstractC2069g.m4584h();
                            String str = AbstractC1117n.f3877c;
                            C2079q c2079qM4621b = AbstractC2082t.m4621b(str);
                            if (c2079qM4621b == null || !c2079qM4621b.f7356g) {
                                set.contains(AbstractC1795e.class);
                            } else {
                                SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
                                AbstractC1795e.f6194b = sensorManager;
                                if (sensorManager != null) {
                                    Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                                    C1803m c1803m = new C1803m();
                                    c1803m.f6221g = new WeakReference(activity);
                                    c1803m.f6219e = null;
                                    c1803m.f6220f = new Handler(Looper.getMainLooper());
                                    AbstractC1795e.f6195c = c1803m;
                                    C1804n c1804n2 = AbstractC1795e.f6193a;
                                    C0009j c0009j = new C0009j(c2079qM4621b, 27, str);
                                    if (!set.contains(c1804n2)) {
                                        try {
                                            c1804n2.f6223a = c0009j;
                                        } catch (Throwable th) {
                                            AbstractC0147a.m295a(th, c1804n2);
                                        }
                                    }
                                    AbstractC1795e.f6194b.registerListener(c1804n2, defaultSensor, 2);
                                    if (c2079qM4621b.f7356g) {
                                        AbstractC1795e.f6195c.m4004o();
                                    }
                                    break;
                                }
                            }
                            AbstractC0147a.f354a.contains(AbstractC1795e.class);
                            break;
                        }
                    } catch (Throwable th2) {
                        AbstractC0147a.m295a(th2, AbstractC1795e.class);
                    }
                }
                if (!AbstractC0147a.f354a.contains(AbstractC1776a.class)) {
                    try {
                        if (AbstractC1776a.f6152a.booleanValue() && !C1778c.m3937d().isEmpty()) {
                            ViewTreeObserverOnGlobalFocusChangeListenerC1779d.m3940d(activity);
                        }
                        break;
                    } catch (Exception unused) {
                    } catch (Throwable th3) {
                        AbstractC0147a.m295a(th3, AbstractC1776a.class);
                    }
                }
                AbstractC1989d.m4404d(activity);
                AbstractC1874d.f6600a.execute(new RunnableC1872b(jCurrentTimeMillis, strM4540i, activity.getApplicationContext()));
                break;
            default:
                try {
                    AbstractC1117n.m2891a().execute(new RunnableC0218b(9));
                } catch (Exception unused2) {
                    return;
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        switch (this.f6594a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ScheduledExecutorService scheduledExecutorService = AbstractC1874d.f6600a;
                HashMap map = C2085w.f7377b;
                AbstractC1117n.m2896f();
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        switch (this.f6594a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC1874d.f6608i++;
                HashMap map = C2085w.f7377b;
                AbstractC1117n.m2896f();
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        switch (this.f6594a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ScheduledExecutorService scheduledExecutorService = AbstractC1874d.f6600a;
                HashMap map = C2085w.f7377b;
                AbstractC1117n.m2896f();
                Set set = AbstractC0147a.f354a;
                if (!set.contains(C1718m.class)) {
                    try {
                        C0444d c0444d = AbstractC1715j.f5996a;
                        if (!set.contains(AbstractC1715j.class)) {
                            try {
                                AbstractC1715j.f5997b.execute(new RunnableC0218b(4));
                            } catch (Throwable th) {
                                AbstractC0147a.m295a(th, AbstractC1715j.class);
                            }
                        }
                    } catch (Throwable th2) {
                        AbstractC0147a.m295a(th2, C1718m.class);
                    }
                }
                AbstractC1874d.f6608i--;
                break;
            default:
                try {
                    if (AbstractC1883m.f6620c.booleanValue() && activity.getLocalClassName().equals("com.android.billingclient.api.ProxyBillingActivity")) {
                        AbstractC1117n.m2891a().execute(new RunnableC0218b(10));
                        break;
                    }
                } catch (Exception unused) {
                    return;
                }
                break;
        }
    }
}
