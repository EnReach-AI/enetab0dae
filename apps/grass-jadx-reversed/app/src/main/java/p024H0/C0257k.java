package p024H0;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import androidx.fragment.app.AbstractActivityC0947r;
import com.facebook.AbstractC1117n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import p010C0.AbstractC0147a;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2072j;
import p166z0.AbstractC2087y;
import p166z0.C2086x;

/* JADX INFO: renamed from: H0.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0257k extends AbstractC0269w {
    public static final Parcelable.Creator<C0257k> CREATOR = new C0247a(3);

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: e */
    public final String mo485e() {
        return "fb_lite_login";
    }

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: i */
    public final int mo488i(C0261o c0261o) {
        String strM508f = C0263q.m508f();
        AbstractActivityC0947r abstractActivityC0947rM2490h = this.f688f.f671g.m2490h();
        String str = c0261o.f656h;
        Set set = c0261o.f654f;
        boolean zM506a = c0261o.m506a();
        int i3 = c0261o.f655g;
        String strM525d = m525d(c0261o.f657i);
        String str2 = c0261o.f660l;
        ArrayList arrayList = AbstractC2087y.f7381a;
        Set set2 = AbstractC0147a.f354a;
        Intent intent = null;
        if (!set2.contains(AbstractC2087y.class)) {
            try {
                Intent intentM4634c = AbstractC2087y.m4634c(new C2086x(1), str, set, strM508f, zM506a, i3, strM525d, str2, false);
                if (!set2.contains(AbstractC2087y.class) && intentM4634c != null) {
                    try {
                        ResolveInfo resolveInfoResolveActivity = abstractActivityC0947rM2490h.getPackageManager().resolveActivity(intentM4634c, 0);
                        if (resolveInfoResolveActivity != null) {
                            if (AbstractC2072j.m4609a(abstractActivityC0947rM2490h, resolveInfoResolveActivity.activityInfo.packageName)) {
                                intent = intentM4634c;
                            }
                        }
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, AbstractC2087y.class);
                    }
                }
            } catch (Throwable th2) {
                AbstractC0147a.m295a(th2, AbstractC2087y.class);
            }
        }
        Intent intent2 = intent;
        m524a("e2e", strM508f);
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        int i4 = AbstractC1117n.f3883i;
        if (intent2 != null) {
            try {
                this.f688f.f671g.m2487O(i4, intent2);
                return 1;
            } catch (ActivityNotFoundException unused) {
            }
        }
        return 0;
    }
}
