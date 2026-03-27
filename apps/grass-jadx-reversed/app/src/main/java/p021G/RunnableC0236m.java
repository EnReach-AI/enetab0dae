package p021G;

import android.os.Handler;
import androidx.fragment.app.C0928N;
import androidx.fragment.app.C0937h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p005B.AbstractC0032g;
import p026I.InterfaceC0293a;

/* JADX INFO: renamed from: G.m */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0236m implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f566e = 0;

    /* JADX INFO: renamed from: f */
    public Object f567f;

    /* JADX INFO: renamed from: g */
    public Object f568g;

    /* JADX INFO: renamed from: h */
    public Object f569h;

    public /* synthetic */ RunnableC0236m() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        switch (this.f566e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                try {
                    objCall = ((Callable) this.f567f).call();
                } catch (Exception unused) {
                    objCall = null;
                }
                ((Handler) this.f569h).post(new RunnableC0224a((C0230g) ((InterfaceC0293a) this.f568g), 1, objCall));
                break;
            default:
                List list = (List) this.f567f;
                C0928N c0928n = (C0928N) this.f568g;
                if (list.contains(c0928n)) {
                    list.remove(c0928n);
                    ((C0937h) this.f569h).getClass();
                    AbstractC0032g.m143a(c0928n.f3111c.f3210J, c0928n.f3109a);
                }
                break;
        }
    }

    public RunnableC0236m(C0937h c0937h, ArrayList arrayList, C0928N c0928n) {
        this.f569h = c0937h;
        this.f567f = arrayList;
        this.f568g = c0928n;
    }
}
