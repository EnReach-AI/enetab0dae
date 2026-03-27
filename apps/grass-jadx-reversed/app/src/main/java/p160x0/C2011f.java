package p160x0;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.facebook.AbstractC1117n;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import p010C0.AbstractC0147a;
import p117m0.C1718m;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2083u;
import p166z0.C2068f;

/* JADX INFO: renamed from: x0.f */
/* JADX INFO: loaded from: classes.dex */
public final class C2011f implements InstallReferrerStateListener {

    /* JADX INFO: renamed from: a */
    public Object f7168a;

    /* JADX INFO: renamed from: b */
    public Object f7169b;

    /* JADX INFO: renamed from: b */
    public static String m4463b(C2010e c2010e, String str) {
        String strReplace = str.replace("\\u003C", "<").replace("\\n", "").replace("\\\"", "\"");
        return String.format("<html id=\"%s\" data-rect=\"%d,%d,%d,%d\">%s</html>", c2010e.f7163a, Integer.valueOf(c2010e.f7164b), Integer.valueOf(c2010e.f7165c), Integer.valueOf(c2010e.f7166d), Integer.valueOf(c2010e.f7167e), strReplace.substring(1, strReplace.length() - 1));
    }

    /* JADX INFO: renamed from: a */
    public void m4464a(PrintWriter printWriter) {
        HashMap map = (HashMap) this.f7169b;
        HashSet<C2010e> hashSet = (HashSet) this.f7168a;
        try {
            for (C2010e c2010e : hashSet) {
                String str = (String) map.get(c2010e.f7163a);
                if (str != null) {
                    printWriter.print("WebView HTML for ");
                    printWriter.print(c2010e);
                    printWriter.println(":");
                    printWriter.println(m4463b(c2010e, str));
                }
            }
        } catch (Exception unused) {
        }
        hashSet.clear();
        map.clear();
    }

    /* JADX INFO: renamed from: c */
    public void m4465c(int i3) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(this)) {
            return;
        }
        try {
            if (i3 != 0) {
                if (i3 != 2) {
                    return;
                }
                AbstractC2083u.m4626a();
                return;
            }
            try {
                String string = ((InstallReferrerClient) this.f7168a).mo2843a().f3787a.getString("install_referrer");
                if (string != null && (string.contains("fb") || string.contains("facebook"))) {
                    ((C2068f) this.f7169b).getClass();
                    if (!set.contains(C1718m.class)) {
                        try {
                            HashSet hashSet = AbstractC1117n.f3875a;
                            AbstractC2069g.m4584h();
                            AbstractC1117n.f3882h.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("install_referrer", string).apply();
                        } catch (Throwable th) {
                            AbstractC0147a.m295a(th, C1718m.class);
                        }
                    }
                }
                AbstractC2083u.m4626a();
            } catch (RemoteException unused) {
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, this);
        }
    }
}
