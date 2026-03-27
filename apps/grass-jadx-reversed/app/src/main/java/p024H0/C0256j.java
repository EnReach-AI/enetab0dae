package p024H0;

import android.os.Parcelable;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.fragment.app.C0946q;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: renamed from: H0.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0256j extends AbstractC0268v {
    public static final Parcelable.Creator<C0256j> CREATOR = new C0247a(2);

    /* JADX INFO: renamed from: g */
    public static ScheduledThreadPoolExecutor f642g;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: e */
    public final String mo485e() {
        return "device_auth";
    }

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: i */
    public final int mo488i(C0261o c0261o) {
        AbstractActivityC0947r abstractActivityC0947rM2490h = this.f688f.f671g.m2490h();
        if (abstractActivityC0947rM2490h == null || abstractActivityC0947rM2490h.isFinishing()) {
            return 1;
        }
        C0255i c0255i = new C0255i();
        c0255i.m2470R(((C0946q) abstractActivityC0947rM2490h.f3251s.f534f).f3249h, "login_with_facebook");
        c0255i.m499a0(c0261o);
        return 1;
    }
}
