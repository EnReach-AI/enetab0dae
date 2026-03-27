package p054R1;

/* JADX INFO: renamed from: R1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0621a {

    /* JADX INFO: renamed from: g */
    public static final C0621a f1588g = new C0621a(4201, 4096, 1);

    /* JADX INFO: renamed from: h */
    public static final C0621a f1589h = new C0621a(1033, 1024, 1);

    /* JADX INFO: renamed from: i */
    public static final C0621a f1590i = new C0621a(67, 64, 1);

    /* JADX INFO: renamed from: j */
    public static final C0621a f1591j = new C0621a(19, 16, 1);

    /* JADX INFO: renamed from: k */
    public static final C0621a f1592k = new C0621a(285, 256, 0);

    /* JADX INFO: renamed from: l */
    public static final C0621a f1593l = new C0621a(301, 256, 1);

    /* JADX INFO: renamed from: a */
    public final int[] f1594a;

    /* JADX INFO: renamed from: b */
    public final int[] f1595b;

    /* JADX INFO: renamed from: c */
    public final C0622b f1596c;

    /* JADX INFO: renamed from: d */
    public final int f1597d;

    /* JADX INFO: renamed from: e */
    public final int f1598e;

    /* JADX INFO: renamed from: f */
    public final int f1599f;

    public C0621a(int i3, int i4, int i5) {
        this.f1598e = i3;
        this.f1597d = i4;
        this.f1599f = i5;
        this.f1594a = new int[i4];
        this.f1595b = new int[i4];
        int i6 = 1;
        for (int i7 = 0; i7 < i4; i7++) {
            this.f1594a[i7] = i6;
            i6 <<= 1;
            if (i6 >= i4) {
                i6 = (i6 ^ i3) & (i4 - 1);
            }
        }
        for (int i8 = 0; i8 < i4 - 1; i8++) {
            this.f1595b[this.f1594a[i8]] = i8;
        }
        this.f1596c = new C0622b(this, new int[]{0});
    }

    /* JADX INFO: renamed from: a */
    public final int m1438a(int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return 0;
        }
        int[] iArr = this.f1595b;
        return this.f1594a[(iArr[i3] + iArr[i4]) % (this.f1597d - 1)];
    }

    public final String toString() {
        return "GF(0x" + Integer.toHexString(this.f1598e) + ',' + this.f1597d + ')';
    }
}
