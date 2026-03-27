package com.fasterxml.jackson.databind.deser.std;

import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p071Y0.InterfaceC0738b;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public final class NumberDeserializers$LongDeserializer extends NumberDeserializers$PrimitiveOrWrapperDeserializer<Long> {
    private static final long serialVersionUID = 1;
    static final NumberDeserializers$LongDeserializer primitiveInstance = new NumberDeserializers$LongDeserializer(Long.TYPE, 0L);
    static final NumberDeserializers$LongDeserializer wrapperInstance = new NumberDeserializers$LongDeserializer(Long.class, null);

    public NumberDeserializers$LongDeserializer(Class<Long> cls, Long l3) {
        super(cls, EnumC1664f.f5894j, l3, 0L);
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
    public Long deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return abstractC0545m.mo1171P() ? Long.valueOf(abstractC0545m.mo1205t()) : this._primitive ? Long.valueOf(_parseLongPrimitive(abstractC0545m, abstractC0718i)) : _parseLong(abstractC0545m, abstractC0718i, Long.class);
    }
}
