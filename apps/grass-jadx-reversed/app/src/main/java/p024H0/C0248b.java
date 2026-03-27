package p024H0;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AbstractC1117n;
import com.facebook.CustomTabMainActivity;
import com.facebook.EnumC1108e;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import p005B.AbstractC0032g;
import p166z0.AbstractC2069g;
import p166z0.C2068f;

/* JADX INFO: renamed from: H0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0248b extends AbstractC0270x {
    public static final Parcelable.Creator<C0248b> CREATOR = new C0247a(0);

    /* JADX INFO: renamed from: k */
    public static boolean f605k = false;

    /* JADX INFO: renamed from: h */
    public String f606h;

    /* JADX INFO: renamed from: i */
    public String f607i;

    /* JADX INFO: renamed from: j */
    public String f608j;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: e */
    public final String mo485e() {
        return "custom_tab";
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d3  */
    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo486g(int r7, int r8, android.content.Intent r9) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p024H0.C0248b.mo486g(int, int, android.content.Intent):boolean");
    }

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: h */
    public final void mo487h(JSONObject jSONObject) throws JSONException {
        jSONObject.put("7_challenge", this.f607i);
    }

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: i */
    public final int mo488i(C0261o c0261o) {
        if (this.f608j.isEmpty()) {
            return 0;
        }
        Bundle bundleM527j = m527j(c0261o);
        bundleM527j.putString("redirect_uri", this.f608j);
        bundleM527j.putString("client_id", c0261o.f656h);
        bundleM527j.putString("e2e", C0263q.m508f());
        bundleM527j.putString("response_type", "token,signed_request,graph_domain");
        bundleM527j.putString("return_scopes", "true");
        bundleM527j.putString("auth_type", c0261o.f660l);
        bundleM527j.putString("login_behavior", AbstractC0032g.m163u(c0261o.f653e));
        Locale locale = Locale.ROOT;
        HashSet hashSet = AbstractC1117n.f3875a;
        bundleM527j.putString("sdk", "android-8.2.0");
        bundleM527j.putString("sso", "chrome_custom_tab");
        bundleM527j.putString("cct_prefetching", AbstractC1117n.f3886l ? "1" : "0");
        if (f605k) {
            bundleM527j.putString("cct_over_app_switch", "1");
        }
        if (AbstractC1117n.f3886l) {
            C2068f.m4574f(bundleM527j, "oauth");
        }
        Intent intent = new Intent(this.f688f.f671g.m2490h(), (Class<?>) CustomTabMainActivity.class);
        int i3 = CustomTabMainActivity.f3803g;
        intent.putExtra("CustomTabMainActivity.extra_action", "oauth");
        intent.putExtra("CustomTabMainActivity.extra_params", bundleM527j);
        String strM4577a = this.f606h;
        if (strM4577a == null) {
            strM4577a = AbstractC2069g.m4577a();
            this.f606h = strM4577a;
        }
        intent.putExtra("CustomTabMainActivity.extra_chromePackage", strM4577a);
        this.f688f.f671g.m2487O(1, intent);
        return 1;
    }

    @Override // p024H0.AbstractC0270x
    /* JADX INFO: renamed from: k */
    public final EnumC1108e mo489k() {
        return EnumC1108e.CHROME_CUSTOM_TAB;
    }

    @Override // p024H0.AbstractC0268v, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f607i);
    }
}
