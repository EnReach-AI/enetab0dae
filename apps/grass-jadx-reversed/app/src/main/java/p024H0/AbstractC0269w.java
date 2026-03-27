package p024H0;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.C1111h;
import com.facebook.EnumC1108e;
import p166z0.AbstractC2052A;
import p166z0.AbstractC2056E;

/* JADX INFO: renamed from: H0.w */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0269w extends AbstractC0268v {
    @Override // p024H0.AbstractC0268v
    /* JADX INFO: renamed from: g */
    public final boolean mo486g(int i3, int i4, Intent intent) {
        C0262p c0262pM507a;
        C0262p c0262p;
        C0261o c0261o = this.f688f.f675k;
        if (intent == null) {
            c0262p = new C0262p(c0261o, 2, null, "Operation canceled", null);
        } else {
            if (i4 == 0) {
                Bundle extras = intent.getExtras();
                String string = extras.getString("error");
                if (string == null) {
                    string = extras.getString("error_type");
                }
                String string2 = extras.get("error_code") != null ? extras.get("error_code").toString() : null;
                if ("CONNECTION_FAILURE".equals(string2)) {
                    String string3 = extras.getString("error_message");
                    if (string3 == null) {
                        string3 = extras.getString("error_description");
                    }
                    c0262pM507a = C0262p.m507a(c0261o, string, string3, string2);
                    c0262p = c0262pM507a;
                } else {
                    c0262p = new C0262p(c0261o, 2, null, string, null);
                }
            } else if (i4 != -1) {
                c0262p = C0262p.m507a(c0261o, "Unexpected resultCode from authorization.", null, null);
            } else {
                Bundle extras2 = intent.getExtras();
                String string4 = extras2.getString("error");
                if (string4 == null) {
                    string4 = extras2.getString("error_type");
                }
                String string5 = extras2.get("error_code") != null ? extras2.get("error_code").toString() : null;
                String string6 = extras2.getString("error_message");
                if (string6 == null) {
                    string6 = extras2.getString("error_description");
                }
                String string7 = extras2.getString("e2e");
                if (!AbstractC2056E.m4550s(string7)) {
                    m526f(string7);
                }
                if (string4 == null && string5 == null && string6 == null) {
                    try {
                        c0262p = new C0262p(c0261o, 1, AbstractC0268v.m523c(c0261o.f654f, extras2, EnumC1108e.FACEBOOK_APPLICATION_WEB, c0261o.f656h), null, null);
                    } catch (C1111h e3) {
                        c0262pM507a = C0262p.m507a(c0261o, null, e3.getMessage(), null);
                        c0262p = c0262pM507a;
                    }
                } else {
                    if (string4.equals("logged_out")) {
                        C0248b.f605k = true;
                    } else if (!AbstractC2052A.f7256a.contains(string4)) {
                        if (AbstractC2052A.f7257b.contains(string4)) {
                            c0262p = new C0262p(c0261o, 2, null, null, null);
                        } else {
                            c0262pM507a = C0262p.m507a(c0261o, string4, string6, string5);
                            c0262p = c0262pM507a;
                        }
                    }
                    c0262p = null;
                }
            }
        }
        if (c0262p != null) {
            this.f688f.m512d(c0262p);
        } else {
            this.f688f.m516i();
        }
        return true;
    }
}
