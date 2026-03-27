package p066W0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import p050Q0.AbstractC0594g;

/* JADX INFO: renamed from: W0.q */
/* JADX INFO: loaded from: classes.dex */
public class C0690q {

    /* JADX INFO: renamed from: l */
    public static final char[] f1868l = new char[0];

    /* JADX INFO: renamed from: a */
    public final C0674a f1869a;

    /* JADX INFO: renamed from: b */
    public char[] f1870b;

    /* JADX INFO: renamed from: c */
    public int f1871c;

    /* JADX INFO: renamed from: d */
    public int f1872d;

    /* JADX INFO: renamed from: e */
    public ArrayList f1873e;

    /* JADX INFO: renamed from: f */
    public boolean f1874f;

    /* JADX INFO: renamed from: g */
    public int f1875g;

    /* JADX INFO: renamed from: h */
    public char[] f1876h;

    /* JADX INFO: renamed from: i */
    public int f1877i;

    /* JADX INFO: renamed from: j */
    public String f1878j;

    /* JADX INFO: renamed from: k */
    public char[] f1879k;

    public C0690q(C0674a c0674a) {
        this.f1869a = c0674a;
    }

    /* JADX INFO: renamed from: a */
    public static void m1648a(int i3, int i4) {
        throw new IllegalStateException("TextBuffer overrun: size reached (" + (((long) i3) + ((long) i4)) + ") exceeds maximum of 2147483647");
    }

    /* JADX INFO: renamed from: b */
    public final void m1649b(int i3, char[] cArr, int i4) {
        if (this.f1871c >= 0) {
            m1664q(i4);
        }
        this.f1878j = null;
        this.f1879k = null;
        char[] cArr2 = this.f1876h;
        int length = cArr2.length;
        int i5 = this.f1877i;
        int i6 = length - i5;
        if (i6 >= i4) {
            System.arraycopy(cArr, i3, cArr2, i5, i4);
            this.f1877i += i4;
            return;
        }
        m1665r(i4);
        if (i6 > 0) {
            System.arraycopy(cArr, i3, cArr2, this.f1877i, i6);
            i3 += i6;
            i4 -= i6;
        }
        do {
            m1657j();
            int iMin = Math.min(this.f1876h.length, i4);
            System.arraycopy(cArr, i3, this.f1876h, 0, iMin);
            this.f1877i += iMin;
            i3 += iMin;
            i4 -= iMin;
        } while (i4 > 0);
    }

    /* JADX INFO: renamed from: c */
    public final void m1650c(String str, int i3, int i4) {
        if (this.f1871c >= 0) {
            m1664q(i4);
        }
        this.f1878j = null;
        this.f1879k = null;
        char[] cArr = this.f1876h;
        int length = cArr.length;
        int i5 = this.f1877i;
        int i6 = length - i5;
        if (i6 >= i4) {
            str.getChars(i3, i3 + i4, cArr, i5);
            this.f1877i += i4;
            return;
        }
        m1665r(i4);
        if (i6 > 0) {
            int i7 = i3 + i6;
            str.getChars(i3, i7, cArr, this.f1877i);
            i4 -= i6;
            i3 = i7;
        }
        while (true) {
            m1657j();
            int iMin = Math.min(this.f1876h.length, i4);
            int i8 = i3 + iMin;
            str.getChars(i3, i8, this.f1876h, 0);
            this.f1877i += iMin;
            i4 -= iMin;
            if (i4 <= 0) {
                return;
            } else {
                i3 = i8;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final char[] m1651d(int i3) {
        C0674a c0674a = this.f1869a;
        return c0674a != null ? c0674a.m1633b(2, i3) : new char[Math.max(i3, 500)];
    }

    /* JADX INFO: renamed from: e */
    public final void m1652e() {
        this.f1874f = false;
        this.f1873e.clear();
        this.f1875g = 0;
        this.f1877i = 0;
    }

    /* JADX INFO: renamed from: f */
    public final char[] m1653f() {
        int i3;
        char[] cArrCopyOf = this.f1879k;
        if (cArrCopyOf == null) {
            String str = this.f1878j;
            if (str != null) {
                cArrCopyOf = str.toCharArray();
            } else {
                int i4 = this.f1871c;
                char[] cArr = f1868l;
                if (i4 >= 0) {
                    int i5 = this.f1872d;
                    if (i5 < 1) {
                        cArrCopyOf = cArr;
                    } else {
                        mo1647s(i5);
                        int i6 = this.f1871c;
                        cArrCopyOf = i6 == 0 ? Arrays.copyOf(this.f1870b, i5) : Arrays.copyOfRange(this.f1870b, i6, i5 + i6);
                    }
                } else {
                    int iM1663p = m1663p();
                    if (iM1663p < 1) {
                        if (iM1663p < 0) {
                            m1648a(this.f1875g, this.f1877i);
                            throw null;
                        }
                        cArrCopyOf = cArr;
                    } else {
                        mo1647s(iM1663p);
                        cArrCopyOf = new char[iM1663p];
                        ArrayList arrayList = this.f1873e;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            i3 = 0;
                            for (int i7 = 0; i7 < size; i7++) {
                                char[] cArr2 = (char[]) this.f1873e.get(i7);
                                int length = cArr2.length;
                                System.arraycopy(cArr2, 0, cArrCopyOf, i3, length);
                                i3 += length;
                            }
                        } else {
                            i3 = 0;
                        }
                        System.arraycopy(this.f1876h, 0, cArrCopyOf, i3, this.f1877i);
                    }
                }
            }
            this.f1879k = cArrCopyOf;
        }
        return cArrCopyOf;
    }

    /* JADX INFO: renamed from: g */
    public final int m1654g(boolean z3) {
        char[] cArr;
        int i3 = this.f1871c;
        return (i3 < 0 || (cArr = this.f1870b) == null) ? z3 ? -AbstractC0594g.m1348e(1, this.f1876h, this.f1877i - 1) : AbstractC0594g.m1348e(0, this.f1876h, this.f1877i) : z3 ? -AbstractC0594g.m1348e(i3 + 1, cArr, this.f1872d - 1) : AbstractC0594g.m1348e(i3, cArr, this.f1872d);
    }

    /* JADX INFO: renamed from: h */
    public final String m1655h() {
        if (this.f1878j == null) {
            char[] cArr = this.f1879k;
            if (cArr != null) {
                this.f1878j = new String(cArr);
            } else if (this.f1871c >= 0) {
                int i3 = this.f1872d;
                if (i3 < 1) {
                    this.f1878j = "";
                    return "";
                }
                mo1647s(i3);
                this.f1878j = new String(this.f1870b, this.f1871c, this.f1872d);
            } else {
                int i4 = this.f1875g;
                int i5 = this.f1877i;
                if (i4 != 0) {
                    int i6 = i4 + i5;
                    if (i6 < 0) {
                        m1648a(i4, i5);
                        throw null;
                    }
                    mo1647s(i6);
                    StringBuilder sb = new StringBuilder(i6);
                    ArrayList arrayList = this.f1873e;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        for (int i7 = 0; i7 < size; i7++) {
                            char[] cArr2 = (char[]) this.f1873e.get(i7);
                            sb.append(cArr2, 0, cArr2.length);
                        }
                    }
                    sb.append(this.f1876h, 0, this.f1877i);
                    this.f1878j = sb.toString();
                } else if (i5 == 0) {
                    this.f1878j = "";
                } else {
                    mo1647s(i5);
                    this.f1878j = new String(this.f1876h, 0, i5);
                }
            }
        }
        return this.f1878j;
    }

    /* JADX INFO: renamed from: i */
    public final char[] m1656i() {
        this.f1871c = -1;
        this.f1877i = 0;
        this.f1872d = 0;
        this.f1870b = null;
        this.f1878j = null;
        this.f1879k = null;
        if (this.f1874f) {
            m1652e();
        }
        char[] cArr = this.f1876h;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrM1651d = m1651d(0);
        this.f1876h = cArrM1651d;
        return cArrM1651d;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0028 A[PHI: r1
      0x0028: PHI (r1v9 int) = (r1v7 int), (r1v8 int) binds: [B:8:0x0026, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1657j() {
        /*
            r3 = this;
            java.util.ArrayList r0 = r3.f1873e
            if (r0 != 0) goto Lb
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.f1873e = r0
        Lb:
            char[] r0 = r3.f1876h
            r1 = 1
            r3.f1874f = r1
            java.util.ArrayList r1 = r3.f1873e
            r1.add(r0)
            int r1 = r3.f1875g
            int r2 = r0.length
            int r1 = r1 + r2
            r3.f1875g = r1
            if (r1 < 0) goto L34
            r1 = 0
            r3.f1877i = r1
            int r0 = r0.length
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L2a
        L28:
            r0 = r1
            goto L2f
        L2a:
            r1 = 65536(0x10000, float:9.1835E-41)
            if (r0 <= r1) goto L2f
            goto L28
        L2f:
            char[] r0 = new char[r0]
            r3.f1876h = r0
            return
        L34:
            int r2 = r0.length
            int r1 = r1 - r2
            int r0 = r0.length
            m1648a(r1, r0)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p066W0.C0690q.m1657j():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002c A[PHI: r1
      0x002c: PHI (r1v7 int) = (r1v5 int), (r1v6 int) binds: [B:8:0x002a, B:11:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final char[] m1658k() {
        /*
            r3 = this;
            java.util.ArrayList r0 = r3.f1873e
            if (r0 != 0) goto Lb
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.f1873e = r0
        Lb:
            r0 = 1
            r3.f1874f = r0
            java.util.ArrayList r0 = r3.f1873e
            char[] r1 = r3.f1876h
            r0.add(r1)
            char[] r0 = r3.f1876h
            int r0 = r0.length
            int r1 = r3.f1875g
            int r1 = r1 + r0
            r3.f1875g = r1
            if (r1 < 0) goto L38
            r2 = 0
            r3.f1877i = r2
            r3.mo1647s(r1)
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L2e
        L2c:
            r0 = r1
            goto L33
        L2e:
            r1 = 65536(0x10000, float:9.1835E-41)
            if (r0 <= r1) goto L33
            goto L2c
        L33:
            char[] r0 = new char[r0]
            r3.f1876h = r0
            return r0
        L38:
            int r1 = r1 - r0
            m1648a(r1, r0)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p066W0.C0690q.m1658k():char[]");
    }

    /* JADX INFO: renamed from: l */
    public final char[] m1659l() {
        if (this.f1871c >= 0) {
            m1664q(1);
        } else {
            char[] cArr = this.f1876h;
            if (cArr == null) {
                this.f1876h = m1651d(0);
            } else if (this.f1877i >= cArr.length) {
                m1657j();
            }
        }
        return this.f1876h;
    }

    /* JADX INFO: renamed from: m */
    public final char[] m1660m() {
        if (this.f1871c >= 0) {
            return this.f1870b;
        }
        char[] cArr = this.f1879k;
        if (cArr != null) {
            return cArr;
        }
        String str = this.f1878j;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this.f1879k = charArray;
            return charArray;
        }
        if (this.f1874f) {
            return m1653f();
        }
        char[] cArr2 = this.f1876h;
        return cArr2 == null ? f1868l : cArr2;
    }

    /* JADX INFO: renamed from: n */
    public final void m1661n() {
        char[] cArr;
        this.f1871c = -1;
        this.f1877i = 0;
        this.f1872d = 0;
        this.f1870b = null;
        this.f1879k = null;
        if (this.f1874f) {
            m1652e();
        }
        C0674a c0674a = this.f1869a;
        if (c0674a == null || (cArr = this.f1876h) == null) {
            return;
        }
        this.f1876h = null;
        c0674a.f1835b.set(2, cArr);
    }

    /* JADX INFO: renamed from: o */
    public final void m1662o(int i3, char[] cArr, int i4) {
        this.f1878j = null;
        this.f1879k = null;
        this.f1870b = cArr;
        this.f1871c = i3;
        this.f1872d = i4;
        if (this.f1874f) {
            m1652e();
        }
    }

    /* JADX INFO: renamed from: p */
    public final int m1663p() {
        if (this.f1871c >= 0) {
            return this.f1872d;
        }
        char[] cArr = this.f1879k;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.f1878j;
        return str != null ? str.length() : this.f1875g + this.f1877i;
    }

    /* JADX INFO: renamed from: q */
    public final void m1664q(int i3) {
        int i4 = this.f1872d;
        this.f1872d = 0;
        char[] cArr = this.f1870b;
        this.f1870b = null;
        int i5 = this.f1871c;
        this.f1871c = -1;
        int i6 = i3 + i4;
        char[] cArr2 = this.f1876h;
        if (cArr2 == null || i6 > cArr2.length) {
            this.f1876h = m1651d(i6);
        }
        if (i4 > 0) {
            System.arraycopy(cArr, i5, this.f1876h, 0, i4);
        }
        this.f1875g = 0;
        this.f1877i = i4;
    }

    /* JADX INFO: renamed from: r */
    public final void m1665r(int i3) {
        int i4 = this.f1875g + this.f1877i + i3;
        if (i4 < 0) {
            i4 = Integer.MAX_VALUE;
        }
        mo1647s(i4);
    }

    /* JADX INFO: renamed from: s */
    public void mo1647s(int i3) {
    }

    public final String toString() {
        try {
            return m1655h();
        } catch (IOException unused) {
            return "TextBuffer: Exception when reading contents";
        }
    }
}
