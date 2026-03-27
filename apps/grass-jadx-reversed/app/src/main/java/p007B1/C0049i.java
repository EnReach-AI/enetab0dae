package p007B1;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: renamed from: B1.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0049i {

    /* JADX INFO: renamed from: a */
    public CharSequence f177a;

    /* JADX INFO: renamed from: b */
    public final TextPaint f178b;

    /* JADX INFO: renamed from: c */
    public final int f179c;

    /* JADX INFO: renamed from: d */
    public int f180d;

    /* JADX INFO: renamed from: k */
    public boolean f187k;

    /* JADX INFO: renamed from: e */
    public Layout.Alignment f181e = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: f */
    public int f182f = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: g */
    public float f183g = 0.0f;

    /* JADX INFO: renamed from: h */
    public float f184h = 1.0f;

    /* JADX INFO: renamed from: i */
    public int f185i = 1;

    /* JADX INFO: renamed from: j */
    public boolean f186j = true;

    /* JADX INFO: renamed from: l */
    public TextUtils.TruncateAt f188l = null;

    public C0049i(CharSequence charSequence, TextPaint textPaint, int i3) {
        this.f177a = charSequence;
        this.f178b = textPaint;
        this.f179c = i3;
        this.f180d = charSequence.length();
    }

    /* JADX INFO: renamed from: a */
    public final StaticLayout m207a() {
        if (this.f177a == null) {
            this.f177a = "";
        }
        int iMax = Math.max(0, this.f179c);
        CharSequence charSequenceEllipsize = this.f177a;
        int i3 = this.f182f;
        TextPaint textPaint = this.f178b;
        if (i3 == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f188l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f180d);
        this.f180d = iMin;
        if (this.f187k && this.f182f == 1) {
            this.f181e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.f181e);
        builderObtain.setIncludePad(this.f186j);
        builderObtain.setTextDirection(this.f187k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f188l;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f182f);
        float f3 = this.f183g;
        if (f3 != 0.0f || this.f184h != 1.0f) {
            builderObtain.setLineSpacing(f3, this.f184h);
        }
        if (this.f182f > 1) {
            builderObtain.setHyphenationFrequency(this.f185i);
        }
        return builderObtain.build();
    }
}
