package p077a0;

import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.fragment.app.C0919E;
import androidx.fragment.app.C0946q;
import androidx.lifecycle.EnumC0978k;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p098g.AbstractActivityC1367f;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: a0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0842a implements InterfaceC0845d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2508a;

    /* JADX INFO: renamed from: b */
    public final Object f2509b;

    public /* synthetic */ C0842a(AbstractActivityC0947r abstractActivityC0947r, int i3) {
        this.f2508a = i3;
        this.f2509b = abstractActivityC0947r;
    }

    @Override // p077a0.InterfaceC0845d
    /* JADX INFO: renamed from: a */
    public final Bundle mo2169a() {
        AbstractActivityC0947r abstractActivityC0947r;
        switch (this.f2508a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f2509b));
                return bundle;
            case 1:
                Bundle bundle2 = new Bundle();
                do {
                    abstractActivityC0947r = (AbstractActivityC0947r) this.f2509b;
                } while (AbstractActivityC0947r.m2497m(((C0946q) abstractActivityC0947r.f3251s.f534f).f3249h));
                abstractActivityC0947r.f3252t.m2518d(EnumC0978k.ON_STOP);
                C0919E c0919eM2377M = ((C0946q) abstractActivityC0947r.f3251s.f534f).f3249h.m2377M();
                if (c0919eM2377M != null) {
                    bundle2.putParcelable("android:support:fragments", c0919eM2377M);
                }
                return bundle2;
            default:
                Bundle bundle3 = new Bundle();
                ((AbstractActivityC1367f) this.f2509b).m3342n().getClass();
                return bundle3;
        }
    }

    public C0842a(C0846e c0846e) {
        this.f2508a = 0;
        AbstractC1766e.m3920e("registry", c0846e);
        this.f2509b = new LinkedHashSet();
        c0846e.m2176f("androidx.savedstate.Restarter", this);
    }
}
