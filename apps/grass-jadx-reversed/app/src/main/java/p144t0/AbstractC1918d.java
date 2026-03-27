package p144t0;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AbstractC1117n;
import com.facebook.C1125v;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005B.AbstractC0032g;
import p010C0.AbstractC0147a;
import p019F0.RunnableC0218b;
import p136r.AbstractC1849h;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2077o;
import p166z0.EnumC2076n;

/* JADX INFO: renamed from: t0.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1918d {

    /* JADX INFO: renamed from: a */
    public static final ConcurrentHashMap f6719a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b */
    public static final Integer f6720b = 259200000;

    /* JADX INFO: renamed from: c */
    public static final List f6721c = Arrays.asList("other", "fb_mobile_complete_registration", "fb_mobile_add_to_cart", "fb_mobile_purchase", "fb_mobile_initiated_checkout");

    /* JADX INFO: renamed from: d */
    public static final List f6722d = Arrays.asList("none", "address", "health");

    /* JADX INFO: renamed from: a */
    public static boolean m4271a(long j2) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1918d.class)) {
            return false;
        }
        try {
            if (set.contains(AbstractC1918d.class) || j2 == 0) {
                return false;
            }
            try {
                return System.currentTimeMillis() - j2 < ((long) f6720b.intValue());
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC1918d.class);
                return false;
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1918d.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4272b(JSONObject jSONObject) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1918d.class)) {
            return;
        }
        try {
            if (set.contains(AbstractC1918d.class)) {
                return;
            }
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    try {
                        C1917c c1917cM4268a = C1917c.m4268a(jSONObject.getJSONObject(itKeys.next()));
                        if (c1917cM4268a != null) {
                            f6719a.put(c1917cM4268a.f6711a, c1917cM4268a);
                        }
                    } catch (JSONException unused) {
                        return;
                    }
                }
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC1918d.class);
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1918d.class);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4273c() {
        if (AbstractC0147a.f354a.contains(AbstractC1918d.class)) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String str = null;
            int iMax = 0;
            for (Map.Entry entry : f6719a.entrySet()) {
                String str2 = (String) entry.getKey();
                if (str2.equals(AbstractC0032g.m149g(2))) {
                    C1917c c1917c = (C1917c) entry.getValue();
                    str = c1917c.f6712b;
                    iMax = Math.max(iMax, c1917c.f6714d);
                    if (AbstractC2077o.m4613b(EnumC2076n.SuggestedEvents) && !AbstractC0147a.f354a.contains(AbstractC1918d.class)) {
                        try {
                            Locale localeM4544m = AbstractC2056E.m4544m();
                            if (localeM4544m == null || localeM4544m.getLanguage().contains("en")) {
                                c1917c.f6718h = new RunnableC0218b(12);
                                arrayList.add(c1917c);
                            }
                        } catch (Throwable th) {
                            AbstractC0147a.m295a(th, AbstractC1918d.class);
                        }
                    }
                }
                if (str2.equals(AbstractC0032g.m149g(1))) {
                    C1917c c1917c2 = (C1917c) entry.getValue();
                    String str3 = c1917c2.f6712b;
                    int iMax2 = Math.max(iMax, c1917c2.f6714d);
                    if (AbstractC2077o.m4613b(EnumC2076n.IntelligentIntegrity)) {
                        c1917c2.f6718h = new RunnableC0218b(13);
                        arrayList.add(c1917c2);
                    }
                    str = str3;
                    iMax = iMax2;
                }
            }
            if (str == null || iMax <= 0 || arrayList.isEmpty()) {
                return;
            }
            C1917c.m4270c(new C1917c("MTML", str, null, iMax, null), arrayList);
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1918d.class);
        }
    }

    /* JADX INFO: renamed from: d */
    public static JSONObject m4274d() {
        if (AbstractC0147a.f354a.contains(AbstractC1918d.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("fields", TextUtils.join(",", new String[]{"use_case", "version_id", "asset_uri", "rules_uri", "thresholds"}));
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C1125v c1125v = new C1125v(null, AbstractC1117n.f3877c + "/model_asset", null, null, null);
            c1125v.f3911i = true;
            c1125v.f3907e = bundle;
            JSONObject jSONObject = c1125v.m2923d().f3920b;
            if (jSONObject == null) {
                return null;
            }
            return m4276f(jSONObject);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1918d.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static File m4275e() {
        if (AbstractC0147a.f354a.contains(AbstractC1918d.class)) {
            return null;
        }
        try {
            C1917c c1917c = (C1917c) f6719a.get(AbstractC0032g.m149g(2));
            if (c1917c == null) {
                return null;
            }
            return c1917c.f6716f;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1918d.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: f */
    public static JSONObject m4276f(JSONObject jSONObject) {
        if (AbstractC0147a.f354a.contains(AbstractC1918d.class)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("version_id", jSONObject3.getString("version_id"));
                    jSONObject4.put("use_case", jSONObject3.getString("use_case"));
                    jSONObject4.put("thresholds", jSONObject3.getJSONArray("thresholds"));
                    jSONObject4.put("asset_uri", jSONObject3.getString("asset_uri"));
                    if (jSONObject3.has("rules_uri")) {
                        jSONObject4.put("rules_uri", jSONObject3.getString("rules_uri"));
                    }
                    jSONObject2.put(jSONObject3.getString("use_case"), jSONObject4);
                }
                return jSONObject2;
            } catch (JSONException unused) {
                return new JSONObject();
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1918d.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    public static String[] m4277g(int i3, float[][] fArr, String[] strArr) {
        if (AbstractC0147a.f354a.contains(AbstractC1918d.class)) {
            return null;
        }
        try {
            C1917c c1917c = (C1917c) f6719a.get(AbstractC0032g.m149g(i3));
            if (c1917c != null && c1917c.f6717g != null) {
                int length = strArr.length;
                int length2 = fArr[0].length;
                C1915a c1915a = new C1915a(new int[]{length, length2});
                for (int i4 = 0; i4 < length; i4++) {
                    System.arraycopy(fArr[i4], 0, c1915a.f6696a, i4 * length2, length2);
                }
                C1915a c1915aM4267d = c1917c.f6717g.m4267d(c1915a, strArr, AbstractC0032g.m148f(i3));
                float[] fArr2 = c1917c.f6715e;
                if (c1915aM4267d != null && fArr2 != null && c1915aM4267d.f6696a.length != 0 && fArr2.length != 0) {
                    int iM4118b = AbstractC1849h.m4118b(i3);
                    if (iM4118b == 0) {
                        return m4278h(c1915aM4267d, fArr2);
                    }
                    if (iM4118b != 1) {
                        return null;
                    }
                    return m4279i(c1915aM4267d, fArr2);
                }
            }
            return null;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1918d.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: h */
    public static String[] m4278h(C1915a c1915a, float[] fArr) {
        if (AbstractC0147a.f354a.contains(AbstractC1918d.class)) {
            return null;
        }
        try {
            int[] iArr = c1915a.f6697b;
            int i3 = iArr[0];
            int i4 = iArr[1];
            float[] fArr2 = c1915a.f6696a;
            String[] strArr = new String[i3];
            if (i4 != fArr.length) {
                return null;
            }
            for (int i5 = 0; i5 < i3; i5++) {
                strArr[i5] = "none";
                for (int i6 = 0; i6 < fArr.length; i6++) {
                    if (fArr2[(i5 * i4) + i6] >= fArr[i6]) {
                        strArr[i5] = (String) f6722d.get(i6);
                    }
                }
            }
            return strArr;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1918d.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: i */
    public static String[] m4279i(C1915a c1915a, float[] fArr) {
        if (AbstractC0147a.f354a.contains(AbstractC1918d.class)) {
            return null;
        }
        try {
            int[] iArr = c1915a.f6697b;
            int i3 = iArr[0];
            int i4 = iArr[1];
            float[] fArr2 = c1915a.f6696a;
            String[] strArr = new String[i3];
            if (i4 != fArr.length) {
                return null;
            }
            for (int i5 = 0; i5 < i3; i5++) {
                strArr[i5] = "other";
                for (int i6 = 0; i6 < fArr.length; i6++) {
                    if (fArr2[(i5 * i4) + i6] >= fArr[i6]) {
                        strArr[i5] = (String) f6721c.get(i6);
                    }
                }
            }
            return strArr;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1918d.class);
            return null;
        }
    }
}
