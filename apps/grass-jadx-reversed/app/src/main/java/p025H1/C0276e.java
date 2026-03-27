package p025H1;

import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import p010C0.AbstractC0147a;
import p019F0.AbstractC0219c;
import p019F0.C0217a;
import p019F0.C0222f;
import p019F0.RunnableC0218b;
import p021G.C0233j;
import p043N1.InterfaceC0562d;
import p051Q1.C0601b;
import p059T1.C0647c;
import p059T1.InterfaceC0646b;
import p108j.InterfaceC1491y;
import p108j.MenuC1479m;
import p125o0.AbstractC1795e;
import p125o0.C1804n;
import p144t0.AbstractC1918d;
import p156w0.AbstractC1986a;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2077o;
import p166z0.AbstractC2082t;
import p166z0.C2079q;
import p166z0.EnumC2076n;
import p166z0.InterfaceC2075m;

/* JADX INFO: renamed from: H1.e */
/* JADX INFO: loaded from: classes.dex */
public class C0276e implements InterfaceC0562d, InterfaceC0646b, InterfaceC2075m, InterfaceC1491y {

    /* JADX INFO: renamed from: f */
    public static C0276e f695f;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f696e;

    public /* synthetic */ C0276e(int i3) {
        this.f696e = i3;
    }

    /* JADX INFO: renamed from: e */
    public static C0601b m531e(byte[][] bArr, int i3) {
        int i4 = i3 * 2;
        int length = bArr[0].length + i4;
        int length2 = bArr.length + i4;
        C0601b c0601b = new C0601b(length, length2);
        int[] iArr = c0601b.f1558h;
        int length3 = iArr.length;
        for (int i5 = 0; i5 < length3; i5++) {
            iArr[i5] = 0;
        }
        int i6 = (length2 - i3) - 1;
        int i7 = 0;
        while (i7 < bArr.length) {
            byte[] bArr2 = bArr[i7];
            for (int i8 = 0; i8 < bArr[0].length; i8++) {
                if (bArr2[i8] == 1) {
                    c0601b.m1378b(i8 + i3, i6);
                }
            }
            i7++;
            i6--;
        }
        return c0601b;
    }

    /* JADX INFO: renamed from: h */
    public static byte[][] m532h(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int length = (bArr.length - i3) - 1;
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                bArr2[i4][length] = bArr[i3][i4];
            }
        }
        return bArr2;
    }

    @Override // p108j.InterfaceC1491y
    /* JADX INFO: renamed from: a */
    public void mo533a(MenuC1479m menuC1479m, boolean z3) {
    }

    @Override // p108j.InterfaceC1491y
    /* JADX INFO: renamed from: b */
    public boolean mo534b(MenuC1479m menuC1479m) {
        return false;
    }

    @Override // p059T1.InterfaceC0646b
    /* JADX INFO: renamed from: c */
    public void mo429c(C0647c c0647c) {
        int i3;
        int i4 = c0647c.f1729d;
        String str = c0647c.f1726a;
        int length = str.length();
        if (i4 < length) {
            char cCharAt = str.charAt(i4);
            i3 = 0;
            while (AbstractC1986a.m4380h(cCharAt) && i4 < length) {
                i3++;
                i4++;
                if (i4 < length) {
                    cCharAt = str.charAt(i4);
                }
            }
        } else {
            i3 = 0;
        }
        if (i3 >= 2) {
            char cCharAt2 = str.charAt(c0647c.f1729d);
            char cCharAt3 = str.charAt(c0647c.f1729d + 1);
            if (AbstractC1986a.m4380h(cCharAt2) && AbstractC1986a.m4380h(cCharAt3)) {
                c0647c.m1597d((char) ((cCharAt3 - '0') + ((cCharAt2 - '0') * 10) + 130));
                c0647c.f1729d += 2;
                return;
            } else {
                throw new IllegalArgumentException("not digits: " + cCharAt2 + cCharAt3);
            }
        }
        char cM1594a = c0647c.m1594a();
        int iM4383k = AbstractC1986a.m4383k(str, c0647c.f1729d, 0);
        if (iM4383k == 0) {
            if (!AbstractC1986a.m4381i(cM1594a)) {
                c0647c.m1597d((char) (cM1594a + 1));
                c0647c.f1729d++;
                return;
            } else {
                c0647c.m1597d((char) 235);
                c0647c.m1597d((char) (cM1594a - 127));
                c0647c.f1729d++;
                return;
            }
        }
        if (iM4383k == 1) {
            c0647c.m1597d((char) 230);
            c0647c.f1730e = 1;
            return;
        }
        if (iM4383k == 2) {
            c0647c.m1597d((char) 239);
            c0647c.f1730e = 2;
            return;
        }
        if (iM4383k == 3) {
            c0647c.m1597d((char) 238);
            c0647c.f1730e = 3;
        } else if (iM4383k == 4) {
            c0647c.m1597d((char) 240);
            c0647c.f1730e = 4;
        } else {
            if (iM4383k != 5) {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(iM4383k)));
            }
            c0647c.m1597d((char) 231);
            c0647c.f1730e = 5;
        }
    }

    @Override // p166z0.InterfaceC2075m
    /* JADX INFO: renamed from: d */
    public void mo430d(boolean z3) {
        boolean zM2863a;
        int i3 = 0;
        int i4 = 1;
        switch (this.f696e) {
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                if (z3) {
                    HashSet hashSet = AbstractC1117n.f3875a;
                    if (AbstractC1103F.m2866c()) {
                        AbstractC2077o.m4612a(new C0217a(i4), EnumC2076n.CrashReport);
                        AbstractC2077o.m4612a(new C0222f(i4), EnumC2076n.ErrorReport);
                        break;
                    }
                }
                break;
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                if (z3) {
                    HashSet hashSet2 = AbstractC1117n.f3875a;
                    AtomicBoolean atomicBoolean = AbstractC1103F.f3811a;
                    if (AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
                        zM2863a = false;
                    } else {
                        try {
                            AbstractC1103F.m2868e();
                            zM2863a = AbstractC1103F.f3817g.m2863a();
                        } catch (Throwable th) {
                            AbstractC0147a.m295a(th, AbstractC1103F.class);
                            zM2863a = false;
                        }
                    }
                    if (zM2863a) {
                        AbstractC2069g.m4584h();
                        C2079q c2079qM4621b = AbstractC2082t.m4621b(AbstractC1117n.f3877c);
                        if (c2079qM4621b != null && c2079qM4621b.f7359j) {
                            boolean z4 = AbstractC0219c.f524a;
                            Set set = AbstractC0147a.f354a;
                            if (!set.contains(AbstractC0219c.class)) {
                                try {
                                    if (!AbstractC0219c.f524a) {
                                        AbstractC0219c.f524a = true;
                                        if (!set.contains(AbstractC0219c.class)) {
                                            try {
                                                AbstractC1117n.m2891a().execute(new RunnableC0218b(i3));
                                            } catch (Throwable th2) {
                                                AbstractC0147a.m295a(th2, AbstractC0219c.class);
                                            }
                                        }
                                        AbstractC0219c.f525b.m437a();
                                        break;
                                    }
                                } catch (Throwable th3) {
                                    AbstractC0147a.m295a(th3, AbstractC0219c.class);
                                    return;
                                }
                                break;
                            }
                        }
                    }
                }
                break;
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
            default:
                if (z3) {
                    C1804n c1804n = AbstractC1795e.f6193a;
                    if (!AbstractC0147a.f354a.contains(AbstractC1795e.class)) {
                        try {
                            AbstractC1795e.f6197e.set(true);
                        } catch (Throwable th4) {
                            AbstractC0147a.m295a(th4, AbstractC1795e.class);
                            return;
                        }
                        break;
                    }
                } else {
                    C1804n c1804n2 = AbstractC1795e.f6193a;
                    if (!AbstractC0147a.f354a.contains(AbstractC1795e.class)) {
                        try {
                            AbstractC1795e.f6197e.set(false);
                        } catch (Throwable th5) {
                            AbstractC0147a.m295a(th5, AbstractC1795e.class);
                        }
                        break;
                    }
                }
                break;
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                if (z3) {
                    ConcurrentHashMap concurrentHashMap = AbstractC1918d.f6719a;
                    if (!AbstractC0147a.f354a.contains(AbstractC1918d.class)) {
                        try {
                            try {
                                AbstractC1117n.m2891a().execute(new RunnableC0218b(11));
                            } catch (Exception unused) {
                                return;
                            }
                        } catch (Throwable th6) {
                            AbstractC0147a.m295a(th6, AbstractC1918d.class);
                            return;
                        }
                        break;
                    }
                }
                break;
        }
    }

    /* JADX INFO: renamed from: f */
    public int m535f(Object obj) {
        return ((C0233j) obj).f560c;
    }

    /* JADX INFO: renamed from: g */
    public boolean m536g(Object obj) {
        return ((C0233j) obj).f561d;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0456 A[LOOP:13: B:225:0x0454->B:226:0x0456, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0220 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    @Override // p043N1.InterfaceC0562d
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p051Q1.C0601b mo434i(java.lang.String r28, int r29, java.util.EnumMap r30) throws p043N1.C0563e {
        /*
            Method dump skipped, instruction units count: 1480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p025H1.C0276e.mo434i(java.lang.String, int, java.util.EnumMap):Q1.b");
    }
}
