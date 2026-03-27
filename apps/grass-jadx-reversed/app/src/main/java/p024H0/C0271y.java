package p024H0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.fragment.app.C0946q;
import com.facebook.AbstractC1117n;
import com.facebook.EnumC1108e;
import java.util.HashSet;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p166z0.AbstractC2069g;
import p166z0.C2070h;
import p166z0.DialogC2062K;

/* JADX INFO: renamed from: H0.y */
/* JADX INFO: loaded from: classes.dex */
public final class C0271y extends AbstractC0270x {
    public static final Parcelable.Creator<C0271y> CREATOR = new C0247a(9);

    /* JADX INFO: renamed from: h */
    public DialogC2062K f690h;

    /* JADX INFO: renamed from: i */
    public String f691i;

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: b */
    public final void mo504b() {
        DialogC2062K dialogC2062K = this.f690h;
        if (dialogC2062K != null) {
            dialogC2062K.cancel();
            this.f690h = null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: e */
    public final String mo485e() {
        return "web_view";
    }

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: i */
    public final int mo488i(C0261o c0261o) {
        Bundle bundleM527j = m527j(c0261o);
        C0009j c0009j = new C0009j(this, c0261o, 8, false);
        String strM508f = C0263q.m508f();
        this.f691i = strM508f;
        m524a("e2e", strM508f);
        AbstractActivityC0947r abstractActivityC0947rM2490h = this.f688f.f671g.m2490h();
        boolean zHasSystemFeature = abstractActivityC0947rM2490h.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        String str = c0261o.f656h;
        if (str == null) {
            AbstractC2069g.m4582f("context", abstractActivityC0947rM2490h);
            HashSet hashSet = AbstractC1117n.f3875a;
            synchronized (AbstractC1117n.class) {
                AbstractC1117n.m2900j(abstractActivityC0947rM2490h);
            }
            AbstractC2069g.m4584h();
            str = AbstractC1117n.f3877c;
        }
        AbstractC2069g.m4583g(str, "applicationId");
        String str2 = this.f691i;
        bundleM527j.putString("redirect_uri", zHasSystemFeature ? "fbconnect://chrome_os_success" : "fbconnect://success");
        bundleM527j.putString("client_id", str);
        bundleM527j.putString("e2e", str2);
        bundleM527j.putString("response_type", "token,signed_request,graph_domain");
        bundleM527j.putString("return_scopes", "true");
        bundleM527j.putString("auth_type", c0261o.f660l);
        bundleM527j.putString("login_behavior", AbstractC0032g.m163u(c0261o.f653e));
        this.f690h = DialogC2062K.m4562c(abstractActivityC0947rM2490h, "oauth", bundleM527j, c0009j);
        C2070h c2070h = new C2070h();
        c2070h.m2486N();
        c2070h.f7309m0 = this.f690h;
        c2070h.m2470R(((C0946q) abstractActivityC0947rM2490h.f3251s.f534f).f3249h, "FacebookDialogFragment");
        return 1;
    }

    @Override // p024H0.AbstractC0270x
    /* JADX INFO: renamed from: k */
    public final EnumC1108e mo489k() {
        return EnumC1108e.WEB_VIEW;
    }

    @Override // p024H0.AbstractC0268v, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f691i);
    }
}
