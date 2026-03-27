package p129p0;

import org.json.JSONObject;

/* JADX INFO: renamed from: p0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1821c {

    /* JADX INFO: renamed from: a */
    public final String f6310a;

    /* JADX INFO: renamed from: b */
    public final int f6311b;

    /* JADX INFO: renamed from: c */
    public final int f6312c;

    /* JADX INFO: renamed from: d */
    public final String f6313d;

    /* JADX INFO: renamed from: e */
    public final String f6314e;

    /* JADX INFO: renamed from: f */
    public final String f6315f;

    /* JADX INFO: renamed from: g */
    public final String f6316g;

    /* JADX INFO: renamed from: h */
    public final int f6317h;

    public C1821c(JSONObject jSONObject) {
        this.f6310a = jSONObject.getString("class_name");
        this.f6311b = jSONObject.optInt("index", -1);
        this.f6312c = jSONObject.optInt("id");
        this.f6313d = jSONObject.optString("text");
        this.f6314e = jSONObject.optString("tag");
        this.f6315f = jSONObject.optString("description");
        this.f6316g = jSONObject.optString("hint");
        this.f6317h = jSONObject.optInt("match_bitmask");
    }
}
