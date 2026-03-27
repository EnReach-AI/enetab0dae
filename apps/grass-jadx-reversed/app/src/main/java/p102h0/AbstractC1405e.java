package p102h0;

import android.os.Looper;
import android.webkit.TracingConfig;
import android.webkit.TracingController;
import android.webkit.WebView;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import p099g0.AbstractC1388a;

/* JADX INFO: renamed from: h0.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1405e {
    /* JADX INFO: renamed from: a */
    public static TracingController m3414a() {
        return TracingController.getInstance();
    }

    /* JADX INFO: renamed from: b */
    public static ClassLoader m3415b() {
        return WebView.getWebViewClassLoader();
    }

    /* JADX INFO: renamed from: c */
    public static Looper m3416c(WebView webView) {
        return webView.getWebViewLooper();
    }

    /* JADX INFO: renamed from: d */
    public static boolean m3417d(TracingController tracingController) {
        return tracingController.isTracing();
    }

    /* JADX INFO: renamed from: e */
    public static void m3418e(String str) {
        WebView.setDataDirectorySuffix(str);
    }

    /* JADX INFO: renamed from: f */
    public static void m3419f(TracingController tracingController, AbstractC1388a abstractC1388a) {
        new TracingConfig.Builder();
        throw null;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m3420g(TracingController tracingController, OutputStream outputStream, Executor executor) {
        return tracingController.stop(outputStream, executor);
    }
}
