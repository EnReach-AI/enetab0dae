package io.getgrass.www;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: io.getgrass.www.f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC1459f implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f5247e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ RustWebView f5248f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ String f5249g;

    public /* synthetic */ RunnableC1459f(int i3, RustWebView rustWebView, String str) {
        this.f5247e = i3;
        this.f5248f = rustWebView;
        this.f5249g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f5249g;
        RustWebView rustWebView = this.f5248f;
        switch (this.f5247e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int i3 = RustWebView.f5224h;
                AbstractC1766e.m3920e("this$0", rustWebView);
                AbstractC1766e.m3920e("$html", str);
                rustWebView.loadData(str, "text/html", null);
                break;
            default:
                int i4 = RustWebView.f5224h;
                AbstractC1766e.m3920e("this$0", rustWebView);
                AbstractC1766e.m3920e("$url", str);
                rustWebView.loadUrl(str);
                break;
        }
    }
}
