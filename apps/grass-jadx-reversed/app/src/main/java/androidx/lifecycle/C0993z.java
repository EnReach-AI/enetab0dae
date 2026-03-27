package androidx.lifecycle;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: renamed from: androidx.lifecycle.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0993z extends AbstractC0972e {
    final /* synthetic */ C0956A this$0;

    public C0993z(C0956A c0956a) {
        this.this$0 = c0956a;
    }

    @Override // androidx.lifecycle.AbstractC0972e, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 29) {
            int i3 = FragmentC0958C.f3283f;
            ((FragmentC0958C) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag")).f3284e = this.this$0.f3282l;
        }
    }

    @Override // androidx.lifecycle.AbstractC0972e, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        C0956A c0956a = this.this$0;
        int i3 = c0956a.f3276f - 1;
        c0956a.f3276f = i3;
        if (i3 == 0) {
            c0956a.f3279i.postDelayed(c0956a.f3281k, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.registerActivityLifecycleCallbacks(new C0992y(this));
    }

    @Override // androidx.lifecycle.AbstractC0972e, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        C0956A c0956a = this.this$0;
        int i3 = c0956a.f3275e - 1;
        c0956a.f3275e = i3;
        if (i3 == 0 && c0956a.f3277g) {
            c0956a.f3280j.m2518d(EnumC0978k.ON_STOP);
            c0956a.f3278h = true;
        }
    }
}
