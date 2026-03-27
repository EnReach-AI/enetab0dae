package p166z0;

import com.facebook.CallableC1115l;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import p160x0.C2011f;

/* JADX INFO: renamed from: z0.v */
/* JADX INFO: loaded from: classes.dex */
public final class CallableC2084v implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Callable f7375a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2011f f7376b;

    public CallableC2084v(C2011f c2011f, CallableC1115l callableC1115l) {
        this.f7376b = c2011f;
        this.f7375a = callableC1115l;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        C2011f c2011f = this.f7376b;
        try {
            c2011f.f7168a = this.f7375a.call();
            ((CountDownLatch) c2011f.f7169b).countDown();
            return null;
        } catch (Throwable th) {
            ((CountDownLatch) c2011f.f7169b).countDown();
            throw th;
        }
    }
}
