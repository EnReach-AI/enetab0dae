package p033K0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import com.facebook.AbstractC1117n;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import p002A0.C0021c;
import p002A0.EnumC0020b;
import p008B2.C0084Y;
import p008B2.C0090c;
import p010C0.AbstractC0147a;
import p011C2.C0160m;
import p019F0.C0222f;
import p036L0.C0445e;
import p036L0.C0447g;
import p036L0.C0449i;
import p039M0.EnumC0511z;
import p043N1.EnumC0559a;
import p043N1.InterfaceC0562d;
import p051Q1.C0601b;
import p069X0.AbstractC0721l;
import p092e1.InterfaceC1338c;
import p118m1.AbstractC1745j;
import p161x2.InterfaceC2012a;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: K0.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0405c implements InterfaceC0562d, InterfaceC1338c {
    /* JADX INFO: renamed from: a */
    public static final C0090c m882a() {
        return new C0090c(C0160m.f390a, 0);
    }

    /* JADX INFO: renamed from: b */
    public static int m883b(boolean[] zArr, int i3, int[] iArr, boolean z3) {
        int i4 = 0;
        for (int i5 : iArr) {
            int i6 = 0;
            while (i6 < i5) {
                zArr[i3] = z3;
                i6++;
                i3++;
            }
            i4 += i5;
            z3 = !z3;
        }
        return i4;
    }

    /* JADX INFO: renamed from: c */
    public static C0021c m884c(Throwable th, EnumC0020b enumC0020b) {
        String str;
        C0021c c0021c = new C0021c();
        c0021c.f66b = enumC0020b;
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        Context context = AbstractC1117n.f3882h;
        String string = null;
        Throwable th2 = null;
        if (context == null) {
            str = null;
        } else {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                str = null;
            }
        }
        c0021c.f68d = str;
        c0021c.f69e = th == null ? null : th.getCause() == null ? th.toString() : th.getCause().toString();
        if (th != null) {
            JSONArray jSONArray = new JSONArray();
            while (th != null && th != th2) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    jSONArray.put(stackTraceElement.toString());
                }
                th2 = th;
                th = th.getCause();
            }
            string = jSONArray.toString();
        }
        c0021c.f70f = string;
        Long lValueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        c0021c.f71g = lValueOf;
        StringBuffer stringBuffer = new StringBuffer();
        int iOrdinal = enumC0020b.ordinal();
        stringBuffer.append(iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "Unknown" : "thread_check_log_" : "shield_log_" : "crash_log_" : "analysis_log_");
        stringBuffer.append(lValueOf.toString());
        stringBuffer.append(".json");
        c0021c.f65a = stringBuffer.toString();
        return c0021c;
    }

    /* JADX INFO: renamed from: d */
    public static String m885d(AbstractC0721l abstractC0721l) {
        String str;
        String str2;
        String name = abstractC0721l.f2036e.getName();
        if (name.startsWith("java.time.")) {
            if (name.indexOf(46, 10) >= 0) {
                return null;
            }
            str = "Java 8 date/time";
            str2 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
        } else {
            if (!name.startsWith("org.joda.time.")) {
                return null;
            }
            str = "Joda date/time";
            str2 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
        }
        return str + " type " + AbstractC1745j.m3895r(abstractC0721l) + " not supported by default: add Module \"" + str2 + "\" to enable handling";
    }

    /* JADX INFO: renamed from: f */
    public static String m886f(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            StringBuilder sb = new StringBuilder();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            for (Signature signature : signatureArr) {
                messageDigest.update(signature.toByteArray());
                sb.append(Base64.encodeToString(messageDigest.digest(), 0));
                sb.append(":");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            return sb.toString();
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: h */
    public static Object m887h(AbstractC0721l abstractC0721l) {
        Class cls = abstractC0721l.f2036e;
        Class clsM3871A = AbstractC1745j.m3871A(cls);
        if (clsM3871A == null) {
            if (abstractC0721l.mo1887v() || abstractC0721l.mo1629b()) {
                return EnumC0511z.f1184g;
            }
            if (cls == String.class) {
                return "";
            }
            if (abstractC0721l.m1891z(Date.class)) {
                return new Date(0L);
            }
            if (!abstractC0721l.m1891z(Calendar.class)) {
                return null;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0L);
            return gregorianCalendar;
        }
        if (clsM3871A == Integer.TYPE) {
            return 0;
        }
        if (clsM3871A == Long.TYPE) {
            return 0L;
        }
        if (clsM3871A == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (clsM3871A == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (clsM3871A == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (clsM3871A == Byte.TYPE) {
            return (byte) 0;
        }
        if (clsM3871A == Short.TYPE) {
            return (short) 0;
        }
        if (clsM3871A == Character.TYPE) {
            return (char) 0;
        }
        throw new IllegalArgumentException("Class " + clsM3871A.getName() + " is not a primitive type");
    }

    /* JADX INFO: renamed from: j */
    public static final InterfaceC2012a m888j(InterfaceC2012a interfaceC2012a) {
        return interfaceC2012a.mo221c().mo234f() ? interfaceC2012a : new C0084Y(interfaceC2012a);
    }

    /* JADX INFO: renamed from: k */
    public static C0021c m889k(File file) {
        C0021c c0021c = new C0021c();
        String name = file.getName();
        c0021c.f65a = name;
        c0021c.f66b = name.startsWith("crash_log_") ? EnumC0020b.f61g : name.startsWith("shield_log_") ? EnumC0020b.f62h : name.startsWith("thread_check_log_") ? EnumC0020b.f63i : name.startsWith("analysis_log_") ? EnumC0020b.f60f : EnumC0020b.f59e;
        JSONObject jSONObjectM901k = AbstractC0406d.m901k(name);
        if (jSONObjectM901k != null) {
            c0021c.f71g = Long.valueOf(jSONObjectM901k.optLong("timestamp", 0L));
            c0021c.f68d = jSONObjectM901k.optString("app_version", null);
            c0021c.f69e = jSONObjectM901k.optString("reason", null);
            c0021c.f70f = jSONObjectM901k.optString("callstack", null);
            c0021c.f67c = jSONObjectM901k.optJSONArray("feature_names");
        }
        return c0021c;
    }

    /* JADX INFO: renamed from: l */
    public static JSONObject m890l(C0445e c0445e, C0222f c0222f) {
        if (AbstractC0147a.f354a.contains(AbstractC0405c.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : c0445e.f1088e.keySet()) {
                jSONObject.put(str, m892n(c0445e.f1088e.get(str), c0222f));
            }
            return jSONObject;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC0405c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: m */
    public static JSONObject m891m(C0447g c0447g, C0222f c0222f) {
        if (AbstractC0147a.f354a.contains(AbstractC0405c.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : c0447g.f1088e.keySet()) {
                jSONObject.put(str, m892n(c0447g.f1088e.get(str), c0222f));
            }
            return jSONObject;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC0405c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: n */
    public static Object m892n(Object obj, C0222f c0222f) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC0405c.class)) {
            return null;
        }
        try {
            if (obj == null) {
                return JSONObject.NULL;
            }
            if (!(obj instanceof String) && !(obj instanceof Boolean) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long)) {
                if (obj instanceof C0449i) {
                    return C0222f.m463e((C0449i) obj);
                }
                if (obj instanceof C0447g) {
                    return m891m((C0447g) obj, c0222f);
                }
                if (!(obj instanceof List)) {
                    throw new IllegalArgumentException("Invalid object found for JSON serialization: " + obj.toString());
                }
                List list = (List) obj;
                if (set.contains(AbstractC0405c.class)) {
                    return null;
                }
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(m892n(it.next(), c0222f));
                    }
                    return jSONArray;
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, AbstractC0405c.class);
                    return null;
                }
            }
            return obj;
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC0405c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public abstract boolean[] mo893e(String str);

    /* JADX INFO: renamed from: g */
    public int mo894g() {
        return 10;
    }

    @Override // p043N1.InterfaceC0562d
    /* JADX INFO: renamed from: i */
    public C0601b mo434i(String str, int i3, EnumMap enumMap) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        int iMo894g = mo894g();
        EnumC0559a enumC0559a = EnumC0559a.f1358j;
        if (enumMap.containsKey(enumC0559a)) {
            iMo894g = Integer.parseInt(enumMap.get(enumC0559a).toString());
        }
        boolean[] zArrMo893e = mo893e(str);
        int length = zArrMo893e.length;
        int i4 = iMo894g + length;
        int iMax = Math.max(200, i4);
        int iMax2 = Math.max(1, 200);
        int i5 = iMax / i4;
        int i6 = (iMax - (length * i5)) / 2;
        C0601b c0601b = new C0601b(iMax, iMax2);
        int i7 = 0;
        while (i7 < length) {
            if (zArrMo893e[i7]) {
                c0601b.m1379c(i6, 0, i5, iMax2);
            }
            i7++;
            i6 += i5;
        }
        return c0601b;
    }
}
