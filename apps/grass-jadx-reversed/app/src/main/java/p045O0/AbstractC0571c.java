package p045O0;

import com.fasterxml.jackson.core.exc.C1130a;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.math.BigDecimal;
import java.math.BigInteger;
import p005B.AbstractC0032g;
import p042N0.AbstractC0545m;
import p042N0.C0541i;
import p042N0.C0542j;
import p042N0.EnumC0548p;
import p050Q0.AbstractC0594g;
import p050Q0.C0591d;

/* JADX INFO: renamed from: O0.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0571c extends AbstractC0545m {

    /* JADX INFO: renamed from: h */
    public static final byte[] f1414h = new byte[0];

    /* JADX INFO: renamed from: i */
    public static final BigInteger f1415i;

    /* JADX INFO: renamed from: j */
    public static final BigInteger f1416j;

    /* JADX INFO: renamed from: k */
    public static final BigInteger f1417k;

    /* JADX INFO: renamed from: l */
    public static final BigInteger f1418l;

    /* JADX INFO: renamed from: m */
    public static final BigDecimal f1419m;

    /* JADX INFO: renamed from: n */
    public static final BigDecimal f1420n;

    /* JADX INFO: renamed from: o */
    public static final BigDecimal f1421o;

    /* JADX INFO: renamed from: p */
    public static final BigDecimal f1422p;

    /* JADX INFO: renamed from: g */
    public EnumC0548p f1423g;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(-2147483648L);
        f1415i = bigIntegerValueOf;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(2147483647L);
        f1416j = bigIntegerValueOf2;
        BigInteger bigIntegerValueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        f1417k = bigIntegerValueOf3;
        BigInteger bigIntegerValueOf4 = BigInteger.valueOf(Long.MAX_VALUE);
        f1418l = bigIntegerValueOf4;
        f1419m = new BigDecimal(bigIntegerValueOf3);
        f1420n = new BigDecimal(bigIntegerValueOf4);
        f1421o = new BigDecimal(bigIntegerValueOf);
        f1422p = new BigDecimal(bigIntegerValueOf2);
    }

    public AbstractC0571c(int i3) {
        this.f1306e = i3;
    }

    /* JADX INFO: renamed from: e0 */
    public static final String m1276e0(int i3) {
        char c3 = (char) i3;
        if (Character.isISOControl(c3)) {
            return "(CTRL-CHAR, code " + i3 + ")";
        }
        if (i3 <= 255) {
            return "'" + c3 + "' (code " + i3 + ")";
        }
        return "'" + c3 + "' (code " + i3 + " / 0x" + Integer.toHexString(i3) + ")";
    }

    /* JADX INFO: renamed from: g0 */
    public static String m1277g0(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith("-")) {
            length--;
        }
        return String.format("[Integer with %d digits]", Integer.valueOf(length));
    }

    /* JADX INFO: renamed from: h0 */
    public static String m1278h0(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith("-")) {
            length--;
        }
        return String.format("[number with %d characters]", Integer.valueOf(length));
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: F */
    public C0541i mo1161F() {
        return mo1197l();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: H */
    public int mo1163H() {
        EnumC0548p enumC0548p = this.f1423g;
        return (enumC0548p == EnumC0548p.VALUE_NUMBER_INT || enumC0548p == EnumC0548p.VALUE_NUMBER_FLOAT) ? mo1204s() : mo1286p0();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: I */
    public final long mo1164I() {
        EnumC0548p enumC0548p;
        String strTrim;
        int length;
        EnumC0548p enumC0548p2 = this.f1423g;
        EnumC0548p enumC0548p3 = EnumC0548p.VALUE_NUMBER_INT;
        if (enumC0548p2 == enumC0548p3 || enumC0548p2 == (enumC0548p = EnumC0548p.VALUE_NUMBER_FLOAT)) {
            return mo1205t();
        }
        if (enumC0548p2 == enumC0548p3 || enumC0548p2 == enumC0548p) {
            return mo1205t();
        }
        long jM1346c = 0;
        if (enumC0548p2 == null) {
            return 0L;
        }
        int i3 = enumC0548p2.f1328h;
        if (i3 != 6) {
            switch (i3) {
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    return 1L;
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                default:
                    return 0L;
                case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                    Object objMo1202q = mo1202q();
                    if (objMo1202q instanceof Number) {
                        return ((Number) objMo1202q).longValue();
                    }
                    return 0L;
            }
        }
        String strMo1157B = mo1157B();
        if ("null".equals(strMo1157B)) {
            return 0L;
        }
        String str = AbstractC0594g.f1522a;
        if (strMo1157B == null || (length = (strTrim = strMo1157B.trim()).length()) == 0) {
            return 0L;
        }
        int i4 = 0;
        char cCharAt = strTrim.charAt(0);
        if (cCharAt == '+') {
            strTrim = strTrim.substring(1);
            length = strTrim.length();
        } else if (cCharAt == '-') {
            i4 = 1;
        }
        while (i4 < length) {
            try {
                char cCharAt2 = strTrim.charAt(i4);
                if (cCharAt2 > '9' || cCharAt2 < '0') {
                    jM1346c = (long) AbstractC0594g.m1346c(strTrim, true);
                    break;
                }
                i4++;
            } catch (NumberFormatException unused) {
                return jM1346c;
            }
        }
        jM1346c = Long.parseLong(strTrim);
        return jM1346c;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: J */
    public String mo1165J() {
        return mo1287q0();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: K */
    public final boolean mo1166K() {
        return this.f1423g != null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: M */
    public final boolean mo1168M(EnumC0548p enumC0548p) {
        return this.f1423g == enumC0548p;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: N */
    public final boolean mo1169N() {
        EnumC0548p enumC0548p = this.f1423g;
        return enumC0548p != null && enumC0548p.f1328h == 5;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: P */
    public final boolean mo1171P() {
        return this.f1423g == EnumC0548p.VALUE_NUMBER_INT;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: Q */
    public final boolean mo1172Q() {
        return this.f1423g == EnumC0548p.START_ARRAY;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: R */
    public final boolean mo1173R() {
        return this.f1423g == EnumC0548p.START_OBJECT;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: c */
    public final void mo1186c() {
        if (this.f1423g != null) {
            this.f1423g = null;
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: c0 */
    public AbstractC0545m mo1187c0() throws C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p != EnumC0548p.START_OBJECT && enumC0548p != EnumC0548p.START_ARRAY) {
            return this;
        }
        int i3 = 1;
        while (true) {
            EnumC0548p enumC0548pMo1177V = mo1177V();
            if (enumC0548pMo1177V == null) {
                mo1269f0();
                return this;
            }
            if (enumC0548pMo1177V.f1329i) {
                i3++;
            } else if (enumC0548pMo1177V.f1330j) {
                i3--;
                if (i3 == 0) {
                    return this;
                }
            } else if (enumC0548pMo1177V == EnumC0548p.NOT_AVAILABLE) {
                throw new C0542j(this, AbstractC0032g.m154l("Not enough content available for `skipChildren()`: non-blocking parser? (", getClass().getName(), ")"));
            }
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: e */
    public final EnumC0548p mo1190e() {
        return this.f1423g;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: f */
    public final int mo1191f() {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == null) {
            return 0;
        }
        return enumC0548p.f1328h;
    }

    /* JADX INFO: renamed from: f0 */
    public abstract void mo1269f0();

    /* JADX INFO: renamed from: i0 */
    public final void m1279i0(String str) throws C0542j {
        throw new C0542j(this, str);
    }

    /* JADX INFO: renamed from: j0 */
    public final void m1280j0() throws C0591d {
        m1281k0(" in " + this.f1423g);
        throw null;
    }

    /* JADX INFO: renamed from: k0 */
    public final void m1281k0(String str) throws C0591d {
        throw new C0591d(this, AbstractC0032g.m152j("Unexpected end-of-input", str));
    }

    /* JADX INFO: renamed from: l0 */
    public final void m1282l0(EnumC0548p enumC0548p) throws C0591d {
        m1281k0(enumC0548p != EnumC0548p.VALUE_STRING ? (enumC0548p == EnumC0548p.VALUE_NUMBER_INT || enumC0548p == EnumC0548p.VALUE_NUMBER_FLOAT) ? " in a Number value" : " in a value" : " in a String value");
        throw null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: m */
    public String mo1198m() {
        return mo1188d();
    }

    /* JADX INFO: renamed from: m0 */
    public final void m1283m0(int i3, String str) throws C0542j {
        if (i3 < 0) {
            m1280j0();
            throw null;
        }
        String strM154l = AbstractC0032g.m154l("Unexpected character (", m1276e0(i3), ")");
        if (str != null) {
            strM154l = strM154l + ": " + str;
        }
        m1279i0(strM154l);
        throw null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: n */
    public final EnumC0548p mo1199n() {
        return this.f1423g;
    }

    /* JADX INFO: renamed from: n0 */
    public final void m1284n0(int i3, String str) throws C0542j {
        m1279i0(AbstractC0032g.m154l("Unexpected character (", m1276e0(i3), ") in numeric value") + ": " + str);
        throw null;
    }

    /* JADX INFO: renamed from: o0 */
    public final void m1285o0(int i3) throws C0542j {
        m1279i0("Illegal character (" + m1276e0((char) i3) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX INFO: renamed from: p0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int mo1286p0() {
        /*
            r7 = this;
            r0 = 1
            N0.p r1 = r7.f1423g
            N0.p r2 = p042N0.EnumC0548p.VALUE_NUMBER_INT
            if (r1 == r2) goto L7d
            N0.p r2 = p042N0.EnumC0548p.VALUE_NUMBER_FLOAT
            if (r1 != r2) goto Ld
            goto L7d
        Ld:
            r2 = 0
            if (r1 == 0) goto L7c
            r3 = 6
            int r1 = r1.f1328h
            if (r1 == r3) goto L2d
            r3 = 9
            if (r1 == r3) goto L2c
            r0 = 12
            if (r1 == r0) goto L1e
            goto L7c
        L1e:
            java.lang.Object r0 = r7.mo1202q()
            boolean r1 = r0 instanceof java.lang.Number
            if (r1 == 0) goto L7c
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
        L2c:
            return r0
        L2d:
            java.lang.String r1 = r7.mo1157B()
            java.lang.String r3 = "null"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L3a
            return r2
        L3a:
            java.lang.String r3 = p050Q0.AbstractC0594g.f1522a
            if (r1 != 0) goto L3f
            goto L7c
        L3f:
            java.lang.String r1 = r1.trim()
            int r3 = r1.length()
            if (r3 != 0) goto L4a
            goto L7c
        L4a:
            char r4 = r1.charAt(r2)
            r5 = 43
            if (r4 != r5) goto L5c
            java.lang.String r1 = r1.substring(r0)
            int r3 = r1.length()
        L5a:
            r4 = r2
            goto L61
        L5c:
            r5 = 45
            if (r4 != r5) goto L5a
            r4 = r0
        L61:
            if (r4 >= r3) goto L78
            char r5 = r1.charAt(r4)
            r6 = 57
            if (r5 > r6) goto L72
            r6 = 48
            if (r5 >= r6) goto L70
            goto L72
        L70:
            int r4 = r4 + r0
            goto L61
        L72:
            double r0 = p050Q0.AbstractC0594g.m1346c(r1, r0)     // Catch: java.lang.NumberFormatException -> L7c
            int r2 = (int) r0     // Catch: java.lang.NumberFormatException -> L7c
            goto L7c
        L78:
            int r2 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L7c
        L7c:
            return r2
        L7d:
            int r0 = r7.mo1204s()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p045O0.AbstractC0571c.mo1286p0():int");
    }

    /* JADX INFO: renamed from: q0 */
    public String mo1287q0() {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == EnumC0548p.VALUE_STRING) {
            return mo1157B();
        }
        if (enumC0548p == EnumC0548p.FIELD_NAME) {
            return mo1198m();
        }
        if (enumC0548p == null || enumC0548p == EnumC0548p.VALUE_NULL || !enumC0548p.f1332l) {
            return null;
        }
        return mo1157B();
    }

    /* JADX INFO: renamed from: r0 */
    public final void m1288r0() throws C1130a {
        throw new C1130a(this, String.format("Numeric value (%s) out of range of int (%d - %s)", m1277g0(mo1157B()), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    /* JADX INFO: renamed from: s0 */
    public final void m1289s0() throws C1130a {
        m1290t0(mo1157B());
        throw null;
    }

    /* JADX INFO: renamed from: t0 */
    public final void m1290t0(String str) throws C1130a {
        throw new C1130a(this, String.format("Numeric value (%s) out of range of long (%d - %s)", m1277g0(str), Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
