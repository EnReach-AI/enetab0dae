package p102h0;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: renamed from: h0.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1407g implements InterfaceC1412l {

    /* JADX INFO: renamed from: e */
    public static final String[] f5033e = new String[0];

    @Override // p102h0.InterfaceC1412l
    public final WebViewProviderBoundaryInterface createWebView(WebView webView) {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }

    @Override // p102h0.InterfaceC1412l
    /* JADX INFO: renamed from: g */
    public final String[] mo447g() {
        return f5033e;
    }
}
