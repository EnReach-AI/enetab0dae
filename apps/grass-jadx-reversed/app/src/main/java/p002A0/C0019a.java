package p002A0;

import com.facebook.C1106c;
import com.facebook.C1114k;
import com.facebook.C1128y;
import com.facebook.InterfaceC1121r;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONException;
import org.json.JSONObject;
import p033K0.AbstractC0406d;
import p033K0.C0403a;
import p033K0.C0404b;

/* JADX INFO: renamed from: A0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0019a implements InterfaceC1121r {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f57a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f58b;

    public /* synthetic */ C0019a(int i3, Object obj) {
        this.f57a = i3;
        this.f58b = obj;
    }

    @Override // com.facebook.InterfaceC1121r
    /* JADX INFO: renamed from: a */
    public final void mo74a(C1128y c1128y) {
        switch (this.f57a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                try {
                    if (c1128y.f3921c == null && c1128y.f3920b.getBoolean("success")) {
                        AbstractC0406d.m895b(((C0021c) this.f58b).f65a);
                        break;
                    }
                } catch (JSONException unused) {
                    return;
                }
                break;
            case 1:
                C1114k c1114k = c1128y.f3921c;
                C0404b c0404b = (C0404b) this.f58b;
                if (c1114k != null) {
                    c0404b.m880T(c1114k);
                } else {
                    JSONObject jSONObject = c1128y.f3920b;
                    C0403a c0403a = new C0403a();
                    try {
                        c0403a.f924e = jSONObject.getString("user_code");
                        c0403a.f925f = jSONObject.getLong("expires_in");
                        c0404b.m881U(c0403a);
                    } catch (JSONException unused2) {
                        c0404b.m880T(new C1114k(0, "", "Malformed server response"));
                        return;
                    }
                }
                break;
            default:
                JSONObject jSONObject2 = c1128y.f3920b;
                if (jSONObject2 != null) {
                    String strOptString = jSONObject2.optString("access_token");
                    C1106c c1106c = (C1106c) this.f58b;
                    c1106c.f3842b = strOptString;
                    c1106c.f3841a = jSONObject2.optInt("expires_at");
                    c1106c.f3844d = Long.valueOf(jSONObject2.optLong("data_access_expiration_time"));
                    c1106c.f3843c = jSONObject2.optString("graph_domain", null);
                    break;
                }
                break;
        }
    }
}
