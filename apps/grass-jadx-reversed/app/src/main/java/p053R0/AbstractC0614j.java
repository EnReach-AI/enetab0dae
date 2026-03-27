package p053R0;

import java.math.BigDecimal;

/* JADX INFO: renamed from: R0.j */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0614j {

    /* JADX INFO: renamed from: a */
    public static final C0613i f1583a = new C0613i();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static BigDecimal m1436a(CharSequence charSequence) {
        String str;
        char c3;
        int i3;
        boolean z3;
        int i4;
        long j2;
        int i5;
        String str2;
        String str3;
        int i6;
        int length = charSequence.length();
        f1583a.getClass();
        String str4 = "value exceeds limits";
        try {
            if (length >= 32) {
                return C0613i.m1433c(charSequence, length);
            }
            char cM1387a = AbstractC0606b.m1387a(charSequence, 0, length);
            boolean z4 = cM1387a == '-';
            String str5 = "illegal syntax";
            try {
                if (z4 || cM1387a == '+') {
                    char cM1387a2 = AbstractC0606b.m1387a(charSequence, 1, length);
                    if (cM1387a2 == 0) {
                        throw new NumberFormatException("illegal syntax");
                    }
                    c3 = cM1387a2;
                    i3 = 1;
                } else {
                    c3 = cM1387a;
                    i3 = 0;
                }
                boolean z5 = false;
                int i7 = i3;
                char c4 = c3;
                long j3 = 0;
                int i8 = -1;
                while (true) {
                    if (i7 >= length) {
                        z3 = z4;
                        break;
                    }
                    char cCharAt = charSequence.charAt(i7);
                    if (!AbstractC0608d.m1408a(cCharAt)) {
                        z3 = z4;
                        if (cCharAt != '.') {
                            c4 = cCharAt;
                            break;
                        }
                        z5 |= i8 >= 0;
                        int i9 = i7;
                        while (true) {
                            if (i9 >= length - 4) {
                                c4 = cCharAt;
                                break;
                            }
                            c4 = cCharAt;
                            int i10 = i9 + 4;
                            long jCharAt = (((long) charSequence.charAt(i9 + 2)) << 16) | ((long) charSequence.charAt(i9 + 1)) | (((long) charSequence.charAt(i9 + 3)) << 32) | (((long) charSequence.charAt(i10)) << 48);
                            long j4 = jCharAt - 13511005043687472L;
                            int i11 = (((jCharAt + 19703549022044230L) | j4) & (-35747867511423104L)) != 0 ? -1 : (int) ((j4 * 281475406208040961L) >>> 48);
                            if (i11 < 0) {
                                break;
                            }
                            j3 = (j3 * 10000) + ((long) i11);
                            i9 = i10;
                            cCharAt = c4;
                        }
                        i8 = i7;
                        i7 = i9;
                    } else {
                        z3 = z4;
                        j3 = ((j3 * 10) + ((long) cCharAt)) - 48;
                        c4 = cCharAt;
                    }
                    i7++;
                    z4 = z3;
                }
                if (i8 < 0) {
                    i4 = i7 - i3;
                    i5 = i7;
                    j2 = 0;
                } else {
                    i4 = (i7 - i3) - 1;
                    j2 = (i8 - i7) + 1;
                    i5 = i8;
                }
                if ((c4 | ' ') == 101) {
                    int i12 = i7 + 1;
                    try {
                        char cM1387a3 = AbstractC0606b.m1387a(charSequence, i12, length);
                        boolean z6 = cM1387a3 == '-';
                        if (z6 || cM1387a3 == '+') {
                            i12 = i7 + 2;
                            cM1387a3 = AbstractC0606b.m1387a(charSequence, i12, length);
                        }
                        z5 |= !AbstractC0608d.m1408a(cM1387a3);
                        char c5 = cM1387a3;
                        long j5 = 0;
                        while (true) {
                            if (j5 < 2147483647L) {
                                str2 = str4;
                                str3 = str5;
                                j5 = ((j5 * 10) + ((long) c5)) - 48;
                            } else {
                                str2 = str4;
                                str3 = str5;
                            }
                            i12++;
                            try {
                                char cM1387a4 = AbstractC0606b.m1387a(charSequence, i12, length);
                                if (!AbstractC0608d.m1408a(cM1387a4)) {
                                    break;
                                }
                                c5 = cM1387a4;
                                str4 = str2;
                                str5 = str3;
                            } catch (ArithmeticException e3) {
                                e = e3;
                                str = str2;
                                NumberFormatException numberFormatException = new NumberFormatException(str);
                                numberFormatException.initCause(e);
                                throw numberFormatException;
                            }
                        }
                        if (z6) {
                            j5 = -j5;
                        }
                        j2 += j5;
                        i6 = i7;
                        i7 = i12;
                    } catch (ArithmeticException e4) {
                        e = e4;
                        str2 = "value exceeds limits";
                    }
                } else {
                    str2 = "value exceeds limits";
                    str3 = "illegal syntax";
                    i6 = length;
                }
                if (z5 || i7 < length || i4 == 0 || i4 > 1292782621) {
                    throw new NumberFormatException(str3);
                }
                if (j2 <= -2147483648L || j2 > 2147483647L) {
                    throw new NumberFormatException(str2);
                }
                if (i4 > 18) {
                    return C0613i.m1435e(charSequence, i3, i5, i5 + 1, i6, z3, (int) j2);
                }
                if (z3) {
                    j3 = -j3;
                }
                return new BigDecimal(j3).scaleByPowerOfTen((int) j2);
            } catch (ArithmeticException e5) {
                e = e5;
                str = length;
            }
        } catch (ArithmeticException e6) {
            e = e6;
            str = "value exceeds limits";
        }
    }
}
