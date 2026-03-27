package com.fasterxml.jackson.databind.ser.std;

import java.io.IOException;
import java.nio.ByteBuffer;
import p042N0.AbstractC0534b;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p092e1.InterfaceC1338c;
import p118m1.C1741f;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferSerializer extends StdScalarSerializer<ByteBuffer> {
    public ByteBufferSerializer() {
        super(ByteBuffer.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(ByteBuffer byteBuffer, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        if (byteBuffer.hasArray()) {
            int iPosition = byteBuffer.position();
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + iPosition;
            int iLimit = byteBuffer.limit() - iPosition;
            abstractC0540h.getClass();
            abstractC0540h.mo1139l(AbstractC0534b.f1228b, bArrArray, iArrayOffset, iLimit);
            return;
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        if (byteBufferAsReadOnlyBuffer.position() > 0) {
            byteBufferAsReadOnlyBuffer.rewind();
        }
        C1741f c1741f = new C1741f(byteBufferAsReadOnlyBuffer);
        int iRemaining = byteBufferAsReadOnlyBuffer.remaining();
        abstractC0540h.getClass();
        abstractC0540h.mo1138k(AbstractC0534b.f1228b, c1741f, iRemaining);
        c1741f.close();
    }
}
