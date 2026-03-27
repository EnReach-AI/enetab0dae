package com.fasterxml.jackson.databind.deser.std;

import java.util.concurrent.atomic.AtomicBoolean;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p078a1.C0850b;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
public class AtomicBooleanDeserializer extends StdScalarDeserializer<AtomicBoolean> {
    private static final long serialVersionUID = 1;

    public AtomicBooleanDeserializer() {
        super((Class<?>) AtomicBoolean.class);
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return new AtomicBoolean(false);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5896l;
    }

    @Override // p069X0.AbstractC0722m
    public AtomicBoolean deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == EnumC0548p.VALUE_TRUE) {
            return new AtomicBoolean(true);
        }
        if (enumC0548pMo1190e == EnumC0548p.VALUE_FALSE) {
            return new AtomicBoolean(false);
        }
        Boolean bool_parseBoolean = _parseBoolean(abstractC0545m, abstractC0718i, AtomicBoolean.class);
        if (bool_parseBoolean == null) {
            return null;
        }
        return new AtomicBoolean(bool_parseBoolean.booleanValue());
    }
}
