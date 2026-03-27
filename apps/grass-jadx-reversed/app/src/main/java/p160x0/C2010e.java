package p160x0;

import android.webkit.WebView;

/* JADX INFO: renamed from: x0.e */
/* JADX INFO: loaded from: classes.dex */
public final class C2010e {

    /* JADX INFO: renamed from: f */
    public static final int[] f7162f = new int[2];

    /* JADX INFO: renamed from: a */
    public final String f7163a;

    /* JADX INFO: renamed from: b */
    public final int f7164b;

    /* JADX INFO: renamed from: c */
    public final int f7165c;

    /* JADX INFO: renamed from: d */
    public final int f7166d;

    /* JADX INFO: renamed from: e */
    public final int f7167e;

    public C2010e(WebView webView) {
        this.f7163a = webView.getClass().getName() + "{" + Integer.toHexString(webView.hashCode()) + "}";
        int[] iArr = f7162f;
        webView.getLocationOnScreen(iArr);
        this.f7164b = iArr[0];
        this.f7165c = iArr[1];
        this.f7166d = webView.getWidth();
        this.f7167e = webView.getHeight();
    }
}
