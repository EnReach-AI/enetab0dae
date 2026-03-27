package p023H;

import android.icu.util.ULocale;
import java.util.Locale;

/* JADX INFO: renamed from: H.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0240c {
    /* JADX INFO: renamed from: a */
    public static ULocale m480a(Object obj) {
        return ULocale.addLikelySubtags((ULocale) obj);
    }

    /* JADX INFO: renamed from: b */
    public static ULocale m481b(Locale locale) {
        return ULocale.forLocale(locale);
    }

    /* JADX INFO: renamed from: c */
    public static String m482c(Object obj) {
        return ((ULocale) obj).getScript();
    }
}
