package p166z0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AbstractC1117n;
import com.facebook.C1111h;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import p002A0.C0022d;
import p010C0.AbstractC0147a;

/* JADX INFO: renamed from: z0.E */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2056E {

    /* JADX INFO: renamed from: a */
    public static int f7265a = 0;

    /* JADX INFO: renamed from: b */
    public static long f7266b = -1;

    /* JADX INFO: renamed from: c */
    public static long f7267c = -1;

    /* JADX INFO: renamed from: d */
    public static long f7268d = -1;

    /* JADX INFO: renamed from: e */
    public static String f7269e = "";

    /* JADX INFO: renamed from: f */
    public static String f7270f = "";

    /* JADX INFO: renamed from: g */
    public static String f7271g = "NoCarrier";

    /* JADX INFO: renamed from: A */
    public static void m4529A(JSONObject jSONObject, Context context) throws JSONException {
        String str;
        Locale locale;
        int i3;
        WindowManager windowManager;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("a2");
        int i4 = 0;
        if (f7266b == -1 || System.currentTimeMillis() - f7266b >= 1800000) {
            f7266b = System.currentTimeMillis();
            try {
                TimeZone timeZone = TimeZone.getDefault();
                f7269e = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
                f7270f = timeZone.getID();
            } catch (AssertionError | Exception unused) {
            }
            if (f7271g.equals("NoCarrier")) {
                try {
                    f7271g = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
                } catch (Exception unused2) {
                }
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    f7267c = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                }
                f7267c = Math.round(f7267c / 1.073741824E9d);
            } catch (Exception unused3) {
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    f7268d = ((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize());
                }
                f7268d = Math.round(f7268d / 1.073741824E9d);
            } catch (Exception unused4) {
            }
        }
        String packageName = context.getPackageName();
        int i5 = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i5 = packageInfo.versionCode;
            str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused5) {
            str = "";
        }
        jSONArray.put(packageName);
        jSONArray.put(i5);
        jSONArray.put(str);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception unused6) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + "_" + locale.getCountry());
        jSONArray.put(f7269e);
        jSONArray.put(f7271g);
        double d = 0.0d;
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception unused7) {
        }
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i6 = displayMetrics.widthPixels;
            try {
                i4 = displayMetrics.heightPixels;
                d = displayMetrics.density;
            } catch (Exception unused8) {
            }
            int i7 = i4;
            i4 = i6;
            i3 = i7;
        } else {
            i3 = 0;
        }
        jSONArray.put(i4);
        jSONArray.put(i3);
        jSONArray.put(new DecimalFormat("#.##").format(d));
        int i8 = f7265a;
        if (i8 <= 0) {
            try {
                File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new C0022d(3));
                if (fileArrListFiles != null) {
                    f7265a = fileArrListFiles.length;
                }
            } catch (Exception unused9) {
            }
            if (f7265a <= 0) {
                f7265a = Math.max(Runtime.getRuntime().availableProcessors(), 1);
            }
            i8 = f7265a;
        }
        jSONArray.put(i8);
        jSONArray.put(f7267c);
        jSONArray.put(f7268d);
        jSONArray.put(f7270f);
        jSONObject.put("extinfo", jSONArray.toString());
    }

    /* JADX INFO: renamed from: B */
    public static String m4530B(String str) {
        if (str == null) {
            return null;
        }
        return m4547p("SHA-256", str.getBytes());
    }

    /* JADX INFO: renamed from: C */
    public static void m4531C(Parcel parcel, Map map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
    }

    /* JADX INFO: renamed from: a */
    public static HashMap m4532a(String str) {
        if (str.isEmpty()) {
            return new HashMap();
        }
        try {
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            return map;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    /* JADX INFO: renamed from: b */
    public static Uri m4533b(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        return builder.build();
    }

    /* JADX INFO: renamed from: c */
    public static void m4534c(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        for (String str2 : cookie.split(";")) {
            String[] strArrSplit = str2.split("=");
            if (strArrSplit.length > 0) {
                cookieManager.setCookie(str, strArrSplit[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
        }
        cookieManager.removeExpiredCookie();
    }

    /* JADX INFO: renamed from: d */
    public static void m4535d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static String m4536e(String str) {
        return m4550s(str) ? "" : str;
    }

    /* JADX INFO: renamed from: f */
    public static HashMap m4537f(JSONObject jSONObject) {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject.optString(next);
            if (strOptString != null) {
                map.put(next, strOptString);
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: g */
    public static int m4538g(InputStream inputStream, OutputStream outputStream) throws Throwable {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[8192];
                int i3 = 0;
                while (true) {
                    int i4 = bufferedInputStream2.read(bArr);
                    if (i4 == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, i4);
                    i3 += i4;
                }
                bufferedInputStream2.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return i3;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: h */
    public static void m4539h(URLConnection uRLConnection) {
        if (uRLConnection == null || !(uRLConnection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) uRLConnection).disconnect();
    }

    /* JADX INFO: renamed from: i */
    public static String m4540i(Context context) {
        return context == null ? "null" : context == context.getApplicationContext() ? "unknown" : context.getClass().getSimpleName();
    }

    /* JADX INFO: renamed from: j */
    public static String m4541j(Context context) {
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            String str = AbstractC1117n.f3878d;
            if (str != null) {
                return str;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i3 = applicationInfo.labelRes;
            return i3 == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i3);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: k */
    public static Date m4542k(Bundle bundle, String str, Date date) {
        long jLongValue;
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            jLongValue = ((Long) obj).longValue();
        } else {
            if (!(obj instanceof String)) {
                return null;
            }
            try {
                jLongValue = Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        if (jLongValue == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date((jLongValue * 1000) + date.getTime());
    }

    /* JADX INFO: renamed from: l */
    public static JSONObject m4543l() {
        if (AbstractC0147a.f354a.contains(AbstractC2056E.class)) {
            return null;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            String string = AbstractC1117n.f3882h.getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).getString("data_processing_options", null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2056E.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: m */
    public static Locale m4544m() {
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            return AbstractC1117n.f3882h.getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: n */
    public static Object m4545n(JSONObject jSONObject, String str, String str2) throws JSONException {
        Object objOpt = jSONObject.opt(str);
        if (objOpt != null && (objOpt instanceof String)) {
            objOpt = new JSONTokener((String) objOpt).nextValue();
        }
        if (objOpt == null || (objOpt instanceof JSONObject) || (objOpt instanceof JSONArray)) {
            return objOpt;
        }
        if (str2 == null) {
            throw new C1111h("Got an unexpected non-JSON object.");
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt(str2, objOpt);
        return jSONObject2;
    }

    /* JADX INFO: renamed from: o */
    public static C2071i m4546o(JSONObject jSONObject) throws JSONException {
        String strOptString;
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        ArrayList arrayList3 = new ArrayList(jSONArray.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
            String strOptString2 = jSONObjectOptJSONObject.optString("permission");
            if (strOptString2 != null && !strOptString2.equals("installed") && (strOptString = jSONObjectOptJSONObject.optString("status")) != null) {
                if (strOptString.equals("granted")) {
                    arrayList.add(strOptString2);
                } else if (strOptString.equals("declined")) {
                    arrayList2.add(strOptString2);
                } else if (strOptString.equals("expired")) {
                    arrayList3.add(strOptString2);
                }
            }
        }
        C2071i c2071i = new C2071i();
        c2071i.f7314a = arrayList;
        c2071i.f7315b = arrayList2;
        c2071i.f7316c = arrayList3;
        return c2071i;
    }

    /* JADX INFO: renamed from: p */
    public static String m4547p(String str, byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b3 : bArrDigest) {
                sb.append(Integer.toHexString((b3 >> 4) & 15));
                sb.append(Integer.toHexString(b3 & 15));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: q */
    public static boolean m4548q() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            intent.setData(Uri.parse("fb" + AbstractC1117n.f3877c + "://applinks"));
            AbstractC2069g.m4584h();
            Context context = AbstractC1117n.f3882h;
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                if (packageName.equals(it.next().activityInfo.packageName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: r */
    public static boolean m4549r() {
        if (AbstractC0147a.f354a.contains(AbstractC2056E.class)) {
            return false;
        }
        try {
            JSONObject jSONObjectM4543l = m4543l();
            if (jSONObjectM4543l == null) {
                return false;
            }
            try {
                JSONArray jSONArray = jSONObjectM4543l.getJSONArray("data_processing_options");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    if (jSONArray.getString(i3).toLowerCase().equals("ldu")) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2056E.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: s */
    public static boolean m4550s(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX INFO: renamed from: t */
    public static boolean m4551t(Uri uri) {
        return uri != null && ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()) || "fbstaging".equalsIgnoreCase(uri.getScheme()));
    }

    /* JADX INFO: renamed from: u */
    public static ArrayList m4552u(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(jSONArray.getString(i3));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: v */
    public static String m4553v(AbstractMap abstractMap) {
        if (abstractMap.isEmpty()) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : abstractMap.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: w */
    public static Bundle m4554w(String str) {
        Bundle bundle = new Bundle();
        if (!m4550s(str)) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                try {
                    if (strArrSplit.length == 2) {
                        bundle.putString(URLDecoder.decode(strArrSplit[0], "UTF-8"), URLDecoder.decode(strArrSplit[1], "UTF-8"));
                    } else if (strArrSplit.length == 1) {
                        bundle.putString(URLDecoder.decode(strArrSplit[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException unused) {
                    HashSet hashSet = AbstractC1117n.f3875a;
                }
            }
        }
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: x */
    public static void m4555x(Bundle bundle, JSONArray jSONArray) {
        if (jSONArray instanceof boolean[]) {
            bundle.putBooleanArray("media", (boolean[]) jSONArray);
            return;
        }
        if (jSONArray instanceof double[]) {
            bundle.putDoubleArray("media", (double[]) jSONArray);
            return;
        }
        if (jSONArray instanceof int[]) {
            bundle.putIntArray("media", (int[]) jSONArray);
        } else if (jSONArray instanceof long[]) {
            bundle.putLongArray("media", (long[]) jSONArray);
        } else {
            bundle.putString("media", jSONArray.toString());
        }
    }

    /* JADX INFO: renamed from: y */
    public static String m4556y(InputStream inputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            inputStreamReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[2048];
            while (true) {
                int i3 = inputStreamReader.read(cArr);
                if (i3 == -1) {
                    String string = sb.toString();
                    m4535d(bufferedInputStream);
                    m4535d(inputStreamReader);
                    return string;
                }
                sb.append(cArr, 0, i3);
            }
        } catch (Throwable th4) {
            th = th4;
            m4535d(bufferedInputStream);
            m4535d(inputStreamReader);
            throw th;
        }
    }

    /* JADX INFO: renamed from: z */
    public static HashMap m4557z(Parcel parcel) {
        int i3 = parcel.readInt();
        if (i3 < 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i4 = 0; i4 < i3; i4++) {
            map.put(parcel.readString(), parcel.readString());
        }
        return map;
    }
}
