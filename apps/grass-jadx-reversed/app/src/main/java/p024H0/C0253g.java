package p024H0;

import android.app.AlertDialog;
import android.util.Log;
import com.facebook.AbstractC1117n;
import com.facebook.C1111h;
import com.facebook.C1114k;
import com.facebook.C1128y;
import com.facebook.InterfaceC1121r;
import io.getgrass.www.R;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p163y0.AbstractC2043b;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;
import p166z0.C2071i;
import p166z0.EnumC2053B;

/* JADX INFO: renamed from: H0.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0253g implements InterfaceC1121r {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f620a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Serializable f621b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f622c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f623d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f624e;

    public C0253g(AtomicBoolean atomicBoolean, HashSet hashSet, HashSet hashSet2, HashSet hashSet3) {
        this.f621b = atomicBoolean;
        this.f622c = hashSet;
        this.f623d = hashSet2;
        this.f624e = hashSet3;
    }

    @Override // com.facebook.InterfaceC1121r
    /* JADX INFO: renamed from: a */
    public final void mo74a(C1128y c1128y) {
        JSONArray jSONArrayOptJSONArray;
        switch (this.f620a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (!((C0255i) this.f624e).f634q0.get()) {
                    C1114k c1114k = c1128y.f3921c;
                    if (c1114k != null) {
                        ((C0255i) this.f624e).m495W(c1114k.f3872m);
                    } else {
                        try {
                            JSONObject jSONObject = c1128y.f3920b;
                            String string = jSONObject.getString("id");
                            C2071i c2071iM4546o = AbstractC2056E.m4546o(jSONObject);
                            String string2 = jSONObject.getString("name");
                            AbstractC2043b.m4507a(((C0255i) this.f624e).f637t0.f626f);
                            HashSet hashSet = AbstractC1117n.f3875a;
                            AbstractC2069g.m4584h();
                            if (AbstractC2082t.m4621b(AbstractC1117n.f3877c).f7352c.contains(EnumC2053B.RequireConfirm)) {
                                C0255i c0255i = (C0255i) this.f624e;
                                if (!c0255i.f640w0) {
                                    c0255i.f640w0 = true;
                                    String str = (String) this.f621b;
                                    Date date = (Date) this.f622c;
                                    Date date2 = (Date) this.f623d;
                                    String string3 = c0255i.m2495m().getString(R.string.com_facebook_smart_login_confirmation_title);
                                    String string4 = c0255i.m2495m().getString(R.string.com_facebook_smart_login_confirmation_continue_as);
                                    String string5 = c0255i.m2495m().getString(R.string.com_facebook_smart_login_confirmation_cancel);
                                    String str2 = String.format(string4, string2);
                                    AlertDialog.Builder builder = new AlertDialog.Builder(c0255i.m2492j());
                                    builder.setMessage(string3).setCancelable(true).setNegativeButton(str2, new DialogInterfaceOnClickListenerC0252f(c0255i, string, c2071iM4546o, str, date, date2)).setPositiveButton(string5, new DialogInterfaceOnClickListenerC0251e(c0255i));
                                    builder.create().show();
                                }
                            }
                            C0255i.m491T((C0255i) this.f624e, string, c2071iM4546o, (String) this.f621b, (Date) this.f622c, (Date) this.f623d);
                        } catch (JSONException e3) {
                            ((C0255i) this.f624e).m495W(new C1111h(e3));
                            return;
                        }
                    }
                    break;
                }
                break;
            default:
                JSONObject jSONObject2 = c1128y.f3920b;
                if (jSONObject2 != null && (jSONArrayOptJSONArray = jSONObject2.optJSONArray("data")) != null) {
                    ((AtomicBoolean) this.f621b).set(true);
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("permission");
                            String strOptString2 = jSONObjectOptJSONObject.optString("status");
                            if (!AbstractC2056E.m4550s(strOptString) && !AbstractC2056E.m4550s(strOptString2)) {
                                String lowerCase = strOptString2.toLowerCase(Locale.US);
                                if (lowerCase.equals("granted")) {
                                    ((Set) this.f622c).add(strOptString);
                                } else if (lowerCase.equals("declined")) {
                                    ((Set) this.f623d).add(strOptString);
                                } else if (lowerCase.equals("expired")) {
                                    ((Set) this.f624e).add(strOptString);
                                } else {
                                    Log.w("AccessTokenManager", "Unexpected status: ".concat(lowerCase));
                                }
                            }
                        }
                    }
                }
                break;
        }
    }

    public C0253g(C0255i c0255i, String str, Date date, Date date2) {
        this.f624e = c0255i;
        this.f621b = str;
        this.f622c = date;
        this.f623d = date2;
    }
}
