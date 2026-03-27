package androidx.activity;

import android.app.Activity;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: renamed from: androidx.activity.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0871f {
    /* JADX INFO: renamed from: a */
    public static OnBackInvokedDispatcher m2195a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }
}
