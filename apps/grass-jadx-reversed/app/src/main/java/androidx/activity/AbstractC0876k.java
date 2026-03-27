package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* JADX INFO: renamed from: androidx.activity.k */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0876k {
    /* JADX INFO: renamed from: a */
    public static OnBackInvokedCallback m2207a(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new C0875j(0, runnable);
    }

    /* JADX INFO: renamed from: b */
    public static void m2208b(Object obj, int i3, Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i3, (OnBackInvokedCallback) obj2);
    }

    /* JADX INFO: renamed from: c */
    public static void m2209c(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
