package p053R0;

import java.math.BigInteger;

/* JADX INFO: renamed from: R0.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0612h {

    /* JADX INFO: renamed from: a */
    public static final double f1579a = Math.cos(0.7853981633974483d);

    /* JADX INFO: renamed from: b */
    public static final double f1580b = Math.sin(0.7853981633974483d);

    /* JADX INFO: renamed from: c */
    public static volatile C0607c[] f1581c = new C0607c[20];

    /* JADX INFO: renamed from: d */
    public static volatile C0607c[] f1582d = new C0607c[20];

    /* JADX INFO: renamed from: a */
    public static int m1421a(int i3) {
        if (i3 <= 9728) {
            return 19;
        }
        if (i3 <= 18432) {
            return 18;
        }
        if (i3 <= 69632) {
            return 17;
        }
        if (i3 <= 262144) {
            return 16;
        }
        if (i3 <= 983040) {
            return 15;
        }
        if (i3 <= 3670016) {
            return 14;
        }
        if (i3 <= 13631488) {
            return 13;
        }
        if (i3 <= 25165824) {
            return 12;
        }
        if (i3 <= 92274688) {
            return 11;
        }
        if (i3 <= 335544320) {
            return 10;
        }
        return i3 <= 1207959552 ? 9 : 8;
    }

    /* JADX INFO: renamed from: b */
    public static C0607c m1422b(int i3) {
        if (i3 == 1) {
            C0607c c0607c = new C0607c(1);
            c0607c.m1402o(0, 1.0d);
            c0607c.m1393e(0, 0.0d);
            return c0607c;
        }
        C0607c c0607c2 = new C0607c(i3);
        c0607c2.m1404q(0, 1.0d, 0.0d);
        int i4 = i3 / 2;
        c0607c2.m1404q(i4, f1579a, f1580b);
        double d = 1.5707963267948966d / ((double) i3);
        for (int i5 = 1; i5 < i4; i5++) {
            double d3 = ((double) i5) * d;
            double dCos = Math.cos(d3);
            double dSin = Math.sin(d3);
            c0607c2.m1404q(i5, dCos, dSin);
            c0607c2.m1404q(i3 - i5, dSin, dCos);
        }
        return c0607c2;
    }

    /* JADX INFO: renamed from: c */
    public static void m1423c(C0607c c0607c, C0607c[] c0607cArr) {
        double[] dArr;
        int i3 = c0607c.f1566f;
        int iNumberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i3);
        while (true) {
            dArr = (double[]) c0607c.f1568h;
            if (iNumberOfLeadingZeros < 2) {
                break;
            }
            C0607c c0607c2 = c0607cArr[iNumberOfLeadingZeros - 2];
            int i4 = 1 << iNumberOfLeadingZeros;
            int i5 = 0;
            while (i5 < i3) {
                int i6 = 0;
                while (true) {
                    int i7 = i4 / 4;
                    if (i6 < i7) {
                        double dM1401n = c0607c2.m1401n(i6);
                        double dM1392d = c0607c2.m1392d(i6);
                        double d = (dM1401n * dM1401n) + ((-dM1392d) * dM1392d);
                        double d3 = 2.0d * dM1401n * dM1392d;
                        int i8 = i5 + i6;
                        int i9 = i7 + i8;
                        C0607c c0607c3 = c0607c2;
                        int i10 = (i4 / 2) + i8;
                        int i11 = i3;
                        int i12 = ((i4 * 3) / 4) + i8;
                        double dM1401n2 = c0607c.m1401n(i9) + dArr[c0607c.m1403p(i8)];
                        double dM1392d2 = c0607c.m1392d(i9) + dArr[c0607c.m1394f(i8)];
                        double dM1401n3 = c0607c.m1401n(i10) + dM1401n2;
                        double dM1392d3 = c0607c.m1392d(i10) + dM1392d2;
                        int i13 = i4;
                        double dM1401n4 = c0607c.m1401n(i12) + dM1401n3;
                        double dM1392d4 = c0607c.m1392d(i12) + dM1392d3;
                        double dM1392d5 = c0607c.m1392d(i9) + dArr[c0607c.m1403p(i8)];
                        double dM1401n5 = dArr[c0607c.m1394f(i8)] - c0607c.m1401n(i9);
                        double dM1401n6 = dM1392d5 - c0607c.m1401n(i10);
                        double dM1392d6 = dM1401n5 - c0607c.m1392d(i10);
                        double dM1392d7 = dM1401n6 - c0607c.m1392d(i12);
                        double dM1401n7 = c0607c.m1401n(i12) + dM1392d6;
                        double d4 = (dM1392d7 * dM1401n) + (dM1401n7 * dM1392d);
                        double d5 = ((-dM1392d7) * dM1392d) + (dM1401n7 * dM1401n);
                        double dM1401n8 = dArr[c0607c.m1403p(i8)] - c0607c.m1401n(i9);
                        double dM1392d8 = dArr[c0607c.m1394f(i8)] - c0607c.m1392d(i9);
                        double dM1401n9 = c0607c.m1401n(i10) + dM1401n8;
                        double dM1392d9 = c0607c.m1392d(i10) + dM1392d8;
                        double dM1401n10 = dM1401n9 - c0607c.m1401n(i12);
                        double dM1392d10 = dM1392d9 - c0607c.m1392d(i12);
                        double d6 = (dM1401n10 * d) + (dM1392d10 * d3);
                        double d7 = ((-dM1401n10) * d3) + (dM1392d10 * d);
                        double dM1392d11 = dArr[c0607c.m1403p(i8)] - c0607c.m1392d(i9);
                        double dM1401n11 = c0607c.m1401n(i9) + dArr[c0607c.m1394f(i8)];
                        double dM1401n12 = dM1392d11 - c0607c.m1401n(i10);
                        double dM1392d12 = dM1401n11 - c0607c.m1392d(i10);
                        double dM1392d13 = c0607c.m1392d(i12) + dM1401n12;
                        double dM1401n13 = dM1392d12 - c0607c.m1401n(i12);
                        c0607c.m1402o(i8, dM1401n4);
                        c0607c.m1393e(i8, dM1392d4);
                        c0607c.m1402o(i9, d4);
                        c0607c.m1393e(i9, d5);
                        c0607c.m1402o(i10, d6);
                        c0607c.m1393e(i10, d7);
                        c0607c.m1402o(i12, (dM1392d13 * dM1401n) + ((-dM1401n13) * dM1392d));
                        c0607c.m1393e(i12, (dM1392d13 * dM1392d) + (dM1401n13 * dM1401n));
                        i6++;
                        i4 = i13;
                        c0607c2 = c0607c3;
                        i3 = i11;
                        i5 = i5;
                        iNumberOfLeadingZeros = iNumberOfLeadingZeros;
                    }
                }
                i5 += i4;
            }
            iNumberOfLeadingZeros -= 2;
        }
        int i14 = i3;
        if (iNumberOfLeadingZeros > 0) {
            for (int i15 = 0; i15 < i14; i15 += 2) {
                double d8 = dArr[c0607c.m1403p(i15)];
                double d9 = dArr[c0607c.m1394f(i15)];
                int i16 = i15 + 1;
                double d10 = dArr[c0607c.m1403p(i16)];
                double d11 = dArr[c0607c.m1394f(i16)];
                int iM1403p = c0607c.m1403p(i15);
                dArr[iM1403p] = dArr[iM1403p] + d10;
                int iM1394f = c0607c.m1394f(i15);
                dArr[iM1394f] = dArr[iM1394f] + d11;
                c0607c.m1402o(i16, d8 - d10);
                c0607c.m1393e(i16, d9 - d11);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1424d(C0607c c0607c, C0607c c0607c2, C0607c c0607c3, int i3, double d) {
        double dSqrt = Math.sqrt(3.0d) * ((double) i3) * (-0.5d);
        for (int i4 = 0; i4 < c0607c.f1566f; i4++) {
            double dM1401n = c0607c3.m1401n(i4) + c0607c2.m1401n(i4) + c0607c.m1401n(i4);
            double dM1392d = c0607c3.m1392d(i4) + c0607c2.m1392d(i4) + c0607c.m1392d(i4);
            double dM1392d2 = (c0607c3.m1392d(i4) - c0607c2.m1392d(i4)) * dSqrt;
            double dM1401n2 = (c0607c2.m1401n(i4) - c0607c3.m1401n(i4)) * dSqrt;
            double dM1401n3 = (c0607c3.m1401n(i4) + c0607c2.m1401n(i4)) * 0.5d;
            double dM1392d3 = (c0607c3.m1392d(i4) + c0607c2.m1392d(i4)) * 0.5d;
            double dM1401n4 = (c0607c.m1401n(i4) - dM1401n3) + dM1392d2;
            double dM1392d4 = (c0607c.m1392d(i4) + dM1401n2) - dM1392d3;
            double dM1401n5 = (c0607c.m1401n(i4) - dM1401n3) - dM1392d2;
            double dM1392d5 = (c0607c.m1392d(i4) - dM1401n2) - dM1392d3;
            c0607c.m1402o(i4, dM1401n * d);
            c0607c.m1393e(i4, dM1392d * d);
            c0607c2.m1402o(i4, dM1401n4 * d);
            c0607c2.m1393e(i4, dM1392d4 * d);
            c0607c3.m1402o(i4, dM1401n5 * d);
            c0607c3.m1393e(i4, dM1392d5 * d);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1425e(C0607c c0607c, C0607c[] c0607cArr, C0607c c0607c2) {
        int i3;
        int i4 = c0607c.f1566f;
        int i5 = i4 / 3;
        int i6 = 0;
        C0607c c0607c3 = new C0607c(0, i5, c0607c);
        int i7 = i5 * 2;
        C0607c c0607c4 = new C0607c(i5, i7, c0607c);
        C0607c c0607c5 = new C0607c(i7, i4, c0607c);
        m1424d(c0607c3, c0607c4, c0607c5, 1, 1.0d);
        C0611g c0611g = new C0611g();
        while (true) {
            i3 = i4 / 4;
            if (i6 >= i3) {
                break;
            }
            c0611g.f1577a = c0607c2.m1401n(i6);
            c0611g.f1578b = c0607c2.m1392d(i6);
            c0607c4.m1397j(i6, c0611g);
            c0607c5.m1397j(i6, c0611g);
            c0607c5.m1397j(i6, c0611g);
            i6++;
        }
        for (int i8 = i3; i8 < i5; i8++) {
            int i9 = i8 - i3;
            c0611g.f1577a = c0607c2.m1401n(i9);
            c0611g.f1578b = c0607c2.m1392d(i9);
            c0607c4.m1398k(i8, c0611g);
            c0607c5.m1398k(i8, c0611g);
            c0607c5.m1398k(i8, c0611g);
        }
        m1423c(c0607c3, c0607cArr);
        m1423c(c0607c4, c0607cArr);
        m1423c(c0607c5, c0607cArr);
    }

    /* JADX INFO: renamed from: f */
    public static BigInteger m1426f(int i3, int i4, C0607c c0607c) {
        C0607c c0607c2 = c0607c;
        long j2 = i4;
        int iMin = (int) Math.min(c0607c2.f1566f, (2147483648L / j2) + 1);
        int i5 = (int) ((((((long) iMin) * j2) + 31) * 8) / 32);
        byte[] bArr = new byte[i5];
        int i6 = 1;
        int i7 = (1 << i4) - 1;
        int i8 = 32 - i4;
        int i9 = (i5 * 8) - i4;
        int i10 = 0;
        int i11 = i5 - 4;
        int iMin2 = Math.min(Math.max(0, i9 >> 3), i11);
        long j3 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 <= i6) {
            int i14 = i10;
            while (i14 < iMin) {
                long jRound = Math.round(((double[]) c0607c2.f1568h)[(i14 << 1) + i12]) + j3;
                int iMin3 = Math.min(Math.max(i10, i9 >> 3), i11);
                i13 = (int) (((jRound & ((long) i7)) << ((i8 - i9) + (iMin3 << 3))) | ((long) (i13 >>> ((iMin2 - iMin3) << 3))));
                AbstractC0608d.m1416i(iMin3, bArr, i13);
                i9 -= i4;
                i14++;
                c0607c2 = c0607c;
                iMin2 = iMin3;
                j3 = jRound >> i4;
                iMin = iMin;
                i10 = 0;
            }
            i12++;
            c0607c2 = c0607c;
            i6 = 1;
            i10 = 0;
        }
        return new BigInteger(i3, bArr);
    }

    /* JADX INFO: renamed from: g */
    public static C0607c[] m1427g(int i3) {
        C0607c[] c0607cArr = new C0607c[i3 + 1];
        while (i3 >= 0) {
            if (i3 < 20) {
                if (f1581c[i3] == null) {
                    f1581c[i3] = m1422b(1 << i3);
                }
                c0607cArr[i3] = f1581c[i3];
            } else {
                c0607cArr[i3] = m1422b(1 << i3);
            }
            i3 -= 2;
        }
        return c0607cArr;
    }

    /* JADX INFO: renamed from: h */
    public static C0607c m1428h(int i3) {
        if (i3 >= 20) {
            return m1422b(3 << i3);
        }
        if (f1582d[i3] == null) {
            f1582d[i3] = m1422b(3 << i3);
        }
        return f1582d[i3];
    }

    /* JADX INFO: renamed from: i */
    public static void m1429i(C0607c c0607c, C0607c[] c0607cArr) {
        int i3;
        int i4 = c0607c.f1566f;
        int iNumberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i4);
        int i5 = iNumberOfLeadingZeros % 2;
        int i6 = 1;
        double[] dArr = (double[]) c0607c.f1568h;
        if (i5 != 0) {
            for (int i7 = 0; i7 < i4; i7 += 2) {
                int i8 = i7 + 1;
                double d = dArr[c0607c.m1403p(i8)];
                double d3 = dArr[c0607c.m1394f(i8)];
                double d4 = dArr[c0607c.m1403p(i7)];
                double d5 = dArr[c0607c.m1394f(i7)];
                int iM1403p = c0607c.m1403p(i7);
                dArr[iM1403p] = dArr[iM1403p] + d;
                int iM1394f = c0607c.m1394f(i7);
                dArr[iM1394f] = dArr[iM1394f] + d3;
                c0607c.m1402o(i8, d4 - d);
                c0607c.m1393e(i8, d5 - d3);
            }
            i3 = 2;
        } else {
            i3 = 1;
        }
        while (i3 <= iNumberOfLeadingZeros) {
            C0607c c0607c2 = c0607cArr[i3 - 1];
            int i9 = i6 << (i3 + 1);
            int i10 = 0;
            while (i10 < i4) {
                int i11 = 0;
                while (true) {
                    int i12 = i9 / 4;
                    if (i11 < i12) {
                        double dM1401n = c0607c2.m1401n(i11);
                        double dM1392d = c0607c2.m1392d(i11);
                        double d6 = (dM1401n * dM1401n) + ((-dM1392d) * dM1392d);
                        double d7 = 2.0d * dM1401n * dM1392d;
                        int i13 = i10 + i11;
                        int i14 = i12 + i13;
                        int i15 = iNumberOfLeadingZeros;
                        int i16 = (i9 / 2) + i13;
                        int i17 = i4;
                        int i18 = ((i9 * 3) / 4) + i13;
                        double d8 = dArr[c0607c.m1403p(i13)];
                        double d9 = dArr[c0607c.m1394f(i13)];
                        double d10 = dArr[c0607c.m1403p(i14)];
                        int i19 = i9;
                        double d11 = dArr[c0607c.m1394f(i14)];
                        int i20 = i11;
                        double d12 = (d10 * dM1401n) + ((-d11) * dM1392d);
                        double d13 = (d10 * dM1392d) + (d11 * dM1401n);
                        double d14 = dArr[c0607c.m1403p(i16)];
                        double d15 = dArr[c0607c.m1394f(i16)];
                        double d16 = (d14 * d6) + ((-d15) * d7);
                        double d17 = (d14 * d7) + (d15 * d6);
                        double d18 = dArr[c0607c.m1403p(i18)];
                        double d19 = dArr[c0607c.m1394f(i18)];
                        double d20 = (d18 * dM1401n) + (d19 * dM1392d);
                        double d21 = ((-d18) * dM1392d) + (d19 * dM1401n);
                        c0607c.m1402o(i13, d8 + d12 + d16 + d20);
                        c0607c.m1393e(i13, d9 + d13 + d17 + d21);
                        c0607c.m1402o(i14, ((d8 - d13) - d16) + d21);
                        c0607c.m1393e(i14, ((d9 + d12) - d17) - d20);
                        c0607c.m1402o(i16, ((d8 - d12) + d16) - d20);
                        c0607c.m1393e(i16, ((d9 - d13) + d17) - d21);
                        c0607c.m1402o(i18, ((d8 + d13) - d16) - d21);
                        c0607c.m1393e(i18, ((d9 - d12) - d17) + d20);
                        i11 = i20 + 1;
                        c0607c2 = c0607c2;
                        iNumberOfLeadingZeros = i15;
                        i4 = i17;
                        i9 = i19;
                        i10 = i10;
                        i3 = i3;
                    }
                }
                i10 += i9;
            }
            i3 += 2;
            i6 = 1;
        }
        int i21 = iNumberOfLeadingZeros;
        int i22 = 0;
        while (i22 < i4) {
            int i23 = i21;
            int i24 = -i23;
            int iM1403p2 = c0607c.m1403p(i22);
            int iM1394f2 = c0607c.m1394f(i22);
            double d22 = dArr[iM1403p2];
            double d23 = dArr[iM1394f2];
            dArr[iM1403p2] = Math.scalb(d22, i24);
            dArr[iM1394f2] = Math.scalb(d23, i24);
            i22++;
            i21 = i23;
        }
    }

    /* JADX INFO: renamed from: j */
    public static void m1430j(C0607c c0607c, C0607c[] c0607cArr, C0607c c0607c2) {
        int i3;
        int i4 = c0607c.f1566f;
        int i5 = i4 / 3;
        int i6 = 0;
        C0607c c0607c3 = new C0607c(0, i5, c0607c);
        int i7 = i5 * 2;
        C0607c c0607c4 = new C0607c(i5, i7, c0607c);
        C0607c c0607c5 = new C0607c(i7, i4, c0607c);
        m1429i(c0607c3, c0607cArr);
        m1429i(c0607c4, c0607cArr);
        m1429i(c0607c5, c0607cArr);
        C0611g c0611g = new C0611g();
        while (true) {
            i3 = i4 / 4;
            if (i6 >= i3) {
                break;
            }
            c0611g.f1577a = c0607c2.m1401n(i6);
            c0611g.f1578b = c0607c2.m1392d(i6);
            c0607c4.m1395g(i6, c0611g);
            c0607c5.m1395g(i6, c0611g);
            c0607c5.m1395g(i6, c0611g);
            i6++;
        }
        for (int i8 = i3; i8 < i5; i8++) {
            int i9 = i8 - i3;
            c0611g.f1577a = c0607c2.m1401n(i9);
            c0611g.f1578b = c0607c2.m1392d(i9);
            c0607c4.m1396i(i8, c0611g);
            c0607c5.m1396i(i8, c0611g);
            c0607c5.m1396i(i8, c0611g);
        }
        m1424d(c0607c3, c0607c4, c0607c5, -1, 0.3333333333333333d);
    }

    /* JADX INFO: renamed from: k */
    public static BigInteger m1431k(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger2.signum() == 0 || bigInteger.signum() == 0) {
            return BigInteger.ZERO;
        }
        if (bigInteger2 == bigInteger) {
            if (bigInteger2.signum() == 0) {
                return BigInteger.ZERO;
            }
            if (bigInteger2.bitLength() < 33220) {
                return bigInteger2.multiply(bigInteger2);
            }
            byte[] byteArray = bigInteger2.toByteArray();
            int length = byteArray.length * 8;
            int iM1421a = m1421a(length);
            int i3 = ((length + iM1421a) - 1) / iM1421a;
            int i4 = i3 + 1;
            int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i3);
            int i5 = 32 - iNumberOfLeadingZeros;
            int i6 = 1 << i5;
            int i7 = (i6 * 3) / 4;
            if (i4 >= i7) {
                C0607c c0607cM1432l = m1432l(i6, byteArray, iM1421a);
                C0607c[] c0607cArrM1427g = m1427g(i5);
                c0607cM1432l.m1390b(c0607cArrM1427g[i5]);
                m1423c(c0607cM1432l, c0607cArrM1427g);
                c0607cM1432l.m1407t();
                m1429i(c0607cM1432l, c0607cArrM1427g);
                c0607cM1432l.m1389a(c0607cArrM1427g[i5]);
                return m1426f(1, iM1421a, c0607cM1432l);
            }
            C0607c c0607cM1432l2 = m1432l(i7, byteArray, iM1421a);
            int i8 = 30 - iNumberOfLeadingZeros;
            C0607c[] c0607cArrM1427g2 = m1427g(i8);
            C0607c c0607cM1428h = m1428h(i8);
            C0607c c0607cM1428h2 = m1428h(28 - iNumberOfLeadingZeros);
            c0607cM1432l2.m1390b(c0607cM1428h);
            m1425e(c0607cM1432l2, c0607cArrM1427g2, c0607cM1428h2);
            c0607cM1432l2.m1407t();
            m1430j(c0607cM1432l2, c0607cArrM1427g2, c0607cM1428h2);
            c0607cM1432l2.m1389a(c0607cM1428h);
            return m1426f(1, iM1421a, c0607cM1432l2);
        }
        int iBitLength = bigInteger.bitLength();
        int iBitLength2 = bigInteger2.bitLength();
        if (((long) iBitLength) + ((long) iBitLength2) > 2147483648L) {
            throw new ArithmeticException("BigInteger would overflow supported range");
        }
        if (iBitLength <= 1920 || iBitLength2 <= 1920 || (iBitLength <= 33220 && iBitLength2 <= 33220)) {
            return bigInteger.multiply(bigInteger2);
        }
        int iSignum = bigInteger2.signum() * bigInteger.signum();
        if (bigInteger.signum() < 0) {
            bigInteger = bigInteger.negate();
        }
        byte[] byteArray2 = bigInteger.toByteArray();
        if (bigInteger2.signum() < 0) {
            bigInteger2 = bigInteger2.negate();
        }
        byte[] byteArray3 = bigInteger2.toByteArray();
        int iMax = Math.max(byteArray2.length, byteArray3.length) * 8;
        int iM1421a2 = m1421a(iMax);
        int i9 = ((iMax + iM1421a2) - 1) / iM1421a2;
        int i10 = i9 + 1;
        int iNumberOfLeadingZeros2 = Integer.numberOfLeadingZeros(i9);
        int i11 = 32 - iNumberOfLeadingZeros2;
        int i12 = 1 << i11;
        int i13 = (i12 * 3) / 4;
        if (i10 >= i13 || i11 <= 3) {
            C0607c[] c0607cArrM1427g3 = m1427g(i11);
            C0607c c0607cM1432l3 = m1432l(i12, byteArray2, iM1421a2);
            c0607cM1432l3.m1390b(c0607cArrM1427g3[i11]);
            m1423c(c0607cM1432l3, c0607cArrM1427g3);
            C0607c c0607cM1432l4 = m1432l(i12, byteArray3, iM1421a2);
            c0607cM1432l4.m1390b(c0607cArrM1427g3[i11]);
            m1423c(c0607cM1432l4, c0607cArrM1427g3);
            c0607cM1432l3.m1399l(c0607cM1432l4);
            m1429i(c0607cM1432l3, c0607cArrM1427g3);
            c0607cM1432l3.m1389a(c0607cArrM1427g3[i11]);
            return m1426f(iSignum, iM1421a2, c0607cM1432l3);
        }
        int i14 = 30 - iNumberOfLeadingZeros2;
        C0607c[] c0607cArrM1427g4 = m1427g(i14);
        C0607c c0607cM1428h3 = m1428h(i14);
        C0607c c0607cM1428h4 = m1428h(28 - iNumberOfLeadingZeros2);
        C0607c c0607cM1432l5 = m1432l(i13, byteArray2, iM1421a2);
        c0607cM1432l5.m1390b(c0607cM1428h3);
        m1425e(c0607cM1432l5, c0607cArrM1427g4, c0607cM1428h4);
        C0607c c0607cM1432l6 = m1432l(i13, byteArray3, iM1421a2);
        c0607cM1432l6.m1390b(c0607cM1428h3);
        m1425e(c0607cM1432l6, c0607cArrM1427g4, c0607cM1428h4);
        c0607cM1432l5.m1399l(c0607cM1432l6);
        m1430j(c0607cM1432l5, c0607cArrM1427g4, c0607cM1428h4);
        c0607cM1432l5.m1389a(c0607cM1428h3);
        return m1426f(iSignum, iM1421a2, c0607cM1432l5);
    }

    /* JADX INFO: renamed from: l */
    public static C0607c m1432l(int i3, byte[] bArr, int i4) {
        C0607c c0607c = new C0607c(i3);
        if (bArr.length < 4) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 4 - bArr.length, bArr.length);
            bArr = bArr2;
        }
        int i5 = 1 << i4;
        int i6 = i5 / 2;
        int i7 = i5 - 1;
        int i8 = 32 - i4;
        int length = (bArr.length * 8) - i4;
        int i9 = 0;
        int i10 = 0;
        while (length > (-i4)) {
            int iMin = Math.min(Math.max(0, length >> 3), bArr.length - 4);
            i9 = (i6 - (((((bArr[iMin + 3] & 255) | ((((bArr[iMin] & 255) << 24) | ((bArr[iMin + 1] & 255) << 16)) | ((bArr[iMin + 2] & 255) << 8))) >>> ((i8 - length) + (iMin << 3))) & i7) + i9)) >>> 31;
            c0607c.m1402o(i10, r9 - ((-i9) & i5));
            i10++;
            length -= i4;
        }
        if (i9 > 0) {
            c0607c.m1402o(i10, i9);
        }
        return c0607c;
    }
}
