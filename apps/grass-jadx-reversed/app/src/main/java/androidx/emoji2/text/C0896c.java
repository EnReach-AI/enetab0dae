package androidx.emoji2.text;

import android.text.TextPaint;

/* JADX INFO: renamed from: androidx.emoji2.text.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0896c implements InterfaceC0899f {

    /* JADX INFO: renamed from: b */
    public static final ThreadLocal f2964b = new ThreadLocal();

    /* JADX INFO: renamed from: a */
    public final TextPaint f2965a;

    public C0896c() {
        TextPaint textPaint = new TextPaint();
        this.f2965a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
