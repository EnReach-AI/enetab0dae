package com.fasterxml.jackson.databind.deser.std;

import java.io.IOException;
import java.nio.ByteBuffer;
import p042N0.AbstractC0534b;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p114l1.EnumC1664f;
import p118m1.C1742g;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferDeserializer extends StdScalarDeserializer<ByteBuffer> {
    private static final long serialVersionUID = 1;

    public ByteBufferDeserializer() {
        super((Class<?>) ByteBuffer.class);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5899o;
    }

    @Override // p069X0.AbstractC0722m
    public ByteBuffer deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        abstractC0545m.getClass();
        return ByteBuffer.wrap(abstractC0545m.mo1193h(AbstractC0534b.f1228b));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public ByteBuffer deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, ByteBuffer byteBuffer) throws IOException {
        C1742g c1742g = new C1742g(byteBuffer);
        abstractC0545m.mo1180Y(abstractC0718i.f1998g.f2481f.f2429o, c1742g);
        c1742g.close();
        return byteBuffer;
    }
}
