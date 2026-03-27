package p098g;

import android.app.LocaleManager;
import android.os.LocaleList;

/* JADX INFO: renamed from: g.i */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1370i {
    /* JADX INFO: renamed from: a */
    public static LocaleList m3345a(Object obj) {
        return ((LocaleManager) obj).getApplicationLocales();
    }

    /* JADX INFO: renamed from: b */
    public static void m3346b(Object obj, LocaleList localeList) {
        ((LocaleManager) obj).setApplicationLocales(localeList);
    }
}
