package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: renamed from: androidx.lifecycle.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0980m extends AbstractC0972e {
    @Override // androidx.lifecycle.AbstractC0972e, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        FragmentC0958C.m2503c(activity);
    }

    @Override // androidx.lifecycle.AbstractC0972e, android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // androidx.lifecycle.AbstractC0972e, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
