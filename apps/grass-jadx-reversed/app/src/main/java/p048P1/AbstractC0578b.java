package p048P1;

import p001A.C0009j;
import p051Q1.C0600a;
import p051Q1.C0601b;
import p054R1.C0621a;

/* JADX INFO: renamed from: P1.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0578b {

    /* JADX INFO: renamed from: a */
    public static final int[] f1442a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    /* JADX INFO: renamed from: a */
    public static void m1300a(C0601b c0601b, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5 += 2) {
            int i6 = i3 - i5;
            int i7 = i6;
            while (true) {
                int i8 = i3 + i5;
                if (i7 <= i8) {
                    c0601b.m1378b(i7, i6);
                    c0601b.m1378b(i7, i8);
                    c0601b.m1378b(i6, i7);
                    c0601b.m1378b(i8, i7);
                    i7++;
                }
            }
        }
        int i9 = i3 - i4;
        c0601b.m1378b(i9, i9);
        int i10 = i9 + 1;
        c0601b.m1378b(i10, i9);
        c0601b.m1378b(i9, i10);
        int i11 = i3 + i4;
        c0601b.m1378b(i11, i9);
        c0601b.m1378b(i11, i10);
        c0601b.m1378b(i11, i11 - 1);
    }

    /* JADX INFO: renamed from: b */
    public static C0600a m1301b(C0600a c0600a, int i3, int i4) {
        C0621a c0621a;
        int i5 = c0600a.f1554f / i4;
        if (i4 == 4) {
            c0621a = C0621a.f1591j;
        } else if (i4 == 6) {
            c0621a = C0621a.f1590i;
        } else if (i4 == 8) {
            c0621a = C0621a.f1593l;
        } else if (i4 == 10) {
            c0621a = C0621a.f1589h;
        } else {
            if (i4 != 12) {
                throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i4)));
            }
            c0621a = C0621a.f1588g;
        }
        C0009j c0009j = new C0009j(c0621a);
        int i6 = i3 / i4;
        int[] iArr = new int[i6];
        int i7 = c0600a.f1554f / i4;
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i4; i10++) {
                i9 |= c0600a.m1375d((i8 * i4) + i10) ? 1 << ((i4 - i10) - 1) : 0;
            }
            iArr[i8] = i9;
        }
        c0009j.m65y(iArr, i6 - i5);
        C0600a c0600a2 = new C0600a();
        c0600a2.m1373b(0, i3 % i4);
        for (int i11 = 0; i11 < i6; i11++) {
            c0600a2.m1373b(iArr[i11], i4);
        }
        return c0600a2;
    }

    /* JADX INFO: renamed from: c */
    public static C0600a m1302c(C0600a c0600a, int i3) {
        C0600a c0600a2 = new C0600a();
        int i4 = c0600a.f1554f;
        int i5 = (1 << i3) - 2;
        int i6 = 0;
        while (i6 < i4) {
            int i7 = 0;
            for (int i8 = 0; i8 < i3; i8++) {
                int i9 = i6 + i8;
                if (i9 >= i4 || c0600a.m1375d(i9)) {
                    i7 |= 1 << ((i3 - 1) - i8);
                }
            }
            int i10 = i7 & i5;
            if (i10 == i5) {
                c0600a2.m1373b(i10, i3);
            } else if (i10 == 0) {
                c0600a2.m1373b(i7 | 1, i3);
            } else {
                c0600a2.m1373b(i7, i3);
                i6 += i3;
            }
            i6--;
            i6 += i3;
        }
        return c0600a2;
    }
}
