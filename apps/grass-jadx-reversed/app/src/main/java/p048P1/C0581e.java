package p048P1;

/* JADX INFO: renamed from: P1.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0581e {

    /* JADX INFO: renamed from: e */
    public static final C0581e f1450e = new C0581e(AbstractC0582f.f1455b, 0, 0, 0);

    /* JADX INFO: renamed from: a */
    public final int f1451a;

    /* JADX INFO: renamed from: b */
    public final AbstractC0582f f1452b;

    /* JADX INFO: renamed from: c */
    public final int f1453c;

    /* JADX INFO: renamed from: d */
    public final int f1454d;

    public C0581e(AbstractC0582f abstractC0582f, int i3, int i4, int i5) {
        this.f1452b = abstractC0582f;
        this.f1451a = i3;
        this.f1453c = i4;
        this.f1454d = i5;
    }

    /* JADX INFO: renamed from: a */
    public final C0581e m1304a(int i3) {
        AbstractC0582f c0580d = this.f1452b;
        int i4 = this.f1451a;
        int i5 = this.f1454d;
        if (i4 == 4 || i4 == 2) {
            int[] iArr = C0579c.f1444c[i4];
            i4 = 0;
            int i6 = iArr[0];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            c0580d.getClass();
            i5 += i8;
            c0580d = new C0580d(c0580d, i7, i8);
        }
        int i9 = this.f1453c;
        int i10 = (i9 == 0 || i9 == 31) ? 18 : i9 == 62 ? 9 : 8;
        int i11 = i9 + 1;
        C0581e c0581e = new C0581e(c0580d, i4, i11, i5 + i10);
        return i11 == 2078 ? c0581e.m1305b(i3 + 1) : c0581e;
    }

    /* JADX INFO: renamed from: b */
    public final C0581e m1305b(int i3) {
        int i4 = this.f1453c;
        if (i4 == 0) {
            return this;
        }
        AbstractC0582f abstractC0582f = this.f1452b;
        abstractC0582f.getClass();
        return new C0581e(new C0577a(abstractC0582f, i3 - i4, i4), this.f1451a, 0, this.f1454d);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1306c(C0581e c0581e) {
        int i3;
        int i4 = this.f1454d + (C0579c.f1444c[this.f1451a][c0581e.f1451a] >> 16);
        int i5 = c0581e.f1453c;
        if (i5 > 0 && ((i3 = this.f1453c) == 0 || i3 > i5)) {
            i4 += 10;
        }
        return i4 <= c0581e.f1454d;
    }

    /* JADX INFO: renamed from: d */
    public final C0581e m1307d(int i3, int i4) {
        int i5 = this.f1454d;
        AbstractC0582f c0580d = this.f1452b;
        int i6 = this.f1451a;
        if (i3 != i6) {
            int i7 = C0579c.f1444c[i6][i3];
            int i8 = 65535 & i7;
            int i9 = i7 >> 16;
            c0580d.getClass();
            i5 += i9;
            c0580d = new C0580d(c0580d, i8, i9);
        }
        int i10 = i3 == 2 ? 4 : 5;
        c0580d.getClass();
        return new C0581e(new C0580d(c0580d, i4, i10), i3, 0, i5 + i10);
    }

    /* JADX INFO: renamed from: e */
    public final C0581e m1308e(int i3, int i4) {
        int i5 = this.f1451a;
        int i6 = i5 == 2 ? 4 : 5;
        int i7 = C0579c.f1446e[i5][i3];
        AbstractC0582f abstractC0582f = this.f1452b;
        abstractC0582f.getClass();
        return new C0581e(new C0580d(new C0580d(abstractC0582f, i7, i6), i4, 5), i5, 0, this.f1454d + i6 + 5);
    }

    public final String toString() {
        return String.format("%s bits=%d bytes=%d", C0579c.f1443b[this.f1451a], Integer.valueOf(this.f1454d), Integer.valueOf(this.f1453c));
    }
}
