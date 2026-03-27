package androidx.activity;

import android.window.OnBackInvokedCallback;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p098g.LayoutInflaterFactory2C1382u;

/* JADX INFO: renamed from: androidx.activity.j */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0875j implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2612a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2613b;

    public /* synthetic */ C0875j(int i3, Object obj) {
        this.f2612a = i3;
        this.f2613b = obj;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        switch (this.f2612a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((Runnable) this.f2613b).run();
                break;
            default:
                ((LayoutInflaterFactory2C1382u) this.f2613b).m3374D();
                break;
        }
    }
}
