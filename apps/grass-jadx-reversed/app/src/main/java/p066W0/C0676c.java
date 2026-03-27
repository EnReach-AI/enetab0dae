package p066W0;

import java.io.OutputStream;
import java.util.LinkedList;

/* JADX INFO: renamed from: W0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0676c extends OutputStream {

    /* JADX INFO: renamed from: j */
    public static final byte[] f1838j = new byte[0];

    /* JADX INFO: renamed from: e */
    public final C0674a f1839e;

    /* JADX INFO: renamed from: f */
    public final LinkedList f1840f;

    /* JADX INFO: renamed from: g */
    public int f1841g;

    /* JADX INFO: renamed from: h */
    public byte[] f1842h;

    /* JADX INFO: renamed from: i */
    public int f1843i;

    public C0676c(C0674a c0674a) {
        this(c0674a, 500);
    }

    /* JADX INFO: renamed from: a */
    public final void m1634a() {
        int length = this.f1841g + this.f1842h.length;
        if (length < 0) {
            throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
        }
        this.f1841g = length;
        int iMax = Math.max(length >> 1, 1000);
        if (iMax > 131072) {
            iMax = 131072;
        }
        this.f1840f.add(this.f1842h);
        this.f1842h = new byte[iMax];
        this.f1843i = 0;
    }

    /* JADX INFO: renamed from: b */
    public final void m1635b(int i3) {
        if (this.f1843i >= this.f1842h.length) {
            m1634a();
        }
        byte[] bArr = this.f1842h;
        int i4 = this.f1843i;
        this.f1843i = i4 + 1;
        bArr[i4] = (byte) i3;
    }

    /* JADX INFO: renamed from: c */
    public final void m1636c(int i3) {
        int i4 = this.f1843i;
        int i5 = i4 + 2;
        byte[] bArr = this.f1842h;
        if (i5 >= bArr.length) {
            m1635b(i3 >> 16);
            m1635b(i3 >> 8);
            m1635b(i3);
            return;
        }
        int i6 = i4 + 1;
        this.f1843i = i6;
        bArr[i4] = (byte) (i3 >> 16);
        this.f1843i = i5;
        bArr[i6] = (byte) (i3 >> 8);
        this.f1843i = i4 + 3;
        bArr[i5] = (byte) i3;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    /* JADX INFO: renamed from: d */
    public final void m1637d(int i3) {
        int i4 = this.f1843i;
        int i5 = i4 + 1;
        byte[] bArr = this.f1842h;
        if (i5 >= bArr.length) {
            m1635b(i3 >> 8);
            m1635b(i3);
        } else {
            this.f1843i = i5;
            bArr[i4] = (byte) (i3 >> 8);
            this.f1843i = i4 + 2;
            bArr[i5] = (byte) i3;
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m1638e() {
        this.f1841g = 0;
        this.f1843i = 0;
        LinkedList linkedList = this.f1840f;
        if (linkedList.isEmpty()) {
            return;
        }
        linkedList.clear();
    }

    /* JADX INFO: renamed from: f */
    public final byte[] m1639f() {
        int i3 = this.f1841g + this.f1843i;
        if (i3 == 0) {
            return f1838j;
        }
        byte[] bArr = new byte[i3];
        LinkedList<byte[]> linkedList = this.f1840f;
        int i4 = 0;
        for (byte[] bArr2 : linkedList) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        System.arraycopy(this.f1842h, 0, bArr, i4, this.f1843i);
        int i5 = i4 + this.f1843i;
        if (i5 == i3) {
            if (!linkedList.isEmpty()) {
                m1638e();
            }
            return bArr;
        }
        throw new RuntimeException("Internal error: total len assumed to be " + i3 + ", copied " + i5 + " bytes");
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public C0676c(C0674a c0674a, int i3) {
        this.f1840f = new LinkedList();
        this.f1839e = c0674a;
        this.f1842h = c0674a == null ? new byte[i3 > 131072 ? 131072 : i3] : c0674a.m1632a(2);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i3, int i4) {
        while (true) {
            int iMin = Math.min(this.f1842h.length - this.f1843i, i4);
            if (iMin > 0) {
                System.arraycopy(bArr, i3, this.f1842h, this.f1843i, iMin);
                i3 += iMin;
                this.f1843i += iMin;
                i4 -= iMin;
            }
            if (i4 <= 0) {
                return;
            } else {
                m1634a();
            }
        }
    }

    public C0676c(byte[] bArr, int i3) {
        this.f1840f = new LinkedList();
        this.f1839e = null;
        this.f1842h = bArr;
        this.f1843i = i3;
    }

    @Override // java.io.OutputStream
    public final void write(int i3) {
        m1635b(i3);
    }
}
