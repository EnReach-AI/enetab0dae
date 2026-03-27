package p021G;

import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p001A.C0009j;
import p026I.InterfaceC0293a;
import p128p.C1817k;

/* JADX INFO: renamed from: G.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0230g implements InterfaceC0293a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f550a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f551b;

    public /* synthetic */ C0230g(int i3, Object obj) {
        this.f550a = i3;
        this.f551b = obj;
    }

    @Override // p026I.InterfaceC0293a
    /* JADX INFO: renamed from: a */
    public final void mo474a(Object obj) {
        switch (this.f550a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0231h c0231h = (C0231h) obj;
                if (c0231h == null) {
                    c0231h = new C0231h(-3);
                }
                ((C0009j) this.f551b).m33K(c0231h);
                return;
            default:
                C0231h c0231h2 = (C0231h) obj;
                synchronized (AbstractC0232i.f556c) {
                    try {
                        C1817k c1817k = AbstractC0232i.f557d;
                        ArrayList arrayList = (ArrayList) c1817k.getOrDefault((String) this.f551b, null);
                        if (arrayList == null) {
                            return;
                        }
                        c1817k.remove((String) this.f551b);
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            ((InterfaceC0293a) arrayList.get(i3)).mo474a(c0231h2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
