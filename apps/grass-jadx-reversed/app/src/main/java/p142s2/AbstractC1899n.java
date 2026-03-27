package p142s2;

import p005B.AbstractC0032g;
import p117m0.AbstractC1717l;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: s2.n */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1899n extends AbstractC1898m {
    /* JADX INFO: renamed from: e */
    public static final void m4228e(String str) {
        throw new NumberFormatException(AbstractC0032g.m153k("Invalid number format: '", str, '\''));
    }

    /* JADX INFO: renamed from: f */
    public static Integer m4229f(String str) {
        boolean z3;
        int i3;
        int i4;
        AbstractC1766e.m3920e("<this>", str);
        AbstractC1717l.m3798a();
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i5 = 0;
        char cCharAt = str.charAt(0);
        int i6 = -2147483647;
        if (AbstractC1766e.m3921f(cCharAt, 48) < 0) {
            i3 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i6 = Integer.MIN_VALUE;
                z3 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z3 = false;
            }
        } else {
            z3 = false;
            i3 = 0;
        }
        int i7 = -59652323;
        while (i3 < length) {
            int iDigit = Character.digit((int) str.charAt(i3), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i5 < i7 && (i7 != -59652323 || i5 < (i7 = i6 / 10))) || (i4 = i5 * 10) < i6 + iDigit) {
                return null;
            }
            i5 = i4 - iDigit;
            i3++;
        }
        return z3 ? Integer.valueOf(i5) : Integer.valueOf(-i5);
    }

    /* JADX INFO: renamed from: g */
    public static Long m4230g(String str) {
        boolean z3;
        AbstractC1766e.m3920e("<this>", str);
        AbstractC1717l.m3798a();
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        long j2 = -9223372036854775807L;
        if (AbstractC1766e.m3921f(cCharAt, 48) < 0) {
            z3 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j2 = Long.MIN_VALUE;
                i3 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z3 = false;
                i3 = 1;
            }
        } else {
            z3 = false;
        }
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i3 < length) {
            int iDigit = Character.digit((int) str.charAt(i3), 10);
            if (iDigit < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 != -256204778801521550L) {
                    return null;
                }
                j4 = j2 / ((long) 10);
                if (j3 < j4) {
                    return null;
                }
            }
            long j5 = j3 * ((long) 10);
            long j6 = iDigit;
            if (j5 < j2 + j6) {
                return null;
            }
            j3 = j5 - j6;
            i3++;
        }
        return z3 ? Long.valueOf(j3) : Long.valueOf(-j3);
    }
}
