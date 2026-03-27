package p162y;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: renamed from: y.q */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2038q {
    /* JADX INFO: renamed from: a */
    public static void m4498a(Object obj, Intent intent, Bundle bundle) {
        RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
    }

    /* JADX INFO: renamed from: b */
    public static Bundle m4499b(Intent intent) {
        return RemoteInput.getResultsFromIntent(intent);
    }
}
