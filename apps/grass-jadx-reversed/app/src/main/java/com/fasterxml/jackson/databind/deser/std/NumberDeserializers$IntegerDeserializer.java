package com.fasterxml.jackson.databind.deser.std;

import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p071Y0.InterfaceC0738b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public final class NumberDeserializers$IntegerDeserializer extends NumberDeserializers$PrimitiveOrWrapperDeserializer<Integer> {
    private static final long serialVersionUID = 1;
    static final NumberDeserializers$IntegerDeserializer primitiveInstance = new NumberDeserializers$IntegerDeserializer(Integer.TYPE, 0);
    static final NumberDeserializers$IntegerDeserializer wrapperInstance = new NumberDeserializers$IntegerDeserializer(Integer.class, null);

    public NumberDeserializers$IntegerDeserializer(Class<Integer> cls, Integer num) {
        super(cls, EnumC1664f.f5894j, num, 0);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers$PrimitiveOrWrapperDeserializer, p069X0.AbstractC0722m
    public /* bridge */ /* synthetic */ Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return super.getEmptyValue(abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers$PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public /* bridge */ /* synthetic */ EnumC1736a getNullAccessPattern() {
        return super.getNullAccessPattern();
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return true;
    }

    @Override // p069X0.AbstractC0722m
    public Integer deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return abstractC0545m.mo1171P() ? Integer.valueOf(abstractC0545m.mo1204s()) : this._primitive ? Integer.valueOf(_parseIntPrimitive(abstractC0545m, abstractC0718i)) : _parseInteger(abstractC0545m, abstractC0718i, Integer.class);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Integer deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC0545m.mo1171P() ? Integer.valueOf(abstractC0545m.mo1204s()) : this._primitive ? Integer.valueOf(_parseIntPrimitive(abstractC0545m, abstractC0718i)) : _parseInteger(abstractC0545m, abstractC0718i, Integer.class);
    }
}
