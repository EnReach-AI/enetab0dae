package p118m1;

import com.fasterxml.jackson.core.exc.C1130a;
import com.fasterxml.jackson.core.exc.C1131b;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;
import p005B.AbstractC0032g;
import p042N0.AbstractC0545m;
import p042N0.AbstractC0547o;
import p042N0.AbstractC0549q;
import p042N0.C0533a;
import p042N0.C0541i;
import p042N0.C0542j;
import p042N0.C0553u;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p042N0.EnumC0554v;
import p045O0.AbstractC0571c;
import p050Q0.AbstractC0594g;
import p066W0.AbstractC0692s;
import p066W0.C0674a;
import p066W0.C0676c;
import p066W0.C0684k;

/* JADX INFO: renamed from: m1.C */
/* JADX INFO: loaded from: classes.dex */
public final class C1728C extends AbstractC0571c {

    /* JADX INFO: renamed from: q */
    public final AbstractC0549q f6040q;

    /* JADX INFO: renamed from: r */
    public final C0553u f6041r;

    /* JADX INFO: renamed from: s */
    public final boolean f6042s;

    /* JADX INFO: renamed from: t */
    public final boolean f6043t;

    /* JADX INFO: renamed from: u */
    public C1729D f6044u;

    /* JADX INFO: renamed from: w */
    public C1731F f6046w;

    /* JADX INFO: renamed from: x */
    public boolean f6047x;

    /* JADX INFO: renamed from: y */
    public transient C0676c f6048y;

    /* JADX INFO: renamed from: z */
    public C0541i f6049z = null;

    /* JADX INFO: renamed from: v */
    public int f6045v = -1;

    public C1728C(C1729D c1729d, AbstractC0549q abstractC0549q, boolean z3, boolean z4, AbstractC0547o abstractC0547o, C0553u c0553u) {
        this.f6044u = c1729d;
        this.f6040q = abstractC0549q;
        this.f6041r = c0553u;
        this.f6046w = abstractC0547o == null ? new C1731F() : new C1731F(abstractC0547o);
        this.f6042s = z3;
        this.f6043t = z4;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: B */
    public final String mo1157B() {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == EnumC0548p.VALUE_STRING || enumC0548p == EnumC0548p.FIELD_NAME) {
            Object objM3845v0 = m3845v0();
            if (objM3845v0 instanceof String) {
                return (String) objM3845v0;
            }
            Annotation[] annotationArr = AbstractC1745j.f6110a;
            if (objM3845v0 == null) {
                return null;
            }
            return objM3845v0.toString();
        }
        if (enumC0548p == null) {
            return null;
        }
        int iOrdinal = enumC0548p.ordinal();
        if (iOrdinal != 8 && iOrdinal != 9) {
            return this.f1423g.f1325e;
        }
        Object objM3845v02 = m3845v0();
        Annotation[] annotationArr2 = AbstractC1745j.f6110a;
        if (objM3845v02 == null) {
            return null;
        }
        return objM3845v02.toString();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: C */
    public final char[] mo1158C() {
        String strMo1157B = mo1157B();
        if (strMo1157B == null) {
            return null;
        }
        return strMo1157B.toCharArray();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: D */
    public final int mo1159D() {
        String strMo1157B = mo1157B();
        if (strMo1157B == null) {
            return 0;
        }
        return strMo1157B.length();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: E */
    public final int mo1160E() {
        return 0;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: G */
    public final Object mo1162G() {
        C1729D c1729d = this.f6044u;
        int i3 = this.f6045v;
        TreeMap treeMap = c1729d.f6054d;
        if (treeMap == null) {
            return null;
        }
        return treeMap.get(Integer.valueOf(i3 + i3));
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: L */
    public final boolean mo1167L() {
        return false;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: S */
    public final boolean mo1174S() {
        if (this.f1423g != EnumC0548p.VALUE_NUMBER_FLOAT) {
            return false;
        }
        Object objM3845v0 = m3845v0();
        if (objM3845v0 instanceof Double) {
            Double d = (Double) objM3845v0;
            return d.isNaN() || d.isInfinite();
        }
        if (!(objM3845v0 instanceof Float)) {
            return false;
        }
        Float f3 = (Float) objM3845v0;
        return f3.isNaN() || f3.isInfinite();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: T */
    public final String mo1175T() {
        C1729D c1729d;
        if (this.f6047x || (c1729d = this.f6044u) == null) {
            return null;
        }
        int i3 = this.f6045v + 1;
        if (i3 < 16) {
            EnumC0548p enumC0548pM3850d = c1729d.m3850d(i3);
            EnumC0548p enumC0548p = EnumC0548p.FIELD_NAME;
            if (enumC0548pM3850d == enumC0548p) {
                this.f6045v = i3;
                this.f1423g = enumC0548p;
                String str = this.f6044u.f6053c[i3];
                String string = str instanceof String ? str : str.toString();
                this.f6046w.f6072f = string;
                return string;
            }
        }
        if (mo1177V() == EnumC0548p.FIELD_NAME) {
            return mo1188d();
        }
        return null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: V */
    public final EnumC0548p mo1177V() {
        C1729D c1729d;
        if (this.f6047x || (c1729d = this.f6044u) == null) {
            return null;
        }
        int i3 = this.f6045v + 1;
        this.f6045v = i3;
        if (i3 >= 16) {
            this.f6045v = 0;
            C1729D c1729d2 = c1729d.f6051a;
            this.f6044u = c1729d2;
            if (c1729d2 == null) {
                return null;
            }
        }
        EnumC0548p enumC0548pM3850d = this.f6044u.m3850d(this.f6045v);
        this.f1423g = enumC0548pM3850d;
        if (enumC0548pM3850d == EnumC0548p.FIELD_NAME) {
            Object objM3845v0 = m3845v0();
            this.f6046w.f6072f = objM3845v0 instanceof String ? (String) objM3845v0 : objM3845v0.toString();
        } else if (enumC0548pM3850d == EnumC0548p.START_OBJECT) {
            C1731F c1731f = this.f6046w;
            c1731f.f1309b++;
            this.f6046w = new C1731F(c1731f, 2);
        } else if (enumC0548pM3850d == EnumC0548p.START_ARRAY) {
            C1731F c1731f2 = this.f6046w;
            c1731f2.f1309b++;
            this.f6046w = new C1731F(c1731f2, 1);
        } else if (enumC0548pM3850d == EnumC0548p.END_OBJECT || enumC0548pM3850d == EnumC0548p.END_ARRAY) {
            C1731F c1731f3 = this.f6046w;
            AbstractC0547o abstractC0547o = c1731f3.f6070d;
            this.f6046w = abstractC0547o instanceof C1731F ? (C1731F) abstractC0547o : abstractC0547o == null ? new C1731F() : new C1731F(abstractC0547o, c1731f3.f6071e);
        } else {
            this.f6046w.f1309b++;
        }
        return this.f1423g;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: Y */
    public final int mo1180Y(C0533a c0533a, C1742g c1742g) throws C0542j {
        byte[] bArrMo1193h = mo1193h(c0533a);
        if (bArrMo1193h == null) {
            return 0;
        }
        c1742g.write(bArrMo1193h, 0, bArrMo1193h.length);
        return bArrMo1193h.length;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: a */
    public final boolean mo1182a() {
        return this.f6043t;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: b */
    public final boolean mo1184b() {
        return this.f6042s;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6047x) {
            return;
        }
        this.f6047x = true;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: d */
    public final String mo1188d() {
        EnumC0548p enumC0548p = this.f1423g;
        return (enumC0548p == EnumC0548p.START_OBJECT || enumC0548p == EnumC0548p.START_ARRAY) ? this.f6046w.f6070d.mo1213a() : this.f6046w.f6072f;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: d0 */
    public final C0553u mo1189d0() {
        return this.f6041r;
    }

    @Override // p045O0.AbstractC0571c
    /* JADX INFO: renamed from: f0 */
    public final void mo1269f0() {
        AbstractC0692s.m1666a();
        throw null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: g */
    public final BigInteger mo1192g() throws C1131b, C0542j {
        Number numberM3846w0 = m3846w0(true);
        if (numberM3846w0 instanceof BigInteger) {
            return (BigInteger) numberM3846w0;
        }
        if (!(numberM3846w0 instanceof BigDecimal)) {
            return BigInteger.valueOf(numberM3846w0.longValue());
        }
        BigDecimal bigDecimal = (BigDecimal) numberM3846w0;
        int iScale = bigDecimal.scale();
        this.f6041r.getClass();
        C0553u.m1236a(iScale);
        return bigDecimal.toBigInteger();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: h */
    public final byte[] mo1193h(C0533a c0533a) throws C0542j {
        if (this.f1423g == EnumC0548p.VALUE_EMBEDDED_OBJECT) {
            Object objM3845v0 = m3845v0();
            if (objM3845v0 instanceof byte[]) {
                return (byte[]) objM3845v0;
            }
        }
        if (this.f1423g != EnumC0548p.VALUE_STRING) {
            throw new C0542j(this, "Current token (" + this.f1423g + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), cannot access as binary");
        }
        String strMo1157B = mo1157B();
        if (strMo1157B == null) {
            return null;
        }
        C0676c c0676c = this.f6048y;
        if (c0676c == null) {
            c0676c = new C0676c((C0674a) null, 100);
            this.f6048y = c0676c;
        } else {
            c0676c.m1638e();
        }
        try {
            c0533a.m1072b(strMo1157B, c0676c);
            return c0676c.m1639f();
        } catch (IllegalArgumentException e3) {
            m1279i0(e3.getMessage());
            throw null;
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: k */
    public final AbstractC0549q mo1196k() {
        return this.f6040q;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: l */
    public final C0541i mo1197l() {
        C0541i c0541i = this.f6049z;
        return c0541i == null ? C0541i.f1269k : c0541i;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: o */
    public final BigDecimal mo1200o() throws C0542j {
        Number numberM3846w0 = m3846w0(true);
        return numberM3846w0 instanceof BigDecimal ? (BigDecimal) numberM3846w0 : numberM3846w0 instanceof Integer ? BigDecimal.valueOf(numberM3846w0.intValue()) : numberM3846w0 instanceof Long ? BigDecimal.valueOf(numberM3846w0.longValue()) : numberM3846w0 instanceof BigInteger ? new BigDecimal((BigInteger) numberM3846w0) : BigDecimal.valueOf(numberM3846w0.doubleValue());
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: p */
    public final double mo1201p() {
        return m3846w0(false).doubleValue();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: q */
    public final Object mo1202q() {
        if (this.f1423g == EnumC0548p.VALUE_EMBEDDED_OBJECT) {
            return m3845v0();
        }
        return null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: r */
    public final float mo1203r() {
        return m3846w0(false).floatValue();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: s */
    public final int mo1204s() throws C1130a {
        Number numberM3846w0 = this.f1423g == EnumC0548p.VALUE_NUMBER_INT ? (Number) m3845v0() : m3846w0(false);
        if ((numberM3846w0 instanceof Integer) || (numberM3846w0 instanceof Short) || (numberM3846w0 instanceof Byte)) {
            return numberM3846w0.intValue();
        }
        if (numberM3846w0 instanceof Long) {
            long jLongValue = numberM3846w0.longValue();
            int i3 = (int) jLongValue;
            if (i3 == jLongValue) {
                return i3;
            }
            m1288r0();
            throw null;
        }
        if (numberM3846w0 instanceof BigInteger) {
            BigInteger bigInteger = (BigInteger) numberM3846w0;
            if (AbstractC0571c.f1415i.compareTo(bigInteger) > 0 || AbstractC0571c.f1416j.compareTo(bigInteger) < 0) {
                m1288r0();
                throw null;
            }
        } else {
            if ((numberM3846w0 instanceof Double) || (numberM3846w0 instanceof Float)) {
                double dDoubleValue = numberM3846w0.doubleValue();
                if (dDoubleValue >= -2.147483648E9d && dDoubleValue <= 2.147483647E9d) {
                    return (int) dDoubleValue;
                }
                m1288r0();
                throw null;
            }
            if (!(numberM3846w0 instanceof BigDecimal)) {
                AbstractC0692s.m1666a();
                throw null;
            }
            BigDecimal bigDecimal = (BigDecimal) numberM3846w0;
            if (AbstractC0571c.f1421o.compareTo(bigDecimal) > 0 || AbstractC0571c.f1422p.compareTo(bigDecimal) < 0) {
                m1288r0();
                throw null;
            }
        }
        return numberM3846w0.intValue();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: t */
    public final long mo1205t() throws C1130a {
        Number numberM3846w0 = this.f1423g == EnumC0548p.VALUE_NUMBER_INT ? (Number) m3845v0() : m3846w0(false);
        if ((numberM3846w0 instanceof Long) || (numberM3846w0 instanceof Integer) || (numberM3846w0 instanceof Short) || (numberM3846w0 instanceof Byte)) {
            return numberM3846w0.longValue();
        }
        if (numberM3846w0 instanceof BigInteger) {
            BigInteger bigInteger = (BigInteger) numberM3846w0;
            if (AbstractC0571c.f1417k.compareTo(bigInteger) > 0 || AbstractC0571c.f1418l.compareTo(bigInteger) < 0) {
                m1289s0();
                throw null;
            }
        } else {
            if ((numberM3846w0 instanceof Double) || (numberM3846w0 instanceof Float)) {
                double dDoubleValue = numberM3846w0.doubleValue();
                if (dDoubleValue >= -9.223372036854776E18d && dDoubleValue <= 9.223372036854776E18d) {
                    return (long) dDoubleValue;
                }
                m1289s0();
                throw null;
            }
            if (!(numberM3846w0 instanceof BigDecimal)) {
                AbstractC0692s.m1666a();
                throw null;
            }
            BigDecimal bigDecimal = (BigDecimal) numberM3846w0;
            if (AbstractC0571c.f1419m.compareTo(bigDecimal) > 0 || AbstractC0571c.f1420n.compareTo(bigDecimal) < 0) {
                m1289s0();
                throw null;
            }
        }
        return numberM3846w0.longValue();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: u */
    public final EnumC0544l mo1206u() throws C0542j {
        Object objMo1208w = mo1208w();
        boolean z3 = objMo1208w instanceof Integer;
        EnumC0544l enumC0544l = EnumC0544l.f1298e;
        if (z3) {
            return enumC0544l;
        }
        if (objMo1208w instanceof Long) {
            return EnumC0544l.f1299f;
        }
        if (objMo1208w instanceof Double) {
            return EnumC0544l.f1302i;
        }
        boolean z4 = objMo1208w instanceof BigDecimal;
        EnumC0544l enumC0544l2 = EnumC0544l.f1303j;
        if (z4) {
            return enumC0544l2;
        }
        boolean z5 = objMo1208w instanceof BigInteger;
        EnumC0544l enumC0544l3 = EnumC0544l.f1300g;
        if (z5) {
            return enumC0544l3;
        }
        if (objMo1208w instanceof Float) {
            return EnumC0544l.f1301h;
        }
        if (objMo1208w instanceof Short) {
            return enumC0544l;
        }
        if (objMo1208w instanceof String) {
            return this.f1423g == EnumC0548p.VALUE_NUMBER_FLOAT ? enumC0544l2 : enumC0544l3;
        }
        return null;
    }

    /* JADX INFO: renamed from: u0 */
    public final void m3844u0() throws C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == null || !enumC0548p.f1331k) {
            throw new C0542j(this, "Current token (" + this.f1423g + ") not numeric, cannot use numeric value accessors");
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: v */
    public final Number mo1207v() {
        return m3846w0(false);
    }

    /* JADX INFO: renamed from: v0 */
    public final Object m3845v0() {
        C1729D c1729d = this.f6044u;
        return c1729d.f6053c[this.f6045v];
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: w */
    public final Object mo1208w() throws C0542j {
        m3844u0();
        return m3845v0();
    }

    /* JADX INFO: renamed from: w0 */
    public final Number m3846w0(boolean z3) throws C0542j {
        m3844u0();
        Object objM3845v0 = m3845v0();
        if (objM3845v0 instanceof Number) {
            return (Number) objM3845v0;
        }
        if (!(objM3845v0 instanceof String)) {
            throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + AbstractC1745j.m3883f(objM3845v0));
        }
        String str = (String) objM3845v0;
        int length = str.length();
        if (this.f1423g == EnumC0548p.VALUE_NUMBER_INT) {
            return (z3 || length >= 19) ? AbstractC0594g.m1345b(str, m1170O(EnumC0554v.USE_FAST_BIG_NUMBER_PARSER)) : length >= 10 ? Long.valueOf(AbstractC0594g.m1351h(str)) : Integer.valueOf(AbstractC0594g.m1349f(str));
        }
        if (!z3) {
            return Double.valueOf(AbstractC0594g.m1346c(str, m1170O(EnumC0554v.USE_FAST_DOUBLE_PARSER)));
        }
        BigDecimal bigDecimalM1344a = AbstractC0594g.m1344a(str, m1170O(EnumC0554v.USE_FAST_BIG_NUMBER_PARSER));
        if (bigDecimalM1344a != null) {
            return bigDecimalM1344a;
        }
        throw new IllegalStateException(AbstractC0032g.m154l("Internal error: failed to parse number '", str, "'"));
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: x */
    public final Object mo1209x() {
        return this.f6044u.m3849c(this.f6045v);
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: y */
    public final AbstractC0547o mo1210y() {
        return this.f6046w;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: z */
    public final C0684k mo1211z() {
        return AbstractC0545m.f1305f;
    }
}
