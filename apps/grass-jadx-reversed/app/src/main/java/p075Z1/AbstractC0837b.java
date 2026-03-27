package p075Z1;

import p043N1.C0563e;
import p053R0.C0607c;

/* JADX INFO: renamed from: Z1.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0837b {

    /* JADX INFO: renamed from: a */
    public static final int[] f2499a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b */
    public static final int[][] f2500b = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c */
    public static final int[][] f2501c = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: d */
    public static final int[][] f2502d = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* JADX INFO: renamed from: e */
    public static final int[][] f2503e = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX INFO: renamed from: a */
    public static int m2162a(C0607c c0607c, boolean z3) {
        int i3 = c0607c.f1566f;
        int i4 = c0607c.f1567g;
        int i5 = z3 ? i4 : i3;
        if (!z3) {
            i3 = i4;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            byte b3 = -1;
            int i8 = 0;
            for (int i9 = 0; i9 < i3; i9++) {
                byte[][] bArr = (byte[][]) c0607c.f1568h;
                byte b4 = z3 ? bArr[i7][i9] : bArr[i9][i7];
                if (b4 == b3) {
                    i8++;
                } else {
                    if (i8 >= 5) {
                        i6 += i8 - 2;
                    }
                    i8 = 1;
                    b3 = b4;
                }
            }
            if (i8 >= 5) {
                i6 = (i8 - 2) + i6;
            }
        }
        return i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x024d  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m2163b(p051Q1.C0600a r27, int r28, p072Y1.C0754b r29, int r30, p053R0.C0607c r31) throws p043N1.C0563e {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p075Z1.AbstractC0837b.m2163b(Q1.a, int, Y1.b, int, R0.c):void");
    }

    /* JADX INFO: renamed from: c */
    public static int m2164c(int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i4);
        int i5 = 32 - iNumberOfLeadingZeros;
        int iNumberOfLeadingZeros2 = i3 << (31 - iNumberOfLeadingZeros);
        while (32 - Integer.numberOfLeadingZeros(iNumberOfLeadingZeros2) >= i5) {
            iNumberOfLeadingZeros2 ^= i4 << ((32 - Integer.numberOfLeadingZeros(iNumberOfLeadingZeros2)) - i5);
        }
        return iNumberOfLeadingZeros2;
    }

    /* JADX INFO: renamed from: d */
    public static void m2165d(int i3, int i4, C0607c c0607c) throws C0563e {
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = i3 + i5;
            if (!m2168g(c0607c.m1391c(i6, i4))) {
                throw new C0563e();
            }
            c0607c.m1405r(i6, i4, 0);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m2166e(int i3, int i4, C0607c c0607c) {
        for (int i5 = 0; i5 < 7; i5++) {
            int[] iArr = f2500b[i5];
            for (int i6 = 0; i6 < 7; i6++) {
                c0607c.m1405r(i3 + i6, i4 + i5, iArr[i6]);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m2167f(int i3, int i4, C0607c c0607c) throws C0563e {
        for (int i5 = 0; i5 < 7; i5++) {
            int i6 = i4 + i5;
            if (!m2168g(c0607c.m1391c(i3, i6))) {
                throw new C0563e();
            }
            c0607c.m1405r(i3, i6, 0);
        }
    }

    /* JADX INFO: renamed from: g */
    public static boolean m2168g(int i3) {
        return i3 == -1;
    }
}
