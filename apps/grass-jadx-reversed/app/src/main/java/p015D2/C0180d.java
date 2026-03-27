package p015D2;

/* JADX INFO: renamed from: D2.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0180d {

    /* JADX INFO: renamed from: a */
    public static final char[] f419a = new char[117];

    /* JADX INFO: renamed from: b */
    public static final byte[] f420b = new byte[126];

    static {
        int i3 = 0;
        for (int i4 = 0; i4 < 32; i4++) {
        }
        m302a('b', 8);
        m302a('t', 9);
        m302a('n', 10);
        m302a('f', 12);
        m302a('r', 13);
        m302a('/', 47);
        m302a('\"', 34);
        m302a('\\', 92);
        while (true) {
            byte[] bArr = f420b;
            if (i3 >= 33) {
                bArr[9] = 3;
                bArr[10] = 3;
                bArr[13] = 3;
                bArr[32] = 3;
                bArr[44] = 4;
                bArr[58] = 5;
                bArr[123] = 6;
                bArr[125] = 7;
                bArr[91] = 8;
                bArr[93] = 9;
                bArr[34] = 1;
                bArr[92] = 2;
                return;
            }
            bArr[i3] = 127;
            i3++;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m302a(char c3, int i3) {
        if (c3 != 'u') {
            f419a[c3] = (char) i3;
        }
    }
}
