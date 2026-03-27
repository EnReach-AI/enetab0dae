package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.Collections;
import java.util.List;
import p081b0.C1003a;
import p081b0.InterfaceC1004b;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements InterfaceC1004b {
    @Override // p081b0.InterfaceC1004b
    /* JADX INFO: renamed from: a */
    public final List mo2335a() {
        return Collections.emptyList();
    }

    @Override // p081b0.InterfaceC1004b
    /* JADX INFO: renamed from: b */
    public final Object mo2336b(Context context) {
        if (!C1003a.m2693c(context).f3576b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        if (!AbstractC0981n.f3324a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new C0980m());
        }
        C0956A c0956a = C0956A.f3274m;
        c0956a.getClass();
        c0956a.f3279i = new Handler();
        c0956a.f3280j.m2518d(EnumC0978k.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new C0993z(c0956a));
        return c0956a;
    }
}
