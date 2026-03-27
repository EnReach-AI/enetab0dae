package com.facebook;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005B.AbstractC0032g;
import p007B1.RunnableC0055o;
import p021G.RunnableC0224a;
import p036L0.C0444d;
import p166z0.AbstractC2052A;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.C2085w;

/* JADX INFO: renamed from: com.facebook.v */
/* JADX INFO: loaded from: classes.dex */
public final class C1125v {

    /* JADX INFO: renamed from: j */
    public static final String f3900j;

    /* JADX INFO: renamed from: k */
    public static final Pattern f3901k = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");

    /* JADX INFO: renamed from: l */
    public static volatile String f3902l;

    /* JADX INFO: renamed from: a */
    public final C1104a f3903a;

    /* JADX INFO: renamed from: b */
    public final EnumC1129z f3904b;

    /* JADX INFO: renamed from: c */
    public final String f3905c;

    /* JADX INFO: renamed from: d */
    public JSONObject f3906d;

    /* JADX INFO: renamed from: e */
    public Bundle f3907e;

    /* JADX INFO: renamed from: f */
    public InterfaceC1121r f3908f;

    /* JADX INFO: renamed from: g */
    public Object f3909g;

    /* JADX INFO: renamed from: h */
    public final String f3910h;

    /* JADX INFO: renamed from: i */
    public boolean f3911i = false;

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int iNextInt = secureRandom.nextInt(11) + 30;
        for (int i3 = 0; i3 < iNextInt; i3++) {
            sb.append(charArray[secureRandom.nextInt(charArray.length)]);
        }
        f3900j = sb.toString();
    }

    public C1125v(C1104a c1104a, String str, Bundle bundle, EnumC1129z enumC1129z, InterfaceC1121r interfaceC1121r) {
        this.f3903a = c1104a;
        this.f3905c = str;
        this.f3910h = null;
        m2927s(interfaceC1121r);
        this.f3904b = enumC1129z == null ? EnumC1129z.f3922e : enumC1129z;
        if (bundle != null) {
            this.f3907e = new Bundle(bundle);
        } else {
            this.f3907e = new Bundle();
        }
        this.f3910h = AbstractC1117n.m2892b();
    }

    /* JADX INFO: renamed from: c */
    public static HttpURLConnection m2908c(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (f3902l == null) {
            f3902l = "FBAndroidSDK.8.2.0";
        }
        httpURLConnection.setRequestProperty("User-Agent", f3902l);
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    /* JADX INFO: renamed from: f */
    public static ArrayList m2909f(C1127x c1127x) throws Throwable {
        HttpURLConnection httpURLConnectionM2920t;
        ArrayList arrayListM2928a;
        AbstractC2069g.m4581e(c1127x);
        HttpURLConnection httpURLConnection = null;
        errorStream = null;
        InputStream errorStream = null;
        try {
            try {
                try {
                    try {
                        httpURLConnectionM2920t = m2920t(c1127x);
                        try {
                        } catch (C1111h e3) {
                            HashMap map = C2085w.f7377b;
                            AbstractC1117n.m2896f();
                            arrayListM2928a = C1128y.m2928a(c1127x, httpURLConnectionM2920t, e3);
                        } catch (Exception e4) {
                            HashMap map2 = C2085w.f7377b;
                            AbstractC1117n.m2896f();
                            arrayListM2928a = C1128y.m2928a(c1127x, httpURLConnectionM2920t, new C1111h(e4));
                        }
                        if (!AbstractC1117n.m2894d()) {
                            Log.e("y", "GraphRequest can't be used when Facebook SDK isn't fully initialized");
                            throw new C1111h("GraphRequest can't be used when Facebook SDK isn't fully initialized");
                        }
                        errorStream = httpURLConnectionM2920t.getResponseCode() >= 400 ? httpURLConnectionM2920t.getErrorStream() : httpURLConnectionM2920t.getInputStream();
                        arrayListM2928a = C1128y.m2930c(errorStream, httpURLConnectionM2920t, c1127x);
                        AbstractC2056E.m4535d(errorStream);
                        AbstractC2056E.m4539h(httpURLConnectionM2920t);
                        int size = c1127x.f3916f.size();
                        if (size != arrayListM2928a.size()) {
                            Locale locale = Locale.US;
                            throw new C1111h("Received " + arrayListM2928a.size() + " responses while expecting " + size);
                        }
                        m2917p(c1127x, arrayListM2928a);
                        C1107d c1107dM2887a = C1107d.m2887a();
                        if (((C1104a) c1107dM2887a.f3849d) != null) {
                            long time = new Date().getTime();
                            if (((C1104a) c1107dM2887a.f3849d).f3828j.f3858e && time - ((Date) c1107dM2887a.f3851f).getTime() > 3600000 && time - ((C1104a) c1107dM2887a.f3849d).f3829k.getTime() > 86400000) {
                                if (Looper.getMainLooper().equals(Looper.myLooper())) {
                                    c1107dM2887a.m2888b();
                                } else {
                                    new Handler(Looper.getMainLooper()).post(new RunnableC0055o(14, c1107dM2887a));
                                }
                            }
                        }
                        AbstractC2056E.m4539h(httpURLConnectionM2920t);
                        return arrayListM2928a;
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = httpURLConnectionM2920t;
                        AbstractC2056E.m4539h(httpURLConnection);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    AbstractC2056E.m4539h(httpURLConnection);
                    throw th;
                }
            } catch (Throwable th3) {
                AbstractC2056E.m4535d(null);
                throw th3;
            }
        } catch (Exception e5) {
            ArrayList arrayListM2928a2 = C1128y.m2928a(c1127x.f3916f, null, new C1111h(e5));
            m2917p(c1127x, arrayListM2928a2);
            return arrayListM2928a2;
        }
    }

    /* JADX INFO: renamed from: g */
    public static AsyncTaskC1126w m2910g(C1127x c1127x) {
        AbstractC2069g.m4581e(c1127x);
        AsyncTaskC1126w asyncTaskC1126w = new AsyncTaskC1126w(c1127x);
        asyncTaskC1126w.executeOnExecutor(AbstractC1117n.m2891a(), new Void[0]);
        return asyncTaskC1126w;
    }

    /* JADX INFO: renamed from: j */
    public static boolean m2911j(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof C1123t);
    }

    /* JADX INFO: renamed from: k */
    public static boolean m2912k(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    /* JADX INFO: renamed from: l */
    public static C1125v m2913l(C1104a c1104a, String str, JSONObject jSONObject, InterfaceC1121r interfaceC1121r) {
        C1125v c1125v = new C1125v(c1104a, str, null, EnumC1129z.f3923f, interfaceC1121r);
        c1125v.f3906d = jSONObject;
        return c1125v;
    }

    /* JADX INFO: renamed from: m */
    public static String m2914m(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number)) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX INFO: renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m2915n(org.json.JSONObject r6, java.lang.String r7, com.facebook.InterfaceC1122s r8) {
        /*
            java.util.regex.Pattern r0 = com.facebook.C1125v.f3901k
            java.util.regex.Matcher r0 = r0.matcher(r7)
            boolean r1 = r0.matches()
            r2 = 1
            if (r1 == 0) goto L12
            java.lang.String r0 = r0.group(r2)
            goto L13
        L12:
            r0 = r7
        L13:
            java.lang.String r1 = "me/"
            boolean r1 = r0.startsWith(r1)
            r3 = 0
            if (r1 != 0) goto L27
            java.lang.String r1 = "/me/"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L25
            goto L27
        L25:
            r7 = r3
            goto L3c
        L27:
            java.lang.String r0 = ":"
            int r0 = r7.indexOf(r0)
            java.lang.String r1 = "?"
            int r7 = r7.indexOf(r1)
            r1 = 3
            if (r0 <= r1) goto L25
            r1 = -1
            if (r7 == r1) goto L3b
            if (r0 >= r7) goto L25
        L3b:
            r7 = r2
        L3c:
            java.util.Iterator r0 = r6.keys()
        L40:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L61
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r6.opt(r1)
            if (r7 == 0) goto L5c
            java.lang.String r5 = "image"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L5c
            r5 = r2
            goto L5d
        L5c:
            r5 = r3
        L5d:
            m2916o(r1, r4, r8, r5)
            goto L40
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.C1125v.m2915n(org.json.JSONObject, java.lang.String, com.facebook.s):void");
    }

    /* JADX INFO: renamed from: o */
    public static void m2916o(String str, Object obj, InterfaceC1122s interfaceC1122s, boolean z3) {
        Class<?> cls = obj.getClass();
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj;
            if (z3) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    m2916o(str + "[" + next + "]", jSONObject.opt(next), interfaceC1122s, z3);
                }
                return;
            }
            if (jSONObject.has("id")) {
                m2916o(str, jSONObject.optString("id"), interfaceC1122s, z3);
                return;
            } else if (jSONObject.has("url")) {
                m2916o(str, jSONObject.optString("url"), interfaceC1122s, z3);
                return;
            } else {
                if (jSONObject.has("fbsdk:create_object")) {
                    m2916o(str, jSONObject.toString(), interfaceC1122s, z3);
                    return;
                }
                return;
            }
        }
        if (!JSONArray.class.isAssignableFrom(cls)) {
            if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
                interfaceC1122s.mo980f(str, obj.toString());
                return;
            } else {
                if (Date.class.isAssignableFrom(cls)) {
                    interfaceC1122s.mo980f(str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj));
                    return;
                }
                return;
            }
        }
        JSONArray jSONArray = (JSONArray) obj;
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Locale locale = Locale.ROOT;
            m2916o(str + "[" + i3 + "]", jSONArray.opt(i3), interfaceC1122s, z3);
        }
    }

    /* JADX INFO: renamed from: p */
    public static void m2917p(C1127x c1127x, ArrayList arrayList) {
        int size = c1127x.f3916f.size();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            C1125v c1125v = (C1125v) c1127x.f3916f.get(i3);
            if (c1125v.f3908f != null) {
                arrayList2.add(new Pair(c1125v.f3908f, arrayList.get(i3)));
            }
        }
        if (arrayList2.size() > 0) {
            RunnableC0224a runnableC0224a = new RunnableC0224a(arrayList2, 3, c1127x);
            Handler handler = c1127x.f3915e;
            if (handler == null) {
                runnableC0224a.run();
            } else {
                handler.post(runnableC0224a);
            }
        }
    }

    /* JADX INFO: renamed from: q */
    public static void m2918q(HashMap map, C1124u c1124u) {
        for (String str : map.keySet()) {
            C1120q c1120q = (C1120q) map.get(str);
            if (m2911j(c1120q.f3893b)) {
                c1124u.m2906g(str, c1120q.f3893b, c1120q.f3892a);
            }
        }
    }

    /* JADX INFO: renamed from: r */
    public static final void m2919r(C1127x c1127x, HttpURLConnection httpURLConnection) throws Throwable {
        boolean z3;
        OutputStream gZIPOutputStream;
        String str;
        C2085w c2085w = new C2085w();
        AbstractC2069g.m4583g("Request", "tag");
        c2085w.f7378a = new StringBuilder();
        int size = c1127x.f3916f.size();
        Iterator<E> it = c1127x.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                z3 = true;
                break;
            }
            C1125v c1125v = (C1125v) it.next();
            Iterator<String> it2 = c1125v.f3907e.keySet().iterator();
            while (it2.hasNext()) {
                if (m2911j(c1125v.f3907e.get(it2.next()))) {
                    z3 = false;
                    break loop0;
                }
            }
        }
        EnumC1129z enumC1129z = EnumC1129z.f3923f;
        EnumC1129z enumC1129z2 = size == 1 ? ((C1125v) c1127x.f3916f.get(0)).f3904b : enumC1129z;
        httpURLConnection.setRequestMethod(enumC1129z2.name());
        if (z3) {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        } else {
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + f3900j);
        }
        URL url = httpURLConnection.getURL();
        AbstractC1117n.m2896f();
        AbstractC1117n.m2896f();
        AbstractC1117n.m2896f();
        httpURLConnection.getRequestMethod();
        AbstractC1117n.m2896f();
        httpURLConnection.getRequestProperty("User-Agent");
        AbstractC1117n.m2896f();
        httpURLConnection.getRequestProperty("Content-Type");
        AbstractC1117n.m2896f();
        httpURLConnection.setConnectTimeout(0);
        httpURLConnection.setReadTimeout(0);
        if (enumC1129z2 != enumC1129z) {
            c2085w.f7378a.getClass();
            AbstractC1117n.m2896f();
            c2085w.f7378a = new StringBuilder();
            return;
        }
        httpURLConnection.setDoOutput(true);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
            if (z3) {
                try {
                    gZIPOutputStream = new GZIPOutputStream(bufferedOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } else {
                gZIPOutputStream = bufferedOutputStream2;
            }
            for (C1105b c1105b : c1127x.f3917g) {
            }
            Iterator<E> it3 = c1127x.iterator();
            while (it3.hasNext()) {
                InterfaceC1121r interfaceC1121r = ((C1125v) it3.next()).f3908f;
            }
            C1124u c1124u = new C1124u();
            c1124u.f3896e = true;
            c1124u.f3898g = gZIPOutputStream;
            c1124u.f3899h = c2085w;
            c1124u.f3897f = z3;
            if (size == 1) {
                C1125v c1125v2 = (C1125v) c1127x.f3916f.get(0);
                HashMap map = new HashMap();
                for (String str2 : c1125v2.f3907e.keySet()) {
                    Object obj = c1125v2.f3907e.get(str2);
                    if (m2911j(obj)) {
                        map.put(str2, new C1120q(c1125v2, obj));
                    }
                }
                AbstractC1117n.m2896f();
                Bundle bundle = c1125v2.f3907e;
                for (String str3 : bundle.keySet()) {
                    Object obj2 = bundle.get(str3);
                    if (m2912k(obj2)) {
                        c1124u.m2906g(str3, obj2, c1125v2);
                    }
                }
                AbstractC1117n.m2896f();
                m2918q(map, c1124u);
                JSONObject jSONObject = c1125v2.f3906d;
                if (jSONObject != null) {
                    m2915n(jSONObject, url.getPath(), c1124u);
                }
            } else {
                Iterator<E> it4 = c1127x.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        C1104a c1104a = ((C1125v) it4.next()).f3903a;
                        if (c1104a != null && (str = c1104a.f3830l) != null) {
                            break;
                        }
                    } else {
                        HashSet hashSet = AbstractC1117n.f3875a;
                        AbstractC2069g.m4584h();
                        str = AbstractC1117n.f3877c;
                        break;
                    }
                }
                if (AbstractC2056E.m4550s(str)) {
                    throw new C1111h("App ID was not specified at the request or Settings.");
                }
                c1124u.mo980f("batch_app_id", str);
                HashMap map2 = new HashMap();
                JSONArray jSONArray = new JSONArray();
                Iterator it5 = c1127x.iterator();
                while (it5.hasNext()) {
                    C1125v c1125v3 = (C1125v) it5.next();
                    c1125v3.getClass();
                    JSONObject jSONObject2 = new JSONObject();
                    String str4 = AbstractC2052A.m4528a() + "/" + c1125v3.m2925h();
                    c1125v3.m2921a();
                    Uri uri = Uri.parse(c1125v3.m2922b(str4, Boolean.TRUE));
                    String str5 = uri.getPath() + "?" + uri.getQuery();
                    jSONObject2.put("relative_url", str5);
                    jSONObject2.put("method", c1125v3.f3904b);
                    C1104a c1104a2 = c1125v3.f3903a;
                    if (c1104a2 != null) {
                        C2085w.m4628a(c1104a2.f3827i);
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> it6 = c1125v3.f3907e.keySet().iterator();
                    while (it6.hasNext()) {
                        Object obj3 = c1125v3.f3907e.get(it6.next());
                        if (m2911j(obj3)) {
                            Locale locale = Locale.ROOT;
                            String str6 = "file" + map2.size();
                            arrayList.add(str6);
                            map2.put(str6, new C1120q(c1125v3, obj3));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        jSONObject2.put("attached_files", TextUtils.join(",", arrayList));
                    }
                    if (c1125v3.f3906d != null) {
                        ArrayList arrayList2 = new ArrayList();
                        m2915n(c1125v3.f3906d, str5, new C0444d(arrayList2));
                        jSONObject2.put("body", TextUtils.join("&", arrayList2));
                    }
                    jSONArray.put(jSONObject2);
                }
                c1124u.mo980f("batch", jSONArray.toString());
                AbstractC1117n.m2896f();
                m2918q(map2, c1124u);
            }
            gZIPOutputStream.close();
            c2085w.f7378a.getClass();
            AbstractC1117n.m2896f();
            c2085w.f7378a = new StringBuilder();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: t */
    public static HttpURLConnection m2920t(C1127x c1127x) {
        Iterator<E> it = c1127x.iterator();
        while (it.hasNext()) {
            C1125v c1125v = (C1125v) it.next();
            if (EnumC1129z.f3922e.equals(c1125v.f3904b)) {
                String strSubstring = c1125v.f3910h;
                if (!AbstractC2056E.m4550s(strSubstring)) {
                    if (strSubstring.startsWith("v")) {
                        strSubstring = strSubstring.substring(1);
                    }
                    String[] strArrSplit = strSubstring.split("\\.");
                    if ((strArrSplit.length < 2 || Integer.parseInt(strArrSplit[0]) <= 2) && (Integer.parseInt(strArrSplit[0]) < 2 || Integer.parseInt(strArrSplit[1]) < 4)) {
                    }
                }
                Bundle bundle = c1125v.f3907e;
                if (!bundle.containsKey("fields") || AbstractC2056E.m4550s(bundle.getString("fields"))) {
                    HashMap map = C2085w.f7377b;
                    AbstractC1117n.m2896f();
                }
            }
        }
        try {
            HttpURLConnection httpURLConnectionM2908c = null;
            try {
                httpURLConnectionM2908c = m2908c(c1127x.f3916f.size() == 1 ? new URL(((C1125v) c1127x.f3916f.get(0)).m2926i()) : new URL(AbstractC2052A.m4528a()));
                m2919r(c1127x, httpURLConnectionM2908c);
                return httpURLConnectionM2908c;
            } catch (IOException | JSONException e3) {
                AbstractC2056E.m4539h(httpURLConnectionM2908c);
                throw new C1111h("could not construct request body", e3);
            }
        } catch (MalformedURLException e4) {
            throw new C1111h("could not construct URL for request", e4);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2921a() {
        if (this.f3903a != null) {
            if (!this.f3907e.containsKey("access_token")) {
                String str = this.f3903a.f3827i;
                C2085w.m4628a(str);
                this.f3907e.putString("access_token", str);
            }
        } else if (!this.f3911i && !this.f3907e.containsKey("access_token")) {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            String str2 = AbstractC1117n.f3877c;
            AbstractC2069g.m4584h();
            String str3 = AbstractC1117n.f3879e;
            if (!AbstractC2056E.m4550s(str2) && !AbstractC2056E.m4550s(str3)) {
                this.f3907e.putString("access_token", str2 + "|" + str3);
            }
        }
        this.f3907e.putString("sdk", "android");
        this.f3907e.putString("format", "json");
        AbstractC1117n.m2896f();
        AbstractC1117n.m2896f();
    }

    /* JADX INFO: renamed from: b */
    public final String m2922b(String str, Boolean bool) {
        if (!bool.booleanValue() && this.f3904b == EnumC1129z.f3923f) {
            return str;
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (String str2 : this.f3907e.keySet()) {
            Object obj = this.f3907e.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (m2912k(obj)) {
                builderBuildUpon.appendQueryParameter(str2, m2914m(obj).toString());
            } else if (this.f3904b == EnumC1129z.f3922e) {
                Locale locale = Locale.US;
                throw new IllegalArgumentException("Unsupported parameter type for GET request: ".concat(obj.getClass().getSimpleName()));
            }
        }
        return builderBuildUpon.toString();
    }

    /* JADX INFO: renamed from: d */
    public final C1128y m2923d() throws Throwable {
        ArrayList arrayListM2909f = m2909f(new C1127x(Arrays.asList(this)));
        if (arrayListM2909f.size() == 1) {
            return (C1128y) arrayListM2909f.get(0);
        }
        throw new C1111h("invalid state: expected a single response");
    }

    /* JADX INFO: renamed from: e */
    public final AsyncTaskC1126w m2924e() {
        return m2910g(new C1127x(Arrays.asList(this)));
    }

    /* JADX INFO: renamed from: h */
    public final String m2925h() {
        Pattern pattern = f3901k;
        String str = this.f3905c;
        if (pattern.matcher(str).matches()) {
            return str;
        }
        return this.f3910h + "/" + str;
    }

    /* JADX INFO: renamed from: i */
    public final String m2926i() {
        String strM4528a;
        String str;
        if (this.f3904b == EnumC1129z.f3923f && (str = this.f3905c) != null && str.endsWith("/videos")) {
            Collection collection = AbstractC2052A.f7256a;
            strM4528a = AbstractC0032g.m152j("https://graph-video.", AbstractC1117n.m2893c());
        } else {
            strM4528a = AbstractC2052A.m4528a();
        }
        String str2 = strM4528a + "/" + m2925h();
        m2921a();
        return m2922b(str2, Boolean.FALSE);
    }

    /* JADX INFO: renamed from: s */
    public final void m2927s(InterfaceC1121r interfaceC1121r) {
        AbstractC1117n.m2896f();
        AbstractC1117n.m2896f();
        this.f3908f = interfaceC1121r;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{Request:  accessToken: ");
        Object obj = this.f3903a;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", graphPath: ");
        sb.append(this.f3905c);
        sb.append(", graphObject: ");
        sb.append(this.f3906d);
        sb.append(", httpMethod: ");
        sb.append(this.f3904b);
        sb.append(", parameters: ");
        sb.append(this.f3907e);
        sb.append("}");
        return sb.toString();
    }
}
