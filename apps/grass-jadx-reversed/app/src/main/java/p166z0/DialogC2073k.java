package p166z0;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.AbstractC1117n;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
import p007B1.RunnableC0055o;

/* JADX INFO: renamed from: z0.k */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC2073k extends DialogC2062K {

    /* JADX INFO: renamed from: s */
    public static final /* synthetic */ int f7318s = 0;

    /* JADX INFO: renamed from: r */
    public boolean f7319r;

    @Override // p166z0.DialogC2062K, android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        C2057F c2057f = this.f7285h;
        if (!this.f7292o || this.f7290m || c2057f == null || !c2057f.isShown()) {
            super.cancel();
        } else {
            if (this.f7319r) {
                return;
            }
            this.f7319r = true;
            c2057f.loadUrl("javascript:(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0055o(23, this), 1500L);
        }
    }

    @Override // p166z0.DialogC2062K
    /* JADX INFO: renamed from: d */
    public final Bundle mo4563d(String str) {
        Bundle bundleM4554w = AbstractC2056E.m4554w(Uri.parse(str).getQuery());
        String string = bundleM4554w.getString("bridge_args");
        bundleM4554w.remove("bridge_args");
        if (!AbstractC2056E.m4550s(string)) {
            try {
                bundleM4554w.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", AbstractC2067e.m4573a(new JSONObject(string)));
            } catch (JSONException unused) {
                HashSet hashSet = AbstractC1117n.f3875a;
            }
        }
        String string2 = bundleM4554w.getString("method_results");
        bundleM4554w.remove("method_results");
        if (!AbstractC2056E.m4550s(string2)) {
            if (AbstractC2056E.m4550s(string2)) {
                string2 = "{}";
            }
            try {
                bundleM4554w.putBundle("com.facebook.platform.protocol.RESULT_ARGS", AbstractC2067e.m4573a(new JSONObject(string2)));
            } catch (JSONException unused2) {
                HashSet hashSet2 = AbstractC1117n.f3875a;
            }
        }
        bundleM4554w.remove("version");
        bundleM4554w.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", AbstractC2087y.m4638g());
        return bundleM4554w;
    }
}
