package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.InterfaceC0967L;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p084c.InterfaceC1079b;
import p098g.AbstractActivityC1367f;
import p098g.AbstractC1371j;

/* JADX INFO: renamed from: androidx.fragment.app.p */
/* JADX INFO: loaded from: classes.dex */
public final class C0945p implements InterfaceC1079b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3244a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractActivityC0947r f3245b;

    public /* synthetic */ C0945p(AbstractActivityC0947r abstractActivityC0947r, int i3) {
        this.f3244a = i3;
        this.f3245b = abstractActivityC0947r;
    }

    @Override // p084c.InterfaceC1079b
    /* JADX INFO: renamed from: a */
    public final void mo2193a() {
        switch (this.f3244a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractActivityC0947r abstractActivityC0947r = this.f3245b;
                C0946q c0946q = (C0946q) abstractActivityC0947r.f3251s.f534f;
                c0946q.f3249h.m2386b(c0946q, c0946q, null);
                Bundle bundleM2174d = abstractActivityC0947r.f2601i.f2519b.m2174d("android:support:fragments");
                if (bundleM2174d != null) {
                    Parcelable parcelable = bundleM2174d.getParcelable("android:support:fragments");
                    C0946q c0946q2 = (C0946q) abstractActivityC0947r.f3251s.f534f;
                    if (!(c0946q2 instanceof InterfaceC0967L)) {
                        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
                    }
                    c0946q2.f3249h.m2376L(parcelable);
                    return;
                }
                return;
            default:
                AbstractActivityC1367f abstractActivityC1367f = (AbstractActivityC1367f) this.f3245b;
                AbstractC1371j abstractC1371jM3342n = abstractActivityC1367f.m3342n();
                abstractC1371jM3342n.mo3349a();
                abstractActivityC1367f.f2601i.f2519b.m2174d("androidx:appcompat");
                abstractC1371jM3342n.mo3351f();
                return;
        }
    }
}
