package app.tauri.notification;

import android.content.Context;
import p119m2.AbstractC1766e;
import p142s2.AbstractC1892g;

/* JADX INFO: loaded from: classes.dex */
public final class AssetUtils {

    public static final class Companion {
        /* JADX INFO: renamed from: a */
        public static String m2662a(String str) {
            if (str == null) {
                return null;
            }
            if (AbstractC1892g.m4217j(str, "/")) {
                String strSubstring = str.substring(AbstractC1892g.m4223p(str, '/') + 1);
                AbstractC1766e.m3919d("substring(...)", strSubstring);
                return strSubstring;
            }
            if (!AbstractC1892g.m4217j(str, ".")) {
                return str;
            }
            String strSubstring2 = str.substring(0, AbstractC1892g.m4223p(str, '.'));
            AbstractC1766e.m3919d("substring(...)", strSubstring2);
            return strSubstring2;
        }

        /* JADX INFO: renamed from: b */
        public static int m2663b(Context context, String str, String str2) {
            AbstractC1766e.m3920e("context", context);
            return context.getResources().getIdentifier(str, str2, context.getPackageName());
        }
    }
}
