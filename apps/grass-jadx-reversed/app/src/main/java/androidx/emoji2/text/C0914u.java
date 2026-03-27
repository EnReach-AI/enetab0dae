package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: renamed from: androidx.emoji2.text.u */
/* JADX INFO: loaded from: classes.dex */
public final class C0914u implements Spannable {

    /* JADX INFO: renamed from: e */
    public boolean f3015e = false;

    /* JADX INFO: renamed from: f */
    public Spannable f3016f;

    public C0914u(Spannable spannable) {
        this.f3016f = spannable;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i3) {
        return this.f3016f.charAt(i3);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f3016f.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f3016f.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f3016f.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f3016f.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f3016f.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i3, int i4, Class cls) {
        return this.f3016f.getSpans(i3, i4, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f3016f.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i3, int i4, Class cls) {
        return this.f3016f.nextSpanTransition(i3, i4, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        Spannable spannable = this.f3016f;
        if (!this.f3015e && (spannable instanceof PrecomputedText)) {
            this.f3016f = new SpannableString(spannable);
        }
        this.f3015e = true;
        this.f3016f.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i3, int i4, int i5) {
        Spannable spannable = this.f3016f;
        if (!this.f3015e && (spannable instanceof PrecomputedText)) {
            this.f3016f = new SpannableString(spannable);
        }
        this.f3015e = true;
        this.f3016f.setSpan(obj, i3, i4, i5);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i3, int i4) {
        return this.f3016f.subSequence(i3, i4);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f3016f.toString();
    }

    public C0914u(CharSequence charSequence) {
        this.f3016f = new SpannableString(charSequence);
    }
}
