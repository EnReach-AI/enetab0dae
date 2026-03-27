package p013D0;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: D0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0175a {

    /* JADX INFO: renamed from: a */
    public String f409a;

    /* JADX INFO: renamed from: b */
    public String f410b;

    /* JADX INFO: renamed from: c */
    public Long f411c;

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l3 = this.f411c;
            if (l3 != null) {
                jSONObject.put("timestamp", l3);
            }
            jSONObject.put("error_message", this.f410b);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
