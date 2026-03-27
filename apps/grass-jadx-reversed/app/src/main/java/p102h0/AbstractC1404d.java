package p102h0;

import android.content.pm.PackageInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: renamed from: h0.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1404d {
    /* JADX INFO: renamed from: a */
    public static PackageInfo m3409a() {
        return WebView.getCurrentWebViewPackage();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3410b(WebSettings webSettings) {
        return webSettings.getSafeBrowsingEnabled();
    }

    /* JADX INFO: renamed from: c */
    public static WebChromeClient m3411c(WebView webView) {
        return webView.getWebChromeClient();
    }

    /* JADX INFO: renamed from: d */
    public static WebViewClient m3412d(WebView webView) {
        return webView.getWebViewClient();
    }

    /* JADX INFO: renamed from: e */
    public static void m3413e(WebSettings webSettings, boolean z3) {
        webSettings.setSafeBrowsingEnabled(z3);
    }
}
