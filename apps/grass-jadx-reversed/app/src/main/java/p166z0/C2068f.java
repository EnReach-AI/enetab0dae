package p166z0;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.C0920F;
import androidx.lifecycle.AbstractC0964I;
import com.facebook.AbstractC1117n;
import com.facebook.C1099B;
import com.facebook.C1100C;
import com.facebook.C1111h;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.Collection;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p043N1.InterfaceC0562d;
import p059T1.C0647c;
import p059T1.InterfaceC0646b;
import p065W.C0673a;
import p117m0.AbstractC1720o;
import p117m0.C1719n;
import p133q0.AbstractC1838b;
import p156w0.AbstractC1986a;

/* JADX INFO: renamed from: z0.f */
/* JADX INFO: loaded from: classes.dex */
public final class C2068f implements InterfaceC0562d, InterfaceC0646b, InterfaceC2075m, InterfaceC2055D {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f7306e;

    public /* synthetic */ C2068f(int i3) {
        this.f7306e = i3;
    }

    /* JADX INFO: renamed from: f */
    public static Uri m4574f(Bundle bundle, String str) {
        if (AbstractC0147a.f354a.contains(C2068f.class)) {
            return null;
        }
        try {
            Collection collection = AbstractC2052A.f7256a;
            return AbstractC2056E.m4533b("m." + AbstractC1117n.f3881g, AbstractC1117n.m2892b() + "/dialog/" + str, bundle);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C2068f.class);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0049, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0086, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0070 A[EDGE_INSN: B:91:0x0070->B:48:0x0070 BREAK  A[LOOP:2: B:49:0x0072->B:60:0x0089, LOOP_LABEL: LOOP:2: B:49:0x0072->B:60:0x0089], EDGE_INSN: B:94:0x0070->B:48:0x0070 BREAK  A[LOOP:2: B:49:0x0072->B:60:0x0089]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a6 A[ADDED_TO_REGION] */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m4575g(android.view.inputmethod.InputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p166z0.C2068f.m4575g(android.view.inputmethod.InputConnection, android.text.Editable, int, int, boolean):boolean");
    }

    @Override // p166z0.InterfaceC2055D
    /* JADX INFO: renamed from: a */
    public void mo2845a(C1111h c1111h) {
        Log.e("B", "Got unexpected exception: " + c1111h);
    }

    @Override // p166z0.InterfaceC2055D
    /* JADX INFO: renamed from: b */
    public void mo2846b(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("id");
        if (strOptString == null) {
            Log.w("B", "No user ID returned on Me request");
        } else {
            String strOptString2 = jSONObject.optString("link");
            C1100C.m2844i().m2859p(new C1099B(strOptString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), strOptString2 != null ? Uri.parse(strOptString2) : null), true);
        }
    }

    @Override // p059T1.InterfaceC0646b
    /* JADX INFO: renamed from: c */
    public void mo429c(C0647c c0647c) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!c0647c.m1595b()) {
                break;
            }
            sb.append(c0647c.m1594a());
            int i3 = c0647c.f1729d + 1;
            c0647c.f1729d = i3;
            if (AbstractC1986a.m4383k(c0647c.f1726a, i3, 5) != 5) {
                c0647c.f1730e = 0;
                break;
            }
        }
        int length = sb.length() - 1;
        StringBuilder sb2 = c0647c.f1728c;
        int length2 = sb2.length() + length + 1;
        c0647c.m1596c(length2);
        boolean z3 = c0647c.f1731f.f1739b - length2 > 0;
        if (c0647c.m1595b() || z3) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length3 = sb.length();
        for (int i4 = 0; i4 < length3; i4++) {
            int length4 = (((sb2.length() + 1) * 149) % 255) + 1 + sb.charAt(i4);
            if (length4 > 255) {
                length4 -= 256;
            }
            c0647c.m1597d((char) length4);
        }
    }

    @Override // p166z0.InterfaceC2075m
    /* JADX INFO: renamed from: d */
    public void mo430d(boolean z3) {
        switch (this.f7306e) {
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                if (z3 && !AbstractC0147a.f354a.contains(AbstractC1720o.class)) {
                    try {
                        AbstractC2082t.f7373d.add(new C1719n());
                        AbstractC2082t.m4622c();
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, AbstractC1720o.class);
                        return;
                    }
                    break;
                }
                break;
            default:
                if (z3) {
                    boolean z4 = AbstractC1838b.f6356a;
                    if (!AbstractC0147a.f354a.contains(AbstractC1838b.class)) {
                        try {
                            AbstractC1838b.f6356a = true;
                            AbstractC1838b.m4076a();
                        } catch (Throwable th2) {
                            AbstractC0147a.m295a(th2, AbstractC1838b.class);
                        }
                        break;
                    }
                }
                break;
        }
    }

    /* JADX INFO: renamed from: e */
    public AbstractC0964I m4576e(Class cls) {
        switch (this.f7306e) {
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return new C0673a();
            default:
                return new C0920F(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    @Override // p043N1.InterfaceC0562d
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p051Q1.C0601b mo434i(java.lang.String r20, int r21, java.util.EnumMap r22) {
        /*
            Method dump skipped, instruction units count: 1118
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p166z0.C2068f.mo434i(java.lang.String, int, java.util.EnumMap):Q1.b");
    }
}
