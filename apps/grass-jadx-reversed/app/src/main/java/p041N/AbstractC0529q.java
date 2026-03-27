package p041N;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.TextView;

/* JADX INFO: renamed from: N.q */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0529q {
    /* JADX INFO: renamed from: a */
    public static int m1059a(TextView textView) {
        return textView.getBreakStrategy();
    }

    /* JADX INFO: renamed from: b */
    public static ColorStateList m1060b(TextView textView) {
        return textView.getCompoundDrawableTintList();
    }

    /* JADX INFO: renamed from: c */
    public static PorterDuff.Mode m1061c(TextView textView) {
        return textView.getCompoundDrawableTintMode();
    }

    /* JADX INFO: renamed from: d */
    public static int m1062d(TextView textView) {
        return textView.getHyphenationFrequency();
    }

    /* JADX INFO: renamed from: e */
    public static void m1063e(TextView textView, int i3) {
        textView.setBreakStrategy(i3);
    }

    /* JADX INFO: renamed from: f */
    public static void m1064f(TextView textView, ColorStateList colorStateList) {
        textView.setCompoundDrawableTintList(colorStateList);
    }

    /* JADX INFO: renamed from: g */
    public static void m1065g(TextView textView, PorterDuff.Mode mode) {
        textView.setCompoundDrawableTintMode(mode);
    }

    /* JADX INFO: renamed from: h */
    public static void m1066h(TextView textView, int i3) {
        textView.setHyphenationFrequency(i3);
    }
}
