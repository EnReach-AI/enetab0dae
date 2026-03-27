package io.getgrass.www;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.emoji2.text.C0905l;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;
import p001A.RunnableC0014o;
import p019F0.C0221e;
import p026I.C0295c;
import p099g0.C1389b;
import p099g0.C1390c;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class RustWebViewClient extends WebViewClient {

    /* JADX INFO: renamed from: f */
    public static final /* synthetic */ int f5228f = 0;

    /* JADX INFO: renamed from: a */
    public final LinkedHashMap f5229a;

    /* JADX INFO: renamed from: b */
    public String f5230b;

    /* JADX INFO: renamed from: c */
    public Uri f5231c;

    /* JADX INFO: renamed from: d */
    public String f5232d;

    /* JADX INFO: renamed from: e */
    public final C0221e f5233e;

    public static final class Companion {
    }

    static {
        System.loadLibrary("app_lib");
    }

    public RustWebViewClient(Context context) {
        AbstractC1766e.m3920e("context", context);
        this.f5229a = new LinkedHashMap();
        this.f5230b = "about:blank";
        ArrayList<C0295c> arrayList = new ArrayList();
        String strAssetLoaderDomain = assetLoaderDomain();
        C1389b c1389b = new C1389b();
        C0905l c0905l = new C0905l();
        c0905l.f2986a = context;
        c1389b.f5016a = c0905l;
        arrayList.add(new C0295c("/", c1389b));
        ArrayList arrayList2 = new ArrayList();
        for (C0295c c0295c : arrayList) {
            arrayList2.add(new C1390c(strAssetLoaderDomain, (String) c0295c.f793a, (C1389b) c0295c.f794b));
        }
        this.f5233e = new C0221e(15, arrayList2);
    }

    private final native String assetLoaderDomain();

    private final native WebResourceResponse handleRequest(String str, WebResourceRequest webResourceRequest, boolean z3);

    private final native void onPageLoaded(String str);

    private final native void onPageLoading(String str);

    private final native boolean shouldOverride(String str);

    private final native boolean withAssetLoader();

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        AbstractC1766e.m3920e("view", webView);
        AbstractC1766e.m3920e("url", str);
        onPageLoaded(str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        AbstractC1766e.m3920e("view", webView);
        AbstractC1766e.m3920e("url", str);
        this.f5230b = str;
        if (AbstractC1766e.m3916a(this.f5229a.get(str), Boolean.FALSE)) {
            for (String str2 : ((RustWebView) webView).getInitScripts()) {
                webView.evaluateJavascript(str2, null);
            }
        }
        onPageLoading(str);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        AbstractC1766e.m3920e("view", webView);
        AbstractC1766e.m3920e("request", webResourceRequest);
        AbstractC1766e.m3920e("error", webResourceError);
        if (webResourceError.getErrorCode() != -6 || !webResourceRequest.isForMainFrame() || AbstractC1766e.m3916a(webResourceRequest.getUrl(), this.f5231c)) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            return;
        }
        webView.stopLoading();
        webView.loadUrl(webResourceRequest.getUrl().toString());
        this.f5232d = webResourceRequest.getUrl().toString();
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        AbstractC1766e.m3920e("view", webView);
        AbstractC1766e.m3920e("request", webResourceRequest);
        String str = this.f5232d;
        if (str != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0014o(webView, 3, str));
            this.f5232d = null;
            return null;
        }
        this.f5231c = webResourceRequest.getUrl();
        if (!withAssetLoader()) {
            RustWebView rustWebView = (RustWebView) webView;
            WebResourceResponse webResourceResponseHandleRequest = handleRequest(rustWebView.getId(), webResourceRequest, rustWebView.f5227g);
            LinkedHashMap linkedHashMap = this.f5229a;
            String string = webResourceRequest.getUrl().toString();
            AbstractC1766e.m3919d("toString(...)", string);
            linkedHashMap.put(string, Boolean.valueOf(webResourceResponseHandleRequest != null));
            return webResourceResponseHandleRequest;
        }
        Uri url = webResourceRequest.getUrl();
        for (C1390c c1390c : (List) this.f5233e.f534f) {
            c1390c.getClass();
            boolean zEquals = url.getScheme().equals("http");
            String str2 = c1390c.f5019c;
            C1389b c1389b = ((!zEquals || c1390c.f5017a) && (url.getScheme().equals("http") || url.getScheme().equals("https")) && url.getAuthority().equals(c1390c.f5018b) && url.getPath().startsWith(str2)) ? c1390c.f5020d : null;
            if (c1389b != null) {
                String strReplaceFirst = url.getPath().replaceFirst(str2, "");
                try {
                    C0905l c0905l = c1389b.f5016a;
                    c0905l.getClass();
                    String strSubstring = (strReplaceFirst.length() <= 1 || strReplaceFirst.charAt(0) != '/') ? strReplaceFirst : strReplaceFirst.substring(1);
                    InputStream inputStreamOpen = c0905l.f2986a.getAssets().open(strSubstring, 2);
                    if (strSubstring.endsWith(".svgz")) {
                        inputStreamOpen = new GZIPInputStream(inputStreamOpen);
                    }
                    String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(strReplaceFirst);
                    if (strGuessContentTypeFromName == null) {
                        strGuessContentTypeFromName = "text/plain";
                    }
                    return new WebResourceResponse(strGuessContentTypeFromName, null, inputStreamOpen);
                } catch (IOException e3) {
                    Log.e("WebViewAssetLoader", "Error opening asset path: " + strReplaceFirst, e3);
                    return new WebResourceResponse(null, null, null);
                }
            }
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        AbstractC1766e.m3920e("view", webView);
        AbstractC1766e.m3920e("request", webResourceRequest);
        String string = webResourceRequest.getUrl().toString();
        AbstractC1766e.m3919d("toString(...)", string);
        return shouldOverride(string);
    }
}
