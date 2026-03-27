package io.getgrass.www;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.emoji2.text.RunnableC0903j;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p099g0.AbstractC1391d;
import p102h0.AbstractC1403c;
import p102h0.AbstractC1410j;
import p102h0.C1402b;
import p102h0.InterfaceC1406f;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class RustWebView extends WebView {

    /* JADX INFO: renamed from: h */
    public static final /* synthetic */ int f5224h = 0;

    /* JADX INFO: renamed from: e */
    public final String[] f5225e;

    /* JADX INFO: renamed from: f */
    public final String f5226f;

    /* JADX INFO: renamed from: g */
    public final boolean f5227g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RustWebView(Context context, String[] strArr, String str) {
        super(context);
        AbstractC1766e.m3920e("context", context);
        AbstractC1766e.m3920e("initScripts", strArr);
        AbstractC1766e.m3920e("id", str);
        this.f5225e = strArr;
        this.f5226f = str;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setGeolocationEnabled(true);
        getSettings().setDatabaseEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        C1402b c1402b = AbstractC1410j.f5036a;
        Set<InterfaceC1406f> setUnmodifiableSet = Collections.unmodifiableSet(AbstractC1403c.f5030c);
        HashSet hashSet = new HashSet();
        for (InterfaceC1406f interfaceC1406f : setUnmodifiableSet) {
            if (((AbstractC1403c) interfaceC1406f).f5031a.equals("DOCUMENT_START_SCRIPT")) {
                hashSet.add(interfaceC1406f);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException("Unknown feature DOCUMENT_START_SCRIPT");
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            AbstractC1403c abstractC1403c = (AbstractC1403c) ((InterfaceC1406f) it.next());
            if (abstractC1403c.mo3407a() || abstractC1403c.mo3408b()) {
                this.f5227g = true;
                for (String str2 : this.f5225e) {
                    Set setSingleton = Collections.singleton("*");
                    AbstractC1766e.m3919d("singleton(...)", setSingleton);
                    int i3 = AbstractC1391d.f5021a;
                    if (!AbstractC1410j.f5036a.mo3408b()) {
                        throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
                    }
                }
                return;
            }
        }
        this.f5227g = false;
    }

    /* JADX INFO: renamed from: a */
    public static void m3474a(int i3, RustWebView rustWebView, String str) {
        AbstractC1766e.m3920e("this$0", rustWebView);
        AbstractC1766e.m3917b(str);
        rustWebView.onEval(i3, str);
    }

    private final native void onEval(int i3, String str);

    private final native boolean shouldOverride(String str);

    public final void evalScript(final int i3, final String str) {
        AbstractC1766e.m3920e("script", str);
        post(new Runnable() { // from class: io.getgrass.www.e
            @Override // java.lang.Runnable
            public final void run() {
                int i4 = RustWebView.f5224h;
                final RustWebView rustWebView = this;
                AbstractC1766e.m3920e("this$0", rustWebView);
                String str2 = str;
                AbstractC1766e.m3920e("$script", str2);
                final int i5 = i3;
                rustWebView.evaluateJavascript(str2, new ValueCallback() { // from class: io.getgrass.www.g
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        RustWebView.m3474a(i5, rustWebView, (String) obj);
                    }
                });
            }
        });
    }

    @Override // android.view.View
    public final String getId() {
        return this.f5226f;
    }

    public final String[] getInitScripts() {
        return this.f5225e;
    }

    public final void loadHTMLMainThread(String str) {
        AbstractC1766e.m3920e("html", str);
        post(new RunnableC1459f(0, this, str));
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String str) {
        AbstractC1766e.m3920e("url", str);
        if (shouldOverride(str)) {
            return;
        }
        super.loadUrl(str);
    }

    public final void loadUrlMainThread(String str) {
        AbstractC1766e.m3920e("url", str);
        post(new RunnableC1459f(1, this, str));
    }

    public final void loadUrlMainThread(String str, Map<String, String> map) {
        AbstractC1766e.m3920e("url", str);
        AbstractC1766e.m3920e("additionalHttpHeaders", map);
        post(new RunnableC0903j(this, str, map, 1));
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String str, Map map) {
        AbstractC1766e.m3920e("url", str);
        AbstractC1766e.m3920e("additionalHttpHeaders", map);
        if (shouldOverride(str)) {
            return;
        }
        super.loadUrl(str, map);
    }
}
