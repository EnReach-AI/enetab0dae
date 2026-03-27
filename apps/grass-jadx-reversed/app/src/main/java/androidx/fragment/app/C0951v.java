package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.C0881b;
import androidx.activity.result.InterfaceC0882c;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p166z0.C2071i;

/* JADX INFO: renamed from: androidx.fragment.app.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0951v implements InterfaceC0882c {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f3264e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C0918D f3265f;

    public /* synthetic */ C0951v(C0918D c0918d, int i3) {
        this.f3264e = i3;
        this.f3265f = c0918d;
    }

    @Override // androidx.activity.result.InterfaceC0882c
    /* JADX INFO: renamed from: j */
    public final void mo449j(Object obj) {
        switch (this.f3264e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0881b c0881b = (C0881b) obj;
                C0918D c0918d = this.f3265f;
                C0915A c0915a = (C0915A) c0918d.f3051w.pollFirst();
                if (c0915a != null) {
                    C2071i c2071i = c0918d.f3031c;
                    String str = c0915a.f3017e;
                    AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM4597f = c2071i.m4597f(str);
                    if (abstractComponentCallbacksC0944oM4597f != null) {
                        abstractComponentCallbacksC0944oM4597f.mo517o(c0915a.f3018f, c0881b.f2627e, c0881b.f2628f);
                    } else {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                    }
                } else {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                }
                break;
            default:
                C0881b c0881b2 = (C0881b) obj;
                C0918D c0918d2 = this.f3265f;
                C0915A c0915a2 = (C0915A) c0918d2.f3051w.pollFirst();
                if (c0915a2 != null) {
                    C2071i c2071i2 = c0918d2.f3031c;
                    String str2 = c0915a2.f3017e;
                    AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM4597f2 = c2071i2.m4597f(str2);
                    if (abstractComponentCallbacksC0944oM4597f2 != null) {
                        abstractComponentCallbacksC0944oM4597f2.mo517o(c0915a2.f3018f, c0881b2.f2627e, c0881b2.f2628f);
                    } else {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str2);
                    }
                } else {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                }
                break;
        }
    }
}
