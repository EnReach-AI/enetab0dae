package p117m0;

import android.os.Bundle;
import com.facebook.AbstractC1117n;
import com.facebook.C1111h;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import p005B.AbstractC0032g;
import p010C0.AbstractC0147a;
import p133q0.AbstractC1838b;
import p133q0.C1837a;
import p137r0.AbstractC1852a;
import p141s0.AbstractC1875e;
import p152v0.AbstractC1973b;
import p166z0.C2085w;

/* JADX INFO: renamed from: m0.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1711f implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final HashSet f5983j = new HashSet();
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final JSONObject f5984e;

    /* JADX INFO: renamed from: f */
    public final boolean f5985f;

    /* JADX INFO: renamed from: g */
    public final boolean f5986g;

    /* JADX INFO: renamed from: h */
    public final String f5987h;

    /* JADX INFO: renamed from: i */
    public final String f5988i;

    public C1711f(String str, String str2, Double d, Bundle bundle, boolean z3, boolean z4, UUID uuid) throws JSONException {
        this.f5985f = z3;
        this.f5986g = z4;
        this.f5987h = str2;
        m3791b(str2);
        JSONObject jSONObject = new JSONObject();
        boolean z5 = AbstractC1973b.f6991a;
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1973b.class)) {
            str2 = null;
        } else {
            try {
                if (AbstractC1973b.f6991a) {
                    boolean zContains = false;
                    if (!set.contains(AbstractC1973b.class)) {
                        try {
                            zContains = AbstractC1973b.f6993c.contains(str2);
                        } catch (Throwable th) {
                            AbstractC0147a.m295a(th, AbstractC1973b.class);
                        }
                    }
                    if (zContains) {
                        str2 = "_removed_";
                    }
                }
            } catch (Throwable th2) {
                AbstractC0147a.m295a(th2, AbstractC1973b.class);
                str2 = null;
            }
        }
        jSONObject.put("_eventName", str2);
        jSONObject.put("_eventName_md5", m3790a(str2));
        jSONObject.put("_logTime", System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (bundle != null) {
            HashMap map = new HashMap();
            for (String str3 : bundle.keySet()) {
                m3791b(str3);
                Object obj = bundle.get(str3);
                if (!(obj instanceof String) && !(obj instanceof Number)) {
                    throw new C1111h(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", obj, str3));
                }
                map.put(str3, obj.toString());
            }
            if (!AbstractC0147a.f354a.contains(AbstractC1852a.class)) {
                try {
                    if (AbstractC1852a.f6422a && map.size() != 0) {
                        try {
                            ArrayList<String> arrayList = new ArrayList(map.keySet());
                            JSONObject jSONObject2 = new JSONObject();
                            for (String str4 : arrayList) {
                                String str5 = (String) map.get(str4);
                                if (AbstractC1852a.m4130e(str4) || AbstractC1852a.m4130e(str5)) {
                                    map.remove(str4);
                                    if (!AbstractC1852a.f6423b) {
                                        str5 = "";
                                    }
                                    jSONObject2.put(str4, str5);
                                }
                            }
                            if (jSONObject2.length() != 0) {
                                map.put("_onDeviceParams", jSONObject2.toString());
                            }
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th3) {
                    AbstractC0147a.m295a(th3, AbstractC1852a.class);
                }
            }
            boolean z6 = AbstractC1973b.f6991a;
            boolean zContains2 = AbstractC0147a.f354a.contains(AbstractC1973b.class);
            String str6 = this.f5987h;
            if (!zContains2) {
                try {
                    if (AbstractC1973b.f6991a) {
                        HashMap map2 = new HashMap();
                        for (String str7 : new ArrayList(map.keySet())) {
                            String strM4366a = AbstractC1973b.m4366a(str6, str7);
                            if (strM4366a != null) {
                                map2.put(str7, strM4366a);
                                map.remove(str7);
                            }
                        }
                        if (map2.size() > 0) {
                            try {
                                JSONObject jSONObject3 = new JSONObject();
                                for (Map.Entry entry : map2.entrySet()) {
                                    jSONObject3.put((String) entry.getKey(), entry.getValue());
                                }
                                map.put("_restrictedParams", jSONObject3.toString());
                            } catch (JSONException unused2) {
                            }
                        }
                    }
                } catch (Throwable th4) {
                    AbstractC0147a.m295a(th4, AbstractC1973b.class);
                }
            }
            boolean z7 = AbstractC1838b.f6356a;
            if (!AbstractC0147a.f354a.contains(AbstractC1838b.class)) {
                try {
                    if (AbstractC1838b.f6356a) {
                        ArrayList<String> arrayList2 = new ArrayList(map.keySet());
                        for (C1837a c1837a : new ArrayList(AbstractC1838b.f6357b)) {
                            if (c1837a.f6354a.equals(str6)) {
                                for (String str8 : arrayList2) {
                                    if (c1837a.f6355b.contains(str8)) {
                                        map.remove(str8);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    AbstractC0147a.m295a(th5, AbstractC1838b.class);
                }
            }
            for (String str9 : map.keySet()) {
                jSONObject.put(str9, map.get(str9));
            }
        }
        if (d != null) {
            jSONObject.put("_valueToSum", d.doubleValue());
        }
        if (this.f5986g) {
            jSONObject.put("_inBackground", "1");
        }
        if (this.f5985f) {
            jSONObject.put("_implicitlyLogged", "1");
        } else {
            jSONObject.toString();
            HashMap map3 = C2085w.f7377b;
            AbstractC1117n.m2896f();
        }
        this.f5984e = jSONObject;
        this.f5988i = m3790a(jSONObject.toString());
    }

    /* JADX INFO: renamed from: a */
    public static String m3790a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            return AbstractC1875e.m4195a(messageDigest.digest());
        } catch (UnsupportedEncodingException unused) {
            HashSet hashSet = AbstractC1117n.f3875a;
            return "1";
        } catch (NoSuchAlgorithmException unused2) {
            HashSet hashSet2 = AbstractC1117n.f3875a;
            return "0";
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m3791b(String str) {
        boolean zContains;
        if (str == null || str.length() == 0 || str.length() > 40) {
            if (str == null) {
                str = "<None Provided>";
            }
            Locale locale = Locale.ROOT;
            throw new C1111h(AbstractC0032g.m154l("Identifier '", str, "' must be less than 40 characters"));
        }
        HashSet hashSet = f5983j;
        synchronized (hashSet) {
            zContains = hashSet.contains(str);
        }
        if (zContains) {
            return;
        }
        if (!str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
            throw new C1111h(AbstractC0032g.m154l("Skipping event named '", str, "' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen."));
        }
        synchronized (hashSet) {
            hashSet.add(str);
        }
    }

    private Object writeReplace() {
        return new C1710e(this.f5984e.toString(), this.f5985f, this.f5986g, this.f5988i);
    }

    public final String toString() {
        JSONObject jSONObject = this.f5984e;
        return "\"" + jSONObject.optString("_eventName") + "\", implicit: " + this.f5985f + ", json: " + jSONObject.toString();
    }

    public C1711f(String str, boolean z3, boolean z4, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        this.f5984e = jSONObject;
        this.f5985f = z3;
        this.f5987h = jSONObject.optString("_eventName");
        this.f5988i = str2;
        this.f5986g = z4;
    }
}
