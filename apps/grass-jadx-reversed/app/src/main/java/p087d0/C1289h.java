package p087d0;

import android.view.View;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: d0.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1289h extends AbstractC1294m {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4604a;

    /* JADX INFO: renamed from: b */
    public Object f4605b;

    public /* synthetic */ C1289h() {
        this.f4604a = 2;
    }

    @Override // p087d0.AbstractC1294m, p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: b */
    public void mo3257b() {
        switch (this.f4604a) {
            case 2:
                C1282a c1282a = (C1282a) this.f4605b;
                if (!c1282a.f4585D) {
                    c1282a.m3265D();
                    c1282a.f4585D = true;
                }
                break;
        }
    }

    @Override // p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: d */
    public final void mo3252d(AbstractC1293l abstractC1293l) {
        switch (this.f4604a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C1300s c1300s = AbstractC1299r.f4645a;
                c1300s.mo1940h((View) this.f4605b, 1.0f);
                c1300s.getClass();
                abstractC1293l.m3274u(this);
                break;
            case 1:
                ((AbstractC1293l) this.f4605b).mo3246w();
                abstractC1293l.m3274u(this);
                break;
            default:
                C1282a c1282a = (C1282a) this.f4605b;
                int i3 = c1282a.f4584C - 1;
                c1282a.f4584C = i3;
                if (i3 == 0) {
                    c1282a.f4585D = false;
                    c1282a.m3270l();
                }
                abstractC1293l.m3274u(this);
                break;
        }
    }

    public /* synthetic */ C1289h(int i3, Object obj) {
        this.f4604a = i3;
        this.f4605b = obj;
    }
}
