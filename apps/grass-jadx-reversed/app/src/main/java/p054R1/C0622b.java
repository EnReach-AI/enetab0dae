package p054R1;

/* JADX INFO: renamed from: R1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0622b {

    /* JADX INFO: renamed from: a */
    public final C0621a f1600a;

    /* JADX INFO: renamed from: b */
    public final int[] f1601b;

    public C0622b(C0621a c0621a, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f1600a = c0621a;
        int length = iArr.length;
        int i3 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f1601b = iArr;
            return;
        }
        while (i3 < length && iArr[i3] == 0) {
            i3++;
        }
        if (i3 == length) {
            this.f1601b = new int[]{0};
            return;
        }
        int i4 = length - i3;
        int[] iArr2 = new int[i4];
        this.f1601b = iArr2;
        System.arraycopy(iArr, i3, iArr2, 0, i4);
    }

    /* JADX INFO: renamed from: a */
    public final C0622b m1439a(C0622b c0622b) {
        C0621a c0621a = c0622b.f1600a;
        C0621a c0621a2 = this.f1600a;
        if (!c0621a2.equals(c0621a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        int[] iArr = this.f1601b;
        if (iArr[0] == 0) {
            return c0622b;
        }
        int[] iArr2 = c0622b.f1601b;
        if (iArr2[0] == 0) {
            return this;
        }
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i3 = length; i3 < iArr.length; i3++) {
            iArr3[i3] = iArr2[i3 - length] ^ iArr[i3];
        }
        return new C0622b(c0621a2, iArr3);
    }

    /* JADX INFO: renamed from: b */
    public final int m1440b() {
        return this.f1601b.length - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(m1440b() * 8);
        for (int iM1440b = m1440b(); iM1440b >= 0; iM1440b--) {
            int[] iArr = this.f1601b;
            int i3 = iArr[(iArr.length - 1) - iM1440b];
            if (i3 != 0) {
                if (i3 < 0) {
                    sb.append(" - ");
                    i3 = -i3;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iM1440b == 0 || i3 != 1) {
                    C0621a c0621a = this.f1600a;
                    if (i3 == 0) {
                        c0621a.getClass();
                        throw new IllegalArgumentException();
                    }
                    int i4 = c0621a.f1595b[i3];
                    if (i4 == 0) {
                        sb.append('1');
                    } else if (i4 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i4);
                    }
                }
                if (iM1440b != 0) {
                    if (iM1440b == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iM1440b);
                    }
                }
            }
        }
        return sb.toString();
    }
}
