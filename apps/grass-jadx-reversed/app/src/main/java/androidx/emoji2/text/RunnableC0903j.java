package androidx.emoji2.text;

import android.support.v4.media.session.AbstractC0864a;
import io.getgrass.www.RustWebView;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p071Y0.AbstractC0752p;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: androidx.emoji2.text.j */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0903j implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f2980e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f2981f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f2982g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ Object f2983h;

    public /* synthetic */ RunnableC0903j(Object obj, Object obj2, Object obj3, int i3) {
        this.f2980e = i3;
        this.f2981f = obj;
        this.f2982g = obj2;
        this.f2983h = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2980e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0905l c0905l = (C0905l) this.f2981f;
                AbstractC0864a abstractC0864a = (AbstractC0864a) this.f2982g;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f2983h;
                c0905l.getClass();
                try {
                    C0909p c0909pM1934c = AbstractC0752p.m1934c(c0905l.f2986a);
                    if (c0909pM1934c == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    C0908o c0908o = (C0908o) ((InterfaceC0901h) c0909pM1934c.f2410b);
                    synchronized (c0908o.f3000d) {
                        c0908o.f3002f = threadPoolExecutor;
                        break;
                    }
                    ((InterfaceC0901h) c0909pM1934c.f2410b).mo2340a(new C0904k(abstractC0864a, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    abstractC0864a.mo2191h(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            default:
                int i3 = RustWebView.f5224h;
                RustWebView rustWebView = (RustWebView) this.f2981f;
                AbstractC1766e.m3920e("this$0", rustWebView);
                String str = (String) this.f2982g;
                AbstractC1766e.m3920e("$url", str);
                Map map = (Map) this.f2983h;
                AbstractC1766e.m3920e("$additionalHttpHeaders", map);
                rustWebView.loadUrl(str, map);
                return;
        }
    }
}
