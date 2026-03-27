package p162y;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: renamed from: y.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2028g {
    /* JADX INFO: renamed from: a */
    public static Intent m4482a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4483b(Activity activity, Intent intent) {
        return activity.navigateUpTo(intent);
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4484c(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }
}
