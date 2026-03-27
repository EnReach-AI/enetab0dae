package p018F;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: renamed from: F.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0212d {
    /* JADX INFO: renamed from: a */
    public static LocaleList m420a(Locale... localeArr) {
        return new LocaleList(localeArr);
    }

    /* JADX INFO: renamed from: b */
    public static LocaleList m421b() {
        return LocaleList.getAdjustedDefault();
    }

    /* JADX INFO: renamed from: c */
    public static LocaleList m422c() {
        return LocaleList.getDefault();
    }
}
