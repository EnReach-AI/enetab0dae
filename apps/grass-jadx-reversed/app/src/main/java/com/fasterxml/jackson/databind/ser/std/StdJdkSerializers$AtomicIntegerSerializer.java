package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;
import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p092e1.InterfaceC1338c;

/* JADX INFO: loaded from: classes.dex */
public class StdJdkSerializers$AtomicIntegerSerializer extends StdScalarSerializer<AtomicInteger> {
    public StdJdkSerializers$AtomicIntegerSerializer() {
        super(AtomicInteger.class, false);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        visitIntFormat(interfaceC1338c, abstractC0721l, EnumC0544l.f1298e);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        return createSchemaNode("integer", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(AtomicInteger atomicInteger, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1149v(atomicInteger.get());
    }
}
