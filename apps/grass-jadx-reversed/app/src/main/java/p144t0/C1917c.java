package p144t0;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p036L0.C0444d;
import p141s0.AsyncTaskC1881k;
import p141s0.InterfaceC1880j;

/* JADX INFO: renamed from: t0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1917c {

    /* JADX INFO: renamed from: a */
    public final String f6711a;

    /* JADX INFO: renamed from: b */
    public final String f6712b;

    /* JADX INFO: renamed from: c */
    public final String f6713c;

    /* JADX INFO: renamed from: d */
    public final int f6714d;

    /* JADX INFO: renamed from: e */
    public final float[] f6715e;

    /* JADX INFO: renamed from: f */
    public File f6716f;

    /* JADX INFO: renamed from: g */
    public C1916b f6717g;

    /* JADX INFO: renamed from: h */
    public Runnable f6718h;

    public C1917c(String str, String str2, String str3, int i3, float[] fArr) {
        this.f6711a = str;
        this.f6712b = str2;
        this.f6713c = str3;
        this.f6714d = i3;
        this.f6715e = fArr;
    }

    /* JADX INFO: renamed from: a */
    public static C1917c m4268a(JSONObject jSONObject) {
        float[] fArr;
        float[] fArr2;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("use_case");
            String string2 = jSONObject.getString("asset_uri");
            String strOptString = jSONObject.optString("rules_uri", null);
            int i3 = jSONObject.getInt("version_id");
            JSONArray jSONArray = jSONObject.getJSONArray("thresholds");
            ConcurrentHashMap concurrentHashMap = AbstractC1918d.f6719a;
            Set set = AbstractC0147a.f354a;
            if (set.contains(AbstractC1918d.class)) {
                fArr2 = null;
            } else {
                try {
                    if (set.contains(AbstractC1918d.class) || jSONArray == null) {
                        fArr = null;
                        fArr2 = fArr;
                    } else {
                        try {
                            fArr = new float[jSONArray.length()];
                            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                try {
                                    fArr[i4] = Float.parseFloat(jSONArray.getString(i4));
                                } catch (JSONException unused) {
                                }
                            }
                        } catch (Throwable th) {
                            AbstractC0147a.m295a(th, AbstractC1918d.class);
                            fArr = null;
                            fArr2 = fArr;
                            return new C1917c(string, string2, strOptString, i3, fArr2);
                        }
                        fArr2 = fArr;
                    }
                } catch (Throwable th2) {
                    AbstractC0147a.m295a(th2, AbstractC1918d.class);
                    fArr2 = null;
                }
            }
            return new C1917c(string, string2, strOptString, i3, fArr2);
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4269b(String str, String str2, InterfaceC1880j interfaceC1880j) {
        File file = new File(AbstractC1920f.m4306g(), str2);
        if (str == null || file.exists()) {
            interfaceC1880j.mo49i(file);
            return;
        }
        AsyncTaskC1881k asyncTaskC1881k = new AsyncTaskC1881k();
        asyncTaskC1881k.f6617c = str;
        asyncTaskC1881k.f6616b = file;
        asyncTaskC1881k.f6615a = interfaceC1880j;
        asyncTaskC1881k.execute(new String[0]);
    }

    /* JADX INFO: renamed from: c */
    public static void m4270c(C1917c c1917c, ArrayList arrayList) {
        File[] fileArrListFiles;
        String str = c1917c.f6711a;
        File fileM4306g = AbstractC1920f.m4306g();
        int i3 = c1917c.f6714d;
        if (fileM4306g != null && (fileArrListFiles = fileM4306g.listFiles()) != null && fileArrListFiles.length != 0) {
            String str2 = str + "_" + i3;
            for (File file : fileArrListFiles) {
                String name = file.getName();
                if (name.startsWith(str) && !name.startsWith(str2)) {
                    file.delete();
                }
            }
        }
        m4269b(c1917c.f6712b, c1917c.f6711a + "_" + i3, new C0444d(arrayList));
    }
}
