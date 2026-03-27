package p019F0;

import android.graphics.Path;
import android.net.Uri;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import com.facebook.C1111h;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002A0.C0022d;
import p005B.AbstractC0032g;
import p006B0.C0038a;
import p006B0.C0039b;
import p010C0.AbstractC0147a;
import p013D0.C0175a;
import p025H1.C0276e;
import p033K0.AbstractC0406d;
import p034K1.C0429p;
import p036L0.C0449i;
import p043N1.EnumC0559a;
import p043N1.InterfaceC0562d;
import p051Q1.C0601b;
import p053R0.C0607c;
import p059T1.AbstractC0648d;
import p059T1.C0647c;
import p059T1.C0649e;
import p059T1.C0651g;
import p059T1.EnumC0650f;
import p059T1.InterfaceC0646b;
import p152v0.AbstractC1973b;
import p166z0.AbstractC2056E;
import p166z0.C2068f;
import p166z0.InterfaceC2075m;

/* JADX INFO: renamed from: F0.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0222f implements InterfaceC2075m, InterfaceC0562d, InterfaceC0646b {

    /* JADX INFO: renamed from: f */
    public static C0222f f535f;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f536e;

    public /* synthetic */ C0222f(int i3) {
        this.f536e = i3;
    }

    /* JADX INFO: renamed from: a */
    public static String m461a(StringBuilder sb) {
        int length = sb.length();
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (sb.charAt(0) << 18) + ((length >= 2 ? sb.charAt(1) : (char) 0) << '\f') + ((length >= 3 ? sb.charAt(2) : (char) 0) << 6) + (length >= 4 ? sb.charAt(3) : (char) 0);
        char c3 = (char) ((iCharAt >> 16) & 255);
        char c4 = (char) ((iCharAt >> 8) & 255);
        char c5 = (char) (iCharAt & 255);
        StringBuilder sb2 = new StringBuilder(3);
        sb2.append(c3);
        if (length >= 2) {
            sb2.append(c4);
        }
        if (length >= 3) {
            sb2.append(c5);
        }
        return sb2.toString();
    }

    /* JADX INFO: renamed from: b */
    public static Path m462b(float f3, float f4, float f5, float f6) {
        Path path = new Path();
        path.moveTo(f3, f4);
        path.lineTo(f5, f6);
        return path;
    }

    /* JADX INFO: renamed from: e */
    public static JSONObject m463e(C0449i c0449i) {
        Uri uri = c0449i.f1091g;
        if (!AbstractC2056E.m4551t(uri)) {
            throw new C1111h("Only web images may be used in OG objects shared via the web dialog");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", uri.toString());
            return jSONObject;
        } catch (JSONException e3) {
            throw new C1111h("Unable to attach images", e3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        p156w0.AbstractC1986a.m4377e(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        throw null;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    @Override // p059T1.InterfaceC0646b
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo429c(p059T1.C0647c r12) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p019F0.C0222f.mo429c(T1.c):void");
    }

    @Override // p166z0.InterfaceC2075m
    /* JADX INFO: renamed from: d */
    public void mo430d(boolean z3) {
        int i3 = 2;
        int i4 = 1;
        switch (this.f536e) {
            case 1:
                if (z3) {
                    HashSet hashSet = AbstractC1117n.f3875a;
                    if (AbstractC1103F.m2866c() && !AbstractC2056E.m4549r()) {
                        File fileM898f = AbstractC0406d.m898f();
                        File[] fileArrListFiles = fileM898f == null ? new File[0] : fileM898f.listFiles(new C0022d(2));
                        ArrayList arrayList = new ArrayList();
                        for (File file : fileArrListFiles) {
                            C0175a c0175a = new C0175a();
                            String name = file.getName();
                            c0175a.f409a = name;
                            JSONObject jSONObjectM901k = AbstractC0406d.m901k(name);
                            if (jSONObjectM901k != null) {
                                c0175a.f411c = Long.valueOf(jSONObjectM901k.optLong("timestamp", 0L));
                                c0175a.f410b = jSONObjectM901k.optString("error_message", null);
                            }
                            if (c0175a.f410b != null && c0175a.f411c != null) {
                                arrayList.add(c0175a);
                            }
                        }
                        Collections.sort(arrayList, new C0038a(i3));
                        JSONArray jSONArray = new JSONArray();
                        for (int i5 = 0; i5 < arrayList.size() && i5 < 1000; i5++) {
                            jSONArray.put(arrayList.get(i5));
                        }
                        AbstractC0406d.m905o("error_reports", jSONArray, new C0039b(arrayList, i4));
                        break;
                    }
                }
                break;
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                if (z3) {
                    AbstractC1117n.f3887m = true;
                }
                break;
            default:
                if (z3) {
                    boolean z4 = AbstractC1973b.f6991a;
                    if (!AbstractC0147a.f354a.contains(AbstractC1973b.class)) {
                        try {
                            AbstractC1973b.f6991a = true;
                            AbstractC1973b.m4367b();
                        } catch (Throwable th) {
                            AbstractC0147a.m295a(th, AbstractC1973b.class);
                        }
                        break;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v13 */
    @Override // p043N1.InterfaceC0562d
    /* JADX INFO: renamed from: i */
    public C0601b mo434i(String str, int i3, EnumMap enumMap) {
        int i4;
        int i5;
        int i6;
        char c3;
        char c4;
        int i7;
        byte[] bArr;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        C0601b c0601b;
        ?? r15;
        int i14 = 0;
        int i15 = 3;
        int i16 = 5;
        int i17 = 4;
        int i18 = 2;
        int i19 = 1;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i3 != 6) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(AbstractC0032g.m165w(i3)));
        }
        EnumC0650f enumC0650f = EnumC0650f.f1746e;
        EnumC0650f enumC0650f2 = (EnumC0650f) enumMap.get(EnumC0559a.f1355g);
        if (enumC0650f2 != null) {
            enumC0650f = enumC0650f2;
        }
        AbstractC0032g.m162t(enumMap.get(EnumC0559a.f1356h));
        AbstractC0032g.m162t(enumMap.get(EnumC0559a.f1357i));
        InterfaceC0646b[] interfaceC0646bArr = {new C0276e(i17), new C0217a(i16), new C0651g(i14), new C0651g(i19), new C0222f(i16), new C2068f(i17)};
        C0647c c0647c = new C0647c(str);
        c0647c.f1727b = enumC0650f;
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            c0647c.m1597d((char) 236);
            c0647c.f1732g = 2;
            c0647c.f1729d += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            c0647c.m1597d((char) 237);
            c0647c.f1732g = 2;
            c0647c.f1729d += 7;
        }
        int i20 = 0;
        while (c0647c.m1595b()) {
            interfaceC0646bArr[i20].mo429c(c0647c);
            int i21 = c0647c.f1730e;
            if (i21 >= 0) {
                c0647c.f1730e = -1;
                i20 = i21;
            }
        }
        StringBuilder sb = c0647c.f1728c;
        int length = sb.length();
        c0647c.m1596c(sb.length());
        int i22 = c0647c.f1731f.f1739b;
        if (length < i22 && i20 != 0 && i20 != 5 && i20 != 4) {
            c0647c.m1597d((char) 254);
        }
        if (sb.length() < i22) {
            sb.append((char) 129);
        }
        while (sb.length() < i22) {
            int length2 = ((sb.length() + 1) * 149) % 253;
            int i23 = length2 + 130;
            if (i23 > 254) {
                i23 = length2 - 124;
            }
            sb.append((char) i23);
        }
        String string = sb.toString();
        C0649e c0649eM1599e = C0649e.m1599e(string.length(), enumC0650f);
        int[] iArr = AbstractC0648d.f1733a;
        int length3 = string.length();
        int i24 = c0649eM1599e.f1739b;
        if (length3 != i24) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        int i25 = c0649eM1599e.f1740c;
        StringBuilder sb2 = new StringBuilder(i24 + i25);
        sb2.append(string);
        int iMo1593c = c0649eM1599e.mo1593c();
        if (iMo1593c == 1) {
            sb2.append(AbstractC0648d.m1598a(i25, string));
        } else {
            sb2.setLength(sb2.capacity());
            int[] iArr2 = new int[iMo1593c];
            int[] iArr3 = new int[iMo1593c];
            int[] iArr4 = new int[iMo1593c];
            int i26 = 0;
            while (i26 < iMo1593c) {
                int i27 = i26 + 1;
                iArr2[i26] = c0649eM1599e.mo1592a(i27);
                iArr3[i26] = c0649eM1599e.f1745h;
                iArr4[i26] = 0;
                if (i26 > 0) {
                    iArr4[i26] = iArr4[i26 - 1] + iArr2[i26];
                }
                i26 = i27;
            }
            for (int i28 = 0; i28 < iMo1593c; i28++) {
                StringBuilder sb3 = new StringBuilder(iArr2[i28]);
                for (int i29 = i28; i29 < i24; i29 += iMo1593c) {
                    sb3.append(string.charAt(i29));
                }
                String strM1598a = AbstractC0648d.m1598a(iArr3[i28], sb3.toString());
                int i30 = i28;
                int i31 = 0;
                while (i30 < iArr3[i28] * iMo1593c) {
                    sb2.setCharAt(i24 + i30, strM1598a.charAt(i31));
                    i30 += iMo1593c;
                    i31++;
                }
            }
        }
        String string2 = sb2.toString();
        int iM1600b = c0649eM1599e.m1600b();
        int i32 = c0649eM1599e.f1741d;
        int iM1601d = c0649eM1599e.m1601d();
        int i33 = c0649eM1599e.f1742e;
        C0429p c0429p = new C0429p(string2, iM1600b * i32, iM1601d * i33);
        int i34 = 0;
        int i35 = 0;
        int i36 = 4;
        while (true) {
            i4 = c0429p.f986b;
            i5 = c0429p.f985a;
            if (i36 == i5 && i34 == 0) {
                int i37 = i5 - 1;
                c0429p.m939a(i37, i14, i35, i19);
                c0429p.m939a(i37, i19, i35, i18);
                c0429p.m939a(i37, i18, i35, i15);
                c0429p.m939a(i14, i4 - 2, i35, 4);
                int i38 = i4 - 1;
                c0429p.m939a(i14, i38, i35, 5);
                c0429p.m939a(i19, i38, i35, 6);
                c0429p.m939a(i18, i38, i35, 7);
                c0429p.m939a(i15, i38, i35, 8);
                i35++;
            }
            i6 = i5 - 2;
            if (i36 == i6 && i34 == 0 && i4 % 4 != 0) {
                c0429p.m939a(i5 - 3, i14, i35, i19);
                c0429p.m939a(i6, i14, i35, i18);
                c0429p.m939a(i5 - 1, i14, i35, i15);
                c0429p.m939a(i14, i4 - 4, i35, 4);
                c0429p.m939a(i14, i4 - 3, i35, 5);
                c0429p.m939a(i14, i4 - 2, i35, 6);
                i19 = 1;
                int i39 = i4 - 1;
                c0429p.m939a(i14, i39, i35, 7);
                c3 = '\b';
                c0429p.m939a(1, i39, i35, 8);
                i35++;
            } else {
                c3 = '\b';
            }
            if (i36 != i6 || i34 != 0) {
                c4 = c3;
            } else if (i4 % 8 == 4) {
                c0429p.m939a(i5 - 3, i14, i35, i19);
                i7 = 2;
                c0429p.m939a(i6, i14, i35, 2);
                c0429p.m939a(i5 - 1, i14, i35, i15);
                c0429p.m939a(i14, i4 - 2, i35, 4);
                int i40 = i4 - 1;
                c0429p.m939a(i14, i40, i35, 5);
                c0429p.m939a(i19, i40, i35, 6);
                c0429p.m939a(2, i40, i35, 7);
                c4 = '\b';
                c0429p.m939a(3, i40, i35, 8);
                i35++;
                if (i36 != i5 + 4 && i34 == i7 && i4 % 8 == 0) {
                    int i41 = i5 - 1;
                    c0429p.m939a(i41, i14, i35, 1);
                    int i42 = i4 - 1;
                    c0429p.m939a(i41, i42, i35, i7);
                    int i43 = i4 - 3;
                    c0429p.m939a(i14, i43, i35, 3);
                    int i44 = i4 - 2;
                    c0429p.m939a(i14, i44, i35, 4);
                    c0429p.m939a(i14, i42, i35, 5);
                    c0429p.m939a(1, i43, i35, 6);
                    c0429p.m939a(1, i44, i35, 7);
                    c0429p.m939a(1, i42, i35, 8);
                    i35++;
                }
                while (true) {
                    bArr = (byte[]) c0429p.f988d;
                    if (i36 < i5 && i34 >= 0 && bArr[(i36 * i4) + i34] < 0) {
                        c0429p.m940b(i36, i34, i35);
                        i35++;
                    }
                    i8 = i36 - 2;
                    i9 = i34 + 2;
                    if (i8 < 0 || i9 >= i4) {
                        break;
                    }
                    i34 = i9;
                    i36 = i8;
                }
                i10 = i36 - 1;
                i11 = i34 + 5;
                while (true) {
                    if (i10 >= 0 && i11 < i4 && bArr[(i10 * i4) + i11] < 0) {
                        c0429p.m940b(i10, i11, i35);
                        i35++;
                    }
                    i12 = i10 + 2;
                    i13 = i11 - 2;
                    if (i12 >= i5 || i13 < 0) {
                        break;
                    }
                    i11 = i13;
                    i10 = i12;
                }
                i36 = i10 + 5;
                i34 = i11 - 1;
                if (i36 < i5 && i34 >= i4) {
                    break;
                }
                i18 = 2;
                i14 = 0;
                i19 = 1;
                i15 = 3;
            } else {
                c4 = '\b';
            }
            i7 = 2;
            if (i36 != i5 + 4) {
            }
            while (true) {
                bArr = (byte[]) c0429p.f988d;
                if (i36 < i5) {
                    c0429p.m940b(i36, i34, i35);
                    i35++;
                }
                i8 = i36 - 2;
                i9 = i34 + 2;
                if (i8 < 0) {
                    break;
                }
                break;
                break;
                i34 = i9;
                i36 = i8;
            }
            i10 = i36 - 1;
            i11 = i34 + 5;
            while (true) {
                if (i10 >= 0) {
                    c0429p.m940b(i10, i11, i35);
                    i35++;
                }
                i12 = i10 + 2;
                i13 = i11 - 2;
                if (i12 >= i5) {
                    break;
                }
                break;
                break;
                i11 = i13;
                i10 = i12;
            }
            i36 = i10 + 5;
            i34 = i11 - 1;
            if (i36 < i5) {
            }
            i18 = 2;
            i14 = 0;
            i19 = 1;
            i15 = 3;
        }
        int i45 = i4 - 1;
        int i46 = i5 - 1;
        if (bArr[(i46 * i4) + i45] < 0) {
            int i47 = (i46 * i4) + i45;
            byte b3 = (byte) 1;
            bArr[i47] = b3;
            bArr[(i6 * i4) + (i4 - 2)] = b3;
        }
        int iM1600b2 = c0649eM1599e.m1600b() * i32;
        int iM1601d2 = c0649eM1599e.m1601d() * i33;
        C0607c c0607c = new C0607c((c0649eM1599e.m1600b() * i32) + (c0649eM1599e.m1600b() << 1), (c0649eM1599e.m1601d() * i33) + (c0649eM1599e.m1601d() << 1));
        int i48 = 0;
        int i49 = 0;
        while (i48 < iM1601d2) {
            int i50 = i48 % i33;
            if (i50 == 0) {
                int i51 = 0;
                int i52 = 0;
                while (true) {
                    r15 = 1;
                    if (i51 >= (c0649eM1599e.m1600b() * i32) + (c0649eM1599e.m1600b() << 1)) {
                        break;
                    }
                    c0607c.m1406s(i52, i49, i51 % 2 == 0);
                    i52++;
                    i51++;
                }
                i49++;
            } else {
                r15 = 1;
            }
            int i53 = 0;
            int i54 = 0;
            while (i53 < iM1600b2) {
                int i55 = i53 % i32;
                if (i55 == 0) {
                    c0607c.m1406s(i54, i49, r15);
                    i54 += r15;
                }
                c0607c.m1406s(i54, i49, bArr[(i48 * i4) + i53] == r15 ? r15 : 0);
                int i56 = i54 + 1;
                int i57 = iM1600b2;
                if (i55 == i32 - 1) {
                    c0607c.m1406s(i56, i49, i48 % 2 == 0 ? r15 : 0);
                    i54 += 2;
                } else {
                    i54 = i56;
                }
                i53 += r15;
                iM1600b2 = i57;
            }
            int i58 = iM1600b2;
            int i59 = i49 + 1;
            if (i50 == i33 - 1) {
                int i60 = 0;
                for (int i61 = 0; i61 < (c0649eM1599e.m1600b() * i32) + (c0649eM1599e.m1600b() << r15); i61 += r15) {
                    c0607c.m1406s(i60, i59, r15);
                    i60 += r15;
                }
                i49 += 2;
            } else {
                i49 = i59;
            }
            i48 += r15;
            iM1600b2 = i58;
        }
        int i62 = c0607c.f1566f;
        int iMax = Math.max(200, i62);
        int i63 = c0607c.f1567g;
        int iMax2 = Math.max(200, i63);
        int iMin = Math.min(iMax / i62, iMax2 / i63);
        int i64 = (iMax - (i62 * iMin)) / 2;
        int i65 = (iMax2 - (i63 * iMin)) / 2;
        if (200 < i63 || 200 < i62) {
            c0601b = new C0601b(i62, i63);
            i64 = 0;
            i65 = 0;
        } else {
            c0601b = new C0601b(200, 200);
        }
        int[] iArr5 = c0601b.f1558h;
        int length4 = iArr5.length;
        for (int i66 = 0; i66 < length4; i66++) {
            iArr5[i66] = 0;
        }
        int i67 = 0;
        while (i67 < i63) {
            int i68 = i64;
            int i69 = 0;
            while (i69 < i62) {
                if (c0607c.m1391c(i69, i67) == 1) {
                    c0601b.m1379c(i68, i65, iMin, iMin);
                }
                i69++;
                i68 += iMin;
            }
            i67++;
            i65 += iMin;
        }
        return c0601b;
    }

    public /* synthetic */ C0222f(int i3, Object obj) {
        this.f536e = i3;
    }
}
