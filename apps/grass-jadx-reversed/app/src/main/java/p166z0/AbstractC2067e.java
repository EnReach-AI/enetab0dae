package p166z0;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: z0.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2067e {

    /* JADX INFO: renamed from: a */
    public static final HashMap f7305a;

    static {
        HashMap map = new HashMap();
        f7305a = map;
        map.put(Boolean.class, new C2066d(0));
        map.put(Integer.class, new C2066d(1));
        map.put(Long.class, new C2066d(2));
        map.put(Double.class, new C2066d(3));
        map.put(String.class, new C2066d(4));
        map.put(String[].class, new C2066d(5));
        map.put(JSONArray.class, new C2066d(6));
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m4573a(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj != null && obj != JSONObject.NULL) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, m4573a((JSONObject) obj));
                } else {
                    C2066d c2066d = (C2066d) f7305a.get(obj.getClass());
                    if (c2066d == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    c2066d.m4572a(bundle, next, obj);
                }
            }
        }
        return bundle;
    }
}
