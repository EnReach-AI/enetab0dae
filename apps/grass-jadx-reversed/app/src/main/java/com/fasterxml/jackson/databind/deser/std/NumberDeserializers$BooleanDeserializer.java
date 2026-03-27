package com.fasterxml.jackson.databind.deser.std;

import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p071Y0.InterfaceC0738b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public final class NumberDeserializers$BooleanDeserializer extends NumberDeserializers$PrimitiveOrWrapperDeserializer<Boolean> {
    private static final long serialVersionUID = 1;
    static final NumberDeserializers$BooleanDeserializer primitiveInstance = new NumberDeserializers$BooleanDeserializer(Boolean.TYPE, Boolean.FALSE);
    static final NumberDeserializers$BooleanDeserializer wrapperInstance = new NumberDeserializers$BooleanDeserializer(Boolean.class, null);

    public NumberDeserializers$BooleanDeserializer(Class<Boolean> cls, Boolean bool) {
        super(cls, EnumC1664f.f5896l, bool, Boolean.FALSE);
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
    public Boolean deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        return enumC0548pMo1190e == EnumC0548p.VALUE_TRUE ? Boolean.TRUE : enumC0548pMo1190e == EnumC0548p.VALUE_FALSE ? Boolean.FALSE : this._primitive ? Boolean.valueOf(_parseBooleanPrimitive(abstractC0545m, abstractC0718i)) : _parseBoolean(abstractC0545m, abstractC0718i, this._valueClass);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Boolean deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        return enumC0548pMo1190e == EnumC0548p.VALUE_TRUE ? Boolean.TRUE : enumC0548pMo1190e == EnumC0548p.VALUE_FALSE ? Boolean.FALSE : this._primitive ? Boolean.valueOf(_parseBooleanPrimitive(abstractC0545m, abstractC0718i)) : _parseBoolean(abstractC0545m, abstractC0718i, this._valueClass);
    }
}
