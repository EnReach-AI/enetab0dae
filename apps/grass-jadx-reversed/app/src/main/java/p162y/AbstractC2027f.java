package p162y;

import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: renamed from: y.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2027f {
    /* JADX INFO: renamed from: a */
    public static IBinder m4480a(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    /* JADX INFO: renamed from: b */
    public static void m4481b(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
