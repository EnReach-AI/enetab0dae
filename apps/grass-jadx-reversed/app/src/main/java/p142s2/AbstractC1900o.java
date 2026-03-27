package p142s2;

import java.util.Collection;
import java.util.Iterator;
import p119m2.AbstractC1766e;
import p131p2.C1831e;
import p131p2.C1832f;

/* JADX INFO: renamed from: s2.o */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1900o extends AbstractC1899n {
    /* JADX INFO: renamed from: h */
    public static boolean m4231h(CharSequence charSequence) {
        AbstractC1766e.m3920e("<this>", charSequence);
        if (charSequence.length() == 0) {
            return true;
        }
        Iterable c1832f = new C1832f(0, charSequence.length() - 1, 1);
        if ((c1832f instanceof Collection) && ((Collection) c1832f).isEmpty()) {
            return true;
        }
        Iterator it = c1832f.iterator();
        while (((C1831e) it).f6343g) {
            char cCharAt = charSequence.charAt(((C1831e) it).m4074a());
            if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: i */
    public static boolean m4232i(int i3, int i4, int i5, String str, String str2, boolean z3) {
        AbstractC1766e.m3920e("<this>", str);
        AbstractC1766e.m3920e("other", str2);
        return !z3 ? str.regionMatches(i3, str2, i4, i5) : str.regionMatches(z3, i3, str2, i4, i5);
    }
}
