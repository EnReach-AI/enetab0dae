package p098g;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.C0875j;
import java.util.Objects;
import p032K.AbstractC0388f;

/* JADX INFO: renamed from: g.p */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1377p {
    /* JADX INFO: renamed from: a */
    public static OnBackInvokedDispatcher m3362a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    /* JADX INFO: renamed from: b */
    public static OnBackInvokedCallback m3363b(Object obj, LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u) {
        Objects.requireNonNull(layoutInflaterFactory2C1382u);
        C0875j c0875j = new C0875j(1, layoutInflaterFactory2C1382u);
        AbstractC0388f.m859g(obj).registerOnBackInvokedCallback(1000000, c0875j);
        return c0875j;
    }

    /* JADX INFO: renamed from: c */
    public static void m3364c(Object obj, Object obj2) {
        AbstractC0388f.m859g(obj).unregisterOnBackInvokedCallback(AbstractC0388f.m856d(obj2));
    }
}
