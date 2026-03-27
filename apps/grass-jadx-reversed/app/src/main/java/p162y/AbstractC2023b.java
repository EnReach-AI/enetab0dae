package p162y;

import android.app.Activity;
import android.app.SharedElementCallback;

/* JADX INFO: renamed from: y.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2023b {
    /* JADX INFO: renamed from: a */
    public static void m4470a(Object obj) {
        ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
    }

    /* JADX INFO: renamed from: b */
    public static void m4471b(Activity activity, String[] strArr, int i3) {
        activity.requestPermissions(strArr, i3);
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4472c(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
