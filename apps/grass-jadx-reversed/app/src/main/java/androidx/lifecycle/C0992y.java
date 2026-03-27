package androidx.lifecycle;

import android.app.Activity;

/* JADX INFO: renamed from: androidx.lifecycle.y */
/* JADX INFO: loaded from: classes.dex */
public final class C0992y extends AbstractC0972e {
    final /* synthetic */ C0993z this$1;

    public C0992y(C0993z c0993z) {
        this.this$1 = c0993z;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        this.this$1.this$0.m2501a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        C0956A c0956a = this.this$1.this$0;
        int i3 = c0956a.f3275e + 1;
        c0956a.f3275e = i3;
        if (i3 == 1 && c0956a.f3278h) {
            c0956a.f3280j.m2518d(EnumC0978k.ON_START);
            c0956a.f3278h = false;
        }
    }
}
