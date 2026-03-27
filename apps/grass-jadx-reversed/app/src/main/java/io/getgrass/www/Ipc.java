package io.getgrass.www;

import android.webkit.JavascriptInterface;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class Ipc {

    /* JADX INFO: renamed from: a */
    public final RustWebViewClient f5167a;

    public static final class Companion {
    }

    static {
        System.loadLibrary("app_lib");
    }

    public Ipc(RustWebViewClient rustWebViewClient) {
        AbstractC1766e.m3920e("webViewClient", rustWebViewClient);
        this.f5167a = rustWebViewClient;
    }

    private final native void ipc(String str, String str2);

    @JavascriptInterface
    public final void postMessage(String str) {
        if (str != null) {
            ipc(this.f5167a.f5230b, str);
        }
    }
}
