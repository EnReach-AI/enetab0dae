package p001A;

import android.graphics.Typeface;
import android.util.Log;
import android.webkit.WebView;
import io.getgrass.plugin.ForegroundService;
import io.getgrass.www.RustWebViewClient;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p098g.ExecutorC1355A;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: A.o */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0014o implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f37e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f38f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f39g;

    public /* synthetic */ RunnableC0014o(Object obj, int i3, Object obj2) {
        this.f37e = i3;
        this.f38f = obj;
        this.f39g = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f39g;
        Object obj2 = this.f38f;
        switch (this.f37e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((AbstractC0001b) obj2).mo14h((Typeface) obj);
                return;
            case 1:
                ForegroundService foregroundService = (ForegroundService) obj2;
                AbstractC1766e.m3920e("$service", foregroundService);
                ForegroundService.Companion companion = (ForegroundService.Companion) obj;
                AbstractC1766e.m3920e("this$0", companion);
                try {
                    foregroundService.f5166j = false;
                    Log.d(companion.toString(), "Trying to run stopWebsocket");
                    foregroundService.stopWebsocket();
                    return;
                } catch (UnsatisfiedLinkError unused) {
                    Log.e(companion.toString(), "Error running stopWebsocket");
                    return;
                }
            case 2:
                Runnable runnable = (Runnable) obj;
                ExecutorC1355A executorC1355A = (ExecutorC1355A) obj2;
                executorC1355A.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    executorC1355A.m3310a();
                }
            default:
                int i3 = RustWebViewClient.f5228f;
                WebView webView = (WebView) obj2;
                AbstractC1766e.m3920e("$view", webView);
                String str = (String) obj;
                AbstractC1766e.m3920e("$it", str);
                webView.loadUrl(str);
                return;
        }
    }
}
