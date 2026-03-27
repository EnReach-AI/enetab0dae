package p018F;

import java.util.Locale;
import p023H.AbstractC0240c;

/* JADX INFO: renamed from: F.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0211c {

    /* JADX INFO: renamed from: a */
    public static final Locale[] f516a = {new Locale("en", "XA"), new Locale("ar", "XB")};

    /* JADX INFO: renamed from: a */
    public static Locale m418a(String str) {
        return Locale.forLanguageTag(str);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m419b(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return true;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage())) {
            return false;
        }
        Locale[] localeArr = f516a;
        int length = localeArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                for (Locale locale3 : localeArr) {
                    if (!locale3.equals(locale2)) {
                    }
                }
                String strM482c = AbstractC0240c.m482c(AbstractC0240c.m480a(AbstractC0240c.m481b(locale)));
                if (!strM482c.isEmpty()) {
                    return strM482c.equals(AbstractC0240c.m482c(AbstractC0240c.m480a(AbstractC0240c.m481b(locale2))));
                }
                String country = locale.getCountry();
                return country.isEmpty() || country.equals(locale2.getCountry());
            }
            if (localeArr[i3].equals(locale)) {
                break;
            }
            i3++;
        }
        return false;
    }
}
