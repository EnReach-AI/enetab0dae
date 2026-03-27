package p165z;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: renamed from: z.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2045a {
    /* JADX INFO: renamed from: a */
    public static void m4512a(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
    }

    /* JADX INFO: renamed from: b */
    public static void m4513b(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
