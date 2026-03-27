package p150u2;

import java.lang.Thread;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;
import p083b2.AbstractC1056a;
import p089d2.C1318l;
import p119m2.AbstractC1766e;
import p139r2.AbstractC1856c;
import p139r2.C1854a;
import p139r2.C1858e;

/* JADX INFO: renamed from: u2.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1957f {

    /* JADX INFO: renamed from: a */
    public static final List f6976a;

    static {
        try {
            Iterator it = Arrays.asList(new AndroidExceptionPreHandler()).iterator();
            AbstractC1766e.m3920e("<this>", it);
            f6976a = AbstractC1856c.m4134j(new C1854a(new C1858e(it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m4359a(Throwable th) {
        Throwable runtimeException;
        C1318l c1318l = C1318l.f4678e;
        Iterator it = f6976a.iterator();
        while (it.hasNext()) {
            try {
                ((InterfaceC1956e) it.next()).handleException(c1318l, th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadCurrentThread.getUncaughtExceptionHandler();
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    AbstractC1056a.m2814a(runtimeException, th);
                }
                uncaughtExceptionHandler.uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        try {
            AbstractC1056a.m2814a(th, new C1961j());
        } catch (Throwable unused) {
        }
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
