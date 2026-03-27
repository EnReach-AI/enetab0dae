package p045O0;

import com.fasterxml.jackson.core.exc.C1130a;
import com.fasterxml.jackson.core.exc.C1131b;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import p025H1.C0283l;
import p042N0.AbstractC0545m;
import p042N0.AbstractC0547o;
import p042N0.C0533a;
import p042N0.C0541i;
import p042N0.C0542j;
import p042N0.C0553u;
import p042N0.EnumC0543k;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p042N0.EnumC0554v;
import p050Q0.AbstractC0594g;
import p050Q0.C0590c;
import p050Q0.C0591d;
import p058T0.C0638c;
import p066W0.AbstractC0692s;
import p066W0.C0674a;
import p066W0.C0676c;
import p066W0.C0684k;
import p066W0.C0688o;
import p125o0.C1803m;

/* JADX INFO: renamed from: O0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0570b extends AbstractC0571c {

    /* JADX INFO: renamed from: S */
    public static final C0684k f1385S = AbstractC0545m.f1305f;

    /* JADX INFO: renamed from: A */
    public int f1386A;

    /* JADX INFO: renamed from: B */
    public C0638c f1387B;

    /* JADX INFO: renamed from: C */
    public EnumC0548p f1388C;

    /* JADX INFO: renamed from: D */
    public final C0688o f1389D;

    /* JADX INFO: renamed from: E */
    public char[] f1390E;

    /* JADX INFO: renamed from: F */
    public boolean f1391F;

    /* JADX INFO: renamed from: G */
    public C0676c f1392G;

    /* JADX INFO: renamed from: H */
    public byte[] f1393H;

    /* JADX INFO: renamed from: I */
    public int f1394I;

    /* JADX INFO: renamed from: J */
    public int f1395J;

    /* JADX INFO: renamed from: K */
    public long f1396K;

    /* JADX INFO: renamed from: L */
    public float f1397L;

    /* JADX INFO: renamed from: M */
    public double f1398M;

    /* JADX INFO: renamed from: N */
    public BigInteger f1399N;

    /* JADX INFO: renamed from: O */
    public BigDecimal f1400O;

    /* JADX INFO: renamed from: P */
    public String f1401P;

    /* JADX INFO: renamed from: Q */
    public boolean f1402Q;

    /* JADX INFO: renamed from: R */
    public int f1403R;

    /* JADX INFO: renamed from: q */
    public final C0283l f1404q;

    /* JADX INFO: renamed from: r */
    public final C0553u f1405r;

    /* JADX INFO: renamed from: s */
    public boolean f1406s;

    /* JADX INFO: renamed from: t */
    public int f1407t;

    /* JADX INFO: renamed from: u */
    public int f1408u;

    /* JADX INFO: renamed from: v */
    public long f1409v;

    /* JADX INFO: renamed from: w */
    public int f1410w;

    /* JADX INFO: renamed from: x */
    public int f1411x;

    /* JADX INFO: renamed from: y */
    public long f1412y;

    /* JADX INFO: renamed from: z */
    public int f1413z;

    public AbstractC0570b(C0283l c0283l, int i3) {
        super(i3);
        this.f1410w = 1;
        this.f1413z = 1;
        this.f1394I = 0;
        this.f1404q = c0283l;
        C0553u c0553u = (C0553u) c0283l.f760f;
        this.f1405r = c0553u == null ? C0553u.f1339e : c0553u;
        this.f1389D = new C0688o(c0553u, (C0674a) c0283l.f759e);
        this.f1387B = new C0638c(null, 0, EnumC0543k.STRICT_DUPLICATE_DETECTION.m1155a(i3) ? new C1803m(this) : null, 0, 1, 0);
    }

    /* JADX INFO: renamed from: P0 */
    public static int[] m1249P0(int[] iArr, int i3) {
        return iArr == null ? new int[i3] : Arrays.copyOf(iArr, iArr.length + i3);
    }

    /* JADX INFO: renamed from: Q0 */
    public static IllegalArgumentException m1250Q0(C0533a c0533a, int i3, int i4, String str) {
        String str2;
        if (i3 <= 32) {
            str2 = String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", Integer.toHexString(i3), Integer.valueOf(i4 + 1));
        } else if (i3 == c0533a.f1223i) {
            str2 = "Unexpected padding character ('" + c0533a.f1223i + "') as character #" + (i4 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(i3) || Character.isISOControl(i3)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(i3) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + ((char) i3) + "' (code 0x" + Integer.toHexString(i3) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }

    /* JADX INFO: renamed from: A0 */
    public final BigDecimal m1251A0() throws C0542j {
        BigDecimal bigDecimal = this.f1400O;
        if (bigDecimal != null) {
            return bigDecimal;
        }
        String str = this.f1401P;
        if (str == null) {
            throw new IllegalStateException("cannot get BigDecimal from current parser state");
        }
        try {
            BigDecimal bigDecimalM1344a = AbstractC0594g.m1344a(str, m1170O(EnumC0554v.USE_FAST_BIG_NUMBER_PARSER));
            this.f1400O = bigDecimalM1344a;
            this.f1401P = null;
            return bigDecimalM1344a;
        } catch (NumberFormatException e3) {
            C0542j c0542j = new C0542j("Malformed numeric value (" + AbstractC0571c.m1278h0(this.f1401P) + ")", mo1197l(), e3);
            c0542j.f3925f = this;
            throw c0542j;
        }
    }

    /* JADX INFO: renamed from: B0 */
    public final BigInteger m1252B0() throws C0542j {
        BigInteger bigInteger = this.f1399N;
        if (bigInteger != null) {
            return bigInteger;
        }
        String str = this.f1401P;
        if (str == null) {
            throw new IllegalStateException("cannot get BigInteger from current parser state");
        }
        try {
            BigInteger bigIntegerM1345b = AbstractC0594g.m1345b(str, m1170O(EnumC0554v.USE_FAST_BIG_NUMBER_PARSER));
            this.f1399N = bigIntegerM1345b;
            this.f1401P = null;
            return bigIntegerM1345b;
        } catch (NumberFormatException e3) {
            C0542j c0542j = new C0542j("Malformed numeric value (" + AbstractC0571c.m1278h0(this.f1401P) + ")", mo1197l(), e3);
            c0542j.f3925f = this;
            throw c0542j;
        }
    }

    /* JADX INFO: renamed from: C0 */
    public final C0676c m1253C0() {
        C0676c c0676c = this.f1392G;
        if (c0676c == null) {
            this.f1392G = new C0676c(null);
        } else {
            c0676c.m1638e();
        }
        return this.f1392G;
    }

    /* JADX INFO: renamed from: D0 */
    public final double m1254D0() throws C0542j {
        String str = this.f1401P;
        if (str != null) {
            try {
                this.f1398M = AbstractC0594g.m1346c(str, m1170O(EnumC0554v.USE_FAST_DOUBLE_PARSER));
                this.f1401P = null;
            } catch (NumberFormatException e3) {
                C0542j c0542j = new C0542j("Malformed numeric value (" + AbstractC0571c.m1278h0(this.f1401P) + ")", mo1197l(), e3);
                c0542j.f3925f = this;
                throw c0542j;
            }
        }
        return this.f1398M;
    }

    /* JADX INFO: renamed from: E0 */
    public final float m1255E0() throws C0542j {
        String str = this.f1401P;
        if (str != null) {
            try {
                this.f1397L = AbstractC0594g.m1347d(str, m1170O(EnumC0554v.USE_FAST_DOUBLE_PARSER));
                this.f1401P = null;
            } catch (NumberFormatException e3) {
                C0542j c0542j = new C0542j("Malformed numeric value (" + AbstractC0571c.m1278h0(this.f1401P) + ")", mo1197l(), e3);
                c0542j.f3925f = this;
                throw c0542j;
            }
        }
        return this.f1397L;
    }

    /* JADX INFO: renamed from: F0 */
    public final void m1256F0(char c3) throws C0542j {
        if (EnumC0543k.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.m1155a(this.f1306e)) {
            return;
        }
        if (c3 == '\'' && EnumC0543k.ALLOW_SINGLE_QUOTES.m1155a(this.f1306e)) {
            return;
        }
        m1279i0("Unrecognized character escape " + AbstractC0571c.m1276e0(c3));
        throw null;
    }

    /* JADX INFO: renamed from: G0 */
    public final int m1257G0() throws C1130a, C0542j {
        if (this.f1406s) {
            m1279i0("Internal error: _parseNumericValue called when parser instance closed");
            throw null;
        }
        if (this.f1423g != EnumC0548p.VALUE_NUMBER_INT || this.f1403R > 9) {
            m1258H0(1);
            if ((this.f1394I & 1) == 0) {
                m1263M0();
            }
            return this.f1395J;
        }
        int iM1654g = this.f1389D.m1654g(this.f1402Q);
        this.f1395J = iM1654g;
        this.f1394I = 1;
        return iM1654g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b8, code lost:
    
        if (r15 < 0) goto L61;
     */
    /* JADX INFO: renamed from: H0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1258H0(int r18) throws com.fasterxml.jackson.core.exc.C1130a, p042N0.C0542j {
        /*
            Method dump skipped, instruction units count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p045O0.AbstractC0570b.m1258H0(int):void");
    }

    /* JADX INFO: renamed from: I0 */
    public abstract void mo1259I0();

    /* JADX INFO: renamed from: J0 */
    public final void m1260J0(char c3, int i3) throws C0542j {
        C0638c c0638c = this.f1387B;
        m1279i0(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", Character.valueOf((char) i3), Character.valueOf(c3), c0638c.m1220h(), new C0541i(m1272w0(), -1L, -1L, c0638c.f1650i, c0638c.f1651j)));
        throw null;
    }

    /* JADX INFO: renamed from: K0 */
    public final void m1261K0(int i3, String str) throws C0542j {
        if (!EnumC0543k.ALLOW_UNQUOTED_CONTROL_CHARS.m1155a(this.f1306e) || i3 > 32) {
            m1279i0("Illegal unquoted character (" + AbstractC0571c.m1276e0((char) i3) + "): has to be escaped using backslash to be included in " + str);
            throw null;
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: L */
    public final boolean mo1167L() {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == EnumC0548p.VALUE_STRING) {
            return true;
        }
        if (enumC0548p == EnumC0548p.FIELD_NAME) {
            return this.f1391F;
        }
        return false;
    }

    /* JADX INFO: renamed from: L0 */
    public final String m1262L0() {
        return EnumC0543k.ALLOW_NON_NUMERIC_NUMBERS.m1155a(this.f1306e) ? "(JSON String, Number (or 'NaN'/'INF'/'+INF'), Array, Object or token 'null', 'true' or 'false')" : "(JSON String, Number, Array, Object or token 'null', 'true' or 'false')";
    }

    /* JADX INFO: renamed from: M0 */
    public final void m1263M0() throws C1130a, C0542j {
        int i3 = this.f1394I;
        if ((i3 & 2) != 0) {
            long j2 = this.f1396K;
            int i4 = (int) j2;
            if (i4 != j2) {
                throw new C1130a(this, String.format("Numeric value (%s) out of range of int (%d - %s)", AbstractC0571c.m1277g0(mo1157B()), Integer.MIN_VALUE, Integer.MAX_VALUE));
            }
            this.f1395J = i4;
        } else if ((i3 & 4) != 0) {
            BigInteger bigIntegerM1252B0 = m1252B0();
            if (AbstractC0571c.f1415i.compareTo(bigIntegerM1252B0) > 0 || AbstractC0571c.f1416j.compareTo(bigIntegerM1252B0) < 0) {
                m1288r0();
                throw null;
            }
            this.f1395J = bigIntegerM1252B0.intValue();
        } else if ((i3 & 8) != 0) {
            double dM1254D0 = m1254D0();
            if (dM1254D0 < -2.147483648E9d || dM1254D0 > 2.147483647E9d) {
                m1288r0();
                throw null;
            }
            this.f1395J = (int) dM1254D0;
        } else {
            if ((i3 & 16) == 0) {
                AbstractC0692s.m1666a();
                throw null;
            }
            BigDecimal bigDecimalM1251A0 = m1251A0();
            if (AbstractC0571c.f1421o.compareTo(bigDecimalM1251A0) > 0 || AbstractC0571c.f1422p.compareTo(bigDecimalM1251A0) < 0) {
                m1288r0();
                throw null;
            }
            this.f1395J = bigDecimalM1251A0.intValue();
        }
        this.f1394I |= 1;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:T0.c) from 0x0020: IPUT (r8v0 ?? I:T0.c), (r7v0 ?? I:T0.c) T0.c.f T0.c
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    /* JADX INFO: renamed from: N0 */
    public final void m1264N0(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:T0.c) from 0x0020: IPUT (r8v0 ?? I:T0.c), (r7v0 ?? I:T0.c) T0.c.f T0.c
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:T0.c) from 0x0020: IPUT (r8v0 ?? I:T0.c), (r7v0 ?? I:T0.c) T0.c.f T0.c
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    /* JADX INFO: renamed from: O0 */
    public final void m1265O0(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:T0.c) from 0x0020: IPUT (r8v0 ?? I:T0.c), (r7v0 ?? I:T0.c) T0.c.f T0.c
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    /* JADX INFO: renamed from: R0 */
    public final EnumC0548p m1266R0(String str, double d) throws C1131b {
        C0688o c0688o = this.f1389D;
        c0688o.f1870b = null;
        c0688o.f1871c = -1;
        c0688o.f1872d = 0;
        c0688o.mo1647s(str.length());
        c0688o.f1878j = str;
        c0688o.f1879k = null;
        if (c0688o.f1874f) {
            c0688o.m1652e();
        }
        c0688o.f1877i = 0;
        this.f1398M = d;
        this.f1394I = 8;
        return EnumC0548p.VALUE_NUMBER_FLOAT;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: S */
    public final boolean mo1174S() {
        if (this.f1423g != EnumC0548p.VALUE_NUMBER_FLOAT || (this.f1394I & 8) == 0) {
            return false;
        }
        return !Double.isFinite(m1254D0());
    }

    /* JADX INFO: renamed from: S0 */
    public final EnumC0548p m1267S0(boolean z3, int i3, int i4, int i5) throws C1131b {
        this.f1405r.getClass();
        C0553u.m1237b(i4 + i3 + i5);
        this.f1402Q = z3;
        this.f1403R = i3;
        this.f1394I = 0;
        return EnumC0548p.VALUE_NUMBER_FLOAT;
    }

    /* JADX INFO: renamed from: T0 */
    public final EnumC0548p m1268T0(int i3, boolean z3) throws C1131b {
        this.f1405r.getClass();
        C0553u.m1238c(i3);
        this.f1402Q = z3;
        this.f1403R = i3;
        this.f1394I = 0;
        return EnumC0548p.VALUE_NUMBER_INT;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: X */
    public final void mo1179X(int i3, int i4) {
        int i5 = this.f1306e;
        int i6 = (i3 & i4) | ((~i4) & i5);
        int i7 = i5 ^ i6;
        if (i7 != 0) {
            this.f1306e = i6;
            m1270u0(i6, i7);
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: a0 */
    public final void mo1183a0(Object obj) {
        this.f1387B.f1649h = obj;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: b0 */
    public final AbstractC0545m mo1185b0(int i3) {
        int i4 = this.f1306e ^ i3;
        if (i4 != 0) {
            this.f1306e = i3;
            m1270u0(i3, i4);
        }
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f1406s) {
            return;
        }
        this.f1407t = Math.max(this.f1407t, this.f1408u);
        this.f1406s = true;
        try {
            mo1271v0();
        } finally {
            mo1259I0();
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: d0 */
    public final C0553u mo1189d0() {
        return this.f1405r;
    }

    @Override // p045O0.AbstractC0571c
    /* JADX INFO: renamed from: f0 */
    public final void mo1269f0() throws C0591d {
        if (this.f1387B.m1218f()) {
            return;
        }
        String str = this.f1387B.m1216d() ? "Array" : "Object";
        C0638c c0638c = this.f1387B;
        C0590c c0590cM1272w0 = m1272w0();
        c0638c.getClass();
        m1281k0(": expected close marker for " + str + " (start marker at " + new C0541i(c0590cM1272w0, -1L, -1L, c0638c.f1650i, c0638c.f1651j) + ")");
        throw null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: g */
    public final BigInteger mo1192g() throws C1130a, C1131b, C0542j {
        int i3 = this.f1394I;
        if ((i3 & 4) == 0) {
            if (i3 == 0) {
                m1258H0(4);
            }
            int i4 = this.f1394I;
            if ((i4 & 4) == 0) {
                int i5 = i4 & 16;
                C0553u c0553u = this.f1405r;
                if (i5 != 0) {
                    BigDecimal bigDecimalM1251A0 = m1251A0();
                    int iScale = bigDecimalM1251A0.scale();
                    c0553u.getClass();
                    C0553u.m1236a(iScale);
                    this.f1399N = bigDecimalM1251A0.toBigInteger();
                } else if ((i4 & 2) != 0) {
                    this.f1399N = BigInteger.valueOf(this.f1396K);
                } else if ((i4 & 1) != 0) {
                    this.f1399N = BigInteger.valueOf(this.f1395J);
                } else {
                    if ((i4 & 8) == 0) {
                        AbstractC0692s.m1666a();
                        throw null;
                    }
                    if (this.f1401P != null) {
                        BigDecimal bigDecimalM1251A02 = m1251A0();
                        int iScale2 = bigDecimalM1251A02.scale();
                        c0553u.getClass();
                        C0553u.m1236a(iScale2);
                        this.f1399N = bigDecimalM1251A02.toBigInteger();
                    } else {
                        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(m1254D0());
                        int iScale3 = bigDecimalValueOf.scale();
                        c0553u.getClass();
                        C0553u.m1236a(iScale3);
                        this.f1399N = bigDecimalValueOf.toBigInteger();
                    }
                }
                this.f1394I |= 4;
            }
        }
        return m1252B0();
    }

    @Override // p045O0.AbstractC0571c, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: m */
    public final String mo1198m() {
        C0638c c0638c;
        EnumC0548p enumC0548p = this.f1423g;
        return ((enumC0548p == EnumC0548p.START_OBJECT || enumC0548p == EnumC0548p.START_ARRAY) && (c0638c = this.f1387B.f1645d) != null) ? c0638c.f1648g : this.f1387B.f1648g;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: o */
    public final BigDecimal mo1200o() throws C1130a, C0542j {
        int i3 = this.f1394I;
        if ((i3 & 16) == 0) {
            if (i3 == 0) {
                m1258H0(16);
            }
            int i4 = this.f1394I;
            if ((i4 & 16) == 0) {
                if ((i4 & 8) != 0) {
                    String strMo1157B = this.f1401P;
                    if (strMo1157B == null) {
                        strMo1157B = mo1157B();
                    }
                    this.f1400O = AbstractC0594g.m1344a(strMo1157B, m1170O(EnumC0554v.USE_FAST_BIG_NUMBER_PARSER));
                } else if ((i4 & 4) != 0) {
                    this.f1400O = new BigDecimal(m1252B0());
                } else if ((i4 & 2) != 0) {
                    this.f1400O = BigDecimal.valueOf(this.f1396K);
                } else {
                    if ((i4 & 1) == 0) {
                        AbstractC0692s.m1666a();
                        throw null;
                    }
                    this.f1400O = BigDecimal.valueOf(this.f1395J);
                }
                this.f1394I |= 16;
            }
        }
        return m1251A0();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: p */
    public final double mo1201p() throws C1130a, C0542j {
        int i3 = this.f1394I;
        if ((i3 & 8) == 0) {
            if (i3 == 0) {
                m1258H0(8);
            }
            int i4 = this.f1394I;
            if ((i4 & 8) == 0) {
                if ((i4 & 16) != 0) {
                    if (this.f1401P != null) {
                        this.f1398M = m1254D0();
                    } else {
                        this.f1398M = m1251A0().doubleValue();
                    }
                } else if ((i4 & 4) != 0) {
                    if (this.f1401P != null) {
                        this.f1398M = m1254D0();
                    } else {
                        this.f1398M = m1252B0().doubleValue();
                    }
                } else if ((i4 & 2) != 0) {
                    this.f1398M = this.f1396K;
                } else if ((i4 & 1) != 0) {
                    this.f1398M = this.f1395J;
                } else {
                    if ((i4 & 32) == 0) {
                        AbstractC0692s.m1666a();
                        throw null;
                    }
                    if (this.f1401P != null) {
                        this.f1398M = m1254D0();
                    } else {
                        this.f1398M = m1255E0();
                    }
                }
                this.f1394I |= 8;
            }
        }
        return m1254D0();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: r */
    public final float mo1203r() throws C1130a, C0542j {
        int i3 = this.f1394I;
        if ((i3 & 32) == 0) {
            if (i3 == 0) {
                m1258H0(32);
            }
            int i4 = this.f1394I;
            if ((i4 & 32) == 0) {
                if ((i4 & 16) != 0) {
                    if (this.f1401P != null) {
                        this.f1397L = m1255E0();
                    } else {
                        this.f1397L = m1251A0().floatValue();
                    }
                } else if ((i4 & 4) != 0) {
                    if (this.f1401P != null) {
                        this.f1397L = m1255E0();
                    } else {
                        this.f1397L = m1252B0().floatValue();
                    }
                } else if ((i4 & 2) != 0) {
                    this.f1397L = this.f1396K;
                } else if ((i4 & 1) != 0) {
                    this.f1397L = this.f1395J;
                } else {
                    if ((i4 & 8) == 0) {
                        AbstractC0692s.m1666a();
                        throw null;
                    }
                    if (this.f1401P != null) {
                        this.f1397L = m1255E0();
                    } else {
                        this.f1397L = (float) m1254D0();
                    }
                }
                this.f1394I |= 32;
            }
        }
        return m1255E0();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: s */
    public final int mo1204s() throws C1130a, C0542j {
        int i3 = this.f1394I;
        if ((i3 & 1) == 0) {
            if (i3 == 0) {
                return m1257G0();
            }
            if ((i3 & 1) == 0) {
                m1263M0();
            }
        }
        return this.f1395J;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: t */
    public final long mo1205t() throws C1130a, C0542j {
        int i3 = this.f1394I;
        if ((i3 & 2) == 0) {
            if (i3 == 0) {
                m1258H0(2);
            }
            int i4 = this.f1394I;
            if ((i4 & 2) == 0) {
                if ((i4 & 1) != 0) {
                    this.f1396K = this.f1395J;
                } else if ((i4 & 4) != 0) {
                    BigInteger bigIntegerM1252B0 = m1252B0();
                    if (AbstractC0571c.f1417k.compareTo(bigIntegerM1252B0) > 0 || AbstractC0571c.f1418l.compareTo(bigIntegerM1252B0) < 0) {
                        m1289s0();
                        throw null;
                    }
                    this.f1396K = bigIntegerM1252B0.longValue();
                } else if ((i4 & 8) != 0) {
                    double dM1254D0 = m1254D0();
                    if (dM1254D0 < -9.223372036854776E18d || dM1254D0 > 9.223372036854776E18d) {
                        m1289s0();
                        throw null;
                    }
                    this.f1396K = (long) dM1254D0;
                } else {
                    if ((i4 & 16) == 0) {
                        AbstractC0692s.m1666a();
                        throw null;
                    }
                    BigDecimal bigDecimalM1251A0 = m1251A0();
                    if (AbstractC0571c.f1419m.compareTo(bigDecimalM1251A0) > 0 || AbstractC0571c.f1420n.compareTo(bigDecimalM1251A0) < 0) {
                        m1289s0();
                        throw null;
                    }
                    this.f1396K = bigDecimalM1251A0.longValue();
                }
                this.f1394I |= 2;
            }
        }
        return this.f1396K;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: u */
    public final EnumC0544l mo1206u() throws C1130a, C0542j {
        if (this.f1394I == 0) {
            m1258H0(0);
        }
        if (this.f1423g == EnumC0548p.VALUE_NUMBER_INT) {
            int i3 = this.f1394I;
            return (i3 & 1) != 0 ? EnumC0544l.f1298e : (i3 & 2) != 0 ? EnumC0544l.f1299f : EnumC0544l.f1300g;
        }
        int i4 = this.f1394I;
        return (i4 & 16) != 0 ? EnumC0544l.f1303j : (i4 & 32) != 0 ? EnumC0544l.f1301h : EnumC0544l.f1302i;
    }

    /* JADX INFO: renamed from: u0 */
    public final void m1270u0(int i3, int i4) {
        int i5 = EnumC0543k.STRICT_DUPLICATE_DETECTION.f1297f;
        if ((i4 & i5) == 0 || (i3 & i5) == 0) {
            return;
        }
        C0638c c0638c = this.f1387B;
        if (c0638c.f1646e == null) {
            c0638c.f1646e = new C1803m(this);
            this.f1387B = c0638c;
        } else {
            c0638c.f1646e = null;
            this.f1387B = c0638c;
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: v */
    public final Number mo1207v() throws C1130a, C0542j {
        if (this.f1394I == 0) {
            m1258H0(0);
        }
        if (this.f1423g == EnumC0548p.VALUE_NUMBER_INT) {
            int i3 = this.f1394I;
            if ((i3 & 1) != 0) {
                return Integer.valueOf(this.f1395J);
            }
            if ((i3 & 2) != 0) {
                return Long.valueOf(this.f1396K);
            }
            if ((i3 & 4) != 0) {
                return m1252B0();
            }
            AbstractC0692s.m1666a();
            throw null;
        }
        int i4 = this.f1394I;
        if ((i4 & 16) != 0) {
            return m1251A0();
        }
        if ((i4 & 32) != 0) {
            return Float.valueOf(m1255E0());
        }
        if ((i4 & 8) != 0) {
            return Double.valueOf(m1254D0());
        }
        AbstractC0692s.m1666a();
        throw null;
    }

    /* JADX INFO: renamed from: v0 */
    public abstract void mo1271v0();

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: w */
    public final Object mo1208w() throws C1130a, C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p != EnumC0548p.VALUE_NUMBER_INT) {
            if (enumC0548p != EnumC0548p.VALUE_NUMBER_FLOAT) {
                return mo1207v();
            }
            int i3 = this.f1394I;
            return (i3 & 16) != 0 ? m1251A0() : (i3 & 8) != 0 ? Double.valueOf(m1254D0()) : (i3 & 32) != 0 ? Float.valueOf(m1255E0()) : this.f1389D.m1655h();
        }
        if (this.f1394I == 0) {
            m1258H0(0);
        }
        int i4 = this.f1394I;
        if ((i4 & 1) != 0) {
            return Integer.valueOf(this.f1395J);
        }
        if ((i4 & 2) != 0) {
            return Long.valueOf(this.f1396K);
        }
        if ((i4 & 4) == 0) {
            AbstractC0692s.m1666a();
            throw null;
        }
        BigInteger bigInteger = this.f1399N;
        if (bigInteger != null) {
            return bigInteger;
        }
        String str = this.f1401P;
        return str != null ? str : m1252B0();
    }

    /* JADX INFO: renamed from: w0 */
    public final C0590c m1272w0() {
        return EnumC0543k.INCLUDE_SOURCE_IN_LOCATION.m1155a(this.f1306e) ? (C0590c) this.f1404q.f756b : C0590c.f1511g;
    }

    /* JADX INFO: renamed from: x0 */
    public final int m1273x0(C0533a c0533a, char c3, int i3) {
        if (c3 != '\\') {
            throw m1250Q0(c0533a, c3, i3, null);
        }
        char cMo1275z0 = mo1275z0();
        if (cMo1275z0 <= ' ' && i3 == 0) {
            return -1;
        }
        int iM1073c = c0533a.m1073c(cMo1275z0);
        if (iM1073c >= 0 || (iM1073c == -2 && i3 >= 2)) {
            return iM1073c;
        }
        throw m1250Q0(c0533a, cMo1275z0, i3, null);
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: y */
    public final AbstractC0547o mo1210y() {
        return this.f1387B;
    }

    /* JADX INFO: renamed from: y0 */
    public final int m1274y0(C0533a c0533a, int i3, int i4) {
        if (i3 != 92) {
            throw m1250Q0(c0533a, i3, i4, null);
        }
        char cMo1275z0 = mo1275z0();
        if (cMo1275z0 <= ' ' && i4 == 0) {
            return -1;
        }
        int iM1074d = c0533a.m1074d(cMo1275z0);
        if (iM1074d >= 0 || iM1074d == -2) {
            return iM1074d;
        }
        throw m1250Q0(c0533a, cMo1275z0, i4, null);
    }

    /* JADX INFO: renamed from: z0 */
    public abstract char mo1275z0();
}
