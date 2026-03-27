package p086c2;

import java.util.AbstractCollection;
import java.util.Iterator;
import p115l2.InterfaceC1689l;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: c2.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1085d extends AbstractC1091j {
    /* JADX INFO: renamed from: w */
    public static final void m2833w(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, InterfaceC1689l interfaceC1689l) {
        AbstractC1766e.m3920e("<this>", iterable);
        AbstractC1766e.m3920e("separator", charSequence);
        AbstractC1766e.m3920e("prefix", charSequence2);
        AbstractC1766e.m3920e("postfix", charSequence3);
        AbstractC1766e.m3920e("truncated", charSequence4);
        sb.append(charSequence2);
        Iterator it = iterable.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i4++;
            if (i4 > 1) {
                sb.append(charSequence);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            if (interfaceC1689l != null) {
                sb.append((CharSequence) interfaceC1689l.mo249f(next));
            } else {
                if (next != null ? next instanceof CharSequence : true) {
                    sb.append((CharSequence) next);
                } else if (next instanceof Character) {
                    sb.append(((Character) next).charValue());
                } else {
                    sb.append((CharSequence) String.valueOf(next));
                }
            }
        }
        if (i3 >= 0 && i4 > i3) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    /* JADX INFO: renamed from: x */
    public static String m2834x(Iterable iterable, String str, String str2, String str3, InterfaceC1689l interfaceC1689l, int i3) {
        if ((i3 & 32) != 0) {
            interfaceC1689l = null;
        }
        InterfaceC1689l interfaceC1689l2 = interfaceC1689l;
        AbstractC1766e.m3920e("<this>", iterable);
        AbstractC1766e.m3920e("prefix", str2);
        StringBuilder sb = new StringBuilder();
        m2833w(iterable, sb, str, str2, str3, -1, "...", interfaceC1689l2);
        String string = sb.toString();
        AbstractC1766e.m3919d("toString(...)", string);
        return string;
    }

    /* JADX INFO: renamed from: y */
    public static final void m2835y(Iterable iterable, AbstractCollection abstractCollection) {
        AbstractC1766e.m3920e("<this>", iterable);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }
}
