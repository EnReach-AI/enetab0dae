package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p092e1.InterfaceC1338c;

/* JADX INFO: loaded from: classes.dex */
public class StdJdkSerializers$AtomicBooleanSerializer extends StdScalarSerializer<AtomicBoolean> {
    public StdJdkSerializers$AtomicBooleanSerializer() {
        super(AtomicBoolean.class, false);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        return createSchemaNode("boolean", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(AtomicBoolean atomicBoolean, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1140m(atomicBoolean.get());
    }
}
