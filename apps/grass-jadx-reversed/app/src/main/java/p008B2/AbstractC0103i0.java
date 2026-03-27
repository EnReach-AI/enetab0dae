package p008B2;

import java.util.Locale;
import java.util.Map;
import p083b2.C1061f;
import p083b2.C1067l;
import p083b2.C1069n;
import p083b2.C1070o;
import p083b2.C1071p;
import p083b2.C1072q;
import p083b2.C1073r;
import p083b2.C1075t;
import p083b2.C1076u;
import p083b2.C1077v;
import p086c2.AbstractC1097p;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;
import p119m2.C1763b;
import p146t2.C1922a;

/* JADX INFO: renamed from: B2.i0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0103i0 {

    /* JADX INFO: renamed from: a */
    public static final Map f292a;

    static {
        C1061f c1061f = new C1061f(AbstractC1770i.m3927a(String.class), C0115o0.f310a);
        C1061f c1061f2 = new C1061f(AbstractC1770i.m3927a(Character.TYPE), C0114o.f308a);
        C1061f c1061f3 = new C1061f(AbstractC1770i.m3927a(char[].class), C0112n.f305c);
        C1061f c1061f4 = new C1061f(AbstractC1770i.m3927a(Double.TYPE), C0126u.f327a);
        C1061f c1061f5 = new C1061f(AbstractC1770i.m3927a(double[].class), C0124t.f324c);
        C1061f c1061f6 = new C1061f(AbstractC1770i.m3927a(Float.TYPE), C0064D.f215a);
        C1061f c1061f7 = new C1061f(AbstractC1770i.m3927a(float[].class), C0062C.f212c);
        C1061f c1061f8 = new C1061f(AbstractC1770i.m3927a(Long.TYPE), C0076P.f239a);
        C1061f c1061f9 = new C1061f(AbstractC1770i.m3927a(long[].class), C0075O.f238c);
        C1061f c1061f10 = new C1061f(AbstractC1770i.m3927a(C1072q.class), C0135y0.f347a);
        C1061f c1061f11 = new C1061f(AbstractC1770i.m3927a(C1073r.class), C0133x0.f344c);
        C1061f c1061f12 = new C1061f(AbstractC1770i.m3927a(Integer.TYPE), C0071K.f231a);
        C1061f c1061f13 = new C1061f(AbstractC1770i.m3927a(int[].class), C0070J.f230c);
        C1061f c1061f14 = new C1061f(AbstractC1770i.m3927a(C1070o.class), C0129v0.f332a);
        C1061f c1061f15 = new C1061f(AbstractC1770i.m3927a(C1071p.class), C0127u0.f329c);
        C1061f c1061f16 = new C1061f(AbstractC1770i.m3927a(Short.TYPE), C0113n0.f306a);
        C1061f c1061f17 = new C1061f(AbstractC1770i.m3927a(short[].class), C0111m0.f304c);
        C1061f c1061f18 = new C1061f(AbstractC1770i.m3927a(C1075t.class), C0061B0.f210a);
        C1061f c1061f19 = new C1061f(AbstractC1770i.m3927a(C1076u.class), C0059A0.f207c);
        C1061f c1061f20 = new C1061f(AbstractC1770i.m3927a(Byte.TYPE), C0102i.f290a);
        C1061f c1061f21 = new C1061f(AbstractC1770i.m3927a(byte[].class), C0100h.f287c);
        C1061f c1061f22 = new C1061f(AbstractC1770i.m3927a(C1067l.class), C0123s0.f322a);
        C1061f c1061f23 = new C1061f(AbstractC1770i.m3927a(C1069n.class), C0121r0.f319c);
        C1061f c1061f24 = new C1061f(AbstractC1770i.m3927a(Boolean.TYPE), C0096f.f281a);
        C1061f c1061f25 = new C1061f(AbstractC1770i.m3927a(boolean[].class), C0094e.f280c);
        C1061f c1061f26 = new C1061f(AbstractC1770i.m3927a(C1077v.class), C0063C0.f213b);
        C1061f c1061f27 = new C1061f(AbstractC1770i.m3927a(Void.class), C0083X.f252a);
        C1763b c1763bM3927a = AbstractC1770i.m3927a(C1922a.class);
        int i3 = C1922a.f6730h;
        f292a = AbstractC1097p.m2841j(c1061f, c1061f2, c1061f3, c1061f4, c1061f5, c1061f6, c1061f7, c1061f8, c1061f9, c1061f10, c1061f11, c1061f12, c1061f13, c1061f14, c1061f15, c1061f16, c1061f17, c1061f18, c1061f19, c1061f20, c1061f21, c1061f22, c1061f23, c1061f24, c1061f25, c1061f26, c1061f27, new C1061f(c1763bM3927a, C0128v.f330a));
    }

    /* JADX INFO: renamed from: a */
    public static final String m266a(String str) {
        String strValueOf;
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            String strValueOf2 = String.valueOf(cCharAt);
            AbstractC1766e.m3918c("null cannot be cast to non-null type java.lang.String", strValueOf2);
            Locale locale = Locale.ROOT;
            strValueOf = strValueOf2.toUpperCase(locale);
            AbstractC1766e.m3919d("toUpperCase(...)", strValueOf);
            if (strValueOf.length() <= 1) {
                strValueOf = String.valueOf(Character.toTitleCase(cCharAt));
            } else if (cCharAt != 329) {
                char cCharAt2 = strValueOf.charAt(0);
                String strSubstring = strValueOf.substring(1);
                AbstractC1766e.m3919d("substring(...)", strSubstring);
                String lowerCase = strSubstring.toLowerCase(locale);
                AbstractC1766e.m3919d("toLowerCase(...)", lowerCase);
                strValueOf = cCharAt2 + lowerCase;
            }
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        sb.append((Object) strValueOf);
        String strSubstring2 = str.substring(1);
        AbstractC1766e.m3919d("this as java.lang.String).substring(startIndex)", strSubstring2);
        sb.append(strSubstring2);
        return sb.toString();
    }
}
