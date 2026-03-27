package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import p036L0.C0444d;

/* JADX INFO: renamed from: androidx.lifecycle.C */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentC0958C extends Fragment {

    /* JADX INFO: renamed from: f */
    public static final /* synthetic */ int f3283f = 0;

    /* JADX INFO: renamed from: e */
    public C0444d f3284e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m2502a(Activity activity, EnumC0978k enumC0978k) {
        if (activity instanceof InterfaceC0984q) {
            C0986s c0986sMo2199d = ((InterfaceC0984q) activity).mo2199d();
            if (c0986sMo2199d instanceof C0986s) {
                c0986sMo2199d.m2518d(enumC0978k);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m2503c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            C0957B.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new FragmentC0958C(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2504b(EnumC0978k enumC0978k) {
        if (Build.VERSION.SDK_INT < 29) {
            m2502a(getActivity(), enumC0978k);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m2504b(EnumC0978k.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        m2504b(EnumC0978k.ON_DESTROY);
        this.f3284e = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        m2504b(EnumC0978k.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        C0444d c0444d = this.f3284e;
        if (c0444d != null) {
            ((C0956A) c0444d.f1085e).m2501a();
        }
        m2504b(EnumC0978k.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        C0444d c0444d = this.f3284e;
        if (c0444d != null) {
            C0956A c0956a = (C0956A) c0444d.f1085e;
            int i3 = c0956a.f3275e + 1;
            c0956a.f3275e = i3;
            if (i3 == 1 && c0956a.f3278h) {
                c0956a.f3280j.m2518d(EnumC0978k.ON_START);
                c0956a.f3278h = false;
            }
        }
        m2504b(EnumC0978k.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        m2504b(EnumC0978k.ON_STOP);
    }
}
