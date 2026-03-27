package p050Q0;

import java.io.Writer;
import p066W0.C0674a;
import p066W0.C0690q;

/* JADX INFO: renamed from: Q0.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0596i extends Writer {

    /* JADX INFO: renamed from: e */
    public final C0690q f1529e;

    public C0596i(C0674a c0674a) {
        this.f1529e = new C0690q(c0674a);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) {
        append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }

    @Override // java.io.Writer
    public final void write(char[] cArr) {
        this.f1529e.m1649b(0, cArr, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i3, int i4) {
        append(charSequence, i3, i4);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i3, int i4) {
        this.f1529e.m1649b(i3, cArr, i4);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(char c3) {
        write(c3);
        return this;
    }

    @Override // java.io.Writer
    public final void write(int i3) {
        C0690q c0690q = this.f1529e;
        char c3 = (char) i3;
        if (c0690q.f1871c >= 0) {
            c0690q.m1664q(16);
        }
        c0690q.f1878j = null;
        c0690q.f1879k = null;
        char[] cArr = c0690q.f1876h;
        if (c0690q.f1877i >= cArr.length) {
            c0690q.m1665r(1);
            c0690q.m1657j();
            cArr = c0690q.f1876h;
        }
        int i4 = c0690q.f1877i;
        c0690q.f1877i = i4 + 1;
        cArr[i4] = c3;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(char c3) {
        write(c3);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        String string = charSequence.toString();
        this.f1529e.m1650c(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i3, int i4) {
        String string = charSequence.subSequence(i3, i4).toString();
        this.f1529e.m1650c(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str) {
        this.f1529e.m1650c(str, 0, str.length());
    }

    @Override // java.io.Writer
    public final void write(String str, int i3, int i4) {
        this.f1529e.m1650c(str, i3, i4);
    }
}
