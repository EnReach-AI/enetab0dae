package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p092e1.EnumC1337b;
import p092e1.InterfaceC1338c;
import p109j1.C1514v;
import p114l1.C1675q;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class StdArraySerializers$ShortArraySerializer extends StdArraySerializers$TypedPrimitiveArraySerializer<short[]> {
    private static final AbstractC0721l VALUE_TYPE;

    static {
        C1675q c1675q = C1675q.f5933h;
        Class cls = Short.TYPE;
        c1675q.getClass();
        VALUE_TYPE = C1675q.m3772m(cls);
    }

    public StdArraySerializers$ShortArraySerializer() {
        super(short[].class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public AbstractC0728s _withResolved(InterfaceC0714e interfaceC0714e, Boolean bool) {
        return new StdArraySerializers$ShortArraySerializer(this, interfaceC0714e, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        visitArrayFormat(interfaceC1338c, abstractC0721l, EnumC1337b.f4765g);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0728s getContentSerializer() {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0721l getContentType() {
        return VALUE_TYPE;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        C1514v c1514vCreateSchemaNode = createSchemaNode("array", true);
        c1514vCreateSchemaNode.m3559s("items", createSchemaNode("integer"));
        return c1514vCreateSchemaNode;
    }

    public StdArraySerializers$ShortArraySerializer(StdArraySerializers$ShortArraySerializer stdArraySerializers$ShortArraySerializer, InterfaceC0714e interfaceC0714e, Boolean bool) {
        super(stdArraySerializers$ShortArraySerializer, interfaceC0714e, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(short[] sArr) {
        return sArr.length == 1;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, short[] sArr) {
        return sArr.length == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public final void serialize(short[] sArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (sArr.length == 1 && _shouldUnwrapSingle(abstractC0709K)) {
            serializeContents(sArr, abstractC0540h, abstractC0709K);
            return;
        }
        abstractC0540h.mo1119L(sArr);
        serializeContents(sArr, abstractC0540h, abstractC0709K);
        abstractC0540h.mo1142o();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public void serializeContents(short[] sArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        for (short s3 : sArr) {
            abstractC0540h.mo1149v(s3);
        }
    }
}
