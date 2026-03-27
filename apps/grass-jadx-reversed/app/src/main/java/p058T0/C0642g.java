package p058T0;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import p025H1.C0283l;
import p042N0.AbstractC0549q;
import p042N0.C0533a;
import p042N0.EnumC0539g;
import p042N0.InterfaceC0550r;
import p042N0.InterfaceC0551s;
import p050Q0.AbstractC0589b;
import p050Q0.AbstractC0595h;
import p050Q0.C0592e;
import p050Q0.C0597j;
import p066W0.C0674a;

/* JADX INFO: renamed from: T0.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0642g extends AbstractC0637b {

    /* JADX INFO: renamed from: A */
    public static final byte[] f1683A = AbstractC0589b.m1334a(true);

    /* JADX INFO: renamed from: B */
    public static final byte[] f1684B = AbstractC0589b.m1334a(false);

    /* JADX INFO: renamed from: C */
    public static final byte[] f1685C = {110, 117, 108, 108};

    /* JADX INFO: renamed from: D */
    public static final byte[] f1686D = {116, 114, 117, 101};

    /* JADX INFO: renamed from: E */
    public static final byte[] f1687E = {102, 97, 108, 115, 101};

    /* JADX INFO: renamed from: r */
    public final OutputStream f1688r;

    /* JADX INFO: renamed from: s */
    public final byte f1689s;

    /* JADX INFO: renamed from: t */
    public byte[] f1690t;

    /* JADX INFO: renamed from: u */
    public int f1691u;

    /* JADX INFO: renamed from: v */
    public final int f1692v;

    /* JADX INFO: renamed from: w */
    public final int f1693w;

    /* JADX INFO: renamed from: x */
    public char[] f1694x;

    /* JADX INFO: renamed from: y */
    public final int f1695y;

    /* JADX INFO: renamed from: z */
    public final boolean f1696z;

    public C0642g(C0283l c0283l, int i3, AbstractC0549q abstractC0549q, OutputStream outputStream, char c3) {
        super(c0283l, i3, abstractC0549q);
        this.f1688r = outputStream;
        this.f1689s = (byte) c3;
        if (c3 != '\"') {
            this.f1640l = AbstractC0589b.m1336c(c3);
        }
        this.f1696z = true;
        C0283l.m556a((byte[]) c0283l.f762h);
        C0674a c0674a = (C0674a) c0283l.f759e;
        byte[] bArrM1632a = c0674a.m1632a(1);
        c0283l.f762h = bArrM1632a;
        this.f1690t = bArrM1632a;
        int length = bArrM1632a.length;
        this.f1692v = length;
        this.f1693w = length >> 3;
        C0283l.m556a((char[]) c0283l.f765k);
        char[] cArrM1633b = c0674a.m1633b(1, 0);
        c0283l.f765k = cArrM1633b;
        this.f1694x = cArrM1633b;
        this.f1695y = cArrM1633b.length;
        if (mo1134g(EnumC0539g.ESCAPE_NON_ASCII)) {
            m1464b0(127);
        }
    }

    /* JADX INFO: renamed from: f0 */
    public static int m1508f0(InputStream inputStream, byte[] bArr, int i3, int i4, int i5) throws IOException {
        int i6 = 0;
        while (i3 < i4) {
            bArr[i6] = bArr[i3];
            i6++;
            i3++;
        }
        int iMin = Math.min(i5, bArr.length);
        do {
            int i7 = iMin - i6;
            if (i7 == 0) {
                break;
            }
            int i8 = inputStream.read(bArr, i6, i7);
            if (i8 < 0) {
                return i6;
            }
            i6 += i8;
        } while (i6 < 3);
        return i6;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: A */
    public final void mo1108A(short s3) throws IOException {
        mo1248Y("write a number");
        int i3 = this.f1691u + 6;
        int i4 = this.f1692v;
        if (i3 >= i4) {
            m1509c0();
        }
        if (!this.f1383h) {
            this.f1691u = AbstractC0595h.m1358g(s3, this.f1690t, this.f1691u);
            return;
        }
        if (this.f1691u + 8 >= i4) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i5 = this.f1691u;
        int i6 = i5 + 1;
        this.f1691u = i6;
        byte b3 = this.f1689s;
        bArr[i5] = b3;
        int iM1358g = AbstractC0595h.m1358g(s3, bArr, i6);
        byte[] bArr2 = this.f1690t;
        this.f1691u = iM1358g + 1;
        bArr2[iM1358g] = b3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: D */
    public final void mo1111D(char c3) throws IOException {
        if (this.f1691u + 3 >= this.f1692v) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        if (c3 <= 127) {
            int i3 = this.f1691u;
            this.f1691u = i3 + 1;
            bArr[i3] = (byte) c3;
        } else {
            if (c3 >= 2048) {
                m1511e0(c3, 0, 0, null);
                return;
            }
            int i4 = this.f1691u;
            int i5 = i4 + 1;
            this.f1691u = i5;
            bArr[i4] = (byte) ((c3 >> 6) | 192);
            this.f1691u = i4 + 2;
            bArr[i5] = (byte) ((c3 & '?') | 128);
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: E */
    public final void mo1112E(InterfaceC0551s interfaceC0551s) throws IOException {
        byte[] bArr = this.f1690t;
        int i3 = this.f1691u;
        C0597j c0597j = (C0597j) interfaceC0551s;
        byte[] bArrM1340c = c0597j.f1533g;
        if (bArrM1340c == null) {
            C0597j.f1530j.getClass();
            bArrM1340c = C0592e.m1340c(c0597j.f1531e);
            c0597j.f1533g = bArrM1340c;
        }
        int length = bArrM1340c.length;
        if (i3 + length > bArr.length) {
            length = -1;
        } else {
            System.arraycopy(bArrM1340c, 0, bArr, i3, length);
        }
        if (length < 0) {
            m1514i0(c0597j.m1367d());
        } else {
            this.f1691u += length;
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: F */
    public final void mo1113F(String str) throws IOException {
        char c3;
        int length = str.length();
        char[] cArr = this.f1694x;
        if (length <= cArr.length) {
            str.getChars(0, length, cArr, 0);
            mo1114G(cArr, length);
            return;
        }
        int length2 = str.length();
        if (((length2 - length) | length) < 0) {
            m1129a(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `String` of length %d", 0, Integer.valueOf(length), Integer.valueOf(length2)));
            throw null;
        }
        char[] cArr2 = this.f1694x;
        int length3 = cArr2.length;
        if (length <= length3) {
            str.getChars(0, length, cArr2, 0);
            mo1114G(cArr2, length);
            return;
        }
        int i3 = this.f1692v;
        int iMin = Math.min(length3, (i3 >> 2) + (i3 >> 4));
        int i4 = iMin * 3;
        int i5 = 0;
        while (length > 0) {
            int iMin2 = Math.min(iMin, length);
            str.getChars(i5, i5 + iMin2, cArr2, 0);
            if (this.f1691u + i4 > i3) {
                m1509c0();
            }
            if (iMin2 > 1 && (c3 = cArr2[iMin2 - 1]) >= 55296 && c3 <= 56319) {
                iMin2--;
            }
            int iM1511e0 = 0;
            while (iM1511e0 < iMin2) {
                do {
                    char c4 = cArr2[iM1511e0];
                    if (c4 > 127) {
                        iM1511e0++;
                        if (c4 < 2048) {
                            byte[] bArr = this.f1690t;
                            int i6 = this.f1691u;
                            int i7 = i6 + 1;
                            this.f1691u = i7;
                            bArr[i6] = (byte) ((c4 >> 6) | 192);
                            this.f1691u = i6 + 2;
                            bArr[i7] = (byte) ((c4 & '?') | 128);
                        } else {
                            iM1511e0 = m1511e0(c4, iM1511e0, iMin2, cArr2);
                        }
                    } else {
                        byte[] bArr2 = this.f1690t;
                        int i8 = this.f1691u;
                        this.f1691u = i8 + 1;
                        bArr2[i8] = (byte) c4;
                        iM1511e0++;
                    }
                } while (iM1511e0 < iMin2);
                i5 += iMin2;
                length -= iMin2;
            }
            i5 += iMin2;
            length -= iMin2;
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: G */
    public final void mo1114G(char[] cArr, int i3) throws IOException {
        m1247X(cArr, i3);
        int i4 = i3 + i3 + i3;
        int i5 = this.f1691u + i4;
        int iM1511e0 = 0;
        int i6 = this.f1692v;
        if (i5 > i6) {
            if (i6 < i4) {
                byte[] bArr = this.f1690t;
                while (iM1511e0 < i3) {
                    do {
                        char c3 = cArr[iM1511e0];
                        if (c3 >= 128) {
                            if (this.f1691u + 3 >= i6) {
                                m1509c0();
                            }
                            int iM1511e02 = iM1511e0 + 1;
                            char c4 = cArr[iM1511e0];
                            if (c4 < 2048) {
                                int i7 = this.f1691u;
                                int i8 = i7 + 1;
                                this.f1691u = i8;
                                bArr[i7] = (byte) ((c4 >> 6) | 192);
                                this.f1691u = i7 + 2;
                                bArr[i8] = (byte) ((c4 & '?') | 128);
                            } else {
                                iM1511e02 = m1511e0(c4, iM1511e02, i3, cArr);
                            }
                            iM1511e0 = iM1511e02;
                        } else {
                            if (this.f1691u >= i6) {
                                m1509c0();
                            }
                            int i9 = this.f1691u;
                            this.f1691u = i9 + 1;
                            bArr[i9] = (byte) c3;
                            iM1511e0++;
                        }
                    } while (iM1511e0 < i3);
                    return;
                }
                return;
            }
            m1509c0();
        }
        while (iM1511e0 < i3) {
            do {
                char c5 = cArr[iM1511e0];
                if (c5 > 127) {
                    iM1511e0++;
                    if (c5 < 2048) {
                        byte[] bArr2 = this.f1690t;
                        int i10 = this.f1691u;
                        int i11 = i10 + 1;
                        this.f1691u = i11;
                        bArr2[i10] = (byte) ((c5 >> 6) | 192);
                        this.f1691u = i10 + 2;
                        bArr2[i11] = (byte) ((c5 & '?') | 128);
                    } else {
                        iM1511e0 = m1511e0(c5, iM1511e0, i3, cArr);
                    }
                } else {
                    byte[] bArr3 = this.f1690t;
                    int i12 = this.f1691u;
                    this.f1691u = i12 + 1;
                    bArr3[i12] = (byte) c5;
                    iM1511e0++;
                }
            } while (iM1511e0 < i3);
            return;
        }
    }

    @Override // p045O0.AbstractC0569a, p042N0.AbstractC0540h
    /* JADX INFO: renamed from: H */
    public final void mo1115H(InterfaceC0551s interfaceC0551s) throws IOException {
        mo1248Y("write a raw (unencoded) value");
        byte[] bArr = this.f1690t;
        int i3 = this.f1691u;
        C0597j c0597j = (C0597j) interfaceC0551s;
        byte[] bArrM1340c = c0597j.f1533g;
        if (bArrM1340c == null) {
            C0597j.f1530j.getClass();
            bArrM1340c = C0592e.m1340c(c0597j.f1531e);
            c0597j.f1533g = bArrM1340c;
        }
        int length = bArrM1340c.length;
        if (i3 + length > bArr.length) {
            length = -1;
        } else {
            System.arraycopy(bArrM1340c, 0, bArr, i3, length);
        }
        if (length < 0) {
            m1514i0(c0597j.m1367d());
        } else {
            this.f1691u += length;
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: J */
    public final void mo1117J() throws IOException {
        mo1248Y("start an array");
        this.f1384i = this.f1384i.m1467i();
        InterfaceC0550r interfaceC0550r = this.f1268e;
        if (interfaceC0550r != null) {
            interfaceC0550r.mo1227d(this);
            return;
        }
        if (this.f1691u >= this.f1692v) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i3 = this.f1691u;
        this.f1691u = i3 + 1;
        bArr[i3] = 91;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: K */
    public final void mo1118K(Object obj) throws IOException {
        mo1248Y("start an array");
        this.f1384i = this.f1384i.m1468j(obj);
        InterfaceC0550r interfaceC0550r = this.f1268e;
        if (interfaceC0550r != null) {
            interfaceC0550r.mo1227d(this);
            return;
        }
        if (this.f1691u >= this.f1692v) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i3 = this.f1691u;
        this.f1691u = i3 + 1;
        bArr[i3] = 91;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: L */
    public final void mo1119L(Object obj) throws IOException {
        mo1248Y("start an array");
        this.f1384i = this.f1384i.m1468j(obj);
        InterfaceC0550r interfaceC0550r = this.f1268e;
        if (interfaceC0550r != null) {
            interfaceC0550r.mo1227d(this);
            return;
        }
        if (this.f1691u >= this.f1692v) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i3 = this.f1691u;
        this.f1691u = i3 + 1;
        bArr[i3] = 91;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: M */
    public final void mo1120M() throws IOException {
        mo1248Y("start an object");
        this.f1384i = this.f1384i.m1469k();
        InterfaceC0550r interfaceC0550r = this.f1268e;
        if (interfaceC0550r != null) {
            interfaceC0550r.mo1229f(this);
            return;
        }
        if (this.f1691u >= this.f1692v) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i3 = this.f1691u;
        this.f1691u = i3 + 1;
        bArr[i3] = 123;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: N */
    public final void mo1121N(Object obj) throws IOException {
        mo1248Y("start an object");
        this.f1384i = this.f1384i.m1470l(obj);
        InterfaceC0550r interfaceC0550r = this.f1268e;
        if (interfaceC0550r != null) {
            interfaceC0550r.mo1229f(this);
            return;
        }
        if (this.f1691u >= this.f1692v) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i3 = this.f1691u;
        this.f1691u = i3 + 1;
        bArr[i3] = 123;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: P */
    public final void mo1123P(int i3, char[] cArr, int i4) throws IOException {
        mo1248Y("write a string");
        int i5 = this.f1691u;
        int i6 = this.f1692v;
        if (i5 >= i6) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i7 = this.f1691u;
        int i8 = i7 + 1;
        this.f1691u = i8;
        byte b3 = this.f1689s;
        bArr[i7] = b3;
        if (i4 <= this.f1693w) {
            if (i8 + i4 > i6) {
                m1509c0();
            }
            m1518m0(i3, cArr, i4);
        } else {
            m1520o0(i3, cArr, i4);
        }
        if (this.f1691u >= i6) {
            m1509c0();
        }
        byte[] bArr2 = this.f1690t;
        int i9 = this.f1691u;
        this.f1691u = i9 + 1;
        bArr2[i9] = b3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: Q */
    public final void mo1124Q(InterfaceC0551s interfaceC0551s) throws IOException {
        mo1248Y("write a string");
        int i3 = this.f1691u;
        int i4 = this.f1692v;
        if (i3 >= i4) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i5 = this.f1691u;
        int i6 = i5 + 1;
        this.f1691u = i6;
        byte b3 = this.f1689s;
        bArr[i5] = b3;
        C0597j c0597j = (C0597j) interfaceC0551s;
        int iM1364a = c0597j.m1364a(bArr, i6);
        if (iM1364a < 0) {
            m1514i0(c0597j.m1366c());
        } else {
            this.f1691u += iM1364a;
        }
        if (this.f1691u >= i4) {
            m1509c0();
        }
        byte[] bArr2 = this.f1690t;
        int i7 = this.f1691u;
        this.f1691u = i7 + 1;
        bArr2[i7] = b3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: R */
    public final void mo1125R(String str) throws IOException {
        mo1248Y("write a string");
        if (str == null) {
            m1516k0();
            return;
        }
        int length = str.length();
        if (length > this.f1693w) {
            m1521p0(str, true);
            return;
        }
        int i3 = this.f1691u + length;
        int i4 = this.f1692v;
        if (i3 >= i4) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i5 = this.f1691u;
        this.f1691u = i5 + 1;
        byte b3 = this.f1689s;
        bArr[i5] = b3;
        m1519n0(str, 0, length);
        if (this.f1691u >= i4) {
            m1509c0();
        }
        byte[] bArr2 = this.f1690t;
        int i6 = this.f1691u;
        this.f1691u = i6 + 1;
        bArr2[i6] = b3;
    }

    @Override // p045O0.AbstractC0569a
    /* JADX INFO: renamed from: Y */
    public final void mo1248Y(String str) throws IOException {
        byte b3;
        int iM1472n = this.f1384i.m1472n();
        if (this.f1268e != null) {
            m1463a0(iM1472n, str);
            return;
        }
        if (iM1472n == 1) {
            b3 = 44;
        } else {
            if (iM1472n != 2) {
                if (iM1472n != 3) {
                    if (iM1472n != 5) {
                        return;
                    }
                    m1462Z(str);
                    throw null;
                }
                InterfaceC0551s interfaceC0551s = this.f1642n;
                if (interfaceC0551s != null) {
                    byte[] bArrM1367d = ((C0597j) interfaceC0551s).m1367d();
                    if (bArrM1367d.length > 0) {
                        m1514i0(bArrM1367d);
                        return;
                    }
                    return;
                }
                return;
            }
            b3 = 58;
        }
        if (this.f1691u >= this.f1692v) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i3 = this.f1691u;
        this.f1691u = i3 + 1;
        bArr[i3] = b3;
    }

    /* JADX INFO: renamed from: c0 */
    public final void m1509c0() throws IOException {
        int i3 = this.f1691u;
        if (i3 > 0) {
            this.f1691u = 0;
            this.f1688r.write(this.f1690t, 0, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0055  */
    @Override // p042N0.AbstractC0540h, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws java.lang.Throwable {
        /*
            r8 = this;
            r0 = 0
            byte[] r1 = r8.f1690t     // Catch: java.io.IOException -> L23
            if (r1 == 0) goto L25
            N0.g r1 = p042N0.EnumC0539g.AUTO_CLOSE_JSON_CONTENT     // Catch: java.io.IOException -> L23
            boolean r1 = r8.mo1134g(r1)     // Catch: java.io.IOException -> L23
            if (r1 == 0) goto L25
        Ld:
            T0.e r1 = r8.f1384i     // Catch: java.io.IOException -> L23
            boolean r2 = r1.m1216d()     // Catch: java.io.IOException -> L23
            if (r2 == 0) goto L19
            r8.mo1142o()     // Catch: java.io.IOException -> L23
            goto Ld
        L19:
            boolean r1 = r1.m1217e()     // Catch: java.io.IOException -> L23
            if (r1 == 0) goto L25
            r8.mo1143p()     // Catch: java.io.IOException -> L23
            goto Ld
        L23:
            r1 = move-exception
            goto L29
        L25:
            r8.m1509c0()     // Catch: java.io.IOException -> L23
            r1 = r0
        L29:
            r2 = 0
            r8.f1691u = r2
            H1.l r2 = r8.f1639k
            java.io.OutputStream r3 = r8.f1688r
            if (r3 == 0) goto L59
            boolean r4 = r2.f755a     // Catch: java.lang.RuntimeException -> L4b java.io.IOException -> L4d
            if (r4 != 0) goto L4f
            N0.g r4 = p042N0.EnumC0539g.AUTO_CLOSE_TARGET     // Catch: java.lang.RuntimeException -> L4b java.io.IOException -> L4d
            boolean r4 = r8.mo1134g(r4)     // Catch: java.lang.RuntimeException -> L4b java.io.IOException -> L4d
            if (r4 == 0) goto L3f
            goto L4f
        L3f:
            N0.g r4 = p042N0.EnumC0539g.FLUSH_PASSED_TO_STREAM     // Catch: java.lang.RuntimeException -> L4b java.io.IOException -> L4d
            boolean r4 = r8.mo1134g(r4)     // Catch: java.lang.RuntimeException -> L4b java.io.IOException -> L4d
            if (r4 == 0) goto L59
            r3.flush()     // Catch: java.lang.RuntimeException -> L4b java.io.IOException -> L4d
            goto L59
        L4b:
            r0 = move-exception
            goto L53
        L4d:
            r0 = move-exception
            goto L53
        L4f:
            r3.close()     // Catch: java.lang.RuntimeException -> L4b java.io.IOException -> L4d
            goto L59
        L53:
            if (r1 == 0) goto L58
            r0.addSuppressed(r1)
        L58:
            throw r0
        L59:
            byte[] r3 = r8.f1690t
            r4 = 1
            java.lang.String r5 = "Trying to release buffer smaller than original"
            if (r3 == 0) goto L82
            boolean r6 = r8.f1696z
            if (r6 == 0) goto L82
            r8.f1690t = r0
            java.lang.Object r6 = r2.f762h
            byte[] r6 = (byte[]) r6
            if (r3 == r6) goto L77
            int r7 = r3.length
            int r6 = r6.length
            if (r7 < r6) goto L71
            goto L77
        L71:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        L77:
            r2.f762h = r0
            java.lang.Object r6 = r2.f759e
            W0.a r6 = (p066W0.C0674a) r6
            java.util.concurrent.atomic.AtomicReferenceArray r6 = r6.f1834a
            r6.set(r4, r3)
        L82:
            char[] r3 = r8.f1694x
            if (r3 == 0) goto La4
            r8.f1694x = r0
            java.lang.Object r6 = r2.f765k
            char[] r6 = (char[]) r6
            if (r3 == r6) goto L99
            int r7 = r3.length
            int r6 = r6.length
            if (r7 < r6) goto L93
            goto L99
        L93:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        L99:
            r2.f765k = r0
            java.lang.Object r0 = r2.f759e
            W0.a r0 = (p066W0.C0674a) r0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.f1835b
            r0.set(r4, r3)
        La4:
            if (r1 != 0) goto La7
            return
        La7:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0642g.close():void");
    }

    /* JADX INFO: renamed from: d0 */
    public final int m1510d0(int i3, int i4) {
        byte[] bArr = this.f1644p ? f1683A : f1684B;
        byte[] bArr2 = this.f1690t;
        if (i3 < 55296 || i3 > 57343) {
            bArr2[i4] = (byte) ((i3 >> 12) | 224);
            int i5 = i4 + 2;
            bArr2[i4 + 1] = (byte) (((i3 >> 6) & 63) | 128);
            int i6 = i4 + 3;
            bArr2[i5] = (byte) ((i3 & 63) | 128);
            return i6;
        }
        bArr2[i4] = 92;
        bArr2[i4 + 1] = 117;
        bArr2[i4 + 2] = bArr[(i3 >> 12) & 15];
        bArr2[i4 + 3] = bArr[(i3 >> 8) & 15];
        int i7 = i4 + 5;
        bArr2[i4 + 4] = bArr[(i3 >> 4) & 15];
        int i8 = i4 + 6;
        bArr2[i7] = bArr[i3 & 15];
        return i8;
    }

    /* JADX INFO: renamed from: e0 */
    public final int m1511e0(int i3, int i4, int i5, char[] cArr) throws IOException {
        if (i3 < 55296 || i3 > 57343) {
            byte[] bArr = this.f1690t;
            int i6 = this.f1691u;
            int i7 = i6 + 1;
            this.f1691u = i7;
            bArr[i6] = (byte) ((i3 >> 12) | 224);
            int i8 = i6 + 2;
            this.f1691u = i8;
            bArr[i7] = (byte) (((i3 >> 6) & 63) | 128);
            this.f1691u = i6 + 3;
            bArr[i8] = (byte) ((i3 & 63) | 128);
            return i4;
        }
        if (i4 >= i5 || cArr == null) {
            m1129a(String.format("Split surrogate on writeRaw() input (last character): first character 0x%4x", Integer.valueOf(i3)));
            throw null;
        }
        char c3 = cArr[i4];
        if (c3 < 56320 || c3 > 57343) {
            m1129a(String.format("Incomplete surrogate pair: first char 0x%04X, second 0x%04X", Integer.valueOf(i3), Integer.valueOf(c3)));
            throw null;
        }
        int i9 = (c3 - 56320) + ((i3 - 55296) << 10) + 65536;
        if (this.f1691u + 4 > this.f1692v) {
            m1509c0();
        }
        byte[] bArr2 = this.f1690t;
        int i10 = this.f1691u;
        int i11 = i10 + 1;
        this.f1691u = i11;
        bArr2[i10] = (byte) ((i9 >> 18) | 240);
        int i12 = i10 + 2;
        this.f1691u = i12;
        bArr2[i11] = (byte) (((i9 >> 12) & 63) | 128);
        int i13 = i10 + 3;
        this.f1691u = i13;
        bArr2[i12] = (byte) (((i9 >> 6) & 63) | 128);
        this.f1691u = i10 + 4;
        bArr2[i13] = (byte) ((i9 & 63) | 128);
        return i4 + 1;
    }

    @Override // p042N0.AbstractC0540h, java.io.Flushable
    public final void flush() throws IOException {
        m1509c0();
        OutputStream outputStream = this.f1688r;
        if (outputStream == null || !mo1134g(EnumC0539g.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        outputStream.flush();
    }

    /* JADX INFO: renamed from: g0 */
    public final int m1512g0(C0533a c0533a, InputStream inputStream, byte[] bArr) throws IOException {
        int i3 = this.f1692v - 6;
        int i4 = 2;
        int i5 = c0533a.f1224j >> 2;
        int i6 = -3;
        int i7 = 0;
        int iM1508f0 = 0;
        int i8 = 0;
        while (true) {
            if (i7 > i6) {
                iM1508f0 = m1508f0(inputStream, bArr, i7, iM1508f0, bArr.length);
                if (iM1508f0 < 3) {
                    break;
                }
                i6 = iM1508f0 - 3;
                i7 = 0;
            }
            if (this.f1691u > i3) {
                m1509c0();
            }
            int i9 = i7 + 2;
            int i10 = ((bArr[i7 + 1] & 255) | (bArr[i7] << 8)) << 8;
            i7 += 3;
            i8 += 3;
            int iM1076f = c0533a.m1076f((bArr[i9] & 255) | i10, this.f1690t, this.f1691u);
            this.f1691u = iM1076f;
            i5--;
            if (i5 <= 0) {
                byte[] bArr2 = this.f1690t;
                int i11 = iM1076f + 1;
                this.f1691u = i11;
                bArr2[iM1076f] = 92;
                this.f1691u = iM1076f + 2;
                bArr2[i11] = 110;
                i5 = c0533a.f1224j >> 2;
            }
        }
        if (iM1508f0 <= 0) {
            return i8;
        }
        if (this.f1691u > i3) {
            m1509c0();
        }
        int i12 = bArr[0] << 16;
        if (1 < iM1508f0) {
            i12 |= (bArr[1] & 255) << 8;
        } else {
            i4 = 1;
        }
        int i13 = i8 + i4;
        this.f1691u = c0533a.m1079i(i12, i4, this.f1690t, this.f1691u);
        return i13;
    }

    /* JADX INFO: renamed from: h0 */
    public final int m1513h0(C0533a c0533a, InputStream inputStream, byte[] bArr, int i3) throws IOException {
        int iM1508f0;
        int i4 = this.f1692v - 6;
        int i5 = 2;
        int i6 = c0533a.f1224j >> 2;
        int i7 = -3;
        int i8 = 0;
        int iM1508f02 = 0;
        while (true) {
            if (i3 <= 2) {
                break;
            }
            if (i8 > i7) {
                iM1508f02 = m1508f0(inputStream, bArr, i8, iM1508f02, i3);
                if (iM1508f02 < 3) {
                    i8 = 0;
                    break;
                }
                i7 = iM1508f02 - 3;
                i8 = 0;
            }
            if (this.f1691u > i4) {
                m1509c0();
            }
            int i9 = i8 + 2;
            int i10 = ((bArr[i8 + 1] & 255) | (bArr[i8] << 8)) << 8;
            i8 += 3;
            i3 -= 3;
            int iM1076f = c0533a.m1076f((bArr[i9] & 255) | i10, this.f1690t, this.f1691u);
            this.f1691u = iM1076f;
            i6--;
            if (i6 <= 0) {
                byte[] bArr2 = this.f1690t;
                int i11 = iM1076f + 1;
                this.f1691u = i11;
                bArr2[iM1076f] = 92;
                this.f1691u = iM1076f + 2;
                bArr2[i11] = 110;
                i6 = c0533a.f1224j >> 2;
            }
        }
        if (i3 <= 0 || (iM1508f0 = m1508f0(inputStream, bArr, i8, iM1508f02, i3)) <= 0) {
            return i3;
        }
        if (this.f1691u > i4) {
            m1509c0();
        }
        int i12 = bArr[0] << 16;
        if (1 < iM1508f0) {
            i12 |= (bArr[1] & 255) << 8;
        } else {
            i5 = 1;
        }
        this.f1691u = c0533a.m1079i(i12, i5, this.f1690t, this.f1691u);
        return i3 - i5;
    }

    /* JADX INFO: renamed from: i0 */
    public final void m1514i0(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.f1691u + length > this.f1692v) {
            m1509c0();
            if (length > 512) {
                this.f1688r.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.f1690t, this.f1691u, length);
        this.f1691u += length;
    }

    /* JADX INFO: renamed from: j0 */
    public final int m1515j0(int i3, int i4) {
        int i5;
        byte[] bArr = this.f1690t;
        byte[] bArr2 = this.f1644p ? f1683A : f1684B;
        bArr[i4] = 92;
        int i6 = i4 + 2;
        bArr[i4 + 1] = 117;
        if (i3 > 255) {
            int i7 = i3 >> 8;
            int i8 = i4 + 3;
            bArr[i6] = bArr2[(i7 & 255) >> 4];
            i5 = i4 + 4;
            bArr[i8] = bArr2[i7 & 15];
            i3 &= 255;
        } else {
            int i9 = i4 + 3;
            bArr[i6] = 48;
            i5 = i4 + 4;
            bArr[i9] = 48;
        }
        int i10 = i5 + 1;
        bArr[i5] = bArr2[i3 >> 4];
        int i11 = i5 + 2;
        bArr[i10] = bArr2[i3 & 15];
        return i11;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: k */
    public final int mo1138k(C0533a c0533a, InputStream inputStream, int i3) throws IOException {
        mo1248Y("write a binary value");
        int i4 = this.f1691u;
        int i5 = this.f1692v;
        if (i4 >= i5) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i6 = this.f1691u;
        this.f1691u = i6 + 1;
        byte b3 = this.f1689s;
        bArr[i6] = b3;
        C0283l c0283l = this.f1639k;
        byte[] bArrM557b = c0283l.m557b();
        try {
            if (i3 < 0) {
                i3 = m1512g0(c0533a, inputStream, bArrM557b);
            } else {
                int iM1513h0 = m1513h0(c0533a, inputStream, bArrM557b, i3);
                if (iM1513h0 > 0) {
                    m1129a("Too few bytes available: missing " + iM1513h0 + " bytes (out of " + i3 + ")");
                    throw null;
                }
            }
            c0283l.m560e(bArrM557b);
            if (this.f1691u >= i5) {
                m1509c0();
            }
            byte[] bArr2 = this.f1690t;
            int i7 = this.f1691u;
            this.f1691u = i7 + 1;
            bArr2[i7] = b3;
            return i3;
        } catch (Throwable th) {
            c0283l.m560e(bArrM557b);
            throw th;
        }
    }

    /* JADX INFO: renamed from: k0 */
    public final void m1516k0() throws IOException {
        if (this.f1691u + 4 >= this.f1692v) {
            m1509c0();
        }
        System.arraycopy(f1685C, 0, this.f1690t, this.f1691u, 4);
        this.f1691u += 4;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: l */
    public final void mo1139l(C0533a c0533a, byte[] bArr, int i3, int i4) throws IOException {
        int iM1076f;
        m1246W(i3, bArr, i4);
        mo1248Y("write a binary value");
        int i5 = this.f1691u;
        int i6 = this.f1692v;
        if (i5 >= i6) {
            m1509c0();
        }
        byte[] bArr2 = this.f1690t;
        int i7 = this.f1691u;
        this.f1691u = i7 + 1;
        byte b3 = this.f1689s;
        bArr2[i7] = b3;
        int i8 = i4 + i3;
        int i9 = i8 - 3;
        int i10 = i6 - 6;
        int i11 = c0533a.f1224j;
        loop0: while (true) {
            int i12 = i11 >> 2;
            while (i3 <= i9) {
                if (this.f1691u > i10) {
                    m1509c0();
                }
                int i13 = i3 + 2;
                int i14 = ((bArr[i3 + 1] & 255) | (bArr[i3] << 8)) << 8;
                i3 += 3;
                iM1076f = c0533a.m1076f(i14 | (bArr[i13] & 255), this.f1690t, this.f1691u);
                this.f1691u = iM1076f;
                i12--;
                if (i12 <= 0) {
                    break;
                }
            }
            byte[] bArr3 = this.f1690t;
            int i15 = iM1076f + 1;
            this.f1691u = i15;
            bArr3[iM1076f] = 92;
            this.f1691u = iM1076f + 2;
            bArr3[i15] = 110;
            i11 = c0533a.f1224j;
        }
        int i16 = i8 - i3;
        if (i16 > 0) {
            if (this.f1691u > i10) {
                m1509c0();
            }
            int i17 = i3 + 1;
            int i18 = bArr[i3] << 16;
            if (i16 == 2) {
                i18 |= (bArr[i17] & 255) << 8;
            }
            this.f1691u = c0533a.m1079i(i18, i16, this.f1690t, this.f1691u);
        }
        if (this.f1691u >= i6) {
            m1509c0();
        }
        byte[] bArr4 = this.f1690t;
        int i19 = this.f1691u;
        this.f1691u = i19 + 1;
        bArr4[i19] = b3;
    }

    /* JADX INFO: renamed from: l0 */
    public final void m1517l0(String str) throws IOException {
        int i3 = this.f1691u;
        int i4 = this.f1692v;
        if (i3 >= i4) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i5 = this.f1691u;
        this.f1691u = i5 + 1;
        byte b3 = this.f1689s;
        bArr[i5] = b3;
        mo1113F(str);
        if (this.f1691u >= i4) {
            m1509c0();
        }
        byte[] bArr2 = this.f1690t;
        int i6 = this.f1691u;
        this.f1691u = i6 + 1;
        bArr2[i6] = b3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: m */
    public final void mo1140m(boolean z3) throws IOException {
        mo1248Y("write a boolean value");
        if (this.f1691u + 5 >= this.f1692v) {
            m1509c0();
        }
        byte[] bArr = z3 ? f1686D : f1687E;
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.f1690t, this.f1691u, length);
        this.f1691u += length;
    }

    /* JADX INFO: renamed from: m0 */
    public final void m1518m0(int i3, char[] cArr, int i4) throws IOException {
        char c3;
        int i5 = i4 + i3;
        int i6 = this.f1691u;
        byte[] bArr = this.f1690t;
        int[] iArr = this.f1640l;
        while (i3 < i5 && (c3 = cArr[i3]) <= 127 && iArr[c3] == 0) {
            bArr[i6] = (byte) c3;
            i3++;
            i6++;
        }
        this.f1691u = i6;
        if (i3 < i5) {
            int i7 = this.f1641m;
            int i8 = this.f1692v;
            if (i7 == 0) {
                if (((i5 - i3) * 6) + i6 > i8) {
                    m1509c0();
                }
                int iM1510d0 = this.f1691u;
                byte[] bArr2 = this.f1690t;
                int[] iArr2 = this.f1640l;
                while (i3 < i5) {
                    int i9 = i3 + 1;
                    char c4 = cArr[i3];
                    if (c4 <= 127) {
                        int i10 = iArr2[c4];
                        if (i10 == 0) {
                            bArr2[iM1510d0] = (byte) c4;
                            i3 = i9;
                            iM1510d0++;
                        } else if (i10 > 0) {
                            int i11 = iM1510d0 + 1;
                            bArr2[iM1510d0] = 92;
                            iM1510d0 += 2;
                            bArr2[i11] = (byte) i10;
                        } else {
                            iM1510d0 = m1515j0(c4, iM1510d0);
                        }
                    } else if (c4 <= 2047) {
                        int i12 = iM1510d0 + 1;
                        bArr2[iM1510d0] = (byte) ((c4 >> 6) | 192);
                        iM1510d0 += 2;
                        bArr2[i12] = (byte) ((c4 & '?') | 128);
                    } else {
                        iM1510d0 = m1510d0(c4, iM1510d0);
                    }
                    i3 = i9;
                }
                this.f1691u = iM1510d0;
                return;
            }
            if (((i5 - i3) * 6) + i6 > i8) {
                m1509c0();
            }
            int iM1510d02 = this.f1691u;
            byte[] bArr3 = this.f1690t;
            int[] iArr3 = this.f1640l;
            int i13 = this.f1641m;
            while (i3 < i5) {
                int i14 = i3 + 1;
                char c5 = cArr[i3];
                if (c5 <= 127) {
                    int i15 = iArr3[c5];
                    if (i15 == 0) {
                        bArr3[iM1510d02] = (byte) c5;
                        i3 = i14;
                        iM1510d02++;
                    } else if (i15 > 0) {
                        int i16 = iM1510d02 + 1;
                        bArr3[iM1510d02] = 92;
                        iM1510d02 += 2;
                        bArr3[i16] = (byte) i15;
                    } else {
                        iM1510d02 = m1515j0(c5, iM1510d02);
                    }
                } else if (c5 > i13) {
                    iM1510d02 = m1515j0(c5, iM1510d02);
                } else if (c5 <= 2047) {
                    int i17 = iM1510d02 + 1;
                    bArr3[iM1510d02] = (byte) ((c5 >> 6) | 192);
                    iM1510d02 += 2;
                    bArr3[i17] = (byte) ((c5 & '?') | 128);
                } else {
                    iM1510d02 = m1510d0(c5, iM1510d02);
                }
                i3 = i14;
            }
            this.f1691u = iM1510d02;
        }
    }

    /* JADX INFO: renamed from: n0 */
    public final void m1519n0(String str, int i3, int i4) throws IOException {
        char cCharAt;
        int i5 = i4 + i3;
        int i6 = this.f1691u;
        byte[] bArr = this.f1690t;
        int[] iArr = this.f1640l;
        while (i3 < i5 && (cCharAt = str.charAt(i3)) <= 127 && iArr[cCharAt] == 0) {
            bArr[i6] = (byte) cCharAt;
            i3++;
            i6++;
        }
        this.f1691u = i6;
        if (i3 < i5) {
            int i7 = this.f1641m;
            int i8 = this.f1692v;
            if (i7 == 0) {
                if (((i5 - i3) * 6) + i6 > i8) {
                    m1509c0();
                }
                int iM1510d0 = this.f1691u;
                byte[] bArr2 = this.f1690t;
                int[] iArr2 = this.f1640l;
                while (i3 < i5) {
                    int i9 = i3 + 1;
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 <= 127) {
                        int i10 = iArr2[cCharAt2];
                        if (i10 == 0) {
                            bArr2[iM1510d0] = (byte) cCharAt2;
                            i3 = i9;
                            iM1510d0++;
                        } else if (i10 > 0) {
                            int i11 = iM1510d0 + 1;
                            bArr2[iM1510d0] = 92;
                            iM1510d0 += 2;
                            bArr2[i11] = (byte) i10;
                        } else {
                            iM1510d0 = m1515j0(cCharAt2, iM1510d0);
                        }
                    } else if (cCharAt2 <= 2047) {
                        int i12 = iM1510d0 + 1;
                        bArr2[iM1510d0] = (byte) ((cCharAt2 >> 6) | 192);
                        iM1510d0 += 2;
                        bArr2[i12] = (byte) ((cCharAt2 & '?') | 128);
                    } else {
                        iM1510d0 = m1510d0(cCharAt2, iM1510d0);
                    }
                    i3 = i9;
                }
                this.f1691u = iM1510d0;
                return;
            }
            if (((i5 - i3) * 6) + i6 > i8) {
                m1509c0();
            }
            int iM1510d02 = this.f1691u;
            byte[] bArr3 = this.f1690t;
            int[] iArr3 = this.f1640l;
            int i13 = this.f1641m;
            while (i3 < i5) {
                int i14 = i3 + 1;
                char cCharAt3 = str.charAt(i3);
                if (cCharAt3 <= 127) {
                    int i15 = iArr3[cCharAt3];
                    if (i15 == 0) {
                        bArr3[iM1510d02] = (byte) cCharAt3;
                        i3 = i14;
                        iM1510d02++;
                    } else if (i15 > 0) {
                        int i16 = iM1510d02 + 1;
                        bArr3[iM1510d02] = 92;
                        iM1510d02 += 2;
                        bArr3[i16] = (byte) i15;
                    } else {
                        iM1510d02 = m1515j0(cCharAt3, iM1510d02);
                    }
                } else if (cCharAt3 > i13) {
                    iM1510d02 = m1515j0(cCharAt3, iM1510d02);
                } else if (cCharAt3 <= 2047) {
                    int i17 = iM1510d02 + 1;
                    bArr3[iM1510d02] = (byte) ((cCharAt3 >> 6) | 192);
                    iM1510d02 += 2;
                    bArr3[i17] = (byte) ((cCharAt3 & '?') | 128);
                } else {
                    iM1510d02 = m1510d0(cCharAt3, iM1510d02);
                }
                i3 = i14;
            }
            this.f1691u = iM1510d02;
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: o */
    public final void mo1142o() throws IOException {
        if (!this.f1384i.m1216d()) {
            m1129a("Current context not Array but ".concat(this.f1384i.m1220h()));
            throw null;
        }
        InterfaceC0550r interfaceC0550r = this.f1268e;
        if (interfaceC0550r != null) {
            interfaceC0550r.mo1225b(this, this.f1384i.f1309b + 1);
        } else {
            if (this.f1691u >= this.f1692v) {
                m1509c0();
            }
            byte[] bArr = this.f1690t;
            int i3 = this.f1691u;
            this.f1691u = i3 + 1;
            bArr[i3] = 93;
        }
        C0640e c0640e = this.f1384i;
        c0640e.f1662h = null;
        this.f1384i = c0640e.f1658d;
    }

    /* JADX INFO: renamed from: o0 */
    public final void m1520o0(int i3, char[] cArr, int i4) throws IOException {
        do {
            int iMin = Math.min(this.f1693w, i4);
            if (this.f1691u + iMin > this.f1692v) {
                m1509c0();
            }
            m1518m0(i3, cArr, iMin);
            i3 += iMin;
            i4 -= iMin;
        } while (i4 > 0);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: p */
    public final void mo1143p() throws IOException {
        if (!this.f1384i.m1217e()) {
            m1129a("Current context not Object but ".concat(this.f1384i.m1220h()));
            throw null;
        }
        InterfaceC0550r interfaceC0550r = this.f1268e;
        if (interfaceC0550r != null) {
            interfaceC0550r.mo1230g(this, this.f1384i.f1309b + 1);
        } else {
            if (this.f1691u >= this.f1692v) {
                m1509c0();
            }
            byte[] bArr = this.f1690t;
            int i3 = this.f1691u;
            this.f1691u = i3 + 1;
            bArr[i3] = 125;
        }
        C0640e c0640e = this.f1384i;
        c0640e.f1662h = null;
        this.f1384i = c0640e.f1658d;
    }

    /* JADX INFO: renamed from: p0 */
    public final void m1521p0(String str, boolean z3) throws IOException {
        byte b3 = this.f1689s;
        int i3 = this.f1692v;
        if (z3) {
            if (this.f1691u >= i3) {
                m1509c0();
            }
            byte[] bArr = this.f1690t;
            int i4 = this.f1691u;
            this.f1691u = i4 + 1;
            bArr[i4] = b3;
        }
        int length = str.length();
        int i5 = 0;
        while (length > 0) {
            int iMin = Math.min(this.f1693w, length);
            if (this.f1691u + iMin > i3) {
                m1509c0();
            }
            m1519n0(str, i5, iMin);
            i5 += iMin;
            length -= iMin;
        }
        if (z3) {
            if (this.f1691u >= i3) {
                m1509c0();
            }
            byte[] bArr2 = this.f1690t;
            int i6 = this.f1691u;
            this.f1691u = i6 + 1;
            bArr2[i6] = b3;
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: q */
    public final void mo1144q(InterfaceC0551s interfaceC0551s) throws IOException {
        InterfaceC0550r interfaceC0550r = this.f1268e;
        byte b3 = this.f1689s;
        int i3 = this.f1692v;
        if (interfaceC0550r != null) {
            C0597j c0597j = (C0597j) interfaceC0551s;
            int iM1471m = this.f1384i.m1471m(c0597j.f1531e);
            if (iM1471m == 4) {
                m1129a("Can not write a field name, expecting a value");
                throw null;
            }
            if (iM1471m == 1) {
                this.f1268e.mo1228e(this);
            } else {
                this.f1268e.mo1233j(this);
            }
            boolean z3 = !this.f1643o;
            if (z3) {
                if (this.f1691u >= i3) {
                    m1509c0();
                }
                byte[] bArr = this.f1690t;
                int i4 = this.f1691u;
                this.f1691u = i4 + 1;
                bArr[i4] = b3;
            }
            int iM1364a = c0597j.m1364a(this.f1690t, this.f1691u);
            if (iM1364a < 0) {
                m1514i0(c0597j.m1366c());
            } else {
                this.f1691u += iM1364a;
            }
            if (z3) {
                if (this.f1691u >= i3) {
                    m1509c0();
                }
                byte[] bArr2 = this.f1690t;
                int i5 = this.f1691u;
                this.f1691u = i5 + 1;
                bArr2[i5] = b3;
                return;
            }
            return;
        }
        C0597j c0597j2 = (C0597j) interfaceC0551s;
        int iM1471m2 = this.f1384i.m1471m(c0597j2.f1531e);
        if (iM1471m2 == 4) {
            m1129a("Can not write a field name, expecting a value");
            throw null;
        }
        if (iM1471m2 == 1) {
            if (this.f1691u >= i3) {
                m1509c0();
            }
            byte[] bArr3 = this.f1690t;
            int i6 = this.f1691u;
            this.f1691u = i6 + 1;
            bArr3[i6] = 44;
        }
        if (this.f1643o) {
            int iM1364a2 = c0597j2.m1364a(this.f1690t, this.f1691u);
            if (iM1364a2 < 0) {
                m1514i0(c0597j2.m1366c());
                return;
            } else {
                this.f1691u += iM1364a2;
                return;
            }
        }
        if (this.f1691u >= i3) {
            m1509c0();
        }
        byte[] bArr4 = this.f1690t;
        int i7 = this.f1691u;
        int i8 = i7 + 1;
        this.f1691u = i8;
        bArr4[i7] = b3;
        int iM1364a3 = c0597j2.m1364a(bArr4, i8);
        if (iM1364a3 < 0) {
            m1514i0(c0597j2.m1366c());
        } else {
            this.f1691u += iM1364a3;
        }
        if (this.f1691u >= i3) {
            m1509c0();
        }
        byte[] bArr5 = this.f1690t;
        int i9 = this.f1691u;
        this.f1691u = i9 + 1;
        bArr5[i9] = b3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: r */
    public final void mo1145r(String str) throws IOException {
        InterfaceC0550r interfaceC0550r = this.f1268e;
        byte b3 = this.f1689s;
        int i3 = this.f1695y;
        int i4 = this.f1693w;
        int i5 = 0;
        int i6 = this.f1692v;
        if (interfaceC0550r != null) {
            int iM1471m = this.f1384i.m1471m(str);
            if (iM1471m == 4) {
                m1129a("Can not write a field name, expecting a value");
                throw null;
            }
            if (iM1471m == 1) {
                this.f1268e.mo1228e(this);
            } else {
                this.f1268e.mo1233j(this);
            }
            if (this.f1643o) {
                m1521p0(str, false);
                return;
            }
            int length = str.length();
            if (length > i3) {
                m1521p0(str, true);
                return;
            }
            if (this.f1691u >= i6) {
                m1509c0();
            }
            byte[] bArr = this.f1690t;
            int i7 = this.f1691u;
            this.f1691u = i7 + 1;
            bArr[i7] = b3;
            str.getChars(0, length, this.f1694x, 0);
            if (length <= i4) {
                if (this.f1691u + length > i6) {
                    m1509c0();
                }
                m1518m0(0, this.f1694x, length);
            } else {
                m1520o0(0, this.f1694x, length);
            }
            if (this.f1691u >= i6) {
                m1509c0();
            }
            byte[] bArr2 = this.f1690t;
            int i8 = this.f1691u;
            this.f1691u = i8 + 1;
            bArr2[i8] = b3;
            return;
        }
        int iM1471m2 = this.f1384i.m1471m(str);
        if (iM1471m2 == 4) {
            m1129a("Can not write a field name, expecting a value");
            throw null;
        }
        if (iM1471m2 == 1) {
            if (this.f1691u >= i6) {
                m1509c0();
            }
            byte[] bArr3 = this.f1690t;
            int i9 = this.f1691u;
            this.f1691u = i9 + 1;
            bArr3[i9] = 44;
        }
        if (this.f1643o) {
            m1521p0(str, false);
            return;
        }
        int length2 = str.length();
        if (length2 > i3) {
            m1521p0(str, true);
            return;
        }
        if (this.f1691u >= i6) {
            m1509c0();
        }
        byte[] bArr4 = this.f1690t;
        int i10 = this.f1691u;
        int i11 = i10 + 1;
        this.f1691u = i11;
        bArr4[i10] = b3;
        if (length2 <= i4) {
            if (i11 + length2 > i6) {
                m1509c0();
            }
            m1519n0(str, 0, length2);
        } else {
            do {
                int iMin = Math.min(i4, length2);
                if (this.f1691u + iMin > i6) {
                    m1509c0();
                }
                m1519n0(str, i5, iMin);
                i5 += iMin;
                length2 -= iMin;
            } while (length2 > 0);
        }
        if (this.f1691u >= i6) {
            m1509c0();
        }
        byte[] bArr5 = this.f1690t;
        int i12 = this.f1691u;
        this.f1691u = i12 + 1;
        bArr5[i12] = b3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: s */
    public final void mo1146s() throws IOException {
        mo1248Y("write a null");
        m1516k0();
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: t */
    public final void mo1147t(double d) throws IOException {
        if (!this.f1383h) {
            String str = AbstractC0595h.f1524a;
            if (!(!Double.isFinite(d)) || !EnumC0539g.QUOTE_NON_NUMERIC_NUMBERS.m1106a(this.f1382g)) {
                mo1248Y("write a number");
                mo1113F(AbstractC0595h.m1362k(d, mo1134g(EnumC0539g.USE_FAST_DOUBLE_WRITER)));
                return;
            }
        }
        mo1125R(AbstractC0595h.m1362k(d, mo1134g(EnumC0539g.USE_FAST_DOUBLE_WRITER)));
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: u */
    public final void mo1148u(float f3) throws IOException {
        if (!this.f1383h) {
            String str = AbstractC0595h.f1524a;
            if (!(!Float.isFinite(f3)) || !EnumC0539g.QUOTE_NON_NUMERIC_NUMBERS.m1106a(this.f1382g)) {
                mo1248Y("write a number");
                mo1113F(AbstractC0595h.m1363l(f3, mo1134g(EnumC0539g.USE_FAST_DOUBLE_WRITER)));
                return;
            }
        }
        mo1125R(AbstractC0595h.m1363l(f3, mo1134g(EnumC0539g.USE_FAST_DOUBLE_WRITER)));
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: v */
    public final void mo1149v(int i3) throws IOException {
        mo1248Y("write a number");
        int i4 = this.f1691u + 11;
        int i5 = this.f1692v;
        if (i4 >= i5) {
            m1509c0();
        }
        if (!this.f1383h) {
            this.f1691u = AbstractC0595h.m1358g(i3, this.f1690t, this.f1691u);
            return;
        }
        if (this.f1691u + 13 >= i5) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i6 = this.f1691u;
        int i7 = i6 + 1;
        this.f1691u = i7;
        byte b3 = this.f1689s;
        bArr[i6] = b3;
        int iM1358g = AbstractC0595h.m1358g(i3, bArr, i7);
        byte[] bArr2 = this.f1690t;
        this.f1691u = iM1358g + 1;
        bArr2[iM1358g] = b3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: w */
    public final void mo1150w(long j2) throws IOException {
        mo1248Y("write a number");
        boolean z3 = this.f1383h;
        int i3 = this.f1692v;
        if (!z3) {
            if (this.f1691u + 21 >= i3) {
                m1509c0();
            }
            this.f1691u = AbstractC0595h.m1360i(j2, this.f1690t, this.f1691u);
            return;
        }
        if (this.f1691u + 23 >= i3) {
            m1509c0();
        }
        byte[] bArr = this.f1690t;
        int i4 = this.f1691u;
        int i5 = i4 + 1;
        this.f1691u = i5;
        byte b3 = this.f1689s;
        bArr[i4] = b3;
        int iM1360i = AbstractC0595h.m1360i(j2, bArr, i5);
        byte[] bArr2 = this.f1690t;
        this.f1691u = iM1360i + 1;
        bArr2[iM1360i] = b3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: x */
    public final void mo1151x(String str) throws IOException {
        mo1248Y("write a number");
        if (str == null) {
            m1516k0();
        } else if (this.f1383h) {
            m1517l0(str);
        } else {
            mo1113F(str);
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: y */
    public final void mo1152y(BigDecimal bigDecimal) throws IOException {
        mo1248Y("write a number");
        if (bigDecimal == null) {
            m1516k0();
        } else if (this.f1383h) {
            m1517l0(m1245V(bigDecimal));
        } else {
            mo1113F(m1245V(bigDecimal));
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: z */
    public final void mo1153z(BigInteger bigInteger) throws IOException {
        mo1248Y("write a number");
        if (bigInteger == null) {
            m1516k0();
        } else if (this.f1383h) {
            m1517l0(bigInteger.toString());
        } else {
            mo1113F(bigInteger.toString());
        }
    }
}
