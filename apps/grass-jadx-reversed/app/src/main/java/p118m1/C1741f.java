package p118m1;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: m1.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1741f extends InputStream {

    /* JADX INFO: renamed from: e */
    public final ByteBuffer f6099e;

    public C1741f(ByteBuffer byteBuffer) {
        this.f6099e = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f6099e.remaining();
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.f6099e;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) {
        ByteBuffer byteBuffer = this.f6099e;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i4, byteBuffer.remaining());
        byteBuffer.get(bArr, i3, iMin);
        return iMin;
    }
}
