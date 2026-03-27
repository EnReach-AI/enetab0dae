package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;
import p039M0.AbstractC0493h0;
import p052R.C0603a;
import p125o0.C1803m;

/* JADX INFO: renamed from: androidx.emoji2.text.t */
/* JADX INFO: loaded from: classes.dex */
public final class C0913t extends ReplacementSpan {

    /* JADX INFO: renamed from: b */
    public final C0906m f3013b;

    /* JADX INFO: renamed from: a */
    public final Paint.FontMetricsInt f3012a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c */
    public float f3014c = 1.0f;

    public C0913t(C0906m c0906m) {
        AbstractC0493h0.m1010c("metadata cannot be null", c0906m);
        this.f3013b = c0906m;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i3, int i4, float f3, int i5, int i6, int i7, Paint paint) {
        C0902i.m2341a().getClass();
        C0906m c0906m = this.f3013b;
        C1803m c1803m = c0906m.f2989b;
        Typeface typeface = (Typeface) c1803m.f6219e;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText((char[]) c1803m.f6221g, c0906m.f2988a * 2, 2, f3, i6, paint);
        paint.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f3012a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        C0906m c0906m = this.f3013b;
        this.f3014c = fAbs / (c0906m.m2350c().m843a(14) != 0 ? ((ByteBuffer) r8.f888d).getShort(r1 + r8.f885a) : (short) 0);
        C0603a c0603aM2350c = c0906m.m2350c();
        int iM843a = c0603aM2350c.m843a(14);
        if (iM843a != 0) {
            ((ByteBuffer) c0603aM2350c.f888d).getShort(iM843a + c0603aM2350c.f885a);
        }
        short s3 = (short) ((c0906m.m2350c().m843a(12) != 0 ? ((ByteBuffer) r5.f888d).getShort(r7 + r5.f885a) : (short) 0) * this.f3014c);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s3;
    }
}
