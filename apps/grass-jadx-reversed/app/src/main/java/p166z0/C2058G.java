package p166z0;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.AbstractC1117n;
import com.facebook.C1109f;
import com.facebook.C1114k;
import com.facebook.C1119p;
import java.util.HashSet;

/* JADX INFO: renamed from: z0.G */
/* JADX INFO: loaded from: classes.dex */
public final class C2058G extends WebViewClient {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ DialogC2062K f7272a;

    public C2058G(DialogC2062K dialogC2062K) {
        this.f7272a = dialogC2062K;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        DialogC2062K dialogC2062K = this.f7272a;
        if (!dialogC2062K.f7291n) {
            dialogC2062K.f7286i.dismiss();
        }
        dialogC2062K.f7288k.setBackgroundColor(0);
        dialogC2062K.f7285h.setVisibility(0);
        dialogC2062K.f7287j.setVisibility(0);
        dialogC2062K.f7292o = true;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        HashSet hashSet = AbstractC1117n.f3875a;
        super.onPageStarted(webView, str, bitmap);
        DialogC2062K dialogC2062K = this.f7272a;
        if (dialogC2062K.f7291n) {
            return;
        }
        dialogC2062K.f7286i.show();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i3, String str, String str2) {
        super.onReceivedError(webView, i3, str, str2);
        this.f7272a.m4565f(new C1109f(i3, str, str2));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        sslErrorHandler.cancel();
        this.f7272a.m4565f(new C1109f(-11, null, null));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        int i3;
        HashSet hashSet = AbstractC1117n.f3875a;
        DialogC2062K dialogC2062K = this.f7272a;
        if (!str.startsWith(dialogC2062K.f7283f)) {
            if (str.startsWith("fbconnect://cancel")) {
                dialogC2062K.cancel();
                return true;
            }
            if (str.contains("touch")) {
                return false;
            }
            try {
                dialogC2062K.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        }
        Bundle bundleMo4563d = dialogC2062K.mo4563d(str);
        String string = bundleMo4563d.getString("error");
        if (string == null) {
            string = bundleMo4563d.getString("error_type");
        }
        String string2 = bundleMo4563d.getString("error_msg");
        if (string2 == null) {
            string2 = bundleMo4563d.getString("error_message");
        }
        if (string2 == null) {
            string2 = bundleMo4563d.getString("error_description");
        }
        String string3 = bundleMo4563d.getString("error_code");
        if (AbstractC2056E.m4550s(string3)) {
            i3 = -1;
        } else {
            try {
                i3 = Integer.parseInt(string3);
            } catch (NumberFormatException unused2) {
                i3 = -1;
            }
        }
        if (AbstractC2056E.m4550s(string) && AbstractC2056E.m4550s(string2) && i3 == -1) {
            InterfaceC2059H interfaceC2059H = dialogC2062K.f7284g;
            if (interfaceC2059H != null && !dialogC2062K.f7290m) {
                dialogC2062K.f7290m = true;
                interfaceC2059H.mo59s(bundleMo4563d, null);
                dialogC2062K.dismiss();
            }
        } else if ((string == null || !(string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) && i3 != 4201) {
            dialogC2062K.m4565f(new C1119p(new C1114k(i3, string, string2), string2));
        } else {
            dialogC2062K.cancel();
        }
        return true;
    }
}
