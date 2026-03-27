package p118m1;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: m1.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1742g extends OutputStream {

    /* JADX INFO: renamed from: e */
    public final ByteBuffer f6100e;

    public C1742g(ByteBuffer byteBuffer) {
        this.f6100e = byteBuffer;
    }

    @Override // java.io.OutputStream
    public final void write(int i3) {
        this.f6100e.put((byte) i3);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i3, int i4) {
        this.f6100e.put(bArr, i3, i4);
    }
}
