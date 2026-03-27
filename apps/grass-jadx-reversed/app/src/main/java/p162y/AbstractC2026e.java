package p162y;

import android.app.AppOpsManager;
import android.content.Context;

/* JADX INFO: renamed from: y.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2026e {
    /* JADX INFO: renamed from: a */
    public static int m4477a(AppOpsManager appOpsManager, String str, int i3, String str2) {
        if (appOpsManager == null) {
            return 1;
        }
        return appOpsManager.checkOpNoThrow(str, i3, str2);
    }

    /* JADX INFO: renamed from: b */
    public static String m4478b(Context context) {
        return context.getOpPackageName();
    }

    /* JADX INFO: renamed from: c */
    public static AppOpsManager m4479c(Context context) {
        return (AppOpsManager) context.getSystemService(AppOpsManager.class);
    }
}
