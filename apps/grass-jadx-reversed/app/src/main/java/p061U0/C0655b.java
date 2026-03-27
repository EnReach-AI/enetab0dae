package p061U0;

import com.fasterxml.jackson.core.exc.C1131b;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import p066W0.C0682i;

/* JADX INFO: renamed from: U0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0655b {

    /* JADX INFO: renamed from: a */
    public final C0655b f1763a;

    /* JADX INFO: renamed from: b */
    public final AtomicReference f1764b;

    /* JADX INFO: renamed from: c */
    public final int f1765c;

    /* JADX INFO: renamed from: d */
    public final boolean f1766d;

    /* JADX INFO: renamed from: e */
    public final boolean f1767e;

    /* JADX INFO: renamed from: f */
    public int[] f1768f;

    /* JADX INFO: renamed from: g */
    public int f1769g;

    /* JADX INFO: renamed from: h */
    public int f1770h;

    /* JADX INFO: renamed from: i */
    public int f1771i;

    /* JADX INFO: renamed from: j */
    public int f1772j;

    /* JADX INFO: renamed from: k */
    public int f1773k;

    /* JADX INFO: renamed from: l */
    public String[] f1774l;

    /* JADX INFO: renamed from: m */
    public int f1775m;

    /* JADX INFO: renamed from: n */
    public int f1776n;

    /* JADX INFO: renamed from: o */
    public boolean f1777o;

    public C0655b(int i3) {
        this.f1763a = null;
        this.f1773k = 0;
        this.f1777o = true;
        this.f1765c = i3;
        this.f1766d = false;
        this.f1767e = true;
        this.f1764b = new AtomicReference(new C0654a(64, 4, new int[512], new String[128], 448, 512));
    }

    /* JADX INFO: renamed from: a */
    public final int m1602a(int i3) {
        return (i3 & (this.f1769g - 1)) << 2;
    }

    /* JADX INFO: renamed from: b */
    public final int m1603b(int i3) throws C1131b {
        int iM1602a = m1602a(i3);
        int[] iArr = this.f1768f;
        if (iArr[iM1602a + 3] == 0) {
            return iM1602a;
        }
        if (this.f1773k > (this.f1769g >> 1)) {
            int iM1605d = (this.f1775m - m1605d()) >> 2;
            int i4 = this.f1773k;
            if (iM1605d > ((i4 + 1) >> 7) || i4 > ((double) this.f1769g) * 0.8d) {
                return m1604c(i3);
            }
        }
        int i5 = this.f1770h + ((iM1602a >> 3) << 2);
        if (iArr[i5 + 3] == 0) {
            return i5;
        }
        int i6 = this.f1771i;
        int i7 = this.f1772j;
        int i8 = i6 + ((iM1602a >> (i7 + 2)) << i7);
        int i9 = (1 << i7) + i8;
        while (i8 < i9) {
            if (iArr[i8 + 3] == 0) {
                return i8;
            }
            i8 += 4;
        }
        int i10 = this.f1775m;
        int i11 = i10 + 4;
        this.f1775m = i11;
        int i12 = this.f1769g;
        if (i11 < (i12 << 3)) {
            return i10;
        }
        if (!this.f1767e || i12 <= 1024) {
            return m1604c(i3);
        }
        throw new C1131b("Spill-over slots in symbol table with " + this.f1773k + " entries, hash area of " + this.f1769g + " slots is now full (all " + (this.f1769g >> 3) + " slots -- suspect a DoS attack based on hash collisions. You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`");
    }

    /* JADX INFO: renamed from: c */
    public final int m1604c(int i3) throws C1131b {
        this.f1777o = false;
        int[] iArr = this.f1768f;
        String[] strArr = this.f1774l;
        int i4 = this.f1769g;
        int i5 = this.f1773k;
        int i6 = i4 + i4;
        int i7 = this.f1775m;
        if (i6 > 65536) {
            m1615n(true);
        } else {
            this.f1768f = new int[iArr.length + (i4 << 3)];
            this.f1769g = i6;
            int i8 = i6 << 2;
            this.f1770h = i8;
            this.f1771i = i8 + (i8 >> 1);
            int i9 = i6 >> 2;
            this.f1772j = i9 < 64 ? 4 : i9 <= 256 ? 5 : i9 <= 1024 ? 6 : 7;
            this.f1774l = new String[strArr.length << 1];
            m1615n(false);
            int[] iArr2 = new int[16];
            int i10 = 0;
            for (int i11 = 0; i11 < i7; i11 += 4) {
                int i12 = iArr[i11 + 3];
                if (i12 != 0) {
                    i10++;
                    String str = strArr[i11 >> 2];
                    if (i12 == 1) {
                        iArr2[0] = iArr[i11];
                        m1607f(str, iArr2, 1);
                    } else if (i12 == 2) {
                        iArr2[0] = iArr[i11];
                        iArr2[1] = iArr[i11 + 1];
                        m1607f(str, iArr2, 2);
                    } else if (i12 != 3) {
                        if (i12 > iArr2.length) {
                            iArr2 = new int[i12];
                        }
                        System.arraycopy(iArr, iArr[i11 + 1], iArr2, 0, i12);
                        m1607f(str, iArr2, i12);
                    } else {
                        iArr2[0] = iArr[i11];
                        iArr2[1] = iArr[i11 + 1];
                        iArr2[2] = iArr[i11 + 2];
                        m1607f(str, iArr2, 3);
                    }
                }
            }
            if (i10 != i5) {
                throw new IllegalStateException("Internal error: Failed rehash(), old count=" + i5 + ", copyCount=" + i10);
            }
        }
        int iM1602a = m1602a(i3);
        int[] iArr3 = this.f1768f;
        if (iArr3[iM1602a + 3] == 0) {
            return iM1602a;
        }
        int i13 = this.f1770h + ((iM1602a >> 3) << 2);
        if (iArr3[i13 + 3] == 0) {
            return i13;
        }
        int i14 = this.f1771i;
        int i15 = this.f1772j;
        int i16 = i14 + ((iM1602a >> (i15 + 2)) << i15);
        int i17 = (1 << i15) + i16;
        while (i16 < i17) {
            if (iArr3[i16 + 3] == 0) {
                return i16;
            }
            i16 += 4;
        }
        int i18 = this.f1775m;
        this.f1775m = i18 + 4;
        return i18;
    }

    /* JADX INFO: renamed from: d */
    public final int m1605d() {
        int i3 = this.f1769g;
        return (i3 << 3) - i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m1606e(int r8, int r9, int[] r10) {
        /*
            r7 = this;
            int[] r0 = r7.f1768f
            r1 = 1
            r2 = 0
            switch(r8) {
                case 4: goto L52;
                case 5: goto L44;
                case 6: goto L36;
                case 7: goto L28;
                case 8: goto L1c;
                default: goto L7;
            }
        L7:
            r0 = r2
        L8:
            int r3 = r0 + 1
            r0 = r10[r0]
            int[] r4 = r7.f1768f
            int r5 = r9 + 1
            r9 = r4[r9]
            if (r0 == r9) goto L16
            r1 = r2
            goto L18
        L16:
            if (r3 < r8) goto L19
        L18:
            return r1
        L19:
            r0 = r3
            r9 = r5
            goto L8
        L1c:
            r8 = r10[r2]
            int r3 = r9 + 1
            r9 = r0[r9]
            if (r8 == r9) goto L25
            return r2
        L25:
            r8 = r1
            r9 = r3
            goto L29
        L28:
            r8 = r2
        L29:
            int r3 = r8 + 1
            r8 = r10[r8]
            int r4 = r9 + 1
            r9 = r0[r9]
            if (r8 == r9) goto L34
            return r2
        L34:
            r9 = r4
            goto L37
        L36:
            r3 = r2
        L37:
            int r8 = r3 + 1
            r3 = r10[r3]
            int r4 = r9 + 1
            r9 = r0[r9]
            if (r3 == r9) goto L42
            return r2
        L42:
            r9 = r4
            goto L45
        L44:
            r8 = r2
        L45:
            int r3 = r8 + 1
            r8 = r10[r8]
            int r4 = r9 + 1
            r9 = r0[r9]
            if (r8 == r9) goto L50
            return r2
        L50:
            r9 = r4
            goto L53
        L52:
            r3 = r2
        L53:
            int r8 = r3 + 1
            r4 = r10[r3]
            int r5 = r9 + 1
            r6 = r0[r9]
            if (r4 == r6) goto L5e
            return r2
        L5e:
            int r4 = r3 + 2
            r8 = r10[r8]
            int r6 = r9 + 2
            r5 = r0[r5]
            if (r8 == r5) goto L69
            return r2
        L69:
            int r3 = r3 + 3
            r8 = r10[r4]
            int r9 = r9 + 3
            r4 = r0[r6]
            if (r8 == r4) goto L74
            return r2
        L74:
            r8 = r10[r3]
            r9 = r0[r9]
            if (r8 == r9) goto L7b
            return r2
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p061U0.C0655b.m1606e(int, int, int[]):boolean");
    }

    /* JADX INFO: renamed from: f */
    public final String m1607f(String str, int[] iArr, int i3) throws C1131b {
        int iM1603b;
        if (this.f1777o) {
            if (this.f1763a == null) {
                if (this.f1773k == 0) {
                    throw new IllegalStateException("Internal error: Cannot add names to Root symbol table");
                }
                throw new IllegalStateException("Internal error: Cannot add names to Placeholder symbol table");
            }
            int[] iArr2 = this.f1768f;
            this.f1768f = Arrays.copyOf(iArr2, iArr2.length);
            String[] strArr = this.f1774l;
            this.f1774l = (String[]) Arrays.copyOf(strArr, strArr.length);
            this.f1777o = false;
        }
        if (this.f1766d) {
            str = C0682i.f1857f.m1642a(str);
        }
        if (i3 == 1) {
            int i4 = iArr[0] ^ this.f1765c;
            int i5 = i4 + (i4 >>> 16);
            int i6 = i5 ^ (i5 << 3);
            iM1603b = m1603b(i6 + (i6 >>> 12));
            int[] iArr3 = this.f1768f;
            iArr3[iM1603b] = iArr[0];
            iArr3[iM1603b + 3] = 1;
        } else if (i3 == 2) {
            iM1603b = m1603b(m1608g(iArr[0], iArr[1]));
            int[] iArr4 = this.f1768f;
            iArr4[iM1603b] = iArr[0];
            iArr4[iM1603b + 1] = iArr[1];
            iArr4[iM1603b + 3] = 2;
        } else if (i3 != 3) {
            int iM1610i = m1610i(iArr, i3);
            iM1603b = m1603b(iM1610i);
            int[] iArr5 = this.f1768f;
            iArr5[iM1603b] = iM1610i;
            int i7 = this.f1776n;
            int i8 = i7 + i3;
            if (i8 > iArr5.length) {
                this.f1768f = Arrays.copyOf(this.f1768f, Math.max(i8 - iArr5.length, Math.min(4096, this.f1769g)) + this.f1768f.length);
            }
            System.arraycopy(iArr, 0, this.f1768f, i7, i3);
            this.f1776n += i3;
            int[] iArr6 = this.f1768f;
            iArr6[iM1603b + 1] = i7;
            iArr6[iM1603b + 3] = i3;
        } else {
            iM1603b = m1603b(m1609h(iArr[0], iArr[1], iArr[2]));
            int[] iArr7 = this.f1768f;
            iArr7[iM1603b] = iArr[0];
            iArr7[iM1603b + 1] = iArr[1];
            iArr7[iM1603b + 2] = iArr[2];
            iArr7[iM1603b + 3] = 3;
        }
        this.f1774l[iM1603b >> 2] = str;
        this.f1773k++;
        return str;
    }

    /* JADX INFO: renamed from: g */
    public final int m1608g(int i3, int i4) {
        int i5 = i3 + (i3 >>> 15);
        int i6 = this.f1765c ^ ((i4 * 33) + (i5 ^ (i5 >>> 9)));
        int i7 = i6 + (i6 >>> 16);
        int i8 = i7 ^ (i7 >>> 4);
        return i8 + (i8 << 3);
    }

    /* JADX INFO: renamed from: h */
    public final int m1609h(int i3, int i4, int i5) {
        int i6 = i3 ^ this.f1765c;
        int i7 = (((i6 + (i6 >>> 9)) * 31) + i4) * 33;
        int i8 = (i7 + (i7 >>> 15)) ^ i5;
        int i9 = i8 + (i8 >>> 4);
        int i10 = i9 + (i9 >>> 15);
        return i10 ^ (i10 << 9);
    }

    /* JADX INFO: renamed from: i */
    public final int m1610i(int[] iArr, int i3) {
        if (i3 < 4) {
            throw new IllegalArgumentException("qlen is too short, needs to be at least 4");
        }
        int i4 = iArr[0] ^ this.f1765c;
        int i5 = i4 + (i4 >>> 9) + iArr[1];
        int i6 = ((i5 + (i5 >>> 15)) * 33) ^ iArr[2];
        int i7 = i6 + (i6 >>> 4);
        for (int i8 = 3; i8 < i3; i8++) {
            int i9 = iArr[i8];
            i7 += i9 ^ (i9 >> 21);
        }
        int i10 = i7 * 65599;
        int i11 = i10 + (i10 >>> 19);
        return (i11 << 5) ^ i11;
    }

    /* JADX INFO: renamed from: j */
    public final String m1611j(int i3) {
        int i4 = this.f1765c ^ i3;
        int i5 = i4 + (i4 >>> 16);
        int i6 = i5 ^ (i5 << 3);
        int iM1602a = m1602a(i6 + (i6 >>> 12));
        int[] iArr = this.f1768f;
        int i7 = iArr[iM1602a + 3];
        if (i7 == 1) {
            if (iArr[iM1602a] == i3) {
                return this.f1774l[iM1602a >> 2];
            }
        } else if (i7 == 0) {
            return null;
        }
        int i8 = this.f1770h + ((iM1602a >> 3) << 2);
        int i9 = iArr[i8 + 3];
        if (i9 == 1) {
            if (iArr[i8] == i3) {
                return this.f1774l[i8 >> 2];
            }
        } else if (i9 == 0) {
            return null;
        }
        int i10 = this.f1771i;
        int i11 = this.f1772j;
        int i12 = i10 + ((iM1602a >> (i11 + 2)) << i11);
        int i13 = (1 << i11) + i12;
        while (i12 < i13) {
            int i14 = iArr[i12 + 3];
            if (i3 == iArr[i12] && 1 == i14) {
                return this.f1774l[i12 >> 2];
            }
            if (i14 == 0) {
                return null;
            }
            i12 += 4;
        }
        for (int iM1605d = m1605d(); iM1605d < this.f1775m; iM1605d += 4) {
            if (i3 == iArr[iM1605d] && 1 == iArr[iM1605d + 3]) {
                return this.f1774l[iM1605d >> 2];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: k */
    public final String m1612k(int i3, int i4) {
        int iM1602a = m1602a(m1608g(i3, i4));
        int[] iArr = this.f1768f;
        int i5 = iArr[iM1602a + 3];
        if (i5 == 2) {
            if (i3 == iArr[iM1602a] && i4 == iArr[iM1602a + 1]) {
                return this.f1774l[iM1602a >> 2];
            }
        } else if (i5 == 0) {
            return null;
        }
        int i6 = this.f1770h + ((iM1602a >> 3) << 2);
        int i7 = iArr[i6 + 3];
        if (i7 == 2) {
            if (i3 == iArr[i6] && i4 == iArr[i6 + 1]) {
                return this.f1774l[i6 >> 2];
            }
        } else if (i7 == 0) {
            return null;
        }
        int i8 = this.f1771i;
        int i9 = this.f1772j;
        int i10 = i8 + ((iM1602a >> (i9 + 2)) << i9);
        int i11 = (1 << i9) + i10;
        while (i10 < i11) {
            int i12 = iArr[i10 + 3];
            if (i3 == iArr[i10] && i4 == iArr[i10 + 1] && 2 == i12) {
                return this.f1774l[i10 >> 2];
            }
            if (i12 == 0) {
                return null;
            }
            i10 += 4;
        }
        for (int iM1605d = m1605d(); iM1605d < this.f1775m; iM1605d += 4) {
            if (i3 == iArr[iM1605d] && i4 == iArr[iM1605d + 1] && 2 == iArr[iM1605d + 3]) {
                return this.f1774l[iM1605d >> 2];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: l */
    public final String m1613l(int i3, int i4, int i5) {
        int iM1602a = m1602a(m1609h(i3, i4, i5));
        int[] iArr = this.f1768f;
        int i6 = iArr[iM1602a + 3];
        if (i6 == 3) {
            if (i3 == iArr[iM1602a] && iArr[iM1602a + 1] == i4 && iArr[iM1602a + 2] == i5) {
                return this.f1774l[iM1602a >> 2];
            }
        } else if (i6 == 0) {
            return null;
        }
        int i7 = this.f1770h + ((iM1602a >> 3) << 2);
        int i8 = iArr[i7 + 3];
        if (i8 == 3) {
            if (i3 == iArr[i7] && iArr[i7 + 1] == i4 && iArr[i7 + 2] == i5) {
                return this.f1774l[i7 >> 2];
            }
        } else if (i8 == 0) {
            return null;
        }
        int i9 = this.f1771i;
        int i10 = this.f1772j;
        int i11 = i9 + ((iM1602a >> (i10 + 2)) << i10);
        int i12 = (1 << i10) + i11;
        while (i11 < i12) {
            int i13 = iArr[i11 + 3];
            if (i3 == iArr[i11] && i4 == iArr[i11 + 1] && i5 == iArr[i11 + 2] && 3 == i13) {
                return this.f1774l[i11 >> 2];
            }
            if (i13 == 0) {
                return null;
            }
            i11 += 4;
        }
        for (int iM1605d = m1605d(); iM1605d < this.f1775m; iM1605d += 4) {
            if (i3 == iArr[iM1605d] && i4 == iArr[iM1605d + 1] && i5 == iArr[iM1605d + 2] && 3 == iArr[iM1605d + 3]) {
                return this.f1774l[iM1605d >> 2];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: m */
    public final String m1614m(int[] iArr, int i3) {
        if (i3 < 4) {
            return i3 != 1 ? i3 != 2 ? i3 != 3 ? "" : m1613l(iArr[0], iArr[1], iArr[2]) : m1612k(iArr[0], iArr[1]) : m1611j(iArr[0]);
        }
        int iM1610i = m1610i(iArr, i3);
        int iM1602a = m1602a(iM1610i);
        int[] iArr2 = this.f1768f;
        int i4 = iArr2[iM1602a + 3];
        if (iM1610i == iArr2[iM1602a] && i4 == i3 && m1606e(i3, iArr2[iM1602a + 1], iArr)) {
            return this.f1774l[iM1602a >> 2];
        }
        if (i4 == 0) {
            return null;
        }
        int i5 = this.f1770h + ((iM1602a >> 3) << 2);
        int i6 = iArr2[i5 + 3];
        if (iM1610i == iArr2[i5] && i6 == i3 && m1606e(i3, iArr2[i5 + 1], iArr)) {
            return this.f1774l[i5 >> 2];
        }
        int i7 = this.f1771i;
        int i8 = this.f1772j;
        int i9 = i7 + ((iM1602a >> (i8 + 2)) << i8);
        int[] iArr3 = this.f1768f;
        int i10 = (1 << i8) + i9;
        while (i9 < i10) {
            int i11 = iArr3[i9 + 3];
            if (iM1610i == iArr3[i9] && i3 == i11 && m1606e(i3, iArr3[i9 + 1], iArr)) {
                return this.f1774l[i9 >> 2];
            }
            if (i11 == 0) {
                return null;
            }
            i9 += 4;
        }
        for (int iM1605d = m1605d(); iM1605d < this.f1775m; iM1605d += 4) {
            if (iM1610i == iArr3[iM1605d] && i3 == iArr3[iM1605d + 3] && m1606e(i3, iArr3[iM1605d + 1], iArr)) {
                return this.f1774l[iM1605d >> 2];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: n */
    public final void m1615n(boolean z3) {
        this.f1773k = 0;
        this.f1775m = m1605d();
        this.f1776n = this.f1769g << 3;
        if (z3) {
            Arrays.fill(this.f1768f, 0);
            Arrays.fill(this.f1774l, (Object) null);
        }
    }

    public final String toString() {
        int i3 = this.f1770h;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 3; i6 < i3; i6 += 4) {
            if (this.f1768f[i6] != 0) {
                i5++;
            }
        }
        int i7 = this.f1771i;
        int i8 = 0;
        for (int i9 = this.f1770h + 3; i9 < i7; i9 += 4) {
            if (this.f1768f[i9] != 0) {
                i8++;
            }
        }
        int i10 = this.f1771i + 3;
        int i11 = this.f1769g + i10;
        int i12 = 0;
        while (i10 < i11) {
            if (this.f1768f[i10] != 0) {
                i12++;
            }
            i10 += 4;
        }
        int iM1605d = (this.f1775m - m1605d()) >> 2;
        int i13 = this.f1769g << 3;
        for (int i14 = 3; i14 < i13; i14 += 4) {
            if (this.f1768f[i14] != 0) {
                i4++;
            }
        }
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", C0655b.class.getName(), Integer.valueOf(this.f1773k), Integer.valueOf(this.f1769g), Integer.valueOf(i5), Integer.valueOf(i8), Integer.valueOf(i12), Integer.valueOf(iM1605d), Integer.valueOf(i5 + i8 + i12 + iM1605d), Integer.valueOf(i4));
    }

    public C0655b(C0655b c0655b, int i3, C0654a c0654a, boolean z3, boolean z4) {
        this.f1763a = c0655b;
        this.f1765c = i3;
        this.f1766d = z3;
        this.f1767e = z4;
        this.f1764b = null;
        this.f1773k = c0654a.f1757b;
        int i4 = c0654a.f1756a;
        this.f1769g = i4;
        int i5 = i4 << 2;
        this.f1770h = i5;
        this.f1771i = i5 + (i5 >> 1);
        this.f1772j = c0654a.f1758c;
        this.f1768f = c0654a.f1759d;
        this.f1774l = c0654a.f1760e;
        this.f1775m = c0654a.f1761f;
        this.f1776n = c0654a.f1762g;
        this.f1777o = true;
    }
}
