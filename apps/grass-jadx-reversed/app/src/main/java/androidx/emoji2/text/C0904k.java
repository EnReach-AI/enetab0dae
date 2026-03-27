package androidx.emoji2.text;

import android.support.v4.media.session.AbstractC0864a;
import java.util.concurrent.ThreadPoolExecutor;
import p125o0.C1803m;

/* JADX INFO: renamed from: androidx.emoji2.text.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0904k extends AbstractC0864a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC0864a f2984a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ThreadPoolExecutor f2985b;

    public C0904k(AbstractC0864a abstractC0864a, ThreadPoolExecutor threadPoolExecutor) {
        this.f2984a = abstractC0864a;
        this.f2985b = threadPoolExecutor;
    }

    @Override // android.support.v4.media.session.AbstractC0864a
    /* JADX INFO: renamed from: h */
    public final void mo2191h(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f2985b;
        try {
            this.f2984a.mo2191h(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // android.support.v4.media.session.AbstractC0864a
    /* JADX INFO: renamed from: i */
    public final void mo2192i(C1803m c1803m) {
        ThreadPoolExecutor threadPoolExecutor = this.f2985b;
        try {
            this.f2984a.mo2192i(c1803m);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
