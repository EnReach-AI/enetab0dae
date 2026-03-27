package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import p002A0.C0019a;
import p005B.AbstractC0032g;
import p024H0.C0253g;
import p036L0.C0444d;
import p068X.C0698c;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: com.facebook.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1107d {

    /* JADX INFO: renamed from: g */
    public static volatile C1107d f3845g;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3846a;

    /* JADX INFO: renamed from: b */
    public final Object f3847b;

    /* JADX INFO: renamed from: c */
    public final Object f3848c;

    /* JADX INFO: renamed from: d */
    public Object f3849d;

    /* JADX INFO: renamed from: e */
    public final Object f3850e;

    /* JADX INFO: renamed from: f */
    public Object f3851f;

    public C1107d(String str, String str2, String str3, List list) {
        this.f3846a = 1;
        str.getClass();
        this.f3847b = str;
        str2.getClass();
        this.f3848c = str2;
        this.f3849d = str3;
        list.getClass();
        this.f3850e = list;
        this.f3851f = AbstractC0032g.m156n(str, "-", str2, "-", str3);
    }

    /* JADX INFO: renamed from: a */
    public static C1107d m2887a() {
        if (f3845g == null) {
            synchronized (C1107d.class) {
                try {
                    if (f3845g == null) {
                        HashSet hashSet = AbstractC1117n.f3875a;
                        AbstractC2069g.m4584h();
                        f3845g = new C1107d(C0698c.m1678a(AbstractC1117n.f3882h), new C0444d(14));
                    }
                } finally {
                }
            }
        }
        return f3845g;
    }

    /* JADX INFO: renamed from: b */
    public void m2888b() {
        C1104a c1104a = (C1104a) this.f3849d;
        if (c1104a != null && ((AtomicBoolean) this.f3850e).compareAndSet(false, true)) {
            this.f3851f = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            C1106c c1106c = new C1106c();
            C0253g c0253g = new C0253g(atomicBoolean, hashSet, hashSet2, hashSet3);
            Bundle bundle = new Bundle();
            EnumC1129z enumC1129z = EnumC1129z.f3922e;
            C1125v c1125v = new C1125v(c1104a, "me/permissions", bundle, enumC1129z, c0253g);
            C0019a c0019a = new C0019a(2, c1106c);
            Bundle bundle2 = new Bundle();
            bundle2.putString("grant_type", "fb_extend_sso_token");
            bundle2.putString("client_id", c1104a.f3830l);
            C1127x c1127x = new C1127x(c1125v, new C1125v(c1104a, "oauth/access_token", bundle2, enumC1129z, c0019a));
            C1105b c1105b = new C1105b(this, c1104a, atomicBoolean, c1106c, hashSet, hashSet2, hashSet3);
            ArrayList arrayList = c1127x.f3917g;
            if (!arrayList.contains(c1105b)) {
                arrayList.add(c1105b);
            }
            C1125v.m2910g(c1127x);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2889c(C1104a c1104a, C1104a c1104a2) {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        Intent intent = new Intent(AbstractC1117n.f3882h, (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", c1104a);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", c1104a2);
        ((C0698c) this.f3847b).m1680c(intent);
    }

    /* JADX INFO: renamed from: d */
    public void m2890d(C1104a c1104a, boolean z3) {
        C1104a c1104a2 = (C1104a) this.f3849d;
        this.f3849d = c1104a;
        ((AtomicBoolean) this.f3850e).set(false);
        this.f3851f = new Date(0L);
        if (z3) {
            C0444d c0444d = (C0444d) this.f3848c;
            if (c1104a != null) {
                c0444d.getClass();
                AbstractC2069g.m4582f("accessToken", c1104a);
                try {
                    ((SharedPreferences) c0444d.f1085e).edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", c1104a.m2877c().toString()).apply();
                } catch (JSONException unused) {
                }
            } else {
                ((SharedPreferences) c0444d.f1085e).edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
                HashSet hashSet = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                Context context = AbstractC1117n.f3882h;
                AbstractC2056E.m4534c(context, "facebook.com");
                AbstractC2056E.m4534c(context, ".facebook.com");
                AbstractC2056E.m4534c(context, "https://facebook.com");
                AbstractC2056E.m4534c(context, "https://.facebook.com");
            }
        }
        if (c1104a2 == null ? c1104a == null : c1104a2.equals(c1104a)) {
            return;
        }
        m2889c(c1104a2, c1104a);
        HashSet hashSet2 = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        Context context2 = AbstractC1117n.f3882h;
        Date date = C1104a.f3820p;
        C1104a c1104a3 = (C1104a) m2887a().f3849d;
        AlarmManager alarmManager = (AlarmManager) context2.getSystemService("alarm");
        if (!C1104a.m2876b() || c1104a3.f3823e == null || alarmManager == null) {
            return;
        }
        Intent intent = new Intent(context2, (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        try {
            alarmManager.set(1, c1104a3.f3823e.getTime(), PendingIntent.getBroadcast(context2, 0, intent, 0));
        } catch (Exception unused2) {
        }
    }

    public String toString() {
        switch (this.f3846a) {
            case 1:
                StringBuilder sb = new StringBuilder();
                sb.append("FontRequest {mProviderAuthority: " + ((String) this.f3847b) + ", mProviderPackage: " + ((String) this.f3848c) + ", mQuery: " + ((String) this.f3849d) + ", mCertificates:");
                int i3 = 0;
                while (true) {
                    List list = (List) this.f3850e;
                    if (i3 >= list.size()) {
                        sb.append("}mCertificatesArray: 0");
                        return sb.toString();
                    }
                    sb.append(" [");
                    List list2 = (List) list.get(i3);
                    for (int i4 = 0; i4 < list2.size(); i4++) {
                        sb.append(" \"");
                        sb.append(Base64.encodeToString((byte[]) list2.get(i4), 0));
                        sb.append("\"");
                    }
                    sb.append(" ]");
                    i3++;
                }
                break;
            default:
                return super.toString();
        }
    }

    public C1107d(C0698c c0698c, C0444d c0444d) {
        this.f3846a = 0;
        this.f3850e = new AtomicBoolean(false);
        this.f3851f = new Date(0L);
        AbstractC2069g.m4582f("localBroadcastManager", c0698c);
        this.f3847b = c0698c;
        this.f3848c = c0444d;
    }
}
