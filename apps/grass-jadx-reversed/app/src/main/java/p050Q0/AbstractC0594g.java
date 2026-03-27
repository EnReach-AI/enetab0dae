package p050Q0;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.math.BigInteger;
import p053R0.AbstractC0615k;
import p053R0.AbstractC0619o;
import p053R0.AbstractC0620p;
import p053R0.C0618n;

/* JADX INFO: renamed from: Q0.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0594g {

    /* JADX INFO: renamed from: a */
    public static final String f1522a = String.valueOf(Long.MIN_VALUE).substring(1);

    /* JADX INFO: renamed from: b */
    public static final String f1523b = String.valueOf(Long.MAX_VALUE);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.math.BigDecimal] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v9, types: [char[]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.math.BigDecimal m1344a(java.lang.String r6, boolean r7) {
        /*
            java.lang.String r0 = "\" can not be represented as `java.math.BigDecimal`, reason: "
            java.lang.String r1 = "Value \""
            r2 = 0
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r7 == 0) goto L47
            java.math.BigDecimal r6 = p053R0.AbstractC0614j.m1436a(r6)     // Catch: java.lang.NumberFormatException -> Le
            goto L61
        Le:
            r7 = move-exception
            int r4 = r6.length()
            if (r4 > r3) goto L16
            goto L2b
        L16:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = r6.substring(r2, r3)
            r4.append(r6)
            java.lang.String r6 = " [truncated]"
            r4.append(r6)
            java.lang.String r6 = r4.toString()
        L2b:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r3.append(r6)
            r3.append(r0)
            java.lang.String r6 = r7.getMessage()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            r2.<init>(r6)
            throw r2
        L47:
            char[] r6 = r6.toCharArray()
            int r7 = r6.length
            r4 = 500(0x1f4, float:7.0E-43)
            if (r7 >= r4) goto L5b
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch: java.lang.NumberFormatException -> L57 java.lang.ArithmeticException -> L59
            r4.<init>(r6, r2, r7)     // Catch: java.lang.NumberFormatException -> L57 java.lang.ArithmeticException -> L59
            r6 = r4
            goto L61
        L57:
            r4 = move-exception
            goto L62
        L59:
            r4 = move-exception
            goto L62
        L5b:
            int r4 = r7 / 10
            java.math.BigDecimal r6 = p148u0.AbstractC1944c.m4342f(r7, r6, r4)     // Catch: java.lang.NumberFormatException -> L57 java.lang.ArithmeticException -> L59
        L61:
            return r6
        L62:
            java.lang.String r4 = r4.getMessage()
            if (r4 != 0) goto L6a
            java.lang.String r4 = "Not a valid number representation"
        L6a:
            if (r7 > r3) goto L72
            java.lang.String r3 = new java.lang.String
            r3.<init>(r6, r2, r7)
            goto L95
        L72:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r5 = new java.lang.String
            char[] r2 = java.util.Arrays.copyOfRange(r6, r2, r3)
            r5.<init>(r2)
            r7.append(r5)
            java.lang.String r2 = "(truncated, full length is "
            r7.append(r2)
            int r6 = r6.length
            r7.append(r6)
            java.lang.String r6 = " chars)"
            r7.append(r6)
            java.lang.String r3 = r7.toString()
        L95:
            java.lang.NumberFormatException r6 = new java.lang.NumberFormatException
            java.lang.String r7 = p005B.AbstractC0032g.m155m(r1, r3, r0, r4)
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p050Q0.AbstractC0594g.m1344a(java.lang.String, boolean):java.math.BigDecimal");
    }

    /* JADX INFO: renamed from: b */
    public static BigInteger m1345b(String str, boolean z3) {
        if (!z3) {
            return new BigInteger(str);
        }
        try {
            return AbstractC0615k.m1437a(str);
        } catch (NumberFormatException e3) {
            if (str.length() > 1000) {
                str = str.substring(0, 1000) + " [truncated]";
            }
            throw new NumberFormatException("Value \"" + str + "\" can not be represented as `java.math.BigInteger`, reason: " + e3.getMessage());
        }
    }

    /* JADX INFO: renamed from: c */
    public static double m1346c(String str, boolean z3) {
        if (!z3) {
            return Double.parseDouble(str);
        }
        C0618n c0618n = AbstractC0619o.f1586a;
        return Double.longBitsToDouble(AbstractC0619o.f1586a.m1383e(str, str.length()));
    }

    /* JADX INFO: renamed from: d */
    public static float m1347d(String str, boolean z3) {
        if (!z3) {
            return Float.parseFloat(str);
        }
        C0618n c0618n = AbstractC0620p.f1587a;
        return Float.intBitsToFloat((int) AbstractC0620p.f1587a.m1383e(str, str.length()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: renamed from: e */
    public static int m1348e(int i3, char[] cArr, int i4) {
        if (i4 > 0 && cArr[i3] == '+') {
            i3++;
            i4--;
        }
        int i5 = cArr[(i3 + i4) - 1] - '0';
        switch (i4) {
            case 2:
                return i5 + ((cArr[i3] - '0') * 10);
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                i5 += (cArr[i3] - '0') * 100;
                i3++;
                return i5 + ((cArr[i3] - '0') * 10);
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                i5 += (cArr[i3] - '0') * 1000;
                i3++;
                i5 += (cArr[i3] - '0') * 100;
                i3++;
                return i5 + ((cArr[i3] - '0') * 10);
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                i5 += (cArr[i3] - '0') * 10000;
                i3++;
                i5 += (cArr[i3] - '0') * 1000;
                i3++;
                i5 += (cArr[i3] - '0') * 100;
                i3++;
                return i5 + ((cArr[i3] - '0') * 10);
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                i5 += (cArr[i3] - '0') * 100000;
                i3++;
                i5 += (cArr[i3] - '0') * 10000;
                i3++;
                i5 += (cArr[i3] - '0') * 1000;
                i3++;
                i5 += (cArr[i3] - '0') * 100;
                i3++;
                return i5 + ((cArr[i3] - '0') * 10);
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                i5 += (cArr[i3] - '0') * 1000000;
                i3++;
                i5 += (cArr[i3] - '0') * 100000;
                i3++;
                i5 += (cArr[i3] - '0') * 10000;
                i3++;
                i5 += (cArr[i3] - '0') * 1000;
                i3++;
                i5 += (cArr[i3] - '0') * 100;
                i3++;
                return i5 + ((cArr[i3] - '0') * 10);
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                i5 += (cArr[i3] - '0') * 10000000;
                i3++;
                i5 += (cArr[i3] - '0') * 1000000;
                i3++;
                i5 += (cArr[i3] - '0') * 100000;
                i3++;
                i5 += (cArr[i3] - '0') * 10000;
                i3++;
                i5 += (cArr[i3] - '0') * 1000;
                i3++;
                i5 += (cArr[i3] - '0') * 100;
                i3++;
                return i5 + ((cArr[i3] - '0') * 10);
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                i5 += (cArr[i3] - '0') * 100000000;
                i3++;
                i5 += (cArr[i3] - '0') * 10000000;
                i3++;
                i5 += (cArr[i3] - '0') * 1000000;
                i3++;
                i5 += (cArr[i3] - '0') * 100000;
                i3++;
                i5 += (cArr[i3] - '0') * 10000;
                i3++;
                i5 += (cArr[i3] - '0') * 1000;
                i3++;
                i5 += (cArr[i3] - '0') * 100;
                i3++;
                return i5 + ((cArr[i3] - '0') * 10);
            default:
                return i5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0072, code lost:
    
        return java.lang.Integer.parseInt(r10);
     */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m1349f(java.lang.String r10) {
        /*
            r0 = 0
            char r1 = r10.charAt(r0)
            int r2 = r10.length()
            r3 = 45
            r4 = 1
            if (r1 != r3) goto Lf
            r0 = r4
        Lf:
            r3 = 2
            r5 = 10
            if (r0 == 0) goto L24
            if (r2 == r4) goto L1f
            if (r2 <= r5) goto L19
            goto L1f
        L19:
            char r1 = r10.charAt(r4)
            r4 = r3
            goto L2d
        L1f:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L24:
            r6 = 9
            if (r2 <= r6) goto L2d
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L2d:
            r6 = 57
            if (r1 > r6) goto L81
            r7 = 48
            if (r1 >= r7) goto L36
            goto L81
        L36:
            int r1 = r1 - r7
            if (r4 >= r2) goto L7d
            int r8 = r4 + 1
            char r9 = r10.charAt(r4)
            if (r9 > r6) goto L78
            if (r9 >= r7) goto L44
            goto L78
        L44:
            int r1 = r1 * 10
            int r9 = r9 - r7
            int r1 = r1 + r9
            if (r8 >= r2) goto L7d
            int r4 = r4 + r3
            char r3 = r10.charAt(r8)
            if (r3 > r6) goto L73
            if (r3 >= r7) goto L54
            goto L73
        L54:
            int r1 = r1 * 10
            int r3 = r3 - r7
            int r1 = r1 + r3
            if (r4 >= r2) goto L7d
        L5a:
            int r3 = r4 + 1
            char r4 = r10.charAt(r4)
            if (r4 > r6) goto L6e
            if (r4 >= r7) goto L65
            goto L6e
        L65:
            int r1 = r1 * r5
            int r4 = r4 + (-48)
            int r1 = r1 + r4
            if (r3 < r2) goto L6c
            goto L7d
        L6c:
            r4 = r3
            goto L5a
        L6e:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L73:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L78:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L7d:
            if (r0 == 0) goto L80
            int r1 = -r1
        L80:
            return r1
        L81:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p050Q0.AbstractC0594g.m1349f(java.lang.String):int");
    }

    /* JADX INFO: renamed from: g */
    public static long m1350g(int i3, char[] cArr, int i4) {
        int i5 = i4 - 9;
        return (((long) m1348e(i3, cArr, i5)) * 1000000000) + ((long) m1348e(i3 + i5, cArr, 9));
    }

    /* JADX INFO: renamed from: h */
    public static long m1351h(String str) {
        return str.length() <= 9 ? m1349f(str) : Long.parseLong(str);
    }
}
