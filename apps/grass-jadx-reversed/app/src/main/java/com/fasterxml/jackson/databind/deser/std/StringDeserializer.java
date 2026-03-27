package com.fasterxml.jackson.databind.deser.std;

import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p071Y0.InterfaceC0738b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class StringDeserializer extends StdScalarDeserializer<String> {
    public static final StringDeserializer instance = new StringDeserializer();
    private static final long serialVersionUID = 1;

    public StringDeserializer() {
        super((Class<?>) String.class);
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return "";
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5898n;
    }

    @Override // p069X0.AbstractC0722m
    public String deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING) ? abstractC0545m.mo1157B() : abstractC0545m.mo1168M(EnumC0548p.START_ARRAY) ? _deserializeFromArray(abstractC0545m, abstractC0718i) : _parseString(abstractC0545m, abstractC0718i, this);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public String deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return deserialize(abstractC0545m, abstractC0718i);
    }
}
