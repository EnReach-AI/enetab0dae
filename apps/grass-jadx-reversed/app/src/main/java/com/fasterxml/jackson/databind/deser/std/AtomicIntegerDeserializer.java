package com.fasterxml.jackson.databind.deser.std;

import java.util.concurrent.atomic.AtomicInteger;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p078a1.C0850b;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
public class AtomicIntegerDeserializer extends StdScalarDeserializer<AtomicInteger> {
    private static final long serialVersionUID = 1;

    public AtomicIntegerDeserializer() {
        super((Class<?>) AtomicInteger.class);
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return new AtomicInteger();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5894j;
    }

    @Override // p069X0.AbstractC0722m
    public AtomicInteger deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (abstractC0545m.mo1171P()) {
            return new AtomicInteger(abstractC0545m.mo1204s());
        }
        Integer num_parseInteger = _parseInteger(abstractC0545m, abstractC0718i, AtomicInteger.class);
        if (num_parseInteger == null) {
            return null;
        }
        return new AtomicInteger(num_parseInteger.intValue());
    }
}
