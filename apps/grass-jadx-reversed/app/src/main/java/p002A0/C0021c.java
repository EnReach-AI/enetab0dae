package p002A0;

import android.os.Build;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: A0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0021c {

    /* JADX INFO: renamed from: a */
    public String f65a;

    /* JADX INFO: renamed from: b */
    public EnumC0020b f66b;

    /* JADX INFO: renamed from: c */
    public JSONArray f67c;

    /* JADX INFO: renamed from: d */
    public String f68d;

    /* JADX INFO: renamed from: e */
    public String f69e;

    /* JADX INFO: renamed from: f */
    public String f70f;

    /* JADX INFO: renamed from: g */
    public Long f71g;

    /* JADX INFO: renamed from: a */
    public final boolean m75a() {
        int iOrdinal = this.f66b.ordinal();
        Long l3 = this.f71g;
        return iOrdinal != 1 ? ((iOrdinal != 2 && iOrdinal != 3 && iOrdinal != 4) || this.f70f == null || l3 == null) ? false : true : (this.f67c == null || l3 == null) ? false : true;
    }

    public final String toString() {
        JSONObject jSONObject;
        EnumC0020b enumC0020b = this.f66b;
        int iOrdinal = enumC0020b.ordinal();
        Long l3 = this.f71g;
        if (iOrdinal == 1) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = this.f67c;
            if (jSONArray != null) {
                jSONObject2.put("feature_names", jSONArray);
            }
            if (l3 != null) {
                jSONObject2.put("timestamp", l3);
            }
            jSONObject = jSONObject2;
        } else if (iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4) {
            jSONObject = new JSONObject();
            jSONObject.put("device_os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            String str = this.f68d;
            if (str != null) {
                jSONObject.put("app_version", str);
            }
            if (l3 != null) {
                jSONObject.put("timestamp", l3);
            }
            String str2 = this.f69e;
            if (str2 != null) {
                jSONObject.put("reason", str2);
            }
            String str3 = this.f70f;
            if (str3 != null) {
                jSONObject.put("callstack", str3);
            }
            jSONObject.put("type", enumC0020b);
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
