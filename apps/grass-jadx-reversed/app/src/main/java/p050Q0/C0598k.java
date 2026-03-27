package p050Q0;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import p025H1.C0283l;

/* JADX INFO: renamed from: Q0.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0598k extends Reader {

    /* JADX INFO: renamed from: e */
    public final C0283l f1536e;

    /* JADX INFO: renamed from: f */
    public InputStream f1537f;

    /* JADX INFO: renamed from: g */
    public byte[] f1538g;

    /* JADX INFO: renamed from: h */
    public int f1539h;

    /* JADX INFO: renamed from: i */
    public int f1540i;

    /* JADX INFO: renamed from: j */
    public final boolean f1541j;

    /* JADX INFO: renamed from: k */
    public char f1542k = 0;

    /* JADX INFO: renamed from: l */
    public int f1543l;

    /* JADX INFO: renamed from: m */
    public int f1544m;

    /* JADX INFO: renamed from: n */
    public final boolean f1545n;

    /* JADX INFO: renamed from: o */
    public char[] f1546o;

    public C0598k(C0283l c0283l, InputStream inputStream, byte[] bArr, int i3, int i4, boolean z3) {
        this.f1536e = c0283l;
        this.f1537f = inputStream;
        this.f1538g = bArr;
        this.f1539h = i3;
        this.f1540i = i4;
        this.f1541j = z3;
        this.f1545n = inputStream != null;
    }

    /* JADX INFO: renamed from: a */
    public final void m1368a(int i3) throws CharConversionException {
        int i4 = this.f1544m + i3;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i3 + ", needed 4, at char #" + this.f1543l + ", byte #" + i4 + ")");
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream inputStream = this.f1537f;
        if (inputStream != null) {
            this.f1537f = null;
            byte[] bArr = this.f1538g;
            if (bArr != null) {
                this.f1538g = null;
                C0283l c0283l = this.f1536e;
                if (c0283l != null) {
                    c0283l.m561f(bArr);
                }
            }
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public final int read() {
        if (this.f1546o == null) {
            this.f1546o = new char[1];
        }
        if (read(this.f1546o, 0, 1) < 1) {
            return -1;
        }
        return this.f1546o[0];
    }

    @Override // java.io.Reader
    public final int read(char[] cArr, int i3, int i4) throws IOException {
        int i5;
        int i6;
        byte[] bArr;
        byte[] bArr2;
        int i7;
        int i8;
        byte[] bArr3 = this.f1538g;
        if (bArr3 == null) {
            return -1;
        }
        if (i4 < 1) {
            return i4;
        }
        if (i3 >= 0 && (i5 = i3 + i4) <= cArr.length) {
            char c3 = this.f1542k;
            if (c3 != 0) {
                i6 = i3 + 1;
                cArr[i3] = c3;
                this.f1542k = (char) 0;
            } else {
                int i9 = this.f1540i;
                int i10 = this.f1539h;
                int i11 = i9 - i10;
                if (i11 < 4) {
                    InputStream inputStream = this.f1537f;
                    if (inputStream != null) {
                        this.f1544m = (i9 - i11) + this.f1544m;
                        C0283l c0283l = this.f1536e;
                        boolean z3 = this.f1545n;
                        if (i11 > 0) {
                            if (i10 > 0) {
                                System.arraycopy(bArr3, i10, bArr3, 0, i11);
                                this.f1539h = 0;
                            }
                            this.f1540i = i11;
                        } else {
                            this.f1539h = 0;
                            int i12 = inputStream.read(bArr3);
                            if (i12 < 1) {
                                this.f1540i = 0;
                                if (i12 >= 0) {
                                    throw new IOException("Strange I/O stream, returned 0 bytes on read");
                                }
                                if (z3 && (bArr = this.f1538g) != null) {
                                    this.f1538g = null;
                                    if (c0283l != null) {
                                        c0283l.m561f(bArr);
                                    }
                                }
                            } else {
                                this.f1540i = i12;
                            }
                        }
                        while (true) {
                            int i13 = this.f1540i;
                            if (i13 >= 4) {
                                break;
                            }
                            InputStream inputStream2 = this.f1537f;
                            byte[] bArr4 = this.f1538g;
                            int i14 = inputStream2.read(bArr4, i13, bArr4.length - i13);
                            if (i14 < 1) {
                                if (i14 < 0) {
                                    if (z3 && (bArr2 = this.f1538g) != null) {
                                        this.f1538g = null;
                                        if (c0283l != null) {
                                            c0283l.m561f(bArr2);
                                        }
                                    }
                                    m1368a(this.f1540i);
                                    throw null;
                                }
                                throw new IOException("Strange I/O stream, returned 0 bytes on read");
                            }
                            this.f1540i += i14;
                        }
                    }
                    if (i11 == 0) {
                        return -1;
                    }
                    m1368a(this.f1540i - this.f1539h);
                    throw null;
                }
                i6 = i3;
            }
            int i15 = this.f1540i - 4;
            while (true) {
                if (i6 >= i5) {
                    break;
                }
                int i16 = this.f1539h;
                if (i16 > i15) {
                    break;
                }
                if (this.f1541j) {
                    byte[] bArr5 = this.f1538g;
                    i7 = (bArr5[i16] << 8) | (bArr5[i16 + 1] & 255);
                    i8 = (bArr5[i16 + 3] & 255) | ((bArr5[i16 + 2] & 255) << 8);
                } else {
                    byte[] bArr6 = this.f1538g;
                    int i17 = (bArr6[i16] & 255) | ((bArr6[i16 + 1] & 255) << 8);
                    i7 = (bArr6[i16 + 3] << 8) | (bArr6[i16 + 2] & 255);
                    i8 = i17;
                }
                this.f1539h = i16 + 4;
                if (i7 != 0) {
                    int i18 = 65535 & i7;
                    int i19 = i8 | ((i18 - 1) << 16);
                    if (i18 <= 16) {
                        int i20 = i6 + 1;
                        cArr[i6] = (char) ((i19 >> 10) + 55296);
                        int i21 = (i19 & 1023) | 56320;
                        if (i20 >= i5) {
                            this.f1542k = (char) i19;
                            i6 = i20;
                            break;
                        }
                        i8 = i21;
                        i6 = i20;
                    } else {
                        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i19) + String.format(" (above 0x%08x)", 1114111) + " at char #" + (this.f1543l + (i6 - i3)) + ", byte #" + ((this.f1544m + this.f1539h) - 1) + ")");
                    }
                }
                cArr[i6] = (char) i8;
                i6++;
            }
            int i22 = i6 - i3;
            this.f1543l += i22;
            return i22;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("read(buf,%d,%d), cbuf[%d]", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(cArr.length)));
    }
}
