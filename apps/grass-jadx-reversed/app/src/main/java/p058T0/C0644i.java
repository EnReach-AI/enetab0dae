package p058T0;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
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

/* JADX INFO: renamed from: T0.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0644i extends AbstractC0637b {

    /* JADX INFO: renamed from: y */
    public static final char[] f1717y = AbstractC0589b.m1335b(true);

    /* JADX INFO: renamed from: z */
    public static final char[] f1718z = AbstractC0589b.m1335b(false);

    /* JADX INFO: renamed from: r */
    public final Writer f1719r;

    /* JADX INFO: renamed from: s */
    public final char f1720s;

    /* JADX INFO: renamed from: t */
    public char[] f1721t;

    /* JADX INFO: renamed from: u */
    public int f1722u;

    /* JADX INFO: renamed from: v */
    public int f1723v;

    /* JADX INFO: renamed from: w */
    public final int f1724w;

    /* JADX INFO: renamed from: x */
    public char[] f1725x;

    public C0644i(C0283l c0283l, int i3, AbstractC0549q abstractC0549q, Writer writer, char c3) {
        super(c0283l, i3, abstractC0549q);
        this.f1719r = writer;
        C0283l.m556a((char[]) c0283l.f765k);
        char[] cArrM1633b = ((C0674a) c0283l.f759e).m1633b(1, 0);
        c0283l.f765k = cArrM1633b;
        this.f1721t = cArrM1633b;
        this.f1724w = cArrM1633b.length;
        this.f1720s = c3;
        if (c3 != '\"') {
            this.f1640l = AbstractC0589b.m1336c(c3);
        }
    }

    /* JADX INFO: renamed from: h0 */
    public static int m1581h0(InputStream inputStream, byte[] bArr, int i3, int i4, int i5) throws IOException {
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
        boolean z3 = this.f1383h;
        int i3 = this.f1724w;
        if (!z3) {
            if (this.f1723v + 6 >= i3) {
                m1584e0();
            }
            this.f1723v = AbstractC0595h.m1359h(s3, this.f1721t, this.f1723v);
            return;
        }
        if (this.f1723v + 8 >= i3) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i4 = this.f1723v;
        int i5 = i4 + 1;
        this.f1723v = i5;
        char c3 = this.f1720s;
        cArr[i4] = c3;
        int iM1359h = AbstractC0595h.m1359h(s3, cArr, i5);
        char[] cArr2 = this.f1721t;
        this.f1723v = iM1359h + 1;
        cArr2[iM1359h] = c3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: D */
    public final void mo1111D(char c3) throws IOException {
        if (this.f1723v >= this.f1724w) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i3 = this.f1723v;
        this.f1723v = i3 + 1;
        cArr[i3] = c3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: E */
    public final void mo1112E(InterfaceC0551s interfaceC0551s) throws IOException {
        char[] cArr = this.f1721t;
        int i3 = this.f1723v;
        C0597j c0597j = (C0597j) interfaceC0551s;
        String str = c0597j.f1531e;
        int length = str.length();
        if (i3 + length > cArr.length) {
            length = -1;
        } else {
            str.getChars(0, length, cArr, i3);
        }
        if (length < 0) {
            mo1113F(c0597j.f1531e);
        } else {
            this.f1723v += length;
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: F */
    public final void mo1113F(String str) throws IOException {
        int length = str.length();
        int i3 = this.f1723v;
        int i4 = this.f1724w;
        int i5 = i4 - i3;
        if (i5 == 0) {
            m1584e0();
            i5 = i4 - this.f1723v;
        }
        if (i5 >= length) {
            str.getChars(0, length, this.f1721t, this.f1723v);
            this.f1723v += length;
            return;
        }
        int i6 = this.f1723v;
        int i7 = i4 - i6;
        str.getChars(0, i7, this.f1721t, i6);
        this.f1723v += i7;
        m1584e0();
        int length2 = str.length() - i7;
        while (length2 > i4) {
            int i8 = i7 + i4;
            str.getChars(i7, i8, this.f1721t, 0);
            this.f1722u = 0;
            this.f1723v = i4;
            m1584e0();
            length2 -= i4;
            i7 = i8;
        }
        str.getChars(i7, i7 + length2, this.f1721t, 0);
        this.f1722u = 0;
        this.f1723v = length2;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: G */
    public final void mo1114G(char[] cArr, int i3) throws IOException {
        m1247X(cArr, i3);
        if (i3 >= 32) {
            m1584e0();
            this.f1719r.write(cArr, 0, i3);
        } else {
            if (i3 > this.f1724w - this.f1723v) {
                m1584e0();
            }
            System.arraycopy(cArr, 0, this.f1721t, this.f1723v, i3);
            this.f1723v += i3;
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
        if (this.f1723v >= this.f1724w) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i3 = this.f1723v;
        this.f1723v = i3 + 1;
        cArr[i3] = '[';
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
        if (this.f1723v >= this.f1724w) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i3 = this.f1723v;
        this.f1723v = i3 + 1;
        cArr[i3] = '[';
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
        if (this.f1723v >= this.f1724w) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i3 = this.f1723v;
        this.f1723v = i3 + 1;
        cArr[i3] = '[';
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
        if (this.f1723v >= this.f1724w) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i3 = this.f1723v;
        this.f1723v = i3 + 1;
        cArr[i3] = '{';
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
        if (this.f1723v >= this.f1724w) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i3 = this.f1723v;
        this.f1723v = i3 + 1;
        cArr[i3] = '{';
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[PHI: r11
      0x0045: PHI (r11v6 int) = (r11v3 int), (r11v7 int) binds: [B:15:0x0041, B:13:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: P */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo1123P(int r17, char[] r18, int r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0644i.mo1123P(int, char[], int):void");
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: Q */
    public final void mo1124Q(InterfaceC0551s interfaceC0551s) throws IOException {
        mo1248Y("write a string");
        int i3 = this.f1723v;
        int i4 = this.f1724w;
        if (i3 >= i4) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i5 = this.f1723v;
        int i6 = i5 + 1;
        this.f1723v = i6;
        char c3 = this.f1720s;
        cArr[i5] = c3;
        C0597j c0597j = (C0597j) interfaceC0551s;
        char[] cArrM1341d = c0597j.f1534h;
        if (cArrM1341d == null) {
            C0597j.f1530j.getClass();
            cArrM1341d = C0592e.m1341d(c0597j.f1531e);
            c0597j.f1534h = cArrM1341d;
        }
        int length = cArrM1341d.length;
        if (i6 + length > cArr.length) {
            length = -1;
        } else {
            System.arraycopy(cArrM1341d, 0, cArr, i6, length);
        }
        if (length >= 0) {
            int i7 = this.f1723v + length;
            this.f1723v = i7;
            if (i7 >= i4) {
                m1584e0();
            }
            char[] cArr2 = this.f1721t;
            int i8 = this.f1723v;
            this.f1723v = i8 + 1;
            cArr2[i8] = c3;
            return;
        }
        char[] cArrM1365b = c0597j.m1365b();
        int length2 = cArrM1365b.length;
        if (length2 < 32) {
            if (length2 > i4 - this.f1723v) {
                m1584e0();
            }
            System.arraycopy(cArrM1365b, 0, this.f1721t, this.f1723v, length2);
            this.f1723v += length2;
        } else {
            m1584e0();
            this.f1719r.write(cArrM1365b, 0, length2);
        }
        if (this.f1723v >= i4) {
            m1584e0();
        }
        char[] cArr3 = this.f1721t;
        int i9 = this.f1723v;
        this.f1723v = i9 + 1;
        cArr3[i9] = c3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: R */
    public final void mo1125R(String str) throws IOException {
        mo1248Y("write a string");
        if (str == null) {
            m1589k0();
            return;
        }
        int i3 = this.f1723v;
        int i4 = this.f1724w;
        if (i3 >= i4) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i5 = this.f1723v;
        this.f1723v = i5 + 1;
        char c3 = this.f1720s;
        cArr[i5] = c3;
        m1591m0(str);
        if (this.f1723v >= i4) {
            m1584e0();
        }
        char[] cArr2 = this.f1721t;
        int i6 = this.f1723v;
        this.f1723v = i6 + 1;
        cArr2[i6] = c3;
    }

    @Override // p045O0.AbstractC0569a
    /* JADX INFO: renamed from: Y */
    public final void mo1248Y(String str) throws IOException {
        char c3;
        int iM1472n = this.f1384i.m1472n();
        if (this.f1268e != null) {
            m1463a0(iM1472n, str);
            return;
        }
        if (iM1472n == 1) {
            c3 = ',';
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
                    mo1113F(((C0597j) interfaceC0551s).f1531e);
                    return;
                }
                return;
            }
            c3 = ':';
        }
        if (this.f1723v >= this.f1724w) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i3 = this.f1723v;
        this.f1723v = i3 + 1;
        cArr[i3] = c3;
    }

    /* JADX INFO: renamed from: c0 */
    public final char[] m1582c0() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u', 0, 0, 0, 0};
        this.f1725x = cArr;
        return cArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0057  */
    @Override // p042N0.AbstractC0540h, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            char[] r1 = r6.f1721t     // Catch: java.io.IOException -> L23
            if (r1 == 0) goto L25
            N0.g r1 = p042N0.EnumC0539g.AUTO_CLOSE_JSON_CONTENT     // Catch: java.io.IOException -> L23
            boolean r1 = r6.mo1134g(r1)     // Catch: java.io.IOException -> L23
            if (r1 == 0) goto L25
        Ld:
            T0.e r1 = r6.f1384i     // Catch: java.io.IOException -> L23
            boolean r2 = r1.m1216d()     // Catch: java.io.IOException -> L23
            if (r2 == 0) goto L19
            r6.mo1142o()     // Catch: java.io.IOException -> L23
            goto Ld
        L19:
            boolean r1 = r1.m1217e()     // Catch: java.io.IOException -> L23
            if (r1 == 0) goto L25
            r6.mo1143p()     // Catch: java.io.IOException -> L23
            goto Ld
        L23:
            r1 = move-exception
            goto L29
        L25:
            r6.m1584e0()     // Catch: java.io.IOException -> L23
            r1 = r0
        L29:
            r2 = 0
            r6.f1722u = r2
            r6.f1723v = r2
            H1.l r2 = r6.f1639k
            java.io.Writer r3 = r6.f1719r
            if (r3 == 0) goto L5b
            boolean r4 = r2.f755a     // Catch: java.lang.RuntimeException -> L4d java.io.IOException -> L4f
            if (r4 != 0) goto L51
            N0.g r4 = p042N0.EnumC0539g.AUTO_CLOSE_TARGET     // Catch: java.lang.RuntimeException -> L4d java.io.IOException -> L4f
            boolean r4 = r6.mo1134g(r4)     // Catch: java.lang.RuntimeException -> L4d java.io.IOException -> L4f
            if (r4 == 0) goto L41
            goto L51
        L41:
            N0.g r4 = p042N0.EnumC0539g.FLUSH_PASSED_TO_STREAM     // Catch: java.lang.RuntimeException -> L4d java.io.IOException -> L4f
            boolean r4 = r6.mo1134g(r4)     // Catch: java.lang.RuntimeException -> L4d java.io.IOException -> L4f
            if (r4 == 0) goto L5b
            r3.flush()     // Catch: java.lang.RuntimeException -> L4d java.io.IOException -> L4f
            goto L5b
        L4d:
            r0 = move-exception
            goto L55
        L4f:
            r0 = move-exception
            goto L55
        L51:
            r3.close()     // Catch: java.lang.RuntimeException -> L4d java.io.IOException -> L4f
            goto L5b
        L55:
            if (r1 == 0) goto L5a
            r0.addSuppressed(r1)
        L5a:
            throw r0
        L5b:
            char[] r3 = r6.f1721t
            if (r3 == 0) goto L80
            r6.f1721t = r0
            java.lang.Object r4 = r2.f765k
            char[] r4 = (char[]) r4
            if (r3 == r4) goto L74
            int r5 = r3.length
            int r4 = r4.length
            if (r5 < r4) goto L6c
            goto L74
        L6c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Trying to release buffer smaller than original"
            r0.<init>(r1)
            throw r0
        L74:
            r2.f765k = r0
            java.lang.Object r0 = r2.f759e
            W0.a r0 = (p066W0.C0674a) r0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.f1835b
            r2 = 1
            r0.set(r2, r3)
        L80:
            if (r1 != 0) goto L83
            return
        L83:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0644i.close():void");
    }

    /* JADX INFO: renamed from: d0 */
    public final void m1583d0(char c3, int i3) throws IOException {
        int i4;
        int i5 = this.f1724w;
        if (i3 >= 0) {
            if (this.f1723v + 2 > i5) {
                m1584e0();
            }
            char[] cArr = this.f1721t;
            int i6 = this.f1723v;
            int i7 = i6 + 1;
            this.f1723v = i7;
            cArr[i6] = '\\';
            this.f1723v = i6 + 2;
            cArr[i7] = (char) i3;
            return;
        }
        if (i3 == -2) {
            throw null;
        }
        if (this.f1723v + 5 >= i5) {
            m1584e0();
        }
        int i8 = this.f1723v;
        char[] cArr2 = this.f1721t;
        char[] cArr3 = this.f1644p ? f1717y : f1718z;
        cArr2[i8] = '\\';
        int i9 = i8 + 2;
        cArr2[i8 + 1] = 'u';
        if (c3 > 255) {
            int i10 = c3 >> '\b';
            int i11 = i8 + 3;
            cArr2[i9] = cArr3[(i10 & 255) >> 4];
            i4 = i8 + 4;
            cArr2[i11] = cArr3[i10 & 15];
            c3 = (char) (c3 & 255);
        } else {
            int i12 = i8 + 3;
            cArr2[i9] = '0';
            i4 = i8 + 4;
            cArr2[i12] = '0';
        }
        cArr2[i4] = cArr3[c3 >> 4];
        cArr2[i4 + 1] = cArr3[c3 & 15];
        this.f1723v = i4 + 2;
    }

    /* JADX INFO: renamed from: e0 */
    public final void m1584e0() throws IOException {
        int i3 = this.f1723v;
        int i4 = this.f1722u;
        int i5 = i3 - i4;
        if (i5 > 0) {
            this.f1722u = 0;
            this.f1723v = 0;
            this.f1719r.write(this.f1721t, i4, i5);
        }
    }

    /* JADX INFO: renamed from: f0 */
    public final int m1585f0(char[] cArr, int i3, int i4, char c3, int i5) throws IOException {
        int i6;
        Writer writer = this.f1719r;
        if (i5 >= 0) {
            if (i3 > 1 && i3 < i4) {
                int i7 = i3 - 2;
                cArr[i7] = '\\';
                cArr[i3 - 1] = (char) i5;
                return i7;
            }
            char[] cArrM1582c0 = this.f1725x;
            if (cArrM1582c0 == null) {
                cArrM1582c0 = m1582c0();
            }
            cArrM1582c0[1] = (char) i5;
            writer.write(cArrM1582c0, 0, 2);
            return i3;
        }
        if (i5 == -2) {
            throw null;
        }
        char[] cArr2 = this.f1644p ? f1717y : f1718z;
        if (i3 <= 5 || i3 >= i4) {
            char[] cArrM1582c02 = this.f1725x;
            if (cArrM1582c02 == null) {
                cArrM1582c02 = m1582c0();
            }
            this.f1722u = this.f1723v;
            if (c3 <= 255) {
                cArrM1582c02[6] = cArr2[c3 >> 4];
                cArrM1582c02[7] = cArr2[c3 & 15];
                writer.write(cArrM1582c02, 2, 6);
                return i3;
            }
            int i8 = c3 >> '\b';
            cArrM1582c02[10] = cArr2[(i8 & 255) >> 4];
            cArrM1582c02[11] = cArr2[i8 & 15];
            cArrM1582c02[12] = cArr2[(c3 & 255) >> 4];
            cArrM1582c02[13] = cArr2[c3 & 15];
            writer.write(cArrM1582c02, 8, 6);
            return i3;
        }
        cArr[i3 - 6] = '\\';
        int i9 = i3 - 4;
        cArr[i3 - 5] = 'u';
        if (c3 > 255) {
            int i10 = c3 >> '\b';
            int i11 = i3 - 3;
            cArr[i9] = cArr2[(i10 & 255) >> 4];
            i6 = i3 - 2;
            cArr[i11] = cArr2[i10 & 15];
            c3 = (char) (c3 & 255);
        } else {
            int i12 = i3 - 3;
            cArr[i9] = '0';
            i6 = i3 - 2;
            cArr[i12] = '0';
        }
        cArr[i6] = cArr2[c3 >> 4];
        cArr[i6 + 1] = cArr2[c3 & 15];
        return i6 - 4;
    }

    @Override // p042N0.AbstractC0540h, java.io.Flushable
    public final void flush() throws IOException {
        m1584e0();
        Writer writer = this.f1719r;
        if (writer == null || !mo1134g(EnumC0539g.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        writer.flush();
    }

    /* JADX INFO: renamed from: g0 */
    public final void m1586g0(char c3, int i3) throws IOException {
        int i4;
        Writer writer = this.f1719r;
        if (i3 >= 0) {
            int i5 = this.f1723v;
            if (i5 >= 2) {
                int i6 = i5 - 2;
                this.f1722u = i6;
                char[] cArr = this.f1721t;
                cArr[i6] = '\\';
                cArr[i5 - 1] = (char) i3;
                return;
            }
            char[] cArrM1582c0 = this.f1725x;
            if (cArrM1582c0 == null) {
                cArrM1582c0 = m1582c0();
            }
            this.f1722u = this.f1723v;
            cArrM1582c0[1] = (char) i3;
            writer.write(cArrM1582c0, 0, 2);
            return;
        }
        if (i3 == -2) {
            throw null;
        }
        char[] cArr2 = this.f1644p ? f1717y : f1718z;
        int i7 = this.f1723v;
        if (i7 < 6) {
            char[] cArrM1582c02 = this.f1725x;
            if (cArrM1582c02 == null) {
                cArrM1582c02 = m1582c0();
            }
            this.f1722u = this.f1723v;
            if (c3 <= 255) {
                cArrM1582c02[6] = cArr2[c3 >> 4];
                cArrM1582c02[7] = cArr2[c3 & 15];
                writer.write(cArrM1582c02, 2, 6);
                return;
            } else {
                int i8 = c3 >> '\b';
                cArrM1582c02[10] = cArr2[(i8 & 255) >> 4];
                cArrM1582c02[11] = cArr2[i8 & 15];
                cArrM1582c02[12] = cArr2[(c3 & 255) >> 4];
                cArrM1582c02[13] = cArr2[c3 & 15];
                writer.write(cArrM1582c02, 8, 6);
                return;
            }
        }
        char[] cArr3 = this.f1721t;
        int i9 = i7 - 6;
        this.f1722u = i9;
        cArr3[i9] = '\\';
        cArr3[i7 - 5] = 'u';
        if (c3 > 255) {
            int i10 = c3 >> '\b';
            cArr3[i7 - 4] = cArr2[(i10 & 255) >> 4];
            i4 = i7 - 3;
            cArr3[i4] = cArr2[i10 & 15];
            c3 = (char) (c3 & 255);
        } else {
            cArr3[i7 - 4] = '0';
            i4 = i7 - 3;
            cArr3[i4] = '0';
        }
        cArr3[i4 + 1] = cArr2[c3 >> 4];
        cArr3[i4 + 2] = cArr2[c3 & 15];
    }

    /* JADX INFO: renamed from: i0 */
    public final int m1587i0(C0533a c0533a, InputStream inputStream, byte[] bArr) throws IOException {
        int i3 = this.f1724w - 6;
        int i4 = 2;
        int i5 = c0533a.f1224j >> 2;
        int i6 = -3;
        int i7 = 0;
        int iM1581h0 = 0;
        int i8 = 0;
        while (true) {
            if (i7 > i6) {
                iM1581h0 = m1581h0(inputStream, bArr, i7, iM1581h0, bArr.length);
                if (iM1581h0 < 3) {
                    break;
                }
                i6 = iM1581h0 - 3;
                i7 = 0;
            }
            if (this.f1723v > i3) {
                m1584e0();
            }
            int i9 = i7 + 2;
            int i10 = ((bArr[i7 + 1] & 255) | (bArr[i7] << 8)) << 8;
            i7 += 3;
            i8 += 3;
            int iM1077g = c0533a.m1077g((bArr[i9] & 255) | i10, this.f1721t, this.f1723v);
            this.f1723v = iM1077g;
            i5--;
            if (i5 <= 0) {
                char[] cArr = this.f1721t;
                int i11 = iM1077g + 1;
                this.f1723v = i11;
                cArr[iM1077g] = '\\';
                this.f1723v = iM1077g + 2;
                cArr[i11] = 'n';
                i5 = c0533a.f1224j >> 2;
            }
        }
        if (iM1581h0 <= 0) {
            return i8;
        }
        if (this.f1723v > i3) {
            m1584e0();
        }
        int i12 = bArr[0] << 16;
        if (1 < iM1581h0) {
            i12 |= (bArr[1] & 255) << 8;
        } else {
            i4 = 1;
        }
        int i13 = i8 + i4;
        this.f1723v = c0533a.m1078h(i12, i4, this.f1723v, this.f1721t);
        return i13;
    }

    /* JADX INFO: renamed from: j0 */
    public final int m1588j0(C0533a c0533a, InputStream inputStream, byte[] bArr, int i3) throws IOException {
        int iM1581h0;
        int i4 = this.f1724w - 6;
        int i5 = 2;
        int i6 = c0533a.f1224j >> 2;
        int i7 = -3;
        int i8 = 0;
        int iM1581h02 = 0;
        while (true) {
            if (i3 <= 2) {
                break;
            }
            if (i8 > i7) {
                iM1581h02 = m1581h0(inputStream, bArr, i8, iM1581h02, i3);
                if (iM1581h02 < 3) {
                    i8 = 0;
                    break;
                }
                i7 = iM1581h02 - 3;
                i8 = 0;
            }
            if (this.f1723v > i4) {
                m1584e0();
            }
            int i9 = i8 + 2;
            int i10 = ((bArr[i8 + 1] & 255) | (bArr[i8] << 8)) << 8;
            i8 += 3;
            i3 -= 3;
            int iM1077g = c0533a.m1077g((bArr[i9] & 255) | i10, this.f1721t, this.f1723v);
            this.f1723v = iM1077g;
            i6--;
            if (i6 <= 0) {
                char[] cArr = this.f1721t;
                int i11 = iM1077g + 1;
                this.f1723v = i11;
                cArr[iM1077g] = '\\';
                this.f1723v = iM1077g + 2;
                cArr[i11] = 'n';
                i6 = c0533a.f1224j >> 2;
            }
        }
        if (i3 <= 0 || (iM1581h0 = m1581h0(inputStream, bArr, i8, iM1581h02, i3)) <= 0) {
            return i3;
        }
        if (this.f1723v > i4) {
            m1584e0();
        }
        int i12 = bArr[0] << 16;
        if (1 < iM1581h0) {
            i12 |= (bArr[1] & 255) << 8;
        } else {
            i5 = 1;
        }
        this.f1723v = c0533a.m1078h(i12, i5, this.f1723v, this.f1721t);
        return i3 - i5;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: k */
    public final int mo1138k(C0533a c0533a, InputStream inputStream, int i3) throws IOException {
        mo1248Y("write a binary value");
        int i4 = this.f1723v;
        int i5 = this.f1724w;
        if (i4 >= i5) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i6 = this.f1723v;
        this.f1723v = i6 + 1;
        char c3 = this.f1720s;
        cArr[i6] = c3;
        C0283l c0283l = this.f1639k;
        byte[] bArrM557b = c0283l.m557b();
        try {
            if (i3 < 0) {
                i3 = m1587i0(c0533a, inputStream, bArrM557b);
            } else {
                int iM1588j0 = m1588j0(c0533a, inputStream, bArrM557b, i3);
                if (iM1588j0 > 0) {
                    m1129a("Too few bytes available: missing " + iM1588j0 + " bytes (out of " + i3 + ")");
                    throw null;
                }
            }
            c0283l.m560e(bArrM557b);
            if (this.f1723v >= i5) {
                m1584e0();
            }
            char[] cArr2 = this.f1721t;
            int i7 = this.f1723v;
            this.f1723v = i7 + 1;
            cArr2[i7] = c3;
            return i3;
        } catch (Throwable th) {
            c0283l.m560e(bArrM557b);
            throw th;
        }
    }

    /* JADX INFO: renamed from: k0 */
    public final void m1589k0() throws IOException {
        if (this.f1723v + 4 >= this.f1724w) {
            m1584e0();
        }
        int i3 = this.f1723v;
        char[] cArr = this.f1721t;
        cArr[i3] = 'n';
        cArr[i3 + 1] = 'u';
        cArr[i3 + 2] = 'l';
        cArr[i3 + 3] = 'l';
        this.f1723v = i3 + 4;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: l */
    public final void mo1139l(C0533a c0533a, byte[] bArr, int i3, int i4) throws IOException {
        int iM1077g;
        m1246W(i3, bArr, i4);
        mo1248Y("write a binary value");
        int i5 = this.f1723v;
        int i6 = this.f1724w;
        if (i5 >= i6) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i7 = this.f1723v;
        this.f1723v = i7 + 1;
        char c3 = this.f1720s;
        cArr[i7] = c3;
        int i8 = i4 + i3;
        int i9 = i8 - 3;
        int i10 = i6 - 6;
        int i11 = c0533a.f1224j;
        loop0: while (true) {
            int i12 = i11 >> 2;
            while (i3 <= i9) {
                if (this.f1723v > i10) {
                    m1584e0();
                }
                int i13 = i3 + 2;
                int i14 = ((bArr[i3 + 1] & 255) | (bArr[i3] << 8)) << 8;
                i3 += 3;
                iM1077g = c0533a.m1077g(i14 | (bArr[i13] & 255), this.f1721t, this.f1723v);
                this.f1723v = iM1077g;
                i12--;
                if (i12 <= 0) {
                    break;
                }
            }
            char[] cArr2 = this.f1721t;
            int i15 = iM1077g + 1;
            this.f1723v = i15;
            cArr2[iM1077g] = '\\';
            this.f1723v = iM1077g + 2;
            cArr2[i15] = 'n';
            i11 = c0533a.f1224j;
        }
        int i16 = i8 - i3;
        if (i16 > 0) {
            if (this.f1723v > i10) {
                m1584e0();
            }
            int i17 = i3 + 1;
            int i18 = bArr[i3] << 16;
            if (i16 == 2) {
                i18 |= (bArr[i17] & 255) << 8;
            }
            this.f1723v = c0533a.m1078h(i18, i16, this.f1723v, this.f1721t);
        }
        if (this.f1723v >= i6) {
            m1584e0();
        }
        char[] cArr3 = this.f1721t;
        int i19 = this.f1723v;
        this.f1723v = i19 + 1;
        cArr3[i19] = c3;
    }

    /* JADX INFO: renamed from: l0 */
    public final void m1590l0(String str) throws IOException {
        int i3 = this.f1723v;
        int i4 = this.f1724w;
        if (i3 >= i4) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i5 = this.f1723v;
        this.f1723v = i5 + 1;
        char c3 = this.f1720s;
        cArr[i5] = c3;
        mo1113F(str);
        if (this.f1723v >= i4) {
            m1584e0();
        }
        char[] cArr2 = this.f1721t;
        int i6 = this.f1723v;
        this.f1723v = i6 + 1;
        cArr2[i6] = c3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: m */
    public final void mo1140m(boolean z3) throws IOException {
        int i3;
        mo1248Y("write a boolean value");
        if (this.f1723v + 5 >= this.f1724w) {
            m1584e0();
        }
        int i4 = this.f1723v;
        char[] cArr = this.f1721t;
        if (z3) {
            cArr[i4] = 't';
            cArr[i4 + 1] = 'r';
            cArr[i4 + 2] = 'u';
            i3 = i4 + 3;
            cArr[i3] = 'e';
        } else {
            cArr[i4] = 'f';
            cArr[i4 + 1] = 'a';
            cArr[i4 + 2] = 'l';
            cArr[i4 + 3] = 's';
            i3 = i4 + 4;
            cArr[i3] = 'e';
        }
        this.f1723v = i3 + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e5  */
    /* JADX INFO: renamed from: m0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1591m0(java.lang.String r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0644i.m1591m0(java.lang.String):void");
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
            if (this.f1723v >= this.f1724w) {
                m1584e0();
            }
            char[] cArr = this.f1721t;
            int i3 = this.f1723v;
            this.f1723v = i3 + 1;
            cArr[i3] = ']';
        }
        C0640e c0640e = this.f1384i;
        c0640e.f1662h = null;
        this.f1384i = c0640e.f1658d;
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
            if (this.f1723v >= this.f1724w) {
                m1584e0();
            }
            char[] cArr = this.f1721t;
            int i3 = this.f1723v;
            this.f1723v = i3 + 1;
            cArr[i3] = '}';
        }
        C0640e c0640e = this.f1384i;
        c0640e.f1662h = null;
        this.f1384i = c0640e.f1658d;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: q */
    public final void mo1144q(InterfaceC0551s interfaceC0551s) throws IOException {
        C0597j c0597j = (C0597j) interfaceC0551s;
        int iM1471m = this.f1384i.m1471m(c0597j.f1531e);
        if (iM1471m == 4) {
            m1129a("Can not write a field name, expecting a value");
            throw null;
        }
        boolean z3 = iM1471m == 1;
        InterfaceC0550r interfaceC0550r = this.f1268e;
        char c3 = this.f1720s;
        int i3 = this.f1724w;
        if (interfaceC0550r != null) {
            if (z3) {
                interfaceC0550r.mo1228e(this);
            } else {
                interfaceC0550r.mo1233j(this);
            }
            char[] cArrM1365b = c0597j.m1365b();
            if (this.f1643o) {
                mo1114G(cArrM1365b, cArrM1365b.length);
                return;
            }
            if (this.f1723v >= i3) {
                m1584e0();
            }
            char[] cArr = this.f1721t;
            int i4 = this.f1723v;
            this.f1723v = i4 + 1;
            cArr[i4] = c3;
            mo1114G(cArrM1365b, cArrM1365b.length);
            if (this.f1723v >= i3) {
                m1584e0();
            }
            char[] cArr2 = this.f1721t;
            int i5 = this.f1723v;
            this.f1723v = i5 + 1;
            cArr2[i5] = c3;
            return;
        }
        if (this.f1723v + 1 >= i3) {
            m1584e0();
        }
        if (z3) {
            char[] cArr3 = this.f1721t;
            int i6 = this.f1723v;
            this.f1723v = i6 + 1;
            cArr3[i6] = ',';
        }
        if (this.f1643o) {
            char[] cArrM1365b2 = c0597j.m1365b();
            mo1114G(cArrM1365b2, cArrM1365b2.length);
            return;
        }
        char[] cArr4 = this.f1721t;
        int i7 = this.f1723v;
        int i8 = i7 + 1;
        this.f1723v = i8;
        cArr4[i7] = c3;
        char[] cArrM1341d = c0597j.f1534h;
        if (cArrM1341d == null) {
            C0597j.f1530j.getClass();
            cArrM1341d = C0592e.m1341d(c0597j.f1531e);
            c0597j.f1534h = cArrM1341d;
        }
        int length = cArrM1341d.length;
        if (i8 + length > cArr4.length) {
            length = -1;
        } else {
            System.arraycopy(cArrM1341d, 0, cArr4, i8, length);
        }
        if (length < 0) {
            char[] cArrM1365b3 = c0597j.m1365b();
            mo1114G(cArrM1365b3, cArrM1365b3.length);
            if (this.f1723v >= i3) {
                m1584e0();
            }
            char[] cArr5 = this.f1721t;
            int i9 = this.f1723v;
            this.f1723v = i9 + 1;
            cArr5[i9] = c3;
            return;
        }
        int i10 = this.f1723v + length;
        this.f1723v = i10;
        if (i10 >= i3) {
            m1584e0();
        }
        char[] cArr6 = this.f1721t;
        int i11 = this.f1723v;
        this.f1723v = i11 + 1;
        cArr6[i11] = c3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: r */
    public final void mo1145r(String str) throws IOException {
        int iM1471m = this.f1384i.m1471m(str);
        if (iM1471m == 4) {
            m1129a("Can not write a field name, expecting a value");
            throw null;
        }
        boolean z3 = iM1471m == 1;
        InterfaceC0550r interfaceC0550r = this.f1268e;
        char c3 = this.f1720s;
        int i3 = this.f1724w;
        if (interfaceC0550r != null) {
            if (z3) {
                interfaceC0550r.mo1228e(this);
            } else {
                interfaceC0550r.mo1233j(this);
            }
            if (this.f1643o) {
                m1591m0(str);
                return;
            }
            if (this.f1723v >= i3) {
                m1584e0();
            }
            char[] cArr = this.f1721t;
            int i4 = this.f1723v;
            this.f1723v = i4 + 1;
            cArr[i4] = c3;
            m1591m0(str);
            if (this.f1723v >= i3) {
                m1584e0();
            }
            char[] cArr2 = this.f1721t;
            int i5 = this.f1723v;
            this.f1723v = i5 + 1;
            cArr2[i5] = c3;
            return;
        }
        if (this.f1723v + 1 >= i3) {
            m1584e0();
        }
        if (z3) {
            char[] cArr3 = this.f1721t;
            int i6 = this.f1723v;
            this.f1723v = i6 + 1;
            cArr3[i6] = ',';
        }
        if (this.f1643o) {
            m1591m0(str);
            return;
        }
        char[] cArr4 = this.f1721t;
        int i7 = this.f1723v;
        this.f1723v = i7 + 1;
        cArr4[i7] = c3;
        m1591m0(str);
        if (this.f1723v >= i3) {
            m1584e0();
        }
        char[] cArr5 = this.f1721t;
        int i8 = this.f1723v;
        this.f1723v = i8 + 1;
        cArr5[i8] = c3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: s */
    public final void mo1146s() throws IOException {
        mo1248Y("write a null");
        m1589k0();
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: t */
    public final void mo1147t(double d) throws IOException {
        if (!this.f1383h) {
            String str = AbstractC0595h.f1524a;
            if (!(!Double.isFinite(d)) || !mo1134g(EnumC0539g.QUOTE_NON_NUMERIC_NUMBERS)) {
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
            if (!(!Float.isFinite(f3)) || !mo1134g(EnumC0539g.QUOTE_NON_NUMERIC_NUMBERS)) {
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
        boolean z3 = this.f1383h;
        int i4 = this.f1724w;
        if (!z3) {
            if (this.f1723v + 11 >= i4) {
                m1584e0();
            }
            this.f1723v = AbstractC0595h.m1359h(i3, this.f1721t, this.f1723v);
            return;
        }
        if (this.f1723v + 13 >= i4) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i5 = this.f1723v;
        int i6 = i5 + 1;
        this.f1723v = i6;
        char c3 = this.f1720s;
        cArr[i5] = c3;
        int iM1359h = AbstractC0595h.m1359h(i3, cArr, i6);
        char[] cArr2 = this.f1721t;
        this.f1723v = iM1359h + 1;
        cArr2[iM1359h] = c3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: w */
    public final void mo1150w(long j2) throws IOException {
        mo1248Y("write a number");
        boolean z3 = this.f1383h;
        int i3 = this.f1724w;
        if (!z3) {
            if (this.f1723v + 21 >= i3) {
                m1584e0();
            }
            this.f1723v = AbstractC0595h.m1361j(j2, this.f1721t, this.f1723v);
            return;
        }
        if (this.f1723v + 23 >= i3) {
            m1584e0();
        }
        char[] cArr = this.f1721t;
        int i4 = this.f1723v;
        int i5 = i4 + 1;
        this.f1723v = i5;
        char c3 = this.f1720s;
        cArr[i4] = c3;
        int iM1361j = AbstractC0595h.m1361j(j2, cArr, i5);
        char[] cArr2 = this.f1721t;
        this.f1723v = iM1361j + 1;
        cArr2[iM1361j] = c3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: x */
    public final void mo1151x(String str) throws IOException {
        mo1248Y("write a number");
        if (str == null) {
            m1589k0();
        } else if (this.f1383h) {
            m1590l0(str);
        } else {
            mo1113F(str);
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: y */
    public final void mo1152y(BigDecimal bigDecimal) throws IOException {
        mo1248Y("write a number");
        if (bigDecimal == null) {
            m1589k0();
        } else if (this.f1383h) {
            m1590l0(m1245V(bigDecimal));
        } else {
            mo1113F(m1245V(bigDecimal));
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: z */
    public final void mo1153z(BigInteger bigInteger) throws IOException {
        mo1248Y("write a number");
        if (bigInteger == null) {
            m1589k0();
        } else if (this.f1383h) {
            m1590l0(bigInteger.toString());
        } else {
            mo1113F(bigInteger.toString());
        }
    }
}
