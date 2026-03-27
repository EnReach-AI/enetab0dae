package io.getgrass.www;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.fragment.app.C0945p;
import p077a0.C0842a;
import p098g.AbstractActivityC1367f;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public abstract class WryActivity extends AbstractActivityC1367f {

    /* JADX INFO: renamed from: y */
    public RustWebView f5235y;

    public static final class Companion {
    }

    static {
        System.loadLibrary("app_lib");
    }

    public WryActivity() {
        this.f2601i.f2519b.m2176f("androidx:appcompat", new C0842a(this, 2));
        m2200f(new C0945p(this, 1));
    }

    private final native void create(WryActivity wryActivity);

    private final native void destroy();

    private final native void focus(boolean z3);

    private final native void memory();

    private final native void onActivityDestroy();

    private final native void pause();

    private final native void resume();

    private final native void save();

    private final native void start();

    private final native void stop();

    public final Class<?> getAppClass(String str) {
        AbstractC1766e.m3920e("name", str);
        return Class.forName(str);
    }

    @SuppressLint({"WebViewApiAvailability", "ObsoleteSdkInt"})
    public final String getVersion() {
        PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
        String str = currentWebViewPackage != null ? currentWebViewPackage.versionName : null;
        return str == null ? "" : str;
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, androidx.activity.AbstractActivityC0873h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        create(this);
    }

    @Override // p098g.AbstractActivityC1367f, androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        destroy();
        onActivityDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            RustWebView rustWebView = this.f5235y;
            if (rustWebView == null) {
                AbstractC1766e.m3924i("mWebView");
                throw null;
            }
            if (rustWebView.canGoBack()) {
                RustWebView rustWebView2 = this.f5235y;
                if (rustWebView2 != null) {
                    rustWebView2.goBack();
                    return true;
                }
                AbstractC1766e.m3924i("mWebView");
                throw null;
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, android.app.Activity, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        memory();
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public void onPause() {
        super.onPause();
        pause();
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public void onResume() {
        super.onResume();
        resume();
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        AbstractC1766e.m3920e("outState", bundle);
        super.onSaveInstanceState(bundle);
        save();
    }

    @Override // p098g.AbstractActivityC1367f, androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public final void onStart() {
        super.onStart();
        start();
    }

    @Override // p098g.AbstractActivityC1367f, androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public final void onStop() {
        super.onStop();
        stop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        focus(z3);
    }

    /* JADX INFO: renamed from: p */
    public void mo3467p(WebView webView) {
        AbstractC1766e.m3920e("webView", webView);
    }

    public final void setWebView(RustWebView rustWebView) {
        AbstractC1766e.m3920e("webView", rustWebView);
        this.f5235y = rustWebView;
        mo3467p(rustWebView);
    }
}
