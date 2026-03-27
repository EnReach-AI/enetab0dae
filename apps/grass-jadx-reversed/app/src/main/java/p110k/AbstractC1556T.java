package p110k;

import android.widget.TextView;

/* JADX INFO: renamed from: k.T */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1556T {
    /* JADX INFO: renamed from: a */
    public static int m3608a(TextView textView) {
        return textView.getAutoSizeStepGranularity();
    }

    /* JADX INFO: renamed from: b */
    public static void m3609b(TextView textView, int i3, int i4, int i5, int i6) {
        textView.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
    }

    /* JADX INFO: renamed from: c */
    public static void m3610c(TextView textView, int[] iArr, int i3) {
        textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
    }

    /* JADX INFO: renamed from: d */
    public static boolean m3611d(TextView textView, String str) {
        return textView.setFontVariationSettings(str);
    }
}
