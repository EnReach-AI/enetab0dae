package p142s2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p008B2.C0085Z;
import p086c2.AbstractC1084c;
import p086c2.AbstractC1085d;
import p086c2.AbstractC1086e;
import p086c2.AbstractC1087f;
import p117m0.AbstractC1720o;
import p119m2.AbstractC1766e;
import p139r2.AbstractC1856c;
import p139r2.C1860g;

/* JADX INFO: renamed from: s2.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1893h extends AbstractC1720o {
    /* JADX INFO: renamed from: d */
    public static String m4227d(String str) {
        Comparable comparable;
        AbstractC1766e.m3920e("<this>", str);
        int i3 = 0;
        List listM4134j = AbstractC1856c.m4134j(new C1860g(new C1888c(str, 0, 0, new C1901p(AbstractC1084c.m2829w(new String[]{"\r\n", "\n", "\r"}), false)), new C0085Z(3, str)));
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : listM4134j) {
            if (true ^ AbstractC1900o.m4231h((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC1087f.m2838v(arrayList, 10));
        for (String str2 : arrayList) {
            int length = str2.length();
            int length2 = 0;
            while (true) {
                if (length2 >= length) {
                    length2 = -1;
                    break;
                }
                char cCharAt = str2.charAt(length2);
                if (!(Character.isWhitespace(cCharAt) || Character.isSpaceChar(cCharAt))) {
                    break;
                }
                length2++;
            }
            if (length2 == -1) {
                length2 = str2.length();
            }
            arrayList2.add(Integer.valueOf(length2));
        }
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            comparable = (Comparable) it.next();
            while (it.hasNext()) {
                Comparable comparable2 = (Comparable) it.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listM4134j.size();
        int iM2836t = AbstractC1086e.m2836t(listM4134j);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listM4134j) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            String str3 = (String) obj2;
            String strM4218k = ((i3 == 0 || i3 == iM2836t) && AbstractC1900o.m4231h(str3)) ? null : AbstractC1892g.m4218k(iIntValue, str3);
            if (strM4218k != null) {
                arrayList3.add(strM4218k);
            }
            i3 = i4;
        }
        StringBuilder sb = new StringBuilder(length3);
        AbstractC1085d.m2833w(arrayList3, sb, "\n", "", "", -1, "...", null);
        String string = sb.toString();
        AbstractC1766e.m3919d("toString(...)", string);
        return string;
    }
}
