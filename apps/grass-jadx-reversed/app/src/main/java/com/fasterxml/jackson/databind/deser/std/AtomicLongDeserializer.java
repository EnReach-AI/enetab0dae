package com.fasterxml.jackson.databind.deser.std;

import java.util.concurrent.atomic.AtomicLong;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p078a1.C0850b;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
public class AtomicLongDeserializer extends StdScalarDeserializer<AtomicLong> {
    private static final long serialVersionUID = 1;

    public AtomicLongDeserializer() {
        super((Class<?>) AtomicLong.class);
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return new AtomicLong();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5894j;
    }

    @Override // p069X0.AbstractC0722m
    public AtomicLong deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (abstractC0545m.mo1171P()) {
            return new AtomicLong(abstractC0545m.mo1205t());
        }
        if (_parseLong(abstractC0545m, abstractC0718i, AtomicLong.class) == null) {
            return null;
        }
        return new AtomicLong(r3.intValue());
    }
}
