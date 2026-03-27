package p110k;

import android.os.LocaleList;
import android.widget.TextView;

/* JADX INFO: renamed from: k.S */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1554S {
    /* JADX INFO: renamed from: a */
    public static LocaleList m3606a(String str) {
        return LocaleList.forLanguageTags(str);
    }

    /* JADX INFO: renamed from: b */
    public static void m3607b(TextView textView, LocaleList localeList) {
        textView.setTextLocales(localeList);
    }
}
