package p141s0;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p010C0.AbstractC0147a;
import p166z0.AbstractC2056E;

/* JADX INFO: renamed from: s0.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1875e {
    /* JADX INFO: renamed from: a */
    public static String m4195a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b3 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b3)));
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: b */
    public static View m4196b(Activity activity) {
        if (AbstractC0147a.f354a.contains(AbstractC1875e.class) || activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            return window.getDecorView().getRootView();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1875e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4197c() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith("generic") && !str.startsWith("unknown")) {
            String str2 = Build.MODEL;
            if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    public static double m4198d(String str) {
        try {
            Matcher matcher = Pattern.compile("[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?", 8).matcher(str);
            if (!matcher.find()) {
                return 0.0d;
            }
            String strGroup = matcher.group(0);
            Locale localeM4544m = AbstractC2056E.m4544m();
            if (localeM4544m == null) {
                localeM4544m = Locale.getDefault();
            }
            return NumberFormat.getNumberInstance(localeM4544m).parse(strGroup).doubleValue();
        } catch (ParseException unused) {
            return 0.0d;
        }
    }
}
