package app.tauri;

import android.text.TextUtils;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class Logger {

    public static final class Companion {
        /* JADX INFO: renamed from: a */
        public static void m2656a(String str, String str2) {
            AbstractC1766e.m3920e("tag", str);
            AbstractC1766e.m3920e("message", str2);
        }

        /* JADX INFO: renamed from: b */
        public static String m2657b(String... strArr) {
            if (!(!(strArr.length == 0))) {
                return "Tauri";
            }
            return "Tauri/" + TextUtils.join("/", strArr);
        }
    }
}
