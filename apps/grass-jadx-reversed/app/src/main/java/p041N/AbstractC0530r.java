package p041N;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.widget.TextView;

/* JADX INFO: renamed from: N.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0530r {
    /* JADX INFO: renamed from: a */
    public static String[] m1067a(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    /* JADX INFO: renamed from: b */
    public static PrecomputedText.Params m1068b(TextView textView) {
        return textView.getTextMetricsParams();
    }

    /* JADX INFO: renamed from: c */
    public static void m1069c(TextView textView, int i3) {
        textView.setFirstBaselineToTopHeight(i3);
    }
}
