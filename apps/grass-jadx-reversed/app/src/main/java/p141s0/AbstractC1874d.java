package p141s0;

import android.app.Application;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p025H1.C0276e;
import p110k.C1605n;
import p166z0.AbstractC2077o;
import p166z0.EnumC2076n;

/* JADX INFO: renamed from: s0.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1874d {

    /* JADX INFO: renamed from: b */
    public static volatile ScheduledFuture f6601b;

    /* JADX INFO: renamed from: e */
    public static volatile C1605n f6604e;

    /* JADX INFO: renamed from: g */
    public static String f6606g;

    /* JADX INFO: renamed from: h */
    public static long f6607h;

    /* JADX INFO: renamed from: j */
    public static WeakReference f6609j;

    /* JADX INFO: renamed from: a */
    public static final ScheduledExecutorService f6600a = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: c */
    public static final Object f6602c = new Object();

    /* JADX INFO: renamed from: d */
    public static final AtomicInteger f6603d = new AtomicInteger(0);

    /* JADX INFO: renamed from: f */
    public static final AtomicBoolean f6605f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i */
    public static int f6608i = 0;

    /* JADX INFO: renamed from: a */
    public static void m4192a() {
        synchronized (f6602c) {
            try {
                if (f6601b != null) {
                    f6601b.cancel(false);
                }
                f6601b = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static UUID m4193b() {
        if (f6604e != null) {
            return (UUID) f6604e.f5698f;
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public static void m4194c(Application application, String str) {
        if (f6605f.compareAndSet(false, true)) {
            AbstractC2077o.m4612a(new C0276e(12), EnumC2076n.CodelessEvents);
            f6606g = str;
            application.registerActivityLifecycleCallbacks(new C1871a(0));
        }
    }
}
