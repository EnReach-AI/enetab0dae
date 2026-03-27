package p162y;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

/* JADX INFO: renamed from: y.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2022a {
    /* JADX INFO: renamed from: a */
    public static void m4467a(Activity activity) {
        activity.finishAffinity();
    }

    /* JADX INFO: renamed from: b */
    public static void m4468b(Activity activity, Intent intent, int i3, Bundle bundle) {
        activity.startActivityForResult(intent, i3, bundle);
    }

    /* JADX INFO: renamed from: c */
    public static void m4469c(Activity activity, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
    }
}
