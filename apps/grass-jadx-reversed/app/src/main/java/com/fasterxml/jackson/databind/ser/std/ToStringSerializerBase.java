package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
public abstract class ToStringSerializerBase extends StdSerializer<Object> {
    public ToStringSerializerBase(Class<?> cls) {
        super(cls, false);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        visitStringFormat(interfaceC1338c, abstractC0721l);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        return createSchemaNode("string", true);
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, Object obj) {
        return valueToString(obj).isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1125R(valueToString(obj));
    }

    @Override // p069X0.AbstractC0728s
    public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.VALUE_STRING, obj));
        serialize(obj, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }

    public abstract String valueToString(Object obj);
}
