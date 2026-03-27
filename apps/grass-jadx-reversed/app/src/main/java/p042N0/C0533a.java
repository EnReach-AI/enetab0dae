package p042N0;

import java.io.Serializable;
import java.util.Arrays;
import p005B.AbstractC0032g;
import p066W0.C0676c;

/* JADX INFO: renamed from: N0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0533a implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final transient int[] f1219e;

    /* JADX INFO: renamed from: f */
    public final transient char[] f1220f;

    /* JADX INFO: renamed from: g */
    public final transient byte[] f1221g;

    /* JADX INFO: renamed from: h */
    public final String f1222h;

    /* JADX INFO: renamed from: i */
    public final char f1223i;

    /* JADX INFO: renamed from: j */
    public final int f1224j;

    /* JADX INFO: renamed from: k */
    public final boolean f1225k;

    /* JADX INFO: renamed from: l */
    public final int f1226l;

    public C0533a(String str, String str2, boolean z3, char c3, int i3) {
        int[] iArr = new int[128];
        this.f1219e = iArr;
        char[] cArr = new char[64];
        this.f1220f = cArr;
        this.f1221g = new byte[64];
        this.f1222h = str;
        this.f1225k = z3;
        this.f1223i = c3;
        this.f1224j = i3;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i4 = 0; i4 < length; i4++) {
            char c4 = this.f1220f[i4];
            this.f1221g[i4] = (byte) c4;
            this.f1219e[c4] = i4;
        }
        if (z3) {
            this.f1219e[c3] = -2;
        }
        this.f1226l = z3 ? 2 : 1;
    }

    /* JADX INFO: renamed from: a */
    public final void m1071a(char c3, int i3, String str) {
        String str2;
        if (c3 <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c3) + ") as character #" + (i3 + 1) + " of 4-char base64 unit: can only used between units";
        } else {
            char c4 = this.f1223i;
            if (c3 == c4) {
                str2 = "Unexpected padding character ('" + c4 + "') as character #" + (i3 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
            } else if (!Character.isDefined(c3) || Character.isISOControl(c3)) {
                str2 = "Illegal character (code 0x" + Integer.toHexString(c3) + ") in base64 content";
            } else {
                str2 = "Illegal character '" + c3 + "' (code 0x" + Integer.toHexString(c3) + ") in base64 content";
            }
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new IllegalArgumentException(str2);
    }

    /* JADX INFO: renamed from: b */
    public final void m1072b(String str, C0676c c0676c) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            char cCharAt = str.charAt(i3);
            if (cCharAt > ' ') {
                int iM1073c = m1073c(cCharAt);
                if (iM1073c < 0) {
                    m1071a(cCharAt, 0, null);
                    throw null;
                }
                if (i4 >= length) {
                    throw new IllegalArgumentException(m1080j());
                }
                int i5 = i3 + 2;
                char cCharAt2 = str.charAt(i4);
                int iM1073c2 = m1073c(cCharAt2);
                if (iM1073c2 < 0) {
                    m1071a(cCharAt2, 1, null);
                    throw null;
                }
                int i6 = (iM1073c << 6) | iM1073c2;
                if (i5 >= length) {
                    if (m1081k()) {
                        throw new IllegalArgumentException(m1080j());
                    }
                    c0676c.m1635b(i6 >> 4);
                    return;
                }
                int i7 = i3 + 3;
                char cCharAt3 = str.charAt(i5);
                int iM1073c3 = m1073c(cCharAt3);
                String str2 = this.f1222h;
                int i8 = this.f1226l;
                if (iM1073c3 >= 0) {
                    int i9 = (i6 << 6) | iM1073c3;
                    if (i7 >= length) {
                        if (m1081k()) {
                            throw new IllegalArgumentException(m1080j());
                        }
                        c0676c.m1637d(i9 >> 2);
                        return;
                    }
                    i3 += 4;
                    char cCharAt4 = str.charAt(i7);
                    int iM1073c4 = m1073c(cCharAt4);
                    if (iM1073c4 >= 0) {
                        c0676c.m1636c((i9 << 6) | iM1073c4);
                    } else {
                        if (iM1073c4 != -2) {
                            m1071a(cCharAt4, 3, null);
                            throw null;
                        }
                        if (i8 == 1) {
                            throw new IllegalArgumentException(AbstractC0032g.m154l("Unexpected end of base64-encoded String: base64 variant '", str2, "' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured"));
                        }
                        c0676c.m1637d(i9 >> 2);
                    }
                } else {
                    if (iM1073c3 != -2) {
                        m1071a(cCharAt3, 2, null);
                        throw null;
                    }
                    if (i8 == 1) {
                        throw new IllegalArgumentException(AbstractC0032g.m154l("Unexpected end of base64-encoded String: base64 variant '", str2, "' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured"));
                    }
                    if (i7 >= length) {
                        throw new IllegalArgumentException(m1080j());
                    }
                    i3 += 4;
                    char cCharAt5 = str.charAt(i7);
                    char c3 = this.f1223i;
                    if (cCharAt5 != c3) {
                        m1071a(cCharAt5, 3, "expected padding character '" + c3 + "'");
                        throw null;
                    }
                    c0676c.m1635b(i6 >> 4);
                }
            } else {
                i3 = i4;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m1073c(char c3) {
        if (c3 <= 127) {
            return this.f1219e[c3];
        }
        return -1;
    }

    /* JADX INFO: renamed from: d */
    public final int m1074d(int i3) {
        if (i3 <= 127) {
            return this.f1219e[i3];
        }
        return -1;
    }

    /* JADX INFO: renamed from: e */
    public final String m1075e(byte[] bArr) {
        char[] cArr;
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        int i3 = this.f1224j >> 2;
        int i4 = length - 3;
        int i5 = 0;
        loop0: while (true) {
            int i6 = i3;
            do {
                cArr = this.f1220f;
                if (i5 > i4) {
                    break loop0;
                }
                int i7 = i5 + 2;
                int i8 = ((bArr[i5 + 1] & 255) | (bArr[i5] << 8)) << 8;
                i5 += 3;
                int i9 = i8 | (bArr[i7] & 255);
                sb.append(cArr[(i9 >> 18) & 63]);
                sb.append(cArr[(i9 >> 12) & 63]);
                sb.append(cArr[(i9 >> 6) & 63]);
                sb.append(cArr[i9 & 63]);
                i6--;
            } while (i6 > 0);
            sb.append("\\n");
        }
        int i10 = length - i5;
        if (i10 > 0) {
            int i11 = i5 + 1;
            int i12 = bArr[i5] << 16;
            if (i10 == 2) {
                i12 |= (bArr[i11] & 255) << 8;
            }
            sb.append(cArr[(i12 >> 18) & 63]);
            sb.append(cArr[(i12 >> 12) & 63]);
            if (this.f1225k) {
                char c3 = this.f1223i;
                sb.append(i10 == 2 ? cArr[(i12 >> 6) & 63] : c3);
                sb.append(c3);
            } else if (i10 == 2) {
                sb.append(cArr[(i12 >> 6) & 63]);
            }
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C0533a.class) {
            return false;
        }
        C0533a c0533a = (C0533a) obj;
        return c0533a.f1223i == this.f1223i && c0533a.f1224j == this.f1224j && c0533a.f1225k == this.f1225k && c0533a.f1226l == this.f1226l && this.f1222h.equals(c0533a.f1222h);
    }

    /* JADX INFO: renamed from: f */
    public final int m1076f(int i3, byte[] bArr, int i4) {
        byte[] bArr2 = this.f1221g;
        bArr[i4] = bArr2[(i3 >> 18) & 63];
        bArr[i4 + 1] = bArr2[(i3 >> 12) & 63];
        int i5 = i4 + 3;
        bArr[i4 + 2] = bArr2[(i3 >> 6) & 63];
        int i6 = i4 + 4;
        bArr[i5] = bArr2[i3 & 63];
        return i6;
    }

    /* JADX INFO: renamed from: g */
    public final int m1077g(int i3, char[] cArr, int i4) {
        char[] cArr2 = this.f1220f;
        cArr[i4] = cArr2[(i3 >> 18) & 63];
        cArr[i4 + 1] = cArr2[(i3 >> 12) & 63];
        int i5 = i4 + 3;
        cArr[i4 + 2] = cArr2[(i3 >> 6) & 63];
        int i6 = i4 + 4;
        cArr[i5] = cArr2[i3 & 63];
        return i6;
    }

    /* JADX INFO: renamed from: h */
    public final int m1078h(int i3, int i4, int i5, char[] cArr) {
        char[] cArr2 = this.f1220f;
        cArr[i5] = cArr2[(i3 >> 18) & 63];
        int i6 = i5 + 2;
        cArr[i5 + 1] = cArr2[(i3 >> 12) & 63];
        if (!this.f1225k) {
            if (i4 != 2) {
                return i6;
            }
            int i7 = i5 + 3;
            cArr[i6] = cArr2[(i3 >> 6) & 63];
            return i7;
        }
        int i8 = i5 + 3;
        char c3 = this.f1223i;
        cArr[i6] = i4 == 2 ? cArr2[(i3 >> 6) & 63] : c3;
        int i9 = i5 + 4;
        cArr[i8] = c3;
        return i9;
    }

    public final int hashCode() {
        return this.f1222h.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final int m1079i(int i3, int i4, byte[] bArr, int i5) {
        byte[] bArr2 = this.f1221g;
        bArr[i5] = bArr2[(i3 >> 18) & 63];
        int i6 = i5 + 2;
        bArr[i5 + 1] = bArr2[(i3 >> 12) & 63];
        if (!this.f1225k) {
            if (i4 != 2) {
                return i6;
            }
            int i7 = i5 + 3;
            bArr[i6] = bArr2[(i3 >> 6) & 63];
            return i7;
        }
        byte b3 = (byte) this.f1223i;
        int i8 = i5 + 3;
        bArr[i6] = i4 == 2 ? bArr2[(i3 >> 6) & 63] : b3;
        int i9 = i5 + 4;
        bArr[i8] = b3;
        return i9;
    }

    /* JADX INFO: renamed from: j */
    public final String m1080j() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end. This Base64Variant might have been incorrectly configured", this.f1222h, Character.valueOf(this.f1223i));
    }

    /* JADX INFO: renamed from: k */
    public final boolean m1081k() {
        return this.f1226l == 2;
    }

    public Object readResolve() {
        C0533a c0533a = AbstractC0534b.f1227a;
        String str = c0533a.f1222h;
        String str2 = this.f1222h;
        if (!str.equals(str2)) {
            c0533a = AbstractC0534b.f1228b;
            if (!c0533a.f1222h.equals(str2)) {
                c0533a = AbstractC0534b.f1229c;
                if (!c0533a.f1222h.equals(str2)) {
                    c0533a = AbstractC0534b.f1230d;
                    if (!c0533a.f1222h.equals(str2)) {
                        throw new IllegalArgumentException(AbstractC0032g.m152j("No Base64Variant with name ", str2 == null ? "<null>" : AbstractC0032g.m154l("'", str2, "'")));
                    }
                }
            }
        }
        C0533a c0533a2 = c0533a;
        boolean z3 = this.f1225k;
        boolean z4 = c0533a2.f1225k;
        return (z3 == z4 && this.f1223i == c0533a2.f1223i && this.f1226l == c0533a2.f1226l && this.f1224j == c0533a2.f1224j && z3 == z4) ? c0533a2 : new C0533a(c0533a2, this.f1222h, z3, this.f1223i, this.f1226l, this.f1224j);
    }

    public final String toString() {
        return this.f1222h;
    }

    public C0533a(C0533a c0533a, String str, boolean z3, char c3, int i3, int i4) {
        int[] iArr = new int[128];
        this.f1219e = iArr;
        char[] cArr = new char[64];
        this.f1220f = cArr;
        byte[] bArr = new byte[64];
        this.f1221g = bArr;
        this.f1222h = str;
        byte[] bArr2 = c0533a.f1221g;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = c0533a.f1220f;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = c0533a.f1219e;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.f1225k = z3;
        this.f1223i = c3;
        this.f1224j = i4;
        this.f1226l = i3;
    }
}
