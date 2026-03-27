package p024H0;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.C1104a;
import com.facebook.EnumC1108e;
import java.util.ArrayList;
import java.util.Date;
import p166z0.AbstractC2056E;

/* JADX INFO: renamed from: H0.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0259m extends AbstractC0268v {
    public static final Parcelable.Creator<C0259m> CREATOR = new C0247a(4);

    /* JADX INFO: renamed from: g */
    public ServiceConnectionC0258l f652g;

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: b */
    public final void mo504b() {
        ServiceConnectionC0258l serviceConnectionC0258l = this.f652g;
        if (serviceConnectionC0258l != null) {
            serviceConnectionC0258l.f646d = false;
            serviceConnectionC0258l.f645c = null;
            this.f652g = null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: e */
    public final String mo485e() {
        return "get_token";
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0017  */
    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int mo488i(p024H0.C0261o r11) {
        /*
            r10 = this;
            r0 = 0
            H0.l r1 = new H0.l
            H0.q r2 = r10.f688f
            androidx.fragment.app.o r2 = r2.f671g
            androidx.fragment.app.r r2 = r2.m2490h()
            java.lang.String r3 = r11.f656h
            r1.<init>(r2, r3)
            r10.f652g = r1
            boolean r2 = r1.f646d
            r3 = 1
            if (r2 == 0) goto L1a
        L17:
            r1 = r0
            goto Lab
        L1a:
            int r2 = r1.f651i
            java.util.ArrayList r4 = p166z0.AbstractC2087y.f7381a
            java.util.Set r4 = p010C0.AbstractC0147a.f354a
            java.lang.Class<z0.y> r5 = p166z0.AbstractC2087y.class
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L2a
        L28:
            r2 = r0
            goto L3a
        L2a:
            int[] r2 = new int[]{r2}     // Catch: java.lang.Throwable -> L35
            W0.k r2 = p166z0.AbstractC2087y.m4637f(r2)     // Catch: java.lang.Throwable -> L35
            int r2 = r2.f1859a     // Catch: java.lang.Throwable -> L35
            goto L3a
        L35:
            r2 = move-exception
            p010C0.AbstractC0147a.m295a(r2, r5)
            goto L28
        L3a:
            r4 = -1
            if (r2 != r4) goto L3e
            goto L17
        L3e:
            java.util.Set r2 = p010C0.AbstractC0147a.f354a
            boolean r2 = r2.contains(r5)
            android.content.Context r4 = r1.f643a
            r6 = 0
            if (r2 == 0) goto L4a
            goto La1
        L4a:
            java.util.ArrayList r2 = p166z0.AbstractC2087y.f7381a     // Catch: java.lang.Throwable -> L9d
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L9d
        L50:
            boolean r7 = r2.hasNext()     // Catch: java.lang.Throwable -> L9d
            if (r7 == 0) goto La1
            java.lang.Object r7 = r2.next()     // Catch: java.lang.Throwable -> L9d
            z0.x r7 = (p166z0.C2086x) r7     // Catch: java.lang.Throwable -> L9d
            android.content.Intent r8 = new android.content.Intent     // Catch: java.lang.Throwable -> L9d
            java.lang.String r9 = "com.facebook.platform.PLATFORM_SERVICE"
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L9d
            java.lang.String r7 = r7.m4631c()     // Catch: java.lang.Throwable -> L9d
            android.content.Intent r7 = r8.setPackage(r7)     // Catch: java.lang.Throwable -> L9d
            java.lang.String r8 = "android.intent.category.DEFAULT"
            android.content.Intent r7 = r7.addCategory(r8)     // Catch: java.lang.Throwable -> L9d
            java.util.Set r8 = p010C0.AbstractC0147a.f354a     // Catch: java.lang.Throwable -> L9d
            boolean r8 = r8.contains(r5)     // Catch: java.lang.Throwable -> L9d
            if (r8 == 0) goto L7b
        L79:
            r7 = r6
            goto L99
        L7b:
            if (r7 != 0) goto L7e
            goto L79
        L7e:
            android.content.pm.PackageManager r8 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L94
            android.content.pm.ResolveInfo r8 = r8.resolveService(r7, r0)     // Catch: java.lang.Throwable -> L94
            if (r8 != 0) goto L89
            goto L79
        L89:
            android.content.pm.ServiceInfo r8 = r8.serviceInfo     // Catch: java.lang.Throwable -> L94
            java.lang.String r8 = r8.packageName     // Catch: java.lang.Throwable -> L94
            boolean r8 = p166z0.AbstractC2072j.m4609a(r4, r8)     // Catch: java.lang.Throwable -> L94
            if (r8 != 0) goto L99
            goto L79
        L94:
            r7 = move-exception
            p010C0.AbstractC0147a.m295a(r7, r5)     // Catch: java.lang.Throwable -> L9d
            goto L79
        L99:
            if (r7 == 0) goto L50
            r6 = r7
            goto La1
        L9d:
            r2 = move-exception
            p010C0.AbstractC0147a.m295a(r2, r5)
        La1:
            if (r6 != 0) goto La5
            goto L17
        La5:
            r1.f646d = r3
            r4.bindService(r6, r1, r3)
            r1 = r3
        Lab:
            if (r1 != 0) goto Lae
            return r0
        Lae:
            H0.q r1 = r10.f688f
            F0.e r1 = r1.f673i
            if (r1 == 0) goto Lbb
            java.lang.Object r1 = r1.f534f
            android.view.View r1 = (android.view.View) r1
            r1.setVisibility(r0)
        Lbb:
            A.j r1 = new A.j
            r2 = 7
            r1.<init>(r10, r11, r2, r0)
            H0.l r11 = r10.f652g
            r11.f645c = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p024H0.C0259m.mo488i(H0.o):int");
    }

    /* JADX INFO: renamed from: j */
    public final void m505j(C0261o c0261o, Bundle bundle) {
        C1104a c1104a;
        EnumC1108e enumC1108e = EnumC1108e.FACEBOOK_APPLICATION_SERVICE;
        String str = c0261o.f656h;
        Date dateM4542k = AbstractC2056E.m4542k(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
        ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String string = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        Date dateM4542k2 = AbstractC2056E.m4542k(bundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0L));
        if (AbstractC2056E.m4550s(string)) {
            c1104a = null;
        } else {
            c1104a = new C1104a(string, str, bundle.getString("com.facebook.platform.extra.USER_ID"), stringArrayList, null, null, enumC1108e, dateM4542k, new Date(), dateM4542k2, bundle.getString("graph_domain"));
        }
        this.f688f.m512d(new C0262p(this.f688f.f675k, 1, c1104a, null, null));
    }
}
