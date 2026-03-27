package com.facebook;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import p166z0.AbstractC2056E;
import p166z0.C2085w;

/* JADX INFO: renamed from: com.facebook.y */
/* JADX INFO: loaded from: classes.dex */
public final class C1128y {

    /* JADX INFO: renamed from: d */
    public static final /* synthetic */ int f3918d = 0;

    /* JADX INFO: renamed from: a */
    public final HttpURLConnection f3919a;

    /* JADX INFO: renamed from: b */
    public final JSONObject f3920b;

    /* JADX INFO: renamed from: c */
    public final C1114k f3921c;

    public C1128y(HttpURLConnection httpURLConnection, JSONObject jSONObject, C1114k c1114k) {
        this.f3919a = httpURLConnection;
        this.f3920b = jSONObject;
        this.f3921c = c1114k;
    }

    /* JADX INFO: renamed from: a */
    public static ArrayList m2928a(List list, HttpURLConnection httpURLConnection, C1111h c1111h) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new C1128y(httpURLConnection, null, new C1114k(c1111h)));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016c  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.C1128y m2929b(com.facebook.C1125v r21, java.net.HttpURLConnection r22, java.lang.Object r23, java.lang.Object r24) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.C1128y.m2929b(com.facebook.v, java.net.HttpURLConnection, java.lang.Object, java.lang.Object):com.facebook.y");
    }

    /* JADX INFO: renamed from: c */
    public static ArrayList m2930c(InputStream inputStream, HttpURLConnection httpURLConnection, C1127x c1127x) throws Throwable {
        Object obj;
        String strM4556y = AbstractC2056E.m4556y(inputStream);
        strM4556y.getClass();
        HashMap map = C2085w.f7377b;
        AbstractC1117n.m2896f();
        Object objNextValue = new JSONTokener(strM4556y).nextValue();
        int size = c1127x.f3916f.size();
        ArrayList arrayList = new ArrayList(size);
        if (size == 1) {
            c1127x.get(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("body", objNextValue);
                jSONObject.put("code", httpURLConnection.getResponseCode());
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                obj = jSONArray;
            } catch (IOException e3) {
                arrayList.add(new C1128y(httpURLConnection, null, new C1114k(e3)));
                obj = objNextValue;
            } catch (JSONException e4) {
                arrayList.add(new C1128y(httpURLConnection, null, new C1114k(e4)));
                obj = objNextValue;
            }
        } else {
            obj = objNextValue;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) obj;
            if (jSONArray2.length() == size) {
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    try {
                        arrayList.add(m2929b((C1125v) c1127x.get(i3), httpURLConnection, jSONArray2.get(i3), objNextValue));
                    } catch (C1111h e5) {
                        arrayList.add(new C1128y(httpURLConnection, null, new C1114k(e5)));
                    } catch (JSONException e6) {
                        arrayList.add(new C1128y(httpURLConnection, null, new C1114k(e6)));
                    }
                }
                HashMap map2 = C2085w.f7377b;
                AbstractC1117n.m2896f();
                return arrayList;
            }
        }
        throw new C1111h("Unexpected number of results");
    }

    public final String toString() {
        String string;
        try {
            Locale locale = Locale.US;
            HttpURLConnection httpURLConnection = this.f3919a;
            int responseCode = httpURLConnection != null ? httpURLConnection.getResponseCode() : 200;
            StringBuilder sb = new StringBuilder();
            sb.append(responseCode);
            string = sb.toString();
        } catch (IOException unused) {
            string = "unknown";
        }
        return "{Response:  responseCode: " + string + ", graphObject: " + this.f3920b + ", error: " + this.f3921c + "}";
    }
}
