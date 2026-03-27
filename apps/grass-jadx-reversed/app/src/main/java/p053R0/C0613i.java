package p053R0;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: renamed from: R0.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0613i extends AbstractC0606b {
    /* JADX INFO: renamed from: c */
    public static BigDecimal m1433c(CharSequence charSequence, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j2;
        String str;
        int i9;
        boolean z3;
        int i10;
        long j3;
        String str2 = "illegal syntax";
        if (i3 > 1292782635) {
            throw new NumberFormatException("illegal syntax");
        }
        int i11 = 0;
        char cM1387a = AbstractC0606b.m1387a(charSequence, 0, i3);
        boolean z4 = cM1387a == '-';
        if (z4 || cM1387a == '+') {
            cM1387a = AbstractC0606b.m1387a(charSequence, 1, i3);
            if (cM1387a == 0) {
                throw new NumberFormatException("illegal syntax");
            }
            i4 = 1;
        } else {
            i4 = 0;
        }
        int i12 = i4;
        while (true) {
            i5 = i3 - 8;
            if (i12 >= i5) {
                break;
            }
            boolean z5 = true;
            for (int i13 = i11; i13 < 8; i13++) {
                z5 &= '0' == charSequence.charAt(i13 + i12);
            }
            if (!z5) {
                break;
            }
            i12 += 8;
            i11 = 0;
        }
        while (i12 < i3 && charSequence.charAt(i12) == '0') {
            i12++;
        }
        int i14 = i12;
        while (i14 < i5) {
            boolean zM1408a = true;
            for (int i15 = 0; i15 < 8; i15++) {
                zM1408a &= AbstractC0608d.m1408a(charSequence.charAt(i15 + i14));
            }
            if (!zM1408a) {
                break;
            }
            i14 += 8;
        }
        while (i14 < i3) {
            cM1387a = charSequence.charAt(i14);
            if (!AbstractC0608d.m1408a(cM1387a)) {
                break;
            }
            i14++;
        }
        if (cM1387a == '.') {
            int i16 = i14 + 1;
            while (i16 < i5) {
                boolean z6 = true;
                for (int i17 = 0; i17 < 8; i17++) {
                    z6 &= '0' == charSequence.charAt(i17 + i16);
                }
                if (!z6) {
                    break;
                }
                i16 += 8;
            }
            while (i16 < i3 && charSequence.charAt(i16) == '0') {
                i16++;
            }
            int i18 = i16;
            while (i18 < i5) {
                boolean zM1408a2 = true;
                for (int i19 = 0; i19 < 8; i19++) {
                    zM1408a2 &= AbstractC0608d.m1408a(charSequence.charAt(i19 + i18));
                }
                if (!zM1408a2) {
                    break;
                }
                i18 += 8;
            }
            while (i18 < i3) {
                cM1387a = charSequence.charAt(i18);
                if (!AbstractC0608d.m1408a(cM1387a)) {
                    break;
                }
                i18++;
            }
            int i20 = i16;
            i6 = i14;
            i14 = i18;
            i7 = i20;
        } else {
            i6 = -1;
            i7 = -1;
        }
        if (i6 < 0) {
            i6 = i14;
            i8 = i14 - i12;
            j2 = 0;
            i7 = i6;
        } else {
            i8 = i12 == i6 ? i14 - i7 : (i14 - i12) - 1;
            j2 = (i6 - i14) + 1;
        }
        if ((cM1387a | ' ') == 101) {
            i9 = i14 + 1;
            char cM1387a2 = AbstractC0606b.m1387a(charSequence, i9, i3);
            boolean z7 = cM1387a2 == '-';
            if (z7 || cM1387a2 == '+') {
                i9 = i14 + 2;
                cM1387a2 = AbstractC0606b.m1387a(charSequence, i9, i3);
            }
            boolean z8 = !AbstractC0608d.m1408a(cM1387a2);
            long j4 = 0;
            while (true) {
                if (j4 < 2147483647L) {
                    i10 = i14;
                    str = str2;
                    j4 = ((j4 * 10) + ((long) cM1387a2)) - 48;
                } else {
                    i10 = i14;
                    str = str2;
                }
                j3 = j4;
                i9++;
                char cM1387a3 = AbstractC0606b.m1387a(charSequence, i9, i3);
                if (!AbstractC0608d.m1408a(cM1387a3)) {
                    break;
                }
                j4 = j3;
                cM1387a2 = cM1387a3;
                str2 = str;
                i14 = i10;
            }
            if (z7) {
                j3 = -j3;
            }
            j2 += j3;
            z3 = z8;
        } else {
            str = "illegal syntax";
            i9 = i14;
            z3 = false;
            i10 = i3;
        }
        if (z3 || i9 < i3) {
            throw new NumberFormatException(str);
        }
        if (i10 - i4 == 0) {
            throw new NumberFormatException(str);
        }
        if (j2 < -2147483648L || j2 > 2147483647L || i8 > 1292782621) {
            throw new NumberFormatException("value exceeds limits");
        }
        return m1435e(charSequence, i12, i6, i7, i10, z4, (int) j2);
    }

    /* JADX INFO: renamed from: d */
    public static BigInteger m1434d(CharSequence charSequence, int i3, int i4, boolean z3) {
        int i5 = i4 - i3;
        if (i5 <= 18) {
            int i6 = (i5 & 7) + i3;
            long jM1415h = AbstractC0608d.m1415h(charSequence, i3, i6);
            boolean z4 = jM1415h >= 0;
            while (i6 < i4) {
                int iM1412e = AbstractC0608d.m1412e(charSequence, i6);
                z4 &= iM1412e >= 0;
                jM1415h = (jM1415h * 100000000) + ((long) iM1412e);
                i6 += 8;
            }
            if (!z4) {
                throw new NumberFormatException("illegal syntax");
            }
            if (z3) {
                jM1415h = -jM1415h;
            }
            return BigInteger.valueOf(jM1415h);
        }
        while (i3 < i4 && charSequence.charAt(i3) == '0') {
            i3++;
        }
        if (i4 - i3 > 646456993) {
            throw new NumberFormatException("value exceeds limits");
        }
        BigInteger bigInteger = AbstractC0610f.f1573a;
        TreeMap treeMap = new TreeMap();
        treeMap.put(0, BigInteger.valueOf(5L));
        treeMap.put(16, AbstractC0610f.f1575c);
        AbstractC0610f.m1419c(treeMap, i3, i4);
        for (Map.Entry entry : treeMap.entrySet()) {
            entry.setValue(((BigInteger) entry.getValue()).shiftLeft(((Integer) entry.getKey()).intValue()));
        }
        BigInteger bigIntegerM1409b = AbstractC0608d.m1409b(charSequence, i3, i4, treeMap);
        return z3 ? bigIntegerM1409b.negate() : bigIntegerM1409b;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.math.BigDecimal m1435e(java.lang.CharSequence r8, int r9, int r10, int r11, int r12, boolean r13, int r14) {
        /*
            int r0 = r12 - r10
            int r0 = r0 + (-1)
            int r1 = r12 - r11
            int r2 = r10 - r9
            r3 = 16
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 400(0x190, float:5.6E-43)
            r6 = 0
            if (r2 <= 0) goto L39
            if (r2 <= r5) goto L33
            java.math.BigInteger r2 = p053R0.AbstractC0610f.f1573a
            java.util.TreeMap r2 = new java.util.TreeMap
            r2.<init>()
            java.math.BigInteger r7 = java.math.BigInteger.ONE
            r2.put(r4, r7)
            java.math.BigInteger r7 = p053R0.AbstractC0610f.f1574b
            r2.put(r3, r7)
            p053R0.AbstractC0610f.m1419c(r2, r9, r10)
            java.math.BigInteger r9 = p053R0.AbstractC0608d.m1409b(r8, r9, r10, r2)
            goto L3c
        L33:
            java.math.BigInteger r9 = p053R0.AbstractC0608d.m1409b(r8, r9, r10, r6)
        L37:
            r2 = r6
            goto L3c
        L39:
            java.math.BigInteger r9 = java.math.BigInteger.ZERO
            goto L37
        L3c:
            if (r0 <= 0) goto L74
            if (r1 <= r5) goto L5b
            if (r2 != 0) goto L53
            java.math.BigInteger r10 = p053R0.AbstractC0610f.f1573a
            java.util.TreeMap r2 = new java.util.TreeMap
            r2.<init>()
            java.math.BigInteger r10 = java.math.BigInteger.ONE
            r2.put(r4, r10)
            java.math.BigInteger r10 = p053R0.AbstractC0610f.f1574b
            r2.put(r3, r10)
        L53:
            p053R0.AbstractC0610f.m1419c(r2, r11, r12)
            java.math.BigInteger r8 = p053R0.AbstractC0608d.m1409b(r8, r11, r12, r2)
            goto L5f
        L5b:
            java.math.BigInteger r8 = p053R0.AbstractC0608d.m1409b(r8, r11, r12, r6)
        L5f:
            int r10 = r9.signum()
            if (r10 != 0) goto L67
        L65:
            r9 = r8
            goto L74
        L67:
            java.math.BigInteger r10 = p053R0.AbstractC0610f.m1417a(r2, r0)
            java.math.BigInteger r9 = p053R0.AbstractC0612h.m1431k(r9, r10)
            java.math.BigInteger r8 = r9.add(r8)
            goto L65
        L74:
            java.math.BigDecimal r8 = new java.math.BigDecimal
            if (r13 == 0) goto L7c
            java.math.BigInteger r9 = r9.negate()
        L7c:
            int r10 = -r14
            r8.<init>(r9, r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p053R0.C0613i.m1435e(java.lang.CharSequence, int, int, int, int, boolean, int):java.math.BigDecimal");
    }
}
