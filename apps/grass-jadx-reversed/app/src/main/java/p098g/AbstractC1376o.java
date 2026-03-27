package p098g;

import android.content.res.Configuration;
import android.os.LocaleList;
import p018F.C0213e;

/* JADX INFO: renamed from: g.o */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1376o {
    /* JADX INFO: renamed from: a */
    public static void m3358a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    /* JADX INFO: renamed from: b */
    public static C0213e m3359b(Configuration configuration) {
        return C0213e.m423a(configuration.getLocales().toLanguageTags());
    }

    /* JADX INFO: renamed from: c */
    public static void m3360c(C0213e c0213e) {
        LocaleList.setDefault(LocaleList.forLanguageTags(c0213e.f518a.f519a.toLanguageTags()));
    }

    /* JADX INFO: renamed from: d */
    public static void m3361d(Configuration configuration, C0213e c0213e) {
        configuration.setLocales(LocaleList.forLanguageTags(c0213e.f518a.f519a.toLanguageTags()));
    }
}
