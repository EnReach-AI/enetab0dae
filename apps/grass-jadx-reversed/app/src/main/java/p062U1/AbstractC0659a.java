package p062U1;

import p020F2.AbstractC0223a;

/* JADX INFO: renamed from: U1.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0659a extends AbstractC0223a {

    /* JADX INFO: renamed from: b */
    public static final char[] f1798b = "0123456789-$:/.+ABCD".toCharArray();

    /* JADX INFO: renamed from: c */
    public static final int[] f1799c = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: i */
    public static boolean m1619i(char[] cArr, char c3) {
        for (char c4 : cArr) {
            if (c4 == c3) {
                return true;
            }
        }
        return false;
    }
}
