package app.tauri.plugin;

import org.json.JSONException;
import org.json.JSONObject;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class JSObject extends JSONObject {

    public static final class Companion {
    }

    public JSObject() {
    }

    @Override // org.json.JSONObject
    public final boolean getBoolean(String str) {
        AbstractC1766e.m3920e("key", str);
        Boolean boolValueOf = Boolean.FALSE;
        try {
            boolValueOf = Boolean.valueOf(super.getBoolean(str));
        } catch (JSONException unused) {
        }
        return boolValueOf.booleanValue();
    }

    @Override // org.json.JSONObject
    public final String getString(String str) {
        AbstractC1766e.m3920e("key", str);
        String string = !isNull(str) ? super.getString(str) : "";
        AbstractC1766e.m3917b(string);
        return string;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSObject(String str) {
        super(str);
        AbstractC1766e.m3920e("json", str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSObject(JSONObject jSONObject, String[] strArr) {
        super(jSONObject, strArr);
        AbstractC1766e.m3920e("obj", jSONObject);
        AbstractC1766e.m3920e("names", strArr);
    }

    @Override // org.json.JSONObject
    public JSObject put(String str, boolean z3) {
        AbstractC1766e.m3920e("key", str);
        try {
            super.put(str, z3);
        } catch (JSONException unused) {
        }
        return this;
    }

    @Override // org.json.JSONObject
    public JSObject put(String str, int i3) {
        AbstractC1766e.m3920e("key", str);
        try {
            super.put(str, i3);
        } catch (JSONException unused) {
        }
        return this;
    }

    @Override // org.json.JSONObject
    public JSObject put(String str, long j2) {
        AbstractC1766e.m3920e("key", str);
        try {
            super.put(str, j2);
        } catch (JSONException unused) {
        }
        return this;
    }

    @Override // org.json.JSONObject
    public JSObject put(String str, double d) {
        AbstractC1766e.m3920e("key", str);
        try {
            super.put(str, d);
        } catch (JSONException unused) {
        }
        return this;
    }

    @Override // org.json.JSONObject
    public JSObject put(String str, Object obj) {
        AbstractC1766e.m3920e("key", str);
        try {
            super.put(str, obj);
        } catch (JSONException unused) {
        }
        return this;
    }

    public final JSObject put(String str, String str2) {
        AbstractC1766e.m3920e("key", str);
        try {
            super.put(str, (Object) str2);
        } catch (JSONException unused) {
        }
        return this;
    }
}
