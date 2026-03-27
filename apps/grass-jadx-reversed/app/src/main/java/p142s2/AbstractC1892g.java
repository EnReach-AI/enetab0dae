package p142s2;

import java.util.NoSuchElementException;
import p086c2.AbstractC1084c;
import p117m0.AbstractC1717l;
import p119m2.AbstractC1766e;
import p131p2.C1832f;

/* JADX INFO: renamed from: s2.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1892g extends AbstractC1900o {
    /* JADX INFO: renamed from: j */
    public static boolean m4217j(CharSequence charSequence, String str) {
        AbstractC1766e.m3920e("<this>", charSequence);
        return m4222o(charSequence, str, 0, false, 2) >= 0;
    }

    /* JADX INFO: renamed from: k */
    public static String m4218k(int i3, String str) {
        AbstractC1766e.m3920e("<this>", str);
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested character count " + i3 + " is less than zero.").toString());
        }
        int length = str.length();
        if (i3 > length) {
            i3 = length;
        }
        String strSubstring = str.substring(i3);
        AbstractC1766e.m3919d("substring(...)", strSubstring);
        return strSubstring;
    }

    /* JADX INFO: renamed from: l */
    public static int m4219l(CharSequence charSequence) {
        AbstractC1766e.m3920e("<this>", charSequence);
        return charSequence.length() - 1;
    }

    /* JADX INFO: renamed from: m */
    public static final int m4220m(CharSequence charSequence, String str, int i3, boolean z3) {
        AbstractC1766e.m3920e("<this>", charSequence);
        AbstractC1766e.m3920e("string", str);
        if (!z3 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i3);
        }
        int length = charSequence.length();
        if (i3 < 0) {
            i3 = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        C1832f c1832f = new C1832f(i3, length, 1);
        boolean z4 = charSequence instanceof String;
        int i4 = c1832f.f6340g;
        int i5 = c1832f.f6339f;
        int i6 = c1832f.f6338e;
        if (!z4 || !(str instanceof String)) {
            if ((i4 > 0 && i6 <= i5) || (i4 < 0 && i5 <= i6)) {
                while (!m4224q(str, charSequence, i6, str.length(), z3)) {
                    if (i6 != i5) {
                        i6 += i4;
                    }
                }
                return i6;
            }
            return -1;
        }
        if ((i4 > 0 && i6 <= i5) || (i4 < 0 && i5 <= i6)) {
            while (!AbstractC1900o.m4232i(0, i6, str.length(), str, (String) charSequence, z3)) {
                if (i6 != i5) {
                    i6 += i4;
                }
            }
            return i6;
        }
        return -1;
    }

    /* JADX INFO: renamed from: n */
    public static int m4221n(CharSequence charSequence, char c3, int i3, boolean z3, int i4) {
        int i5;
        boolean z4 = true;
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        AbstractC1766e.m3920e("<this>", charSequence);
        if (!z3 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c3, i3);
        }
        char[] cArr = {c3};
        if (!z3 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(AbstractC1084c.m2827A(cArr), i3);
        }
        if (i3 < 0) {
            i3 = 0;
        }
        C1832f c1832f = new C1832f(i3, m4219l(charSequence), 1);
        int i6 = c1832f.f6339f;
        int i7 = c1832f.f6340g;
        if (i7 <= 0 ? i3 < i6 : i3 > i6) {
            z4 = false;
        }
        if (!z4) {
            i3 = i6;
        }
        while (z4) {
            if (i3 != i6) {
                i5 = i3 + i7;
            } else {
                if (!z4) {
                    throw new NoSuchElementException();
                }
                i5 = i3;
                z4 = false;
            }
            if (AbstractC1717l.m3802e(cArr[0], charSequence.charAt(i3), z3)) {
                return i3;
            }
            i3 = i5;
        }
        return -1;
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ int m4222o(CharSequence charSequence, String str, int i3, boolean z3, int i4) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return m4220m(charSequence, str, i3, z3);
    }

    /* JADX INFO: renamed from: p */
    public static int m4223p(CharSequence charSequence, char c3) {
        int iM4219l = m4219l(charSequence);
        AbstractC1766e.m3920e("<this>", charSequence);
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c3, iM4219l);
        }
        char[] cArr = {c3};
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(AbstractC1084c.m2827A(cArr), iM4219l);
        }
        int iM4219l2 = m4219l(charSequence);
        if (iM4219l > iM4219l2) {
            iM4219l = iM4219l2;
        }
        while (-1 < iM4219l) {
            if (AbstractC1717l.m3802e(cArr[0], charSequence.charAt(iM4219l), false)) {
                return iM4219l;
            }
            iM4219l--;
        }
        return -1;
    }

    /* JADX INFO: renamed from: q */
    public static final boolean m4224q(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, boolean z3) {
        AbstractC1766e.m3920e("<this>", charSequence);
        AbstractC1766e.m3920e("other", charSequence2);
        if (i3 < 0 || charSequence.length() - i4 < 0 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!AbstractC1717l.m3802e(charSequence.charAt(i5), charSequence2.charAt(i3 + i5), z3)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: r */
    public static String m4225r(String str, String str2) {
        AbstractC1766e.m3920e("delimiter", str2);
        int iM4222o = m4222o(str, str2, 0, false, 6);
        if (iM4222o == -1) {
            return str;
        }
        String strSubstring = str.substring(str2.length() + iM4222o, str.length());
        AbstractC1766e.m3919d("substring(...)", strSubstring);
        return strSubstring;
    }

    /* JADX INFO: renamed from: s */
    public static String m4226s(String str) {
        AbstractC1766e.m3920e("<this>", str);
        AbstractC1766e.m3920e("missingDelimiterValue", str);
        int iM4223p = m4223p(str, '.');
        if (iM4223p == -1) {
            return str;
        }
        String strSubstring = str.substring(iM4223p + 1, str.length());
        AbstractC1766e.m3919d("substring(...)", strSubstring);
        return strSubstring;
    }
}
