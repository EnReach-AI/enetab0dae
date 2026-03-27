package p079a2;

import android.webkit.WebView;
import app.tauri.plugin.JSObject;
import io.getgrass.plugin.ExamplePlugin;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: a2.a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0856a implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f2526e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ ExamplePlugin f2527f;

    public /* synthetic */ RunnableC0856a(ExamplePlugin examplePlugin, int i3) {
        this.f2526e = i3;
        this.f2527f = examplePlugin;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2526e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ExamplePlugin examplePlugin = this.f2527f;
                AbstractC1766e.m3920e("this$0", examplePlugin);
                examplePlugin.m2687e("onForegroundServiceStart", new JSObject());
                break;
            case 1:
                ExamplePlugin examplePlugin2 = this.f2527f;
                AbstractC1766e.m3920e("this$0", examplePlugin2);
                try {
                    Thread.sleep(1000L);
                    examplePlugin2.f5150d.runOnUiThread(new RunnableC0856a(examplePlugin2, 2));
                } catch (InterruptedException unused) {
                    return;
                }
                break;
            default:
                ExamplePlugin examplePlugin3 = this.f2527f;
                AbstractC1766e.m3920e("this$0", examplePlugin3);
                WebView webView = examplePlugin3.f5152f;
                if (webView != null) {
                    webView.dispatchWindowVisibilityChanged(0);
                }
                break;
        }
    }
}
