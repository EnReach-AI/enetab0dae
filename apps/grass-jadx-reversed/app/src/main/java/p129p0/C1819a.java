package p129p0;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: p0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1819a {

    /* JADX INFO: renamed from: a */
    public final String f6302a;

    /* JADX INFO: renamed from: b */
    public final List f6303b;

    /* JADX INFO: renamed from: c */
    public final List f6304c;

    /* JADX INFO: renamed from: d */
    public final String f6305d;

    public C1819a(String str, ArrayList arrayList, ArrayList arrayList2, String str2) {
        this.f6302a = str;
        this.f6303b = arrayList;
        this.f6304c = arrayList2;
        this.f6305d = str2;
    }

    /* JADX INFO: renamed from: a */
    public static C1819a m4046a(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("event_name");
        String string2 = jSONObject.getString("method");
        Locale locale = Locale.ENGLISH;
        String upperCase = string2.toUpperCase(locale);
        if (upperCase == null) {
            throw new NullPointerException("Name is null");
        }
        if (!upperCase.equals("MANUAL") && !upperCase.equals("INFERENCE")) {
            throw new IllegalArgumentException("No enum constant com.facebook.appevents.codeless.internal.EventBinding.MappingMethod.".concat(upperCase));
        }
        String upperCase2 = jSONObject.getString("event_type").toUpperCase(locale);
        if (upperCase2 == null) {
            throw new NullPointerException("Name is null");
        }
        if (!upperCase2.equals("CLICK") && !upperCase2.equals("SELECTED") && !upperCase2.equals("TEXT_CHANGED")) {
            throw new IllegalArgumentException("No enum constant com.facebook.appevents.codeless.internal.EventBinding.ActionType.".concat(upperCase2));
        }
        jSONObject.getString("app_version");
        JSONArray jSONArray = jSONObject.getJSONArray("path");
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(new C1821c(jSONArray.getJSONObject(i3)));
        }
        jSONObject.optString("path_type", "absolute");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("parameters");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                arrayList2.add(new C1820b(jSONArrayOptJSONArray.getJSONObject(i4)));
            }
        }
        jSONObject.optString("component_id");
        return new C1819a(string, arrayList, arrayList2, jSONObject.optString("activity_name"));
    }
}
