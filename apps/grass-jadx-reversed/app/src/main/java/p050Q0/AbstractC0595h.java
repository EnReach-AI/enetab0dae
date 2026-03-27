package p050Q0;

/* JADX INFO: renamed from: Q0.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0595h {

    /* JADX INFO: renamed from: a */
    public static final String f1524a = String.valueOf(Integer.MIN_VALUE);

    /* JADX INFO: renamed from: b */
    public static final String f1525b = String.valueOf(Long.MIN_VALUE);

    /* JADX INFO: renamed from: c */
    public static final int[] f1526c = new int[1000];

    /* JADX INFO: renamed from: d */
    public static final String[] f1527d;

    /* JADX INFO: renamed from: e */
    public static final String[] f1528e;

    static {
        int i3 = 0;
        for (int i4 = 0; i4 < 10; i4++) {
            for (int i5 = 0; i5 < 10; i5++) {
                int i6 = 0;
                while (i6 < 10) {
                    f1526c[i3] = ((i4 + 48) << 16) | ((i5 + 48) << 8) | (i6 + 48);
                    i6++;
                    i3++;
                }
            }
        }
        f1527d = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        f1528e = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    /* JADX INFO: renamed from: a */
    public static int m1352a(int i3, byte[] bArr, int i4) {
        int i5 = f1526c[i3];
        bArr[i4] = (byte) (i5 >> 16);
        int i6 = i4 + 2;
        bArr[i4 + 1] = (byte) (i5 >> 8);
        int i7 = i4 + 3;
        bArr[i6] = (byte) i5;
        return i7;
    }

    /* JADX INFO: renamed from: b */
    public static int m1353b(int i3, char[] cArr, int i4) {
        int i5 = f1526c[i3];
        cArr[i4] = (char) (i5 >> 16);
        int i6 = i4 + 2;
        cArr[i4 + 1] = (char) ((i5 >> 8) & 127);
        int i7 = i4 + 3;
        cArr[i6] = (char) (i5 & 127);
        return i7;
    }

    /* JADX INFO: renamed from: c */
    public static int m1354c(int i3, byte[] bArr, int i4) {
        int i5 = f1526c[i3];
        if (i3 > 9) {
            if (i3 > 99) {
                bArr[i4] = (byte) (i5 >> 16);
                i4++;
            }
            bArr[i4] = (byte) (i5 >> 8);
            i4++;
        }
        int i6 = i4 + 1;
        bArr[i4] = (byte) i5;
        return i6;
    }

    /* JADX INFO: renamed from: d */
    public static int m1355d(int i3, char[] cArr, int i4) {
        int i5 = f1526c[i3];
        if (i3 > 9) {
            if (i3 > 99) {
                cArr[i4] = (char) (i5 >> 16);
                i4++;
            }
            cArr[i4] = (char) ((i5 >> 8) & 127);
            i4++;
        }
        int i6 = i4 + 1;
        cArr[i4] = (char) (i5 & 127);
        return i6;
    }

    /* JADX INFO: renamed from: e */
    public static int m1356e(int i3, byte[] bArr, int i4) {
        int i5 = i3 / 1000;
        int i6 = i3 - (i5 * 1000);
        int i7 = i5 / 1000;
        int i8 = i5 - (i7 * 1000);
        int[] iArr = f1526c;
        int i9 = iArr[i7];
        bArr[i4] = (byte) (i9 >> 16);
        bArr[i4 + 1] = (byte) (i9 >> 8);
        bArr[i4 + 2] = (byte) i9;
        int i10 = iArr[i8];
        bArr[i4 + 3] = (byte) (i10 >> 16);
        bArr[i4 + 4] = (byte) (i10 >> 8);
        bArr[i4 + 5] = (byte) i10;
        int i11 = iArr[i6];
        bArr[i4 + 6] = (byte) (i11 >> 16);
        int i12 = i4 + 8;
        bArr[i4 + 7] = (byte) (i11 >> 8);
        int i13 = i4 + 9;
        bArr[i12] = (byte) i11;
        return i13;
    }

    /* JADX INFO: renamed from: f */
    public static int m1357f(int i3, char[] cArr, int i4) {
        int i5 = i3 / 1000;
        int i6 = i3 - (i5 * 1000);
        int i7 = i5 / 1000;
        int[] iArr = f1526c;
        int i8 = iArr[i7];
        cArr[i4] = (char) (i8 >> 16);
        cArr[i4 + 1] = (char) ((i8 >> 8) & 127);
        cArr[i4 + 2] = (char) (i8 & 127);
        int i9 = iArr[i5 - (i7 * 1000)];
        cArr[i4 + 3] = (char) (i9 >> 16);
        cArr[i4 + 4] = (char) ((i9 >> 8) & 127);
        cArr[i4 + 5] = (char) (i9 & 127);
        int i10 = iArr[i6];
        cArr[i4 + 6] = (char) (i10 >> 16);
        int i11 = i4 + 8;
        cArr[i4 + 7] = (char) ((i10 >> 8) & 127);
        int i12 = i4 + 9;
        cArr[i11] = (char) (i10 & 127);
        return i12;
    }

    /* JADX INFO: renamed from: g */
    public static int m1358g(int i3, byte[] bArr, int i4) {
        int i5;
        if (i3 < 0) {
            if (i3 == Integer.MIN_VALUE) {
                String str = f1524a;
                int length = str.length();
                int i6 = 0;
                while (i6 < length) {
                    bArr[i4] = (byte) str.charAt(i6);
                    i6++;
                    i4++;
                }
                return i4;
            }
            bArr[i4] = 45;
            i3 = -i3;
            i4++;
        }
        if (i3 < 1000000) {
            if (i3 >= 1000) {
                int i7 = i3 / 1000;
                return m1352a(i3 - (i7 * 1000), bArr, m1354c(i7, bArr, i4));
            }
            if (i3 >= 10) {
                return m1354c(i3, bArr, i4);
            }
            int i8 = i4 + 1;
            bArr[i4] = (byte) (i3 + 48);
            return i8;
        }
        if (i3 < 1000000000) {
            int i9 = i3 / 1000;
            int i10 = i9 / 1000;
            return m1352a(i3 - (i9 * 1000), bArr, m1352a(i9 - (i10 * 1000), bArr, m1354c(i10, bArr, i4)));
        }
        int i11 = i3 - 1000000000;
        if (i11 >= 1000000000) {
            i11 = i3 - 2000000000;
            i5 = i4 + 1;
            bArr[i4] = 50;
        } else {
            i5 = i4 + 1;
            bArr[i4] = 49;
        }
        return m1356e(i11, bArr, i5);
    }

    /* JADX INFO: renamed from: h */
    public static int m1359h(int i3, char[] cArr, int i4) {
        int i5;
        if (i3 < 0) {
            if (i3 == Integer.MIN_VALUE) {
                String str = f1524a;
                int length = str.length();
                str.getChars(0, length, cArr, i4);
                return length + i4;
            }
            cArr[i4] = '-';
            i3 = -i3;
            i4++;
        }
        if (i3 < 1000000) {
            if (i3 >= 1000) {
                int i6 = i3 / 1000;
                return m1353b(i3 - (i6 * 1000), cArr, m1355d(i6, cArr, i4));
            }
            if (i3 >= 10) {
                return m1355d(i3, cArr, i4);
            }
            cArr[i4] = (char) (i3 + 48);
            return i4 + 1;
        }
        if (i3 < 1000000000) {
            int i7 = i3 / 1000;
            int i8 = i7 / 1000;
            return m1353b(i3 - (i7 * 1000), cArr, m1353b(i7 - (i8 * 1000), cArr, m1355d(i8, cArr, i4)));
        }
        int i9 = i3 - 1000000000;
        if (i9 >= 1000000000) {
            i9 = i3 - 2000000000;
            i5 = i4 + 1;
            cArr[i4] = '2';
        } else {
            i5 = i4 + 1;
            cArr[i4] = '1';
        }
        return m1357f(i9, cArr, i5);
    }

    /* JADX INFO: renamed from: i */
    public static int m1360i(long j2, byte[] bArr, int i3) {
        int iM1356e;
        if (j2 < 0) {
            if (j2 > -2147483648L) {
                return m1358g((int) j2, bArr, i3);
            }
            if (j2 == Long.MIN_VALUE) {
                String str = f1525b;
                int length = str.length();
                int i4 = 0;
                while (i4 < length) {
                    bArr[i3] = (byte) str.charAt(i4);
                    i4++;
                    i3++;
                }
                return i3;
            }
            bArr[i3] = 45;
            j2 = -j2;
            i3++;
        } else if (j2 <= 2147483647L) {
            return m1358g((int) j2, bArr, i3);
        }
        long j3 = j2 / 1000000000;
        long j4 = j2 - (j3 * 1000000000);
        if (j3 < 1000000000) {
            int i5 = (int) j3;
            int[] iArr = f1526c;
            if (i5 >= 1000000) {
                int i6 = i5 / 1000;
                int i7 = i5 - (i6 * 1000);
                int i8 = i6 / 1000;
                int iM1354c = m1354c(i8, bArr, i3);
                int i9 = iArr[i6 - (i8 * 1000)];
                bArr[iM1354c] = (byte) (i9 >> 16);
                bArr[iM1354c + 1] = (byte) (i9 >> 8);
                bArr[iM1354c + 2] = (byte) i9;
                int i10 = iArr[i7];
                bArr[iM1354c + 3] = (byte) (i10 >> 16);
                int i11 = iM1354c + 5;
                bArr[iM1354c + 4] = (byte) (i10 >> 8);
                iM1356e = iM1354c + 6;
                bArr[i11] = (byte) i10;
            } else if (i5 < 1000) {
                iM1356e = m1354c(i5, bArr, i3);
            } else {
                int i12 = i5 / 1000;
                int i13 = i5 - (i12 * 1000);
                int i14 = iArr[i12];
                if (i12 > 9) {
                    if (i12 > 99) {
                        bArr[i3] = (byte) (i14 >> 16);
                        i3++;
                    }
                    bArr[i3] = (byte) (i14 >> 8);
                    i3++;
                }
                bArr[i3] = (byte) i14;
                int i15 = iArr[i13];
                bArr[i3 + 1] = (byte) (i15 >> 16);
                int i16 = i3 + 3;
                bArr[i3 + 2] = (byte) (i15 >> 8);
                iM1356e = i3 + 4;
                bArr[i16] = (byte) i15;
            }
        } else {
            long j5 = j3 / 1000000000;
            int iM1354c2 = m1354c((int) j5, bArr, i3);
            iM1356e = m1356e((int) (j3 - (1000000000 * j5)), bArr, iM1354c2);
        }
        return m1356e((int) j4, bArr, iM1356e);
    }

    /* JADX INFO: renamed from: j */
    public static int m1361j(long j2, char[] cArr, int i3) {
        int iM1357f;
        if (j2 < 0) {
            if (j2 > -2147483648L) {
                return m1359h((int) j2, cArr, i3);
            }
            if (j2 == Long.MIN_VALUE) {
                String str = f1525b;
                int length = str.length();
                str.getChars(0, length, cArr, i3);
                return length + i3;
            }
            cArr[i3] = '-';
            j2 = -j2;
            i3++;
        } else if (j2 <= 2147483647L) {
            return m1359h((int) j2, cArr, i3);
        }
        long j3 = j2 / 1000000000;
        long j4 = j2 - (j3 * 1000000000);
        if (j3 < 1000000000) {
            int i4 = (int) j3;
            int[] iArr = f1526c;
            if (i4 >= 1000000) {
                int i5 = i4 / 1000;
                int i6 = i4 - (i5 * 1000);
                int i7 = i5 / 1000;
                int iM1355d = m1355d(i7, cArr, i3);
                int i8 = iArr[i5 - (i7 * 1000)];
                cArr[iM1355d] = (char) (i8 >> 16);
                cArr[iM1355d + 1] = (char) ((i8 >> 8) & 127);
                cArr[iM1355d + 2] = (char) (i8 & 127);
                int i9 = iArr[i6];
                cArr[iM1355d + 3] = (char) (i9 >> 16);
                int i10 = iM1355d + 5;
                cArr[iM1355d + 4] = (char) ((i9 >> 8) & 127);
                iM1357f = iM1355d + 6;
                cArr[i10] = (char) (i9 & 127);
            } else if (i4 < 1000) {
                iM1357f = m1355d(i4, cArr, i3);
            } else {
                int i11 = i4 / 1000;
                int i12 = i4 - (i11 * 1000);
                int i13 = iArr[i11];
                if (i11 > 9) {
                    if (i11 > 99) {
                        cArr[i3] = (char) (i13 >> 16);
                        i3++;
                    }
                    cArr[i3] = (char) ((i13 >> 8) & 127);
                    i3++;
                }
                cArr[i3] = (char) (i13 & 127);
                int i14 = iArr[i12];
                cArr[i3 + 1] = (char) (i14 >> 16);
                int i15 = i3 + 3;
                cArr[i3 + 2] = (char) ((i14 >> 8) & 127);
                iM1357f = i3 + 4;
                cArr[i15] = (char) (i14 & 127);
            }
        } else {
            long j5 = j3 / 1000000000;
            int iM1355d2 = m1355d((int) j5, cArr, i3);
            iM1357f = m1357f((int) (j3 - (1000000000 * j5)), cArr, iM1355d2);
        }
        return m1357f((int) j4, cArr, iM1357f);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /* JADX INFO: renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1362k(double r11, boolean r13) {
        /*
            if (r13 == 0) goto La6
            S0.a r13 = new S0.a
            r0 = 0
            r1 = 0
            r13.<init>(r0, r1)
            long r11 = java.lang.Double.doubleToRawLongBits(r11)
            r0 = 4503599627370495(0xfffffffffffff, double:2.225073858507201E-308)
            long r0 = r0 & r11
            r2 = 52
            long r2 = r11 >>> r2
            int r2 = (int) r2
            r3 = 2047(0x7ff, float:2.868E-42)
            r2 = r2 & r3
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            r9 = 0
            if (r2 >= r3) goto L75
            r3 = -1
            r13.f1625c = r3
            int r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r11 >= 0) goto L30
            r12 = 45
            r13.m1449a(r12)
        L30:
            if (r2 == 0) goto L58
            int r11 = 1075 - r2
            r2 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
            long r0 = r0 | r2
            if (r11 <= 0) goto L3b
            r12 = r8
            goto L3c
        L3b:
            r12 = r7
        L3c:
            r2 = 53
            if (r11 >= r2) goto L42
            r2 = r8
            goto L43
        L42:
            r2 = r7
        L43:
            r12 = r12 & r2
            if (r12 == 0) goto L53
            long r2 = r0 >> r11
            long r9 = r2 << r11
            int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r12 != 0) goto L53
            r13.m1455i(r7, r2)
        L51:
            r11 = r7
            goto L82
        L53:
            int r11 = -r11
            r13.m1457k(r11, r7, r0)
            goto L51
        L58:
            int r12 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r12 == 0) goto L6f
            r11 = 3
            int r11 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            r12 = -1074(0xfffffffffffffbce, float:NaN)
            if (r11 >= 0) goto L6b
            r9 = 10
            long r0 = r0 * r9
            r13.m1457k(r12, r3, r0)
            goto L51
        L6b:
            r13.m1457k(r12, r7, r0)
            goto L51
        L6f:
            if (r11 != 0) goto L73
            r11 = r8
            goto L82
        L73:
            r11 = r6
            goto L82
        L75:
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 == 0) goto L7b
            r11 = 5
            goto L82
        L7b:
            int r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r11 <= 0) goto L81
            r11 = r5
            goto L82
        L81:
            r11 = r4
        L82:
            if (r11 == 0) goto L9b
            if (r11 == r8) goto L98
            if (r11 == r6) goto L95
            if (r11 == r5) goto L92
            if (r11 == r4) goto L8f
            java.lang.String r11 = "NaN"
            goto Laa
        L8f:
            java.lang.String r11 = "-Infinity"
            goto Laa
        L92:
            java.lang.String r11 = "Infinity"
            goto Laa
        L95:
            java.lang.String r11 = "-0.0"
            goto Laa
        L98:
            java.lang.String r11 = "0.0"
            goto Laa
        L9b:
            java.lang.String r11 = new java.lang.String
            int r12 = r13.f1625c
            int r12 = r12 + r8
            byte[] r13 = r13.f1624b
            r11.<init>(r13, r7, r7, r12)
            goto Laa
        La6:
            java.lang.String r11 = java.lang.Double.toString(r11)
        Laa:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p050Q0.AbstractC0595h.m1362k(double, boolean):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX INFO: renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1363l(float r9, boolean r10) {
        /*
            if (r10 == 0) goto L92
            S0.a r10 = new S0.a
            r0 = 1
            r1 = 0
            r10.<init>(r0, r1)
            int r9 = java.lang.Float.floatToRawIntBits(r9)
            r0 = 8388607(0x7fffff, float:1.1754942E-38)
            r0 = r0 & r9
            int r1 = r9 >>> 23
            r2 = 255(0xff, float:3.57E-43)
            r1 = r1 & r2
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            if (r1 >= r2) goto L65
            r2 = -1
            r10.f1625c = r2
            if (r9 >= 0) goto L27
            r8 = 45
            r10.m1449a(r8)
        L27:
            if (r1 == 0) goto L4d
            int r9 = 150 - r1
            r1 = 8388608(0x800000, float:1.1754944E-38)
            r0 = r0 | r1
            if (r9 <= 0) goto L32
            r1 = r7
            goto L33
        L32:
            r1 = r6
        L33:
            r2 = 24
            if (r9 >= r2) goto L39
            r2 = r7
            goto L3a
        L39:
            r2 = r6
        L3a:
            r1 = r1 & r2
            if (r1 == 0) goto L48
            int r1 = r0 >> r9
            int r2 = r1 << r9
            if (r2 != r0) goto L48
            r10.m1454h(r1, r6)
        L46:
            r9 = r6
            goto L6e
        L48:
            int r9 = -r9
            r10.m1456j(r9, r0, r6)
            goto L46
        L4d:
            if (r0 == 0) goto L5f
            r9 = 8
            r1 = -149(0xffffffffffffff6b, float:NaN)
            if (r0 >= r9) goto L5b
            int r0 = r0 * 10
            r10.m1456j(r1, r0, r2)
            goto L46
        L5b:
            r10.m1456j(r1, r0, r6)
            goto L46
        L5f:
            if (r9 != 0) goto L63
            r9 = r7
            goto L6e
        L63:
            r9 = r5
            goto L6e
        L65:
            if (r0 == 0) goto L69
            r9 = 5
            goto L6e
        L69:
            if (r9 <= 0) goto L6d
            r9 = r4
            goto L6e
        L6d:
            r9 = r3
        L6e:
            if (r9 == 0) goto L87
            if (r9 == r7) goto L84
            if (r9 == r5) goto L81
            if (r9 == r4) goto L7e
            if (r9 == r3) goto L7b
            java.lang.String r9 = "NaN"
            goto L96
        L7b:
            java.lang.String r9 = "-Infinity"
            goto L96
        L7e:
            java.lang.String r9 = "Infinity"
            goto L96
        L81:
            java.lang.String r9 = "-0.0"
            goto L96
        L84:
            java.lang.String r9 = "0.0"
            goto L96
        L87:
            java.lang.String r9 = new java.lang.String
            int r0 = r10.f1625c
            int r0 = r0 + r7
            byte[] r10 = r10.f1624b
            r9.<init>(r10, r6, r6, r0)
            goto L96
        L92:
            java.lang.String r9 = java.lang.Float.toString(r9)
        L96:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p050Q0.AbstractC0595h.m1363l(float, boolean):java.lang.String");
    }
}
