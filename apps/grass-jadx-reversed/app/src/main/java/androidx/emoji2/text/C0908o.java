package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.media.session.AbstractC0864a;
import com.facebook.C1107d;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p015D2.C0192p;
import p019F0.C0217a;
import p021G.AbstractC0228e;
import p021G.C0233j;
import p028I1.RunnableC0304d;
import p039M0.AbstractC0493h0;

/* JADX INFO: renamed from: androidx.emoji2.text.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0908o implements InterfaceC0901h {

    /* JADX INFO: renamed from: a */
    public final Context f2997a;

    /* JADX INFO: renamed from: b */
    public final C1107d f2998b;

    /* JADX INFO: renamed from: c */
    public final C0217a f2999c;

    /* JADX INFO: renamed from: d */
    public final Object f3000d;

    /* JADX INFO: renamed from: e */
    public Handler f3001e;

    /* JADX INFO: renamed from: f */
    public Executor f3002f;

    /* JADX INFO: renamed from: g */
    public ThreadPoolExecutor f3003g;

    /* JADX INFO: renamed from: h */
    public AbstractC0864a f3004h;

    public C0908o(Context context, C1107d c1107d) {
        C0217a c0217a = C0909p.f3005d;
        this.f3000d = new Object();
        AbstractC0493h0.m1010c("Context cannot be null", context);
        this.f2997a = context.getApplicationContext();
        this.f2998b = c1107d;
        this.f2999c = c0217a;
    }

    @Override // androidx.emoji2.text.InterfaceC0901h
    /* JADX INFO: renamed from: a */
    public final void mo2340a(AbstractC0864a abstractC0864a) {
        synchronized (this.f3000d) {
            this.f3004h = abstractC0864a;
        }
        m2355c();
    }

    /* JADX INFO: renamed from: b */
    public final void m2354b() {
        synchronized (this.f3000d) {
            try {
                this.f3004h = null;
                Handler handler = this.f3001e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f3001e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f3003g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f3002f = null;
                this.f3003g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m2355c() {
        synchronized (this.f3000d) {
            try {
                if (this.f3004h == null) {
                    return;
                }
                if (this.f3002f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0894a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f3003g = threadPoolExecutor;
                    this.f3002f = threadPoolExecutor;
                }
                this.f3002f.execute(new RunnableC0304d(6, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final C0233j m2356d() {
        try {
            C0217a c0217a = this.f2999c;
            Context context = this.f2997a;
            C1107d c1107d = this.f2998b;
            c0217a.getClass();
            C0192p c0192pM473a = AbstractC0228e.m473a(context, c1107d);
            int i3 = c0192pM473a.f443f;
            if (i3 != 0) {
                throw new RuntimeException("fetchFonts failed (" + i3 + ")");
            }
            C0233j[] c0233jArr = (C0233j[]) c0192pM473a.f444g;
            if (c0233jArr == null || c0233jArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return c0233jArr[0];
        } catch (PackageManager.NameNotFoundException e3) {
            throw new RuntimeException("provider not found", e3);
        }
    }
}
