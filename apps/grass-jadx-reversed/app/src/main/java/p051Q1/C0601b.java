package p051Q1;

import java.util.Arrays;

/* JADX INFO: renamed from: Q1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0601b implements Cloneable {

    /* JADX INFO: renamed from: e */
    public final int f1555e;

    /* JADX INFO: renamed from: f */
    public final int f1556f;

    /* JADX INFO: renamed from: g */
    public final int f1557g;

    /* JADX INFO: renamed from: h */
    public final int[] f1558h;

    public C0601b(int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f1555e = i3;
        this.f1556f = i4;
        int i5 = (i3 + 31) / 32;
        this.f1557g = i5;
        this.f1558h = new int[i5 * i4];
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1377a(int i3, int i4) {
        return ((this.f1558h[(i3 / 32) + (i4 * this.f1557g)] >>> (i3 & 31)) & 1) != 0;
    }

    /* JADX INFO: renamed from: b */
    public final void m1378b(int i3, int i4) {
        int i5 = (i3 / 32) + (i4 * this.f1557g);
        int[] iArr = this.f1558h;
        iArr[i5] = (1 << (i3 & 31)) | iArr[i5];
    }

    /* JADX INFO: renamed from: c */
    public final void m1379c(int i3, int i4, int i5, int i6) {
        if (i4 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i6 <= 0 || i5 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i7 = i5 + i3;
        int i8 = i6 + i4;
        if (i8 > this.f1556f || i7 > this.f1555e) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i4 < i8) {
            int i9 = this.f1557g * i4;
            for (int i10 = i3; i10 < i7; i10++) {
                int i11 = (i10 / 32) + i9;
                int[] iArr = this.f1558h;
                iArr[i11] = iArr[i11] | (1 << (i10 & 31));
            }
            i4++;
        }
    }

    public final Object clone() {
        int[] iArr = (int[]) this.f1558h.clone();
        return new C0601b(this.f1555e, this.f1556f, this.f1557g, iArr);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0601b)) {
            return false;
        }
        C0601b c0601b = (C0601b) obj;
        return this.f1555e == c0601b.f1555e && this.f1556f == c0601b.f1556f && this.f1557g == c0601b.f1557g && Arrays.equals(this.f1558h, c0601b.f1558h);
    }

    public final int hashCode() {
        int i3 = this.f1555e;
        return Arrays.hashCode(this.f1558h) + (((((((i3 * 31) + i3) * 31) + this.f1556f) * 31) + this.f1557g) * 31);
    }

    public final String toString() {
        int i3 = this.f1555e;
        int i4 = this.f1556f;
        StringBuilder sb = new StringBuilder((i3 + 1) * i4);
        for (int i5 = 0; i5 < i4; i5++) {
            for (int i6 = 0; i6 < i3; i6++) {
                sb.append(m1377a(i6, i5) ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public C0601b(int i3, int i4, int i5, int[] iArr) {
        this.f1555e = i3;
        this.f1556f = i4;
        this.f1557g = i5;
        this.f1558h = iArr;
    }
}
