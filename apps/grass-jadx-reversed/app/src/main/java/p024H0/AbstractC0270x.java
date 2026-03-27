package p024H0;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import androidx.fragment.app.AbstractActivityC0947r;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import com.facebook.C1104a;
import com.facebook.C1107d;
import com.facebook.C1111h;
import com.facebook.C1113j;
import com.facebook.C1114k;
import com.facebook.C1119p;
import com.facebook.EnumC1108e;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import p005B.AbstractC0032g;
import p166z0.AbstractC2056E;

/* JADX INFO: renamed from: H0.x */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0270x extends AbstractC0268v {

    /* JADX INFO: renamed from: g */
    public String f689g;

    /* JADX INFO: renamed from: j */
    public final Bundle m527j(C0261o c0261o) {
        Bundle bundle = new Bundle();
        Set set = c0261o.f654f;
        if (set != null && set.size() != 0) {
            String strJoin = TextUtils.join(",", c0261o.f654f);
            bundle.putString("scope", strJoin);
            m524a("scope", strJoin);
        }
        bundle.putString("default_audience", AbstractC0032g.m151i(c0261o.f655g));
        bundle.putString("state", m525d(c0261o.f657i));
        Date date = C1104a.f3820p;
        C1104a c1104a = (C1104a) C1107d.m2887a().f3849d;
        String str = c1104a != null ? c1104a.f3827i : null;
        if (str == null || !str.equals(this.f688f.f671g.m2490h().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", ""))) {
            AbstractActivityC0947r abstractActivityC0947rM2490h = this.f688f.f671g.m2490h();
            AbstractC2056E.m4534c(abstractActivityC0947rM2490h, "facebook.com");
            AbstractC2056E.m4534c(abstractActivityC0947rM2490h, ".facebook.com");
            AbstractC2056E.m4534c(abstractActivityC0947rM2490h, "https://facebook.com");
            AbstractC2056E.m4534c(abstractActivityC0947rM2490h, "https://.facebook.com");
            m524a("access_token", "0");
        } else {
            bundle.putString("access_token", str);
            m524a("access_token", "1");
        }
        bundle.putString("cbt", String.valueOf(System.currentTimeMillis()));
        HashSet hashSet = AbstractC1117n.f3875a;
        bundle.putString("ies", AbstractC1103F.m2866c() ? "1" : "0");
        return bundle;
    }

    /* JADX INFO: renamed from: k */
    public abstract EnumC1108e mo489k();

    /* JADX INFO: renamed from: l */
    public final void m528l(C0261o c0261o, Bundle bundle, C1111h c1111h) {
        String string;
        C0262p c0262pM507a;
        this.f689g = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.f689g = bundle.getString("e2e");
            }
            try {
                C1104a c1104aM523c = AbstractC0268v.m523c(c0261o.f654f, bundle, mo489k(), c0261o.f656h);
                c0262pM507a = new C0262p(this.f688f.f675k, 1, c1104aM523c, null, null);
                CookieSyncManager.createInstance(this.f688f.f671g.m2490h()).sync();
                this.f688f.f671g.m2490h().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", c1104aM523c.f3827i).apply();
            } catch (C1111h e3) {
                c0262pM507a = C0262p.m507a(this.f688f.f675k, null, e3.getMessage(), null);
            }
        } else if (c1111h instanceof C1113j) {
            c0262pM507a = new C0262p(this.f688f.f675k, 2, null, "User canceled log in.", null);
        } else {
            this.f689g = null;
            String message = c1111h.getMessage();
            if (c1111h instanceof C1119p) {
                Locale locale = Locale.ROOT;
                C1114k c1114k = ((C1119p) c1111h).f3891e;
                int i3 = c1114k.f3865f;
                StringBuilder sb = new StringBuilder();
                sb.append(i3);
                string = sb.toString();
                message = c1114k.toString();
            } else {
                string = null;
            }
            c0262pM507a = C0262p.m507a(this.f688f.f675k, null, message, string);
        }
        if (!AbstractC2056E.m4550s(this.f689g)) {
            m526f(this.f689g);
        }
        this.f688f.m512d(c0262pM507a);
    }
}
