package p062U1;

import p033K0.AbstractC0405c;

/* JADX INFO: renamed from: U1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0660b extends AbstractC0405c {

    /* JADX INFO: renamed from: e */
    public static final char[] f1800e;

    /* JADX INFO: renamed from: f */
    public static final char[] f1801f = {'T', 'N', '*', 'E'};

    /* JADX INFO: renamed from: g */
    public static final char[] f1802g = {'/', ':', '+', '.'};

    /* JADX INFO: renamed from: h */
    public static final char f1803h;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f1800e = cArr;
        f1803h = cArr[0];
    }

    @Override // p033K0.AbstractC0405c
    /* JADX INFO: renamed from: e */
    public final boolean[] mo893e(String str) {
        int i3;
        int length = str.length();
        char c3 = f1803h;
        if (length < 2) {
            str = c3 + str + c3;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f1800e;
            boolean zM1619i = AbstractC0659a.m1619i(cArr, upperCase);
            boolean zM1619i2 = AbstractC0659a.m1619i(cArr, upperCase2);
            char[] cArr2 = f1801f;
            boolean zM1619i3 = AbstractC0659a.m1619i(cArr2, upperCase);
            boolean zM1619i4 = AbstractC0659a.m1619i(cArr2, upperCase2);
            if (zM1619i) {
                if (!zM1619i2) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (!zM1619i3) {
                if (zM1619i2 || zM1619i4) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
                str = c3 + str + c3;
            } else if (!zM1619i4) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
            }
        }
        int i4 = 20;
        for (int i5 = 1; i5 < str.length() - 1; i5++) {
            if (Character.isDigit(str.charAt(i5)) || str.charAt(i5) == '-' || str.charAt(i5) == '$') {
                i4 += 9;
            } else {
                if (!AbstractC0659a.m1619i(f1802g, str.charAt(i5))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i5) + '\'');
                }
                i4 += 10;
            }
        }
        boolean[] zArr = new boolean[(str.length() - 1) + i4];
        int i6 = 0;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i7));
            if (i7 == 0 || i7 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i8 = 0;
            while (true) {
                char[] cArr3 = AbstractC0659a.f1798b;
                if (i8 >= cArr3.length) {
                    i3 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i8]) {
                    i3 = AbstractC0659a.f1799c[i8];
                    break;
                }
                i8++;
            }
            int i9 = 0;
            int i10 = 0;
            boolean z3 = true;
            while (i9 < 7) {
                zArr[i6] = z3;
                i6++;
                if (((i3 >> (6 - i9)) & 1) == 0 || i10 == 1) {
                    z3 = !z3;
                    i9++;
                    i10 = 0;
                } else {
                    i10++;
                }
            }
            if (i7 < str.length() - 1) {
                zArr[i6] = false;
                i6++;
            }
        }
        return zArr;
    }
}
