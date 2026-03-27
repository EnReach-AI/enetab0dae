package p146t2;

import java.util.NoSuchElementException;
import p071Y0.AbstractC0752p;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1800j;
import p131p2.C1832f;
import p131p2.C1835i;

/* JADX INFO: renamed from: t2.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1922a implements Comparable {

    /* JADX INFO: renamed from: f */
    public static final long f6728f;

    /* JADX INFO: renamed from: g */
    public static final long f6729g;

    /* JADX INFO: renamed from: h */
    public static final /* synthetic */ int f6730h = 0;

    /* JADX INFO: renamed from: e */
    public final long f6731e;

    static {
        int i3 = AbstractC1923b.f6732a;
        f6728f = AbstractC1800j.m3989g(4611686018427387903L);
        f6729g = AbstractC1800j.m3989g(-4611686018427387903L);
    }

    /* JADX INFO: renamed from: a */
    public static final long m4312a(long j2, long j3) {
        long j4 = 1000000;
        long j5 = j3 / j4;
        long j6 = j2 + j5;
        if (!new C1835i(-4611686018426L, 4611686018426L).m4075a(j6)) {
            return AbstractC1800j.m3989g(AbstractC0752p.m1932a(j6));
        }
        long j7 = ((j6 * j4) + (j3 - (j5 * j4))) << 1;
        int i3 = AbstractC1923b.f6732a;
        return j7;
    }

    /* JADX INFO: renamed from: b */
    public static final void m4313b(StringBuilder sb, int i3, int i4, int i5, String str, boolean z3) {
        CharSequence charSequenceSubSequence;
        sb.append(i3);
        if (i4 != 0) {
            sb.append('.');
            String strValueOf = String.valueOf(i4);
            AbstractC1766e.m3920e("<this>", strValueOf);
            if (i5 < 0) {
                throw new IllegalArgumentException("Desired length " + i5 + " is less than zero.");
            }
            if (i5 <= strValueOf.length()) {
                charSequenceSubSequence = strValueOf.subSequence(0, strValueOf.length());
            } else {
                StringBuilder sb2 = new StringBuilder(i5);
                C1832f c1832f = new C1832f(1, i5 - strValueOf.length(), 1);
                int i6 = c1832f.f6339f;
                int i7 = c1832f.f6340g;
                boolean z4 = i7 <= 0 ? 1 >= i6 : 1 <= i6;
                int i8 = z4 ? 1 : i6;
                while (z4) {
                    if (i8 != i6) {
                        i8 += i7;
                    } else {
                        if (!z4) {
                            throw new NoSuchElementException();
                        }
                        z4 = false;
                    }
                    sb2.append('0');
                }
                sb2.append((CharSequence) strValueOf);
                charSequenceSubSequence = sb2;
            }
            String string = charSequenceSubSequence.toString();
            int i9 = -1;
            int length = string.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i10 = length - 1;
                    if (string.charAt(length) != '0') {
                        i9 = length;
                        break;
                    } else if (i10 < 0) {
                        break;
                    } else {
                        length = i10;
                    }
                }
            }
            int i11 = i9 + 1;
            if (z3 || i11 >= 3) {
                sb.append((CharSequence) string, 0, ((i9 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) string, 0, i11);
            }
        }
        sb.append(str);
    }

    /* JADX INFO: renamed from: c */
    public static final int m4314c(long j2) {
        if (m4315d(j2)) {
            return 0;
        }
        return (int) ((((int) j2) & 1) == 1 ? ((j2 >> 1) % ((long) 1000)) * ((long) 1000000) : (j2 >> 1) % ((long) 1000000000));
    }

    /* JADX INFO: renamed from: d */
    public static final boolean m4315d(long j2) {
        return j2 == f6728f || j2 == f6729g;
    }

    /* JADX INFO: renamed from: e */
    public static final long m4316e(long j2, long j3) {
        if (m4315d(j2)) {
            if ((!m4315d(j3)) || (j3 ^ j2) >= 0) {
                return j2;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (m4315d(j3)) {
            return j3;
        }
        int i3 = ((int) j2) & 1;
        if (i3 != (((int) j3) & 1)) {
            return i3 == 1 ? m4312a(j2 >> 1, j3 >> 1) : m4312a(j3 >> 1, j2 >> 1);
        }
        long j4 = (j2 >> 1) + (j3 >> 1);
        if (i3 != 0) {
            return AbstractC1800j.m3990h(j4);
        }
        if (!new C1835i(-4611686018426999999L, 4611686018426999999L).m4075a(j4)) {
            return AbstractC1800j.m3989g(j4 / ((long) 1000000));
        }
        long j5 = j4 << 1;
        int i4 = AbstractC1923b.f6732a;
        return j5;
    }

    /* JADX INFO: renamed from: f */
    public static final long m4317f(long j2, EnumC1924c enumC1924c) {
        AbstractC1766e.m3920e("unit", enumC1924c);
        if (j2 == f6728f) {
            return Long.MAX_VALUE;
        }
        if (j2 == f6729g) {
            return Long.MIN_VALUE;
        }
        long j3 = j2 >> 1;
        EnumC1924c enumC1924c2 = (((int) j2) & 1) == 0 ? EnumC1924c.NANOSECONDS : EnumC1924c.MILLISECONDS;
        AbstractC1766e.m3920e("sourceUnit", enumC1924c2);
        return enumC1924c.f6740e.convert(j3, enumC1924c2.f6740e);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j2 = ((C1922a) obj).f6731e;
        long j3 = this.f6731e;
        long j4 = j3 ^ j2;
        int i3 = 1;
        if (j4 >= 0 && (((int) j4) & 1) != 0) {
            int i4 = (((int) j3) & 1) - (((int) j2) & 1);
            return j3 < 0 ? -i4 : i4;
        }
        if (j3 < j2) {
            i3 = -1;
        } else if (j3 == j2) {
            i3 = 0;
        }
        return i3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1922a) {
            return this.f6731e == ((C1922a) obj).f6731e;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f6731e);
    }

    public final String toString() {
        boolean z3;
        int iM4317f;
        int i3;
        StringBuilder sb;
        long j2 = this.f6731e;
        if (j2 == 0) {
            return "0s";
        }
        if (j2 == f6728f) {
            return "Infinity";
        }
        if (j2 == f6729g) {
            return "-Infinity";
        }
        boolean z4 = j2 < 0;
        StringBuilder sb2 = new StringBuilder();
        if (z4) {
            sb2.append('-');
        }
        if (j2 < 0) {
            j2 = ((long) (((int) j2) & 1)) + ((-(j2 >> 1)) << 1);
            int i4 = AbstractC1923b.f6732a;
        }
        long jM4317f = m4317f(j2, EnumC1924c.DAYS);
        if (m4315d(j2)) {
            z3 = z4;
            iM4317f = 0;
        } else {
            z3 = z4;
            iM4317f = (int) (m4317f(j2, EnumC1924c.HOURS) % ((long) 24));
        }
        int iM4317f2 = m4315d(j2) ? 0 : (int) (m4317f(j2, EnumC1924c.MINUTES) % ((long) 60));
        int iM4317f3 = m4315d(j2) ? 0 : (int) (m4317f(j2, EnumC1924c.SECONDS) % ((long) 60));
        int iM4314c = m4314c(j2);
        boolean z5 = jM4317f != 0;
        boolean z6 = iM4317f != 0;
        boolean z7 = iM4317f2 != 0;
        boolean z8 = (iM4317f3 == 0 && iM4314c == 0) ? false : true;
        if (z5) {
            sb2.append(jM4317f);
            sb2.append('d');
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (z6 || (z5 && (z7 || z8))) {
            int i5 = i3 + 1;
            if (i3 > 0) {
                sb2.append(' ');
            }
            sb2.append(iM4317f);
            sb2.append('h');
            i3 = i5;
        }
        if (z7 || (z8 && (z6 || z5))) {
            int i6 = i3 + 1;
            if (i3 > 0) {
                sb2.append(' ');
            }
            sb2.append(iM4317f2);
            sb2.append('m');
            i3 = i6;
        }
        if (z8) {
            int i7 = i3 + 1;
            if (i3 > 0) {
                sb2.append(' ');
            }
            if (iM4317f3 != 0 || z5 || z6 || z7) {
                sb = sb2;
                m4313b(sb, iM4317f3, iM4314c, 9, "s", false);
            } else if (iM4314c >= 1000000) {
                sb = sb2;
                m4313b(sb2, iM4314c / 1000000, iM4314c % 1000000, 6, "ms", false);
            } else {
                sb = sb2;
                if (iM4314c >= 1000) {
                    m4313b(sb, iM4314c / 1000, iM4314c % 1000, 3, "us", false);
                } else {
                    sb.append(iM4314c);
                    sb.append("ns");
                }
            }
            i3 = i7;
        } else {
            sb = sb2;
        }
        if (z3 && i3 > 1) {
            sb.insert(1, '(').append(')');
        }
        String string = sb.toString();
        AbstractC1766e.m3919d("toString(...)", string);
        return string;
    }
}
