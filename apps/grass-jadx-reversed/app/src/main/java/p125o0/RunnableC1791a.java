package p125o0;

import android.os.Bundle;
import com.facebook.AbstractC1117n;
import java.util.HashSet;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p010C0.AbstractC0147a;
import p019F0.C0221e;
import p117m0.C1718m;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: o0.a */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1791a implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f6180e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ String f6181f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Bundle f6182g;

    public /* synthetic */ RunnableC1791a(String str, Bundle bundle, int i3) {
        this.f6180e = i3;
        this.f6181f = str;
        this.f6182g = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = this.f6182g;
        String str = this.f6181f;
        switch (this.f6180e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (!AbstractC0147a.f354a.contains(this)) {
                    try {
                        HashSet hashSet = AbstractC1117n.f3875a;
                        AbstractC2069g.m4584h();
                        ((C1718m) C0221e.m440y(AbstractC1117n.f3882h).f534f).m3815d(bundle, str);
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, this);
                        return;
                    }
                    break;
                }
                break;
            default:
                if (!AbstractC0147a.f354a.contains(this)) {
                    try {
                        HashSet hashSet2 = AbstractC1117n.f3875a;
                        AbstractC2069g.m4584h();
                        ((C1718m) C0221e.m440y(AbstractC1117n.f3882h).f534f).m3815d(bundle, str);
                    } catch (Throwable th2) {
                        AbstractC0147a.m295a(th2, this);
                    }
                    break;
                }
                break;
        }
    }
}
