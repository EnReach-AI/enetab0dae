package p024H0;

import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0947r;
import java.util.concurrent.Executors;
import p010C0.AbstractC0147a;
import p036L0.C0444d;
import p117m0.C1718m;

/* JADX INFO: renamed from: H0.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0265s {

    /* JADX INFO: renamed from: a */
    public final C0444d f684a;

    /* JADX INFO: renamed from: b */
    public final String f685b;

    static {
        Executors.newSingleThreadScheduledExecutor();
    }

    public C0265s(AbstractActivityC0947r abstractActivityC0947r, String str) {
        this.f685b = str;
        this.f684a = new C0444d(new C1718m(abstractActivityC0947r, str));
        try {
            PackageManager packageManager = abstractActivityC0947r.getPackageManager();
            if (packageManager != null) {
                packageManager.getPackageInfo("com.facebook.katana", 0);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m522a(String str) {
        if (AbstractC0147a.f354a.contains(C0265s.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
            bundle.putString("0_auth_logger_id", str);
            bundle.putString("3_method", "");
            bundle.putString("2_result", "");
            bundle.putString("5_error_message", "");
            bundle.putString("4_error_code", "");
            bundle.putString("6_extras", "");
            return bundle;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C0265s.class);
            return null;
        }
    }
}
