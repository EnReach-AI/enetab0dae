package p058T0;

import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicReference;
import p025H1.C0283l;
import p042N0.AbstractC0549q;
import p042N0.C0533a;
import p042N0.C0541i;
import p042N0.C0542j;
import p042N0.EnumC0543k;
import p042N0.EnumC0548p;
import p045O0.AbstractC0570b;
import p050Q0.AbstractC0589b;
import p050Q0.C0591d;
import p061U0.C0656c;
import p061U0.C0657d;
import p061U0.C0658e;
import p066W0.C0674a;
import p066W0.C0676c;
import p066W0.C0684k;
import p066W0.C0688o;
import p118m1.C1742g;

/* JADX INFO: renamed from: T0.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0641f extends AbstractC0570b {

    /* JADX INFO: renamed from: d0 */
    public static final int f1664d0 = EnumC0543k.ALLOW_TRAILING_COMMA.f1297f;

    /* JADX INFO: renamed from: e0 */
    public static final int f1665e0 = EnumC0543k.ALLOW_NUMERIC_LEADING_ZEROS.f1297f;

    /* JADX INFO: renamed from: f0 */
    public static final int f1666f0 = EnumC0543k.ALLOW_NON_NUMERIC_NUMBERS.f1297f;

    /* JADX INFO: renamed from: g0 */
    public static final int f1667g0 = EnumC0543k.ALLOW_MISSING_VALUES.f1297f;

    /* JADX INFO: renamed from: h0 */
    public static final int f1668h0 = EnumC0543k.ALLOW_SINGLE_QUOTES.f1297f;

    /* JADX INFO: renamed from: i0 */
    public static final int f1669i0 = EnumC0543k.ALLOW_UNQUOTED_FIELD_NAMES.f1297f;

    /* JADX INFO: renamed from: j0 */
    public static final int f1670j0 = EnumC0543k.ALLOW_COMMENTS.f1297f;

    /* JADX INFO: renamed from: k0 */
    public static final int f1671k0 = EnumC0543k.ALLOW_YAML_COMMENTS.f1297f;

    /* JADX INFO: renamed from: l0 */
    public static final int[] f1672l0 = AbstractC0589b.f1504e;

    /* JADX INFO: renamed from: T */
    public Reader f1673T;

    /* JADX INFO: renamed from: U */
    public char[] f1674U;

    /* JADX INFO: renamed from: V */
    public final boolean f1675V;

    /* JADX INFO: renamed from: W */
    public final AbstractC0549q f1676W;

    /* JADX INFO: renamed from: X */
    public final C0658e f1677X;

    /* JADX INFO: renamed from: Y */
    public final int f1678Y;

    /* JADX INFO: renamed from: Z */
    public boolean f1679Z;

    /* JADX INFO: renamed from: a0 */
    public long f1680a0;

    /* JADX INFO: renamed from: b0 */
    public int f1681b0;

    /* JADX INFO: renamed from: c0 */
    public int f1682c0;

    public C0641f(C0283l c0283l, int i3, AbstractC0549q abstractC0549q, C0658e c0658e, char[] cArr, int i4, int i5, boolean z3) {
        super(c0283l, i3);
        this.f1673T = null;
        this.f1676W = abstractC0549q;
        this.f1674U = cArr;
        this.f1407t = i4;
        this.f1408u = i5;
        this.f1411x = i4;
        this.f1409v = -i4;
        this.f1677X = c0658e;
        this.f1678Y = c0658e.f1787c;
        this.f1675V = z3;
    }

    /* JADX INFO: renamed from: A1 */
    public final void m1473A1() {
        int i3 = this.f1407t;
        this.f1412y = this.f1409v + ((long) i3);
        this.f1413z = this.f1410w;
        this.f1386A = i3 - this.f1411x;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: B */
    public final String mo1157B() throws C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        EnumC0548p enumC0548p2 = EnumC0548p.VALUE_STRING;
        C0688o c0688o = this.f1389D;
        if (enumC0548p == enumC0548p2) {
            if (this.f1679Z) {
                this.f1679Z = false;
                m1478W0();
            }
            return c0688o.m1655h();
        }
        if (enumC0548p == null) {
            return null;
        }
        int i3 = enumC0548p.f1328h;
        return i3 != 5 ? (i3 == 6 || i3 == 7 || i3 == 8) ? c0688o.m1655h() : enumC0548p.f1325e : this.f1387B.f1648g;
    }

    /* JADX INFO: renamed from: B1 */
    public final void m1474B1(int i3) throws C0542j {
        int i4 = this.f1407t;
        int i5 = i4 + 1;
        this.f1407t = i5;
        if (i3 != 9) {
            if (i3 == 10) {
                this.f1410w++;
                this.f1411x = i5;
            } else if (i3 == 13) {
                this.f1407t = i4;
            } else {
                if (i3 == 32) {
                    return;
                }
                m1283m0(i3, "Expected space separating root-level values");
                throw null;
            }
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: C */
    public final char[] mo1158C() throws C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == null) {
            return null;
        }
        int i3 = enumC0548p.f1328h;
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7 && i3 != 8) {
                    return enumC0548p.f1326f;
                }
            } else if (this.f1679Z) {
                this.f1679Z = false;
                m1478W0();
            }
            return this.f1389D.m1660m();
        }
        if (!this.f1391F) {
            String str = this.f1387B.f1648g;
            int length = str.length();
            char[] cArr = this.f1390E;
            if (cArr == null) {
                C0283l c0283l = this.f1404q;
                C0283l.m556a((char[]) c0283l.f766l);
                char[] cArrM1633b = ((C0674a) c0283l.f759e).m1633b(3, length);
                c0283l.f766l = cArrM1633b;
                this.f1390E = cArrM1633b;
            } else if (cArr.length < length) {
                this.f1390E = new char[length];
            }
            str.getChars(0, length, this.f1390E, 0);
            this.f1391F = true;
        }
        return this.f1390E;
    }

    /* JADX INFO: renamed from: C1 */
    public final char m1475C1(String str) throws C0591d {
        if (this.f1407t >= this.f1408u && !m1482a1()) {
            m1281k0(str);
            throw null;
        }
        char[] cArr = this.f1674U;
        int i3 = this.f1407t;
        this.f1407t = i3 + 1;
        return cArr[i3];
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: D */
    public final int mo1159D() throws C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == null) {
            return 0;
        }
        int i3 = enumC0548p.f1328h;
        if (i3 == 5) {
            return this.f1387B.f1648g.length();
        }
        if (i3 != 6) {
            if (i3 != 7 && i3 != 8) {
                return enumC0548p.f1326f.length;
            }
        } else if (this.f1679Z) {
            this.f1679Z = false;
            m1478W0();
        }
        return this.f1389D.m1663p();
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: E */
    public final int mo1160E() throws C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == null) {
            return 0;
        }
        int i3 = enumC0548p.f1328h;
        if (i3 != 6) {
            if (i3 != 7 && i3 != 8) {
                return 0;
            }
        } else if (this.f1679Z) {
            this.f1679Z = false;
            m1478W0();
        }
        int i4 = this.f1389D.f1871c;
        if (i4 >= 0) {
            return i4;
        }
        return 0;
    }

    @Override // p045O0.AbstractC0571c, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: F */
    public final C0541i mo1161F() {
        if (this.f1423g != EnumC0548p.FIELD_NAME) {
            return new C0541i(m1272w0(), -1L, this.f1412y - 1, this.f1413z, this.f1386A);
        }
        return new C0541i(m1272w0(), -1L, (this.f1680a0 - 1) + this.f1409v, this.f1681b0, this.f1682c0);
    }

    @Override // p045O0.AbstractC0570b
    /* JADX INFO: renamed from: I0 */
    public final void mo1259I0() {
        char[] cArr;
        C0658e c0658e;
        this.f1389D.m1661n();
        char[] cArr2 = this.f1390E;
        C0283l c0283l = this.f1404q;
        if (cArr2 != null) {
            this.f1390E = null;
            char[] cArr3 = (char[]) c0283l.f766l;
            if (cArr2 != cArr3 && cArr2.length < cArr3.length) {
                throw new IllegalArgumentException("Trying to release buffer smaller than original");
            }
            c0283l.f766l = null;
            ((C0674a) c0283l.f759e).f1835b.set(3, cArr2);
        }
        C0658e c0658e2 = this.f1677X;
        if ((!c0658e2.f1796l) && (c0658e = c0658e2.f1785a) != null && c0658e2.f1789e) {
            C0657d c0657d = new C0657d(c0658e2);
            AtomicReference atomicReference = c0658e.f1786b;
            C0657d c0657d2 = (C0657d) atomicReference.get();
            int i3 = c0657d2.f1781a;
            int i4 = c0657d.f1781a;
            if (i4 != i3) {
                if (i4 > 12000) {
                    c0657d = new C0657d(new String[64], new C0656c[32]);
                }
                while (!atomicReference.compareAndSet(c0657d2, c0657d) && atomicReference.get() == c0657d2) {
                }
            }
            c0658e2.f1796l = true;
        }
        if (!this.f1675V || (cArr = this.f1674U) == null) {
            return;
        }
        this.f1674U = null;
        char[] cArr4 = (char[]) c0283l.f764j;
        if (cArr != cArr4 && cArr.length < cArr4.length) {
            throw new IllegalArgumentException("Trying to release buffer smaller than original");
        }
        c0283l.f764j = null;
        ((C0674a) c0283l.f759e).f1835b.set(0, cArr);
    }

    @Override // p045O0.AbstractC0571c, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: J */
    public final String mo1165J() throws C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p != EnumC0548p.VALUE_STRING) {
            return enumC0548p == EnumC0548p.FIELD_NAME ? mo1198m() : super.mo1287q0();
        }
        if (this.f1679Z) {
            this.f1679Z = false;
            m1478W0();
        }
        return this.f1389D.m1655h();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00a9  */
    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: T */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String mo1175T() throws p042N0.C0542j {
        /*
            Method dump skipped, instruction units count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0641f.mo1175T():java.lang.String");
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: U */
    public final String mo1176U() throws C0542j {
        if (this.f1423g != EnumC0548p.FIELD_NAME) {
            if (mo1177V() == EnumC0548p.VALUE_STRING) {
                return mo1157B();
            }
            return null;
        }
        this.f1391F = false;
        EnumC0548p enumC0548p = this.f1388C;
        this.f1388C = null;
        this.f1423g = enumC0548p;
        if (enumC0548p == EnumC0548p.VALUE_STRING) {
            if (this.f1679Z) {
                this.f1679Z = false;
                m1478W0();
            }
            return this.f1389D.m1655h();
        }
        if (enumC0548p == EnumC0548p.START_ARRAY) {
            m1264N0(this.f1413z, this.f1386A);
        } else if (enumC0548p == EnumC0548p.START_OBJECT) {
            m1265O0(this.f1413z, this.f1386A);
        }
        return null;
    }

    /* JADX INFO: renamed from: U0 */
    public final void m1476U0(int i3) throws C0542j {
        if (i3 == 93) {
            m1473A1();
            if (!this.f1387B.m1216d()) {
                m1260J0('}', i3);
                throw null;
            }
            C0638c c0638c = this.f1387B;
            c0638c.f1649h = null;
            this.f1387B = c0638c.f1645d;
            this.f1423g = EnumC0548p.END_ARRAY;
        }
        if (i3 == 125) {
            m1473A1();
            if (!this.f1387B.m1217e()) {
                m1260J0(']', i3);
                throw null;
            }
            C0638c c0638c2 = this.f1387B;
            c0638c2.f1649h = null;
            this.f1387B = c0638c2.f1645d;
            this.f1423g = EnumC0548p.END_OBJECT;
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: V */
    public final EnumC0548p mo1177V() throws C0542j {
        EnumC0548p enumC0548pM1494m1;
        EnumC0548p enumC0548p = this.f1423g;
        EnumC0548p enumC0548p2 = EnumC0548p.FIELD_NAME;
        if (enumC0548p == enumC0548p2) {
            return m1488g1();
        }
        this.f1394I = 0;
        if (this.f1679Z) {
            m1505x1();
        }
        int iM1506y1 = m1506y1();
        if (iM1506y1 < 0) {
            close();
            this.f1423g = null;
            return null;
        }
        this.f1393H = null;
        if (iM1506y1 == 93 || iM1506y1 == 125) {
            m1476U0(iM1506y1);
            return this.f1423g;
        }
        if (this.f1387B.m1465i()) {
            iM1506y1 = m1502u1(iM1506y1);
            if ((this.f1306e & f1664d0) != 0 && (iM1506y1 == 93 || iM1506y1 == 125)) {
                m1476U0(iM1506y1);
                return this.f1423g;
            }
        }
        boolean zM1217e = this.f1387B.m1217e();
        if (zM1217e) {
            int i3 = this.f1407t;
            this.f1680a0 = i3;
            this.f1681b0 = this.f1410w;
            this.f1682c0 = i3 - this.f1411x;
            this.f1387B.m1466j(iM1506y1 == 34 ? m1491j1() : m1480Y0(iM1506y1));
            this.f1423g = enumC0548p2;
            iM1506y1 = m1500s1();
        }
        m1473A1();
        if (iM1506y1 == 34) {
            this.f1679Z = true;
            enumC0548pM1494m1 = EnumC0548p.VALUE_STRING;
        } else if (iM1506y1 == 43) {
            enumC0548pM1494m1 = EnumC0639d.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.f1657f.m1155a(this.f1306e) ? m1494m1(false) : m1481Z0(iM1506y1);
        } else if (iM1506y1 == 91) {
            if (!zM1217e) {
                m1264N0(this.f1413z, this.f1386A);
            }
            enumC0548pM1494m1 = EnumC0548p.START_ARRAY;
        } else if (iM1506y1 == 102) {
            m1484c1();
            enumC0548pM1494m1 = EnumC0548p.VALUE_FALSE;
        } else if (iM1506y1 == 110) {
            m1485d1();
            enumC0548pM1494m1 = EnumC0548p.VALUE_NULL;
        } else if (iM1506y1 == 116) {
            m1487f1();
            enumC0548pM1494m1 = EnumC0548p.VALUE_TRUE;
        } else if (iM1506y1 == 123) {
            if (!zM1217e) {
                m1265O0(this.f1413z, this.f1386A);
            }
            enumC0548pM1494m1 = EnumC0548p.START_OBJECT;
        } else {
            if (iM1506y1 == 125) {
                m1283m0(iM1506y1, "expected a value");
                throw null;
            }
            if (iM1506y1 == 45) {
                enumC0548pM1494m1 = m1494m1(true);
            } else if (iM1506y1 != 46) {
                switch (iM1506y1) {
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        enumC0548pM1494m1 = m1495n1(iM1506y1);
                        break;
                    default:
                        enumC0548pM1494m1 = m1481Z0(iM1506y1);
                        break;
                }
            } else {
                enumC0548pM1494m1 = m1490i1(false);
            }
        }
        if (zM1217e) {
            this.f1388C = enumC0548pM1494m1;
            return this.f1423g;
        }
        this.f1423g = enumC0548pM1494m1;
        return enumC0548pM1494m1;
    }

    /* JADX INFO: renamed from: V0 */
    public final byte[] m1477V0(C0533a c0533a) throws C0542j {
        C0676c c0676cM1253C0 = m1253C0();
        while (true) {
            if (this.f1407t >= this.f1408u) {
                m1483b1();
            }
            char[] cArr = this.f1674U;
            int i3 = this.f1407t;
            this.f1407t = i3 + 1;
            char c3 = cArr[i3];
            if (c3 > ' ') {
                int iM1073c = c0533a.m1073c(c3);
                if (iM1073c < 0) {
                    if (c3 == '\"') {
                        return c0676cM1253C0.m1639f();
                    }
                    iM1073c = m1273x0(c0533a, c3, 0);
                    if (iM1073c < 0) {
                        continue;
                    }
                }
                if (this.f1407t >= this.f1408u) {
                    m1483b1();
                }
                char[] cArr2 = this.f1674U;
                int i4 = this.f1407t;
                this.f1407t = i4 + 1;
                char c4 = cArr2[i4];
                int iM1073c2 = c0533a.m1073c(c4);
                if (iM1073c2 < 0) {
                    iM1073c2 = m1273x0(c0533a, c4, 1);
                }
                int i5 = (iM1073c << 6) | iM1073c2;
                if (this.f1407t >= this.f1408u) {
                    m1483b1();
                }
                char[] cArr3 = this.f1674U;
                int i6 = this.f1407t;
                this.f1407t = i6 + 1;
                char c5 = cArr3[i6];
                int iM1073c3 = c0533a.m1073c(c5);
                if (iM1073c3 < 0) {
                    if (iM1073c3 != -2) {
                        if (c5 == '\"') {
                            c0676cM1253C0.m1635b(i5 >> 4);
                            if (!c0533a.m1081k()) {
                                return c0676cM1253C0.m1639f();
                            }
                            this.f1407t--;
                            m1279i0(c0533a.m1080j());
                            throw null;
                        }
                        iM1073c3 = m1273x0(c0533a, c5, 2);
                    }
                    if (iM1073c3 == -2) {
                        if (this.f1407t >= this.f1408u) {
                            m1483b1();
                        }
                        char[] cArr4 = this.f1674U;
                        int i7 = this.f1407t;
                        this.f1407t = i7 + 1;
                        char c6 = cArr4[i7];
                        char c7 = c0533a.f1223i;
                        if (c6 != c7 && m1273x0(c0533a, c6, 3) != -2) {
                            throw AbstractC0570b.m1250Q0(c0533a, c6, 3, "expected padding character '" + c7 + "'");
                        }
                        c0676cM1253C0.m1635b(i5 >> 4);
                    }
                }
                int i8 = (i5 << 6) | iM1073c3;
                if (this.f1407t >= this.f1408u) {
                    m1483b1();
                }
                char[] cArr5 = this.f1674U;
                int i9 = this.f1407t;
                this.f1407t = i9 + 1;
                char c8 = cArr5[i9];
                int iM1073c4 = c0533a.m1073c(c8);
                if (iM1073c4 < 0) {
                    if (iM1073c4 != -2) {
                        if (c8 == '\"') {
                            c0676cM1253C0.m1637d(i8 >> 2);
                            if (!c0533a.m1081k()) {
                                return c0676cM1253C0.m1639f();
                            }
                            this.f1407t--;
                            m1279i0(c0533a.m1080j());
                            throw null;
                        }
                        iM1073c4 = m1273x0(c0533a, c8, 3);
                    }
                    if (iM1073c4 == -2) {
                        c0676cM1253C0.m1637d(i8 >> 2);
                    }
                }
                c0676cM1253C0.m1636c((i8 << 6) | iM1073c4);
            }
        }
    }

    /* JADX INFO: renamed from: W0 */
    public final void m1478W0() throws C0542j {
        int i3 = this.f1407t;
        int i4 = this.f1408u;
        int[] iArr = f1672l0;
        C0688o c0688o = this.f1389D;
        if (i3 < i4) {
            int length = iArr.length;
            while (true) {
                char[] cArr = this.f1674U;
                char c3 = cArr[i3];
                if (c3 >= length || iArr[c3] == 0) {
                    i3++;
                    if (i3 >= i4) {
                        break;
                    }
                } else if (c3 == '\"') {
                    int i5 = this.f1407t;
                    c0688o.m1662o(i5, cArr, i3 - i5);
                    this.f1407t = i3 + 1;
                    return;
                }
            }
        }
        char[] cArr2 = this.f1674U;
        int i6 = this.f1407t;
        int i7 = i3 - i6;
        c0688o.f1870b = null;
        c0688o.f1871c = -1;
        c0688o.f1872d = 0;
        c0688o.f1878j = null;
        c0688o.f1879k = null;
        if (c0688o.f1874f) {
            c0688o.m1652e();
        } else if (c0688o.f1876h == null) {
            c0688o.f1876h = c0688o.m1651d(i7);
        }
        c0688o.f1875g = 0;
        c0688o.f1877i = 0;
        c0688o.m1649b(i6, cArr2, i7);
        this.f1407t = i3;
        char[] cArrM1659l = c0688o.m1659l();
        int i8 = c0688o.f1877i;
        int length2 = iArr.length;
        while (true) {
            if (this.f1407t >= this.f1408u && !m1482a1()) {
                EnumC0548p enumC0548p = EnumC0548p.NOT_AVAILABLE;
                m1281k0(": was expecting closing quote for a string value");
                throw null;
            }
            char[] cArr3 = this.f1674U;
            int i9 = this.f1407t;
            this.f1407t = i9 + 1;
            char cMo1275z0 = cArr3[i9];
            if (cMo1275z0 < length2 && iArr[cMo1275z0] != 0) {
                if (cMo1275z0 == '\"') {
                    c0688o.f1877i = i8;
                    return;
                } else if (cMo1275z0 == '\\') {
                    cMo1275z0 = mo1275z0();
                } else if (cMo1275z0 < ' ') {
                    m1261K0(cMo1275z0, "string value");
                }
            }
            if (i8 >= cArrM1659l.length) {
                cArrM1659l = c0688o.m1658k();
                i8 = 0;
            }
            cArrM1659l[i8] = cMo1275z0;
            i8++;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r11v0 ??, r11v1 ??, r11v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    /* JADX INFO: renamed from: X0 */
    public final p042N0.EnumC0548p m1479X0(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r11v0 ??, r11v1 ??, r11v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r11v0 ??
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

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: Y */
    public final int mo1180Y(C0533a c0533a, C1742g c1742g) throws IOException {
        if (!this.f1679Z || this.f1423g != EnumC0548p.VALUE_STRING) {
            byte[] bArrMo1193h = mo1193h(c0533a);
            c1742g.write(bArrMo1193h);
            return bArrMo1193h.length;
        }
        C0283l c0283l = this.f1404q;
        byte[] bArrM557b = c0283l.m557b();
        try {
            return m1496o1(c0533a, c1742g, bArrM557b);
        } finally {
            c0283l.m560e(bArrM557b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x00f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ec A[SYNTHETIC] */
    /* JADX INFO: renamed from: Y0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m1480Y0(int r11) throws p042N0.C0542j {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0641f.m1480Y0(int):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /* JADX INFO: renamed from: Z0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p042N0.EnumC0548p m1481Z0(int r10) throws p042N0.C0542j {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0641f.m1481Z0(int):N0.p");
    }

    /* JADX INFO: renamed from: a1 */
    public final boolean m1482a1() throws IOException {
        Reader reader = this.f1673T;
        if (reader != null) {
            char[] cArr = this.f1674U;
            int i3 = reader.read(cArr, 0, cArr.length);
            if (i3 > 0) {
                int i4 = this.f1408u;
                long j2 = i4;
                this.f1409v += j2;
                this.f1411x -= i4;
                this.f1680a0 -= j2;
                this.f1407t = 0;
                this.f1408u = i3;
                return true;
            }
            mo1271v0();
            if (i3 == 0) {
                throw new IOException("Reader returned 0 characters when trying to read " + this.f1408u);
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b1 */
    public final void m1483b1() throws C0591d {
        if (m1482a1()) {
            return;
        }
        m1280j0();
        throw null;
    }

    /* JADX INFO: renamed from: c1 */
    public final void m1484c1() throws C0542j {
        int i3;
        char c3;
        int i4 = this.f1407t;
        if (i4 + 4 < this.f1408u) {
            char[] cArr = this.f1674U;
            if (cArr[i4] == 'a' && cArr[i4 + 1] == 'l' && cArr[i4 + 2] == 's' && cArr[i4 + 3] == 'e' && ((c3 = cArr[(i3 = i4 + 4)]) < '0' || c3 == ']' || c3 == '}')) {
                this.f1407t = i3;
                return;
            }
        }
        m1486e1(1, "false");
    }

    /* JADX INFO: renamed from: d1 */
    public final void m1485d1() throws C0542j {
        int i3;
        char c3;
        int i4 = this.f1407t;
        if (i4 + 3 < this.f1408u) {
            char[] cArr = this.f1674U;
            if (cArr[i4] == 'u' && cArr[i4 + 1] == 'l' && cArr[i4 + 2] == 'l' && ((c3 = cArr[(i3 = i4 + 3)]) < '0' || c3 == ']' || c3 == '}')) {
                this.f1407t = i3;
                return;
            }
        }
        m1486e1(1, "null");
    }

    /* JADX INFO: renamed from: e1 */
    public final void m1486e1(int i3, String str) throws C0542j {
        int i4;
        char c3;
        int length = str.length();
        if (this.f1407t + length < this.f1408u) {
            while (this.f1674U[this.f1407t] == str.charAt(i3)) {
                int i5 = this.f1407t + 1;
                this.f1407t = i5;
                i3++;
                if (i3 >= length) {
                    char c4 = this.f1674U[i5];
                    if (c4 < '0' || c4 == ']' || c4 == '}' || !Character.isJavaIdentifierPart(c4)) {
                        return;
                    }
                    m1497p1(str.substring(0, i3), m1262L0());
                    throw null;
                }
            }
            m1497p1(str.substring(0, i3), m1262L0());
            throw null;
        }
        int length2 = str.length();
        do {
            if ((this.f1407t >= this.f1408u && !m1482a1()) || this.f1674U[this.f1407t] != str.charAt(i3)) {
                m1497p1(str.substring(0, i3), m1262L0());
                throw null;
            }
            i4 = this.f1407t + 1;
            this.f1407t = i4;
            i3++;
        } while (i3 < length2);
        if ((i4 < this.f1408u || m1482a1()) && (c3 = this.f1674U[this.f1407t]) >= '0' && c3 != ']' && c3 != '}' && Character.isJavaIdentifierPart(c3)) {
            m1497p1(str.substring(0, i3), m1262L0());
            throw null;
        }
    }

    /* JADX INFO: renamed from: f1 */
    public final void m1487f1() throws C0542j {
        int i3;
        char c3;
        int i4 = this.f1407t;
        if (i4 + 3 < this.f1408u) {
            char[] cArr = this.f1674U;
            if (cArr[i4] == 'r' && cArr[i4 + 1] == 'u' && cArr[i4 + 2] == 'e' && ((c3 = cArr[(i3 = i4 + 3)]) < '0' || c3 == ']' || c3 == '}')) {
                this.f1407t = i3;
                return;
            }
        }
        m1486e1(1, "true");
    }

    /* JADX INFO: renamed from: g1 */
    public final EnumC0548p m1488g1() {
        this.f1391F = false;
        EnumC0548p enumC0548p = this.f1388C;
        this.f1388C = null;
        if (enumC0548p == EnumC0548p.START_ARRAY) {
            m1264N0(this.f1413z, this.f1386A);
        } else if (enumC0548p == EnumC0548p.START_OBJECT) {
            m1265O0(this.f1413z, this.f1386A);
        }
        this.f1423g = enumC0548p;
        return enumC0548p;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: h */
    public final byte[] mo1193h(C0533a c0533a) throws C0542j {
        byte[] bArr;
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p == EnumC0548p.VALUE_EMBEDDED_OBJECT && (bArr = this.f1393H) != null) {
            return bArr;
        }
        if (enumC0548p != EnumC0548p.VALUE_STRING) {
            m1279i0("Current token (" + this.f1423g + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
            throw null;
        }
        if (this.f1679Z) {
            try {
                this.f1393H = m1477V0(c0533a);
                this.f1679Z = false;
            } catch (IllegalArgumentException e3) {
                throw new C0542j(this, "Failed to decode VALUE_STRING as base64 (" + c0533a + "): " + e3.getMessage());
            }
        } else if (this.f1393H == null) {
            C0676c c0676cM1253C0 = m1253C0();
            try {
                c0533a.m1072b(mo1157B(), c0676cM1253C0);
                this.f1393H = c0676cM1253C0.m1639f();
            } catch (IllegalArgumentException e4) {
                m1279i0(e4.getMessage());
                throw null;
            }
        }
        return this.f1393H;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r12v0 ??, r12v1 ??, r12v13 ??, r12v9 ??, r12v5 ??, r12v4 ??, r12v3 ??, r12v8 ??, r12v7 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    /* JADX INFO: renamed from: h1 */
    public final p042N0.EnumC0548p m1489h1(boolean r11, 
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r12v0 ??, r12v1 ??, r12v13 ??, r12v9 ??, r12v5 ??, r12v4 ??, r12v3 ??, r12v8 ??, r12v7 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r12v0 ??
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

    /* JADX INFO: renamed from: i1 */
    public final EnumC0548p m1490i1(boolean z3) {
        if (!EnumC0639d.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.f1657f.m1155a(this.f1306e)) {
            return m1481Z0(46);
        }
        int i3 = this.f1407t;
        int i4 = i3 - 1;
        if (z3) {
            i4 = i3 - 2;
        }
        return m1489h1(z3, 46, i4, i3, 0);
    }

    /* JADX INFO: renamed from: j1 */
    public final String m1491j1() {
        int i3 = this.f1407t;
        int i4 = this.f1678Y;
        while (true) {
            if (i3 >= this.f1408u) {
                break;
            }
            char[] cArr = this.f1674U;
            char c3 = cArr[i3];
            int[] iArr = f1672l0;
            if (c3 >= iArr.length || iArr[c3] == 0) {
                i4 = (i4 * 33) + c3;
                i3++;
            } else if (c3 == '\"') {
                int i5 = this.f1407t;
                this.f1407t = i3 + 1;
                return this.f1677X.m1618c(i5, i3 - i5, i4, cArr);
            }
        }
        int i6 = this.f1407t;
        this.f1407t = i3;
        return m1492k1(i6, i4, 34);
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: k */
    public final AbstractC0549q mo1196k() {
        return this.f1676W;
    }

    /* JADX INFO: renamed from: k1 */
    public final String m1492k1(int i3, int i4, int i5) throws C0542j {
        char[] cArr = this.f1674U;
        int i6 = this.f1407t - i3;
        C0688o c0688o = this.f1389D;
        c0688o.m1662o(i3, cArr, i6);
        char[] cArrM1659l = c0688o.m1659l();
        int i7 = c0688o.f1877i;
        while (true) {
            if (this.f1407t >= this.f1408u && !m1482a1()) {
                EnumC0548p enumC0548p = EnumC0548p.NOT_AVAILABLE;
                m1281k0(" in field name");
                throw null;
            }
            char[] cArr2 = this.f1674U;
            int i8 = this.f1407t;
            this.f1407t = i8 + 1;
            char cMo1275z0 = cArr2[i8];
            if (cMo1275z0 <= '\\') {
                if (cMo1275z0 == '\\') {
                    cMo1275z0 = mo1275z0();
                } else if (cMo1275z0 <= i5) {
                    if (cMo1275z0 == i5) {
                        c0688o.f1877i = i7;
                        char[] cArrM1660m = c0688o.m1660m();
                        int i9 = c0688o.f1871c;
                        return this.f1677X.m1618c(i9 >= 0 ? i9 : 0, c0688o.m1663p(), i4, cArrM1660m);
                    }
                    if (cMo1275z0 < ' ') {
                        m1261K0(cMo1275z0, "name");
                    }
                }
            }
            i4 = (i4 * 33) + cMo1275z0;
            int i10 = i7 + 1;
            cArrM1659l[i7] = cMo1275z0;
            if (i10 >= cArrM1659l.length) {
                cArrM1659l = c0688o.m1658k();
                i7 = 0;
            } else {
                i7 = i10;
            }
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: l */
    public final C0541i mo1197l() {
        int i3 = (this.f1407t - this.f1411x) + 1;
        return new C0541i(m1272w0(), -1L, ((long) this.f1407t) + this.f1409v, this.f1410w, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0053 A[EDGE_INSN: B:25:0x0053->B:47:0x008f BREAK  A[LOOP:0: B:34:0x006c->B:148:?]] */
    /* JADX INFO: renamed from: l1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p042N0.EnumC0548p m1493l1(int r17, boolean r18) throws p042N0.C0542j {
        /*
            Method dump skipped, instruction units count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0641f.m1493l1(int, boolean):N0.p");
    }

    /* JADX INFO: renamed from: m1 */
    public final EnumC0548p m1494m1(boolean z3) throws C0542j {
        int i3 = this.f1407t;
        int i4 = z3 ? i3 - 1 : i3;
        int i5 = this.f1408u;
        if (i3 >= i5) {
            return m1493l1(i4, z3);
        }
        int i6 = i3 + 1;
        char c3 = this.f1674U[i3];
        if (c3 > '9' || c3 < '0') {
            this.f1407t = i6;
            return c3 == '.' ? m1490i1(z3) : m1479X0(c3, z3, true);
        }
        if (c3 == '0') {
            return m1493l1(i4, z3);
        }
        int i7 = 1;
        while (i6 < i5) {
            int i8 = i6 + 1;
            char c4 = this.f1674U[i6];
            if (c4 < '0' || c4 > '9') {
                if (c4 == '.' || c4 == 'e' || c4 == 'E') {
                    this.f1407t = i8;
                    return m1489h1(z3, c4, i4, i8, i7);
                }
                this.f1407t = i6;
                if (this.f1387B.m1218f()) {
                    m1474B1(c4);
                }
                this.f1389D.m1662o(i4, this.f1674U, i6 - i4);
                return m1268T0(i7, z3);
            }
            i7++;
            i6 = i8;
        }
        return m1493l1(i4, z3);
    }

    /* JADX INFO: renamed from: n1 */
    public final EnumC0548p m1495n1(int i3) throws C0542j {
        int i4 = this.f1407t;
        int i5 = i4 - 1;
        int i6 = this.f1408u;
        if (i3 == 48) {
            return m1493l1(i5, false);
        }
        int i7 = 1;
        while (i4 < i6) {
            int i8 = i4 + 1;
            char c3 = this.f1674U[i4];
            if (c3 < '0' || c3 > '9') {
                if (c3 == '.' || c3 == 'e' || c3 == 'E') {
                    this.f1407t = i8;
                    return m1489h1(false, c3, i5, i8, i7);
                }
                this.f1407t = i4;
                if (this.f1387B.m1218f()) {
                    m1474B1(c3);
                }
                this.f1389D.m1662o(i5, this.f1674U, i4 - i5);
                return m1268T0(i7, false);
            }
            i7++;
            i4 = i8;
        }
        this.f1407t = i5;
        return m1493l1(i5, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX INFO: renamed from: o1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m1496o1(p042N0.C0533a r17, p118m1.C1742g r18, byte[] r19) throws p042N0.C0542j {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0641f.m1496o1(N0.a, m1.g, byte[]):int");
    }

    /* JADX INFO: renamed from: p1 */
    public final void m1497p1(String str, String str2) throws C0542j {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.f1407t >= this.f1408u && !m1482a1()) {
                break;
            }
            char c3 = this.f1674U[this.f1407t];
            if (!Character.isJavaIdentifierPart(c3)) {
                break;
            }
            this.f1407t++;
            sb.append(c3);
            if (sb.length() >= 256) {
                sb.append("...");
                break;
            }
        }
        throw new C0542j(this, "Unrecognized token '" + ((Object) sb) + "': was expecting " + str2);
    }

    @Override // p045O0.AbstractC0571c
    /* JADX INFO: renamed from: q0 */
    public final String mo1287q0() throws C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p != EnumC0548p.VALUE_STRING) {
            return enumC0548p == EnumC0548p.FIELD_NAME ? mo1198m() : super.mo1287q0();
        }
        if (this.f1679Z) {
            this.f1679Z = false;
            m1478W0();
        }
        return this.f1389D.m1655h();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        return r0;
     */
    /* JADX INFO: renamed from: q1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m1498q1() throws p042N0.C0542j {
        /*
            r3 = this;
        L0:
            int r0 = r3.f1407t
            int r1 = r3.f1408u
            if (r0 < r1) goto L2c
            boolean r0 = r3.m1482a1()
            if (r0 == 0) goto Ld
            goto L2c
        Ld:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unexpected end-of-input within/between "
            r0.<init>(r1)
            T0.c r1 = r3.f1387B
            java.lang.String r1 = r1.m1220h()
            r0.append(r1)
            java.lang.String r1 = " entries"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            N0.j r1 = new N0.j
            r1.<init>(r3, r0)
            throw r1
        L2c:
            char[] r0 = r3.f1674U
            int r1 = r3.f1407t
            int r2 = r1 + 1
            r3.f1407t = r2
            char r0 = r0[r1]
            r1 = 32
            if (r0 <= r1) goto L53
            r1 = 47
            if (r0 != r1) goto L42
            r3.m1503v1()
            goto L0
        L42:
            r1 = 35
            if (r0 != r1) goto L52
            int r1 = r3.f1306e
            int r2 = p058T0.C0641f.f1671k0
            r1 = r1 & r2
            if (r1 != 0) goto L4e
            goto L52
        L4e:
            r3.m1504w1()
            goto L0
        L52:
            return r0
        L53:
            if (r0 >= r1) goto L0
            r1 = 10
            if (r0 != r1) goto L62
            int r0 = r3.f1410w
            int r0 = r0 + 1
            r3.f1410w = r0
            r3.f1411x = r2
            goto L0
        L62:
            r1 = 13
            if (r0 != r1) goto L6a
            r3.m1499r1()
            goto L0
        L6a:
            r1 = 9
            if (r0 != r1) goto L6f
            goto L0
        L6f:
            r3.m1285o0(r0)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0641f.m1498q1():int");
    }

    /* JADX INFO: renamed from: r1 */
    public final void m1499r1() {
        if (this.f1407t < this.f1408u || m1482a1()) {
            char[] cArr = this.f1674U;
            int i3 = this.f1407t;
            if (cArr[i3] == '\n') {
                this.f1407t = i3 + 1;
            }
        }
        this.f1410w++;
        this.f1411x = this.f1407t;
    }

    /* JADX INFO: renamed from: s1 */
    public final int m1500s1() {
        int i3 = this.f1407t;
        if (i3 + 4 >= this.f1408u) {
            return m1501t1(false);
        }
        char[] cArr = this.f1674U;
        char c3 = cArr[i3];
        if (c3 == ':') {
            int i4 = i3 + 1;
            this.f1407t = i4;
            char c4 = cArr[i4];
            if (c4 > ' ') {
                if (c4 == '/' || c4 == '#') {
                    return m1501t1(true);
                }
                this.f1407t = i3 + 2;
                return c4;
            }
            if (c4 == ' ' || c4 == '\t') {
                int i5 = i3 + 2;
                this.f1407t = i5;
                char c5 = cArr[i5];
                if (c5 > ' ') {
                    if (c5 == '/' || c5 == '#') {
                        return m1501t1(true);
                    }
                    this.f1407t = i3 + 3;
                    return c5;
                }
            }
            return m1501t1(true);
        }
        if (c3 == ' ' || c3 == '\t') {
            int i6 = i3 + 1;
            this.f1407t = i6;
            c3 = cArr[i6];
        }
        if (c3 != ':') {
            return m1501t1(false);
        }
        int i7 = this.f1407t;
        int i8 = i7 + 1;
        this.f1407t = i8;
        char c6 = cArr[i8];
        if (c6 > ' ') {
            if (c6 == '/' || c6 == '#') {
                return m1501t1(true);
            }
            this.f1407t = i7 + 2;
            return c6;
        }
        if (c6 == ' ' || c6 == '\t') {
            int i9 = i7 + 2;
            this.f1407t = i9;
            char c7 = cArr[i9];
            if (c7 > ' ') {
                if (c7 == '/' || c7 == '#') {
                    return m1501t1(true);
                }
                this.f1407t = i7 + 3;
                return c7;
            }
        }
        return m1501t1(true);
    }

    /* JADX INFO: renamed from: t1 */
    public final int m1501t1(boolean z3) throws C0542j {
        while (true) {
            if (this.f1407t >= this.f1408u && !m1482a1()) {
                m1281k0(" within/between " + this.f1387B.m1220h() + " entries");
                throw null;
            }
            char[] cArr = this.f1674U;
            int i3 = this.f1407t;
            int i4 = i3 + 1;
            this.f1407t = i4;
            char c3 = cArr[i3];
            if (c3 > ' ') {
                if (c3 == '/') {
                    m1503v1();
                } else if (c3 == '#' && (this.f1306e & f1671k0) != 0) {
                    m1504w1();
                } else {
                    if (z3) {
                        return c3;
                    }
                    if (c3 != ':') {
                        m1283m0(c3, "was expecting a colon to separate field name and value");
                        throw null;
                    }
                    z3 = true;
                }
            } else if (c3 >= ' ') {
                continue;
            } else if (c3 == '\n') {
                this.f1410w++;
                this.f1411x = i4;
            } else if (c3 == '\r') {
                m1499r1();
            } else if (c3 != '\t') {
                m1285o0(c3);
                throw null;
            }
        }
    }

    /* JADX INFO: renamed from: u1 */
    public final int m1502u1(int i3) throws C0542j {
        if (i3 != 44) {
            m1283m0(i3, "was expecting comma to separate " + this.f1387B.m1220h() + " entries");
            throw null;
        }
        while (true) {
            int i4 = this.f1407t;
            if (i4 >= this.f1408u) {
                return m1498q1();
            }
            char[] cArr = this.f1674U;
            int i5 = i4 + 1;
            this.f1407t = i5;
            char c3 = cArr[i4];
            if (c3 > ' ') {
                if (c3 != '/' && c3 != '#') {
                    return c3;
                }
                this.f1407t = i4;
                return m1498q1();
            }
            if (c3 < ' ') {
                if (c3 == '\n') {
                    this.f1410w++;
                    this.f1411x = i5;
                } else if (c3 == '\r') {
                    m1499r1();
                } else if (c3 != '\t') {
                    m1285o0(c3);
                    throw null;
                }
            }
        }
    }

    @Override // p045O0.AbstractC0570b
    /* JADX INFO: renamed from: v0 */
    public final void mo1271v0() throws IOException {
        if (this.f1673T != null) {
            if (this.f1404q.f755a || EnumC0543k.AUTO_CLOSE_SOURCE.m1155a(this.f1306e)) {
                this.f1673T.close();
            }
            this.f1673T = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        m1281k0(" in a comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
    
        throw null;
     */
    /* JADX INFO: renamed from: v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1503v1() throws p042N0.C0542j {
        /*
            r7 = this;
            int r0 = r7.f1306e
            int r1 = p058T0.C0641f.f1670j0
            r0 = r0 & r1
            r1 = 0
            r2 = 47
            if (r0 == 0) goto L8f
            int r0 = r7.f1407t
            int r3 = r7.f1408u
            java.lang.String r4 = " in a comment"
            if (r0 < r3) goto L1d
            boolean r0 = r7.m1482a1()
            if (r0 == 0) goto L19
            goto L1d
        L19:
            r7.m1281k0(r4)
            throw r1
        L1d:
            char[] r0 = r7.f1674U
            int r3 = r7.f1407t
            int r5 = r3 + 1
            r7.f1407t = r5
            char r0 = r0[r3]
            if (r0 != r2) goto L2d
            r7.m1504w1()
            goto L66
        L2d:
            r3 = 42
            if (r0 != r3) goto L89
        L31:
            int r0 = r7.f1407t
            int r5 = r7.f1408u
            if (r0 < r5) goto L3d
            boolean r0 = r7.m1482a1()
            if (r0 == 0) goto L56
        L3d:
            char[] r0 = r7.f1674U
            int r5 = r7.f1407t
            int r6 = r5 + 1
            r7.f1407t = r6
            char r0 = r0[r5]
            if (r0 > r3) goto L31
            if (r0 != r3) goto L67
            int r0 = r7.f1408u
            if (r6 < r0) goto L5a
            boolean r0 = r7.m1482a1()
            if (r0 == 0) goto L56
            goto L5a
        L56:
            r7.m1281k0(r4)
            throw r1
        L5a:
            char[] r0 = r7.f1674U
            int r5 = r7.f1407t
            char r0 = r0[r5]
            if (r0 != r2) goto L31
            int r5 = r5 + 1
            r7.f1407t = r5
        L66:
            return
        L67:
            r5 = 32
            if (r0 >= r5) goto L31
            r5 = 10
            if (r0 != r5) goto L78
            int r0 = r7.f1410w
            int r0 = r0 + 1
            r7.f1410w = r0
            r7.f1411x = r6
            goto L31
        L78:
            r5 = 13
            if (r0 != r5) goto L80
            r7.m1499r1()
            goto L31
        L80:
            r5 = 9
            if (r0 != r5) goto L85
            goto L31
        L85:
            r7.m1285o0(r0)
            throw r1
        L89:
            java.lang.String r2 = "was expecting either '*' or '/' for a comment"
            r7.m1283m0(r0, r2)
            throw r1
        L8f:
            java.lang.String r0 = "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)"
            r7.m1283m0(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0641f.m1503v1():void");
    }

    /* JADX INFO: renamed from: w1 */
    public final void m1504w1() throws C0542j {
        while (true) {
            if (this.f1407t >= this.f1408u && !m1482a1()) {
                return;
            }
            char[] cArr = this.f1674U;
            int i3 = this.f1407t;
            int i4 = i3 + 1;
            this.f1407t = i4;
            char c3 = cArr[i3];
            if (c3 < ' ') {
                if (c3 == '\n') {
                    this.f1410w++;
                    this.f1411x = i4;
                    return;
                } else if (c3 == '\r') {
                    m1499r1();
                    return;
                } else if (c3 != '\t') {
                    m1285o0(c3);
                    throw null;
                }
            }
        }
    }

    /* JADX INFO: renamed from: x1 */
    public final void m1505x1() throws C0542j {
        this.f1679Z = false;
        int i3 = this.f1407t;
        int i4 = this.f1408u;
        char[] cArr = this.f1674U;
        while (true) {
            if (i3 >= i4) {
                this.f1407t = i3;
                if (!m1482a1()) {
                    EnumC0548p enumC0548p = EnumC0548p.NOT_AVAILABLE;
                    m1281k0(": was expecting closing quote for a string value");
                    throw null;
                }
                i3 = this.f1407t;
                i4 = this.f1408u;
            }
            int i5 = i3 + 1;
            char c3 = cArr[i3];
            if (c3 <= '\\') {
                if (c3 == '\\') {
                    this.f1407t = i5;
                    mo1275z0();
                    i3 = this.f1407t;
                    i4 = this.f1408u;
                } else if (c3 <= '\"') {
                    if (c3 == '\"') {
                        this.f1407t = i5;
                        return;
                    } else if (c3 < ' ') {
                        this.f1407t = i5;
                        m1261K0(c3, "string value");
                    }
                }
            }
            i3 = i5;
        }
    }

    /* JADX INFO: renamed from: y1 */
    public final int m1506y1() throws C0542j {
        if (this.f1407t >= this.f1408u && !m1482a1()) {
            mo1269f0();
            return -1;
        }
        char[] cArr = this.f1674U;
        int i3 = this.f1407t;
        int i4 = i3 + 1;
        this.f1407t = i4;
        char c3 = cArr[i3];
        if (c3 > ' ') {
            if (c3 != '/' && c3 != '#') {
                return c3;
            }
            this.f1407t = i3;
            return m1507z1();
        }
        if (c3 != ' ') {
            if (c3 == '\n') {
                this.f1410w++;
                this.f1411x = i4;
            } else if (c3 == '\r') {
                m1499r1();
            } else if (c3 != '\t') {
                m1285o0(c3);
                throw null;
            }
        }
        while (true) {
            int i5 = this.f1407t;
            if (i5 >= this.f1408u) {
                return m1507z1();
            }
            char[] cArr2 = this.f1674U;
            int i6 = i5 + 1;
            this.f1407t = i6;
            char c4 = cArr2[i5];
            if (c4 > ' ') {
                if (c4 != '/' && c4 != '#') {
                    return c4;
                }
                this.f1407t = i5;
                return m1507z1();
            }
            if (c4 != ' ') {
                if (c4 == '\n') {
                    this.f1410w++;
                    this.f1411x = i6;
                } else if (c4 == '\r') {
                    m1499r1();
                } else if (c4 != '\t') {
                    m1285o0(c4);
                    throw null;
                }
            }
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: z */
    public final C0684k mo1211z() {
        return AbstractC0570b.f1385S;
    }

    @Override // p045O0.AbstractC0570b
    /* JADX INFO: renamed from: z0 */
    public final char mo1275z0() throws C0542j {
        if (this.f1407t >= this.f1408u && !m1482a1()) {
            EnumC0548p enumC0548p = EnumC0548p.NOT_AVAILABLE;
            m1281k0(" in character escape sequence");
            throw null;
        }
        char[] cArr = this.f1674U;
        int i3 = this.f1407t;
        this.f1407t = i3 + 1;
        char c3 = cArr[i3];
        if (c3 == '\"' || c3 == '/' || c3 == '\\') {
            return c3;
        }
        if (c3 == 'b') {
            return '\b';
        }
        if (c3 == 'f') {
            return '\f';
        }
        if (c3 == 'n') {
            return '\n';
        }
        if (c3 == 'r') {
            return '\r';
        }
        if (c3 == 't') {
            return '\t';
        }
        if (c3 != 'u') {
            m1256F0(c3);
            return c3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            if (this.f1407t >= this.f1408u && !m1482a1()) {
                EnumC0548p enumC0548p2 = EnumC0548p.NOT_AVAILABLE;
                m1281k0(" in character escape sequence");
                throw null;
            }
            char[] cArr2 = this.f1674U;
            int i6 = this.f1407t;
            this.f1407t = i6 + 1;
            char c4 = cArr2[i6];
            int i7 = AbstractC0589b.f1510k[c4 & 255];
            if (i7 < 0) {
                m1283m0(c4, "expected a hex-digit for character escape sequence");
                throw null;
            }
            i4 = (i4 << 4) | i7;
        }
        return (char) i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        return r0;
     */
    /* JADX INFO: renamed from: z1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m1507z1() throws p042N0.C0542j {
        /*
            r3 = this;
        L0:
            int r0 = r3.f1407t
            int r1 = r3.f1408u
            if (r0 < r1) goto L11
            boolean r0 = r3.m1482a1()
            if (r0 != 0) goto L11
            r3.mo1269f0()
            r0 = -1
            return r0
        L11:
            char[] r0 = r3.f1674U
            int r1 = r3.f1407t
            int r2 = r1 + 1
            r3.f1407t = r2
            char r0 = r0[r1]
            r1 = 32
            if (r0 <= r1) goto L38
            r1 = 47
            if (r0 != r1) goto L27
            r3.m1503v1()
            goto L0
        L27:
            r1 = 35
            if (r0 != r1) goto L37
            int r1 = r3.f1306e
            int r2 = p058T0.C0641f.f1671k0
            r1 = r1 & r2
            if (r1 != 0) goto L33
            goto L37
        L33:
            r3.m1504w1()
            goto L0
        L37:
            return r0
        L38:
            if (r0 == r1) goto L0
            r1 = 10
            if (r0 != r1) goto L47
            int r0 = r3.f1410w
            int r0 = r0 + 1
            r3.f1410w = r0
            r3.f1411x = r2
            goto L0
        L47:
            r1 = 13
            if (r0 != r1) goto L4f
            r3.m1499r1()
            goto L0
        L4f:
            r1 = 9
            if (r0 != r1) goto L54
            goto L0
        L54:
            r3.m1285o0(r0)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0641f.m1507z1():int");
    }

    public C0641f(C0283l c0283l, int i3, Reader reader, AbstractC0549q abstractC0549q, C0658e c0658e) {
        super(c0283l, i3);
        this.f1673T = reader;
        C0283l.m556a((char[]) c0283l.f764j);
        char[] cArrM1633b = ((C0674a) c0283l.f759e).m1633b(0, 0);
        c0283l.f764j = cArrM1633b;
        this.f1674U = cArrM1633b;
        this.f1407t = 0;
        this.f1408u = 0;
        this.f1676W = abstractC0549q;
        this.f1677X = c0658e;
        this.f1678Y = c0658e.f1787c;
        this.f1675V = true;
    }
}
