package p086c2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import p119m2.AbstractC1766e;
import p144t0.AbstractC1919e;
import p144t0.AbstractC1920f;

/* JADX INFO: renamed from: c2.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1084c extends AbstractC1919e {
    /* JADX INFO: renamed from: A */
    public static char m2827A(char[] cArr) {
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    /* JADX INFO: renamed from: B */
    public static List m2828B(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new C1082a(objArr, false)) : AbstractC1920f.m4310m(objArr[0]) : C1093l.f3782e;
    }

    /* JADX INFO: renamed from: w */
    public static List m2829w(Object[] objArr) {
        AbstractC1766e.m3920e("<this>", objArr);
        List listAsList = Arrays.asList(objArr);
        AbstractC1766e.m3919d("asList(...)", listAsList);
        return listAsList;
    }

    /* JADX INFO: renamed from: x */
    public static boolean m2830x(long[] jArr, long j2) {
        int length = jArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (j2 == jArr[i3]) {
                break;
            }
            i3++;
        }
        return i3 >= 0;
    }

    /* JADX INFO: renamed from: y */
    public static final void m2831y(Object[] objArr, Object[] objArr2, int i3, int i4, int i5) {
        AbstractC1766e.m3920e("<this>", objArr);
        AbstractC1766e.m3920e("destination", objArr2);
        System.arraycopy(objArr, i4, objArr2, i3, i5 - i4);
    }

    /* JADX INFO: renamed from: z */
    public static int m2832z(Object[] objArr, Object obj) {
        AbstractC1766e.m3920e("<this>", objArr);
        int i3 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i3 < length) {
                if (objArr[i3] == null) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i3 < length2) {
            if (obj.equals(objArr[i3])) {
                return i3;
            }
            i3++;
        }
        return -1;
    }
}
