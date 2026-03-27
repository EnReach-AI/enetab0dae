package p005B;

import android.graphics.Color;

/* JADX INFO: renamed from: B.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0026a {

    /* JADX INFO: renamed from: a */
    public static final ThreadLocal f79a = new ThreadLocal();

    /* JADX INFO: renamed from: a */
    public static int m104a(double d, double d3, double d4) {
        double d5 = (((-0.4986d) * d4) + (((-1.5372d) * d3) + (3.2406d * d))) / 100.0d;
        double d6 = ((0.0415d * d4) + ((1.8758d * d3) + ((-0.9689d) * d))) / 100.0d;
        double d7 = ((1.057d * d4) + (((-0.204d) * d3) + (0.0557d * d))) / 100.0d;
        double dPow = d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d;
        double dPow2 = d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d;
        double dPow3 = d7 > 0.0031308d ? (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d : d7 * 12.92d;
        int iRound = (int) Math.round(dPow * 255.0d);
        int iMin = iRound < 0 ? 0 : Math.min(iRound, 255);
        int iRound2 = (int) Math.round(dPow2 * 255.0d);
        int iMin2 = iRound2 < 0 ? 0 : Math.min(iRound2, 255);
        int iRound3 = (int) Math.round(dPow3 * 255.0d);
        return Color.rgb(iMin, iMin2, iRound3 >= 0 ? Math.min(iRound3, 255) : 0);
    }

    /* JADX INFO: renamed from: b */
    public static int m105b(int i3, int i4) {
        int iAlpha = Color.alpha(i4);
        int iAlpha2 = Color.alpha(i3);
        int i5 = 255 - (((255 - iAlpha2) * (255 - iAlpha)) / 255);
        return Color.argb(i5, m106c(Color.red(i3), iAlpha2, Color.red(i4), iAlpha, i5), m106c(Color.green(i3), iAlpha2, Color.green(i4), iAlpha, i5), m106c(Color.blue(i3), iAlpha2, Color.blue(i4), iAlpha, i5));
    }

    /* JADX INFO: renamed from: c */
    public static int m106c(int i3, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        return (((255 - i4) * (i5 * i6)) + ((i3 * 255) * i4)) / (i7 * 255);
    }

    /* JADX INFO: renamed from: d */
    public static int m107d(int i3, int i4) {
        if (i4 < 0 || i4 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i3 & 16777215) | (i4 << 24);
    }
}
