package p062U1;

import java.util.EnumMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p005B.AbstractC0032g;
import p033K0.AbstractC0405c;
import p043N1.C0560b;
import p051Q1.C0601b;

/* JADX INFO: renamed from: U1.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0664f extends AbstractC0405c {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f1809e;

    public /* synthetic */ C0664f(int i3) {
        this.f1809e = i3;
    }

    @Override // p033K0.AbstractC0405c
    /* JADX INFO: renamed from: e */
    public final boolean[] mo893e(String str) {
        switch (this.f1809e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int length = str.length();
                if (length == 12) {
                    try {
                        str = str + AbstractC0666h.m1627j(str);
                    } catch (C0560b e3) {
                        throw new IllegalArgumentException(e3);
                    }
                } else {
                    if (length != 13) {
                        throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
                    }
                    try {
                        if (!AbstractC0666h.m1626i(str)) {
                            throw new IllegalArgumentException("Contents do not pass checksum");
                        }
                    } catch (C0560b unused) {
                        throw new IllegalArgumentException("Illegal contents");
                    }
                }
                int i3 = AbstractC0663e.f1807g[Character.digit(str.charAt(0), 10)];
                boolean[] zArr = new boolean[95];
                int iM883b = AbstractC0405c.m883b(zArr, 0, AbstractC0666h.f1814b, true);
                for (int i4 = 1; i4 <= 6; i4++) {
                    int iDigit = Character.digit(str.charAt(i4), 10);
                    if (((i3 >> (6 - i4)) & 1) == 1) {
                        iDigit += 10;
                    }
                    iM883b += AbstractC0405c.m883b(zArr, iM883b, AbstractC0666h.f1818f[iDigit], false);
                }
                int iM883b2 = AbstractC0405c.m883b(zArr, iM883b, AbstractC0666h.f1815c, false) + iM883b;
                for (int i5 = 7; i5 <= 12; i5++) {
                    iM883b2 += AbstractC0405c.m883b(zArr, iM883b2, AbstractC0666h.f1817e[Character.digit(str.charAt(i5), 10)], true);
                }
                AbstractC0405c.m883b(zArr, iM883b2, AbstractC0666h.f1814b, true);
                return zArr;
            case 1:
                int length2 = str.length();
                if (length2 == 7) {
                    try {
                        str = str + AbstractC0666h.m1627j(str);
                    } catch (C0560b e4) {
                        throw new IllegalArgumentException(e4);
                    }
                } else {
                    if (length2 != 8) {
                        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length2)));
                    }
                    try {
                        if (!AbstractC0666h.m1626i(str)) {
                            throw new IllegalArgumentException("Contents do not pass checksum");
                        }
                    } catch (C0560b unused2) {
                        throw new IllegalArgumentException("Illegal contents");
                    }
                }
                boolean[] zArr2 = new boolean[67];
                int iM883b3 = AbstractC0405c.m883b(zArr2, 0, AbstractC0666h.f1814b, true);
                for (int i6 = 0; i6 <= 3; i6++) {
                    iM883b3 += AbstractC0405c.m883b(zArr2, iM883b3, AbstractC0666h.f1817e[Character.digit(str.charAt(i6), 10)], false);
                }
                int iM883b4 = AbstractC0405c.m883b(zArr2, iM883b3, AbstractC0666h.f1815c, false) + iM883b3;
                for (int i7 = 4; i7 <= 7; i7++) {
                    iM883b4 += AbstractC0405c.m883b(zArr2, iM883b4, AbstractC0666h.f1817e[Character.digit(str.charAt(i7), 10)], true);
                }
                AbstractC0405c.m883b(zArr2, iM883b4, AbstractC0666h.f1814b, true);
                return zArr2;
            default:
                int length3 = str.length();
                if (length3 == 7) {
                    try {
                        str = str + AbstractC0666h.m1627j(AbstractC0663e.m1620k(str));
                    } catch (C0560b e5) {
                        throw new IllegalArgumentException(e5);
                    }
                } else {
                    if (length3 != 8) {
                        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length3)));
                    }
                    try {
                        if (!AbstractC0666h.m1626i(str)) {
                            throw new IllegalArgumentException("Contents do not pass checksum");
                        }
                    } catch (C0560b unused3) {
                        throw new IllegalArgumentException("Illegal contents");
                    }
                }
                int iDigit2 = Character.digit(str.charAt(0), 10);
                if (iDigit2 != 0 && iDigit2 != 1) {
                    throw new IllegalArgumentException("Number system must be 0 or 1");
                }
                int i8 = AbstractC0663e.f1808h[iDigit2][Character.digit(str.charAt(7), 10)];
                boolean[] zArr3 = new boolean[51];
                int iM883b5 = AbstractC0405c.m883b(zArr3, 0, AbstractC0666h.f1814b, true);
                for (int i9 = 1; i9 <= 6; i9++) {
                    int iDigit3 = Character.digit(str.charAt(i9), 10);
                    if (((i8 >> (6 - i9)) & 1) == 1) {
                        iDigit3 += 10;
                    }
                    iM883b5 += AbstractC0405c.m883b(zArr3, iM883b5, AbstractC0666h.f1818f[iDigit3], false);
                }
                AbstractC0405c.m883b(zArr3, iM883b5, AbstractC0666h.f1816d, false);
                return zArr3;
        }
    }

    @Override // p033K0.AbstractC0405c
    /* JADX INFO: renamed from: g */
    public final int mo894g() {
        return 9;
    }

    @Override // p033K0.AbstractC0405c, p043N1.InterfaceC0562d
    /* JADX INFO: renamed from: i */
    public final C0601b mo434i(String str, int i3, EnumMap enumMap) {
        switch (this.f1809e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (i3 == 8) {
                    return super.mo434i(str, i3, enumMap);
                }
                throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(AbstractC0032g.m165w(i3)));
            case 1:
                if (i3 == 7) {
                    return super.mo434i(str, i3, enumMap);
                }
                throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(AbstractC0032g.m165w(i3)));
            default:
                if (i3 == 16) {
                    return super.mo434i(str, i3, enumMap);
                }
                throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(AbstractC0032g.m165w(i3)));
        }
    }
}
