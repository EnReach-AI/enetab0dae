package p141s0;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import p010C0.AbstractC0147a;
import p015D2.C0181e;
import p033K0.AbstractC0405c;
import p110k.C1605n;
import p117m0.AbstractC1715j;
import p117m0.C1718m;
import p166z0.C2085w;

/* JADX INFO: renamed from: s0.o */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1885o {

    /* JADX INFO: renamed from: a */
    public static final long[] f6630a = {300000, 900000, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    /* JADX INFO: renamed from: a */
    public static final String m4211a(String str) throws IOException {
        int i3;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)), 1024);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            do {
                i3 = bufferedInputStream.read(bArr);
                if (i3 > 0) {
                    messageDigest.update(bArr, 0, i3);
                }
            } while (i3 != -1);
            String string = new BigInteger(1, messageDigest.digest()).toString(16);
            bufferedInputStream.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m4212b(Context context) {
        if (AbstractC0147a.f354a.contains(AbstractC1885o.class)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String str = "PCKGCHKSUM;" + packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            String string = sharedPreferences.getString(str, null);
            if (string != null && string.length() == 32) {
                return string;
            }
            String strM4211a = m4211a(packageManager.getApplicationInfo(context.getPackageName(), 0).sourceDir);
            sharedPreferences.edit().putString(str, strM4211a).apply();
            return strM4211a;
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1885o.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4213c(Context context, String str, String str2) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1885o.class)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("fb_mobile_launch_source", "Unclassified");
            bundle.putString("fb_mobile_pckg_fp", m4212b(context));
            bundle.putString("fb_mobile_app_cert_hash", AbstractC0405c.m886f(context));
            C1718m c1718m = new C1718m(str, str2);
            HashSet hashSet = AbstractC1117n.f3875a;
            if (AbstractC1103F.m2866c()) {
                c1718m.m3815d(bundle, "fb_mobile_activate_app");
            }
            if (C1718m.m3810a() == 2 || set.contains(c1718m)) {
                return;
            }
            try {
                AbstractC1715j.m3795d(1);
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, c1718m);
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1885o.class);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m4214d() {
        if (AbstractC0147a.f354a.contains(AbstractC1885o.class)) {
            return;
        }
        try {
            HashMap map = C2085w.f7377b;
            AbstractC1117n.m2896f();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1885o.class);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m4215e(String str, C1605n c1605n, String str2) {
        Long l3;
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1885o.class) || c1605n == null) {
            return;
        }
        try {
            Long l4 = (Long) c1605n.f5696d;
            long jLongValue = (l4 == null ? 0L : l4.longValue()) - ((Long) c1605n.f5695c).longValue();
            Long lValueOf = Long.valueOf(jLongValue);
            if (jLongValue < 0) {
                lValueOf = 0L;
                m4214d();
            }
            Long l5 = (Long) c1605n.f5694b;
            long jLongValue2 = (l5 == null || (l3 = (Long) c1605n.f5695c) == null) ? 0L : l3.longValue() - l5.longValue();
            Long lValueOf2 = Long.valueOf(jLongValue2);
            if (jLongValue2 < 0) {
                m4214d();
                lValueOf2 = 0L;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("fb_mobile_app_interruptions", c1605n.f5693a);
            Locale locale = Locale.ROOT;
            long jLongValue3 = lValueOf.longValue();
            int i3 = 0;
            if (!set.contains(AbstractC1885o.class)) {
                int i4 = 0;
                while (true) {
                    try {
                        long[] jArr = f6630a;
                        if (i4 >= 19 || jArr[i4] >= jLongValue3) {
                            break;
                        } else {
                            i4++;
                        }
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, AbstractC1885o.class);
                    }
                }
                i3 = i4;
            }
            bundle.putString("fb_mobile_time_between_sessions", "session_quanta_" + i3);
            C0181e c0181e = (C0181e) c1605n.f5697e;
            bundle.putString("fb_mobile_launch_source", c0181e != null ? c0181e.toString() : "Unclassified");
            bundle.putLong("_logTime", ((Long) c1605n.f5695c).longValue() / 1000);
            C1718m c1718m = new C1718m(str, str2);
            double dLongValue = lValueOf2.longValue() / 1000.0d;
            HashSet hashSet = AbstractC1117n.f3875a;
            if (!AbstractC1103F.m2866c() || AbstractC0147a.f354a.contains(c1718m)) {
                return;
            }
            try {
                c1718m.m3816e("fb_mobile_deactivate_app", Double.valueOf(dLongValue), bundle, false, AbstractC1874d.m4193b());
            } catch (Throwable th2) {
                AbstractC0147a.m295a(th2, c1718m);
            }
        } catch (Throwable th3) {
            AbstractC0147a.m295a(th3, AbstractC1885o.class);
        }
    }
}
