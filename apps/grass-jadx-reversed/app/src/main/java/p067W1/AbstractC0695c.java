package p067W1;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: renamed from: W1.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0695c {

    /* JADX INFO: renamed from: c */
    public static final byte[] f1889c;

    /* JADX INFO: renamed from: a */
    public static final byte[] f1887a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* JADX INFO: renamed from: b */
    public static final byte[] f1888b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* JADX INFO: renamed from: d */
    public static final byte[] f1890d = new byte[128];

    /* JADX INFO: renamed from: e */
    public static final Charset f1891e = StandardCharsets.ISO_8859_1;

    static {
        int i3 = 0;
        byte[] bArr = new byte[128];
        f1889c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i4 = 0;
        while (true) {
            byte[] bArr2 = f1887a;
            if (i4 >= bArr2.length) {
                break;
            }
            byte b3 = bArr2[i4];
            if (b3 > 0) {
                f1889c[b3] = (byte) i4;
            }
            i4++;
        }
        Arrays.fill(f1890d, (byte) -1);
        while (true) {
            byte[] bArr3 = f1888b;
            if (i3 >= bArr3.length) {
                return;
            }
            byte b4 = bArr3[i3];
            if (b4 > 0) {
                f1890d[b4] = (byte) i3;
            }
            i3++;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1673a(byte[] bArr, int i3, int i4, StringBuilder sb) {
        if (i3 == 1 && i4 == 0) {
            sb.append((char) 913);
        } else if (i3 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        int i5 = 0;
        if (i3 >= 6) {
            char[] cArr = new char[5];
            int i6 = 0;
            while (i3 - i6 >= 6) {
                long j2 = 0;
                for (int i7 = 0; i7 < 6; i7++) {
                    j2 = (j2 << 8) + ((long) (bArr[i6 + i7] & 255));
                }
                for (int i8 = 0; i8 < 5; i8++) {
                    cArr[i8] = (char) (j2 % 900);
                    j2 /= 900;
                }
                for (int i9 = 4; i9 >= 0; i9--) {
                    sb.append(cArr[i9]);
                }
                i6 += 6;
            }
            i5 = i6;
        }
        while (i5 < i3) {
            sb.append((char) (bArr[i5] & 255));
            i5++;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m1674b(int i3, int i4, String str, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i4 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i5 = 0;
        while (i5 < i4) {
            sb2.setLength(0);
            int iMin = Math.min(44, i4 - i5);
            StringBuilder sb3 = new StringBuilder("1");
            int i6 = i3 + i5;
            sb3.append(str.substring(i6, i6 + iMin));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i5 += iMin;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00e4 A[EDGE_INSN: B:76:0x00e4->B:57:0x00e4 BREAK  A[LOOP:0: B:3:0x000e->B:93:0x000e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x000e A[SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m1675c(java.lang.CharSequence r17, int r18, int r19, java.lang.StringBuilder r20, int r21) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p067W1.AbstractC0695c.m1675c(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    /* JADX INFO: renamed from: d */
    public static boolean m1676d(char c3) {
        if (c3 != ' ') {
            return c3 >= 'a' && c3 <= 'z';
        }
        return true;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m1677e(char c3) {
        if (c3 != ' ') {
            return c3 >= 'A' && c3 <= 'Z';
        }
        return true;
    }
}
