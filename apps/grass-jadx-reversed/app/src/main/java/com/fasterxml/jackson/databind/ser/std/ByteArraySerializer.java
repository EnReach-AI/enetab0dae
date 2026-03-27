package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p071Y0.InterfaceC0738b;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p109j1.C1514v;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class ByteArraySerializer extends StdSerializer<byte[]> {
    private static final long serialVersionUID = 1;

    public ByteArraySerializer() {
        super(byte[].class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        C1514v c1514vCreateSchemaNode = createSchemaNode("array", true);
        c1514vCreateSchemaNode.m3559s("items", createSchemaNode("byte"));
        return c1514vCreateSchemaNode;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, byte[] bArr) {
        return bArr.length == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(byte[] bArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1139l(abstractC0709K.f1966e.f2481f.f2429o, bArr, 0, bArr.length);
    }

    @Override // p069X0.AbstractC0728s
    public void serializeWithType(byte[] bArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.VALUE_EMBEDDED_OBJECT, bArr));
        abstractC0540h.mo1139l(abstractC0709K.f1966e.f2481f.f2429o, bArr, 0, bArr.length);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }
}
