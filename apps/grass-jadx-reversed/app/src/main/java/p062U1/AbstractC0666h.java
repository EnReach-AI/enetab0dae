package p062U1;

import p020F2.AbstractC0223a;
import p043N1.AbstractC0561c;
import p043N1.C0560b;

/* JADX INFO: renamed from: U1.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0666h extends AbstractC0223a {

    /* JADX INFO: renamed from: b */
    public static final int[] f1814b = {1, 1, 1};

    /* JADX INFO: renamed from: c */
    public static final int[] f1815c = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: d */
    public static final int[] f1816d = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: e */
    public static final int[][] f1817e;

    /* JADX INFO: renamed from: f */
    public static final int[][] f1818f;

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f1817e = iArr;
        int[][] iArr2 = new int[20][];
        f1818f = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i3 = 10; i3 < 20; i3++) {
            int[] iArr3 = f1817e[i3 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i4 = 0; i4 < iArr3.length; i4++) {
                iArr4[i4] = iArr3[(iArr3.length - i4) - 1];
            }
            f1818f[i3] = iArr4;
        }
    }

    /* JADX INFO: renamed from: i */
    public static boolean m1626i(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i3 = length - 1;
        return m1627j(charSequence.subSequence(0, i3)) == Character.digit(charSequence.charAt(i3), 10);
    }

    /* JADX INFO: renamed from: j */
    public static int m1627j(CharSequence charSequence) throws C0560b {
        int length = charSequence.length();
        int i3 = 0;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            int iCharAt = charSequence.charAt(i4) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                C0560b c0560b = C0560b.f1366g;
                if (AbstractC0561c.f1367e) {
                    throw new C0560b();
                }
                throw C0560b.f1366g;
            }
            i3 += iCharAt;
        }
        int i5 = i3 * 3;
        for (int i6 = length - 2; i6 >= 0; i6 -= 2) {
            int iCharAt2 = charSequence.charAt(i6) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                C0560b c0560b2 = C0560b.f1366g;
                if (AbstractC0561c.f1367e) {
                    throw new C0560b();
                }
                throw C0560b.f1366g;
            }
            i5 += iCharAt2;
        }
        return (1000 - i5) % 10;
    }
}
