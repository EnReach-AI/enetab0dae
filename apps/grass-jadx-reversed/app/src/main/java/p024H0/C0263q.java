package p024H0;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.fragment.app.AbstractComponentCallbacksC0944o;
import io.getgrass.www.R;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p019F0.C0221e;
import p036L0.C0444d;
import p166z0.AbstractC2056E;

/* JADX INFO: renamed from: H0.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0263q implements Parcelable {
    public static final Parcelable.Creator<C0263q> CREATOR = new C0247a(6);

    /* JADX INFO: renamed from: e */
    public AbstractC0268v[] f669e;

    /* JADX INFO: renamed from: f */
    public int f670f;

    /* JADX INFO: renamed from: g */
    public AbstractComponentCallbacksC0944o f671g;

    /* JADX INFO: renamed from: h */
    public C0444d f672h;

    /* JADX INFO: renamed from: i */
    public C0221e f673i;

    /* JADX INFO: renamed from: j */
    public boolean f674j;

    /* JADX INFO: renamed from: k */
    public C0261o f675k;

    /* JADX INFO: renamed from: l */
    public HashMap f676l;

    /* JADX INFO: renamed from: m */
    public HashMap f677m;

    /* JADX INFO: renamed from: n */
    public C0265s f678n;

    /* JADX INFO: renamed from: o */
    public int f679o;

    /* JADX INFO: renamed from: p */
    public int f680p;

    /* JADX INFO: renamed from: f */
    public static String m508f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m509a(String str, String str2, boolean z3) {
        if (this.f676l == null) {
            this.f676l = new HashMap();
        }
        if (this.f676l.containsKey(str) && z3) {
            str2 = ((String) this.f676l.get(str)) + "," + str2;
        }
        this.f676l.put(str, str2);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m510b() {
        if (this.f674j) {
            return true;
        }
        if (this.f671g.m2490h().checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
            this.f674j = true;
            return true;
        }
        AbstractActivityC0947r abstractActivityC0947rM2490h = this.f671g.m2490h();
        m511c(C0262p.m507a(this.f675k, abstractActivityC0947rM2490h.getString(R.string.com_facebook_internet_permission_error_title), abstractActivityC0947rM2490h.getString(R.string.com_facebook_internet_permission_error_message), null));
        return false;
    }

    /* JADX INFO: renamed from: c */
    public final void m511c(C0262p c0262p) {
        String str;
        AbstractC0268v abstractC0268vM513e = m513e();
        int i3 = c0262p.f662e;
        if (abstractC0268vM513e != null) {
            String strMo485e = abstractC0268vM513e.mo485e();
            HashMap map = abstractC0268vM513e.f687e;
            if (i3 == 1) {
                str = "success";
            } else if (i3 == 2) {
                str = "cancel";
            } else {
                if (i3 != 3) {
                    throw null;
                }
                str = "error";
            }
            m515h(strMo485e, str, c0262p.f664g, c0262p.f665h, map);
        }
        HashMap map2 = this.f676l;
        if (map2 != null) {
            c0262p.f667j = map2;
        }
        HashMap map3 = this.f677m;
        if (map3 != null) {
            c0262p.f668k = map3;
        }
        this.f669e = null;
        this.f670f = -1;
        this.f675k = null;
        this.f676l = null;
        this.f679o = 0;
        this.f680p = 0;
        C0444d c0444d = this.f672h;
        if (c0444d != null) {
            C0264r c0264r = (C0264r) c0444d.f1085e;
            c0264r.f683Y = null;
            int i4 = i3 == 2 ? 0 : -1;
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.facebook.LoginFragment:Result", c0262p);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            if (c0264r.m2496n()) {
                c0264r.m2490h().setResult(i4, intent);
                c0264r.m2490h().finish();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:9:0x0017, B:11:0x0021, B:15:0x0037, B:14:0x002f), top: B:22:0x0017 }] */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m512d(p024H0.C0262p r8) {
        /*
            r7 = this;
            com.facebook.a r3 = r8.f663f
            if (r3 == 0) goto L53
            boolean r0 = com.facebook.C1104a.m2876b()
            if (r0 == 0) goto L53
            if (r3 == 0) goto L4b
            com.facebook.d r8 = com.facebook.C1107d.m2887a()
            java.lang.Object r8 = r8.f3849d
            com.facebook.a r8 = (com.facebook.C1104a) r8
            r6 = 0
            if (r8 == 0) goto L2f
            java.lang.String r8 = r8.f3831m     // Catch: java.lang.Exception -> L2d
            java.lang.String r0 = r3.f3831m     // Catch: java.lang.Exception -> L2d
            boolean r8 = r8.equals(r0)     // Catch: java.lang.Exception -> L2d
            if (r8 == 0) goto L2f
            H0.o r1 = r7.f675k     // Catch: java.lang.Exception -> L2d
            H0.p r8 = new H0.p     // Catch: java.lang.Exception -> L2d
            r5 = 0
            r2 = 1
            r4 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2d
            goto L37
        L2d:
            r8 = move-exception
            goto L3b
        L2f:
            H0.o r8 = r7.f675k     // Catch: java.lang.Exception -> L2d
            java.lang.String r0 = "User logged in as different Facebook user."
            H0.p r8 = p024H0.C0262p.m507a(r8, r0, r6, r6)     // Catch: java.lang.Exception -> L2d
        L37:
            r7.m511c(r8)     // Catch: java.lang.Exception -> L2d
            goto L56
        L3b:
            H0.o r0 = r7.f675k
            java.lang.String r8 = r8.getMessage()
            java.lang.String r1 = "Caught exception"
            H0.p r8 = p024H0.C0262p.m507a(r0, r1, r8, r6)
            r7.m511c(r8)
            goto L56
        L4b:
            com.facebook.h r8 = new com.facebook.h
            java.lang.String r0 = "Can't validate without a token"
            r8.<init>(r0)
            throw r8
        L53:
            r7.m511c(r8)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p024H0.C0263q.m512d(H0.p):void");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public final AbstractC0268v m513e() {
        int i3 = this.f670f;
        if (i3 >= 0) {
            return this.f669e[i3];
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p024H0.C0265s m514g() {
        /*
            r3 = this;
            H0.s r0 = r3.f678n
            if (r0 == 0) goto L1f
            java.util.Set r1 = p010C0.AbstractC0147a.f354a
            boolean r1 = r1.contains(r0)
            r2 = 0
            if (r1 == 0) goto Le
            goto L15
        Le:
            java.lang.String r2 = r0.f685b     // Catch: java.lang.Throwable -> L11
            goto L15
        L11:
            r1 = move-exception
            p010C0.AbstractC0147a.m295a(r1, r0)
        L15:
            H0.o r0 = r3.f675k
            java.lang.String r0 = r0.f656h
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L30
        L1f:
            H0.s r0 = new H0.s
            androidx.fragment.app.o r1 = r3.f671g
            androidx.fragment.app.r r1 = r1.m2490h()
            H0.o r2 = r3.f675k
            java.lang.String r2 = r2.f656h
            r0.<init>(r1, r2)
            r3.f678n = r0
        L30:
            H0.s r0 = r3.f678n
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p024H0.C0263q.m514g():H0.s");
    }

    /* JADX INFO: renamed from: h */
    public final void m515h(String str, String str2, String str3, String str4, HashMap map) {
        if (this.f675k == null) {
            C0265s c0265sM514g = m514g();
            c0265sM514g.getClass();
            if (AbstractC0147a.f354a.contains(c0265sM514g)) {
                return;
            }
            try {
                Bundle bundleM522a = C0265s.m522a("");
                bundleM522a.putString("2_result", "error");
                bundleM522a.putString("5_error_message", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
                bundleM522a.putString("3_method", str);
                c0265sM514g.f684a.m985v(bundleM522a, "fb_mobile_login_method_complete");
                return;
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, c0265sM514g);
                return;
            }
        }
        C0265s c0265sM514g2 = m514g();
        String str5 = this.f675k.f657i;
        c0265sM514g2.getClass();
        if (AbstractC0147a.f354a.contains(c0265sM514g2)) {
            return;
        }
        try {
            Bundle bundleM522a2 = C0265s.m522a(str5);
            bundleM522a2.putString("2_result", str2);
            if (str3 != null) {
                bundleM522a2.putString("5_error_message", str3);
            }
            if (str4 != null) {
                bundleM522a2.putString("4_error_code", str4);
            }
            if (map != null && !map.isEmpty()) {
                bundleM522a2.putString("6_extras", new JSONObject(map).toString());
            }
            bundleM522a2.putString("3_method", str);
            c0265sM514g2.f684a.m985v(bundleM522a2, "fb_mobile_login_method_complete");
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, c0265sM514g2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b4, code lost:
    
        r0 = r8.f675k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b6, code lost:
    
        if (r0 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
    
        m511c(p024H0.C0262p.m507a(r0, "Login attempt failed.", null, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c2, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m516i() {
        /*
            r8 = this;
            int r0 = r8.f670f
            if (r0 < 0) goto L1a
            H0.v r0 = r8.m513e()
            java.lang.String r2 = r0.mo485e()
            H0.v r0 = r8.m513e()
            java.util.HashMap r6 = r0.f687e
            r4 = 0
            r5 = 0
            java.lang.String r3 = "skipped"
            r1 = r8
            r1.m515h(r2, r3, r4, r5, r6)
        L1a:
            H0.v[] r0 = r8.f669e
            if (r0 == 0) goto Lb4
            int r1 = r8.f670f
            int r0 = r0.length
            r2 = 1
            int r0 = r0 - r2
            if (r1 >= r0) goto Lb4
            int r1 = r1 + 1
            r8.f670f = r1
            H0.v r0 = r8.m513e()
            r0.getClass()
            boolean r1 = r0 instanceof p024H0.C0271y
            r3 = 0
            if (r1 == 0) goto L43
            boolean r1 = r8.m510b()
            if (r1 != 0) goto L43
            java.lang.String r0 = "no_internet_permission"
            java.lang.String r1 = "1"
            r8.m509a(r0, r1, r3)
            goto L1a
        L43:
            H0.o r1 = r8.f675k
            int r1 = r0.mo488i(r1)
            r8.f679o = r3
            java.lang.String r3 = "3_method"
            if (r1 <= 0) goto L7d
            H0.s r2 = r8.m514g()
            H0.o r4 = r8.f675k
            java.lang.String r4 = r4.f657i
            java.lang.String r0 = r0.mo485e()
            r2.getClass()
            java.util.Set r5 = p010C0.AbstractC0147a.f354a
            boolean r5 = r5.contains(r2)
            if (r5 == 0) goto L67
            goto L7a
        L67:
            android.os.Bundle r4 = p024H0.C0265s.m522a(r4)     // Catch: java.lang.Throwable -> L76
            r4.putString(r3, r0)     // Catch: java.lang.Throwable -> L76
            L0.d r0 = r2.f684a     // Catch: java.lang.Throwable -> L76
            java.lang.String r3 = "fb_mobile_login_method_start"
            r0.m985v(r4, r3)     // Catch: java.lang.Throwable -> L76
            goto L7a
        L76:
            r0 = move-exception
            p010C0.AbstractC0147a.m295a(r0, r2)
        L7a:
            r8.f680p = r1
            goto Lb1
        L7d:
            H0.s r4 = r8.m514g()
            H0.o r5 = r8.f675k
            java.lang.String r5 = r5.f657i
            java.lang.String r6 = r0.mo485e()
            r4.getClass()
            java.util.Set r7 = p010C0.AbstractC0147a.f354a
            boolean r7 = r7.contains(r4)
            if (r7 == 0) goto L95
            goto La8
        L95:
            android.os.Bundle r5 = p024H0.C0265s.m522a(r5)     // Catch: java.lang.Throwable -> La4
            r5.putString(r3, r6)     // Catch: java.lang.Throwable -> La4
            L0.d r3 = r4.f684a     // Catch: java.lang.Throwable -> La4
            java.lang.String r6 = "fb_mobile_login_method_not_tried"
            r3.m985v(r5, r6)     // Catch: java.lang.Throwable -> La4
            goto La8
        La4:
            r3 = move-exception
            p010C0.AbstractC0147a.m295a(r3, r4)
        La8:
            java.lang.String r0 = r0.mo485e()
            java.lang.String r3 = "not_tried"
            r8.m509a(r3, r0, r2)
        Lb1:
            if (r1 <= 0) goto L1a
            return
        Lb4:
            H0.o r0 = r8.f675k
            if (r0 == 0) goto Lc2
            java.lang.String r1 = "Login attempt failed."
            r2 = 0
            H0.p r0 = p024H0.C0262p.m507a(r0, r1, r2, r2)
            r8.m511c(r0)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p024H0.C0263q.m516i():void");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelableArray(this.f669e, i3);
        parcel.writeInt(this.f670f);
        parcel.writeParcelable(this.f675k, i3);
        AbstractC2056E.m4531C(parcel, this.f676l);
        AbstractC2056E.m4531C(parcel, this.f677m);
    }
}
