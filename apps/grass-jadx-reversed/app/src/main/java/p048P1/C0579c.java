package p048P1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: renamed from: P1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0579c {

    /* JADX INFO: renamed from: b */
    public static final String[] f1443b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* JADX INFO: renamed from: c */
    public static final int[][] f1444c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* JADX INFO: renamed from: d */
    public static final int[][] f1445d;

    /* JADX INFO: renamed from: e */
    public static final int[][] f1446e;

    /* JADX INFO: renamed from: a */
    public final byte[] f1447a;

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        f1445d = iArr;
        iArr[0][32] = 1;
        for (int i3 = 65; i3 <= 90; i3++) {
            f1445d[0][i3] = i3 - 63;
        }
        f1445d[1][32] = 1;
        for (int i4 = 97; i4 <= 122; i4++) {
            f1445d[1][i4] = i4 - 95;
        }
        f1445d[2][32] = 1;
        for (int i5 = 48; i5 <= 57; i5++) {
            f1445d[2][i5] = i5 - 46;
        }
        int[] iArr2 = f1445d[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i6 = 0; i6 < 28; i6++) {
            f1445d[3][iArr3[i6]] = i6;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i7 = 0; i7 < 31; i7++) {
            int i8 = iArr4[i7];
            if (i8 > 0) {
                f1445d[4][i8] = i7;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        f1446e = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f1446e;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public C0579c(byte[] bArr) {
        this.f1447a = bArr;
    }

    /* JADX INFO: renamed from: a */
    public static LinkedList m1303a(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C0581e c0581e = (C0581e) it.next();
            Iterator it2 = linkedList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    linkedList2.add(c0581e);
                    break;
                }
                C0581e c0581e2 = (C0581e) it2.next();
                if (c0581e2.m1306c(c0581e)) {
                    break;
                }
                if (c0581e.m1306c(c0581e2)) {
                    it2.remove();
                }
            }
        }
        return linkedList2;
    }
}
