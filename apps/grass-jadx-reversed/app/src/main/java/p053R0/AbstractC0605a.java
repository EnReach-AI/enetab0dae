package p053R0;

/* JADX INFO: renamed from: R0.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0605a extends AbstractC0606b {
    /* JADX INFO: renamed from: g */
    public static int m1380g(CharSequence charSequence, int i3, int i4) {
        while (i3 < i4 && charSequence.charAt(i3) <= ' ') {
            i3++;
        }
        return i3;
    }

    /* JADX INFO: renamed from: c */
    public abstract long mo1381c();

    /* JADX INFO: renamed from: d */
    public abstract long mo1382d();

    /* JADX INFO: renamed from: e */
    public long m1383e(CharSequence charSequence, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z3;
        int i8;
        int i9;
        long j2;
        boolean z4;
        int i10;
        char cM1387a;
        int i11;
        int iMin;
        int i12;
        int i13;
        int i14;
        long j3;
        int i15;
        boolean z5;
        char c3;
        if (i3 < 0 || i3 > charSequence.length() || i3 > 2147483643) {
            throw new IllegalArgumentException("offset < 0 or length > str.length");
        }
        int iM1380g = m1380g(charSequence, 0, i3);
        if (iM1380g == i3) {
            throw new NumberFormatException("illegal syntax");
        }
        char cCharAt = charSequence.charAt(iM1380g);
        boolean z6 = cCharAt == '-';
        if ((z6 || cCharAt == '+') && (cCharAt = AbstractC0606b.m1387a(charSequence, (iM1380g = iM1380g + 1), i3)) == 0) {
            throw new NumberFormatException("illegal syntax");
        }
        if (cCharAt >= 'I') {
            if (charSequence.charAt(iM1380g) == 'N') {
                int i16 = iM1380g + 2;
                if (i16 < i3 && charSequence.charAt(iM1380g + 1) == 'a' && charSequence.charAt(i16) == 'N' && m1380g(charSequence, iM1380g + 3, i3) == i3) {
                    return mo1381c();
                }
            } else {
                int i17 = iM1380g + 7;
                if (i17 < i3 && charSequence.charAt(iM1380g) == 'I' && charSequence.charAt(iM1380g + 1) == 'n' && charSequence.charAt(iM1380g + 2) == 'f' && charSequence.charAt(iM1380g + 3) == 'i' && charSequence.charAt(iM1380g + 4) == 'n' && charSequence.charAt(iM1380g + 5) == 'i' && charSequence.charAt(iM1380g + 6) == 't' && charSequence.charAt(i17) == 'y' && m1380g(charSequence, iM1380g + 8, i3) == i3) {
                    return z6 ? mo1382d() : mo1384f();
                }
            }
            throw new NumberFormatException("illegal syntax");
        }
        boolean z7 = cCharAt == '0';
        if (z7) {
            int i18 = iM1380g + 1;
            char cM1387a2 = AbstractC0606b.m1387a(charSequence, i18, i3);
            if (cM1387a2 == 'x' || cM1387a2 == 'X') {
                int i19 = iM1380g + 2;
                int i20 = i19;
                long j4 = 0;
                char c4 = 0;
                int i21 = -1;
                boolean z8 = false;
                while (true) {
                    if (i20 >= i3) {
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i20);
                    int iM1388b = AbstractC0606b.m1388b(cCharAt2);
                    if (iM1388b < 0) {
                        c3 = cCharAt2;
                        if (iM1388b != -4) {
                            c4 = c3;
                            break;
                        }
                        z8 |= i21 >= 0;
                        int i22 = i20;
                        while (i22 < i3 - 8) {
                            long jM1413f = AbstractC0608d.m1413f(charSequence, i22 + 1);
                            if (jM1413f < 0) {
                                break;
                            }
                            j4 = (j4 << 32) + jM1413f;
                            i22 += 8;
                        }
                        i21 = i20;
                        i20 = i22;
                    } else {
                        c3 = cCharAt2;
                        j4 = (j4 << 4) | ((long) iM1388b);
                    }
                    i20++;
                    c4 = c3;
                }
                if (i21 < 0) {
                    i11 = i20 - i19;
                    i21 = i20;
                    iMin = 0;
                } else {
                    i11 = (i20 - i19) - 1;
                    iMin = Math.min((i21 - i20) + 1, 1024) * 4;
                }
                boolean z9 = (c4 | ' ') == 112;
                if (z9) {
                    int i23 = i20 + 1;
                    char cM1387a3 = AbstractC0606b.m1387a(charSequence, i23, i3);
                    boolean z10 = cM1387a3 == '-';
                    if (z10 || cM1387a3 == '+') {
                        i23 = i20 + 2;
                        cM1387a3 = AbstractC0606b.m1387a(charSequence, i23, i3);
                    }
                    boolean z11 = (!AbstractC0608d.m1408a(cM1387a3)) | z8;
                    int i24 = 0;
                    do {
                        if (i24 < 1024) {
                            i24 = ((i24 * 10) + cM1387a3) - 48;
                        }
                        i23++;
                        cM1387a3 = AbstractC0606b.m1387a(charSequence, i23, i3);
                    } while (AbstractC0608d.m1408a(cM1387a3));
                    if (z10) {
                        i24 = -i24;
                    }
                    i14 = i24;
                    z8 = z11;
                    i12 = i23;
                    c4 = cM1387a3;
                    i13 = iMin + i24;
                } else {
                    i12 = i20;
                    i13 = iMin;
                    i14 = 0;
                }
                if ((c4 == 'F') | (c4 == 'd') | (c4 == 'D') | (c4 == 'f')) {
                    i12++;
                }
                int iM1380g2 = m1380g(charSequence, i12, i3);
                if (z8 || iM1380g2 < i3 || i11 == 0 || !z9) {
                    throw new NumberFormatException("illegal syntax");
                }
                if (i11 > 16) {
                    long j5 = 0;
                    i15 = 0;
                    while (i19 < i20) {
                        int iM1388b2 = AbstractC0606b.m1388b(charSequence.charAt(i19));
                        if (iM1388b2 < 0) {
                            i15++;
                        } else {
                            if (Long.compareUnsigned(j5, 1000000000000000000L) >= 0) {
                                break;
                            }
                            j5 = (j5 << 4) | ((long) iM1388b2);
                        }
                        i19++;
                    }
                    z5 = i19 < i20;
                    j3 = j5;
                    iM1380g2 = i19;
                } else {
                    j3 = j4;
                    i15 = 0;
                    z5 = false;
                }
                return mo1386i(charSequence, i3, z6, j3, i13, z5, (((i21 - iM1380g2) + i15) * 4) + i14);
            }
            iM1380g = i18;
        }
        int i25 = iM1380g;
        long j6 = 0;
        char cCharAt3 = 0;
        boolean z12 = false;
        int i26 = -1;
        while (i25 < i3) {
            cCharAt3 = charSequence.charAt(i25);
            if (!AbstractC0608d.m1408a(cCharAt3)) {
                if (cCharAt3 != '.') {
                    break;
                }
                z12 |= i26 >= 0;
                i26 = i25;
            } else {
                j6 = ((j6 * 10) + ((long) cCharAt3)) - 48;
            }
            i25++;
        }
        if (i26 < 0) {
            i6 = i25 - iM1380g;
            i5 = i25;
            i4 = 0;
        } else {
            i4 = (i26 - i25) + 1;
            i5 = i26;
            i6 = (i25 - iM1380g) - 1;
        }
        if ((cCharAt3 | ' ') == 101) {
            int i27 = i25 + 1;
            char cM1387a4 = AbstractC0606b.m1387a(charSequence, i27, i3);
            boolean z13 = cM1387a4 == '-';
            if (z13 || cM1387a4 == '+') {
                i27 = i25 + 2;
                cM1387a4 = AbstractC0606b.m1387a(charSequence, i27, i3);
            }
            z3 = true;
            boolean z14 = (!AbstractC0608d.m1408a(cM1387a4)) | z12;
            i7 = iM1380g;
            i9 = 0;
            while (true) {
                if (i9 < 1024) {
                    i9 = ((i9 * 10) + cM1387a4) - 48;
                }
                i27++;
                cM1387a = AbstractC0606b.m1387a(charSequence, i27, i3);
                if (!AbstractC0608d.m1408a(cM1387a)) {
                    break;
                }
                cM1387a4 = cM1387a;
            }
            if (z13) {
                i9 = -i9;
            }
            i4 += i9;
            i8 = i27;
            z12 = z14;
            cCharAt3 = cM1387a;
        } else {
            i7 = iM1380g;
            z3 = true;
            i8 = i25;
            i9 = 0;
        }
        if ((cCharAt3 == 'F' ? z3 : false) | (cCharAt3 == 'd' ? z3 : false) | (cCharAt3 == 'D' ? z3 : false) | (cCharAt3 == 'f' ? z3 : false)) {
            i8++;
        }
        int iM1380g3 = m1380g(charSequence, i8, i3);
        if (z12 || iM1380g3 < i3 || (!z7 && i6 == 0)) {
            throw new NumberFormatException("illegal syntax");
        }
        if (i6 > 19) {
            long j7 = 0;
            int i28 = i7;
            int i29 = 0;
            while (i28 < i25) {
                char cCharAt4 = charSequence.charAt(i28);
                if (cCharAt4 != '.') {
                    if (Long.compareUnsigned(j7, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j7 = ((j7 * 10) + ((long) cCharAt4)) - 48;
                } else {
                    i29++;
                }
                i28++;
            }
            i10 = (i5 - i28) + i29 + i9;
            z4 = i28 < i25 ? z3 : false;
            j2 = j7;
        } else {
            j2 = j6;
            z4 = false;
            i10 = 0;
        }
        return mo1385h(charSequence, i3, z6, j2, i4, z4, i10);
    }

    /* JADX INFO: renamed from: f */
    public abstract long mo1384f();

    /* JADX INFO: renamed from: h */
    public abstract long mo1385h(CharSequence charSequence, int i3, boolean z3, long j2, int i4, boolean z4, int i5);

    /* JADX INFO: renamed from: i */
    public abstract long mo1386i(CharSequence charSequence, int i3, boolean z3, long j2, int i4, boolean z4, int i5);
}
