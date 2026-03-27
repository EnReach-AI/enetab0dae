package p053R0;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: renamed from: R0.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0610f {

    /* JADX INFO: renamed from: a */
    public static final BigInteger f1573a = BigInteger.valueOf(5);

    /* JADX INFO: renamed from: b */
    public static final BigInteger f1574b = BigInteger.valueOf(10000000000000000L);

    /* JADX INFO: renamed from: c */
    public static final BigInteger f1575c = BigInteger.valueOf(152587890625L);

    /* JADX INFO: renamed from: d */
    public static final BigInteger[] f1576d = {BigInteger.ONE, BigInteger.TEN, BigInteger.valueOf(100), BigInteger.valueOf(1000), BigInteger.valueOf(10000), BigInteger.valueOf(100000), BigInteger.valueOf(1000000), BigInteger.valueOf(10000000), BigInteger.valueOf(100000000), BigInteger.valueOf(1000000000), BigInteger.valueOf(10000000000L), BigInteger.valueOf(100000000000L), BigInteger.valueOf(1000000000000L), BigInteger.valueOf(10000000000000L), BigInteger.valueOf(100000000000000L), BigInteger.valueOf(1000000000000000L)};

    /* JADX INFO: renamed from: a */
    public static BigInteger m1417a(TreeMap treeMap, int i3) {
        BigInteger[] bigIntegerArr = f1576d;
        if (i3 < bigIntegerArr.length) {
            return bigIntegerArr[i3];
        }
        if (treeMap == null) {
            return f1573a.pow(i3).shiftLeft(i3);
        }
        Map.Entry entryFloorEntry = treeMap.floorEntry(Integer.valueOf(i3));
        Integer num = (Integer) entryFloorEntry.getKey();
        return num.intValue() == i3 ? (BigInteger) entryFloorEntry.getValue() : AbstractC0612h.m1431k((BigInteger) entryFloorEntry.getValue(), m1417a(treeMap, i3 - num.intValue()));
    }

    /* JADX INFO: renamed from: b */
    public static BigInteger m1418b(TreeMap treeMap, int i3) {
        int i4 = i3 & (-16);
        Map.Entry entryFloorEntry = treeMap.floorEntry(Integer.valueOf(i4));
        int iIntValue = ((Integer) entryFloorEntry.getKey()).intValue();
        BigInteger bigInteger = (BigInteger) entryFloorEntry.getValue();
        if (iIntValue == i4) {
            return bigInteger;
        }
        int i5 = i4 - iIntValue;
        BigInteger bigIntegerM1418b = (BigInteger) treeMap.get(Integer.valueOf(i5));
        if (bigIntegerM1418b == null) {
            bigIntegerM1418b = m1418b(treeMap, i5);
            treeMap.put(Integer.valueOf(i5), bigIntegerM1418b);
        }
        return AbstractC0612h.m1431k(bigInteger, bigIntegerM1418b);
    }

    /* JADX INFO: renamed from: c */
    public static void m1419c(TreeMap treeMap, int i3, int i4) {
        if (i4 - i3 <= 18) {
            return;
        }
        int i5 = i4 - ((((i4 - ((i3 + i4) >>> 1)) + 15) >> 4) << 4);
        int i6 = i4 - i5;
        if (treeMap.containsKey(Integer.valueOf(i6))) {
            return;
        }
        m1419c(treeMap, i3, i5);
        m1419c(treeMap, i5, i4);
        treeMap.put(Integer.valueOf(i6), m1418b(treeMap, i6));
    }

    /* JADX INFO: renamed from: d */
    public static C0609e m1420d(long j2, long j3) {
        long j4 = j2 & 4294967295L;
        long j5 = j2 >>> 32;
        long j6 = j3 & 4294967295L;
        long j7 = j3 >>> 32;
        long j8 = j5 * j7;
        long j9 = j7 * j4;
        return new C0609e(j8 + ((((j5 * j6) + ((j4 * j6) >>> 32)) + (4294967295L & j9)) >>> 32) + (j9 >>> 32));
    }
}
