package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: renamed from: androidx.fragment.app.L */
/* JADX INFO: loaded from: classes.dex */
public final class C0926L extends Writer {

    /* JADX INFO: renamed from: f */
    public final StringBuilder f3105f = new StringBuilder(128);

    /* JADX INFO: renamed from: e */
    public final String f3104e = "FragmentManager";

    /* JADX INFO: renamed from: a */
    public final void m2434a() {
        StringBuilder sb = this.f3105f;
        if (sb.length() > 0) {
            Log.d(this.f3104e, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        m2434a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        m2434a();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            char c3 = cArr[i3 + i5];
            if (c3 == '\n') {
                m2434a();
            } else {
                this.f3105f.append(c3);
            }
        }
    }
}
