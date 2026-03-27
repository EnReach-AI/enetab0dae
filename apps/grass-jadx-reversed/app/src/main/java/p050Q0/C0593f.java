package p050Q0;

import java.io.IOException;
import java.io.InputStream;
import p025H1.C0283l;

/* JADX INFO: renamed from: Q0.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0593f extends InputStream {

    /* JADX INFO: renamed from: e */
    public final C0283l f1517e;

    /* JADX INFO: renamed from: f */
    public final InputStream f1518f;

    /* JADX INFO: renamed from: g */
    public byte[] f1519g;

    /* JADX INFO: renamed from: h */
    public int f1520h;

    /* JADX INFO: renamed from: i */
    public final int f1521i;

    public C0593f(C0283l c0283l, InputStream inputStream, byte[] bArr, int i3, int i4) {
        this.f1517e = c0283l;
        this.f1518f = inputStream;
        this.f1519g = bArr;
        this.f1520h = i3;
        this.f1521i = i4;
    }

    /* JADX INFO: renamed from: a */
    public final void m1343a() {
        byte[] bArr = this.f1519g;
        if (bArr != null) {
            this.f1519g = null;
            C0283l c0283l = this.f1517e;
            if (c0283l != null) {
                c0283l.m561f(bArr);
            }
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f1519g != null ? this.f1521i - this.f1520h : this.f1518f.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        m1343a();
        this.f1518f.close();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i3) {
        if (this.f1519g == null) {
            this.f1518f.mark(i3);
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f1519g == null && this.f1518f.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f1519g;
        if (bArr == null) {
            return this.f1518f.read();
        }
        int i3 = this.f1520h;
        int i4 = i3 + 1;
        this.f1520h = i4;
        int i5 = bArr[i3] & 255;
        if (i4 >= this.f1521i) {
            m1343a();
        }
        return i5;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        if (this.f1519g == null) {
            this.f1518f.reset();
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        long j3;
        if (this.f1519g != null) {
            int i3 = this.f1520h;
            j3 = this.f1521i - i3;
            if (j3 > j2) {
                this.f1520h = i3 + ((int) j2);
                return j2;
            }
            m1343a();
            j2 -= j3;
        } else {
            j3 = 0;
        }
        return j2 > 0 ? j3 + this.f1518f.skip(j2) : j3;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) {
        byte[] bArr2 = this.f1519g;
        if (bArr2 != null) {
            int i5 = this.f1520h;
            int i6 = this.f1521i;
            int i7 = i6 - i5;
            if (i4 > i7) {
                i4 = i7;
            }
            System.arraycopy(bArr2, i5, bArr, i3, i4);
            int i8 = this.f1520h + i4;
            this.f1520h = i8;
            if (i8 >= i6) {
                m1343a();
            }
            return i4;
        }
        return this.f1518f.read(bArr, i3, i4);
    }
}
