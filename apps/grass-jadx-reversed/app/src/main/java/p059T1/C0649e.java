package p059T1;

/* JADX INFO: renamed from: T1.e */
/* JADX INFO: loaded from: classes.dex */
public class C0649e {

    /* JADX INFO: renamed from: i */
    public static final C0649e[] f1737i = {new C0649e(false, 3, 5, 8, 8, 1, 3, 5), new C0649e(false, 5, 7, 10, 10, 1, 5, 7), new C0649e(true, 5, 7, 16, 6, 1, 5, 7), new C0649e(false, 8, 10, 12, 12, 1, 8, 10), new C0649e(true, 10, 11, 14, 6, 2, 10, 11), new C0649e(false, 12, 12, 14, 14, 1, 12, 12), new C0649e(true, 16, 14, 24, 10, 1, 16, 14), new C0649e(false, 18, 14, 16, 16, 1, 18, 14), new C0649e(false, 22, 18, 18, 18, 1, 22, 18), new C0649e(true, 22, 18, 16, 10, 2, 22, 18), new C0649e(false, 30, 20, 20, 20, 1, 30, 20), new C0649e(true, 32, 24, 16, 14, 2, 32, 24), new C0649e(false, 36, 24, 22, 22, 1, 36, 24), new C0649e(false, 44, 28, 24, 24, 1, 44, 28), new C0649e(true, 49, 28, 22, 14, 2, 49, 28), new C0649e(false, 62, 36, 14, 14, 4, 62, 36), new C0649e(false, 86, 42, 16, 16, 4, 86, 42), new C0649e(false, 114, 48, 18, 18, 4, 114, 48), new C0649e(false, 144, 56, 20, 20, 4, 144, 56), new C0649e(false, 174, 68, 22, 22, 4, 174, 68), new C0649e(false, 204, 84, 24, 24, 4, 102, 42), new C0649e(false, 280, 112, 14, 14, 16, 140, 56), new C0649e(false, 368, 144, 16, 16, 16, 92, 36), new C0649e(false, 456, 192, 18, 18, 16, 114, 48), new C0649e(false, 576, 224, 20, 20, 16, 144, 56), new C0649e(false, 696, 272, 22, 22, 16, 174, 68), new C0649e(false, 816, 336, 24, 24, 16, 136, 56), new C0649e(false, 1050, 408, 18, 18, 36, 175, 68), new C0649e(false, 1304, 496, 20, 20, 36, 163, 62), new C0645a(false, 1558, 620, 22, 22, 36, -1, 62)};

    /* JADX INFO: renamed from: a */
    public final boolean f1738a;

    /* JADX INFO: renamed from: b */
    public final int f1739b;

    /* JADX INFO: renamed from: c */
    public final int f1740c;

    /* JADX INFO: renamed from: d */
    public final int f1741d;

    /* JADX INFO: renamed from: e */
    public final int f1742e;

    /* JADX INFO: renamed from: f */
    public final int f1743f;

    /* JADX INFO: renamed from: g */
    public final int f1744g;

    /* JADX INFO: renamed from: h */
    public final int f1745h;

    public C0649e(boolean z3, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f1738a = z3;
        this.f1739b = i3;
        this.f1740c = i4;
        this.f1741d = i5;
        this.f1742e = i6;
        this.f1743f = i7;
        this.f1744g = i8;
        this.f1745h = i9;
    }

    /* JADX INFO: renamed from: e */
    public static C0649e m1599e(int i3, EnumC0650f enumC0650f) {
        C0649e[] c0649eArr = f1737i;
        for (int i4 = 0; i4 < 30; i4++) {
            C0649e c0649e = c0649eArr[i4];
            if (!(enumC0650f == EnumC0650f.f1747f && c0649e.f1738a) && ((enumC0650f != EnumC0650f.f1748g || c0649e.f1738a) && i3 <= c0649e.f1739b)) {
                return c0649e;
            }
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i3)));
    }

    /* JADX INFO: renamed from: a */
    public int mo1592a(int i3) {
        return this.f1744g;
    }

    /* JADX INFO: renamed from: b */
    public final int m1600b() {
        int i3 = 1;
        int i4 = this.f1743f;
        if (i4 != 1) {
            i3 = 2;
            if (i4 != 2 && i4 != 4) {
                if (i4 == 16) {
                    return 4;
                }
                if (i4 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: c */
    public int mo1593c() {
        return this.f1739b / this.f1744g;
    }

    /* JADX INFO: renamed from: d */
    public final int m1601d() {
        int i3 = this.f1743f;
        if (i3 == 1 || i3 == 2) {
            return 1;
        }
        if (i3 == 4) {
            return 2;
        }
        if (i3 == 16) {
            return 4;
        }
        if (i3 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1738a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        int i3 = this.f1741d;
        sb.append(i3);
        sb.append('x');
        int i4 = this.f1742e;
        sb.append(i4);
        sb.append(", symbol size ");
        sb.append((m1600b() * i3) + (m1600b() << 1));
        sb.append('x');
        sb.append((m1601d() * i4) + (m1601d() << 1));
        sb.append(", symbol data size ");
        sb.append(m1600b() * i3);
        sb.append('x');
        sb.append(m1601d() * i4);
        sb.append(", codewords ");
        sb.append(this.f1739b);
        sb.append('+');
        sb.append(this.f1740c);
        return sb.toString();
    }
}
