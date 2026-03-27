package p156w0;

import android.os.Build;
import android.util.Patterns;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;

/* JADX INFO: renamed from: w0.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1986a {

    /* JADX INFO: renamed from: a */
    public static HashMap f7046a = null;

    /* JADX INFO: renamed from: b */
    public static HashMap f7047b = null;

    /* JADX INFO: renamed from: c */
    public static HashMap f7048c = null;

    /* JADX INFO: renamed from: d */
    public static JSONObject f7049d = null;

    /* JADX INFO: renamed from: e */
    public static boolean f7050e = false;

    /* JADX INFO: renamed from: a */
    public static int m4373a(float[] fArr, int[] iArr, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < 6; i4++) {
            int iCeil = (int) Math.ceil(fArr[i4]);
            iArr[i4] = iCeil;
            if (i3 > iCeil) {
                Arrays.fill(bArr, (byte) 0);
                i3 = iCeil;
            }
            if (i3 == iCeil) {
                bArr[i4] = (byte) (bArr[i4] + 1);
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: b */
    public static float[] m4374b(String str, JSONObject jSONObject) {
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return null;
        }
        try {
            if (!f7050e) {
                return null;
            }
            float[] fArr = new float[30];
            Arrays.fill(fArr, 0.0f);
            try {
                String lowerCase = str.toLowerCase();
                JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject("view").toString());
                String strOptString = jSONObject.optString("screenname");
                JSONArray jSONArray = new JSONArray();
                m4387o(jSONObject2, jSONArray);
                m4391s(fArr, m4386n(jSONObject2));
                JSONObject jSONObjectM4375c = m4375c(jSONObject2);
                if (jSONObjectM4375c == null) {
                    return null;
                }
                m4391s(fArr, m4385m(jSONObjectM4375c, jSONArray, strOptString, jSONObject2.toString(), lowerCase));
                return fArr;
            } catch (JSONException unused) {
                return fArr;
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1986a.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static JSONObject m4375c(JSONObject jSONObject) {
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return null;
        }
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return jSONObject;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
            if (jSONArrayOptJSONArray == null) {
                return null;
            }
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                JSONObject jSONObjectM4375c = m4375c(jSONArrayOptJSONArray.getJSONObject(i3));
                if (jSONObjectM4375c != null) {
                    return jSONObjectM4375c;
                }
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1986a.class);
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static String m4376d(String str, String str2, String str3) {
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return null;
        }
        try {
            return (str3 + " | " + str2 + ", " + str).toLowerCase();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1986a.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m4377e(char c3) {
        String hexString = Integer.toHexString(c3);
        throw new IllegalArgumentException("Illegal character: " + c3 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    /* JADX INFO: renamed from: f */
    public static void m4378f(File file) {
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return;
        }
        try {
            try {
                f7049d = new JSONObject();
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                f7049d = new JSONObject(new String(bArr, "UTF-8"));
                HashMap map = new HashMap();
                f7046a = map;
                map.put("ENGLISH", "1");
                f7046a.put("GERMAN", "2");
                f7046a.put("SPANISH", "3");
                f7046a.put("JAPANESE", "4");
                HashMap map2 = new HashMap();
                f7047b = map2;
                map2.put("VIEW_CONTENT", "0");
                f7047b.put("SEARCH", "1");
                f7047b.put("ADD_TO_CART", "2");
                f7047b.put("ADD_TO_WISHLIST", "3");
                f7047b.put("INITIATE_CHECKOUT", "4");
                f7047b.put("ADD_PAYMENT_INFO", "5");
                f7047b.put("PURCHASE", "6");
                f7047b.put("LEAD", "7");
                f7047b.put("COMPLETE_REGISTRATION", "8");
                HashMap map3 = new HashMap();
                f7048c = map3;
                map3.put("BUTTON_TEXT", "1");
                f7048c.put("PAGE_TITLE", "2");
                f7048c.put("RESOLVED_DOCUMENT_LINK", "3");
                f7048c.put("BUTTON_ID", "4");
                f7050e = true;
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1986a.class);
        }
    }

    /* JADX INFO: renamed from: g */
    public static boolean m4379g() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 33) {
            if (i3 >= 32) {
                String str = Build.VERSION.CODENAME;
                if (!"REL".equals(str)) {
                    Locale locale = Locale.ROOT;
                    if (str.toUpperCase(locale).compareTo("Tiramisu".toUpperCase(locale)) >= 0) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m4380h(char c3) {
        return c3 >= '0' && c3 <= '9';
    }

    /* JADX INFO: renamed from: i */
    public static boolean m4381i(char c3) {
        return c3 >= 128 && c3 <= 255;
    }

    /* JADX INFO: renamed from: j */
    public static boolean m4382j(char c3) {
        if (c3 == '\r' || c3 == '*' || c3 == '>' || c3 == ' ') {
            return true;
        }
        if (c3 < '0' || c3 > '9') {
            return c3 >= 'A' && c3 <= 'Z';
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x01e1, code lost:
    
        return 5;
     */
    /* JADX INFO: renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m4383k(java.lang.CharSequence r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p156w0.AbstractC1986a.m4383k(java.lang.CharSequence, int, int):int");
    }

    /* JADX INFO: renamed from: l */
    public static boolean m4384l(String[] strArr, String[] strArr2) {
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return false;
        }
        try {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (str2.contains(str)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1986a.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: m */
    public static float[] m4385m(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            Arrays.fill(fArr, 0.0f);
            fArr[3] = jSONArray.length() > 1 ? r0 - 1 : 0;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (!AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
                        try {
                            if ((jSONObject2.optInt("classtypebitmask") & 32) > 0) {
                                fArr[9] = fArr[9] + 1.0f;
                            }
                        } catch (Throwable th) {
                            AbstractC0147a.m295a(th, AbstractC1986a.class);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            fArr[13] = -1.0f;
            fArr[14] = -1.0f;
            String str4 = str + '|' + str3;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            m4392t(jSONObject, sb2, sb);
            String string = sb.toString();
            String string2 = sb2.toString();
            fArr[15] = m4389q("COMPLETE_REGISTRATION", "BUTTON_TEXT", string2) ? 1.0f : 0.0f;
            fArr[16] = m4389q("COMPLETE_REGISTRATION", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
            fArr[17] = m4389q("COMPLETE_REGISTRATION", "BUTTON_ID", string) ? 1.0f : 0.0f;
            fArr[18] = str2.contains("password") ? 1.0f : 0.0f;
            fArr[19] = m4388p("(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)", str2) ? 1.0f : 0.0f;
            fArr[20] = m4388p("(?i)(sign in)|login|signIn", str2) ? 1.0f : 0.0f;
            fArr[21] = m4388p("(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)", str2) ? 1.0f : 0.0f;
            fArr[22] = m4389q("PURCHASE", "BUTTON_TEXT", string2) ? 1.0f : 0.0f;
            fArr[24] = m4389q("PURCHASE", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
            fArr[25] = m4388p("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart", string2) ? 1.0f : 0.0f;
            fArr[27] = m4388p("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy", str4) ? 1.0f : 0.0f;
            fArr[28] = m4389q("LEAD", "BUTTON_TEXT", string2) ? 1.0f : 0.0f;
            fArr[29] = m4389q("LEAD", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
            return fArr;
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1986a.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: n */
    public static float[] m4386n(JSONObject jSONObject) {
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            Arrays.fill(fArr, 0.0f);
            String lowerCase = jSONObject.optString("text").toLowerCase();
            String lowerCase2 = jSONObject.optString("hint").toLowerCase();
            String lowerCase3 = jSONObject.optString("classname").toLowerCase();
            int iOptInt = jSONObject.optInt("inputtype", -1);
            String[] strArr = {lowerCase, lowerCase2};
            if (m4384l(new String[]{"$", "amount", "price", "total"}, strArr)) {
                fArr[0] = (float) (((double) fArr[0]) + 1.0d);
            }
            if (m4384l(new String[]{"password", "pwd"}, strArr)) {
                fArr[1] = (float) (((double) fArr[1]) + 1.0d);
            }
            if (m4384l(new String[]{"tel", "phone"}, strArr)) {
                fArr[2] = (float) (((double) fArr[2]) + 1.0d);
            }
            if (m4384l(new String[]{"search"}, strArr)) {
                fArr[4] = (float) (((double) fArr[4]) + 1.0d);
            }
            if (iOptInt >= 0) {
                fArr[5] = (float) (((double) fArr[5]) + 1.0d);
            }
            if (iOptInt == 3 || iOptInt == 2) {
                fArr[6] = (float) (((double) fArr[6]) + 1.0d);
            }
            if (iOptInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                fArr[7] = (float) (((double) fArr[7]) + 1.0d);
            }
            if (lowerCase3.contains("checkbox")) {
                fArr[8] = (float) (((double) fArr[8]) + 1.0d);
            }
            if (m4384l(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
                fArr[10] = (float) (((double) fArr[10]) + 1.0d);
            }
            if (lowerCase3.contains("radio") && lowerCase3.contains("button")) {
                fArr[12] = (float) (((double) fArr[12]) + 1.0d);
            }
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
                int length = jSONArrayOptJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    m4391s(fArr, m4386n(jSONArrayOptJSONArray.getJSONObject(i3)));
                }
            } catch (JSONException unused) {
            }
            return fArr;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1986a.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: o */
    public static boolean m4387o(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z3;
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return false;
        }
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return true;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
            int i3 = 0;
            while (true) {
                if (i3 >= jSONArrayOptJSONArray.length()) {
                    z3 = false;
                    break;
                }
                if (jSONArrayOptJSONArray.getJSONObject(i3).optBoolean("is_interacted")) {
                    z3 = true;
                    break;
                }
                i3++;
            }
            boolean z4 = z3;
            JSONArray jSONArray2 = new JSONArray();
            if (z3) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    jSONArray.put(jSONArrayOptJSONArray.getJSONObject(i4));
                }
            } else {
                for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i5);
                    if (m4387o(jSONObject2, jSONArray)) {
                        jSONArray2.put(jSONObject2);
                        z4 = true;
                    }
                }
                jSONObject.put("childviews", jSONArray2);
            }
            return z4;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1986a.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: p */
    public static boolean m4388p(String str, String str2) {
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return false;
        }
        try {
            return Pattern.compile(str).matcher(str2).find();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1986a.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: q */
    public static boolean m4389q(String str, String str2, String str3) {
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return false;
        }
        try {
            return m4388p(f7049d.optJSONObject("rulesForLanguage").optJSONObject((String) f7046a.get("ENGLISH")).optJSONObject("rulesForEvent").optJSONObject((String) f7047b.get(str)).optJSONObject("positiveRules").optString((String) f7048c.get(str2)), str3);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1986a.class);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final p161x2.InterfaceC2012a m4390r(p166z0.C2068f r5, p135q2.InterfaceC1841b r6, boolean r7) {
        /*
            q2.a r0 = p008B2.AbstractC0089b0.m260g(r6)
            boolean r1 = r6.mo247b()
            java.util.List r6 = r6.mo246a()
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = p086c2.AbstractC1087f.m2838v(r6, r3)
            r2.<init>(r3)
            java.util.Iterator r6 = r6.iterator()
            boolean r3 = r6.hasNext()
            r4 = 0
            if (r3 != 0) goto L8f
            boolean r6 = r2.isEmpty()
            java.lang.String r3 = "clazz"
            if (r6 == 0) goto L43
            A.j r6 = p161x2.AbstractC2021j.f7180a
            p119m2.AbstractC1766e.m3920e(r3, r0)
            if (r1 != 0) goto L3c
            A.j r6 = p161x2.AbstractC2021j.f7180a
            x2.a r6 = r6.m25B(r0)
            if (r6 == 0) goto L3a
            goto L5e
        L3a:
            r6 = r4
            goto L5e
        L3c:
            A.j r6 = p161x2.AbstractC2021j.f7181b
            x2.a r6 = r6.m25B(r0)
            goto L5e
        L43:
            A.j r6 = p161x2.AbstractC2021j.f7180a
            p119m2.AbstractC1766e.m3920e(r3, r0)
            if (r1 != 0) goto L51
            A.j r6 = p161x2.AbstractC2021j.f7182c
            java.lang.Object r6 = r6.m26C(r0, r2)
            goto L57
        L51:
            A.j r6 = p161x2.AbstractC2021j.f7183d
            java.lang.Object r6 = r6.m26C(r0, r2)
        L57:
            boolean r3 = r6 instanceof p083b2.C1062g
            if (r3 == 0) goto L5c
            r6 = r4
        L5c:
            x2.a r6 = (p161x2.InterfaceC2012a) r6
        L5e:
            if (r6 == 0) goto L61
            return r6
        L61:
            boolean r6 = r2.isEmpty()
            if (r6 == 0) goto L71
            r5.getClass()
            java.lang.String r5 = "kClass"
            p119m2.AbstractC1766e.m3920e(r5, r0)
        L6f:
            r5 = r4
            goto L85
        L71:
            java.util.ArrayList r5 = p148u0.AbstractC1946e.m4351i(r5, r2, r7)
            if (r5 != 0) goto L78
            return r4
        L78:
            x2.g r6 = new x2.g
            r7 = 2
            r6.<init>(r2, r7)
            x2.a r5 = p148u0.AbstractC1946e.m4348f(r0, r5, r6)
            if (r5 != 0) goto L85
            goto L6f
        L85:
            if (r5 == 0) goto L8e
            if (r1 == 0) goto L8d
            x2.a r5 = p033K0.AbstractC0405c.m888j(r5)
        L8d:
            r4 = r5
        L8e:
            return r4
        L8f:
            java.lang.Object r5 = r6.next()
            p005B.AbstractC0032g.m162t(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p156w0.AbstractC1986a.m4390r(z0.f, q2.b, boolean):x2.a");
    }

    /* JADX INFO: renamed from: s */
    public static void m4391s(float[] fArr, float[] fArr2) {
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            try {
                fArr[i3] = fArr[i3] + fArr2[i3];
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC1986a.class);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: t */
    public static void m4392t(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        if (AbstractC0147a.f354a.contains(AbstractC1986a.class)) {
            return;
        }
        try {
            String lowerCase = jSONObject.optString("text", "").toLowerCase();
            String lowerCase2 = jSONObject.optString("hint", "").toLowerCase();
            if (!lowerCase.isEmpty()) {
                sb.append(lowerCase);
                sb.append(" ");
            }
            if (!lowerCase2.isEmpty()) {
                sb2.append(lowerCase2);
                sb2.append(" ");
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                try {
                    m4392t(jSONArrayOptJSONArray.getJSONObject(i3), sb, sb2);
                } catch (JSONException unused) {
                }
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1986a.class);
        }
    }
}
