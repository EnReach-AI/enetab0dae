package p024H0;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import com.facebook.C1104a;
import com.facebook.C1111h;
import com.facebook.EnumC1108e;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
import p117m0.C1718m;
import p166z0.AbstractC2056E;

/* JADX INFO: renamed from: H0.v */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0268v implements Parcelable {

    /* JADX INFO: renamed from: e */
    public HashMap f687e;

    /* JADX INFO: renamed from: f */
    public C0263q f688f;

    public AbstractC0268v(C0263q c0263q) {
        this.f688f = c0263q;
    }

    /* JADX INFO: renamed from: c */
    public static C1104a m523c(Collection collection, Bundle bundle, EnumC1108e enumC1108e, String str) {
        Date dateM4542k = AbstractC2056E.m4542k(bundle, "expires_in", new Date());
        String string = bundle.getString("access_token");
        Date dateM4542k2 = AbstractC2056E.m4542k(bundle, "data_access_expiration_time", new Date(0L));
        String string2 = bundle.getString("granted_scopes");
        Collection arrayList = !AbstractC2056E.m4550s(string2) ? new ArrayList(Arrays.asList(string2.split(","))) : collection;
        String string3 = bundle.getString("denied_scopes");
        ArrayList arrayList2 = !AbstractC2056E.m4550s(string3) ? new ArrayList(Arrays.asList(string3.split(","))) : null;
        String string4 = bundle.getString("expired_scopes");
        ArrayList arrayList3 = !AbstractC2056E.m4550s(string4) ? new ArrayList(Arrays.asList(string4.split(","))) : null;
        if (AbstractC2056E.m4550s(string)) {
            return null;
        }
        String string5 = bundle.getString("graph_domain");
        String string6 = bundle.getString("signed_request");
        if (string6 == null || string6.isEmpty()) {
            throw new C1111h("Authorization response does not contain the signed_request");
        }
        try {
            String[] strArrSplit = string6.split("\\.");
            if (strArrSplit.length == 2) {
                return new C1104a(string, str, new JSONObject(new String(Base64.decode(strArrSplit[1], 0), "UTF-8")).getString("user_id"), arrayList, arrayList2, arrayList3, enumC1108e, dateM4542k, new Date(), dateM4542k2, string5);
            }
        } catch (UnsupportedEncodingException | JSONException unused) {
        }
        throw new C1111h("Failed to retrieve user_id from signed_request");
    }

    /* JADX INFO: renamed from: a */
    public final void m524a(String str, String str2) {
        if (this.f687e == null) {
            this.f687e = new HashMap();
        }
        this.f687e.put(str, str2 == null ? null : str2.toString());
    }

    /* JADX INFO: renamed from: b */
    public void mo504b() {
    }

    /* JADX INFO: renamed from: d */
    public final String m525d(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", mo485e());
            mo487h(jSONObject);
        } catch (JSONException e3) {
            Log.w("LoginMethodHandler", "Error creating client state json: " + e3.getMessage());
        }
        return jSONObject.toString();
    }

    /* JADX INFO: renamed from: e */
    public abstract String mo485e();

    /* JADX INFO: renamed from: f */
    public final void m526f(String str) {
        C0263q c0263q = this.f688f;
        String str2 = c0263q.f675k.f656h;
        C1718m c1718m = new C1718m(c0263q.f671g.m2490h(), str2);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString("app_id", str2);
        HashSet hashSet = AbstractC1117n.f3875a;
        if (AbstractC1103F.m2866c()) {
            c1718m.m3817g(bundle, "fb_dialogs_web_login_dialog_complete");
        }
    }

    /* JADX INFO: renamed from: g */
    public boolean mo486g(int i3, int i4, Intent intent) {
        return false;
    }

    /* JADX INFO: renamed from: h */
    public void mo487h(JSONObject jSONObject) {
    }

    /* JADX INFO: renamed from: i */
    public abstract int mo488i(C0261o c0261o);

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        AbstractC2056E.m4531C(parcel, this.f687e);
    }

    public AbstractC0268v(Parcel parcel) {
        this.f687e = AbstractC2056E.m4557z(parcel);
    }
}
