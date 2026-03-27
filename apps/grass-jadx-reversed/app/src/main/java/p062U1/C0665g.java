package p062U1;

import java.util.EnumMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p005B.AbstractC0032g;
import p033K0.AbstractC0405c;
import p051Q1.C0601b;

/* JADX INFO: renamed from: U1.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0665g extends AbstractC0405c {

    /* JADX INFO: renamed from: f */
    public static final int[] f1810f = {1, 1, 1, 1};

    /* JADX INFO: renamed from: g */
    public static final int[] f1811g = {3, 1, 1};

    /* JADX INFO: renamed from: h */
    public static final int[][] f1812h = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f1813e;

    public /* synthetic */ C0665g(int i3) {
        this.f1813e = i3;
    }

    /* JADX INFO: renamed from: o */
    public static void m1621o(boolean[] zArr, int i3, int[] iArr) {
        int length = iArr.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i3 + 1;
            zArr[i3] = iArr[i4] != 0;
            i4++;
            i3 = i5;
        }
    }

    /* JADX INFO: renamed from: p */
    public static int m1622p(int i3, String str) {
        int iIndexOf = 0;
        int i4 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i4;
            i4++;
            if (i4 > i3) {
                i4 = 1;
            }
        }
        return iIndexOf % 47;
    }

    /* JADX INFO: renamed from: q */
    public static int m1623q(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        int i4 = 1;
        if (i3 >= length) {
            return 1;
        }
        char cCharAt = charSequence.charAt(i3);
        if (cCharAt == 241) {
            return 4;
        }
        if (cCharAt >= '0' && cCharAt <= '9') {
            int i5 = i3 + 1;
            i4 = 2;
            if (i5 >= length) {
                return 2;
            }
            char cCharAt2 = charSequence.charAt(i5);
            if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                return 3;
            }
        }
        return i4;
    }

    /* JADX INFO: renamed from: r */
    public static void m1624r(int[] iArr, int i3) {
        for (int i4 = 0; i4 < 9; i4++) {
            int i5 = 1;
            if (((1 << (8 - i4)) & i3) != 0) {
                i5 = 2;
            }
            iArr[i4] = i5;
        }
    }

    /* JADX INFO: renamed from: s */
    public static void m1625s(int[] iArr, int i3) {
        for (int i4 = 0; i4 < 9; i4++) {
            int i5 = 1;
            if (((1 << (8 - i4)) & i3) == 0) {
                i5 = 0;
            }
            iArr[i4] = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0188  */
    @Override // p033K0.AbstractC0405c
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean[] mo893e(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 1030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p062U1.C0665g.mo893e(java.lang.String):boolean[]");
    }

    @Override // p033K0.AbstractC0405c, p043N1.InterfaceC0562d
    /* JADX INFO: renamed from: i */
    public final C0601b mo434i(String str, int i3, EnumMap enumMap) {
        switch (this.f1813e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (i3 == 9) {
                    return super.mo434i(str, i3, enumMap);
                }
                throw new IllegalArgumentException("Can only encode ITF, but got ".concat(AbstractC0032g.m165w(i3)));
            case 1:
                if (i3 == 5) {
                    return super.mo434i(str, i3, enumMap);
                }
                throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(AbstractC0032g.m165w(i3)));
            case 2:
                if (i3 == 3) {
                    return super.mo434i(str, i3, enumMap);
                }
                throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(AbstractC0032g.m165w(i3)));
            default:
                if (i3 == 4) {
                    return super.mo434i(str, i3, enumMap);
                }
                throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(AbstractC0032g.m165w(i3)));
        }
    }
}
