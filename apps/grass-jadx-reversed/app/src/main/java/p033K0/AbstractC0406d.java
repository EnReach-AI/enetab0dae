package p033K0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AbstractC1117n;
import com.facebook.C1104a;
import com.facebook.C1111h;
import com.facebook.C1123t;
import com.facebook.C1125v;
import com.facebook.EnumC1129z;
import com.facebook.InterfaceC1121r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p008B2.C0107k0;
import p010C0.AbstractC0147a;
import p025H1.C0291t;
import p031J1.C0382f;
import p119m2.AbstractC1766e;
import p135q2.InterfaceC1840a;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.C2060I;
import p167z2.C2090b;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: K0.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0406d {
    /* JADX INFO: renamed from: b */
    public static void m895b(String str) {
        File fileM898f = m898f();
        if (fileM898f == null || str == null) {
            return;
        }
        new File(fileM898f, str).delete();
    }

    /* JADX INFO: renamed from: c */
    public static final InterfaceC1840a m896c(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("<this>", interfaceC2095g);
        if (interfaceC2095g instanceof C2090b) {
            return ((C2090b) interfaceC2095g).f7393b;
        }
        if (interfaceC2095g instanceof C0107k0) {
            return m896c(((C0107k0) interfaceC2095g).f296a);
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public static Pair m897e(String str) {
        String strSubstring;
        int i3;
        if (AbstractC0147a.f354a.contains(AbstractC0406d.class)) {
            return null;
        }
        try {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf == -1 || str.length() <= (i3 = iIndexOf + 1)) {
                strSubstring = null;
            } else {
                strSubstring = str.substring(0, iIndexOf);
                str = str.substring(i3);
            }
            return new Pair(strSubstring, str);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC0406d.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: f */
    public static File m898f() {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        File file = new File(AbstractC1117n.f3882h.getCacheDir(), "instrument");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    /* JADX INFO: renamed from: h */
    public static C1125v m899h(C1104a c1104a, Uri uri, C2060I c2060i) {
        if (AbstractC0147a.f354a.contains(AbstractC0406d.class)) {
            return null;
        }
        if (uri != null) {
            try {
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return m900i(c1104a, new File(uri.getPath()), c2060i);
                }
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC0406d.class);
                return null;
            }
        }
        if (uri == null || !"content".equalsIgnoreCase(uri.getScheme())) {
            throw new C1111h("The image Uri must be either a file:// or content:// Uri");
        }
        C1123t c1123t = new C1123t(uri);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", c1123t);
        return new C1125v(c1104a, "me/staging_resources", bundle, EnumC1129z.f3923f, c2060i);
    }

    /* JADX INFO: renamed from: i */
    public static C1125v m900i(C1104a c1104a, File file, C2060I c2060i) {
        if (AbstractC0147a.f354a.contains(AbstractC0406d.class)) {
            return null;
        }
        try {
            C1123t c1123t = new C1123t(ParcelFileDescriptor.open(file, 268435456));
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", c1123t);
            return new C1125v(c1104a, "me/staging_resources", bundle, EnumC1129z.f3923f, c2060i);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC0406d.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: k */
    public static JSONObject m901k(String str) {
        File fileM898f = m898f();
        if (fileM898f != null && str != null) {
            try {
                return new JSONObject(AbstractC2056E.m4556y(new FileInputStream(new File(fileM898f, str))));
            } catch (Exception unused) {
                m895b(str);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: l */
    public static JSONArray m902l(JSONArray jSONArray) {
        if (AbstractC0147a.f354a.contains(AbstractC0406d.class)) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object objM903m = jSONArray.get(i3);
                if (objM903m instanceof JSONArray) {
                    objM903m = m902l((JSONArray) objM903m);
                } else if (objM903m instanceof JSONObject) {
                    objM903m = m903m((JSONObject) objM903m, true);
                }
                jSONArray2.put(objM903m);
            }
            return jSONArray2;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC0406d.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: m */
    public static JSONObject m903m(JSONObject jSONObject, boolean z3) {
        if (AbstractC0147a.f354a.contains(AbstractC0406d.class) || jSONObject == null) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONArray jSONArrayNames = jSONObject.names();
                for (int i3 = 0; i3 < jSONArrayNames.length(); i3++) {
                    String string = jSONArrayNames.getString(i3);
                    Object objM902l = jSONObject.get(string);
                    if (objM902l instanceof JSONObject) {
                        objM902l = m903m((JSONObject) objM902l, true);
                    } else if (objM902l instanceof JSONArray) {
                        objM902l = m902l((JSONArray) objM902l);
                    }
                    Pair pairM897e = m897e(string);
                    String str = (String) pairM897e.first;
                    String str2 = (String) pairM897e.second;
                    if (z3) {
                        if (str != null && str.equals("fbsdk")) {
                            jSONObject2.put(string, objM902l);
                        } else if (str == null || str.equals("og")) {
                            jSONObject2.put(str2, objM902l);
                        } else {
                            jSONObject3.put(str2, objM902l);
                        }
                    } else if (str == null || !str.equals("fb")) {
                        jSONObject2.put(str2, objM902l);
                    } else {
                        jSONObject2.put(string, objM902l);
                    }
                }
                if (jSONObject3.length() > 0) {
                    jSONObject2.put("data", jSONObject3);
                }
                return jSONObject2;
            } catch (JSONException unused) {
                throw new C1111h("Failed to create json object from share content");
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC0406d.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: n */
    public static void m904n(Throwable th) {
        if ((th instanceof VirtualMachineError) || (th instanceof ThreadDeath) || (th instanceof InterruptedException) || (th instanceof ClassCircularityError) || (th instanceof ClassFormatError) || (th instanceof IncompatibleClassChangeError) || (th instanceof BootstrapMethodError) || (th instanceof VerifyError)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            if (!(th instanceof RuntimeException)) {
                throw new RuntimeException(th);
            }
            throw ((RuntimeException) th);
        }
    }

    /* JADX INFO: renamed from: o */
    public static void m905o(String str, JSONArray jSONArray, InterfaceC1121r interfaceC1121r) {
        if (jSONArray.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, jSONArray.toString());
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C1125v.m2913l(null, AbstractC1117n.f3877c + "/instruments", jSONObject, interfaceC1121r).m2924e();
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: p */
    public static void m906p(String str, String str2) {
        File fileM898f = m898f();
        if (fileM898f == null || str == null || str2 == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileM898f, str));
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract Intent mo907a(Context context, Object obj);

    /* JADX INFO: renamed from: d */
    public abstract void mo530d(C0291t c0291t, float f3, float f4);

    /* JADX INFO: renamed from: g */
    public C0382f mo908g(Context context, Object obj) {
        AbstractC1766e.m3920e("context", context);
        return null;
    }

    /* JADX INFO: renamed from: j */
    public abstract Object mo909j(int i3, Intent intent);
}
