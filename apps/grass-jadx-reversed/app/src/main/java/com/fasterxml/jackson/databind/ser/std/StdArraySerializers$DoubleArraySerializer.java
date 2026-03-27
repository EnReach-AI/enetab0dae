package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
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
import p100g1.AbstractC1399h;
import p109j1.C1514v;
import p114l1.C1675q;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class StdArraySerializers$DoubleArraySerializer extends ArraySerializerBase<double[]> {
    private static final AbstractC0721l VALUE_TYPE;

    static {
        C1675q c1675q = C1675q.f5933h;
        Class cls = Double.TYPE;
        c1675q.getClass();
        VALUE_TYPE = C1675q.m3772m(cls);
    }

    public StdArraySerializers$DoubleArraySerializer() {
        super(double[].class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public AbstractC0728s _withResolved(InterfaceC0714e interfaceC0714e, Boolean bool) {
        return new StdArraySerializers$DoubleArraySerializer(this, interfaceC0714e, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(AbstractC1399h abstractC1399h) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        visitArrayFormat(interfaceC1338c, abstractC0721l, EnumC1337b.f4764f);
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
        c1514vCreateSchemaNode.m3559s("items", createSchemaNode("number"));
        return c1514vCreateSchemaNode;
    }

    public StdArraySerializers$DoubleArraySerializer(StdArraySerializers$DoubleArraySerializer stdArraySerializers$DoubleArraySerializer, InterfaceC0714e interfaceC0714e, Boolean bool) {
        super(stdArraySerializers$DoubleArraySerializer, interfaceC0714e, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(double[] dArr) {
        return dArr.length == 1;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, double[] dArr) {
        return dArr.length == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public final void serialize(double[] dArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (dArr.length == 1 && _shouldUnwrapSingle(abstractC0709K)) {
            serializeContents(dArr, abstractC0540h, abstractC0709K);
            return;
        }
        int length = dArr.length;
        abstractC0540h.getClass();
        AbstractC0540h.m1107b(dArr.length, length);
        abstractC0540h.mo1119L(dArr);
        for (double d : dArr) {
            abstractC0540h.mo1147t(d);
        }
        abstractC0540h.mo1142o();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public void serializeContents(double[] dArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        for (double d : dArr) {
            abstractC0540h.mo1147t(d);
        }
    }
}
