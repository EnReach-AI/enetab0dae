package p051Q1;

import java.util.Arrays;

/* JADX INFO: renamed from: Q1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0600a implements Cloneable {

    /* JADX INFO: renamed from: f */
    public int f1554f = 0;

    /* JADX INFO: renamed from: e */
    public int[] f1553e = new int[1];

    /* JADX INFO: renamed from: a */
    public final void m1372a(boolean z3) {
        m1374c(this.f1554f + 1);
        if (z3) {
            int[] iArr = this.f1553e;
            int i3 = this.f1554f;
            int i4 = i3 / 32;
            iArr[i4] = (1 << (i3 & 31)) | iArr[i4];
        }
        this.f1554f++;
    }

    /* JADX INFO: renamed from: b */
    public final void m1373b(int i3, int i4) {
        if (i4 < 0 || i4 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m1374c(this.f1554f + i4);
        while (i4 > 0) {
            boolean z3 = true;
            if (((i3 >> (i4 - 1)) & 1) != 1) {
                z3 = false;
            }
            m1372a(z3);
            i4--;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m1374c(int i3) {
        int[] iArr = this.f1553e;
        if (i3 > (iArr.length << 5)) {
            int[] iArr2 = new int[(i3 + 31) / 32];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f1553e = iArr2;
        }
    }

    public final Object clone() {
        int[] iArr = (int[]) this.f1553e.clone();
        int i3 = this.f1554f;
        C0600a c0600a = new C0600a();
        c0600a.f1553e = iArr;
        c0600a.f1554f = i3;
        return c0600a;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m1375d(int i3) {
        return ((1 << (i3 & 31)) & this.f1553e[i3 / 32]) != 0;
    }

    /* JADX INFO: renamed from: e */
    public final int m1376e() {
        return (this.f1554f + 7) / 8;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0600a)) {
            return false;
        }
        C0600a c0600a = (C0600a) obj;
        return this.f1554f == c0600a.f1554f && Arrays.equals(this.f1553e, c0600a.f1553e);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1553e) + (this.f1554f * 31);
    }

    public final String toString() {
        int i3 = this.f1554f;
        StringBuilder sb = new StringBuilder((i3 / 8) + i3 + 1);
        for (int i4 = 0; i4 < this.f1554f; i4++) {
            if ((i4 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(m1375d(i4) ? 'X' : '.');
        }
        return sb.toString();
    }
}
