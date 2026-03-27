package com.facebook;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1105b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1104a f3834a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AtomicBoolean f3835b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C1106c f3836c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Set f3837d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Set f3838e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Set f3839f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ C1107d f3840g;

    public C1105b(C1107d c1107d, C1104a c1104a, AtomicBoolean atomicBoolean, C1106c c1106c, HashSet hashSet, HashSet hashSet2, HashSet hashSet3) {
        this.f3840g = c1107d;
        this.f3834a = c1104a;
        this.f3835b = atomicBoolean;
        this.f3836c = c1106c;
        this.f3837d = hashSet;
        this.f3838e = hashSet2;
        this.f3839f = hashSet3;
    }

    /* JADX INFO: renamed from: a */
    public final void m2878a() throws Throwable {
        C1107d c1107d;
        C1107d c1107d2;
        Date date;
        C1107d c1107d3 = this.f3840g;
        AtomicBoolean atomicBoolean = this.f3835b;
        C1104a c1104a = this.f3834a;
        try {
            if (((C1104a) C1107d.m2887a().f3849d) == null || ((C1104a) C1107d.m2887a().f3849d).f3831m != c1104a.f3831m) {
                ((AtomicBoolean) c1107d3.f3850e).set(false);
                return;
            }
            boolean z3 = atomicBoolean.get();
            C1106c c1106c = this.f3836c;
            if (!z3 && ((String) c1106c.f3842b) == null && c1106c.f3841a == 0) {
                ((AtomicBoolean) c1107d3.f3850e).set(false);
                return;
            }
            String str = (String) c1106c.f3842b;
            if (str == null) {
                str = c1104a.f3827i;
            }
            String str2 = str;
            String str3 = c1104a.f3830l;
            String str4 = c1104a.f3831m;
            Set set = atomicBoolean.get() ? this.f3837d : c1104a.f3824f;
            Set set2 = atomicBoolean.get() ? this.f3838e : c1104a.f3825g;
            Set set3 = atomicBoolean.get() ? this.f3839f : c1104a.f3826h;
            EnumC1108e enumC1108e = c1104a.f3828j;
            try {
                if (c1106c.f3841a != 0) {
                    try {
                        c1107d2 = c1107d3;
                        date = new Date(((long) c1106c.f3841a) * 1000);
                    } catch (Throwable th) {
                        th = th;
                        c1107d2 = c1107d3;
                        c1107d = c1107d2;
                        ((AtomicBoolean) c1107d.f3850e).set(false);
                        throw th;
                    }
                } else {
                    c1107d2 = c1107d3;
                    date = c1104a.f3823e;
                }
                C1107d.m2887a().m2890d(new C1104a(str2, str3, str4, set, set2, set3, enumC1108e, date, new Date(), ((Long) c1106c.f3844d) != null ? new Date(((Long) c1106c.f3844d).longValue() * 1000) : c1104a.f3832n, (String) c1106c.f3843c), true);
                ((AtomicBoolean) c1107d2.f3850e).set(false);
                return;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            c1107d = c1107d3;
        }
        ((AtomicBoolean) c1107d.f3850e).set(false);
        throw th;
    }
}
