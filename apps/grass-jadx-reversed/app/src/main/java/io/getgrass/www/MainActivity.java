package io.getgrass.www;

import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class MainActivity extends TauriActivity {

    /* JADX INFO: renamed from: A */
    public WebView f5168A;

    @Override // io.getgrass.www.WryActivity, p098g.AbstractActivityC1367f, androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Log.d(getPackageName(), "[MainActivity][onDestroy]");
        WebView webView = this.f5168A;
        ViewParent parent = webView != null ? webView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f5168A);
        }
        WebView webView2 = this.f5168A;
        if (webView2 != null) {
            webView2.stopLoading();
        }
        WebView webView3 = this.f5168A;
        if (webView3 != null) {
            webView3.loadUrl("about:blank");
        }
        WebView webView4 = this.f5168A;
        if (webView4 != null) {
            webView4.clearHistory();
        }
        WebView webView5 = this.f5168A;
        if (webView5 != null) {
            webView5.removeAllViews();
        }
        WebView webView6 = this.f5168A;
        if (webView6 != null) {
            webView6.destroy();
        }
    }

    @Override // io.getgrass.www.WryActivity, android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        sendHasFocus(z3);
    }

    @Override // io.getgrass.www.WryActivity
    /* JADX INFO: renamed from: p */
    public final void mo3467p(WebView webView) {
        AbstractC1766e.m3920e("webView", webView);
        this.f5168A = webView;
    }

    public final native boolean sendHasFocus(boolean z3);
}
