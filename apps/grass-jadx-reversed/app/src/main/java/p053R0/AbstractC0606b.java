package p053R0;

import java.util.Arrays;

/* JADX INFO: renamed from: R0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0606b {

    /* JADX INFO: renamed from: a */
    public static final byte[] f1564a;

    static {
        byte[] bArr = new byte[256];
        f1564a = bArr;
        Arrays.fill(bArr, (byte) -1);
        for (char c3 = '0'; c3 <= '9'; c3 = (char) (c3 + 1)) {
            f1564a[c3] = (byte) (c3 - '0');
        }
        for (char c4 = 'A'; c4 <= 'F'; c4 = (char) (c4 + 1)) {
            f1564a[c4] = (byte) (c4 - '7');
        }
        for (char c5 = 'a'; c5 <= 'f'; c5 = (char) (c5 + 1)) {
            f1564a[c5] = (byte) (c5 - 'W');
        }
        for (char c6 = '.'; c6 <= '.'; c6 = (char) (c6 + 1)) {
            f1564a[c6] = -4;
        }
    }

    /* JADX INFO: renamed from: a */
    public static char m1387a(CharSequence charSequence, int i3, int i4) {
        if (i3 < i4) {
            return charSequence.charAt(i3);
        }
        return (char) 0;
    }

    /* JADX INFO: renamed from: b */
    public static int m1388b(char c3) {
        if (c3 < 128) {
            return f1564a[c3];
        }
        return -1;
    }
}
