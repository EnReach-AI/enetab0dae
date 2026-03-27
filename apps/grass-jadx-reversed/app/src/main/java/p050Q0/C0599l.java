package p050Q0;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import p025H1.C0283l;
import p066W0.C0674a;

/* JADX INFO: renamed from: Q0.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0599l extends Writer {

    /* JADX INFO: renamed from: e */
    public final C0283l f1547e;

    /* JADX INFO: renamed from: f */
    public OutputStream f1548f;

    /* JADX INFO: renamed from: g */
    public byte[] f1549g;

    /* JADX INFO: renamed from: h */
    public final int f1550h;

    /* JADX INFO: renamed from: i */
    public int f1551i;

    /* JADX INFO: renamed from: j */
    public int f1552j;

    public C0599l(C0283l c0283l, OutputStream outputStream) {
        this.f1547e = c0283l;
        this.f1548f = outputStream;
        C0283l.m556a((byte[]) c0283l.f762h);
        byte[] bArrM1632a = ((C0674a) c0283l.f759e).m1632a(1);
        c0283l.f762h = bArrM1632a;
        this.f1549g = bArrM1632a;
        this.f1550h = bArrM1632a.length - 4;
        this.f1551i = 0;
    }

    /* JADX INFO: renamed from: b */
    public static void m1369b(int i3) throws IOException {
        throw new IOException(m1370c(i3));
    }

    /* JADX INFO: renamed from: c */
    public static String m1370c(int i3) {
        if (i3 > 1114111) {
            return "Illegal character point (0x" + Integer.toHexString(i3) + ") to output; max is 0x10FFFF as per RFC 4627";
        }
        if (i3 < 55296) {
            return "Illegal character point (0x" + Integer.toHexString(i3) + ") to output";
        }
        if (i3 <= 56319) {
            return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(i3) + ")";
        }
        return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(i3) + ")";
    }

    /* JADX INFO: renamed from: a */
    public final int m1371a(int i3) throws IOException {
        int i4 = this.f1552j;
        this.f1552j = 0;
        if (i3 >= 56320 && i3 <= 57343) {
            return (i3 - 56320) + ((i4 - 55296) << 10) + 65536;
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i4) + ", second 0x" + Integer.toHexString(i3) + "; illegal combination");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(char c3) throws IOException {
        write(c3);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        OutputStream outputStream = this.f1548f;
        if (outputStream != null) {
            int i3 = this.f1551i;
            if (i3 > 0) {
                outputStream.write(this.f1549g, 0, i3);
                this.f1551i = 0;
            }
            OutputStream outputStream2 = this.f1548f;
            this.f1548f = null;
            byte[] bArr = this.f1549g;
            if (bArr != null) {
                this.f1549g = null;
                C0283l c0283l = this.f1547e;
                byte[] bArr2 = (byte[]) c0283l.f762h;
                if (bArr != bArr2 && bArr.length < bArr2.length) {
                    throw new IllegalArgumentException("Trying to release buffer smaller than original");
                }
                c0283l.f762h = null;
                ((C0674a) c0283l.f759e).f1834a.set(1, bArr);
            }
            outputStream2.close();
            int i4 = this.f1552j;
            this.f1552j = 0;
            if (i4 <= 0) {
                return;
            }
            m1369b(i4);
            throw null;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() throws IOException {
        OutputStream outputStream = this.f1548f;
        if (outputStream != null) {
            int i3 = this.f1551i;
            if (i3 > 0) {
                outputStream.write(this.f1549g, 0, i3);
                this.f1551i = 0;
            }
            this.f1548f.flush();
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(char c3) throws IOException {
        write(c3);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0023, code lost:
    
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void write(char[] r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p050Q0.C0599l.write(char[], int, int):void");
    }

    @Override // java.io.Writer
    public final void write(int i3) throws IOException {
        int i4;
        if (this.f1552j > 0) {
            i3 = m1371a(i3);
        } else if (i3 >= 55296 && i3 <= 57343) {
            if (i3 <= 56319) {
                this.f1552j = i3;
                return;
            } else {
                m1369b(i3);
                throw null;
            }
        }
        int i5 = this.f1551i;
        if (i5 >= this.f1550h) {
            this.f1548f.write(this.f1549g, 0, i5);
            this.f1551i = 0;
        }
        if (i3 < 128) {
            byte[] bArr = this.f1549g;
            int i6 = this.f1551i;
            this.f1551i = i6 + 1;
            bArr[i6] = (byte) i3;
            return;
        }
        int i7 = this.f1551i;
        if (i3 < 2048) {
            byte[] bArr2 = this.f1549g;
            int i8 = i7 + 1;
            bArr2[i7] = (byte) ((i3 >> 6) | 192);
            i4 = i7 + 2;
            bArr2[i8] = (byte) ((i3 & 63) | 128);
        } else if (i3 <= 65535) {
            byte[] bArr3 = this.f1549g;
            bArr3[i7] = (byte) ((i3 >> 12) | 224);
            int i9 = i7 + 2;
            bArr3[i7 + 1] = (byte) (((i3 >> 6) & 63) | 128);
            i4 = i7 + 3;
            bArr3[i9] = (byte) ((i3 & 63) | 128);
        } else if (i3 <= 1114111) {
            byte[] bArr4 = this.f1549g;
            bArr4[i7] = (byte) ((i3 >> 18) | 240);
            bArr4[i7 + 1] = (byte) (((i3 >> 12) & 63) | 128);
            int i10 = i7 + 3;
            bArr4[i7 + 2] = (byte) (((i3 >> 6) & 63) | 128);
            i4 = i7 + 4;
            bArr4[i10] = (byte) ((i3 & 63) | 128);
        } else {
            m1369b(i3);
            throw null;
        }
        this.f1551i = i4;
    }

    @Override // java.io.Writer
    public final void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0027, code lost:
    
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void write(java.lang.String r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p050Q0.C0599l.write(java.lang.String, int, int):void");
    }
}
