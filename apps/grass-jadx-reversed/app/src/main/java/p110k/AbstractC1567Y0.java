package p110k;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.C0875j;
import java.util.Objects;

/* JADX INFO: renamed from: k.Y0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1567Y0 {
    /* JADX INFO: renamed from: a */
    public static OnBackInvokedDispatcher m3638a(View view) {
        return view.findOnBackInvokedDispatcher();
    }

    /* JADX INFO: renamed from: b */
    public static OnBackInvokedCallback m3639b(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new C0875j(0, runnable);
    }

    /* JADX INFO: renamed from: c */
    public static void m3640c(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
    }

    /* JADX INFO: renamed from: d */
    public static void m3641d(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
