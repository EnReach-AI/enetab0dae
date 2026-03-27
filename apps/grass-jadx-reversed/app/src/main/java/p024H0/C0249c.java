package p024H0;

import com.facebook.C1111h;
import com.facebook.C1114k;
import com.facebook.C1128y;
import com.facebook.InterfaceC1121r;
import java.util.Locale;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONException;
import org.json.JSONObject;
import p163y0.AbstractC2043b;

/* JADX INFO: renamed from: H0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0249c implements InterfaceC1121r {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f609a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C0255i f610b;

    public /* synthetic */ C0249c(C0255i c0255i, int i3) {
        this.f609a = i3;
        this.f610b = c0255i;
    }

    @Override // com.facebook.InterfaceC1121r
    /* JADX INFO: renamed from: a */
    public final void mo74a(C1128y c1128y) {
        switch (this.f609a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0255i c0255i = this.f610b;
                if (!c0255i.f639v0) {
                    C1114k c1114k = c1128y.f3921c;
                    if (c1114k != null) {
                        c0255i.m495W(c1114k.f3872m);
                    } else {
                        JSONObject jSONObject = c1128y.f3920b;
                        C0254h c0254h = new C0254h();
                        try {
                            String string = jSONObject.getString("user_code");
                            c0254h.f626f = string;
                            c0254h.f625e = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", string);
                            c0254h.f627g = jSONObject.getString("code");
                            c0254h.f628h = jSONObject.getLong("interval");
                            c0255i.m498Z(c0254h);
                        } catch (JSONException e3) {
                            c0255i.m495W(new C1111h(e3));
                            return;
                        }
                    }
                    break;
                }
                break;
            default:
                if (!this.f610b.f634q0.get()) {
                    C1114k c1114k2 = c1128y.f3921c;
                    if (c1114k2 == null) {
                        try {
                            JSONObject jSONObject2 = c1128y.f3920b;
                            C0255i.m490S(this.f610b, jSONObject2.getString("access_token"), Long.valueOf(jSONObject2.getLong("expires_in")), Long.valueOf(jSONObject2.optLong("data_access_expiration_time")));
                        } catch (JSONException e4) {
                            this.f610b.m495W(new C1111h(e4));
                        }
                        break;
                    } else {
                        int i3 = c1114k2.f3866g;
                        if (i3 != 1349152) {
                            switch (i3) {
                                case 1349172:
                                case 1349174:
                                    this.f610b.m497Y();
                                    break;
                                case 1349173:
                                    this.f610b.m494V();
                                    break;
                                default:
                                    this.f610b.m495W(c1114k2.f3872m);
                                    break;
                            }
                        } else {
                            if (this.f610b.f637t0 != null) {
                                AbstractC2043b.m4507a(this.f610b.f637t0.f626f);
                            }
                            C0255i c0255i2 = this.f610b;
                            C0261o c0261o = c0255i2.f641x0;
                            if (c0261o == null) {
                                c0255i2.m494V();
                            } else {
                                c0255i2.m499a0(c0261o);
                            }
                            break;
                        }
                    }
                }
                break;
        }
    }
}
