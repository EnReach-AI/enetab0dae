package androidx.fragment.app;

import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: androidx.fragment.app.M */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0927M implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f3106e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C0928N f3107f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ C0937h f3108g;

    public /* synthetic */ RunnableC0927M(C0937h c0937h, C0928N c0928n, int i3) {
        this.f3106e = i3;
        this.f3108g = c0937h;
        this.f3107f = c0928n;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3106e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ArrayList arrayList = this.f3108g.f3163b;
                C0928N c0928n = this.f3107f;
                if (arrayList.contains(c0928n)) {
                    AbstractC0032g.m143a(c0928n.f3111c.f3210J, c0928n.f3109a);
                }
                break;
            default:
                C0937h c0937h = this.f3108g;
                ArrayList arrayList2 = c0937h.f3163b;
                C0928N c0928n2 = this.f3107f;
                arrayList2.remove(c0928n2);
                c0937h.f3164c.remove(c0928n2);
                break;
        }
    }
}
