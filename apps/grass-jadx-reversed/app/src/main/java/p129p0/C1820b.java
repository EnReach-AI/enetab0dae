package p129p0;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: p0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1820b {

    /* JADX INFO: renamed from: a */
    public final String f6306a;

    /* JADX INFO: renamed from: b */
    public final String f6307b;

    /* JADX INFO: renamed from: c */
    public final ArrayList f6308c;

    /* JADX INFO: renamed from: d */
    public final String f6309d;

    public C1820b(JSONObject jSONObject) {
        this.f6306a = jSONObject.getString("name");
        this.f6307b = jSONObject.optString("value");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("path");
        if (jSONArrayOptJSONArray != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                arrayList.add(new C1821c(jSONArrayOptJSONArray.getJSONObject(i3)));
            }
        }
        this.f6308c = arrayList;
        this.f6309d = jSONObject.optString("path_type", "absolute");
    }
}
