package p058T0;

import com.fasterxml.jackson.core.exc.C1130a;
import com.fasterxml.jackson.core.exc.C1131b;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;
import p005B.AbstractC0032g;
import p025H1.C0283l;
import p042N0.AbstractC0549q;
import p042N0.C0533a;
import p042N0.C0541i;
import p042N0.C0542j;
import p042N0.EnumC0543k;
import p042N0.EnumC0548p;
import p045O0.AbstractC0570b;
import p045O0.AbstractC0571c;
import p050Q0.AbstractC0589b;
import p050Q0.C0591d;
import p061U0.C0654a;
import p061U0.C0655b;
import p066W0.C0674a;
import p066W0.C0676c;
import p066W0.C0684k;
import p066W0.C0688o;
import p118m1.C1742g;

/* JADX INFO: renamed from: T0.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0643h extends AbstractC0570b {

    /* JADX INFO: renamed from: d0 */
    public static final int f1697d0 = EnumC0543k.ALLOW_TRAILING_COMMA.f1297f;

    /* JADX INFO: renamed from: e0 */
    public static final int f1698e0 = EnumC0543k.ALLOW_NUMERIC_LEADING_ZEROS.f1297f;

    /* JADX INFO: renamed from: f0 */
    public static final int f1699f0 = EnumC0543k.ALLOW_NON_NUMERIC_NUMBERS.f1297f;

    /* JADX INFO: renamed from: g0 */
    public static final int f1700g0 = EnumC0543k.ALLOW_MISSING_VALUES.f1297f;

    /* JADX INFO: renamed from: h0 */
    public static final int f1701h0 = EnumC0543k.ALLOW_SINGLE_QUOTES.f1297f;

    /* JADX INFO: renamed from: i0 */
    public static final int f1702i0 = EnumC0543k.ALLOW_UNQUOTED_FIELD_NAMES.f1297f;

    /* JADX INFO: renamed from: j0 */
    public static final int f1703j0 = EnumC0543k.ALLOW_COMMENTS.f1297f;

    /* JADX INFO: renamed from: k0 */
    public static final int f1704k0 = EnumC0543k.ALLOW_YAML_COMMENTS.f1297f;

    /* JADX INFO: renamed from: l0 */
    public static final int[] f1705l0 = AbstractC0589b.f1505f;

    /* JADX INFO: renamed from: m0 */
    public static final int[] f1706m0 = AbstractC0589b.f1504e;

    /* JADX INFO: renamed from: T */
    public final AbstractC0549q f1707T;

    /* JADX INFO: renamed from: U */
    public final C0655b f1708U;

    /* JADX INFO: renamed from: V */
    public int[] f1709V;

    /* JADX INFO: renamed from: W */
    public boolean f1710W;

    /* JADX INFO: renamed from: X */
    public int f1711X;

    /* JADX INFO: renamed from: Y */
    public int f1712Y;

    /* JADX INFO: renamed from: Z */
    public int f1713Z;

    /* JADX INFO: renamed from: a0 */
    public InputStream f1714a0;

    /* JADX INFO: renamed from: b0 */
    public byte[] f1715b0;

    /* JADX INFO: renamed from: c0 */
    public final boolean f1716c0;

    public C0643h(C0283l c0283l, int i3, InputStream inputStream, AbstractC0549q abstractC0549q, C0655b c0655b, byte[] bArr, int i4, int i5, int i6, boolean z3) {
        super(c0283l, i3);
        this.f1709V = new int[16];
        this.f1714a0 = inputStream;
        this.f1707T = abstractC0549q;
        this.f1708U = c0655b;
        this.f1715b0 = bArr;
        this.f1407t = i4;
        this.f1408u = i5;
        this.f1411x = i4 - i6;
        this.f1409v = (-i4) + i6;
        this.f1716c0 = z3;
    }

    /* JADX INFO: renamed from: q1 */
    public static final int m1522q1(int i3, int i4) {
        return i4 == 4 ? i3 : i3 | ((-1) << (i4 << 3));
    }

    /* JADX INFO: renamed from: A1 */
    public final void m1523A1(int i3) throws C0542j {
        m1279i0("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i3));
        throw null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: B */
    public final String mo1157B() {
        EnumC0548p enumC0548p = this.f1423g;
        EnumC0548p enumC0548p2 = EnumC0548p.VALUE_STRING;
        C0688o c0688o = this.f1389D;
        if (enumC0548p == enumC0548p2) {
            if (!this.f1710W) {
                return c0688o.m1655h();
            }
            this.f1710W = false;
            return m1558c1();
        }
        if (enumC0548p == null) {
            return null;
        }
        int i3 = enumC0548p.f1328h;
        return i3 != 5 ? (i3 == 6 || i3 == 7 || i3 == 8) ? c0688o.m1655h() : enumC0548p.f1325e : this.f1387B.f1648g;
    }

    /* JADX INFO: renamed from: B1 */
    public final void m1524B1(int i3, int i4) throws C0542j {
        this.f1407t = i4;
        m1523A1(i3);
        throw null;
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
            } else if (this.f1710W) {
                this.f1710W = false;
                m1559d1();
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
    public final void m1525C1(String str, String str2) throws C0542j {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.f1407t >= this.f1408u && !m1563h1()) {
                break;
            }
            byte[] bArr = this.f1715b0;
            int i3 = this.f1407t;
            this.f1407t = i3 + 1;
            char cM1549X0 = (char) m1549X0(bArr[i3]);
            if (!Character.isJavaIdentifierPart(cM1549X0)) {
                break;
            }
            sb.append(cM1549X0);
            if (sb.length() >= 256) {
                sb.append("...");
                break;
            }
        }
        throw new C0542j(this, "Unrecognized token '" + ((Object) sb) + "': was expecting " + str2);
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
        } else if (this.f1710W) {
            this.f1710W = false;
            m1559d1();
        }
        return this.f1389D.m1663p();
    }

    /* JADX INFO: renamed from: D1 */
    public final void m1526D1() {
        if (this.f1407t < this.f1408u || m1563h1()) {
            byte[] bArr = this.f1715b0;
            int i3 = this.f1407t;
            if (bArr[i3] == 10) {
                this.f1407t = i3 + 1;
            }
        }
        this.f1410w++;
        this.f1411x = this.f1407t;
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
        } else if (this.f1710W) {
            this.f1710W = false;
            m1559d1();
        }
        int i4 = this.f1389D.f1871c;
        if (i4 >= 0) {
            return i4;
        }
        return 0;
    }

    /* JADX INFO: renamed from: E1 */
    public final int m1527E1() {
        int i3 = this.f1407t;
        if (i3 + 4 >= this.f1408u) {
            return m1528F1(false);
        }
        byte[] bArr = this.f1715b0;
        byte b3 = bArr[i3];
        if (b3 == 58) {
            int i4 = i3 + 1;
            this.f1407t = i4;
            byte b4 = bArr[i4];
            if (b4 > 32) {
                if (b4 == 47 || b4 == 35) {
                    return m1528F1(true);
                }
                this.f1407t = i3 + 2;
                return b4;
            }
            if (b4 == 32 || b4 == 9) {
                int i5 = i3 + 2;
                this.f1407t = i5;
                byte b5 = bArr[i5];
                if (b5 > 32) {
                    if (b5 == 47 || b5 == 35) {
                        return m1528F1(true);
                    }
                    this.f1407t = i3 + 3;
                    return b5;
                }
            }
            return m1528F1(true);
        }
        if (b3 == 32 || b3 == 9) {
            int i6 = i3 + 1;
            this.f1407t = i6;
            b3 = bArr[i6];
        }
        if (b3 != 58) {
            return m1528F1(false);
        }
        int i7 = this.f1407t;
        int i8 = i7 + 1;
        this.f1407t = i8;
        byte b6 = bArr[i8];
        if (b6 > 32) {
            if (b6 == 47 || b6 == 35) {
                return m1528F1(true);
            }
            this.f1407t = i7 + 2;
            return b6;
        }
        if (b6 == 32 || b6 == 9) {
            int i9 = i7 + 2;
            this.f1407t = i9;
            byte b7 = bArr[i9];
            if (b7 > 32) {
                if (b7 == 47 || b7 == 35) {
                    return m1528F1(true);
                }
                this.f1407t = i7 + 3;
                return b7;
            }
        }
        return m1528F1(true);
    }

    @Override // p045O0.AbstractC0571c, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: F */
    public final C0541i mo1161F() {
        if (this.f1423g != EnumC0548p.FIELD_NAME) {
            return new C0541i(m1272w0(), this.f1412y - 1, -1L, this.f1413z, this.f1386A);
        }
        return new C0541i(m1272w0(), this.f1409v + ((long) (this.f1711X - 1)), -1L, this.f1712Y, this.f1713Z);
    }

    /* JADX INFO: renamed from: F1 */
    public final int m1528F1(boolean z3) throws C0542j {
        while (true) {
            if (this.f1407t >= this.f1408u && !m1563h1()) {
                m1281k0(" within/between " + this.f1387B.m1220h() + " entries");
                throw null;
            }
            byte[] bArr = this.f1715b0;
            int i3 = this.f1407t;
            int i4 = i3 + 1;
            this.f1407t = i4;
            int i5 = bArr[i3] & 255;
            if (i5 > 32) {
                if (i5 == 47) {
                    m1529G1();
                } else if (i5 == 35 && (this.f1306e & f1704k0) != 0) {
                    m1530H1();
                } else {
                    if (z3) {
                        return i5;
                    }
                    if (i5 != 58) {
                        m1283m0(i5, "was expecting a colon to separate field name and value");
                        throw null;
                    }
                    z3 = true;
                }
            } else if (i5 == 32) {
                continue;
            } else if (i5 == 10) {
                this.f1410w++;
                this.f1411x = i4;
            } else if (i5 == 13) {
                m1526D1();
            } else if (i5 != 9) {
                m1285o0(i5);
                throw null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
    
        m1281k0(" in a comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0072, code lost:
    
        throw null;
     */
    /* JADX INFO: renamed from: G1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1529G1() throws p042N0.C0542j {
        /*
            r9 = this;
            int r0 = r9.f1306e
            int r1 = p058T0.C0643h.f1703j0
            r0 = r0 & r1
            r1 = 0
            r2 = 47
            if (r0 == 0) goto La3
            int r0 = r9.f1407t
            int r3 = r9.f1408u
            java.lang.String r4 = " in a comment"
            if (r0 < r3) goto L1d
            boolean r0 = r9.m1563h1()
            if (r0 == 0) goto L19
            goto L1d
        L19:
            r9.m1281k0(r4)
            throw r1
        L1d:
            byte[] r0 = r9.f1715b0
            int r3 = r9.f1407t
            int r5 = r3 + 1
            r9.f1407t = r5
            r0 = r0[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 != r2) goto L2f
            r9.m1530H1()
            goto L7f
        L2f:
            r3 = 42
            if (r0 != r3) goto L9d
            int[] r5 = p050Q0.AbstractC0589b.f1508i
        L35:
            int r0 = r9.f1407t
            int r6 = r9.f1408u
            if (r0 < r6) goto L41
            boolean r0 = r9.m1563h1()
            if (r0 == 0) goto L6f
        L41:
            byte[] r0 = r9.f1715b0
            int r6 = r9.f1407t
            int r7 = r6 + 1
            r9.f1407t = r7
            r0 = r0[r6]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r6 = r5[r0]
            if (r6 == 0) goto L35
            r8 = 2
            if (r6 == r8) goto L99
            r8 = 3
            if (r6 == r8) goto L95
            r8 = 4
            if (r6 == r8) goto L91
            r8 = 10
            if (r6 == r8) goto L88
            r8 = 13
            if (r6 == r8) goto L84
            if (r6 != r3) goto L80
            int r0 = r9.f1408u
            if (r7 < r0) goto L73
            boolean r0 = r9.m1563h1()
            if (r0 == 0) goto L6f
            goto L73
        L6f:
            r9.m1281k0(r4)
            throw r1
        L73:
            byte[] r0 = r9.f1715b0
            int r6 = r9.f1407t
            r0 = r0[r6]
            if (r0 != r2) goto L35
            int r6 = r6 + 1
            r9.f1407t = r6
        L7f:
            return
        L80:
            r9.m1579y1(r0)
            throw r1
        L84:
            r9.m1526D1()
            goto L35
        L88:
            int r0 = r9.f1410w
            int r0 = r0 + 1
            r9.f1410w = r0
            r9.f1411x = r7
            goto L35
        L91:
            r9.m1534L1()
            goto L35
        L95:
            r9.m1533K1()
            goto L35
        L99:
            r9.m1532J1()
            goto L35
        L9d:
            java.lang.String r2 = "was expecting either '*' or '/' for a comment"
            r9.m1283m0(r0, r2)
            throw r1
        La3:
            java.lang.String r0 = "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)"
            r9.m1283m0(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0643h.m1529G1():void");
    }

    @Override // p045O0.AbstractC0571c, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: H */
    public final int mo1163H() throws C1130a, C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p != EnumC0548p.VALUE_NUMBER_INT && enumC0548p != EnumC0548p.VALUE_NUMBER_FLOAT) {
            return super.mo1286p0();
        }
        int i3 = this.f1394I;
        int i4 = i3 & 1;
        if (i4 == 0) {
            if (i3 == 0) {
                return m1257G0();
            }
            if (i4 == 0) {
                m1263M0();
            }
        }
        return this.f1395J;
    }

    /* JADX INFO: renamed from: H1 */
    public final void m1530H1() throws C0542j {
        int[] iArr = AbstractC0589b.f1508i;
        while (true) {
            if (this.f1407t >= this.f1408u && !m1563h1()) {
                return;
            }
            byte[] bArr = this.f1715b0;
            int i3 = this.f1407t;
            int i4 = i3 + 1;
            this.f1407t = i4;
            int i5 = bArr[i3] & 255;
            int i6 = iArr[i5];
            if (i6 != 0) {
                if (i6 == 2) {
                    m1532J1();
                } else if (i6 == 3) {
                    m1533K1();
                } else if (i6 == 4) {
                    m1534L1();
                } else if (i6 == 10) {
                    this.f1410w++;
                    this.f1411x = i4;
                    return;
                } else if (i6 == 13) {
                    m1526D1();
                    return;
                } else if (i6 != 42 && i6 < 0) {
                    m1579y1(i5);
                    throw null;
                }
            }
        }
    }

    @Override // p045O0.AbstractC0570b
    /* JADX INFO: renamed from: I0 */
    public final void mo1259I0() {
        byte[] bArr;
        byte[] bArr2;
        this.f1389D.m1661n();
        char[] cArr = this.f1390E;
        C0283l c0283l = this.f1404q;
        if (cArr != null) {
            this.f1390E = null;
            char[] cArr2 = (char[]) c0283l.f766l;
            if (cArr != cArr2 && cArr.length < cArr2.length) {
                throw new IllegalArgumentException("Trying to release buffer smaller than original");
            }
            c0283l.f766l = null;
            ((C0674a) c0283l.f759e).f1835b.set(3, cArr);
        }
        C0655b c0655b = this.f1708U;
        C0655b c0655b2 = c0655b.f1763a;
        if (c0655b2 != null && (!c0655b.f1777o)) {
            C0654a c0654a = new C0654a(c0655b);
            AtomicReference atomicReference = c0655b2.f1764b;
            C0654a c0654a2 = (C0654a) atomicReference.get();
            int i3 = c0654a2.f1757b;
            int i4 = c0654a.f1757b;
            if (i4 != i3) {
                if (i4 > 6000) {
                    c0654a = new C0654a(64, 4, new int[512], new String[128], 448, 512);
                }
                while (!atomicReference.compareAndSet(c0654a2, c0654a) && atomicReference.get() == c0654a2) {
                }
            }
            c0655b.f1777o = true;
        }
        if (!this.f1716c0 || (bArr = this.f1715b0) == null || bArr == (bArr2 = AbstractC0571c.f1414h)) {
            return;
        }
        this.f1715b0 = bArr2;
        c0283l.m561f(bArr);
    }

    /* JADX INFO: renamed from: I1 */
    public final void m1531I1() throws C0542j {
        this.f1710W = false;
        byte[] bArr = this.f1715b0;
        while (true) {
            int i3 = this.f1407t;
            int i4 = this.f1408u;
            if (i3 >= i4) {
                m1564i1();
                i3 = this.f1407t;
                i4 = this.f1408u;
            }
            while (true) {
                if (i3 >= i4) {
                    this.f1407t = i3;
                    break;
                }
                int i5 = i3 + 1;
                int i6 = bArr[i3] & 255;
                int i7 = f1705l0[i6];
                if (i7 != 0) {
                    this.f1407t = i5;
                    if (i6 == 34) {
                        return;
                    }
                    if (i7 == 1) {
                        mo1275z0();
                    } else if (i7 == 2) {
                        m1532J1();
                    } else if (i7 == 3) {
                        m1533K1();
                    } else if (i7 == 4) {
                        m1534L1();
                    } else {
                        if (i6 >= 32) {
                            m1579y1(i6);
                            throw null;
                        }
                        m1261K0(i6, "string value");
                    }
                } else {
                    i3 = i5;
                }
            }
        }
    }

    @Override // p045O0.AbstractC0571c, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: J */
    public final String mo1165J() {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p != EnumC0548p.VALUE_STRING) {
            return enumC0548p == EnumC0548p.FIELD_NAME ? mo1198m() : super.mo1287q0();
        }
        if (!this.f1710W) {
            return this.f1389D.m1655h();
        }
        this.f1710W = false;
        return m1558c1();
    }

    /* JADX INFO: renamed from: J1 */
    public final void m1532J1() throws C0542j {
        if (this.f1407t >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr = this.f1715b0;
        int i3 = this.f1407t;
        int i4 = i3 + 1;
        this.f1407t = i4;
        byte b3 = bArr[i3];
        if ((b3 & 192) == 128) {
            return;
        }
        m1524B1(b3 & 255, i4);
        throw null;
    }

    /* JADX INFO: renamed from: K1 */
    public final void m1533K1() throws C0542j {
        if (this.f1407t >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr = this.f1715b0;
        int i3 = this.f1407t;
        int i4 = i3 + 1;
        this.f1407t = i4;
        byte b3 = bArr[i3];
        if ((b3 & 192) != 128) {
            m1524B1(b3 & 255, i4);
            throw null;
        }
        if (i4 >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr2 = this.f1715b0;
        int i5 = this.f1407t;
        int i6 = i5 + 1;
        this.f1407t = i6;
        byte b4 = bArr2[i5];
        if ((b4 & 192) == 128) {
            return;
        }
        m1524B1(b4 & 255, i6);
        throw null;
    }

    /* JADX INFO: renamed from: L1 */
    public final void m1534L1() throws C0542j {
        if (this.f1407t >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr = this.f1715b0;
        int i3 = this.f1407t;
        int i4 = i3 + 1;
        this.f1407t = i4;
        byte b3 = bArr[i3];
        if ((b3 & 192) != 128) {
            m1524B1(b3 & 255, i4);
            throw null;
        }
        if (i4 >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr2 = this.f1715b0;
        int i5 = this.f1407t;
        int i6 = i5 + 1;
        this.f1407t = i6;
        byte b4 = bArr2[i5];
        if ((b4 & 192) != 128) {
            m1524B1(b4 & 255, i6);
            throw null;
        }
        if (i6 >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr3 = this.f1715b0;
        int i7 = this.f1407t;
        int i8 = i7 + 1;
        this.f1407t = i8;
        byte b5 = bArr3[i7];
        if ((b5 & 192) == 128) {
            return;
        }
        m1524B1(b5 & 255, i8);
        throw null;
    }

    /* JADX INFO: renamed from: M1 */
    public final int m1535M1() throws C0542j {
        while (true) {
            int i3 = this.f1407t;
            if (i3 >= this.f1408u) {
                return m1536N1();
            }
            byte[] bArr = this.f1715b0;
            int i4 = i3 + 1;
            this.f1407t = i4;
            int i5 = bArr[i3] & 255;
            if (i5 > 32) {
                if (i5 != 47 && i5 != 35) {
                    return i5;
                }
                this.f1407t = i3;
                return m1536N1();
            }
            if (i5 != 32) {
                if (i5 == 10) {
                    this.f1410w++;
                    this.f1411x = i4;
                } else if (i5 == 13) {
                    m1526D1();
                } else if (i5 != 9) {
                    m1285o0(i5);
                    throw null;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        return r0;
     */
    /* JADX INFO: renamed from: N1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m1536N1() throws p042N0.C0542j {
        /*
            r3 = this;
        L0:
            int r0 = r3.f1407t
            int r1 = r3.f1408u
            if (r0 < r1) goto L2c
            boolean r0 = r3.m1563h1()
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
            byte[] r0 = r3.f1715b0
            int r1 = r3.f1407t
            int r2 = r1 + 1
            r3.f1407t = r2
            r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 32
            if (r0 <= r1) goto L55
            r1 = 47
            if (r0 != r1) goto L44
            r3.m1529G1()
            goto L0
        L44:
            r1 = 35
            if (r0 != r1) goto L54
            int r1 = r3.f1306e
            int r2 = p058T0.C0643h.f1704k0
            r1 = r1 & r2
            if (r1 != 0) goto L50
            goto L54
        L50:
            r3.m1530H1()
            goto L0
        L54:
            return r0
        L55:
            if (r0 == r1) goto L0
            r1 = 10
            if (r0 != r1) goto L64
            int r0 = r3.f1410w
            int r0 = r0 + 1
            r3.f1410w = r0
            r3.f1411x = r2
            goto L0
        L64:
            r1 = 13
            if (r0 != r1) goto L6c
            r3.m1526D1()
            goto L0
        L6c:
            r1 = 9
            if (r0 != r1) goto L71
            goto L0
        L71:
            r3.m1285o0(r0)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0643h.m1536N1():int");
    }

    /* JADX INFO: renamed from: O1 */
    public final int m1537O1() throws C0542j {
        if (this.f1407t >= this.f1408u && !m1563h1()) {
            mo1269f0();
            return -1;
        }
        byte[] bArr = this.f1715b0;
        int i3 = this.f1407t;
        int i4 = i3 + 1;
        this.f1407t = i4;
        int i5 = bArr[i3] & 255;
        if (i5 > 32) {
            if (i5 != 47 && i5 != 35) {
                return i5;
            }
            this.f1407t = i3;
            return m1538P1();
        }
        if (i5 != 32) {
            if (i5 == 10) {
                this.f1410w++;
                this.f1411x = i4;
            } else if (i5 == 13) {
                m1526D1();
            } else if (i5 != 9) {
                m1285o0(i5);
                throw null;
            }
        }
        while (true) {
            int i6 = this.f1407t;
            if (i6 >= this.f1408u) {
                return m1538P1();
            }
            byte[] bArr2 = this.f1715b0;
            int i7 = i6 + 1;
            this.f1407t = i7;
            int i8 = bArr2[i6] & 255;
            if (i8 > 32) {
                if (i8 != 47 && i8 != 35) {
                    return i8;
                }
                this.f1407t = i6;
                return m1538P1();
            }
            if (i8 != 32) {
                if (i8 == 10) {
                    this.f1410w++;
                    this.f1411x = i7;
                } else if (i8 == 13) {
                    m1526D1();
                } else if (i8 != 9) {
                    m1285o0(i8);
                    throw null;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        return r0;
     */
    /* JADX INFO: renamed from: P1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m1538P1() throws p042N0.C0542j {
        /*
            r3 = this;
        L0:
            int r0 = r3.f1407t
            int r1 = r3.f1408u
            if (r0 < r1) goto L12
            boolean r0 = r3.m1563h1()
            if (r0 == 0) goto Ld
            goto L12
        Ld:
            r3.mo1269f0()
            r0 = -1
            return r0
        L12:
            byte[] r0 = r3.f1715b0
            int r1 = r3.f1407t
            int r2 = r1 + 1
            r3.f1407t = r2
            r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 32
            if (r0 <= r1) goto L3b
            r1 = 47
            if (r0 != r1) goto L2a
            r3.m1529G1()
            goto L0
        L2a:
            r1 = 35
            if (r0 != r1) goto L3a
            int r1 = r3.f1306e
            int r2 = p058T0.C0643h.f1704k0
            r1 = r1 & r2
            if (r1 != 0) goto L36
            goto L3a
        L36:
            r3.m1530H1()
            goto L0
        L3a:
            return r0
        L3b:
            if (r0 == r1) goto L0
            r1 = 10
            if (r0 != r1) goto L4a
            int r0 = r3.f1410w
            int r0 = r0 + 1
            r3.f1410w = r0
            r3.f1411x = r2
            goto L0
        L4a:
            r1 = 13
            if (r0 != r1) goto L52
            r3.m1526D1()
            goto L0
        L52:
            r1 = 9
            if (r0 != r1) goto L57
            goto L0
        L57:
            r3.m1285o0(r0)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0643h.m1538P1():int");
    }

    /* JADX INFO: renamed from: Q1 */
    public final void m1539Q1() {
        this.f1413z = this.f1410w;
        int i3 = this.f1407t;
        this.f1412y = this.f1409v + ((long) i3);
        this.f1386A = i3 - this.f1411x;
    }

    /* JADX INFO: renamed from: R1 */
    public final int m1540R1() throws C0542j {
        if (this.f1407t >= this.f1408u && !m1563h1()) {
            return 48;
        }
        byte[] bArr = this.f1715b0;
        int i3 = this.f1407t;
        int i4 = bArr[i3] & 255;
        if (i4 < 48 || i4 > 57) {
            return 48;
        }
        if ((this.f1306e & f1698e0) == 0) {
            m1279i0("Invalid numeric value: Leading zeroes not allowed");
            throw null;
        }
        this.f1407t = i3 + 1;
        if (i4 == 48) {
            do {
                if (this.f1407t >= this.f1408u && !m1563h1()) {
                    break;
                }
                byte[] bArr2 = this.f1715b0;
                int i5 = this.f1407t;
                i4 = bArr2[i5] & 255;
                if (i4 < 48 || i4 > 57) {
                    return 48;
                }
                this.f1407t = i5 + 1;
            } while (i4 == 48);
        }
        return i4;
    }

    /* JADX INFO: renamed from: S1 */
    public final void m1541S1(int i3) throws C0542j {
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
    /* JADX INFO: renamed from: T */
    public final String mo1175T() throws C0542j {
        EnumC0548p enumC0548pM1576v1;
        this.f1394I = 0;
        EnumC0548p enumC0548p = this.f1423g;
        EnumC0548p enumC0548p2 = EnumC0548p.FIELD_NAME;
        if (enumC0548p == enumC0548p2) {
            m1570o1();
            return null;
        }
        if (this.f1710W) {
            m1531I1();
        }
        int iM1537O1 = m1537O1();
        if (iM1537O1 < 0) {
            close();
            this.f1423g = null;
            return null;
        }
        this.f1393H = null;
        if (iM1537O1 == 93) {
            m1543U0();
            this.f1423g = EnumC0548p.END_ARRAY;
            return null;
        }
        if (iM1537O1 == 125) {
            m1545V0();
            this.f1423g = EnumC0548p.END_OBJECT;
            return null;
        }
        if (this.f1387B.m1465i()) {
            if (iM1537O1 != 44) {
                m1283m0(iM1537O1, "was expecting comma to separate " + this.f1387B.m1220h() + " entries");
                throw null;
            }
            iM1537O1 = m1535M1();
            if ((this.f1306e & f1697d0) != 0 && (iM1537O1 == 93 || iM1537O1 == 125)) {
                if (iM1537O1 == 125) {
                    m1545V0();
                    this.f1423g = EnumC0548p.END_OBJECT;
                } else {
                    m1543U0();
                    this.f1423g = EnumC0548p.END_ARRAY;
                }
                return null;
            }
        }
        if (!this.f1387B.m1217e()) {
            m1539Q1();
            m1571p1(iM1537O1);
            return null;
        }
        this.f1712Y = this.f1410w;
        int i3 = this.f1407t;
        this.f1711X = i3;
        this.f1713Z = i3 - this.f1411x;
        String strM1574t1 = m1574t1(iM1537O1);
        this.f1387B.m1466j(strM1574t1);
        this.f1423g = enumC0548p2;
        int iM1527E1 = m1527E1();
        m1539Q1();
        if (iM1527E1 == 34) {
            this.f1710W = true;
            this.f1388C = EnumC0548p.VALUE_STRING;
            return strM1574t1;
        }
        if (iM1527E1 == 43) {
            enumC0548pM1576v1 = EnumC0639d.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.f1657f.m1155a(this.f1306e) ? m1576v1(false) : m1562g1(iM1527E1);
        } else if (iM1527E1 == 91) {
            enumC0548pM1576v1 = EnumC0548p.START_ARRAY;
        } else if (iM1527E1 == 102) {
            m1565j1();
            enumC0548pM1576v1 = EnumC0548p.VALUE_FALSE;
        } else if (iM1527E1 == 110) {
            m1566k1();
            enumC0548pM1576v1 = EnumC0548p.VALUE_NULL;
        } else if (iM1527E1 == 116) {
            m1569n1();
            enumC0548pM1576v1 = EnumC0548p.VALUE_TRUE;
        } else if (iM1527E1 == 123) {
            enumC0548pM1576v1 = EnumC0548p.START_OBJECT;
        } else if (iM1527E1 == 45) {
            enumC0548pM1576v1 = m1576v1(true);
        } else if (iM1527E1 != 46) {
            switch (iM1527E1) {
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
                    enumC0548pM1576v1 = m1577w1(iM1527E1);
                    break;
                default:
                    enumC0548pM1576v1 = m1562g1(iM1527E1);
                    break;
            }
        } else {
            enumC0548pM1576v1 = m1573s1(false);
        }
        this.f1388C = enumC0548pM1576v1;
        return strM1574t1;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0130  */
    /* JADX INFO: renamed from: T1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m1542T1(int r23, int r24, int[] r25) throws p042N0.C0542j {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0643h.m1542T1(int, int, int[]):java.lang.String");
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: U */
    public final String mo1176U() {
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
            if (!this.f1710W) {
                return this.f1389D.m1655h();
            }
            this.f1710W = false;
            return m1558c1();
        }
        if (enumC0548p == EnumC0548p.START_ARRAY) {
            m1264N0(this.f1413z, this.f1386A);
        } else if (enumC0548p == EnumC0548p.START_OBJECT) {
            m1265O0(this.f1413z, this.f1386A);
        }
        return null;
    }

    /* JADX INFO: renamed from: U0 */
    public final void m1543U0() throws C0542j {
        m1539Q1();
        if (!this.f1387B.m1216d()) {
            m1260J0('}', 93);
            throw null;
        }
        C0638c c0638c = this.f1387B;
        c0638c.f1649h = null;
        this.f1387B = c0638c.f1645d;
    }

    /* JADX INFO: renamed from: U1 */
    public final String m1544U1(int i3, int i4) {
        int iM1522q1 = m1522q1(i3, i4);
        String strM1611j = this.f1708U.m1611j(iM1522q1);
        if (strM1611j != null) {
            return strM1611j;
        }
        int[] iArr = this.f1709V;
        iArr[0] = iM1522q1;
        return m1542T1(1, i4, iArr);
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: V */
    public final EnumC0548p mo1177V() throws C0542j {
        EnumC0548p enumC0548pM1576v1;
        EnumC0548p enumC0548p = this.f1423g;
        EnumC0548p enumC0548p2 = EnumC0548p.FIELD_NAME;
        if (enumC0548p == enumC0548p2) {
            return m1570o1();
        }
        this.f1394I = 0;
        if (this.f1710W) {
            m1531I1();
        }
        int iM1537O1 = m1537O1();
        if (iM1537O1 < 0) {
            close();
            this.f1423g = null;
            return null;
        }
        this.f1393H = null;
        if (iM1537O1 == 93) {
            m1543U0();
            EnumC0548p enumC0548p3 = EnumC0548p.END_ARRAY;
            this.f1423g = enumC0548p3;
            return enumC0548p3;
        }
        if (iM1537O1 == 125) {
            m1545V0();
            EnumC0548p enumC0548p4 = EnumC0548p.END_OBJECT;
            this.f1423g = enumC0548p4;
            return enumC0548p4;
        }
        if (this.f1387B.m1465i()) {
            if (iM1537O1 != 44) {
                m1283m0(iM1537O1, "was expecting comma to separate " + this.f1387B.m1220h() + " entries");
                throw null;
            }
            iM1537O1 = m1535M1();
            if ((this.f1306e & f1697d0) != 0 && (iM1537O1 == 93 || iM1537O1 == 125)) {
                if (iM1537O1 == 125) {
                    m1545V0();
                    EnumC0548p enumC0548p5 = EnumC0548p.END_OBJECT;
                    this.f1423g = enumC0548p5;
                    return enumC0548p5;
                }
                m1543U0();
                EnumC0548p enumC0548p6 = EnumC0548p.END_ARRAY;
                this.f1423g = enumC0548p6;
                return enumC0548p6;
            }
        }
        if (!this.f1387B.m1217e()) {
            m1539Q1();
            return m1571p1(iM1537O1);
        }
        this.f1712Y = this.f1410w;
        int i3 = this.f1407t;
        this.f1711X = i3;
        this.f1713Z = i3 - this.f1411x;
        this.f1387B.m1466j(m1574t1(iM1537O1));
        this.f1423g = enumC0548p2;
        int iM1527E1 = m1527E1();
        m1539Q1();
        if (iM1527E1 == 34) {
            this.f1710W = true;
            this.f1388C = EnumC0548p.VALUE_STRING;
            return this.f1423g;
        }
        if (iM1527E1 == 43) {
            enumC0548pM1576v1 = EnumC0639d.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.f1657f.m1155a(this.f1306e) ? m1576v1(false) : m1562g1(iM1527E1);
        } else if (iM1527E1 == 91) {
            enumC0548pM1576v1 = EnumC0548p.START_ARRAY;
        } else if (iM1527E1 == 102) {
            m1565j1();
            enumC0548pM1576v1 = EnumC0548p.VALUE_FALSE;
        } else if (iM1527E1 == 110) {
            m1566k1();
            enumC0548pM1576v1 = EnumC0548p.VALUE_NULL;
        } else if (iM1527E1 == 116) {
            m1569n1();
            enumC0548pM1576v1 = EnumC0548p.VALUE_TRUE;
        } else if (iM1527E1 == 123) {
            enumC0548pM1576v1 = EnumC0548p.START_OBJECT;
        } else if (iM1527E1 == 45) {
            enumC0548pM1576v1 = m1576v1(true);
        } else if (iM1527E1 != 46) {
            switch (iM1527E1) {
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
                    enumC0548pM1576v1 = m1577w1(iM1527E1);
                    break;
                default:
                    enumC0548pM1576v1 = m1562g1(iM1527E1);
                    break;
            }
        } else {
            enumC0548pM1576v1 = m1573s1(false);
        }
        this.f1388C = enumC0548pM1576v1;
        return this.f1423g;
    }

    /* JADX INFO: renamed from: V0 */
    public final void m1545V0() throws C0542j {
        m1539Q1();
        if (!this.f1387B.m1217e()) {
            m1260J0(']', 125);
            throw null;
        }
        C0638c c0638c = this.f1387B;
        c0638c.f1649h = null;
        this.f1387B = c0638c.f1645d;
    }

    /* JADX INFO: renamed from: V1 */
    public final String m1546V1(int i3, int i4, int i5) {
        int iM1522q1 = m1522q1(i4, i5);
        String strM1612k = this.f1708U.m1612k(i3, iM1522q1);
        if (strM1612k != null) {
            return strM1612k;
        }
        int[] iArr = this.f1709V;
        iArr[0] = i3;
        iArr[1] = iM1522q1;
        return m1542T1(2, i5, iArr);
    }

    /* JADX INFO: renamed from: W0 */
    public final byte[] m1547W0(C0533a c0533a) throws C0542j {
        C0676c c0676cM1253C0 = m1253C0();
        while (true) {
            if (this.f1407t >= this.f1408u) {
                m1564i1();
            }
            byte[] bArr = this.f1715b0;
            int i3 = this.f1407t;
            this.f1407t = i3 + 1;
            int i4 = bArr[i3] & 255;
            if (i4 > 32) {
                int iM1074d = c0533a.m1074d(i4);
                if (iM1074d < 0) {
                    if (i4 == 34) {
                        return c0676cM1253C0.m1639f();
                    }
                    iM1074d = m1274y0(c0533a, i4, 0);
                    if (iM1074d < 0) {
                        continue;
                    }
                }
                if (this.f1407t >= this.f1408u) {
                    m1564i1();
                }
                byte[] bArr2 = this.f1715b0;
                int i5 = this.f1407t;
                this.f1407t = i5 + 1;
                int i6 = bArr2[i5] & 255;
                int iM1074d2 = c0533a.m1074d(i6);
                if (iM1074d2 < 0) {
                    iM1074d2 = m1274y0(c0533a, i6, 1);
                }
                int i7 = (iM1074d << 6) | iM1074d2;
                if (this.f1407t >= this.f1408u) {
                    m1564i1();
                }
                byte[] bArr3 = this.f1715b0;
                int i8 = this.f1407t;
                this.f1407t = i8 + 1;
                int i9 = bArr3[i8] & 255;
                int iM1074d3 = c0533a.m1074d(i9);
                if (iM1074d3 < 0) {
                    if (iM1074d3 != -2) {
                        if (i9 == 34) {
                            c0676cM1253C0.m1635b(i7 >> 4);
                            if (!c0533a.m1081k()) {
                                return c0676cM1253C0.m1639f();
                            }
                            this.f1407t--;
                            m1279i0(c0533a.m1080j());
                            throw null;
                        }
                        iM1074d3 = m1274y0(c0533a, i9, 2);
                    }
                    if (iM1074d3 == -2) {
                        if (this.f1407t >= this.f1408u) {
                            m1564i1();
                        }
                        byte[] bArr4 = this.f1715b0;
                        int i10 = this.f1407t;
                        this.f1407t = i10 + 1;
                        int i11 = bArr4[i10] & 255;
                        char c3 = c0533a.f1223i;
                        if (i11 != c3 && m1274y0(c0533a, i11, 3) != -2) {
                            throw AbstractC0570b.m1250Q0(c0533a, i11, 3, "expected padding character '" + c3 + "'");
                        }
                        c0676cM1253C0.m1635b(i7 >> 4);
                    }
                }
                int i12 = (i7 << 6) | iM1074d3;
                if (this.f1407t >= this.f1408u) {
                    m1564i1();
                }
                byte[] bArr5 = this.f1715b0;
                int i13 = this.f1407t;
                this.f1407t = i13 + 1;
                int i14 = bArr5[i13] & 255;
                int iM1074d4 = c0533a.m1074d(i14);
                if (iM1074d4 < 0) {
                    if (iM1074d4 != -2) {
                        if (i14 == 34) {
                            c0676cM1253C0.m1637d(i12 >> 2);
                            if (!c0533a.m1081k()) {
                                return c0676cM1253C0.m1639f();
                            }
                            this.f1407t--;
                            m1279i0(c0533a.m1080j());
                            throw null;
                        }
                        iM1074d4 = m1274y0(c0533a, i14, 3);
                    }
                    if (iM1074d4 == -2) {
                        c0676cM1253C0.m1637d(i12 >> 2);
                    }
                }
                c0676cM1253C0.m1636c((i12 << 6) | iM1074d4);
            }
        }
    }

    /* JADX INFO: renamed from: W1 */
    public final String m1548W1(int i3, int i4, int i5, int i6) {
        int iM1522q1 = m1522q1(i5, i6);
        String strM1613l = this.f1708U.m1613l(i3, i4, iM1522q1);
        if (strM1613l != null) {
            return strM1613l;
        }
        int[] iArr = this.f1709V;
        iArr[0] = i3;
        iArr[1] = i4;
        iArr[2] = m1522q1(iM1522q1, i6);
        return m1542T1(3, i6, iArr);
    }

    /* JADX INFO: renamed from: X0 */
    public final int m1549X0(int i3) throws C0542j {
        int i4;
        char c3;
        int i5 = i3 & 255;
        if (i5 <= 127) {
            return i5;
        }
        if ((i3 & 224) == 192) {
            i4 = i3 & 31;
            c3 = 1;
        } else if ((i3 & 240) == 224) {
            i4 = i3 & 15;
            c3 = 2;
        } else {
            if ((i3 & 248) != 240) {
                m1580z1(i3 & 255);
                throw null;
            }
            i4 = i3 & 7;
            c3 = 3;
        }
        int iM1552Y1 = m1552Y1();
        if ((iM1552Y1 & 192) != 128) {
            m1523A1(iM1552Y1 & 255);
            throw null;
        }
        int i6 = (i4 << 6) | (iM1552Y1 & 63);
        if (c3 > 1) {
            int iM1552Y12 = m1552Y1();
            if ((iM1552Y12 & 192) != 128) {
                m1523A1(iM1552Y12 & 255);
                throw null;
            }
            i6 = (i6 << 6) | (iM1552Y12 & 63);
            if (c3 > 2) {
                int iM1552Y13 = m1552Y1();
                if ((iM1552Y13 & 192) == 128) {
                    return (iM1552Y13 & 63) | (i6 << 6);
                }
                m1523A1(iM1552Y13 & 255);
                throw null;
            }
        }
        return i6;
    }

    /* JADX INFO: renamed from: X1 */
    public final String m1550X1(int i3, int i4, int i5, int[] iArr) {
        if (i3 >= iArr.length) {
            iArr = AbstractC0570b.m1249P0(iArr, iArr.length);
            this.f1709V = iArr;
        }
        int i6 = i3 + 1;
        iArr[i3] = m1522q1(i4, i5);
        String strM1614m = this.f1708U.m1614m(iArr, i6);
        return strM1614m == null ? m1542T1(i6, i5, iArr) : strM1614m;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: Y */
    public final int mo1180Y(C0533a c0533a, C1742g c1742g) throws IOException {
        if (!this.f1710W || this.f1423g != EnumC0548p.VALUE_STRING) {
            byte[] bArrMo1193h = mo1193h(c0533a);
            c1742g.write(bArrMo1193h);
            return bArrMo1193h.length;
        }
        C0283l c0283l = this.f1404q;
        byte[] bArrM557b = c0283l.m557b();
        try {
            return m1578x1(c0533a, c1742g, bArrM557b);
        } finally {
            c0283l.m560e(bArrM557b);
        }
    }

    /* JADX INFO: renamed from: Y0 */
    public final int m1551Y0(int i3) throws C0542j {
        if (this.f1407t >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr = this.f1715b0;
        int i4 = this.f1407t;
        int i5 = i4 + 1;
        this.f1407t = i5;
        byte b3 = bArr[i4];
        if ((b3 & 192) == 128) {
            return ((i3 & 31) << 6) | (b3 & 63);
        }
        m1524B1(b3 & 255, i5);
        throw null;
    }

    /* JADX INFO: renamed from: Y1 */
    public final int m1552Y1() throws C0591d {
        if (this.f1407t >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr = this.f1715b0;
        int i3 = this.f1407t;
        this.f1407t = i3 + 1;
        return bArr[i3] & 255;
    }

    /* JADX INFO: renamed from: Z0 */
    public final int m1553Z0(int i3) throws C0542j {
        if (this.f1407t >= this.f1408u) {
            m1564i1();
        }
        int i4 = i3 & 15;
        byte[] bArr = this.f1715b0;
        int i5 = this.f1407t;
        int i6 = i5 + 1;
        this.f1407t = i6;
        byte b3 = bArr[i5];
        if ((b3 & 192) != 128) {
            m1524B1(b3 & 255, i6);
            throw null;
        }
        int i7 = (i4 << 6) | (b3 & 63);
        if (i6 >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr2 = this.f1715b0;
        int i8 = this.f1407t;
        int i9 = i8 + 1;
        this.f1407t = i9;
        byte b4 = bArr2[i8];
        if ((b4 & 192) == 128) {
            return (i7 << 6) | (b4 & 63);
        }
        m1524B1(b4 & 255, i9);
        throw null;
    }

    /* JADX INFO: renamed from: Z1 */
    public final String m1554Z1(int i3, int i4, int i5, int i6, int[] iArr) throws C0542j {
        int i7;
        int i8;
        while (true) {
            if (f1706m0[i5] != 0) {
                if (i5 == 34) {
                    if (i6 > 0) {
                        if (i3 >= iArr.length) {
                            iArr = AbstractC0570b.m1249P0(iArr, iArr.length);
                            this.f1709V = iArr;
                        }
                        iArr[i3] = m1522q1(i4, i6);
                        i3 = 1 + i3;
                    }
                    String strM1614m = this.f1708U.m1614m(iArr, i3);
                    return strM1614m == null ? m1542T1(i3, i6, iArr) : strM1614m;
                }
                if (i5 != 92) {
                    m1261K0(i5, "name");
                } else {
                    i5 = mo1275z0();
                }
                if (i5 > 127) {
                    int i9 = 0;
                    if (i6 >= 4) {
                        if (i3 >= iArr.length) {
                            iArr = AbstractC0570b.m1249P0(iArr, iArr.length);
                            this.f1709V = iArr;
                        }
                        iArr[i3] = i4;
                        i3++;
                        i4 = 0;
                        i6 = 0;
                    }
                    if (i5 < 2048) {
                        i7 = i4 << 8;
                        i8 = (i5 >> 6) | 192;
                    } else {
                        int i10 = (i4 << 8) | (i5 >> 12) | 224;
                        i6++;
                        if (i6 >= 4) {
                            if (i3 >= iArr.length) {
                                iArr = AbstractC0570b.m1249P0(iArr, iArr.length);
                                this.f1709V = iArr;
                            }
                            iArr[i3] = i10;
                            i3++;
                            i6 = 0;
                        } else {
                            i9 = i10;
                        }
                        i7 = i9 << 8;
                        i8 = ((i5 >> 6) & 63) | 128;
                    }
                    i4 = i7 | i8;
                    i6++;
                    i5 = (i5 & 63) | 128;
                }
            }
            if (i6 < 4) {
                i6++;
                i4 = (i4 << 8) | i5;
            } else {
                if (i3 >= iArr.length) {
                    iArr = AbstractC0570b.m1249P0(iArr, iArr.length);
                    this.f1709V = iArr;
                }
                iArr[i3] = i4;
                i4 = i5;
                i3++;
                i6 = 1;
            }
            if (this.f1407t >= this.f1408u && !m1563h1()) {
                EnumC0548p enumC0548p = EnumC0548p.NOT_AVAILABLE;
                m1281k0(" in field name");
                throw null;
            }
            byte[] bArr = this.f1715b0;
            int i11 = this.f1407t;
            this.f1407t = i11 + 1;
            i5 = bArr[i11] & 255;
        }
    }

    /* JADX INFO: renamed from: a1 */
    public final int m1555a1(int i3) throws C0542j {
        int i4 = i3 & 15;
        byte[] bArr = this.f1715b0;
        int i5 = this.f1407t;
        int i6 = i5 + 1;
        this.f1407t = i6;
        byte b3 = bArr[i5];
        if ((b3 & 192) != 128) {
            m1524B1(b3 & 255, i6);
            throw null;
        }
        int i7 = (i4 << 6) | (b3 & 63);
        int i8 = i5 + 2;
        this.f1407t = i8;
        byte b4 = bArr[i6];
        if ((b4 & 192) == 128) {
            return (i7 << 6) | (b4 & 63);
        }
        m1524B1(b4 & 255, i8);
        throw null;
    }

    /* JADX INFO: renamed from: a2 */
    public final String m1556a2(int i3, int i4, int i5, int i6, int i7) {
        int[] iArr = this.f1709V;
        iArr[0] = i3;
        iArr[1] = i4;
        return m1554Z1(2, i5, i6, i7, iArr);
    }

    /* JADX INFO: renamed from: b1 */
    public final int m1557b1(int i3) throws C0542j {
        if (this.f1407t >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr = this.f1715b0;
        int i4 = this.f1407t;
        int i5 = i4 + 1;
        this.f1407t = i5;
        byte b3 = bArr[i4];
        if ((b3 & 192) != 128) {
            m1524B1(b3 & 255, i5);
            throw null;
        }
        int i6 = ((i3 & 7) << 6) | (b3 & 63);
        if (i5 >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr2 = this.f1715b0;
        int i7 = this.f1407t;
        int i8 = i7 + 1;
        this.f1407t = i8;
        byte b4 = bArr2[i7];
        if ((b4 & 192) != 128) {
            m1524B1(b4 & 255, i8);
            throw null;
        }
        int i9 = (i6 << 6) | (b4 & 63);
        if (i8 >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr3 = this.f1715b0;
        int i10 = this.f1407t;
        int i11 = i10 + 1;
        this.f1407t = i11;
        byte b5 = bArr3[i10];
        if ((b5 & 192) == 128) {
            return ((i9 << 6) | (b5 & 63)) - 65536;
        }
        m1524B1(b5 & 255, i11);
        throw null;
    }

    /* JADX INFO: renamed from: c1 */
    public final String m1558c1() throws C1131b, C0542j {
        int i3 = this.f1407t;
        if (i3 >= this.f1408u) {
            m1564i1();
            i3 = this.f1407t;
        }
        C0688o c0688o = this.f1389D;
        char[] cArrM1656i = c0688o.m1656i();
        int iMin = Math.min(this.f1408u, cArrM1656i.length + i3);
        byte[] bArr = this.f1715b0;
        int i4 = 0;
        while (true) {
            if (i3 >= iMin) {
                break;
            }
            int i5 = bArr[i3] & 255;
            if (f1705l0[i5] == 0) {
                i3++;
                cArrM1656i[i4] = (char) i5;
                i4++;
            } else if (i5 == 34) {
                this.f1407t = i3 + 1;
                c0688o.f1877i = i4;
                if (c0688o.f1875g > 0) {
                    return c0688o.m1655h();
                }
                c0688o.mo1647s(i4);
                String str = i4 == 0 ? "" : new String(c0688o.f1876h, 0, i4);
                c0688o.f1878j = str;
                return str;
            }
        }
        this.f1407t = i3;
        m1560e1(cArrM1656i, i4);
        return c0688o.m1655h();
    }

    /* JADX INFO: renamed from: d1 */
    public final void m1559d1() throws C0542j {
        int i3 = this.f1407t;
        if (i3 >= this.f1408u) {
            m1564i1();
            i3 = this.f1407t;
        }
        C0688o c0688o = this.f1389D;
        char[] cArrM1656i = c0688o.m1656i();
        int iMin = Math.min(this.f1408u, cArrM1656i.length + i3);
        byte[] bArr = this.f1715b0;
        int i4 = 0;
        while (true) {
            if (i3 >= iMin) {
                break;
            }
            int i5 = bArr[i3] & 255;
            if (f1705l0[i5] == 0) {
                i3++;
                cArrM1656i[i4] = (char) i5;
                i4++;
            } else if (i5 == 34) {
                this.f1407t = i3 + 1;
                c0688o.f1877i = i4;
                return;
            }
        }
        this.f1407t = i3;
        m1560e1(cArrM1656i, i4);
    }

    /* JADX INFO: renamed from: e1 */
    public final void m1560e1(char[] cArr, int i3) throws C0542j {
        byte[] bArr = this.f1715b0;
        while (true) {
            int i4 = this.f1407t;
            if (i4 >= this.f1408u) {
                m1564i1();
                i4 = this.f1407t;
            }
            int length = cArr.length;
            int i5 = 0;
            C0688o c0688o = this.f1389D;
            if (i3 >= length) {
                cArr = c0688o.m1658k();
                i3 = 0;
            }
            int iMin = Math.min(this.f1408u, (cArr.length - i3) + i4);
            while (true) {
                if (i4 >= iMin) {
                    this.f1407t = i4;
                    break;
                }
                int i6 = i4 + 1;
                int iMo1275z0 = bArr[i4] & 255;
                int i7 = f1705l0[iMo1275z0];
                if (i7 != 0) {
                    this.f1407t = i6;
                    if (iMo1275z0 == 34) {
                        c0688o.f1877i = i3;
                        return;
                    }
                    if (i7 == 1) {
                        iMo1275z0 = mo1275z0();
                    } else if (i7 == 2) {
                        iMo1275z0 = m1551Y0(iMo1275z0);
                    } else if (i7 == 3) {
                        iMo1275z0 = this.f1408u - i6 >= 2 ? m1555a1(iMo1275z0) : m1553Z0(iMo1275z0);
                    } else if (i7 == 4) {
                        int iM1557b1 = m1557b1(iMo1275z0);
                        int i8 = i3 + 1;
                        cArr[i3] = (char) ((iM1557b1 >> 10) | 55296);
                        if (i8 >= cArr.length) {
                            cArr = c0688o.m1658k();
                            i3 = 0;
                        } else {
                            i3 = i8;
                        }
                        iMo1275z0 = (iM1557b1 & 1023) | 56320;
                    } else {
                        if (iMo1275z0 >= 32) {
                            m1579y1(iMo1275z0);
                            throw null;
                        }
                        m1261K0(iMo1275z0, "string value");
                    }
                    if (i3 >= cArr.length) {
                        cArr = c0688o.m1658k();
                    } else {
                        i5 = i3;
                    }
                    i3 = i5 + 1;
                    cArr[i5] = (char) iMo1275z0;
                } else {
                    cArr[i3] = (char) iMo1275z0;
                    i4 = i6;
                    i3++;
                }
            }
        }
    }

    /* JADX INFO: renamed from: f1 */
    public final EnumC0548p m1561f1(int i3, boolean z3, boolean z4) throws C0542j {
        String str;
        if (i3 == 73) {
            if (this.f1407t >= this.f1408u && !m1563h1()) {
                m1282l0(EnumC0548p.VALUE_NUMBER_FLOAT);
                throw null;
            }
            byte[] bArr = this.f1715b0;
            int i4 = this.f1407t;
            this.f1407t = i4 + 1;
            i3 = bArr[i4];
            if (i3 == 78) {
                str = z3 ? "-INF" : "+INF";
            } else if (i3 == 110) {
                str = z3 ? "-Infinity" : "+Infinity";
            }
            m1567l1(3, str);
            if ((this.f1306e & f1699f0) != 0) {
                return m1266R0(str, z3 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            throw new C0542j(this, AbstractC0032g.m154l("Non-standard token '", str, "': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow"));
        }
        if (EnumC0639d.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.f1657f.m1155a(this.f1306e) || z3) {
            m1284n0(i3, z3 ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value");
            throw null;
        }
        m1284n0(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        if (r13 != 44) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        if (r12.f1387B.m1216d() == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
    
        if (r12.f1387B.m1218f() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
    
        if ((r12.f1306e & p058T0.C0643h.f1700g0) == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
    
        r12.f1407t--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
    
        return p042N0.EnumC0548p.VALUE_NULL;
     */
    /* JADX INFO: renamed from: g1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p042N0.EnumC0548p m1562g1(int r13) throws p042N0.C0542j {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0643h.m1562g1(int):N0.p");
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: h */
    public final byte[] mo1193h(C0533a c0533a) throws C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p != EnumC0548p.VALUE_STRING && (enumC0548p != EnumC0548p.VALUE_EMBEDDED_OBJECT || this.f1393H == null)) {
            m1279i0("Current token (" + this.f1423g + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
            throw null;
        }
        if (this.f1710W) {
            try {
                this.f1393H = m1547W0(c0533a);
                this.f1710W = false;
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

    /* JADX INFO: renamed from: h1 */
    public final boolean m1563h1() throws IOException {
        byte[] bArr;
        int length;
        InputStream inputStream = this.f1714a0;
        if (inputStream == null || (length = (bArr = this.f1715b0).length) == 0) {
            return false;
        }
        int i3 = inputStream.read(bArr, 0, length);
        if (i3 > 0) {
            int i4 = this.f1408u;
            this.f1409v += (long) i4;
            this.f1411x -= i4;
            this.f1711X -= i4;
            this.f1407t = 0;
            this.f1408u = i3;
            return true;
        }
        mo1271v0();
        if (i3 == 0) {
            throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.f1715b0.length + " bytes");
        }
        return false;
    }

    /* JADX INFO: renamed from: i1 */
    public final void m1564i1() throws C0591d {
        if (m1563h1()) {
            return;
        }
        m1280j0();
        throw null;
    }

    /* JADX INFO: renamed from: j1 */
    public final void m1565j1() throws C0542j {
        int i3;
        int i4 = this.f1407t;
        if (i4 + 4 < this.f1408u) {
            byte[] bArr = this.f1715b0;
            int i5 = i4 + 1;
            if (bArr[i4] == 97) {
                int i6 = i4 + 2;
                if (bArr[i5] == 108) {
                    int i7 = i4 + 3;
                    if (bArr[i6] == 115) {
                        int i8 = i4 + 4;
                        if (bArr[i7] == 101 && ((i3 = bArr[i8] & 255) < 48 || i3 == 93 || i3 == 125)) {
                            this.f1407t = i8;
                            return;
                        }
                    }
                }
            }
        }
        m1568m1(1, "false");
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: k */
    public final AbstractC0549q mo1196k() {
        return this.f1707T;
    }

    /* JADX INFO: renamed from: k1 */
    public final void m1566k1() throws C0542j {
        int i3;
        int i4 = this.f1407t;
        if (i4 + 3 < this.f1408u) {
            byte[] bArr = this.f1715b0;
            int i5 = i4 + 1;
            if (bArr[i4] == 117) {
                int i6 = i4 + 2;
                if (bArr[i5] == 108) {
                    int i7 = i4 + 3;
                    if (bArr[i6] == 108 && ((i3 = bArr[i7] & 255) < 48 || i3 == 93 || i3 == 125)) {
                        this.f1407t = i7;
                        return;
                    }
                }
            }
        }
        m1568m1(1, "null");
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: l */
    public final C0541i mo1197l() {
        return new C0541i(m1272w0(), this.f1409v + ((long) this.f1407t), -1L, this.f1410w, (this.f1407t - this.f1411x) + 1);
    }

    /* JADX INFO: renamed from: l1 */
    public final void m1567l1(int i3, String str) throws C0542j {
        int length = str.length();
        if (this.f1407t + length >= this.f1408u) {
            m1568m1(i3, str);
            return;
        }
        while (this.f1715b0[this.f1407t] == str.charAt(i3)) {
            int i4 = this.f1407t + 1;
            this.f1407t = i4;
            i3++;
            if (i3 >= length) {
                int i5 = this.f1715b0[i4] & 255;
                if (i5 < 48 || i5 == 93 || i5 == 125 || !Character.isJavaIdentifierPart((char) m1549X0(i5))) {
                    return;
                }
                m1525C1(str.substring(0, i3), m1262L0());
                throw null;
            }
        }
        m1525C1(str.substring(0, i3), m1262L0());
        throw null;
    }

    /* JADX INFO: renamed from: m1 */
    public final void m1568m1(int i3, String str) throws C0542j {
        int i4;
        int i5;
        int length = str.length();
        do {
            if ((this.f1407t >= this.f1408u && !m1563h1()) || this.f1715b0[this.f1407t] != str.charAt(i3)) {
                m1525C1(str.substring(0, i3), m1262L0());
                throw null;
            }
            i4 = this.f1407t + 1;
            this.f1407t = i4;
            i3++;
        } while (i3 < length);
        if ((i4 < this.f1408u || m1563h1()) && (i5 = this.f1715b0[this.f1407t] & 255) >= 48 && i5 != 93 && i5 != 125 && Character.isJavaIdentifierPart((char) m1549X0(i5))) {
            m1525C1(str.substring(0, i3), m1262L0());
            throw null;
        }
    }

    /* JADX INFO: renamed from: n1 */
    public final void m1569n1() throws C0542j {
        int i3;
        int i4 = this.f1407t;
        if (i4 + 3 < this.f1408u) {
            byte[] bArr = this.f1715b0;
            int i5 = i4 + 1;
            if (bArr[i4] == 114) {
                int i6 = i4 + 2;
                if (bArr[i5] == 117) {
                    int i7 = i4 + 3;
                    if (bArr[i6] == 101 && ((i3 = bArr[i7] & 255) < 48 || i3 == 93 || i3 == 125)) {
                        this.f1407t = i7;
                        return;
                    }
                }
            }
        }
        m1568m1(1, "true");
    }

    /* JADX INFO: renamed from: o1 */
    public final EnumC0548p m1570o1() {
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

    @Override // p045O0.AbstractC0571c
    /* JADX INFO: renamed from: p0 */
    public final int mo1286p0() throws C1130a, C0542j {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p != EnumC0548p.VALUE_NUMBER_INT && enumC0548p != EnumC0548p.VALUE_NUMBER_FLOAT) {
            return super.mo1286p0();
        }
        int i3 = this.f1394I;
        int i4 = i3 & 1;
        if (i4 == 0) {
            if (i3 == 0) {
                return m1257G0();
            }
            if (i4 == 0) {
                m1263M0();
            }
        }
        return this.f1395J;
    }

    /* JADX INFO: renamed from: p1 */
    public final EnumC0548p m1571p1(int i3) throws C0542j {
        if (i3 == 34) {
            this.f1710W = true;
            EnumC0548p enumC0548p = EnumC0548p.VALUE_STRING;
            this.f1423g = enumC0548p;
            return enumC0548p;
        }
        if (i3 == 43) {
            if (EnumC0639d.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.f1657f.m1155a(this.f1306e)) {
                EnumC0548p enumC0548pM1576v1 = m1576v1(false);
                this.f1423g = enumC0548pM1576v1;
                return enumC0548pM1576v1;
            }
            EnumC0548p enumC0548pM1562g1 = m1562g1(i3);
            this.f1423g = enumC0548pM1562g1;
            return enumC0548pM1562g1;
        }
        if (i3 == 91) {
            m1264N0(this.f1413z, this.f1386A);
            EnumC0548p enumC0548p2 = EnumC0548p.START_ARRAY;
            this.f1423g = enumC0548p2;
            return enumC0548p2;
        }
        if (i3 == 102) {
            m1565j1();
            EnumC0548p enumC0548p3 = EnumC0548p.VALUE_FALSE;
            this.f1423g = enumC0548p3;
            return enumC0548p3;
        }
        if (i3 == 110) {
            m1566k1();
            EnumC0548p enumC0548p4 = EnumC0548p.VALUE_NULL;
            this.f1423g = enumC0548p4;
            return enumC0548p4;
        }
        if (i3 == 116) {
            m1569n1();
            EnumC0548p enumC0548p5 = EnumC0548p.VALUE_TRUE;
            this.f1423g = enumC0548p5;
            return enumC0548p5;
        }
        if (i3 == 123) {
            m1265O0(this.f1413z, this.f1386A);
            EnumC0548p enumC0548p6 = EnumC0548p.START_OBJECT;
            this.f1423g = enumC0548p6;
            return enumC0548p6;
        }
        if (i3 == 45) {
            EnumC0548p enumC0548pM1576v12 = m1576v1(true);
            this.f1423g = enumC0548pM1576v12;
            return enumC0548pM1576v12;
        }
        if (i3 == 46) {
            EnumC0548p enumC0548pM1573s1 = m1573s1(false);
            this.f1423g = enumC0548pM1573s1;
            return enumC0548pM1573s1;
        }
        switch (i3) {
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
                EnumC0548p enumC0548pM1577w1 = m1577w1(i3);
                this.f1423g = enumC0548pM1577w1;
                return enumC0548pM1577w1;
            default:
                EnumC0548p enumC0548pM1562g12 = m1562g1(i3);
                this.f1423g = enumC0548pM1562g12;
                return enumC0548pM1562g12;
        }
    }

    @Override // p045O0.AbstractC0571c
    /* JADX INFO: renamed from: q0 */
    public final String mo1287q0() {
        EnumC0548p enumC0548p = this.f1423g;
        if (enumC0548p != EnumC0548p.VALUE_STRING) {
            return enumC0548p == EnumC0548p.FIELD_NAME ? mo1198m() : super.mo1287q0();
        }
        if (!this.f1710W) {
            return this.f1389D.m1655h();
        }
        this.f1710W = false;
        return m1558c1();
    }

    /* JADX INFO: renamed from: r1 */
    public final EnumC0548p m1572r1(char[] cArr, int i3, int i4, boolean z3, int i5) throws C0542j {
        char[] cArrM1658k;
        int i6;
        int i7;
        boolean z4;
        int i8 = i4;
        C0688o c0688o = this.f1389D;
        int i9 = 0;
        if (i8 == 46) {
            cArrM1658k = cArr;
            int i10 = i3;
            if (i10 >= cArrM1658k.length) {
                cArrM1658k = c0688o.m1658k();
                i10 = 0;
            }
            int i11 = i10 + 1;
            cArrM1658k[i10] = (char) i8;
            int i12 = 0;
            while (true) {
                if (this.f1407t >= this.f1408u && !m1563h1()) {
                    z4 = true;
                    break;
                }
                byte[] bArr = this.f1715b0;
                int i13 = this.f1407t;
                this.f1407t = i13 + 1;
                i8 = bArr[i13] & 255;
                if (i8 < 48 || i8 > 57) {
                    break;
                }
                i12++;
                if (i11 >= cArrM1658k.length) {
                    cArrM1658k = c0688o.m1658k();
                    i11 = 0;
                }
                cArrM1658k[i11] = (char) i8;
                i11++;
            }
            z4 = false;
            if (i12 == 0 && !EnumC0639d.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.f1657f.m1155a(this.f1306e)) {
                m1284n0(i8, "Decimal point not followed by a digit");
                throw null;
            }
            int i14 = i12;
            i6 = i11;
            i7 = i14;
        } else {
            cArrM1658k = cArr;
            i6 = i3;
            i7 = 0;
            z4 = false;
        }
        if (i8 == 101 || i8 == 69) {
            if (i6 >= cArrM1658k.length) {
                cArrM1658k = c0688o.m1658k();
                i6 = 0;
            }
            int i15 = i6 + 1;
            cArrM1658k[i6] = (char) i8;
            if (this.f1407t >= this.f1408u) {
                m1564i1();
            }
            byte[] bArr2 = this.f1715b0;
            int i16 = this.f1407t;
            this.f1407t = i16 + 1;
            i8 = bArr2[i16] & 255;
            if (i8 == 45 || i8 == 43) {
                if (i15 >= cArrM1658k.length) {
                    cArrM1658k = c0688o.m1658k();
                    i15 = 0;
                }
                int i17 = i15 + 1;
                cArrM1658k[i15] = (char) i8;
                if (this.f1407t >= this.f1408u) {
                    m1564i1();
                }
                byte[] bArr3 = this.f1715b0;
                int i18 = this.f1407t;
                this.f1407t = i18 + 1;
                i8 = bArr3[i18] & 255;
                i15 = i17;
            }
            int i19 = 0;
            while (i8 >= 48 && i8 <= 57) {
                i19++;
                if (i15 >= cArrM1658k.length) {
                    cArrM1658k = c0688o.m1658k();
                    i15 = 0;
                }
                int i20 = i15 + 1;
                cArrM1658k[i15] = (char) i8;
                if (this.f1407t >= this.f1408u && !m1563h1()) {
                    z4 = true;
                    i9 = i19;
                    i6 = i20;
                    break;
                }
                byte[] bArr4 = this.f1715b0;
                int i21 = this.f1407t;
                this.f1407t = i21 + 1;
                i8 = bArr4[i21] & 255;
                i15 = i20;
            }
            i9 = i19;
            i6 = i15;
            if (i9 == 0) {
                m1284n0(i8, "Exponent indicator not followed by a digit");
                throw null;
            }
        }
        if (!z4) {
            this.f1407t--;
            if (this.f1387B.m1218f()) {
                m1541S1(i8);
            }
        }
        c0688o.f1877i = i6;
        return m1267S0(z3, i5, i7, i9);
    }

    /* JADX INFO: renamed from: s1 */
    public final EnumC0548p m1573s1(boolean z3) {
        if (!EnumC0639d.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.f1657f.m1155a(this.f1306e)) {
            return m1562g1(46);
        }
        char[] cArrM1656i = this.f1389D.m1656i();
        int i3 = 0;
        if (z3) {
            cArrM1656i[0] = '-';
            i3 = 1;
        }
        return m1572r1(cArrM1656i, i3, 46, z3, 0);
    }

    /* JADX INFO: renamed from: t1 */
    public final String m1574t1(int i3) throws C0542j {
        String strM1614m;
        int i4 = i3;
        int[] iArr = f1706m0;
        int i5 = 0;
        if (i4 != 34) {
            C0655b c0655b = this.f1708U;
            if (i4 != 39 || (this.f1306e & f1701h0) == 0) {
                if ((this.f1306e & f1702i0) == 0) {
                    m1283m0((char) m1549X0(i3), "was expecting double-quote to start field name");
                    throw null;
                }
                int[] iArr2 = AbstractC0589b.f1507h;
                if (iArr2[i4] != 0) {
                    m1283m0(i4, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
                    throw null;
                }
                int[] iArrM1249P0 = this.f1709V;
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    if (i5 < 4) {
                        i5++;
                        i7 = i4 | (i7 << 8);
                    } else {
                        if (i6 >= iArrM1249P0.length) {
                            iArrM1249P0 = AbstractC0570b.m1249P0(iArrM1249P0, iArrM1249P0.length);
                            this.f1709V = iArrM1249P0;
                        }
                        iArrM1249P0[i6] = i7;
                        i7 = i4;
                        i6++;
                        i5 = 1;
                    }
                    if (this.f1407t >= this.f1408u && !m1563h1()) {
                        EnumC0548p enumC0548p = EnumC0548p.NOT_AVAILABLE;
                        m1281k0(" in field name");
                        throw null;
                    }
                    byte[] bArr = this.f1715b0;
                    int i8 = this.f1407t;
                    i4 = bArr[i8] & 255;
                    if (iArr2[i4] != 0) {
                        if (i5 > 0) {
                            if (i6 >= iArrM1249P0.length) {
                                iArrM1249P0 = AbstractC0570b.m1249P0(iArrM1249P0, iArrM1249P0.length);
                                this.f1709V = iArrM1249P0;
                            }
                            iArrM1249P0[i6] = i7;
                            i6++;
                        }
                        strM1614m = c0655b.m1614m(iArrM1249P0, i6);
                        if (strM1614m == null) {
                            strM1614m = m1542T1(i6, i5, iArrM1249P0);
                        }
                    } else {
                        this.f1407t = i8 + 1;
                    }
                }
            } else {
                if (this.f1407t >= this.f1408u && !m1563h1()) {
                    EnumC0548p enumC0548p2 = EnumC0548p.NOT_AVAILABLE;
                    m1281k0(": was expecting closing ''' for field name");
                    throw null;
                }
                byte[] bArr2 = this.f1715b0;
                int i9 = this.f1407t;
                this.f1407t = i9 + 1;
                int iMo1275z0 = bArr2[i9] & 255;
                if (iMo1275z0 == 39) {
                    return "";
                }
                int[] iArrM1249P02 = this.f1709V;
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 39; iMo1275z0 != i13; i13 = 39) {
                    if (iArr[iMo1275z0] != 0 && iMo1275z0 != 34) {
                        if (iMo1275z0 != 92) {
                            m1261K0(iMo1275z0, "name");
                        } else {
                            iMo1275z0 = mo1275z0();
                        }
                        if (iMo1275z0 > 127) {
                            if (i10 >= 4) {
                                if (i11 >= iArrM1249P02.length) {
                                    iArrM1249P02 = AbstractC0570b.m1249P0(iArrM1249P02, iArrM1249P02.length);
                                    this.f1709V = iArrM1249P02;
                                }
                                iArrM1249P02[i11] = i12;
                                i12 = 0;
                                i11++;
                                i10 = 0;
                            }
                            if (iMo1275z0 < 2048) {
                                i12 = (i12 << 8) | (iMo1275z0 >> 6) | 192;
                                i10++;
                            } else {
                                int i14 = (i12 << 8) | (iMo1275z0 >> 12) | 224;
                                int i15 = i10 + 1;
                                if (i15 >= 4) {
                                    if (i11 >= iArrM1249P02.length) {
                                        iArrM1249P02 = AbstractC0570b.m1249P0(iArrM1249P02, iArrM1249P02.length);
                                        this.f1709V = iArrM1249P02;
                                    }
                                    iArrM1249P02[i11] = i14;
                                    i14 = 0;
                                    i11++;
                                    i15 = 0;
                                }
                                i12 = (i14 << 8) | ((iMo1275z0 >> 6) & 63) | 128;
                                i10 = i15 + 1;
                            }
                            iMo1275z0 = (iMo1275z0 & 63) | 128;
                        }
                    }
                    if (i10 < 4) {
                        i10++;
                        i12 = iMo1275z0 | (i12 << 8);
                    } else {
                        if (i11 >= iArrM1249P02.length) {
                            iArrM1249P02 = AbstractC0570b.m1249P0(iArrM1249P02, iArrM1249P02.length);
                            this.f1709V = iArrM1249P02;
                        }
                        iArrM1249P02[i11] = i12;
                        i12 = iMo1275z0;
                        i11++;
                        i10 = 1;
                    }
                    if (this.f1407t >= this.f1408u && !m1563h1()) {
                        EnumC0548p enumC0548p3 = EnumC0548p.NOT_AVAILABLE;
                        m1281k0(" in field name");
                        throw null;
                    }
                    byte[] bArr3 = this.f1715b0;
                    int i16 = this.f1407t;
                    this.f1407t = i16 + 1;
                    iMo1275z0 = bArr3[i16] & 255;
                }
                if (i10 > 0) {
                    if (i11 >= iArrM1249P02.length) {
                        iArrM1249P02 = AbstractC0570b.m1249P0(iArrM1249P02, iArrM1249P02.length);
                        this.f1709V = iArrM1249P02;
                    }
                    iArrM1249P02[i11] = m1522q1(i12, i10);
                    i11++;
                }
                strM1614m = c0655b.m1614m(iArrM1249P02, i11);
                if (strM1614m == null) {
                    strM1614m = m1542T1(i11, i10, iArrM1249P02);
                }
            }
            return strM1614m;
        }
        int i17 = this.f1407t;
        int i18 = i17 + 13;
        int i19 = this.f1408u;
        if (i18 > i19) {
            if (i17 >= i19 && !m1563h1()) {
                EnumC0548p enumC0548p4 = EnumC0548p.NOT_AVAILABLE;
                m1281k0(": was expecting closing '\"' for name");
                throw null;
            }
            byte[] bArr4 = this.f1715b0;
            int i20 = this.f1407t;
            this.f1407t = i20 + 1;
            int i21 = bArr4[i20] & 255;
            return i21 == 34 ? "" : m1554Z1(0, 0, i21, 0, this.f1709V);
        }
        byte[] bArr5 = this.f1715b0;
        int i22 = i17 + 1;
        this.f1407t = i22;
        int i23 = bArr5[i17] & 255;
        if (iArr[i23] != 0) {
            return i23 == 34 ? "" : m1554Z1(0, 0, i23, 0, this.f1709V);
        }
        int i24 = i17 + 2;
        this.f1407t = i24;
        int i25 = bArr5[i22] & 255;
        if (iArr[i25] != 0) {
            return i25 == 34 ? m1544U1(i23, 1) : m1554Z1(0, i23, i25, 1, this.f1709V);
        }
        int i26 = i25 | (i23 << 8);
        int i27 = i17 + 3;
        this.f1407t = i27;
        int i28 = bArr5[i24] & 255;
        if (iArr[i28] != 0) {
            return i28 == 34 ? m1544U1(i26, 2) : m1554Z1(0, i26, i28, 2, this.f1709V);
        }
        int i29 = i28 | (i26 << 8);
        int i30 = i17 + 4;
        this.f1407t = i30;
        int i31 = bArr5[i27] & 255;
        if (iArr[i31] != 0) {
            return i31 == 34 ? m1544U1(i29, 3) : m1554Z1(0, i29, i31, 3, this.f1709V);
        }
        int i32 = (i29 << 8) | i31;
        int i33 = i17 + 5;
        this.f1407t = i33;
        int i34 = bArr5[i30] & 255;
        if (iArr[i34] != 0) {
            return i34 == 34 ? m1544U1(i32, 4) : m1554Z1(0, i32, i34, 4, this.f1709V);
        }
        int i35 = i17 + 6;
        this.f1407t = i35;
        int i36 = bArr5[i33] & 255;
        if (iArr[i36] != 0) {
            if (i36 == 34) {
                return m1546V1(i32, i34, 1);
            }
            int[] iArr3 = this.f1709V;
            iArr3[0] = i32;
            return m1554Z1(1, i34, i36, 1, iArr3);
        }
        int i37 = (i34 << 8) | i36;
        int i38 = i17 + 7;
        this.f1407t = i38;
        int i39 = bArr5[i35] & 255;
        if (iArr[i39] != 0) {
            if (i39 == 34) {
                return m1546V1(i32, i37, 2);
            }
            int[] iArr4 = this.f1709V;
            iArr4[0] = i32;
            return m1554Z1(1, i37, i39, 2, iArr4);
        }
        int i40 = (i37 << 8) | i39;
        int i41 = i17 + 8;
        this.f1407t = i41;
        int i42 = bArr5[i38] & 255;
        if (iArr[i42] != 0) {
            if (i42 == 34) {
                return m1546V1(i32, i40, 3);
            }
            int[] iArr5 = this.f1709V;
            iArr5[0] = i32;
            return m1554Z1(1, i40, i42, 3, iArr5);
        }
        int i43 = (i40 << 8) | i42;
        int i44 = i17 + 9;
        this.f1407t = i44;
        int i45 = bArr5[i41] & 255;
        if (iArr[i45] != 0) {
            if (i45 == 34) {
                return m1546V1(i32, i43, 4);
            }
            int[] iArr6 = this.f1709V;
            iArr6[0] = i32;
            return m1554Z1(1, i43, i45, 4, iArr6);
        }
        int i46 = i17 + 10;
        this.f1407t = i46;
        int i47 = bArr5[i44] & 255;
        if (iArr[i47] != 0) {
            return i47 == 34 ? m1548W1(i32, i43, i45, 1) : m1556a2(i32, i43, i45, i47, 1);
        }
        int i48 = i47 | (i45 << 8);
        int i49 = i17 + 11;
        this.f1407t = i49;
        int i50 = bArr5[i46] & 255;
        if (iArr[i50] != 0) {
            return i50 == 34 ? m1548W1(i32, i43, i48, 2) : m1556a2(i32, i43, i48, i50, 2);
        }
        int i51 = (i48 << 8) | i50;
        int i52 = i17 + 12;
        this.f1407t = i52;
        int i53 = bArr5[i49] & 255;
        if (iArr[i53] != 0) {
            return i53 == 34 ? m1548W1(i32, i43, i51, 3) : m1556a2(i32, i43, i51, i53, 3);
        }
        int i54 = (i51 << 8) | i53;
        this.f1407t = i18;
        int i55 = bArr5[i52] & 255;
        if (iArr[i55] != 0) {
            return i55 == 34 ? m1548W1(i32, i43, i54, 4) : m1556a2(i32, i43, i54, i55, 4);
        }
        int[] iArr7 = this.f1709V;
        iArr7[0] = i32;
        iArr7[1] = i43;
        iArr7[2] = i54;
        int i56 = 3;
        while (true) {
            int i57 = this.f1407t;
            int i58 = i57 + 4;
            if (i58 > this.f1408u) {
                return m1554Z1(i56, 0, i55, 0, this.f1709V);
            }
            int i59 = i57 + 1;
            this.f1407t = i59;
            int i60 = bArr5[i57] & 255;
            if (iArr[i60] != 0) {
                if (i60 == 34) {
                    return m1550X1(i56, i55, 1, this.f1709V);
                }
                return m1554Z1(i56, i55, i60, 1, this.f1709V);
            }
            int i61 = (i55 << 8) | i60;
            int i62 = i57 + 2;
            this.f1407t = i62;
            int i63 = bArr5[i59] & 255;
            if (iArr[i63] != 0) {
                if (i63 == 34) {
                    return m1550X1(i56, i61, 2, this.f1709V);
                }
                return m1554Z1(i56, i61, i63, 2, this.f1709V);
            }
            int i64 = (i61 << 8) | i63;
            int i65 = i57 + 3;
            this.f1407t = i65;
            int i66 = bArr5[i62] & 255;
            if (iArr[i66] != 0) {
                if (i66 == 34) {
                    return m1550X1(i56, i64, 3, this.f1709V);
                }
                return m1554Z1(i56, i64, i66, 3, this.f1709V);
            }
            int i67 = (i64 << 8) | i66;
            this.f1407t = i58;
            int i68 = bArr5[i65] & 255;
            if (iArr[i68] != 0) {
                if (i68 == 34) {
                    return m1550X1(i56, i67, 4, this.f1709V);
                }
                return m1554Z1(i56, i67, i68, 4, this.f1709V);
            }
            int[] iArr8 = this.f1709V;
            if (i56 >= iArr8.length) {
                this.f1709V = AbstractC0570b.m1249P0(iArr8, i56);
            }
            this.f1709V[i56] = i67;
            i55 = i68;
            i56++;
        }
    }

    /* JADX INFO: renamed from: u1 */
    public final EnumC0548p m1575u1(char[] cArr, int i3, boolean z3, int i4) throws C0542j {
        C0688o c0688o;
        int i5;
        int i6;
        char[] cArrM1658k = cArr;
        int i7 = i3;
        int i8 = i4;
        while (true) {
            int i9 = this.f1407t;
            int i10 = this.f1408u;
            c0688o = this.f1389D;
            if (i9 >= i10 && !m1563h1()) {
                c0688o.f1877i = i7;
                return m1268T0(i8, z3);
            }
            byte[] bArr = this.f1715b0;
            i5 = this.f1407t;
            this.f1407t = i5 + 1;
            i6 = bArr[i5] & 255;
            if (i6 > 57 || i6 < 48) {
                break;
            }
            if (i7 >= cArrM1658k.length) {
                i7 = 0;
                cArrM1658k = c0688o.m1658k();
            }
            cArrM1658k[i7] = (char) i6;
            i8++;
            i7++;
        }
        if (i6 == 46 || i6 == 101 || i6 == 69) {
            return m1572r1(cArrM1658k, i7, i6, z3, i8);
        }
        this.f1407t = i5;
        c0688o.f1877i = i7;
        if (this.f1387B.m1218f()) {
            m1541S1(this.f1715b0[this.f1407t] & 255);
        }
        return m1268T0(i8, z3);
    }

    @Override // p045O0.AbstractC0570b
    /* JADX INFO: renamed from: v0 */
    public final void mo1271v0() throws IOException {
        if (this.f1714a0 != null) {
            if (this.f1404q.f755a || EnumC0543k.AUTO_CLOSE_SOURCE.m1155a(this.f1306e)) {
                this.f1714a0.close();
            }
            this.f1714a0 = null;
        }
    }

    /* JADX INFO: renamed from: v1 */
    public final EnumC0548p m1576v1(boolean z3) throws C0542j {
        int i3;
        int i4;
        C0688o c0688o = this.f1389D;
        char[] cArrM1656i = c0688o.m1656i();
        int i5 = 0;
        if (z3) {
            cArrM1656i[0] = '-';
            i5 = 1;
        }
        if (this.f1407t >= this.f1408u) {
            m1564i1();
        }
        byte[] bArr = this.f1715b0;
        int i6 = this.f1407t;
        this.f1407t = i6 + 1;
        int iM1540R1 = bArr[i6] & 255;
        if (iM1540R1 <= 48) {
            if (iM1540R1 != 48) {
                return iM1540R1 == 46 ? m1573s1(z3) : m1561f1(iM1540R1, z3, true);
            }
            iM1540R1 = m1540R1();
        } else if (iM1540R1 > 57) {
            return m1561f1(iM1540R1, z3, true);
        }
        int i7 = i5 + 1;
        cArrM1656i[i5] = (char) iM1540R1;
        int iMin = Math.min(this.f1408u, (this.f1407t + cArrM1656i.length) - i7);
        int i8 = 1;
        while (true) {
            i3 = this.f1407t;
            if (i3 >= iMin) {
                return m1575u1(cArrM1656i, i7, z3, i8);
            }
            byte[] bArr2 = this.f1715b0;
            this.f1407t = i3 + 1;
            i4 = bArr2[i3] & 255;
            if (i4 < 48 || i4 > 57) {
                break;
            }
            i8++;
            cArrM1656i[i7] = (char) i4;
            i7++;
        }
        if (i4 == 46 || i4 == 101 || i4 == 69) {
            return m1572r1(cArrM1656i, i7, i4, z3, i8);
        }
        this.f1407t = i3;
        c0688o.f1877i = i7;
        if (this.f1387B.m1218f()) {
            m1541S1(i4);
        }
        return m1268T0(i8, z3);
    }

    /* JADX INFO: renamed from: w1 */
    public final EnumC0548p m1577w1(int i3) throws C0542j {
        int i4;
        int i5;
        C0688o c0688o = this.f1389D;
        char[] cArrM1656i = c0688o.m1656i();
        if (i3 == 48) {
            i3 = m1540R1();
        }
        cArrM1656i[0] = (char) i3;
        int i6 = 1;
        int iMin = Math.min(this.f1408u, (this.f1407t + cArrM1656i.length) - 1);
        int i7 = 1;
        while (true) {
            i4 = this.f1407t;
            if (i4 >= iMin) {
                return m1575u1(cArrM1656i, i6, false, i7);
            }
            byte[] bArr = this.f1715b0;
            this.f1407t = i4 + 1;
            i5 = bArr[i4] & 255;
            if (i5 < 48 || i5 > 57) {
                break;
            }
            i7++;
            cArrM1656i[i6] = (char) i5;
            i6++;
        }
        if (i5 == 46 || i5 == 101 || i5 == 69) {
            return m1572r1(cArrM1656i, i6, i5, false, i7);
        }
        this.f1407t = i4;
        c0688o.f1877i = i6;
        if (this.f1387B.m1218f()) {
            m1541S1(i5);
        }
        return m1268T0(i7, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX INFO: renamed from: x1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m1578x1(p042N0.C0533a r17, p118m1.C1742g r18, byte[] r19) throws p042N0.C0542j {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0643h.m1578x1(N0.a, m1.g, byte[]):int");
    }

    /* JADX INFO: renamed from: y1 */
    public final void m1579y1(int i3) throws C0542j {
        if (i3 < 32) {
            m1285o0(i3);
            throw null;
        }
        m1580z1(i3);
        throw null;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: z */
    public final C0684k mo1211z() {
        return AbstractC0570b.f1385S;
    }

    @Override // p045O0.AbstractC0570b
    /* JADX INFO: renamed from: z0 */
    public final char mo1275z0() throws C0542j {
        if (this.f1407t >= this.f1408u && !m1563h1()) {
            EnumC0548p enumC0548p = EnumC0548p.NOT_AVAILABLE;
            m1281k0(" in character escape sequence");
            throw null;
        }
        byte[] bArr = this.f1715b0;
        int i3 = this.f1407t;
        this.f1407t = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 == 34 || b3 == 47 || b3 == 92) {
            return (char) b3;
        }
        if (b3 == 98) {
            return '\b';
        }
        if (b3 == 102) {
            return '\f';
        }
        if (b3 == 110) {
            return '\n';
        }
        if (b3 == 114) {
            return '\r';
        }
        if (b3 == 116) {
            return '\t';
        }
        if (b3 != 117) {
            char cM1549X0 = (char) m1549X0(b3);
            m1256F0(cM1549X0);
            return cM1549X0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            if (this.f1407t >= this.f1408u && !m1563h1()) {
                EnumC0548p enumC0548p2 = EnumC0548p.NOT_AVAILABLE;
                m1281k0(" in character escape sequence");
                throw null;
            }
            byte[] bArr2 = this.f1715b0;
            int i6 = this.f1407t;
            this.f1407t = i6 + 1;
            int i7 = bArr2[i6] & 255;
            int i8 = AbstractC0589b.f1510k[i7];
            if (i8 < 0) {
                m1283m0(i7, "expected a hex-digit for character escape sequence");
                throw null;
            }
            i4 = (i4 << 4) | i8;
        }
        return (char) i4;
    }

    /* JADX INFO: renamed from: z1 */
    public final void m1580z1(int i3) throws C0542j {
        m1279i0("Invalid UTF-8 start byte 0x" + Integer.toHexString(i3));
        throw null;
    }
}
