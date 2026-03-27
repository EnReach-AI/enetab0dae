package p023H;

import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import p026I.AbstractC0294b;

/* JADX INFO: renamed from: H.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0241d {

    /* JADX INFO: renamed from: a */
    public final TextPaint f594a;

    /* JADX INFO: renamed from: b */
    public final TextDirectionHeuristic f595b;

    /* JADX INFO: renamed from: c */
    public final int f596c;

    /* JADX INFO: renamed from: d */
    public final int f597d;

    public C0241d(PrecomputedText.Params params) {
        this.f594a = params.getTextPaint();
        this.f595b = params.getTextDirection();
        this.f596c = params.getBreakStrategy();
        this.f597d = params.getHyphenationFrequency();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0241d)) {
            return false;
        }
        C0241d c0241d = (C0241d) obj;
        if (this.f596c == c0241d.f596c && this.f597d == c0241d.f597d) {
            TextPaint textPaint = this.f594a;
            float textSize = textPaint.getTextSize();
            TextPaint textPaint2 = c0241d.f594a;
            return textSize == textPaint2.getTextSize() && textPaint.getTextScaleX() == textPaint2.getTextScaleX() && textPaint.getTextSkewX() == textPaint2.getTextSkewX() && textPaint.getLetterSpacing() == textPaint2.getLetterSpacing() && TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) && textPaint.getFlags() == textPaint2.getFlags() && textPaint.getTextLocales().equals(textPaint2.getTextLocales()) && (textPaint.getTypeface() != null ? textPaint.getTypeface().equals(textPaint2.getTypeface()) : textPaint2.getTypeface() == null) && this.f595b == c0241d.f595b;
        }
        return false;
    }

    public final int hashCode() {
        TextPaint textPaint = this.f594a;
        return AbstractC0294b.m570b(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.f595b, Integer.valueOf(this.f596c), Integer.valueOf(this.f597d));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f594a;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        sb.append(", textLocale=" + textPaint.getTextLocales());
        sb.append(", typeface=" + textPaint.getTypeface());
        sb.append(", variationSettings=" + textPaint.getFontVariationSettings());
        sb.append(", textDir=" + this.f595b);
        sb.append(", breakStrategy=" + this.f596c);
        sb.append(", hyphenationFrequency=" + this.f597d);
        sb.append("}");
        return sb.toString();
    }
}
