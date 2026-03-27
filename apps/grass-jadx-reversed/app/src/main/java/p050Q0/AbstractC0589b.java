package p050Q0;

import java.util.Arrays;

/* JADX INFO: renamed from: Q0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0589b {

    /* JADX INFO: renamed from: a */
    public static final char[] f1500a;

    /* JADX INFO: renamed from: b */
    public static final char[] f1501b;

    /* JADX INFO: renamed from: c */
    public static final byte[] f1502c;

    /* JADX INFO: renamed from: d */
    public static final byte[] f1503d;

    /* JADX INFO: renamed from: e */
    public static final int[] f1504e;

    /* JADX INFO: renamed from: f */
    public static final int[] f1505f;

    /* JADX INFO: renamed from: g */
    public static final int[] f1506g;

    /* JADX INFO: renamed from: h */
    public static final int[] f1507h;

    /* JADX INFO: renamed from: i */
    public static final int[] f1508i;

    /* JADX INFO: renamed from: j */
    public static final int[] f1509j;

    /* JADX INFO: renamed from: k */
    public static final int[] f1510k;

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        f1500a = charArray;
        f1501b = "0123456789abcdef".toCharArray();
        int length = charArray.length;
        f1502c = new byte[length];
        f1503d = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            f1502c[i3] = (byte) f1500a[i3];
            f1503d[i3] = (byte) f1501b[i3];
        }
        int[] iArr = new int[256];
        for (int i4 = 0; i4 < 32; i4++) {
            iArr[i4] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f1504e = iArr;
        int length2 = iArr.length;
        int[] iArr2 = new int[length2];
        System.arraycopy(iArr, 0, iArr2, 0, length2);
        for (int i5 = 128; i5 < 256; i5++) {
            iArr2[i5] = (i5 & 224) == 192 ? 2 : (i5 & 240) == 224 ? 3 : (i5 & 248) == 240 ? 4 : -1;
        }
        f1505f = iArr2;
        int[] iArr3 = new int[256];
        Arrays.fill(iArr3, -1);
        for (int i6 = 33; i6 < 256; i6++) {
            if (Character.isJavaIdentifierPart((char) i6)) {
                iArr3[i6] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        f1506g = iArr3;
        int[] iArr4 = new int[256];
        System.arraycopy(iArr3, 0, iArr4, 0, 256);
        Arrays.fill(iArr4, 128, 128, 0);
        f1507h = iArr4;
        int[] iArr5 = new int[256];
        int[] iArr6 = f1505f;
        System.arraycopy(iArr6, 128, iArr5, 128, 128);
        Arrays.fill(iArr5, 0, 32, -1);
        iArr5[9] = 0;
        iArr5[10] = 10;
        iArr5[13] = 13;
        iArr5[42] = 42;
        f1508i = iArr5;
        int[] iArr7 = new int[256];
        System.arraycopy(iArr6, 128, iArr7, 128, 128);
        Arrays.fill(iArr7, 0, 32, -1);
        iArr7[32] = 1;
        iArr7[9] = 1;
        iArr7[10] = 10;
        iArr7[13] = 13;
        iArr7[47] = 47;
        iArr7[35] = 35;
        int[] iArr8 = new int[128];
        for (int i7 = 0; i7 < 32; i7++) {
            iArr8[i7] = -1;
        }
        iArr8[34] = 34;
        iArr8[92] = 92;
        iArr8[8] = 98;
        iArr8[9] = 116;
        iArr8[12] = 102;
        iArr8[10] = 110;
        iArr8[13] = 114;
        f1509j = iArr8;
        int[] iArr9 = new int[256];
        f1510k = iArr9;
        Arrays.fill(iArr9, -1);
        for (int i8 = 0; i8 < 10; i8++) {
            f1510k[i8 + 48] = i8;
        }
        for (int i9 = 0; i9 < 6; i9++) {
            int[] iArr10 = f1510k;
            int i10 = i9 + 10;
            iArr10[i9 + 97] = i10;
            iArr10[i9 + 65] = i10;
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m1334a(boolean z3) {
        return (byte[]) (z3 ? f1502c.clone() : f1503d.clone());
    }

    /* JADX INFO: renamed from: b */
    public static char[] m1335b(boolean z3) {
        return (char[]) (z3 ? f1500a.clone() : f1501b.clone());
    }

    /* JADX INFO: renamed from: c */
    public static int[] m1336c(int i3) {
        int[] iArr = f1509j;
        if (i3 == 34) {
            return iArr;
        }
        int[][] iArr2 = C0588a.f1498b.f1499a;
        int[] iArrCopyOf = iArr2[i3];
        if (iArrCopyOf == null) {
            iArrCopyOf = Arrays.copyOf(iArr, 128);
            if (iArrCopyOf[i3] == 0) {
                iArrCopyOf[i3] = -1;
            }
            iArr2[i3] = iArrCopyOf;
        }
        return iArrCopyOf;
    }
}
