package p162y;

import android.app.AppOpsManager;
import android.content.Context;

/* JADX INFO: renamed from: y.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2025d {
    /* JADX INFO: renamed from: a */
    public static <T> T m4473a(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    /* JADX INFO: renamed from: b */
    public static int m4474b(AppOpsManager appOpsManager, String str, String str2) {
        return appOpsManager.noteProxyOp(str, str2);
    }

    /* JADX INFO: renamed from: c */
    public static int m4475c(AppOpsManager appOpsManager, String str, String str2) {
        return appOpsManager.noteProxyOpNoThrow(str, str2);
    }

    /* JADX INFO: renamed from: d */
    public static String m4476d(String str) {
        return AppOpsManager.permissionToOp(str);
    }
}
