package p056S0;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: S0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0633a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1623a;

    /* JADX INFO: renamed from: b */
    public final byte[] f1624b;

    /* JADX INFO: renamed from: c */
    public int f1625c;

    public C0633a(int i3) {
        this.f1623a = 2;
        this.f1624b = new byte[i3];
        this.f1625c = 0;
    }

    /* JADX INFO: renamed from: f */
    public static int m1447f(long j2, long j3) {
        long jM1458a = AbstractC0634b.m1458a(j2, j3);
        return (int) ((((jM1458a & 4294967295L) + 4294967295L) >>> 32) | (jM1458a >>> 31));
    }

    /* JADX INFO: renamed from: g */
    public static long m1448g(long j2, long j3, long j4) {
        long jM1458a = AbstractC0634b.m1458a(j3, j4);
        long j5 = j2 * j4;
        long jM1458a2 = AbstractC0634b.m1458a(j2, j4);
        long j6 = (j5 >>> 1) + jM1458a;
        return (jM1458a2 + (j6 >>> 63)) | (((j6 & Long.MAX_VALUE) + Long.MAX_VALUE) >>> 63);
    }

    /* JADX INFO: renamed from: a */
    public void m1449a(int i3) {
        switch (this.f1623a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int i4 = this.f1625c + 1;
                this.f1625c = i4;
                this.f1624b[i4] = (byte) i3;
                break;
            default:
                int i5 = this.f1625c + 1;
                this.f1625c = i5;
                this.f1624b[i5] = (byte) i3;
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1450b(int i3) {
        switch (this.f1623a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int iM1458a = ((int) (AbstractC0634b.m1458a(((long) (i3 + 1)) << 28, 193428131138340668L) >>> 20)) - 1;
                for (int i4 = 0; i4 < 8; i4++) {
                    int i5 = iM1458a * 10;
                    m1451c(i5 >>> 28);
                    iM1458a = i5 & 268435455;
                }
                break;
            default:
                int iM1458a2 = ((int) (AbstractC0634b.m1458a(((long) (i3 + 1)) << 28, 193428131138340668L) >>> 20)) - 1;
                for (int i6 = 0; i6 < 8; i6++) {
                    int i7 = iM1458a2 * 10;
                    m1451c(i7 >>> 28);
                    iM1458a2 = i7 & 268435455;
                }
                break;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m1451c(int i3) {
        switch (this.f1623a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int i4 = this.f1625c + 1;
                this.f1625c = i4;
                this.f1624b[i4] = (byte) (i3 + 48);
                break;
            default:
                int i5 = this.f1625c + 1;
                this.f1625c = i5;
                this.f1624b[i5] = (byte) (i3 + 48);
                break;
        }
    }

    /* JADX INFO: renamed from: d */
    public void m1452d(int i3) {
        int i4;
        byte b3;
        if (i3 != 0) {
            m1450b(i3);
        }
        while (true) {
            i4 = this.f1625c;
            b3 = this.f1624b[i4];
            if (b3 != 48) {
                break;
            } else {
                this.f1625c = i4 - 1;
            }
        }
        if (b3 == 46) {
            this.f1625c = i4 + 1;
        }
    }

    /* JADX INFO: renamed from: e */
    public void m1453e() {
        int i3;
        byte b3;
        while (true) {
            i3 = this.f1625c;
            b3 = this.f1624b[i3];
            if (b3 != 48) {
                break;
            } else {
                this.f1625c = i3 - 1;
            }
        }
        if (b3 == 46) {
            this.f1625c = i3 + 1;
        }
    }

    /* JADX INFO: renamed from: h */
    public void m1454h(int i3, int i4) {
        int iNumberOfLeadingZeros = (int) ((((long) (32 - Integer.numberOfLeadingZeros(i3))) * 661971961083L) >> 41);
        long j2 = i3;
        long[] jArr = AbstractC0634b.f1626a;
        if (j2 >= jArr[iNumberOfLeadingZeros]) {
            iNumberOfLeadingZeros++;
        }
        int i5 = (int) (j2 * jArr[9 - iNumberOfLeadingZeros]);
        int i6 = i4 + iNumberOfLeadingZeros;
        int i7 = (int) ((((long) i5) * 1441151881) >>> 57);
        int i8 = i5 - (100000000 * i7);
        int i9 = 1;
        if (i6 > 0 && i6 <= 7) {
            m1451c(i7);
            int iM1458a = ((int) (AbstractC0634b.m1458a(((long) (i8 + 1)) << 28, 193428131138340668L) >>> 20)) - 1;
            while (i9 < i6) {
                int i10 = iM1458a * 10;
                m1451c(i10 >>> 28);
                iM1458a = i10 & 268435455;
                i9++;
            }
            m1449a(46);
            while (i9 <= 8) {
                int i11 = iM1458a * 10;
                m1451c(i11 >>> 28);
                iM1458a = i11 & 268435455;
                i9++;
            }
            m1453e();
            return;
        }
        if (-3 < i6 && i6 <= 0) {
            m1451c(0);
            m1449a(46);
            while (i6 < 0) {
                m1451c(0);
                i6++;
            }
            m1451c(i7);
            m1450b(i8);
            m1453e();
            return;
        }
        m1451c(i7);
        m1449a(46);
        m1450b(i8);
        m1453e();
        int i12 = i6 - 1;
        m1449a(69);
        if (i12 < 0) {
            m1449a(45);
            i12 = -i12;
        }
        if (i12 < 10) {
            m1451c(i12);
            return;
        }
        int i13 = (i12 * 103) >>> 10;
        m1451c(i13);
        m1451c(i12 - (i13 * 10));
    }

    /* JADX INFO: renamed from: i */
    public void m1455i(int i3, long j2) {
        int iNumberOfLeadingZeros = (int) ((((long) (64 - Long.numberOfLeadingZeros(j2))) * 661971961083L) >> 41);
        long[] jArr = AbstractC0634b.f1626a;
        if (j2 >= jArr[iNumberOfLeadingZeros]) {
            iNumberOfLeadingZeros++;
        }
        long j3 = j2 * jArr[17 - iNumberOfLeadingZeros];
        int i4 = i3 + iNumberOfLeadingZeros;
        long jM1458a = AbstractC0634b.m1458a(j3, 193428131138340668L) >>> 20;
        int i5 = (int) (j3 - (100000000 * jM1458a));
        int i6 = (int) ((1441151881 * jM1458a) >>> 57);
        int i7 = (int) (jM1458a - ((long) (100000000 * i6)));
        int i8 = 1;
        if (i4 > 0 && i4 <= 7) {
            m1451c(i6);
            int iM1458a = ((int) (AbstractC0634b.m1458a(((long) (i7 + 1)) << 28, 193428131138340668L) >>> 20)) - 1;
            while (i8 < i4) {
                int i9 = iM1458a * 10;
                m1451c(i9 >>> 28);
                iM1458a = i9 & 268435455;
                i8++;
            }
            m1449a(46);
            while (i8 <= 8) {
                int i10 = iM1458a * 10;
                m1451c(i10 >>> 28);
                iM1458a = i10 & 268435455;
                i8++;
            }
            m1452d(i5);
            return;
        }
        if (-3 < i4 && i4 <= 0) {
            m1451c(0);
            m1449a(46);
            while (i4 < 0) {
                m1451c(0);
                i4++;
            }
            m1451c(i6);
            m1450b(i7);
            m1452d(i5);
            return;
        }
        m1451c(i6);
        m1449a(46);
        m1450b(i7);
        m1452d(i5);
        int i11 = i4 - 1;
        m1449a(69);
        if (i11 < 0) {
            m1449a(45);
            i11 = -i11;
        }
        if (i11 < 10) {
            m1451c(i11);
            return;
        }
        if (i11 >= 100) {
            int i12 = (i11 * 1311) >>> 17;
            m1451c(i12);
            i11 -= i12 * 100;
        }
        int i13 = (i11 * 103) >>> 10;
        m1451c(i13);
        m1451c(i11 - (i13 * 10));
    }

    /* JADX INFO: renamed from: j */
    public void m1456j(int i3, int i4, int i5) {
        long j2;
        int i6;
        int i7 = i4 & 1;
        long j3 = i4 << 2;
        long j4 = j3 + 2;
        if ((i4 != 8388608) || (i3 == -149)) {
            i6 = (int) ((((long) i3) * 661971961083L) >> 41);
            j2 = j3 - 2;
        } else {
            j2 = j3 - 1;
            i6 = (int) (((((long) i3) * 661971961083L) - 274743187321L) >> 41);
        }
        int i8 = ((int) ((((long) (-i6)) * 913124641741L) >> 38)) + i3 + 33;
        long j5 = AbstractC0634b.f1627b[(i6 + 324) << 1] + 1;
        int iM1447f = m1447f(j5, j3 << i8);
        int iM1447f2 = m1447f(j5, j2 << i8);
        int iM1447f3 = m1447f(j5, j4 << i8);
        int i9 = iM1447f >> 2;
        if (i9 >= 100) {
            int i10 = ((int) ((((long) i9) * 1717986919) >>> 34)) * 10;
            int i11 = i10 + 10;
            boolean z3 = iM1447f2 + i7 <= (i10 << 2);
            if (z3 != ((i11 << 2) + i7 <= iM1447f3)) {
                if (!z3) {
                    i10 = i11;
                }
                m1454h(i10, i6);
                return;
            }
        }
        int i12 = i9 + 1;
        boolean z4 = iM1447f2 + i7 <= (i9 << 2);
        if (z4 != ((i12 << 2) + i7 <= iM1447f3)) {
            if (!z4) {
                i9 = i12;
            }
            m1454h(i9, i6 + i5);
        } else {
            int i13 = iM1447f - ((i9 + i12) << 1);
            if (i13 >= 0 && (i13 != 0 || (i9 & 1) != 0)) {
                i9 = i12;
            }
            m1454h(i9, i6 + i5);
        }
    }

    /* JADX INFO: renamed from: k */
    public void m1457k(int i3, int i4, long j2) {
        int i5;
        long j3;
        long j4;
        long j5;
        int i6 = ((int) j2) & 1;
        long j6 = j2 << 2;
        long j7 = j6 + 2;
        if ((j2 != 4503599627370496L) || (i3 == -1074)) {
            j3 = j6 - 2;
            i5 = i6;
            j4 = ((long) i3) * 661971961083L;
        } else {
            i5 = i6;
            j3 = j6 - 1;
            j4 = (((long) i3) * 661971961083L) - 274743187321L;
        }
        int i7 = (int) (j4 >> 41);
        int i8 = ((int) ((((long) (-i7)) * 913124641741L) >> 38)) + i3 + 2;
        long[] jArr = AbstractC0634b.f1627b;
        int i9 = (i7 + 324) << 1;
        long j8 = jArr[i9];
        long j9 = jArr[i9 | 1];
        long jM1448g = m1448g(j8, j9, j6 << i8);
        long jM1448g2 = m1448g(j8, j9, j3 << i8);
        long jM1448g3 = m1448g(j8, j9, j7 << i8);
        long j10 = jM1448g >> 2;
        if (j10 >= 100) {
            long jM1458a = AbstractC0634b.m1458a(j10, 1844674407370955168L) * 10;
            long j11 = jM1458a + 10;
            j5 = jM1448g;
            long j12 = i5;
            boolean z3 = jM1448g2 + j12 <= (jM1458a << 2);
            if (z3 != ((j11 << 2) + j12 <= jM1448g3)) {
                if (!z3) {
                    jM1458a = j11;
                }
                m1455i(i7, jM1458a);
                return;
            }
        } else {
            j5 = jM1448g;
        }
        long j13 = j10 + 1;
        long j14 = i5;
        boolean z4 = jM1448g2 + j14 <= (j10 << 2);
        if (z4 != ((j13 << 2) + j14 <= jM1448g3)) {
            if (!z4) {
                j10 = j13;
            }
            m1455i(i7 + i4, j10);
        } else {
            long j15 = j5 - ((j10 + j13) << 1);
            if (j15 >= 0 && (j15 != 0 || (j10 & 1) != 0)) {
                j10 = j13;
            }
            m1455i(i7 + i4, j10);
        }
    }

    public C0633a(int i3, byte b3) {
        this.f1623a = i3;
        switch (i3) {
            case 1:
                this.f1624b = new byte[15];
                break;
            default:
                this.f1624b = new byte[24];
                break;
        }
    }
}
