package p128p;

/* JADX INFO: renamed from: p.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1810d {

    /* JADX INFO: renamed from: a */
    public static final int[] f6267a = new int[0];

    /* JADX INFO: renamed from: b */
    public static final Object[] f6268b = new Object[0];

    /* JADX INFO: renamed from: a */
    public static int m4021a(int i3, int i4, int[] iArr) {
        int i5 = i3 - 1;
        int i6 = 0;
        while (i6 <= i5) {
            int i7 = (i6 + i5) >>> 1;
            int i8 = iArr[i7];
            if (i8 < i4) {
                i6 = i7 + 1;
            } else {
                if (i8 <= i4) {
                    return i7;
                }
                i5 = i7 - 1;
            }
        }
        return ~i6;
    }

    /* JADX INFO: renamed from: b */
    public static int m4022b(long[] jArr, int i3, long j2) {
        int i4 = i3 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            long j3 = jArr[i6];
            if (j3 < j2) {
                i5 = i6 + 1;
            } else {
                if (j3 <= j2) {
                    return i6;
                }
                i4 = i6 - 1;
            }
        }
        return ~i5;
    }
}
